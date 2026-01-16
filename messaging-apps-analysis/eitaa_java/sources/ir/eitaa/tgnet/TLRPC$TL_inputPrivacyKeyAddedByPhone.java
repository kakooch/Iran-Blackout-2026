package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputPrivacyKeyAddedByPhone extends TLRPC$InputPrivacyKey {
    public static int constructor = -786326563;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
