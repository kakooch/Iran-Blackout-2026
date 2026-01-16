package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputPrivacyKeyStatusTimestamp extends TLRPC$InputPrivacyKey {
    public static int constructor = 1335282456;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
