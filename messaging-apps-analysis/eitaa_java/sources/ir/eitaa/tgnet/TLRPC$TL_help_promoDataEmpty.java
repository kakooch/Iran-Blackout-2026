package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_help_promoDataEmpty extends TLRPC$help_PromoData {
    public static int constructor = -1728664459;
    public int expires;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.expires = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.expires);
    }
}
