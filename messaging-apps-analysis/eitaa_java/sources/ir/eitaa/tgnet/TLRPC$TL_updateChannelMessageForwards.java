package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateChannelMessageForwards extends TLRPC$Update {
    public static int constructor = -761649164;
    public long channel_id;
    public int forwards;
    public int id;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.channel_id = stream.readInt64(exception);
        this.id = stream.readInt32(exception);
        this.forwards = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.channel_id);
        stream.writeInt32(this.id);
        stream.writeInt32(this.forwards);
    }
}
