<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<c:import url ="../layout/header2.jsp" ></c:import>



<style>

 a { color:#05f; text-decoration:none; }
 a:hover { text-decoration:underline; }
 
 h1, h2, h3, h4, h5, h6 { margin:0; padding:0; }
 ul, lo, li { margin:0; padding:0; list-style:none; }

 /* ---------- */
 
 div#root { width:900px; margin:0 auto; }
 header#header { }
 nav#nav { }
 section#container { }
  section#content { float:right; width:700px; }
  aside#aside { float:left; width:180px; }
  section#container::after { content:""; display:block; clear:both; } 

 
 /* ---------- */
 

 
 nav#nav div#nav_box { font-size:14px; padding:10px; text-align:right; }
 nav#nav div#nav_box li { display:inline-block; margin:0 10px; }
 nav#nav div#nav_box li a { color:#333; }
 
 section#container { }
 
 aside#aside h3 { font-size:22px; margin-bottom:20px; text-align:center; }
 aside#aside li { font-size:16px; text-align:center; }
 aside#aside li a { color:#000; display:block; padding:10px 0; }
 aside#aside li a:hover { text-decoration:none; background:#eee; }
 
 aside#aside li { position:relative; }
aside#aside li:hover { background:#eee; }   
aside#aside li > ul.low { display:none; position:absolute; top:0; left:180px;  }
aside#aside li:hover > ul.low { display:block; }
aside#aside li:hover > ul.low li a { background:#eee; border:1px solid #eee; }
aside#aside li:hover > ul.low li a:hover { background:#fff;}
aside#aside li > ul.low li { width:180px; }
 

 
</style>

<style>
 section#content ul li { display:inline-block; margin:10px; }
 section#content div.thumb img { width:200px; height:200px; }
 section#content div.goodsName { padding:10px 0; text-align:center; }
 section#content div.goodsName a { color:#000; }
</style>

<div id="wrap-box-top">
	<div><a href="/shop/home"><span class="glyphicon glyphicon-arrow-left"></span>&nbsp;상품 홈</a></div>
	<div id="title-box">장바구니</div>
	<div></div>
</div>
<div id="wrap-box">


<section id="container">
	<div id="container_box">
	
		<section id="content">
			
			<ul>
 			<c:forEach items="${cartList}" var="cartList">
 			<li>
  			<div class="thumb">
   				<img src="<%=request.getContextPath() %>/upload/${cartList.imgStoredName }" 
			 alt="그림을 불러오지못함" width="50%" height="50%"><br>
  			</div> 
  			<div class="gdsInfo">
    			<p>
     				 <span>상품명 : </span>${cartList.gdsName}<br />
				     <span>개당 가격 : </span><fmt:formatNumber pattern="###,###,###" value="${cartList.gdsPrice}" /><br />
				     <span>구입 수량 : </span>${cartList.cartStock}<br />
				     <span>최종 가격 : </span><fmt:formatNumber pattern="###,###,###" value="${cartList.gdsPrice * cartList.cartStock}" />
    			</p>    
   			</div>
 			</li>
 			</c:forEach>
			</ul>
		
		</section>
	
	
	</div>

</section>
</div>

<c:import url ="../layout/footer.jsp" ></c:import>