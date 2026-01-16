package ir.eitaa.tgnet;

import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class TLRPC$TL_messageService extends TLRPC$Message {
    public static int constructor = 721967202;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.out = (int32 & 2) != 0;
        this.mentioned = (int32 & 16) != 0;
        this.media_unread = (int32 & 32) != 0;
        this.silent = (int32 & 8192) != 0;
        this.post = (int32 & 16384) != 0;
        this.legacy = (int32 & 524288) != 0;
        this.id = stream.readInt32(exception);
        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
            this.from_id = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        this.peer_id = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        if ((this.flags & 8) != 0) {
            this.reply_to = TLRPC$TL_messageReplyHeader.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        this.date = stream.readInt32(exception);
        this.action = TLRPC$MessageAction.TLdeserialize(stream, stream.readInt32(exception), exception);
        if ((this.flags & ConnectionsManager.FileTypeVideo) != 0) {
            this.ttl_period = stream.readInt32(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.out ? this.flags | 2 : this.flags & (-3);
        this.flags = i;
        int i2 = this.mentioned ? i | 16 : i & (-17);
        this.flags = i2;
        int i3 = this.media_unread ? i2 | 32 : i2 & (-33);
        this.flags = i3;
        int i4 = this.silent ? i3 | 8192 : i3 & (-8193);
        this.flags = i4;
        int i5 = this.post ? i4 | 16384 : i4 & (-16385);
        this.flags = i5;
        int i6 = this.legacy ? i5 | 524288 : i5 & (-524289);
        this.flags = i6;
        stream.writeInt32(i6);
        stream.writeInt32(this.id);
        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
            this.from_id.serializeToStream(stream);
        }
        this.peer_id.serializeToStream(stream);
        if ((this.flags & 8) != 0) {
            this.reply_to.serializeToStream(stream);
        }
        stream.writeInt32(this.date);
        this.action.serializeToStream(stream);
        if ((this.flags & ConnectionsManager.FileTypeVideo) != 0) {
            stream.writeInt32(this.ttl_period);
        }
    }
}
