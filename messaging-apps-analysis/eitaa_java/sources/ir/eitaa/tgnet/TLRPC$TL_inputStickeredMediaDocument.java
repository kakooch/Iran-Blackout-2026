package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputStickeredMediaDocument extends TLRPC$InputStickeredMedia {
    public static int constructor = 70813275;
    public TLRPC$InputDocument id;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.id = TLRPC$InputDocument.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.id.serializeToStream(stream);
    }
}
