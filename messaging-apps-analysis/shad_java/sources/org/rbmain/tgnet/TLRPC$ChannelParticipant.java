package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$ChannelParticipant extends TLObject {
    public TLRPC$TL_chatAdminRights admin_rights;
    public TLRPC$TL_channelAdminRights_layer92 admin_rights_layer92;
    public TLRPC$TL_chatBannedRights banned_rights;
    public TLRPC$TL_channelBannedRights_layer92 banned_rights_layer92;
    public boolean can_edit;
    public int date;
    public int flags;
    public int inviter_id;
    public int kicked_by;
    public boolean left;
    public TLRPC$Peer peer;
    public int promoted_by;
    public String rank;
    public boolean self;

    public static TLRPC$ChannelParticipant TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$ChannelParticipant tLRPC$TL_channelParticipantAdmin;
        switch (i) {
            case -2138237532:
                tLRPC$TL_channelParticipantAdmin = new TLRPC$TL_channelParticipantCreator() { // from class: org.rbmain.tgnet.TLRPC$TL_channelParticipantCreator_layer118
                    public static int constructor = -2138237532;

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelParticipantCreator, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.flags = abstractSerializedData2.readInt32(z2);
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.peer = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = abstractSerializedData2.readInt32(z2);
                        if ((this.flags & 1) != 0) {
                            this.rank = abstractSerializedData2.readString(z2);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelParticipantCreator, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.flags);
                        abstractSerializedData2.writeInt32(this.peer.user_id);
                        if ((this.flags & 1) != 0) {
                            abstractSerializedData2.writeString(this.rank);
                        }
                    }
                };
                break;
            case -1933187430:
                tLRPC$TL_channelParticipantAdmin = new TLRPC$ChannelParticipant() { // from class: org.rbmain.tgnet.TLRPC$TL_channelParticipantKicked_layer67
                    public static int constructor = -1933187430;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.peer = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = abstractSerializedData2.readInt32(z2);
                        this.kicked_by = abstractSerializedData2.readInt32(z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.peer.user_id);
                        abstractSerializedData2.writeInt32(this.kicked_by);
                        abstractSerializedData2.writeInt32(this.date);
                    }
                };
                break;
            case -1861910545:
                tLRPC$TL_channelParticipantAdmin = new TLRPC$TL_channelParticipantAdmin() { // from class: org.rbmain.tgnet.TLRPC$TL_channelParticipantModerator_layer67
                    public static int constructor = -1861910545;

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelParticipantAdmin, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.peer = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = abstractSerializedData2.readInt32(z2);
                        this.inviter_id = abstractSerializedData2.readInt32(z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelParticipantAdmin, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.peer.user_id);
                        abstractSerializedData2.writeInt32(this.inviter_id);
                        abstractSerializedData2.writeInt32(this.date);
                    }
                };
                break;
            case -1743180447:
                tLRPC$TL_channelParticipantAdmin = new TLRPC$TL_channelParticipantAdmin() { // from class: org.rbmain.tgnet.TLRPC$TL_channelParticipantEditor_layer67
                    public static int constructor = -1743180447;

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelParticipantAdmin, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.peer = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = abstractSerializedData2.readInt32(z2);
                        this.inviter_id = abstractSerializedData2.readInt32(z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelParticipantAdmin, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.peer.user_id);
                        abstractSerializedData2.writeInt32(this.inviter_id);
                        abstractSerializedData2.writeInt32(this.date);
                    }
                };
                break;
            case -1557620115:
                tLRPC$TL_channelParticipantAdmin = new TLRPC$ChannelParticipant() { // from class: org.rbmain.tgnet.TLRPC$TL_channelParticipantSelf
                    public static int constructor = -1557620115;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.peer = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = abstractSerializedData2.readInt32(z2);
                        this.inviter_id = abstractSerializedData2.readInt32(z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.peer.user_id);
                        abstractSerializedData2.writeInt32(this.inviter_id);
                        abstractSerializedData2.writeInt32(this.date);
                    }
                };
                break;
            case -1473271656:
                tLRPC$TL_channelParticipantAdmin = new TLRPC$TL_channelParticipantAdmin() { // from class: org.rbmain.tgnet.TLRPC$TL_channelParticipantAdmin_layer92
                    public static int constructor = -1473271656;

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelParticipantAdmin, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.can_edit = (int32 & 1) != 0;
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.peer = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = abstractSerializedData2.readInt32(z2);
                        this.inviter_id = abstractSerializedData2.readInt32(z2);
                        this.promoted_by = abstractSerializedData2.readInt32(z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                        TLRPC$TL_channelAdminRights_layer92 tLRPC$TL_channelAdminRights_layer92TLdeserialize = TLRPC$TL_channelAdminRights_layer92.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.admin_rights_layer92 = tLRPC$TL_channelAdminRights_layer92TLdeserialize;
                        this.admin_rights = TLRPC$Chat.mergeAdminRights(tLRPC$TL_channelAdminRights_layer92TLdeserialize);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelParticipantAdmin, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.can_edit ? this.flags | 1 : this.flags & (-2);
                        this.flags = i2;
                        abstractSerializedData2.writeInt32(i2);
                        abstractSerializedData2.writeInt32(this.peer.user_id);
                        abstractSerializedData2.writeInt32(this.inviter_id);
                        abstractSerializedData2.writeInt32(this.promoted_by);
                        abstractSerializedData2.writeInt32(this.date);
                        this.admin_rights_layer92.serializeToStream(abstractSerializedData2);
                    }
                };
                break;
            case -1010402965:
                tLRPC$TL_channelParticipantAdmin = new TLRPC$TL_channelParticipantLeft() { // from class: org.rbmain.tgnet.TLRPC$TL_channelParticipantLeft_layer125
                    public static int constructor = -1010402965;

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelParticipantLeft, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.peer = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelParticipantLeft, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.peer.user_id);
                    }
                };
                break;
            case -859915345:
                tLRPC$TL_channelParticipantAdmin = new TLRPC$TL_channelParticipantAdmin();
                break;
            case -471670279:
                tLRPC$TL_channelParticipantAdmin = new TLRPC$TL_channelParticipantCreator() { // from class: org.rbmain.tgnet.TLRPC$TL_channelParticipantCreator_layer103
                    public static int constructor = -471670279;

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelParticipantCreator, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.peer = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelParticipantCreator, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.peer.user_id);
                    }
                };
                break;
            case 367766557:
                tLRPC$TL_channelParticipantAdmin = new TLRPC$TL_channelParticipant();
                break;
            case 453242886:
                tLRPC$TL_channelParticipantAdmin = new TLRPC$TL_channelParticipantLeft();
                break;
            case 470789295:
                tLRPC$TL_channelParticipantAdmin = new TLRPC$TL_channelParticipantBanned() { // from class: org.rbmain.tgnet.TLRPC$TL_channelParticipantBanned_layer125
                    public static int constructor = 470789295;

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelParticipantBanned, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.left = (int32 & 1) != 0;
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.peer = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = abstractSerializedData2.readInt32(z2);
                        this.kicked_by = abstractSerializedData2.readInt32(z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.banned_rights = TLRPC$TL_chatBannedRights.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelParticipantBanned, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.left ? this.flags | 1 : this.flags & (-2);
                        this.flags = i2;
                        abstractSerializedData2.writeInt32(i2);
                        abstractSerializedData2.writeInt32(this.peer.user_id);
                        abstractSerializedData2.writeInt32(this.kicked_by);
                        abstractSerializedData2.writeInt32(this.date);
                        this.banned_rights.serializeToStream(abstractSerializedData2);
                    }
                };
                break;
            case 573315206:
                tLRPC$TL_channelParticipantAdmin = new TLRPC$TL_channelParticipantBanned() { // from class: org.rbmain.tgnet.TLRPC$TL_channelParticipantBanned_layer92
                    public static int constructor = 573315206;

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelParticipantBanned, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.left = (int32 & 1) != 0;
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.peer = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = abstractSerializedData2.readInt32(z2);
                        this.kicked_by = abstractSerializedData2.readInt32(z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                        TLRPC$TL_channelBannedRights_layer92 tLRPC$TL_channelBannedRights_layer92TLdeserialize = TLRPC$TL_channelBannedRights_layer92.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.banned_rights_layer92 = tLRPC$TL_channelBannedRights_layer92TLdeserialize;
                        this.banned_rights = TLRPC$Chat.mergeBannedRights(tLRPC$TL_channelBannedRights_layer92TLdeserialize);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelParticipantBanned, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.left ? this.flags | 1 : this.flags & (-2);
                        this.flags = i2;
                        abstractSerializedData2.writeInt32(i2);
                        abstractSerializedData2.writeInt32(this.peer.user_id);
                        abstractSerializedData2.writeInt32(this.kicked_by);
                        abstractSerializedData2.writeInt32(this.date);
                        this.banned_rights_layer92.serializeToStream(abstractSerializedData2);
                    }
                };
                break;
            case 1149094475:
                tLRPC$TL_channelParticipantAdmin = new TLRPC$TL_channelParticipantCreator();
                break;
            case 1352785878:
                tLRPC$TL_channelParticipantAdmin = new TLRPC$TL_channelParticipantBanned();
                break;
            case 1571450403:
                tLRPC$TL_channelParticipantAdmin = new TLRPC$TL_channelParticipantAdmin() { // from class: org.rbmain.tgnet.TLRPC$TL_channelParticipantAdmin_layer103
                    public static int constructor = 1571450403;

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelParticipantAdmin, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.can_edit = (int32 & 1) != 0;
                        this.self = (int32 & 2) != 0;
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.peer = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = abstractSerializedData2.readInt32(z2);
                        if ((this.flags & 2) != 0) {
                            this.inviter_id = abstractSerializedData2.readInt32(z2);
                        }
                        this.promoted_by = abstractSerializedData2.readInt32(z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.admin_rights = TLRPC$TL_chatAdminRights.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelParticipantAdmin, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.can_edit ? this.flags | 1 : this.flags & (-2);
                        this.flags = i2;
                        int i3 = this.self ? i2 | 2 : i2 & (-3);
                        this.flags = i3;
                        abstractSerializedData2.writeInt32(i3);
                        abstractSerializedData2.writeInt32(this.peer.user_id);
                        if ((this.flags & 2) != 0) {
                            abstractSerializedData2.writeInt32(this.inviter_id);
                        }
                        abstractSerializedData2.writeInt32(this.promoted_by);
                        abstractSerializedData2.writeInt32(this.date);
                        this.admin_rights.serializeToStream(abstractSerializedData2);
                    }
                };
                break;
            default:
                tLRPC$TL_channelParticipantAdmin = null;
                break;
        }
        if (tLRPC$TL_channelParticipantAdmin == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in ChannelParticipant", Integer.valueOf(i)));
        }
        if (tLRPC$TL_channelParticipantAdmin != null) {
            tLRPC$TL_channelParticipantAdmin.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_channelParticipantAdmin;
    }
}
