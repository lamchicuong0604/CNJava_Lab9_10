package com.example.springcommerce.repository.custom;

import com.example.springcommerce.dto.ProductSearchRequest;
import com.example.springcommerce.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> search(ProductSearchRequest searchQuery) {
        Map<String, Object> values = new HashMap<>();
        StringBuilder sql = new StringBuilder("SELECT P FROM Product P ");
        sql.append(createWhereQuery(searchQuery, values));
        Query query = entityManager.createQuery(sql.toString(), Product.class);
        values.forEach(query::setParameter);
        return query.getResultList();
    }

    private String createWhereQuery(ProductSearchRequest searchQuery, Map<String, Object> values) {
        StringBuilder sql = new StringBuilder(" WHERE 1 = 1 ");
        if (Objects.nonNull(searchQuery.getName()) && !("".equals(searchQuery.getName()))) {
            sql.append(" AND P.name like :name ");
            values.put("name", "%" + searchQuery.getName() + "%");
        }
        if (Objects.nonNull(searchQuery.getBrand()) && !("".equals(searchQuery.getBrand()))) {
            sql.append(" AND P.brand like :brand ");
            values.put("brand", "%" + searchQuery.getBrand() + "%");
        }
        if (searchQuery.getFromPrice() > 0) {
            sql.append(" AND P.price >= :fromPrice ");
            values.put("fromPrice", searchQuery.getFromPrice());
        }
        if (searchQuery.getToPrice() > 0 ) {
            sql.append(" AND P.price <= :toPrice ");
            values.put("toPrice", searchQuery.getToPrice());
        }
        if (searchQuery.getCategoryId() > 0 ) {
            sql.append(" AND P.categoryId = :categoryId ");
            values.put("categoryId", searchQuery.getCategoryId());
        }
        if (Objects.nonNull(searchQuery.getColor()) && !("".equals(searchQuery.getColor()))) {
            sql.append(" AND P.color like :color ");
            values.put("color", "%" + searchQuery.getColor() + "%");
        }
        return sql.toString();
    }
}
