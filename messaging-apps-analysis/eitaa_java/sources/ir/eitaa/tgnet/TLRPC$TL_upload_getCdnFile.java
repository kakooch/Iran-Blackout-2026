package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_upload_getCdnFile extends TLObject {
    public static int constructor = 536919235;
    public byte[] file_token;
    public int limit;
    public int offset;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$upload_CdnFile.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeByteArray(this.file_token);
        stream.writeInt32(this.offset);
        stream.writeInt32(this.limit);
    }
}
