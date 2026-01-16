package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channelAdminLogEventActionChangeLinkedChat extends TLRPC$ChannelAdminLogEventAction {
    public static int constructor = 84703944;
    public long new_value;
    public long prev_value;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.prev_value = stream.readInt64(exception);
        this.new_value = stream.readInt64(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.prev_value);
        stream.writeInt64(this.new_value);
    }
}
