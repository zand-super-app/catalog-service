package ae.superapp.catalog.controller;

import com.fasterxml.jackson.databind.JsonNode;

import ae.superapp.catalog.dto.CatalogRS;
import ae.superapp.catalog.service.CatalogService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static ae.superapp.catalog.constants.SwaggerConstants.*;

import java.util.List;

@RestController
@RequestMapping("/catalogs")
@Tag(name = CATALOG_CONTROLLER_TAG_SUMMARY, description = CATALOG_CONTROLLER_DESCRIPTION)
public class CatalogController {

    @Autowired
    CatalogService catalogService;

    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
            @Content(mediaType = "application/json")
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "400", description = "Bad Request")})
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CatalogRS> getCatalogs() {
        return catalogService.getCatalogs();
    }

    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
            @Content(mediaType = "application/json")
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "400", description = "Bad Request")})
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CatalogRS getCatalog(@PathVariable Long id) {
        return catalogService.getCatalog(id);
    }

    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
            @Content(mediaType = "application/json")
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "400", description = "Bad Request")})
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CatalogRS postCatalog(@RequestBody JsonNode catalog) {
        return catalogService.postCatalog(catalog);
    }

    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
            @Content(mediaType = "application/json")
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "400", description = "Bad Request")})
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CatalogRS pathCatalog(@PathVariable Long id, @RequestBody JsonNode catalog) {
        return catalogService.patchCatalog(id, catalog);
    }

    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
            @Content(mediaType = "application/json")
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "400", description = "Bad Request")})
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCatalog(@PathVariable Long id) {
        catalogService.deleteCatalog(id);
    }

}
