package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_affectedMessages extends TLObject {
    public static int constructor = -2066640507;
    public int pts;
    public int pts_count;

    public static TLRPC$TL_messages_affectedMessages TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_messages_affectedMessages", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_messages_affectedMessages tLRPC$TL_messages_affectedMessages = new TLRPC$TL_messages_affectedMessages();
        tLRPC$TL_messages_affectedMessages.readParams(stream, exception);
        return tLRPC$TL_messages_affectedMessages;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.pts = stream.readInt32(exception);
        this.pts_count = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.pts);
        stream.writeInt32(this.pts_count);
    }
}
