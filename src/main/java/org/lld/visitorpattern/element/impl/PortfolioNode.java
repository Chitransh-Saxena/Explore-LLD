package org.lld.visitorpattern.element.impl;

import org.lld.visitorpattern.element.PortfolioManagerElement;
import org.lld.visitorpattern.visitor.PortfolioManagerVisitor;

import java.util.ArrayList;
import java.util.List;

public class PortfolioNode implements PortfolioManagerElement {

    private List<PortfolioManagerElement> accounts = new ArrayList<>();
    @Override
    public void accept(PortfolioManagerVisitor visitor) {
        visitor.visitPortfolio(this);
    }

    public List<PortfolioManagerElement> getAccounts() {
        return accounts;
    }
}
