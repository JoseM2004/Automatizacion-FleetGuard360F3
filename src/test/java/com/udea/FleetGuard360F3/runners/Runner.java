package com.udea.FleetGuard360F3.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/.../",
        glue = "com.udea.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Runner {}