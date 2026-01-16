package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_stat_ad extends TLObject {
    public static int constructor = -1626620176;
    public int id;
    public TLRPC$Ads_Location location;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.id);
        this.location.serializeToStream(stream);
    }
}
