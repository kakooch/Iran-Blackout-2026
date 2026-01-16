package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_phoneCallDiscardReasonDisconnect extends TLRPC$PhoneCallDiscardReason {
    public static int constructor = -527056480;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
