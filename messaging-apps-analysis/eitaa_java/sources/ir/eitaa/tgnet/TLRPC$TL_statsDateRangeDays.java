package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_statsDateRangeDays extends TLObject {
    public static int constructor = -1237848657;
    public int max_date;
    public int min_date;

    public static TLRPC$TL_statsDateRangeDays TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_statsDateRangeDays", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_statsDateRangeDays tLRPC$TL_statsDateRangeDays = new TLRPC$TL_statsDateRangeDays();
        tLRPC$TL_statsDateRangeDays.readParams(stream, exception);
        return tLRPC$TL_statsDateRangeDays;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.min_date = stream.readInt32(exception);
        this.max_date = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.min_date);
        stream.writeInt32(this.max_date);
    }
}
