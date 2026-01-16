package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_updateStickerSetsOrder extends TLRPC$Update {
    public static int constructor = 196268545;
    public int flags;
    public boolean masks;
    public ArrayList<Long> order = new ArrayList<>();

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.masks = (int32 & 1) != 0;
        int int322 = stream.readInt32(exception);
        if (int322 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
        } else {
            int int323 = stream.readInt32(exception);
            for (int i = 0; i < int323; i++) {
                this.order.add(Long.valueOf(stream.readInt64(exception)));
            }
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.masks ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        stream.writeInt32(481674261);
        int size = this.order.size();
        stream.writeInt32(size);
        for (int i2 = 0; i2 < size; i2++) {
            stream.writeInt64(this.order.get(i2).longValue());
        }
    }
}
