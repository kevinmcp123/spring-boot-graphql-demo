package com.example.springbootgraphqldemo;

import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootGraphqlDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootGraphqlDemoApplication.class, args);
        final FoodService foodService = context.getBean(FoodService.class);

        Stream.of("Pizza", "Spam", "Eggs", "Avocado").forEach(name -> {
            Food food = new Food();
            food.setName(name);
            foodService.saveFood(food);
        });

        foodService.getFoods().forEach(System.out::println);
    }

}
