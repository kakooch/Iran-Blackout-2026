package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updatePhoneCallSignalingData extends TLRPC$Update {
    public static int constructor = 643940105;
    public byte[] data;
    public long phone_call_id;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.phone_call_id = stream.readInt64(exception);
        this.data = stream.readByteArray(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.phone_call_id);
        stream.writeByteArray(this.data);
    }
}
