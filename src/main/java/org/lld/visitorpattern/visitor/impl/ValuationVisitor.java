package org.lld.visitorpattern.visitor.impl;

import org.lld.visitorpattern.element.PortfolioManagerElement;
import org.lld.visitorpattern.element.impl.AccountNode;
import org.lld.visitorpattern.element.impl.AssetNode;
import org.lld.visitorpattern.element.impl.PortfolioNode;
import org.lld.visitorpattern.visitor.PortfolioManagerVisitor;

public class ValuationVisitor implements PortfolioManagerVisitor {
    @Override
    public void visitPortfolio(PortfolioNode portfolioNode) {

        System.out.println("Visiting Portfolio - " + portfolioNode.getId());

        for(PortfolioManagerElement accountNode: portfolioNode.getAccounts()) {

            AccountNode node = (AccountNode) accountNode;
            for(PortfolioManagerElement assetNode :  node.getAssets()) {

                AssetNode node1 = (AssetNode) assetNode;
                System.out.println("Asset Name - " + node1.getName());
                System.out.println("Asset Value - " + node1.getValue());
            }
        }
    }

    @Override
    public void visitAccount(AccountNode accountNode) {

        System.out.println("Visiting Account - " + accountNode.getId());

        AccountNode node = (AccountNode) accountNode;
        for(PortfolioManagerElement assetNode :  node.getAssets()) {

            AssetNode node1 = (AssetNode) assetNode;
            System.out.println("Asset Name - " + node1.getName());
            System.out.println("Asset Value - " + node1.getValue());
        }
    }

    @Override
    public void visitAsset(AssetNode assetNode) {

        System.out.println("Visiting Asset - " + assetNode.toString());
    }
}
