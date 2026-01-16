package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_topPeerCategoryPeers extends TLObject {
    public static int constructor = -75283823;
    public TLRPC$TopPeerCategory category;
    public int count;
    public ArrayList<TLRPC$TL_topPeer> peers = new ArrayList<>();

    public static TLRPC$TL_topPeerCategoryPeers TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_topPeerCategoryPeers", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_topPeerCategoryPeers tLRPC$TL_topPeerCategoryPeers = new TLRPC$TL_topPeerCategoryPeers();
        tLRPC$TL_topPeerCategoryPeers.readParams(stream, exception);
        return tLRPC$TL_topPeerCategoryPeers;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.category = TLRPC$TopPeerCategory.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.count = stream.readInt32(exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            TLRPC$TL_topPeer tLRPC$TL_topPeerTLdeserialize = TLRPC$TL_topPeer.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$TL_topPeerTLdeserialize == null) {
                return;
            }
            this.peers.add(tLRPC$TL_topPeerTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.category.serializeToStream(stream);
        stream.writeInt32(this.count);
        stream.writeInt32(481674261);
        int size = this.peers.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.peers.get(i).serializeToStream(stream);
        }
    }
}
