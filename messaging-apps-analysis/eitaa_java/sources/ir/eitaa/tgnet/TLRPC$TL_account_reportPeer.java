package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_reportPeer extends TLObject {
    public static int constructor = -977650298;
    public String message;
    public TLRPC$InputPeer peer;
    public TLRPC$ReportReason reason;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        this.reason.serializeToStream(stream);
        stream.writeString(this.message);
    }
}
