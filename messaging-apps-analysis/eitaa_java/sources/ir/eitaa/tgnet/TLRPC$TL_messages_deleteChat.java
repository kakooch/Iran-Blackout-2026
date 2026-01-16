package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_deleteChat extends TLObject {
    public static int constructor = 1540419152;
    public long chat_id;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.chat_id);
    }
}
