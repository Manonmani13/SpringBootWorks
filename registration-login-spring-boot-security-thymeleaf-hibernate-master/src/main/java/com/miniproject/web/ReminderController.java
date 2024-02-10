package com.miniproject.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.miniproject.dto.ReminderDto;
import com.miniproject.model.Reminders;
import com.miniproject.service.ReminderService;

@Controller
@RequestMapping("/reminders")
public class ReminderController {
	private ReminderService reminderService;

	private static final Logger logger = LoggerFactory.getLogger(ReminderController.class);
	public List<Reminders> remindersList;

	public ReminderController(ReminderService reminderService) {
		super();
		this.reminderService = reminderService;
	}

	@PostMapping
	public String createReminder(@ModelAttribute("reminder") ReminderDto registrationDto) {
		reminderService.save(registrationDto);
		return "redirect:/reminders?success";
	}

	@GetMapping
	public String showReminder() {
		return "reminders";
	}

	@ModelAttribute("reminder")
	public ReminderDto ReminderDto() {
		return new ReminderDto();
	}

	@GetMapping("/getAll")
	public String getSamplePage(Model model) {
		// Add data to be displayed on the view
		model.addAttribute("list", reminderService.getAllReminders());
		remindersList = new ArrayList<>();
		remindersList = reminderService.getAllReminders();
		System.out.println(reminderService.getAllReminders().toString());
		System.out.println(reminderService.getAllReminders().size());
		System.out.println(reminderService.getAllReminders());
		logger.info("sss");

		return "list";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String updateForm(@PathVariable(value = "id") long id, Model model) {
		Reminders remiders = reminderService.getById(id);
		model.addAttribute("reminders", remiders);
		return "update";
	}

	@GetMapping("/update")
	public String updateForm(@ModelAttribute("reminder") ReminderDto registrationDto) {
		reminderService.save(registrationDto);
		return "redirect:/reminders/getAll";
	}

	@GetMapping("/deleteRemiders/{id}")
	public String deleteThroughId(@PathVariable(value = "id") long id) {
		reminderService.deleteViaId(id);
		return "redirect:/reminders/getAll";

	}
	/*
	 * @PostMapping("/getBirthdayNames") public ResponseEntity<List<String>>
	 * getBirthdayNames(@RequestParam("userInput") int userInput) { if (userInput <
	 * 1) { return ResponseEntity.badRequest().build(); // Invalid user input }
	 * List<Reminders> reminders =
	 * reminderService.getRemindersWithinNextNDays(userInput); List<String>
	 * birthdayNames =
	 * reminders.stream().map(Reminders::getName).collect(Collectors.toList());
	 * if(birthdayNames.isEmpty()) {
	 * birthdayNames.add("No upcoming birthday names found"); } return
	 * ResponseEntity.ok(birthdayNames); }
	 */


	
	/*
	 * @PostMapping("/getBirthdayNames") public ResponseEntity<List<String>>
	 * getBirthdayNames(@RequestParam("userInput") int userInput) { if (userInput <
	 * 1) { return ResponseEntity.badRequest().build(); // Invalid user input }
	 * 
	 * // Call the ReminderService to get reminders within the next day
	 * List<Reminders> reminders =
	 * reminderService.getRemindersWithinNextNDays(userInput);
	 * 
	 * // Create a list to store names with their corresponding birthday dates
	 * List<String> birthdayNames = new ArrayList<>();
	 * 
	 * // Extract names with their birthday dates from the reminders for (Reminders
	 * reminder : reminders) { // Convert the date format from yyyy-mm-dd to
	 * mm-dd-yyyy String formattedDate = formatDate(reminder.getDate()); String
	 * nameWithDate = reminder.getName() + "'s birthday is on " + formattedDate;
	 * birthdayNames.add(nameWithDate); }
	 * 
	 * System.out.println("Hi " + birthdayNames);
	 * 
	 * // Check if birthdayNames is empty if(birthdayNames.isEmpty()) { // If it's
	 * empty, add the message birthdayNames.add("No upcoming birthday found"); }
	 * 
	 * return ResponseEntity.ok(birthdayNames); }
	 */
	
	/*
	 * @PostMapping("/getBirthdayNames") public ResponseEntity<List<String>>
	 * getBirthdayNames(@RequestParam("userInput") int userInput) { if (userInput <
	 * 1) { return ResponseEntity.badRequest().build(); // Invalid user input }
	 * 
	 * // Call the ReminderService to get reminders within the next day
	 * List<Reminders> reminders =
	 * reminderService.getRemindersWithinNextNDays(userInput);
	 * 
	 * // Create a list to store names with their corresponding birthday dates
	 * List<String> birthdayNames = new ArrayList<>();
	 * 
	 * // Extract names with their birthday dates from the reminders for (Reminders
	 * reminder : reminders) { // Convert the date format from yyyy-mm-dd to
	 * mm-dd-yyyy String formattedDate = formatDate(reminder.getDate()); String
	 * nameWithDate = reminder.getName() + "'s birthday is on " + formattedDate;
	 * birthdayNames.add(nameWithDate); }
	 * 
	 * System.out.println("Hi " + birthdayNames);
	 * 
	 * // Check if birthdayNames is empty if(birthdayNames.isEmpty()) { // If it's
	 * empty, add the message birthdayNames.add("No upcoming birthday found"); }
	 * 
	 * // Join the list elements with newline characters String response =
	 * String.join("\n", birthdayNames);
	 * 
	 * // Return ResponseEntity with the list of names and dates separated by
	 * newlines return ResponseEntity.ok(Collections.singletonList(response)); }
	 */
	
	@PostMapping("/getBirthdayNames")
	public ResponseEntity<List<String>> getBirthdayNames(@RequestParam("userInput") int userInput) {
	    if (userInput < 1) {
	        return ResponseEntity.badRequest().build(); // Invalid user input
	    }

	    // Call the ReminderService to get reminders within the next day
	    List<Reminders> reminders = reminderService.getRemindersWithinNextNDays(userInput);

	    // Create a list to store names with their corresponding birthday dates
	    List<String> birthdayNames = new ArrayList<>();

	    // Extract names with their birthday dates from the reminders
	    for (Reminders reminder : reminders) {
	        // Convert the date format from yyyy-mm-dd to mm-dd-yyyy
	        String formattedDate = formatDate(reminder.getDate());
	        String nameWithDate = reminder.getName() + "'s birthday is on " + formattedDate;
	        birthdayNames.add(nameWithDate);
	    }

	    System.out.println("Hi " + birthdayNames);
	    
	    // Check if birthdayNames is empty
	    if(birthdayNames.isEmpty()) {
	        // If it's empty, add the message
	        birthdayNames.add("No upcoming birthday found");
	    }

	    return ResponseEntity.ok(birthdayNames);
	} 
	// Helper method to format the date from yyyy-mm-dd to mm-dd-yyyy
	private String formatDate(String date) {
	    try {
	        SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd");
	        SimpleDateFormat sdfOutput = new SimpleDateFormat("dd-MM-yyyy");
	        Date formattedDate = sdfInput.parse(date);
	        return sdfOutput.format(formattedDate);
	    } catch (ParseException e) {
	        // If parsing fails, return the original date
	        return date;
	    }
	}



	@Scheduled(cron = "0 0 0 * * *")
	public void runBirthdayCheckDaily() {
		String birthdayMessage = reminderService.checkIfBirthdayToday();
		if (birthdayMessage != null) {
			// Log or send the message as needed
			System.out.println(birthdayMessage);
		}
	}
}
