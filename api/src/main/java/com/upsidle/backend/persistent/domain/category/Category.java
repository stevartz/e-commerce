package com.upsidle.backend.persistent.domain.category;

import com.upsidle.backend.persistent.domain.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;


/**
 * The product model for the application.
 *
 * @author Stephen Boakye
 * @version 1.0
 * @since 1.0
 */
@Entity
@Getter
@Setter
@Table(name = "category")
@NoArgsConstructor
@ToString(callSuper = true)
public class Category extends BaseEntity<Long> implements Serializable {

    @Serial
    private static final long serialVersionUID = 2412831733001851062L;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Category name is required")
    private String name;

    public Category(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Category category) || !super.equals(o)) {
            return false;
        }
        return Objects.equals(getName(), category.getName());
    }

    @Override
    protected boolean canEqual(Object other) {
        return other instanceof  Category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName());
    }
}




