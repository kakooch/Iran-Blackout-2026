package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$messages_RecentStickers extends TLObject {
    public static TLRPC$messages_RecentStickers TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$messages_RecentStickers tLRPC$TL_messages_recentStickers;
        if (constructor == -1999405994) {
            tLRPC$TL_messages_recentStickers = new TLRPC$TL_messages_recentStickers();
        } else {
            tLRPC$TL_messages_recentStickers = constructor != 186120336 ? null : new TLRPC$messages_RecentStickers() { // from class: ir.eitaa.tgnet.TLRPC$TL_messages_recentStickersNotModified
                public static int constructor = 186120336;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                }
            };
        }
        if (tLRPC$TL_messages_recentStickers == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in messages_RecentStickers", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_messages_recentStickers != null) {
            tLRPC$TL_messages_recentStickers.readParams(stream, exception);
        }
        return tLRPC$TL_messages_recentStickers;
    }
}
