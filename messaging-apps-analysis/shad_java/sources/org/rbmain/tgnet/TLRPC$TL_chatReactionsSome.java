package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_chatReactionsSome extends TLRPC$ChatReactions {
    public static int constructor = 1713193015;
    public ArrayList<TLRPC$Reaction> reactions = new ArrayList<>();

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        if (int32 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int322; i++) {
            TLRPC$Reaction tLRPC$ReactionTLdeserialize = TLRPC$Reaction.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$ReactionTLdeserialize == null) {
                return;
            }
            this.reactions.add(tLRPC$ReactionTLdeserialize);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(481674261);
        int size = this.reactions.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.reactions.get(i).serializeToStream(abstractSerializedData);
        }
    }
}
