package com.upsidle.backend.persistent.domain.product;

import com.jparams.verifier.tostring.NameStyle;
import com.jparams.verifier.tostring.ToStringVerifier;
import com.upsidle.TestUtils;
import com.upsidle.shared.util.ProductUtils;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

public class CategoryTest extends TestUtils {

  @Test
  void equalsContract() {

    var vegetable = ProductUtils.createProduct(FAKER.food().vegetable());
    var product = ProductUtils.createProduct();

    EqualsVerifier.forClass(Category.class)
        .withRedefinedSuperclass()
        .withPrefabValues(Product.class, vegetable, product)
        .withOnlyTheseFields(TestUtils.getEntityEqualsFields("name"))
        .verify();
  }

  @Test
  void testToString() {
    ToStringVerifier.forClass(Category.class)
        .withClassName(NameStyle.SIMPLE_NAME)
        .withIgnoredFields("products")
        .verify();
  }
}
