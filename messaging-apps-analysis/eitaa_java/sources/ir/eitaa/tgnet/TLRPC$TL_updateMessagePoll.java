package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateMessagePoll extends TLRPC$Update {
    public static int constructor = -1398708869;
    public int flags;
    public TLRPC$Poll poll;
    public long poll_id;
    public TLRPC$PollResults results;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.poll_id = stream.readInt64(exception);
        if ((this.flags & 1) != 0) {
            this.poll = TLRPC$Poll.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        this.results = TLRPC$PollResults.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeInt64(this.poll_id);
        if ((this.flags & 1) != 0) {
            this.poll.serializeToStream(stream);
        }
        this.results.serializeToStream(stream);
    }
}
