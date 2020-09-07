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
	
	tr {
	  margin-bottom: 10px;'
	}
	
	td {
	  margin-right: 10px;'
	}

</style>


<div id="line">
	
	<%@ include file="Menu.jspf" %>

	<div id="borders">
		<div id="borders">
			<h2>Информация о сотруднике:</h2>
		</div>
		<c:if test="${ isEmpty }">
			Нет сотрудника с таким номером :(
			<p/>
			Поик сотрудников <a href="/staff">по ссылке</a>
		</c:if>
		<c:if test="${ !isEmpty }">
			<c:if test="${ !isEditMode }">
				<form>
					<button
						type="submit"
						name="isEditMode"
						value="true"
						
						name="id"
						value="${ employee.getEmployeeId() }"
					>
						Редактировать
					</button>
				</form>
				<table>
					<tr>
						<td>Имя</td><td>${ employee.getFirstName() }</td>
					</tr>
					<tr>
						<td>Фамилия</td><td>${ employee.getSurname() }</td>
					</tr>
					<tr>
						<td>Отчество</td><td>${ employee.getSecondName() }</td>
					</tr>
				</table>
			</c:if>
			<c:if test="${ isEditMode }">
				<form>
					<button
						type="submit"
						name="edit"
						value="true"
					>
						Сохранить
					</button>
					<table>
						<tr>
							<td>Имя</td>
							<td>
								<input 
									type="text"
									name="FirstName"
									value="${ employee.getFirstName() }"
								/>
							</td>
						</tr>
						<tr>
							<td>Фамилия</td><td>${ employee.getSurname() }</td>
						</tr>
						<tr>
							<td>Отчество</td><td>${ employee.getSecondName() }</td>
						</tr>
					</table>
				</form>
			</c:if>
		</c:if>

	</div>
</div>
