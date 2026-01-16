package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$MessageReplies extends TLObject {
    public long channel_id;
    public boolean comments;
    public int flags;
    public int max_id;
    public int read_max_id;
    public ArrayList<TLRPC$Peer> recent_repliers = new ArrayList<>();
    public int replies;
    public int replies_pts;

    public static TLRPC$MessageReplies TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$TL_messageReplies tLRPC$TL_messageReplies;
        if (constructor != -2083123262) {
            tLRPC$TL_messageReplies = constructor != 1093204652 ? null : new TLRPC$TL_messageReplies() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageReplies_layer131
                public static int constructor = 1093204652;

                @Override // ir.eitaa.tgnet.TLRPC$TL_messageReplies, ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    int int32 = stream2.readInt32(exception2);
                    this.flags = int32;
                    this.comments = (int32 & 1) != 0;
                    this.replies = stream2.readInt32(exception2);
                    this.replies_pts = stream2.readInt32(exception2);
                    if ((this.flags & 2) != 0) {
                        int int322 = stream2.readInt32(exception2);
                        if (int322 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = stream2.readInt32(exception2);
                        for (int i = 0; i < int323; i++) {
                            TLRPC$Peer tLRPC$PeerTLdeserialize = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$PeerTLdeserialize == null) {
                                return;
                            }
                            this.recent_repliers.add(tLRPC$PeerTLdeserialize);
                        }
                    }
                    if ((this.flags & 1) != 0) {
                        this.channel_id = stream2.readInt32(exception2);
                    }
                    if ((this.flags & 4) != 0) {
                        this.max_id = stream2.readInt32(exception2);
                    }
                    if ((this.flags & 8) != 0) {
                        this.read_max_id = stream2.readInt32(exception2);
                    }
                }

                @Override // ir.eitaa.tgnet.TLRPC$TL_messageReplies, ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    int i = this.comments ? this.flags | 1 : this.flags & (-2);
                    this.flags = i;
                    stream2.writeInt32(i);
                    stream2.writeInt32(this.replies);
                    stream2.writeInt32(this.replies_pts);
                    if ((this.flags & 2) != 0) {
                        stream2.writeInt32(481674261);
                        int size = this.recent_repliers.size();
                        stream2.writeInt32(size);
                        for (int i2 = 0; i2 < size; i2++) {
                            this.recent_repliers.get(i2).serializeToStream(stream2);
                        }
                    }
                    if ((this.flags & 1) != 0) {
                        stream2.writeInt32((int) this.channel_id);
                    }
                    if ((this.flags & 4) != 0) {
                        stream2.writeInt32(this.max_id);
                    }
                    if ((this.flags & 8) != 0) {
                        stream2.writeInt32(this.read_max_id);
                    }
                }
            };
        } else {
            tLRPC$TL_messageReplies = new TLRPC$TL_messageReplies();
        }
        if (tLRPC$TL_messageReplies == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in MessageReplies", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_messageReplies != null) {
            tLRPC$TL_messageReplies.readParams(stream, exception);
        }
        return tLRPC$TL_messageReplies;
    }
}
