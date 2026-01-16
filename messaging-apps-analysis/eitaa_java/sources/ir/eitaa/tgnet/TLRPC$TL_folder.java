package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_folder extends TLObject {
    public static int constructor = -11252123;
    public boolean autofill_new_broadcasts;
    public boolean autofill_new_correspondents;
    public boolean autofill_public_groups;
    public int flags;
    public int id;
    public TLRPC$ChatPhoto photo;
    public String title;

    public static TLRPC$TL_folder TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_folder", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_folder tLRPC$TL_folder = new TLRPC$TL_folder();
        tLRPC$TL_folder.readParams(stream, exception);
        return tLRPC$TL_folder;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.autofill_new_broadcasts = (int32 & 1) != 0;
        this.autofill_public_groups = (int32 & 2) != 0;
        this.autofill_new_correspondents = (int32 & 4) != 0;
        this.id = stream.readInt32(exception);
        this.title = stream.readString(exception);
        if ((this.flags & 8) != 0) {
            this.photo = TLRPC$ChatPhoto.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.autofill_new_broadcasts ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.autofill_public_groups ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.autofill_new_correspondents ? i2 | 4 : i2 & (-5);
        this.flags = i3;
        stream.writeInt32(i3);
        stream.writeInt32(this.id);
        stream.writeString(this.title);
        if ((this.flags & 8) != 0) {
            this.photo.serializeToStream(stream);
        }
    }
}
