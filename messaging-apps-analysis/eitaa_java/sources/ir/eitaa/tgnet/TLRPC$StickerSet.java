package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$StickerSet extends TLObject {
    public long access_hash;
    public boolean animated;
    public boolean archived;
    public int count;
    public int flags;
    public int hash;
    public long id;
    public boolean installed;
    public int installed_date;
    public boolean masks;
    public boolean official;
    public String short_name;
    public int thumb_dc_id;
    public int thumb_version;
    public ArrayList<TLRPC$PhotoSize> thumbs = new ArrayList<>();
    public String title;

    public static TLRPC$StickerSet TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$TL_stickerSet tLRPC$TL_stickerSet;
        switch (constructor) {
            case -1482409193:
                tLRPC$TL_stickerSet = new TLRPC$TL_stickerSet() { // from class: ir.eitaa.tgnet.TLRPC$TL_stickerSet_old
                    public static int constructor = -1482409193;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_stickerSet, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt64(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.title = stream2.readString(exception2);
                        this.short_name = stream2.readString(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_stickerSet, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt64(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeString(this.title);
                        stream2.writeString(this.short_name);
                    }
                };
                break;
            case -852477119:
                tLRPC$TL_stickerSet = new TLRPC$TL_stickerSet() { // from class: ir.eitaa.tgnet.TLRPC$TL_stickerSet_layer75
                    public static int constructor = -852477119;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_stickerSet, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.installed = (int32 & 1) != 0;
                        this.archived = (int32 & 2) != 0;
                        this.official = (int32 & 4) != 0;
                        this.masks = (int32 & 8) != 0;
                        this.id = stream2.readInt64(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.title = stream2.readString(exception2);
                        this.short_name = stream2.readString(exception2);
                        this.count = stream2.readInt32(exception2);
                        this.hash = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_stickerSet, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.installed ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.archived ? i | 2 : i & (-3);
                        this.flags = i2;
                        int i3 = this.official ? i2 | 4 : i2 & (-5);
                        this.flags = i3;
                        int i4 = this.masks ? i3 | 8 : i3 & (-9);
                        this.flags = i4;
                        stream2.writeInt32(i4);
                        stream2.writeInt64(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeString(this.title);
                        stream2.writeString(this.short_name);
                        stream2.writeInt32(this.count);
                        stream2.writeInt32(this.hash);
                    }
                };
                break;
            case -673242758:
                tLRPC$TL_stickerSet = new TLRPC$TL_stickerSet();
                break;
            case -290164953:
                tLRPC$TL_stickerSet = new TLRPC$TL_stickerSet() { // from class: ir.eitaa.tgnet.TLRPC$TL_stickerSet_layer121
                    public static int constructor = -290164953;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_stickerSet, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        TLRPC$PhotoSize tLRPC$PhotoSizeTLdeserialize;
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.archived = (int32 & 2) != 0;
                        this.official = (int32 & 4) != 0;
                        this.masks = (int32 & 8) != 0;
                        this.animated = (int32 & 32) != 0;
                        if ((int32 & 1) != 0) {
                            this.installed_date = stream2.readInt32(exception2);
                        }
                        this.id = stream2.readInt64(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.title = stream2.readString(exception2);
                        this.short_name = stream2.readString(exception2);
                        if ((this.flags & 16) != 0 && (tLRPC$PhotoSizeTLdeserialize = TLRPC$PhotoSize.TLdeserialize(0L, 0L, 0L, stream2, stream2.readInt32(exception2), exception2)) != null) {
                            this.thumbs.add(tLRPC$PhotoSizeTLdeserialize);
                        }
                        if ((this.flags & 16) != 0) {
                            this.thumb_dc_id = stream2.readInt32(exception2);
                        }
                        this.count = stream2.readInt32(exception2);
                        this.hash = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_stickerSet, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.archived ? this.flags | 2 : this.flags & (-3);
                        this.flags = i;
                        int i2 = this.official ? i | 4 : i & (-5);
                        this.flags = i2;
                        int i3 = this.masks ? i2 | 8 : i2 & (-9);
                        this.flags = i3;
                        int i4 = this.animated ? i3 | 32 : i3 & (-33);
                        this.flags = i4;
                        stream2.writeInt32(i4);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32(this.installed_date);
                        }
                        stream2.writeInt64(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeString(this.title);
                        stream2.writeString(this.short_name);
                        if ((this.flags & 16) != 0) {
                            this.thumbs.get(0).serializeToStream(stream2);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32(this.thumb_dc_id);
                        }
                        stream2.writeInt32(this.count);
                        stream2.writeInt32(this.hash);
                    }
                };
                break;
            case 1088567208:
                tLRPC$TL_stickerSet = new TLRPC$TL_stickerSet() { // from class: ir.eitaa.tgnet.TLRPC$TL_stickerSet_layer126
                    public static int constructor = 1088567208;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_stickerSet, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.archived = (int32 & 2) != 0;
                        this.official = (int32 & 4) != 0;
                        this.masks = (int32 & 8) != 0;
                        this.animated = (int32 & 32) != 0;
                        if ((int32 & 1) != 0) {
                            this.installed_date = stream2.readInt32(exception2);
                        }
                        this.id = stream2.readInt64(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.title = stream2.readString(exception2);
                        this.short_name = stream2.readString(exception2);
                        if ((this.flags & 16) != 0) {
                            int int322 = stream2.readInt32(exception2);
                            if (int322 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = stream2.readInt32(exception2);
                            for (int i = 0; i < int323; i++) {
                                TLRPC$PhotoSize tLRPC$PhotoSizeTLdeserialize = TLRPC$PhotoSize.TLdeserialize(0L, 0L, 0L, stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$PhotoSizeTLdeserialize == null) {
                                    return;
                                }
                                this.thumbs.add(tLRPC$PhotoSizeTLdeserialize);
                            }
                        }
                        if ((this.flags & 16) != 0) {
                            this.thumb_dc_id = stream2.readInt32(exception2);
                        }
                        this.count = stream2.readInt32(exception2);
                        this.hash = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_stickerSet, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.archived ? this.flags | 2 : this.flags & (-3);
                        this.flags = i;
                        int i2 = this.official ? i | 4 : i & (-5);
                        this.flags = i2;
                        int i3 = this.masks ? i2 | 8 : i2 & (-9);
                        this.flags = i3;
                        int i4 = this.animated ? i3 | 32 : i3 & (-33);
                        this.flags = i4;
                        stream2.writeInt32(i4);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32(this.installed_date);
                        }
                        stream2.writeInt64(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeString(this.title);
                        stream2.writeString(this.short_name);
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32(481674261);
                            int size = this.thumbs.size();
                            stream2.writeInt32(size);
                            for (int i5 = 0; i5 < size; i5++) {
                                this.thumbs.get(i5).serializeToStream(stream2);
                            }
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32(this.thumb_dc_id);
                        }
                        stream2.writeInt32(this.count);
                        stream2.writeInt32(this.hash);
                    }
                };
                break;
            case 1434820921:
                tLRPC$TL_stickerSet = new TLRPC$TL_stickerSet() { // from class: ir.eitaa.tgnet.TLRPC$TL_stickerSet_layer96
                    public static int constructor = 1434820921;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_stickerSet, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.archived = (int32 & 2) != 0;
                        this.official = (int32 & 4) != 0;
                        this.masks = (int32 & 8) != 0;
                        if ((int32 & 1) != 0) {
                            this.installed_date = stream2.readInt32(exception2);
                        }
                        this.id = stream2.readInt64(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.title = stream2.readString(exception2);
                        this.short_name = stream2.readString(exception2);
                        this.count = stream2.readInt32(exception2);
                        this.hash = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_stickerSet, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.archived ? this.flags | 2 : this.flags & (-3);
                        this.flags = i;
                        int i2 = this.official ? i | 4 : i & (-5);
                        this.flags = i2;
                        int i3 = this.masks ? i2 | 8 : i2 & (-9);
                        this.flags = i3;
                        stream2.writeInt32(i3);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32(this.installed_date);
                        }
                        stream2.writeInt64(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeString(this.title);
                        stream2.writeString(this.short_name);
                        stream2.writeInt32(this.count);
                        stream2.writeInt32(this.hash);
                    }
                };
                break;
            case 1787870391:
                tLRPC$TL_stickerSet = new TLRPC$TL_stickerSet() { // from class: ir.eitaa.tgnet.TLRPC$TL_stickerSet_layer97
                    public static int constructor = 1787870391;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_stickerSet, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        TLRPC$PhotoSize tLRPC$PhotoSizeTLdeserialize;
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.archived = (int32 & 2) != 0;
                        this.official = (int32 & 4) != 0;
                        this.masks = (int32 & 8) != 0;
                        if ((int32 & 1) != 0) {
                            this.installed_date = stream2.readInt32(exception2);
                        }
                        this.id = stream2.readInt64(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.title = stream2.readString(exception2);
                        this.short_name = stream2.readString(exception2);
                        if ((this.flags & 16) != 0 && (tLRPC$PhotoSizeTLdeserialize = TLRPC$PhotoSize.TLdeserialize(0L, 0L, 0L, stream2, stream2.readInt32(exception2), exception2)) != null) {
                            this.thumbs.add(tLRPC$PhotoSizeTLdeserialize);
                        }
                        this.count = stream2.readInt32(exception2);
                        this.hash = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_stickerSet, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.archived ? this.flags | 2 : this.flags & (-3);
                        this.flags = i;
                        int i2 = this.official ? i | 4 : i & (-5);
                        this.flags = i2;
                        int i3 = this.masks ? i2 | 8 : i2 & (-9);
                        this.flags = i3;
                        stream2.writeInt32(i3);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32(this.installed_date);
                        }
                        stream2.writeInt64(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeString(this.title);
                        stream2.writeString(this.short_name);
                        if ((this.flags & 16) != 0) {
                            this.thumbs.get(0).serializeToStream(stream2);
                        }
                        stream2.writeInt32(this.count);
                        stream2.writeInt32(this.hash);
                    }
                };
                break;
            default:
                tLRPC$TL_stickerSet = null;
                break;
        }
        if (tLRPC$TL_stickerSet == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in StickerSet", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_stickerSet != null) {
            tLRPC$TL_stickerSet.readParams(stream, exception);
        }
        return tLRPC$TL_stickerSet;
    }
}
