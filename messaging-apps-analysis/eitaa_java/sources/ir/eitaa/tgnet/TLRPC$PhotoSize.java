package ir.eitaa.tgnet;

import android.text.TextUtils;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$PhotoSize extends TLObject {
    public byte[] bytes;
    public int h;
    public TLRPC$FileLocation location;
    public int size;
    public String type;
    public int w;

    public static TLRPC$PhotoSize TLdeserialize(long photo_id, long document_id, long sticker_set_id, AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$PhotoSize tLRPC$TL_photoStrippedSize;
        switch (constructor) {
            case -668906175:
                tLRPC$TL_photoStrippedSize = new TLRPC$PhotoSize() { // from class: ir.eitaa.tgnet.TLRPC$TL_photoPathSize
                    public static int constructor = -668906175;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.type = stream2.readString(exception2);
                        this.bytes = stream2.readByteArray(exception2);
                        this.h = 50;
                        this.w = 50;
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeString(this.type);
                        stream2.writeByteArray(this.bytes);
                    }
                };
                break;
            case -525288402:
                tLRPC$TL_photoStrippedSize = new TLRPC$TL_photoStrippedSize();
                break;
            case -374917894:
                tLRPC$TL_photoStrippedSize = new TLRPC$TL_photoCachedSize() { // from class: ir.eitaa.tgnet.TLRPC$TL_photoCachedSize_layer127
                    public static int constructor = -374917894;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_photoCachedSize, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.type = stream2.readString(exception2);
                        this.location = TLRPC$FileLocation.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.w = stream2.readInt32(exception2);
                        this.h = stream2.readInt32(exception2);
                        this.bytes = stream2.readByteArray(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_photoCachedSize, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeString(this.type);
                        this.location.serializeToStream(stream2);
                        stream2.writeInt32(this.w);
                        stream2.writeInt32(this.h);
                        stream2.writeByteArray(this.bytes);
                    }
                };
                break;
            case -96535659:
                tLRPC$TL_photoStrippedSize = new TLRPC$TL_photoSizeProgressive();
                break;
            case 35527382:
                tLRPC$TL_photoStrippedSize = new TLRPC$TL_photoCachedSize();
                break;
            case 236446268:
                tLRPC$TL_photoStrippedSize = new TLRPC$TL_photoSizeEmpty();
                break;
            case 1520986705:
                tLRPC$TL_photoStrippedSize = new TLRPC$TL_photoSizeProgressive() { // from class: ir.eitaa.tgnet.TLRPC$TL_photoSizeProgressive_layer127
                    public static int constructor = 1520986705;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_photoSizeProgressive, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.type = stream2.readString(exception2);
                        this.location = TLRPC$FileLocation.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.w = stream2.readInt32(exception2);
                        this.h = stream2.readInt32(exception2);
                        int int32 = stream2.readInt32(exception2);
                        if (int32 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = stream2.readInt32(exception2);
                        for (int i = 0; i < int322; i++) {
                            this.sizes.add(Integer.valueOf(stream2.readInt32(exception2)));
                        }
                        if (this.sizes.isEmpty()) {
                            return;
                        }
                        ArrayList<Integer> arrayList = this.sizes;
                        this.size = arrayList.get(arrayList.size() - 1).intValue();
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_photoSizeProgressive, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeString(this.type);
                        this.location.serializeToStream(stream2);
                        stream2.writeInt32(this.w);
                        stream2.writeInt32(this.h);
                        stream2.writeInt32(481674261);
                        int size = this.sizes.size();
                        stream2.writeInt32(size);
                        for (int i = 0; i < size; i++) {
                            stream2.writeInt32(this.sizes.get(i).intValue());
                        }
                    }
                };
                break;
            case 1976012384:
                tLRPC$TL_photoStrippedSize = new TLRPC$TL_photoSize();
                break;
            case 2009052699:
                tLRPC$TL_photoStrippedSize = new TLRPC$TL_photoSize_layer127();
                break;
            default:
                tLRPC$TL_photoStrippedSize = null;
                break;
        }
        if (tLRPC$TL_photoStrippedSize == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in PhotoSize", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_photoStrippedSize != null) {
            tLRPC$TL_photoStrippedSize.readParams(stream, exception);
            if (tLRPC$TL_photoStrippedSize.location == null) {
                if (!TextUtils.isEmpty(tLRPC$TL_photoStrippedSize.type) && (photo_id != 0 || document_id != 0 || sticker_set_id != 0)) {
                    TLRPC$TL_fileLocationToBeDeprecated tLRPC$TL_fileLocationToBeDeprecated = new TLRPC$TL_fileLocationToBeDeprecated();
                    tLRPC$TL_photoStrippedSize.location = tLRPC$TL_fileLocationToBeDeprecated;
                    if (photo_id != 0) {
                        tLRPC$TL_fileLocationToBeDeprecated.volume_id = -photo_id;
                        tLRPC$TL_fileLocationToBeDeprecated.local_id = tLRPC$TL_photoStrippedSize.type.charAt(0);
                    } else if (document_id != 0) {
                        tLRPC$TL_fileLocationToBeDeprecated.volume_id = -document_id;
                        tLRPC$TL_fileLocationToBeDeprecated.local_id = tLRPC$TL_photoStrippedSize.type.charAt(0) + 1000;
                    } else if (sticker_set_id != 0) {
                        tLRPC$TL_fileLocationToBeDeprecated.volume_id = -sticker_set_id;
                        tLRPC$TL_fileLocationToBeDeprecated.local_id = tLRPC$TL_photoStrippedSize.type.charAt(0) + 2000;
                    }
                } else {
                    tLRPC$TL_photoStrippedSize.location = new TLRPC$TL_fileLocationUnavailable();
                }
            }
        }
        return tLRPC$TL_photoStrippedSize;
    }
}
