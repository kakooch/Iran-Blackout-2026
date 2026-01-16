package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_uploadTheme extends TLObject {
    public static int constructor = 473805619;
    public TLRPC$InputFile file;
    public String file_name;
    public int flags;
    public String mime_type;
    public TLRPC$InputFile thumb;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Document.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        this.file.serializeToStream(stream);
        if ((this.flags & 1) != 0) {
            this.thumb.serializeToStream(stream);
        }
        stream.writeString(this.file_name);
        stream.writeString(this.mime_type);
    }
}
