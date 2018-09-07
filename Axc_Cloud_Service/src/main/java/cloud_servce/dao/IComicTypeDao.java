package cloud_servce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cloud_servce.entity.ComicType;


public interface IComicTypeDao extends JpaRepository<ComicType, Integer>, JpaSpecificationExecutor<ComicType>{
	ComicType findByComicId(Integer comic_id);
}