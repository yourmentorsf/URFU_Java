package urfu.mvc.firstmvc.services;

import org.springframework.stereotype.Service;
import urfu.mvc.firstmvc.web.model.ArticleDto;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Override
    public List<ArticleDto> getAll() {
        return null;
    }

    @Override
    public ArticleDto getById(UUID id) {

        return ArticleDto.builder()
                .id(UUID.randomUUID())
                .title("My First Article")
                .content("Some random text about nothing. Adn one more sentence.")
                .created(ZonedDateTime.now())
                .views(1)
                .build();
    }

    @Override
    public ArticleDto handleSave(ArticleDto dto) {
            return ArticleDto.builder()
                .id(UUID.randomUUID())
                .title(dto.getTitle())
                .content(dto.getContent())
                .created(dto.getCreated())
                .views(dto.getViews())
                .build();
    }

    @Override
    public ArticleDto handleUpdate(UUID id, ArticleDto dto) {
        return null;
    }

    @Override
    public void handleDelete(UUID id) {

    }
}
