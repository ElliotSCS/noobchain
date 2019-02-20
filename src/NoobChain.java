import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class NoobChain {
    public static List<Block> blockchain = new ArrayList<>();
    public static int difficulty = 5;

    public static void main(String[] args) {
        BlockConstructor constructor = new BlockConstructor();

        blockchain.add(constructor.constructBlock(
                Data.getFileContentsAsString("SampleJson")));
        System.out.println("Trying to Mine block 1...");
        blockchain.get(0).mineBlock(difficulty);

        blockchain.add(constructor.constructBlock(
                Data.getFileContentsAsString("SupplierJsonExample")));
        System.out.println("Trying to Mine block 2... ");
        blockchain.get(1).mineBlock(difficulty);

        /*blockchain.add(new Block("Cool kid third block",
                blockchain.get(blockchain.size()-1).getHash()));
        System.out.println("Trying to Mine block 3... ");
        blockchain.get(2).mineBlock(difficulty);*/

        System.out.println("\nBlockchain is Valid: " + BlockchainValidator.isChainValid(blockchain));

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);

        /*Block genesisBlock = new Block("Hi im the first block", "0");
        System.out.println("Hash for block 1 : " + genesisBlock.getHash());

        Block secondBlock = new Block("Yo im the second block", genesisBlock.getHash());
        System.out.println("Hash for block 2 : " + secondBlock.getHash());

        Block thirdBlock = new Block("Cool kid third block", secondBlock.getHash());
        System.out.println("Hash for block 3 : " + thirdBlock.getHash());*/
    }
}
