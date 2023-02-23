package examples.infratest;


import examples.infratest.scenarios.ScenarioLoaderHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class BaseTest {

    protected static ScenarioLoaderHelper scenarios = new ScenarioLoaderHelper();
    @Autowired
    protected MockMvc mockMvc;

    protected String s(String scenarioName) {
        return this.scenarios.getScenario(scenarioName).getJson();
    }


}
