package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_setChatTheme extends TLObject {
    public static int constructor = -432283329;
    public String emoticon;
    public TLRPC$InputPeer peer;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        stream.writeString(this.emoticon);
    }
}
