package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_GetCallOutAuthHash extends TLObject {
    public static int constructor = 2044603457;
    public String phone = "";

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (TLRPC$TL_UserPayHash.constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_GetPayHash", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_UserPayHash tLRPC$TL_UserPayHash = new TLRPC$TL_UserPayHash();
        tLRPC$TL_UserPayHash.readParams(stream, exception);
        return tLRPC$TL_UserPayHash;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.phone);
    }
}
