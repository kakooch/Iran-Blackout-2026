package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_reorderStickerSets extends TLObject {
    public static int constructor = 2016638777;
    public int flags;
    public boolean masks;
    public ArrayList<Long> order = new ArrayList<>();

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
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
