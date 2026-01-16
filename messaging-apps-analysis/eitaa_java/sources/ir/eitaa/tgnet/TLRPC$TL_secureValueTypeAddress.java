package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_secureValueTypeAddress extends TLRPC$SecureValueType {
    public static int constructor = -874308058;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
