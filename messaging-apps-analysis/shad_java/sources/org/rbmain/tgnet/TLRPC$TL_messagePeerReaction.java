package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_messagePeerReaction extends TLRPC$MessagePeerReaction {
    public static int constructor = -1938180548;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.big = (int32 & 1) != 0;
        this.unread = (int32 & 2) != 0;
        this.peer_id = TLRPC$Peer.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.date = abstractSerializedData.readInt32(z);
        this.reaction = TLRPC$Reaction.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.big ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.unread ? i | 2 : i & (-3);
        this.flags = i2;
        abstractSerializedData.writeInt32(i2);
        this.peer_id.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(this.date);
        this.reaction.serializeToStream(abstractSerializedData);
    }
}
