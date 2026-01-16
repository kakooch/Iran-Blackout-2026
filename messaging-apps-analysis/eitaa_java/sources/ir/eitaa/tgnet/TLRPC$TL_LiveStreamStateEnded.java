package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_LiveStreamStateEnded extends TLRPC$LiveStreamState {
    public static int constructor = -53427794;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.isArchived = (int32 & 1) != 0;
        this.duration = stream.readInt32(exception);
        if ((this.flags & 1) != 0) {
            this.expire_date = stream.readInt32(exception);
            this.archive_link = stream.readString(exception);
            this.archive_size = stream.readInt32(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeInt32(this.duration);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(this.expire_date);
            stream.writeString(this.archive_link);
            stream.writeInt32(this.archive_size);
        }
    }
}
