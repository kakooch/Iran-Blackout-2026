package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_readFeaturedStickers extends TLObject {
    public static int constructor = 1527873830;
    public ArrayList<Long> id = new ArrayList<>();

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(481674261);
        int size = this.id.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            stream.writeInt64(this.id.get(i).longValue());
        }
    }
}
