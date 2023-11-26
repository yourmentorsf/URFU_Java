package urfu.mvc.firstmvc.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import urfu.mvc.firstmvc.services.ArticleService;
import urfu.mvc.firstmvc.web.model.ArticleDto;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/articles")
@RestController
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }


    @GetMapping("/")
    public ResponseEntity<List<ArticleDto>> getAll(){
        return new ResponseEntity<>(articleService.getAll(), HttpStatus.OK);
    }


    @GetMapping("/show/{id}")
    public ResponseEntity<ArticleDto> get(@PathVariable() UUID id){
        return new ResponseEntity<>(articleService.getById(id), HttpStatus.OK);
    }

        @PostMapping("/create")
        public ResponseEntity<ArticleDto> create(ArticleDto dto){
            ArticleDto savedDto = articleService.handleSave(dto);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", "/api/v1/articles/" + savedDto.getId().toString());

            return new ResponseEntity<>(savedDto, headers, HttpStatus.CREATED);
        }
    }
