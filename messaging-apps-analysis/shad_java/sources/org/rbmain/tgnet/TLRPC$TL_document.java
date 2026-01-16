package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_document extends TLRPC$Document {
    public static int constructor = 512177195;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.flags = abstractSerializedData.readInt32(z);
        this.id = abstractSerializedData.readInt64(z);
        this.access_hash = abstractSerializedData.readInt64(z);
        this.file_reference = abstractSerializedData.readByteArray(z);
        this.date = abstractSerializedData.readInt32(z);
        this.mime_type = abstractSerializedData.readString(z);
        this.size = abstractSerializedData.readInt32(z);
        if ((this.flags & 1) != 0) {
            int int32 = abstractSerializedData.readInt32(z);
            if (int32 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                }
                return;
            }
            int int322 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < int322; i++) {
                TLRPC$PhotoSize tLRPC$PhotoSizeTLdeserialize = TLRPC$PhotoSize.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (tLRPC$PhotoSizeTLdeserialize == null) {
                    return;
                }
                this.thumbs.add(tLRPC$PhotoSizeTLdeserialize);
            }
        }
        if ((this.flags & 2) != 0) {
            int int323 = abstractSerializedData.readInt32(z);
            if (int323 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
                }
                return;
            }
            int int324 = abstractSerializedData.readInt32(z);
            for (int i2 = 0; i2 < int324; i2++) {
                TLRPC$VideoSize tLRPC$VideoSizeTLdeserialize = TLRPC$VideoSize.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (tLRPC$VideoSizeTLdeserialize == null) {
                    return;
                }
                this.video_thumbs.add(tLRPC$VideoSizeTLdeserialize);
            }
        }
        this.dc_id = abstractSerializedData.readInt32(z);
        int int325 = abstractSerializedData.readInt32(z);
        if (int325 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int325)));
            }
            return;
        }
        int int326 = abstractSerializedData.readInt32(z);
        for (int i3 = 0; i3 < int326; i3++) {
            TLRPC$DocumentAttribute tLRPC$DocumentAttributeTLdeserialize = TLRPC$DocumentAttribute.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$DocumentAttributeTLdeserialize == null) {
                return;
            }
            this.attributes.add(tLRPC$DocumentAttributeTLdeserialize);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.flags);
        abstractSerializedData.writeInt64(this.id);
        abstractSerializedData.writeInt64(this.access_hash);
        abstractSerializedData.writeByteArray(this.file_reference);
        abstractSerializedData.writeInt32(this.date);
        abstractSerializedData.writeString(this.mime_type);
        abstractSerializedData.writeInt32(this.size);
        if ((this.flags & 1) != 0) {
            abstractSerializedData.writeInt32(481674261);
            int size = this.thumbs.size();
            abstractSerializedData.writeInt32(size);
            for (int i = 0; i < size; i++) {
                this.thumbs.get(i).serializeToStream(abstractSerializedData);
            }
        }
        if ((this.flags & 2) != 0) {
            abstractSerializedData.writeInt32(481674261);
            int size2 = this.video_thumbs.size();
            abstractSerializedData.writeInt32(size2);
            for (int i2 = 0; i2 < size2; i2++) {
                this.video_thumbs.get(i2).serializeToStream(abstractSerializedData);
            }
        }
        abstractSerializedData.writeInt32(this.dc_id);
        abstractSerializedData.writeInt32(481674261);
        int size3 = this.attributes.size();
        abstractSerializedData.writeInt32(size3);
        for (int i3 = 0; i3 < size3; i3++) {
            this.attributes.get(i3).serializeToStream(abstractSerializedData);
        }
    }
}
