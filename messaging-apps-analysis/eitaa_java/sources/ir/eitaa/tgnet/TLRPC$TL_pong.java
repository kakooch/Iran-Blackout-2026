package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_pong extends TLObject {
    public static int constructor = 880243653;
    public long msg_id;
    public long ping_id;

    public static TLRPC$TL_pong TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_pong", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_pong tLRPC$TL_pong = new TLRPC$TL_pong();
        tLRPC$TL_pong.readParams(stream, exception);
        return tLRPC$TL_pong;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.msg_id = stream.readInt64(exception);
        this.ping_id = stream.readInt64(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.msg_id);
        stream.writeInt64(this.ping_id);
    }
}
