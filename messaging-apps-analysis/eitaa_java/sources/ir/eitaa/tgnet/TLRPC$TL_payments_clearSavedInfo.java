package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_payments_clearSavedInfo extends TLObject {
    public static int constructor = -667062079;
    public boolean credentials;
    public int flags;
    public boolean info;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.credentials ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.info ? i | 2 : i & (-3);
        this.flags = i2;
        stream.writeInt32(i2);
    }
}
