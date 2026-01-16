package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messageActionGeoProximityReached extends TLRPC$MessageAction {
    public static int constructor = -1730095465;
    public int distance;
    public TLRPC$Peer from_id;
    public TLRPC$Peer to_id;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.from_id = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.to_id = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.distance = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.from_id.serializeToStream(stream);
        this.to_id.serializeToStream(stream);
        stream.writeInt32(this.distance);
    }
}
