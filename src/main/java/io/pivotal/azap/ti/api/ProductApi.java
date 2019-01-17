package io.pivotal.azap.ti.api;

import io.pivotal.azap.ti.db.ProductRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductApi {
  private ProductRepository products;

  @Autowired
  public ProductApi(ProductRepository products) {
    this.products = products;
  }

  @GetMapping("/{id}")
  public Product get(@PathVariable("id") Long id){
    return Product.builder().id(id).build();
  }

}
