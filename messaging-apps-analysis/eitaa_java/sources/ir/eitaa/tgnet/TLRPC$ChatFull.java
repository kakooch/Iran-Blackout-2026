package ir.eitaa.tgnet;

import java.util.ArrayList;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public abstract class TLRPC$ChatFull extends TLObject {
    public String about;
    public int admins_count;
    public int available_min_id;
    public int banned_count;
    public boolean blocked;
    public TLRPC$TL_inputGroupCall call;
    public int call_msg_id;
    public boolean can_set_location;
    public boolean can_set_stickers;
    public boolean can_set_username;
    public boolean can_view_participants;
    public boolean can_view_stats;
    public TLRPC$Photo chat_photo;
    public TLRPC$ExportedChatInvite exported_invite;
    public int flags;
    public int folder_id;
    public TLRPC$Peer groupcall_default_join_as;
    public boolean has_scheduled;
    public boolean hidden_prehistory;
    public long id;
    public long inviterId;
    public int invitesCount;
    public int kicked_count;
    public long linked_chat_id;
    public TLRPC$ChannelLocation location;
    public long migrated_from_chat_id;
    public int migrated_from_max_id;
    public TLRPC$PeerNotifySettings notify_settings;
    public int online_count;
    public TLRPC$ChatParticipants participants;
    public int participants_count;
    public int pinned_msg_id;
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
    public ArrayList<TLRPC$BotInfo> bot_info = new ArrayList<>();
    public ArrayList<String> pending_suggestions = new ArrayList<>();

    public static TLRPC$ChatFull TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$ChatFull tLRPC$TL_channelFull;
        switch (constructor) {
            case -1977734781:
                tLRPC$TL_channelFull = new TLRPC$TL_chatFull() { // from class: ir.eitaa.tgnet.TLRPC$TL_chatFull_layer131
                    public static int constructor = -1977734781;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatFull, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.can_set_username = (int32 & 128) != 0;
                        this.has_scheduled = (int32 & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0;
                        this.id = stream2.readInt32(exception2);
                        this.about = stream2.readString(exception2);
                        this.participants = TLRPC$ChatParticipants.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 4) != 0) {
                            this.chat_photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 8192) != 0) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) TLRPC$ExportedChatInvite.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            int int322 = stream2.readInt32(exception2);
                            if (int322 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = stream2.readInt32(exception2);
                            for (int i = 0; i < int323; i++) {
                                TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$BotInfoTLdeserialize == null) {
                                    return;
                                }
                                this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            this.pinned_msg_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            this.folder_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0) {
                            this.call = TLRPC$TL_inputGroupCall.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 16384) != 0) {
                            this.ttl_period = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.groupcall_default_join_as = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatFull, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.can_set_username ? this.flags | 128 : this.flags & (-129);
                        this.flags = i;
                        int i2 = this.has_scheduled ? i | Factory.DEVICE_HAS_CRAPPY_OPENSLES : i & (-257);
                        this.flags = i2;
                        stream2.writeInt32(i2);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.about);
                        this.participants.serializeToStream(stream2);
                        if ((this.flags & 4) != 0) {
                            this.chat_photo.serializeToStream(stream2);
                        }
                        this.notify_settings.serializeToStream(stream2);
                        if ((this.flags & 8192) != 0) {
                            this.exported_invite.serializeToStream(stream2);
                        }
                        if ((this.flags & 8) != 0) {
                            stream2.writeInt32(481674261);
                            int size = this.bot_info.size();
                            stream2.writeInt32(size);
                            for (int i3 = 0; i3 < size; i3++) {
                                this.bot_info.get(i3).serializeToStream(stream2);
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            stream2.writeInt32(this.pinned_msg_id);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            stream2.writeInt32(this.folder_id);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0) {
                            this.call.serializeToStream(stream2);
                        }
                        if ((this.flags & 16384) != 0) {
                            stream2.writeInt32(this.ttl_period);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.groupcall_default_join_as.serializeToStream(stream2);
                        }
                    }
                };
                break;
            case -1781833897:
                tLRPC$TL_channelFull = new TLRPC$TL_channelFull() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelFull_layer70
                    public static int constructor = -1781833897;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.can_set_username = (int32 & 64) != 0;
                        this.id = stream2.readInt32(exception2);
                        this.about = stream2.readString(exception2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.banned_count = stream2.readInt32(exception2);
                        }
                        this.read_inbox_max_id = stream2.readInt32(exception2);
                        this.read_outbox_max_id = stream2.readInt32(exception2);
                        this.unread_count = stream2.readInt32(exception2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        int int322 = stream2.readInt32(exception2);
                        if (int322 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = stream2.readInt32(exception2);
                        for (int i = 0; i < int323; i++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.pinned_msg_id = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i;
                        int i2 = this.can_set_username ? i | 64 : i & (-65);
                        this.flags = i2;
                        stream2.writeInt32(i2);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.kicked_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.banned_count);
                        }
                        stream2.writeInt32(this.read_inbox_max_id);
                        stream2.writeInt32(this.read_outbox_max_id);
                        stream2.writeInt32(this.unread_count);
                        this.chat_photo.serializeToStream(stream2);
                        this.notify_settings.serializeToStream(stream2);
                        this.exported_invite.serializeToStream(stream2);
                        stream2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        stream2.writeInt32(size);
                        for (int i3 = 0; i3 < size; i3++) {
                            this.bot_info.get(i3).serializeToStream(stream2);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32((int) this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32(this.migrated_from_max_id);
                        }
                        if ((this.flags & 32) != 0) {
                            stream2.writeInt32(this.pinned_msg_id);
                        }
                    }
                };
                break;
            case -1749097118:
                tLRPC$TL_channelFull = new TLRPC$TL_channelFull() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelFull_layer52
                    public static int constructor = -1749097118;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.can_set_username = (int32 & 64) != 0;
                        this.id = stream2.readInt32(exception2);
                        this.about = stream2.readString(exception2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = stream2.readInt32(exception2);
                        }
                        this.read_inbox_max_id = stream2.readInt32(exception2);
                        this.unread_count = stream2.readInt32(exception2);
                        this.unread_important_count = stream2.readInt32(exception2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        int int322 = stream2.readInt32(exception2);
                        if (int322 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = stream2.readInt32(exception2);
                        for (int i = 0; i < int323; i++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.pinned_msg_id = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i;
                        int i2 = this.can_set_username ? i | 64 : i & (-65);
                        this.flags = i2;
                        stream2.writeInt32(i2);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.kicked_count);
                        }
                        stream2.writeInt32(this.read_inbox_max_id);
                        stream2.writeInt32(this.unread_count);
                        stream2.writeInt32(this.unread_important_count);
                        this.chat_photo.serializeToStream(stream2);
                        this.notify_settings.serializeToStream(stream2);
                        this.exported_invite.serializeToStream(stream2);
                        stream2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        stream2.writeInt32(size);
                        for (int i3 = 0; i3 < size; i3++) {
                            this.bot_info.get(i3).serializeToStream(stream2);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32((int) this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32(this.migrated_from_max_id);
                        }
                        if ((this.flags & 32) != 0) {
                            stream2.writeInt32(this.pinned_msg_id);
                        }
                    }
                };
                break;
            case -1736252138:
                tLRPC$TL_channelFull = new TLRPC$TL_channelFull() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelFull_layer101
                    public static int constructor = -1736252138;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.can_set_username = (int32 & 64) != 0;
                        this.can_set_stickers = (int32 & 128) != 0;
                        this.hidden_prehistory = (int32 & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0;
                        this.can_view_stats = (int32 & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0;
                        this.id = stream2.readInt32(exception2);
                        this.about = stream2.readString(exception2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.banned_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8192) != 0) {
                            this.online_count = stream2.readInt32(exception2);
                        }
                        this.read_inbox_max_id = stream2.readInt32(exception2);
                        this.read_outbox_max_id = stream2.readInt32(exception2);
                        this.unread_count = stream2.readInt32(exception2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        int int322 = stream2.readInt32(exception2);
                        if (int322 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = stream2.readInt32(exception2);
                        for (int i = 0; i < int323; i++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.pinned_msg_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.stickerset = TLRPC$StickerSet.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            this.available_min_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            this.folder_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8192) != 0) {
                            this.linked_chat_id = stream2.readInt32(exception2);
                        }
                        this.pts = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i;
                        int i2 = this.can_set_username ? i | 64 : i & (-65);
                        this.flags = i2;
                        int i3 = this.can_set_stickers ? i2 | 128 : i2 & (-129);
                        this.flags = i3;
                        int i4 = this.hidden_prehistory ? i3 | Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV : i3 & (-1025);
                        this.flags = i4;
                        int i5 = this.can_view_stats ? i4 | Factory.DEVICE_HAS_CRAPPY_AAUDIO : i4 & (-4097);
                        this.flags = i5;
                        stream2.writeInt32(i5);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.kicked_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.banned_count);
                        }
                        if ((this.flags & 8192) != 0) {
                            stream2.writeInt32(this.online_count);
                        }
                        stream2.writeInt32(this.read_inbox_max_id);
                        stream2.writeInt32(this.read_outbox_max_id);
                        stream2.writeInt32(this.unread_count);
                        this.chat_photo.serializeToStream(stream2);
                        this.notify_settings.serializeToStream(stream2);
                        this.exported_invite.serializeToStream(stream2);
                        stream2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        stream2.writeInt32(size);
                        for (int i6 = 0; i6 < size; i6++) {
                            this.bot_info.get(i6).serializeToStream(stream2);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32((int) this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32(this.migrated_from_max_id);
                        }
                        if ((this.flags & 32) != 0) {
                            stream2.writeInt32(this.pinned_msg_id);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.stickerset.serializeToStream(stream2);
                        }
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            stream2.writeInt32(this.available_min_id);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            stream2.writeInt32(this.folder_id);
                        }
                        if ((this.flags & 8192) != 0) {
                            stream2.writeInt32((int) this.linked_chat_id);
                        }
                        stream2.writeInt32(this.pts);
                    }
                };
                break;
            case -1640751649:
                tLRPC$TL_channelFull = new TLRPC$TL_channelFull() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelFull_layer48
                    public static int constructor = -1640751649;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.id = stream2.readInt32(exception2);
                        this.about = stream2.readString(exception2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = stream2.readInt32(exception2);
                        }
                        this.read_inbox_max_id = stream2.readInt32(exception2);
                        this.unread_count = stream2.readInt32(exception2);
                        this.unread_important_count = stream2.readInt32(exception2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        int int322 = stream2.readInt32(exception2);
                        if (int322 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = stream2.readInt32(exception2);
                        for (int i = 0; i < int323; i++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i;
                        stream2.writeInt32(i);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.kicked_count);
                        }
                        stream2.writeInt32(this.read_inbox_max_id);
                        stream2.writeInt32(this.unread_count);
                        stream2.writeInt32(this.unread_important_count);
                        this.chat_photo.serializeToStream(stream2);
                        this.notify_settings.serializeToStream(stream2);
                        this.exported_invite.serializeToStream(stream2);
                        stream2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        stream2.writeInt32(size);
                        for (int i2 = 0; i2 < size; i2++) {
                            this.bot_info.get(i2).serializeToStream(stream2);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32((int) this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32(this.migrated_from_max_id);
                        }
                    }
                };
                break;
            case -1009430225:
                tLRPC$TL_channelFull = new TLRPC$TL_channelFull() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelFull_layer67
                    public static int constructor = -1009430225;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.can_set_username = (int32 & 64) != 0;
                        this.id = stream2.readInt32(exception2);
                        this.about = stream2.readString(exception2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = stream2.readInt32(exception2);
                        }
                        this.read_inbox_max_id = stream2.readInt32(exception2);
                        this.read_outbox_max_id = stream2.readInt32(exception2);
                        this.unread_count = stream2.readInt32(exception2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        int int322 = stream2.readInt32(exception2);
                        if (int322 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = stream2.readInt32(exception2);
                        for (int i = 0; i < int323; i++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.pinned_msg_id = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i;
                        int i2 = this.can_set_username ? i | 64 : i & (-65);
                        this.flags = i2;
                        stream2.writeInt32(i2);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.kicked_count);
                        }
                        stream2.writeInt32(this.read_inbox_max_id);
                        stream2.writeInt32(this.read_outbox_max_id);
                        stream2.writeInt32(this.unread_count);
                        this.chat_photo.serializeToStream(stream2);
                        this.notify_settings.serializeToStream(stream2);
                        this.exported_invite.serializeToStream(stream2);
                        stream2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        stream2.writeInt32(size);
                        for (int i3 = 0; i3 < size; i3++) {
                            this.bot_info.get(i3).serializeToStream(stream2);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32((int) this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32(this.migrated_from_max_id);
                        }
                        if ((this.flags & 32) != 0) {
                            stream2.writeInt32(this.pinned_msg_id);
                        }
                    }
                };
                break;
            case -877254512:
                tLRPC$TL_channelFull = new TLRPC$TL_channelFull() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelFull_layer89
                    public static int constructor = -877254512;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.can_set_username = (int32 & 64) != 0;
                        this.can_set_stickers = (int32 & 128) != 0;
                        this.hidden_prehistory = (int32 & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0;
                        this.id = stream2.readInt32(exception2);
                        this.about = stream2.readString(exception2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.banned_count = stream2.readInt32(exception2);
                        }
                        this.read_inbox_max_id = stream2.readInt32(exception2);
                        this.read_outbox_max_id = stream2.readInt32(exception2);
                        this.unread_count = stream2.readInt32(exception2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        int int322 = stream2.readInt32(exception2);
                        if (int322 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = stream2.readInt32(exception2);
                        for (int i = 0; i < int323; i++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.pinned_msg_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.stickerset = TLRPC$StickerSet.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            this.available_min_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            this.call_msg_id = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i;
                        int i2 = this.can_set_username ? i | 64 : i & (-65);
                        this.flags = i2;
                        int i3 = this.can_set_stickers ? i2 | 128 : i2 & (-129);
                        this.flags = i3;
                        int i4 = this.hidden_prehistory ? i3 | Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV : i3 & (-1025);
                        this.flags = i4;
                        stream2.writeInt32(i4);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.kicked_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.banned_count);
                        }
                        stream2.writeInt32(this.read_inbox_max_id);
                        stream2.writeInt32(this.read_outbox_max_id);
                        stream2.writeInt32(this.unread_count);
                        this.chat_photo.serializeToStream(stream2);
                        this.notify_settings.serializeToStream(stream2);
                        this.exported_invite.serializeToStream(stream2);
                        stream2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        stream2.writeInt32(size);
                        for (int i5 = 0; i5 < size; i5++) {
                            this.bot_info.get(i5).serializeToStream(stream2);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32((int) this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32(this.migrated_from_max_id);
                        }
                        if ((this.flags & 32) != 0) {
                            stream2.writeInt32(this.pinned_msg_id);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.stickerset.serializeToStream(stream2);
                        }
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            stream2.writeInt32(this.available_min_id);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            stream2.writeInt32(this.call_msg_id);
                        }
                    }
                };
                break;
            case -374179305:
                tLRPC$TL_channelFull = new TLRPC$TL_channelFull();
                break;
            case -304961647:
                tLRPC$TL_channelFull = new TLRPC$TL_chatFull() { // from class: ir.eitaa.tgnet.TLRPC$TL_chatFull_layer92
                    public static int constructor = -304961647;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatFull, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.flags = stream2.readInt32(exception2);
                        this.id = stream2.readInt32(exception2);
                        this.participants = TLRPC$ChatParticipants.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 4) != 0) {
                            this.chat_photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        if ((this.flags & 8) != 0) {
                            int int32 = stream2.readInt32(exception2);
                            if (int32 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                                }
                                return;
                            }
                            int int322 = stream2.readInt32(exception2);
                            for (int i = 0; i < int322; i++) {
                                TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$BotInfoTLdeserialize == null) {
                                    return;
                                }
                                this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            this.pinned_msg_id = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatFull, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.flags);
                        stream2.writeInt32((int) this.id);
                        this.participants.serializeToStream(stream2);
                        if ((this.flags & 4) != 0) {
                            this.chat_photo.serializeToStream(stream2);
                        }
                        this.notify_settings.serializeToStream(stream2);
                        this.exported_invite.serializeToStream(stream2);
                        if ((this.flags & 8) != 0) {
                            stream2.writeInt32(481674261);
                            int size = this.bot_info.size();
                            stream2.writeInt32(size);
                            for (int i = 0; i < size; i++) {
                                this.bot_info.get(i).serializeToStream(stream2);
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            stream2.writeInt32(this.pinned_msg_id);
                        }
                    }
                };
                break;
            case -281384243:
                tLRPC$TL_channelFull = new TLRPC$TL_channelFull() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelFull_layer122
                    public static int constructor = -281384243;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.can_set_username = (int32 & 64) != 0;
                        this.can_set_stickers = (int32 & 128) != 0;
                        this.hidden_prehistory = (int32 & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0;
                        this.can_set_location = (65536 & int32) != 0;
                        this.has_scheduled = (524288 & int32) != 0;
                        this.can_view_stats = (1048576 & int32) != 0;
                        this.blocked = (int32 & 4194304) != 0;
                        this.id = stream2.readInt32(exception2);
                        this.about = stream2.readString(exception2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.banned_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8192) != 0) {
                            this.online_count = stream2.readInt32(exception2);
                        }
                        this.read_inbox_max_id = stream2.readInt32(exception2);
                        this.read_outbox_max_id = stream2.readInt32(exception2);
                        this.unread_count = stream2.readInt32(exception2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        int int322 = stream2.readInt32(exception2);
                        if (int322 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = stream2.readInt32(exception2);
                        for (int i = 0; i < int323; i++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.pinned_msg_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.stickerset = TLRPC$StickerSet.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            this.available_min_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            this.folder_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 16384) != 0) {
                            this.linked_chat_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.location = TLRPC$ChannelLocation.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 131072) != 0) {
                            this.slowmode_seconds = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 262144) != 0) {
                            this.slowmode_next_send_date = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0) {
                            this.stats_dc = stream2.readInt32(exception2);
                        }
                        this.pts = stream2.readInt32(exception2);
                        if ((this.flags & 2097152) != 0) {
                            this.call = TLRPC$TL_inputGroupCall.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i;
                        int i2 = this.can_set_username ? i | 64 : i & (-65);
                        this.flags = i2;
                        int i3 = this.can_set_stickers ? i2 | 128 : i2 & (-129);
                        this.flags = i3;
                        int i4 = this.hidden_prehistory ? i3 | Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV : i3 & (-1025);
                        this.flags = i4;
                        int i5 = this.can_set_location ? i4 | 65536 : i4 & (-65537);
                        this.flags = i5;
                        int i6 = this.has_scheduled ? i5 | 524288 : i5 & (-524289);
                        this.flags = i6;
                        int i7 = this.can_view_stats ? i6 | 1048576 : i6 & (-1048577);
                        this.flags = i7;
                        int i8 = this.blocked ? i7 | 4194304 : i7 & (-4194305);
                        this.flags = i8;
                        stream2.writeInt32(i8);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.kicked_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.banned_count);
                        }
                        if ((this.flags & 8192) != 0) {
                            stream2.writeInt32(this.online_count);
                        }
                        stream2.writeInt32(this.read_inbox_max_id);
                        stream2.writeInt32(this.read_outbox_max_id);
                        stream2.writeInt32(this.unread_count);
                        this.chat_photo.serializeToStream(stream2);
                        this.notify_settings.serializeToStream(stream2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInvite = this.exported_invite;
                        if (tLRPC$ExportedChatInvite != null) {
                            tLRPC$ExportedChatInvite.serializeToStream(stream2);
                        } else {
                            new TLRPC$TL_chatInviteEmpty_layer122().serializeToStream(stream2);
                        }
                        stream2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        stream2.writeInt32(size);
                        for (int i9 = 0; i9 < size; i9++) {
                            this.bot_info.get(i9).serializeToStream(stream2);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32((int) this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32(this.migrated_from_max_id);
                        }
                        if ((this.flags & 32) != 0) {
                            stream2.writeInt32(this.pinned_msg_id);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.stickerset.serializeToStream(stream2);
                        }
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            stream2.writeInt32(this.available_min_id);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            stream2.writeInt32(this.folder_id);
                        }
                        if ((this.flags & 16384) != 0) {
                            stream2.writeInt32((int) this.linked_chat_id);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.location.serializeToStream(stream2);
                        }
                        if ((this.flags & 131072) != 0) {
                            stream2.writeInt32(this.slowmode_seconds);
                        }
                        if ((this.flags & 262144) != 0) {
                            stream2.writeInt32(this.slowmode_next_send_date);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0) {
                            stream2.writeInt32(this.stats_dc);
                        }
                        stream2.writeInt32(this.pts);
                        if ((this.flags & 2097152) != 0) {
                            this.call.serializeToStream(stream2);
                        }
                    }
                };
                break;
            case -261341160:
                tLRPC$TL_channelFull = new TLRPC$TL_chatFull() { // from class: ir.eitaa.tgnet.TLRPC$TL_chatFull_layer124
                    public static int constructor = -261341160;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatFull, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.can_set_username = (int32 & 128) != 0;
                        this.has_scheduled = (int32 & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0;
                        this.id = stream2.readInt32(exception2);
                        this.about = stream2.readString(exception2);
                        this.participants = TLRPC$ChatParticipants.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 4) != 0) {
                            this.chat_photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 8192) != 0) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) TLRPC$ExportedChatInvite.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            int int322 = stream2.readInt32(exception2);
                            if (int322 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = stream2.readInt32(exception2);
                            for (int i = 0; i < int323; i++) {
                                TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$BotInfoTLdeserialize == null) {
                                    return;
                                }
                                this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            this.pinned_msg_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            this.folder_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0) {
                            this.call = TLRPC$TL_inputGroupCall.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 16384) != 0) {
                            this.ttl_period = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatFull, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.can_set_username ? this.flags | 128 : this.flags & (-129);
                        this.flags = i;
                        int i2 = this.has_scheduled ? i | Factory.DEVICE_HAS_CRAPPY_OPENSLES : i & (-257);
                        this.flags = i2;
                        stream2.writeInt32(i2);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.about);
                        this.participants.serializeToStream(stream2);
                        if ((this.flags & 4) != 0) {
                            this.chat_photo.serializeToStream(stream2);
                        }
                        this.notify_settings.serializeToStream(stream2);
                        if ((this.flags & 8192) != 0) {
                            this.exported_invite.serializeToStream(stream2);
                        }
                        if ((this.flags & 8) != 0) {
                            stream2.writeInt32(481674261);
                            int size = this.bot_info.size();
                            stream2.writeInt32(size);
                            for (int i3 = 0; i3 < size; i3++) {
                                this.bot_info.get(i3).serializeToStream(stream2);
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            stream2.writeInt32(this.pinned_msg_id);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            stream2.writeInt32(this.folder_id);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0) {
                            this.call.serializeToStream(stream2);
                        }
                        if ((this.flags & 16384) != 0) {
                            stream2.writeInt32(this.ttl_period);
                        }
                    }
                };
                break;
            case -253335766:
                tLRPC$TL_channelFull = new TLRPC$TL_channelFull() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelFull_layer121
                    public static int constructor = -253335766;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.can_set_username = (int32 & 64) != 0;
                        this.can_set_stickers = (int32 & 128) != 0;
                        this.hidden_prehistory = (int32 & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0;
                        this.can_set_location = (65536 & int32) != 0;
                        this.has_scheduled = (524288 & int32) != 0;
                        this.can_view_stats = (1048576 & int32) != 0;
                        this.blocked = (int32 & 4194304) != 0;
                        this.id = stream2.readInt32(exception2);
                        this.about = stream2.readString(exception2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.banned_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8192) != 0) {
                            this.online_count = stream2.readInt32(exception2);
                        }
                        this.read_inbox_max_id = stream2.readInt32(exception2);
                        this.read_outbox_max_id = stream2.readInt32(exception2);
                        this.unread_count = stream2.readInt32(exception2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        int int322 = stream2.readInt32(exception2);
                        if (int322 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = stream2.readInt32(exception2);
                        for (int i = 0; i < int323; i++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.pinned_msg_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.stickerset = TLRPC$StickerSet.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            this.available_min_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            this.folder_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 16384) != 0) {
                            this.linked_chat_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.location = TLRPC$ChannelLocation.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 131072) != 0) {
                            this.slowmode_seconds = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 262144) != 0) {
                            this.slowmode_next_send_date = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0) {
                            this.stats_dc = stream2.readInt32(exception2);
                        }
                        this.pts = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i;
                        int i2 = this.can_set_username ? i | 64 : i & (-65);
                        this.flags = i2;
                        int i3 = this.can_set_stickers ? i2 | 128 : i2 & (-129);
                        this.flags = i3;
                        int i4 = this.hidden_prehistory ? i3 | Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV : i3 & (-1025);
                        this.flags = i4;
                        int i5 = this.can_set_location ? i4 | 65536 : i4 & (-65537);
                        this.flags = i5;
                        int i6 = this.has_scheduled ? i5 | 524288 : i5 & (-524289);
                        this.flags = i6;
                        int i7 = this.can_view_stats ? i6 | 1048576 : i6 & (-1048577);
                        this.flags = i7;
                        int i8 = this.blocked ? i7 | 4194304 : i7 & (-4194305);
                        this.flags = i8;
                        stream2.writeInt32(i8);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.kicked_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.banned_count);
                        }
                        if ((this.flags & 8192) != 0) {
                            stream2.writeInt32(this.online_count);
                        }
                        stream2.writeInt32(this.read_inbox_max_id);
                        stream2.writeInt32(this.read_outbox_max_id);
                        stream2.writeInt32(this.unread_count);
                        this.chat_photo.serializeToStream(stream2);
                        this.notify_settings.serializeToStream(stream2);
                        this.exported_invite.serializeToStream(stream2);
                        stream2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        stream2.writeInt32(size);
                        for (int i9 = 0; i9 < size; i9++) {
                            this.bot_info.get(i9).serializeToStream(stream2);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32((int) this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32(this.migrated_from_max_id);
                        }
                        if ((this.flags & 32) != 0) {
                            stream2.writeInt32(this.pinned_msg_id);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.stickerset.serializeToStream(stream2);
                        }
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            stream2.writeInt32(this.available_min_id);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            stream2.writeInt32(this.folder_id);
                        }
                        if ((this.flags & 16384) != 0) {
                            stream2.writeInt32((int) this.linked_chat_id);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.location.serializeToStream(stream2);
                        }
                        if ((this.flags & 131072) != 0) {
                            stream2.writeInt32(this.slowmode_seconds);
                        }
                        if ((this.flags & 262144) != 0) {
                            stream2.writeInt32(this.slowmode_next_send_date);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0) {
                            stream2.writeInt32(this.stats_dc);
                        }
                        stream2.writeInt32(this.pts);
                    }
                };
                break;
            case -213431562:
                tLRPC$TL_channelFull = new TLRPC$TL_chatFull() { // from class: ir.eitaa.tgnet.TLRPC$TL_chatFull_layer123
                    public static int constructor = -213431562;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatFull, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.can_set_username = (int32 & 128) != 0;
                        this.has_scheduled = (int32 & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0;
                        this.id = stream2.readInt32(exception2);
                        this.about = stream2.readString(exception2);
                        this.participants = TLRPC$ChatParticipants.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 4) != 0) {
                            this.chat_photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 8192) != 0) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) TLRPC$ExportedChatInvite.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            int int322 = stream2.readInt32(exception2);
                            if (int322 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = stream2.readInt32(exception2);
                            for (int i = 0; i < int323; i++) {
                                TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$BotInfoTLdeserialize == null) {
                                    return;
                                }
                                this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            this.pinned_msg_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            this.folder_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0) {
                            this.call = TLRPC$TL_inputGroupCall.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatFull, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.can_set_username ? this.flags | 128 : this.flags & (-129);
                        this.flags = i;
                        int i2 = this.has_scheduled ? i | Factory.DEVICE_HAS_CRAPPY_OPENSLES : i & (-257);
                        this.flags = i2;
                        stream2.writeInt32(i2);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.about);
                        this.participants.serializeToStream(stream2);
                        if ((this.flags & 4) != 0) {
                            this.chat_photo.serializeToStream(stream2);
                        }
                        this.notify_settings.serializeToStream(stream2);
                        if ((this.flags & 8192) != 0) {
                            this.exported_invite.serializeToStream(stream2);
                        }
                        if ((this.flags & 8) != 0) {
                            stream2.writeInt32(481674261);
                            int size = this.bot_info.size();
                            stream2.writeInt32(size);
                            for (int i3 = 0; i3 < size; i3++) {
                                this.bot_info.get(i3).serializeToStream(stream2);
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            stream2.writeInt32(this.pinned_msg_id);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            stream2.writeInt32(this.folder_id);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0) {
                            this.call.serializeToStream(stream2);
                        }
                    }
                };
                break;
            case -88925533:
                tLRPC$TL_channelFull = new TLRPC$TL_channelFull() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelFull_old
                    public static int constructor = -88925533;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.id = stream2.readInt32(exception2);
                        this.about = stream2.readString(exception2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = stream2.readInt32(exception2);
                        }
                        this.read_inbox_max_id = stream2.readInt32(exception2);
                        this.unread_count = stream2.readInt32(exception2);
                        this.unread_important_count = stream2.readInt32(exception2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i;
                        stream2.writeInt32(i);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.kicked_count);
                        }
                        stream2.writeInt32(this.read_inbox_max_id);
                        stream2.writeInt32(this.unread_count);
                        stream2.writeInt32(this.unread_important_count);
                        this.chat_photo.serializeToStream(stream2);
                        this.notify_settings.serializeToStream(stream2);
                        this.exported_invite.serializeToStream(stream2);
                    }
                };
                break;
            case 56920439:
                tLRPC$TL_channelFull = new TLRPC$TL_channelFull() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelFull_layer99
                    public static int constructor = 56920439;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.can_set_username = (int32 & 64) != 0;
                        this.can_set_stickers = (int32 & 128) != 0;
                        this.hidden_prehistory = (int32 & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0;
                        this.can_view_stats = (int32 & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0;
                        this.id = stream2.readInt32(exception2);
                        this.about = stream2.readString(exception2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.banned_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8192) != 0) {
                            this.online_count = stream2.readInt32(exception2);
                        }
                        this.read_inbox_max_id = stream2.readInt32(exception2);
                        this.read_outbox_max_id = stream2.readInt32(exception2);
                        this.unread_count = stream2.readInt32(exception2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        int int322 = stream2.readInt32(exception2);
                        if (int322 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = stream2.readInt32(exception2);
                        for (int i = 0; i < int323; i++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.pinned_msg_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.stickerset = TLRPC$StickerSet.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            this.available_min_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            this.folder_id = stream2.readInt32(exception2);
                        }
                        this.pts = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i;
                        int i2 = this.can_set_username ? i | 64 : i & (-65);
                        this.flags = i2;
                        int i3 = this.can_set_stickers ? i2 | 128 : i2 & (-129);
                        this.flags = i3;
                        int i4 = this.hidden_prehistory ? i3 | Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV : i3 & (-1025);
                        this.flags = i4;
                        int i5 = this.can_view_stats ? i4 | Factory.DEVICE_HAS_CRAPPY_AAUDIO : i4 & (-4097);
                        this.flags = i5;
                        stream2.writeInt32(i5);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.kicked_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.banned_count);
                        }
                        if ((this.flags & 8192) != 0) {
                            stream2.writeInt32(this.online_count);
                        }
                        stream2.writeInt32(this.read_inbox_max_id);
                        stream2.writeInt32(this.read_outbox_max_id);
                        stream2.writeInt32(this.unread_count);
                        this.chat_photo.serializeToStream(stream2);
                        this.notify_settings.serializeToStream(stream2);
                        this.exported_invite.serializeToStream(stream2);
                        stream2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        stream2.writeInt32(size);
                        for (int i6 = 0; i6 < size; i6++) {
                            this.bot_info.get(i6).serializeToStream(stream2);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32((int) this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32(this.migrated_from_max_id);
                        }
                        if ((this.flags & 32) != 0) {
                            stream2.writeInt32(this.pinned_msg_id);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.stickerset.serializeToStream(stream2);
                        }
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            stream2.writeInt32(this.available_min_id);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            stream2.writeInt32(this.folder_id);
                        }
                        stream2.writeInt32(this.pts);
                    }
                };
                break;
            case 231260545:
                tLRPC$TL_channelFull = new TLRPC$TL_chatFull() { // from class: ir.eitaa.tgnet.TLRPC$TL_chatFull_layer122
                    public static int constructor = 231260545;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatFull, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.can_set_username = (int32 & 128) != 0;
                        this.has_scheduled = (int32 & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0;
                        this.id = stream2.readInt32(exception2);
                        this.about = stream2.readString(exception2);
                        this.participants = TLRPC$ChatParticipants.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 4) != 0) {
                            this.chat_photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        if ((this.flags & 8) != 0) {
                            int int322 = stream2.readInt32(exception2);
                            if (int322 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = stream2.readInt32(exception2);
                            for (int i = 0; i < int323; i++) {
                                TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$BotInfoTLdeserialize == null) {
                                    return;
                                }
                                this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            this.pinned_msg_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            this.folder_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0) {
                            this.call = TLRPC$TL_inputGroupCall.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatFull, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.can_set_username ? this.flags | 128 : this.flags & (-129);
                        this.flags = i;
                        int i2 = this.has_scheduled ? i | Factory.DEVICE_HAS_CRAPPY_OPENSLES : i & (-257);
                        this.flags = i2;
                        stream2.writeInt32(i2);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.about);
                        this.participants.serializeToStream(stream2);
                        if ((this.flags & 4) != 0) {
                            this.chat_photo.serializeToStream(stream2);
                        }
                        this.notify_settings.serializeToStream(stream2);
                        this.exported_invite.serializeToStream(stream2);
                        if ((this.flags & 8) != 0) {
                            stream2.writeInt32(481674261);
                            int size = this.bot_info.size();
                            stream2.writeInt32(size);
                            for (int i3 = 0; i3 < size; i3++) {
                                this.bot_info.get(i3).serializeToStream(stream2);
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            stream2.writeInt32(this.pinned_msg_id);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            stream2.writeInt32(this.folder_id);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0) {
                            this.call.serializeToStream(stream2);
                        }
                    }
                };
                break;
            case 277964371:
                tLRPC$TL_channelFull = new TLRPC$TL_channelFull() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelFull_layer103
                    public static int constructor = 277964371;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.can_set_username = (int32 & 64) != 0;
                        this.can_set_stickers = (int32 & 128) != 0;
                        this.hidden_prehistory = (int32 & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0;
                        this.can_view_stats = (int32 & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0;
                        this.can_set_location = (int32 & 65536) != 0;
                        this.id = stream2.readInt32(exception2);
                        this.about = stream2.readString(exception2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.banned_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8192) != 0) {
                            this.online_count = stream2.readInt32(exception2);
                        }
                        this.read_inbox_max_id = stream2.readInt32(exception2);
                        this.read_outbox_max_id = stream2.readInt32(exception2);
                        this.unread_count = stream2.readInt32(exception2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        int int322 = stream2.readInt32(exception2);
                        if (int322 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = stream2.readInt32(exception2);
                        for (int i = 0; i < int323; i++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.pinned_msg_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.stickerset = TLRPC$StickerSet.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            this.available_min_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            this.folder_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 16384) != 0) {
                            this.linked_chat_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.location = TLRPC$ChannelLocation.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        this.pts = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i;
                        int i2 = this.can_set_username ? i | 64 : i & (-65);
                        this.flags = i2;
                        int i3 = this.can_set_stickers ? i2 | 128 : i2 & (-129);
                        this.flags = i3;
                        int i4 = this.hidden_prehistory ? i3 | Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV : i3 & (-1025);
                        this.flags = i4;
                        int i5 = this.can_view_stats ? i4 | Factory.DEVICE_HAS_CRAPPY_AAUDIO : i4 & (-4097);
                        this.flags = i5;
                        int i6 = this.can_set_location ? i5 | 65536 : i5 & (-65537);
                        this.flags = i6;
                        stream2.writeInt32(i6);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.kicked_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.banned_count);
                        }
                        if ((this.flags & 8192) != 0) {
                            stream2.writeInt32(this.online_count);
                        }
                        stream2.writeInt32(this.read_inbox_max_id);
                        stream2.writeInt32(this.read_outbox_max_id);
                        stream2.writeInt32(this.unread_count);
                        this.chat_photo.serializeToStream(stream2);
                        this.notify_settings.serializeToStream(stream2);
                        this.exported_invite.serializeToStream(stream2);
                        stream2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        stream2.writeInt32(size);
                        for (int i7 = 0; i7 < size; i7++) {
                            this.bot_info.get(i7).serializeToStream(stream2);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32((int) this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32(this.migrated_from_max_id);
                        }
                        if ((this.flags & 32) != 0) {
                            stream2.writeInt32(this.pinned_msg_id);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.stickerset.serializeToStream(stream2);
                        }
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            stream2.writeInt32(this.available_min_id);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            stream2.writeInt32(this.folder_id);
                        }
                        if ((this.flags & 16384) != 0) {
                            stream2.writeInt32((int) this.linked_chat_id);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.location.serializeToStream(stream2);
                        }
                        stream2.writeInt32(this.pts);
                    }
                };
                break;
            case 401891279:
                tLRPC$TL_channelFull = new TLRPC$TL_channelFull() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelFull_layer71
                    public static int constructor = 401891279;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.can_set_username = (int32 & 64) != 0;
                        this.can_set_stickers = (int32 & 128) != 0;
                        this.id = stream2.readInt32(exception2);
                        this.about = stream2.readString(exception2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.banned_count = stream2.readInt32(exception2);
                        }
                        this.read_inbox_max_id = stream2.readInt32(exception2);
                        this.read_outbox_max_id = stream2.readInt32(exception2);
                        this.unread_count = stream2.readInt32(exception2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        int int322 = stream2.readInt32(exception2);
                        if (int322 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = stream2.readInt32(exception2);
                        for (int i = 0; i < int323; i++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.pinned_msg_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.stickerset = TLRPC$StickerSet.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i;
                        int i2 = this.can_set_username ? i | 64 : i & (-65);
                        this.flags = i2;
                        int i3 = this.can_set_stickers ? i2 | 128 : i2 & (-129);
                        this.flags = i3;
                        stream2.writeInt32(i3);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.kicked_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.banned_count);
                        }
                        stream2.writeInt32(this.read_inbox_max_id);
                        stream2.writeInt32(this.read_outbox_max_id);
                        stream2.writeInt32(this.unread_count);
                        this.chat_photo.serializeToStream(stream2);
                        this.notify_settings.serializeToStream(stream2);
                        this.exported_invite.serializeToStream(stream2);
                        stream2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        stream2.writeInt32(size);
                        for (int i4 = 0; i4 < size; i4++) {
                            this.bot_info.get(i4).serializeToStream(stream2);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32((int) this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32(this.migrated_from_max_id);
                        }
                        if ((this.flags & 32) != 0) {
                            stream2.writeInt32(this.pinned_msg_id);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.stickerset.serializeToStream(stream2);
                        }
                    }
                };
                break;
            case 461151667:
                tLRPC$TL_channelFull = new TLRPC$TL_chatFull() { // from class: ir.eitaa.tgnet.TLRPC$TL_chatFull_layer121
                    public static int constructor = 461151667;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatFull, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.can_set_username = (int32 & 128) != 0;
                        this.has_scheduled = (int32 & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0;
                        this.id = stream2.readInt32(exception2);
                        this.about = stream2.readString(exception2);
                        this.participants = TLRPC$ChatParticipants.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 4) != 0) {
                            this.chat_photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        if ((this.flags & 8) != 0) {
                            int int322 = stream2.readInt32(exception2);
                            if (int322 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = stream2.readInt32(exception2);
                            for (int i = 0; i < int323; i++) {
                                TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$BotInfoTLdeserialize == null) {
                                    return;
                                }
                                this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            this.pinned_msg_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            this.folder_id = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatFull, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.can_set_username ? this.flags | 128 : this.flags & (-129);
                        this.flags = i;
                        int i2 = this.has_scheduled ? i | Factory.DEVICE_HAS_CRAPPY_OPENSLES : i & (-257);
                        this.flags = i2;
                        stream2.writeInt32(i2);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.about);
                        this.participants.serializeToStream(stream2);
                        if ((this.flags & 4) != 0) {
                            this.chat_photo.serializeToStream(stream2);
                        }
                        this.notify_settings.serializeToStream(stream2);
                        this.exported_invite.serializeToStream(stream2);
                        if ((this.flags & 8) != 0) {
                            stream2.writeInt32(481674261);
                            int size = this.bot_info.size();
                            stream2.writeInt32(size);
                            for (int i3 = 0; i3 < size; i3++) {
                                this.bot_info.get(i3).serializeToStream(stream2);
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            stream2.writeInt32(this.pinned_msg_id);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            stream2.writeInt32(this.folder_id);
                        }
                    }
                };
                break;
            case 478652186:
                tLRPC$TL_channelFull = new TLRPC$TL_channelFull() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelFull_layer98
                    public static int constructor = 478652186;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.can_set_username = (int32 & 64) != 0;
                        this.can_set_stickers = (int32 & 128) != 0;
                        this.hidden_prehistory = (int32 & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0;
                        this.can_view_stats = (int32 & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0;
                        this.id = stream2.readInt32(exception2);
                        this.about = stream2.readString(exception2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.banned_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8192) != 0) {
                            this.online_count = stream2.readInt32(exception2);
                        }
                        this.read_inbox_max_id = stream2.readInt32(exception2);
                        this.read_outbox_max_id = stream2.readInt32(exception2);
                        this.unread_count = stream2.readInt32(exception2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        int int322 = stream2.readInt32(exception2);
                        if (int322 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = stream2.readInt32(exception2);
                        for (int i = 0; i < int323; i++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.pinned_msg_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.stickerset = TLRPC$StickerSet.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            this.available_min_id = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i;
                        int i2 = this.can_set_username ? i | 64 : i & (-65);
                        this.flags = i2;
                        int i3 = this.can_set_stickers ? i2 | 128 : i2 & (-129);
                        this.flags = i3;
                        int i4 = this.hidden_prehistory ? i3 | Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV : i3 & (-1025);
                        this.flags = i4;
                        int i5 = this.can_view_stats ? i4 | Factory.DEVICE_HAS_CRAPPY_AAUDIO : i4 & (-4097);
                        this.flags = i5;
                        stream2.writeInt32(i5);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.kicked_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.banned_count);
                        }
                        if ((this.flags & 8192) != 0) {
                            stream2.writeInt32(this.online_count);
                        }
                        stream2.writeInt32(this.read_inbox_max_id);
                        stream2.writeInt32(this.read_outbox_max_id);
                        stream2.writeInt32(this.unread_count);
                        this.chat_photo.serializeToStream(stream2);
                        this.notify_settings.serializeToStream(stream2);
                        this.exported_invite.serializeToStream(stream2);
                        stream2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        stream2.writeInt32(size);
                        for (int i6 = 0; i6 < size; i6++) {
                            this.bot_info.get(i6).serializeToStream(stream2);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32((int) this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32(this.migrated_from_max_id);
                        }
                        if ((this.flags & 32) != 0) {
                            stream2.writeInt32(this.pinned_msg_id);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.stickerset.serializeToStream(stream2);
                        }
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            stream2.writeInt32(this.available_min_id);
                        }
                    }
                };
                break;
            case 581055962:
                tLRPC$TL_channelFull = new TLRPC$TL_chatFull() { // from class: ir.eitaa.tgnet.TLRPC$TL_chatFull_layer98
                    public static int constructor = 581055962;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatFull, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.can_set_username = (int32 & 128) != 0;
                        this.id = stream2.readInt32(exception2);
                        this.about = stream2.readString(exception2);
                        this.participants = TLRPC$ChatParticipants.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 4) != 0) {
                            this.chat_photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        if ((this.flags & 8) != 0) {
                            int int322 = stream2.readInt32(exception2);
                            if (int322 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = stream2.readInt32(exception2);
                            for (int i = 0; i < int323; i++) {
                                TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$BotInfoTLdeserialize == null) {
                                    return;
                                }
                                this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            this.pinned_msg_id = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatFull, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.can_set_username ? this.flags | 128 : this.flags & (-129);
                        this.flags = i;
                        stream2.writeInt32(i);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.about);
                        this.participants.serializeToStream(stream2);
                        if ((this.flags & 4) != 0) {
                            this.chat_photo.serializeToStream(stream2);
                        }
                        this.notify_settings.serializeToStream(stream2);
                        this.exported_invite.serializeToStream(stream2);
                        if ((this.flags & 8) != 0) {
                            stream2.writeInt32(481674261);
                            int size = this.bot_info.size();
                            stream2.writeInt32(size);
                            for (int i2 = 0; i2 < size; i2++) {
                                this.bot_info.get(i2).serializeToStream(stream2);
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            stream2.writeInt32(this.pinned_msg_id);
                        }
                    }
                };
                break;
            case 625524791:
                tLRPC$TL_channelFull = new TLRPC$TL_channelFull() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelFull_layer124
                    public static int constructor = 625524791;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.can_set_username = (int32 & 64) != 0;
                        this.can_set_stickers = (int32 & 128) != 0;
                        this.hidden_prehistory = (int32 & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0;
                        this.can_set_location = (65536 & int32) != 0;
                        this.has_scheduled = (524288 & int32) != 0;
                        this.can_view_stats = (1048576 & int32) != 0;
                        this.blocked = (int32 & 4194304) != 0;
                        this.id = stream2.readInt32(exception2);
                        this.about = stream2.readString(exception2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.banned_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8192) != 0) {
                            this.online_count = stream2.readInt32(exception2);
                        }
                        this.read_inbox_max_id = stream2.readInt32(exception2);
                        this.read_outbox_max_id = stream2.readInt32(exception2);
                        this.unread_count = stream2.readInt32(exception2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 8388608) != 0) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) TLRPC$ExportedChatInvite.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        int int322 = stream2.readInt32(exception2);
                        if (int322 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = stream2.readInt32(exception2);
                        for (int i = 0; i < int323; i++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.pinned_msg_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.stickerset = TLRPC$StickerSet.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            this.available_min_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            this.folder_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 16384) != 0) {
                            this.linked_chat_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.location = TLRPC$ChannelLocation.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 131072) != 0) {
                            this.slowmode_seconds = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 262144) != 0) {
                            this.slowmode_next_send_date = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0) {
                            this.stats_dc = stream2.readInt32(exception2);
                        }
                        this.pts = stream2.readInt32(exception2);
                        if ((this.flags & 2097152) != 0) {
                            this.call = TLRPC$TL_inputGroupCall.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & ConnectionsManager.FileTypePhoto) != 0) {
                            this.ttl_period = stream2.readInt32(exception2);
                        }
                        if ((this.flags & ConnectionsManager.FileTypeVideo) != 0) {
                            int int324 = stream2.readInt32(exception2);
                            if (int324 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
                                }
                            } else {
                                int int325 = stream2.readInt32(exception2);
                                for (int i2 = 0; i2 < int325; i2++) {
                                    this.pending_suggestions.add(stream2.readString(exception2));
                                }
                            }
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i;
                        int i2 = this.can_set_username ? i | 64 : i & (-65);
                        this.flags = i2;
                        int i3 = this.can_set_stickers ? i2 | 128 : i2 & (-129);
                        this.flags = i3;
                        int i4 = this.hidden_prehistory ? i3 | Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV : i3 & (-1025);
                        this.flags = i4;
                        int i5 = this.can_set_location ? i4 | 65536 : i4 & (-65537);
                        this.flags = i5;
                        int i6 = this.has_scheduled ? i5 | 524288 : i5 & (-524289);
                        this.flags = i6;
                        int i7 = this.can_view_stats ? i6 | 1048576 : i6 & (-1048577);
                        this.flags = i7;
                        int i8 = this.blocked ? i7 | 4194304 : i7 & (-4194305);
                        this.flags = i8;
                        stream2.writeInt32(i8);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.kicked_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.banned_count);
                        }
                        if ((this.flags & 8192) != 0) {
                            stream2.writeInt32(this.online_count);
                        }
                        stream2.writeInt32(this.read_inbox_max_id);
                        stream2.writeInt32(this.read_outbox_max_id);
                        stream2.writeInt32(this.unread_count);
                        this.chat_photo.serializeToStream(stream2);
                        this.notify_settings.serializeToStream(stream2);
                        if ((this.flags & 8388608) != 0) {
                            this.exported_invite.serializeToStream(stream2);
                        }
                        stream2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        stream2.writeInt32(size);
                        for (int i9 = 0; i9 < size; i9++) {
                            this.bot_info.get(i9).serializeToStream(stream2);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32((int) this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32(this.migrated_from_max_id);
                        }
                        if ((this.flags & 32) != 0) {
                            stream2.writeInt32(this.pinned_msg_id);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.stickerset.serializeToStream(stream2);
                        }
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            stream2.writeInt32(this.available_min_id);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            stream2.writeInt32(this.folder_id);
                        }
                        if ((this.flags & 16384) != 0) {
                            stream2.writeInt32((int) this.linked_chat_id);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.location.serializeToStream(stream2);
                        }
                        if ((this.flags & 131072) != 0) {
                            stream2.writeInt32(this.slowmode_seconds);
                        }
                        if ((this.flags & 262144) != 0) {
                            stream2.writeInt32(this.slowmode_next_send_date);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0) {
                            stream2.writeInt32(this.stats_dc);
                        }
                        stream2.writeInt32(this.pts);
                        if ((this.flags & 2097152) != 0) {
                            this.call.serializeToStream(stream2);
                        }
                        if ((this.flags & ConnectionsManager.FileTypePhoto) != 0) {
                            stream2.writeInt32(this.ttl_period);
                        }
                        if ((this.flags & ConnectionsManager.FileTypeVideo) != 0) {
                            stream2.writeInt32(481674261);
                            int size2 = this.pending_suggestions.size();
                            stream2.writeInt32(size2);
                            for (int i10 = 0; i10 < size2; i10++) {
                                stream2.writeString(this.pending_suggestions.get(i10));
                            }
                        }
                    }
                };
                break;
            case 763976820:
                tLRPC$TL_channelFull = new TLRPC$ChatFull() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelFull_layer110
                    public static int constructor = 763976820;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.can_set_username = (int32 & 64) != 0;
                        this.can_set_stickers = (int32 & 128) != 0;
                        this.hidden_prehistory = (int32 & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0;
                        this.can_view_stats = (int32 & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0;
                        this.can_set_location = (65536 & int32) != 0;
                        this.has_scheduled = (int32 & 524288) != 0;
                        this.id = stream2.readInt32(exception2);
                        this.about = stream2.readString(exception2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.banned_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8192) != 0) {
                            this.online_count = stream2.readInt32(exception2);
                        }
                        this.read_inbox_max_id = stream2.readInt32(exception2);
                        this.read_outbox_max_id = stream2.readInt32(exception2);
                        this.unread_count = stream2.readInt32(exception2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        int int322 = stream2.readInt32(exception2);
                        if (int322 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = stream2.readInt32(exception2);
                        for (int i = 0; i < int323; i++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.pinned_msg_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.stickerset = TLRPC$StickerSet.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            this.available_min_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            this.folder_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 16384) != 0) {
                            this.linked_chat_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.location = TLRPC$ChannelLocation.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 131072) != 0) {
                            this.slowmode_seconds = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 262144) != 0) {
                            this.slowmode_next_send_date = stream2.readInt32(exception2);
                        }
                        this.pts = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i;
                        int i2 = this.can_set_username ? i | 64 : i & (-65);
                        this.flags = i2;
                        int i3 = this.can_set_stickers ? i2 | 128 : i2 & (-129);
                        this.flags = i3;
                        int i4 = this.hidden_prehistory ? i3 | Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV : i3 & (-1025);
                        this.flags = i4;
                        int i5 = this.can_view_stats ? i4 | Factory.DEVICE_HAS_CRAPPY_AAUDIO : i4 & (-4097);
                        this.flags = i5;
                        int i6 = this.can_set_location ? i5 | 65536 : i5 & (-65537);
                        this.flags = i6;
                        int i7 = this.has_scheduled ? i6 | 524288 : i6 & (-524289);
                        this.flags = i7;
                        stream2.writeInt32(i7);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.kicked_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.banned_count);
                        }
                        if ((this.flags & 8192) != 0) {
                            stream2.writeInt32(this.online_count);
                        }
                        stream2.writeInt32(this.read_inbox_max_id);
                        stream2.writeInt32(this.read_outbox_max_id);
                        stream2.writeInt32(this.unread_count);
                        this.chat_photo.serializeToStream(stream2);
                        this.notify_settings.serializeToStream(stream2);
                        this.exported_invite.serializeToStream(stream2);
                        stream2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        stream2.writeInt32(size);
                        for (int i8 = 0; i8 < size; i8++) {
                            this.bot_info.get(i8).serializeToStream(stream2);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32((int) this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32(this.migrated_from_max_id);
                        }
                        if ((this.flags & 32) != 0) {
                            stream2.writeInt32(this.pinned_msg_id);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.stickerset.serializeToStream(stream2);
                        }
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            stream2.writeInt32(this.available_min_id);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            stream2.writeInt32(this.folder_id);
                        }
                        if ((this.flags & 16384) != 0) {
                            stream2.writeInt32((int) this.linked_chat_id);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.location.serializeToStream(stream2);
                        }
                        if ((this.flags & 131072) != 0) {
                            stream2.writeInt32(this.slowmode_seconds);
                        }
                        if ((this.flags & 262144) != 0) {
                            stream2.writeInt32(this.slowmode_next_send_date);
                        }
                        stream2.writeInt32(this.pts);
                    }
                };
                break;
            case 771925524:
                tLRPC$TL_channelFull = new TLRPC$TL_chatFull() { // from class: ir.eitaa.tgnet.TLRPC$TL_chatFull_layer87
                    public static int constructor = 771925524;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatFull, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt32(exception2);
                        this.participants = TLRPC$ChatParticipants.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        int int32 = stream2.readInt32(exception2);
                        if (int32 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = stream2.readInt32(exception2);
                        for (int i = 0; i < int322; i++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatFull, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.id);
                        this.participants.serializeToStream(stream2);
                        this.chat_photo.serializeToStream(stream2);
                        this.notify_settings.serializeToStream(stream2);
                        this.exported_invite.serializeToStream(stream2);
                        stream2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        stream2.writeInt32(size);
                        for (int i = 0; i < size; i++) {
                            this.bot_info.get(i).serializeToStream(stream2);
                        }
                    }
                };
                break;
            case 793980732:
                tLRPC$TL_channelFull = new TLRPC$TL_channelFull() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelFull_layer132
                    public static int constructor = 793980732;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.can_set_username = (int32 & 64) != 0;
                        this.can_set_stickers = (int32 & 128) != 0;
                        this.hidden_prehistory = (int32 & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0;
                        this.can_set_location = (65536 & int32) != 0;
                        this.has_scheduled = (524288 & int32) != 0;
                        this.can_view_stats = (1048576 & int32) != 0;
                        this.blocked = (int32 & 4194304) != 0;
                        this.id = stream2.readInt32(exception2);
                        this.about = stream2.readString(exception2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.banned_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8192) != 0) {
                            this.online_count = stream2.readInt32(exception2);
                        }
                        this.read_inbox_max_id = stream2.readInt32(exception2);
                        this.read_outbox_max_id = stream2.readInt32(exception2);
                        this.unread_count = stream2.readInt32(exception2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 8388608) != 0) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) TLRPC$ExportedChatInvite.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        int int322 = stream2.readInt32(exception2);
                        if (int322 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = stream2.readInt32(exception2);
                        for (int i = 0; i < int323; i++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.pinned_msg_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.stickerset = TLRPC$StickerSet.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            this.available_min_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            this.folder_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 16384) != 0) {
                            this.linked_chat_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.location = TLRPC$ChannelLocation.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 131072) != 0) {
                            this.slowmode_seconds = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 262144) != 0) {
                            this.slowmode_next_send_date = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0) {
                            this.stats_dc = stream2.readInt32(exception2);
                        }
                        this.pts = stream2.readInt32(exception2);
                        if ((this.flags & 2097152) != 0) {
                            this.call = TLRPC$TL_inputGroupCall.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & ConnectionsManager.FileTypePhoto) != 0) {
                            this.ttl_period = stream2.readInt32(exception2);
                        }
                        if ((this.flags & ConnectionsManager.FileTypeVideo) != 0) {
                            int int324 = stream2.readInt32(exception2);
                            if (int324 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
                                }
                                return;
                            } else {
                                int int325 = stream2.readInt32(exception2);
                                for (int i2 = 0; i2 < int325; i2++) {
                                    this.pending_suggestions.add(stream2.readString(exception2));
                                }
                            }
                        }
                        if ((this.flags & ConnectionsManager.FileTypeFile) != 0) {
                            this.groupcall_default_join_as = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 134217728) != 0) {
                            this.theme_emoticon = stream2.readString(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i;
                        int i2 = this.can_set_username ? i | 64 : i & (-65);
                        this.flags = i2;
                        int i3 = this.can_set_stickers ? i2 | 128 : i2 & (-129);
                        this.flags = i3;
                        int i4 = this.hidden_prehistory ? i3 | Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV : i3 & (-1025);
                        this.flags = i4;
                        int i5 = this.can_set_location ? i4 | 65536 : i4 & (-65537);
                        this.flags = i5;
                        int i6 = this.has_scheduled ? i5 | 524288 : i5 & (-524289);
                        this.flags = i6;
                        int i7 = this.can_view_stats ? i6 | 1048576 : i6 & (-1048577);
                        this.flags = i7;
                        int i8 = this.blocked ? i7 | 4194304 : i7 & (-4194305);
                        this.flags = i8;
                        stream2.writeInt32(i8);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.kicked_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.banned_count);
                        }
                        if ((this.flags & 8192) != 0) {
                            stream2.writeInt32(this.online_count);
                        }
                        stream2.writeInt32(this.read_inbox_max_id);
                        stream2.writeInt32(this.read_outbox_max_id);
                        stream2.writeInt32(this.unread_count);
                        this.chat_photo.serializeToStream(stream2);
                        this.notify_settings.serializeToStream(stream2);
                        if ((this.flags & 8388608) != 0) {
                            this.exported_invite.serializeToStream(stream2);
                        }
                        stream2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        stream2.writeInt32(size);
                        for (int i9 = 0; i9 < size; i9++) {
                            this.bot_info.get(i9).serializeToStream(stream2);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32((int) this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32(this.migrated_from_max_id);
                        }
                        if ((this.flags & 32) != 0) {
                            stream2.writeInt32(this.pinned_msg_id);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.stickerset.serializeToStream(stream2);
                        }
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            stream2.writeInt32(this.available_min_id);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            stream2.writeInt32(this.folder_id);
                        }
                        if ((this.flags & 16384) != 0) {
                            stream2.writeInt32((int) this.linked_chat_id);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.location.serializeToStream(stream2);
                        }
                        if ((this.flags & 131072) != 0) {
                            stream2.writeInt32(this.slowmode_seconds);
                        }
                        if ((this.flags & 262144) != 0) {
                            stream2.writeInt32(this.slowmode_next_send_date);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0) {
                            stream2.writeInt32(this.stats_dc);
                        }
                        stream2.writeInt32(this.pts);
                        if ((this.flags & 2097152) != 0) {
                            this.call.serializeToStream(stream2);
                        }
                        if ((this.flags & ConnectionsManager.FileTypePhoto) != 0) {
                            stream2.writeInt32(this.ttl_period);
                        }
                        if ((this.flags & ConnectionsManager.FileTypeVideo) != 0) {
                            stream2.writeInt32(481674261);
                            int size2 = this.pending_suggestions.size();
                            stream2.writeInt32(size2);
                            for (int i10 = 0; i10 < size2; i10++) {
                                stream2.writeString(this.pending_suggestions.get(i10));
                            }
                        }
                        if ((this.flags & ConnectionsManager.FileTypeFile) != 0) {
                            this.groupcall_default_join_as.serializeToStream(stream2);
                        }
                        if ((this.flags & 134217728) != 0) {
                            stream2.writeString(this.theme_emoticon);
                        }
                    }
                };
                break;
            case 1235264985:
                tLRPC$TL_channelFull = new TLRPC$TL_chatFull() { // from class: ir.eitaa.tgnet.TLRPC$TL_chatFull_layer132
                    public static int constructor = 1235264985;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatFull, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.can_set_username = (int32 & 128) != 0;
                        this.has_scheduled = (int32 & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0;
                        this.id = stream2.readInt32(exception2);
                        this.about = stream2.readString(exception2);
                        this.participants = TLRPC$ChatParticipants.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 4) != 0) {
                            this.chat_photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 8192) != 0) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) TLRPC$ExportedChatInvite.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            int int322 = stream2.readInt32(exception2);
                            if (int322 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = stream2.readInt32(exception2);
                            for (int i = 0; i < int323; i++) {
                                TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$BotInfoTLdeserialize == null) {
                                    return;
                                }
                                this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            this.pinned_msg_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            this.folder_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0) {
                            this.call = TLRPC$TL_inputGroupCall.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 16384) != 0) {
                            this.ttl_period = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.groupcall_default_join_as = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 65536) != 0) {
                            this.theme_emoticon = stream2.readString(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatFull, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.can_set_username ? this.flags | 128 : this.flags & (-129);
                        this.flags = i;
                        int i2 = this.has_scheduled ? i | Factory.DEVICE_HAS_CRAPPY_OPENSLES : i & (-257);
                        this.flags = i2;
                        stream2.writeInt32(i2);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.about);
                        this.participants.serializeToStream(stream2);
                        if ((this.flags & 4) != 0) {
                            this.chat_photo.serializeToStream(stream2);
                        }
                        this.notify_settings.serializeToStream(stream2);
                        if ((this.flags & 8192) != 0) {
                            this.exported_invite.serializeToStream(stream2);
                        }
                        if ((this.flags & 8) != 0) {
                            stream2.writeInt32(481674261);
                            int size = this.bot_info.size();
                            stream2.writeInt32(size);
                            for (int i3 = 0; i3 < size; i3++) {
                                this.bot_info.get(i3).serializeToStream(stream2);
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            stream2.writeInt32(this.pinned_msg_id);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            stream2.writeInt32(this.folder_id);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0) {
                            this.call.serializeToStream(stream2);
                        }
                        if ((this.flags & 16384) != 0) {
                            stream2.writeInt32(this.ttl_period);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.groupcall_default_join_as.serializeToStream(stream2);
                        }
                        if ((this.flags & 65536) != 0) {
                            stream2.writeString(this.theme_emoticon);
                        }
                    }
                };
                break;
            case 1304281241:
                tLRPC$TL_channelFull = new TLRPC$TL_chatFull();
                break;
            case 1418477459:
                tLRPC$TL_channelFull = new TLRPC$TL_channelFull() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelFull_layer131
                    public static int constructor = 1418477459;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.can_set_username = (int32 & 64) != 0;
                        this.can_set_stickers = (int32 & 128) != 0;
                        this.hidden_prehistory = (int32 & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0;
                        this.can_set_location = (65536 & int32) != 0;
                        this.has_scheduled = (524288 & int32) != 0;
                        this.can_view_stats = (1048576 & int32) != 0;
                        this.blocked = (int32 & 4194304) != 0;
                        this.id = stream2.readInt64(exception2);
                        this.about = stream2.readString(exception2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.banned_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8192) != 0) {
                            this.online_count = stream2.readInt32(exception2);
                        }
                        this.read_inbox_max_id = stream2.readInt32(exception2);
                        this.read_outbox_max_id = stream2.readInt32(exception2);
                        this.unread_count = stream2.readInt32(exception2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 8388608) != 0) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) TLRPC$ExportedChatInvite.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        int int322 = stream2.readInt32(exception2);
                        if (int322 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = stream2.readInt32(exception2);
                        for (int i = 0; i < int323; i++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = stream2.readInt64(exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.pinned_msg_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.stickerset = TLRPC$StickerSet.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            this.available_min_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            this.folder_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 16384) != 0) {
                            this.linked_chat_id = stream2.readInt64(exception2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.location = TLRPC$ChannelLocation.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 131072) != 0) {
                            this.slowmode_seconds = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 262144) != 0) {
                            this.slowmode_next_send_date = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0) {
                            this.stats_dc = stream2.readInt32(exception2);
                        }
                        this.pts = stream2.readInt32(exception2);
                        if ((this.flags & 2097152) != 0) {
                            this.call = TLRPC$TL_inputGroupCall.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & ConnectionsManager.FileTypePhoto) != 0) {
                            this.ttl_period = stream2.readInt32(exception2);
                        }
                        if ((this.flags & ConnectionsManager.FileTypeVideo) != 0) {
                            int int324 = stream2.readInt32(exception2);
                            if (int324 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
                                }
                                return;
                            } else {
                                int int325 = stream2.readInt32(exception2);
                                for (int i2 = 0; i2 < int325; i2++) {
                                    this.pending_suggestions.add(stream2.readString(exception2));
                                }
                            }
                        }
                        if ((this.flags & ConnectionsManager.FileTypeFile) != 0) {
                            this.groupcall_default_join_as = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i;
                        int i2 = this.can_set_username ? i | 64 : i & (-65);
                        this.flags = i2;
                        int i3 = this.can_set_stickers ? i2 | 128 : i2 & (-129);
                        this.flags = i3;
                        int i4 = this.hidden_prehistory ? i3 | Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV : i3 & (-1025);
                        this.flags = i4;
                        int i5 = this.can_set_location ? i4 | 65536 : i4 & (-65537);
                        this.flags = i5;
                        int i6 = this.has_scheduled ? i5 | 524288 : i5 & (-524289);
                        this.flags = i6;
                        int i7 = this.can_view_stats ? i6 | 1048576 : i6 & (-1048577);
                        this.flags = i7;
                        int i8 = this.blocked ? i7 | 4194304 : i7 & (-4194305);
                        this.flags = i8;
                        stream2.writeInt32(i8);
                        stream2.writeInt64(this.id);
                        stream2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.kicked_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.banned_count);
                        }
                        if ((this.flags & 8192) != 0) {
                            stream2.writeInt32(this.online_count);
                        }
                        stream2.writeInt32(this.read_inbox_max_id);
                        stream2.writeInt32(this.read_outbox_max_id);
                        stream2.writeInt32(this.unread_count);
                        this.chat_photo.serializeToStream(stream2);
                        this.notify_settings.serializeToStream(stream2);
                        if ((this.flags & 8388608) != 0) {
                            this.exported_invite.serializeToStream(stream2);
                        }
                        stream2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        stream2.writeInt32(size);
                        for (int i9 = 0; i9 < size; i9++) {
                            this.bot_info.get(i9).serializeToStream(stream2);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt64(this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32(this.migrated_from_max_id);
                        }
                        if ((this.flags & 32) != 0) {
                            stream2.writeInt32(this.pinned_msg_id);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.stickerset.serializeToStream(stream2);
                        }
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            stream2.writeInt32(this.available_min_id);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            stream2.writeInt32(this.folder_id);
                        }
                        if ((this.flags & 16384) != 0) {
                            stream2.writeInt64(this.linked_chat_id);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.location.serializeToStream(stream2);
                        }
                        if ((this.flags & 131072) != 0) {
                            stream2.writeInt32(this.slowmode_seconds);
                        }
                        if ((this.flags & 262144) != 0) {
                            stream2.writeInt32(this.slowmode_next_send_date);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0) {
                            stream2.writeInt32(this.stats_dc);
                        }
                        stream2.writeInt32(this.pts);
                        if ((this.flags & 2097152) != 0) {
                            this.call.serializeToStream(stream2);
                        }
                        if ((this.flags & ConnectionsManager.FileTypePhoto) != 0) {
                            stream2.writeInt32(this.ttl_period);
                        }
                        if ((this.flags & ConnectionsManager.FileTypeVideo) != 0) {
                            stream2.writeInt32(481674261);
                            int size2 = this.pending_suggestions.size();
                            stream2.writeInt32(size2);
                            for (int i10 = 0; i10 < size2; i10++) {
                                stream2.writeString(this.pending_suggestions.get(i10));
                            }
                        }
                        if ((this.flags & ConnectionsManager.FileTypeFile) != 0) {
                            this.groupcall_default_join_as.serializeToStream(stream2);
                        }
                    }
                };
                break;
            case 1991201921:
                tLRPC$TL_channelFull = new TLRPC$TL_channelFull() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelFull_layer72
                    public static int constructor = 1991201921;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.can_set_username = (int32 & 64) != 0;
                        this.can_set_stickers = (int32 & 128) != 0;
                        this.hidden_prehistory = (int32 & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0;
                        this.id = stream2.readInt32(exception2);
                        this.about = stream2.readString(exception2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.banned_count = stream2.readInt32(exception2);
                        }
                        this.read_inbox_max_id = stream2.readInt32(exception2);
                        this.read_outbox_max_id = stream2.readInt32(exception2);
                        this.unread_count = stream2.readInt32(exception2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$ExportedChatInviteTLdeserialize instanceof TLRPC$TL_chatInviteExported) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInviteTLdeserialize;
                        }
                        int int322 = stream2.readInt32(exception2);
                        if (int322 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = stream2.readInt32(exception2);
                        for (int i = 0; i < int323; i++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.pinned_msg_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.stickerset = TLRPC$StickerSet.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            this.available_min_id = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i;
                        int i2 = this.can_set_username ? i | 64 : i & (-65);
                        this.flags = i2;
                        int i3 = this.can_set_stickers ? i2 | 128 : i2 & (-129);
                        this.flags = i3;
                        int i4 = this.hidden_prehistory ? i3 | Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV : i3 & (-1025);
                        this.flags = i4;
                        stream2.writeInt32(i4);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.kicked_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.banned_count);
                        }
                        stream2.writeInt32(this.read_inbox_max_id);
                        stream2.writeInt32(this.read_outbox_max_id);
                        stream2.writeInt32(this.unread_count);
                        this.chat_photo.serializeToStream(stream2);
                        this.notify_settings.serializeToStream(stream2);
                        this.exported_invite.serializeToStream(stream2);
                        stream2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        stream2.writeInt32(size);
                        for (int i5 = 0; i5 < size; i5++) {
                            this.bot_info.get(i5).serializeToStream(stream2);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32((int) this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32(this.migrated_from_max_id);
                        }
                        if ((this.flags & 32) != 0) {
                            stream2.writeInt32(this.pinned_msg_id);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.stickerset.serializeToStream(stream2);
                        }
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            stream2.writeInt32(this.available_min_id);
                        }
                    }
                };
                break;
            case 2055070967:
                tLRPC$TL_channelFull = new TLRPC$TL_channelFull() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelFull_layer123
                    public static int constructor = 2055070967;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.can_view_participants = (int32 & 8) != 0;
                        this.can_set_username = (int32 & 64) != 0;
                        this.can_set_stickers = (int32 & 128) != 0;
                        this.hidden_prehistory = (int32 & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0;
                        this.can_set_location = (65536 & int32) != 0;
                        this.has_scheduled = (524288 & int32) != 0;
                        this.can_view_stats = (1048576 & int32) != 0;
                        this.blocked = (int32 & 4194304) != 0;
                        this.id = stream2.readInt32(exception2);
                        this.about = stream2.readString(exception2);
                        if ((this.flags & 1) != 0) {
                            this.participants_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.admins_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.kicked_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.banned_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8192) != 0) {
                            this.online_count = stream2.readInt32(exception2);
                        }
                        this.read_inbox_max_id = stream2.readInt32(exception2);
                        this.read_outbox_max_id = stream2.readInt32(exception2);
                        this.unread_count = stream2.readInt32(exception2);
                        this.chat_photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 8388608) != 0) {
                            this.exported_invite = (TLRPC$TL_chatInviteExported) TLRPC$ExportedChatInvite.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        int int322 = stream2.readInt32(exception2);
                        if (int322 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = stream2.readInt32(exception2);
                        for (int i = 0; i < int323; i++) {
                            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$BotInfoTLdeserialize == null) {
                                return;
                            }
                            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_chat_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.migrated_from_max_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.pinned_msg_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.stickerset = TLRPC$StickerSet.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            this.available_min_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            this.folder_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 16384) != 0) {
                            this.linked_chat_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.location = TLRPC$ChannelLocation.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 131072) != 0) {
                            this.slowmode_seconds = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 262144) != 0) {
                            this.slowmode_next_send_date = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0) {
                            this.stats_dc = stream2.readInt32(exception2);
                        }
                        this.pts = stream2.readInt32(exception2);
                        if ((this.flags & 2097152) != 0) {
                            this.call = TLRPC$TL_inputGroupCall.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelFull, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
                        this.flags = i;
                        int i2 = this.can_set_username ? i | 64 : i & (-65);
                        this.flags = i2;
                        int i3 = this.can_set_stickers ? i2 | 128 : i2 & (-129);
                        this.flags = i3;
                        int i4 = this.hidden_prehistory ? i3 | Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV : i3 & (-1025);
                        this.flags = i4;
                        int i5 = this.can_set_location ? i4 | 65536 : i4 & (-65537);
                        this.flags = i5;
                        int i6 = this.has_scheduled ? i5 | 524288 : i5 & (-524289);
                        this.flags = i6;
                        int i7 = this.can_view_stats ? i6 | 1048576 : i6 & (-1048577);
                        this.flags = i7;
                        int i8 = this.blocked ? i7 | 4194304 : i7 & (-4194305);
                        this.flags = i8;
                        stream2.writeInt32(i8);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.about);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32(this.admins_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.kicked_count);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.banned_count);
                        }
                        if ((this.flags & 8192) != 0) {
                            stream2.writeInt32(this.online_count);
                        }
                        stream2.writeInt32(this.read_inbox_max_id);
                        stream2.writeInt32(this.read_outbox_max_id);
                        stream2.writeInt32(this.unread_count);
                        this.chat_photo.serializeToStream(stream2);
                        this.notify_settings.serializeToStream(stream2);
                        if ((this.flags & 8388608) != 0) {
                            this.exported_invite.serializeToStream(stream2);
                        }
                        stream2.writeInt32(481674261);
                        int size = this.bot_info.size();
                        stream2.writeInt32(size);
                        for (int i9 = 0; i9 < size; i9++) {
                            this.bot_info.get(i9).serializeToStream(stream2);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32((int) this.migrated_from_chat_id);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32(this.migrated_from_max_id);
                        }
                        if ((this.flags & 32) != 0) {
                            stream2.writeInt32(this.pinned_msg_id);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.stickerset.serializeToStream(stream2);
                        }
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            stream2.writeInt32(this.available_min_id);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            stream2.writeInt32(this.folder_id);
                        }
                        if ((this.flags & 16384) != 0) {
                            stream2.writeInt32((int) this.linked_chat_id);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.location.serializeToStream(stream2);
                        }
                        if ((this.flags & 131072) != 0) {
                            stream2.writeInt32(this.slowmode_seconds);
                        }
                        if ((this.flags & 262144) != 0) {
                            stream2.writeInt32(this.slowmode_next_send_date);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0) {
                            stream2.writeInt32(this.stats_dc);
                        }
                        stream2.writeInt32(this.pts);
                        if ((this.flags & 2097152) != 0) {
                            this.call.serializeToStream(stream2);
                        }
                    }
                };
                break;
            default:
                tLRPC$TL_channelFull = null;
                break;
        }
        if (tLRPC$TL_channelFull == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in ChatFull", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_channelFull != null) {
            tLRPC$TL_channelFull.readParams(stream, exception);
        }
        return tLRPC$TL_channelFull;
    }
}
