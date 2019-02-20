public class TransportBlock implements Block {
    private String hash;
    private String typeCode;
    private String previousHash;
    private String truckID;
    private String contentsOfShipment;
    private int nonce = 0;

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setHash() {
        String newHash = StringUtil.applySha256(previousHash + truckID + nonce
                + contentsOfShipment + typeCode);
        hash = newHash;
    }

    public String calculateHash() {
        String newHash = StringUtil.applySha256(previousHash + truckID + nonce
                + contentsOfShipment + typeCode);
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
