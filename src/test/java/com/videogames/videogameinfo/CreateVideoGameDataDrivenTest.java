package com.videogames.videogameinfo;

import com.videogames.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.videogames.videogameinfo.VideoGameCRUDTestWithSteps.*;
@Concurrent(threads = "4x")
@UseTestDataFrom("src/test/java/resources/testdata/videogame.csv")
@RunWith(SerenityParameterizedRunner.class)
public class CreateVideoGameDataDrivenTest extends TestBase {

    private int id;
    private String name;
    private String releasedate;
    private int reviewscore;
    private String category;
    private String rating;

    @Steps
    VideoGameSteps videoGameSteps;


@Title(" Creating a new videogame by Data Driven Test")
    @Test
    public void createNewVideoGame(){
    videoGameSteps.createVideoGame(id,name,releasedate,reviewscore,category,rating);
}


}
