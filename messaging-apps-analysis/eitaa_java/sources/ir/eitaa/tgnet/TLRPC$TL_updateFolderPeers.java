package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_updateFolderPeers extends TLRPC$Update {
    public static int constructor = 422972864;
    public ArrayList<TLRPC$TL_folderPeer> folder_peers = new ArrayList<>();
    public int pts;
    public int pts_count;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            TLRPC$TL_folderPeer tLRPC$TL_folderPeerTLdeserialize = TLRPC$TL_folderPeer.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$TL_folderPeerTLdeserialize == null) {
                return;
            }
            this.folder_peers.add(tLRPC$TL_folderPeerTLdeserialize);
        }
        this.pts = stream.readInt32(exception);
        this.pts_count = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(481674261);
        int size = this.folder_peers.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.folder_peers.get(i).serializeToStream(stream);
        }
        stream.writeInt32(this.pts);
        stream.writeInt32(this.pts_count);
    }
}
