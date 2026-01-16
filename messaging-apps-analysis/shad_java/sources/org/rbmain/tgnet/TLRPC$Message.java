package org.rbmain.tgnet;

import android.text.TextUtils;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.model.ChatMessage;
import ir.aaap.messengercore.model.ChatType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.rbmain.messenger.LiteMode;
import org.rbmain.messenger.MessagesController;

/* loaded from: classes4.dex */
public abstract class TLRPC$Message extends TLObject {
    public TLRPC$MessageAction action;
    public String author_title;
    public String botStartId;
    public String bot_button_text;
    public int button_id;
    public ChatMessage.ChatMessageTypeEnum chatMessageType;
    public ChatType chatType;
    public int date;
    public int destroyTime;
    public long dialog_id;
    public int edit_date;
    public boolean edit_hide;
    public String fileName;
    public int flags;
    public int forwards;
    public TLRPC$Peer from_id;
    public boolean from_scheduled;
    public String fwdFromGuid;
    public ChatType fwdFromType;
    public TLRPC$MessageFwdHeader fwd_from;
    public long grouped_id;
    public long id;
    public boolean isThreadMessage;
    public boolean is_ban;
    public long lastTimeLocationUpdated;
    public int layer;
    public boolean legacy;
    public TLRPC$MessageMedia media;
    public boolean media_unread;
    public boolean mentioned;
    public String message;
    public boolean noforwards;
    public String notificationId;
    public long notificationImageId;
    public boolean out;
    public HashMap<String, String> params;
    public TLRPC$Peer peer_id;
    public boolean pinned;
    public boolean post;
    public String post_author;
    public boolean premiumEffectWasPlayed;
    public long prevMessageId;
    public long random_id;
    public TLRPC$TL_messageReactions reactions;
    public long realId;
    public TLRPC$MessageReplies replies;
    public TLRPC$Message replyMessage;
    public TLRPC$ReplyMarkup reply_markup;
    public TLRPC$TL_messageReplyHeader reply_to;
    public int reqId;
    public int seq_in;
    public int seq_out;
    public boolean silent;
    public TLRPC$TL_textWithEntities translatedText;
    public int ttl;
    public int ttl_period;
    public boolean unread;
    public int via_bot_id;
    public String via_bot_name;
    public int views;
    public String voiceTranscription;
    public boolean voiceTranscriptionFinal;
    public long voiceTranscriptionId;
    public boolean voiceTranscriptionOpen;
    public boolean voiceTranscriptionRated;
    public boolean with_my_score;
    public ArrayList<TLRPC$MessageEntity> entities = new ArrayList<>();
    public ArrayList<TLRPC$TL_restrictionReason> restriction_reason = new ArrayList<>();
    public int send_state = 0;
    public long fwd_msg_id = 0;
    public String attachPath = BuildConfig.FLAVOR;
    public long local_id = 0;
    public int stickerVerified = 1;

