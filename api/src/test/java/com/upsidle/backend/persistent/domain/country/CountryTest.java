package com.upsidle.backend.persistent.domain.country;

import com.jparams.verifier.tostring.NameStyle;
import com.jparams.verifier.tostring.ToStringVerifier;
import com.upsidle.TestUtils;
import com.upsidle.backend.persistent.domain.state.State;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

public class CountryTest extends TestUtils {

  @Test
  void equalsContract() {
    State one = new State();
    one.setName(TestUtils.FAKER.country().name());

    State two = new State();
    one.setName(TestUtils.FAKER.country().name());

    EqualsVerifier.forClass(Country.class)
        .withRedefinedSuperclass()
        .withPrefabValues(State.class, one, two)
        .withOnlyTheseFields(TestUtils.getEntityEqualsFields("name"))
        .verify();
  }

  @Test
  void testToString() {
    ToStringVerifier.forClass(Country.class).withClassName(NameStyle.SIMPLE_NAME).verify();
  }
}
