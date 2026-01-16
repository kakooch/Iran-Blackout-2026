package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class TLRPC$photos_Photos extends TLObject {
    public int count;
    public ArrayList<TLRPC$Photo> photos = new ArrayList<>();
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    public static TLRPC$photos_Photos TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$photos_Photos tLRPC$TL_photos_photos;
        if (i == -1916114267) {
            tLRPC$TL_photos_photos = new TLRPC$TL_photos_photos();
        } else {
            tLRPC$TL_photos_photos = i != 352657236 ? null : new TLRPC$photos_Photos() { // from class: org.rbmain.tgnet.TLRPC$TL_photos_photosSlice
                public static int constructor = 352657236;

                @Override // org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                    this.count = abstractSerializedData2.readInt32(z2);
                    int int32 = abstractSerializedData2.readInt32(z2);
                    if (int32 != 481674261) {
                        if (z2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                        }
                        return;
                    }
                    int int322 = abstractSerializedData2.readInt32(z2);
                    for (int i2 = 0; i2 < int322; i2++) {
                        TLRPC$Photo tLRPC$PhotoTLdeserialize = TLRPC$Photo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$PhotoTLdeserialize == null) {
                            return;
                        }
                        this.photos.add(tLRPC$PhotoTLdeserialize);
                    }
                    int int323 = abstractSerializedData2.readInt32(z2);
                    if (int323 != 481674261) {
                        if (z2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
                        }
                        return;
                    }
                    int int324 = abstractSerializedData2.readInt32(z2);
                    for (int i3 = 0; i3 < int324; i3++) {
                        TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$UserTLdeserialize == null) {
                            return;
                        }
                        this.users.add(tLRPC$UserTLdeserialize);
                    }
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                    abstractSerializedData2.writeInt32(this.count);
                    abstractSerializedData2.writeInt32(481674261);
                    int size = this.photos.size();
                    abstractSerializedData2.writeInt32(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        this.photos.get(i2).serializeToStream(abstractSerializedData2);
                    }
                    abstractSerializedData2.writeInt32(481674261);
                    int size2 = this.users.size();
                    abstractSerializedData2.writeInt32(size2);
                    for (int i3 = 0; i3 < size2; i3++) {
                        this.users.get(i3).serializeToStream(abstractSerializedData2);
                    }
                }
            };
        }
        if (tLRPC$TL_photos_photos == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in photos_Photos", Integer.valueOf(i)));
        }
        if (tLRPC$TL_photos_photos != null) {
            tLRPC$TL_photos_photos.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_photos_photos;
    }
}
