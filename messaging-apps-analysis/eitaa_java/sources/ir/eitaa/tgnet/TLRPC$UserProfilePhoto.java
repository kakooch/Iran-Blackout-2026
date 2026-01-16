package ir.eitaa.tgnet;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLoader;

/* loaded from: classes.dex */
public abstract class TLRPC$UserProfilePhoto extends TLObject {
    public int dc_id;
    public int flags;
    public boolean has_video;
    public TLRPC$FileLocation photo_big;
    public long photo_id;
    public TLRPC$FileLocation photo_small;
    public BitmapDrawable strippedBitmap;
    public byte[] stripped_thumb;

    public static TLRPC$UserProfilePhoto TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$UserProfilePhoto tLRPC$TL_userProfilePhoto;
        switch (constructor) {
            case -2100168954:
                tLRPC$TL_userProfilePhoto = new TLRPC$TL_userProfilePhoto();
                break;
            case -1727196013:
                tLRPC$TL_userProfilePhoto = new TLRPC$TL_userProfilePhoto() { // from class: ir.eitaa.tgnet.TLRPC$TL_userProfilePhoto_old
                    public static int constructor = -1727196013;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_userProfilePhoto, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.photo_small = TLRPC$FileLocation.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.photo_big = TLRPC$FileLocation.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_userProfilePhoto, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        this.photo_small.serializeToStream(stream2);
                        this.photo_big.serializeToStream(stream2);
                    }
                };
                break;
            case -865771401:
                tLRPC$TL_userProfilePhoto = new TLRPC$TL_userProfilePhoto() { // from class: ir.eitaa.tgnet.TLRPC$TL_userProfilePhoto_layer127
                    public static int constructor = -865771401;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_userProfilePhoto, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.has_video = (int32 & 1) != 0;
                        this.photo_id = stream2.readInt64(exception2);
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

                    @Override // ir.eitaa.tgnet.TLRPC$TL_userProfilePhoto, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.has_video ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        stream2.writeInt32(i);
                        stream2.writeInt64(this.photo_id);
                        this.photo_small.serializeToStream(stream2);
                        this.photo_big.serializeToStream(stream2);
                        if ((this.flags & 2) != 0) {
                            stream2.writeByteArray(this.stripped_thumb);
                        }
                        stream2.writeInt32(this.dc_id);
                    }
                };
                break;
            case -715532088:
                tLRPC$TL_userProfilePhoto = new TLRPC$TL_userProfilePhoto() { // from class: ir.eitaa.tgnet.TLRPC$TL_userProfilePhoto_layer97
                    public static int constructor = -715532088;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_userProfilePhoto, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.photo_id = stream2.readInt64(exception2);
                        this.photo_small = TLRPC$FileLocation.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.photo_big = TLRPC$FileLocation.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_userProfilePhoto, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt64(this.photo_id);
                        this.photo_small.serializeToStream(stream2);
                        this.photo_big.serializeToStream(stream2);
                    }
                };
                break;
            case -321430132:
                tLRPC$TL_userProfilePhoto = new TLRPC$TL_userProfilePhoto() { // from class: ir.eitaa.tgnet.TLRPC$TL_userProfilePhoto_layer115
                    public static int constructor = -321430132;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_userProfilePhoto, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.photo_id = stream2.readInt64(exception2);
                        this.photo_small = TLRPC$FileLocation.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.photo_big = TLRPC$FileLocation.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.dc_id = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_userProfilePhoto, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt64(this.photo_id);
                        this.photo_small.serializeToStream(stream2);
                        this.photo_big.serializeToStream(stream2);
                        stream2.writeInt32(this.dc_id);
                    }
                };
                break;
            case 1326562017:
                tLRPC$TL_userProfilePhoto = new TLRPC$TL_userProfilePhotoEmpty();
                break;
            case 1775479590:
                tLRPC$TL_userProfilePhoto = new TLRPC$TL_userProfilePhoto() { // from class: ir.eitaa.tgnet.TLRPC$TL_userProfilePhoto_layer126
                    public static int constructor = 1775479590;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_userProfilePhoto, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.has_video = (int32 & 1) != 0;
                        this.photo_id = stream2.readInt64(exception2);
                        this.photo_small = TLRPC$FileLocation.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.photo_big = TLRPC$FileLocation.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.dc_id = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_userProfilePhoto, ir.eitaa.tgnet.TLObject
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
            default:
                tLRPC$TL_userProfilePhoto = null;
                break;
        }
        if (tLRPC$TL_userProfilePhoto == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in UserProfilePhoto", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_userProfilePhoto != null) {
            tLRPC$TL_userProfilePhoto.readParams(stream, exception);
        }
        return tLRPC$TL_userProfilePhoto;
    }
}
