package hasanalmunawarDev.SpringBasic.application;

import hasanalmunawarDev.SpringBasic.Listener.AppFailedListener;
import hasanalmunawarDev.SpringBasic.Listener.AppStartedListener;
import hasanalmunawarDev.SpringBasic.Listener.AppStartingListener;
import hasanalmunawarDev.SpringBasic.date.Barr;
import hasanalmunawarDev.SpringBasic.date.Foo;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class FooApplication {

//    public static void main(String[] args) {
//        ConfigurableApplicationContext context = SpringApplication.run(FooApplication.class, args);
//        Foo foo = context.getBean(Foo.class);
//    }

    @Bean
    public Foo foo(){
        return new Foo();
    }

//    public static void main(String[] args) {
//        SpringApplication application = new SpringApplication(FooApplication.class);
//        application.setBannerMode(Banner.Mode.OFF);
//        application.setListeners(
//                List.of(new AppStartingListener(), //
//                        new AppStartedListener(),
//                        new AppFailedListener()
//        ));

        /*
        ApplicationStartingEvent = Dikirim ketika start aplikasi
ApplicationContextInitializedEvent = Dikirim ketika ApplicationContext sudah di initialisasi
ApplicationStartedEvent = Dikirim ketika aplikasi sudah berjalan
ApplicationFailedEvent = Dikirim ketika aplikasi gagal berjalan
dan lain-lain

*/

//        ConfigurableApplicationContext context = application.run(args);
//        Foo foo = context.getBean(Foo.class);
//    }
}
