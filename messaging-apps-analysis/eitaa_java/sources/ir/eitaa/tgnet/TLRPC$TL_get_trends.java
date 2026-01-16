package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_get_trends extends TLObject {
    public static int constructor = 257659321;
    public String lang = "en";

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_updateTrends.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.lang);
    }
}
