package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_keyboardButtonUrlAuth extends TLRPC$KeyboardButton {
    public static int constructor = 280464681;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.text = stream.readString(exception);
        if ((this.flags & 1) != 0) {
            this.fwd_text = stream.readString(exception);
        }
        this.url = stream.readString(exception);
        this.button_id = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeString(this.text);
        if ((this.flags & 1) != 0) {
            stream.writeString(this.fwd_text);
        }
        stream.writeString(this.url);
        stream.writeInt32(this.button_id);
    }
}
