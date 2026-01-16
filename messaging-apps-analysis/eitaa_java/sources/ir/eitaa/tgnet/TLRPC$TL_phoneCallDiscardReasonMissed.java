package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_phoneCallDiscardReasonMissed extends TLRPC$PhoneCallDiscardReason {
    public static int constructor = -2048646399;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
