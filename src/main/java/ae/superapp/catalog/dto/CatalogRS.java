package ae.superapp.catalog.dto;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class CatalogRS {

    private Long id;
    private JsonNode Catalog;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;

}
