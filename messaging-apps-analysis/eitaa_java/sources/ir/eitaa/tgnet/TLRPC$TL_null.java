package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_null extends TLObject {
    public static int constructor = 1450380236;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
