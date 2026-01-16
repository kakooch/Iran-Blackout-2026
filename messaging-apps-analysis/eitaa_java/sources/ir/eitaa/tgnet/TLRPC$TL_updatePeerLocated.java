package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_updatePeerLocated extends TLRPC$Update {
    public static int constructor = -1263546448;
    public ArrayList<TLRPC$PeerLocated> peers = new ArrayList<>();

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
            TLRPC$PeerLocated tLRPC$PeerLocatedTLdeserialize = TLRPC$PeerLocated.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$PeerLocatedTLdeserialize == null) {
                return;
            }
            this.peers.add(tLRPC$PeerLocatedTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(481674261);
        int size = this.peers.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.peers.get(i).serializeToStream(stream);
        }
    }
}
