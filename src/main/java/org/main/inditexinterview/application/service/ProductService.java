package org.main.inditexinterview.application.service;

import org.main.inditexinterview.domain.model.Product;
import org.main.inditexinterview.domain.model.SortingCriteria;

import java.util.List;

public interface ProductService {
    List<Product> getSortedProducts(SortingCriteria sortingCriteria);
}
