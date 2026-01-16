package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$messages_Stickers extends TLObject {
    public static TLRPC$messages_Stickers TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$messages_Stickers tLRPC$TL_messages_stickers;
        if (constructor == -244016606) {
            tLRPC$TL_messages_stickers = new TLRPC$messages_Stickers() { // from class: ir.eitaa.tgnet.TLRPC$TL_messages_stickersNotModified
                public static int constructor = -244016606;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                }
            };
        } else {
            tLRPC$TL_messages_stickers = constructor != 816245886 ? null : new TLRPC$TL_messages_stickers();
        }
        if (tLRPC$TL_messages_stickers == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in messages_Stickers", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_messages_stickers != null) {
            tLRPC$TL_messages_stickers.readParams(stream, exception);
        }
        return tLRPC$TL_messages_stickers;
    }
}
