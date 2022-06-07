package com.developersboard.shared.util;

import com.developersboard.backend.persistent.domain.product.Product;
import com.developersboard.constant.ErrorConstants;
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
}
