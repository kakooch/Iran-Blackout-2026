package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channelAdminLogEventActionChangeHistoryTTL extends TLRPC$ChannelAdminLogEventAction {
    public static int constructor = 1855199800;
    public int new_value;
    public int prev_value;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.prev_value = stream.readInt32(exception);
        this.new_value = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.prev_value);
        stream.writeInt32(this.new_value);
    }
}
