package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messageReplyHeader extends TLObject {
    public static int constructor = -1495959709;
    public int flags;
    public int reply_to_msg_id;
    public TLRPC$Peer reply_to_peer_id;
    public long reply_to_random_id;
    public int reply_to_top_id;

    public static TLRPC$TL_messageReplyHeader TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_messageReplyHeader", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
        tLRPC$TL_messageReplyHeader.readParams(stream, exception);
        return tLRPC$TL_messageReplyHeader;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.reply_to_msg_id = stream.readInt32(exception);
        if ((this.flags & 1) != 0) {
            this.reply_to_peer_id = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 2) != 0) {
            this.reply_to_top_id = stream.readInt32(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeInt32(this.reply_to_msg_id);
        if ((this.flags & 1) != 0) {
            this.reply_to_peer_id.serializeToStream(stream);
        }
        if ((this.flags & 2) != 0) {
            stream.writeInt32(this.reply_to_top_id);
        }
    }
}
