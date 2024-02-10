package com.miniproject.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.dto.ReminderDto;
import com.miniproject.model.Reminders;
import com.miniproject.repository.ReminderRepository;

@Service
public class ReminderService {
	@Autowired
	private ReminderRepository reminderRepo;

	public Reminders save(ReminderDto reminderDto) {
		Reminders reminder = new Reminders();
		reminder.setName(reminderDto.getName());
		reminder.setMessage(reminderDto.getMessage());
		reminder.setDate(reminderDto.getDate());
		reminder.setUserId(reminderDto.getUserId());
		return reminderRepo.save(reminder);
	}

	public List<Reminders> getAllReminders() {
		return reminderRepo.findAll();
	}

	/*
	 * public Reminders getById(Long id) { Optional<Reminders> optional =
	 * reminderRepo.findById(id); Reminders employee = null; if
	 * (optional.isPresent()) reminderRepo.deleteById(id); else throw new
	 * RuntimeException( "Remider not found for id : " + id); return employee; }
	 */

	public Reminders getById(Long id) {
		Optional<Reminders> optional = reminderRepo.findById(id);
		 if(optional.isPresent()) reminderRepo.deleteById(id);
		return optional.orElseThrow(() -> new RuntimeException("Reminder not found for id: " + id));
	}

	public void deleteViaId(long id) {
		reminderRepo.deleteById(id);
	}

	public String checkIfBirthdayToday() {
		LocalDate today = LocalDate.now();
		List<Reminders> usersWithBirthdayToday = reminderRepo.findByDate(today);

		if (!usersWithBirthdayToday.isEmpty()) {
			// Construct and return a message indicating the birthdays
			StringBuilder message = new StringBuilder("Today is the birthday of: ");
			for (Reminders user : usersWithBirthdayToday) {
				message.append(user.getName()).append(", ");
			}
			return message.toString();
		} else {
			return null; // No birthdays today
		}
	}

	// Sample data of birthday names mapped to dates (you can replace this with your
	// actual data source)
	private final List<ReminderDto> birthdayData = new ArrayList<>();

	// This method retrieves birthday names for a given date
	public List<String> getBirthdayNamesForDate(int daysBeforeBirthday) {
		// Get today's date
		LocalDate today = LocalDate.now();

		// Calculate the target date (birthday) by subtracting daysBeforeBirthday from
		// today
		LocalDate targetDate = today.minusDays(daysBeforeBirthday);

		// Format the target date as "dd MMM" (e.g., "06 Feb")
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM");
		String formattedDate = targetDate.format(formatter);

		// Retrieve birthday names for the determined date
		List<String> birthdayNames = new ArrayList<>();
		for (ReminderDto reminder : birthdayData) {
			if (reminder.getDate().equals(formattedDate)) {
				birthdayNames.add(reminder.getName());
			}
		}
		return birthdayNames;
	}

	private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public List<Reminders> getRemindersWithinNextNDays(int n) {
		LocalDate today = LocalDate.now();
		LocalDate nextDay = today.plusDays(n);

		// Format LocalDate objects to String
		String startDateString = today.format(dateFormatter);
		String endDateString = nextDay.format(dateFormatter);

		// Fetch reminders whose date falls within the next n days
		return reminderRepo.findByDateBetween(startDateString, endDateString);
	}

	public ReminderRepository getReminderRepo() {
		return reminderRepo;
	}

	public void setReminderRepo(ReminderRepository reminderRepo) {
		this.reminderRepo = reminderRepo;
	}

	@Override
	public String toString() {
		return "ReminderService [reminderRepo=" + reminderRepo + "]";
	}

}
