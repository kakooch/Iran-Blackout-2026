package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messageMediaPoll extends TLRPC$MessageMedia {
    public static int constructor = 1272375192;
    public TLRPC$Poll poll;
    public TLRPC$PollResults results;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.poll = TLRPC$Poll.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.results = TLRPC$PollResults.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.poll.serializeToStream(stream);
        this.results.serializeToStream(stream);
    }
}
