package org.lld.visitorpattern.element.impl;

import org.lld.visitorpattern.element.PortfolioManagerElement;
import org.lld.visitorpattern.visitor.PortfolioManagerVisitor;

public class AssetNode implements PortfolioManagerElement {
    @Override
    public void accept(PortfolioManagerVisitor visitor) {
        visitor.visitAsset(this);
    }
}
