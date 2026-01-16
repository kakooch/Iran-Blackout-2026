package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_peerBlocked extends TLObject {
    public static int constructor = -386039788;
    public int date;
    public TLRPC$Peer peer_id;

    public static TLRPC$TL_peerBlocked TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_peerBlocked", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_peerBlocked tLRPC$TL_peerBlocked = new TLRPC$TL_peerBlocked();
        tLRPC$TL_peerBlocked.readParams(stream, exception);
        return tLRPC$TL_peerBlocked;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.peer_id = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.date = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer_id.serializeToStream(stream);
        stream.writeInt32(this.date);
    }
}
