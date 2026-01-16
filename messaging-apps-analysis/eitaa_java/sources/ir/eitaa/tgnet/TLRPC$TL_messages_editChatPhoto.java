package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_editChatPhoto extends TLObject {
    public static int constructor = 903730804;
    public long chat_id;
    public TLRPC$InputChatPhoto photo;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.chat_id);
        this.photo.serializeToStream(stream);
    }
}
