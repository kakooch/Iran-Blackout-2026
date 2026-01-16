package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_statsURL extends TLObject {
    public static int constructor = 1202287072;
    public String url;

    public static TLRPC$TL_statsURL TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_statsURL", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_statsURL tLRPC$TL_statsURL = new TLRPC$TL_statsURL();
        tLRPC$TL_statsURL.readParams(stream, exception);
        return tLRPC$TL_statsURL;
    }

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
