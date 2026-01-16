package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_contactStatus extends TLObject {
    public static int constructor = 383348795;
    public TLRPC$UserStatus status;
    public long user_id;

    public static TLRPC$TL_contactStatus TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_contactStatus", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_contactStatus tLRPC$TL_contactStatus = new TLRPC$TL_contactStatus();
        tLRPC$TL_contactStatus.readParams(stream, exception);
        return tLRPC$TL_contactStatus;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.user_id = stream.readInt64(exception);
        this.status = TLRPC$UserStatus.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.user_id);
        this.status.serializeToStream(stream);
    }
}
