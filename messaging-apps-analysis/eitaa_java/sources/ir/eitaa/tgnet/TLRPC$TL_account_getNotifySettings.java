package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_getNotifySettings extends TLObject {
    public static int constructor = 313765169;
    public TLRPC$InputNotifyPeer peer;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$PeerNotifySettings.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
    }
}