    public static TLRPC$Message TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$Message tLRPC$TL_messageEmpty;
        switch (i) {
            case -2082087340:
                tLRPC$TL_messageEmpty = new TLRPC$TL_messageEmpty() { // from class: org.rbmain.tgnet.TLRPC$TL_messageEmpty_layer122
                    public static int constructor = -2082087340;

                    @Override // org.rbmain.tgnet.TLRPC$TL_messageEmpty, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.id = abstractSerializedData2.readInt32(z2);
                        this.peer_id = new TLRPC$TL_peerUser();
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_messageEmpty, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32((int) this.id);
                    }
                };
                break;
            case -1868117372:
                tLRPC$TL_messageEmpty = new TLRPC$TL_messageEmpty();
                break;
            case -1864508399:
                tLRPC$TL_messageEmpty = new TLRPC$TL_message() { // from class: org.rbmain.tgnet.TLRPC$TL_message_layer72
                    public static int constructor = -1864508399;

                    @Override // org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.silent = (int32 & 8192) != 0;
                        this.post = (int32 & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        if ((this.flags & 256) != 0) {
                            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                            this.from_id = tLRPC$TL_peerUser;
                            tLRPC$TL_peerUser.user_id = abstractSerializedData2.readInt32(z2);
                        }
                        this.peer_id = TLRPC$Peer.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if ((this.flags & 4) != 0) {
                            this.fwd_from = TLRPC$MessageFwdHeader.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 2048) != 0) {
                            this.via_bot_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 8) != 0) {
                            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
                            this.reply_to = tLRPC$TL_messageReplyHeader;
                            tLRPC$TL_messageReplyHeader.reply_to_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.message = abstractSerializedData2.readString(z2);
                        if ((this.flags & 512) != 0) {
                            TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            this.media = tLRPC$MessageMediaTLdeserialize;
                            if (tLRPC$MessageMediaTLdeserialize != null) {
                                this.ttl = tLRPC$MessageMediaTLdeserialize.ttl_seconds;
                            }
                            if (tLRPC$MessageMediaTLdeserialize != null && !TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                                this.message = this.media.captionLegacy;
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 128) != 0) {
                            int int322 = abstractSerializedData2.readInt32(z2);
                            if (int322 != 481674261) {
                                if (z2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = abstractSerializedData2.readInt32(z2);
                            for (int i2 = 0; i2 < int323; i2++) {
                                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                                if (tLRPC$MessageEntityTLdeserialize == null) {
                                    return;
                                }
                                this.entities.add(tLRPC$MessageEntityTLdeserialize);
                            }
                        }
                        if ((this.flags & 1024) != 0) {
                            this.views = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.edit_date = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_CHECK) != 0) {
                            this.post_author = abstractSerializedData2.readString(z2);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.out ? this.flags | 2 : this.flags & (-3);
                        this.flags = i2;
                        int i3 = this.mentioned ? i2 | 16 : i2 & (-17);
                        this.flags = i3;
                        int i4 = this.media_unread ? i3 | 32 : i3 & (-33);
                        this.flags = i4;
                        int i5 = this.silent ? i4 | 8192 : i4 & (-8193);
                        this.flags = i5;
                        int i6 = this.post ? i5 | LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM : i5 & (-16385);
                        this.flags = i6;
                        abstractSerializedData2.writeInt32(i6);
                        abstractSerializedData2.writeInt32((int) this.id);
                        if ((this.flags & 256) != 0) {
                            abstractSerializedData2.writeInt32(this.from_id.user_id);
                        }
                        this.peer_id.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 4) != 0) {
                            this.fwd_from.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 2048) != 0) {
                            abstractSerializedData2.writeInt32(this.via_bot_id);
                        }
                        if ((this.flags & 8) != 0) {
                            abstractSerializedData2.writeInt32((int) this.reply_to.reply_to_msg_id);
                        }
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeString(this.message);
                        if ((this.flags & 512) != 0) {
                            this.media.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 128) != 0) {
                            abstractSerializedData2.writeInt32(481674261);
                            int size = this.entities.size();
                            abstractSerializedData2.writeInt32(size);
                            for (int i7 = 0; i7 < size; i7++) {
                                this.entities.get(i7).serializeToStream(abstractSerializedData2);
                            }
                        }
                        if ((this.flags & 1024) != 0) {
                            abstractSerializedData2.writeInt32(this.views);
                        }
                        if ((this.flags & 32768) != 0) {
                            abstractSerializedData2.writeInt32(this.edit_date);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_CHECK) != 0) {
                            abstractSerializedData2.writeString(this.post_author);
                        }
                        writeAttachPath(abstractSerializedData2);
                    }
                };
                break;
            case -1752573244:
                tLRPC$TL_messageEmpty = new TLRPC$TL_message() { // from class: org.rbmain.tgnet.TLRPC$TL_message_layer104_3
                    public static int constructor = -1752573244;

                    @Override // org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.silent = (int32 & 8192) != 0;
                        this.post = (int32 & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0;
                        this.from_scheduled = (262144 & int32) != 0;
                        this.legacy = (524288 & int32) != 0;
                        this.edit_hide = (int32 & 2097152) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        if ((this.flags & 256) != 0) {
                            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                            this.from_id = tLRPC$TL_peerUser;
                            tLRPC$TL_peerUser.user_id = abstractSerializedData2.readInt32(z2);
                        }
                        this.peer_id = TLRPC$Peer.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if ((this.flags & 4) != 0) {
                            this.fwd_from = TLRPC$MessageFwdHeader.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 2048) != 0) {
                            this.via_bot_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 8) != 0) {
                            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
                            this.reply_to = tLRPC$TL_messageReplyHeader;
                            tLRPC$TL_messageReplyHeader.reply_to_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.message = abstractSerializedData2.readString(z2);
                        if ((this.flags & 512) != 0) {
                            TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            this.media = tLRPC$MessageMediaTLdeserialize;
                            if (tLRPC$MessageMediaTLdeserialize != null) {
                                this.ttl = tLRPC$MessageMediaTLdeserialize.ttl_seconds;
                            }
                            if (tLRPC$MessageMediaTLdeserialize != null && !TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                                this.message = this.media.captionLegacy;
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 128) != 0) {
                            int int322 = abstractSerializedData2.readInt32(z2);
                            if (int322 != 481674261) {
                                if (z2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = abstractSerializedData2.readInt32(z2);
                            for (int i2 = 0; i2 < int323; i2++) {
                                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                                if (tLRPC$MessageEntityTLdeserialize == null) {
                                    return;
                                }
                                this.entities.add(tLRPC$MessageEntityTLdeserialize);
                            }
                        }
                        if ((this.flags & 1024) != 0) {
                            this.views = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.edit_date = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_CHECK) != 0) {
                            this.post_author = abstractSerializedData2.readString(z2);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_REORDER) != 0) {
                            this.grouped_id = abstractSerializedData2.readInt64(z2);
                        }
                        if ((this.flags & 1048576) != 0) {
                            this.reactions = TLRPC$MessageReactions.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 4194304) != 0) {
                            int int324 = abstractSerializedData2.readInt32(z2);
                            if (int324 != 481674261) {
                                if (z2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
                                }
                                return;
                            }
                            int int325 = abstractSerializedData2.readInt32(z2);
                            for (int i3 = 0; i3 < int325; i3++) {
                                TLRPC$TL_restrictionReason tLRPC$TL_restrictionReasonTLdeserialize = TLRPC$TL_restrictionReason.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                                if (tLRPC$TL_restrictionReasonTLdeserialize == null) {
                                    return;
                                }
                                this.restriction_reason.add(tLRPC$TL_restrictionReasonTLdeserialize);
                            }
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.out ? this.flags | 2 : this.flags & (-3);
                        this.flags = i2;
                        int i3 = this.mentioned ? i2 | 16 : i2 & (-17);
                        this.flags = i3;
                        int i4 = this.media_unread ? i3 | 32 : i3 & (-33);
                        this.flags = i4;
                        int i5 = this.silent ? i4 | 8192 : i4 & (-8193);
                        this.flags = i5;
                        int i6 = this.post ? i5 | LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM : i5 & (-16385);
                        this.flags = i6;
                        int i7 = this.from_scheduled ? i6 | MessagesController.UPDATE_MASK_CHAT_MUTE : i6 & (-262145);
                        this.flags = i7;
                        int i8 = this.legacy ? i7 | MessagesController.UPDATE_MASK_CHAT_SHOW_SPAM : i7 & (-524289);
                        this.flags = i8;
                        int i9 = this.edit_hide ? i8 | 2097152 : i8 & (-2097153);
                        this.flags = i9;
                        abstractSerializedData2.writeInt32(i9);
                        abstractSerializedData2.writeInt32((int) this.id);
                        if ((this.flags & 256) != 0) {
                            abstractSerializedData2.writeInt32(this.from_id.user_id);
                        }
                        this.peer_id.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 4) != 0) {
                            this.fwd_from.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 2048) != 0) {
                            abstractSerializedData2.writeInt32(this.via_bot_id);
                        }
                        if ((this.flags & 8) != 0) {
                            abstractSerializedData2.writeInt32((int) this.reply_to.reply_to_msg_id);
                        }
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeString(this.message);
                        if ((this.flags & 512) != 0) {
                            this.media.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 128) != 0) {
                            abstractSerializedData2.writeInt32(481674261);
                            int size = this.entities.size();
                            abstractSerializedData2.writeInt32(size);
                            for (int i10 = 0; i10 < size; i10++) {
                                this.entities.get(i10).serializeToStream(abstractSerializedData2);
                            }
                        }
                        if ((this.flags & 1024) != 0) {
                            abstractSerializedData2.writeInt32(this.views);
                        }
                        if ((this.flags & 32768) != 0) {
                            abstractSerializedData2.writeInt32(this.edit_date);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_CHECK) != 0) {
                            abstractSerializedData2.writeString(this.post_author);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_REORDER) != 0) {
                            abstractSerializedData2.writeInt64(this.grouped_id);
                        }
                        if ((this.flags & 1048576) != 0) {
                            this.reactions.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 4194304) != 0) {
                            abstractSerializedData2.writeInt32(481674261);
                            int size2 = this.restriction_reason.size();
                            abstractSerializedData2.writeInt32(size2);
                            for (int i11 = 0; i11 < size2; i11++) {
                                this.restriction_reason.get(i11).serializeToStream(abstractSerializedData2);
                            }
                        }
                        writeAttachPath(abstractSerializedData2);
                    }
                };
                break;
            case -1642487306:
                tLRPC$TL_messageEmpty = new TLRPC$TL_messageService() { // from class: org.rbmain.tgnet.TLRPC$TL_messageService_layer118
                    public static int constructor = -1642487306;

                    @Override // org.rbmain.tgnet.TLRPC$TL_messageService, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.unread = (int32 & 1) != 0;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.silent = (int32 & 8192) != 0;
                        this.post = (int32 & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0;
                        this.legacy = (int32 & MessagesController.UPDATE_MASK_CHAT_SHOW_SPAM) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        if ((this.flags & 256) != 0) {
                            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                            this.from_id = tLRPC$TL_peerUser;
                            tLRPC$TL_peerUser.user_id = abstractSerializedData2.readInt32(z2);
                        }
                        this.peer_id = TLRPC$Peer.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if ((this.flags & 8) != 0) {
                            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
                            this.reply_to = tLRPC$TL_messageReplyHeader;
                            tLRPC$TL_messageReplyHeader.reply_to_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.action = TLRPC$MessageAction.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_messageService, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.unread ? this.flags | 1 : this.flags & (-2);
                        this.flags = i2;
                        int i3 = this.out ? i2 | 2 : i2 & (-3);
                        this.flags = i3;
                        int i4 = this.mentioned ? i3 | 16 : i3 & (-17);
                        this.flags = i4;
                        int i5 = this.media_unread ? i4 | 32 : i4 & (-33);
                        this.flags = i5;
                        int i6 = this.silent ? i5 | 8192 : i5 & (-8193);
                        this.flags = i6;
                        int i7 = this.post ? i6 | LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM : i6 & (-16385);
                        this.flags = i7;
                        int i8 = this.legacy ? i7 | MessagesController.UPDATE_MASK_CHAT_SHOW_SPAM : i7 & (-524289);
                        this.flags = i8;
                        abstractSerializedData2.writeInt32(i8);
                        abstractSerializedData2.writeInt32((int) this.id);
                        if ((this.flags & 256) != 0) {
                            abstractSerializedData2.writeInt32(this.from_id.user_id);
                        }
                        this.peer_id.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 8) != 0) {
                            abstractSerializedData2.writeInt32((int) this.reply_to.reply_to_msg_id);
                        }
                        abstractSerializedData2.writeInt32(this.date);
                        this.action.serializeToStream(abstractSerializedData2);
                        writeAttachPath(abstractSerializedData2);
                    }
                };
                break;
            case -1618124613:
                tLRPC$TL_messageEmpty = new TLRPC$TL_messageService() { // from class: org.rbmain.tgnet.TLRPC$TL_messageService_old
                    public static int constructor = -1618124613;

                    @Override // org.rbmain.tgnet.TLRPC$TL_messageService, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.id = abstractSerializedData2.readInt32(z2);
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.from_id = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = abstractSerializedData2.readInt32(z2);
                        this.peer_id = TLRPC$Peer.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.out = abstractSerializedData2.readBool(z2);
                        this.unread = abstractSerializedData2.readBool(z2);
                        this.flags |= 256;
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.action = TLRPC$MessageAction.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_messageService, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32((int) this.id);
                        abstractSerializedData2.writeInt32(this.from_id.user_id);
                        this.peer_id.serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeBool(this.out);
                        abstractSerializedData2.writeBool(this.unread);
                        abstractSerializedData2.writeInt32(this.date);
                        this.action.serializeToStream(abstractSerializedData2);
                    }
                };
                break;
            case -1553471722:
                tLRPC$TL_messageEmpty = new TLRPC$TL_messageForwarded_old2();
                break;
            case -1481959023:
                tLRPC$TL_messageEmpty = new TLRPC$TL_message() { // from class: org.rbmain.tgnet.TLRPC$TL_message_old3
                    public static int constructor = -1481959023;

                    @Override // org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2) | 256 | 512;
                        this.flags = int32;
                        this.unread = (int32 & 1) != 0;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.from_id = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = abstractSerializedData2.readInt32(z2);
                        this.peer_id = TLRPC$Peer.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if ((this.flags & 4) != 0) {
                            TLRPC$TL_messageFwdHeader tLRPC$TL_messageFwdHeader = new TLRPC$TL_messageFwdHeader();
                            this.fwd_from = tLRPC$TL_messageFwdHeader;
                            tLRPC$TL_messageFwdHeader.from_id = new TLRPC$TL_peerUser();
                            this.fwd_from.from_id.user_id = abstractSerializedData2.readInt32(z2);
                            TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = this.fwd_from;
                            tLRPC$MessageFwdHeader.flags |= 1;
                            tLRPC$MessageFwdHeader.date = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 8) != 0) {
                            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
                            this.reply_to = tLRPC$TL_messageReplyHeader;
                            tLRPC$TL_messageReplyHeader.reply_to_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.message = abstractSerializedData2.readString(z2);
                        TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.media = tLRPC$MessageMediaTLdeserialize;
                        if (tLRPC$MessageMediaTLdeserialize == null || TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                            return;
                        }
                        this.message = this.media.captionLegacy;
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.unread ? this.flags | 1 : this.flags & (-2);
                        this.flags = i2;
                        int i3 = this.out ? i2 | 2 : i2 & (-3);
                        this.flags = i3;
                        int i4 = this.mentioned ? i3 | 16 : i3 & (-17);
                        this.flags = i4;
                        int i5 = this.media_unread ? i4 | 32 : i4 & (-33);
                        this.flags = i5;
                        abstractSerializedData2.writeInt32(i5);
                        abstractSerializedData2.writeInt32((int) this.id);
                        abstractSerializedData2.writeInt32(this.from_id.user_id);
                        this.peer_id.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.fwd_from.from_id.user_id);
                            abstractSerializedData2.writeInt32(this.fwd_from.date);
                        }
                        if ((this.flags & 8) != 0) {
                            abstractSerializedData2.writeInt32((int) this.reply_to.reply_to_msg_id);
                        }
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeString(this.message);
                        this.media.serializeToStream(abstractSerializedData2);
                        writeAttachPath(abstractSerializedData2);
                    }
                };
                break;
            case -1125940270:
                tLRPC$TL_messageEmpty = new TLRPC$TL_message();
                break;
            case -1066691065:
                tLRPC$TL_messageEmpty = new TLRPC$TL_messageService() { // from class: org.rbmain.tgnet.TLRPC$TL_messageService_layer48
                    public static int constructor = -1066691065;

                    @Override // org.rbmain.tgnet.TLRPC$TL_messageService, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.unread = (int32 & 1) != 0;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.silent = (int32 & 8192) != 0;
                        this.post = (int32 & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        if ((this.flags & 256) != 0) {
                            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                            this.from_id = tLRPC$TL_peerUser;
                            tLRPC$TL_peerUser.user_id = abstractSerializedData2.readInt32(z2);
                        }
                        TLRPC$Peer tLRPC$PeerTLdeserialize = TLRPC$Peer.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.peer_id = tLRPC$PeerTLdeserialize;
                        if (this.from_id == null) {
                            this.from_id = tLRPC$PeerTLdeserialize;
                        }
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.action = TLRPC$MessageAction.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_messageService, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.unread ? this.flags | 1 : this.flags & (-2);
                        this.flags = i2;
                        int i3 = this.out ? i2 | 2 : i2 & (-3);
                        this.flags = i3;
                        int i4 = this.mentioned ? i3 | 16 : i3 & (-17);
                        this.flags = i4;
                        int i5 = this.media_unread ? i4 | 32 : i4 & (-33);
                        this.flags = i5;
                        int i6 = this.silent ? i5 | 8192 : i5 & (-8193);
                        this.flags = i6;
                        int i7 = this.post ? i6 | LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM : i6 & (-16385);
                        this.flags = i7;
                        abstractSerializedData2.writeInt32(i7);
                        abstractSerializedData2.writeInt32((int) this.id);
                        if ((this.flags & 256) != 0) {
                            abstractSerializedData2.writeInt32(this.from_id.user_id);
                        }
                        this.peer_id.serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32(this.date);
                        this.action.serializeToStream(abstractSerializedData2);
                    }
                };
                break;
            case -1063525281:
                tLRPC$TL_messageEmpty = new TLRPC$TL_message() { // from class: org.rbmain.tgnet.TLRPC$TL_message_layer68
                    public static int constructor = -1063525281;

                    @Override // org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.unread = (int32 & 1) != 0;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.silent = (int32 & 8192) != 0;
                        this.post = (int32 & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0;
                        this.with_my_score = (int32 & 1073741824) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        if ((this.flags & 256) != 0) {
                            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                            this.from_id = tLRPC$TL_peerUser;
                            tLRPC$TL_peerUser.user_id = abstractSerializedData2.readInt32(z2);
                        }
                        TLRPC$Peer tLRPC$PeerTLdeserialize = TLRPC$Peer.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.peer_id = tLRPC$PeerTLdeserialize;
                        if (this.from_id == null) {
                            this.from_id = tLRPC$PeerTLdeserialize;
                        }
                        if ((this.flags & 4) != 0) {
                            this.fwd_from = TLRPC$MessageFwdHeader.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 2048) != 0) {
                            this.via_bot_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 8) != 0) {
                            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
                            this.reply_to = tLRPC$TL_messageReplyHeader;
                            tLRPC$TL_messageReplyHeader.reply_to_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.message = abstractSerializedData2.readString(z2);
                        if ((this.flags & 512) != 0) {
                            TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            this.media = tLRPC$MessageMediaTLdeserialize;
                            if (tLRPC$MessageMediaTLdeserialize != null && !TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                                this.message = this.media.captionLegacy;
                            }
                        } else {
                            this.media = new TLRPC$TL_messageMediaEmpty();
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 128) != 0) {
                            int int322 = abstractSerializedData2.readInt32(z2);
                            if (int322 != 481674261) {
                                if (z2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = abstractSerializedData2.readInt32(z2);
                            for (int i2 = 0; i2 < int323; i2++) {
                                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                                if (tLRPC$MessageEntityTLdeserialize == null) {
                                    return;
                                }
                                this.entities.add(tLRPC$MessageEntityTLdeserialize);
                            }
                        }
                        if ((this.flags & 1024) != 0) {
                            this.views = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.edit_date = abstractSerializedData2.readInt32(z2);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.unread ? this.flags | 1 : this.flags & (-2);
                        this.flags = i2;
                        int i3 = this.out ? i2 | 2 : i2 & (-3);
                        this.flags = i3;
                        int i4 = this.mentioned ? i3 | 16 : i3 & (-17);
                        this.flags = i4;
                        int i5 = this.media_unread ? i4 | 32 : i4 & (-33);
                        this.flags = i5;
                        int i6 = this.silent ? i5 | 8192 : i5 & (-8193);
                        this.flags = i6;
                        int i7 = this.post ? i6 | LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM : i6 & (-16385);
                        this.flags = i7;
                        int i8 = this.with_my_score ? i7 | 1073741824 : i7 & (-1073741825);
                        this.flags = i8;
                        abstractSerializedData2.writeInt32(i8);
                        abstractSerializedData2.writeInt32((int) this.id);
                        if ((this.flags & 256) != 0) {
                            abstractSerializedData2.writeInt32(this.from_id.user_id);
                        }
                        this.peer_id.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 4) != 0) {
                            this.fwd_from.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 2048) != 0) {
                            abstractSerializedData2.writeInt32(this.via_bot_id);
                        }
                        if ((this.flags & 8) != 0) {
                            abstractSerializedData2.writeInt32((int) this.reply_to.reply_to_msg_id);
                        }
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeString(this.message);
                        if ((this.flags & 512) != 0) {
                            this.media.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 128) != 0) {
                            abstractSerializedData2.writeInt32(481674261);
                            int size = this.entities.size();
                            abstractSerializedData2.writeInt32(size);
                            for (int i9 = 0; i9 < size; i9++) {
                                this.entities.get(i9).serializeToStream(abstractSerializedData2);
                            }
                        }
                        if ((this.flags & 1024) != 0) {
                            abstractSerializedData2.writeInt32(this.views);
                        }
                        if ((this.flags & 32768) != 0) {
                            abstractSerializedData2.writeInt32(this.edit_date);
                        }
                        writeAttachPath(abstractSerializedData2);
                    }
                };
                break;
            case -1023016155:
                tLRPC$TL_messageEmpty = new TLRPC$TL_message() { // from class: org.rbmain.tgnet.TLRPC$TL_message_old4
                    public static int constructor = -1023016155;

                    @Override // org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2) | 256 | 512;
                        this.flags = int32;
                        this.unread = (int32 & 1) != 0;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.from_id = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = abstractSerializedData2.readInt32(z2);
                        this.peer_id = TLRPC$Peer.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if ((this.flags & 4) != 0) {
                            TLRPC$TL_messageFwdHeader tLRPC$TL_messageFwdHeader = new TLRPC$TL_messageFwdHeader();
                            this.fwd_from = tLRPC$TL_messageFwdHeader;
                            tLRPC$TL_messageFwdHeader.from_id = new TLRPC$TL_peerUser();
                            this.fwd_from.from_id.user_id = abstractSerializedData2.readInt32(z2);
                            TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = this.fwd_from;
                            tLRPC$MessageFwdHeader.flags |= 1;
                            tLRPC$MessageFwdHeader.date = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 8) != 0) {
                            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
                            this.reply_to = tLRPC$TL_messageReplyHeader;
                            tLRPC$TL_messageReplyHeader.reply_to_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.message = abstractSerializedData2.readString(z2);
                        TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.media = tLRPC$MessageMediaTLdeserialize;
                        if (tLRPC$MessageMediaTLdeserialize != null && !TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                            this.message = this.media.captionLegacy;
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.unread ? this.flags | 1 : this.flags & (-2);
                        this.flags = i2;
                        int i3 = this.out ? i2 | 2 : i2 & (-3);
                        this.flags = i3;
                        int i4 = this.mentioned ? i3 | 16 : i3 & (-17);
                        this.flags = i4;
                        int i5 = this.media_unread ? i4 | 32 : i4 & (-33);
                        this.flags = i5;
                        abstractSerializedData2.writeInt32(i5);
                        abstractSerializedData2.writeInt32((int) this.id);
                        abstractSerializedData2.writeInt32(this.from_id.user_id);
                        this.peer_id.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.fwd_from.from_id.user_id);
                            abstractSerializedData2.writeInt32(this.fwd_from.date);
                        }
                        if ((this.flags & 8) != 0) {
                            abstractSerializedData2.writeInt32((int) this.reply_to.reply_to_msg_id);
                        }
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeString(this.message);
                        this.media.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 64) != 0) {
                            this.reply_markup.serializeToStream(abstractSerializedData2);
                        }
                        writeAttachPath(abstractSerializedData2);
                    }
                };
                break;
            case -913120932:
                tLRPC$TL_messageEmpty = new TLRPC$TL_message() { // from class: org.rbmain.tgnet.TLRPC$TL_message_layer47
                    public static int constructor = -913120932;

                    @Override // org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.unread = (int32 & 1) != 0;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        if ((this.flags & 256) != 0) {
                            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                            this.from_id = tLRPC$TL_peerUser;
                            tLRPC$TL_peerUser.user_id = abstractSerializedData2.readInt32(z2);
                        }
                        TLRPC$Peer tLRPC$PeerTLdeserialize = TLRPC$Peer.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.peer_id = tLRPC$PeerTLdeserialize;
                        if (this.from_id == null) {
                            this.from_id = tLRPC$PeerTLdeserialize;
                        }
                        if ((this.flags & 4) != 0) {
                            this.fwd_from = new TLRPC$TL_messageFwdHeader();
                            TLRPC$Peer tLRPC$PeerTLdeserialize2 = TLRPC$Peer.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$PeerTLdeserialize2 != null) {
                                TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = this.fwd_from;
                                tLRPC$MessageFwdHeader.from_id = tLRPC$PeerTLdeserialize2;
                                tLRPC$MessageFwdHeader.flags |= 1;
                            }
                            this.fwd_from.date = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 2048) != 0) {
                            this.via_bot_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 8) != 0) {
                            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
                            this.reply_to = tLRPC$TL_messageReplyHeader;
                            tLRPC$TL_messageReplyHeader.reply_to_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.message = abstractSerializedData2.readString(z2);
                        if ((this.flags & 512) != 0) {
                            TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            this.media = tLRPC$MessageMediaTLdeserialize;
                            if (tLRPC$MessageMediaTLdeserialize != null && !TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                                this.message = this.media.captionLegacy;
                            }
                        } else {
                            this.media = new TLRPC$TL_messageMediaEmpty();
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 128) != 0) {
                            int int322 = abstractSerializedData2.readInt32(z2);
                            if (int322 != 481674261) {
                                if (z2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = abstractSerializedData2.readInt32(z2);
                            for (int i2 = 0; i2 < int323; i2++) {
                                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                                if (tLRPC$MessageEntityTLdeserialize == null) {
                                    return;
                                }
                                this.entities.add(tLRPC$MessageEntityTLdeserialize);
                            }
                        }
                        if ((this.flags & 1024) != 0) {
                            this.views = abstractSerializedData2.readInt32(z2);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.unread ? this.flags | 1 : this.flags & (-2);
                        this.flags = i2;
                        int i3 = this.out ? i2 | 2 : i2 & (-3);
                        this.flags = i3;
                        int i4 = this.mentioned ? i3 | 16 : i3 & (-17);
                        this.flags = i4;
                        int i5 = this.media_unread ? i4 | 32 : i4 & (-33);
                        this.flags = i5;
                        abstractSerializedData2.writeInt32(i5);
                        abstractSerializedData2.writeInt32((int) this.id);
                        if ((this.flags & 256) != 0) {
                            abstractSerializedData2.writeInt32(this.from_id.user_id);
                        }
                        this.peer_id.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 4) != 0) {
                            TLRPC$Peer tLRPC$Peer = this.fwd_from.from_id;
                            if (tLRPC$Peer != null) {
                                tLRPC$Peer.serializeToStream(abstractSerializedData2);
                            }
                            abstractSerializedData2.writeInt32(this.fwd_from.date);
                        }
                        if ((this.flags & 2048) != 0) {
                            abstractSerializedData2.writeInt32(this.via_bot_id);
                        }
                        if ((this.flags & 8) != 0) {
                            abstractSerializedData2.writeInt32((int) this.reply_to.reply_to_msg_id);
                        }
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeString(this.message);
                        if ((this.flags & 512) != 0) {
                            this.media.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 128) != 0) {
                            abstractSerializedData2.writeInt32(481674261);
                            int size = this.entities.size();
                            abstractSerializedData2.writeInt32(size);
                            for (int i6 = 0; i6 < size; i6++) {
                                this.entities.get(i6).serializeToStream(abstractSerializedData2);
                            }
                        }
                        if ((this.flags & 1024) != 0) {
                            abstractSerializedData2.writeInt32(this.views);
                        }
                        writeAttachPath(abstractSerializedData2);
                    }
                };
                break;
            case -260565816:
                tLRPC$TL_messageEmpty = new TLRPC$TL_message() { // from class: org.rbmain.tgnet.TLRPC$TL_message_old5
                    public static int constructor = -260565816;

                    @Override // org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2) | 256 | 512;
                        this.flags = int32;
                        this.unread = (int32 & 1) != 0;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.from_id = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = abstractSerializedData2.readInt32(z2);
                        this.peer_id = TLRPC$Peer.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if ((this.flags & 4) != 0) {
                            TLRPC$TL_messageFwdHeader tLRPC$TL_messageFwdHeader = new TLRPC$TL_messageFwdHeader();
                            this.fwd_from = tLRPC$TL_messageFwdHeader;
                            tLRPC$TL_messageFwdHeader.from_id = new TLRPC$TL_peerUser();
                            this.fwd_from.from_id.user_id = abstractSerializedData2.readInt32(z2);
                            TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = this.fwd_from;
                            tLRPC$MessageFwdHeader.flags |= 1;
                            tLRPC$MessageFwdHeader.date = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 8) != 0) {
                            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
                            this.reply_to = tLRPC$TL_messageReplyHeader;
                            tLRPC$TL_messageReplyHeader.reply_to_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.message = abstractSerializedData2.readString(z2);
                        TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.media = tLRPC$MessageMediaTLdeserialize;
                        if (tLRPC$MessageMediaTLdeserialize != null && !TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                            this.message = this.media.captionLegacy;
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 128) != 0) {
                            int int322 = abstractSerializedData2.readInt32(z2);
                            if (int322 != 481674261) {
                                if (z2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = abstractSerializedData2.readInt32(z2);
                            for (int i2 = 0; i2 < int323; i2++) {
                                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                                if (tLRPC$MessageEntityTLdeserialize == null) {
                                    return;
                                }
                                this.entities.add(tLRPC$MessageEntityTLdeserialize);
                            }
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.unread ? this.flags | 1 : this.flags & (-2);
                        this.flags = i2;
                        int i3 = this.out ? i2 | 2 : i2 & (-3);
                        this.flags = i3;
                        int i4 = this.mentioned ? i3 | 16 : i3 & (-17);
                        this.flags = i4;
                        int i5 = this.media_unread ? i4 | 32 : i4 & (-33);
                        this.flags = i5;
                        abstractSerializedData2.writeInt32(i5);
                        abstractSerializedData2.writeInt32((int) this.id);
                        abstractSerializedData2.writeInt32(this.from_id.user_id);
                        this.peer_id.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.fwd_from.from_id.user_id);
                            abstractSerializedData2.writeInt32(this.fwd_from.date);
                        }
                        if ((this.flags & 8) != 0) {
                            abstractSerializedData2.writeInt32((int) this.reply_to.reply_to_msg_id);
                        }
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeString(this.message);
                        this.media.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 64) != 0) {
                            this.reply_markup.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 128) != 0) {
                            abstractSerializedData2.writeInt32(481674261);
                            int size = this.entities.size();
                            abstractSerializedData2.writeInt32(size);
                            for (int i6 = 0; i6 < size; i6++) {
                                this.entities.get(i6).serializeToStream(abstractSerializedData2);
                            }
                        }
                        writeAttachPath(abstractSerializedData2);
                    }
                };
                break;
            case -181507201:
                tLRPC$TL_messageEmpty = new TLRPC$TL_message() { // from class: org.rbmain.tgnet.TLRPC$TL_message_layer118
                    public static int constructor = -181507201;

                    @Override // org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.silent = (int32 & 8192) != 0;
                        this.post = (int32 & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0;
                        this.from_scheduled = (262144 & int32) != 0;
                        this.legacy = (524288 & int32) != 0;
                        this.edit_hide = (int32 & 2097152) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        if ((this.flags & 256) != 0) {
                            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                            this.from_id = tLRPC$TL_peerUser;
                            tLRPC$TL_peerUser.user_id = abstractSerializedData2.readInt32(z2);
                        }
                        this.peer_id = TLRPC$Peer.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if ((this.flags & 4) != 0) {
                            this.fwd_from = TLRPC$MessageFwdHeader.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 2048) != 0) {
                            this.via_bot_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 8) != 0) {
                            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
                            this.reply_to = tLRPC$TL_messageReplyHeader;
                            tLRPC$TL_messageReplyHeader.reply_to_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.message = abstractSerializedData2.readString(z2);
                        if ((this.flags & 512) != 0) {
                            TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            this.media = tLRPC$MessageMediaTLdeserialize;
                            if (tLRPC$MessageMediaTLdeserialize != null) {
                                this.ttl = tLRPC$MessageMediaTLdeserialize.ttl_seconds;
                            }
                            if (tLRPC$MessageMediaTLdeserialize != null && !TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                                this.message = this.media.captionLegacy;
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 128) != 0) {
                            int int322 = abstractSerializedData2.readInt32(z2);
                            if (int322 != 481674261) {
                                if (z2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = abstractSerializedData2.readInt32(z2);
                            for (int i2 = 0; i2 < int323; i2++) {
                                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                                if (tLRPC$MessageEntityTLdeserialize == null) {
                                    return;
                                }
                                this.entities.add(tLRPC$MessageEntityTLdeserialize);
                            }
                        }
                        if ((this.flags & 1024) != 0) {
                            this.views = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 1024) != 0) {
                            this.forwards = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.edit_date = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_CHECK) != 0) {
                            this.post_author = abstractSerializedData2.readString(z2);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_REORDER) != 0) {
                            this.grouped_id = abstractSerializedData2.readInt64(z2);
                        }
                        if ((this.flags & 4194304) != 0) {
                            int int324 = abstractSerializedData2.readInt32(z2);
                            if (int324 != 481674261) {
                                if (z2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
                                }
                                return;
                            }
                            int int325 = abstractSerializedData2.readInt32(z2);
                            for (int i3 = 0; i3 < int325; i3++) {
                                TLRPC$TL_restrictionReason tLRPC$TL_restrictionReasonTLdeserialize = TLRPC$TL_restrictionReason.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                                if (tLRPC$TL_restrictionReasonTLdeserialize == null) {
                                    return;
                                }
                                this.restriction_reason.add(tLRPC$TL_restrictionReasonTLdeserialize);
                            }
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.out ? this.flags | 2 : this.flags & (-3);
                        this.flags = i2;
                        int i3 = this.mentioned ? i2 | 16 : i2 & (-17);
                        this.flags = i3;
                        int i4 = this.media_unread ? i3 | 32 : i3 & (-33);
                        this.flags = i4;
                        int i5 = this.silent ? i4 | 8192 : i4 & (-8193);
                        this.flags = i5;
                        int i6 = this.post ? i5 | LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM : i5 & (-16385);
                        this.flags = i6;
                        int i7 = this.from_scheduled ? i6 | MessagesController.UPDATE_MASK_CHAT_MUTE : i6 & (-262145);
                        this.flags = i7;
                        int i8 = this.legacy ? i7 | MessagesController.UPDATE_MASK_CHAT_SHOW_SPAM : i7 & (-524289);
                        this.flags = i8;
                        int i9 = this.edit_hide ? i8 | 2097152 : i8 & (-2097153);
                        this.flags = i9;
                        abstractSerializedData2.writeInt32(i9);
                        abstractSerializedData2.writeInt32((int) this.id);
                        if ((this.flags & 256) != 0) {
                            abstractSerializedData2.writeInt32(this.from_id.user_id);
                        }
                        this.peer_id.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 4) != 0) {
                            this.fwd_from.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 2048) != 0) {
                            abstractSerializedData2.writeInt32(this.via_bot_id);
                        }
                        if ((this.flags & 8) != 0) {
                            abstractSerializedData2.writeInt32((int) this.reply_to.reply_to_msg_id);
                        }
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeString(this.message);
                        if ((this.flags & 512) != 0) {
                            this.media.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 128) != 0) {
                            abstractSerializedData2.writeInt32(481674261);
                            int size = this.entities.size();
                            abstractSerializedData2.writeInt32(size);
                            for (int i10 = 0; i10 < size; i10++) {
                                this.entities.get(i10).serializeToStream(abstractSerializedData2);
                            }
                        }
                        if ((this.flags & 1024) != 0) {
                            abstractSerializedData2.writeInt32(this.views);
                        }
                        if ((this.flags & 1024) != 0) {
                            abstractSerializedData2.writeInt32(this.forwards);
                        }
                        if ((this.flags & 32768) != 0) {
                            abstractSerializedData2.writeInt32(this.edit_date);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_CHECK) != 0) {
                            abstractSerializedData2.writeString(this.post_author);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_REORDER) != 0) {
                            abstractSerializedData2.writeInt64(this.grouped_id);
                        }
                        if ((this.flags & 4194304) != 0) {
                            abstractSerializedData2.writeInt32(481674261);
                            int size2 = this.restriction_reason.size();
                            abstractSerializedData2.writeInt32(size2);
                            for (int i11 = 0; i11 < size2; i11++) {
                                this.restriction_reason.get(i11).serializeToStream(abstractSerializedData2);
                            }
                        }
                        writeAttachPath(abstractSerializedData2);
                    }
                };
                break;
            case 99903492:
                tLRPC$TL_messageEmpty = new TLRPC$TL_messageForwarded_old2() { // from class: org.rbmain.tgnet.TLRPC$TL_messageForwarded_old
                    public static int constructor = 99903492;

                    @Override // org.rbmain.tgnet.TLRPC$TL_messageForwarded_old2, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.id = abstractSerializedData2.readInt32(z2);
                        TLRPC$TL_messageFwdHeader tLRPC$TL_messageFwdHeader = new TLRPC$TL_messageFwdHeader();
                        this.fwd_from = tLRPC$TL_messageFwdHeader;
                        tLRPC$TL_messageFwdHeader.from_id = new TLRPC$TL_peerUser();
                        this.fwd_from.from_id.user_id = abstractSerializedData2.readInt32(z2);
                        TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = this.fwd_from;
                        tLRPC$MessageFwdHeader.flags |= 1;
                        tLRPC$MessageFwdHeader.date = abstractSerializedData2.readInt32(z2);
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.from_id = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = abstractSerializedData2.readInt32(z2);
                        this.peer_id = TLRPC$Peer.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.out = abstractSerializedData2.readBool(z2);
                        this.unread = abstractSerializedData2.readBool(z2);
                        this.flags |= 772;
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.message = abstractSerializedData2.readString(z2);
                        TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.media = tLRPC$MessageMediaTLdeserialize;
                        if (tLRPC$MessageMediaTLdeserialize == null || TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                            return;
                        }
                        this.message = this.media.captionLegacy;
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_messageForwarded_old2, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32((int) this.id);
                        abstractSerializedData2.writeInt32(this.fwd_from.from_id.user_id);
                        abstractSerializedData2.writeInt32(this.fwd_from.date);
                        abstractSerializedData2.writeInt32(this.from_id.user_id);
                        this.peer_id.serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeBool(this.out);
                        abstractSerializedData2.writeBool(this.unread);
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeString(this.message);
                        this.media.serializeToStream(abstractSerializedData2);
                        writeAttachPath(abstractSerializedData2);
                    }
                };
                break;
            case 479924263:
                tLRPC$TL_messageEmpty = new TLRPC$TL_message() { // from class: org.rbmain.tgnet.TLRPC$TL_message_layer104_2
                    public static int constructor = 479924263;

                    @Override // org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.silent = (int32 & 8192) != 0;
                        this.post = (int32 & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0;
                        this.from_scheduled = (262144 & int32) != 0;
                        this.legacy = (524288 & int32) != 0;
                        this.edit_hide = (int32 & 2097152) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        if ((this.flags & 256) != 0) {
                            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                            this.from_id = tLRPC$TL_peerUser;
                            tLRPC$TL_peerUser.user_id = abstractSerializedData2.readInt32(z2);
                        }
                        this.peer_id = TLRPC$Peer.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if ((this.flags & 4) != 0) {
                            this.fwd_from = TLRPC$MessageFwdHeader.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 2048) != 0) {
                            this.via_bot_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 8) != 0) {
                            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
                            this.reply_to = tLRPC$TL_messageReplyHeader;
                            tLRPC$TL_messageReplyHeader.reply_to_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.message = abstractSerializedData2.readString(z2);
                        if ((this.flags & 512) != 0) {
                            TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            this.media = tLRPC$MessageMediaTLdeserialize;
                            if (tLRPC$MessageMediaTLdeserialize != null) {
                                this.ttl = tLRPC$MessageMediaTLdeserialize.ttl_seconds;
                            }
                            if (tLRPC$MessageMediaTLdeserialize != null && !TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                                this.message = this.media.captionLegacy;
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 128) != 0) {
                            int int322 = abstractSerializedData2.readInt32(z2);
                            if (int322 != 481674261) {
                                if (z2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = abstractSerializedData2.readInt32(z2);
                            for (int i2 = 0; i2 < int323; i2++) {
                                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                                if (tLRPC$MessageEntityTLdeserialize == null) {
                                    return;
                                }
                                this.entities.add(tLRPC$MessageEntityTLdeserialize);
                            }
                        }
                        if ((this.flags & 1024) != 0) {
                            this.views = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.edit_date = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_CHECK) != 0) {
                            this.post_author = abstractSerializedData2.readString(z2);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_REORDER) != 0) {
                            this.grouped_id = abstractSerializedData2.readInt64(z2);
                        }
                        if ((this.flags & 1048576) != 0) {
                            this.reactions = TLRPC$MessageReactions.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 4194304) != 0) {
                            abstractSerializedData2.readString(z2);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.out ? this.flags | 2 : this.flags & (-3);
                        this.flags = i2;
                        int i3 = this.mentioned ? i2 | 16 : i2 & (-17);
                        this.flags = i3;
                        int i4 = this.media_unread ? i3 | 32 : i3 & (-33);
                        this.flags = i4;
                        int i5 = this.silent ? i4 | 8192 : i4 & (-8193);
                        this.flags = i5;
                        int i6 = this.post ? i5 | LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM : i5 & (-16385);
                        this.flags = i6;
                        int i7 = this.from_scheduled ? i6 | MessagesController.UPDATE_MASK_CHAT_MUTE : i6 & (-262145);
                        this.flags = i7;
                        int i8 = this.legacy ? i7 | MessagesController.UPDATE_MASK_CHAT_SHOW_SPAM : i7 & (-524289);
                        this.flags = i8;
                        int i9 = this.edit_hide ? i8 | 2097152 : i8 & (-2097153);
                        this.flags = i9;
                        abstractSerializedData2.writeInt32(i9);
                        abstractSerializedData2.writeInt32((int) this.id);
                        if ((this.flags & 256) != 0) {
                            abstractSerializedData2.writeInt32(this.from_id.user_id);
                        }
                        this.peer_id.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 4) != 0) {
                            this.fwd_from.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 2048) != 0) {
                            abstractSerializedData2.writeInt32(this.via_bot_id);
                        }
                        if ((this.flags & 8) != 0) {
                            abstractSerializedData2.writeInt32((int) this.reply_to.reply_to_msg_id);
                        }
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeString(this.message);
                        if ((this.flags & 512) != 0) {
                            this.media.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 128) != 0) {
                            abstractSerializedData2.writeInt32(481674261);
                            int size = this.entities.size();
                            abstractSerializedData2.writeInt32(size);
                            for (int i10 = 0; i10 < size; i10++) {
                                this.entities.get(i10).serializeToStream(abstractSerializedData2);
                            }
                        }
                        if ((this.flags & 1024) != 0) {
                            abstractSerializedData2.writeInt32(this.views);
                        }
                        if ((this.flags & 32768) != 0) {
                            abstractSerializedData2.writeInt32(this.edit_date);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_CHECK) != 0) {
                            abstractSerializedData2.writeString(this.post_author);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_REORDER) != 0) {
                            abstractSerializedData2.writeInt64(this.grouped_id);
                        }
                        if ((this.flags & 1048576) != 0) {
                            this.reactions.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 4194304) != 0) {
                            abstractSerializedData2.writeString(BuildConfig.FLAVOR);
                        }
                        writeAttachPath(abstractSerializedData2);
                    }
                };
                break;
            case 495384334:
                tLRPC$TL_messageEmpty = new TLRPC$TL_messageService() { // from class: org.rbmain.tgnet.TLRPC$TL_messageService_old2
                    public static int constructor = 495384334;

                    @Override // org.rbmain.tgnet.TLRPC$TL_messageService, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.unread = (int32 & 1) != 0;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.from_id = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = abstractSerializedData2.readInt32(z2);
                        this.peer_id = TLRPC$Peer.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.action = TLRPC$MessageAction.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.flags |= 256;
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_messageService, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.unread ? this.flags | 1 : this.flags & (-2);
                        this.flags = i2;
                        int i3 = this.out ? i2 | 2 : i2 & (-3);
                        this.flags = i3;
                        int i4 = this.mentioned ? i3 | 16 : i3 & (-17);
                        this.flags = i4;
                        int i5 = this.media_unread ? i4 | 32 : i4 & (-33);
                        this.flags = i5;
                        abstractSerializedData2.writeInt32(i5);
                        abstractSerializedData2.writeInt32((int) this.id);
                        abstractSerializedData2.writeInt32(this.from_id.user_id);
                        this.peer_id.serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32(this.date);
                        this.action.serializeToStream(abstractSerializedData2);
                    }
                };
                break;
            case 585853626:
                tLRPC$TL_messageEmpty = new TLRPC$TL_message() { // from class: org.rbmain.tgnet.TLRPC$TL_message_old
                    public static int constructor = 585853626;

                    @Override // org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.id = abstractSerializedData2.readInt32(z2);
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.from_id = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = abstractSerializedData2.readInt32(z2);
                        this.peer_id = TLRPC$Peer.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.out = abstractSerializedData2.readBool(z2);
                        this.unread = abstractSerializedData2.readBool(z2);
                        this.flags |= 768;
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.message = abstractSerializedData2.readString(z2);
                        TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.media = tLRPC$MessageMediaTLdeserialize;
                        if (tLRPC$MessageMediaTLdeserialize == null || TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                            return;
                        }
                        this.message = this.media.captionLegacy;
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32((int) this.id);
                        abstractSerializedData2.writeInt32(this.from_id.user_id);
                        this.peer_id.serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeBool(this.out);
                        abstractSerializedData2.writeBool(this.unread);
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeString(this.message);
                        this.media.serializeToStream(abstractSerializedData2);
                        writeAttachPath(abstractSerializedData2);
                    }
                };
                break;
            case 678405636:
                tLRPC$TL_messageEmpty = new TLRPC$TL_messageService() { // from class: org.rbmain.tgnet.TLRPC$TL_messageService_layer123
                    public static int constructor = 678405636;

                    @Override // org.rbmain.tgnet.TLRPC$TL_messageService, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.silent = (int32 & 8192) != 0;
                        this.post = (int32 & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0;
                        this.legacy = (int32 & MessagesController.UPDATE_MASK_CHAT_SHOW_SPAM) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        if ((this.flags & 256) != 0) {
                            this.from_id = TLRPC$Peer.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        this.peer_id = TLRPC$Peer.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if ((this.flags & 8) != 0) {
                            this.reply_to = TLRPC$TL_messageReplyHeader.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.action = TLRPC$MessageAction.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_messageService, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.out ? this.flags | 2 : this.flags & (-3);
                        this.flags = i2;
                        int i3 = this.mentioned ? i2 | 16 : i2 & (-17);
                        this.flags = i3;
                        int i4 = this.media_unread ? i3 | 32 : i3 & (-33);
                        this.flags = i4;
                        int i5 = this.silent ? i4 | 8192 : i4 & (-8193);
                        this.flags = i5;
                        int i6 = this.post ? i5 | LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM : i5 & (-16385);
                        this.flags = i6;
                        int i7 = this.legacy ? i6 | MessagesController.UPDATE_MASK_CHAT_SHOW_SPAM : i6 & (-524289);
                        this.flags = i7;
                        abstractSerializedData2.writeInt32(i7);
                        abstractSerializedData2.writeInt32((int) this.id);
                        if ((this.flags & 256) != 0) {
                            this.from_id.serializeToStream(abstractSerializedData2);
                        }
                        this.peer_id.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 8) != 0) {
                            this.reply_to.serializeToStream(abstractSerializedData2);
                        }
                        abstractSerializedData2.writeInt32(this.date);
                        this.action.serializeToStream(abstractSerializedData2);
                        writeAttachPath(abstractSerializedData2);
                    }
                };
                break;
            case 721967202:
                tLRPC$TL_messageEmpty = new TLRPC$TL_messageService();
                break;
            case 736885382:
                tLRPC$TL_messageEmpty = new TLRPC$TL_message() { // from class: org.rbmain.tgnet.TLRPC$TL_message_old6
                    public static int constructor = 736885382;

                    @Override // org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2) | 256;
                        this.flags = int32;
                        this.unread = (int32 & 1) != 0;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.from_id = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = abstractSerializedData2.readInt32(z2);
                        this.peer_id = TLRPC$Peer.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if ((this.flags & 4) != 0) {
                            TLRPC$TL_messageFwdHeader tLRPC$TL_messageFwdHeader = new TLRPC$TL_messageFwdHeader();
                            this.fwd_from = tLRPC$TL_messageFwdHeader;
                            tLRPC$TL_messageFwdHeader.from_id = new TLRPC$TL_peerUser();
                            this.fwd_from.from_id.user_id = abstractSerializedData2.readInt32(z2);
                            TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = this.fwd_from;
                            tLRPC$MessageFwdHeader.flags |= 1;
                            tLRPC$MessageFwdHeader.date = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 8) != 0) {
                            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
                            this.reply_to = tLRPC$TL_messageReplyHeader;
                            tLRPC$TL_messageReplyHeader.reply_to_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.message = abstractSerializedData2.readString(z2);
                        if ((this.flags & 512) != 0) {
                            TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            this.media = tLRPC$MessageMediaTLdeserialize;
                            if (tLRPC$MessageMediaTLdeserialize != null && !TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                                this.message = this.media.captionLegacy;
                            }
                        } else {
                            this.media = new TLRPC$TL_messageMediaEmpty();
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 128) != 0) {
                            int int322 = abstractSerializedData2.readInt32(z2);
                            if (int322 != 481674261) {
                                if (z2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = abstractSerializedData2.readInt32(z2);
                            for (int i2 = 0; i2 < int323; i2++) {
                                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                                if (tLRPC$MessageEntityTLdeserialize == null) {
                                    return;
                                }
                                this.entities.add(tLRPC$MessageEntityTLdeserialize);
                            }
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.unread ? this.flags | 1 : this.flags & (-2);
                        this.flags = i2;
                        int i3 = this.out ? i2 | 2 : i2 & (-3);
                        this.flags = i3;
                        int i4 = this.mentioned ? i3 | 16 : i3 & (-17);
                        this.flags = i4;
                        int i5 = this.media_unread ? i4 | 32 : i4 & (-33);
                        this.flags = i5;
                        abstractSerializedData2.writeInt32(i5);
                        abstractSerializedData2.writeInt32((int) this.id);
                        abstractSerializedData2.writeInt32(this.from_id.user_id);
                        this.peer_id.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.fwd_from.from_id.user_id);
                            abstractSerializedData2.writeInt32(this.fwd_from.date);
                        }
                        if ((this.flags & 8) != 0) {
                            abstractSerializedData2.writeInt32((int) this.reply_to.reply_to_msg_id);
                        }
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeString(this.message);
                        if ((this.flags & 512) != 0) {
                            this.media.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 128) != 0) {
                            abstractSerializedData2.writeInt32(481674261);
                            int size = this.entities.size();
                            abstractSerializedData2.writeInt32(size);
                            for (int i6 = 0; i6 < size; i6++) {
                                this.entities.get(i6).serializeToStream(abstractSerializedData2);
                            }
                        }
                        writeAttachPath(abstractSerializedData2);
                    }
                };
                break;
            case 1157215293:
                tLRPC$TL_messageEmpty = new TLRPC$TL_message() { // from class: org.rbmain.tgnet.TLRPC$TL_message_layer104
                    public static int constructor = 1157215293;

                    @Override // org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.silent = (int32 & 8192) != 0;
                        this.post = (int32 & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0;
                        this.from_scheduled = (262144 & int32) != 0;
                        this.legacy = (int32 & MessagesController.UPDATE_MASK_CHAT_SHOW_SPAM) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        if ((this.flags & 256) != 0) {
                            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                            this.from_id = tLRPC$TL_peerUser;
                            tLRPC$TL_peerUser.user_id = abstractSerializedData2.readInt32(z2);
                        }
                        this.peer_id = TLRPC$Peer.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if ((this.flags & 4) != 0) {
                            this.fwd_from = TLRPC$MessageFwdHeader.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 2048) != 0) {
                            this.via_bot_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 8) != 0) {
                            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
                            this.reply_to = tLRPC$TL_messageReplyHeader;
                            tLRPC$TL_messageReplyHeader.reply_to_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.message = abstractSerializedData2.readString(z2);
                        if ((this.flags & 512) != 0) {
                            TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            this.media = tLRPC$MessageMediaTLdeserialize;
                            if (tLRPC$MessageMediaTLdeserialize != null) {
                                this.ttl = tLRPC$MessageMediaTLdeserialize.ttl_seconds;
                            }
                            if (tLRPC$MessageMediaTLdeserialize != null && !TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                                this.message = this.media.captionLegacy;
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 128) != 0) {
                            int int322 = abstractSerializedData2.readInt32(z2);
                            if (int322 != 481674261) {
                                if (z2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = abstractSerializedData2.readInt32(z2);
                            for (int i2 = 0; i2 < int323; i2++) {
                                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                                if (tLRPC$MessageEntityTLdeserialize == null) {
                                    return;
                                }
                                this.entities.add(tLRPC$MessageEntityTLdeserialize);
                            }
                        }
                        if ((this.flags & 1024) != 0) {
                            this.views = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.edit_date = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_CHECK) != 0) {
                            this.post_author = abstractSerializedData2.readString(z2);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_REORDER) != 0) {
                            this.grouped_id = abstractSerializedData2.readInt64(z2);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.out ? this.flags | 2 : this.flags & (-3);
                        this.flags = i2;
                        int i3 = this.mentioned ? i2 | 16 : i2 & (-17);
                        this.flags = i3;
                        int i4 = this.media_unread ? i3 | 32 : i3 & (-33);
                        this.flags = i4;
                        int i5 = this.silent ? i4 | 8192 : i4 & (-8193);
                        this.flags = i5;
                        int i6 = this.post ? i5 | LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM : i5 & (-16385);
                        this.flags = i6;
                        int i7 = this.from_scheduled ? i6 | MessagesController.UPDATE_MASK_CHAT_MUTE : i6 & (-262145);
                        this.flags = i7;
                        int i8 = this.legacy ? i7 | MessagesController.UPDATE_MASK_CHAT_SHOW_SPAM : i7 & (-524289);
                        this.flags = i8;
                        abstractSerializedData2.writeInt32(i8);
                        abstractSerializedData2.writeInt32((int) this.id);
                        if ((this.flags & 256) != 0) {
                            abstractSerializedData2.writeInt32(this.from_id.user_id);
                        }
                        this.peer_id.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 4) != 0) {
                            this.fwd_from.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 2048) != 0) {
                            abstractSerializedData2.writeInt32(this.via_bot_id);
                        }
                        if ((this.flags & 8) != 0) {
                            abstractSerializedData2.writeInt32((int) this.reply_to.reply_to_msg_id);
                        }
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeString(this.message);
                        if ((this.flags & 512) != 0) {
                            this.media.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 128) != 0) {
                            abstractSerializedData2.writeInt32(481674261);
                            int size = this.entities.size();
                            abstractSerializedData2.writeInt32(size);
                            for (int i9 = 0; i9 < size; i9++) {
                                this.entities.get(i9).serializeToStream(abstractSerializedData2);
                            }
                        }
                        if ((this.flags & 1024) != 0) {
                            abstractSerializedData2.writeInt32(this.views);
                        }
                        if ((this.flags & 32768) != 0) {
                            abstractSerializedData2.writeInt32(this.edit_date);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_CHECK) != 0) {
                            abstractSerializedData2.writeString(this.post_author);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_REORDER) != 0) {
                            abstractSerializedData2.writeInt64(this.grouped_id);
                        }
                        writeAttachPath(abstractSerializedData2);
                    }
                };
                break;
            case 1160515173:
                tLRPC$TL_messageEmpty = new TLRPC$TL_message() { // from class: org.rbmain.tgnet.TLRPC$TL_message_layer117
                    public static int constructor = 1160515173;

                    @Override // org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.silent = (int32 & 8192) != 0;
                        this.post = (int32 & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0;
                        this.from_scheduled = (262144 & int32) != 0;
                        this.legacy = (524288 & int32) != 0;
                        this.edit_hide = (int32 & 2097152) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        if ((this.flags & 256) != 0) {
                            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                            this.from_id = tLRPC$TL_peerUser;
                            tLRPC$TL_peerUser.user_id = abstractSerializedData2.readInt32(z2);
                        }
                        this.peer_id = TLRPC$Peer.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if ((this.flags & 4) != 0) {
                            this.fwd_from = TLRPC$MessageFwdHeader.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 2048) != 0) {
                            this.via_bot_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 8) != 0) {
                            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
                            this.reply_to = tLRPC$TL_messageReplyHeader;
                            tLRPC$TL_messageReplyHeader.reply_to_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.message = abstractSerializedData2.readString(z2);
                        if ((this.flags & 512) != 0) {
                            TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            this.media = tLRPC$MessageMediaTLdeserialize;
                            if (tLRPC$MessageMediaTLdeserialize != null) {
                                this.ttl = tLRPC$MessageMediaTLdeserialize.ttl_seconds;
                            }
                            if (tLRPC$MessageMediaTLdeserialize != null && !TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                                this.message = this.media.captionLegacy;
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 128) != 0) {
                            int int322 = abstractSerializedData2.readInt32(z2);
                            if (int322 != 481674261) {
                                if (z2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = abstractSerializedData2.readInt32(z2);
                            for (int i2 = 0; i2 < int323; i2++) {
                                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                                if (tLRPC$MessageEntityTLdeserialize == null) {
                                    return;
                                }
                                this.entities.add(tLRPC$MessageEntityTLdeserialize);
                            }
                        }
                        if ((this.flags & 1024) != 0) {
                            this.views = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.edit_date = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_CHECK) != 0) {
                            this.post_author = abstractSerializedData2.readString(z2);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_REORDER) != 0) {
                            this.grouped_id = abstractSerializedData2.readInt64(z2);
                        }
                        if ((this.flags & 4194304) != 0) {
                            int int324 = abstractSerializedData2.readInt32(z2);
                            if (int324 != 481674261) {
                                if (z2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
                                }
                                return;
                            }
                            int int325 = abstractSerializedData2.readInt32(z2);
                            for (int i3 = 0; i3 < int325; i3++) {
                                TLRPC$TL_restrictionReason tLRPC$TL_restrictionReasonTLdeserialize = TLRPC$TL_restrictionReason.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                                if (tLRPC$TL_restrictionReasonTLdeserialize == null) {
                                    return;
                                }
                                this.restriction_reason.add(tLRPC$TL_restrictionReasonTLdeserialize);
                            }
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.out ? this.flags | 2 : this.flags & (-3);
                        this.flags = i2;
                        int i3 = this.mentioned ? i2 | 16 : i2 & (-17);
                        this.flags = i3;
                        int i4 = this.media_unread ? i3 | 32 : i3 & (-33);
                        this.flags = i4;
                        int i5 = this.silent ? i4 | 8192 : i4 & (-8193);
                        this.flags = i5;
                        int i6 = this.post ? i5 | LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM : i5 & (-16385);
                        this.flags = i6;
                        int i7 = this.from_scheduled ? i6 | MessagesController.UPDATE_MASK_CHAT_MUTE : i6 & (-262145);
                        this.flags = i7;
                        int i8 = this.legacy ? i7 | MessagesController.UPDATE_MASK_CHAT_SHOW_SPAM : i7 & (-524289);
                        this.flags = i8;
                        int i9 = this.edit_hide ? i8 | 2097152 : i8 & (-2097153);
                        this.flags = i9;
                        abstractSerializedData2.writeInt32(i9);
                        abstractSerializedData2.writeInt32((int) this.id);
                        if ((this.flags & 256) != 0) {
                            abstractSerializedData2.writeInt32(this.from_id.user_id);
                        }
                        this.peer_id.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 4) != 0) {
                            this.fwd_from.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 2048) != 0) {
                            abstractSerializedData2.writeInt32(this.via_bot_id);
                        }
                        if ((this.flags & 8) != 0) {
                            abstractSerializedData2.writeInt32((int) this.reply_to.reply_to_msg_id);
                        }
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeString(this.message);
                        if ((this.flags & 512) != 0) {
                            this.media.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 128) != 0) {
                            abstractSerializedData2.writeInt32(481674261);
                            int size = this.entities.size();
                            abstractSerializedData2.writeInt32(size);
                            for (int i10 = 0; i10 < size; i10++) {
                                this.entities.get(i10).serializeToStream(abstractSerializedData2);
                            }
                        }
                        if ((this.flags & 1024) != 0) {
                            abstractSerializedData2.writeInt32(this.views);
                        }
                        if ((this.flags & 32768) != 0) {
                            abstractSerializedData2.writeInt32(this.edit_date);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_CHECK) != 0) {
                            abstractSerializedData2.writeString(this.post_author);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_REORDER) != 0) {
                            abstractSerializedData2.writeInt64(this.grouped_id);
                        }
                        if ((this.flags & 4194304) != 0) {
                            abstractSerializedData2.writeInt32(481674261);
                            int size2 = this.restriction_reason.size();
                            abstractSerializedData2.writeInt32(size2);
                            for (int i11 = 0; i11 < size2; i11++) {
                                this.restriction_reason.get(i11).serializeToStream(abstractSerializedData2);
                            }
                        }
                        writeAttachPath(abstractSerializedData2);
                    }
                };
                break;
            case 1431655928:
                tLRPC$TL_messageEmpty = new TLRPC$TL_message_secret_old();
                break;
            case 1431655929:
                tLRPC$TL_messageEmpty = new TLRPC$TL_message_secret_layer72();
                break;
            case 1431655930:
                tLRPC$TL_messageEmpty = new TLRPC$TL_message_secret();
                break;
            case 1450613171:
                tLRPC$TL_messageEmpty = new TLRPC$TL_message() { // from class: org.rbmain.tgnet.TLRPC$TL_message_old2
                    public static int constructor = 1450613171;

                    @Override // org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2) | 256 | 512;
                        this.flags = int32;
                        this.unread = (int32 & 1) != 0;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.from_id = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = abstractSerializedData2.readInt32(z2);
                        this.peer_id = TLRPC$Peer.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.message = abstractSerializedData2.readString(z2);
                        TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.media = tLRPC$MessageMediaTLdeserialize;
                        if (tLRPC$MessageMediaTLdeserialize == null || TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                            return;
                        }
                        this.message = this.media.captionLegacy;
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.unread ? this.flags | 1 : this.flags & (-2);
                        this.flags = i2;
                        int i3 = this.out ? i2 | 2 : i2 & (-3);
                        this.flags = i3;
                        int i4 = this.mentioned ? i3 | 16 : i3 & (-17);
                        this.flags = i4;
                        int i5 = this.media_unread ? i4 | 32 : i4 & (-33);
                        this.flags = i5;
                        abstractSerializedData2.writeInt32(i5);
                        abstractSerializedData2.writeInt32((int) this.id);
                        abstractSerializedData2.writeInt32(this.from_id.user_id);
                        this.peer_id.serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeString(this.message);
                        this.media.serializeToStream(abstractSerializedData2);
                        writeAttachPath(abstractSerializedData2);
                    }
                };
                break;
            case 1487813065:
                tLRPC$TL_messageEmpty = new TLRPC$TL_message() { // from class: org.rbmain.tgnet.TLRPC$TL_message_layer123
                    public static int constructor = 1487813065;

                    @Override // org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.silent = (int32 & 8192) != 0;
                        this.post = (int32 & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0;
                        this.from_scheduled = (262144 & int32) != 0;
                        this.legacy = (524288 & int32) != 0;
                        this.edit_hide = (2097152 & int32) != 0;
                        this.pinned = (int32 & ConnectionsManager.FileTypePhoto) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        if ((this.flags & 256) != 0) {
                            this.from_id = TLRPC$Peer.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        this.peer_id = TLRPC$Peer.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if ((this.flags & 4) != 0) {
                            this.fwd_from = TLRPC$MessageFwdHeader.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 2048) != 0) {
                            this.via_bot_id = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 8) != 0) {
                            this.reply_to = TLRPC$TL_messageReplyHeader.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.message = abstractSerializedData2.readString(z2);
                        if ((this.flags & 512) != 0) {
                            TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            this.media = tLRPC$MessageMediaTLdeserialize;
                            if (tLRPC$MessageMediaTLdeserialize != null) {
                                this.ttl = tLRPC$MessageMediaTLdeserialize.ttl_seconds;
                            }
                            if (tLRPC$MessageMediaTLdeserialize != null && !TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                                this.message = this.media.captionLegacy;
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 128) != 0) {
                            int int322 = abstractSerializedData2.readInt32(z2);
                            if (int322 != 481674261) {
                                if (z2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = abstractSerializedData2.readInt32(z2);
                            for (int i2 = 0; i2 < int323; i2++) {
                                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                                if (tLRPC$MessageEntityTLdeserialize == null) {
                                    return;
                                }
                                this.entities.add(tLRPC$MessageEntityTLdeserialize);
                            }
                        }
                        if ((this.flags & 1024) != 0) {
                            this.views = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 1024) != 0) {
                            this.forwards = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 8388608) != 0) {
                            this.replies = TLRPC$MessageReplies.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.edit_date = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_CHECK) != 0) {
                            this.post_author = abstractSerializedData2.readString(z2);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_REORDER) != 0) {
                            this.grouped_id = abstractSerializedData2.readInt64(z2);
                        }
                        if ((this.flags & 4194304) != 0) {
                            int int324 = abstractSerializedData2.readInt32(z2);
                            if (int324 != 481674261) {
                                if (z2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
                                }
                                return;
                            }
                            int int325 = abstractSerializedData2.readInt32(z2);
                            for (int i3 = 0; i3 < int325; i3++) {
                                TLRPC$TL_restrictionReason tLRPC$TL_restrictionReasonTLdeserialize = TLRPC$TL_restrictionReason.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                                if (tLRPC$TL_restrictionReasonTLdeserialize == null) {
                                    return;
                                }
                                this.restriction_reason.add(tLRPC$TL_restrictionReasonTLdeserialize);
                            }
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.out ? this.flags | 2 : this.flags & (-3);
                        this.flags = i2;
                        int i3 = this.mentioned ? i2 | 16 : i2 & (-17);
                        this.flags = i3;
                        int i4 = this.media_unread ? i3 | 32 : i3 & (-33);
                        this.flags = i4;
                        int i5 = this.silent ? i4 | 8192 : i4 & (-8193);
                        this.flags = i5;
                        int i6 = this.post ? i5 | LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM : i5 & (-16385);
                        this.flags = i6;
                        int i7 = this.from_scheduled ? i6 | MessagesController.UPDATE_MASK_CHAT_MUTE : i6 & (-262145);
                        this.flags = i7;
                        int i8 = this.legacy ? i7 | MessagesController.UPDATE_MASK_CHAT_SHOW_SPAM : i7 & (-524289);
                        this.flags = i8;
                        int i9 = this.edit_hide ? i8 | 2097152 : i8 & (-2097153);
                        this.flags = i9;
                        int i10 = this.pinned ? i9 | ConnectionsManager.FileTypePhoto : i9 & (-16777217);
                        this.flags = i10;
                        abstractSerializedData2.writeInt32(i10);
                        abstractSerializedData2.writeInt32((int) this.id);
                        if ((this.flags & 256) != 0) {
                            this.from_id.serializeToStream(abstractSerializedData2);
                        }
                        this.peer_id.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 4) != 0) {
                            this.fwd_from.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 2048) != 0) {
                            abstractSerializedData2.writeInt32(this.via_bot_id);
                        }
                        if ((this.flags & 8) != 0) {
                            this.reply_to.serializeToStream(abstractSerializedData2);
                        }
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeString(this.message);
                        if ((this.flags & 512) != 0) {
                            this.media.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 128) != 0) {
                            abstractSerializedData2.writeInt32(481674261);
                            int size = this.entities.size();
                            abstractSerializedData2.writeInt32(size);
                            for (int i11 = 0; i11 < size; i11++) {
                                this.entities.get(i11).serializeToStream(abstractSerializedData2);
                            }
                        }
                        if ((this.flags & 1024) != 0) {
                            abstractSerializedData2.writeInt32(this.views);
                        }
                        if ((this.flags & 1024) != 0) {
                            abstractSerializedData2.writeInt32(this.forwards);
                        }
                        if ((this.flags & 8388608) != 0) {
                            this.replies.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 32768) != 0) {
                            abstractSerializedData2.writeInt32(this.edit_date);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_CHECK) != 0) {
                            abstractSerializedData2.writeString(this.post_author);
                        }
                        if ((this.flags & MessagesController.UPDATE_MASK_REORDER) != 0) {
                            abstractSerializedData2.writeInt64(this.grouped_id);
                        }
                        if ((this.flags & 4194304) != 0) {
                            abstractSerializedData2.writeInt32(481674261);
                            int size2 = this.restriction_reason.size();
                            abstractSerializedData2.writeInt32(size2);
                            for (int i12 = 0; i12 < size2; i12++) {
                                this.restriction_reason.get(i12).serializeToStream(abstractSerializedData2);
                            }
                        }
                        writeAttachPath(abstractSerializedData2);
                    }
                };
                break;
            case 1537633299:
                tLRPC$TL_messageEmpty = new TLRPC$TL_message() { // from class: org.rbmain.tgnet.TLRPC$TL_message_old7
                    public static int constructor = 1537633299;

                    @Override // org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.unread = (int32 & 1) != 0;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.id = abstractSerializedData2.readInt32(z2);
                        if ((this.flags & 256) != 0) {
                            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                            this.from_id = tLRPC$TL_peerUser;
                            tLRPC$TL_peerUser.user_id = abstractSerializedData2.readInt32(z2);
                        }
                        TLRPC$Peer tLRPC$PeerTLdeserialize = TLRPC$Peer.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.peer_id = tLRPC$PeerTLdeserialize;
                        if (this.from_id == null) {
                            this.from_id = tLRPC$PeerTLdeserialize;
                        }
                        if ((this.flags & 4) != 0) {
                            this.fwd_from = new TLRPC$TL_messageFwdHeader();
                            TLRPC$Peer tLRPC$PeerTLdeserialize2 = TLRPC$Peer.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$PeerTLdeserialize2 != null) {
                                TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = this.fwd_from;
                                tLRPC$MessageFwdHeader.from_id = tLRPC$PeerTLdeserialize2;
                                tLRPC$MessageFwdHeader.flags |= 1;
                            }
                            this.fwd_from.date = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 8) != 0) {
                            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
                            this.reply_to = tLRPC$TL_messageReplyHeader;
                            tLRPC$TL_messageReplyHeader.reply_to_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.message = abstractSerializedData2.readString(z2);
                        if ((this.flags & 512) != 0) {
                            TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            this.media = tLRPC$MessageMediaTLdeserialize;
                            if (tLRPC$MessageMediaTLdeserialize != null && !TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                                this.message = this.media.captionLegacy;
                            }
                        } else {
                            this.media = new TLRPC$TL_messageMediaEmpty();
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 128) != 0) {
                            int int322 = abstractSerializedData2.readInt32(z2);
                            if (int322 != 481674261) {
                                if (z2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = abstractSerializedData2.readInt32(z2);
                            for (int i2 = 0; i2 < int323; i2++) {
                                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                                if (tLRPC$MessageEntityTLdeserialize == null) {
                                    return;
                                }
                                this.entities.add(tLRPC$MessageEntityTLdeserialize);
                            }
                        }
                        if ((this.flags & 1024) != 0) {
                            this.views = abstractSerializedData2.readInt32(z2);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.unread ? this.flags | 1 : this.flags & (-2);
                        this.flags = i2;
                        int i3 = this.out ? i2 | 2 : i2 & (-3);
                        this.flags = i3;
                        int i4 = this.mentioned ? i3 | 16 : i3 & (-17);
                        this.flags = i4;
                        int i5 = this.media_unread ? i4 | 32 : i4 & (-33);
                        this.flags = i5;
                        abstractSerializedData2.writeInt32(i5);
                        abstractSerializedData2.writeInt32((int) this.id);
                        if ((this.flags & 256) != 0) {
                            abstractSerializedData2.writeInt32(this.from_id.user_id);
                        }
                        this.peer_id.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 4) != 0) {
                            TLRPC$Peer tLRPC$Peer = this.fwd_from.from_id;
                            if (tLRPC$Peer != null) {
                                tLRPC$Peer.serializeToStream(abstractSerializedData2);
                            }
                            abstractSerializedData2.writeInt32(this.fwd_from.date);
                        }
                        if ((this.flags & 8) != 0) {
                            abstractSerializedData2.writeInt32((int) this.reply_to.reply_to_msg_id);
                        }
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeString(this.message);
                        if ((this.flags & 512) != 0) {
                            this.media.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 128) != 0) {
                            abstractSerializedData2.writeInt32(481674261);
                            int size = this.entities.size();
                            abstractSerializedData2.writeInt32(size);
                            for (int i6 = 0; i6 < size; i6++) {
                                this.entities.get(i6).serializeToStream(abstractSerializedData2);
                            }
                        }
                        if ((this.flags & 1024) != 0) {
                            abstractSerializedData2.writeInt32(this.views);
                        }
                        writeAttachPath(abstractSerializedData2);
                    }
                };
                break;
            default:
                tLRPC$TL_messageEmpty = null;
                break;
        }
        if (tLRPC$TL_messageEmpty == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in Message", Integer.valueOf(i)));
        }
        if (tLRPC$TL_messageEmpty != null) {
            tLRPC$TL_messageEmpty.readParams(abstractSerializedData, z);
            if (tLRPC$TL_messageEmpty.from_id == null) {
                tLRPC$TL_messageEmpty.from_id = tLRPC$TL_messageEmpty.peer_id;
            }
        }
        return tLRPC$TL_messageEmpty;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void readAttachPath(org.rbmain.tgnet.AbstractSerializedData r11, int r12) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.tgnet.TLRPC$Message.readAttachPath(org.rbmain.tgnet.AbstractSerializedData, int):void");
    }

    protected void writeAttachPath(AbstractSerializedData abstractSerializedData) {
        HashMap<String, String> map;
        HashMap<String, String> map2;
        if ((this instanceof TLRPC$TL_message_secret) || (this instanceof TLRPC$TL_message_secret_layer72)) {
            String str = this.attachPath;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            if (this.send_state == 1 && (map = this.params) != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : this.params.entrySet()) {
                    str = entry.getKey() + "|=|" + entry.getValue() + "||" + str;
                }
                str = "||" + str;
            }
            abstractSerializedData.writeString(str);
            return;
        }
        String str2 = !TextUtils.isEmpty(this.attachPath) ? this.attachPath : " ";
        if (this.legacy) {
            if (this.params == null) {
                this.params = new HashMap<>();
            }
            this.layer = 127;
            this.params.put("legacy_layer", "127");
        }
        if ((this.id < 0 || this.send_state == 3 || this.legacy) && (map2 = this.params) != null && map2.size() > 0) {
            for (Map.Entry<String, String> entry2 : this.params.entrySet()) {
                str2 = entry2.getKey() + "|=|" + entry2.getValue() + "||" + str2;
            }
            str2 = "||" + str2;
        }
        abstractSerializedData.writeString(str2);
        if ((this.flags & 4) == 0 || this.id >= 0) {
            return;
        }
        abstractSerializedData.writeInt32((int) this.fwd_msg_id);
    }
}
