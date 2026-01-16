package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_ads_inputAdsLocationDialog extends TLRPC$Ads_Location {
    public static int constructor = 314488883;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
