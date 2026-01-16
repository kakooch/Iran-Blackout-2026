package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_phone_toggleGroupCallStartSubscription extends TLObject {
    public static int constructor = 563885286;
    public TLRPC$TL_inputGroupCall call;
    public boolean subscribed;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.call.serializeToStream(stream);
        stream.writeBool(this.subscribed);
    }
}
