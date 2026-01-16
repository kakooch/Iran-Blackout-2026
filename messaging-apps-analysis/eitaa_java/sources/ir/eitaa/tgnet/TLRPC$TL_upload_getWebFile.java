package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_upload_getWebFile extends TLObject {
    public static int constructor = 619086221;
    public int limit;
    public TLRPC$InputWebFileLocation location;
    public int offset;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_upload_webFile.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.location.serializeToStream(stream);
        stream.writeInt32(this.offset);
        stream.writeInt32(this.limit);
    }
}
