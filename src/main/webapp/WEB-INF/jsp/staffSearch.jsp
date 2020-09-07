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
	
	#small-borders {
	  margin: 10px;
	}
	
	#margin-bottom {
	  margin-bottom: 10px;'
	}

</style>


<div id="line">
	
	<%@ include file="Menu.jspf" %>

	<div id="borders">
		<div id="borders">
			<h2>Поиск сотрудников: </h2>
		</div>
		<div>
			<span id="margin-bottom">Ввидите ФИО (или его часть) и нажмите 'Поиск'</span>
			<c:if test="${ isSearchEmpty }">
				<span>Введите непустую строку для поиска</span> 
			</c:if>
			<div>
				<form>
					<input
						name="searchString"
						type="text" 
						value="${ searchString }" 
						placeholder="Введите имя..."
					/>
					<button type="submit">
						Поиск
					</button>
				</form>
			</div>
		</div>
		<c:if test="${ !isSearchEmpty }">
			<div>
				<span>Было найдено ${ empList.size() } сотрудников:</span>
				<c:forEach items="${ empList }" var="employee">
					<div id="margin-bottom">
						<a href="/employee?id=${ employee.getEmployeeId() }">
							${ employee.getFirstName() } ${ employee.getSurname() }
						</a>
						<p/>
					</div>
				</c:forEach>
			</div> 
		</c:if>
	</div>
</div>

<script>

</script>