package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_geoPoint extends TLRPC$GeoPoint {
    public static int constructor = -1297942941;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this._long = stream.readDouble(exception);
        this.lat = stream.readDouble(exception);
        this.access_hash = stream.readInt64(exception);
        if ((this.flags & 1) != 0) {
            this.accuracy_radius = stream.readInt32(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeDouble(this._long);
        stream.writeDouble(this.lat);
        stream.writeInt64(this.access_hash);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(this.accuracy_radius);
        }
    }
}
