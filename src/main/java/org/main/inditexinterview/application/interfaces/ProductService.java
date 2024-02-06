package org.main.inditexinterview.application.interfaces;

import org.main.inditexinterview.application.exception.ProductSortingException;
import org.main.inditexinterview.domain.Product;
import org.main.inditexinterview.domain.SortingCriteria;

import java.util.List;

public interface ProductService {
    List<Product> getSortedProducts(SortingCriteria sortingCriteria) throws ProductSortingException;
}
