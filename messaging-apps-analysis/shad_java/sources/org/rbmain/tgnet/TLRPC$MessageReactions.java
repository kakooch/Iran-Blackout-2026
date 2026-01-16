package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class TLRPC$MessageReactions extends TLObject {
    public boolean can_see_list;
    public int flags;
    public boolean min;
    public ArrayList<TLRPC$ReactionCount> results = new ArrayList<>();
    public ArrayList<TLRPC$MessagePeerReaction> recent_reactions = new ArrayList<>();

    public static TLRPC$TL_messageReactions TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$TL_messageReactions tLRPC$TL_messageReactions;
        if (i == -1199954735) {
            tLRPC$TL_messageReactions = new TLRPC$TL_messageReactions() { // from class: org.rbmain.tgnet.TLRPC$TL_messageReactions_layer137
                public static int constructor = -1199954735;

                @Override // org.rbmain.tgnet.TLRPC$TL_messageReactions, org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                    int int32 = abstractSerializedData2.readInt32(z2);
                    this.flags = int32;
                    this.min = (int32 & 1) != 0;
                    int int322 = abstractSerializedData2.readInt32(z2);
                    if (int322 != 481674261) {
                        if (z2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                        }
                        return;
                    }
                    int int323 = abstractSerializedData2.readInt32(z2);
                    for (int i2 = 0; i2 < int323; i2++) {
                        TLRPC$ReactionCount tLRPC$ReactionCountTLdeserialize = TLRPC$ReactionCount.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$ReactionCountTLdeserialize == null) {
                            return;
                        }
                        this.results.add(tLRPC$ReactionCountTLdeserialize);
                    }
                }

                @Override // org.rbmain.tgnet.TLRPC$TL_messageReactions, org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                    int i2 = this.min ? this.flags | 1 : this.flags & (-2);
                    this.flags = i2;
                    abstractSerializedData2.writeInt32(i2);
                    abstractSerializedData2.writeInt32(481674261);
                    int size = this.results.size();
                    abstractSerializedData2.writeInt32(size);
                    for (int i3 = 0; i3 < size; i3++) {
                        this.results.get(i3).serializeToStream(abstractSerializedData2);
                    }
                }
            };
        } else if (i == 142306870) {
            tLRPC$TL_messageReactions = new TLRPC$TL_messageReactions() { // from class: org.rbmain.tgnet.TLRPC$TL_messageReactionsOld
                public static int constructor = 142306870;

                @Override // org.rbmain.tgnet.TLRPC$TL_messageReactions, org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                    int int32 = abstractSerializedData2.readInt32(z2);
                    this.flags = int32;
                    this.min = (int32 & 1) != 0;
                    this.can_see_list = (int32 & 4) != 0;
                    int int322 = abstractSerializedData2.readInt32(z2);
                    if (int322 != 481674261) {
                        if (z2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                        }
                        return;
                    }
                    int int323 = abstractSerializedData2.readInt32(z2);
                    for (int i2 = 0; i2 < int323; i2++) {
                        TLRPC$ReactionCount tLRPC$ReactionCountTLdeserialize = TLRPC$ReactionCount.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$ReactionCountTLdeserialize == null) {
                            return;
                        }
                        this.results.add(tLRPC$ReactionCountTLdeserialize);
                    }
                    if ((this.flags & 2) != 0) {
                        int int324 = abstractSerializedData2.readInt32(z2);
                        if (int324 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
                            }
                            return;
                        }
                        int int325 = abstractSerializedData2.readInt32(z2);
                        for (int i3 = 0; i3 < int325; i3++) {
                            TLRPC$MessagePeerReaction tLRPC$MessagePeerReactionTLdeserialize = TLRPC$MessagePeerReaction.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$MessagePeerReactionTLdeserialize == null) {
                                return;
                            }
                            this.recent_reactions.add(tLRPC$MessagePeerReactionTLdeserialize);
                        }
                    }
                }

                @Override // org.rbmain.tgnet.TLRPC$TL_messageReactions, org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                    int i2 = this.min ? this.flags | 1 : this.flags & (-2);
                    this.flags = i2;
                    int i3 = this.can_see_list ? i2 | 4 : i2 & (-5);
                    this.flags = i3;
                    abstractSerializedData2.writeInt32(i3);
                    abstractSerializedData2.writeInt32(481674261);
                    int size = this.results.size();
                    abstractSerializedData2.writeInt32(size);
                    for (int i4 = 0; i4 < size; i4++) {
                        this.results.get(i4).serializeToStream(abstractSerializedData2);
                    }
                    if ((this.flags & 2) != 0) {
                        abstractSerializedData2.writeInt32(481674261);
                        int size2 = this.recent_reactions.size();
                        abstractSerializedData2.writeInt32(size2);
                        for (int i5 = 0; i5 < size2; i5++) {
                            this.recent_reactions.get(i5).serializeToStream(abstractSerializedData2);
                        }
                    }
                }
            };
        } else {
            tLRPC$TL_messageReactions = i != 1328256121 ? null : new TLRPC$TL_messageReactions();
        }
        if (tLRPC$TL_messageReactions == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in MessageReactions", Integer.valueOf(i)));
        }
        if (tLRPC$TL_messageReactions != null) {
            tLRPC$TL_messageReactions.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_messageReactions;
    }
}
