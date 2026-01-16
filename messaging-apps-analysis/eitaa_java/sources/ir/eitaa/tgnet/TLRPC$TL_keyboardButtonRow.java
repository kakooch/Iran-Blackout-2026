package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_keyboardButtonRow extends TLObject {
    public static int constructor = 2002815875;
    public ArrayList<TLRPC$KeyboardButton> buttons = new ArrayList<>();

    public static TLRPC$TL_keyboardButtonRow TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_keyboardButtonRow", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_keyboardButtonRow tLRPC$TL_keyboardButtonRow = new TLRPC$TL_keyboardButtonRow();
        tLRPC$TL_keyboardButtonRow.readParams(stream, exception);
        return tLRPC$TL_keyboardButtonRow;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            TLRPC$KeyboardButton tLRPC$KeyboardButtonTLdeserialize = TLRPC$KeyboardButton.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$KeyboardButtonTLdeserialize == null) {
                return;
            }
            this.buttons.add(tLRPC$KeyboardButtonTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(481674261);
        int size = this.buttons.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.buttons.get(i).serializeToStream(stream);
        }
    }
}
