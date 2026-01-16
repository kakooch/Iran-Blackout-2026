package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_EitaaCheckChatInvite extends TLRPC$TL_messages_checkChatInvite {
    public static int constructor = 507247221;
    public int flags;
    public String packageName;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$ChatInvite.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        if ((this.flags & 2) != 0) {
            stream.writeString(this.packageName);
        }
        stream.writeString(this.hash);
    }
}
