package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messageEmpty extends TLRPC$Message {
    public static int constructor = -1868117372;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.id = stream.readInt32(exception);
        if ((this.flags & 1) != 0) {
            this.peer_id = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        } else {
            this.peer_id = new TLRPC$TL_peerUser();
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeInt32(this.id);
        if ((this.flags & 1) != 0) {
            this.peer_id.serializeToStream(stream);
        }
    }
}
