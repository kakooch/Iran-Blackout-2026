package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_chatPhoto extends TLRPC$ChatPhoto {
    public static int constructor = 476978193;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.has_video = (int32 & 1) != 0;
        this.photo_id = stream.readInt64(exception);
        if ((this.flags & 2) != 0) {
            this.stripped_thumb = stream.readByteArray(exception);
        }
        this.dc_id = stream.readInt32(exception);
        TLRPC$TL_fileLocationToBeDeprecated tLRPC$TL_fileLocationToBeDeprecated = new TLRPC$TL_fileLocationToBeDeprecated();
        this.photo_small = tLRPC$TL_fileLocationToBeDeprecated;
        tLRPC$TL_fileLocationToBeDeprecated.volume_id = -this.photo_id;
        tLRPC$TL_fileLocationToBeDeprecated.local_id = 97;
        TLRPC$TL_fileLocationToBeDeprecated tLRPC$TL_fileLocationToBeDeprecated2 = new TLRPC$TL_fileLocationToBeDeprecated();
        this.photo_big = tLRPC$TL_fileLocationToBeDeprecated2;
        tLRPC$TL_fileLocationToBeDeprecated2.volume_id = -this.photo_id;
        tLRPC$TL_fileLocationToBeDeprecated2.local_id = 99;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.has_video ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        stream.writeInt64(this.photo_id);
        if ((this.flags & 2) != 0) {
            stream.writeByteArray(this.stripped_thumb);
        }
        stream.writeInt32(this.dc_id);
    }
}
