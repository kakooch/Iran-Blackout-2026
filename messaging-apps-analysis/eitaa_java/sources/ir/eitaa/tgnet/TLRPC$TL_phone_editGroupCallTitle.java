package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_phone_editGroupCallTitle extends TLObject {
    public static int constructor = 480685066;
    public TLRPC$TL_inputGroupCall call;
    public String title;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.call.serializeToStream(stream);
        stream.writeString(this.title);
    }
}
