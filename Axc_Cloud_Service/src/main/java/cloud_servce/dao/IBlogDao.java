package cloud_servce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import cloud_servce.entity.Blog;

@Repository
public interface IBlogDao extends JpaRepository<Blog, Integer>, JpaSpecificationExecutor<Blog>{
	Blog findByBlogId(Integer blog_id);
	Blog findByOnlyIdentification(String only_identification);
}