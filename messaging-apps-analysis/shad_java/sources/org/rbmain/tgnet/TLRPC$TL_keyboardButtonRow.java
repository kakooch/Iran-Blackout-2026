package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_keyboardButtonRow extends TLObject {
    public static int constructor = 2002815875;
    public ArrayList<TLRPC$KeyboardButton> buttons = new ArrayList<>();

    public static TLRPC$TL_keyboardButtonRow TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        if (constructor != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_keyboardButtonRow", Integer.valueOf(i)));
            }
            return null;
        }
        TLRPC$TL_keyboardButtonRow tLRPC$TL_keyboardButtonRow = new TLRPC$TL_keyboardButtonRow();
        tLRPC$TL_keyboardButtonRow.readParams(abstractSerializedData, z);
        return tLRPC$TL_keyboardButtonRow;
    }

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
            TLRPC$KeyboardButton tLRPC$KeyboardButtonTLdeserialize = TLRPC$KeyboardButton.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$KeyboardButtonTLdeserialize == null) {
                return;
            }
            this.buttons.add(tLRPC$KeyboardButtonTLdeserialize);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(481674261);
        int size = this.buttons.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.buttons.get(i).serializeToStream(abstractSerializedData);
        }
    }
}
