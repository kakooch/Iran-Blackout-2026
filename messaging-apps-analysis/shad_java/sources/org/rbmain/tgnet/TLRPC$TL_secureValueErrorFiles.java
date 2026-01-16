package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_secureValueErrorFiles extends TLRPC$SecureValueError {
    public static int constructor = 1717706985;
    public ArrayList<byte[]> file_hash = new ArrayList<>();
    public String text;
    public TLRPC$SecureValueType type;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.type = TLRPC$SecureValueType.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        int int32 = abstractSerializedData.readInt32(z);
        if (int32 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int322; i++) {
            this.file_hash.add(abstractSerializedData.readByteArray(z));
        }
        this.text = abstractSerializedData.readString(z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.type.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(481674261);
        int size = this.file_hash.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            abstractSerializedData.writeByteArray(this.file_hash.get(i));
        }
        abstractSerializedData.writeString(this.text);
    }
}
