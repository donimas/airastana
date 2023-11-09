package kz.dkazi.airastana.entity.elasticsearch;

import kz.dkazi.airastana.enums.EventStatus;
import kz.dkazi.airastana.enums.EventType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.Instant;

@Document(indexName = "airastana_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LogEventDoc {

    @Id
    private String id;

    @Field(name = "create_date", type = FieldType.Date)
    private Instant createDate;

    private EventType type;

    private String username;

    private String message;

    private EventStatus status;

}
