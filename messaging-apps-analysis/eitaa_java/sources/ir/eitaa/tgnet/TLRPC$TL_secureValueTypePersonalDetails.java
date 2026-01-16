package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_secureValueTypePersonalDetails extends TLRPC$SecureValueType {
    public static int constructor = -1658158621;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
