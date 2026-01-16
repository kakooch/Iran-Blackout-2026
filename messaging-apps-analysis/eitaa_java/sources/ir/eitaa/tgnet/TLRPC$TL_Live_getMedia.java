package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_Live_getMedia extends TLObject {
    public static int constructor = 1194436538;
    public long access_hash;
    public int flags;
    public long id;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$MessageMedia.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeInt64(this.id);
        stream.writeInt64(this.access_hash);
    }
}
