package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$photos_Photos extends TLObject {
    public int count;
    public ArrayList<TLRPC$Photo> photos = new ArrayList<>();
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    public static TLRPC$photos_Photos TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$photos_Photos tLRPC$TL_photos_photos;
        if (constructor == -1916114267) {
            tLRPC$TL_photos_photos = new TLRPC$TL_photos_photos();
        } else {
            tLRPC$TL_photos_photos = constructor != 352657236 ? null : new TLRPC$photos_Photos() { // from class: ir.eitaa.tgnet.TLRPC$TL_photos_photosSlice
                public static int constructor = 352657236;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.count = stream2.readInt32(exception2);
                    int int32 = stream2.readInt32(exception2);
                    if (int32 != 481674261) {
                        if (exception2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                        }
                        return;
                    }
                    int int322 = stream2.readInt32(exception2);
                    for (int i = 0; i < int322; i++) {
                        TLRPC$Photo tLRPC$PhotoTLdeserialize = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$PhotoTLdeserialize == null) {
                            return;
                        }
                        this.photos.add(tLRPC$PhotoTLdeserialize);
                    }
                    int int323 = stream2.readInt32(exception2);
                    if (int323 != 481674261) {
                        if (exception2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
                        }
                        return;
                    }
                    int int324 = stream2.readInt32(exception2);
                    for (int i2 = 0; i2 < int324; i2++) {
                        TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$UserTLdeserialize == null) {
                            return;
                        }
                        this.users.add(tLRPC$UserTLdeserialize);
                    }
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeInt32(this.count);
                    stream2.writeInt32(481674261);
                    int size = this.photos.size();
                    stream2.writeInt32(size);
                    for (int i = 0; i < size; i++) {
                        this.photos.get(i).serializeToStream(stream2);
                    }
                    stream2.writeInt32(481674261);
                    int size2 = this.users.size();
                    stream2.writeInt32(size2);
                    for (int i2 = 0; i2 < size2; i2++) {
                        this.users.get(i2).serializeToStream(stream2);
                    }
                }
            };
        }
        if (tLRPC$TL_photos_photos == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in photos_Photos", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_photos_photos != null) {
            tLRPC$TL_photos_photos.readParams(stream, exception);
        }
        return tLRPC$TL_photos_photos;
    }
}
