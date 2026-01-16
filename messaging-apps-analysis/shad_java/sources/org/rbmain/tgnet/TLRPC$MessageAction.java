package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class TLRPC$MessageAction extends TLObject {
    public String address;
    public TLRPC$TL_inputGroupCall call;
    public String call_id;
    public int channel_id;
    public int chat_id;
    public String currency;
    public int duration;
    public TLRPC$DecryptedMessageAction encryptedAction;
    public int flags;
    public long game_id;
    public int inviter_id;
    public String message;
    public TLRPC$UserProfilePhoto newUserPhoto;
    public TLRPC$Photo photo;
    public TLRPC$PhoneCallDiscardReason reason;
    public int score;
    public String title;
    public long total_amount;
    public int ttl;
    public int user_id;
    public ArrayList<Integer> users = new ArrayList<>();
    public boolean video;
    public TLRPC$WallPaper wallpaper;

    public static TLRPC$MessageAction TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$MessageAction tLRPC$TL_messageActionPhoneCall;
        switch (i) {
            case -2132731265:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageActionPhoneCall();
                break;
            case -1834538890:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$MessageAction() { // from class: org.rbmain.tgnet.TLRPC$TL_messageActionGameScore
                    public static int constructor = -1834538890;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.game_id = abstractSerializedData2.readInt64(z2);
                        this.score = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt64(this.game_id);
                        abstractSerializedData2.writeInt32(this.score);
                    }
                };
                break;
            case -1799538451:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageActionPinMessage();
                break;
            case -1781355374:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageActionChannelCreate();
                break;
            case -1780220945:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageActionChatDeletePhoto();
                break;
            case -1776926890:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$MessageAction() { // from class: org.rbmain.tgnet.TLRPC$TL_messageActionPaymentSent
                    public static int constructor = 1080663248;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.currency = abstractSerializedData2.readString(z2);
                        this.total_amount = abstractSerializedData2.readInt64(z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeString(this.currency);
                        abstractSerializedData2.writeInt64(this.total_amount);
                    }
                };
                break;
            case -1730095465:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageActionGeoProximityReached();
                break;
            case -1615153660:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$MessageAction() { // from class: org.rbmain.tgnet.TLRPC$TL_messageActionHistoryClear
                    public static int constructor = -1615153660;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            case -1539362612:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageActionChatDeleteUser();
                break;
            case -1503425638:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageActionChatCreate() { // from class: org.rbmain.tgnet.TLRPC$TL_messageActionChatCreate_layer131
                    public static int constructor = -1503425638;

                    @Override // org.rbmain.tgnet.TLRPC$TL_messageActionChatCreate, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.title = abstractSerializedData2.readString(z2);
                        int int32 = abstractSerializedData2.readInt32(z2);
                        if (int32 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                        } else {
                            int int322 = abstractSerializedData2.readInt32(z2);
                            for (int i2 = 0; i2 < int322; i2++) {
                                this.users.add(Integer.valueOf(abstractSerializedData2.readInt32(z2)));
                            }
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_messageActionChatCreate, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeString(this.title);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.users.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i2 = 0; i2 < size; i2++) {
                            abstractSerializedData2.writeInt32(this.users.get(i2).intValue());
                        }
                    }
                };
                break;
            case -1441072131:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageActionSetMessagesTTL() { // from class: org.rbmain.tgnet.TLRPC$TL_messageActionSetMessagesTTL_layer149
                    public static int constructor = -1441072131;

                    @Override // org.rbmain.tgnet.TLRPC$TL_messageActionSetMessagesTTL, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.period = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_messageActionSetMessagesTTL, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.period);
                    }
                };
                break;
            case -1434950843:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageActionSetChatTheme();
                break;
            case -1410748418:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$MessageAction() { // from class: org.rbmain.tgnet.TLRPC$TL_messageActionBotAllowed_layer153
                    public static int constructor = -1410748418;
                    public String domain;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.domain = abstractSerializedData2.readString(z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeString(this.domain);
                    }
                };
                break;
            case -1336546578:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageActionChannelMigrateFrom() { // from class: org.rbmain.tgnet.TLRPC$TL_messageActionChannelMigrateFrom_layer131
                    public static int constructor = -1336546578;

                    @Override // org.rbmain.tgnet.TLRPC$TL_messageActionChannelMigrateFrom, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.title = abstractSerializedData2.readString(z2);
                        this.chat_id = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_messageActionChannelMigrateFrom, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeString(this.title);
                        abstractSerializedData2.writeInt32(this.chat_id);
                    }
                };
                break;
            case -1316338916:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageActionTopicEdit() { // from class: org.rbmain.tgnet.TLRPC$TL_messageActionTopicEdit_layer149
                    public static int constructor = -1316338916;

                    @Override // org.rbmain.tgnet.TLRPC$TL_messageActionTopicEdit, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        if ((int32 & 1) != 0) {
                            this.title = abstractSerializedData2.readString(z2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.icon_emoji_id = abstractSerializedData2.readInt64(z2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.closed = abstractSerializedData2.readBool(z2);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_messageActionTopicEdit, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.flags);
                        if ((this.flags & 1) != 0) {
                            abstractSerializedData2.writeString(this.title);
                        }
                        if ((this.flags & 2) != 0) {
                            abstractSerializedData2.writeInt64(this.icon_emoji_id);
                        }
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeBool(this.closed);
                        }
                    }
                };
                break;
            case -1297179892:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageActionChatDeleteUser() { // from class: org.rbmain.tgnet.TLRPC$TL_messageActionChatDeleteUser_layer131
                    public static int constructor = -1297179892;

                    @Override // org.rbmain.tgnet.TLRPC$TL_messageActionChatDeleteUser, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.user_id = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_messageActionChatDeleteUser, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.user_id);
                    }
                };
                break;
            case -1281329567:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageActionGroupCallScheduled();
                break;
            case -1247687078:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageActionChatEditTitle();
                break;
            case -1230047312:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageActionEmpty();
                break;
            case -1136350937:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$MessageAction() { // from class: org.rbmain.tgnet.TLRPC$TL_messageActionSetChatWallPaper
                    public static int constructor = -1136350937;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.wallpaper = TLRPC$WallPaper.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        this.wallpaper.serializeToStream(abstractSerializedData2);
                    }
                };
                break;
            case -1119368275:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageActionChatCreate();
                break;
            case -1064024032:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageActionTopicEdit();
                break;
            case -988359047:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageActionBotAllowed();
                break;
            case -648257196:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageActionSecureValuesSent();
                break;
            case -519864430:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageActionChatMigrateTo();
                break;
            case -365344535:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageActionChannelMigrateFrom();
                break;
            case -339958837:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$MessageAction() { // from class: org.rbmain.tgnet.TLRPC$TL_messageActionChatJoinedByRequest
                    public static int constructor = -339958837;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            case -202219658:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$MessageAction() { // from class: org.rbmain.tgnet.TLRPC$TL_messageActionContactSignUp
                    public static int constructor = -202219658;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            case -85549226:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageActionCustomAction();
                break;
            case 29007925:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$MessageAction() { // from class: org.rbmain.tgnet.TLRPC$TL_messageActionPhoneNumberRequest
                    public static int constructor = 29007925;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            case 51520707:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageActionChatJoinedByLink();
                break;
            case 228168278:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$MessageAction() { // from class: org.rbmain.tgnet.TLRPC$TL_messageActionTopicCreate
                    public static int constructor = 228168278;
                    public int icon_color;
                    public long icon_emoji_id;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.flags = abstractSerializedData2.readInt32(z2);
                        this.title = abstractSerializedData2.readString(z2);
                        this.icon_color = abstractSerializedData2.readInt32(z2);
                        if ((this.flags & 1) != 0) {
                            this.icon_emoji_id = abstractSerializedData2.readInt64(z2);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.flags);
                        abstractSerializedData2.writeString(this.title);
                        abstractSerializedData2.writeInt32(this.icon_color);
                        if ((this.flags & 1) != 0) {
                            abstractSerializedData2.writeInt64(this.icon_emoji_id);
                        }
                    }
                };
                break;
            case 365886720:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageActionChatAddUser();
                break;
            case 1007897979:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageActionSetMessagesTTL();
                break;
            case 1200788123:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageActionScreenshotTaken();
                break;
            case 1217033015:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageActionChatAddUser() { // from class: org.rbmain.tgnet.TLRPC$TL_messageActionChatAddUser_layer131
                    public static int constructor = 1217033015;

                    @Override // org.rbmain.tgnet.TLRPC$TL_messageActionChatAddUser, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        if (int32 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                        } else {
                            int int322 = abstractSerializedData2.readInt32(z2);
                            for (int i2 = 0; i2 < int322; i2++) {
                                this.users.add(Integer.valueOf(abstractSerializedData2.readInt32(z2)));
                            }
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_messageActionChatAddUser, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.users.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i2 = 0; i2 < size; i2++) {
                            abstractSerializedData2.writeInt32(this.users.get(i2).intValue());
                        }
                    }
                };
                break;
            case 1345295095:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$MessageAction() { // from class: org.rbmain.tgnet.TLRPC$TL_messageActionInviteToGroupCall
                    public static int constructor = 1345295095;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.call = TLRPC$TL_inputGroupCall.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        int int32 = abstractSerializedData2.readInt32(z2);
                        if (int32 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                        } else {
                            int int322 = abstractSerializedData2.readInt32(z2);
                            for (int i2 = 0; i2 < int322; i2++) {
                                this.users.add(Integer.valueOf(abstractSerializedData2.readInt32(z2)));
                            }
                        }
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        this.call.serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.users.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i2 = 0; i2 < size; i2++) {
                            abstractSerializedData2.writeInt64(this.users.get(i2).intValue());
                        }
                    }
                };
                break;
            case 1371385889:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageActionChatMigrateTo() { // from class: org.rbmain.tgnet.TLRPC$TL_messageActionChatMigrateTo_layer131
                    public static int constructor = 1371385889;

                    @Override // org.rbmain.tgnet.TLRPC$TL_messageActionChatMigrateTo, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.channel_id = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_messageActionChatMigrateTo, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.channel_id);
                    }
                };
                break;
            case 1431655760:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$MessageAction() { // from class: org.rbmain.tgnet.TLRPC$TL_messageActionUserJoined
                    public static int constructor = 1431655760;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            case 1431655761:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$MessageAction() { // from class: org.rbmain.tgnet.TLRPC$TL_messageActionUserUpdatedPhoto
                    public static int constructor = 1431655761;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.newUserPhoto = TLRPC$UserProfilePhoto.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        this.newUserPhoto.serializeToStream(abstractSerializedData2);
                    }
                };
                break;
            case 1431655762:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$MessageAction() { // from class: org.rbmain.tgnet.TLRPC$TL_messageActionTTLChange
                    public static int constructor = 1431655762;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.ttl = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.ttl);
                    }
                };
                break;
            case 1431655767:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$MessageAction() { // from class: org.rbmain.tgnet.TLRPC$TL_messageActionCreatedBroadcastList
                    public static int constructor = 1431655767;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            case 1431655925:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$MessageAction() { // from class: org.rbmain.tgnet.TLRPC$TL_messageActionLoginUnknownLocation
                    public static int constructor = 1431655925;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.title = abstractSerializedData2.readString(z2);
                        this.address = abstractSerializedData2.readString(z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeString(this.title);
                        abstractSerializedData2.writeString(this.address);
                    }
                };
                break;
            case 1431655927:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageEncryptedAction();
                break;
            case 1581055051:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageActionChatAddUser() { // from class: org.rbmain.tgnet.TLRPC$TL_messageActionChatAddUser_old
                    public static int constructor = 1581055051;

                    @Override // org.rbmain.tgnet.TLRPC$TL_messageActionChatAddUser, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.user_id = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_messageActionChatAddUser, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.user_id);
                    }
                };
                break;
            case 2047704898:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageActionGroupCall();
                break;
            case 2144015272:
                tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageActionChatEditPhoto();
                break;
            default:
                tLRPC$TL_messageActionPhoneCall = null;
                break;
        }
        if (tLRPC$TL_messageActionPhoneCall == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in MessageAction", Integer.valueOf(i)));
        }
        if (tLRPC$TL_messageActionPhoneCall != null) {
            tLRPC$TL_messageActionPhoneCall.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_messageActionPhoneCall;
    }
}
