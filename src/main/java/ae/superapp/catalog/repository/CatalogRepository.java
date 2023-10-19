package ae.superapp.catalog.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ae.superapp.catalog.entity.Catalog;

@Repository
public interface CatalogRepository extends CrudRepository<Catalog, Serializable> {

}
