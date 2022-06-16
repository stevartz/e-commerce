package com.upsidle.backend.persistent.domain.product;

import com.jparams.verifier.tostring.NameStyle;
import com.jparams.verifier.tostring.ToStringVerifier;
import com.upsidle.TestUtils;
import com.upsidle.shared.util.ProductUtils;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

class ProductTest extends TestUtils {

  @Test
  void equalsContract() {

    var book = ProductUtils.createCategory(FAKER.book().genre());
    var category = ProductUtils.createCategory();

    EqualsVerifier.forClass(Product.class)
        .withRedefinedSuperclass()
        .withPrefabValues(Category.class, book, category)
        .withOnlyTheseFields(TestUtils.getEntityEqualsFields("name"))
        .verify();
  }

  @Test
  void testToString() {
    ToStringVerifier.forClass(Product.class)
        .withClassName(NameStyle.SIMPLE_NAME)
        .withIgnoredFields("rating", "category")
        .verify();
  }
}
