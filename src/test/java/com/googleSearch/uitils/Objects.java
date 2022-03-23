package com.googleSearch.uitils;

import com.googleSearch.pages.SearchPage;
import com.googleSearch.pages.SearchResultsPage;

public class Objects {

    private SearchPage searchPage;
    private SearchResultsPage searchResultsPage;

    public Objects() {
        searchPage = new SearchPage();
        searchResultsPage = new SearchResultsPage();
    }

    public SearchPage getSearchPage() {
        return searchPage;
    }

    public SearchResultsPage getSearchResultsPage() {
        return searchResultsPage;
    }
}
