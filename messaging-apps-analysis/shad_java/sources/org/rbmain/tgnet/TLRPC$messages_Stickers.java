package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$messages_Stickers extends TLObject {
    public static TLRPC$messages_Stickers TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$messages_Stickers tLRPC$TL_messages_stickers;
        if (i != -463889475) {
            tLRPC$TL_messages_stickers = i != -244016606 ? null : new TLRPC$messages_Stickers() { // from class: org.rbmain.tgnet.TLRPC$TL_messages_stickersNotModified
                public static int constructor = -244016606;

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                }
            };
        } else {
            tLRPC$TL_messages_stickers = new TLRPC$TL_messages_stickers();
        }
        if (tLRPC$TL_messages_stickers == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in messages_Stickers", Integer.valueOf(i)));
        }
        if (tLRPC$TL_messages_stickers != null) {
            tLRPC$TL_messages_stickers.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_messages_stickers;
    }
}
