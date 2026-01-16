package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputMediaGeoPoint extends TLRPC$InputMedia {
    public static int constructor = -104578748;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.geo_point = TLRPC$InputGeoPoint.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.geo_point.serializeToStream(stream);
    }
}
