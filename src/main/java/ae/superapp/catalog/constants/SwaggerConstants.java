package ae.superapp.catalog.constants;


/**
 * Constants class for Swagger Constants
 *
 * @since 2023-07-11
 */
public class SwaggerConstants {

    private SwaggerConstants() {
    }
    public static final String OPEN_API_APP_TITLE = "RAKBANK Catalog Service";
    public static final String OPEN_API_APP_DESCRIPTION = "This service provides APIs for Catalogs";
    public static final String OPEN_API_APP_VERSION = "alpha";
    public static final String LOCAL_SERVER_BASE_URL = "http://localhost:8091/catalog-service";
    public static final String LOCAL_SERVER_DESCRIPTION = "LOCAL";
    public static final String CATALOG_CONTROLLER_TAG_SUMMARY = "Catalog Controller";
    public static final String CATALOG_CONTROLLER_DESCRIPTION = "APIs that we are exposing to do crud operation on catalog";
}
