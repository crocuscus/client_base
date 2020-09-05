package com.clientbase.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Repository;

import com.clientbase.model.Employee;
import com.clientbase.model.EmployeeStatus;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query(value = "select * from employee where fullname @@ :name_part", nativeQuery = true)
	public List<Employee> findByFullname(String name_part);
	
	public default Pair<Optional<Employee>, String> addOrUpdateEmployee(Integer id,	EmployeeStatus status, Map<String, String> fields_dict) {

		String[] required_fields = {"first_name", "surname", "passport", "passport_date", "passport_from_whom"};
		for (String field : required_fields) {
			String value = fields_dict.getOrDefault(field, "");
			if (value.isBlank())
				return Pair.of(Optional.empty(), "addOrUpdateEmployee: empty " + field);
		}
		
		Employee emp = new Employee();
		emp.setAddress(fields_dict.get("address"));
		emp.setEducation(fields_dict.get("education"));
		emp.setEmail(fields_dict.get("email"));
		emp.setEmployeeStatus(status);
		emp.setFirstName(fields_dict.get("first_name"));
		emp.setPassport(fields_dict.get("passport"));
		SimpleDateFormat formatter = new SimpleDateFormat("dd.mm.yyyy");
		String passport_date = fields_dict.get("passport_date");
		if (passport_date != null) {
			try {
				emp.setPassportDate(formatter.parse(passport_date));
			} catch (ParseException e) {
				return Pair.of(Optional.empty(), "addOrUpdateEmployee: incorrect date format");
			}
		}
		emp.setPassportFromWhom(fields_dict.get("passport_from_whom"));
		emp.setPhone(fields_dict.get("phone"));
		emp.setPost(fields_dict.get("post"));
		emp.setSecondName(fields_dict.get("second_name"));
		emp.setSurname(fields_dict.get("surname"));
		if (id != null) {
			emp.setEmployeeId(id);
		}
		emp = saveAndFlush(emp);
		return Pair.of(Optional.of(emp), "ok");
	}
	
	public default void removePersonalData(Integer id) {
		if (id != null && getOne(id) != null)
			addOrUpdateEmployee(id, null, Map.of(
			  "first_name", "Сотрудник",
			  "surname", "Удаленный",
			  "passport", "deleted" + id.toString(),
			  "passport_date", "01.01.2000",
			  "passport_from_whom", "deleted"
			));
	}
}
