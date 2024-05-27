package com.fidan.springcoredemo.rest;

import com.fidan.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //define a private field for the dependency

    private Coach myCoach;

    private Coach anotherCoach;

    @Autowired
    public DemoController(@Qualifier("cricketCoach")Coach coach,
                          @Qualifier("cricketCoach") Coach anotherCoach) {

        System.out.println("In Connstructor "+ getClass().getSimpleName());
        this.myCoach = coach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkOut(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String chek(){
        return "Comparing beans: myCoach == anotherCoach: " + (myCoach == anotherCoach);
    }
}
