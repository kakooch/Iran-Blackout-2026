package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputUserSelf extends TLRPC$InputUser {
    public static int constructor = -138301121;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
