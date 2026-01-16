package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputFolderPeer extends TLObject {
    public static int constructor = -70073706;
    public int folder_id;
    public TLRPC$InputPeer peer;

    public static TLRPC$TL_inputFolderPeer TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_inputFolderPeer", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_inputFolderPeer tLRPC$TL_inputFolderPeer = new TLRPC$TL_inputFolderPeer();
        tLRPC$TL_inputFolderPeer.readParams(stream, exception);
        return tLRPC$TL_inputFolderPeer;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.peer = TLRPC$InputPeer.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.folder_id = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        stream.writeInt32(this.folder_id);
    }
}
