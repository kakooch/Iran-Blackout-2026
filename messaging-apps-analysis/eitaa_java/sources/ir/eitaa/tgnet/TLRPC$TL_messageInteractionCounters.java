package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messageInteractionCounters extends TLObject {
    public static int constructor = -1387279939;
    public int forwards;
    public int msg_id;
    public int views;

    public static TLRPC$TL_messageInteractionCounters TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_messageInteractionCounters", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_messageInteractionCounters tLRPC$TL_messageInteractionCounters = new TLRPC$TL_messageInteractionCounters();
        tLRPC$TL_messageInteractionCounters.readParams(stream, exception);
        return tLRPC$TL_messageInteractionCounters;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.msg_id = stream.readInt32(exception);
        this.views = stream.readInt32(exception);
        this.forwards = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.msg_id);
        stream.writeInt32(this.views);
        stream.writeInt32(this.forwards);
    }
}
