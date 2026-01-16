package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_getChatThemes extends TLObject {
    public static int constructor = -690545285;
    public int hash;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$account_ChatThemes.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.hash);
    }
}
