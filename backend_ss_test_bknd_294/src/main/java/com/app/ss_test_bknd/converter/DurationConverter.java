package com.app.ss_test_bknd.converter;







import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Duration;

@Converter(autoApply = false)
public class DurationConverter implements AttributeConverter<Duration, String> {
    @Override
    public String convertToDatabaseColumn(Duration duration) {
        return duration.toString();
    }

    @Override
    public Duration convertToEntityAttribute(String s) {
        return Duration.parse(s);
    }
}
