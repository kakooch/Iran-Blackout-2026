package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_textEmpty extends TLRPC$RichText {
    public static int constructor = -599948721;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
