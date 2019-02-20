import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class NoobChain {
    public static List<Block> blockchain = new ArrayList<>();
    public static int difficulty = 3;

    public static void main(String[] args) {
        BlockConstructor constructor = new BlockConstructor();

        blockchain.add(constructor.constructBlock(blockchain, "SampleJson"));
        System.out.println("Trying to Mine block 1...");
        blockchain.get(0).mineBlock(difficulty);

        blockchain.add(constructor.constructBlock(blockchain, "SupplierJsonExample"));
        System.out.println("Trying to Mine block 2... ");
        blockchain.get(1).mineBlock(difficulty);

        System.out.println("\nBlockchain is Valid: " + BlockchainValidator.isChainValid(blockchain));

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);
    }
}
