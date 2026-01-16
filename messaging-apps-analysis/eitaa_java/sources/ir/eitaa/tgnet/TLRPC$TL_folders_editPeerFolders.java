package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_folders_editPeerFolders extends TLObject {
    public static int constructor = 1749536939;
    public ArrayList<TLRPC$TL_inputFolderPeer> folder_peers = new ArrayList<>();

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
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
    }
}
