import com.google.gson.Gson;

public class BlockConstructor {
    Gson gson = new Gson();

    private final static String TRANSPORT_BLOCK_CODE = "0T";
    private final static String SUPPLIER_BLOCK_CODE = "0S";

    public Block constructBlock(String json) {
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
            default:
                System.out.println("Invalid Json form");
                break;
        }
        return null;
    }
}
