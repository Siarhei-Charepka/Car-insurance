package json;

import com.alibaba.fastjson.JSON;
import dto.TestDataDto;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

@Slf4j
public class JSONReader {
    public static List<TestDataDto> getCarClientData(String carClientDataFilePath) {
        Path filePath = Path.of(carClientDataFilePath);
        try {
            return JSON.parseArray(Files.readString(filePath), TestDataDto.class);
        } catch (IOException e) {
            log.error("PARSING ERROR");
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}
