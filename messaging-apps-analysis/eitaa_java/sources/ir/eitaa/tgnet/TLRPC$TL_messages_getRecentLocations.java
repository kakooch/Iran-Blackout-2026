package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_getRecentLocations extends TLObject {
    public static int constructor = 1881817312;
    public long hash;
    public int limit;
    public TLRPC$InputPeer peer;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$messages_Messages.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        stream.writeInt32(this.limit);
        stream.writeInt64(this.hash);
    }
}
