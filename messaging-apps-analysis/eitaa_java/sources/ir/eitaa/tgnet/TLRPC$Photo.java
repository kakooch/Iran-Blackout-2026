package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$Photo extends TLObject {
    public long access_hash;
    public String caption;
    public int date;
    public int dc_id;
    public byte[] file_reference;
    public int flags;
    public TLRPC$GeoPoint geo;
    public boolean has_stickers;
    public long id;
    public long user_id;
    public ArrayList<TLRPC$PhotoSize> sizes = new ArrayList<>();
    public ArrayList<TLRPC$VideoSize> video_sizes = new ArrayList<>();

    public static TLRPC$Photo TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$Photo tLRPC$TL_photo;
        switch (constructor) {
            case -1836524247:
                tLRPC$TL_photo = new TLRPC$TL_photo() { // from class: ir.eitaa.tgnet.TLRPC$TL_photo_layer82
                    public static int constructor = -1836524247;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_photo, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.has_stickers = (int32 & 1) != 0;
                        this.id = stream2.readInt64(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.date = stream2.readInt32(exception2);
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
                            this.sizes.add(tLRPC$PhotoSizeTLdeserialize);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_photo, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.has_stickers ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        stream2.writeInt32(i);
                        stream2.writeInt64(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeInt32(this.date);
                        stream2.writeInt32(481674261);
                        int size = this.sizes.size();
                        stream2.writeInt32(size);
                        for (int i2 = 0; i2 < size; i2++) {
                            this.sizes.get(i2).serializeToStream(stream2);
                        }
                    }
                };
                break;
            case -1673036328:
                tLRPC$TL_photo = new TLRPC$TL_photo() { // from class: ir.eitaa.tgnet.TLRPC$TL_photo_layer97
                    public static int constructor = -1673036328;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_photo, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.has_stickers = (int32 & 1) != 0;
                        this.id = stream2.readInt64(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.file_reference = stream2.readByteArray(exception2);
                        this.date = stream2.readInt32(exception2);
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
                            this.sizes.add(tLRPC$PhotoSizeTLdeserialize);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_photo, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.has_stickers ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        stream2.writeInt32(i);
                        stream2.writeInt64(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeByteArray(this.file_reference);
                        stream2.writeInt32(this.date);
                        stream2.writeInt32(481674261);
                        int size = this.sizes.size();
                        stream2.writeInt32(size);
                        for (int i2 = 0; i2 < size; i2++) {
                            this.sizes.get(i2).serializeToStream(stream2);
                        }
                    }
                };
                break;
            case -1014792074:
                tLRPC$TL_photo = new TLRPC$TL_photo() { // from class: ir.eitaa.tgnet.TLRPC$TL_photo_old2
                    public static int constructor = -1014792074;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_photo, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt64(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.user_id = stream2.readInt32(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.geo = TLRPC$GeoPoint.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        int int32 = stream2.readInt32(exception2);
                        if (int32 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = stream2.readInt32(exception2);
                        for (int i = 0; i < int322; i++) {
                            TLRPC$PhotoSize tLRPC$PhotoSizeTLdeserialize = TLRPC$PhotoSize.TLdeserialize(0L, 0L, 0L, stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$PhotoSizeTLdeserialize == null) {
                                return;
                            }
                            this.sizes.add(tLRPC$PhotoSizeTLdeserialize);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_photo, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt64(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeInt32((int) this.user_id);
                        stream2.writeInt32(this.date);
                        this.geo.serializeToStream(stream2);
                        stream2.writeInt32(481674261);
                        int size = this.sizes.size();
                        stream2.writeInt32(size);
                        for (int i = 0; i < size; i++) {
                            this.sizes.get(i).serializeToStream(stream2);
                        }
                    }
                };
                break;
            case -840088834:
                tLRPC$TL_photo = new TLRPC$TL_photo() { // from class: ir.eitaa.tgnet.TLRPC$TL_photo_layer55
                    public static int constructor = -840088834;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_photo, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt64(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.date = stream2.readInt32(exception2);
                        int int32 = stream2.readInt32(exception2);
                        if (int32 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = stream2.readInt32(exception2);
                        for (int i = 0; i < int322; i++) {
                            TLRPC$PhotoSize tLRPC$PhotoSizeTLdeserialize = TLRPC$PhotoSize.TLdeserialize(0L, 0L, 0L, stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$PhotoSizeTLdeserialize == null) {
                                return;
                            }
                            this.sizes.add(tLRPC$PhotoSizeTLdeserialize);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_photo, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt64(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeInt32(this.date);
                        stream2.writeInt32(481674261);
                        int size = this.sizes.size();
                        stream2.writeInt32(size);
                        for (int i = 0; i < size; i++) {
                            this.sizes.get(i).serializeToStream(stream2);
                        }
                    }
                };
                break;
            case -797637467:
                tLRPC$TL_photo = new TLRPC$TL_photo() { // from class: ir.eitaa.tgnet.TLRPC$TL_photo_layer115
                    public static int constructor = -797637467;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_photo, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.has_stickers = (int32 & 1) != 0;
                        this.id = stream2.readInt64(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.file_reference = stream2.readByteArray(exception2);
                        this.date = stream2.readInt32(exception2);
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
                            this.sizes.add(tLRPC$PhotoSizeTLdeserialize);
                        }
                        this.dc_id = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_photo, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.has_stickers ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        stream2.writeInt32(i);
                        stream2.writeInt64(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeByteArray(this.file_reference);
                        stream2.writeInt32(this.date);
                        stream2.writeInt32(481674261);
                        int size = this.sizes.size();
                        stream2.writeInt32(size);
                        for (int i2 = 0; i2 < size; i2++) {
                            this.sizes.get(i2).serializeToStream(stream2);
                        }
                        stream2.writeInt32(this.dc_id);
                    }
                };
                break;
            case -82216347:
                tLRPC$TL_photo = new TLRPC$TL_photo();
                break;
            case 582313809:
                tLRPC$TL_photo = new TLRPC$TL_photo() { // from class: ir.eitaa.tgnet.TLRPC$TL_photo_old
                    public static int constructor = 582313809;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_photo, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt64(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.user_id = stream2.readInt32(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.caption = stream2.readString(exception2);
                        this.geo = TLRPC$GeoPoint.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        int int32 = stream2.readInt32(exception2);
                        if (int32 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = stream2.readInt32(exception2);
                        for (int i = 0; i < int322; i++) {
                            TLRPC$PhotoSize tLRPC$PhotoSizeTLdeserialize = TLRPC$PhotoSize.TLdeserialize(0L, 0L, 0L, stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$PhotoSizeTLdeserialize == null) {
                                return;
                            }
                            this.sizes.add(tLRPC$PhotoSizeTLdeserialize);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_photo, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt64(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeInt32((int) this.user_id);
                        stream2.writeInt32(this.date);
                        stream2.writeString(this.caption);
                        this.geo.serializeToStream(stream2);
                        stream2.writeInt32(481674261);
                        int size = this.sizes.size();
                        stream2.writeInt32(size);
                        for (int i = 0; i < size; i++) {
                            this.sizes.get(i).serializeToStream(stream2);
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
        if (tLRPC$TL_photo == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in Photo", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_photo != null) {
            tLRPC$TL_photo.readParams(stream, exception);
        }
        return tLRPC$TL_photo;
    }
}
