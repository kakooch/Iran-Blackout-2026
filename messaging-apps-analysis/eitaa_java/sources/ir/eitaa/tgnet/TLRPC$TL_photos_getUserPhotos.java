package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_photos_getUserPhotos extends TLObject {
    public static int constructor = -1848823128;
    public int limit;
    public long max_id;
    public int offset;
    public TLRPC$InputUser user_id;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$photos_Photos.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.user_id.serializeToStream(stream);
        stream.writeInt32(this.offset);
        stream.writeInt64(this.max_id);
        stream.writeInt32(this.limit);
    }
}
