package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_keyboardButtonBuy extends TLRPC$KeyboardButton {
    public static int constructor = -1344716869;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.text = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.text);
    }
}
