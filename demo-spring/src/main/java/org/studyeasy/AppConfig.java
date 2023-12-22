package org.studyeasy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.studyeasy.car.Dacia;
import org.studyeasy.car.Engine;
import org.studyeasy.car.Volvo;

@Configuration
@ComponentScan ("org.studyeasy")
public class AppConfig {
//    We can also user spring Beans
//    We can get rid off all @Component annotation from each class and use Spring-Bean here
    @Bean (name = "dacia")
    public Dacia dacia() {
        return  new Dacia();
    }
    @Bean (name = "volvo")
    public Volvo volvo() {
        return new Volvo();
    }

    @Bean (name = "engine")
    public Engine engine() {
        return new Engine();
    }




}
