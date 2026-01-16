package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputCheckPasswordSRP extends TLRPC$InputCheckPasswordSRP {
    public static int constructor = -763367294;
    public byte[] A;
    public byte[] M1;
    public long srp_id;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.srp_id = stream.readInt64(exception);
        this.A = stream.readByteArray(exception);
        this.M1 = stream.readByteArray(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.srp_id);
        stream.writeByteArray(this.A);
        stream.writeByteArray(this.M1);
    }
}
