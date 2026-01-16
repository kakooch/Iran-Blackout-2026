package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class TLRPC$messages_FavedStickers extends TLObject {
    public int hash;
    public ArrayList<TLRPC$TL_stickerPack> packs = new ArrayList<>();
    public ArrayList<TLRPC$Document> stickers = new ArrayList<>();

    public static TLRPC$messages_FavedStickers TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$messages_FavedStickers tLRPC$TL_messages_favedStickers;
        if (i == -1634752813) {
            tLRPC$TL_messages_favedStickers = new TLRPC$messages_FavedStickers() { // from class: org.rbmain.tgnet.TLRPC$TL_messages_favedStickersNotModified
                public static int constructor = -1634752813;

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                }
            };
        } else {
            tLRPC$TL_messages_favedStickers = i != -209768682 ? null : new TLRPC$TL_messages_favedStickers();
        }
        if (tLRPC$TL_messages_favedStickers == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in messages_FavedStickers", Integer.valueOf(i)));
        }
        if (tLRPC$TL_messages_favedStickers != null) {
            tLRPC$TL_messages_favedStickers.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_messages_favedStickers;
    }
}
