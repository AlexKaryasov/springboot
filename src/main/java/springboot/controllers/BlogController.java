package springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springboot.models.Article;
import springboot.repo.ArticleRepository;

@Controller
public class BlogController {

    @Autowired
    protected ArticleRepository articleRepository;

    @GetMapping("/blog")
    protected String getBlogMain(Model model) {
        Iterable<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "blog-main";
    }

}
