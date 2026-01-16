package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_mxbCreateUser extends TLObject {
    public static int constructor = -1091195032;
    public int messenger_id;
    public String phone;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        TLRPC$TL_mxbUser tLRPC$TL_mxbUser = new TLRPC$TL_mxbUser();
        tLRPC$TL_mxbUser.readParams(stream, exception);
        return tLRPC$TL_mxbUser;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.phone);
        stream.writeInt32(this.messenger_id);
    }
}
