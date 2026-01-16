package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updates_ExpireToken extends TLObject {
    public static int constructor = -601545863;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
