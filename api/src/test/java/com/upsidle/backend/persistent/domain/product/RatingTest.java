package com.upsidle.backend.persistent.domain.product;

import com.jparams.verifier.tostring.NameStyle;
import com.jparams.verifier.tostring.ToStringVerifier;
import com.upsidle.TestUtils;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

class RatingTest {

  @Test
  void equalsContract() {

    EqualsVerifier.forClass(Rating.class)
        .withRedefinedSuperclass()
        .withOnlyTheseFields(TestUtils.getEntityEqualsFields("rate", "count"))
        .verify();
  }

  @Test
  void testToString() {
    ToStringVerifier.forClass(Rating.class).withClassName(NameStyle.SIMPLE_NAME).verify();
  }
}
