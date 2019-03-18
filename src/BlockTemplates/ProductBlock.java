package BlockTemplates;
import Structure.StringUtil;

public class ProductBlock implements Block {
    private String hash;
    private String typeCode;
    private String previousHash;
    private String itemName;
    private int numberOfItem;
    private int nonce = 0;

    public boolean equals(Object other) {
        if (other == null || !(other instanceof ProductBlock)) {
            return false;
        }
        ProductBlock toCompare = (ProductBlock) other;
        if (this.itemName.equals(toCompare.itemName) && this.typeCode.equals(toCompare.typeCode)
                && this.numberOfItem == toCompare.numberOfItem) {
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
        String newHash = StringUtil.applySha256(previousHash + itemName + nonce
                + numberOfItem);
        hash = newHash;
    }

    public String calculateHash() {
        String newHash = StringUtil.applySha256(previousHash + itemName + nonce
                + numberOfItem);
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
