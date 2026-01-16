package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_contacts_getLocated extends TLObject {
    public static int constructor = -750207932;
    public boolean background;
    public int flags;
    public TLRPC$InputGeoPoint geo_point;
    public int self_expires;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.background ? this.flags | 2 : this.flags & (-3);
        this.flags = i;
        stream.writeInt32(i);
        this.geo_point.serializeToStream(stream);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(this.self_expires);
        }
    }
}
