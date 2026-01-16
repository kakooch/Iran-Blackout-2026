package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_payments_getBankCardData extends TLObject {
    public static int constructor = 779736953;
    public String number;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_payments_bankCardData.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.number);
    }
}
