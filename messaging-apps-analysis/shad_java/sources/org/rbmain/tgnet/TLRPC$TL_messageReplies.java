package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_messageReplies extends TLRPC$MessageReplies {
    public static int constructor = -2083123262;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.comments = (int32 & 1) != 0;
        this.replies = abstractSerializedData.readInt32(z);
        this.replies_pts = abstractSerializedData.readInt32(z);
        if ((this.flags & 2) != 0) {
            int int322 = abstractSerializedData.readInt32(z);
            if (int322 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                }
                return;
            }
            int int323 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < int323; i++) {
                TLRPC$Peer tLRPC$PeerTLdeserialize = TLRPC$Peer.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (tLRPC$PeerTLdeserialize == null) {
                    return;
                }
                this.recent_repliers.add(tLRPC$PeerTLdeserialize);
            }
        }
        if ((this.flags & 1) != 0) {
            this.channel_id = abstractSerializedData.readInt64(z);
        }
        if ((this.flags & 4) != 0) {
            this.max_id = abstractSerializedData.readInt32(z);
        }
        if ((this.flags & 8) != 0) {
            this.read_max_id = abstractSerializedData.readInt32(z);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.comments ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        abstractSerializedData.writeInt32(i);
        abstractSerializedData.writeInt32(this.replies);
        abstractSerializedData.writeInt32(this.replies_pts);
        if ((this.flags & 2) != 0) {
            abstractSerializedData.writeInt32(481674261);
            int size = this.recent_repliers.size();
            abstractSerializedData.writeInt32(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.recent_repliers.get(i2).serializeToStream(abstractSerializedData);
            }
        }
        if ((this.flags & 1) != 0) {
            abstractSerializedData.writeInt64(this.channel_id);
        }
        if ((this.flags & 4) != 0) {
            abstractSerializedData.writeInt64(this.max_id);
        }
        if ((this.flags & 8) != 0) {
            abstractSerializedData.writeInt64(this.read_max_id);
        }
    }
}
