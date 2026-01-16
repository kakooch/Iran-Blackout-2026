package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$messages_FeaturedStickers extends TLObject {
    public static TLRPC$messages_FeaturedStickers TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$messages_FeaturedStickers tLRPC$TL_messages_featuredStickers;
        if (constructor == -2067782896) {
            tLRPC$TL_messages_featuredStickers = new TLRPC$TL_messages_featuredStickers();
        } else {
            tLRPC$TL_messages_featuredStickers = constructor != -958657434 ? null : new TLRPC$messages_FeaturedStickers() { // from class: ir.eitaa.tgnet.TLRPC$TL_messages_featuredStickersNotModified
                public static int constructor = -958657434;
                public int count;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.count = stream2.readInt32(exception2);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeInt32(this.count);
                }
            };
        }
        if (tLRPC$TL_messages_featuredStickers == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in messages_FeaturedStickers", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_messages_featuredStickers != null) {
            tLRPC$TL_messages_featuredStickers.readParams(stream, exception);
        }
        return tLRPC$TL_messages_featuredStickers;
    }
}
