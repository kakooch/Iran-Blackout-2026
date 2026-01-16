package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_getAuthorizationForm extends TLObject {
    public static int constructor = -1456907910;
    public long bot_id;
    public String public_key;
    public String scope;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_account_authorizationForm.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.bot_id);
        stream.writeString(this.scope);
        stream.writeString(this.public_key);
    }
}
