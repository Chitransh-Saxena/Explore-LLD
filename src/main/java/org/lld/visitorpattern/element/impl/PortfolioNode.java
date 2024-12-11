package org.lld.visitorpattern.element.impl;

import org.lld.visitorpattern.element.PortfolioManagerElement;
import org.lld.visitorpattern.visitor.PortfolioManagerVisitor;

public class PortfolioNode implements PortfolioManagerElement {
    @Override
    public void accept(PortfolioManagerVisitor visitor) {
        visitor.visitPortfolio(this);
    }
}
