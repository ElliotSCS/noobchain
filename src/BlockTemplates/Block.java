package BlockTemplates;

public interface Block {
    String getHash();

    String getPreviousHash();

    void setHash();

    void mineBlock(int difficulty);

    String calculateHash();

    boolean equals(Object other);
}
