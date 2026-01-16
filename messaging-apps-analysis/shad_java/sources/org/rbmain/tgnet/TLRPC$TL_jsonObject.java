package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_jsonObject extends TLRPC$JSONValue {
    public static int constructor = -1715350371;
    public ArrayList<TLRPC$TL_jsonObjectValue> value = new ArrayList<>();

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
            TLRPC$TL_jsonObjectValue tLRPC$TL_jsonObjectValueTLdeserialize = TLRPC$TL_jsonObjectValue.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$TL_jsonObjectValueTLdeserialize == null) {
                return;
            }
            this.value.add(tLRPC$TL_jsonObjectValueTLdeserialize);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(481674261);
        int size = this.value.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.value.get(i).serializeToStream(abstractSerializedData);
        }
    }
}
