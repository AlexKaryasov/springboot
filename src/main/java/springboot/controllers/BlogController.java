package springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/blog/add")
    protected String getBlogAdd(Model model) {
        return "blog-add";
    }

    @PostMapping("/blog/add")
    protected String postBlogAdd(@RequestParam String title,
                                 @RequestParam String preview,
                                 @RequestParam String fullText,
                                 Model model) {
        Article article = new Article(title, preview, fullText);
        articleRepository.save(article);
        return "redirect:/blog";
    }
}
