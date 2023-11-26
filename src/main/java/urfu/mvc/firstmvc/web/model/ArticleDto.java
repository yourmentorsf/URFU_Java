package urfu.mvc.firstmvc.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleDto {
    private UUID id;
    private String title;
    private String content;
    private Integer views;
    private ZonedDateTime created;
}
