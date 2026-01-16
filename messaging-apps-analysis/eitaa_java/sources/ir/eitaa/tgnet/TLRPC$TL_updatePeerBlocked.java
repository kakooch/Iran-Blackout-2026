package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updatePeerBlocked extends TLRPC$Update {
    public static int constructor = 610945826;
    public boolean blocked;
    public TLRPC$Peer peer_id;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.peer_id = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.blocked = stream.readBool(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer_id.serializeToStream(stream);
        stream.writeBool(this.blocked);
    }
}
