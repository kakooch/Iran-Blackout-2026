package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$messages_Reactions extends TLObject {
    public static TLRPC$messages_Reactions TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$messages_Reactions tLRPC$TL_messages_reactions;
        if (i == -1334846497) {
            tLRPC$TL_messages_reactions = new TLRPC$messages_Reactions() { // from class: org.rbmain.tgnet.TLRPC$TL_messages_reactionsNotModified
                public static int constructor = -1334846497;

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                }
            };
        } else {
            tLRPC$TL_messages_reactions = i != -352454890 ? null : new TLRPC$TL_messages_reactions();
        }
        if (tLRPC$TL_messages_reactions == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in messages_Reactions", Integer.valueOf(i)));
        }
        if (tLRPC$TL_messages_reactions != null) {
            tLRPC$TL_messages_reactions.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_messages_reactions;
    }
}
