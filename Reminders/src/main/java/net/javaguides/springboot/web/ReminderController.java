package net.javaguides.springboot.web;

import java.util.Optional;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springboot.model.Reminders;
import net.javaguides.springboot.service.ReminderService;
import net.javaguides.springboot.web.dto.ReminderDto;

@Controller
@RequestMapping("/reminders")
public class ReminderController {
	private ReminderService reminderService;
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
    @Scheduled(cron = "0 0 0 * * *")
    public void runBirthdayCheckDaily() {
        String birthdayMessage = reminderService.checkIfBirthdayToday();
        if (birthdayMessage != null) {
            // Log or send the message as needed
            System.out.println(birthdayMessage);
        }
    }
}
