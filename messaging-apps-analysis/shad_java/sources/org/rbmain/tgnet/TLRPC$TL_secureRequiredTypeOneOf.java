package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_secureRequiredTypeOneOf extends TLRPC$SecureRequiredType {
    public static int constructor = 41187252;
    public ArrayList<TLRPC$SecureRequiredType> types = new ArrayList<>();

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        if (int32 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int322; i++) {
            TLRPC$SecureRequiredType tLRPC$SecureRequiredTypeTLdeserialize = TLRPC$SecureRequiredType.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$SecureRequiredTypeTLdeserialize == null) {
                return;
            }
            this.types.add(tLRPC$SecureRequiredTypeTLdeserialize);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(481674261);
        int size = this.types.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.types.get(i).serializeToStream(abstractSerializedData);
        }
    }
}
