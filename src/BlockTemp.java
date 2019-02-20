import java.util.Date;
import java.security.MessageDigest;

/**
 * An individual block in the chain.
 */
public class BlockTemp {
    private String hash;
    private String previousHash;
    private String data;
    private long timeStamp;
    private int nonce;

    public BlockTemp() {
        //Do nothing.
    }
    /**
     * The constructor for an individual block.
     *
     * @param data Data to store in the block.
     * @param previousHash hash of the previous block.
     */
    public BlockTemp(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    /**
     * Calculates the hash for the current block. Gets called in the constructor.
     *
     * @return A String of the block's hash based on all other inputs.
     */
    public String calculateHash() {
        String newHash = StringUtil.applySha256(previousHash
                + Long.toString(timeStamp) + data + nonce);
        return newHash;
    }

    /**
     * Getter for the hash of the current block.
     *
     * @return String hash.
     */
    public String getHash() {
        return hash;
    }

    /**
     * Getter for previous hash.
     *
     * @return String previousHash.
     */
    public String getPreviousHash() {
        return previousHash;
    }

    /**
     * Tries many many many integers until the desired hash is found.
     *
     * @param difficulty The number of zeros that must be in the start of the hash
     */
    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0','0');
        while (!hash.substring(0,difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!! : " + hash);
    }
}
