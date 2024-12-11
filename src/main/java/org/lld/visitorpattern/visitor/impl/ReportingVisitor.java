package org.lld.visitorpattern.visitor.impl;

import org.lld.visitorpattern.element.impl.AccountNode;
import org.lld.visitorpattern.element.impl.AssetNode;
import org.lld.visitorpattern.element.impl.PortfolioNode;
import org.lld.visitorpattern.visitor.PortfolioManagerVisitor;

public class ReportingVisitor implements PortfolioManagerVisitor {
    @Override
    public void visitPortfolio(PortfolioNode portfolioNode) {

    }

    @Override
    public void visitAccount(AccountNode accountNode) {

    }

    @Override
    public void visitAsset(AssetNode assetNode) {

    }
}
