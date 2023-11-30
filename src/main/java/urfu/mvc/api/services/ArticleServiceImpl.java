package urfu.mvc.api.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import urfu.mvc.api.repositories.ArticleRepository;
import urfu.mvc.api.web.model.Article;
import urfu.mvc.api.web.model.ArticleDto;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    @Override
    public ArticleDto getById(UUID id) {
        Optional<Article> optional = articleRepository.findById(id);
        if(optional.isEmpty()){
            throw new EntityNotFoundException("Article not found for id: " + id);
        }
        Article article = optional.get();
        return ArticleDto.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .created(article.getCreated())
                .views(article.getViews())
                .build();
    }

    @Override
    public ArticleDto handleSave(ArticleDto dto) {

            Article article = convertToEntity(dto);
            articleRepository.save(article);
            return ArticleDto.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .created(article.getCreated())
                .views(article.getViews())
                .build();
    }

    @Override
    public ArticleDto handleUpdate(UUID id, ArticleDto dto) {
        return null;
    }

    @Override
    public void handleDelete(UUID id) {

    }

    private Article convertToEntity(ArticleDto dto){
        Article article = new Article();
        if(dto.getId() == null){
            article.setId(UUID.randomUUID());
        }
        else {
            article.setId(dto.getId());
        }
        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
        if(dto.getViews() == null){
            article.setViews(1);
        }
        else {
            article.setViews(dto.getViews());
        }

        if(dto.getCreated() == null){
            article.setCreated(ZonedDateTime.now());
        }
        return  article;
    }

}
