package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputCheckPasswordEmpty extends TLRPC$InputCheckPasswordSRP {
    public static int constructor = -1736378792;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
