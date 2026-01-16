package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messageActionChatEditPhoto extends TLRPC$MessageAction {
    public static int constructor = 2144015272;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.photo = TLRPC$Photo.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.photo.serializeToStream(stream);
    }
}
