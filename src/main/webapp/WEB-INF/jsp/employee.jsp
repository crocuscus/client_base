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
		<c:if test="${ wasEdit }">
			<c:if test="${ isUpdateFailed }">
				<span>Update fail, try again</span>
				<p/>
				<span>${ updateFailReason }</span>
			</c:if>
			<c:if test="${ !isUpdateFailed }">
				<span>Update success!</span>
			</c:if>
		</c:if>
		<c:if test="${ !isEmpty }">
			<form
			>
				<button
					name="edit"
					value="true"
					type="submit"
				>
					Сохранить изменения
				</button>
				<table>
					<tr>
						<td>ID</td>
						<td>
							<input name="id" value="${ employee.getEmployeeId() }" readOnly=true
							/>
						</td>
					</tr>
					
					<tr>
						<td>Имя</td>
						<td>
							<input type="text" name="first_name" value="${ employee.getFirstName() }"/>
						</td>
					</tr>
					<tr>
						<td>Фамилия</td>
						<td>
							<input type="text" name="surname" value="${ employee.getSurname() }"/>
						</td>
					</tr>
					<tr>
						<td>Отчество</td>
						<td>
							<input type="text" name="second_name" value="${ employee.getSecondName() }"/>
						</td>
					</tr>
					<tr>
						<td>Номер паспорта</td>
						<td>
							<input type="text" name="passport" value="${ employee.getPassport() }"/>
						</td>
					</tr>
					
					<tr>
						<td>Дата валидности</td>
						<td>
							<input type="text" name="passport_date" value="${ employee.getPassportDate() }"/>
						</td>
					</tr>
					
					<tr>
						<td>Откуда</td>
						<td>
							<input type="text" name="passport_from_whom" value="${ employee.getPassportFromWhom() }"/>
						</td>
					</tr>
				</table>
			</form>
		</c:if>
	</div>
</div>
