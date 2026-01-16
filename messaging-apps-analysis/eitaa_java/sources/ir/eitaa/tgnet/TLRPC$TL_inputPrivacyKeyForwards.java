package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputPrivacyKeyForwards extends TLRPC$InputPrivacyKey {
    public static int constructor = -1529000952;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
