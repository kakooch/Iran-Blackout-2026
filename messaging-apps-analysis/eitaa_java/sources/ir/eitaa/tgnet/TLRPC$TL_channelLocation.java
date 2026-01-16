package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channelLocation extends TLRPC$ChannelLocation {
    public static int constructor = 547062491;
    public String address;
    public TLRPC$GeoPoint geo_point;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.geo_point = TLRPC$GeoPoint.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.address = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.geo_point.serializeToStream(stream);
        stream.writeString(this.address);
    }
}
