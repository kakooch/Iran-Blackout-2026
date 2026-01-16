package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_report_reason extends TLObject {
    public static int constructor = 326990165;
    public int flags;
    public boolean hasComment;
    public int id;
    public int subjectId;
    public String title;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.hasComment = (int32 & 1) != 0;
        this.subjectId = stream.readInt32(exception);
        this.id = stream.readInt32(exception);
        this.title = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeInt32(this.subjectId);
        stream.writeInt32(this.id);
        stream.writeString(this.title);
    }
}
