package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_channelParticipantAdmin extends TLRPC$ChannelParticipant {
    public static int constructor = -859915345;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.can_edit = (int32 & 1) != 0;
        this.self = (int32 & 2) != 0;
        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
        this.peer = tLRPC$TL_peerUser;
        tLRPC$TL_peerUser.user_id = abstractSerializedData.readInt32(z);
        if ((this.flags & 2) != 0) {
            this.inviter_id = abstractSerializedData.readInt32(z);
        }
        this.promoted_by = abstractSerializedData.readInt32(z);
        this.date = abstractSerializedData.readInt32(z);
        this.admin_rights = TLRPC$TL_chatAdminRights.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        if ((this.flags & 4) != 0) {
            this.rank = abstractSerializedData.readString(z);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.can_edit ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.self ? i | 2 : i & (-3);
        this.flags = i2;
        abstractSerializedData.writeInt32(i2);
        abstractSerializedData.writeInt32(this.peer.user_id);
        if ((this.flags & 2) != 0) {
            abstractSerializedData.writeInt32(this.inviter_id);
        }
        abstractSerializedData.writeInt32(this.promoted_by);
        abstractSerializedData.writeInt32(this.date);
        this.admin_rights.serializeToStream(abstractSerializedData);
        if ((this.flags & 4) != 0) {
            abstractSerializedData.writeString(this.rank);
        }
    }
}
