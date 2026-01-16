package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_documentAttributeSticker extends TLRPC$DocumentAttribute {
    public static int constructor = 1662637586;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.mask = (int32 & 2) != 0;
        this.alt = stream.readString(exception);
        this.stickerset = TLRPC$InputStickerSet.TLdeserialize(stream, stream.readInt32(exception), exception);
        if ((this.flags & 1) != 0) {
            this.mask_coords = TLRPC$TL_maskCoords.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.mask ? this.flags | 2 : this.flags & (-3);
        this.flags = i;
        stream.writeInt32(i);
        stream.writeString(this.alt);
        this.stickerset.serializeToStream(stream);
        if ((this.flags & 1) != 0) {
            this.mask_coords.serializeToStream(stream);
        }
    }
}
