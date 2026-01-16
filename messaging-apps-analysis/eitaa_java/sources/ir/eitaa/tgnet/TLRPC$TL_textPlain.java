package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_textPlain extends TLRPC$RichText {
    public static int constructor = 1950782688;
    public String text;

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
