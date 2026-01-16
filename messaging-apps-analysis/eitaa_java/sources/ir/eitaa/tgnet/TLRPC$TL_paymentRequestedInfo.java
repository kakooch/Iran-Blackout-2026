package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_paymentRequestedInfo extends TLObject {
    public static int constructor = -1868808300;
    public String email;
    public int flags;
    public String name;
    public String phone;
    public TLRPC$TL_postAddress shipping_address;

    public static TLRPC$TL_paymentRequestedInfo TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_paymentRequestedInfo", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_paymentRequestedInfo tLRPC$TL_paymentRequestedInfo = new TLRPC$TL_paymentRequestedInfo();
        tLRPC$TL_paymentRequestedInfo.readParams(stream, exception);
        return tLRPC$TL_paymentRequestedInfo;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        if ((int32 & 1) != 0) {
            this.name = stream.readString(exception);
        }
        if ((this.flags & 2) != 0) {
            this.phone = stream.readString(exception);
        }
        if ((this.flags & 4) != 0) {
            this.email = stream.readString(exception);
        }
        if ((this.flags & 8) != 0) {
            this.shipping_address = TLRPC$TL_postAddress.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        if ((this.flags & 1) != 0) {
            stream.writeString(this.name);
        }
        if ((this.flags & 2) != 0) {
            stream.writeString(this.phone);
        }
        if ((this.flags & 4) != 0) {
            stream.writeString(this.email);
        }
        if ((this.flags & 8) != 0) {
            this.shipping_address.serializeToStream(stream);
        }
    }
}
