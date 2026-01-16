package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_getFeaturedStickers extends TLObject {
    public static int constructor = 1685588756;
    public long hash;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$messages_FeaturedStickers.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.hash);
    }
}
