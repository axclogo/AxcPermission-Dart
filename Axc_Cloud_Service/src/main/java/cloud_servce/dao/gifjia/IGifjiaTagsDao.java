package cloud_servce.dao.gifjia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import cloud_servce.entity.gifjia.GifjiaTags;

@Repository
public interface IGifjiaTagsDao extends JpaRepository<GifjiaTags, Integer>, JpaSpecificationExecutor<GifjiaTags>{
	
	GifjiaTags findByTagId(Integer tag_id);
	GifjiaTags findByIdentification(String identification);
	
}