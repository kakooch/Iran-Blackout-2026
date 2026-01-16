package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_accountDaysTTL extends TLObject {
    public static int constructor = -1194283041;
    public int days;

    public static TLRPC$TL_accountDaysTTL TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_accountDaysTTL", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_accountDaysTTL tLRPC$TL_accountDaysTTL = new TLRPC$TL_accountDaysTTL();
        tLRPC$TL_accountDaysTTL.readParams(stream, exception);
        return tLRPC$TL_accountDaysTTL;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.days = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.days);
    }
}
