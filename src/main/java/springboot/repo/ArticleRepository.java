package springboot.repo;

import org.springframework.data.repository.CrudRepository;
import springboot.models.Article;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
