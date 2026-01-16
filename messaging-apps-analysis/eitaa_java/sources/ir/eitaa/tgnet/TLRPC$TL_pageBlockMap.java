package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_pageBlockMap extends TLRPC$PageBlock {
    public static int constructor = -1538310410;
    public TLRPC$TL_pageCaption caption;
    public TLRPC$GeoPoint geo;
    public int h;
    public int w;
    public int zoom;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.geo = TLRPC$GeoPoint.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.zoom = stream.readInt32(exception);
        this.w = stream.readInt32(exception);
        this.h = stream.readInt32(exception);
        this.caption = TLRPC$TL_pageCaption.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.geo.serializeToStream(stream);
        stream.writeInt32(this.zoom);
        stream.writeInt32(this.w);
        stream.writeInt32(this.h);
        this.caption.serializeToStream(stream);
    }
}
