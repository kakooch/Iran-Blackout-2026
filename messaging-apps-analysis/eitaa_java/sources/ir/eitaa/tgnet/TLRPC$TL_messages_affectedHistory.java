package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_affectedHistory extends TLObject {
    public static int constructor = -1269012015;
    public int offset;
    public int pts;
    public int pts_count;

    public static TLRPC$TL_messages_affectedHistory TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_messages_affectedHistory", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_messages_affectedHistory tLRPC$TL_messages_affectedHistory = new TLRPC$TL_messages_affectedHistory();
        tLRPC$TL_messages_affectedHistory.readParams(stream, exception);
        return tLRPC$TL_messages_affectedHistory;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.pts = stream.readInt32(exception);
        this.pts_count = stream.readInt32(exception);
        this.offset = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.pts);
        stream.writeInt32(this.pts_count);
        stream.writeInt32(this.offset);
    }
}
