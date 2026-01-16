package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$ChannelParticipant extends TLObject {
    public TLRPC$TL_chatAdminRights admin_rights;
    public TLRPC$TL_channelAdminRights_layer92 admin_rights_layer92;
    public TLRPC$TL_chatBannedRights banned_rights;
    public TLRPC$TL_channelBannedRights_layer92 banned_rights_layer92;
    public boolean can_edit;
    public int date;
    public int flags;
    public long inviter_id;
    public long kicked_by;
    public boolean left;
    public TLRPC$Peer peer;
    public long promoted_by;
    public String rank;
    public boolean self;

    public static TLRPC$ChannelParticipant TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$ChannelParticipant tLRPC$TL_channelParticipant;
        switch (constructor) {
            case -2138237532:
                tLRPC$TL_channelParticipant = new TLRPC$TL_channelParticipantCreator() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelParticipantCreator_layer118
                    public static int constructor = -2138237532;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelParticipantCreator, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.flags = stream2.readInt32(exception2);
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.peer = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        if ((this.flags & 1) != 0) {
                            this.rank = stream2.readString(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelParticipantCreator, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.flags);
                        stream2.writeInt32((int) this.peer.user_id);
                        if ((this.flags & 1) != 0) {
                            stream2.writeString(this.rank);
                        }
                    }
                };
                break;
            case -1933187430:
                tLRPC$TL_channelParticipant = new TLRPC$ChannelParticipant() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelParticipantKicked_layer67
                    public static int constructor = -1933187430;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.peer = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        this.kicked_by = stream2.readInt32(exception2);
                        this.date = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.peer.user_id);
                        stream2.writeInt32((int) this.kicked_by);
                        stream2.writeInt32(this.date);
                    }
                };
                break;
            case -1861910545:
                tLRPC$TL_channelParticipant = new TLRPC$TL_channelParticipantAdmin() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelParticipantModerator_layer67
                    public static int constructor = -1861910545;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelParticipantAdmin, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.peer = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        this.inviter_id = stream2.readInt32(exception2);
                        this.date = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelParticipantAdmin, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.peer.user_id);
                        stream2.writeInt32((int) this.inviter_id);
                        stream2.writeInt32(this.date);
                    }
                };
                break;
            case -1743180447:
                tLRPC$TL_channelParticipant = new TLRPC$TL_channelParticipantAdmin() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelParticipantEditor_layer67
                    public static int constructor = -1743180447;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelParticipantAdmin, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.peer = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        this.inviter_id = stream2.readInt32(exception2);
                        this.date = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelParticipantAdmin, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.peer.user_id);
                        stream2.writeInt32((int) this.inviter_id);
                        stream2.writeInt32(this.date);
                    }
                };
                break;
            case -1557620115:
                tLRPC$TL_channelParticipant = new TLRPC$TL_channelParticipantSelf() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelParticipantSelf_layer131
                    public static int constructor = -1557620115;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelParticipantSelf, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.peer = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        this.inviter_id = stream2.readInt32(exception2);
                        this.date = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelParticipantSelf, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.peer.user_id);
                        stream2.writeInt32((int) this.inviter_id);
                        stream2.writeInt32(this.date);
                    }
                };
                break;
            case -1473271656:
                tLRPC$TL_channelParticipant = new TLRPC$TL_channelParticipantAdmin() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelParticipantAdmin_layer92
                    public static int constructor = -1473271656;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelParticipantAdmin, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.can_edit = (int32 & 1) != 0;
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.peer = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        this.inviter_id = stream2.readInt32(exception2);
                        this.promoted_by = stream2.readInt32(exception2);
                        this.date = stream2.readInt32(exception2);
                        TLRPC$TL_channelAdminRights_layer92 tLRPC$TL_channelAdminRights_layer92TLdeserialize = TLRPC$TL_channelAdminRights_layer92.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.admin_rights_layer92 = tLRPC$TL_channelAdminRights_layer92TLdeserialize;
                        this.admin_rights = TLRPC$Chat.mergeAdminRights(tLRPC$TL_channelAdminRights_layer92TLdeserialize);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelParticipantAdmin, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.can_edit ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        stream2.writeInt32(i);
                        stream2.writeInt32((int) this.peer.user_id);
                        stream2.writeInt32((int) this.inviter_id);
                        stream2.writeInt32((int) this.promoted_by);
                        stream2.writeInt32(this.date);
                        this.admin_rights_layer92.serializeToStream(stream2);
                    }
                };
                break;
            case -1072953408:
                tLRPC$TL_channelParticipant = new TLRPC$TL_channelParticipant();
                break;
            case -1010402965:
                tLRPC$TL_channelParticipant = new TLRPC$TL_channelParticipantLeft() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelParticipantLeft_layer125
                    public static int constructor = -1010402965;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelParticipantLeft, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.peer = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelParticipantLeft, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.peer.user_id);
                    }
                };
                break;
            case -859915345:
                tLRPC$TL_channelParticipant = new TLRPC$TL_channelParticipantAdmin() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelParticipantAdmin_layer131
                    public static int constructor = -859915345;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelParticipantAdmin, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.can_edit = (int32 & 1) != 0;
                        this.self = (int32 & 2) != 0;
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.peer = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        if ((this.flags & 2) != 0) {
                            this.inviter_id = stream2.readInt32(exception2);
                        }
                        this.promoted_by = stream2.readInt32(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.admin_rights = TLRPC$TL_chatAdminRights.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 4) != 0) {
                            this.rank = stream2.readString(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelParticipantAdmin, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.can_edit ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.self ? i | 2 : i & (-3);
                        this.flags = i2;
                        stream2.writeInt32(i2);
                        stream2.writeInt32((int) this.peer.user_id);
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32((int) this.inviter_id);
                        }
                        stream2.writeInt32((int) this.promoted_by);
                        stream2.writeInt32(this.date);
                        this.admin_rights.serializeToStream(stream2);
                        if ((this.flags & 4) != 0) {
                            stream2.writeString(this.rank);
                        }
                    }
                };
                break;
            case -471670279:
                tLRPC$TL_channelParticipant = new TLRPC$TL_channelParticipantCreator() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelParticipantCreator_layer103
                    public static int constructor = -471670279;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelParticipantCreator, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.peer = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelParticipantCreator, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.peer.user_id);
                    }
                };
                break;
            case 367766557:
                tLRPC$TL_channelParticipant = new TLRPC$TL_channelParticipant() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelParticipant_layer131
                    public static int constructor = 367766557;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelParticipant, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.peer = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        this.date = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelParticipant, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.peer.user_id);
                        stream2.writeInt32(this.date);
                    }
                };
                break;
            case 453242886:
                tLRPC$TL_channelParticipant = new TLRPC$TL_channelParticipantLeft();
                break;
            case 470789295:
                tLRPC$TL_channelParticipant = new TLRPC$TL_channelParticipantBanned() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelParticipantBanned_layer125
                    public static int constructor = 470789295;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelParticipantBanned, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.left = (int32 & 1) != 0;
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.peer = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        this.kicked_by = stream2.readInt32(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.banned_rights = TLRPC$TL_chatBannedRights.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelParticipantBanned, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.left ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        stream2.writeInt32(i);
                        stream2.writeInt32((int) this.peer.user_id);
                        stream2.writeInt32((int) this.kicked_by);
                        stream2.writeInt32(this.date);
                        this.banned_rights.serializeToStream(stream2);
                    }
                };
                break;
            case 573315206:
                tLRPC$TL_channelParticipant = new TLRPC$TL_channelParticipantBanned() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelParticipantBanned_layer92
                    public static int constructor = 573315206;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelParticipantBanned, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.left = (int32 & 1) != 0;
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.peer = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        this.kicked_by = stream2.readInt32(exception2);
                        this.date = stream2.readInt32(exception2);
                        TLRPC$TL_channelBannedRights_layer92 tLRPC$TL_channelBannedRights_layer92TLdeserialize = TLRPC$TL_channelBannedRights_layer92.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.banned_rights_layer92 = tLRPC$TL_channelBannedRights_layer92TLdeserialize;
                        this.banned_rights = TLRPC$Chat.mergeBannedRights(tLRPC$TL_channelBannedRights_layer92TLdeserialize);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelParticipantBanned, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.left ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        stream2.writeInt32(i);
                        stream2.writeInt32((int) this.peer.user_id);
                        stream2.writeInt32((int) this.kicked_by);
                        stream2.writeInt32(this.date);
                        this.banned_rights_layer92.serializeToStream(stream2);
                    }
                };
                break;
            case 682146919:
                tLRPC$TL_channelParticipant = new TLRPC$TL_channelParticipantSelf();
                break;
            case 803602899:
                tLRPC$TL_channelParticipant = new TLRPC$TL_channelParticipantCreator();
                break;
            case 885242707:
                tLRPC$TL_channelParticipant = new TLRPC$TL_channelParticipantAdmin();
                break;
            case 1149094475:
                tLRPC$TL_channelParticipant = new TLRPC$TL_channelParticipantCreator() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelParticipantCreator_layer131
                    public static int constructor = 1149094475;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelParticipantCreator, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.flags = stream2.readInt32(exception2);
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.peer = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        this.admin_rights = TLRPC$TL_chatAdminRights.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 1) != 0) {
                            this.rank = stream2.readString(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelParticipantCreator, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.flags);
                        stream2.writeInt32((int) this.peer.user_id);
                        this.admin_rights.serializeToStream(stream2);
                        if ((this.flags & 1) != 0) {
                            stream2.writeString(this.rank);
                        }
                    }
                };
                break;
            case 1352785878:
                tLRPC$TL_channelParticipant = new TLRPC$TL_channelParticipantBanned() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelParticipantBanned_layer131
                    public static int constructor = 1352785878;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelParticipantBanned, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.left = (int32 & 1) != 0;
                        this.peer = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.kicked_by = stream2.readInt32(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.banned_rights = TLRPC$TL_chatBannedRights.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelParticipantBanned, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.left ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        stream2.writeInt32(i);
                        this.peer.serializeToStream(stream2);
                        stream2.writeInt32((int) this.kicked_by);
                        stream2.writeInt32(this.date);
                        this.banned_rights.serializeToStream(stream2);
                    }
                };
                break;
            case 1571450403:
                tLRPC$TL_channelParticipant = new TLRPC$TL_channelParticipantAdmin() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelParticipantAdmin_layer103
                    public static int constructor = 1571450403;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelParticipantAdmin, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.can_edit = (int32 & 1) != 0;
                        this.self = (int32 & 2) != 0;
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.peer = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        if ((this.flags & 2) != 0) {
                            this.inviter_id = stream2.readInt32(exception2);
                        }
                        this.promoted_by = stream2.readInt32(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.admin_rights = TLRPC$TL_chatAdminRights.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelParticipantAdmin, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.can_edit ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.self ? i | 2 : i & (-3);
                        this.flags = i2;
                        stream2.writeInt32(i2);
                        stream2.writeInt32((int) this.peer.user_id);
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32((int) this.inviter_id);
                        }
                        stream2.writeInt32((int) this.promoted_by);
                        stream2.writeInt32(this.date);
                        this.admin_rights.serializeToStream(stream2);
                    }
                };
                break;
            case 1844969806:
                tLRPC$TL_channelParticipant = new TLRPC$TL_channelParticipantBanned();
                break;
            default:
                tLRPC$TL_channelParticipant = null;
                break;
        }
        if (tLRPC$TL_channelParticipant == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in ChannelParticipant", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_channelParticipant != null) {
            tLRPC$TL_channelParticipant.readParams(stream, exception);
        }
        return tLRPC$TL_channelParticipant;
    }
}
