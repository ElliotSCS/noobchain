package BlockTemplates;
import Structure.StringUtil;

public class TransportBlock implements Block {
    private String hash;
    private String typeCode;
    private String previousHash;
    private String truckID;
    private String contentsOfShipment;
    private int numberOfItem;
    private String qualityOfItem;
    private int nonce = 0;

    public boolean equals(Object other) {
        if (other == null || !(other instanceof TransportBlock)) {
            return false;
        }
        TransportBlock toCompare = (TransportBlock) other;
        if (this.truckID.equals(toCompare.truckID) && this.typeCode.equals(toCompare.typeCode)
                && this.contentsOfShipment.equals(toCompare.contentsOfShipment)
                && this.numberOfItem == toCompare.numberOfItem
                && this.qualityOfItem.equals(toCompare.qualityOfItem)) {
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
        String newHash = StringUtil.applySha256(previousHash + truckID + nonce
                + contentsOfShipment + typeCode + numberOfItem + qualityOfItem);
        hash = newHash;
    }

    public String calculateHash() {
        String newHash = StringUtil.applySha256(previousHash + truckID + nonce
                + contentsOfShipment + typeCode + numberOfItem + qualityOfItem);
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
