package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_tokenUpdateing extends TLObject {
    public static int constructor = -601545867;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
