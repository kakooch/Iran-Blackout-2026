package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_urlAuthResultAccepted extends TLRPC$UrlAuthResult {
    public static int constructor = -1886646706;
    public String url;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.url = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.url);
    }
}
