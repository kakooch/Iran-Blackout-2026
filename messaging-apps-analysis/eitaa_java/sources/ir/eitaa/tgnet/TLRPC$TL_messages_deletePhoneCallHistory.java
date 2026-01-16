package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_deletePhoneCallHistory extends TLObject {
    public static int constructor = -104078327;
    public int flags;
    public boolean revoke;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_messages_affectedFoundMessages.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.revoke ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
    }
}
