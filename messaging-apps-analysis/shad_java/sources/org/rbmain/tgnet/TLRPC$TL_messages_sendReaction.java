package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_sendReaction extends TLObject {
    public static int constructor = 627641572;
    public boolean add_to_recent;
    public boolean big;
    public int flags;
    public long msg_id;
    public TLRPC$InputPeer peer;
    public ArrayList<TLRPC$Reaction> reaction = new ArrayList<>();
    public String reactionId;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Updates.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.big ? this.flags | 2 : this.flags & (-3);
        this.flags = i;
        int i2 = this.add_to_recent ? i | 4 : i & (-5);
        this.flags = i2;
        abstractSerializedData.writeInt32(i2);
        this.peer.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt64(this.msg_id);
        if ((this.flags & 1) != 0) {
            abstractSerializedData.writeInt32(481674261);
            int size = this.reaction.size();
            abstractSerializedData.writeInt32(size);
            for (int i3 = 0; i3 < size; i3++) {
                this.reaction.get(i3).serializeToStream(abstractSerializedData);
            }
        }
    }
}
