package springboot.dynamo.demo.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;

import springboot.dynamo.demo.entity.Producto;

@Repository
public class ProductoRepository {
	@Autowired
	private DynamoDBMapper mapper;

	public Producto agregarProducto(Producto producto) {
		mapper.save(producto);
		return producto;
	}
	public Producto buscarProductoPorProductoId(String productoId) {
		return mapper.load(Producto.class, productoId);
	}
	public String eliminarProducto(Producto producto) {
		mapper.delete(producto);
		return "Producto eliminado...";
	}
	
	public String editarProducto(Producto producto) {
		mapper.save(producto, buildExpression(producto));
		return "Producto actualizado!!!";
	}
	
	public DynamoDBSaveExpression buildExpression(Producto producto) {
		DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
		Map<String, ExpectedAttributeValue> expectedMap = new HashMap<>();
		expectedMap.put("productoId", new ExpectedAttributeValue( 
				new AttributeValue().withS(producto.getProductoId())
				));
		dynamoDBSaveExpression.setExpected(expectedMap);
		return dynamoDBSaveExpression;
	}
	
}
