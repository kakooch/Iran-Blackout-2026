package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class TLRPC$Update extends TLObject {
    public static TLRPC$Update TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$Update tLRPC$TL_updateTheme;
        switch (i) {
            case -2112423005:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateTheme();
                break;
            case -2054649973:
                tLRPC$TL_updateTheme = new TLRPC$TL_updatePinnedChannelMessages();
                break;
            case -2033525908:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateChatUserTyping();
                break;
            case -2027964103:
                tLRPC$TL_updateTheme = new TLRPC$Update() { // from class: org.rbmain.tgnet.TLRPC$TL_updateGeoLiveViewed
                    public static int constructor = -2027964103;
                    public long msg_id;
                    public TLRPC$Peer peer;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.peer = TLRPC$Peer.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.msg_id = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        this.peer.serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32((int) this.msg_id);
                    }
                };
                break;
            case -1987495099:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateChannelReadMessagesContents();
                break;
            case -1906403213:
                tLRPC$TL_updateTheme = new TLRPC$Update() { // from class: org.rbmain.tgnet.TLRPC$TL_updateDcOptions
                    public static int constructor = -1906403213;
                    public ArrayList<TLRPC$TL_dcOption> dc_options = new ArrayList<>();

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        if (int32 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int322; i2++) {
                            TLRPC$TL_dcOption tLRPC$TL_dcOptionTLdeserialize = TLRPC$TL_dcOption.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$TL_dcOptionTLdeserialize == null) {
                                return;
                            }
                            this.dc_options.add(tLRPC$TL_dcOptionTLdeserialize);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.dc_options.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i2 = 0; i2 < size; i2++) {
                            this.dc_options.get(i2).serializeToStream(abstractSerializedData2);
                        }
                    }
                };
                break;
            case -1870238482:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateDeleteScheduledMessages();
                break;
            case -1821035490:
                tLRPC$TL_updateTheme = new TLRPC$Update() { // from class: org.rbmain.tgnet.TLRPC$TL_updateSavedGifs
                    public static int constructor = -1821035490;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            case -1791935732:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateUserPhoto();
                break;
            case -1734268085:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateChannelMessageViews();
                break;
            case -1706939360:
                tLRPC$TL_updateTheme = new TLRPC$Update() { // from class: org.rbmain.tgnet.TLRPC$TL_updateRecentStickers
                    public static int constructor = -1706939360;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
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
                tLRPC$TL_updateTheme = new TLRPC$Update() { // from class: org.rbmain.tgnet.TLRPC$TL_updateConfig
                    public static int constructor = -1574314746;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            case -1537295973:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateGroupCall();
                break;
            case -1512627963:
                tLRPC$TL_updateTheme = new TLRPC$Update() { // from class: org.rbmain.tgnet.TLRPC$TL_updateDialogFilterOrder
                    public static int constructor = -1512627963;
                    public ArrayList<Integer> order = new ArrayList<>();

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        if (int32 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                        } else {
                            int int322 = abstractSerializedData2.readInt32(z2);
                            for (int i2 = 0; i2 < int322; i2++) {
                                this.order.add(Integer.valueOf(abstractSerializedData2.readInt32(z2)));
                            }
                        }
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.order.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i2 = 0; i2 < size; i2++) {
                            abstractSerializedData2.writeInt32(this.order.get(i2).intValue());
                        }
                    }
                };
                break;
            case -1489818765:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateUserName();
                break;
            case -1425052898:
                tLRPC$TL_updateTheme = new TLRPC$TL_updatePhoneCall();
                break;
            case -1398708869:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateMessagePoll();
                break;
            case -1264392051:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateEncryption();
                break;
            case -1263546448:
                tLRPC$TL_updateTheme = new TLRPC$TL_updatePeerLocated();
                break;
            case -1232070311:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateChatParticipantAdmin();
                break;
            case -1227598250:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateChannel();
                break;
            case -1147422299:
                tLRPC$TL_updateTheme = new TLRPC$TL_updatePeerHistoryTTL();
                break;
            case -1094555409:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateNotifySettings();
                break;
            case -1015733815:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateDeleteChannelMessages();
                break;
            case -513517117:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateDialogUnreadMark();
                break;
            case -469536605:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateEditMessage();
                break;
            case -451831443:
                tLRPC$TL_updateTheme = new TLRPC$Update() { // from class: org.rbmain.tgnet.TLRPC$TL_updateFavedStickers
                    public static int constructor = -451831443;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            case -364179876:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateChatParticipantAdd();
                break;
            case -352032773:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateChannelTooLong();
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
            case -219423922:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateGroupCallParticipants();
                break;
            case -99664734:
                tLRPC$TL_updateTheme = new TLRPC$TL_updatePinnedDialogs();
                break;
            case 125178264:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateChatParticipants();
                break;
            case 196268545:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateStickerSetsOrder();
                break;
            case 314130811:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateUserPhone();
                break;
            case 314359194:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateNewEncryptedMessage();
                break;
            case 321954198:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateChat();
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
            case 469489699:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateUserStatus();
                break;
            case 482860628:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateReadChannelDiscussionInbox();
                break;
            case 522914557:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateNewMessage();
                break;
            case 610945826:
                tLRPC$TL_updateTheme = new TLRPC$TL_updatePeerBlocked();
                break;
            case 634833351:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateReadChannelOutbox();
                break;
            case 643940105:
                tLRPC$TL_updateTheme = new TLRPC$TL_updatePhoneCallSignalingData();
                break;
            case 654302845:
                tLRPC$TL_updateTheme = new TLRPC$Update() { // from class: org.rbmain.tgnet.TLRPC$TL_updateDialogFilter
                    public static int constructor = 654302845;
                    public TLRPC$TL_dialogFilter filter;
                    public int flags;
                    public int id;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.flags = abstractSerializedData2.readInt32(z2);
                        this.id = abstractSerializedData2.readInt32(z2);
                        if ((this.flags & 1) != 0) {
                            this.filter = TLRPC$TL_dialogFilter.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.flags);
                        abstractSerializedData2.writeInt32(this.id);
                        if ((this.flags & 1) != 0) {
                            this.filter.serializeToStream(abstractSerializedData2);
                        }
                    }
                };
                break;
            case 791617983:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateReadHistoryOutbox();
                break;
            case 856380452:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateReadChannelInbox();
                break;
            case 889491791:
                tLRPC$TL_updateTheme = new TLRPC$Update() { // from class: org.rbmain.tgnet.TLRPC$TL_updateDialogFilters
                    public static int constructor = 889491791;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            case 956179895:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateEncryptedMessagesRead();
                break;
            case 967122427:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateNewScheduledMessage();
                break;
            case 1081547008:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateChannelWebPage();
                break;
            case 1135492588:
                tLRPC$TL_updateTheme = new TLRPC$Update() { // from class: org.rbmain.tgnet.TLRPC$TL_updateStickerSets
                    public static int constructor = 1135492588;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            case 1178116716:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateReadChannelDiscussionOutbox();
                break;
            case 1180041828:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateLangPackTooLong();
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
                tLRPC$TL_updateTheme = new TLRPC$Update() { // from class: org.rbmain.tgnet.TLRPC$TL_updateLoginToken
                    public static int constructor = 1448076945;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            case 1461528386:
                tLRPC$TL_updateTheme = new TLRPC$Update() { // from class: org.rbmain.tgnet.TLRPC$TL_updateReadFeaturedStickers
                    public static int constructor = 1461528386;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            case 1548249383:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateUserTyping();
                break;
            case 1656358105:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateNewChannelMessage();
                break;
            case 1708307556:
                tLRPC$TL_updateTheme = new TLRPC$Update() { // from class: org.rbmain.tgnet.TLRPC$TL_updateChannelParticipant
                    public static int constructor = 1708307556;
                    public int channel_id;
                    public int date;
                    public int flags;
                    public TLRPC$ChannelParticipant new_participant;
                    public TLRPC$ChannelParticipant prev_participant;
                    public int qts;
                    public int user_id;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.flags = abstractSerializedData2.readInt32(z2);
                        this.channel_id = abstractSerializedData2.readInt32(z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.user_id = abstractSerializedData2.readInt32(z2);
                        if ((this.flags & 1) != 0) {
                            this.prev_participant = TLRPC$ChannelParticipant.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.new_participant = TLRPC$ChannelParticipant.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        this.qts = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.flags);
                        abstractSerializedData2.writeInt32(this.channel_id);
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeInt32(this.user_id);
                        if ((this.flags & 1) != 0) {
                            this.prev_participant.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.new_participant.serializeToStream(abstractSerializedData2);
                        }
                        abstractSerializedData2.writeInt32(this.qts);
                    }
                };
                break;
            case 1753886890:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateNewStickerSet();
                break;
            case 1757493555:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateReadMessagesContents();
                break;
            case 1786671974:
                tLRPC$TL_updateTheme = new TLRPC$TL_updatePeerSettings();
                break;
            case 1796675352:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateChannelUserTyping();
                break;
            case 1851755554:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateChatParticipantDelete();
                break;
            case 1852826908:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateDialogPinned();
                break;
            case 1854571743:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateChannelMessageForwards();
                break;
            case 1887741886:
                tLRPC$TL_updateTheme = new TLRPC$Update() { // from class: org.rbmain.tgnet.TLRPC$TL_updateContactsReset
                    public static int constructor = 1887741886;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            case 1893427255:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateChannelAvailableMessages();
                break;
            case 2139689491:
                tLRPC$TL_updateTheme = new TLRPC$TL_updateWebPage();
                break;
            default:
                tLRPC$TL_updateTheme = null;
                break;
        }
        if (tLRPC$TL_updateTheme == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in Update", Integer.valueOf(i)));
        }
        if (tLRPC$TL_updateTheme != null) {
            tLRPC$TL_updateTheme.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_updateTheme;
    }
}
