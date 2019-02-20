import java.util.List;

public class BlockchainValidator {
    public static Boolean isChainValid(List<Block> blockchain) {
        Block currentBlock;
        Block previousBlock;

        //Loop through blockchain to check hashes
        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);

            //Compare registered hash and calculated hash
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                System.out.println("Current hashes not equal");
                return false;
            }
            //compare previous hash with stored previous hash
            if (!previousBlock.getHash().equals(currentBlock.getPreviousHash())) {
                System.out.println("Previous hashes not equal");
                return false;
            }
        }
        return true;
    }
}
