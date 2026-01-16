package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_exportedMessageLink extends TLObject {
    public static int constructor = 524838915;
    public String link;

    public static TLRPC$TL_exportedMessageLink TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_exportedMessageLink", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_exportedMessageLink tLRPC$TL_exportedMessageLink = new TLRPC$TL_exportedMessageLink();
        tLRPC$TL_exportedMessageLink.readParams(stream, exception);
        return tLRPC$TL_exportedMessageLink;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.link = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.link);
    }
}
