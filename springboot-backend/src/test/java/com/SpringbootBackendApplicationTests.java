package com;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SpringbootBackendApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void HelloWorld(){
        ;
    }

    @Test
    void intentionalFailToTestGitHubActions(){
        assertThat(5).isEqualTo(0);
    }

}
