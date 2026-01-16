package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class TLRPC$messages_AvailableReactions extends TLObject {
    public static TLRPC$messages_AvailableReactions TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$messages_AvailableReactions tLRPC$messages_AvailableReactions;
        if (i == -1626924713) {
            tLRPC$messages_AvailableReactions = new TLRPC$messages_AvailableReactions() { // from class: org.rbmain.tgnet.TLRPC$TL_messages_availableReactionsNotModified
                public static int constructor = -1626924713;

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                }
            };
        } else {
            tLRPC$messages_AvailableReactions = i != 1989032621 ? null : new TLRPC$messages_AvailableReactions() { // from class: org.rbmain.tgnet.TLRPC$TL_messages_availableReactions
                public static int constructor = 1989032621;
                public int hash;
                public ArrayList<TLRPC$TL_availableReaction> reactions = new ArrayList<>();

                @Override // org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                    this.hash = abstractSerializedData2.readInt32(z2);
                    int int32 = abstractSerializedData2.readInt32(z2);
                    if (int32 != 481674261) {
                        if (z2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                        }
                        return;
                    }
                    int int322 = abstractSerializedData2.readInt32(z2);
                    for (int i2 = 0; i2 < int322; i2++) {
                        TLRPC$TL_availableReaction tLRPC$TL_availableReactionTLdeserialize = TLRPC$TL_availableReaction.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$TL_availableReactionTLdeserialize == null) {
                            return;
                        }
                        this.reactions.add(tLRPC$TL_availableReactionTLdeserialize);
                    }
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                    abstractSerializedData2.writeInt32(this.hash);
                    abstractSerializedData2.writeInt32(481674261);
                    int size = this.reactions.size();
                    abstractSerializedData2.writeInt32(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        this.reactions.get(i2).serializeToStream(abstractSerializedData2);
                    }
                }
            };
        }
        if (tLRPC$messages_AvailableReactions == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in messages_AvailableReactions", Integer.valueOf(i)));
        }
        if (tLRPC$messages_AvailableReactions != null) {
            tLRPC$messages_AvailableReactions.readParams(abstractSerializedData, z);
        }
        return tLRPC$messages_AvailableReactions;
    }
}
