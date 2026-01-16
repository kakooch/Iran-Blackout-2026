package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_phone_getGroupCall extends TLObject {
    public static int constructor = 68699611;
    public TLRPC$TL_inputGroupCall call;
    public int limit;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_phone_groupCall.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.call.serializeToStream(stream);
        stream.writeInt32(this.limit);
    }
}
