package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_peerLocated extends TLRPC$PeerLocated {
    public static int constructor = -901375139;
    public int distance;
    public int expires;
    public TLRPC$Peer peer;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.peer = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.expires = stream.readInt32(exception);
        this.distance = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        stream.writeInt32(this.expires);
        stream.writeInt32(this.distance);
    }
}
