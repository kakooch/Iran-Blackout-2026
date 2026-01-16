package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateGroupCallConnection extends TLRPC$Update {
    public static int constructor = 192428418;
    public int flags;
    public TLRPC$TL_dataJSON params;
    public boolean presentation;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.presentation = (int32 & 1) != 0;
        this.params = TLRPC$TL_dataJSON.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.presentation ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        this.params.serializeToStream(stream);
    }
}
