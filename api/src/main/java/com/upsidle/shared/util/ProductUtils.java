package com.upsidle.shared.util;

import com.upsidle.backend.persistent.domain.product.Category;
import com.upsidle.backend.persistent.domain.product.Product;
import com.upsidle.constant.ErrorConstants;
import java.math.BigDecimal;
import net.datafaker.Faker;

/**
 * Product utility class that holds product related methods used across the application.
 *
 * @author Eric Opoku
 * @version 1.0
 * @since 1.0
 */
public final class ProductUtils {

  private static final Faker FAKER = new Faker();

  private ProductUtils() {
    throw new AssertionError(ErrorConstants.NOT_INSTANTIABLE);
  }

  /**
   * creates a new product with generated content.
   *
   * @return the product
   */
  public static Product createProduct() {
    return createProduct(FAKER.commerce().productName());
  }

  /**
   * creates a new product with generated content and specified name.
   *
   * @return the product
   */
  public static Product createProduct(String name) {
    var product = new Product(name);
    product.setDescription(FAKER.commerce().department());
    product.setPrice(BigDecimal.valueOf(Double.parseDouble(FAKER.commerce().price())));
    product.setUnitsInStock(FAKER.number().numberBetween(1, 100));
    product.setActive(FAKER.bool().bool());

    return product;
  }

  /**
   * creates a new product category with generated content.
   *
   * @return the product category
   */
  public static Category createCategory() {
    return createCategory(FAKER.commerce().department());
  }

  /**
   * creates a new product category with generated content and specified name.
   *
   * @return the product category
   */
  public static Category createCategory(String name) {
    return new Category(name);
  }
}
