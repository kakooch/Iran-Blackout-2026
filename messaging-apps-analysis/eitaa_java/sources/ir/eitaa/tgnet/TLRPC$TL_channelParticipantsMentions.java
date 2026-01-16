package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channelParticipantsMentions extends TLRPC$ChannelParticipantsFilter {
    public static int constructor = -531931925;
    public int flags;
    public int top_msg_id;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        if ((int32 & 1) != 0) {
            this.q = stream.readString(exception);
        }
        if ((this.flags & 2) != 0) {
            this.top_msg_id = stream.readInt32(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        if ((this.flags & 1) != 0) {
            stream.writeString(this.q);
        }
        if ((this.flags & 2) != 0) {
            stream.writeInt32(this.top_msg_id);
        }
    }
}
