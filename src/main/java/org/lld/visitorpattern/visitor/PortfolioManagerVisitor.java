package org.lld.visitorpattern.visitor;

import org.lld.visitorpattern.element.impl.AccountNode;
import org.lld.visitorpattern.element.impl.AssetNode;
import org.lld.visitorpattern.element.impl.PortfolioNode;

public interface PortfolioManagerVisitor {

    void visitPortfolio(PortfolioNode portfolioNode);
    void visitAccount(AccountNode accountNode);
    void visitAsset(AssetNode assetNode);
}
