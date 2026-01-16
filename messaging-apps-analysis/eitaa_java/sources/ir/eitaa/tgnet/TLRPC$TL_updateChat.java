package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateChat extends TLRPC$Update {
    public static int constructor = -124097970;
    public long chat_id;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.chat_id = stream.readInt64(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.chat_id);
    }
}
