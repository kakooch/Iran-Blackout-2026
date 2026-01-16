package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_statsGraphAsync extends TLRPC$StatsGraph {
    public static int constructor = 1244130093;
    public String token;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.token = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.token);
    }
}
