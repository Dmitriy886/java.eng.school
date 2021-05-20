package ru.mirea.school.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.mirea.school.models.TeachingProgram;
import ru.mirea.school.models.User;
import ru.mirea.school.repo.TeachingProgramRepository;
import ru.mirea.school.repo.UserRepository;

import java.security.Principal;
import java.util.Set;

@Controller
public class MainController {

    @Autowired
    private TeachingProgramRepository teachingProgramRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String home(Model model, Principal principal) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth.getAuthorities().iterator().next().toString().equals("ROLE_ADMIN")) {
            Iterable<TeachingProgram> teachingPrograms = teachingProgramRepository.findAll();
            Iterable<User> teachingUsers = userRepository.findAll();
            model.addAttribute("title", "School - Admin Dashboard");
            model.addAttribute("teachingPrograms", teachingPrograms);
            model.addAttribute("teachingUsers", teachingUsers);
            model.addAttribute("user", userRepository.getUserByUsername(principal.getName()));
            return "dashboard";
        }

        Iterable<TeachingProgram> teachingPrograms = teachingProgramRepository.findAll();
        model.addAttribute("title", "Fitness - Dashboard");
        model.addAttribute("teachingPrograms", teachingPrograms);
        model.addAttribute("user", userRepository.getUserByUsername(principal.getName()));
        return "index";
    }

    @GetMapping("/auth")
    public String auth(Model model) {
        model.addAttribute("title", "School - Authorization");
        model.addAttribute("user", new User());
        return "authorization";
    }

    @GetMapping("/payment")
    public String payment(Model model, Principal principal) {
        model.addAttribute("title", "School - Subscription Payment");
        model.addAttribute("user", userRepository.getUserByUsername(principal.getName()));
        model.addAttribute("dateStart", userRepository.getUserByUsername(principal.getName()).getSubscriptionEnd());
        return "payment";
    }

    @PostMapping("/process_payment")
    public String processPayment(User user, Principal principal) {
        User currentUser = userRepository.getUserByUsername(principal.getName());
        currentUser.setSubscriptionEnd(user.getSubscriptionEnd());
        currentUser.setPrice(user.getPrice());
        int days = Integer.parseInt(currentUser.getDays()) + Integer.parseInt(user.getDays());
        currentUser.setDays(Integer.toString(days));
        userRepository.save(currentUser);
        return "redirect:/";
    }

    @PostMapping("/edit_user")
    public String editUser(User user) {
        if (user.getPassword().length() != 60) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
        }
        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/edit_program/{id}")
    public String editProgram(@PathVariable String id, Model model) {
        if (id.equals("new")) {
            model.addAttribute("title", "Fitness - New teaching Program");
            model.addAttribute("teachingProgram", new TeachingProgram());
            model.addAttribute("endpoint", "/new_program");
        }
        else {
            TeachingProgram teachingProgram = teachingProgramRepository.getTeachingProgramById(Long.parseLong(id));
            model.addAttribute("title", "School - Edit Teaching Program");
            model.addAttribute("teachingProgram", teachingProgram);
            model.addAttribute("endpoint", "/edit_program");
        }
        return "edit_program";
    }

    @PostMapping("/new_program/{id}")
    public String processNewProgram(TeachingProgram teachingProgram) {
        teachingProgramRepository.save(teachingProgram);
        return "redirect:/";
    }

    @PostMapping("/edit_program/{id}")
    public String processProgram(@PathVariable String id, TeachingProgram teachingProgram) {
        TeachingProgram prev = teachingProgramRepository.getTeachingProgramById(Long.parseLong(id));
        teachingProgram.setId(prev.getId());
        teachingProgramRepository.save(teachingProgram);
        return "redirect:/";
    }

    @PostMapping("/subscription_add/{id}")
    public String subscriptionAdd(@PathVariable String id, Principal principal) {
        User currentUser = userRepository.getUserByUsername(principal.getName());
        Set<TeachingProgram> teachingPrograms = currentUser.getTeachingPrograms();
        TeachingProgram teachingProgram = teachingProgramRepository.getTeachingProgramById(Long.parseLong(id));
        teachingPrograms.add(teachingProgram);
        userRepository.save(currentUser);
        return "redirect:/";
    }

    @PostMapping("/subscription_remove/{id}")
    public String subscriptionRemove(@PathVariable String id, Principal principal) {
        User currentUser = userRepository.getUserByUsername(principal.getName());
        Set<TeachingProgram> teachingPrograms = currentUser.getTeachingPrograms();
        TeachingProgram teachingProgram = teachingProgramRepository.getTeachingProgramById(Long.parseLong(id));
        teachingPrograms.remove(teachingProgram);
        userRepository.save(currentUser);
        return "redirect:/";
    }

    @PostMapping("/register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);

        return "redirect:/edit";
    }

    @GetMapping("/edit")
    public String edit(Model model, Principal principal) {
        model.addAttribute("title", "School - Edit");
        model.addAttribute("user", userRepository.getUserByUsername(principal.getName()));
        return "edit";
    }

    @PostMapping("/edit_profile")
    public String editData(User user, Principal principal) {
        User prev = userRepository.getUserByUsername(principal.getName());

        prev.setAvatarUrl(user.getAvatarUrl());
        prev.setFirstName(user.getFirstName());
        prev.setSecondName(user.getSecondName());
        prev.setVisits(user.getVisits());
        prev.setHours(user.getHours());

        userRepository.save(prev);
        return "redirect:/";
    }
}
