package org.lld.visitorpattern.element.impl;

import org.lld.visitorpattern.element.PortfolioManagerElement;
import org.lld.visitorpattern.visitor.PortfolioManagerVisitor;

public class AssetNode implements PortfolioManagerElement {

    private double value;
    private String name;
    @Override
    public void accept(PortfolioManagerVisitor visitor) {
        visitor.visitAsset(this);
    }


    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AssetNode(double value, String name) {
        this.value = value;
        this.name = name;
    }

    public AssetNode() {
    }
}
