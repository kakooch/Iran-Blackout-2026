package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_draftMessageEmpty extends TLRPC$DraftMessage {
    public static int constructor = 453805082;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        if ((int32 & 1) != 0) {
            this.date = stream.readInt32(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(this.date);
        }
    }
}
