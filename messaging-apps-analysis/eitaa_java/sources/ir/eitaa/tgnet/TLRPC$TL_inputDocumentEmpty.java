package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputDocumentEmpty extends TLRPC$InputDocument {
    public static int constructor = 1928391342;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
