package es.tecdata.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import es.tecdata.models.Producto;

@Mapper
public interface ProductosDAO {

	@Insert("insert into productos values (#{ID},#{descripcion},#{precio})")
	public int insert(Producto nuevo);

	@Select("select * from productos")
	public List<Producto> findAll();
	
	@Select("select * from productos where ID = #{id}")
	public Producto findById(Long id);

}
