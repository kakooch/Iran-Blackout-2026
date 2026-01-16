package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_searchStickerSets extends TLObject {
    public static int constructor = 896555914;
    public boolean exclude_featured;
    public int flags;
    public long hash;
    public String q;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$messages_FoundStickerSets.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.exclude_featured ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        stream.writeString(this.q);
        stream.writeInt64(this.hash);
    }
}
