package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updatePeerSettings extends TLRPC$Update {
    public static int constructor = 1786671974;
    public TLRPC$Peer peer;
    public TLRPC$TL_peerSettings settings;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.peer = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.settings = TLRPC$TL_peerSettings.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        this.settings.serializeToStream(stream);
    }
}
