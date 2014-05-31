package ppp.web;

import ppp.domain.Item;
import ppp.domain.Sales;
import ppp.service.ItemsService;
import ppp.service.SalesService;
import ppp.service.StatAnaliz;
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
 * Created by Vlad on 28.05.14.
 */
@Controller
public class SalesController {
    @Autowired
    private ItemsService subjectService;
    @Autowired
    private SalesService salesService;
    @Autowired
    private StatAnaliz analiz;

    public static Item activesubject=null;

    @RequestMapping("/sales")
    public String listAllnames(Map<String, Object> map) {

        map.put("sale", new Sales());

        List<Item> ls = subjectService.listSubject();
        if (activesubject==null && !ls.isEmpty()){
            activesubject = ls.get(0);

        }
        map.put("actives",activesubject);

        List<Sales> salesList = salesService.listSales(activesubject);
        map.put("salesList", salesList);

        map.put("subjectList", ls);




        return "sales";
    }

    @RequestMapping(value = "/addsale", method = RequestMethod.POST)
    public String addSale(@ModelAttribute("newSale") Sales sale, BindingResult result) {
        sale.setItem(activesubject);
        salesService.addSale(sale);
        return "redirect:/sales";
    }

    @RequestMapping("/choose/{subjectId}")
    public String deleteContact(@PathVariable("subjectId") Integer subjectId) {

        activesubject = subjectService.getSubjectById(subjectId);

        return "redirect:/sales";
    }

        @RequestMapping("/deletes/{saleId}")
    public String deleteSale(@PathVariable("saleId") Integer saleId) {

        salesService.removeSale(saleId);

        return "redirect:/sales";
    }




}



