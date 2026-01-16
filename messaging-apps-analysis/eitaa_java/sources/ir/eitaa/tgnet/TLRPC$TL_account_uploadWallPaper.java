package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_uploadWallPaper extends TLObject {
    public static int constructor = -578472351;
    public TLRPC$InputFile file;
    public String mime_type;
    public TLRPC$TL_wallPaperSettings settings;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$WallPaper.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.file.serializeToStream(stream);
        stream.writeString(this.mime_type);
        this.settings.serializeToStream(stream);
    }
}
