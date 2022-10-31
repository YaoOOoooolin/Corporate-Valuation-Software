package com.example;

import com.example.InputSheet.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BasicData basicData = (BasicData) ctx.getBean("basicData");
        BasicInformation basicInformation = (BasicInformation) ctx.getBean("basicInformation");
        DefaultAssumptions defaultAssumptions = (DefaultAssumptions) ctx.getBean("defaultAssumptions");
        Drivers drivers = (Drivers) ctx.getBean("drivers");
        MarketNumbers marketNumbers = (MarketNumbers) ctx.getBean("marketNumbers");
        OtherInputs otherInputs = (OtherInputs) ctx.getBean("otherInputs");


        otherInputs.setNumber_of_options_outstanding_A34(12);
        System.out.println(otherInputs.getNumber_of_options_outstanding_A34());
        basicData.setDo_you_have_RD_expenses_to_capitalize_A13(true);
        System.out.println(basicData.isDo_you_have_RD_expenses_to_capitalize_A13());
            


    }

}
