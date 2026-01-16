package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_decryptedMessageMediaGeoPoint extends TLRPC$DecryptedMessageMedia {
    public static int constructor = 893913689;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.lat = stream.readDouble(exception);
        this._long = stream.readDouble(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeDouble(this.lat);
        stream.writeDouble(this._long);
    }
}
