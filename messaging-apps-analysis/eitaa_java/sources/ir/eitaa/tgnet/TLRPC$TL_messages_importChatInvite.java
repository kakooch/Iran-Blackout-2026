package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_importChatInvite extends TLObject {
    public static int constructor = 1817183516;
    public String hash;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.hash);
    }
}
