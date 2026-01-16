package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_postAddress extends TLObject {
    public static int constructor = 512535275;
    public String city;
    public String country_iso2;
    public String post_code;
    public String state;
    public String street_line1;
    public String street_line2;

    public static TLRPC$TL_postAddress TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_postAddress", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_postAddress tLRPC$TL_postAddress = new TLRPC$TL_postAddress();
        tLRPC$TL_postAddress.readParams(stream, exception);
        return tLRPC$TL_postAddress;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.street_line1 = stream.readString(exception);
        this.street_line2 = stream.readString(exception);
        this.city = stream.readString(exception);
        this.state = stream.readString(exception);
        this.country_iso2 = stream.readString(exception);
        this.post_code = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.street_line1);
        stream.writeString(this.street_line2);
        stream.writeString(this.city);
        stream.writeString(this.state);
        stream.writeString(this.country_iso2);
        stream.writeString(this.post_code);
    }
}
