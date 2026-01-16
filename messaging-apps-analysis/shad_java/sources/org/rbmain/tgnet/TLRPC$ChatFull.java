package org.rbmain.tgnet;

import ir.aaap.messengercore.model.WarningObject;
import java.util.ArrayList;
import org.rbmain.messenger.LiteMode;
import org.rbmain.messenger.MessagesController;

/* loaded from: classes4.dex */
public abstract class TLRPC$ChatFull extends TLObject {
    public String about;
    public int admins_count;
    public int available_min_id;
    public TLRPC$ChatReactions available_reactions;
    public int banned_count;
    public boolean blocked;
    public TLRPC$TL_inputGroupCall call;
    public int call_msg_id;
    public boolean can_delete_channel;
    public boolean can_set_location;
    public boolean can_set_stickers;
    public boolean can_set_username;
    public boolean can_view_participants;
    public boolean can_view_stats;
    public TLRPC$Photo chat_photo;
    public TLRPC$Peer default_send_as;
    public boolean event_messages;
    public TLRPC$TL_chatInviteExported exported_invite;
    public int flags;
    public int folder_id;
    public TLRPC$Peer groupcall_default_join_as;
    public boolean has_scheduled;
    public boolean hidden_prehistory;
    public int id;
    public int inviterId;
    public int invitesCount;
    public int kicked_count;
    public int linked_chat_id;
    public TLRPC$ChannelLocation location;
    public int migrated_from_chat_id;
    public int migrated_from_max_id;
    public TLRPC$PeerNotifySettings notify_settings;
    public int online_count;
    public TLRPC$ChatParticipants participants;
    public int participants_count;
    public long pinned_msg_id;
    public int pts;
    public int read_inbox_max_id;
    public int read_outbox_max_id;
    public int slowmode_next_send_date;
    public int slowmode_seconds;
    public int stats_dc;
    public TLRPC$StickerSet stickerset;
    public String theme_emoticon;
    public int ttl_period;
    public int unread_count;
    public int unread_important_count;
    public WarningObject warningObject;
    public ArrayList<TLRPC$BotInfo> bot_info = new ArrayList<>();
    public ArrayList<String> pending_suggestions = new ArrayList<>();

