package init;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class Log {

    //@RepeatedTest(3)
    public void test(){

        long start = System.nanoTime();
        long millis_startTime = System.currentTimeMillis();
        open("https://google.com");
        $(By.name("q")).val("selenide").pressEnter();
        long end = System.nanoTime();
        long millis_endTime = System.currentTimeMillis();

        System.out.println("Time taken in nano seconds: "
                + (end - start)/10000000);
        System.out.println("Time taken in milli seconds: "
                + (millis_endTime - millis_startTime)/1000);

        //Log.info("Затрачено времени {} ms", (end-start)/10000000);
    }
}
