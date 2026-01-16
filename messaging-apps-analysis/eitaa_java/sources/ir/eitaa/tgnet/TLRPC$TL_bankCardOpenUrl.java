package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_bankCardOpenUrl extends TLObject {
    public static int constructor = -177732982;
    public String name;
    public String url;

    public static TLRPC$TL_bankCardOpenUrl TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_bankCardOpenUrl", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_bankCardOpenUrl tLRPC$TL_bankCardOpenUrl = new TLRPC$TL_bankCardOpenUrl();
        tLRPC$TL_bankCardOpenUrl.readParams(stream, exception);
        return tLRPC$TL_bankCardOpenUrl;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.url = stream.readString(exception);
        this.name = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.url);
        stream.writeString(this.name);
    }
}
