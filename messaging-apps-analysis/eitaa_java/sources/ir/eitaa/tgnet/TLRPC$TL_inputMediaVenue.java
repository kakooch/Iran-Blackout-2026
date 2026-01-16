package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputMediaVenue extends TLRPC$InputMedia {
    public static int constructor = -1052959727;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.geo_point = TLRPC$InputGeoPoint.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.title = stream.readString(exception);
        this.address = stream.readString(exception);
        this.provider = stream.readString(exception);
        this.venue_id = stream.readString(exception);
        this.venue_type = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.geo_point.serializeToStream(stream);
        stream.writeString(this.title);
        stream.writeString(this.address);
        stream.writeString(this.provider);
        stream.writeString(this.venue_id);
        stream.writeString(this.venue_type);
    }
}
