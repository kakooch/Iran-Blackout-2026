package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_nearestDc extends TLObject {
    public static int constructor = -1910892683;
    public String country;
    public int nearest_dc;
    public int this_dc;

    public static TLRPC$TL_nearestDc TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_nearestDc", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_nearestDc tLRPC$TL_nearestDc = new TLRPC$TL_nearestDc();
        tLRPC$TL_nearestDc.readParams(stream, exception);
        return tLRPC$TL_nearestDc;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.country = stream.readString(exception);
        this.this_dc = stream.readInt32(exception);
        this.nearest_dc = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.country);
        stream.writeInt32(this.this_dc);
        stream.writeInt32(this.nearest_dc);
    }
}
