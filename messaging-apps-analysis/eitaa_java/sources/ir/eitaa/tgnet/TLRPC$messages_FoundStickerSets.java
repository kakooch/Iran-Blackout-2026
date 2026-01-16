package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$messages_FoundStickerSets extends TLObject {
    public static TLRPC$messages_FoundStickerSets TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$messages_FoundStickerSets tLRPC$TL_messages_foundStickerSets;
        if (constructor != -1963942446) {
            tLRPC$TL_messages_foundStickerSets = constructor != 223655517 ? null : new TLRPC$messages_FoundStickerSets() { // from class: ir.eitaa.tgnet.TLRPC$TL_messages_foundStickerSetsNotModified
                public static int constructor = 223655517;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                }
            };
        } else {
            tLRPC$TL_messages_foundStickerSets = new TLRPC$TL_messages_foundStickerSets();
        }
        if (tLRPC$TL_messages_foundStickerSets == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in messages_FoundStickerSets", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_messages_foundStickerSets != null) {
            tLRPC$TL_messages_foundStickerSets.readParams(stream, exception);
        }
        return tLRPC$TL_messages_foundStickerSets;
    }
}
