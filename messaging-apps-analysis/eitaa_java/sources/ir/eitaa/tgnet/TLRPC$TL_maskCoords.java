package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_maskCoords extends TLObject {
    public static int constructor = -1361650766;
    public int n;
    public double x;
    public double y;
    public double zoom;

    public static TLRPC$TL_maskCoords TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_maskCoords", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_maskCoords tLRPC$TL_maskCoords = new TLRPC$TL_maskCoords();
        tLRPC$TL_maskCoords.readParams(stream, exception);
        return tLRPC$TL_maskCoords;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.n = stream.readInt32(exception);
        this.x = stream.readDouble(exception);
        this.y = stream.readDouble(exception);
        this.zoom = stream.readDouble(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.n);
        stream.writeDouble(this.x);
        stream.writeDouble(this.y);
        stream.writeDouble(this.zoom);
    }
}
