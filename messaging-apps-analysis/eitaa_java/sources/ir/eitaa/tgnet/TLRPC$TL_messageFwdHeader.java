package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messageFwdHeader extends TLRPC$MessageFwdHeader {
    public static int constructor = 1601666510;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.imported = (int32 & 128) != 0;
        if ((int32 & 1) != 0) {
            this.from_id = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 32) != 0) {
            this.from_name = stream.readString(exception);
        }
        this.date = stream.readInt32(exception);
        if ((this.flags & 4) != 0) {
            this.channel_post = stream.readInt32(exception);
        }
        if ((this.flags & 8) != 0) {
            this.post_author = stream.readString(exception);
        }
        if ((this.flags & 16) != 0) {
            this.saved_from_peer = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 16) != 0) {
            this.saved_from_msg_id = stream.readInt32(exception);
        }
        if ((this.flags & 64) != 0) {
            this.psa_type = stream.readString(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.imported ? this.flags | 128 : this.flags & (-129);
        this.flags = i;
        stream.writeInt32(i);
        if ((this.flags & 1) != 0) {
            this.from_id.serializeToStream(stream);
        }
        if ((this.flags & 32) != 0) {
            stream.writeString(this.from_name);
        }
        stream.writeInt32(this.date);
        if ((this.flags & 4) != 0) {
            stream.writeInt32(this.channel_post);
        }
        if ((this.flags & 8) != 0) {
            stream.writeString(this.post_author);
        }
        if ((this.flags & 16) != 0) {
            this.saved_from_peer.serializeToStream(stream);
        }
        if ((this.flags & 16) != 0) {
            stream.writeInt32(this.saved_from_msg_id);
        }
        if ((this.flags & 64) != 0) {
            stream.writeString(this.psa_type);
        }
    }
}
