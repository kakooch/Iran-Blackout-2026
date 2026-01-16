package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_statsAbsValueAndPrev extends TLObject {
    public static int constructor = -884757282;
    public double current;
    public double previous;

    public static TLRPC$TL_statsAbsValueAndPrev TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_statsAbsValueAndPrev", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_statsAbsValueAndPrev tLRPC$TL_statsAbsValueAndPrev = new TLRPC$TL_statsAbsValueAndPrev();
        tLRPC$TL_statsAbsValueAndPrev.readParams(stream, exception);
        return tLRPC$TL_statsAbsValueAndPrev;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.current = stream.readDouble(exception);
        this.previous = stream.readDouble(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeDouble(this.current);
        stream.writeDouble(this.previous);
    }
}
