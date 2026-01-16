package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_replyKeyboardHide extends TLRPC$ReplyMarkup {
    public static int constructor = -1606526075;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.selective = (int32 & 4) != 0;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.selective ? this.flags | 4 : this.flags & (-5);
        this.flags = i;
        stream.writeInt32(i);
    }
}
