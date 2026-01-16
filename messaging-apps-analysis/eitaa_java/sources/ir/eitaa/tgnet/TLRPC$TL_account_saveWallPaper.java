package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_saveWallPaper extends TLObject {
    public static int constructor = 1817860919;
    public TLRPC$TL_wallPaperSettings settings;
    public boolean unsave;
    public TLRPC$InputWallPaper wallpaper;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.wallpaper.serializeToStream(stream);
        stream.writeBool(this.unsave);
        this.settings.serializeToStream(stream);
    }
}
