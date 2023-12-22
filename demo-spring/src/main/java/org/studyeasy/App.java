package org.studyeasy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import org.studyeasy.car.Dacia;
import org.studyeasy.car.Volvo;
import org.studyeasy.interfaces.Car;

public class App {
    public static void main (String [] args) {
//      Car dacia = new Dacia();
//      dacia.specs();
//      Car volvo = new Volvo();
//      volvo.specs();

        //Spring-java -inversion of control
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Car myCar = context.getBean("volvo", Car.class);
        Car car =context.getBean("dacia", Car.class);
        myCar.specs();
        car.specs();
        context.close();



    }
}
