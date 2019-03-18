package BlockTemplates;
import Structure.StringUtil;

public class ProducerRequestBlock implements Block {
    private String hash;
    private String typeCode;
    private String previousHash;
    private String requestID;
    private String itemRequested;
    private int numberOfItemRequested;
    public Connector connector = null;
    public boolean hasAChain = false;
    private int nonce = 0;

    public String getRequestID() {
        return requestID;
    }

    public boolean equals(Object other) {
        if (other == null || !(other instanceof ProducerRequestBlock)) {
            return false;
        }
        ProducerRequestBlock toCompare = (ProducerRequestBlock) other;
        if (this.requestID.equals(toCompare.requestID) && this.typeCode.equals(toCompare.typeCode)
                && this.itemRequested.equals(toCompare.itemRequested)
                && this.numberOfItemRequested == toCompare.numberOfItemRequested
                && this.hasAChain == toCompare.hasAChain) {
            return true;
        } else {
            return false;
        }
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setHash() {
        String newHash = StringUtil.applySha256(previousHash + requestID + nonce
                + itemRequested + numberOfItemRequested);
        hash = newHash;
    }

    public String calculateHash() {
        String newHash = StringUtil.applySha256(previousHash + requestID + nonce
                + itemRequested + numberOfItemRequested);
        return newHash;
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!! : " + hash);
    }
}
