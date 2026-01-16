package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channelAdminLogEventActionChangeLocation extends TLRPC$ChannelAdminLogEventAction {
    public static int constructor = 241923758;
    public TLRPC$ChannelLocation new_value;
    public TLRPC$ChannelLocation prev_value;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.prev_value = TLRPC$ChannelLocation.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.new_value = TLRPC$ChannelLocation.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.prev_value.serializeToStream(stream);
        this.new_value.serializeToStream(stream);
    }
}
