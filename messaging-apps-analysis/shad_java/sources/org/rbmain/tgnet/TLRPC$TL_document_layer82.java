package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_document_layer82 extends TLRPC$TL_document {
    public static int constructor = -2027738169;

    @Override // org.rbmain.tgnet.TLRPC$TL_document, org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.id = abstractSerializedData.readInt64(z);
        this.access_hash = abstractSerializedData.readInt64(z);
        this.date = abstractSerializedData.readInt32(z);
        this.mime_type = abstractSerializedData.readString(z);
        this.size = abstractSerializedData.readInt32(z);
        this.thumbs.add(TLRPC$PhotoSize.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z));
        this.dc_id = abstractSerializedData.readInt32(z);
        abstractSerializedData.readInt32(z);
        int int32 = abstractSerializedData.readInt32(z);
        if (int32 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int322; i++) {
            TLRPC$DocumentAttribute tLRPC$DocumentAttributeTLdeserialize = TLRPC$DocumentAttribute.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$DocumentAttributeTLdeserialize == null) {
                return;
            }
            this.attributes.add(tLRPC$DocumentAttributeTLdeserialize);
        }
    }

    @Override // org.rbmain.tgnet.TLRPC$TL_document, org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt64(this.id);
        abstractSerializedData.writeInt64(this.access_hash);
        abstractSerializedData.writeInt32(this.date);
        abstractSerializedData.writeString(this.mime_type);
        abstractSerializedData.writeInt32(this.size);
        this.thumbs.get(0).serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(this.dc_id);
        abstractSerializedData.writeInt32(0);
        abstractSerializedData.writeInt32(481674261);
        int size = this.attributes.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.attributes.get(i).serializeToStream(abstractSerializedData);
        }
    }
}
