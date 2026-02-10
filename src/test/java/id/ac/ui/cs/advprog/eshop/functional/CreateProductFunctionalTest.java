package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
class CreateProductFunctionalTest {

    @LocalServerPort
    private int port;

    @Test
    void testCreateProductAndSeeItInList(ChromeDriver driver) {
        String baseUrl = "http://localhost:" + port;

        // Open create page
        driver.get(baseUrl + "/product/create");

        // Fill form
        driver.findElement(By.id("nameInput")).sendKeys("Indomie Goreng");
        driver.findElement(By.id("quantityInput")).sendKeys("10");

        // Submit
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // After submit, ensure user can see product in list
        driver.get(baseUrl + "/product/list");

        List<WebElement> rows = driver.findElements(By.cssSelector("table tbody tr"));
        assertTrue(rows.size() > 0);

        boolean found = rows.stream().anyMatch(row -> row.getText().contains("Indomie Goreng"));
        assertTrue(found);
    }
}
