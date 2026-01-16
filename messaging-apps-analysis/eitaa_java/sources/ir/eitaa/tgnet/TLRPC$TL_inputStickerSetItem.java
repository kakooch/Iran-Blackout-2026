package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputStickerSetItem extends TLObject {
    public static int constructor = -6249322;
    public TLRPC$InputDocument document;
    public String emoji;
    public int flags;
    public TLRPC$TL_maskCoords mask_coords;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.document = TLRPC$InputDocument.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.emoji = stream.readString(exception);
        if ((this.flags & 1) != 0) {
            this.mask_coords = TLRPC$TL_maskCoords.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        this.document.serializeToStream(stream);
        stream.writeString(this.emoji);
        if ((this.flags & 1) != 0) {
            this.mask_coords.serializeToStream(stream);
        }
    }
}
