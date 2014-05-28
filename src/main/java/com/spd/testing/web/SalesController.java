package com.spd.testing.web;

import com.spd.testing.domain.Subject;
import com.spd.testing.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by Vlad on 28.05.14.
 */
@Controller
public class SalesController {
    @Autowired
    private SubjectService subjectService;

    @RequestMapping("/sales")
    public String listAllnames(Map<String, Object> map) {

        map.put("subject", new Subject());
        List<Subject> ls = subjectService.listSubject();
        map.put("subjectList", ls);

        return "sales";
    }

}



