package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_phone_requestCall extends TLObject {
    public static int constructor = 1124046573;
    public int flags;
    public byte[] g_a_hash;
    public TLRPC$TL_phoneCallProtocol protocol;
    public int random_id;
    public TLRPC$InputUser user_id;
    public boolean video;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_phone_phoneCall.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.video ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        this.user_id.serializeToStream(stream);
        stream.writeInt32(this.random_id);
        stream.writeByteArray(this.g_a_hash);
        this.protocol.serializeToStream(stream);
    }
}
