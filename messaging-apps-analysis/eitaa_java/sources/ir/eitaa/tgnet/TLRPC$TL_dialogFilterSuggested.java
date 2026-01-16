package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_dialogFilterSuggested extends TLObject {
    public static int constructor = 2004110666;
    public String description;
    public TLRPC$TL_dialogFilter filter;

    public static TLRPC$TL_dialogFilterSuggested TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_dialogFilterSuggested", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_dialogFilterSuggested tLRPC$TL_dialogFilterSuggested = new TLRPC$TL_dialogFilterSuggested();
        tLRPC$TL_dialogFilterSuggested.readParams(stream, exception);
        return tLRPC$TL_dialogFilterSuggested;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.filter = TLRPC$TL_dialogFilter.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.description = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.filter.serializeToStream(stream);
        stream.writeString(this.description);
    }
}
