package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_pageBlockOrderedList extends TLRPC$PageBlock {
    public static int constructor = -1702174239;
    public ArrayList<TLRPC$PageListOrderedItem> items = new ArrayList<>();

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            TLRPC$PageListOrderedItem tLRPC$PageListOrderedItemTLdeserialize = TLRPC$PageListOrderedItem.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$PageListOrderedItemTLdeserialize == null) {
                return;
            }
            this.items.add(tLRPC$PageListOrderedItemTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(481674261);
        int size = this.items.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.items.get(i).serializeToStream(stream);
        }
    }
}
