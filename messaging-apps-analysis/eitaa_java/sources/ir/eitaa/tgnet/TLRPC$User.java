package ir.eitaa.tgnet;

import java.util.ArrayList;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public abstract class TLRPC$User extends TLObject {
    public boolean MXB_REGISTERED_USER;
    public boolean MXB_VIRTUAL_USER;
    public long access_hash;
    public boolean apply_min_photo;
    public boolean bot;
    public boolean bot_chat_history;
    public int bot_info_version;
    public boolean bot_inline_geo;
    public String bot_inline_placeholder;
    public boolean bot_nochats;
    public boolean contact;
    public boolean deleted;
    public boolean explicit_content;
    public boolean fake;
    public String first_name;
    public int flags;
    public long id;
    public boolean inactive;
    public String lang_code;
    public String last_name;
    public boolean min;
    public boolean mutual_contact;
    public String phone;
    public TLRPC$UserProfilePhoto photo;
    public boolean restricted;
    public ArrayList<TLRPC$TL_restrictionReason> restriction_reason = new ArrayList<>();
    public boolean self;
    public boolean shop;
    public TLRPC$UserStatus status;
    public boolean support;
    public boolean trusty;
    public String username;
    public boolean verified;

    public static TLRPC$User TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$User tLRPC$TL_userContact_old2;
        switch (constructor) {
            case -1820043071:
                tLRPC$TL_userContact_old2 = new TLRPC$TL_user() { // from class: ir.eitaa.tgnet.TLRPC$TL_user_layer131
                    public static int constructor = -1820043071;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_user, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.self = (int32 & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0;
                        this.contact = (int32 & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0;
                        this.mutual_contact = (int32 & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0;
                        this.deleted = (int32 & 8192) != 0;
                        this.bot = (int32 & 16384) != 0;
                        this.bot_chat_history = (32768 & int32) != 0;
                        this.bot_nochats = (65536 & int32) != 0;
                        this.verified = (131072 & int32) != 0;
                        this.restricted = (int32 & 262144) != 0;
                        this.min = (1048576 & int32) != 0;
                        this.bot_inline_geo = (2097152 & int32) != 0;
                        this.support = (8388608 & int32) != 0;
                        this.trusty = (16777216 & int32) != 0;
                        this.apply_min_photo = (33554432 & int32) != 0;
                        this.fake = (int32 & ConnectionsManager.FileTypeFile) != 0;
                        this.id = stream2.readInt32(exception2);
                        if ((this.flags & 1) != 0) {
                            this.access_hash = stream2.readInt64(exception2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.first_name = stream2.readString(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.last_name = stream2.readString(exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            this.username = stream2.readString(exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.phone = stream2.readString(exception2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.photo = TLRPC$UserProfilePhoto.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.status = TLRPC$UserStatus.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 16384) != 0) {
                            this.bot_info_version = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 262144) != 0) {
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
                        if ((this.flags & 524288) != 0) {
                            this.bot_inline_placeholder = stream2.readString(exception2);
                        }
                        if ((this.flags & 4194304) != 0) {
                            this.lang_code = stream2.readString(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_user, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.self ? this.flags | Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV : this.flags & (-1025);
                        this.flags = i;
                        int i2 = this.contact ? i | Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS : i & (-2049);
                        this.flags = i2;
                        int i3 = this.mutual_contact ? i2 | Factory.DEVICE_HAS_CRAPPY_AAUDIO : i2 & (-4097);
                        this.flags = i3;
                        int i4 = this.deleted ? i3 | 8192 : i3 & (-8193);
                        this.flags = i4;
                        int i5 = this.bot ? i4 | 16384 : i4 & (-16385);
                        this.flags = i5;
                        int i6 = this.bot_chat_history ? i5 | 32768 : i5 & (-32769);
                        this.flags = i6;
                        int i7 = this.bot_nochats ? i6 | 65536 : i6 & (-65537);
                        this.flags = i7;
                        int i8 = this.verified ? i7 | 131072 : i7 & (-131073);
                        this.flags = i8;
                        int i9 = this.restricted ? i8 | 262144 : i8 & (-262145);
                        this.flags = i9;
                        int i10 = this.min ? i9 | 1048576 : i9 & (-1048577);
                        this.flags = i10;
                        int i11 = this.bot_inline_geo ? i10 | 2097152 : i10 & (-2097153);
                        this.flags = i11;
                        int i12 = this.support ? i11 | 8388608 : i11 & (-8388609);
                        this.flags = i12;
                        int i13 = this.trusty ? i12 | ConnectionsManager.FileTypePhoto : i12 & (-16777217);
                        this.flags = i13;
                        int i14 = this.apply_min_photo ? i13 | ConnectionsManager.FileTypeVideo : i13 & (-33554433);
                        this.flags = i14;
                        int i15 = this.fake ? i14 | ConnectionsManager.FileTypeFile : i14 & (-67108865);
                        this.flags = i15;
                        stream2.writeInt32(i15);
                        stream2.writeInt32((int) this.id);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt64(this.access_hash);
                        }
                        if ((this.flags & 2) != 0) {
                            stream2.writeString(this.first_name);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeString(this.last_name);
                        }
                        if ((this.flags & 8) != 0) {
                            stream2.writeString(this.username);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeString(this.phone);
                        }
                        if ((this.flags & 32) != 0) {
                            this.photo.serializeToStream(stream2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.status.serializeToStream(stream2);
                        }
                        if ((this.flags & 16384) != 0) {
                            stream2.writeInt32(this.bot_info_version);
                        }
                        if ((this.flags & 262144) != 0) {
                            stream2.writeInt32(481674261);
                            int size = this.restriction_reason.size();
                            stream2.writeInt32(size);
                            for (int i16 = 0; i16 < size; i16++) {
                                this.restriction_reason.get(i16).serializeToStream(stream2);
                            }
                        }
                        if ((this.flags & 524288) != 0) {
                            stream2.writeString(this.bot_inline_placeholder);
                        }
                        if ((this.flags & 4194304) != 0) {
                            stream2.writeString(this.lang_code);
                        }
                    }
                };
                break;
            case -1298475060:
                tLRPC$TL_userContact_old2 = new TLRPC$TL_userDeleted_old2() { // from class: ir.eitaa.tgnet.TLRPC$TL_userDeleted_old
                    public static int constructor = -1298475060;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_userDeleted_old2, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt32(exception2);
                        this.first_name = stream2.readString(exception2);
                        this.last_name = stream2.readString(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_userDeleted_old2, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.first_name);
                        stream2.writeString(this.last_name);
                    }
                };
                break;
            case -894214632:
                tLRPC$TL_userContact_old2 = new TLRPC$TL_userContact_old2();
                break;
            case -787638374:
                tLRPC$TL_userContact_old2 = new TLRPC$TL_user() { // from class: ir.eitaa.tgnet.TLRPC$TL_user_layer65
                    public static int constructor = -787638374;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_user, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.self = (int32 & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0;
                        this.contact = (int32 & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0;
                        this.mutual_contact = (int32 & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0;
                        this.deleted = (int32 & 8192) != 0;
                        this.bot = (int32 & 16384) != 0;
                        this.bot_chat_history = (32768 & int32) != 0;
                        this.bot_nochats = (65536 & int32) != 0;
                        this.verified = (131072 & int32) != 0;
                        this.restricted = (int32 & 262144) != 0;
                        this.min = (1048576 & int32) != 0;
                        this.bot_inline_geo = (int32 & 2097152) != 0;
                        this.id = stream2.readInt32(exception2);
                        if ((this.flags & 1) != 0) {
                            this.access_hash = stream2.readInt64(exception2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.first_name = stream2.readString(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.last_name = stream2.readString(exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            this.username = stream2.readString(exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.phone = stream2.readString(exception2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.photo = TLRPC$UserProfilePhoto.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.status = TLRPC$UserStatus.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 16384) != 0) {
                            this.bot_info_version = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 262144) != 0) {
                            stream2.readString(exception2);
                        }
                        if ((this.flags & 524288) != 0) {
                            this.bot_inline_placeholder = stream2.readString(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_user, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.self ? this.flags | Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV : this.flags & (-1025);
                        this.flags = i;
                        int i2 = this.contact ? i | Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS : i & (-2049);
                        this.flags = i2;
                        int i3 = this.mutual_contact ? i2 | Factory.DEVICE_HAS_CRAPPY_AAUDIO : i2 & (-4097);
                        this.flags = i3;
                        int i4 = this.deleted ? i3 | 8192 : i3 & (-8193);
                        this.flags = i4;
                        int i5 = this.bot ? i4 | 16384 : i4 & (-16385);
                        this.flags = i5;
                        int i6 = this.bot_chat_history ? i5 | 32768 : i5 & (-32769);
                        this.flags = i6;
                        int i7 = this.bot_nochats ? i6 | 65536 : i6 & (-65537);
                        this.flags = i7;
                        int i8 = this.verified ? i7 | 131072 : i7 & (-131073);
                        this.flags = i8;
                        int i9 = this.restricted ? i8 | 262144 : i8 & (-262145);
                        this.flags = i9;
                        int i10 = this.min ? i9 | 1048576 : i9 & (-1048577);
                        this.flags = i10;
                        int i11 = this.bot_inline_geo ? i10 | 2097152 : i10 & (-2097153);
                        this.flags = i11;
                        stream2.writeInt32(i11);
                        stream2.writeInt32((int) this.id);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt64(this.access_hash);
                        }
                        if ((this.flags & 2) != 0) {
                            stream2.writeString(this.first_name);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeString(this.last_name);
                        }
                        if ((this.flags & 8) != 0) {
                            stream2.writeString(this.username);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeString(this.phone);
                        }
                        if ((this.flags & 32) != 0) {
                            this.photo.serializeToStream(stream2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.status.serializeToStream(stream2);
                        }
                        if ((this.flags & 16384) != 0) {
                            stream2.writeInt32(this.bot_info_version);
                        }
                        if ((this.flags & 262144) != 0) {
                            stream2.writeString("");
                        }
                        if ((this.flags & 524288) != 0) {
                            stream2.writeString(this.bot_inline_placeholder);
                        }
                    }
                };
                break;
            case -742634630:
                tLRPC$TL_userContact_old2 = new TLRPC$TL_userEmpty();
                break;
            case -704549510:
                tLRPC$TL_userContact_old2 = new TLRPC$TL_userDeleted_old2();
                break;
            case -640891665:
                tLRPC$TL_userContact_old2 = new TLRPC$TL_userRequest_old2();
                break;
            case -218397927:
                tLRPC$TL_userContact_old2 = new TLRPC$TL_userContact_old2() { // from class: ir.eitaa.tgnet.TLRPC$TL_userContact_old
                    public static int constructor = -218397927;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_userContact_old2, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt32(exception2);
                        this.first_name = stream2.readString(exception2);
                        this.last_name = stream2.readString(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.phone = stream2.readString(exception2);
                        this.photo = TLRPC$UserProfilePhoto.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.status = TLRPC$UserStatus.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_userContact_old2, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.first_name);
                        stream2.writeString(this.last_name);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeString(this.phone);
                        this.photo.serializeToStream(stream2);
                        this.status.serializeToStream(stream2);
                    }
                };
                break;
            case 123533224:
                tLRPC$TL_userContact_old2 = new TLRPC$TL_userForeign_old2();
                break;
            case 476112392:
                tLRPC$TL_userContact_old2 = new TLRPC$TL_userSelf_old3();
                break;
            case 537022650:
                tLRPC$TL_userContact_old2 = new TLRPC$TL_userEmpty() { // from class: ir.eitaa.tgnet.TLRPC$TL_userEmpty_layer131
                    public static int constructor = 537022650;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_userEmpty, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_userEmpty, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.id);
                    }
                };
                break;
            case 585404530:
                tLRPC$TL_userContact_old2 = new TLRPC$TL_user() { // from class: ir.eitaa.tgnet.TLRPC$TL_user_old
                    public static int constructor = 585404530;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_user, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.self = (int32 & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0;
                        this.contact = (int32 & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0;
                        this.mutual_contact = (int32 & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0;
                        this.deleted = (int32 & 8192) != 0;
                        this.bot = (int32 & 16384) != 0;
                        this.bot_chat_history = (32768 & int32) != 0;
                        this.bot_nochats = (65536 & int32) != 0;
                        this.verified = (131072 & int32) != 0;
                        this.explicit_content = (int32 & 262144) != 0;
                        this.id = stream2.readInt32(exception2);
                        if ((this.flags & 1) != 0) {
                            this.access_hash = stream2.readInt64(exception2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.first_name = stream2.readString(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.last_name = stream2.readString(exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            this.username = stream2.readString(exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.phone = stream2.readString(exception2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.photo = TLRPC$UserProfilePhoto.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.status = TLRPC$UserStatus.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 16384) != 0) {
                            this.bot_info_version = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_user, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.self ? this.flags | Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV : this.flags & (-1025);
                        this.flags = i;
                        int i2 = this.contact ? i | Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS : i & (-2049);
                        this.flags = i2;
                        int i3 = this.mutual_contact ? i2 | Factory.DEVICE_HAS_CRAPPY_AAUDIO : i2 & (-4097);
                        this.flags = i3;
                        int i4 = this.deleted ? i3 | 8192 : i3 & (-8193);
                        this.flags = i4;
                        int i5 = this.bot ? i4 | 16384 : i4 & (-16385);
                        this.flags = i5;
                        int i6 = this.bot_chat_history ? i5 | 32768 : i5 & (-32769);
                        this.flags = i6;
                        int i7 = this.bot_nochats ? i6 | 65536 : i6 & (-65537);
                        this.flags = i7;
                        int i8 = this.verified ? i7 | 131072 : i7 & (-131073);
                        this.flags = i8;
                        int i9 = this.explicit_content ? i8 | 262144 : i8 & (-262145);
                        this.flags = i9;
                        stream2.writeInt32(i9);
                        stream2.writeInt32((int) this.id);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt64(this.access_hash);
                        }
                        if ((this.flags & 2) != 0) {
                            stream2.writeString(this.first_name);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeString(this.last_name);
                        }
                        if ((this.flags & 8) != 0) {
                            stream2.writeString(this.username);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeString(this.phone);
                        }
                        if ((this.flags & 32) != 0) {
                            this.photo.serializeToStream(stream2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.status.serializeToStream(stream2);
                        }
                        if ((this.flags & 16384) != 0) {
                            stream2.writeInt32(this.bot_info_version);
                        }
                    }
                };
                break;
            case 585682608:
                tLRPC$TL_userContact_old2 = new TLRPC$TL_userRequest_old2() { // from class: ir.eitaa.tgnet.TLRPC$TL_userRequest_old
                    public static int constructor = 585682608;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_userRequest_old2, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt32(exception2);
                        this.first_name = stream2.readString(exception2);
                        this.last_name = stream2.readString(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.phone = stream2.readString(exception2);
                        this.photo = TLRPC$UserProfilePhoto.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.status = TLRPC$UserStatus.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_userRequest_old2, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.first_name);
                        stream2.writeString(this.last_name);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeString(this.phone);
                        this.photo.serializeToStream(stream2);
                        this.status.serializeToStream(stream2);
                    }
                };
                break;
            case 773059779:
                tLRPC$TL_userContact_old2 = new TLRPC$TL_user() { // from class: ir.eitaa.tgnet.TLRPC$TL_user_layer104
                    public static int constructor = 773059779;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_user, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.self = (int32 & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0;
                        this.contact = (int32 & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0;
                        this.mutual_contact = (int32 & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0;
                        this.deleted = (int32 & 8192) != 0;
                        this.bot = (int32 & 16384) != 0;
                        this.bot_chat_history = (32768 & int32) != 0;
                        this.bot_nochats = (65536 & int32) != 0;
                        this.verified = (131072 & int32) != 0;
                        this.restricted = (int32 & 262144) != 0;
                        this.min = (1048576 & int32) != 0;
                        this.bot_inline_geo = (2097152 & int32) != 0;
                        this.support = (int32 & 8388608) != 0;
                        this.id = stream2.readInt32(exception2);
                        if ((this.flags & 1) != 0) {
                            this.access_hash = stream2.readInt64(exception2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.first_name = stream2.readString(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.last_name = stream2.readString(exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            this.username = stream2.readString(exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.phone = stream2.readString(exception2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.photo = TLRPC$UserProfilePhoto.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.status = TLRPC$UserStatus.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 16384) != 0) {
                            this.bot_info_version = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 262144) != 0) {
                            stream2.readString(exception2);
                        }
                        if ((this.flags & 524288) != 0) {
                            this.bot_inline_placeholder = stream2.readString(exception2);
                        }
                        if ((this.flags & 4194304) != 0) {
                            this.lang_code = stream2.readString(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_user, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.self ? this.flags | Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV : this.flags & (-1025);
                        this.flags = i;
                        int i2 = this.contact ? i | Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS : i & (-2049);
                        this.flags = i2;
                        int i3 = this.mutual_contact ? i2 | Factory.DEVICE_HAS_CRAPPY_AAUDIO : i2 & (-4097);
                        this.flags = i3;
                        int i4 = this.deleted ? i3 | 8192 : i3 & (-8193);
                        this.flags = i4;
                        int i5 = this.bot ? i4 | 16384 : i4 & (-16385);
                        this.flags = i5;
                        int i6 = this.bot_chat_history ? i5 | 32768 : i5 & (-32769);
                        this.flags = i6;
                        int i7 = this.bot_nochats ? i6 | 65536 : i6 & (-65537);
                        this.flags = i7;
                        int i8 = this.verified ? i7 | 131072 : i7 & (-131073);
                        this.flags = i8;
                        int i9 = this.restricted ? i8 | 262144 : i8 & (-262145);
                        this.flags = i9;
                        int i10 = this.min ? i9 | 1048576 : i9 & (-1048577);
                        this.flags = i10;
                        int i11 = this.bot_inline_geo ? i10 | 2097152 : i10 & (-2097153);
                        this.flags = i11;
                        int i12 = this.support ? i11 | 8388608 : i11 & (-8388609);
                        this.flags = i12;
                        stream2.writeInt32(i12);
                        stream2.writeInt32((int) this.id);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt64(this.access_hash);
                        }
                        if ((this.flags & 2) != 0) {
                            stream2.writeString(this.first_name);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeString(this.last_name);
                        }
                        if ((this.flags & 8) != 0) {
                            stream2.writeString(this.username);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeString(this.phone);
                        }
                        if ((this.flags & 32) != 0) {
                            this.photo.serializeToStream(stream2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.status.serializeToStream(stream2);
                        }
                        if ((this.flags & 16384) != 0) {
                            stream2.writeInt32(this.bot_info_version);
                        }
                        if ((this.flags & 262144) != 0) {
                            stream2.writeString("");
                        }
                        if ((this.flags & 524288) != 0) {
                            stream2.writeString(this.bot_inline_placeholder);
                        }
                        if ((this.flags & 4194304) != 0) {
                            stream2.writeString(this.lang_code);
                        }
                    }
                };
                break;
            case 1073147056:
                tLRPC$TL_userContact_old2 = new TLRPC$TL_user();
                break;
            case 1377093789:
                tLRPC$TL_userContact_old2 = new TLRPC$TL_userForeign_old2() { // from class: ir.eitaa.tgnet.TLRPC$TL_userForeign_old
                    public static int constructor = 1377093789;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_userForeign_old2, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt32(exception2);
                        this.first_name = stream2.readString(exception2);
                        this.last_name = stream2.readString(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.photo = TLRPC$UserProfilePhoto.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.status = TLRPC$UserStatus.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_userForeign_old2, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.first_name);
                        stream2.writeString(this.last_name);
                        stream2.writeInt64(this.access_hash);
                        this.photo.serializeToStream(stream2);
                        this.status.serializeToStream(stream2);
                    }
                };
                break;
            case 1879553105:
                tLRPC$TL_userContact_old2 = new TLRPC$TL_userSelf_old3() { // from class: ir.eitaa.tgnet.TLRPC$TL_userSelf_old2
                    public static int constructor = 1879553105;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_userSelf_old3, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt32(exception2);
                        this.first_name = stream2.readString(exception2);
                        this.last_name = stream2.readString(exception2);
                        this.username = stream2.readString(exception2);
                        this.phone = stream2.readString(exception2);
                        this.photo = TLRPC$UserProfilePhoto.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.status = TLRPC$UserStatus.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.inactive = stream2.readBool(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_userSelf_old3, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.first_name);
                        stream2.writeString(this.last_name);
                        stream2.writeString(this.username);
                        stream2.writeString(this.phone);
                        this.photo.serializeToStream(stream2);
                        this.status.serializeToStream(stream2);
                        stream2.writeBool(this.inactive);
                    }
                };
                break;
            case 1912944108:
                tLRPC$TL_userContact_old2 = new TLRPC$TL_userSelf_old3() { // from class: ir.eitaa.tgnet.TLRPC$TL_userSelf_old
                    public static int constructor = 1912944108;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_userSelf_old3, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt32(exception2);
                        this.first_name = stream2.readString(exception2);
                        this.last_name = stream2.readString(exception2);
                        this.phone = stream2.readString(exception2);
                        this.photo = TLRPC$UserProfilePhoto.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.status = TLRPC$UserStatus.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.inactive = stream2.readBool(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_userSelf_old3, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.id);
                        stream2.writeString(this.first_name);
                        stream2.writeString(this.last_name);
                        stream2.writeString(this.phone);
                        this.photo.serializeToStream(stream2);
                        this.status.serializeToStream(stream2);
                        stream2.writeBool(this.inactive);
                    }
                };
                break;
            default:
                tLRPC$TL_userContact_old2 = null;
                break;
        }
        if (tLRPC$TL_userContact_old2 == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in User", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_userContact_old2 != null) {
            tLRPC$TL_userContact_old2.readParams(stream, exception);
        }
        return tLRPC$TL_userContact_old2;
    }
}
