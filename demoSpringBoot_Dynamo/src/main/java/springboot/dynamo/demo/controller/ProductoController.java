package springboot.dynamo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import springboot.dynamo.demo.entity.Producto;
import springboot.dynamo.demo.repository.ProductoRepository;

@RestController
public class ProductoController {
	@Autowired
	private ProductoRepository repository;
	
	@PostMapping("/guardarProducto")
	public Producto guardarProducto(@RequestBody Producto producto) {
		return repository.agregarProducto(producto);		
	}
	@GetMapping("/obtenerProducto/{productoId}")
	public Producto buscarProducto(@PathVariable String productoId) {
		return repository.buscarProductoPorProductoId(productoId);
	}
	@DeleteMapping("/eliminarProducto")
	public String eliminarProducto(@RequestBody Producto producto) {
		return repository.eliminarProducto(producto);
	}
	@PutMapping("/editarProducto")
	public String actualizarProducto(@RequestBody Producto producto) {
		return repository.editarProducto(producto);
	}
	
}
