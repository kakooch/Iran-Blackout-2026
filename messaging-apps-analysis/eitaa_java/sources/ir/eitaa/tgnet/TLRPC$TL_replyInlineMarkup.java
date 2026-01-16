package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_replyInlineMarkup extends TLRPC$ReplyMarkup {
    public static int constructor = 1218642516;

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
            TLRPC$TL_keyboardButtonRow tLRPC$TL_keyboardButtonRowTLdeserialize = TLRPC$TL_keyboardButtonRow.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$TL_keyboardButtonRowTLdeserialize == null) {
                return;
            }
            this.rows.add(tLRPC$TL_keyboardButtonRowTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(481674261);
        int size = this.rows.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.rows.get(i).serializeToStream(stream);
        }
    }
}
