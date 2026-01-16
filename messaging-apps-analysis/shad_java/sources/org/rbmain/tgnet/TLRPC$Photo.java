package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class TLRPC$Photo extends TLObject {
    public long access_hash;
    public String avatr_id;
    public String caption;
    public String cdnTag;
    public int date;
    public int dc_id;
    public byte[] file_reference;
    public int flags;
    public TLRPC$GeoPoint geo;
    public boolean has_stickers;
    public long id;
    public long main_file_id;
    public int user_id;
    public ArrayList<TLRPC$PhotoSize> sizes = new ArrayList<>();
    public ArrayList<TLRPC$VideoSize> video_sizes = new ArrayList<>();

    public static TLRPC$Photo TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$Photo tLRPC$TL_photo;
        switch (i) {
            case -1836524247:
                tLRPC$TL_photo = new TLRPC$TL_photo() { // from class: org.rbmain.tgnet.TLRPC$TL_photo_layer82
                    public static int constructor = -1836524247;

                    @Override // org.rbmain.tgnet.TLRPC$TL_photo, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.has_stickers = (int32 & 1) != 0;
                        this.id = abstractSerializedData2.readInt64(z2);
                        this.access_hash = abstractSerializedData2.readInt64(z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                        int int322 = abstractSerializedData2.readInt32(z2);
                        if (int322 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int323; i2++) {
                            TLRPC$PhotoSize tLRPC$PhotoSizeTLdeserialize = TLRPC$PhotoSize.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$PhotoSizeTLdeserialize == null) {
                                return;
                            }
                            this.sizes.add(tLRPC$PhotoSizeTLdeserialize);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_photo, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.has_stickers ? this.flags | 1 : this.flags & (-2);
                        this.flags = i2;
                        abstractSerializedData2.writeInt32(i2);
                        abstractSerializedData2.writeInt64(this.id);
                        abstractSerializedData2.writeInt64(this.access_hash);
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.sizes.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i3 = 0; i3 < size; i3++) {
                            this.sizes.get(i3).serializeToStream(abstractSerializedData2);
                        }
                    }
                };
                break;
            case -1673036328:
                tLRPC$TL_photo = new TLRPC$TL_photo() { // from class: org.rbmain.tgnet.TLRPC$TL_photo_layer97
                    public static int constructor = -1673036328;

                    @Override // org.rbmain.tgnet.TLRPC$TL_photo, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.has_stickers = (int32 & 1) != 0;
                        this.id = abstractSerializedData2.readInt64(z2);
                        this.access_hash = abstractSerializedData2.readInt64(z2);
                        this.file_reference = abstractSerializedData2.readByteArray(z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                        int int322 = abstractSerializedData2.readInt32(z2);
                        if (int322 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int323; i2++) {
                            TLRPC$PhotoSize tLRPC$PhotoSizeTLdeserialize = TLRPC$PhotoSize.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$PhotoSizeTLdeserialize == null) {
                                return;
                            }
                            this.sizes.add(tLRPC$PhotoSizeTLdeserialize);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_photo, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.has_stickers ? this.flags | 1 : this.flags & (-2);
                        this.flags = i2;
                        abstractSerializedData2.writeInt32(i2);
                        abstractSerializedData2.writeInt64(this.id);
                        abstractSerializedData2.writeInt64(this.access_hash);
                        abstractSerializedData2.writeByteArray(this.file_reference);
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.sizes.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i3 = 0; i3 < size; i3++) {
                            this.sizes.get(i3).serializeToStream(abstractSerializedData2);
                        }
                    }
                };
                break;
            case -1014792074:
                tLRPC$TL_photo = new TLRPC$TL_photo() { // from class: org.rbmain.tgnet.TLRPC$TL_photo_old2
                    public static int constructor = -1014792074;

                    @Override // org.rbmain.tgnet.TLRPC$TL_photo, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.id = abstractSerializedData2.readInt64(z2);
                        this.access_hash = abstractSerializedData2.readInt64(z2);
                        this.user_id = abstractSerializedData2.readInt32(z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.geo = TLRPC$GeoPoint.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        int int32 = abstractSerializedData2.readInt32(z2);
                        if (int32 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int322; i2++) {
                            TLRPC$PhotoSize tLRPC$PhotoSizeTLdeserialize = TLRPC$PhotoSize.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$PhotoSizeTLdeserialize == null) {
                                return;
                            }
                            this.sizes.add(tLRPC$PhotoSizeTLdeserialize);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_photo, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt64(this.id);
                        abstractSerializedData2.writeInt64(this.access_hash);
                        abstractSerializedData2.writeInt32(this.user_id);
                        abstractSerializedData2.writeInt32(this.date);
                        this.geo.serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.sizes.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i2 = 0; i2 < size; i2++) {
                            this.sizes.get(i2).serializeToStream(abstractSerializedData2);
                        }
                    }
                };
                break;
            case -840088834:
                tLRPC$TL_photo = new TLRPC$TL_photo() { // from class: org.rbmain.tgnet.TLRPC$TL_photo_layer55
                    public static int constructor = -840088834;

                    @Override // org.rbmain.tgnet.TLRPC$TL_photo, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.id = abstractSerializedData2.readInt64(z2);
                        this.access_hash = abstractSerializedData2.readInt64(z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                        int int32 = abstractSerializedData2.readInt32(z2);
                        if (int32 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int322; i2++) {
                            TLRPC$PhotoSize tLRPC$PhotoSizeTLdeserialize = TLRPC$PhotoSize.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$PhotoSizeTLdeserialize == null) {
                                return;
                            }
                            this.sizes.add(tLRPC$PhotoSizeTLdeserialize);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_photo, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt64(this.id);
                        abstractSerializedData2.writeInt64(this.access_hash);
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.sizes.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i2 = 0; i2 < size; i2++) {
                            this.sizes.get(i2).serializeToStream(abstractSerializedData2);
                        }
                    }
                };
                break;
            case -797637467:
                tLRPC$TL_photo = new TLRPC$TL_photo() { // from class: org.rbmain.tgnet.TLRPC$TL_photo_layer115
                    public static int constructor = -797637467;

                    @Override // org.rbmain.tgnet.TLRPC$TL_photo, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.has_stickers = (int32 & 1) != 0;
                        this.id = abstractSerializedData2.readInt64(z2);
                        this.access_hash = abstractSerializedData2.readInt64(z2);
                        this.file_reference = abstractSerializedData2.readByteArray(z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                        int int322 = abstractSerializedData2.readInt32(z2);
                        if (int322 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int323; i2++) {
                            TLRPC$PhotoSize tLRPC$PhotoSizeTLdeserialize = TLRPC$PhotoSize.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$PhotoSizeTLdeserialize == null) {
                                return;
                            }
                            this.sizes.add(tLRPC$PhotoSizeTLdeserialize);
                        }
                        this.dc_id = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_photo, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.has_stickers ? this.flags | 1 : this.flags & (-2);
                        this.flags = i2;
                        abstractSerializedData2.writeInt32(i2);
                        abstractSerializedData2.writeInt64(this.id);
                        abstractSerializedData2.writeInt64(this.access_hash);
                        abstractSerializedData2.writeByteArray(this.file_reference);
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.sizes.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i3 = 0; i3 < size; i3++) {
                            this.sizes.get(i3).serializeToStream(abstractSerializedData2);
                        }
                        abstractSerializedData2.writeInt32(this.dc_id);
                    }
                };
                break;
            case -82216347:
                tLRPC$TL_photo = new TLRPC$TL_photo();
                break;
            case 582313809:
                tLRPC$TL_photo = new TLRPC$TL_photo() { // from class: org.rbmain.tgnet.TLRPC$TL_photo_old
                    public static int constructor = 582313809;

                    @Override // org.rbmain.tgnet.TLRPC$TL_photo, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.id = abstractSerializedData2.readInt64(z2);
                        this.access_hash = abstractSerializedData2.readInt64(z2);
                        this.user_id = abstractSerializedData2.readInt32(z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.caption = abstractSerializedData2.readString(z2);
                        this.geo = TLRPC$GeoPoint.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        int int32 = abstractSerializedData2.readInt32(z2);
                        if (int32 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int322; i2++) {
                            TLRPC$PhotoSize tLRPC$PhotoSizeTLdeserialize = TLRPC$PhotoSize.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$PhotoSizeTLdeserialize == null) {
                                return;
                            }
                            this.sizes.add(tLRPC$PhotoSizeTLdeserialize);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_photo, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt64(this.id);
                        abstractSerializedData2.writeInt64(this.access_hash);
                        abstractSerializedData2.writeInt32(this.user_id);
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeString(this.caption);
                        this.geo.serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.sizes.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i2 = 0; i2 < size; i2++) {
                            this.sizes.get(i2).serializeToStream(abstractSerializedData2);
                        }
                    }
                };
                break;
            case 590459437:
                tLRPC$TL_photo = new TLRPC$TL_photoEmpty();
                break;
            default:
                tLRPC$TL_photo = null;
                break;
        }
        if (tLRPC$TL_photo == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in Photo", Integer.valueOf(i)));
        }
        if (tLRPC$TL_photo != null) {
            tLRPC$TL_photo.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_photo;
    }
}
