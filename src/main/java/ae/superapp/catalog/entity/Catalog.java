package ae.superapp.catalog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Table(name = "catalog")
@Data
public class Catalog extends BaseEntity {

    @NotEmpty(message = "Catalog name is required")
    @Column(name = "CATALOG")
    @Lob
    private String catalog;

}
