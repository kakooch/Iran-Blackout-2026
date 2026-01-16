package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputWebFileGeoPointLocation extends TLRPC$InputWebFileLocation {
    public static int constructor = -1625153079;
    public long access_hash;
    public TLRPC$InputGeoPoint geo_point;
    public int h;
    public int scale;
    public int w;
    public int zoom;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.geo_point = TLRPC$InputGeoPoint.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.access_hash = stream.readInt64(exception);
        this.w = stream.readInt32(exception);
        this.h = stream.readInt32(exception);
        this.zoom = stream.readInt32(exception);
        this.scale = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.geo_point.serializeToStream(stream);
        stream.writeInt64(this.access_hash);
        stream.writeInt32(this.w);
        stream.writeInt32(this.h);
        stream.writeInt32(this.zoom);
        stream.writeInt32(this.scale);
    }
}
