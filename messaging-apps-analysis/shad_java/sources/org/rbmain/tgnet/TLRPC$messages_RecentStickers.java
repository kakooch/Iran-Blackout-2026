package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$messages_RecentStickers extends TLObject {
    public static TLRPC$messages_RecentStickers TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$messages_RecentStickers tLRPC$TL_messages_recentStickers;
        if (i != 186120336) {
            tLRPC$TL_messages_recentStickers = i != 586395571 ? null : new TLRPC$TL_messages_recentStickers();
        } else {
            tLRPC$TL_messages_recentStickers = new TLRPC$messages_RecentStickers() { // from class: org.rbmain.tgnet.TLRPC$TL_messages_recentStickersNotModified
                public static int constructor = 186120336;

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                }
            };
        }
        if (tLRPC$TL_messages_recentStickers == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in messages_RecentStickers", Integer.valueOf(i)));
        }
        if (tLRPC$TL_messages_recentStickers != null) {
            tLRPC$TL_messages_recentStickers.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_messages_recentStickers;
    }
}
