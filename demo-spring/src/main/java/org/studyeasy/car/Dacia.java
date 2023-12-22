package org.studyeasy.car;

import org.springframework.stereotype.Component;
import org.studyeasy.interfaces.Car;

//@Component ("dacia")
public class Dacia implements Car {
    @Override
    public void specs() {
        System.out.println("Dacia Hatchback - economy car");
    }
}
