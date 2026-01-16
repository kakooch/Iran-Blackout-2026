package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputPrivacyKeyChatInvite extends TLRPC$InputPrivacyKey {
    public static int constructor = -1107622874;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
