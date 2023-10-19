package ae.superapp.catalog.builder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import ae.superapp.catalog.dto.CatalogRS;
import ae.superapp.catalog.entity.Catalog;
import lombok.SneakyThrows;

public class CatalogApiRsBuilder {

    @SneakyThrows
    public static CatalogRS buildCatalogResponse(Catalog catalog) {
        return CatalogRS.builder().id(catalog.getId())
                .Catalog(new ObjectMapper().readValue(catalog.getCatalog(), JsonNode.class))
                .createdAt(catalog.getCreatedAt())
                .lastModifiedAt(catalog.getLastModifiedAt())
                .build();
    }

}
