package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_folderPeer extends TLObject {
    public static int constructor = -373643672;
    public int folder_id;
    public TLRPC$Peer peer;

    public static TLRPC$TL_folderPeer TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_folderPeer", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_folderPeer tLRPC$TL_folderPeer = new TLRPC$TL_folderPeer();
        tLRPC$TL_folderPeer.readParams(stream, exception);
        return tLRPC$TL_folderPeer;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.peer = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.folder_id = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        stream.writeInt32(this.folder_id);
    }
}
