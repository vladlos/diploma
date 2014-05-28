package com.spd.testing.web;

import com.spd.testing.domain.Subject;
import com.spd.testing.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * Created by Vlad on 04.03.14.
 */
@Controller
public class HomeController {

    @Autowired
    private SubjectService subjectService;



    @RequestMapping("/index")
    public String listAll(Map <String, Object> map) {

        map.put("subject", new Subject());
        List<Subject> ls = subjectService.listSubject();
        map.put("subjectList", ls);

        return "admin";
    }



    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("subject") Subject subject,
                             BindingResult result) {

        subjectService.addSubject(subject);

        return "redirect:/index";
    }



    @RequestMapping("/delete/{subjectId}")
    public String deleteContact(@PathVariable("subjectId") Integer subjectId) {

        subjectService.removeSubject(subjectId);

        return "redirect:/index";
    }

}