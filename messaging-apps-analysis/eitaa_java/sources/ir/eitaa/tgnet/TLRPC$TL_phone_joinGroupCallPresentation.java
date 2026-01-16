package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_phone_joinGroupCallPresentation extends TLObject {
    public static int constructor = -873829436;
    public TLRPC$TL_inputGroupCall call;
    public TLRPC$TL_dataJSON params;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.call.serializeToStream(stream);
        this.params.serializeToStream(stream);
    }
}
