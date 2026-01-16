package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_checkHistoryImportPeer extends TLObject {
    public static int constructor = 1573261059;
    public TLRPC$InputPeer peer;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_messages_checkedHistoryImportPeer.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
    }
}
