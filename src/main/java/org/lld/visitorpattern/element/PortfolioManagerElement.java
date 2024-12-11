package org.lld.visitorpattern.element;

import org.lld.visitorpattern.visitor.PortfolioManagerVisitor;

public interface PortfolioManagerElement {

    void accept(PortfolioManagerVisitor visitor);
}
