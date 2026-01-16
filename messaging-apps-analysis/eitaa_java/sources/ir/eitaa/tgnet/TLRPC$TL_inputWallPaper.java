package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputWallPaper extends TLRPC$InputWallPaper {
    public static int constructor = -433014407;
    public long access_hash;
    public long id;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.id = stream.readInt64(exception);
        this.access_hash = stream.readInt64(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.id);
        stream.writeInt64(this.access_hash);
    }
}
