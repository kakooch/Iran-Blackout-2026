package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_uninstallStickerSet extends TLObject {
    public static int constructor = -110209570;
    public TLRPC$InputStickerSet stickerset;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.stickerset.serializeToStream(stream);
    }
}
