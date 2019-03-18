package Structure;

import BlockTemplates.Block;
import BlockTemplates.Connector;
import BlockTemplates.ProducerRequestBlock;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    Block info;
    List<TreeNode> children = new ArrayList<>();

    public TreeNode(Block info) {
        this.info = info;
        if (info instanceof ProducerRequestBlock) {
            ProducerRequestBlock toAccess = (ProducerRequestBlock) info;
            toAccess.connector = new Connector(toAccess);
        }
    }

    public Block getInfo() {
        return info;
    }
}
