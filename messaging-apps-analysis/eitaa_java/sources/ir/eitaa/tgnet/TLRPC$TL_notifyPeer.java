package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_notifyPeer extends TLRPC$NotifyPeer {
    public static int constructor = -1613493288;
    public TLRPC$Peer peer;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.peer = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
    }
}
