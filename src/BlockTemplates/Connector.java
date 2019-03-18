package BlockTemplates;
import Structure.Blockchain;

public class Connector {
    ProducerRequestBlock parent;
    Block supplyConnection = null;

    public Connector(ProducerRequestBlock parent) {
        this.parent = parent;
    }

    public void SetSupplyConnection(Blockchain supplyChain) {
        parent.hasAChain = true;
        //Some functionality that has not yet been decided on for connecting the supply chain to the produce connector.
    }
}
