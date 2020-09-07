<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style>
	#line {
	  display: flex;
	}
	
	#borders {
	  margin: 20px;
	}
	
	table, th, td, tr {
	  margin: 10px;
	  padding: 10px;
	  border: 1px solid black;
	  border-collapse: collapse;
	}
	
	#tableHead {
	  font-weight: bold;
	
	}
	#tableBody {
	  font-weight: normal;
	}

</style>


<div id="line">
	
	<%@ include file="Menu.jspf" %>

	<div id="borders">
		<div id="borders">
			<h2>В нашем каталоге присутствуют ${ serviceList.size() } услуги: </h2>
		</div>
		<table>
			<tr id="tableHead">
				<th>Наименование услуги</th><th>Цена (руб.)</th>
			</tr>
		<c:forEach items="${ serviceList }" var="service">
			<tr id="tableBody">
				<td>${ service.getServiceName() }</td>
				<td>${ service.getPrice() }</td>
			</tr>
		</c:forEach>
		</table>
	</div>
</div>