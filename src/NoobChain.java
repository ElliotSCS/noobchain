import Structure.Blockchain;
import Structure.BlockchainValidator;
import Structure.TreeChain;
import Structure.TreeNode;
import com.google.gson.GsonBuilder;

public class NoobChain {
    public static int difficulty = 4;

    public static void main(String[] args) {
        TreeChain salad = new TreeChain("Product Example");
        salad.addNode(salad.getRoot(), "ProducerRequestExample");
        TreeNode found = salad.findNode("ProducerRequestExample");
        System.out.println("findNode works: " + (found != null));

        Blockchain exampleSupplyChain = new Blockchain();

        exampleSupplyChain.add("SupplierJsonExample");
        exampleSupplyChain.add("FirstTransportExample");
        exampleSupplyChain.add("SecondTransportExample");

        System.out.println("\nBlockchain is Valid: " + BlockchainValidator.isChainValid(exampleSupplyChain));

        String blockchainJson = new GsonBuilder().setPrettyPrinting()
                .create().toJson(exampleSupplyChain.getBlockchain());
        System.out.println(blockchainJson);

        //Block Mining as proof of work
        //System.out.println("Trying to Mine block 2... ");
        //exampleSupplyChain.getBlockchain().get(1).mineBlock(difficulty);
    }
}
