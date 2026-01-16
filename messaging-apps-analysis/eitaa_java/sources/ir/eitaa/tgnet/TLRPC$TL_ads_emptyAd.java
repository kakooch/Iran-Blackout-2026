package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_ads_emptyAd extends TLRPC$Ads_Ad {
    public int expires;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.expires = stream.readInt32(exception);
    }
}
