package examples.repository.advertence.view;

import au.com.origin.snapshots.Expect;
import au.com.origin.snapshots.annotations.SnapshotName;
import au.com.origin.snapshots.junit5.SnapshotExtension;
import examples.infratest.BaseTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;

import static examples.infratest.BDD.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith({SnapshotExtension.class})
class AdvertenceEndpointTest extends BaseTest {

    private Expect expect;

    @BeforeAll
    public static void beforeAll() throws IOException {
        scenarios.load("advertence-scenario.json");
    }

    @SnapshotName("should create a new advertence")
    @Test
    public void shouldSaveANewAdvertence() throws Exception {
        Given("a new advertence");
            var body = s("new advertence with all valid data");
        When("the api is called");
            var response = mockMvc.perform(post("/advertences")
                    .content(body)
                    .contentType("application/json")).andReturn();
        Then("must return a new advertence created");
            expect.toMatchSnapshot(response.getResponse().getContentAsString());
            assertEquals(CREATED.value(), response.getResponse().getStatus());
    }

    @SnapshotName("should not save because the student not exist")
    @Test
    public void shouldNotSaveBecauseStudentIsInvalid() throws Exception {
        Given("a new advertence");
            var body = s("payload with invalid student");
        When("the api is called");
            var response = mockMvc.perform(post("/advertences")
                .content(body)
                .contentType("application/json")).andReturn();
        Then("must return a bad request");
            expect.toMatchSnapshot(response.getResponse().getContentAsString());
            assertEquals(BAD_REQUEST.value(), response.getResponse().getStatus());
    }
}