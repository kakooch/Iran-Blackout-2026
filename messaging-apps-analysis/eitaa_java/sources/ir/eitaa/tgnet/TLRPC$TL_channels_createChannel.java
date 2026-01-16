package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channels_createChannel extends TLObject {
    public static int constructor = 1029681423;
    public String about;
    public String address;
    public boolean broadcast;
    public int flags;
    public boolean for_import;
    public TLRPC$InputGeoPoint geo_point;
    public boolean megagroup;
    public String title;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.broadcast ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.megagroup ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.for_import ? i2 | 8 : i2 & (-9);
        this.flags = i3;
        stream.writeInt32(i3);
        stream.writeString(this.title);
        stream.writeString(this.about);
        if ((this.flags & 4) != 0) {
            this.geo_point.serializeToStream(stream);
        }
        if ((this.flags & 4) != 0) {
            stream.writeString(this.address);
        }
    }
}
