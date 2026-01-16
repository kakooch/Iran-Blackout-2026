package org.rbmain.tgnet;

import org.rbmain.messenger.LiteMode;
import org.rbmain.messenger.MessagesController;

/* loaded from: classes4.dex */
public class TLRPC$TL_user extends TLRPC$User {
    public static int constructor = -1820043071;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.self = (int32 & 1024) != 0;
        this.contact = (int32 & 2048) != 0;
        this.mutual_contact = (int32 & 4096) != 0;
        this.deleted = (int32 & 8192) != 0;
        this.bot = (int32 & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0;
        this.bot_chat_history = (32768 & int32) != 0;
        this.bot_nochats = (65536 & int32) != 0;
        this.verified = (131072 & int32) != 0;
        this.restricted = (int32 & MessagesController.UPDATE_MASK_CHAT_MUTE) != 0;
        this.min = (1048576 & int32) != 0;
        this.bot_inline_geo = (2097152 & int32) != 0;
        this.support = (8388608 & int32) != 0;
        this.scam = (16777216 & int32) != 0;
        this.apply_min_photo = (33554432 & int32) != 0;
        this.fake = (int32 & ConnectionsManager.FileTypeFile) != 0;
        this.id = abstractSerializedData.readInt32(z);
        if ((this.flags & 1) != 0) {
            this.access_hash = abstractSerializedData.readInt64(z);
        }
        if ((this.flags & 2) != 0) {
            this.first_name = abstractSerializedData.readString(z);
        }
        if ((this.flags & 4) != 0) {
            this.last_name = abstractSerializedData.readString(z);
        }
        if ((this.flags & 8) != 0) {
            this.username = abstractSerializedData.readString(z);
        }
        if ((this.flags & 16) != 0) {
            this.phone = abstractSerializedData.readString(z);
        }
        if ((this.flags & 32) != 0) {
            this.photo = TLRPC$UserProfilePhoto.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
        if ((this.flags & 64) != 0) {
            this.status = TLRPC$UserStatus.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
        if ((this.flags & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0) {
            this.bot_info_version = abstractSerializedData.readInt32(z);
        }
        if ((this.flags & MessagesController.UPDATE_MASK_CHAT_MUTE) != 0) {
            int int322 = abstractSerializedData.readInt32(z);
            if (int322 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                }
                return;
            }
            int int323 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < int323; i++) {
                TLRPC$TL_restrictionReason tLRPC$TL_restrictionReasonTLdeserialize = TLRPC$TL_restrictionReason.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (tLRPC$TL_restrictionReasonTLdeserialize == null) {
                    return;
                }
                this.restriction_reason.add(tLRPC$TL_restrictionReasonTLdeserialize);
            }
        }
        if ((this.flags & MessagesController.UPDATE_MASK_CHAT_SHOW_SPAM) != 0) {
            this.bot_inline_placeholder = abstractSerializedData.readString(z);
        }
        if ((this.flags & 4194304) != 0) {
            this.lang_code = abstractSerializedData.readString(z);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.self ? this.flags | 1024 : this.flags & (-1025);
        this.flags = i;
        int i2 = this.contact ? i | 2048 : i & (-2049);
        this.flags = i2;
        int i3 = this.mutual_contact ? i2 | 4096 : i2 & (-4097);
        this.flags = i3;
        int i4 = this.deleted ? i3 | 8192 : i3 & (-8193);
        this.flags = i4;
        int i5 = this.bot ? i4 | LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM : i4 & (-16385);
        this.flags = i5;
        int i6 = this.bot_chat_history ? i5 | 32768 : i5 & (-32769);
        this.flags = i6;
        int i7 = this.bot_nochats ? i6 | MessagesController.UPDATE_MASK_CHECK : i6 & (-65537);
        this.flags = i7;
        int i8 = this.verified ? i7 | MessagesController.UPDATE_MASK_REORDER : i7 & (-131073);
        this.flags = i8;
        int i9 = this.restricted ? i8 | MessagesController.UPDATE_MASK_CHAT_MUTE : i8 & (-262145);
        this.flags = i9;
        int i10 = this.min ? i9 | 1048576 : i9 & (-1048577);
        this.flags = i10;
        int i11 = this.bot_inline_geo ? i10 | 2097152 : i10 & (-2097153);
        this.flags = i11;
        int i12 = this.support ? i11 | 8388608 : i11 & (-8388609);
        this.flags = i12;
        int i13 = this.scam ? i12 | ConnectionsManager.FileTypePhoto : i12 & (-16777217);
        this.flags = i13;
        int i14 = this.apply_min_photo ? i13 | ConnectionsManager.FileTypeVideo : i13 & (-33554433);
        this.flags = i14;
        int i15 = this.fake ? i14 | ConnectionsManager.FileTypeFile : i14 & (-67108865);
        this.flags = i15;
        abstractSerializedData.writeInt32(i15);
        abstractSerializedData.writeInt32(this.id);
        if ((this.flags & 1) != 0) {
            abstractSerializedData.writeInt64(this.access_hash);
        }
        if ((this.flags & 2) != 0) {
            abstractSerializedData.writeString(this.first_name);
        }
        if ((this.flags & 4) != 0) {
            abstractSerializedData.writeString(this.last_name);
        }
        if ((this.flags & 8) != 0) {
            abstractSerializedData.writeString(this.username);
        }
        if ((this.flags & 16) != 0) {
            abstractSerializedData.writeString(this.phone);
        }
        if ((this.flags & 32) != 0) {
            this.photo.serializeToStream(abstractSerializedData);
        }
        if ((this.flags & 64) != 0) {
            this.status.serializeToStream(abstractSerializedData);
        }
        if ((this.flags & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0) {
            abstractSerializedData.writeInt32(this.bot_info_version);
        }
        if ((this.flags & MessagesController.UPDATE_MASK_CHAT_MUTE) != 0) {
            abstractSerializedData.writeInt32(481674261);
            int size = this.restriction_reason.size();
            abstractSerializedData.writeInt32(size);
            for (int i16 = 0; i16 < size; i16++) {
                this.restriction_reason.get(i16).serializeToStream(abstractSerializedData);
            }
        }
        if ((this.flags & MessagesController.UPDATE_MASK_CHAT_SHOW_SPAM) != 0) {
            abstractSerializedData.writeString(this.bot_inline_placeholder);
        }
        if ((this.flags & 4194304) != 0) {
            abstractSerializedData.writeString(this.lang_code);
        }
    }
}
