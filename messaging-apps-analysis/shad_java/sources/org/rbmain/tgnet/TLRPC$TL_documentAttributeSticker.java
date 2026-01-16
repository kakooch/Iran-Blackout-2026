package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_documentAttributeSticker extends TLRPC$DocumentAttribute {
    public static int constructor = 1662637586;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.mask = (int32 & 2) != 0;
        this.alt = abstractSerializedData.readString(z);
        this.stickerset = TLRPC$InputStickerSet.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        if ((this.flags & 1) != 0) {
            this.mask_coords = TLRPC$TL_maskCoords.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.mask ? this.flags | 2 : this.flags & (-3);
        this.flags = i;
        abstractSerializedData.writeInt32(i);
        abstractSerializedData.writeString(this.alt);
        this.stickerset.serializeToStream(abstractSerializedData);
        if ((this.flags & 1) != 0) {
            this.mask_coords.serializeToStream(abstractSerializedData);
        }
    }
}
