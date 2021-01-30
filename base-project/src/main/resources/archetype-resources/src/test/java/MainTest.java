package ${groupId};

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class MainTest {
    public Main main;

    @BeforeEach
    void init() {
        main = new Main();
    }

    @Test
    @DisplayName("Check getMessage")
    void testMessage() {
        String message = main.getMessage();
        assertEquals("Hello World", message);
    }
}
