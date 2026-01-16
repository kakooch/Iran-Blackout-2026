package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_textImage extends TLRPC$RichText {
    public static int constructor = 136105807;
    public long document_id;
    public int h;
    public int w;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.document_id = stream.readInt64(exception);
        this.w = stream.readInt32(exception);
        this.h = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.document_id);
        stream.writeInt32(this.w);
        stream.writeInt32(this.h);
    }
}
