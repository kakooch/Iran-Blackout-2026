package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_phoneCallDiscardReasonBusy extends TLRPC$PhoneCallDiscardReason {
    public static int constructor = -84416311;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
