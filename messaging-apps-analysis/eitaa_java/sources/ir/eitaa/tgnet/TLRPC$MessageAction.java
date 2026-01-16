package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$MessageAction extends TLObject {
    public String address;
    public TLRPC$TL_inputGroupCall call;
    public long call_id;
    public long channel_id;
    public long chat_id;
    public String currency;
    public int duration;
    public TLRPC$DecryptedMessageAction encryptedAction;
    public int flags;
    public long game_id;
    public long inviter_id;
    public String message;
    public TLRPC$UserProfilePhoto newUserPhoto;
    public TLRPC$Photo photo;
    public TLRPC$PhoneCallDiscardReason reason;
    public int score;
    public String title;
    public long total_amount;
    public int ttl;
    public long user_id;
    public ArrayList<Long> users = new ArrayList<>();
    public boolean video;

    public static TLRPC$MessageAction TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$MessageAction tLRPC$TL_messageActionChatDeletePhoto;
        switch (constructor) {
            case -2132731265:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$MessageAction() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageActionPhoneCall
                    public static int constructor = -2132731265;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.video = (int32 & 4) != 0;
                        this.call_id = stream2.readInt64(exception2);
                        if ((this.flags & 1) != 0) {
                            this.reason = TLRPC$PhoneCallDiscardReason.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.duration = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.video ? this.flags | 4 : this.flags & (-5);
                        this.flags = i;
                        stream2.writeInt32(i);
                        stream2.writeInt64(this.call_id);
                        if ((this.flags & 1) != 0) {
                            this.reason.serializeToStream(stream2);
                        }
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32(this.duration);
                        }
                    }
                };
                break;
            case -1834538890:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$MessageAction() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageActionGameScore
                    public static int constructor = -1834538890;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.game_id = stream2.readInt64(exception2);
                        this.score = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt64(this.game_id);
                        stream2.writeInt32(this.score);
                    }
                };
                break;
            case -1799538451:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$MessageAction() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageActionPinMessage
                    public static int constructor = -1799538451;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case -1781355374:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$MessageAction() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageActionChannelCreate
                    public static int constructor = -1781355374;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.title = stream2.readString(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeString(this.title);
                    }
                };
                break;
            case -1780220945:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$TL_messageActionChatDeletePhoto();
                break;
            case -1730095465:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$TL_messageActionGeoProximityReached();
                break;
            case -1615153660:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$TL_messageActionHistoryClear();
                break;
            case -1539362612:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$TL_messageActionChatDeleteUser();
                break;
            case -1503425638:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$TL_messageActionChatCreate() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageActionChatCreate_layer131
                    public static int constructor = -1503425638;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageActionChatCreate, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.title = stream2.readString(exception2);
                        int int32 = stream2.readInt32(exception2);
                        if (int32 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                        } else {
                            int int322 = stream2.readInt32(exception2);
                            for (int i = 0; i < int322; i++) {
                                this.users.add(Long.valueOf(stream2.readInt32(exception2)));
                            }
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageActionChatCreate, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeString(this.title);
                        stream2.writeInt32(481674261);
                        int size = this.users.size();
                        stream2.writeInt32(size);
                        for (int i = 0; i < size; i++) {
                            stream2.writeInt32((int) this.users.get(i).longValue());
                        }
                    }
                };
                break;
            case -1441072131:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$TL_messageActionSetMessagesTTL();
                break;
            case -1434950843:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$TL_messageActionSetChatTheme();
                break;
            case -1410748418:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$TL_messageActionBotAllowed();
                break;
            case -1336546578:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$TL_messageActionChannelMigrateFrom() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageActionChannelMigrateFrom_layer131
                    public static int constructor = -1336546578;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageActionChannelMigrateFrom, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.title = stream2.readString(exception2);
                        this.chat_id = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageActionChannelMigrateFrom, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeString(this.title);
                        stream2.writeInt32((int) this.chat_id);
                    }
                };
                break;
            case -1297179892:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$TL_messageActionChatDeleteUser() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageActionChatDeleteUser_layer131
                    public static int constructor = -1297179892;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageActionChatDeleteUser, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.user_id = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageActionChatDeleteUser, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.user_id);
                    }
                };
                break;
            case -1281329567:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$TL_messageActionGroupCallScheduled();
                break;
            case -1247687078:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$MessageAction() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageActionChatEditTitle
                    public static int constructor = -1247687078;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.title = stream2.readString(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeString(this.title);
                    }
                };
                break;
            case -1230047312:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$TL_messageActionEmpty();
                break;
            case -1119368275:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$TL_messageActionChatCreate();
                break;
            case -648257196:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$TL_messageActionSecureValuesSent();
                break;
            case -519864430:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$TL_messageActionChatMigrateTo();
                break;
            case -365344535:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$TL_messageActionChannelMigrateFrom();
                break;
            case -202219658:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$MessageAction() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageActionContactSignUp
                    public static int constructor = -202219658;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case -123931160:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$TL_messageActionChatJoinedByLink() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageActionChatJoinedByLink_layer131
                    public static int constructor = -123931160;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageActionChatJoinedByLink, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.inviter_id = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageActionChatJoinedByLink, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.inviter_id);
                    }
                };
                break;
            case -85549226:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$MessageAction() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageActionCustomAction
                    public static int constructor = -85549226;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.message = stream2.readString(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeString(this.message);
                    }
                };
                break;
            case 51520707:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$TL_messageActionChatJoinedByLink();
                break;
            case 365886720:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$TL_messageActionChatAddUser();
                break;
            case 1080663248:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$MessageAction() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageActionPaymentSent
                    public static int constructor = 1080663248;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.currency = stream2.readString(exception2);
                        this.total_amount = stream2.readInt64(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeString(this.currency);
                        stream2.writeInt64(this.total_amount);
                    }
                };
                break;
            case 1200788123:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$TL_messageActionScreenshotTaken();
                break;
            case 1217033015:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$TL_messageActionChatAddUser() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageActionChatAddUser_layer131
                    public static int constructor = 1217033015;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageActionChatAddUser, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        if (int32 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                        } else {
                            int int322 = stream2.readInt32(exception2);
                            for (int i = 0; i < int322; i++) {
                                this.users.add(Long.valueOf(stream2.readInt32(exception2)));
                            }
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageActionChatAddUser, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(481674261);
                        int size = this.users.size();
                        stream2.writeInt32(size);
                        for (int i = 0; i < size; i++) {
                            stream2.writeInt32((int) this.users.get(i).longValue());
                        }
                    }
                };
                break;
            case 1345295095:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$TL_messageActionInviteToGroupCall();
                break;
            case 1371385889:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$TL_messageActionChatMigrateTo() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageActionChatMigrateTo_layer131
                    public static int constructor = 1371385889;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageActionChatMigrateTo, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.channel_id = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageActionChatMigrateTo, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.channel_id);
                    }
                };
                break;
            case 1431655760:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$MessageAction() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageActionUserJoined
                    public static int constructor = 1431655760;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case 1431655761:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$MessageAction() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageActionUserUpdatedPhoto
                    public static int constructor = 1431655761;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.newUserPhoto = TLRPC$UserProfilePhoto.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        this.newUserPhoto.serializeToStream(stream2);
                    }
                };
                break;
            case 1431655762:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$MessageAction() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageActionTTLChange
                    public static int constructor = 1431655762;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.ttl = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.ttl);
                    }
                };
                break;
            case 1431655767:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$MessageAction() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageActionCreatedBroadcastList
                    public static int constructor = 1431655767;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case 1431655925:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$MessageAction() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageActionLoginUnknownLocation
                    public static int constructor = 1431655925;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.title = stream2.readString(exception2);
                        this.address = stream2.readString(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeString(this.title);
                        stream2.writeString(this.address);
                    }
                };
                break;
            case 1431655927:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$TL_messageEncryptedAction();
                break;
            case 1581055051:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$TL_messageActionChatAddUser() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageActionChatAddUser_old
                    public static int constructor = 1581055051;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageActionChatAddUser, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.user_id = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageActionChatAddUser, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.user_id);
                    }
                };
                break;
            case 1991897370:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$TL_messageActionInviteToGroupCall() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageActionInviteToGroupCall_layer131
                    public static int constructor = 1991897370;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageActionInviteToGroupCall, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.call = TLRPC$TL_inputGroupCall.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        int int32 = stream2.readInt32(exception2);
                        if (int32 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                        } else {
                            int int322 = stream2.readInt32(exception2);
                            for (int i = 0; i < int322; i++) {
                                this.users.add(Long.valueOf(stream2.readInt32(exception2)));
                            }
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageActionInviteToGroupCall, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        this.call.serializeToStream(stream2);
                        stream2.writeInt32(481674261);
                        int size = this.users.size();
                        stream2.writeInt32(size);
                        for (int i = 0; i < size; i++) {
                            stream2.writeInt32((int) this.users.get(i).longValue());
                        }
                    }
                };
                break;
            case 2047704898:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$MessageAction() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageActionGroupCall
                    public static int constructor = 2047704898;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.flags = stream2.readInt32(exception2);
                        this.call = TLRPC$TL_inputGroupCall.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 1) != 0) {
                            this.duration = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.flags);
                        this.call.serializeToStream(stream2);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32(this.duration);
                        }
                    }
                };
                break;
            case 2144015272:
                tLRPC$TL_messageActionChatDeletePhoto = new TLRPC$TL_messageActionChatEditPhoto();
                break;
            default:
                tLRPC$TL_messageActionChatDeletePhoto = null;
                break;
        }
        if (tLRPC$TL_messageActionChatDeletePhoto == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in MessageAction", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_messageActionChatDeletePhoto != null) {
            tLRPC$TL_messageActionChatDeletePhoto.readParams(stream, exception);
        }
        return tLRPC$TL_messageActionChatDeletePhoto;
    }
}
