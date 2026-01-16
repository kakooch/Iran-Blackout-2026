package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updatePeerHistoryTTL extends TLRPC$Update {
    public static int constructor = -1147422299;
    public int flags;
    public TLRPC$Peer peer;
    public int ttl_period;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.peer = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        if ((this.flags & 1) != 0) {
            this.ttl_period = stream.readInt32(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        this.peer.serializeToStream(stream);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(this.ttl_period);
        }
    }
}
