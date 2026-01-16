package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_upload_getFile extends TLObject {
    public static int constructor = -1319462148;
    public boolean cdn_supported;
    public int flags;
    public int limit;
    public TLRPC$InputFileLocation location;
    public int offset;
    public boolean precise;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$upload_File.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.precise ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.cdn_supported ? i | 2 : i & (-3);
        this.flags = i2;
        stream.writeInt32(i2);
        this.location.serializeToStream(stream);
        stream.writeInt32(this.offset);
        stream.writeInt32(this.limit);
    }
}
