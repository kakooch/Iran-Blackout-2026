package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_statsGraphError extends TLRPC$StatsGraph {
    public static int constructor = -1092839390;
    public String error;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.error = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.error);
    }
}
