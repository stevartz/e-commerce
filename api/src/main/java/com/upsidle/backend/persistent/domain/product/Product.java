package com.upsidle.backend.persistent.domain.product;

import com.upsidle.backend.persistent.domain.base.BaseEntity;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

/**
 * The product model for the application.
 *
 * @author Eric Opoku
 * @version 1.0
 * @since 1.0
 */
@Entity
@Getter
@Setter
@Audited
@NoArgsConstructor
@ToString(callSuper = true)
public class Product extends BaseEntity<Long> implements Serializable {

  @Serial private static final long serialVersionUID = 5801740651856592988L;

  private String name;
  private String imageUrl;
  private String description;
  private BigDecimal price;
  private boolean active;
  private int unitsInStock;

  @NotAudited
  @ToString.Exclude
  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Rating rating;

  @NotAudited
  @ToString.Exclude
  @JoinColumn(nullable = false)
  @ManyToOne(fetch = FetchType.LAZY)
  private Category category;

  public Product(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Product product) || !super.equals(o)) {
      return false;
    }
    return Objects.equals(getName(), product.getName());
  }

  @Override
  protected boolean canEqual(Object other) {
    return other instanceof Product;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getName());
  }
}
