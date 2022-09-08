package chatbot;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ChickenDAO {
	
	public int insertChicken(ChickenDTO dto);
		
	

}
