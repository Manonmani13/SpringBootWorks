package com.miniproject.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.model.Reminders;

public interface ReminderRepository extends JpaRepository<Reminders, Long>{

	List<Reminders> findByDate(LocalDate today);
	 List<Reminders> findByDateBetween(String startDate, String endDate);


}
