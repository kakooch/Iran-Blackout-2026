package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_stickerSet extends TLRPC$StickerSet {
    public static int constructor = -673242758;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.archived = (int32 & 2) != 0;
        this.official = (int32 & 4) != 0;
        this.masks = (int32 & 8) != 0;
        this.animated = (int32 & 32) != 0;
        if ((int32 & 1) != 0) {
            this.installed_date = abstractSerializedData.readInt32(z);
        }
        this.id = abstractSerializedData.readInt64(z);
        this.access_hash = abstractSerializedData.readInt64(z);
        this.title = abstractSerializedData.readString(z);
        this.short_name = abstractSerializedData.readString(z);
        if ((this.flags & 16) != 0) {
            int int322 = abstractSerializedData.readInt32(z);
            if (int322 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                }
                return;
            }
            int int323 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < int323; i++) {
                TLRPC$PhotoSize tLRPC$PhotoSizeTLdeserialize = TLRPC$PhotoSize.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (tLRPC$PhotoSizeTLdeserialize == null) {
                    return;
                }
                this.thumbs.add(tLRPC$PhotoSizeTLdeserialize);
            }
        }
        if ((this.flags & 16) != 0) {
            this.thumb_dc_id = abstractSerializedData.readInt32(z);
        }
        if ((this.flags & 16) != 0) {
            this.thumb_version = abstractSerializedData.readInt32(z);
        }
        this.count = abstractSerializedData.readInt32(z);
        this.hash = abstractSerializedData.readInt32(z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.archived ? this.flags | 2 : this.flags & (-3);
        this.flags = i;
        int i2 = this.official ? i | 4 : i & (-5);
        this.flags = i2;
        int i3 = this.masks ? i2 | 8 : i2 & (-9);
        this.flags = i3;
        int i4 = this.animated ? i3 | 32 : i3 & (-33);
        this.flags = i4;
        abstractSerializedData.writeInt32(i4);
        if ((this.flags & 1) != 0) {
            abstractSerializedData.writeInt32(this.installed_date);
        }
        abstractSerializedData.writeInt64(this.id);
        abstractSerializedData.writeInt64(this.access_hash);
        abstractSerializedData.writeString(this.title);
        abstractSerializedData.writeString(this.short_name);
        if ((this.flags & 16) != 0) {
            abstractSerializedData.writeInt32(481674261);
            int size = this.thumbs.size();
            abstractSerializedData.writeInt32(size);
            for (int i5 = 0; i5 < size; i5++) {
                this.thumbs.get(i5).serializeToStream(abstractSerializedData);
            }
        }
        if ((this.flags & 16) != 0) {
            abstractSerializedData.writeInt32(this.thumb_dc_id);
        }
        if ((this.flags & 16) != 0) {
            abstractSerializedData.writeInt32(this.thumb_version);
        }
        abstractSerializedData.writeInt32(this.count);
        abstractSerializedData.writeInt32(this.hash);
    }
}
