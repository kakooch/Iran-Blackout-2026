package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_initHistoryImport extends TLObject {
    public static int constructor = 873008187;
    public TLRPC$InputFile file;
    public int media_count;
    public TLRPC$InputPeer peer;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_messages_historyImport.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        this.file.serializeToStream(stream);
        stream.writeInt32(this.media_count);
    }
}
