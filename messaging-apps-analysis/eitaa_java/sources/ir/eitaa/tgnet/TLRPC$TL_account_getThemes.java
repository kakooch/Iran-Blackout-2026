package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_getThemes extends TLObject {
    public static int constructor = 1913054296;
    public String format;
    public long hash;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$account_Themes.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.format);
        stream.writeInt64(this.hash);
    }
}
