package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputChatPhoto extends TLRPC$InputChatPhoto {
    public static int constructor = -1991004873;
    public TLRPC$InputPhoto id;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.id = TLRPC$InputPhoto.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.id.serializeToStream(stream);
    }
}
