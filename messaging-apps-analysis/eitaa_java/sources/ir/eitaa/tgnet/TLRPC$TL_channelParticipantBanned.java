package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channelParticipantBanned extends TLRPC$ChannelParticipant {
    public static int constructor = 1844969806;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.left = (int32 & 1) != 0;
        this.peer = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.kicked_by = stream.readInt64(exception);
        this.date = stream.readInt32(exception);
        this.banned_rights = TLRPC$TL_chatBannedRights.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.left ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        this.peer.serializeToStream(stream);
        stream.writeInt64(this.kicked_by);
        stream.writeInt32(this.date);
        this.banned_rights.serializeToStream(stream);
    }
}
