package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_help_support extends TLObject {
    public static int constructor = 398898678;
    public String phone_number;
    public TLRPC$User user;

    public static TLRPC$TL_help_support TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_help_support", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_help_support tLRPC$TL_help_support = new TLRPC$TL_help_support();
        tLRPC$TL_help_support.readParams(stream, exception);
        return tLRPC$TL_help_support;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.phone_number = stream.readString(exception);
        this.user = TLRPC$User.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.phone_number);
        this.user.serializeToStream(stream);
    }
}
