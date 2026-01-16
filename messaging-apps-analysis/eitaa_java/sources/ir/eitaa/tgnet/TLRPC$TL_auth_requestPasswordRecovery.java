package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_auth_requestPasswordRecovery extends TLObject {
    public static int constructor = -661144474;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_auth_passwordRecovery.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
