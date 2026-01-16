package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateReadChannelOutbox extends TLRPC$Update {
    public static int constructor = -1218471511;
    public long channel_id;
    public int max_id;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.channel_id = stream.readInt64(exception);
        this.max_id = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.channel_id);
        stream.writeInt32(this.max_id);
    }
}
