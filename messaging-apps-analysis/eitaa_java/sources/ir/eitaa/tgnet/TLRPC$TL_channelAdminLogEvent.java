package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channelAdminLogEvent extends TLObject {
    public static int constructor = 531458253;
    public TLRPC$ChannelAdminLogEventAction action;
    public int date;
    public long id;
    public long user_id;

    public static TLRPC$TL_channelAdminLogEvent TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_channelAdminLogEvent", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_channelAdminLogEvent tLRPC$TL_channelAdminLogEvent = new TLRPC$TL_channelAdminLogEvent();
        tLRPC$TL_channelAdminLogEvent.readParams(stream, exception);
        return tLRPC$TL_channelAdminLogEvent;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.id = stream.readInt64(exception);
        this.date = stream.readInt32(exception);
        this.user_id = stream.readInt64(exception);
        this.action = TLRPC$ChannelAdminLogEventAction.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.id);
        stream.writeInt32(this.date);
        stream.writeInt64(this.user_id);
        this.action.serializeToStream(stream);
    }
}
