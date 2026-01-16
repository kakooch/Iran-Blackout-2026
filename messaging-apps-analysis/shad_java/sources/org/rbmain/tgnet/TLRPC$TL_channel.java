package org.rbmain.tgnet;

import org.rbmain.messenger.LiteMode;
import org.rbmain.messenger.MessagesController;

/* loaded from: classes4.dex */
public class TLRPC$TL_channel extends TLRPC$Chat {
    public static int constructor = -753232354;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.creator = (int32 & 1) != 0;
        this.left = (int32 & 4) != 0;
        this.broadcast = (int32 & 32) != 0;
        this.verified = (int32 & 128) != 0;
        this.megagroup = (int32 & 256) != 0;
        this.restricted = (int32 & 512) != 0;
        this.signatures = (int32 & 2048) != 0;
        this.min = (int32 & 4096) != 0;
        this.scam = (524288 & int32) != 0;
        this.has_link = (1048576 & int32) != 0;
        this.has_geo = (2097152 & int32) != 0;
        this.slowmode_enabled = (4194304 & int32) != 0;
        this.call_active = (8388608 & int32) != 0;
        this.call_not_empty = (16777216 & int32) != 0;
        this.fake = (33554432 & int32) != 0;
        this.gigagroup = (int32 & ConnectionsManager.FileTypeFile) != 0;
        this.id = abstractSerializedData.readInt32(z);
        if ((this.flags & 8192) != 0) {
            this.access_hash = abstractSerializedData.readInt64(z);
        }
        this.title = abstractSerializedData.readString(z);
        if ((this.flags & 64) != 0) {
            this.username = abstractSerializedData.readString(z);
        }
        this.photo = TLRPC$ChatPhoto.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.date = abstractSerializedData.readInt32(z);
        this.version = abstractSerializedData.readInt32(z);
        if ((this.flags & 512) != 0) {
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
        if ((this.flags & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0) {
            this.admin_rights = TLRPC$TL_chatAdminRights.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
        if ((this.flags & 32768) != 0) {
            this.banned_rights = TLRPC$TL_chatBannedRights.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
        if ((this.flags & MessagesController.UPDATE_MASK_CHAT_MUTE) != 0) {
            this.default_banned_rights = TLRPC$TL_chatBannedRights.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
        if ((this.flags & MessagesController.UPDATE_MASK_REORDER) != 0) {
            this.participants_count = abstractSerializedData.readInt32(z);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.creator ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.left ? i | 4 : i & (-5);
        this.flags = i2;
        int i3 = this.broadcast ? i2 | 32 : i2 & (-33);
        this.flags = i3;
        int i4 = this.verified ? i3 | 128 : i3 & (-129);
        this.flags = i4;
        int i5 = this.megagroup ? i4 | 256 : i4 & (-257);
        this.flags = i5;
        int i6 = this.restricted ? i5 | 512 : i5 & (-513);
        this.flags = i6;
        int i7 = this.signatures ? i6 | 2048 : i6 & (-2049);
        this.flags = i7;
        int i8 = this.min ? i7 | 4096 : i7 & (-4097);
        this.flags = i8;
        int i9 = this.scam ? i8 | MessagesController.UPDATE_MASK_CHAT_SHOW_SPAM : i8 & (-524289);
        this.flags = i9;
        int i10 = this.has_link ? i9 | 1048576 : i9 & (-1048577);
        this.flags = i10;
        int i11 = this.has_geo ? i10 | 2097152 : i10 & (-2097153);
        this.flags = i11;
        int i12 = this.slowmode_enabled ? i11 | 4194304 : i11 & (-4194305);
        this.flags = i12;
        int i13 = this.call_active ? i12 | 8388608 : i12 & (-8388609);
        this.flags = i13;
        int i14 = this.call_not_empty ? i13 | ConnectionsManager.FileTypePhoto : i13 & (-16777217);
        this.flags = i14;
        int i15 = this.fake ? i14 | ConnectionsManager.FileTypeVideo : i14 & (-33554433);
        this.flags = i15;
        int i16 = this.gigagroup ? i15 | ConnectionsManager.FileTypeFile : i15 & (-67108865);
        this.flags = i16;
        abstractSerializedData.writeInt32(i16);
        abstractSerializedData.writeInt32(this.id);
        if ((this.flags & 8192) != 0) {
            abstractSerializedData.writeInt64(this.access_hash);
        }
        abstractSerializedData.writeString(this.title);
        if ((this.flags & 64) != 0) {
            abstractSerializedData.writeString(this.username);
        }
        this.photo.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(this.date);
        abstractSerializedData.writeInt32(this.version);
        if ((this.flags & 512) != 0) {
            abstractSerializedData.writeInt32(481674261);
            int size = this.restriction_reason.size();
            abstractSerializedData.writeInt32(size);
            for (int i17 = 0; i17 < size; i17++) {
                this.restriction_reason.get(i17).serializeToStream(abstractSerializedData);
            }
        }
        if ((this.flags & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0) {
            this.admin_rights.serializeToStream(abstractSerializedData);
        }
        if ((this.flags & 32768) != 0) {
            this.banned_rights.serializeToStream(abstractSerializedData);
        }
        if ((this.flags & MessagesController.UPDATE_MASK_CHAT_MUTE) != 0) {
            this.default_banned_rights.serializeToStream(abstractSerializedData);
        }
        if ((this.flags & MessagesController.UPDATE_MASK_REORDER) != 0) {
            abstractSerializedData.writeInt32(this.participants_count);
        }
    }
}
