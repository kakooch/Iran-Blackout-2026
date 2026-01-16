package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputStickerSetThumb extends TLRPC$InputFileLocation {
    public static int constructor = -1652231205;
    public TLRPC$InputStickerSet stickerset;
    public int thumb_version;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.stickerset = TLRPC$InputStickerSet.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.thumb_version = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.stickerset.serializeToStream(stream);
        stream.writeInt32(this.thumb_version);
    }
}
