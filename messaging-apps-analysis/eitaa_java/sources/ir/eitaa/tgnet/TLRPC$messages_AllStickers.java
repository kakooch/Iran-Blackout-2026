package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$messages_AllStickers extends TLObject {
    public ArrayList<TLRPC$StickerSet> sets = new ArrayList<>();
    public ArrayList<TLRPC$TL_stickerPack> packs = new ArrayList<>();
    public ArrayList<TLRPC$Document> documents = new ArrayList<>();

    public static TLRPC$messages_AllStickers TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$messages_AllStickers tLRPC$TL_messages_allStickers;
        if (constructor == -843329861) {
            tLRPC$TL_messages_allStickers = new TLRPC$TL_messages_allStickers();
        } else {
            tLRPC$TL_messages_allStickers = constructor != -395967805 ? null : new TLRPC$messages_AllStickers() { // from class: ir.eitaa.tgnet.TLRPC$TL_messages_allStickersNotModified
                public static int constructor = -395967805;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                }
            };
        }
        if (tLRPC$TL_messages_allStickers == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in messages_AllStickers", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_messages_allStickers != null) {
            tLRPC$TL_messages_allStickers.readParams(stream, exception);
        }
        return tLRPC$TL_messages_allStickers;
    }
}
