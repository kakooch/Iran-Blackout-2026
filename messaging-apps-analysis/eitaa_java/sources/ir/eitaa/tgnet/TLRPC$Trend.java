package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$Trend extends TLObject {
    public static int constructor = 257664601;
    public int count;
    public String hashtag;

    public static TLRPC$Trend TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in Trend", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$Trend tLRPC$Trend = new TLRPC$Trend();
        tLRPC$Trend.readParams(stream, exception);
        return tLRPC$Trend;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.hashtag = stream.readString(exception);
        this.count = stream.readInt32(exception);
    }
}
