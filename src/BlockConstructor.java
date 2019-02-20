import com.google.gson.Gson;

public class BlockConstructor {
    Gson gson = new Gson();

    private final static String TRANSPORT_BLOCK_CODE = "0T";

    //TODO use a switch here.
    public Block constructBlock(String json) {
        BlockTypeIdentifier identifier = gson.fromJson(json, BlockTypeIdentifier.class);
        String type = identifier.getTypeCode();

        if (type.equals(TRANSPORT_BLOCK_CODE)) {
            return gson.fromJson(json, TransportBlock.class);
        }
        return null;
    }
}
