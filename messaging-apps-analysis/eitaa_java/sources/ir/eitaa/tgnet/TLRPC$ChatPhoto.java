package ir.eitaa.tgnet;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLoader;

/* loaded from: classes.dex */
public abstract class TLRPC$ChatPhoto extends TLObject {
    public int dc_id;
    public int flags;
    public boolean has_video;
    public TLRPC$FileLocation photo_big;
    public long photo_id;
    public TLRPC$FileLocation photo_small;
    public BitmapDrawable strippedBitmap;
    public byte[] stripped_thumb;

    public static TLRPC$ChatPhoto TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$ChatPhoto tLRPC$TL_chatPhoto;
        switch (constructor) {
            case -770990276:
                tLRPC$TL_chatPhoto = new TLRPC$TL_chatPhoto() { // from class: ir.eitaa.tgnet.TLRPC$TL_chatPhoto_layer126
                    public static int constructor = -770990276;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatPhoto, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.has_video = (int32 & 1) != 0;
                        this.photo_id = stream2.readInt64(exception2);
                        this.photo_small = TLRPC$FileLocation.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.photo_big = TLRPC$FileLocation.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.dc_id = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatPhoto, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.has_video ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        stream2.writeInt32(i);
                        stream2.writeInt64(this.photo_id);
                        this.photo_small.serializeToStream(stream2);
                        this.photo_big.serializeToStream(stream2);
                        stream2.writeInt32(this.dc_id);
                    }
                };
                break;
            case 476978193:
                tLRPC$TL_chatPhoto = new TLRPC$TL_chatPhoto();
                break;
            case 935395612:
                tLRPC$TL_chatPhoto = new TLRPC$ChatPhoto() { // from class: ir.eitaa.tgnet.TLRPC$TL_chatPhotoEmpty
                    public static int constructor = 935395612;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case 1197267925:
                tLRPC$TL_chatPhoto = new TLRPC$TL_chatPhoto() { // from class: ir.eitaa.tgnet.TLRPC$TL_chatPhoto_layer115
                    public static int constructor = 1197267925;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatPhoto, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.photo_small = TLRPC$FileLocation.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.photo_big = TLRPC$FileLocation.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.dc_id = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatPhoto, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        this.photo_small.serializeToStream(stream2);
                        this.photo_big.serializeToStream(stream2);
                        stream2.writeInt32(this.dc_id);
                    }
                };
                break;
            case 1200680453:
                tLRPC$TL_chatPhoto = new TLRPC$TL_chatPhoto() { // from class: ir.eitaa.tgnet.TLRPC$TL_chatPhoto_layer127
                    public static int constructor = 1200680453;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatPhoto, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.has_video = (int32 & 1) != 0;
                        this.photo_small = TLRPC$FileLocation.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.photo_big = TLRPC$FileLocation.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 2) != 0) {
                            this.stripped_thumb = stream2.readByteArray(exception2);
                            if (Build.VERSION.SDK_INT >= 21) {
                                try {
                                    this.strippedBitmap = new BitmapDrawable(ImageLoader.getStrippedPhotoBitmap(this.stripped_thumb, "b"));
                                } catch (Throwable th) {
                                    FileLog.e(th);
                                }
                            }
                        }
                        this.dc_id = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatPhoto, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.has_video ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        stream2.writeInt32(i);
                        this.photo_small.serializeToStream(stream2);
                        this.photo_big.serializeToStream(stream2);
                        if ((this.flags & 2) != 0) {
                            stream2.writeByteArray(this.stripped_thumb);
                        }
                        stream2.writeInt32(this.dc_id);
                    }
                };
                break;
            case 1632839530:
                tLRPC$TL_chatPhoto = new TLRPC$TL_chatPhoto() { // from class: ir.eitaa.tgnet.TLRPC$TL_chatPhoto_layer97
                    public static int constructor = 1632839530;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatPhoto, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.photo_small = TLRPC$FileLocation.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.photo_big = TLRPC$FileLocation.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatPhoto, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        this.photo_small.serializeToStream(stream2);
                        this.photo_big.serializeToStream(stream2);
                    }
                };
                break;
            default:
                tLRPC$TL_chatPhoto = null;
                break;
        }
        if (tLRPC$TL_chatPhoto == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in ChatPhoto", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_chatPhoto != null) {
            tLRPC$TL_chatPhoto.readParams(stream, exception);
        }
        return tLRPC$TL_chatPhoto;
    }
}
