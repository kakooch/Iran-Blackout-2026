package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_topPeerCategoryPeers extends TLObject {
    public static int constructor = -75283823;
    public TLRPC$TopPeerCategory category;
    public int count;
    public ArrayList<TLRPC$TL_topPeer> peers = new ArrayList<>();

    public static TLRPC$TL_topPeerCategoryPeers TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        if (constructor != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_topPeerCategoryPeers", Integer.valueOf(i)));
            }
            return null;
        }
        TLRPC$TL_topPeerCategoryPeers tLRPC$TL_topPeerCategoryPeers = new TLRPC$TL_topPeerCategoryPeers();
        tLRPC$TL_topPeerCategoryPeers.readParams(abstractSerializedData, z);
        return tLRPC$TL_topPeerCategoryPeers;
    }

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.category = TLRPC$TopPeerCategory.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.count = abstractSerializedData.readInt32(z);
        int int32 = abstractSerializedData.readInt32(z);
        if (int32 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int322; i++) {
            TLRPC$TL_topPeer tLRPC$TL_topPeerTLdeserialize = TLRPC$TL_topPeer.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$TL_topPeerTLdeserialize == null) {
                return;
            }
            this.peers.add(tLRPC$TL_topPeerTLdeserialize);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.category.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(this.count);
        abstractSerializedData.writeInt32(481674261);
        int size = this.peers.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.peers.get(i).serializeToStream(abstractSerializedData);
        }
    }
}
