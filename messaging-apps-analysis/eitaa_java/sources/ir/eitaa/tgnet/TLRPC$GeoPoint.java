package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$GeoPoint extends TLObject {
    public double _long;
    public long access_hash;
    public int accuracy_radius;
    public int flags;
    public double lat;

    public static TLRPC$GeoPoint TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$GeoPoint tLRPC$TL_geoPoint;
        switch (constructor) {
            case -1297942941:
                tLRPC$TL_geoPoint = new TLRPC$TL_geoPoint();
                break;
            case 43446532:
                tLRPC$TL_geoPoint = new TLRPC$TL_geoPoint() { // from class: ir.eitaa.tgnet.TLRPC$TL_geoPoint_layer119
                    public static int constructor = 43446532;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_geoPoint, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this._long = stream2.readDouble(exception2);
                        this.lat = stream2.readDouble(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_geoPoint, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeDouble(this._long);
                        stream2.writeDouble(this.lat);
                        stream2.writeInt64(this.access_hash);
                    }
                };
                break;
            case 286776671:
                tLRPC$TL_geoPoint = new TLRPC$GeoPoint() { // from class: ir.eitaa.tgnet.TLRPC$TL_geoPointEmpty
                    public static int constructor = 286776671;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case 541710092:
                tLRPC$TL_geoPoint = new TLRPC$TL_geoPoint() { // from class: ir.eitaa.tgnet.TLRPC$TL_geoPoint_layer81
                    public static int constructor = 541710092;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_geoPoint, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this._long = stream2.readDouble(exception2);
                        this.lat = stream2.readDouble(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_geoPoint, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeDouble(this._long);
                        stream2.writeDouble(this.lat);
                    }
                };
                break;
            default:
                tLRPC$TL_geoPoint = null;
                break;
        }
        if (tLRPC$TL_geoPoint == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in GeoPoint", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_geoPoint != null) {
            tLRPC$TL_geoPoint.readParams(stream, exception);
        }
        return tLRPC$TL_geoPoint;
    }
}
