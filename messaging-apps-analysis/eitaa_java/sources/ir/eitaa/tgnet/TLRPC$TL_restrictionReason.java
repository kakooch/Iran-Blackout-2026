package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_restrictionReason extends TLObject {
    public static int constructor = -797791052;
    public String platform;
    public String reason;
    public String text;

    public static TLRPC$TL_restrictionReason TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_restrictionReason", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_restrictionReason tLRPC$TL_restrictionReason = new TLRPC$TL_restrictionReason();
        tLRPC$TL_restrictionReason.readParams(stream, exception);
        return tLRPC$TL_restrictionReason;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.platform = stream.readString(exception);
        this.reason = stream.readString(exception);
        this.text = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.platform);
        stream.writeString(this.reason);
        stream.writeString(this.text);
    }
}
