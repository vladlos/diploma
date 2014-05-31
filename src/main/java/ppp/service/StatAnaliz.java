package ppp.service;

import ppp.domain.Sales;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Vlad on 29.05.14.
 */
@Service
public class StatAnaliz {



    @Transactional
    public List<Double> calcEMA (List <Sales> salesList){
        double ema=0, ema2=0;
        int n = salesList.size();
        if(n==0 || n==0){return null;}

        List<Double> reselt = new LinkedList<Double>();

        ema2 = salesList.get(0).getQuantity();
        reselt.add(ema2);
        if(n==1){return reselt;}

        for(int i=1; i<salesList.size();i++){
            ema = (ema2*(n-1) + 2*salesList.get(i).getQuantity())/n+1;
            reselt.add(ema);
            ema2 = ema;

        }


        return reselt;
    }

    public Double NeyroCalculate(List<Sales> list){
        Double r=0d;
        int n = list.size();
        if (n<6){return r;}

        for(int i=3;i<n;i++){
           List<Double> p = new LinkedList<Double>();
            p.add(list.get(i-3).getQuantity());
            p.add(list.get(i-2).getQuantity());
            p.add(list.get(i-1).getQuantity());
            neyrolern(p,list.get(i).getQuantity());
        }
        return r;
    }




    private int neyrolern (List<Double> list, Double res){
        return 1;
    }


}
