package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputUserEmpty extends TLRPC$InputUser {
    public static int constructor = -1182234929;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
