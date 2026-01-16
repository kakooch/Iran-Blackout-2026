package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_statsPercentValue extends TLObject {
    public static int constructor = -875679776;
    public double part;
    public double total;

    public static TLRPC$TL_statsPercentValue TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_statsPercentValue", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_statsPercentValue tLRPC$TL_statsPercentValue = new TLRPC$TL_statsPercentValue();
        tLRPC$TL_statsPercentValue.readParams(stream, exception);
        return tLRPC$TL_statsPercentValue;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.part = stream.readDouble(exception);
        this.total = stream.readDouble(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeDouble(this.part);
        stream.writeDouble(this.total);
    }
}
