package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_statsGroupTopInviter extends TLObject {
    public static int constructor = 1398765469;
    public int invitations;
    public long user_id;

    public static TLRPC$TL_statsGroupTopInviter TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_statsGroupTopInviter", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_statsGroupTopInviter tLRPC$TL_statsGroupTopInviter = new TLRPC$TL_statsGroupTopInviter();
        tLRPC$TL_statsGroupTopInviter.readParams(stream, exception);
        return tLRPC$TL_statsGroupTopInviter;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.user_id = stream.readInt64(exception);
        this.invitations = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.user_id);
        stream.writeInt32(this.invitations);
    }
}
