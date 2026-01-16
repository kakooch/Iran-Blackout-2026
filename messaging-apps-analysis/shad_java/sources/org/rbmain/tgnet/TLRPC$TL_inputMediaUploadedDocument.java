package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_inputMediaUploadedDocument extends TLRPC$InputMedia {
    public static int constructor = 1530447553;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.nosound_video = (int32 & 8) != 0;
        this.force_file = (int32 & 16) != 0;
        this.file = TLRPC$InputFile.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        if ((this.flags & 4) != 0) {
            this.thumb = TLRPC$InputFile.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
        this.mime_type = abstractSerializedData.readString(z);
        int int322 = abstractSerializedData.readInt32(z);
        if (int322 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
            return;
        }
        int int323 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int323; i++) {
            TLRPC$DocumentAttribute tLRPC$DocumentAttributeTLdeserialize = TLRPC$DocumentAttribute.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$DocumentAttributeTLdeserialize == null) {
                return;
            }
            this.attributes.add(tLRPC$DocumentAttributeTLdeserialize);
        }
        if ((this.flags & 1) != 0) {
            int int324 = abstractSerializedData.readInt32(z);
            if (int324 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
                }
                return;
            }
            int int325 = abstractSerializedData.readInt32(z);
            for (int i2 = 0; i2 < int325; i2++) {
                TLRPC$InputDocument tLRPC$InputDocumentTLdeserialize = TLRPC$InputDocument.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (tLRPC$InputDocumentTLdeserialize == null) {
                    return;
                }
                this.stickers.add(tLRPC$InputDocumentTLdeserialize);
            }
        }
        if ((this.flags & 2) != 0) {
            this.ttl_seconds = abstractSerializedData.readInt32(z);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.nosound_video ? this.flags | 8 : this.flags & (-9);
        this.flags = i;
        int i2 = this.force_file ? i | 16 : i & (-17);
        this.flags = i2;
        abstractSerializedData.writeInt32(i2);
        this.file.serializeToStream(abstractSerializedData);
        if ((this.flags & 4) != 0) {
            this.thumb.serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeString(this.mime_type);
        abstractSerializedData.writeInt32(481674261);
        int size = this.attributes.size();
        abstractSerializedData.writeInt32(size);
        for (int i3 = 0; i3 < size; i3++) {
            this.attributes.get(i3).serializeToStream(abstractSerializedData);
        }
        if ((this.flags & 1) != 0) {
            abstractSerializedData.writeInt32(481674261);
            int size2 = this.stickers.size();
            abstractSerializedData.writeInt32(size2);
            for (int i4 = 0; i4 < size2; i4++) {
                this.stickers.get(i4).serializeToStream(abstractSerializedData);
            }
        }
        if ((this.flags & 2) != 0) {
            abstractSerializedData.writeInt32(this.ttl_seconds);
        }
    }
}
