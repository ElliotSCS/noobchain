package Structure;

import BlockTemplates.Block;
import Structure.BlockConstructor;
import Structure.TreeNode;

public class TreeChain {
    TreeNode root;
    BlockConstructor constructor = new BlockConstructor();

    public TreeChain(String fileName) {
        root = constructor.constructTreeNode(null, fileName);
    }

    public TreeNode getRoot() {
        return root;
    }

    public void addNode(TreeNode parent, String filename) {
        constructor.constructTreeNode(parent, filename);
    }

    public TreeNode findNode(String filename) {
        Block infoToFind = constructor.constructBlockForChain(null, filename);
        return findNode(root, infoToFind);
    }

    private TreeNode findNode(TreeNode node, Block toFind) {
        if (node.getInfo().equals(toFind)) {
            return node;
        } else {
            for (TreeNode child : node.children) {
                TreeNode potentialFind = findNode(child, toFind);
                if (potentialFind != null) {
                    return potentialFind;
                }
            }
            return null;
        }
    }
}
