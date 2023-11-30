package urfu.mvc.api.services;

import urfu.mvc.api.web.model.Article;
import urfu.mvc.api.web.model.ArticleDto;

import java.util.List;
import java.util.UUID;

public interface ArticleService {
    List<Article> getAll();
    ArticleDto getById(UUID id);
    ArticleDto handleSave(ArticleDto dto);
    ArticleDto handleUpdate(UUID id, ArticleDto dto);
    void handleDelete(UUID id);
}
