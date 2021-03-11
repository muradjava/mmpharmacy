package com.mmpharmacy.mmpharmacy.controller;


import com.mmpharmacy.mmpharmacy.entity.Supplier;
import com.mmpharmacy.mmpharmacy.entity.User;
import com.mmpharmacy.mmpharmacy.repo.RepoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ControllerUsers {

    @Autowired
    private RepoUser repoUser;

    @RequestMapping("/users")
    public String findAllByIsActive(Model md) {
        List<User> users = repoUser.findAllByIsActive("1");
        for (User user : users) {
            md.addAttribute("user", users);
        }
        return "admin/users.html";
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public ResponseEntity deleteUserById(@RequestParam(value = "id") int id) {
//    public ResponseEntity deleteUserById(HttpServletRequest request) {
//
//        int id = Integer.parseInt(request.getParameter("id"));

        User user = repoUser.getOne(id);
        user.setIsActive("0");
        repoUser.save(user);

        return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }

    @RequestMapping("/updateUser")
    public String updateUser(@RequestParam(value = "id") int id, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "surname", required = false) String surname, @RequestParam(value = "email", required = false) String email, @RequestParam(value = "phone_number", required = false) String phone_number) {
        User user = repoUser.getOne(id);
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPhone_number(phone_number);
        System.out.println("Setted");
        repoUser.save(user);
        return "redirect:/admin/users";
    }

    @RequestMapping("/addUser")
    public String addUser(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "surname", required = false) String surname, @RequestParam(value = "email", required = false) String email, @RequestParam(value = "phone_number", required = false) String phone_number) {
        User user = new User(name, surname, phone_number, email, "1");
        repoUser.save(user);
        return "redirect:/admin/suppliers";
    }
}
