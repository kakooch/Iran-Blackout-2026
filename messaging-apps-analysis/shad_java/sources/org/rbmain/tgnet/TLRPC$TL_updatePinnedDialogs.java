package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_updatePinnedDialogs extends TLRPC$Update {
    public static int constructor = -99664734;
    public int flags;
    public int folder_id;
    public ArrayList<TLRPC$DialogPeer> order = new ArrayList<>();

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        if ((int32 & 2) != 0) {
            this.folder_id = abstractSerializedData.readInt32(z);
        }
        if ((this.flags & 1) != 0) {
            int int322 = abstractSerializedData.readInt32(z);
            if (int322 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                }
                return;
            }
            int int323 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < int323; i++) {
                TLRPC$DialogPeer tLRPC$DialogPeerTLdeserialize = TLRPC$DialogPeer.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (tLRPC$DialogPeerTLdeserialize == null) {
                    return;
                }
                this.order.add(tLRPC$DialogPeerTLdeserialize);
            }
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.flags);
        if ((this.flags & 2) != 0) {
            abstractSerializedData.writeInt32(this.folder_id);
        }
        if ((this.flags & 1) != 0) {
            abstractSerializedData.writeInt32(481674261);
            int size = this.order.size();
            abstractSerializedData.writeInt32(size);
            for (int i = 0; i < size; i++) {
                this.order.get(i).serializeToStream(abstractSerializedData);
            }
        }
    }
}
