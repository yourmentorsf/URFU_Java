package urfu.mvc.client.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import urfu.mvc.api.services.ArticleService;
import urfu.mvc.api.web.model.ArticleDto;

import java.util.UUID;

@Controller
public class ArticleViewController {
    private final ArticleService articleService;


    public ArticleViewController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/articles")
    public String listArticles(Model model) {
        model.addAttribute("articles", articleService.getAll());
        return "articles/list"; // Обращение к шаблону src/main/resources/templates/articles/list.html
    }
    @GetMapping("/articles/{id}")
    public String showArticle(Model model, @PathVariable() UUID id){
        model.addAttribute("article", articleService.getById(id));
        return "articles/show";
    }

    @GetMapping("/articles/create")
    public String createArticle(Model model){
        model.addAttribute("article", new ArticleDto());
        return "articles/create";
    }
    @PostMapping("/articles/create")
    public String saveArticle(@ModelAttribute ArticleDto article){
        articleService.handleSave(article);
        return "redirect:/articles";
    }

}
