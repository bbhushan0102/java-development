package org.studyeasy.car;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.studyeasy.interfaces.Car;

//@Component ("volvo")
public class Volvo implements Car {

//    Engine engine = new Engine();
    // instead of creating an object we can autowired so that we can use fully Spring obejct invasion
    // dont create Object mannualy leave it  on Spring
    // By default autowire is default but we can make it false if needed
//    @Autowired (required = false)
   @Autowired
    Engine engine;
   // We cant create constructor in the class but we can create here e.g
//    public Volvo(Engine engine) {
//        engine.type="V7";
//        this.engine = engine;
//    }

    @Override
    public void specs() {
        System.out.println("Hatchback xc-60 2.0D with engine" + " " + engine.type);
    }
}
