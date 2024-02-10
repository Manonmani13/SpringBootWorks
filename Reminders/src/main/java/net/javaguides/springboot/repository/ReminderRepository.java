package net.javaguides.springboot.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Reminders;

public interface ReminderRepository extends JpaRepository<Reminders, Long>{

	List<Reminders> findByDate(LocalDate today);
}
