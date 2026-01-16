package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateDraftMessage extends TLRPC$Update {
    public static int constructor = -299124375;
    public TLRPC$DraftMessage draft;
    public TLRPC$Peer peer;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.peer = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.draft = TLRPC$DraftMessage.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        this.draft.serializeToStream(stream);
    }
}
