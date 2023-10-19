package ae.superapp.catalog.service;

import com.fasterxml.jackson.databind.JsonNode;

import ae.superapp.catalog.builder.CatalogApiRsBuilder;
import ae.superapp.catalog.dto.CatalogRS;
import ae.superapp.catalog.entity.Catalog;
import ae.superapp.catalog.exception.BadRequestException;
import ae.superapp.catalog.repository.CatalogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatalogService {

    @Autowired
    private CatalogRepository catalogRepository;

    public List<CatalogRS> getCatalogs() {
        List<Catalog> dbCatalogs = (List<Catalog>) catalogRepository.findAll();
        return dbCatalogs.stream()
                .map(CatalogApiRsBuilder::buildCatalogResponse)
                .collect(Collectors.toList());
    }

    public CatalogRS getCatalog(Long id) {
        return catalogRepository.findById(id)
                .map(CatalogApiRsBuilder::buildCatalogResponse)
                .orElseThrow(()->new BadRequestException("Catalog not found"));
    }

    public CatalogRS patchCatalog(Long id, JsonNode catalog) {
        Catalog dbCatalog = catalogRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Catalog not found"));

        dbCatalog.setCatalog(catalog.toString());
        return CatalogApiRsBuilder.buildCatalogResponse(catalogRepository.save(dbCatalog));
    }

    public CatalogRS postCatalog(JsonNode catalog) {
        Catalog dbCatalog = new Catalog();
        dbCatalog.setCatalog(catalog.toString());
        return CatalogApiRsBuilder.buildCatalogResponse(catalogRepository.save(dbCatalog));
    }

    public void deleteCatalog(Long id) {
        Catalog dbCatalog = catalogRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Catalog not found"));
        catalogRepository.delete(dbCatalog);
    }

}
