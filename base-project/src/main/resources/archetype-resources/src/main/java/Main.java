package ${groupId};

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public String getMessage() {
        return "Hello World";
    }

    public static void main(String[] args) {
        LOGGER.info("Executing Main.main() with args.length:{}", args.length);

        final Main main = new Main();
        System.out.println(main.getMessage());
    }
}
