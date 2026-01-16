package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_uploadImportedMedia extends TLObject {
    public static int constructor = 713433234;
    public String file_name;
    public long import_id;
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
        stream.writeInt64(this.import_id);
        stream.writeString(this.file_name);
        this.media.serializeToStream(stream);
    }
}
