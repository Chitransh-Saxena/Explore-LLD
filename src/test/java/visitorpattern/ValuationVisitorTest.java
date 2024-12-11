package visitorpattern;

import org.junit.Test;
import org.lld.visitorpattern.element.impl.AccountNode;
import org.lld.visitorpattern.element.impl.AssetNode;
import org.lld.visitorpattern.element.impl.PortfolioNode;

public class ValuationVisitorTest {

    @Test
    public void testValuationOnSimpleTree() throws Exception {

        PortfolioNode root = new PortfolioNode();
        AccountNode accountNode = new AccountNode();
        AssetNode assetNode1 = new AssetNode(100.0, "HDFC");
        AssetNode assetNode2 = new AssetNode(200.0, "ICICI");

        // Need to add children and connections in tree, for that methods for these operations are required
        // Once the tree is prepared, test to get the complete valuation
    }
}
