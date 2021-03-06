package BlockTemplates;
import Structure.StringUtil;

public class SupplierBlock implements Block {
    private String hash;
    private String typeCode;
    private String previousHash;
    private String supplierID;
    private String itemSupplied;
    private int numberOfItem;
    private int nonce = 0;

    public boolean equals(Object other) {
        if (other == null || !(other instanceof SupplierBlock)) {
            return false;
        }
        SupplierBlock toCompare = (SupplierBlock) other;
        if (this.supplierID.equals(toCompare.supplierID) && this.typeCode.equals(toCompare.typeCode)
                && this.itemSupplied.equals(toCompare.itemSupplied)
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
        String newHash = StringUtil.applySha256(previousHash + itemSupplied + nonce
                + numberOfItem + typeCode + supplierID);
        hash = newHash;
    }

    public String calculateHash() {
        String newHash = StringUtil.applySha256(previousHash + itemSupplied + nonce
                + numberOfItem + typeCode + supplierID);
        return newHash;
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0','0');
        while (!hash.substring(0,difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!! : " + hash);
    }
}