    public static TLRPC$ChatFull TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$ChatFull tLRPC$TL_chatFull;
        switch (i) {
            case -1977734781:
                tLRPC$TL_chatFull = new TLRPC$TL_chatFull();
                break;
            case -1781833897:
                tLRPC$TL_chatFull = new TLRPC$TL_channelFull() { // from class: org.rbmain.tgnet.TLRPC$TL_channelFull_layer70
                    public static int constructor = -1781833897;

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelFull, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.can_set_username = (int32 & 64) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        this.about = abstractSerializedData2.readString(z2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.banned_count = abstractSerializedData2.readInt32(z2);
                        }
                        this.read_inbox_max_id = abstractSerializedData2.readInt32(z2);
                        this.read_outbox_max_id = abstractSerializedData2.readInt32(z2);
                        this.unread_count = abstractSerializedData2.readInt32(z2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        int int322 = abstractSerializedData2.readInt32(z2);
                        if (int322 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int323; i2++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.pinned_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelFull, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i2;
                        int i3 = this.can_set_username ? i2 | 64 : i2 & (-65);
                        this.flags = i3;
                        abstractSerializedData2.writeInt32(i3);
                        abstractSerializedData2.writeInt32(this.id);
                        abstractSerializedData2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            abstractSerializedData2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            abstractSerializedData2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.kicked_count);
                        }
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.banned_count);
                        }
                        abstractSerializedData2.writeInt32(this.read_inbox_max_id);
                        abstractSerializedData2.writeInt32(this.read_outbox_max_id);
                        abstractSerializedData2.writeInt32(this.unread_count);
                        this.chat_photo.serializeToStream(abstractSerializedData2);
                        this.notify_settings.serializeToStream(abstractSerializedData2);
                        this.exported_invite.serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i4 = 0; i4 < size; i4++) {
                            this.bot_info.get(i4).serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 16) != 0) {
                            abstractSerializedData2.writeInt32(this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            abstractSerializedData2.writeInt32(this.migrated_from_max_id);
                        }
                        if ((this.flags & 32) != 0) {
                            abstractSerializedData2.writeInt32((int) this.pinned_msg_id);
                        }
                    }
                };
                break;
            case -1749097118:
                tLRPC$TL_chatFull = new TLRPC$TL_channelFull() { // from class: org.rbmain.tgnet.TLRPC$TL_channelFull_layer52
                    public static int constructor = -1749097118;

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelFull, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.can_set_username = (int32 & 64) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        this.about = abstractSerializedData2.readString(z2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = abstractSerializedData2.readInt32(z2);
                        }
                        this.read_inbox_max_id = abstractSerializedData2.readInt32(z2);
                        this.unread_count = abstractSerializedData2.readInt32(z2);
                        this.unread_important_count = abstractSerializedData2.readInt32(z2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        int int322 = abstractSerializedData2.readInt32(z2);
                        if (int322 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int323; i2++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.pinned_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelFull, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i2;
                        int i3 = this.can_set_username ? i2 | 64 : i2 & (-65);
                        this.flags = i3;
                        abstractSerializedData2.writeInt32(i3);
                        abstractSerializedData2.writeInt32(this.id);
                        abstractSerializedData2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            abstractSerializedData2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            abstractSerializedData2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.kicked_count);
                        }
                        abstractSerializedData2.writeInt32(this.read_inbox_max_id);
                        abstractSerializedData2.writeInt32(this.unread_count);
                        abstractSerializedData2.writeInt32(this.unread_important_count);
                        this.chat_photo.serializeToStream(abstractSerializedData2);
                        this.notify_settings.serializeToStream(abstractSerializedData2);
                        this.exported_invite.serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i4 = 0; i4 < size; i4++) {
                            this.bot_info.get(i4).serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 16) != 0) {
                            abstractSerializedData2.writeInt32(this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            abstractSerializedData2.writeInt32(this.migrated_from_max_id);
                        }
                        if ((this.flags & 32) != 0) {
                            abstractSerializedData2.writeInt32((int) this.pinned_msg_id);
                        }
                    }
                };
                break;
            case -1736252138:
                tLRPC$TL_chatFull = new TLRPC$TL_channelFull() { // from class: org.rbmain.tgnet.TLRPC$TL_channelFull_layer101
                    public static int constructor = -1736252138;

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelFull, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.can_set_username = (int32 & 64) != 0;
                        this.can_set_stickers = (int32 & 128) != 0;
                        this.hidden_prehistory = (int32 & 1024) != 0;
                        this.can_view_stats = (int32 & 4096) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        this.about = abstractSerializedData2.readString(z2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.banned_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 8192) != 0) {
                            this.online_count = abstractSerializedData2.readInt32(z2);
                        }
                        this.read_inbox_max_id = abstractSerializedData2.readInt32(z2);
                        this.read_outbox_max_id = abstractSerializedData2.readInt32(z2);
                        this.unread_count = abstractSerializedData2.readInt32(z2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        int int322 = abstractSerializedData2.readInt32(z2);
                        if (int322 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int323; i2++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.pinned_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 256) != 0) {
                            this.stickerset = TLRPC$StickerSet.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 512) != 0) {
                            this.available_min_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 2048) != 0) {
                            this.folder_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 8192) != 0) {
                            this.linked_chat_id = abstractSerializedData2.readInt32(z2);
                        }
                        this.pts = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelFull, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i2;
                        int i3 = this.can_set_username ? i2 | 64 : i2 & (-65);
                        this.flags = i3;
                        int i4 = this.can_set_stickers ? i3 | 128 : i3 & (-129);
                        this.flags = i4;
                        int i5 = this.hidden_prehistory ? i4 | 1024 : i4 & (-1025);
                        this.flags = i5;
                        int i6 = this.can_view_stats ? i5 | 4096 : i5 & (-4097);
                        this.flags = i6;
                        abstractSerializedData2.writeInt32(i6);
                        abstractSerializedData2.writeInt32(this.id);
                        abstractSerializedData2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            abstractSerializedData2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            abstractSerializedData2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.kicked_count);
                        }
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.banned_count);
                        }
                        if ((this.flags & 8192) != 0) {
                            abstractSerializedData2.writeInt32(this.online_count);
                        }
                        abstractSerializedData2.writeInt32(this.read_inbox_max_id);
                        abstractSerializedData2.writeInt32(this.read_outbox_max_id);
                        abstractSerializedData2.writeInt32(this.unread_count);
                        this.chat_photo.serializeToStream(abstractSerializedData2);
                        this.notify_settings.serializeToStream(abstractSerializedData2);
                        this.exported_invite.serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i7 = 0; i7 < size; i7++) {
                            this.bot_info.get(i7).serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 16) != 0) {
                            abstractSerializedData2.writeInt32(this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            abstractSerializedData2.writeInt32(this.migrated_from_max_id);
                        }
                        if ((this.flags & 32) != 0) {
                            abstractSerializedData2.writeInt32((int) this.pinned_msg_id);
                        }
                        if ((this.flags & 256) != 0) {
                            this.stickerset.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 512) != 0) {
                            abstractSerializedData2.writeInt32(this.available_min_id);
                        }
                        if ((this.flags & 2048) != 0) {
                            abstractSerializedData2.writeInt32(this.folder_id);
                        }
                        if ((this.flags & 8192) != 0) {
                            abstractSerializedData2.writeInt32(this.linked_chat_id);
                        }
                        abstractSerializedData2.writeInt32(this.pts);
                    }
                };
                break;
            case -1640751649:
                tLRPC$TL_chatFull = new TLRPC$TL_channelFull() { // from class: org.rbmain.tgnet.TLRPC$TL_channelFull_layer48
                    public static int constructor = -1640751649;

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelFull, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        this.about = abstractSerializedData2.readString(z2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = abstractSerializedData2.readInt32(z2);
                        }
                        this.read_inbox_max_id = abstractSerializedData2.readInt32(z2);
                        this.unread_count = abstractSerializedData2.readInt32(z2);
                        this.unread_important_count = abstractSerializedData2.readInt32(z2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        int int322 = abstractSerializedData2.readInt32(z2);
                        if (int322 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int323; i2++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = abstractSerializedData2.readInt32(z2);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelFull, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i2;
                        abstractSerializedData2.writeInt32(i2);
                        abstractSerializedData2.writeInt32(this.id);
                        abstractSerializedData2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            abstractSerializedData2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            abstractSerializedData2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.kicked_count);
                        }
                        abstractSerializedData2.writeInt32(this.read_inbox_max_id);
                        abstractSerializedData2.writeInt32(this.unread_count);
                        abstractSerializedData2.writeInt32(this.unread_important_count);
                        this.chat_photo.serializeToStream(abstractSerializedData2);
                        this.notify_settings.serializeToStream(abstractSerializedData2);
                        this.exported_invite.serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i3 = 0; i3 < size; i3++) {
                            this.bot_info.get(i3).serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 16) != 0) {
                            abstractSerializedData2.writeInt32(this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            abstractSerializedData2.writeInt32(this.migrated_from_max_id);
                        }
                    }
                };
                break;
            case -1009430225:
                tLRPC$TL_chatFull = new TLRPC$TL_channelFull() { // from class: org.rbmain.tgnet.TLRPC$TL_channelFull_layer67
                    public static int constructor = -1009430225;

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelFull, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.can_set_username = (int32 & 64) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        this.about = abstractSerializedData2.readString(z2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = abstractSerializedData2.readInt32(z2);
                        }
                        this.read_inbox_max_id = abstractSerializedData2.readInt32(z2);
                        this.read_outbox_max_id = abstractSerializedData2.readInt32(z2);
                        this.unread_count = abstractSerializedData2.readInt32(z2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        int int322 = abstractSerializedData2.readInt32(z2);
                        if (int322 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int323; i2++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.pinned_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelFull, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i2;
                        int i3 = this.can_set_username ? i2 | 64 : i2 & (-65);
                        this.flags = i3;
                        abstractSerializedData2.writeInt32(i3);
                        abstractSerializedData2.writeInt32(this.id);
                        abstractSerializedData2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            abstractSerializedData2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            abstractSerializedData2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.kicked_count);
                        }
                        abstractSerializedData2.writeInt32(this.read_inbox_max_id);
                        abstractSerializedData2.writeInt32(this.read_outbox_max_id);
                        abstractSerializedData2.writeInt32(this.unread_count);
                        this.chat_photo.serializeToStream(abstractSerializedData2);
                        this.notify_settings.serializeToStream(abstractSerializedData2);
                        this.exported_invite.serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i4 = 0; i4 < size; i4++) {
                            this.bot_info.get(i4).serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 16) != 0) {
                            abstractSerializedData2.writeInt32(this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            abstractSerializedData2.writeInt32(this.migrated_from_max_id);
                        }
                        if ((this.flags & 32) != 0) {
                            abstractSerializedData2.writeInt32((int) this.pinned_msg_id);
                        }
                    }
                };
                break;
            case -877254512:
                tLRPC$TL_chatFull = new TLRPC$TL_channelFull() { // from class: org.rbmain.tgnet.TLRPC$TL_channelFull_layer89
                    public static int constructor = -877254512;

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelFull, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.can_set_username = (int32 & 64) != 0;
                        this.can_set_stickers = (int32 & 128) != 0;
                        this.hidden_prehistory = (int32 & 1024) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        this.about = abstractSerializedData2.readString(z2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.banned_count = abstractSerializedData2.readInt32(z2);
                        }
                        this.read_inbox_max_id = abstractSerializedData2.readInt32(z2);
                        this.read_outbox_max_id = abstractSerializedData2.readInt32(z2);
                        this.unread_count = abstractSerializedData2.readInt32(z2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        int int322 = abstractSerializedData2.readInt32(z2);
                        if (int322 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int323; i2++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.pinned_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 256) != 0) {
                            this.stickerset = TLRPC$StickerSet.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 512) != 0) {
                            this.available_min_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 2048) != 0) {
                            this.call_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelFull, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i2;
                        int i3 = this.can_set_username ? i2 | 64 : i2 & (-65);
                        this.flags = i3;
                        int i4 = this.can_set_stickers ? i3 | 128 : i3 & (-129);
                        this.flags = i4;
                        int i5 = this.hidden_prehistory ? i4 | 1024 : i4 & (-1025);
                        this.flags = i5;
                        abstractSerializedData2.writeInt32(i5);
                        abstractSerializedData2.writeInt32(this.id);
                        abstractSerializedData2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            abstractSerializedData2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            abstractSerializedData2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.kicked_count);
                        }
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.banned_count);
                        }
                        abstractSerializedData2.writeInt32(this.read_inbox_max_id);
                        abstractSerializedData2.writeInt32(this.read_outbox_max_id);
                        abstractSerializedData2.writeInt32(this.unread_count);
                        this.chat_photo.serializeToStream(abstractSerializedData2);
                        this.notify_settings.serializeToStream(abstractSerializedData2);
                        this.exported_invite.serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i6 = 0; i6 < size; i6++) {
                            this.bot_info.get(i6).serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 16) != 0) {
                            abstractSerializedData2.writeInt32(this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            abstractSerializedData2.writeInt32(this.migrated_from_max_id);
                        }
                        if ((this.flags & 32) != 0) {
                            abstractSerializedData2.writeInt32((int) this.pinned_msg_id);
                        }
                        if ((this.flags & 256) != 0) {
                            this.stickerset.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 512) != 0) {
                            abstractSerializedData2.writeInt32(this.available_min_id);
                        }
                        if ((this.flags & 2048) != 0) {
                            abstractSerializedData2.writeInt32(this.call_msg_id);
                        }
                    }
                };
                break;
            case -304961647:
                tLRPC$TL_chatFull = new TLRPC$TL_chatFull() { // from class: org.rbmain.tgnet.TLRPC$TL_chatFull_layer92
                    public static int constructor = -304961647;

                    @Override // org.rbmain.tgnet.TLRPC$TL_chatFull, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.flags = abstractSerializedData2.readInt32(z2);
                        this.id = abstractSerializedData2.readInt32(z2);
                        this.participants = TLRPC$ChatParticipants.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if ((this.flags & 4) != 0) {
                            this.chat_photo = TLRPC$Photo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        if ((this.flags & 8) != 0) {
                            int int32 = abstractSerializedData2.readInt32(z2);
                            if (int32 != 481674261) {
                                if (z2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                                }
                                return;
                            }
                            int int322 = abstractSerializedData2.readInt32(z2);
                            for (int i2 = 0; i2 < int322; i2++) {
                                TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                                if (tLRPC$BotInfoTLdeserialize == null) {
                                    return;
                                }
                                this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            this.pinned_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_chatFull, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.flags);
                        abstractSerializedData2.writeInt32(this.id);
                        this.participants.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 4) != 0) {
                            this.chat_photo.serializeToStream(abstractSerializedData2);
                        }
                        this.notify_settings.serializeToStream(abstractSerializedData2);
                        this.exported_invite.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 8) != 0) {
                            abstractSerializedData2.writeInt32(481674261);
                            int size = this.bot_info.size();
                            abstractSerializedData2.writeInt32(size);
                            for (int i2 = 0; i2 < size; i2++) {
                                this.bot_info.get(i2).serializeToStream(abstractSerializedData2);
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            abstractSerializedData2.writeInt32((int) this.pinned_msg_id);
                        }
                    }
                };
                break;
            case -281384243:
                tLRPC$TL_chatFull = new TLRPC$TL_channelFull() { // from class: org.rbmain.tgnet.TLRPC$TL_channelFull_layer122
                    public static int constructor = -281384243;

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelFull, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.can_set_username = (int32 & 64) != 0;
                        this.can_set_stickers = (int32 & 128) != 0;
                        this.hidden_prehistory = (int32 & 1024) != 0;
                        this.can_set_location = (65536 & int32) != 0;
                        this.has_scheduled = (524288 & int32) != 0;
                        this.can_view_stats = (1048576 & int32) != 0;
                        this.blocked = (int32 & 4194304) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        this.about = abstractSerializedData2.readString(z2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.banned_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 8192) != 0) {
                            this.online_count = abstractSerializedData2.readInt32(z2);
                        }
                        this.read_inbox_max_id = abstractSerializedData2.readInt32(z2);
                        this.read_outbox_max_id = abstractSerializedData2.readInt32(z2);
                        this.unread_count = abstractSerializedData2.readInt32(z2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        int int322 = abstractSerializedData2.readInt32(z2);
                        if (int322 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int323; i2++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.pinned_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 256) != 0) {
                            this.stickerset = TLRPC$StickerSet.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 512) != 0) {
                            this.available_min_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 2048) != 0) {
                            this.folder_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0) {
                            this.linked_chat_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.location = TLRPC$ChannelLocation.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_REORDER) != 0) {
                            this.slowmode_seconds = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_CHAT_MUTE) != 0) {
                            this.slowmode_next_send_date = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4096) != 0) {
                            this.stats_dc = abstractSerializedData2.readInt32(z2);
                        }
                        this.pts = abstractSerializedData2.readInt32(z2);
                        if ((this.flags & 2097152) != 0) {
                            this.call = TLRPC$TL_inputGroupCall.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelFull, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i2;
                        int i3 = this.can_set_username ? i2 | 64 : i2 & (-65);
                        this.flags = i3;
                        int i4 = this.can_set_stickers ? i3 | 128 : i3 & (-129);
                        this.flags = i4;
                        int i5 = this.hidden_prehistory ? i4 | 1024 : i4 & (-1025);
                        this.flags = i5;
                        int i6 = this.can_set_location ? i5 | MessagesController.UPDATE_MASK_CHECK : i5 & (-65537);
                        this.flags = i6;
                        int i7 = this.has_scheduled ? i6 | MessagesController.UPDATE_MASK_CHAT_SHOW_SPAM : i6 & (-524289);
                        this.flags = i7;
                        int i8 = this.can_view_stats ? i7 | 1048576 : i7 & (-1048577);
                        this.flags = i8;
                        int i9 = this.blocked ? i8 | 4194304 : i8 & (-4194305);
                        this.flags = i9;
                        abstractSerializedData2.writeInt32(i9);
                        abstractSerializedData2.writeInt32(this.id);
                        abstractSerializedData2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            abstractSerializedData2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            abstractSerializedData2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.kicked_count);
                        }
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.banned_count);
                        }
                        if ((this.flags & 8192) != 0) {
                            abstractSerializedData2.writeInt32(this.online_count);
                        }
                        abstractSerializedData2.writeInt32(this.read_inbox_max_id);
                        abstractSerializedData2.writeInt32(this.read_outbox_max_id);
                        abstractSerializedData2.writeInt32(this.unread_count);
                        this.chat_photo.serializeToStream(abstractSerializedData2);
                        this.notify_settings.serializeToStream(abstractSerializedData2);
                        TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported = this.exported_invite;
                        if (tLRPC$TL_chatInviteExported != null) {
                            tLRPC$TL_chatInviteExported.serializeToStream(abstractSerializedData2);
                        } else {
                            new TLRPC$TL_chatInviteEmpty_layer122().serializeToStream(abstractSerializedData2);
                        }
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i10 = 0; i10 < size; i10++) {
                            this.bot_info.get(i10).serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 16) != 0) {
                            abstractSerializedData2.writeInt32(this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            abstractSerializedData2.writeInt32(this.migrated_from_max_id);
                        }
                        if ((this.flags & 32) != 0) {
                            abstractSerializedData2.writeInt32((int) this.pinned_msg_id);
                        }
                        if ((this.flags & 256) != 0) {
                            this.stickerset.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 512) != 0) {
                            abstractSerializedData2.writeInt32(this.available_min_id);
                        }
                        if ((this.flags & 2048) != 0) {
                            abstractSerializedData2.writeInt32(this.folder_id);
                        }
                        if ((this.flags & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0) {
                            abstractSerializedData2.writeInt32(this.linked_chat_id);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.location.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_REORDER) != 0) {
                            abstractSerializedData2.writeInt32(this.slowmode_seconds);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_CHAT_MUTE) != 0) {
                            abstractSerializedData2.writeInt32(this.slowmode_next_send_date);
                        }
                        if ((this.flags & 4096) != 0) {
                            abstractSerializedData2.writeInt32(this.stats_dc);
                        }
                        abstractSerializedData2.writeInt32(this.pts);
                        if ((this.flags & 2097152) != 0) {
                            this.call.serializeToStream(abstractSerializedData2);
                        }
                    }
                };
                break;
            case -261341160:
                tLRPC$TL_chatFull = new TLRPC$TL_chatFull() { // from class: org.rbmain.tgnet.TLRPC$TL_chatFull_layer124
                    public static int constructor = -261341160;

                    @Override // org.rbmain.tgnet.TLRPC$TL_chatFull, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.can_set_username = (int32 & 128) != 0;
                        this.has_scheduled = (int32 & 256) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        this.about = abstractSerializedData2.readString(z2);
                        this.participants = TLRPC$ChatParticipants.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if ((this.flags & 4) != 0) {
                            this.chat_photo = TLRPC$Photo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if ((this.flags & 8192) != 0) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) TLRPC$ExportedChatInvite.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 8) != 0) {
                            int int322 = abstractSerializedData2.readInt32(z2);
                            if (int322 != 481674261) {
                                if (z2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = abstractSerializedData2.readInt32(z2);
                            for (int i2 = 0; i2 < int323; i2++) {
                                TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                                if (tLRPC$BotInfoTLdeserialize == null) {
                                    return;
                                }
                                this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            this.pinned_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 2048) != 0) {
                            this.folder_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4096) != 0) {
                            this.call = TLRPC$TL_inputGroupCall.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0) {
                            this.ttl_period = abstractSerializedData2.readInt32(z2);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_chatFull, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.can_set_username ? this.flags | 128 : this.flags & (-129);
                        this.flags = i2;
                        int i3 = this.has_scheduled ? i2 | 256 : i2 & (-257);
                        this.flags = i3;
                        abstractSerializedData2.writeInt32(i3);
                        abstractSerializedData2.writeInt32(this.id);
                        abstractSerializedData2.writeString(this.about);
                        this.participants.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 4) != 0) {
                            this.chat_photo.serializeToStream(abstractSerializedData2);
                        }
                        this.notify_settings.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 8192) != 0) {
                            this.exported_invite.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 8) != 0) {
                            abstractSerializedData2.writeInt32(481674261);
                            int size = this.bot_info.size();
                            abstractSerializedData2.writeInt32(size);
                            for (int i4 = 0; i4 < size; i4++) {
                                this.bot_info.get(i4).serializeToStream(abstractSerializedData2);
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            abstractSerializedData2.writeInt32((int) this.pinned_msg_id);
                        }
                        if ((this.flags & 2048) != 0) {
                            abstractSerializedData2.writeInt32(this.folder_id);
                        }
                        if ((this.flags & 4096) != 0) {
                            this.call.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0) {
                            abstractSerializedData2.writeInt32(this.ttl_period);
                        }
                    }
                };
                break;
            case -253335766:
                tLRPC$TL_chatFull = new TLRPC$TL_channelFull() { // from class: org.rbmain.tgnet.TLRPC$TL_channelFull_layer121
                    public static int constructor = -253335766;

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelFull, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.can_set_username = (int32 & 64) != 0;
                        this.can_set_stickers = (int32 & 128) != 0;
                        this.hidden_prehistory = (int32 & 1024) != 0;
                        this.can_set_location = (65536 & int32) != 0;
                        this.has_scheduled = (524288 & int32) != 0;
                        this.can_view_stats = (1048576 & int32) != 0;
                        this.blocked = (int32 & 4194304) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        this.about = abstractSerializedData2.readString(z2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.banned_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 8192) != 0) {
                            this.online_count = abstractSerializedData2.readInt32(z2);
                        }
                        this.read_inbox_max_id = abstractSerializedData2.readInt32(z2);
                        this.read_outbox_max_id = abstractSerializedData2.readInt32(z2);
                        this.unread_count = abstractSerializedData2.readInt32(z2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        int int322 = abstractSerializedData2.readInt32(z2);
                        if (int322 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int323; i2++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.pinned_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 256) != 0) {
                            this.stickerset = TLRPC$StickerSet.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 512) != 0) {
                            this.available_min_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 2048) != 0) {
                            this.folder_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0) {
                            this.linked_chat_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.location = TLRPC$ChannelLocation.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_REORDER) != 0) {
                            this.slowmode_seconds = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_CHAT_MUTE) != 0) {
                            this.slowmode_next_send_date = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4096) != 0) {
                            this.stats_dc = abstractSerializedData2.readInt32(z2);
                        }
                        this.pts = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelFull, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i2;
                        int i3 = this.can_set_username ? i2 | 64 : i2 & (-65);
                        this.flags = i3;
                        int i4 = this.can_set_stickers ? i3 | 128 : i3 & (-129);
                        this.flags = i4;
                        int i5 = this.hidden_prehistory ? i4 | 1024 : i4 & (-1025);
                        this.flags = i5;
                        int i6 = this.can_set_location ? i5 | MessagesController.UPDATE_MASK_CHECK : i5 & (-65537);
                        this.flags = i6;
                        int i7 = this.has_scheduled ? i6 | MessagesController.UPDATE_MASK_CHAT_SHOW_SPAM : i6 & (-524289);
                        this.flags = i7;
                        int i8 = this.can_view_stats ? i7 | 1048576 : i7 & (-1048577);
                        this.flags = i8;
                        int i9 = this.blocked ? i8 | 4194304 : i8 & (-4194305);
                        this.flags = i9;
                        abstractSerializedData2.writeInt32(i9);
                        abstractSerializedData2.writeInt32(this.id);
                        abstractSerializedData2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            abstractSerializedData2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            abstractSerializedData2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.kicked_count);
                        }
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.banned_count);
                        }
                        if ((this.flags & 8192) != 0) {
                            abstractSerializedData2.writeInt32(this.online_count);
                        }
                        abstractSerializedData2.writeInt32(this.read_inbox_max_id);
                        abstractSerializedData2.writeInt32(this.read_outbox_max_id);
                        abstractSerializedData2.writeInt32(this.unread_count);
                        this.chat_photo.serializeToStream(abstractSerializedData2);
                        this.notify_settings.serializeToStream(abstractSerializedData2);
                        this.exported_invite.serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i10 = 0; i10 < size; i10++) {
                            this.bot_info.get(i10).serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 16) != 0) {
                            abstractSerializedData2.writeInt32(this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            abstractSerializedData2.writeInt32(this.migrated_from_max_id);
                        }
                        if ((this.flags & 32) != 0) {
                            abstractSerializedData2.writeInt32((int) this.pinned_msg_id);
                        }
                        if ((this.flags & 256) != 0) {
                            this.stickerset.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 512) != 0) {
                            abstractSerializedData2.writeInt32(this.available_min_id);
                        }
                        if ((this.flags & 2048) != 0) {
                            abstractSerializedData2.writeInt32(this.folder_id);
                        }
                        if ((this.flags & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0) {
                            abstractSerializedData2.writeInt32(this.linked_chat_id);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.location.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_REORDER) != 0) {
                            abstractSerializedData2.writeInt32(this.slowmode_seconds);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_CHAT_MUTE) != 0) {
                            abstractSerializedData2.writeInt32(this.slowmode_next_send_date);
                        }
                        if ((this.flags & 4096) != 0) {
                            abstractSerializedData2.writeInt32(this.stats_dc);
                        }
                        abstractSerializedData2.writeInt32(this.pts);
                    }
                };
                break;
            case -213431562:
                tLRPC$TL_chatFull = new TLRPC$TL_chatFull() { // from class: org.rbmain.tgnet.TLRPC$TL_chatFull_layer123
                    public static int constructor = -213431562;

                    @Override // org.rbmain.tgnet.TLRPC$TL_chatFull, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.can_set_username = (int32 & 128) != 0;
                        this.has_scheduled = (int32 & 256) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        this.about = abstractSerializedData2.readString(z2);
                        this.participants = TLRPC$ChatParticipants.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if ((this.flags & 4) != 0) {
                            this.chat_photo = TLRPC$Photo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if ((this.flags & 8192) != 0) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) TLRPC$ExportedChatInvite.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 8) != 0) {
                            int int322 = abstractSerializedData2.readInt32(z2);
                            if (int322 != 481674261) {
                                if (z2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = abstractSerializedData2.readInt32(z2);
                            for (int i2 = 0; i2 < int323; i2++) {
                                TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                                if (tLRPC$BotInfoTLdeserialize == null) {
                                    return;
                                }
                                this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            this.pinned_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 2048) != 0) {
                            this.folder_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4096) != 0) {
                            this.call = TLRPC$TL_inputGroupCall.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_chatFull, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.can_set_username ? this.flags | 128 : this.flags & (-129);
                        this.flags = i2;
                        int i3 = this.has_scheduled ? i2 | 256 : i2 & (-257);
                        this.flags = i3;
                        abstractSerializedData2.writeInt32(i3);
                        abstractSerializedData2.writeInt32(this.id);
                        abstractSerializedData2.writeString(this.about);
                        this.participants.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 4) != 0) {
                            this.chat_photo.serializeToStream(abstractSerializedData2);
                        }
                        this.notify_settings.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 8192) != 0) {
                            this.exported_invite.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 8) != 0) {
                            abstractSerializedData2.writeInt32(481674261);
                            int size = this.bot_info.size();
                            abstractSerializedData2.writeInt32(size);
                            for (int i4 = 0; i4 < size; i4++) {
                                this.bot_info.get(i4).serializeToStream(abstractSerializedData2);
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            abstractSerializedData2.writeInt32((int) this.pinned_msg_id);
                        }
                        if ((this.flags & 2048) != 0) {
                            abstractSerializedData2.writeInt32(this.folder_id);
                        }
                        if ((this.flags & 4096) != 0) {
                            this.call.serializeToStream(abstractSerializedData2);
                        }
                    }
                };
                break;
            case -88925533:
                tLRPC$TL_chatFull = new TLRPC$TL_channelFull() { // from class: org.rbmain.tgnet.TLRPC$TL_channelFull_old
                    public static int constructor = -88925533;

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelFull, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        this.about = abstractSerializedData2.readString(z2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = abstractSerializedData2.readInt32(z2);
                        }
                        this.read_inbox_max_id = abstractSerializedData2.readInt32(z2);
                        this.unread_count = abstractSerializedData2.readInt32(z2);
                        this.unread_important_count = abstractSerializedData2.readInt32(z2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelFull, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i2;
                        abstractSerializedData2.writeInt32(i2);
                        abstractSerializedData2.writeInt32(this.id);
                        abstractSerializedData2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            abstractSerializedData2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            abstractSerializedData2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.kicked_count);
                        }
                        abstractSerializedData2.writeInt32(this.read_inbox_max_id);
                        abstractSerializedData2.writeInt32(this.unread_count);
                        abstractSerializedData2.writeInt32(this.unread_important_count);
                        this.chat_photo.serializeToStream(abstractSerializedData2);
                        this.notify_settings.serializeToStream(abstractSerializedData2);
                        this.exported_invite.serializeToStream(abstractSerializedData2);
                    }
                };
                break;
            case 56920439:
                tLRPC$TL_chatFull = new TLRPC$TL_channelFull() { // from class: org.rbmain.tgnet.TLRPC$TL_channelFull_layer99
                    public static int constructor = 56920439;

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelFull, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.can_set_username = (int32 & 64) != 0;
                        this.can_set_stickers = (int32 & 128) != 0;
                        this.hidden_prehistory = (int32 & 1024) != 0;
                        this.can_view_stats = (int32 & 4096) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        this.about = abstractSerializedData2.readString(z2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.banned_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 8192) != 0) {
                            this.online_count = abstractSerializedData2.readInt32(z2);
                        }
                        this.read_inbox_max_id = abstractSerializedData2.readInt32(z2);
                        this.read_outbox_max_id = abstractSerializedData2.readInt32(z2);
                        this.unread_count = abstractSerializedData2.readInt32(z2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        int int322 = abstractSerializedData2.readInt32(z2);
                        if (int322 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int323; i2++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.pinned_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 256) != 0) {
                            this.stickerset = TLRPC$StickerSet.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 512) != 0) {
                            this.available_min_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 2048) != 0) {
                            this.folder_id = abstractSerializedData2.readInt32(z2);
                        }
                        this.pts = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelFull, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i2;
                        int i3 = this.can_set_username ? i2 | 64 : i2 & (-65);
                        this.flags = i3;
                        int i4 = this.can_set_stickers ? i3 | 128 : i3 & (-129);
                        this.flags = i4;
                        int i5 = this.hidden_prehistory ? i4 | 1024 : i4 & (-1025);
                        this.flags = i5;
                        int i6 = this.can_view_stats ? i5 | 4096 : i5 & (-4097);
                        this.flags = i6;
                        abstractSerializedData2.writeInt32(i6);
                        abstractSerializedData2.writeInt32(this.id);
                        abstractSerializedData2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            abstractSerializedData2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            abstractSerializedData2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.kicked_count);
                        }
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.banned_count);
                        }
                        if ((this.flags & 8192) != 0) {
                            abstractSerializedData2.writeInt32(this.online_count);
                        }
                        abstractSerializedData2.writeInt32(this.read_inbox_max_id);
                        abstractSerializedData2.writeInt32(this.read_outbox_max_id);
                        abstractSerializedData2.writeInt32(this.unread_count);
                        this.chat_photo.serializeToStream(abstractSerializedData2);
                        this.notify_settings.serializeToStream(abstractSerializedData2);
                        this.exported_invite.serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i7 = 0; i7 < size; i7++) {
                            this.bot_info.get(i7).serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 16) != 0) {
                            abstractSerializedData2.writeInt32(this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            abstractSerializedData2.writeInt32(this.migrated_from_max_id);
                        }
                        if ((this.flags & 32) != 0) {
                            abstractSerializedData2.writeInt32((int) this.pinned_msg_id);
                        }
                        if ((this.flags & 256) != 0) {
                            this.stickerset.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 512) != 0) {
                            abstractSerializedData2.writeInt32(this.available_min_id);
                        }
                        if ((this.flags & 2048) != 0) {
                            abstractSerializedData2.writeInt32(this.folder_id);
                        }
                        abstractSerializedData2.writeInt32(this.pts);
                    }
                };
                break;
            case 231260545:
                tLRPC$TL_chatFull = new TLRPC$TL_chatFull() { // from class: org.rbmain.tgnet.TLRPC$TL_chatFull_layer122
                    public static int constructor = 231260545;

                    @Override // org.rbmain.tgnet.TLRPC$TL_chatFull, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.can_set_username = (int32 & 128) != 0;
                        this.has_scheduled = (int32 & 256) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        this.about = abstractSerializedData2.readString(z2);
                        this.participants = TLRPC$ChatParticipants.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if ((this.flags & 4) != 0) {
                            this.chat_photo = TLRPC$Photo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        if ((this.flags & 8) != 0) {
                            int int322 = abstractSerializedData2.readInt32(z2);
                            if (int322 != 481674261) {
                                if (z2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = abstractSerializedData2.readInt32(z2);
                            for (int i2 = 0; i2 < int323; i2++) {
                                TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                                if (tLRPC$BotInfoTLdeserialize == null) {
                                    return;
                                }
                                this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            this.pinned_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 2048) != 0) {
                            this.folder_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4096) != 0) {
                            this.call = TLRPC$TL_inputGroupCall.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_chatFull, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.can_set_username ? this.flags | 128 : this.flags & (-129);
                        this.flags = i2;
                        int i3 = this.has_scheduled ? i2 | 256 : i2 & (-257);
                        this.flags = i3;
                        abstractSerializedData2.writeInt32(i3);
                        abstractSerializedData2.writeInt32(this.id);
                        abstractSerializedData2.writeString(this.about);
                        this.participants.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 4) != 0) {
                            this.chat_photo.serializeToStream(abstractSerializedData2);
                        }
                        this.notify_settings.serializeToStream(abstractSerializedData2);
                        this.exported_invite.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 8) != 0) {
                            abstractSerializedData2.writeInt32(481674261);
                            int size = this.bot_info.size();
                            abstractSerializedData2.writeInt32(size);
                            for (int i4 = 0; i4 < size; i4++) {
                                this.bot_info.get(i4).serializeToStream(abstractSerializedData2);
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            abstractSerializedData2.writeInt32((int) this.pinned_msg_id);
                        }
                        if ((this.flags & 2048) != 0) {
                            abstractSerializedData2.writeInt32(this.folder_id);
                        }
                        if ((this.flags & 4096) != 0) {
                            this.call.serializeToStream(abstractSerializedData2);
                        }
                    }
                };
                break;
            case 277964371:
                tLRPC$TL_chatFull = new TLRPC$TL_channelFull() { // from class: org.rbmain.tgnet.TLRPC$TL_channelFull_layer103
                    public static int constructor = 277964371;

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelFull, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.can_set_username = (int32 & 64) != 0;
                        this.can_set_stickers = (int32 & 128) != 0;
                        this.hidden_prehistory = (int32 & 1024) != 0;
                        this.can_view_stats = (int32 & 4096) != 0;
                        this.can_set_location = (int32 & MessagesController.UPDATE_MASK_CHECK) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        this.about = abstractSerializedData2.readString(z2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.banned_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 8192) != 0) {
                            this.online_count = abstractSerializedData2.readInt32(z2);
                        }
                        this.read_inbox_max_id = abstractSerializedData2.readInt32(z2);
                        this.read_outbox_max_id = abstractSerializedData2.readInt32(z2);
                        this.unread_count = abstractSerializedData2.readInt32(z2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        int int322 = abstractSerializedData2.readInt32(z2);
                        if (int322 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int323; i2++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.pinned_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 256) != 0) {
                            this.stickerset = TLRPC$StickerSet.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 512) != 0) {
                            this.available_min_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 2048) != 0) {
                            this.folder_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0) {
                            this.linked_chat_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.location = TLRPC$ChannelLocation.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        this.pts = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelFull, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i2;
                        int i3 = this.can_set_username ? i2 | 64 : i2 & (-65);
                        this.flags = i3;
                        int i4 = this.can_set_stickers ? i3 | 128 : i3 & (-129);
                        this.flags = i4;
                        int i5 = this.hidden_prehistory ? i4 | 1024 : i4 & (-1025);
                        this.flags = i5;
                        int i6 = this.can_view_stats ? i5 | 4096 : i5 & (-4097);
                        this.flags = i6;
                        int i7 = this.can_set_location ? i6 | MessagesController.UPDATE_MASK_CHECK : i6 & (-65537);
                        this.flags = i7;
                        abstractSerializedData2.writeInt32(i7);
                        abstractSerializedData2.writeInt32(this.id);
                        abstractSerializedData2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            abstractSerializedData2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            abstractSerializedData2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.kicked_count);
                        }
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.banned_count);
                        }
                        if ((this.flags & 8192) != 0) {
                            abstractSerializedData2.writeInt32(this.online_count);
                        }
                        abstractSerializedData2.writeInt32(this.read_inbox_max_id);
                        abstractSerializedData2.writeInt32(this.read_outbox_max_id);
                        abstractSerializedData2.writeInt32(this.unread_count);
                        this.chat_photo.serializeToStream(abstractSerializedData2);
                        this.notify_settings.serializeToStream(abstractSerializedData2);
                        this.exported_invite.serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i8 = 0; i8 < size; i8++) {
                            this.bot_info.get(i8).serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 16) != 0) {
                            abstractSerializedData2.writeInt32(this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            abstractSerializedData2.writeInt32(this.migrated_from_max_id);
                        }
                        if ((this.flags & 32) != 0) {
                            abstractSerializedData2.writeInt32((int) this.pinned_msg_id);
                        }
                        if ((this.flags & 256) != 0) {
                            this.stickerset.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 512) != 0) {
                            abstractSerializedData2.writeInt32(this.available_min_id);
                        }
                        if ((this.flags & 2048) != 0) {
                            abstractSerializedData2.writeInt32(this.folder_id);
                        }
                        if ((this.flags & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0) {
                            abstractSerializedData2.writeInt32(this.linked_chat_id);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.location.serializeToStream(abstractSerializedData2);
                        }
                        abstractSerializedData2.writeInt32(this.pts);
                    }
                };
                break;
            case 401891279:
                tLRPC$TL_chatFull = new TLRPC$TL_channelFull() { // from class: org.rbmain.tgnet.TLRPC$TL_channelFull_layer71
                    public static int constructor = 401891279;

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelFull, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.can_set_username = (int32 & 64) != 0;
                        this.can_set_stickers = (int32 & 128) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        this.about = abstractSerializedData2.readString(z2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.banned_count = abstractSerializedData2.readInt32(z2);
                        }
                        this.read_inbox_max_id = abstractSerializedData2.readInt32(z2);
                        this.read_outbox_max_id = abstractSerializedData2.readInt32(z2);
                        this.unread_count = abstractSerializedData2.readInt32(z2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        int int322 = abstractSerializedData2.readInt32(z2);
                        if (int322 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int323; i2++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.pinned_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 256) != 0) {
                            this.stickerset = TLRPC$StickerSet.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelFull, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i2;
                        int i3 = this.can_set_username ? i2 | 64 : i2 & (-65);
                        this.flags = i3;
                        int i4 = this.can_set_stickers ? i3 | 128 : i3 & (-129);
                        this.flags = i4;
                        abstractSerializedData2.writeInt32(i4);
                        abstractSerializedData2.writeInt32(this.id);
                        abstractSerializedData2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            abstractSerializedData2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            abstractSerializedData2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.kicked_count);
                        }
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.banned_count);
                        }
                        abstractSerializedData2.writeInt32(this.read_inbox_max_id);
                        abstractSerializedData2.writeInt32(this.read_outbox_max_id);
                        abstractSerializedData2.writeInt32(this.unread_count);
                        this.chat_photo.serializeToStream(abstractSerializedData2);
                        this.notify_settings.serializeToStream(abstractSerializedData2);
                        this.exported_invite.serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i5 = 0; i5 < size; i5++) {
                            this.bot_info.get(i5).serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 16) != 0) {
                            abstractSerializedData2.writeInt32(this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            abstractSerializedData2.writeInt32(this.migrated_from_max_id);
                        }
                        if ((this.flags & 32) != 0) {
                            abstractSerializedData2.writeInt32((int) this.pinned_msg_id);
                        }
                        if ((this.flags & 256) != 0) {
                            this.stickerset.serializeToStream(abstractSerializedData2);
                        }
                    }
                };
                break;
            case 461151667:
                tLRPC$TL_chatFull = new TLRPC$TL_chatFull() { // from class: org.rbmain.tgnet.TLRPC$TL_chatFull_layer121
                    public static int constructor = 461151667;

                    @Override // org.rbmain.tgnet.TLRPC$TL_chatFull, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.can_set_username = (int32 & 128) != 0;
                        this.has_scheduled = (int32 & 256) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        this.about = abstractSerializedData2.readString(z2);
                        this.participants = TLRPC$ChatParticipants.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if ((this.flags & 4) != 0) {
                            this.chat_photo = TLRPC$Photo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        if ((this.flags & 8) != 0) {
                            int int322 = abstractSerializedData2.readInt32(z2);
                            if (int322 != 481674261) {
                                if (z2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = abstractSerializedData2.readInt32(z2);
                            for (int i2 = 0; i2 < int323; i2++) {
                                TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                                if (tLRPC$BotInfoTLdeserialize == null) {
                                    return;
                                }
                                this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            this.pinned_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 2048) != 0) {
                            this.folder_id = abstractSerializedData2.readInt32(z2);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_chatFull, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.can_set_username ? this.flags | 128 : this.flags & (-129);
                        this.flags = i2;
                        int i3 = this.has_scheduled ? i2 | 256 : i2 & (-257);
                        this.flags = i3;
                        abstractSerializedData2.writeInt32(i3);
                        abstractSerializedData2.writeInt32(this.id);
                        abstractSerializedData2.writeString(this.about);
                        this.participants.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 4) != 0) {
                            this.chat_photo.serializeToStream(abstractSerializedData2);
                        }
                        this.notify_settings.serializeToStream(abstractSerializedData2);
                        this.exported_invite.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 8) != 0) {
                            abstractSerializedData2.writeInt32(481674261);
                            int size = this.bot_info.size();
                            abstractSerializedData2.writeInt32(size);
                            for (int i4 = 0; i4 < size; i4++) {
                                this.bot_info.get(i4).serializeToStream(abstractSerializedData2);
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            abstractSerializedData2.writeInt32((int) this.pinned_msg_id);
                        }
                        if ((this.flags & 2048) != 0) {
                            abstractSerializedData2.writeInt32(this.folder_id);
                        }
                    }
                };
                break;
            case 478652186:
                tLRPC$TL_chatFull = new TLRPC$TL_channelFull() { // from class: org.rbmain.tgnet.TLRPC$TL_channelFull_layer98
                    public static int constructor = 478652186;

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelFull, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.can_set_username = (int32 & 64) != 0;
                        this.can_set_stickers = (int32 & 128) != 0;
                        this.hidden_prehistory = (int32 & 1024) != 0;
                        this.can_view_stats = (int32 & 4096) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        this.about = abstractSerializedData2.readString(z2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.banned_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 8192) != 0) {
                            this.online_count = abstractSerializedData2.readInt32(z2);
                        }
                        this.read_inbox_max_id = abstractSerializedData2.readInt32(z2);
                        this.read_outbox_max_id = abstractSerializedData2.readInt32(z2);
                        this.unread_count = abstractSerializedData2.readInt32(z2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        int int322 = abstractSerializedData2.readInt32(z2);
                        if (int322 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int323; i2++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.pinned_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 256) != 0) {
                            this.stickerset = TLRPC$StickerSet.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 512) != 0) {
                            this.available_min_id = abstractSerializedData2.readInt32(z2);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelFull, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i2;
                        int i3 = this.can_set_username ? i2 | 64 : i2 & (-65);
                        this.flags = i3;
                        int i4 = this.can_set_stickers ? i3 | 128 : i3 & (-129);
                        this.flags = i4;
                        int i5 = this.hidden_prehistory ? i4 | 1024 : i4 & (-1025);
                        this.flags = i5;
                        int i6 = this.can_view_stats ? i5 | 4096 : i5 & (-4097);
                        this.flags = i6;
                        abstractSerializedData2.writeInt32(i6);
                        abstractSerializedData2.writeInt32(this.id);
                        abstractSerializedData2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            abstractSerializedData2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            abstractSerializedData2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.kicked_count);
                        }
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.banned_count);
                        }
                        if ((this.flags & 8192) != 0) {
                            abstractSerializedData2.writeInt32(this.online_count);
                        }
                        abstractSerializedData2.writeInt32(this.read_inbox_max_id);
                        abstractSerializedData2.writeInt32(this.read_outbox_max_id);
                        abstractSerializedData2.writeInt32(this.unread_count);
                        this.chat_photo.serializeToStream(abstractSerializedData2);
                        this.notify_settings.serializeToStream(abstractSerializedData2);
                        this.exported_invite.serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i7 = 0; i7 < size; i7++) {
                            this.bot_info.get(i7).serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 16) != 0) {
                            abstractSerializedData2.writeInt32(this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            abstractSerializedData2.writeInt32(this.migrated_from_max_id);
                        }
                        if ((this.flags & 32) != 0) {
                            abstractSerializedData2.writeInt32((int) this.pinned_msg_id);
                        }
                        if ((this.flags & 256) != 0) {
                            this.stickerset.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 512) != 0) {
                            abstractSerializedData2.writeInt32(this.available_min_id);
                        }
                    }
                };
                break;
            case 581055962:
                tLRPC$TL_chatFull = new TLRPC$TL_chatFull() { // from class: org.rbmain.tgnet.TLRPC$TL_chatFull_layer98
                    public static int constructor = 581055962;

                    @Override // org.rbmain.tgnet.TLRPC$TL_chatFull, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.can_set_username = (int32 & 128) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        this.about = abstractSerializedData2.readString(z2);
                        this.participants = TLRPC$ChatParticipants.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if ((this.flags & 4) != 0) {
                            this.chat_photo = TLRPC$Photo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        if ((this.flags & 8) != 0) {
                            int int322 = abstractSerializedData2.readInt32(z2);
                            if (int322 != 481674261) {
                                if (z2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = abstractSerializedData2.readInt32(z2);
                            for (int i2 = 0; i2 < int323; i2++) {
                                TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                                if (tLRPC$BotInfoTLdeserialize == null) {
                                    return;
                                }
                                this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            this.pinned_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_chatFull, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.can_set_username ? this.flags | 128 : this.flags & (-129);
                        this.flags = i2;
                        abstractSerializedData2.writeInt32(i2);
                        abstractSerializedData2.writeInt32(this.id);
                        abstractSerializedData2.writeString(this.about);
                        this.participants.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 4) != 0) {
                            this.chat_photo.serializeToStream(abstractSerializedData2);
                        }
                        this.notify_settings.serializeToStream(abstractSerializedData2);
                        this.exported_invite.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 8) != 0) {
                            abstractSerializedData2.writeInt32(481674261);
                            int size = this.bot_info.size();
                            abstractSerializedData2.writeInt32(size);
                            for (int i3 = 0; i3 < size; i3++) {
                                this.bot_info.get(i3).serializeToStream(abstractSerializedData2);
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            abstractSerializedData2.writeInt32((int) this.pinned_msg_id);
                        }
                    }
                };
                break;
            case 625524791:
                tLRPC$TL_chatFull = new TLRPC$TL_channelFull() { // from class: org.rbmain.tgnet.TLRPC$TL_channelFull_layer124
                    public static int constructor = 625524791;

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelFull, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.can_set_username = (int32 & 64) != 0;
                        this.can_set_stickers = (int32 & 128) != 0;
                        this.hidden_prehistory = (int32 & 1024) != 0;
                        this.can_set_location = (65536 & int32) != 0;
                        this.has_scheduled = (524288 & int32) != 0;
                        this.can_view_stats = (1048576 & int32) != 0;
                        this.blocked = (int32 & 4194304) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        this.about = abstractSerializedData2.readString(z2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.banned_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 8192) != 0) {
                            this.online_count = abstractSerializedData2.readInt32(z2);
                        }
                        this.read_inbox_max_id = abstractSerializedData2.readInt32(z2);
                        this.read_outbox_max_id = abstractSerializedData2.readInt32(z2);
                        this.unread_count = abstractSerializedData2.readInt32(z2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if ((this.flags & 8388608) != 0) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) TLRPC$ExportedChatInvite.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        int int322 = abstractSerializedData2.readInt32(z2);
                        if (int322 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int323; i2++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.pinned_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 256) != 0) {
                            this.stickerset = TLRPC$StickerSet.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 512) != 0) {
                            this.available_min_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 2048) != 0) {
                            this.folder_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0) {
                            this.linked_chat_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.location = TLRPC$ChannelLocation.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_REORDER) != 0) {
                            this.slowmode_seconds = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_CHAT_MUTE) != 0) {
                            this.slowmode_next_send_date = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4096) != 0) {
                            this.stats_dc = abstractSerializedData2.readInt32(z2);
                        }
                        this.pts = abstractSerializedData2.readInt32(z2);
                        if ((this.flags & 2097152) != 0) {
                            this.call = TLRPC$TL_inputGroupCall.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & ConnectionsManager.FileTypePhoto) != 0) {
                            this.ttl_period = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & ConnectionsManager.FileTypeVideo) != 0) {
                            int int324 = abstractSerializedData2.readInt32(z2);
                            if (int324 != 481674261) {
                                if (z2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
                                }
                            } else {
                                int int325 = abstractSerializedData2.readInt32(z2);
                                for (int i3 = 0; i3 < int325; i3++) {
                                    this.pending_suggestions.add(abstractSerializedData2.readString(z2));
                                }
                            }
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelFull, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i2;
                        int i3 = this.can_set_username ? i2 | 64 : i2 & (-65);
                        this.flags = i3;
                        int i4 = this.can_set_stickers ? i3 | 128 : i3 & (-129);
                        this.flags = i4;
                        int i5 = this.hidden_prehistory ? i4 | 1024 : i4 & (-1025);
                        this.flags = i5;
                        int i6 = this.can_set_location ? i5 | MessagesController.UPDATE_MASK_CHECK : i5 & (-65537);
                        this.flags = i6;
                        int i7 = this.has_scheduled ? i6 | MessagesController.UPDATE_MASK_CHAT_SHOW_SPAM : i6 & (-524289);
                        this.flags = i7;
                        int i8 = this.can_view_stats ? i7 | 1048576 : i7 & (-1048577);
                        this.flags = i8;
                        int i9 = this.blocked ? i8 | 4194304 : i8 & (-4194305);
                        this.flags = i9;
                        abstractSerializedData2.writeInt32(i9);
                        abstractSerializedData2.writeInt32(this.id);
                        abstractSerializedData2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            abstractSerializedData2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            abstractSerializedData2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.kicked_count);
                        }
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.banned_count);
                        }
                        if ((this.flags & 8192) != 0) {
                            abstractSerializedData2.writeInt32(this.online_count);
                        }
                        abstractSerializedData2.writeInt32(this.read_inbox_max_id);
                        abstractSerializedData2.writeInt32(this.read_outbox_max_id);
                        abstractSerializedData2.writeInt32(this.unread_count);
                        this.chat_photo.serializeToStream(abstractSerializedData2);
                        this.notify_settings.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 8388608) != 0) {
                            this.exported_invite.serializeToStream(abstractSerializedData2);
                        }
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i10 = 0; i10 < size; i10++) {
                            this.bot_info.get(i10).serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 16) != 0) {
                            abstractSerializedData2.writeInt32(this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            abstractSerializedData2.writeInt32(this.migrated_from_max_id);
                        }
                        if ((this.flags & 32) != 0) {
                            abstractSerializedData2.writeInt32((int) this.pinned_msg_id);
                        }
                        if ((this.flags & 256) != 0) {
                            this.stickerset.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 512) != 0) {
                            abstractSerializedData2.writeInt32(this.available_min_id);
                        }
                        if ((this.flags & 2048) != 0) {
                            abstractSerializedData2.writeInt32(this.folder_id);
                        }
                        if ((this.flags & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0) {
                            abstractSerializedData2.writeInt32(this.linked_chat_id);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.location.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_REORDER) != 0) {
                            abstractSerializedData2.writeInt32(this.slowmode_seconds);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_CHAT_MUTE) != 0) {
                            abstractSerializedData2.writeInt32(this.slowmode_next_send_date);
                        }
                        if ((this.flags & 4096) != 0) {
                            abstractSerializedData2.writeInt32(this.stats_dc);
                        }
                        abstractSerializedData2.writeInt32(this.pts);
                        if ((this.flags & 2097152) != 0) {
                            this.call.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & ConnectionsManager.FileTypePhoto) != 0) {
                            abstractSerializedData2.writeInt32(this.ttl_period);
                        }
                        if ((this.flags & ConnectionsManager.FileTypeVideo) != 0) {
                            abstractSerializedData2.writeInt32(481674261);
                            int size2 = this.pending_suggestions.size();
                            abstractSerializedData2.writeInt32(size2);
                            for (int i11 = 0; i11 < size2; i11++) {
                                abstractSerializedData2.writeString(this.pending_suggestions.get(i11));
                            }
                        }
                    }
                };
                break;
            case 763976820:
                tLRPC$TL_chatFull = new TLRPC$ChatFull() { // from class: org.rbmain.tgnet.TLRPC$TL_channelFull_layer110
                    public static int constructor = 763976820;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.can_set_username = (int32 & 64) != 0;
                        this.can_set_stickers = (int32 & 128) != 0;
                        this.hidden_prehistory = (int32 & 1024) != 0;
                        this.can_view_stats = (int32 & 4096) != 0;
                        this.can_set_location = (65536 & int32) != 0;
                        this.has_scheduled = (int32 & MessagesController.UPDATE_MASK_CHAT_SHOW_SPAM) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        this.about = abstractSerializedData2.readString(z2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.banned_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 8192) != 0) {
                            this.online_count = abstractSerializedData2.readInt32(z2);
                        }
                        this.read_inbox_max_id = abstractSerializedData2.readInt32(z2);
                        this.read_outbox_max_id = abstractSerializedData2.readInt32(z2);
                        this.unread_count = abstractSerializedData2.readInt32(z2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        int int322 = abstractSerializedData2.readInt32(z2);
                        if (int322 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int323; i2++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.pinned_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 256) != 0) {
                            this.stickerset = TLRPC$StickerSet.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 512) != 0) {
                            this.available_min_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 2048) != 0) {
                            this.folder_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0) {
                            this.linked_chat_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.location = TLRPC$ChannelLocation.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_REORDER) != 0) {
                            this.slowmode_seconds = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_CHAT_MUTE) != 0) {
                            this.slowmode_next_send_date = abstractSerializedData2.readInt32(z2);
                        }
                        this.pts = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i2;
                        int i3 = this.can_set_username ? i2 | 64 : i2 & (-65);
                        this.flags = i3;
                        int i4 = this.can_set_stickers ? i3 | 128 : i3 & (-129);
                        this.flags = i4;
                        int i5 = this.hidden_prehistory ? i4 | 1024 : i4 & (-1025);
                        this.flags = i5;
                        int i6 = this.can_view_stats ? i5 | 4096 : i5 & (-4097);
                        this.flags = i6;
                        int i7 = this.can_set_location ? i6 | MessagesController.UPDATE_MASK_CHECK : i6 & (-65537);
                        this.flags = i7;
                        int i8 = this.has_scheduled ? i7 | MessagesController.UPDATE_MASK_CHAT_SHOW_SPAM : i7 & (-524289);
                        this.flags = i8;
                        abstractSerializedData2.writeInt32(i8);
                        abstractSerializedData2.writeInt32(this.id);
                        abstractSerializedData2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            abstractSerializedData2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            abstractSerializedData2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.kicked_count);
                        }
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.banned_count);
                        }
                        if ((this.flags & 8192) != 0) {
                            abstractSerializedData2.writeInt32(this.online_count);
                        }
                        abstractSerializedData2.writeInt32(this.read_inbox_max_id);
                        abstractSerializedData2.writeInt32(this.read_outbox_max_id);
                        abstractSerializedData2.writeInt32(this.unread_count);
                        this.chat_photo.serializeToStream(abstractSerializedData2);
                        this.notify_settings.serializeToStream(abstractSerializedData2);
                        this.exported_invite.serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i9 = 0; i9 < size; i9++) {
                            this.bot_info.get(i9).serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 16) != 0) {
                            abstractSerializedData2.writeInt32(this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            abstractSerializedData2.writeInt32(this.migrated_from_max_id);
                        }
                        if ((this.flags & 32) != 0) {
                            abstractSerializedData2.writeInt32((int) this.pinned_msg_id);
                        }
                        if ((this.flags & 256) != 0) {
                            this.stickerset.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 512) != 0) {
                            abstractSerializedData2.writeInt32(this.available_min_id);
                        }
                        if ((this.flags & 2048) != 0) {
                            abstractSerializedData2.writeInt32(this.folder_id);
                        }
                        if ((this.flags & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0) {
                            abstractSerializedData2.writeInt32(this.linked_chat_id);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.location.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_REORDER) != 0) {
                            abstractSerializedData2.writeInt32(this.slowmode_seconds);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_CHAT_MUTE) != 0) {
                            abstractSerializedData2.writeInt32(this.slowmode_next_send_date);
                        }
                        abstractSerializedData2.writeInt32(this.pts);
                    }
                };
                break;
            case 771925524:
                tLRPC$TL_chatFull = new TLRPC$TL_chatFull() { // from class: org.rbmain.tgnet.TLRPC$TL_chatFull_layer87
                    public static int constructor = 771925524;

                    @Override // org.rbmain.tgnet.TLRPC$TL_chatFull, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.id = abstractSerializedData2.readInt32(z2);
                        this.participants = TLRPC$ChatParticipants.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        int int32 = abstractSerializedData2.readInt32(z2);
                        if (int32 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int322; i2++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_chatFull, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.id);
                        this.participants.serializeToStream(abstractSerializedData2);
                        this.chat_photo.serializeToStream(abstractSerializedData2);
                        this.notify_settings.serializeToStream(abstractSerializedData2);
                        this.exported_invite.serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i2 = 0; i2 < size; i2++) {
                            this.bot_info.get(i2).serializeToStream(abstractSerializedData2);
                        }
                    }
                };
                break;
            case 1418477459:
                tLRPC$TL_chatFull = new TLRPC$TL_channelFull();
                break;
            case 1991201921:
                tLRPC$TL_chatFull = new TLRPC$TL_channelFull() { // from class: org.rbmain.tgnet.TLRPC$TL_channelFull_layer72
                    public static int constructor = 1991201921;

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelFull, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.can_set_username = (int32 & 64) != 0;
                        this.can_set_stickers = (int32 & 128) != 0;
                        this.hidden_prehistory = (int32 & 1024) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        this.about = abstractSerializedData2.readString(z2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.banned_count = abstractSerializedData2.readInt32(z2);
                        }
                        this.read_inbox_max_id = abstractSerializedData2.readInt32(z2);
                        this.read_outbox_max_id = abstractSerializedData2.readInt32(z2);
                        this.unread_count = abstractSerializedData2.readInt32(z2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        int int322 = abstractSerializedData2.readInt32(z2);
                        if (int322 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int323; i2++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.pinned_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 256) != 0) {
                            this.stickerset = TLRPC$StickerSet.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 512) != 0) {
                            this.available_min_id = abstractSerializedData2.readInt32(z2);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelFull, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i2;
                        int i3 = this.can_set_username ? i2 | 64 : i2 & (-65);
                        this.flags = i3;
                        int i4 = this.can_set_stickers ? i3 | 128 : i3 & (-129);
                        this.flags = i4;
                        int i5 = this.hidden_prehistory ? i4 | 1024 : i4 & (-1025);
                        this.flags = i5;
                        abstractSerializedData2.writeInt32(i5);
                        abstractSerializedData2.writeInt32(this.id);
                        abstractSerializedData2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            abstractSerializedData2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            abstractSerializedData2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.kicked_count);
                        }
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.banned_count);
                        }
                        abstractSerializedData2.writeInt32(this.read_inbox_max_id);
                        abstractSerializedData2.writeInt32(this.read_outbox_max_id);
                        abstractSerializedData2.writeInt32(this.unread_count);
                        this.chat_photo.serializeToStream(abstractSerializedData2);
                        this.notify_settings.serializeToStream(abstractSerializedData2);
                        this.exported_invite.serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i6 = 0; i6 < size; i6++) {
                            this.bot_info.get(i6).serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 16) != 0) {
                            abstractSerializedData2.writeInt32(this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            abstractSerializedData2.writeInt32(this.migrated_from_max_id);
                        }
                        if ((this.flags & 32) != 0) {
                            abstractSerializedData2.writeInt32((int) this.pinned_msg_id);
                        }
                        if ((this.flags & 256) != 0) {
                            this.stickerset.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 512) != 0) {
                            abstractSerializedData2.writeInt32(this.available_min_id);
                        }
                    }
                };
                break;
            case 2055070967:
                tLRPC$TL_chatFull = new TLRPC$TL_channelFull() { // from class: org.rbmain.tgnet.TLRPC$TL_channelFull_layer123
                    public static int constructor = 2055070967;

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelFull, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.can_set_username = (int32 & 64) != 0;
                        this.can_set_stickers = (int32 & 128) != 0;
                        this.hidden_prehistory = (int32 & 1024) != 0;
                        this.can_set_location = (65536 & int32) != 0;
                        this.has_scheduled = (524288 & int32) != 0;
                        this.can_view_stats = (1048576 & int32) != 0;
                        this.blocked = (int32 & 4194304) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        this.about = abstractSerializedData2.readString(z2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.banned_count = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 8192) != 0) {
                            this.online_count = abstractSerializedData2.readInt32(z2);
                        }
                        this.read_inbox_max_id = abstractSerializedData2.readInt32(z2);
                        this.read_outbox_max_id = abstractSerializedData2.readInt32(z2);
                        this.unread_count = abstractSerializedData2.readInt32(z2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if ((this.flags & 8388608) != 0) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) TLRPC$ExportedChatInvite.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        int int322 = abstractSerializedData2.readInt32(z2);
                        if (int322 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int323; i2++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.pinned_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 256) != 0) {
                            this.stickerset = TLRPC$StickerSet.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 512) != 0) {
                            this.available_min_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 2048) != 0) {
                            this.folder_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0) {
                            this.linked_chat_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.location = TLRPC$ChannelLocation.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_REORDER) != 0) {
                            this.slowmode_seconds = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_CHAT_MUTE) != 0) {
                            this.slowmode_next_send_date = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4096) != 0) {
                            this.stats_dc = abstractSerializedData2.readInt32(z2);
                        }
                        this.pts = abstractSerializedData2.readInt32(z2);
                        if ((this.flags & 2097152) != 0) {
                            this.call = TLRPC$TL_inputGroupCall.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_channelFull, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i2;
                        int i3 = this.can_set_username ? i2 | 64 : i2 & (-65);
                        this.flags = i3;
                        int i4 = this.can_set_stickers ? i3 | 128 : i3 & (-129);
                        this.flags = i4;
                        int i5 = this.hidden_prehistory ? i4 | 1024 : i4 & (-1025);
                        this.flags = i5;
                        int i6 = this.can_set_location ? i5 | MessagesController.UPDATE_MASK_CHECK : i5 & (-65537);
                        this.flags = i6;
                        int i7 = this.has_scheduled ? i6 | MessagesController.UPDATE_MASK_CHAT_SHOW_SPAM : i6 & (-524289);
                        this.flags = i7;
                        int i8 = this.can_view_stats ? i7 | 1048576 : i7 & (-1048577);
                        this.flags = i8;
                        int i9 = this.blocked ? i8 | 4194304 : i8 & (-4194305);
                        this.flags = i9;
                        abstractSerializedData2.writeInt32(i9);
                        abstractSerializedData2.writeInt32(this.id);
                        abstractSerializedData2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            abstractSerializedData2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            abstractSerializedData2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.kicked_count);
                        }
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.banned_count);
                        }
                        if ((this.flags & 8192) != 0) {
                            abstractSerializedData2.writeInt32(this.online_count);
                        }
                        abstractSerializedData2.writeInt32(this.read_inbox_max_id);
                        abstractSerializedData2.writeInt32(this.read_outbox_max_id);
                        abstractSerializedData2.writeInt32(this.unread_count);
                        this.chat_photo.serializeToStream(abstractSerializedData2);
                        this.notify_settings.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 8388608) != 0) {
                            this.exported_invite.serializeToStream(abstractSerializedData2);
                        }
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i10 = 0; i10 < size; i10++) {
                            this.bot_info.get(i10).serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 16) != 0) {
                            abstractSerializedData2.writeInt32(this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            abstractSerializedData2.writeInt32(this.migrated_from_max_id);
                        }
                        if ((this.flags & 32) != 0) {
                            abstractSerializedData2.writeInt32((int) this.pinned_msg_id);
                        }
                        if ((this.flags & 256) != 0) {
                            this.stickerset.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 512) != 0) {
                            abstractSerializedData2.writeInt32(this.available_min_id);
                        }
                        if ((this.flags & 2048) != 0) {
                            abstractSerializedData2.writeInt32(this.folder_id);
                        }
                        if ((this.flags & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0) {
                            abstractSerializedData2.writeInt32(this.linked_chat_id);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.location.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_REORDER) != 0) {
                            abstractSerializedData2.writeInt32(this.slowmode_seconds);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_CHAT_MUTE) != 0) {
                            abstractSerializedData2.writeInt32(this.slowmode_next_send_date);
                        }
                        if ((this.flags & 4096) != 0) {
                            abstractSerializedData2.writeInt32(this.stats_dc);
                        }
                        abstractSerializedData2.writeInt32(this.pts);
                        if ((this.flags & 2097152) != 0) {
                            this.call.serializeToStream(abstractSerializedData2);
                        }
                    }
                };
                break;
            default:
                tLRPC$TL_chatFull = null;
                break;
        }
        if (tLRPC$TL_chatFull == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in ChatFull", Integer.valueOf(i)));
        }
        if (tLRPC$TL_chatFull != null) {
            tLRPC$TL_chatFull.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_chatFull;
    }
}
