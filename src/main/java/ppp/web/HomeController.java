package ppp.web;

import ppp.domain.Item;
import ppp.service.ItemsService;
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
    private ItemsService subjectService;



    @RequestMapping("/index")
    public String listAll(Map <String, Object> map) {

        map.put("item", new Item());
        List<Item> ls = subjectService.listSubject();
        map.put("subjectList", ls);

        return "items";
    }



    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("subject") Item item,
                             BindingResult result) {

        subjectService.addSubject(item);

        return "redirect:/index";
    }



    @RequestMapping("/delete/{subjectId}")
    public String deleteContact(@PathVariable("subjectId") Integer subjectId) {

        subjectService.removeSubject(subjectId);
        SalesController.activesubject=null;
        return "redirect:/index";
    }

}