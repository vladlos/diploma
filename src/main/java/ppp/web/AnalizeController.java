package ppp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ppp.domain.Sales;
import ppp.domain.Item;
import ppp.service.ItemsService;
import ppp.service.SalesService;
import ppp.service.StatAnaliz;

import java.util.List;
import java.util.Map;

/**
 * Created by Vlad on 31.05.14.
 */
@Controller

public class AnalizeController {



    @Autowired
    private ItemsService subjectService;
    @Autowired
    private SalesService salesService;
    @Autowired
    private StatAnaliz analiz;

    public static Item activesubject=null;

    @RequestMapping("/analiz")
    public String listAllnames(Map<String, Object> map) {



        List<Item> ls = subjectService.listSubject();
        if (activesubject==null && !ls.isEmpty()){
            activesubject = ls.get(0);

        }
        map.put("subjectList", ls);
        map.put("actives",activesubject);

        List<Sales> salesList = salesService.listSales(activesubject);
        map.put("salesList", salesList);

        List<Double> ema = analiz.calcEMA(salesList);
        map.put("ema",ema);


        return "analize";
    }


    @RequestMapping("/choosetoanaliz/{subjectId}")
    public String deleteContact(@PathVariable("subjectId") Integer subjectId) {

        activesubject = subjectService.getSubjectById(subjectId);

        return "redirect:/analiz";
    }







}
