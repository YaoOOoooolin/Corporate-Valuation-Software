package com.example;

import com.example.InputSheet.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class APP {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BasicData basicData = (BasicData) ctx.getBean("basicData");
        BasicInformation basicInformation = (BasicInformation) ctx.getBean("basicInformation");
        DefaultAssumptions defaultAssumptions = (DefaultAssumptions) ctx.getBean("defaultAssumptions");
        Drivers drivers = (Drivers) ctx.getBean("drivers");
        MarketNumbers marketNumbers = (MarketNumbers) ctx.getBean("marketNumbers");
        OtherInputs otherInputs = (OtherInputs) ctx.getBean("otherInputs");

    }
}
