package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channels_setStickers extends TLObject {
    public static int constructor = -359881479;
    public TLRPC$InputChannel channel;
    public TLRPC$InputStickerSet stickerset;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.channel.serializeToStream(stream);
        this.stickerset.serializeToStream(stream);
    }
}
