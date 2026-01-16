package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputMediaGeoLive extends TLRPC$InputMedia {
    public static int constructor = -1759532989;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.stopped = (int32 & 1) != 0;
        this.geo_point = TLRPC$InputGeoPoint.TLdeserialize(stream, stream.readInt32(exception), exception);
        if ((this.flags & 4) != 0) {
            this.heading = stream.readInt32(exception);
        }
        if ((this.flags & 2) != 0) {
            this.period = stream.readInt32(exception);
        }
        if ((this.flags & 8) != 0) {
            this.proximity_notification_radius = stream.readInt32(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.stopped ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        this.geo_point.serializeToStream(stream);
        if ((this.flags & 4) != 0) {
            stream.writeInt32(this.heading);
        }
        if ((this.flags & 2) != 0) {
            stream.writeInt32(this.period);
        }
        if ((this.flags & 8) != 0) {
            stream.writeInt32(this.proximity_notification_radius);
        }
    }
}
