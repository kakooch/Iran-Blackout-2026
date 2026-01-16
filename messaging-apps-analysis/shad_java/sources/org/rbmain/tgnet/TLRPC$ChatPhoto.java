package org.rbmain.tgnet;

import android.graphics.drawable.BitmapDrawable;

/* loaded from: classes4.dex */
public abstract class TLRPC$ChatPhoto extends TLObject {
    public int dc_id;
    public int flags;
    public boolean has_video;
    public TLRPC$FileLocation photo_big;
    public TLRPC$FileLocation photo_small;
    public BitmapDrawable strippedBitmap;
    public byte[] stripped_thumb;

    public static TLRPC$ChatPhoto TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$ChatPhoto tLRPC$TL_chatPhotoEmpty;
        switch (i) {
            case -770990276:
                tLRPC$TL_chatPhotoEmpty = new TLRPC$TL_chatPhoto() { // from class: org.rbmain.tgnet.TLRPC$TL_chatPhoto_layer126
                    public static int constructor = -770990276;

                    @Override // org.rbmain.tgnet.TLRPC$TL_chatPhoto, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.has_video = (int32 & 1) != 0;
                        this.photo_small = TLRPC$FileLocation.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.photo_big = TLRPC$FileLocation.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.dc_id = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_chatPhoto, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.has_video ? this.flags | 1 : this.flags & (-2);
                        this.flags = i2;
                        abstractSerializedData2.writeInt32(i2);
                        this.photo_small.serializeToStream(abstractSerializedData2);
                        this.photo_big.serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32(this.dc_id);
                    }
                };
                break;
            case 935395612:
                tLRPC$TL_chatPhotoEmpty = new TLRPC$TL_chatPhotoEmpty();
                break;
            case 1197267925:
                tLRPC$TL_chatPhotoEmpty = new TLRPC$TL_chatPhoto() { // from class: org.rbmain.tgnet.TLRPC$TL_chatPhoto_layer115
                    public static int constructor = 1197267925;

                    @Override // org.rbmain.tgnet.TLRPC$TL_chatPhoto, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.photo_small = TLRPC$FileLocation.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.photo_big = TLRPC$FileLocation.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.dc_id = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_chatPhoto, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        this.photo_small.serializeToStream(abstractSerializedData2);
                        this.photo_big.serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32(this.dc_id);
                    }
                };
                break;
            case 1200680453:
                tLRPC$TL_chatPhotoEmpty = new TLRPC$TL_chatPhoto();
                break;
            case 1632839530:
                tLRPC$TL_chatPhotoEmpty = new TLRPC$TL_chatPhoto() { // from class: org.rbmain.tgnet.TLRPC$TL_chatPhoto_layer97
                    public static int constructor = 1632839530;

                    @Override // org.rbmain.tgnet.TLRPC$TL_chatPhoto, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.photo_small = TLRPC$FileLocation.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.photo_big = TLRPC$FileLocation.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_chatPhoto, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        this.photo_small.serializeToStream(abstractSerializedData2);
                        this.photo_big.serializeToStream(abstractSerializedData2);
                    }
                };
                break;
            default:
                tLRPC$TL_chatPhotoEmpty = null;
                break;
        }
        if (tLRPC$TL_chatPhotoEmpty == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in ChatPhoto", Integer.valueOf(i)));
        }
        if (tLRPC$TL_chatPhotoEmpty != null) {
            tLRPC$TL_chatPhotoEmpty.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_chatPhotoEmpty;
    }
}
