package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$Update extends TLObject {
    public static TLRPC$Update TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$Update tLRPC$TL_updateTheme;
        switch (constructor) {
            case -2112423005:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateTheme();
                break;
            case -2092401936:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateChatUserTyping();
                break;
            case -2027964103:
                tLRPC$TL_updateTheme = new TLRPC$Update() { // from class: ir.eitaa.tgnet.TLRPC$TL_updateGeoLiveViewed
                    public static int constructor = -2027964103;
                    public int msg_id;
                    public TLRPC$Peer peer;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.peer = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.msg_id = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        this.peer.serializeToStream(stream2);
                        stream2.writeInt32(this.msg_id);
                    }
                };
                break;
            case -1937192669:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateChannelUserTyping();
                break;
            case -1906403213:
                tLRPC$TL_updateTheme = new TLRPC$Update() { // from class: ir.eitaa.tgnet.TLRPC$TL_updateDcOptions
                    public static int constructor = -1906403213;
                    public ArrayList<TLRPC$TL_dcOption> dc_options = new ArrayList<>();

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        if (int32 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = stream2.readInt32(exception2);
                        for (int i = 0; i < int322; i++) {
                            TLRPC$TL_dcOption tLRPC$TL_dcOptionTLdeserialize = TLRPC$TL_dcOption.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$TL_dcOptionTLdeserialize == null) {
                                return;
                            }
                            this.dc_options.add(tLRPC$TL_dcOptionTLdeserialize);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(481674261);
                        int size = this.dc_options.size();
                        stream2.writeInt32(size);
                        for (int i = 0; i < size; i++) {
                            this.dc_options.get(i).serializeToStream(stream2);
                        }
                    }
                };
                break;
            case -1870238482:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateDeleteScheduledMessages();
                break;
            case -1842450928:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateReadChannelInbox();
                break;
            case -1821035490:
                tLRPC$TL_updateTheme = new TLRPC$Update() { // from class: ir.eitaa.tgnet.TLRPC$TL_updateSavedGifs
                    public static int constructor = -1821035490;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case -1738720581:
                tLRPC$TL_updateTheme = new TLRPC$Update() { // from class: ir.eitaa.tgnet.TLRPC$TL_updateChannelParticipant
                    public static int constructor = -1738720581;
                    public long actor_id;
                    public long channel_id;
                    public int date;
                    public int flags;
                    public TLRPC$ExportedChatInvite invite;
                    public TLRPC$ChannelParticipant new_participant;
                    public TLRPC$ChannelParticipant prev_participant;
                    public int qts;
                    public long user_id;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.flags = stream2.readInt32(exception2);
                        this.channel_id = stream2.readInt64(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.actor_id = stream2.readInt64(exception2);
                        this.user_id = stream2.readInt64(exception2);
                        if ((this.flags & 1) != 0) {
                            this.prev_participant = TLRPC$ChannelParticipant.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.new_participant = TLRPC$ChannelParticipant.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.invite = TLRPC$ExportedChatInvite.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        this.qts = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.flags);
                        stream2.writeInt64(this.channel_id);
                        stream2.writeInt32(this.date);
                        stream2.writeInt64(this.actor_id);
                        stream2.writeInt64(this.user_id);
                        if ((this.flags & 1) != 0) {
                            this.prev_participant.serializeToStream(stream2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.new_participant.serializeToStream(stream2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.invite.serializeToStream(stream2);
                        }
                        stream2.writeInt32(this.qts);
                    }
                };
                break;
            case -1706939360:
                tLRPC$TL_updateTheme = new TLRPC$Update() { // from class: ir.eitaa.tgnet.TLRPC$TL_updateRecentStickers
                    public static int constructor = -1706939360;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case -1667805217:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateReadHistoryInbox();
                break;
            case -1576161051:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateDeleteMessages();
                break;
            case -1574314746:
                tLRPC$TL_updateTheme = new TLRPC$Update() { // from class: ir.eitaa.tgnet.TLRPC$TL_updateConfig
                    public static int constructor = -1574314746;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case -1512627963:
                tLRPC$TL_updateTheme = new TLRPC$Update() { // from class: ir.eitaa.tgnet.TLRPC$TL_updateDialogFilterOrder
                    public static int constructor = -1512627963;
                    public ArrayList<Integer> order = new ArrayList<>();

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        if (int32 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                        } else {
                            int int322 = stream2.readInt32(exception2);
                            for (int i = 0; i < int322; i++) {
                                this.order.add(Integer.valueOf(stream2.readInt32(exception2)));
                            }
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(481674261);
                        int size = this.order.size();
                        stream2.writeInt32(size);
                        for (int i = 0; i < size; i++) {
                            stream2.writeInt32(this.order.get(i).intValue());
                        }
                    }
                };
                break;
            case -1425052898:
                tLRPC$TL_updateTheme = new TLRPC$TL_updatePhoneCall();
                break;
            case -1398708869:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateMessagePoll();
                break;
            case -1304443240:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateChannelAvailableMessages();
                break;
            case -1264392051:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateEncryption();
                break;
            case -1263546448:
                tLRPC$TL_updateTheme = new TLRPC$TL_updatePeerLocated();
                break;
            case -1218471511:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateReadChannelOutbox();
                break;
            case -1147422299:
                tLRPC$TL_updateTheme = new TLRPC$TL_updatePeerHistoryTTL();
                break;
            case -1094555409:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateNotifySettings();
                break;
            case -1071741569:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateUserTyping();
                break;
            case -1020437742:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateDeleteChannelMessages();
                break;
            case -1007549728:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateUserName();
                break;
            case -761649164:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateChannelMessageForwards();
                break;
            case -693004986:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateReadChannelDiscussionInbox();
                break;
            case -674602590:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateChatParticipantAdmin();
                break;
            case -513517117:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateDialogUnreadMark();
                break;
            case -483443337:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateChatParticipantDelete();
                break;
            case -469536605:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateEditMessage();
                break;
            case -451831443:
                tLRPC$TL_updateTheme = new TLRPC$Update() { // from class: ir.eitaa.tgnet.TLRPC$TL_updateFavedStickers
                    public static int constructor = -451831443;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case -440534818:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateUserStatus();
                break;
            case -337352679:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateServiceNotification();
                break;
            case -309990731:
                tLRPC$TL_updateTheme = new TLRPC$TL_updatePinnedMessages();
                break;
            case -299124375:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateDraftMessage();
                break;
            case -298113238:
                tLRPC$TL_updateTheme = new TLRPC$TL_updatePrivacy();
                break;
            case -232346616:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateChannelMessageViews();
                break;
            case -232290676:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateUserPhoto();
                break;
            case -219423922:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateGroupCallParticipants();
                break;
            case -124097970:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateChat();
                break;
            case -99664734:
                tLRPC$TL_updateTheme = new TLRPC$TL_updatePinnedDialogs();
                break;
            case 69703124:
                tLRPC$TL_updateTheme = new TLRPC$Update() { // from class: ir.eitaa.tgnet.TLRPC$TL_updateEitaaNotification
                    public static int constructor = 69703124;
                    public boolean deleted;
                    public int expireDate;
                    public int flags;
                    public int id;
                    public String link;
                    public TLRPC$TL_EitaaNotification_message message;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.flags = stream2.readInt32(exception2);
                        this.id = stream2.readInt32(exception2);
                        int i = this.flags;
                        this.deleted = (i & 1) != 0;
                        if ((i & 2) != 0) {
                            this.link = stream2.readString(exception2);
                        }
                        this.expireDate = stream2.readInt32(exception2);
                        this.message = TLRPC$TL_EitaaNotification_message.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.flags);
                        stream2.writeInt32(this.id);
                        if ((this.flags & 2) != 0) {
                            stream2.writeString(this.link);
                        }
                        stream2.writeInt32(this.expireDate);
                        this.message.serializeToStream(stream2);
                    }
                };
                break;
            case 88680979:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateUserPhone();
                break;
            case 125178264:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateChatParticipants();
                break;
            case 192428418:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateGroupCallConnection();
                break;
            case 196268545:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateStickerSetsOrder();
                break;
            case 277713951:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateChannelTooLong();
                break;
            case 314359194:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateNewEncryptedMessage();
                break;
            case 347227392:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateGroupCall();
                break;
            case 357013699:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateMessageReactions();
                break;
            case 386986326:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateEncryptedChatTyping();
                break;
            case 422972864:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateFolderPeers();
                break;
            case 457133559:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateEditChannelMessage();
                break;
            case 522914557:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateNewMessage();
                break;
            case 610945826:
                tLRPC$TL_updateTheme = new TLRPC$TL_updatePeerBlocked();
                break;
            case 643940105:
                tLRPC$TL_updateTheme = new TLRPC$TL_updatePhoneCallSignalingData();
                break;
            case 654302845:
                tLRPC$TL_updateTheme = new TLRPC$Update() { // from class: ir.eitaa.tgnet.TLRPC$TL_updateDialogFilter
                    public static int constructor = 654302845;
                    public TLRPC$TL_dialogFilter filter;
                    public int flags;
                    public int id;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.flags = stream2.readInt32(exception2);
                        this.id = stream2.readInt32(exception2);
                        if ((this.flags & 1) != 0) {
                            this.filter = TLRPC$TL_dialogFilter.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.flags);
                        stream2.writeInt32(this.id);
                        if ((this.flags & 1) != 0) {
                            this.filter.serializeToStream(stream2);
                        }
                    }
                };
                break;
            case 791390623:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateChannelWebPage();
                break;
            case 791617983:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateReadHistoryOutbox();
                break;
            case 889491791:
                tLRPC$TL_updateTheme = new TLRPC$Update() { // from class: ir.eitaa.tgnet.TLRPC$TL_updateDialogFilters
                    public static int constructor = 889491791;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case 956179895:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateEncryptedMessagesRead();
                break;
            case 967122427:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateNewScheduledMessage();
                break;
            case 1037718609:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateChatParticipantAdd();
                break;
            case 1135492588:
                tLRPC$TL_updateTheme = new TLRPC$Update() { // from class: ir.eitaa.tgnet.TLRPC$TL_updateStickerSets
                    public static int constructor = 1135492588;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case 1153291573:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateChannelReadMessagesContents();
                break;
            case 1180041828:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateLangPackTooLong();
                break;
            case 1299263278:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateBotCommands();
                break;
            case 1318109142:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateMessageID();
                break;
            case 1421875280:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateChatDefaultBannedRights();
                break;
            case 1442983757:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateLangPack();
                break;
            case 1448076945:
                tLRPC$TL_updateTheme = new TLRPC$Update() { // from class: ir.eitaa.tgnet.TLRPC$TL_updateLoginToken
                    public static int constructor = 1448076945;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case 1461528386:
                tLRPC$TL_updateTheme = new TLRPC$Update() { // from class: ir.eitaa.tgnet.TLRPC$TL_updateReadFeaturedStickers
                    public static int constructor = 1461528386;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case 1538885128:
                tLRPC$TL_updateTheme = new TLRPC$TL_updatePinnedChannelMessages();
                break;
            case 1656358105:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateNewChannelMessage();
                break;
            case 1666927625:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateChannel();
                break;
            case 1753886890:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateNewStickerSet();
                break;
            case 1757493555:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateReadMessagesContents();
                break;
            case 1767677564:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateReadChannelDiscussionOutbox();
                break;
            case 1786671974:
                tLRPC$TL_updateTheme = new TLRPC$TL_updatePeerSettings();
                break;
            case 1852826908:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateDialogPinned();
                break;
            case 1887741886:
                tLRPC$TL_updateTheme = new TLRPC$Update() { // from class: ir.eitaa.tgnet.TLRPC$TL_updateContactsReset
                    public static int constructor = 1887741886;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case 2139689491:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateWebPage();
                break;
            default:
                tLRPC$TL_updateTheme = null;
                break;
        }
        if (tLRPC$TL_updateTheme == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in Update", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_updateTheme != null) {
            tLRPC$TL_updateTheme.readParams(stream, exception);
        }
        return tLRPC$TL_updateTheme;
    }
}
