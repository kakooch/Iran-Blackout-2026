package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_getPrivacy extends TLObject {
    public static int constructor = -623130288;
    public TLRPC$InputPrivacyKey key;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_account_privacyRules.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.key.serializeToStream(stream);
    }
}
