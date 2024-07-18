package caffeinelil.springbootdeveloper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class QuizControllerTest {

    @Autowired
    protected MockMvc mockMvc = null;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper objectMapper; //객체와 JSON간의 변환을 처리함

    @BeforeEach
    public void mockMvcSetUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .build();
    }
    @DisplayName("quiz(): GET /quiz?code=1이면 응답코드는 201, 응답 본문은 Created!를 리턴")
    @Test
    public void getQuiz1() throws Exception {
        final String url = "/quiz";


        final ResultActions result = mockMvc.perform(get(url)
                .param("code", "1 ")
        );

        result
                .andExpect(status().isCreated())
                .andExpect((ResultMatcher) content().string("Created!"));
    }

    @DisplayName("quiz(): GET /quiz?code=2이면 응답코드는 201, 응답 본문은 Created!를 리턴")
    @Test
    public void getQuiz2() throws Exception {
        //given
        final String url = "/quiz";

        final ResultActions result = mockMvc.perform(get(url)
                .param("code", "2 ")
        );

        result
                .andExpect(status().isBadRequest())
                .andExpect((ResultMatcher) content().string("Bad Request!"));
    }
}

