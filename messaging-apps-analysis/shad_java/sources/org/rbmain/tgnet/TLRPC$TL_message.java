package org.rbmain.tgnet;

import android.text.TextUtils;
import org.rbmain.messenger.LiteMode;
import org.rbmain.messenger.MessagesController;

/* loaded from: classes4.dex */
public class TLRPC$TL_message extends TLRPC$Message {
    public static int constructor = -1125940270;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
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
        this.id = abstractSerializedData.readInt32(z);
        if ((this.flags & 256) != 0) {
            this.from_id = TLRPC$Peer.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
        this.peer_id = TLRPC$Peer.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        if ((this.flags & 4) != 0) {
            this.fwd_from = TLRPC$MessageFwdHeader.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
        if ((this.flags & 2048) != 0) {
            this.via_bot_id = abstractSerializedData.readInt32(z);
        }
        if ((this.flags & 8) != 0) {
            this.reply_to = TLRPC$TL_messageReplyHeader.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
        this.date = abstractSerializedData.readInt32(z);
        this.message = abstractSerializedData.readString(z);
        if ((this.flags & 512) != 0) {
            TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            this.media = tLRPC$MessageMediaTLdeserialize;
            if (tLRPC$MessageMediaTLdeserialize != null) {
                this.ttl = tLRPC$MessageMediaTLdeserialize.ttl_seconds;
            }
            if (tLRPC$MessageMediaTLdeserialize != null && !TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                this.message = this.media.captionLegacy;
            }
        }
        if ((this.flags & 64) != 0) {
            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
        if ((this.flags & 128) != 0) {
            int int322 = abstractSerializedData.readInt32(z);
            if (int322 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                }
                return;
            }
            int int323 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < int323; i++) {
                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (tLRPC$MessageEntityTLdeserialize == null) {
                    return;
                }
                this.entities.add(tLRPC$MessageEntityTLdeserialize);
            }
        }
        if ((this.flags & 1024) != 0) {
            this.views = abstractSerializedData.readInt32(z);
        }
        if ((this.flags & 1024) != 0) {
            this.forwards = abstractSerializedData.readInt32(z);
        }
        if ((this.flags & 8388608) != 0) {
            this.replies = TLRPC$MessageReplies.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
        if ((this.flags & 32768) != 0) {
            this.edit_date = abstractSerializedData.readInt32(z);
        }
        if ((this.flags & MessagesController.UPDATE_MASK_CHECK) != 0) {
            this.post_author = abstractSerializedData.readString(z);
        }
        if ((this.flags & MessagesController.UPDATE_MASK_REORDER) != 0) {
            this.grouped_id = abstractSerializedData.readInt64(z);
        }
        if ((this.flags & 4194304) != 0) {
            int int324 = abstractSerializedData.readInt32(z);
            if (int324 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
                }
                return;
            }
            int int325 = abstractSerializedData.readInt32(z);
            for (int i2 = 0; i2 < int325; i2++) {
                TLRPC$TL_restrictionReason tLRPC$TL_restrictionReasonTLdeserialize = TLRPC$TL_restrictionReason.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (tLRPC$TL_restrictionReasonTLdeserialize == null) {
                    return;
                }
                this.restriction_reason.add(tLRPC$TL_restrictionReasonTLdeserialize);
            }
        }
        if ((this.flags & ConnectionsManager.FileTypeVideo) != 0) {
            this.ttl_period = abstractSerializedData.readInt32(z);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        int i;
        String str;
        int i2;
        TLRPC$MessageReplies tLRPC$MessageReplies;
        int i3;
        int i4;
        TLRPC$ReplyMarkup tLRPC$ReplyMarkup;
        TLRPC$MessageMedia tLRPC$MessageMedia;
        TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader;
        int i5;
        TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader;
        TLRPC$Peer tLRPC$Peer;
        abstractSerializedData.writeInt32(constructor);
        int i6 = this.out ? this.flags | 2 : this.flags & (-3);
        this.flags = i6;
        int i7 = this.mentioned ? i6 | 16 : i6 & (-17);
        this.flags = i7;
        int i8 = this.media_unread ? i7 | 32 : i7 & (-33);
        this.flags = i8;
        int i9 = this.silent ? i8 | 8192 : i8 & (-8193);
        this.flags = i9;
        int i10 = this.post ? i9 | LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM : i9 & (-16385);
        this.flags = i10;
        int i11 = this.from_scheduled ? i10 | MessagesController.UPDATE_MASK_CHAT_MUTE : i10 & (-262145);
        this.flags = i11;
        int i12 = this.legacy ? i11 | MessagesController.UPDATE_MASK_CHAT_SHOW_SPAM : i11 & (-524289);
        this.flags = i12;
        int i13 = this.edit_hide ? i12 | 2097152 : i12 & (-2097153);
        this.flags = i13;
        int i14 = this.pinned ? i13 | ConnectionsManager.FileTypePhoto : i13 & (-16777217);
        this.flags = i14;
        abstractSerializedData.writeInt32(i14);
        abstractSerializedData.writeInt32((int) this.id);
        if ((this.flags & 256) != 0 && (tLRPC$Peer = this.from_id) != null) {
            tLRPC$Peer.serializeToStream(abstractSerializedData);
        }
        this.peer_id.serializeToStream(abstractSerializedData);
        if ((this.flags & 4) != 0 && (tLRPC$MessageFwdHeader = this.fwd_from) != null) {
            tLRPC$MessageFwdHeader.serializeToStream(abstractSerializedData);
        }
        if ((this.flags & 2048) != 0 && (i5 = this.via_bot_id) != 0) {
            abstractSerializedData.writeInt32(i5);
        }
        if ((this.flags & 8) != 0 && (tLRPC$TL_messageReplyHeader = this.reply_to) != null) {
            tLRPC$TL_messageReplyHeader.serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(this.date);
        abstractSerializedData.writeString(this.message);
        if ((this.flags & 512) != 0 && (tLRPC$MessageMedia = this.media) != null) {
            tLRPC$MessageMedia.serializeToStream(abstractSerializedData);
        }
        if ((this.flags & 64) != 0 && (tLRPC$ReplyMarkup = this.reply_markup) != null) {
            tLRPC$ReplyMarkup.serializeToStream(abstractSerializedData);
        }
        if ((this.flags & 128) != 0 && this.entities != null) {
            abstractSerializedData.writeInt32(481674261);
            int size = this.entities.size();
            abstractSerializedData.writeInt32(size);
            for (int i15 = 0; i15 < size; i15++) {
                this.entities.get(i15).serializeToStream(abstractSerializedData);
            }
        }
        if ((this.flags & 1024) != 0 && (i4 = this.views) != 0) {
            abstractSerializedData.writeInt32(i4);
        }
        if ((this.flags & 1024) != 0 && (i3 = this.forwards) != 0) {
            abstractSerializedData.writeInt32(i3);
        }
        if ((this.flags & 8388608) != 0 && (tLRPC$MessageReplies = this.replies) != null) {
            tLRPC$MessageReplies.serializeToStream(abstractSerializedData);
        }
        if ((this.flags & 32768) != 0 && (i2 = this.edit_date) != 0) {
            abstractSerializedData.writeInt32(i2);
        }
        if ((this.flags & MessagesController.UPDATE_MASK_CHECK) != 0 && (str = this.post_author) != null) {
            abstractSerializedData.writeString(str);
        }
        if ((this.flags & MessagesController.UPDATE_MASK_REORDER) != 0) {
            long j = this.grouped_id;
            if (j != 0) {
                abstractSerializedData.writeInt64(j);
            }
        }
        if ((this.flags & 4194304) != 0 && this.restriction_reason != null) {
            abstractSerializedData.writeInt32(481674261);
            int size2 = this.restriction_reason.size();
            abstractSerializedData.writeInt32(size2);
            for (int i16 = 0; i16 < size2; i16++) {
                this.restriction_reason.get(i16).serializeToStream(abstractSerializedData);
            }
        }
        if ((this.flags & ConnectionsManager.FileTypeVideo) != 0 && (i = this.ttl_period) != 0) {
            abstractSerializedData.writeInt32(i);
        }
        writeAttachPath(abstractSerializedData);
    }
}
