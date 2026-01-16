package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channelParticipantAdmin extends TLRPC$ChannelParticipant {
    public static int constructor = 885242707;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.can_edit = (int32 & 1) != 0;
        this.self = (int32 & 2) != 0;
        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
        this.peer = tLRPC$TL_peerUser;
        tLRPC$TL_peerUser.user_id = stream.readInt64(exception);
        if ((this.flags & 2) != 0) {
            this.inviter_id = stream.readInt64(exception);
        }
        this.promoted_by = stream.readInt64(exception);
        this.date = stream.readInt32(exception);
        this.admin_rights = TLRPC$TL_chatAdminRights.TLdeserialize(stream, stream.readInt32(exception), exception);
        if ((this.flags & 4) != 0) {
            this.rank = stream.readString(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.can_edit ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.self ? i | 2 : i & (-3);
        this.flags = i2;
        stream.writeInt32(i2);
        stream.writeInt64(this.peer.user_id);
        if ((this.flags & 2) != 0) {
            stream.writeInt64(this.inviter_id);
        }
        stream.writeInt64(this.promoted_by);
        stream.writeInt32(this.date);
        this.admin_rights.serializeToStream(stream);
        if ((this.flags & 4) != 0) {
            stream.writeString(this.rank);
        }
    }
}
