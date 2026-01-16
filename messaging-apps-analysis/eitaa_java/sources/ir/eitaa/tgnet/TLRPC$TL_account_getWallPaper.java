package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_getWallPaper extends TLObject {
    public static int constructor = -57811990;
    public TLRPC$InputWallPaper wallpaper;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$WallPaper.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.wallpaper.serializeToStream(stream);
    }
}
