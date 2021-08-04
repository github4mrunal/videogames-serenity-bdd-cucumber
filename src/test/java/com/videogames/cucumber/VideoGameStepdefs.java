package com.videogames.cucumber;

import com.videogames.utils.TestUtils;
import com.videogames.videogameinfo.VideoGameSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import static org.hamcrest.CoreMatchers.equalTo;

public class VideoGameStepdefs {


        ValidatableResponse response;
        static int id = 1 + TestUtils.getRandomValueInt();
        static String name = "Iron Man";
        static String releaseDate = "2019-09-20T08:55:58.510Z";
        static int reviewScore = 90;
        static String category = "Action";
        static String rating  = "Universal";


        @Steps
        VideoGameSteps videoGameSteps;

        @When("^I create a new videogame by providing the information name \"([^\"]*)\" releaseDate \"([^\"]*)\" rating \"([^\"]*)\"$")
    public void iCreateANewVideogameByProvidingTheInformationNameReleaseDateRating(String name, String releaseDate, String rating)  {
        videoGameSteps.createVideoGame(id,name,releaseDate,reviewScore,category,rating).log().all().statusCode(200).extract().response().body()
                .jsonPath();
    }

    @Then("^I verify the videogame is created$")
    public void iVerifyTheVideogameIsCreated() {
            videoGameSteps.getVideoGameById(id).log().all().statusCode(200);
     //   Assert.assertEquals(response,id);
    }

    @When("^I send GET request to videogames endpoint with Id \"([^\"]*)\",I should received the videogame information$")
    public void iSendGETRequestToVideogamesEndpointWithIdIShouldReceivedTheVideogameInformation(String videogameid)  {
        videoGameSteps.getVideoGameById(id).log().all().statusCode(200);

    }

    @When("^I update a created videogame by providing the new name\"([^\"]*)\" category and rating$")
    public void iUpdateACreatedVideogameByProvidingTheNewNameCategoryAndRating(String name)  {
        id = id;
        name = name + "_new";
        releaseDate = releaseDate;
        reviewScore = reviewScore + 1;
        category = category + "_new";
        rating = rating + "_new";

        videoGameSteps.updateVideoGame(id, name, releaseDate, reviewScore, category, rating).statusCode(200).log().all();

    }

    @Then("^I verify the videogame is updated$")
    public void iVerifyTheVideogameIsUpdated() {
        videoGameSteps.getVideoGameById(id).body("id", equalTo(id));
    }

    @When("^I delete a created videogame ,they must get back a valid status code is (\\d+)$")
    public void iDeleteACreatedVideogameTheyMustGetBackAValidStatusCodeIs(int videogameid) {
        videoGameSteps.deleteVideoGame(id).log().all().statusCode(200);
    }

    @When("^User sends a GET requets to videogames endpoint, they must get back a valid status code 200$")
    public void userSendsAGETRequetsToVideogamesEndpointTheyMustGetBackAValidStatusCode() {
        videoGameSteps.getAllVideoGames().log().all().statusCode(200);
    }
}
