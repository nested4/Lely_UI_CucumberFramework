package com.lely.runners;


import io.cucumber.junit.*;
import org.junit.runner.*;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/lely/step_definitions",
        features = "@target/rerun.txt"
)
public class FailedTestRunner {
}



