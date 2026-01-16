package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_decryptedMessageActionNoop extends TLRPC$DecryptedMessageAction {
    public static int constructor = -1473258141;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
