package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_emojiURL extends TLObject {
    public static int constructor = -1519029347;
    public String url;

    public static TLRPC$TL_emojiURL TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_emojiURL", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_emojiURL tLRPC$TL_emojiURL = new TLRPC$TL_emojiURL();
        tLRPC$TL_emojiURL.readParams(stream, exception);
        return tLRPC$TL_emojiURL;
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
