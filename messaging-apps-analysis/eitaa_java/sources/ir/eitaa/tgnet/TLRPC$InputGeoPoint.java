package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$InputGeoPoint extends TLObject {
    public double _long;
    public int accuracy_radius;
    public int flags;
    public double lat;

    public static TLRPC$InputGeoPoint TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$InputGeoPoint tLRPC$TL_inputGeoPointEmpty;
        if (constructor != -457104426) {
            tLRPC$TL_inputGeoPointEmpty = constructor != -206066487 ? null : new TLRPC$TL_inputGeoPoint();
        } else {
            tLRPC$TL_inputGeoPointEmpty = new TLRPC$TL_inputGeoPointEmpty();
        }
        if (tLRPC$TL_inputGeoPointEmpty == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in InputGeoPoint", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_inputGeoPointEmpty != null) {
            tLRPC$TL_inputGeoPointEmpty.readParams(stream, exception);
        }
        return tLRPC$TL_inputGeoPointEmpty;
    }
}
