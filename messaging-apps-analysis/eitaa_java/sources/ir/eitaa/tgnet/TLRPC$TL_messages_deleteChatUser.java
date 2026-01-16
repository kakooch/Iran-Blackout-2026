package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_deleteChatUser extends TLObject {
    public static int constructor = -1575461717;
    public long chat_id;
    public int flags;
    public boolean revoke_history;
    public TLRPC$InputUser user_id;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.revoke_history ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        stream.writeInt64(this.chat_id);
        this.user_id.serializeToStream(stream);
    }
}
