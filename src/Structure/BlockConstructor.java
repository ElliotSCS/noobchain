package Structure;

import BlockTemplates.*;
import com.google.gson.*;
import java.io.FileReader;
import java.util.List;

public class BlockConstructor {
    private Gson gson = new Gson();

    private final static String TRANSPORT_BLOCK_CODE = "0T";
    private final static String SUPPLIER_BLOCK_CODE = "0S";
    private final static String PRODUCER_REQUEST_BLOCK_CODE = "PR";
    private final static String PRODUCT_BLOCK_CODE = "0P";

    public TreeNode constructTreeNode(TreeNode parent, String filename) {
        String json;
        if (parent == null) {
            json = constructJson("0", filename);
        } else {
            json = constructJson(parent.info.getHash(), filename);
        }
        Block childData = constructBlock(json);
        TreeNode toReturn = new TreeNode(childData);
        if (parent != null) {
            parent.children.add(toReturn);
        }
        return toReturn;
    }

    private Block constructBlock(String json) {
        BlockTypeIdentifier identifier = gson.fromJson(json, BlockTypeIdentifier.class);
        String type = identifier.getTypeCode();

        Block toReturn;
        switch(type) {
            case TRANSPORT_BLOCK_CODE:
                toReturn = gson.fromJson(json, TransportBlock.class);
                toReturn.setHash();
                return toReturn;
            case SUPPLIER_BLOCK_CODE:
                toReturn = gson.fromJson(json, SupplierBlock.class);
                toReturn.setHash();
                return toReturn;
            case PRODUCER_REQUEST_BLOCK_CODE:
                toReturn = gson.fromJson(json, ProducerRequestBlock.class);
                toReturn.setHash();
                return toReturn;
            case PRODUCT_BLOCK_CODE:
                toReturn = gson.fromJson(json, ProductBlock.class);
                toReturn.setHash();
                return toReturn;
            default:
                System.out.println("Invalid Json form");
                return null;
        }
    }
    public Block constructBlockForChain(List<Block> blockchain, String filename) {
        String json;
        if (blockchain == null || blockchain.size() == 0) {
            json = constructJson("0", filename);
        } else {
            json = constructJson(blockchain.get(blockchain.size() - 1).getHash(), filename);
        }
        return constructBlock(json);
    }

    public String constructJson(String previousHash, String filename) {
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = null;

        try {
            jsonObject = (JsonObject)parser.parse(new FileReader(
                    "C:\\Users\\Elliot'sLaptop\\IdeaProjects\\noobchain\\Data\\" + filename));
        } catch (Exception E) {
            System.out.println("That file does not exist in Data folder.");
    }
        jsonObject.add("previousHash", new JsonParser().parse(previousHash));

        return jsonObject.toString();
    }
}
