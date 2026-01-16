package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messageReplies extends TLRPC$MessageReplies {
    public static int constructor = -2083123262;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.comments = (int32 & 1) != 0;
        this.replies = stream.readInt32(exception);
        this.replies_pts = stream.readInt32(exception);
        if ((this.flags & 2) != 0) {
            int int322 = stream.readInt32(exception);
            if (int322 != 481674261) {
                if (exception) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                }
                return;
            }
            int int323 = stream.readInt32(exception);
            for (int i = 0; i < int323; i++) {
                TLRPC$Peer tLRPC$PeerTLdeserialize = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
                if (tLRPC$PeerTLdeserialize == null) {
                    return;
                }
                this.recent_repliers.add(tLRPC$PeerTLdeserialize);
            }
        }
        if ((this.flags & 1) != 0) {
            this.channel_id = stream.readInt64(exception);
        }
        if ((this.flags & 4) != 0) {
            this.max_id = stream.readInt32(exception);
        }
        if ((this.flags & 8) != 0) {
            this.read_max_id = stream.readInt32(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.comments ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        stream.writeInt32(this.replies);
        stream.writeInt32(this.replies_pts);
        if ((this.flags & 2) != 0) {
            stream.writeInt32(481674261);
            int size = this.recent_repliers.size();
            stream.writeInt32(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.recent_repliers.get(i2).serializeToStream(stream);
            }
        }
        if ((this.flags & 1) != 0) {
            stream.writeInt64(this.channel_id);
        }
        if ((this.flags & 4) != 0) {
            stream.writeInt32(this.max_id);
        }
        if ((this.flags & 8) != 0) {
            stream.writeInt32(this.read_max_id);
        }
    }
}
