package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_replyKeyboardForceReply extends TLRPC$ReplyMarkup {
    public static int constructor = -2035021048;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.single_use = (int32 & 2) != 0;
        this.selective = (int32 & 4) != 0;
        if ((int32 & 8) != 0) {
            this.placeholder = stream.readString(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.single_use ? this.flags | 2 : this.flags & (-3);
        this.flags = i;
        int i2 = this.selective ? i | 4 : i & (-5);
        this.flags = i2;
        stream.writeInt32(i2);
        if ((this.flags & 8) != 0) {
            stream.writeString(this.placeholder);
        }
    }
}
