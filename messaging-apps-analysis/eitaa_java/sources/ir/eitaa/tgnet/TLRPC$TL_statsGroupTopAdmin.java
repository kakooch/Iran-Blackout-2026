package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_statsGroupTopAdmin extends TLObject {
    public static int constructor = -682079097;
    public int banned;
    public int deleted;
    public int kicked;
    public long user_id;

    public static TLRPC$TL_statsGroupTopAdmin TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_statsGroupTopAdmin", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_statsGroupTopAdmin tLRPC$TL_statsGroupTopAdmin = new TLRPC$TL_statsGroupTopAdmin();
        tLRPC$TL_statsGroupTopAdmin.readParams(stream, exception);
        return tLRPC$TL_statsGroupTopAdmin;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.user_id = stream.readInt64(exception);
        this.deleted = stream.readInt32(exception);
        this.kicked = stream.readInt32(exception);
        this.banned = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.user_id);
        stream.writeInt32(this.deleted);
        stream.writeInt32(this.kicked);
        stream.writeInt32(this.banned);
    }
}
