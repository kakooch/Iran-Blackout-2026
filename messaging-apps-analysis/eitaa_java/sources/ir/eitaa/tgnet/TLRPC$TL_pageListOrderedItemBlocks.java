package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_pageListOrderedItemBlocks extends TLRPC$PageListOrderedItem {
    public static int constructor = -1730311882;
    public ArrayList<TLRPC$PageBlock> blocks = new ArrayList<>();
    public String num;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.num = stream.readString(exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            TLRPC$PageBlock tLRPC$PageBlockTLdeserialize = TLRPC$PageBlock.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$PageBlockTLdeserialize == null) {
                return;
            }
            this.blocks.add(tLRPC$PageBlockTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.num);
        stream.writeInt32(481674261);
        int size = this.blocks.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.blocks.get(i).serializeToStream(stream);
        }
    }
}
