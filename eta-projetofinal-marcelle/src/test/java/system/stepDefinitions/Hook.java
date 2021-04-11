package system.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import system.helpers.DriverManager;

public class Hook {

    @Before()

    @After()
    public void endSession(){
        DriverManager.endSession();
    }
}
