package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_pageCaption extends TLObject {
    public static int constructor = 1869903447;
    public TLRPC$RichText credit;
    public TLRPC$RichText text;

    public static TLRPC$TL_pageCaption TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_pageCaption", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_pageCaption tLRPC$TL_pageCaption = new TLRPC$TL_pageCaption();
        tLRPC$TL_pageCaption.readParams(stream, exception);
        return tLRPC$TL_pageCaption;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.text = TLRPC$RichText.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.credit = TLRPC$RichText.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.text.serializeToStream(stream);
        this.credit.serializeToStream(stream);
    }
}
