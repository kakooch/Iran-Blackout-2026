package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_sentEmailCode extends TLObject {
    public static int constructor = -2128640689;
    public String email_pattern;
    public int length;

    public static TLRPC$TL_account_sentEmailCode TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_account_sentEmailCode", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_account_sentEmailCode tLRPC$TL_account_sentEmailCode = new TLRPC$TL_account_sentEmailCode();
        tLRPC$TL_account_sentEmailCode.readParams(stream, exception);
        return tLRPC$TL_account_sentEmailCode;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.email_pattern = stream.readString(exception);
        this.length = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.email_pattern);
        stream.writeInt32(this.length);
    }
}
