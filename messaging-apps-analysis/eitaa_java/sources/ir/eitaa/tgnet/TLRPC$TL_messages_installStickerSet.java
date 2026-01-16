package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_installStickerSet extends TLObject {
    public static int constructor = -946871200;
    public boolean archived;
    public TLRPC$InputStickerSet stickerset;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$messages_StickerSetInstallResult.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.stickerset.serializeToStream(stream);
        stream.writeBool(this.archived);
    }
}
