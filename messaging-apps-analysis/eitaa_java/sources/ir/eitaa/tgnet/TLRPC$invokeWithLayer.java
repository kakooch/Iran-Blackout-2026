package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$invokeWithLayer extends TLObject {
    public static int constructor = -627372787;
    public int layer = 133;
    public TLObject query;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.layer);
        this.query.serializeToStream(stream);
    }
}
