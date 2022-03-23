package com.googleSearch.stepDefinitions;

import com.googleSearch.uitils.Driver;
import com.googleSearch.uitils.Objects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.stream.Collectors;

public class Search {
    public Objects objects = new Objects();

    @Given("user is on the Google landing page")
    public void user_is_on_the_Google_landing_pag() {
        Driver.getDriver().get("https://www.google.com");
    }

    @When("user searches for the {string}")
    public void user_searches_for_the(String item) {
        objects.getSearchPage().searchBar.sendKeys(item + Keys.ENTER);
    }

    @Then("user should see the {string} in the search results page")
    public void user_should_see_the_in_the_basket(String item) {
        String currentUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue("Actual URL does not start with " + "https://www.google.com/search?q=" + item,
                currentUrl.startsWith("https://www.google.com/search?q=" + item));
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("Actual page title is not " + item + " - Google Search", actualTitle,
                item + " - Google Search");
        List<String> list = Driver.getDriver().findElements(By.cssSelector("#rso em")).stream().map(p -> p.getText().
                endsWith("s") ? p.getText().toLowerCase() : p.getText().toLowerCase() + "s").collect(Collectors.toList());
        String itemLowerCase = item.toLowerCase();
        System.out.println(itemLowerCase);
        list.forEach(p -> Assert.assertEquals(itemLowerCase, p));
    }
}
