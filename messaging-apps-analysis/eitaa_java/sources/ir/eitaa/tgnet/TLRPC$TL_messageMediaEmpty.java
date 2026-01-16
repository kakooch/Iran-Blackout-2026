package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messageMediaEmpty extends TLRPC$MessageMedia {
    public static int constructor = 1038967584;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
