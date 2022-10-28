package com.bank.javatesttask.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Page<T> {
    private Long numberOfItems;
    private int numberOfPages;
    private int currentPage;

    public Page(org.springframework.data.domain.Page<T> page) {
        this.numberOfItems = page.getTotalElements();
        this.numberOfPages = page.getTotalPages();
        this.currentPage = page.getPageable().getPageNumber();
    }
}
