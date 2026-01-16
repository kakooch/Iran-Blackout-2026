package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_documentAttributeSticker_layer55 extends TLRPC$TL_documentAttributeSticker {
    public static int constructor = 978674434;

    @Override // org.rbmain.tgnet.TLRPC$TL_documentAttributeSticker, org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.alt = abstractSerializedData.readString(z);
        this.stickerset = TLRPC$InputStickerSet.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.rbmain.tgnet.TLRPC$TL_documentAttributeSticker, org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.alt);
        this.stickerset.serializeToStream(abstractSerializedData);
    }
}
