package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_editChatAdmin extends TLObject {
    public static int constructor = -1470377534;
    public long chat_id;
    public boolean is_admin;
    public TLRPC$InputUser user_id;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.chat_id);
        this.user_id.serializeToStream(stream);
        stream.writeBool(this.is_admin);
    }
}
