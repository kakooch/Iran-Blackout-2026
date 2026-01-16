package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_setHistoryTTL extends TLObject {
    public static int constructor = -1207017500;
    public TLRPC$InputPeer peer;
    public int period;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        stream.writeInt32(this.period);
    }
}
