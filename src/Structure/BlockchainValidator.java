package Structure;

import BlockTemplates.Block;
import Structure.Blockchain;

public class BlockchainValidator {
    public static Boolean isChainValid(Blockchain blockchain) {
        Block currentBlock;
        Block previousBlock;

        //Loop through blockchain to check hashes
        for (int i = 1; i < blockchain.getBlockchain().size(); i++) {
            currentBlock = blockchain.getBlockchain().get(i);
            previousBlock = blockchain.getBlockchain().get(i - 1);

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
