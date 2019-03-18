package Structure;

import BlockTemplates.Block;

import java.util.LinkedList;

public class Blockchain extends LinkedList<Block>{
    LinkedList<Block> blockchain;
    BlockConstructor constructor;

    public Blockchain() {
        blockchain = new LinkedList<>();
        constructor = new BlockConstructor();
    }

    public Blockchain(String filename) {
        blockchain = new LinkedList<>();
        constructor = new BlockConstructor();
        add(filename);
    }

    public void add(String filename) {
        blockchain.add(constructor.constructBlockForChain(blockchain, filename));
    }

    public LinkedList<Block> getBlockchain() {
        return blockchain;
    }
}
