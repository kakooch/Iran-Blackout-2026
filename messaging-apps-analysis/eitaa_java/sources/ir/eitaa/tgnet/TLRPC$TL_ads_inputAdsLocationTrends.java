package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_ads_inputAdsLocationTrends extends TLRPC$Ads_Location {
    public static int constructor = 1557811792;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.groupTitle = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.groupTitle);
    }
}
