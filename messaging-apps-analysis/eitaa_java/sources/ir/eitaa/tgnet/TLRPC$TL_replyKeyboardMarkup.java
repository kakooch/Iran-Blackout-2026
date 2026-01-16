package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_replyKeyboardMarkup extends TLRPC$ReplyMarkup {
    public static int constructor = -2049074735;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.resize = (int32 & 1) != 0;
        this.single_use = (int32 & 2) != 0;
        this.selective = (int32 & 4) != 0;
        int int322 = stream.readInt32(exception);
        if (int322 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
            return;
        }
        int int323 = stream.readInt32(exception);
        for (int i = 0; i < int323; i++) {
            TLRPC$TL_keyboardButtonRow tLRPC$TL_keyboardButtonRowTLdeserialize = TLRPC$TL_keyboardButtonRow.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$TL_keyboardButtonRowTLdeserialize == null) {
                return;
            }
            this.rows.add(tLRPC$TL_keyboardButtonRowTLdeserialize);
        }
        if ((this.flags & 8) != 0) {
            this.placeholder = stream.readString(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.resize ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.single_use ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.selective ? i2 | 4 : i2 & (-5);
        this.flags = i3;
        stream.writeInt32(i3);
        stream.writeInt32(481674261);
        int size = this.rows.size();
        stream.writeInt32(size);
        for (int i4 = 0; i4 < size; i4++) {
            this.rows.get(i4).serializeToStream(stream);
        }
        if ((this.flags & 8) != 0) {
            stream.writeString(this.placeholder);
        }
    }
}
