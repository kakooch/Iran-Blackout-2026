package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_pageBlockCollage extends TLRPC$PageBlock {
    public static int constructor = 1705048653;
    public TLRPC$TL_pageCaption caption;
    public ArrayList<TLRPC$PageBlock> items = new ArrayList<>();

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
            TLRPC$PageBlock tLRPC$PageBlockTLdeserialize = TLRPC$PageBlock.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$PageBlockTLdeserialize == null) {
                return;
            }
            this.items.add(tLRPC$PageBlockTLdeserialize);
        }
        this.caption = TLRPC$TL_pageCaption.TLdeserialize(stream, stream.readInt32(exception), exception);
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
        this.caption.serializeToStream(stream);
    }
}
