package org.lld.visitorpattern.element.impl;

import org.lld.visitorpattern.element.PortfolioManagerElement;
import org.lld.visitorpattern.visitor.PortfolioManagerVisitor;

import java.util.ArrayList;
import java.util.List;

public class AccountNode implements PortfolioManagerElement {

    private List<PortfolioManagerElement> assets = new ArrayList<>();
    @Override
    public void accept(PortfolioManagerVisitor visitor) {

        visitor.visitAccount(this);
    }

    public List<PortfolioManagerElement> getAssets() {
        return assets;
    }
}
