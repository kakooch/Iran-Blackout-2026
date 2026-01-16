package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateChannel extends TLRPC$Update {
    public static int constructor = 1666927625;
    public long channel_id;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.channel_id = stream.readInt64(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.channel_id);
    }
}
