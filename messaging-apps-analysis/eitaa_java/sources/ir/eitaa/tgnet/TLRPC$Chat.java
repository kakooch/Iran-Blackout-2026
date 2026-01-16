package ir.eitaa.tgnet;

import java.util.ArrayList;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public abstract class TLRPC$Chat extends TLObject {
    public long access_hash;
    public boolean admin;
    public TLRPC$TL_chatAdminRights admin_rights;
    public TLRPC$TL_channelAdminRights_layer92 admin_rights_layer92;
    public boolean admins_enabled;
    public TLRPC$TL_chatBannedRights banned_rights;
    public TLRPC$TL_channelBannedRights_layer92 banned_rights_layer92;
    public boolean broadcast;
    public boolean call_active;
    public boolean call_not_empty;
    public boolean creator;
    public int date;
    public boolean deactivated;
    public TLRPC$TL_chatBannedRights default_banned_rights;
    public TLRPC$TL_channelBannedRights_layer92 default_banned_rights_layer92;
    public int eFlags;
    public boolean explicit_content;
    public boolean fake;
    public int flags;
    public boolean gigagroup;
    public boolean has_geo;
    public boolean has_link;
    public long id;
    public boolean isMediaContent;
    public boolean kicked;
    public boolean left;
    public int live_stream_msg_id;
    public boolean megagroup;
    public TLRPC$InputChannel migrated_to;
    public boolean min;
    public boolean moderator;
    public int participants_count;
    public TLRPC$ChatPhoto photo;
    public boolean restricted;
    public ArrayList<TLRPC$TL_restrictionReason> restriction_reason = new ArrayList<>();
    public boolean shop;
    public boolean signatures;
    public boolean slowmode_enabled;
    public boolean sponsoredMessage;
    public String title;
    public boolean trusty;
    public int until_date;
    public String username;
    public boolean verified;
    public int version;

    public static TLRPC$Chat TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$Chat tLRPC$TL_channel;
        switch (constructor) {
            case -2107528095:
                tLRPC$TL_channel = new TLRPC$TL_channel();
                break;
            case -2059962289:
                tLRPC$TL_channel = new TLRPC$TL_channelForbidden() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelForbidden_layer67
                    public static int constructor = -2059962289;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelForbidden, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.broadcast = (int32 & 32) != 0;
                        this.megagroup = (int32 & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0;
                        this.id = stream2.readInt32(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.title = stream2.readString(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelForbidden, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.broadcast ? this.flags | 32 : this.flags & (-33);
                        this.flags = i;
                        int i2 = this.megagroup ? i | Factory.DEVICE_HAS_CRAPPY_OPENSLES : i & (-257);
                        this.flags = i2;
                        stream2.writeInt32(i2);
                        stream2.writeInt32((int) this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeString(this.title);
                    }
                };
                break;
            case -1683826688:
                tLRPC$TL_channel = new TLRPC$TL_chatEmpty() { // from class: ir.eitaa.tgnet.TLRPC$TL_chatEmpty_layer131
                    public static int constructor = -1683826688;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatEmpty, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt32(exception2);
                        this.title = "DELETED";
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatEmpty, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.id);
                    }
                };
                break;
            case -1655243071:
                tLRPC$TL_channel = new TLRPC$TL_channel() { // from class: ir.eitaa.tgnet.TLRPC$TL_channel_layer84
                    public static int constructor = -1655243071;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channel, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.creator = (int32 & 1) != 0;
                        this.left = (int32 & 4) != 0;
                        this.broadcast = (int32 & 32) != 0;
                        this.verified = (int32 & 128) != 0;
                        this.megagroup = (int32 & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0;
                        this.restricted = (int32 & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0;
                        this.signatures = (int32 & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0;
                        this.min = (int32 & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0;
                        this.isMediaContent = (int32 & 2097152) != 0;
                        this.trusty = (1073741824 & int32) != 0;
                        this.has_link = (1048576 & int32) != 0;
                        this.has_geo = (2097152 & int32) != 0;
                        this.slowmode_enabled = (4194304 & int32) != 0;
                        this.call_active = (8388608 & int32) != 0;
                        this.call_not_empty = (16777216 & int32) != 0;
                        this.fake = (33554432 & int32) != 0;
                        this.gigagroup = (int32 & ConnectionsManager.FileTypeFile) != 0;
                        this.id = stream2.readInt32(exception2);
                        if ((this.flags & 8192) != 0) {
                            this.access_hash = stream2.readInt64(exception2);
                        }
                        this.title = stream2.readString(exception2);
                        if ((this.flags & 64) != 0) {
                            this.username = stream2.readString(exception2);
                        }
                        this.photo = TLRPC$ChatPhoto.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.date = stream2.readInt32(exception2);
                        this.version = stream2.readInt32(exception2);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            int int322 = stream2.readInt32(exception2);
                            if (int322 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = stream2.readInt32(exception2);
                            for (int i = 0; i < int323; i++) {
                                TLRPC$TL_restrictionReason tLRPC$TL_restrictionReasonTLdeserialize = TLRPC$TL_restrictionReason.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$TL_restrictionReasonTLdeserialize == null) {
                                    return;
                                }
                                this.restriction_reason.add(tLRPC$TL_restrictionReasonTLdeserialize);
                            }
                        }
                        if ((this.flags & 16384) != 0) {
                            TLRPC$TL_channelAdminRights_layer92 tLRPC$TL_channelAdminRights_layer92TLdeserialize = TLRPC$TL_channelAdminRights_layer92.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            this.admin_rights_layer92 = tLRPC$TL_channelAdminRights_layer92TLdeserialize;
                            this.admin_rights = TLRPC$Chat.mergeAdminRights(tLRPC$TL_channelAdminRights_layer92TLdeserialize);
                        }
                        if ((this.flags & 32768) != 0) {
                            TLRPC$TL_channelBannedRights_layer92 tLRPC$TL_channelBannedRights_layer92TLdeserialize = TLRPC$TL_channelBannedRights_layer92.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            this.banned_rights_layer92 = tLRPC$TL_channelBannedRights_layer92TLdeserialize;
                            this.banned_rights = TLRPC$Chat.mergeBannedRights(tLRPC$TL_channelBannedRights_layer92TLdeserialize);
                        }
                        if ((this.flags & 131072) != 0) {
                            this.participants_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 262144) != 0) {
                            TLRPC$TL_channelBannedRights_layer92 tLRPC$TL_channelBannedRights_layer92TLdeserialize2 = TLRPC$TL_channelBannedRights_layer92.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            this.default_banned_rights_layer92 = tLRPC$TL_channelBannedRights_layer92TLdeserialize2;
                            this.default_banned_rights = TLRPC$Chat.mergeBannedRights(tLRPC$TL_channelBannedRights_layer92TLdeserialize2);
                        }
                        if ((this.flags & 524288) != 0) {
                            stream2.readInt32(exception2);
                        }
                        if ((this.flags & 536870912) != 0) {
                            this.live_stream_msg_id = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channel, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.creator ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.left ? i | 4 : i & (-5);
                        this.flags = i2;
                        int i3 = this.broadcast ? i2 | 32 : i2 & (-33);
                        this.flags = i3;
                        int i4 = this.verified ? i3 | 128 : i3 & (-129);
                        this.flags = i4;
                        int i5 = this.megagroup ? i4 | Factory.DEVICE_HAS_CRAPPY_OPENSLES : i4 & (-257);
                        this.flags = i5;
                        int i6 = this.restricted ? i5 | Factory.DEVICE_USE_ANDROID_CAMCORDER : i5 & (-513);
                        this.flags = i6;
                        int i7 = this.signatures ? i6 | Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS : i6 & (-2049);
                        this.flags = i7;
                        int i8 = this.min ? i7 | Factory.DEVICE_HAS_CRAPPY_AAUDIO : i7 & (-4097);
                        this.flags = i8;
                        int i9 = this.live_stream_msg_id != 0 ? i8 | 536870912 : i8 & (-536870913);
                        this.flags = i9;
                        int i10 = this.trusty ? i9 | 1073741824 : i9 & (-1073741825);
                        this.flags = i10;
                        int i11 = this.has_link ? i10 | 1048576 : i10 & (-1048577);
                        this.flags = i11;
                        int i12 = this.has_geo ? i11 | 2097152 : i11 & (-2097153);
                        this.flags = i12;
                        int i13 = this.slowmode_enabled ? i12 | 4194304 : i12 & (-4194305);
                        this.flags = i13;
                        int i14 = this.call_active ? i13 | 8388608 : i13 & (-8388609);
                        this.flags = i14;
                        int i15 = this.call_not_empty ? i14 | ConnectionsManager.FileTypePhoto : i14 & (-16777217);
                        this.flags = i15;
                        int i16 = this.fake ? i15 | ConnectionsManager.FileTypeVideo : i15 & (-33554433);
                        this.flags = i16;
                        int i17 = this.gigagroup ? i16 | ConnectionsManager.FileTypeFile : i16 & (-67108865);
                        this.flags = i17;
                        stream2.writeInt32(i17);
                        stream2.writeInt32((int) this.id);
                        if ((this.flags & 8192) != 0) {
                            stream2.writeInt64(this.access_hash);
                        }
                        stream2.writeString(this.title);
                        if ((this.flags & 64) != 0) {
                            stream2.writeString(this.username);
                        }
                        this.photo.serializeToStream(stream2);
                        stream2.writeInt32(this.date);
                        stream2.writeInt32(this.version);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            stream2.writeInt32(481674261);
                            int size = this.restriction_reason.size();
                            stream2.writeInt32(size);
                            for (int i18 = 0; i18 < size; i18++) {
                                this.restriction_reason.get(i18).serializeToStream(stream2);
                            }
                        }
                        if ((this.flags & 16384) != 0) {
                            TLRPC$TL_channelAdminRights_layer92 tLRPC$TL_channelAdminRights_layer92MergeAdminRights = TLRPC$Chat.mergeAdminRights(this.admin_rights);
                            this.admin_rights_layer92 = tLRPC$TL_channelAdminRights_layer92MergeAdminRights;
                            tLRPC$TL_channelAdminRights_layer92MergeAdminRights.serializeToStream(stream2);
                        }
                        if ((this.flags & 32768) != 0) {
                            TLRPC$TL_channelBannedRights_layer92 tLRPC$TL_channelBannedRights_layer92MergeBannedRights = TLRPC$Chat.mergeBannedRights(this.banned_rights);
                            this.banned_rights_layer92 = tLRPC$TL_channelBannedRights_layer92MergeBannedRights;
                            tLRPC$TL_channelBannedRights_layer92MergeBannedRights.serializeToStream(stream2);
                        }
                        if ((this.flags & 131072) != 0) {
                            stream2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 262144) != 0) {
                            TLRPC$TL_channelBannedRights_layer92 tLRPC$TL_channelBannedRights_layer92MergeBannedRights2 = TLRPC$Chat.mergeBannedRights(this.default_banned_rights);
                            this.default_banned_rights_layer92 = tLRPC$TL_channelBannedRights_layer92MergeBannedRights2;
                            tLRPC$TL_channelBannedRights_layer92MergeBannedRights2.serializeToStream(stream2);
                        }
                        if ((this.flags & 524288) != 0) {
                            stream2.writeInt32(0);
                        }
                        if ((this.flags & 536870912) != 0) {
                            stream2.writeInt32(this.live_stream_msg_id);
                        }
                    }
                };
                break;
            case -1588737454:
                tLRPC$TL_channel = new TLRPC$TL_channel() { // from class: ir.eitaa.tgnet.TLRPC$TL_channel_layer67
                    public static int constructor = -1588737454;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channel, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.creator = (int32 & 1) != 0;
                        this.kicked = (int32 & 2) != 0;
                        this.left = (int32 & 4) != 0;
                        this.moderator = (int32 & 16) != 0;
                        this.broadcast = (int32 & 32) != 0;
                        this.verified = (int32 & 128) != 0;
                        this.megagroup = (int32 & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0;
                        this.restricted = (int32 & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0;
                        this.signatures = (int32 & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0;
                        this.min = (int32 & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0;
                        this.id = stream2.readInt32(exception2);
                        if ((this.flags & 8192) != 0) {
                            this.access_hash = stream2.readInt64(exception2);
                        }
                        this.title = stream2.readString(exception2);
                        if ((this.flags & 64) != 0) {
                            this.username = stream2.readString(exception2);
                        }
                        this.photo = TLRPC$ChatPhoto.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.date = stream2.readInt32(exception2);
                        this.version = stream2.readInt32(exception2);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            stream2.readString(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channel, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.creator ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.kicked ? i | 2 : i & (-3);
                        this.flags = i2;
                        int i3 = this.left ? i2 | 4 : i2 & (-5);
                        this.flags = i3;
                        int i4 = this.moderator ? i3 | 16 : i3 & (-17);
                        this.flags = i4;
                        int i5 = this.broadcast ? i4 | 32 : i4 & (-33);
                        this.flags = i5;
                        int i6 = this.verified ? i5 | 128 : i5 & (-129);
                        this.flags = i6;
                        int i7 = this.megagroup ? i6 | Factory.DEVICE_HAS_CRAPPY_OPENSLES : i6 & (-257);
                        this.flags = i7;
                        int i8 = this.restricted ? i7 | Factory.DEVICE_USE_ANDROID_CAMCORDER : i7 & (-513);
                        this.flags = i8;
                        int i9 = this.signatures ? i8 | Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS : i8 & (-2049);
                        this.flags = i9;
                        int i10 = this.min ? i9 | Factory.DEVICE_HAS_CRAPPY_AAUDIO : i9 & (-4097);
                        this.flags = i10;
                        stream2.writeInt32(i10);
                        stream2.writeInt32((int) this.id);
                        if ((this.flags & 8192) != 0) {
                            stream2.writeInt64(this.access_hash);
                        }
                        stream2.writeString(this.title);
                        if ((this.flags & 64) != 0) {
                            stream2.writeString(this.username);
                        }
                        this.photo.serializeToStream(stream2);
                        stream2.writeInt32(this.date);
                        stream2.writeInt32(this.version);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            stream2.writeString("");
                        }
                    }
                };
                break;
            case -930515796:
                tLRPC$TL_channel = new TLRPC$TL_channel() { // from class: ir.eitaa.tgnet.TLRPC$TL_channel_layer92
                    public static int constructor = -930515796;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channel, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.creator = (int32 & 1) != 0;
                        this.left = (int32 & 4) != 0;
                        this.broadcast = (int32 & 32) != 0;
                        this.verified = (int32 & 128) != 0;
                        this.megagroup = (int32 & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0;
                        this.restricted = (int32 & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0;
                        this.signatures = (int32 & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0;
                        this.min = (int32 & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0;
                        this.id = stream2.readInt32(exception2);
                        if ((this.flags & 8192) != 0) {
                            this.access_hash = stream2.readInt64(exception2);
                        }
                        this.title = stream2.readString(exception2);
                        if ((this.flags & 64) != 0) {
                            this.username = stream2.readString(exception2);
                        }
                        this.photo = TLRPC$ChatPhoto.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.date = stream2.readInt32(exception2);
                        this.version = stream2.readInt32(exception2);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            stream2.readString(exception2);
                        }
                        if ((this.flags & 16384) != 0) {
                            TLRPC$TL_channelAdminRights_layer92 tLRPC$TL_channelAdminRights_layer92TLdeserialize = TLRPC$TL_channelAdminRights_layer92.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            this.admin_rights_layer92 = tLRPC$TL_channelAdminRights_layer92TLdeserialize;
                            this.admin_rights = TLRPC$Chat.mergeAdminRights(tLRPC$TL_channelAdminRights_layer92TLdeserialize);
                        }
                        if ((this.flags & 32768) != 0) {
                            TLRPC$TL_channelBannedRights_layer92 tLRPC$TL_channelBannedRights_layer92TLdeserialize = TLRPC$TL_channelBannedRights_layer92.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            this.banned_rights_layer92 = tLRPC$TL_channelBannedRights_layer92TLdeserialize;
                            this.banned_rights = TLRPC$Chat.mergeBannedRights(tLRPC$TL_channelBannedRights_layer92TLdeserialize);
                        }
                        if ((this.flags & 131072) != 0) {
                            this.participants_count = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channel, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.creator ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.left ? i | 4 : i & (-5);
                        this.flags = i2;
                        int i3 = this.broadcast ? i2 | 32 : i2 & (-33);
                        this.flags = i3;
                        int i4 = this.verified ? i3 | 128 : i3 & (-129);
                        this.flags = i4;
                        int i5 = this.megagroup ? i4 | Factory.DEVICE_HAS_CRAPPY_OPENSLES : i4 & (-257);
                        this.flags = i5;
                        int i6 = this.restricted ? i5 | Factory.DEVICE_USE_ANDROID_CAMCORDER : i5 & (-513);
                        this.flags = i6;
                        int i7 = this.signatures ? i6 | Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS : i6 & (-2049);
                        this.flags = i7;
                        int i8 = this.min ? i7 | Factory.DEVICE_HAS_CRAPPY_AAUDIO : i7 & (-4097);
                        this.flags = i8;
                        stream2.writeInt32(i8);
                        stream2.writeInt32((int) this.id);
                        if ((this.flags & 8192) != 0) {
                            stream2.writeInt64(this.access_hash);
                        }
                        stream2.writeString(this.title);
                        if ((this.flags & 64) != 0) {
                            stream2.writeString(this.username);
                        }
                        this.photo.serializeToStream(stream2);
                        stream2.writeInt32(this.date);
                        stream2.writeInt32(this.version);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            stream2.writeString("");
                        }
                        if ((this.flags & 16384) != 0) {
                            this.admin_rights_layer92.serializeToStream(stream2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.banned_rights_layer92.serializeToStream(stream2);
                        }
                        if ((this.flags & 131072) != 0) {
                            stream2.writeInt32(this.participants_count);
                        }
                    }
                };
                break;
            case -930515795:
                tLRPC$TL_channel = new TLRPC$TL_channel() { // from class: ir.eitaa.tgnet.TLRPC$TL_channel_layer83
                    public static int constructor = -930515795;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channel, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.creator = (int32 & 1) != 0;
                        this.left = (int32 & 4) != 0;
                        this.broadcast = (int32 & 32) != 0;
                        this.verified = (int32 & 128) != 0;
                        this.megagroup = (int32 & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0;
                        this.restricted = (int32 & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0;
                        this.signatures = (int32 & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0;
                        this.min = (int32 & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0;
                        this.isMediaContent = (int32 & 2097152) != 0;
                        this.id = stream2.readInt32(exception2);
                        if ((this.flags & 8192) != 0) {
                            this.access_hash = stream2.readInt64(exception2);
                        }
                        this.title = stream2.readString(exception2);
                        if ((this.flags & 64) != 0) {
                            this.username = stream2.readString(exception2);
                        }
                        this.photo = TLRPC$ChatPhoto.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.date = stream2.readInt32(exception2);
                        this.version = stream2.readInt32(exception2);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            stream2.readString(exception2);
                        }
                        if ((this.flags & 16384) != 0) {
                            TLRPC$TL_channelAdminRights_layer92 tLRPC$TL_channelAdminRights_layer92TLdeserialize = TLRPC$TL_channelAdminRights_layer92.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            this.admin_rights_layer92 = tLRPC$TL_channelAdminRights_layer92TLdeserialize;
                            this.admin_rights = TLRPC$Chat.mergeAdminRights(tLRPC$TL_channelAdminRights_layer92TLdeserialize);
                        }
                        if ((this.flags & 32768) != 0) {
                            TLRPC$TL_channelBannedRights_layer92 tLRPC$TL_channelBannedRights_layer92TLdeserialize = TLRPC$TL_channelBannedRights_layer92.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            this.banned_rights_layer92 = tLRPC$TL_channelBannedRights_layer92TLdeserialize;
                            this.banned_rights = TLRPC$Chat.mergeBannedRights(tLRPC$TL_channelBannedRights_layer92TLdeserialize);
                        }
                        if ((this.flags & 131072) != 0) {
                            this.participants_count = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 262144) != 0) {
                            TLRPC$TL_channelBannedRights_layer92 tLRPC$TL_channelBannedRights_layer92TLdeserialize2 = TLRPC$TL_channelBannedRights_layer92.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            this.default_banned_rights_layer92 = tLRPC$TL_channelBannedRights_layer92TLdeserialize2;
                            this.default_banned_rights = TLRPC$Chat.mergeBannedRights(tLRPC$TL_channelBannedRights_layer92TLdeserialize2);
                        }
                        if ((this.flags & 524288) != 0) {
                            stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channel, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.creator ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.left ? i | 4 : i & (-5);
                        this.flags = i2;
                        int i3 = this.broadcast ? i2 | 32 : i2 & (-33);
                        this.flags = i3;
                        int i4 = this.verified ? i3 | 128 : i3 & (-129);
                        this.flags = i4;
                        int i5 = this.megagroup ? i4 | Factory.DEVICE_HAS_CRAPPY_OPENSLES : i4 & (-257);
                        this.flags = i5;
                        int i6 = this.restricted ? i5 | Factory.DEVICE_USE_ANDROID_CAMCORDER : i5 & (-513);
                        this.flags = i6;
                        int i7 = this.signatures ? i6 | Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS : i6 & (-2049);
                        this.flags = i7;
                        int i8 = this.min ? i7 | Factory.DEVICE_HAS_CRAPPY_AAUDIO : i7 & (-4097);
                        this.flags = i8;
                        stream2.writeInt32(i8);
                        stream2.writeInt32((int) this.id);
                        if ((this.flags & 8192) != 0) {
                            stream2.writeInt64(this.access_hash);
                        }
                        stream2.writeString(this.title);
                        if ((this.flags & 64) != 0) {
                            stream2.writeString(this.username);
                        }
                        this.photo.serializeToStream(stream2);
                        stream2.writeInt32(this.date);
                        stream2.writeInt32(this.version);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            stream2.writeString("");
                        }
                        if ((this.flags & 16384) != 0) {
                            TLRPC$TL_channelAdminRights_layer92 tLRPC$TL_channelAdminRights_layer92MergeAdminRights = TLRPC$Chat.mergeAdminRights(this.admin_rights);
                            this.admin_rights_layer92 = tLRPC$TL_channelAdminRights_layer92MergeAdminRights;
                            tLRPC$TL_channelAdminRights_layer92MergeAdminRights.serializeToStream(stream2);
                        }
                        if ((this.flags & 32768) != 0) {
                            TLRPC$TL_channelBannedRights_layer92 tLRPC$TL_channelBannedRights_layer92MergeBannedRights = TLRPC$Chat.mergeBannedRights(this.banned_rights);
                            this.banned_rights_layer92 = tLRPC$TL_channelBannedRights_layer92MergeBannedRights;
                            tLRPC$TL_channelBannedRights_layer92MergeBannedRights.serializeToStream(stream2);
                        }
                        if ((this.flags & 131072) != 0) {
                            stream2.writeInt32(this.participants_count);
                        }
                        if ((this.flags & 262144) != 0) {
                            TLRPC$TL_channelBannedRights_layer92 tLRPC$TL_channelBannedRights_layer92MergeBannedRights2 = TLRPC$Chat.mergeBannedRights(this.default_banned_rights);
                            this.default_banned_rights_layer92 = tLRPC$TL_channelBannedRights_layer92MergeBannedRights2;
                            tLRPC$TL_channelBannedRights_layer92MergeBannedRights2.serializeToStream(stream2);
                        }
                        if ((this.flags & 524288) != 0) {
                            stream2.writeInt32(0);
                        }
                    }
                };
                break;
            case -753232354:
                tLRPC$TL_channel = new TLRPC$TL_channel() { // from class: ir.eitaa.tgnet.TLRPC$TL_channel_layer131
                    public static int constructor = -753232354;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channel, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.creator = (int32 & 1) != 0;
                        this.left = (int32 & 4) != 0;
                        this.broadcast = (int32 & 32) != 0;
                        this.verified = (int32 & 128) != 0;
                        this.megagroup = (int32 & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0;
                        this.restricted = (int32 & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0;
                        this.signatures = (int32 & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0;
                        this.min = (int32 & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0;
                        this.trusty = (1073741824 & int32) != 0;
                        this.has_link = (1048576 & int32) != 0;
                        this.has_geo = (2097152 & int32) != 0;
                        this.slowmode_enabled = (4194304 & int32) != 0;
                        this.call_active = (8388608 & int32) != 0;
                        this.call_not_empty = (16777216 & int32) != 0;
                        this.fake = (33554432 & int32) != 0;
                        this.gigagroup = (int32 & ConnectionsManager.FileTypeFile) != 0;
                        this.id = stream2.readInt32(exception2);
                        if ((this.flags & 8192) != 0) {
                            this.access_hash = stream2.readInt64(exception2);
                        }
                        this.title = stream2.readString(exception2);
                        if ((this.flags & 64) != 0) {
                            this.username = stream2.readString(exception2);
                        }
                        this.photo = TLRPC$ChatPhoto.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.date = stream2.readInt32(exception2);
                        this.version = stream2.readInt32(exception2);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            int int322 = stream2.readInt32(exception2);
                            if (int322 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = stream2.readInt32(exception2);
                            for (int i = 0; i < int323; i++) {
                                TLRPC$TL_restrictionReason tLRPC$TL_restrictionReasonTLdeserialize = TLRPC$TL_restrictionReason.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$TL_restrictionReasonTLdeserialize == null) {
                                    return;
                                }
                                this.restriction_reason.add(tLRPC$TL_restrictionReasonTLdeserialize);
                            }
                        }
                        if ((this.flags & 16384) != 0) {
                            this.admin_rights = TLRPC$TL_chatAdminRights.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.banned_rights = TLRPC$TL_chatBannedRights.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 262144) != 0) {
                            this.default_banned_rights = TLRPC$TL_chatBannedRights.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 131072) != 0) {
                            this.participants_count = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channel, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.creator ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.left ? i | 4 : i & (-5);
                        this.flags = i2;
                        int i3 = this.broadcast ? i2 | 32 : i2 & (-33);
                        this.flags = i3;
                        int i4 = this.verified ? i3 | 128 : i3 & (-129);
                        this.flags = i4;
                        int i5 = this.megagroup ? i4 | Factory.DEVICE_HAS_CRAPPY_OPENSLES : i4 & (-257);
                        this.flags = i5;
                        int i6 = this.restricted ? i5 | Factory.DEVICE_USE_ANDROID_CAMCORDER : i5 & (-513);
                        this.flags = i6;
                        int i7 = this.signatures ? i6 | Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS : i6 & (-2049);
                        this.flags = i7;
                        int i8 = this.min ? i7 | Factory.DEVICE_HAS_CRAPPY_AAUDIO : i7 & (-4097);
                        this.flags = i8;
                        int i9 = this.trusty ? i8 | 1073741824 : i8 & (-1073741825);
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
                        stream2.writeInt32(i16);
                        stream2.writeInt32((int) this.id);
                        if ((this.flags & 8192) != 0) {
                            stream2.writeInt64(this.access_hash);
                        }
                        stream2.writeString(this.title);
                        if ((this.flags & 64) != 0) {
                            stream2.writeString(this.username);
                        }
                        this.photo.serializeToStream(stream2);
                        stream2.writeInt32(this.date);
                        stream2.writeInt32(this.version);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            stream2.writeInt32(481674261);
                            int size = this.restriction_reason.size();
                            stream2.writeInt32(size);
                            for (int i17 = 0; i17 < size; i17++) {
                                this.restriction_reason.get(i17).serializeToStream(stream2);
                            }
                        }
                        if ((this.flags & 16384) != 0) {
                            this.admin_rights.serializeToStream(stream2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.banned_rights.serializeToStream(stream2);
                        }
                        if ((this.flags & 262144) != 0) {
                            this.default_banned_rights.serializeToStream(stream2);
                        }
                        if ((this.flags & 131072) != 0) {
                            stream2.writeInt32(this.participants_count);
                        }
                    }
                };
                break;
            case -652419756:
                tLRPC$TL_channel = new TLRPC$TL_chat() { // from class: ir.eitaa.tgnet.TLRPC$TL_chat_layer92
                    public static int constructor = -652419756;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chat, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.creator = (int32 & 1) != 0;
                        this.kicked = (int32 & 2) != 0;
                        this.left = (int32 & 4) != 0;
                        this.deactivated = (int32 & 32) != 0;
                        this.id = stream2.readInt32(exception2);
                        this.title = stream2.readString(exception2);
                        this.photo = TLRPC$ChatPhoto.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.participants_count = stream2.readInt32(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.version = stream2.readInt32(exception2);
                        if ((this.flags & 64) != 0) {
                            this.migrated_to = TLRPC$InputChannel.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chat, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.creator ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.kicked ? i | 2 : i & (-3);
                        this.flags = i2;
                        int i3 = this.left ? i2 | 4 : i2 & (-5);
                        this.flags = i3;
                        int i4 = this.deactivated ? i3 | 32 : i3 & (-33);
                        this.flags = i4;
                        stream2.writeInt32(i4);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.title);
                        this.photo.serializeToStream(stream2);
                        stream2.writeInt32(this.participants_count);
                        stream2.writeInt32(this.date);
                        stream2.writeInt32(this.version);
                        if ((this.flags & 64) != 0) {
                            this.migrated_to.serializeToStream(stream2);
                        }
                    }
                };
                break;
            case -83047359:
                tLRPC$TL_channel = new TLRPC$TL_chatForbidden() { // from class: ir.eitaa.tgnet.TLRPC$TL_chatForbidden_old
                    public static int constructor = -83047359;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatForbidden, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt32(exception2);
                        this.title = stream2.readString(exception2);
                        this.date = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatForbidden, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.title);
                        stream2.writeInt32(this.date);
                    }
                };
                break;
            case 120753115:
                tLRPC$TL_channel = new TLRPC$TL_chatForbidden() { // from class: ir.eitaa.tgnet.TLRPC$TL_chatForbidden_layer131
                    public static int constructor = 120753115;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatForbidden, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt32(exception2);
                        this.title = stream2.readString(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatForbidden, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.title);
                    }
                };
                break;
            case 213142316:
                tLRPC$TL_channel = new TLRPC$TL_channel() { // from class: ir.eitaa.tgnet.TLRPC$TL_channel_layer72
                    public static int constructor = 213142300;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channel, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.creator = (int32 & 1) != 0;
                        this.left = (int32 & 4) != 0;
                        this.broadcast = (int32 & 32) != 0;
                        this.verified = (int32 & 128) != 0;
                        this.megagroup = (int32 & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0;
                        this.restricted = (int32 & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0;
                        this.signatures = (int32 & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0;
                        this.min = (int32 & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0;
                        this.id = stream2.readInt32(exception2);
                        if ((this.flags & 8192) != 0) {
                            this.access_hash = stream2.readInt64(exception2);
                        }
                        this.title = stream2.readString(exception2);
                        if ((this.flags & 64) != 0) {
                            this.username = stream2.readString(exception2);
                        }
                        this.photo = TLRPC$ChatPhoto.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.date = stream2.readInt32(exception2);
                        this.version = stream2.readInt32(exception2);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            stream2.readString(exception2);
                        }
                        if ((this.flags & 16384) != 0) {
                            TLRPC$TL_channelAdminRights_layer92 tLRPC$TL_channelAdminRights_layer92TLdeserialize = TLRPC$TL_channelAdminRights_layer92.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            this.admin_rights_layer92 = tLRPC$TL_channelAdminRights_layer92TLdeserialize;
                            this.admin_rights = TLRPC$Chat.mergeAdminRights(tLRPC$TL_channelAdminRights_layer92TLdeserialize);
                        }
                        if ((this.flags & 32768) != 0) {
                            TLRPC$TL_channelBannedRights_layer92 tLRPC$TL_channelBannedRights_layer92TLdeserialize = TLRPC$TL_channelBannedRights_layer92.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            this.banned_rights_layer92 = tLRPC$TL_channelBannedRights_layer92TLdeserialize;
                            this.banned_rights = TLRPC$Chat.mergeBannedRights(tLRPC$TL_channelBannedRights_layer92TLdeserialize);
                        }
                        if ((this.flags & 262144) != 0) {
                            TLRPC$TL_channelBannedRights_layer92 tLRPC$TL_channelBannedRights_layer92TLdeserialize2 = TLRPC$TL_channelBannedRights_layer92.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            this.default_banned_rights_layer92 = tLRPC$TL_channelBannedRights_layer92TLdeserialize2;
                            this.default_banned_rights = TLRPC$Chat.mergeBannedRights(tLRPC$TL_channelBannedRights_layer92TLdeserialize2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channel, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.creator ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.kicked ? i | 2 : i & (-3);
                        this.flags = i2;
                        int i3 = this.left ? i2 | 4 : i2 & (-5);
                        this.flags = i3;
                        int i4 = this.broadcast ? i3 | 32 : i3 & (-33);
                        this.flags = i4;
                        int i5 = this.verified ? i4 | 128 : i4 & (-129);
                        this.flags = i5;
                        int i6 = this.megagroup ? i5 | Factory.DEVICE_HAS_CRAPPY_OPENSLES : i5 & (-257);
                        this.flags = i6;
                        int i7 = this.restricted ? i6 | Factory.DEVICE_USE_ANDROID_CAMCORDER : i6 & (-513);
                        this.flags = i7;
                        int i8 = this.signatures ? i7 | Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS : i7 & (-2049);
                        this.flags = i8;
                        int i9 = this.min ? i8 | Factory.DEVICE_HAS_CRAPPY_AAUDIO : i8 & (-4097);
                        this.flags = i9;
                        stream2.writeInt32(i9);
                        stream2.writeInt32((int) this.id);
                        if ((this.flags & 8192) != 0) {
                            stream2.writeInt64(this.access_hash);
                        }
                        stream2.writeString(this.title);
                        if ((this.flags & 64) != 0) {
                            stream2.writeString(this.username);
                        }
                        this.photo.serializeToStream(stream2);
                        stream2.writeInt32(this.date);
                        stream2.writeInt32(this.version);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            stream2.writeString("");
                        }
                        if ((this.flags & 16384) != 0) {
                            TLRPC$TL_channelAdminRights_layer92 tLRPC$TL_channelAdminRights_layer92MergeAdminRights = TLRPC$Chat.mergeAdminRights(this.admin_rights);
                            this.admin_rights_layer92 = tLRPC$TL_channelAdminRights_layer92MergeAdminRights;
                            tLRPC$TL_channelAdminRights_layer92MergeAdminRights.serializeToStream(stream2);
                        }
                        if ((this.flags & 32768) != 0) {
                            TLRPC$TL_channelBannedRights_layer92 tLRPC$TL_channelBannedRights_layer92MergeBannedRights = TLRPC$Chat.mergeBannedRights(this.banned_rights);
                            this.banned_rights_layer92 = tLRPC$TL_channelBannedRights_layer92MergeBannedRights;
                            tLRPC$TL_channelBannedRights_layer92MergeBannedRights.serializeToStream(stream2);
                        }
                        if ((this.flags & 262144) != 0) {
                            TLRPC$TL_channelBannedRights_layer92 tLRPC$TL_channelBannedRights_layer92MergeBannedRights2 = TLRPC$Chat.mergeBannedRights(this.default_banned_rights);
                            this.default_banned_rights_layer92 = tLRPC$TL_channelBannedRights_layer92MergeBannedRights2;
                            tLRPC$TL_channelBannedRights_layer92MergeBannedRights2.serializeToStream(stream2);
                        }
                    }
                };
                break;
            case 399807445:
                tLRPC$TL_channel = new TLRPC$TL_channelForbidden();
                break;
            case 681420594:
                tLRPC$TL_channel = new TLRPC$TL_channelForbidden() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelForbidden_layer131
                    public static int constructor = 681420594;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelForbidden, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.broadcast = (int32 & 32) != 0;
                        this.megagroup = (int32 & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0;
                        this.id = stream2.readInt32(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.title = stream2.readString(exception2);
                        if ((this.flags & 65536) != 0) {
                            this.until_date = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelForbidden, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.broadcast ? this.flags | 32 : this.flags & (-33);
                        this.flags = i;
                        int i2 = this.megagroup ? i | Factory.DEVICE_HAS_CRAPPY_OPENSLES : i & (-257);
                        this.flags = i2;
                        stream2.writeInt32(i2);
                        stream2.writeInt32((int) this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeString(this.title);
                        if ((this.flags & 65536) != 0) {
                            stream2.writeInt32(this.until_date);
                        }
                    }
                };
                break;
            case 693512293:
                tLRPC$TL_channel = new TLRPC$TL_chatEmpty();
                break;
            case 763724588:
                tLRPC$TL_channel = new TLRPC$TL_channelForbidden() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelForbidden_layer52
                    public static int constructor = 763724588;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelForbidden, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt32(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.title = stream2.readString(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channelForbidden, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeString(this.title);
                    }
                };
                break;
            case 1004149726:
                tLRPC$TL_channel = new TLRPC$TL_chat() { // from class: ir.eitaa.tgnet.TLRPC$TL_chat_layer131
                    public static int constructor = 1004149726;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chat, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.creator = (int32 & 1) != 0;
                        this.kicked = (int32 & 2) != 0;
                        this.left = (int32 & 4) != 0;
                        this.deactivated = (int32 & 32) != 0;
                        this.call_active = (8388608 & int32) != 0;
                        this.call_not_empty = (int32 & ConnectionsManager.FileTypePhoto) != 0;
                        this.id = stream2.readInt32(exception2);
                        this.title = stream2.readString(exception2);
                        this.photo = TLRPC$ChatPhoto.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.participants_count = stream2.readInt32(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.version = stream2.readInt32(exception2);
                        if ((this.flags & 64) != 0) {
                            this.migrated_to = TLRPC$InputChannel.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 16384) != 0) {
                            this.admin_rights = TLRPC$TL_chatAdminRights.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 262144) != 0) {
                            this.default_banned_rights = TLRPC$TL_chatBannedRights.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chat, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.creator ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.kicked ? i | 2 : i & (-3);
                        this.flags = i2;
                        int i3 = this.left ? i2 | 4 : i2 & (-5);
                        this.flags = i3;
                        int i4 = this.deactivated ? i3 | 32 : i3 & (-33);
                        this.flags = i4;
                        int i5 = this.call_active ? i4 | 8388608 : i4 & (-8388609);
                        this.flags = i5;
                        int i6 = this.call_not_empty ? i5 | ConnectionsManager.FileTypePhoto : i5 & (-16777217);
                        this.flags = i6;
                        stream2.writeInt32(i6);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.title);
                        this.photo.serializeToStream(stream2);
                        stream2.writeInt32(this.participants_count);
                        stream2.writeInt32(this.date);
                        stream2.writeInt32(this.version);
                        if ((this.flags & 64) != 0) {
                            this.migrated_to.serializeToStream(stream2);
                        }
                        if ((this.flags & 16384) != 0) {
                            this.admin_rights.serializeToStream(stream2);
                        }
                        if ((this.flags & 262144) != 0) {
                            this.default_banned_rights.serializeToStream(stream2);
                        }
                    }
                };
                break;
            case 1103884886:
                tLRPC$TL_channel = new TLRPC$TL_chat();
                break;
            case 1158377749:
                tLRPC$TL_channel = new TLRPC$TL_channel() { // from class: ir.eitaa.tgnet.TLRPC$TL_channel_layer77
                    public static int constructor = 1158377749;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channel, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.creator = (int32 & 1) != 0;
                        this.left = (int32 & 4) != 0;
                        this.broadcast = (int32 & 32) != 0;
                        this.verified = (int32 & 128) != 0;
                        this.megagroup = (int32 & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0;
                        this.restricted = (int32 & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0;
                        this.signatures = (int32 & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0;
                        this.min = (int32 & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0;
                        this.id = stream2.readInt32(exception2);
                        if ((this.flags & 8192) != 0) {
                            this.access_hash = stream2.readInt64(exception2);
                        }
                        this.title = stream2.readString(exception2);
                        if ((this.flags & 64) != 0) {
                            this.username = stream2.readString(exception2);
                        }
                        this.photo = TLRPC$ChatPhoto.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.date = stream2.readInt32(exception2);
                        this.version = stream2.readInt32(exception2);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            stream2.readString(exception2);
                        }
                        if ((this.flags & 16384) != 0) {
                            TLRPC$TL_channelAdminRights_layer92 tLRPC$TL_channelAdminRights_layer92TLdeserialize = TLRPC$TL_channelAdminRights_layer92.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            this.admin_rights_layer92 = tLRPC$TL_channelAdminRights_layer92TLdeserialize;
                            this.admin_rights = TLRPC$Chat.mergeAdminRights(tLRPC$TL_channelAdminRights_layer92TLdeserialize);
                        }
                        if ((this.flags & 32768) != 0) {
                            TLRPC$TL_channelBannedRights_layer92 tLRPC$TL_channelBannedRights_layer92TLdeserialize = TLRPC$TL_channelBannedRights_layer92.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            this.banned_rights_layer92 = tLRPC$TL_channelBannedRights_layer92TLdeserialize;
                            this.banned_rights = TLRPC$Chat.mergeBannedRights(tLRPC$TL_channelBannedRights_layer92TLdeserialize);
                        }
                        if ((this.flags & 131072) != 0) {
                            this.participants_count = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channel, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.creator ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.left ? i | 4 : i & (-5);
                        this.flags = i2;
                        int i3 = this.broadcast ? i2 | 32 : i2 & (-33);
                        this.flags = i3;
                        int i4 = this.verified ? i3 | 128 : i3 & (-129);
                        this.flags = i4;
                        int i5 = this.megagroup ? i4 | Factory.DEVICE_HAS_CRAPPY_OPENSLES : i4 & (-257);
                        this.flags = i5;
                        int i6 = this.restricted ? i5 | Factory.DEVICE_USE_ANDROID_CAMCORDER : i5 & (-513);
                        this.flags = i6;
                        int i7 = this.signatures ? i6 | Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS : i6 & (-2049);
                        this.flags = i7;
                        int i8 = this.min ? i7 | Factory.DEVICE_HAS_CRAPPY_AAUDIO : i7 & (-4097);
                        this.flags = i8;
                        stream2.writeInt32(i8);
                        stream2.writeInt32((int) this.id);
                        if ((this.flags & 8192) != 0) {
                            stream2.writeInt64(this.access_hash);
                        }
                        stream2.writeString(this.title);
                        if ((this.flags & 64) != 0) {
                            stream2.writeString(this.username);
                        }
                        this.photo.serializeToStream(stream2);
                        stream2.writeInt32(this.date);
                        stream2.writeInt32(this.version);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            stream2.writeString("");
                        }
                        if ((this.flags & 16384) != 0) {
                            this.admin_rights_layer92.serializeToStream(stream2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.banned_rights_layer92.serializeToStream(stream2);
                        }
                        if ((this.flags & 131072) != 0) {
                            stream2.writeInt32(this.participants_count);
                        }
                    }
                };
                break;
            case 1260090630:
                tLRPC$TL_channel = new TLRPC$TL_channel() { // from class: ir.eitaa.tgnet.TLRPC$TL_channel_layer48
                    public static int constructor = 1260090630;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channel, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.creator = (int32 & 1) != 0;
                        this.kicked = (int32 & 2) != 0;
                        this.left = (int32 & 4) != 0;
                        this.moderator = (int32 & 16) != 0;
                        this.broadcast = (int32 & 32) != 0;
                        this.verified = (int32 & 128) != 0;
                        this.megagroup = (int32 & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0;
                        this.restricted = (int32 & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0;
                        this.signatures = (int32 & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0;
                        this.id = stream2.readInt32(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.title = stream2.readString(exception2);
                        if ((this.flags & 64) != 0) {
                            this.username = stream2.readString(exception2);
                        }
                        this.photo = TLRPC$ChatPhoto.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.date = stream2.readInt32(exception2);
                        this.version = stream2.readInt32(exception2);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            stream2.readString(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channel, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.creator ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.kicked ? i | 2 : i & (-3);
                        this.flags = i2;
                        int i3 = this.left ? i2 | 4 : i2 & (-5);
                        this.flags = i3;
                        int i4 = this.moderator ? i3 | 16 : i3 & (-17);
                        this.flags = i4;
                        int i5 = this.broadcast ? i4 | 32 : i4 & (-33);
                        this.flags = i5;
                        int i6 = this.verified ? i5 | 128 : i5 & (-129);
                        this.flags = i6;
                        int i7 = this.megagroup ? i6 | Factory.DEVICE_HAS_CRAPPY_OPENSLES : i6 & (-257);
                        this.flags = i7;
                        int i8 = this.restricted ? i7 | Factory.DEVICE_USE_ANDROID_CAMCORDER : i7 & (-513);
                        this.flags = i8;
                        int i9 = this.signatures ? i8 | Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS : i8 & (-2049);
                        this.flags = i9;
                        stream2.writeInt32(i9);
                        stream2.writeInt32((int) this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeString(this.title);
                        if ((this.flags & 64) != 0) {
                            stream2.writeString(this.username);
                        }
                        this.photo.serializeToStream(stream2);
                        stream2.writeInt32(this.date);
                        stream2.writeInt32(this.version);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            stream2.writeString("");
                        }
                    }
                };
                break;
            case 1307772980:
                tLRPC$TL_channel = new TLRPC$TL_channel() { // from class: ir.eitaa.tgnet.TLRPC$TL_channel_layer104
                    public static int constructor = 1307772980;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channel, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.creator = (int32 & 1) != 0;
                        this.left = (int32 & 4) != 0;
                        this.broadcast = (int32 & 32) != 0;
                        this.verified = (int32 & 128) != 0;
                        this.megagroup = (int32 & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0;
                        this.restricted = (int32 & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0;
                        this.signatures = (int32 & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0;
                        this.min = (int32 & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0;
                        this.has_link = (1048576 & int32) != 0;
                        this.has_geo = (2097152 & int32) != 0;
                        this.slowmode_enabled = (int32 & 4194304) != 0;
                        this.id = stream2.readInt32(exception2);
                        if ((this.flags & 8192) != 0) {
                            this.access_hash = stream2.readInt64(exception2);
                        }
                        this.title = stream2.readString(exception2);
                        if ((this.flags & 64) != 0) {
                            this.username = stream2.readString(exception2);
                        }
                        this.photo = TLRPC$ChatPhoto.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.date = stream2.readInt32(exception2);
                        this.version = stream2.readInt32(exception2);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            stream2.readString(exception2);
                        }
                        if ((this.flags & 16384) != 0) {
                            this.admin_rights = TLRPC$TL_chatAdminRights.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.banned_rights = TLRPC$TL_chatBannedRights.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 262144) != 0) {
                            this.default_banned_rights = TLRPC$TL_chatBannedRights.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 131072) != 0) {
                            this.participants_count = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channel, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.creator ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.left ? i | 4 : i & (-5);
                        this.flags = i2;
                        int i3 = this.broadcast ? i2 | 32 : i2 & (-33);
                        this.flags = i3;
                        int i4 = this.verified ? i3 | 128 : i3 & (-129);
                        this.flags = i4;
                        int i5 = this.megagroup ? i4 | Factory.DEVICE_HAS_CRAPPY_OPENSLES : i4 & (-257);
                        this.flags = i5;
                        int i6 = this.restricted ? i5 | Factory.DEVICE_USE_ANDROID_CAMCORDER : i5 & (-513);
                        this.flags = i6;
                        int i7 = this.signatures ? i6 | Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS : i6 & (-2049);
                        this.flags = i7;
                        int i8 = this.min ? i7 | Factory.DEVICE_HAS_CRAPPY_AAUDIO : i7 & (-4097);
                        this.flags = i8;
                        int i9 = this.has_link ? i8 | 1048576 : i8 & (-1048577);
                        this.flags = i9;
                        int i10 = this.has_geo ? i9 | 2097152 : i9 & (-2097153);
                        this.flags = i10;
                        int i11 = this.slowmode_enabled ? i10 | 4194304 : i10 & (-4194305);
                        this.flags = i11;
                        stream2.writeInt32(i11);
                        stream2.writeInt32((int) this.id);
                        if ((this.flags & 8192) != 0) {
                            stream2.writeInt64(this.access_hash);
                        }
                        stream2.writeString(this.title);
                        if ((this.flags & 64) != 0) {
                            stream2.writeString(this.username);
                        }
                        this.photo.serializeToStream(stream2);
                        stream2.writeInt32(this.date);
                        stream2.writeInt32(this.version);
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            stream2.writeString("");
                        }
                        if ((this.flags & 16384) != 0) {
                            this.admin_rights.serializeToStream(stream2);
                        }
                        if ((this.flags & 32768) != 0) {
                            this.banned_rights.serializeToStream(stream2);
                        }
                        if ((this.flags & 262144) != 0) {
                            this.default_banned_rights.serializeToStream(stream2);
                        }
                        if ((this.flags & 131072) != 0) {
                            stream2.writeInt32(this.participants_count);
                        }
                    }
                };
                break;
            case 1704108455:
                tLRPC$TL_channel = new TLRPC$TL_chatForbidden();
                break;
            case 1737397639:
                tLRPC$TL_channel = new TLRPC$TL_channel() { // from class: ir.eitaa.tgnet.TLRPC$TL_channel_old
                    public static int constructor = 1737397639;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channel, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.creator = (int32 & 1) != 0;
                        this.kicked = (int32 & 2) != 0;
                        this.left = (int32 & 4) != 0;
                        this.moderator = (int32 & 16) != 0;
                        this.broadcast = (int32 & 32) != 0;
                        this.verified = (int32 & 128) != 0;
                        this.megagroup = (int32 & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0;
                        this.explicit_content = (int32 & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0;
                        this.id = stream2.readInt32(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.title = stream2.readString(exception2);
                        if ((this.flags & 64) != 0) {
                            this.username = stream2.readString(exception2);
                        }
                        this.photo = TLRPC$ChatPhoto.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.date = stream2.readInt32(exception2);
                        this.version = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_channel, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.creator ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.kicked ? i | 2 : i & (-3);
                        this.flags = i2;
                        int i3 = this.left ? i2 | 4 : i2 & (-5);
                        this.flags = i3;
                        int i4 = this.moderator ? i3 | 16 : i3 & (-17);
                        this.flags = i4;
                        int i5 = this.broadcast ? i4 | 32 : i4 & (-33);
                        this.flags = i5;
                        int i6 = this.verified ? i5 | 128 : i5 & (-129);
                        this.flags = i6;
                        int i7 = this.megagroup ? i6 | Factory.DEVICE_HAS_CRAPPY_OPENSLES : i6 & (-257);
                        this.flags = i7;
                        int i8 = this.explicit_content ? i7 | Factory.DEVICE_USE_ANDROID_CAMCORDER : i7 & (-513);
                        this.flags = i8;
                        stream2.writeInt32(i8);
                        stream2.writeInt32((int) this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeString(this.title);
                        if ((this.flags & 64) != 0) {
                            stream2.writeString(this.username);
                        }
                        this.photo.serializeToStream(stream2);
                        stream2.writeInt32(this.date);
                        stream2.writeInt32(this.version);
                    }
                };
                break;
            case 1855757255:
                tLRPC$TL_channel = new TLRPC$TL_chat() { // from class: ir.eitaa.tgnet.TLRPC$TL_chat_old
                    public static int constructor = 1855757255;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chat, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt32(exception2);
                        this.title = stream2.readString(exception2);
                        this.photo = TLRPC$ChatPhoto.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.participants_count = stream2.readInt32(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.left = stream2.readBool(exception2);
                        this.version = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chat, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.title);
                        this.photo.serializeToStream(stream2);
                        stream2.writeInt32(this.participants_count);
                        stream2.writeInt32(this.date);
                        stream2.writeBool(this.left);
                        stream2.writeInt32(this.version);
                    }
                };
                break;
            case 1930607688:
                tLRPC$TL_channel = new TLRPC$TL_chat() { // from class: ir.eitaa.tgnet.TLRPC$TL_chat_old2
                    public static int constructor = 1930607688;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chat, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.creator = (int32 & 1) != 0;
                        this.kicked = (int32 & 2) != 0;
                        this.left = (int32 & 4) != 0;
                        this.deactivated = (int32 & 32) != 0;
                        this.id = stream2.readInt32(exception2);
                        this.title = stream2.readString(exception2);
                        this.photo = TLRPC$ChatPhoto.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.participants_count = stream2.readInt32(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.version = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chat, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.creator ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.kicked ? i | 2 : i & (-3);
                        this.flags = i2;
                        int i3 = this.left ? i2 | 4 : i2 & (-5);
                        this.flags = i3;
                        int i4 = this.deactivated ? i3 | 32 : i3 & (-33);
                        this.flags = i4;
                        stream2.writeInt32(i4);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.title);
                        this.photo.serializeToStream(stream2);
                        stream2.writeInt32(this.participants_count);
                        stream2.writeInt32(this.date);
                        stream2.writeInt32(this.version);
                    }
                };
                break;
            default:
                tLRPC$TL_channel = null;
                break;
        }
        if (tLRPC$TL_channel == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in Chat", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_channel != null) {
            tLRPC$TL_channel.readParams(stream, exception);
        }
        return tLRPC$TL_channel;
    }

    protected static TLRPC$TL_chatBannedRights mergeBannedRights(TLRPC$TL_channelBannedRights_layer92 rights) {
        if (rights == null) {
            return null;
        }
        TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights = new TLRPC$TL_chatBannedRights();
        tLRPC$TL_chatBannedRights.view_messages = rights.view_messages;
        tLRPC$TL_chatBannedRights.send_messages = rights.send_messages;
        boolean z = rights.send_media;
        tLRPC$TL_chatBannedRights.send_media = z;
        tLRPC$TL_chatBannedRights.send_stickers = rights.send_stickers;
        tLRPC$TL_chatBannedRights.send_gifs = rights.send_gifs;
        tLRPC$TL_chatBannedRights.send_games = rights.send_games;
        tLRPC$TL_chatBannedRights.send_inline = rights.send_inline;
        tLRPC$TL_chatBannedRights.embed_links = rights.embed_links;
        tLRPC$TL_chatBannedRights.send_polls = z;
        tLRPC$TL_chatBannedRights.change_info = true;
        tLRPC$TL_chatBannedRights.invite_users = true;
        tLRPC$TL_chatBannedRights.pin_messages = true;
        tLRPC$TL_chatBannedRights.until_date = rights.until_date;
        return tLRPC$TL_chatBannedRights;
    }

    protected static TLRPC$TL_channelBannedRights_layer92 mergeBannedRights(TLRPC$TL_chatBannedRights rights) {
        if (rights == null) {
            return null;
        }
        TLRPC$TL_channelBannedRights_layer92 tLRPC$TL_channelBannedRights_layer92 = new TLRPC$TL_channelBannedRights_layer92();
        tLRPC$TL_channelBannedRights_layer92.view_messages = rights.view_messages;
        tLRPC$TL_channelBannedRights_layer92.send_messages = rights.send_messages;
        tLRPC$TL_channelBannedRights_layer92.send_media = rights.send_media;
        tLRPC$TL_channelBannedRights_layer92.send_stickers = rights.send_stickers;
        tLRPC$TL_channelBannedRights_layer92.send_gifs = rights.send_gifs;
        tLRPC$TL_channelBannedRights_layer92.send_games = rights.send_games;
        tLRPC$TL_channelBannedRights_layer92.send_inline = rights.send_inline;
        tLRPC$TL_channelBannedRights_layer92.embed_links = rights.embed_links;
        tLRPC$TL_channelBannedRights_layer92.until_date = rights.until_date;
        return tLRPC$TL_channelBannedRights_layer92;
    }

    protected static TLRPC$TL_chatAdminRights mergeAdminRights(TLRPC$TL_channelAdminRights_layer92 rights) {
        if (rights == null) {
            return null;
        }
        TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights = new TLRPC$TL_chatAdminRights();
        tLRPC$TL_chatAdminRights.change_info = rights.change_info;
        tLRPC$TL_chatAdminRights.post_messages = rights.post_messages;
        tLRPC$TL_chatAdminRights.edit_messages = rights.edit_messages;
        tLRPC$TL_chatAdminRights.delete_messages = rights.delete_messages;
        tLRPC$TL_chatAdminRights.ban_users = rights.ban_users;
        tLRPC$TL_chatAdminRights.invite_users = rights.invite_users;
        tLRPC$TL_chatAdminRights.pin_messages = rights.pin_messages;
        tLRPC$TL_chatAdminRights.add_admins = rights.add_admins;
        tLRPC$TL_chatAdminRights.post_live = rights.post_live;
        return tLRPC$TL_chatAdminRights;
    }

    protected static TLRPC$TL_channelAdminRights_layer92 mergeAdminRights(TLRPC$TL_chatAdminRights rights) {
        if (rights == null) {
            return null;
        }
        TLRPC$TL_channelAdminRights_layer92 tLRPC$TL_channelAdminRights_layer92 = new TLRPC$TL_channelAdminRights_layer92();
        tLRPC$TL_channelAdminRights_layer92.change_info = rights.change_info;
        tLRPC$TL_channelAdminRights_layer92.post_messages = rights.post_messages;
        tLRPC$TL_channelAdminRights_layer92.edit_messages = rights.edit_messages;
        tLRPC$TL_channelAdminRights_layer92.delete_messages = rights.delete_messages;
        tLRPC$TL_channelAdminRights_layer92.ban_users = rights.ban_users;
        tLRPC$TL_channelAdminRights_layer92.invite_users = rights.invite_users;
        tLRPC$TL_channelAdminRights_layer92.pin_messages = rights.pin_messages;
        tLRPC$TL_channelAdminRights_layer92.add_admins = rights.add_admins;
        tLRPC$TL_channelAdminRights_layer92.post_live = rights.post_live;
        return tLRPC$TL_channelAdminRights_layer92;
    }
}
