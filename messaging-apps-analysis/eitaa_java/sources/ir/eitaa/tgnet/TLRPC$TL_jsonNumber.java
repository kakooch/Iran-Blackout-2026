package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_jsonNumber extends TLRPC$JSONValue {
    public static int constructor = 736157604;
    public double value;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.value = stream.readDouble(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeDouble(this.value);
    }
}
