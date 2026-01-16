package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_messageReactions extends TLRPC$MessageReactions {
    public static int constructor = 1328256121;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.min = (int32 & 1) != 0;
        this.can_see_list = (int32 & 4) != 0;
        int int322 = abstractSerializedData.readInt32(z);
        if (int322 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
            return;
        }
        int int323 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int323; i++) {
            TLRPC$ReactionCount tLRPC$ReactionCountTLdeserialize = TLRPC$ReactionCount.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$ReactionCountTLdeserialize == null) {
                return;
            }
            this.results.add(tLRPC$ReactionCountTLdeserialize);
        }
        if ((this.flags & 2) != 0) {
            int int324 = abstractSerializedData.readInt32(z);
            if (int324 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
                }
                return;
            }
            int int325 = abstractSerializedData.readInt32(z);
            for (int i2 = 0; i2 < int325; i2++) {
                TLRPC$MessagePeerReaction tLRPC$MessagePeerReactionTLdeserialize = TLRPC$MessagePeerReaction.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (tLRPC$MessagePeerReactionTLdeserialize == null) {
                    return;
                }
                this.recent_reactions.add(tLRPC$MessagePeerReactionTLdeserialize);
            }
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.min ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.can_see_list ? i | 4 : i & (-5);
        this.flags = i2;
        abstractSerializedData.writeInt32(i2);
        abstractSerializedData.writeInt32(481674261);
        int size = this.results.size();
        abstractSerializedData.writeInt32(size);
        for (int i3 = 0; i3 < size; i3++) {
            this.results.get(i3).serializeToStream(abstractSerializedData);
        }
        if ((this.flags & 2) != 0) {
            abstractSerializedData.writeInt32(481674261);
            int size2 = this.recent_reactions.size();
            abstractSerializedData.writeInt32(size2);
            for (int i4 = 0; i4 < size2; i4++) {
                this.recent_reactions.get(i4).serializeToStream(abstractSerializedData);
            }
        }
    }
}
