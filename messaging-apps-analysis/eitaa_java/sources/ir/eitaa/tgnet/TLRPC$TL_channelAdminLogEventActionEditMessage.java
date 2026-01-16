package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channelAdminLogEventActionEditMessage extends TLRPC$ChannelAdminLogEventAction {
    public static int constructor = 1889215493;
    public TLRPC$Message new_message;
    public TLRPC$Message prev_message;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.prev_message = TLRPC$Message.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.new_message = TLRPC$Message.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.prev_message.serializeToStream(stream);
        this.new_message.serializeToStream(stream);
    }
}
