package web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.google.gson.Gson;

import web.dto.ChatDto;
import web.dto.MyPlant;
import web.service.face.ChatService;
import web.service.face.MemberService;
import web.service.face.MyPlantService;

@Controller
public class StompChatController {
	
	private static final Logger logger = LoggerFactory.getLogger(StompChatController.class);
	
	@Autowired SimpMessagingTemplate template;
	@Autowired ChatService chatService;
	@Autowired MemberService memberService;
	@Autowired MyPlantService myPlantService;
	@Autowired WaterPerService wpService;
	// StompWebSocketConfig 에서 설정한 prifix가 경로에 병합됨.
	
	@MessageMapping(value = "/chat/enter")
	public void enter(ChatDto chatDto) {
		chatDto.setIsStart(1); //채팅시작
		chatService.saveMsg(chatDto);
		logger.info("chatDto {}",chatDto.toString());
		template.convertAndSend("/sub/chat/room" + chatDto.getRoomId(), chatDto);
	}
	
	@MessageMapping(value = "/chat/message")
	public void message(ChatDto chatDto) {
		template.convertAndSend("/sub/chat/room" + chatDto.getRoomId(), chatDto);
		chatService.saveMsg(chatDto);
		logger.info("chatLog {}",chatDto.toString());
	}
	
	@MessageMapping(value = "/chat/exit")
	public void exit(ChatDto chatDto) {
		template.convertAndSend("/sub/chat/room" + chatDto.getRoomId(), chatDto);
		chatDto.setIsEnd(1); // 채팅종료
		chatService.saveMsg(chatDto);
		logger.info("chatLog {}",chatDto.toString());
		
		
	}
	
//	-------일대일채팅--------
	
	@MessageMapping(value = "/chat/enter11")
	public void enter11(ChatDto chatDto) {
		chatDto.setIsStart(1); 
		chatService.saveMsg(chatDto);
	//	chatService.saveMsg(chatDto);
		logger.info("chatDto {}",chatDto.toString());
		
		//채팅방의 주소는 각자의 아이디로 한다. 
		template.convertAndSend("/sub/chat/room11" + chatDto.getUserid(), chatDto);
	}
	
	@MessageMapping(value = "/chat/message11")
	public void message11(ChatDto chatDto) {
		chatService.saveMsg(chatDto);
		template.convertAndSend("/sub/chat/room11" + chatDto.getRoomId(), chatDto);
		logger.info("chatLog {}",chatDto.toString());
	}
	
	@MessageMapping(value = "/chat/exit11")
	public void exit11(ChatDto chatDto) {
		template.convertAndSend("/sub/chat/room11" + chatDto.getRoomId(), chatDto);
		chatDto.setIsEnd(1); // 채팅종료
		chatService.saveMsg(chatDto);
		logger.info("chatLog {}",chatDto.toString());
		
		
	}
	
//	---------------알람 보내기 --------------
	
	@GetMapping(value = "/notice")
//	@MessageMapping
	public String messageAlart(String username, HttpSession session) throws IOException {
		
		web.dto.Member member = new web.dto.Member();
		member.setId(username);
		int memberNo = memberService.getMemberNo(member);
		
		List<MyPlant> forAlarmList = wpService.isWaterToday(memberNo);
		Gson gson = new Gson();
		
		if(forAlarmList.size()!=0) {
			template.convertAndSend("/sub/notice"+username, gson.toJson(forAlarmList));
		}else {
			String[] str = {"noPlantsWantWater","아직 물이 부족하지 않아요."};
			template.convertAndSend("/sub/notice"+username, gson.toJson(str));
		}
		
	
		//테스트용 
//		username = (String) session.getAttribute("id");
		
//		String[] str = {"물을 줄 시간이에요","상품이 출발했어요","좋은 하루 되세요"}; // 추후 물주기및 구매 업데이트반영
		
		
		logger.info("/notice [POST] {} ",username);
//		PrintWriter out = null  ;
//		out.write("{\"result\": true}");
		
		return "chat/empty";
		
	}
	
	
}
