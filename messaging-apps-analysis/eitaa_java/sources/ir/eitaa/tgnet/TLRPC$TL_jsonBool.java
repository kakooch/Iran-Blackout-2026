package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_jsonBool extends TLRPC$JSONValue {
    public static int constructor = -952869270;
    public boolean value;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.value = stream.readBool(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeBool(this.value);
    }
}
