package ir.eitaa.tgnet;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public abstract class TLRPC$Message extends TLObject {
    public TLRPC$MessageAction action;
    public int date;
    public int destroyTime;
    public long dialog_id;
    public int edit_date;
    public boolean edit_hide;
    public int flags;
    public int forwards;
    public TLRPC$Peer from_id;
    public boolean from_scheduled;
    public TLRPC$MessageFwdHeader fwd_from;
    public long grouped_id;
    public int id;
    public boolean isThreadMessage;
    public int layer;
    public boolean legacy;
    public TLRPC$MessageMedia media;
    public boolean media_unread;
    public boolean mentioned;
    public String message;
    public boolean out;
    public HashMap<String, String> params;
    public TLRPC$Peer peer_id;
    public boolean pinned;
    public boolean post;
    public String post_author;
    public long random_id;
    public TLRPC$TL_messageReactions reactions;
    public int realId;
    public TLRPC$MessageReplies replies;
    public TLRPC$Message replyMessage;
    public TLRPC$ReplyMarkup reply_markup;
    public TLRPC$TL_messageReplyHeader reply_to;
    public int reqId;
    public int seq_in;
    public int seq_out;
    public boolean silent;
    public int ttl;
    public int ttl_period;
    public boolean unread;
    public long via_bot_id;
    public String via_bot_name;
    public int views;
    public boolean with_my_score;
    public ArrayList<TLRPC$MessageEntity> entities = new ArrayList<>();
    public ArrayList<TLRPC$TL_restrictionReason> restriction_reason = new ArrayList<>();
    public int send_state = 0;
    public int fwd_msg_id = 0;
    public String attachPath = "";
    public int local_id = 0;
    public int stickerVerified = 1;

    public static TLRPC$Message TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$Message tLRPC$TL_message;
        switch (constructor) {
            case -2082087340:
                tLRPC$TL_message = new TLRPC$TL_messageEmpty() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageEmpty_layer122
                    public static int constructor = -2082087340;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageEmpty, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt32(exception2);
                        this.peer_id = new TLRPC$TL_peerUser();
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageEmpty, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.id);
                    }
                };
                break;
            case -2049520670:
                tLRPC$TL_message = new TLRPC$TL_message();
                break;
            case -1868117372:
                tLRPC$TL_message = new TLRPC$TL_messageEmpty();
                break;
            case -1864508399:
                tLRPC$TL_message = new TLRPC$TL_message() { // from class: ir.eitaa.tgnet.TLRPC$TL_message_layer72
                    public static int constructor = -1864508399;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.silent = (int32 & 8192) != 0;
                        this.post = (int32 & 16384) != 0;
                        this.id = stream2.readInt32(exception2);
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                            this.from_id = tLRPC$TL_peerUser;
                            tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        }
                        this.peer_id = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 4) != 0) {
                            this.fwd_from = TLRPC$MessageFwdHeader.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            this.via_bot_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
                            this.reply_to = tLRPC$TL_messageReplyHeader;
                            tLRPC$TL_messageReplyHeader.reply_to_msg_id = stream2.readInt32(exception2);
                        }
                        this.date = stream2.readInt32(exception2);
                        this.message = stream2.readString(exception2);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            this.media = tLRPC$MessageMediaTLdeserialize;
                            if (tLRPC$MessageMediaTLdeserialize != null) {
                                this.ttl = tLRPC$MessageMediaTLdeserialize.ttl_seconds;
                            }
                            if (tLRPC$MessageMediaTLdeserialize != null && !TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                                this.message = this.media.captionLegacy;
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 128) != 0) {
                            int int322 = stream2.readInt32(exception2);
                            if (int322 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = stream2.readInt32(exception2);
                            for (int i = 0; i < int323; i++) {
                                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$MessageEntityTLdeserialize == null) {
                                    return;
                                }
                                this.entities.add(tLRPC$MessageEntityTLdeserialize);
                            }
                        }
                        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                            this.views = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.edit_date = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 65536) != 0) {
                            this.post_author = stream2.readString(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.out ? this.flags | 2 : this.flags & (-3);
                        this.flags = i;
                        int i2 = this.mentioned ? i | 16 : i & (-17);
                        this.flags = i2;
                        int i3 = this.media_unread ? i2 | 32 : i2 & (-33);
                        this.flags = i3;
                        int i4 = this.silent ? i3 | 8192 : i3 & (-8193);
                        this.flags = i4;
                        int i5 = this.post ? i4 | 16384 : i4 & (-16385);
                        this.flags = i5;
                        stream2.writeInt32(i5);
                        stream2.writeInt32(this.id);
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            stream2.writeInt32((int) this.from_id.user_id);
                        }
                        this.peer_id.serializeToStream(stream2);
                        if ((this.flags & 4) != 0) {
                            this.fwd_from.serializeToStream(stream2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            stream2.writeInt32((int) this.via_bot_id);
                        }
                        if ((this.flags & 8) != 0) {
                            stream2.writeInt32(this.reply_to.reply_to_msg_id);
                        }
                        stream2.writeInt32(this.date);
                        stream2.writeString(this.message);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            this.media.serializeToStream(stream2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup.serializeToStream(stream2);
                        }
                        if ((this.flags & 128) != 0) {
                            stream2.writeInt32(481674261);
                            int size = this.entities.size();
                            stream2.writeInt32(size);
                            for (int i6 = 0; i6 < size; i6++) {
                                this.entities.get(i6).serializeToStream(stream2);
                            }
                        }
                        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                            stream2.writeInt32(this.views);
                        }
                        if ((this.flags & 32768) != 0) {
                            stream2.writeInt32(this.edit_date);
                        }
                        if ((this.flags & 65536) != 0) {
                            stream2.writeString(this.post_author);
                        }
                        writeAttachPath(stream2);
                    }
                };
                break;
            case -1752573244:
                tLRPC$TL_message = new TLRPC$TL_message() { // from class: ir.eitaa.tgnet.TLRPC$TL_message_layer104_3
                    public static int constructor = -1752573244;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.silent = (int32 & 8192) != 0;
                        this.post = (int32 & 16384) != 0;
                        this.from_scheduled = (262144 & int32) != 0;
                        this.legacy = (524288 & int32) != 0;
                        this.edit_hide = (int32 & 2097152) != 0;
                        this.id = stream2.readInt32(exception2);
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                            this.from_id = tLRPC$TL_peerUser;
                            tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        }
                        this.peer_id = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 4) != 0) {
                            this.fwd_from = TLRPC$MessageFwdHeader.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            this.via_bot_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
                            this.reply_to = tLRPC$TL_messageReplyHeader;
                            tLRPC$TL_messageReplyHeader.reply_to_msg_id = stream2.readInt32(exception2);
                        }
                        this.date = stream2.readInt32(exception2);
                        this.message = stream2.readString(exception2);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            this.media = tLRPC$MessageMediaTLdeserialize;
                            if (tLRPC$MessageMediaTLdeserialize != null) {
                                this.ttl = tLRPC$MessageMediaTLdeserialize.ttl_seconds;
                            }
                            if (tLRPC$MessageMediaTLdeserialize != null && !TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                                this.message = this.media.captionLegacy;
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 128) != 0) {
                            int int322 = stream2.readInt32(exception2);
                            if (int322 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = stream2.readInt32(exception2);
                            for (int i = 0; i < int323; i++) {
                                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$MessageEntityTLdeserialize == null) {
                                    return;
                                }
                                this.entities.add(tLRPC$MessageEntityTLdeserialize);
                            }
                        }
                        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                            this.views = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.edit_date = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 65536) != 0) {
                            this.post_author = stream2.readString(exception2);
                        }
                        if ((this.flags & 131072) != 0) {
                            this.grouped_id = stream2.readInt64(exception2);
                        }
                        if ((this.flags & 1048576) != 0) {
                            this.reactions = TLRPC$TL_messageReactions.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 4194304) != 0) {
                            int int324 = stream2.readInt32(exception2);
                            if (int324 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
                                }
                                return;
                            }
                            int int325 = stream2.readInt32(exception2);
                            for (int i2 = 0; i2 < int325; i2++) {
                                TLRPC$TL_restrictionReason tLRPC$TL_restrictionReasonTLdeserialize = TLRPC$TL_restrictionReason.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$TL_restrictionReasonTLdeserialize == null) {
                                    return;
                                }
                                this.restriction_reason.add(tLRPC$TL_restrictionReasonTLdeserialize);
                            }
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.out ? this.flags | 2 : this.flags & (-3);
                        this.flags = i;
                        int i2 = this.mentioned ? i | 16 : i & (-17);
                        this.flags = i2;
                        int i3 = this.media_unread ? i2 | 32 : i2 & (-33);
                        this.flags = i3;
                        int i4 = this.silent ? i3 | 8192 : i3 & (-8193);
                        this.flags = i4;
                        int i5 = this.post ? i4 | 16384 : i4 & (-16385);
                        this.flags = i5;
                        int i6 = this.from_scheduled ? i5 | 262144 : i5 & (-262145);
                        this.flags = i6;
                        int i7 = this.legacy ? i6 | 524288 : i6 & (-524289);
                        this.flags = i7;
                        int i8 = this.edit_hide ? i7 | 2097152 : i7 & (-2097153);
                        this.flags = i8;
                        stream2.writeInt32(i8);
                        stream2.writeInt32(this.id);
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            stream2.writeInt32((int) this.from_id.user_id);
                        }
                        this.peer_id.serializeToStream(stream2);
                        if ((this.flags & 4) != 0) {
                            this.fwd_from.serializeToStream(stream2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            stream2.writeInt32((int) this.via_bot_id);
                        }
                        if ((this.flags & 8) != 0) {
                            stream2.writeInt32(this.reply_to.reply_to_msg_id);
                        }
                        stream2.writeInt32(this.date);
                        stream2.writeString(this.message);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            this.media.serializeToStream(stream2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup.serializeToStream(stream2);
                        }
                        if ((this.flags & 128) != 0) {
                            stream2.writeInt32(481674261);
                            int size = this.entities.size();
                            stream2.writeInt32(size);
                            for (int i9 = 0; i9 < size; i9++) {
                                this.entities.get(i9).serializeToStream(stream2);
                            }
                        }
                        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                            stream2.writeInt32(this.views);
                        }
                        if ((this.flags & 32768) != 0) {
                            stream2.writeInt32(this.edit_date);
                        }
                        if ((this.flags & 65536) != 0) {
                            stream2.writeString(this.post_author);
                        }
                        if ((this.flags & 131072) != 0) {
                            stream2.writeInt64(this.grouped_id);
                        }
                        if ((this.flags & 1048576) != 0) {
                            this.reactions.serializeToStream(stream2);
                        }
                        if ((this.flags & 4194304) != 0) {
                            stream2.writeInt32(481674261);
                            int size2 = this.restriction_reason.size();
                            stream2.writeInt32(size2);
                            for (int i10 = 0; i10 < size2; i10++) {
                                this.restriction_reason.get(i10).serializeToStream(stream2);
                            }
                        }
                        writeAttachPath(stream2);
                    }
                };
                break;
            case -1642487306:
                tLRPC$TL_message = new TLRPC$TL_messageService() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageService_layer118
                    public static int constructor = -1642487306;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageService, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.unread = (int32 & 1) != 0;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.silent = (int32 & 8192) != 0;
                        this.post = (int32 & 16384) != 0;
                        this.legacy = (int32 & 524288) != 0;
                        this.id = stream2.readInt32(exception2);
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                            this.from_id = tLRPC$TL_peerUser;
                            tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        }
                        this.peer_id = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 8) != 0) {
                            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
                            this.reply_to = tLRPC$TL_messageReplyHeader;
                            tLRPC$TL_messageReplyHeader.reply_to_msg_id = stream2.readInt32(exception2);
                        }
                        this.date = stream2.readInt32(exception2);
                        this.action = TLRPC$MessageAction.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageService, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.unread ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.out ? i | 2 : i & (-3);
                        this.flags = i2;
                        int i3 = this.mentioned ? i2 | 16 : i2 & (-17);
                        this.flags = i3;
                        int i4 = this.media_unread ? i3 | 32 : i3 & (-33);
                        this.flags = i4;
                        int i5 = this.silent ? i4 | 8192 : i4 & (-8193);
                        this.flags = i5;
                        int i6 = this.post ? i5 | 16384 : i5 & (-16385);
                        this.flags = i6;
                        int i7 = this.legacy ? i6 | 524288 : i6 & (-524289);
                        this.flags = i7;
                        stream2.writeInt32(i7);
                        stream2.writeInt32(this.id);
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            stream2.writeInt32((int) this.from_id.user_id);
                        }
                        this.peer_id.serializeToStream(stream2);
                        if ((this.flags & 8) != 0) {
                            stream2.writeInt32(this.reply_to.reply_to_msg_id);
                        }
                        stream2.writeInt32(this.date);
                        this.action.serializeToStream(stream2);
                        writeAttachPath(stream2);
                    }
                };
                break;
            case -1618124613:
                tLRPC$TL_message = new TLRPC$TL_messageService() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageService_old
                    public static int constructor = -1618124613;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageService, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt32(exception2);
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.from_id = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        this.peer_id = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.out = stream2.readBool(exception2);
                        this.unread = stream2.readBool(exception2);
                        this.flags |= Factory.DEVICE_HAS_CRAPPY_OPENSLES;
                        this.date = stream2.readInt32(exception2);
                        this.action = TLRPC$MessageAction.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageService, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.id);
                        stream2.writeInt32((int) this.from_id.user_id);
                        this.peer_id.serializeToStream(stream2);
                        stream2.writeBool(this.out);
                        stream2.writeBool(this.unread);
                        stream2.writeInt32(this.date);
                        this.action.serializeToStream(stream2);
                    }
                };
                break;
            case -1553471722:
                tLRPC$TL_message = new TLRPC$TL_messageForwarded_old2();
                break;
            case -1481959023:
                tLRPC$TL_message = new TLRPC$TL_message() { // from class: ir.eitaa.tgnet.TLRPC$TL_message_old3
                    public static int constructor = -1481959023;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2) | Factory.DEVICE_HAS_CRAPPY_OPENSLES | Factory.DEVICE_USE_ANDROID_CAMCORDER;
                        this.flags = int32;
                        this.unread = (int32 & 1) != 0;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.id = stream2.readInt32(exception2);
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.from_id = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        this.peer_id = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 4) != 0) {
                            TLRPC$TL_messageFwdHeader tLRPC$TL_messageFwdHeader = new TLRPC$TL_messageFwdHeader();
                            this.fwd_from = tLRPC$TL_messageFwdHeader;
                            tLRPC$TL_messageFwdHeader.from_id = new TLRPC$TL_peerUser();
                            this.fwd_from.from_id.user_id = stream2.readInt32(exception2);
                            TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = this.fwd_from;
                            tLRPC$MessageFwdHeader.flags |= 1;
                            tLRPC$MessageFwdHeader.date = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
                            this.reply_to = tLRPC$TL_messageReplyHeader;
                            tLRPC$TL_messageReplyHeader.reply_to_msg_id = stream2.readInt32(exception2);
                        }
                        this.date = stream2.readInt32(exception2);
                        this.message = stream2.readString(exception2);
                        TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.media = tLRPC$MessageMediaTLdeserialize;
                        if (tLRPC$MessageMediaTLdeserialize == null || TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                            return;
                        }
                        this.message = this.media.captionLegacy;
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.unread ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.out ? i | 2 : i & (-3);
                        this.flags = i2;
                        int i3 = this.mentioned ? i2 | 16 : i2 & (-17);
                        this.flags = i3;
                        int i4 = this.media_unread ? i3 | 32 : i3 & (-33);
                        this.flags = i4;
                        stream2.writeInt32(i4);
                        stream2.writeInt32(this.id);
                        stream2.writeInt32((int) this.from_id.user_id);
                        this.peer_id.serializeToStream(stream2);
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32((int) this.fwd_from.from_id.user_id);
                            stream2.writeInt32(this.fwd_from.date);
                        }
                        if ((this.flags & 8) != 0) {
                            stream2.writeInt32(this.reply_to.reply_to_msg_id);
                        }
                        stream2.writeInt32(this.date);
                        stream2.writeString(this.message);
                        this.media.serializeToStream(stream2);
                        writeAttachPath(stream2);
                    }
                };
                break;
            case -1125940270:
                tLRPC$TL_message = new TLRPC$TL_message() { // from class: ir.eitaa.tgnet.TLRPC$TL_message_layer131
                    public static int constructor = -1125940270;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.silent = (int32 & 8192) != 0;
                        this.post = (int32 & 16384) != 0;
                        this.from_scheduled = (262144 & int32) != 0;
                        this.legacy = (524288 & int32) != 0;
                        this.edit_hide = (2097152 & int32) != 0;
                        this.pinned = (int32 & ConnectionsManager.FileTypePhoto) != 0;
                        this.id = stream2.readInt32(exception2);
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.from_id = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        this.peer_id = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 4) != 0) {
                            this.fwd_from = TLRPC$MessageFwdHeader.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            this.via_bot_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            this.reply_to = TLRPC$TL_messageReplyHeader.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        this.date = stream2.readInt32(exception2);
                        this.message = stream2.readString(exception2);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            this.media = tLRPC$MessageMediaTLdeserialize;
                            if (tLRPC$MessageMediaTLdeserialize != null) {
                                this.ttl = tLRPC$MessageMediaTLdeserialize.ttl_seconds;
                            }
                            if (tLRPC$MessageMediaTLdeserialize != null && !TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                                this.message = this.media.captionLegacy;
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 128) != 0) {
                            int int322 = stream2.readInt32(exception2);
                            if (int322 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = stream2.readInt32(exception2);
                            for (int i = 0; i < int323; i++) {
                                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$MessageEntityTLdeserialize == null) {
                                    return;
                                }
                                this.entities.add(tLRPC$MessageEntityTLdeserialize);
                            }
                        }
                        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                            this.views = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                            this.forwards = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8388608) != 0) {
                            this.replies = TLRPC$MessageReplies.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.edit_date = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 65536) != 0) {
                            this.post_author = stream2.readString(exception2);
                        }
                        if ((this.flags & 131072) != 0) {
                            this.grouped_id = stream2.readInt64(exception2);
                        }
                        if ((this.flags & 4194304) != 0) {
                            int int324 = stream2.readInt32(exception2);
                            if (int324 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
                                }
                                return;
                            }
                            int int325 = stream2.readInt32(exception2);
                            for (int i2 = 0; i2 < int325; i2++) {
                                TLRPC$TL_restrictionReason tLRPC$TL_restrictionReasonTLdeserialize = TLRPC$TL_restrictionReason.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$TL_restrictionReasonTLdeserialize == null) {
                                    return;
                                }
                                this.restriction_reason.add(tLRPC$TL_restrictionReasonTLdeserialize);
                            }
                        }
                        if ((this.flags & ConnectionsManager.FileTypeVideo) != 0) {
                            this.ttl_period = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.out ? this.flags | 2 : this.flags & (-3);
                        this.flags = i;
                        int i2 = this.mentioned ? i | 16 : i & (-17);
                        this.flags = i2;
                        int i3 = this.media_unread ? i2 | 32 : i2 & (-33);
                        this.flags = i3;
                        int i4 = this.silent ? i3 | 8192 : i3 & (-8193);
                        this.flags = i4;
                        int i5 = this.post ? i4 | 16384 : i4 & (-16385);
                        this.flags = i5;
                        int i6 = this.from_scheduled ? i5 | 262144 : i5 & (-262145);
                        this.flags = i6;
                        int i7 = this.legacy ? i6 | 524288 : i6 & (-524289);
                        this.flags = i7;
                        int i8 = this.edit_hide ? i7 | 2097152 : i7 & (-2097153);
                        this.flags = i8;
                        int i9 = this.pinned ? i8 | ConnectionsManager.FileTypePhoto : i8 & (-16777217);
                        this.flags = i9;
                        stream2.writeInt32(i9);
                        stream2.writeInt32(this.id);
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.from_id.serializeToStream(stream2);
                        }
                        this.peer_id.serializeToStream(stream2);
                        if ((this.flags & 4) != 0) {
                            this.fwd_from.serializeToStream(stream2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            stream2.writeInt32((int) this.via_bot_id);
                        }
                        if ((this.flags & 8) != 0) {
                            this.reply_to.serializeToStream(stream2);
                        }
                        stream2.writeInt32(this.date);
                        stream2.writeString(this.message);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            this.media.serializeToStream(stream2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup.serializeToStream(stream2);
                        }
                        if ((this.flags & 128) != 0) {
                            stream2.writeInt32(481674261);
                            int size = this.entities.size();
                            stream2.writeInt32(size);
                            for (int i10 = 0; i10 < size; i10++) {
                                this.entities.get(i10).serializeToStream(stream2);
                            }
                        }
                        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                            stream2.writeInt32(this.views);
                        }
                        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                            stream2.writeInt32(this.forwards);
                        }
                        if ((this.flags & 8388608) != 0) {
                            this.replies.serializeToStream(stream2);
                        }
                        if ((this.flags & 32768) != 0) {
                            stream2.writeInt32(this.edit_date);
                        }
                        if ((this.flags & 65536) != 0) {
                            stream2.writeString(this.post_author);
                        }
                        if ((this.flags & 131072) != 0) {
                            stream2.writeInt64(this.grouped_id);
                        }
                        if ((this.flags & 4194304) != 0) {
                            stream2.writeInt32(481674261);
                            int size2 = this.restriction_reason.size();
                            stream2.writeInt32(size2);
                            for (int i11 = 0; i11 < size2; i11++) {
                                this.restriction_reason.get(i11).serializeToStream(stream2);
                            }
                        }
                        if ((this.flags & ConnectionsManager.FileTypeVideo) != 0) {
                            stream2.writeInt32(this.ttl_period);
                        }
                        writeAttachPath(stream2);
                    }
                };
                break;
            case -1066691065:
                tLRPC$TL_message = new TLRPC$TL_messageService() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageService_layer48
                    public static int constructor = -1066691065;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageService, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.unread = (int32 & 1) != 0;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.silent = (int32 & 8192) != 0;
                        this.post = (int32 & 16384) != 0;
                        this.id = stream2.readInt32(exception2);
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                            this.from_id = tLRPC$TL_peerUser;
                            tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        }
                        TLRPC$Peer tLRPC$PeerTLdeserialize = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.peer_id = tLRPC$PeerTLdeserialize;
                        if (this.from_id == null) {
                            this.from_id = tLRPC$PeerTLdeserialize;
                        }
                        this.date = stream2.readInt32(exception2);
                        this.action = TLRPC$MessageAction.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageService, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.unread ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.out ? i | 2 : i & (-3);
                        this.flags = i2;
                        int i3 = this.mentioned ? i2 | 16 : i2 & (-17);
                        this.flags = i3;
                        int i4 = this.media_unread ? i3 | 32 : i3 & (-33);
                        this.flags = i4;
                        int i5 = this.silent ? i4 | 8192 : i4 & (-8193);
                        this.flags = i5;
                        int i6 = this.post ? i5 | 16384 : i5 & (-16385);
                        this.flags = i6;
                        stream2.writeInt32(i6);
                        stream2.writeInt32(this.id);
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            stream2.writeInt32((int) this.from_id.user_id);
                        }
                        this.peer_id.serializeToStream(stream2);
                        stream2.writeInt32(this.date);
                        this.action.serializeToStream(stream2);
                    }
                };
                break;
            case -1063525281:
                tLRPC$TL_message = new TLRPC$TL_message() { // from class: ir.eitaa.tgnet.TLRPC$TL_message_layer68
                    public static int constructor = -1063525281;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.unread = (int32 & 1) != 0;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.silent = (int32 & 8192) != 0;
                        this.post = (int32 & 16384) != 0;
                        this.with_my_score = (int32 & 1073741824) != 0;
                        this.id = stream2.readInt32(exception2);
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                            this.from_id = tLRPC$TL_peerUser;
                            tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        }
                        TLRPC$Peer tLRPC$PeerTLdeserialize = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.peer_id = tLRPC$PeerTLdeserialize;
                        if (this.from_id == null) {
                            this.from_id = tLRPC$PeerTLdeserialize;
                        }
                        if ((this.flags & 4) != 0) {
                            this.fwd_from = TLRPC$MessageFwdHeader.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            this.via_bot_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
                            this.reply_to = tLRPC$TL_messageReplyHeader;
                            tLRPC$TL_messageReplyHeader.reply_to_msg_id = stream2.readInt32(exception2);
                        }
                        this.date = stream2.readInt32(exception2);
                        this.message = stream2.readString(exception2);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            this.media = tLRPC$MessageMediaTLdeserialize;
                            if (tLRPC$MessageMediaTLdeserialize != null && !TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                                this.message = this.media.captionLegacy;
                            }
                        } else {
                            this.media = new TLRPC$TL_messageMediaEmpty();
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 128) != 0) {
                            int int322 = stream2.readInt32(exception2);
                            if (int322 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = stream2.readInt32(exception2);
                            for (int i = 0; i < int323; i++) {
                                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$MessageEntityTLdeserialize == null) {
                                    return;
                                }
                                this.entities.add(tLRPC$MessageEntityTLdeserialize);
                            }
                        }
                        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                            this.views = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.edit_date = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.unread ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.out ? i | 2 : i & (-3);
                        this.flags = i2;
                        int i3 = this.mentioned ? i2 | 16 : i2 & (-17);
                        this.flags = i3;
                        int i4 = this.media_unread ? i3 | 32 : i3 & (-33);
                        this.flags = i4;
                        int i5 = this.silent ? i4 | 8192 : i4 & (-8193);
                        this.flags = i5;
                        int i6 = this.post ? i5 | 16384 : i5 & (-16385);
                        this.flags = i6;
                        int i7 = this.with_my_score ? i6 | 1073741824 : i6 & (-1073741825);
                        this.flags = i7;
                        stream2.writeInt32(i7);
                        stream2.writeInt32(this.id);
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            stream2.writeInt32((int) this.from_id.user_id);
                        }
                        this.peer_id.serializeToStream(stream2);
                        if ((this.flags & 4) != 0) {
                            this.fwd_from.serializeToStream(stream2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            stream2.writeInt32((int) this.via_bot_id);
                        }
                        if ((this.flags & 8) != 0) {
                            stream2.writeInt32(this.reply_to.reply_to_msg_id);
                        }
                        stream2.writeInt32(this.date);
                        stream2.writeString(this.message);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            this.media.serializeToStream(stream2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup.serializeToStream(stream2);
                        }
                        if ((this.flags & 128) != 0) {
                            stream2.writeInt32(481674261);
                            int size = this.entities.size();
                            stream2.writeInt32(size);
                            for (int i8 = 0; i8 < size; i8++) {
                                this.entities.get(i8).serializeToStream(stream2);
                            }
                        }
                        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                            stream2.writeInt32(this.views);
                        }
                        if ((this.flags & 32768) != 0) {
                            stream2.writeInt32(this.edit_date);
                        }
                        writeAttachPath(stream2);
                    }
                };
                break;
            case -1023016155:
                tLRPC$TL_message = new TLRPC$TL_message() { // from class: ir.eitaa.tgnet.TLRPC$TL_message_old4
                    public static int constructor = -1023016155;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2) | Factory.DEVICE_HAS_CRAPPY_OPENSLES | Factory.DEVICE_USE_ANDROID_CAMCORDER;
                        this.flags = int32;
                        this.unread = (int32 & 1) != 0;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.id = stream2.readInt32(exception2);
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.from_id = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        this.peer_id = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 4) != 0) {
                            TLRPC$TL_messageFwdHeader tLRPC$TL_messageFwdHeader = new TLRPC$TL_messageFwdHeader();
                            this.fwd_from = tLRPC$TL_messageFwdHeader;
                            tLRPC$TL_messageFwdHeader.from_id = new TLRPC$TL_peerUser();
                            this.fwd_from.from_id.user_id = stream2.readInt32(exception2);
                            TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = this.fwd_from;
                            tLRPC$MessageFwdHeader.flags |= 1;
                            tLRPC$MessageFwdHeader.date = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
                            this.reply_to = tLRPC$TL_messageReplyHeader;
                            tLRPC$TL_messageReplyHeader.reply_to_msg_id = stream2.readInt32(exception2);
                        }
                        this.date = stream2.readInt32(exception2);
                        this.message = stream2.readString(exception2);
                        TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.media = tLRPC$MessageMediaTLdeserialize;
                        if (tLRPC$MessageMediaTLdeserialize != null && !TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                            this.message = this.media.captionLegacy;
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.unread ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.out ? i | 2 : i & (-3);
                        this.flags = i2;
                        int i3 = this.mentioned ? i2 | 16 : i2 & (-17);
                        this.flags = i3;
                        int i4 = this.media_unread ? i3 | 32 : i3 & (-33);
                        this.flags = i4;
                        stream2.writeInt32(i4);
                        stream2.writeInt32(this.id);
                        stream2.writeInt32((int) this.from_id.user_id);
                        this.peer_id.serializeToStream(stream2);
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32((int) this.fwd_from.from_id.user_id);
                            stream2.writeInt32(this.fwd_from.date);
                        }
                        if ((this.flags & 8) != 0) {
                            stream2.writeInt32(this.reply_to.reply_to_msg_id);
                        }
                        stream2.writeInt32(this.date);
                        stream2.writeString(this.message);
                        this.media.serializeToStream(stream2);
                        if ((this.flags & 64) != 0) {
                            this.reply_markup.serializeToStream(stream2);
                        }
                        writeAttachPath(stream2);
                    }
                };
                break;
            case -913120932:
                tLRPC$TL_message = new TLRPC$TL_message() { // from class: ir.eitaa.tgnet.TLRPC$TL_message_layer47
                    public static int constructor = -913120932;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.unread = (int32 & 1) != 0;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.id = stream2.readInt32(exception2);
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                            this.from_id = tLRPC$TL_peerUser;
                            tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        }
                        TLRPC$Peer tLRPC$PeerTLdeserialize = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.peer_id = tLRPC$PeerTLdeserialize;
                        if (this.from_id == null) {
                            this.from_id = tLRPC$PeerTLdeserialize;
                        }
                        if ((this.flags & 4) != 0) {
                            this.fwd_from = new TLRPC$TL_messageFwdHeader();
                            TLRPC$Peer tLRPC$PeerTLdeserialize2 = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$PeerTLdeserialize2 != null) {
                                TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = this.fwd_from;
                                tLRPC$MessageFwdHeader.from_id = tLRPC$PeerTLdeserialize2;
                                tLRPC$MessageFwdHeader.flags |= 1;
                            }
                            this.fwd_from.date = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            this.via_bot_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
                            this.reply_to = tLRPC$TL_messageReplyHeader;
                            tLRPC$TL_messageReplyHeader.reply_to_msg_id = stream2.readInt32(exception2);
                        }
                        this.date = stream2.readInt32(exception2);
                        this.message = stream2.readString(exception2);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            this.media = tLRPC$MessageMediaTLdeserialize;
                            if (tLRPC$MessageMediaTLdeserialize != null && !TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                                this.message = this.media.captionLegacy;
                            }
                        } else {
                            this.media = new TLRPC$TL_messageMediaEmpty();
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 128) != 0) {
                            int int322 = stream2.readInt32(exception2);
                            if (int322 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = stream2.readInt32(exception2);
                            for (int i = 0; i < int323; i++) {
                                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$MessageEntityTLdeserialize == null) {
                                    return;
                                }
                                this.entities.add(tLRPC$MessageEntityTLdeserialize);
                            }
                        }
                        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                            this.views = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.unread ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.out ? i | 2 : i & (-3);
                        this.flags = i2;
                        int i3 = this.mentioned ? i2 | 16 : i2 & (-17);
                        this.flags = i3;
                        int i4 = this.media_unread ? i3 | 32 : i3 & (-33);
                        this.flags = i4;
                        stream2.writeInt32(i4);
                        stream2.writeInt32(this.id);
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            stream2.writeInt32((int) this.from_id.user_id);
                        }
                        this.peer_id.serializeToStream(stream2);
                        if ((this.flags & 4) != 0) {
                            TLRPC$Peer tLRPC$Peer = this.fwd_from.from_id;
                            if (tLRPC$Peer != null) {
                                tLRPC$Peer.serializeToStream(stream2);
                            }
                            stream2.writeInt32(this.fwd_from.date);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            stream2.writeInt32((int) this.via_bot_id);
                        }
                        if ((this.flags & 8) != 0) {
                            stream2.writeInt32(this.reply_to.reply_to_msg_id);
                        }
                        stream2.writeInt32(this.date);
                        stream2.writeString(this.message);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            this.media.serializeToStream(stream2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup.serializeToStream(stream2);
                        }
                        if ((this.flags & 128) != 0) {
                            stream2.writeInt32(481674261);
                            int size = this.entities.size();
                            stream2.writeInt32(size);
                            for (int i5 = 0; i5 < size; i5++) {
                                this.entities.get(i5).serializeToStream(stream2);
                            }
                        }
                        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                            stream2.writeInt32(this.views);
                        }
                        writeAttachPath(stream2);
                    }
                };
                break;
            case -260565816:
                tLRPC$TL_message = new TLRPC$TL_message() { // from class: ir.eitaa.tgnet.TLRPC$TL_message_old5
                    public static int constructor = -260565816;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2) | Factory.DEVICE_HAS_CRAPPY_OPENSLES | Factory.DEVICE_USE_ANDROID_CAMCORDER;
                        this.flags = int32;
                        this.unread = (int32 & 1) != 0;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.id = stream2.readInt32(exception2);
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.from_id = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        this.peer_id = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 4) != 0) {
                            TLRPC$TL_messageFwdHeader tLRPC$TL_messageFwdHeader = new TLRPC$TL_messageFwdHeader();
                            this.fwd_from = tLRPC$TL_messageFwdHeader;
                            tLRPC$TL_messageFwdHeader.from_id = new TLRPC$TL_peerUser();
                            this.fwd_from.from_id.user_id = stream2.readInt32(exception2);
                            TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = this.fwd_from;
                            tLRPC$MessageFwdHeader.flags |= 1;
                            tLRPC$MessageFwdHeader.date = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
                            this.reply_to = tLRPC$TL_messageReplyHeader;
                            tLRPC$TL_messageReplyHeader.reply_to_msg_id = stream2.readInt32(exception2);
                        }
                        this.date = stream2.readInt32(exception2);
                        this.message = stream2.readString(exception2);
                        TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.media = tLRPC$MessageMediaTLdeserialize;
                        if (tLRPC$MessageMediaTLdeserialize != null && !TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                            this.message = this.media.captionLegacy;
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 128) != 0) {
                            int int322 = stream2.readInt32(exception2);
                            if (int322 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = stream2.readInt32(exception2);
                            for (int i = 0; i < int323; i++) {
                                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$MessageEntityTLdeserialize == null) {
                                    return;
                                }
                                this.entities.add(tLRPC$MessageEntityTLdeserialize);
                            }
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.unread ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.out ? i | 2 : i & (-3);
                        this.flags = i2;
                        int i3 = this.mentioned ? i2 | 16 : i2 & (-17);
                        this.flags = i3;
                        int i4 = this.media_unread ? i3 | 32 : i3 & (-33);
                        this.flags = i4;
                        stream2.writeInt32(i4);
                        stream2.writeInt32(this.id);
                        stream2.writeInt32((int) this.from_id.user_id);
                        this.peer_id.serializeToStream(stream2);
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32((int) this.fwd_from.from_id.user_id);
                            stream2.writeInt32(this.fwd_from.date);
                        }
                        if ((this.flags & 8) != 0) {
                            stream2.writeInt32(this.reply_to.reply_to_msg_id);
                        }
                        stream2.writeInt32(this.date);
                        stream2.writeString(this.message);
                        this.media.serializeToStream(stream2);
                        if ((this.flags & 64) != 0) {
                            this.reply_markup.serializeToStream(stream2);
                        }
                        if ((this.flags & 128) != 0) {
                            stream2.writeInt32(481674261);
                            int size = this.entities.size();
                            stream2.writeInt32(size);
                            for (int i5 = 0; i5 < size; i5++) {
                                this.entities.get(i5).serializeToStream(stream2);
                            }
                        }
                        writeAttachPath(stream2);
                    }
                };
                break;
            case -181507201:
                tLRPC$TL_message = new TLRPC$TL_message() { // from class: ir.eitaa.tgnet.TLRPC$TL_message_layer118
                    public static int constructor = -181507201;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.silent = (int32 & 8192) != 0;
                        this.post = (int32 & 16384) != 0;
                        this.from_scheduled = (262144 & int32) != 0;
                        this.legacy = (524288 & int32) != 0;
                        this.edit_hide = (int32 & 2097152) != 0;
                        this.id = stream2.readInt32(exception2);
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                            this.from_id = tLRPC$TL_peerUser;
                            tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        }
                        this.peer_id = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 4) != 0) {
                            this.fwd_from = TLRPC$MessageFwdHeader.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            this.via_bot_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
                            this.reply_to = tLRPC$TL_messageReplyHeader;
                            tLRPC$TL_messageReplyHeader.reply_to_msg_id = stream2.readInt32(exception2);
                        }
                        this.date = stream2.readInt32(exception2);
                        this.message = stream2.readString(exception2);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            this.media = tLRPC$MessageMediaTLdeserialize;
                            if (tLRPC$MessageMediaTLdeserialize != null) {
                                this.ttl = tLRPC$MessageMediaTLdeserialize.ttl_seconds;
                            }
                            if (tLRPC$MessageMediaTLdeserialize != null && !TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                                this.message = this.media.captionLegacy;
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 128) != 0) {
                            int int322 = stream2.readInt32(exception2);
                            if (int322 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = stream2.readInt32(exception2);
                            for (int i = 0; i < int323; i++) {
                                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$MessageEntityTLdeserialize == null) {
                                    return;
                                }
                                this.entities.add(tLRPC$MessageEntityTLdeserialize);
                            }
                        }
                        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                            this.views = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                            this.forwards = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.edit_date = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 65536) != 0) {
                            this.post_author = stream2.readString(exception2);
                        }
                        if ((this.flags & 131072) != 0) {
                            this.grouped_id = stream2.readInt64(exception2);
                        }
                        if ((this.flags & 4194304) != 0) {
                            int int324 = stream2.readInt32(exception2);
                            if (int324 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
                                }
                                return;
                            }
                            int int325 = stream2.readInt32(exception2);
                            for (int i2 = 0; i2 < int325; i2++) {
                                TLRPC$TL_restrictionReason tLRPC$TL_restrictionReasonTLdeserialize = TLRPC$TL_restrictionReason.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$TL_restrictionReasonTLdeserialize == null) {
                                    return;
                                }
                                this.restriction_reason.add(tLRPC$TL_restrictionReasonTLdeserialize);
                            }
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.out ? this.flags | 2 : this.flags & (-3);
                        this.flags = i;
                        int i2 = this.mentioned ? i | 16 : i & (-17);
                        this.flags = i2;
                        int i3 = this.media_unread ? i2 | 32 : i2 & (-33);
                        this.flags = i3;
                        int i4 = this.silent ? i3 | 8192 : i3 & (-8193);
                        this.flags = i4;
                        int i5 = this.post ? i4 | 16384 : i4 & (-16385);
                        this.flags = i5;
                        int i6 = this.from_scheduled ? i5 | 262144 : i5 & (-262145);
                        this.flags = i6;
                        int i7 = this.legacy ? i6 | 524288 : i6 & (-524289);
                        this.flags = i7;
                        int i8 = this.edit_hide ? i7 | 2097152 : i7 & (-2097153);
                        this.flags = i8;
                        stream2.writeInt32(i8);
                        stream2.writeInt32(this.id);
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            stream2.writeInt32((int) this.from_id.user_id);
                        }
                        this.peer_id.serializeToStream(stream2);
                        if ((this.flags & 4) != 0) {
                            this.fwd_from.serializeToStream(stream2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            stream2.writeInt32((int) this.via_bot_id);
                        }
                        if ((this.flags & 8) != 0) {
                            stream2.writeInt32(this.reply_to.reply_to_msg_id);
                        }
                        stream2.writeInt32(this.date);
                        stream2.writeString(this.message);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            this.media.serializeToStream(stream2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup.serializeToStream(stream2);
                        }
                        if ((this.flags & 128) != 0) {
                            stream2.writeInt32(481674261);
                            int size = this.entities.size();
                            stream2.writeInt32(size);
                            for (int i9 = 0; i9 < size; i9++) {
                                this.entities.get(i9).serializeToStream(stream2);
                            }
                        }
                        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                            stream2.writeInt32(this.views);
                        }
                        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                            stream2.writeInt32(this.forwards);
                        }
                        if ((this.flags & 32768) != 0) {
                            stream2.writeInt32(this.edit_date);
                        }
                        if ((this.flags & 65536) != 0) {
                            stream2.writeString(this.post_author);
                        }
                        if ((this.flags & 131072) != 0) {
                            stream2.writeInt64(this.grouped_id);
                        }
                        if ((this.flags & 4194304) != 0) {
                            stream2.writeInt32(481674261);
                            int size2 = this.restriction_reason.size();
                            stream2.writeInt32(size2);
                            for (int i10 = 0; i10 < size2; i10++) {
                                this.restriction_reason.get(i10).serializeToStream(stream2);
                            }
                        }
                        writeAttachPath(stream2);
                    }
                };
                break;
            case 99903492:
                tLRPC$TL_message = new TLRPC$TL_messageForwarded_old2() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageForwarded_old
                    public static int constructor = 99903492;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageForwarded_old2, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt32(exception2);
                        TLRPC$TL_messageFwdHeader tLRPC$TL_messageFwdHeader = new TLRPC$TL_messageFwdHeader();
                        this.fwd_from = tLRPC$TL_messageFwdHeader;
                        tLRPC$TL_messageFwdHeader.from_id = new TLRPC$TL_peerUser();
                        this.fwd_from.from_id.user_id = stream2.readInt32(exception2);
                        TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = this.fwd_from;
                        tLRPC$MessageFwdHeader.flags |= 1;
                        tLRPC$MessageFwdHeader.date = stream2.readInt32(exception2);
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.from_id = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        this.peer_id = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.out = stream2.readBool(exception2);
                        this.unread = stream2.readBool(exception2);
                        this.flags |= 772;
                        this.date = stream2.readInt32(exception2);
                        this.message = stream2.readString(exception2);
                        TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.media = tLRPC$MessageMediaTLdeserialize;
                        if (tLRPC$MessageMediaTLdeserialize == null || TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                            return;
                        }
                        this.message = this.media.captionLegacy;
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageForwarded_old2, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.id);
                        stream2.writeInt32((int) this.fwd_from.from_id.user_id);
                        stream2.writeInt32(this.fwd_from.date);
                        stream2.writeInt32((int) this.from_id.user_id);
                        this.peer_id.serializeToStream(stream2);
                        stream2.writeBool(this.out);
                        stream2.writeBool(this.unread);
                        stream2.writeInt32(this.date);
                        stream2.writeString(this.message);
                        this.media.serializeToStream(stream2);
                        writeAttachPath(stream2);
                    }
                };
                break;
            case 479924263:
                tLRPC$TL_message = new TLRPC$TL_message() { // from class: ir.eitaa.tgnet.TLRPC$TL_message_layer104_2
                    public static int constructor = 479924263;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.silent = (int32 & 8192) != 0;
                        this.post = (int32 & 16384) != 0;
                        this.from_scheduled = (262144 & int32) != 0;
                        this.legacy = (524288 & int32) != 0;
                        this.edit_hide = (int32 & 2097152) != 0;
                        this.id = stream2.readInt32(exception2);
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                            this.from_id = tLRPC$TL_peerUser;
                            tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        }
                        this.peer_id = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 4) != 0) {
                            this.fwd_from = TLRPC$MessageFwdHeader.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            this.via_bot_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
                            this.reply_to = tLRPC$TL_messageReplyHeader;
                            tLRPC$TL_messageReplyHeader.reply_to_msg_id = stream2.readInt32(exception2);
                        }
                        this.date = stream2.readInt32(exception2);
                        this.message = stream2.readString(exception2);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            this.media = tLRPC$MessageMediaTLdeserialize;
                            if (tLRPC$MessageMediaTLdeserialize != null) {
                                this.ttl = tLRPC$MessageMediaTLdeserialize.ttl_seconds;
                            }
                            if (tLRPC$MessageMediaTLdeserialize != null && !TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                                this.message = this.media.captionLegacy;
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 128) != 0) {
                            int int322 = stream2.readInt32(exception2);
                            if (int322 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = stream2.readInt32(exception2);
                            for (int i = 0; i < int323; i++) {
                                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$MessageEntityTLdeserialize == null) {
                                    return;
                                }
                                this.entities.add(tLRPC$MessageEntityTLdeserialize);
                            }
                        }
                        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                            this.views = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.edit_date = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 65536) != 0) {
                            this.post_author = stream2.readString(exception2);
                        }
                        if ((this.flags & 131072) != 0) {
                            this.grouped_id = stream2.readInt64(exception2);
                        }
                        if ((this.flags & 1048576) != 0) {
                            this.reactions = TLRPC$TL_messageReactions.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 4194304) != 0) {
                            stream2.readString(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.out ? this.flags | 2 : this.flags & (-3);
                        this.flags = i;
                        int i2 = this.mentioned ? i | 16 : i & (-17);
                        this.flags = i2;
                        int i3 = this.media_unread ? i2 | 32 : i2 & (-33);
                        this.flags = i3;
                        int i4 = this.silent ? i3 | 8192 : i3 & (-8193);
                        this.flags = i4;
                        int i5 = this.post ? i4 | 16384 : i4 & (-16385);
                        this.flags = i5;
                        int i6 = this.from_scheduled ? i5 | 262144 : i5 & (-262145);
                        this.flags = i6;
                        int i7 = this.legacy ? i6 | 524288 : i6 & (-524289);
                        this.flags = i7;
                        int i8 = this.edit_hide ? i7 | 2097152 : i7 & (-2097153);
                        this.flags = i8;
                        stream2.writeInt32(i8);
                        stream2.writeInt32(this.id);
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            stream2.writeInt32((int) this.from_id.user_id);
                        }
                        this.peer_id.serializeToStream(stream2);
                        if ((this.flags & 4) != 0) {
                            this.fwd_from.serializeToStream(stream2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            stream2.writeInt32((int) this.via_bot_id);
                        }
                        if ((this.flags & 8) != 0) {
                            stream2.writeInt32(this.reply_to.reply_to_msg_id);
                        }
                        stream2.writeInt32(this.date);
                        stream2.writeString(this.message);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            this.media.serializeToStream(stream2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup.serializeToStream(stream2);
                        }
                        if ((this.flags & 128) != 0) {
                            stream2.writeInt32(481674261);
                            int size = this.entities.size();
                            stream2.writeInt32(size);
                            for (int i9 = 0; i9 < size; i9++) {
                                this.entities.get(i9).serializeToStream(stream2);
                            }
                        }
                        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                            stream2.writeInt32(this.views);
                        }
                        if ((this.flags & 32768) != 0) {
                            stream2.writeInt32(this.edit_date);
                        }
                        if ((this.flags & 65536) != 0) {
                            stream2.writeString(this.post_author);
                        }
                        if ((this.flags & 131072) != 0) {
                            stream2.writeInt64(this.grouped_id);
                        }
                        if ((this.flags & 1048576) != 0) {
                            this.reactions.serializeToStream(stream2);
                        }
                        if ((this.flags & 4194304) != 0) {
                            stream2.writeString("");
                        }
                        writeAttachPath(stream2);
                    }
                };
                break;
            case 495384334:
                tLRPC$TL_message = new TLRPC$TL_messageService() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageService_old2
                    public static int constructor = 495384334;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageService, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.unread = (int32 & 1) != 0;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.id = stream2.readInt32(exception2);
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.from_id = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        this.peer_id = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.date = stream2.readInt32(exception2);
                        this.action = TLRPC$MessageAction.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.flags |= Factory.DEVICE_HAS_CRAPPY_OPENSLES;
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageService, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.unread ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.out ? i | 2 : i & (-3);
                        this.flags = i2;
                        int i3 = this.mentioned ? i2 | 16 : i2 & (-17);
                        this.flags = i3;
                        int i4 = this.media_unread ? i3 | 32 : i3 & (-33);
                        this.flags = i4;
                        stream2.writeInt32(i4);
                        stream2.writeInt32(this.id);
                        stream2.writeInt32((int) this.from_id.user_id);
                        this.peer_id.serializeToStream(stream2);
                        stream2.writeInt32(this.date);
                        this.action.serializeToStream(stream2);
                    }
                };
                break;
            case 585853626:
                tLRPC$TL_message = new TLRPC$TL_message() { // from class: ir.eitaa.tgnet.TLRPC$TL_message_old
                    public static int constructor = 585853626;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt32(exception2);
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.from_id = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        this.peer_id = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.out = stream2.readBool(exception2);
                        this.unread = stream2.readBool(exception2);
                        this.flags |= 768;
                        this.date = stream2.readInt32(exception2);
                        this.message = stream2.readString(exception2);
                        TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.media = tLRPC$MessageMediaTLdeserialize;
                        if (tLRPC$MessageMediaTLdeserialize == null || TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                            return;
                        }
                        this.message = this.media.captionLegacy;
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.id);
                        stream2.writeInt32((int) this.from_id.user_id);
                        this.peer_id.serializeToStream(stream2);
                        stream2.writeBool(this.out);
                        stream2.writeBool(this.unread);
                        stream2.writeInt32(this.date);
                        stream2.writeString(this.message);
                        this.media.serializeToStream(stream2);
                        writeAttachPath(stream2);
                    }
                };
                break;
            case 678405636:
                tLRPC$TL_message = new TLRPC$TL_messageService() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageService_layer123
                    public static int constructor = 678405636;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageService, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.silent = (int32 & 8192) != 0;
                        this.post = (int32 & 16384) != 0;
                        this.legacy = (int32 & 524288) != 0;
                        this.id = stream2.readInt32(exception2);
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.from_id = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        this.peer_id = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 8) != 0) {
                            this.reply_to = TLRPC$TL_messageReplyHeader.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        this.date = stream2.readInt32(exception2);
                        this.action = TLRPC$MessageAction.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageService, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.out ? this.flags | 2 : this.flags & (-3);
                        this.flags = i;
                        int i2 = this.mentioned ? i | 16 : i & (-17);
                        this.flags = i2;
                        int i3 = this.media_unread ? i2 | 32 : i2 & (-33);
                        this.flags = i3;
                        int i4 = this.silent ? i3 | 8192 : i3 & (-8193);
                        this.flags = i4;
                        int i5 = this.post ? i4 | 16384 : i4 & (-16385);
                        this.flags = i5;
                        int i6 = this.legacy ? i5 | 524288 : i5 & (-524289);
                        this.flags = i6;
                        stream2.writeInt32(i6);
                        stream2.writeInt32(this.id);
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.from_id.serializeToStream(stream2);
                        }
                        this.peer_id.serializeToStream(stream2);
                        if ((this.flags & 8) != 0) {
                            this.reply_to.serializeToStream(stream2);
                        }
                        stream2.writeInt32(this.date);
                        this.action.serializeToStream(stream2);
                        writeAttachPath(stream2);
                    }
                };
                break;
            case 721967202:
                tLRPC$TL_message = new TLRPC$TL_messageService();
                break;
            case 736885382:
                tLRPC$TL_message = new TLRPC$TL_message() { // from class: ir.eitaa.tgnet.TLRPC$TL_message_old6
                    public static int constructor = 736885382;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2) | Factory.DEVICE_HAS_CRAPPY_OPENSLES;
                        this.flags = int32;
                        this.unread = (int32 & 1) != 0;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.id = stream2.readInt32(exception2);
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.from_id = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        this.peer_id = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 4) != 0) {
                            TLRPC$TL_messageFwdHeader tLRPC$TL_messageFwdHeader = new TLRPC$TL_messageFwdHeader();
                            this.fwd_from = tLRPC$TL_messageFwdHeader;
                            tLRPC$TL_messageFwdHeader.from_id = new TLRPC$TL_peerUser();
                            this.fwd_from.from_id.user_id = stream2.readInt32(exception2);
                            TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = this.fwd_from;
                            tLRPC$MessageFwdHeader.flags |= 1;
                            tLRPC$MessageFwdHeader.date = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
                            this.reply_to = tLRPC$TL_messageReplyHeader;
                            tLRPC$TL_messageReplyHeader.reply_to_msg_id = stream2.readInt32(exception2);
                        }
                        this.date = stream2.readInt32(exception2);
                        this.message = stream2.readString(exception2);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            this.media = tLRPC$MessageMediaTLdeserialize;
                            if (tLRPC$MessageMediaTLdeserialize != null && !TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                                this.message = this.media.captionLegacy;
                            }
                        } else {
                            this.media = new TLRPC$TL_messageMediaEmpty();
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 128) != 0) {
                            int int322 = stream2.readInt32(exception2);
                            if (int322 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = stream2.readInt32(exception2);
                            for (int i = 0; i < int323; i++) {
                                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$MessageEntityTLdeserialize == null) {
                                    return;
                                }
                                this.entities.add(tLRPC$MessageEntityTLdeserialize);
                            }
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.unread ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.out ? i | 2 : i & (-3);
                        this.flags = i2;
                        int i3 = this.mentioned ? i2 | 16 : i2 & (-17);
                        this.flags = i3;
                        int i4 = this.media_unread ? i3 | 32 : i3 & (-33);
                        this.flags = i4;
                        stream2.writeInt32(i4);
                        stream2.writeInt32(this.id);
                        stream2.writeInt32((int) this.from_id.user_id);
                        this.peer_id.serializeToStream(stream2);
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32((int) this.fwd_from.from_id.user_id);
                            stream2.writeInt32(this.fwd_from.date);
                        }
                        if ((this.flags & 8) != 0) {
                            stream2.writeInt32(this.reply_to.reply_to_msg_id);
                        }
                        stream2.writeInt32(this.date);
                        stream2.writeString(this.message);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            this.media.serializeToStream(stream2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup.serializeToStream(stream2);
                        }
                        if ((this.flags & 128) != 0) {
                            stream2.writeInt32(481674261);
                            int size = this.entities.size();
                            stream2.writeInt32(size);
                            for (int i5 = 0; i5 < size; i5++) {
                                this.entities.get(i5).serializeToStream(stream2);
                            }
                        }
                        writeAttachPath(stream2);
                    }
                };
                break;
            case 1157215293:
                tLRPC$TL_message = new TLRPC$TL_message() { // from class: ir.eitaa.tgnet.TLRPC$TL_message_layer104
                    public static int constructor = 1157215293;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.silent = (int32 & 8192) != 0;
                        this.post = (int32 & 16384) != 0;
                        this.from_scheduled = (262144 & int32) != 0;
                        this.legacy = (int32 & 524288) != 0;
                        this.id = stream2.readInt32(exception2);
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                            this.from_id = tLRPC$TL_peerUser;
                            tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        }
                        this.peer_id = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 4) != 0) {
                            this.fwd_from = TLRPC$MessageFwdHeader.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            this.via_bot_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
                            this.reply_to = tLRPC$TL_messageReplyHeader;
                            tLRPC$TL_messageReplyHeader.reply_to_msg_id = stream2.readInt32(exception2);
                        }
                        this.date = stream2.readInt32(exception2);
                        this.message = stream2.readString(exception2);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            this.media = tLRPC$MessageMediaTLdeserialize;
                            if (tLRPC$MessageMediaTLdeserialize != null) {
                                this.ttl = tLRPC$MessageMediaTLdeserialize.ttl_seconds;
                            }
                            if (tLRPC$MessageMediaTLdeserialize != null && !TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                                this.message = this.media.captionLegacy;
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 128) != 0) {
                            int int322 = stream2.readInt32(exception2);
                            if (int322 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = stream2.readInt32(exception2);
                            for (int i = 0; i < int323; i++) {
                                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$MessageEntityTLdeserialize == null) {
                                    return;
                                }
                                this.entities.add(tLRPC$MessageEntityTLdeserialize);
                            }
                        }
                        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                            this.views = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.edit_date = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 65536) != 0) {
                            this.post_author = stream2.readString(exception2);
                        }
                        if ((this.flags & 131072) != 0) {
                            this.grouped_id = stream2.readInt64(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.out ? this.flags | 2 : this.flags & (-3);
                        this.flags = i;
                        int i2 = this.mentioned ? i | 16 : i & (-17);
                        this.flags = i2;
                        int i3 = this.media_unread ? i2 | 32 : i2 & (-33);
                        this.flags = i3;
                        int i4 = this.silent ? i3 | 8192 : i3 & (-8193);
                        this.flags = i4;
                        int i5 = this.post ? i4 | 16384 : i4 & (-16385);
                        this.flags = i5;
                        int i6 = this.from_scheduled ? i5 | 262144 : i5 & (-262145);
                        this.flags = i6;
                        int i7 = this.legacy ? i6 | 524288 : i6 & (-524289);
                        this.flags = i7;
                        stream2.writeInt32(i7);
                        stream2.writeInt32(this.id);
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            stream2.writeInt32((int) this.from_id.user_id);
                        }
                        this.peer_id.serializeToStream(stream2);
                        if ((this.flags & 4) != 0) {
                            this.fwd_from.serializeToStream(stream2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            stream2.writeInt32((int) this.via_bot_id);
                        }
                        if ((this.flags & 8) != 0) {
                            stream2.writeInt32(this.reply_to.reply_to_msg_id);
                        }
                        stream2.writeInt32(this.date);
                        stream2.writeString(this.message);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            this.media.serializeToStream(stream2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup.serializeToStream(stream2);
                        }
                        if ((this.flags & 128) != 0) {
                            stream2.writeInt32(481674261);
                            int size = this.entities.size();
                            stream2.writeInt32(size);
                            for (int i8 = 0; i8 < size; i8++) {
                                this.entities.get(i8).serializeToStream(stream2);
                            }
                        }
                        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                            stream2.writeInt32(this.views);
                        }
                        if ((this.flags & 32768) != 0) {
                            stream2.writeInt32(this.edit_date);
                        }
                        if ((this.flags & 65536) != 0) {
                            stream2.writeString(this.post_author);
                        }
                        if ((this.flags & 131072) != 0) {
                            stream2.writeInt64(this.grouped_id);
                        }
                        writeAttachPath(stream2);
                    }
                };
                break;
            case 1160515173:
                tLRPC$TL_message = new TLRPC$TL_message() { // from class: ir.eitaa.tgnet.TLRPC$TL_message_layer117
                    public static int constructor = 1160515173;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.silent = (int32 & 8192) != 0;
                        this.post = (int32 & 16384) != 0;
                        this.from_scheduled = (262144 & int32) != 0;
                        this.legacy = (524288 & int32) != 0;
                        this.edit_hide = (int32 & 2097152) != 0;
                        this.id = stream2.readInt32(exception2);
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                            this.from_id = tLRPC$TL_peerUser;
                            tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        }
                        this.peer_id = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 4) != 0) {
                            this.fwd_from = TLRPC$MessageFwdHeader.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            this.via_bot_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
                            this.reply_to = tLRPC$TL_messageReplyHeader;
                            tLRPC$TL_messageReplyHeader.reply_to_msg_id = stream2.readInt32(exception2);
                        }
                        this.date = stream2.readInt32(exception2);
                        this.message = stream2.readString(exception2);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            this.media = tLRPC$MessageMediaTLdeserialize;
                            if (tLRPC$MessageMediaTLdeserialize != null) {
                                this.ttl = tLRPC$MessageMediaTLdeserialize.ttl_seconds;
                            }
                            if (tLRPC$MessageMediaTLdeserialize != null && !TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                                this.message = this.media.captionLegacy;
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 128) != 0) {
                            int int322 = stream2.readInt32(exception2);
                            if (int322 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = stream2.readInt32(exception2);
                            for (int i = 0; i < int323; i++) {
                                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$MessageEntityTLdeserialize == null) {
                                    return;
                                }
                                this.entities.add(tLRPC$MessageEntityTLdeserialize);
                            }
                        }
                        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                            this.views = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.edit_date = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 65536) != 0) {
                            this.post_author = stream2.readString(exception2);
                        }
                        if ((this.flags & 131072) != 0) {
                            this.grouped_id = stream2.readInt64(exception2);
                        }
                        if ((this.flags & 4194304) != 0) {
                            int int324 = stream2.readInt32(exception2);
                            if (int324 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
                                }
                                return;
                            }
                            int int325 = stream2.readInt32(exception2);
                            for (int i2 = 0; i2 < int325; i2++) {
                                TLRPC$TL_restrictionReason tLRPC$TL_restrictionReasonTLdeserialize = TLRPC$TL_restrictionReason.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$TL_restrictionReasonTLdeserialize == null) {
                                    return;
                                }
                                this.restriction_reason.add(tLRPC$TL_restrictionReasonTLdeserialize);
                            }
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.out ? this.flags | 2 : this.flags & (-3);
                        this.flags = i;
                        int i2 = this.mentioned ? i | 16 : i & (-17);
                        this.flags = i2;
                        int i3 = this.media_unread ? i2 | 32 : i2 & (-33);
                        this.flags = i3;
                        int i4 = this.silent ? i3 | 8192 : i3 & (-8193);
                        this.flags = i4;
                        int i5 = this.post ? i4 | 16384 : i4 & (-16385);
                        this.flags = i5;
                        int i6 = this.from_scheduled ? i5 | 262144 : i5 & (-262145);
                        this.flags = i6;
                        int i7 = this.legacy ? i6 | 524288 : i6 & (-524289);
                        this.flags = i7;
                        int i8 = this.edit_hide ? i7 | 2097152 : i7 & (-2097153);
                        this.flags = i8;
                        stream2.writeInt32(i8);
                        stream2.writeInt32(this.id);
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            stream2.writeInt32((int) this.from_id.user_id);
                        }
                        this.peer_id.serializeToStream(stream2);
                        if ((this.flags & 4) != 0) {
                            this.fwd_from.serializeToStream(stream2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            stream2.writeInt32((int) this.via_bot_id);
                        }
                        if ((this.flags & 8) != 0) {
                            stream2.writeInt32(this.reply_to.reply_to_msg_id);
                        }
                        stream2.writeInt32(this.date);
                        stream2.writeString(this.message);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            this.media.serializeToStream(stream2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup.serializeToStream(stream2);
                        }
                        if ((this.flags & 128) != 0) {
                            stream2.writeInt32(481674261);
                            int size = this.entities.size();
                            stream2.writeInt32(size);
                            for (int i9 = 0; i9 < size; i9++) {
                                this.entities.get(i9).serializeToStream(stream2);
                            }
                        }
                        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                            stream2.writeInt32(this.views);
                        }
                        if ((this.flags & 32768) != 0) {
                            stream2.writeInt32(this.edit_date);
                        }
                        if ((this.flags & 65536) != 0) {
                            stream2.writeString(this.post_author);
                        }
                        if ((this.flags & 131072) != 0) {
                            stream2.writeInt64(this.grouped_id);
                        }
                        if ((this.flags & 4194304) != 0) {
                            stream2.writeInt32(481674261);
                            int size2 = this.restriction_reason.size();
                            stream2.writeInt32(size2);
                            for (int i10 = 0; i10 < size2; i10++) {
                                this.restriction_reason.get(i10).serializeToStream(stream2);
                            }
                        }
                        writeAttachPath(stream2);
                    }
                };
                break;
            case 1431655928:
                tLRPC$TL_message = new TLRPC$TL_message_secret_old();
                break;
            case 1431655929:
                tLRPC$TL_message = new TLRPC$TL_message_secret_layer72();
                break;
            case 1431655930:
                tLRPC$TL_message = new TLRPC$TL_message_secret();
                break;
            case 1450613171:
                tLRPC$TL_message = new TLRPC$TL_message() { // from class: ir.eitaa.tgnet.TLRPC$TL_message_old2
                    public static int constructor = 1450613171;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2) | Factory.DEVICE_HAS_CRAPPY_OPENSLES | Factory.DEVICE_USE_ANDROID_CAMCORDER;
                        this.flags = int32;
                        this.unread = (int32 & 1) != 0;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.id = stream2.readInt32(exception2);
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        this.from_id = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        this.peer_id = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.date = stream2.readInt32(exception2);
                        this.message = stream2.readString(exception2);
                        TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.media = tLRPC$MessageMediaTLdeserialize;
                        if (tLRPC$MessageMediaTLdeserialize == null || TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                            return;
                        }
                        this.message = this.media.captionLegacy;
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.unread ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.out ? i | 2 : i & (-3);
                        this.flags = i2;
                        int i3 = this.mentioned ? i2 | 16 : i2 & (-17);
                        this.flags = i3;
                        int i4 = this.media_unread ? i3 | 32 : i3 & (-33);
                        this.flags = i4;
                        stream2.writeInt32(i4);
                        stream2.writeInt32(this.id);
                        stream2.writeInt32((int) this.from_id.user_id);
                        this.peer_id.serializeToStream(stream2);
                        stream2.writeInt32(this.date);
                        stream2.writeString(this.message);
                        this.media.serializeToStream(stream2);
                        writeAttachPath(stream2);
                    }
                };
                break;
            case 1487813065:
                tLRPC$TL_message = new TLRPC$TL_message() { // from class: ir.eitaa.tgnet.TLRPC$TL_message_layer123
                    public static int constructor = 1487813065;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.silent = (int32 & 8192) != 0;
                        this.post = (int32 & 16384) != 0;
                        this.from_scheduled = (262144 & int32) != 0;
                        this.legacy = (524288 & int32) != 0;
                        this.edit_hide = (2097152 & int32) != 0;
                        this.pinned = (int32 & ConnectionsManager.FileTypePhoto) != 0;
                        this.id = stream2.readInt32(exception2);
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.from_id = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        this.peer_id = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 4) != 0) {
                            this.fwd_from = TLRPC$MessageFwdHeader.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            this.via_bot_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            this.reply_to = TLRPC$TL_messageReplyHeader.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        this.date = stream2.readInt32(exception2);
                        this.message = stream2.readString(exception2);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            this.media = tLRPC$MessageMediaTLdeserialize;
                            if (tLRPC$MessageMediaTLdeserialize != null) {
                                this.ttl = tLRPC$MessageMediaTLdeserialize.ttl_seconds;
                            }
                            if (tLRPC$MessageMediaTLdeserialize != null && !TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                                this.message = this.media.captionLegacy;
                            }
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 128) != 0) {
                            int int322 = stream2.readInt32(exception2);
                            if (int322 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = stream2.readInt32(exception2);
                            for (int i = 0; i < int323; i++) {
                                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$MessageEntityTLdeserialize == null) {
                                    return;
                                }
                                this.entities.add(tLRPC$MessageEntityTLdeserialize);
                            }
                        }
                        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                            this.views = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                            this.forwards = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8388608) != 0) {
                            this.replies = TLRPC$MessageReplies.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.edit_date = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 65536) != 0) {
                            this.post_author = stream2.readString(exception2);
                        }
                        if ((this.flags & 131072) != 0) {
                            this.grouped_id = stream2.readInt64(exception2);
                        }
                        if ((this.flags & 4194304) != 0) {
                            int int324 = stream2.readInt32(exception2);
                            if (int324 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
                                }
                                return;
                            }
                            int int325 = stream2.readInt32(exception2);
                            for (int i2 = 0; i2 < int325; i2++) {
                                TLRPC$TL_restrictionReason tLRPC$TL_restrictionReasonTLdeserialize = TLRPC$TL_restrictionReason.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$TL_restrictionReasonTLdeserialize == null) {
                                    return;
                                }
                                this.restriction_reason.add(tLRPC$TL_restrictionReasonTLdeserialize);
                            }
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.out ? this.flags | 2 : this.flags & (-3);
                        this.flags = i;
                        int i2 = this.mentioned ? i | 16 : i & (-17);
                        this.flags = i2;
                        int i3 = this.media_unread ? i2 | 32 : i2 & (-33);
                        this.flags = i3;
                        int i4 = this.silent ? i3 | 8192 : i3 & (-8193);
                        this.flags = i4;
                        int i5 = this.post ? i4 | 16384 : i4 & (-16385);
                        this.flags = i5;
                        int i6 = this.from_scheduled ? i5 | 262144 : i5 & (-262145);
                        this.flags = i6;
                        int i7 = this.legacy ? i6 | 524288 : i6 & (-524289);
                        this.flags = i7;
                        int i8 = this.edit_hide ? i7 | 2097152 : i7 & (-2097153);
                        this.flags = i8;
                        int i9 = this.pinned ? i8 | ConnectionsManager.FileTypePhoto : i8 & (-16777217);
                        this.flags = i9;
                        stream2.writeInt32(i9);
                        stream2.writeInt32(this.id);
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.from_id.serializeToStream(stream2);
                        }
                        this.peer_id.serializeToStream(stream2);
                        if ((this.flags & 4) != 0) {
                            this.fwd_from.serializeToStream(stream2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            stream2.writeInt32((int) this.via_bot_id);
                        }
                        if ((this.flags & 8) != 0) {
                            this.reply_to.serializeToStream(stream2);
                        }
                        stream2.writeInt32(this.date);
                        stream2.writeString(this.message);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            this.media.serializeToStream(stream2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup.serializeToStream(stream2);
                        }
                        if ((this.flags & 128) != 0) {
                            stream2.writeInt32(481674261);
                            int size = this.entities.size();
                            stream2.writeInt32(size);
                            for (int i10 = 0; i10 < size; i10++) {
                                this.entities.get(i10).serializeToStream(stream2);
                            }
                        }
                        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                            stream2.writeInt32(this.views);
                        }
                        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                            stream2.writeInt32(this.forwards);
                        }
                        if ((this.flags & 8388608) != 0) {
                            this.replies.serializeToStream(stream2);
                        }
                        if ((this.flags & 32768) != 0) {
                            stream2.writeInt32(this.edit_date);
                        }
                        if ((this.flags & 65536) != 0) {
                            stream2.writeString(this.post_author);
                        }
                        if ((this.flags & 131072) != 0) {
                            stream2.writeInt64(this.grouped_id);
                        }
                        if ((this.flags & 4194304) != 0) {
                            stream2.writeInt32(481674261);
                            int size2 = this.restriction_reason.size();
                            stream2.writeInt32(size2);
                            for (int i11 = 0; i11 < size2; i11++) {
                                this.restriction_reason.get(i11).serializeToStream(stream2);
                            }
                        }
                        writeAttachPath(stream2);
                    }
                };
                break;
            case 1537633299:
                tLRPC$TL_message = new TLRPC$TL_message() { // from class: ir.eitaa.tgnet.TLRPC$TL_message_old7
                    public static int constructor = 1537633299;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.unread = (int32 & 1) != 0;
                        this.out = (int32 & 2) != 0;
                        this.mentioned = (int32 & 16) != 0;
                        this.media_unread = (int32 & 32) != 0;
                        this.id = stream2.readInt32(exception2);
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                            this.from_id = tLRPC$TL_peerUser;
                            tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        }
                        TLRPC$Peer tLRPC$PeerTLdeserialize = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.peer_id = tLRPC$PeerTLdeserialize;
                        if (this.from_id == null) {
                            this.from_id = tLRPC$PeerTLdeserialize;
                        }
                        if ((this.flags & 4) != 0) {
                            this.fwd_from = new TLRPC$TL_messageFwdHeader();
                            TLRPC$Peer tLRPC$PeerTLdeserialize2 = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$PeerTLdeserialize2 != null) {
                                TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = this.fwd_from;
                                tLRPC$MessageFwdHeader.from_id = tLRPC$PeerTLdeserialize2;
                                tLRPC$MessageFwdHeader.flags |= 1;
                            }
                            this.fwd_from.date = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
                            this.reply_to = tLRPC$TL_messageReplyHeader;
                            tLRPC$TL_messageReplyHeader.reply_to_msg_id = stream2.readInt32(exception2);
                        }
                        this.date = stream2.readInt32(exception2);
                        this.message = stream2.readString(exception2);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            this.media = tLRPC$MessageMediaTLdeserialize;
                            if (tLRPC$MessageMediaTLdeserialize != null && !TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                                this.message = this.media.captionLegacy;
                            }
                        } else {
                            this.media = new TLRPC$TL_messageMediaEmpty();
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 128) != 0) {
                            int int322 = stream2.readInt32(exception2);
                            if (int322 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = stream2.readInt32(exception2);
                            for (int i = 0; i < int323; i++) {
                                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$MessageEntityTLdeserialize == null) {
                                    return;
                                }
                                this.entities.add(tLRPC$MessageEntityTLdeserialize);
                            }
                        }
                        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                            this.views = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.unread ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.out ? i | 2 : i & (-3);
                        this.flags = i2;
                        int i3 = this.mentioned ? i2 | 16 : i2 & (-17);
                        this.flags = i3;
                        int i4 = this.media_unread ? i3 | 32 : i3 & (-33);
                        this.flags = i4;
                        stream2.writeInt32(i4);
                        stream2.writeInt32(this.id);
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            stream2.writeInt32((int) this.from_id.user_id);
                        }
                        this.peer_id.serializeToStream(stream2);
                        if ((this.flags & 4) != 0) {
                            TLRPC$Peer tLRPC$Peer = this.fwd_from.from_id;
                            if (tLRPC$Peer != null) {
                                tLRPC$Peer.serializeToStream(stream2);
                            }
                            stream2.writeInt32(this.fwd_from.date);
                        }
                        if ((this.flags & 8) != 0) {
                            stream2.writeInt32(this.reply_to.reply_to_msg_id);
                        }
                        stream2.writeInt32(this.date);
                        stream2.writeString(this.message);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            this.media.serializeToStream(stream2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.reply_markup.serializeToStream(stream2);
                        }
                        if ((this.flags & 128) != 0) {
                            stream2.writeInt32(481674261);
                            int size = this.entities.size();
                            stream2.writeInt32(size);
                            for (int i5 = 0; i5 < size; i5++) {
                                this.entities.get(i5).serializeToStream(stream2);
                            }
                        }
                        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                            stream2.writeInt32(this.views);
                        }
                        writeAttachPath(stream2);
                    }
                };
                break;
            default:
                tLRPC$TL_message = null;
                break;
        }
        if (tLRPC$TL_message == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in Message", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_message != null) {
            tLRPC$TL_message.readParams(stream, exception);
            if (tLRPC$TL_message.from_id == null) {
                tLRPC$TL_message.from_id = tLRPC$TL_message.peer_id;
            }
        }
        return tLRPC$TL_message;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void readAttachPath(ir.eitaa.tgnet.AbstractSerializedData r12, long r13) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.tgnet.TLRPC$Message.readAttachPath(ir.eitaa.tgnet.AbstractSerializedData, long):void");
    }

    protected void writeAttachPath(AbstractSerializedData stream) {
        HashMap<String, String> map;
        HashMap<String, String> map2;
        if ((this instanceof TLRPC$TL_message_secret) || (this instanceof TLRPC$TL_message_secret_layer72)) {
            String str = this.attachPath;
            if (str == null) {
                str = "";
            }
            if (this.send_state == 1 && (map = this.params) != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : this.params.entrySet()) {
                    str = entry.getKey() + "|=|" + entry.getValue() + "||" + str;
                }
                str = "||" + str;
            }
            stream.writeString(str);
            return;
        }
        String str2 = !TextUtils.isEmpty(this.attachPath) ? this.attachPath : " ";
        if (this.legacy) {
            if (this.params == null) {
                this.params = new HashMap<>();
            }
            this.layer = 133;
            this.params.put("legacy_layer", "133");
        }
        if ((this.id < 0 || this.send_state == 3 || this.legacy) && (map2 = this.params) != null && map2.size() > 0) {
            for (Map.Entry<String, String> entry2 : this.params.entrySet()) {
                str2 = entry2.getKey() + "|=|" + entry2.getValue() + "||" + str2;
            }
            str2 = "||" + str2;
        }
        stream.writeString(str2);
        if ((this.flags & 4) == 0 || this.id >= 0) {
            return;
        }
        stream.writeInt32(this.fwd_msg_id);
    }
}
