package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_pageBlockDetails extends TLRPC$PageBlock {
    public static int constructor = 1987480557;
    public ArrayList<TLRPC$PageBlock> blocks = new ArrayList<>();
    public int flags;
    public boolean open;
    public TLRPC$RichText title;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.open = (int32 & 1) != 0;
        int int322 = stream.readInt32(exception);
        if (int322 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
            return;
        }
        int int323 = stream.readInt32(exception);
        for (int i = 0; i < int323; i++) {
            TLRPC$PageBlock tLRPC$PageBlockTLdeserialize = TLRPC$PageBlock.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$PageBlockTLdeserialize == null) {
                return;
            }
            this.blocks.add(tLRPC$PageBlockTLdeserialize);
        }
        this.title = TLRPC$RichText.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.open ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        stream.writeInt32(481674261);
        int size = this.blocks.size();
        stream.writeInt32(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.blocks.get(i2).serializeToStream(stream);
        }
        this.title.serializeToStream(stream);
    }
}
