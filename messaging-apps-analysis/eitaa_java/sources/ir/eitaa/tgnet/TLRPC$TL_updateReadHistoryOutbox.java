package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateReadHistoryOutbox extends TLRPC$Update {
    public static int constructor = 791617983;
    public int max_id;
    public TLRPC$Peer peer;
    public int pts;
    public int pts_count;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.peer = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.max_id = stream.readInt32(exception);
        this.pts = stream.readInt32(exception);
        this.pts_count = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        stream.writeInt32(this.max_id);
        stream.writeInt32(this.pts);
        stream.writeInt32(this.pts_count);
    }
}
