package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_stat_reportAdActionPerformed extends TLObject {
    public static int constructor = -1261786457;
    public TLRPC$TL_stat_ad statAd;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.statAd.serializeToStream(stream);
    }
}
