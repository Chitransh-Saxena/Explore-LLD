package visitorpattern;

import org.junit.Test;
import org.lld.visitorpattern.element.impl.AccountNode;
import org.lld.visitorpattern.element.impl.AssetNode;
import org.lld.visitorpattern.element.impl.PortfolioNode;
import org.lld.visitorpattern.visitor.PortfolioManagerVisitor;
import org.lld.visitorpattern.visitor.impl.ValuationVisitor;

import java.util.List;

public class ValuationVisitorTest {

    @Test
    public void testValuationOnSimpleTree() throws Exception {

        PortfolioNode root = new PortfolioNode();
        root.setId(1);

        AccountNode accountNode = new AccountNode();
        accountNode.setId(11);
        AssetNode assetNode1 = new AssetNode(100.0, "HDFC");
        AssetNode assetNode2 = new AssetNode(200.0, "ICICI");


        AccountNode accountNode2 = new AccountNode();
        accountNode2.setId(12);
        AssetNode assetNode3 = new AssetNode(150.0, "BOD");
        AssetNode assetNode4 = new AssetNode(250.0, "AMEX");



        // Need to add children and connections in tree, for that methods for these operations are required
        // Once the tree is prepared, test to get the complete valuation


        // Setup tree
        root.setAccounts(List.of(accountNode, accountNode2));
        accountNode.setAssets(List.of(assetNode1, assetNode2));
        accountNode2.setAssets(List.of(assetNode3, assetNode4));

        System.out.println("Visit Portfolio Test - " + "\n\n");
        PortfolioManagerVisitor valuationVisitor = new ValuationVisitor();
        root.accept(valuationVisitor);


        System.out.println("\nVisit Account2 Test - " + "\n\n");
        accountNode2.accept(valuationVisitor);


        System.out.println("\nVisit an Asset Test - " + "\n\n");
        assetNode3.accept(valuationVisitor);

    }
}
