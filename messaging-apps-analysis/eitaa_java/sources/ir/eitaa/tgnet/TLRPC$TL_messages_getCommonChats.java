package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_getCommonChats extends TLObject {
    public static int constructor = -468934396;
    public int limit;
    public long max_id;
    public TLRPC$InputUser user_id;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$messages_Chats.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.user_id.serializeToStream(stream);
        stream.writeInt64(this.max_id);
        stream.writeInt32(this.limit);
    }
}
