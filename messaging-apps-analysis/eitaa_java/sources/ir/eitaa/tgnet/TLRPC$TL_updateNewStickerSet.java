package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateNewStickerSet extends TLRPC$Update {
    public static int constructor = 1753886890;
    public TLRPC$TL_messages_stickerSet stickerset;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.stickerset = TLRPC$TL_messages_stickerSet.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.stickerset.serializeToStream(stream);
    }
}
