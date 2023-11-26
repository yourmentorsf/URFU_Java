package urfu.mvc.firstmvc.services;

import urfu.mvc.firstmvc.web.model.ArticleDto;

import java.util.List;
import java.util.UUID;

public interface ArticleService {
    List<ArticleDto> getAll();
    ArticleDto getById(UUID id);
    ArticleDto handleSave(ArticleDto dto);
    ArticleDto handleUpdate(UUID id, ArticleDto dto);
    void handleDelete(UUID id);

}
