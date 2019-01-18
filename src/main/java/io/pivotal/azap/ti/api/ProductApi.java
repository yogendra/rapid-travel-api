package io.pivotal.azap.ti.api;

import static java.util.stream.Collectors.toList;

import io.pivotal.azap.ti.api.Product.ProductType;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductApi {

  List<Product> products;

  @Autowired
  public ProductApi(List<Product> products) {
    this.products = products;
  }


  @GetMapping("/{code}")
  public Optional<Product> get(@PathVariable("code") String code) {
    return products.stream().filter(x -> x.getCode().equals(code)).findFirst();
  }

  @GetMapping({"/", ""})
  public List<Product> getAll() {
    return products;
  }

  @GetMapping(value = {"","/"},
      params = {"type"})
  public List<Product> getAllByType(@RequestParam("type") String type) {
    ProductType requiredType = ProductType.valueOf(type.toUpperCase());
    return products.stream().filter(x -> x.getType() == requiredType).collect(toList());
  }


}
