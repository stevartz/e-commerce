package com.upsidle.backend.persistent.domain.country;

import com.upsidle.backend.persistent.domain.base.BaseEntity;
import com.upsidle.backend.persistent.domain.state.State;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.Audited;

/**
 * The country model for the application.
 *
 * @author Matthew Puentes
 * @version 1.0
 * @since 1.0
 */
@Entity
@Getter
@Setter
@Audited
@Table(name = "countries")
@ToString(callSuper = true)
public class Country extends BaseEntity<Long> implements Serializable {
  private static final long serialVersionUID = 9096210160059983754L;

  @Column(unique = true, nullable = false)
  @Size(min = 2, max = 2)
  @NotBlank(message = "Country code is needed for all country entities")
  private String code;

  @Column(unique = true, nullable = false)
  @NotBlank(message = "Country name is needed for all country entities")
  private String name;

  @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
  private Set<State> states = new HashSet<>();

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Country country) || !super.equals(o)) {
      return false;
    }
    return Objects.equals(getName(), country.getName());
  }

  @Override
  protected boolean canEqual(Object other) {
    return other instanceof Country;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getName());
  }
}
