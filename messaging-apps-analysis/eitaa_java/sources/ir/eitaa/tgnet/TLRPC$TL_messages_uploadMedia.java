package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_uploadMedia extends TLObject {
    public static int constructor = 1369162417;
    public TLRPC$InputMedia media;
    public TLRPC$InputPeer peer;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$MessageMedia.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        this.media.serializeToStream(stream);
    }
}
