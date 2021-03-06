package com.mmpharmacy.mmpharmacy.controller;


import com.mmpharmacy.mmpharmacy.entity.Category;
import com.mmpharmacy.mmpharmacy.repo.RepoCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ControllerCategories {

    @Autowired
    private RepoCategory repoCategory;


    @RequestMapping("/categories")
    public String openAdminPage(Model md) {
        List<Category> category = repoCategory.findAll();
        for (Category cat: category){
            md.addAttribute("category", category);
        }
        return "admin/categories.html";
    }

//    @GetMapping("/deleteCategory")
//    public String deleteTicketByViewGuid(@RequestParam("id") String category_id) {
//        Category category = repoCategory.findTicketsByviewGuid(category_id);
//        category.setIsActive(0);
//        repoCategory.save(ticket);
//        return "redirect:/tickets";
//    }
//    public String getAll(){
//
//        return
//    }
    //todo: getAllTables, edit, delete as update

}
