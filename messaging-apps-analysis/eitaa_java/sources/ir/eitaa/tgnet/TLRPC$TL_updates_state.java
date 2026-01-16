package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updates_state extends TLObject {
    public static int constructor = -1519637954;
    public int date;
    public int pts;
    public int qts;
    public int seq;
    public int unread_count;

    public static TLRPC$TL_updates_state TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_updates_state", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_updates_state tLRPC$TL_updates_state = new TLRPC$TL_updates_state();
        tLRPC$TL_updates_state.readParams(stream, exception);
        return tLRPC$TL_updates_state;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.pts = stream.readInt32(exception);
        this.qts = stream.readInt32(exception);
        this.date = stream.readInt32(exception);
        this.seq = stream.readInt32(exception);
        this.unread_count = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.pts);
        stream.writeInt32(this.qts);
        stream.writeInt32(this.date);
        stream.writeInt32(this.seq);
        stream.writeInt32(this.unread_count);
    }
}
