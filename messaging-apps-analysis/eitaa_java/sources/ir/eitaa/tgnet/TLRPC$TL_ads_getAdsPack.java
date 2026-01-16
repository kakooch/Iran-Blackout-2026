package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_ads_getAdsPack extends TLObject {
    public static int constructor = 950734118;
    public int flags;
    public TLRPC$Ads_Location location;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_ads_AdPack.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        this.location.serializeToStream(stream);
    }
}
