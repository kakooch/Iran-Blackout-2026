package org.rbmain.tgnet;

import ir.aaap.messengercore.model.WarningObject;

/* loaded from: classes4.dex */
public abstract class TLRPC$UserFull extends TLObject {
    public String about;
    public boolean blocked;
    public TLRPC$BotInfo bot_info;
    public boolean can_pin_message;
    public int common_chats_count;
    public int flags;
    public int folder_id;
    public boolean has_scheduled;
    public TLRPC$TL_contacts_link_layer101 link;
    public TLRPC$PeerNotifySettings notify_settings;
    public boolean phone_calls_available;
    public boolean phone_calls_private;
    public long pinned_msg_id;
    public TLRPC$Photo profile_photo;
    public TLRPC$TL_peerSettings settings;
    public String theme_emoticon;
    public int ttl_period;
    public TLRPC$User user;
    public boolean video_calls_available;
    public TLRPC$WallPaper wallpaper;
    public WarningObject warningObject;

    public static TLRPC$UserFull TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$TL_userFull tLRPC$TL_userFull;
        switch (i) {
            case -1901811583:
                tLRPC$TL_userFull = new TLRPC$TL_userFull() { // from class: org.rbmain.tgnet.TLRPC$TL_userFull_layer98
                    public static int constructor = -1901811583;

                    @Override // org.rbmain.tgnet.TLRPC$TL_userFull, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.blocked = (int32 & 1) != 0;
                        this.phone_calls_available = (int32 & 16) != 0;
                        this.phone_calls_private = (int32 & 32) != 0;
                        this.can_pin_message = (int32 & 128) != 0;
                        this.user = TLRPC$User.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if ((this.flags & 2) != 0) {
                            this.about = abstractSerializedData2.readString(z2);
                        }
                        this.link = TLRPC$TL_contacts_link_layer101.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if ((this.flags & 4) != 0) {
                            this.profile_photo = TLRPC$Photo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if ((this.flags & 8) != 0) {
                            this.bot_info = TLRPC$BotInfo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.pinned_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        this.common_chats_count = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_userFull, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.blocked ? this.flags | 1 : this.flags & (-2);
                        this.flags = i2;
                        int i3 = this.phone_calls_available ? i2 | 16 : i2 & (-17);
                        this.flags = i3;
                        int i4 = this.phone_calls_private ? i3 | 32 : i3 & (-33);
                        this.flags = i4;
                        int i5 = this.can_pin_message ? i4 | 128 : i4 & (-129);
                        this.flags = i5;
                        abstractSerializedData2.writeInt32(i5);
                        this.user.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 2) != 0) {
                            abstractSerializedData2.writeString(this.about);
                        }
                        this.link.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 4) != 0) {
                            this.profile_photo.serializeToStream(abstractSerializedData2);
                        }
                        this.notify_settings.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 8) != 0) {
                            this.bot_info.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 64) != 0) {
                            abstractSerializedData2.writeInt32((int) this.pinned_msg_id);
                        }
                        abstractSerializedData2.writeInt32(this.common_chats_count);
                    }
                };
                break;
            case -302941166:
                tLRPC$TL_userFull = new TLRPC$TL_userFull() { // from class: org.rbmain.tgnet.TLRPC$TL_userFull_layer123
                    public static int constructor = -302941166;

                    @Override // org.rbmain.tgnet.TLRPC$TL_userFull, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.blocked = (int32 & 1) != 0;
                        this.phone_calls_available = (int32 & 16) != 0;
                        this.phone_calls_private = (int32 & 32) != 0;
                        this.can_pin_message = (int32 & 128) != 0;
                        this.has_scheduled = (int32 & 4096) != 0;
                        this.video_calls_available = (int32 & 8192) != 0;
                        this.user = TLRPC$User.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if ((this.flags & 2) != 0) {
                            this.about = abstractSerializedData2.readString(z2);
                        }
                        this.settings = TLRPC$TL_peerSettings.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if ((this.flags & 4) != 0) {
                            this.profile_photo = TLRPC$Photo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if ((this.flags & 8) != 0) {
                            this.bot_info = TLRPC$BotInfo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.pinned_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        this.common_chats_count = abstractSerializedData2.readInt32(z2);
                        if ((this.flags & 2048) != 0) {
                            this.folder_id = abstractSerializedData2.readInt32(z2);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_userFull, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.blocked ? this.flags | 1 : this.flags & (-2);
                        this.flags = i2;
                        int i3 = this.phone_calls_available ? i2 | 16 : i2 & (-17);
                        this.flags = i3;
                        int i4 = this.phone_calls_private ? i3 | 32 : i3 & (-33);
                        this.flags = i4;
                        int i5 = this.can_pin_message ? i4 | 128 : i4 & (-129);
                        this.flags = i5;
                        int i6 = this.has_scheduled ? i5 | 4096 : i5 & (-4097);
                        this.flags = i6;
                        abstractSerializedData2.writeInt32(i6);
                        this.user.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 2) != 0) {
                            abstractSerializedData2.writeString(this.about);
                        }
                        this.settings.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 4) != 0) {
                            this.profile_photo.serializeToStream(abstractSerializedData2);
                        }
                        this.notify_settings.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 8) != 0) {
                            this.bot_info.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 64) != 0) {
                            abstractSerializedData2.writeInt32((int) this.pinned_msg_id);
                        }
                        abstractSerializedData2.writeInt32(this.common_chats_count);
                        if ((this.flags & 2048) != 0) {
                            abstractSerializedData2.writeInt32(this.folder_id);
                        }
                    }
                };
                break;
            case 328899191:
                tLRPC$TL_userFull = new TLRPC$TL_userFull();
                break;
            case 1951750604:
                tLRPC$TL_userFull = new TLRPC$TL_userFull() { // from class: org.rbmain.tgnet.TLRPC$TL_userFull_layer101
                    public static int constructor = 1951750604;

                    @Override // org.rbmain.tgnet.TLRPC$TL_userFull, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.blocked = (int32 & 1) != 0;
                        this.phone_calls_available = (int32 & 16) != 0;
                        this.phone_calls_private = (int32 & 32) != 0;
                        this.can_pin_message = (int32 & 128) != 0;
                        this.user = TLRPC$User.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if ((this.flags & 2) != 0) {
                            this.about = abstractSerializedData2.readString(z2);
                        }
                        this.link = TLRPC$TL_contacts_link_layer101.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if ((this.flags & 4) != 0) {
                            this.profile_photo = TLRPC$Photo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if ((this.flags & 8) != 0) {
                            this.bot_info = TLRPC$BotInfo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.pinned_msg_id = abstractSerializedData2.readInt32(z2);
                        }
                        this.common_chats_count = abstractSerializedData2.readInt32(z2);
                        if ((this.flags & 2048) != 0) {
                            this.folder_id = abstractSerializedData2.readInt32(z2);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_userFull, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.blocked ? this.flags | 1 : this.flags & (-2);
                        this.flags = i2;
                        int i3 = this.phone_calls_available ? i2 | 16 : i2 & (-17);
                        this.flags = i3;
                        int i4 = this.phone_calls_private ? i3 | 32 : i3 & (-33);
                        this.flags = i4;
                        int i5 = this.can_pin_message ? i4 | 128 : i4 & (-129);
                        this.flags = i5;
                        abstractSerializedData2.writeInt32(i5);
                        this.user.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 2) != 0) {
                            abstractSerializedData2.writeString(this.about);
                        }
                        this.link.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 4) != 0) {
                            this.profile_photo.serializeToStream(abstractSerializedData2);
                        }
                        this.notify_settings.serializeToStream(abstractSerializedData2);
                        if ((this.flags & 8) != 0) {
                            this.bot_info.serializeToStream(abstractSerializedData2);
                        }
                        if ((this.flags & 64) != 0) {
                            abstractSerializedData2.writeInt32((int) this.pinned_msg_id);
                        }
                        abstractSerializedData2.writeInt32(this.common_chats_count);
                        if ((this.flags & 2048) != 0) {
                            abstractSerializedData2.writeInt32(this.folder_id);
                        }
                    }
                };
                break;
            default:
                tLRPC$TL_userFull = null;
                break;
        }
        if (tLRPC$TL_userFull == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in UserFull", Integer.valueOf(i)));
        }
        if (tLRPC$TL_userFull != null) {
            tLRPC$TL_userFull.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_userFull;
    }
}
