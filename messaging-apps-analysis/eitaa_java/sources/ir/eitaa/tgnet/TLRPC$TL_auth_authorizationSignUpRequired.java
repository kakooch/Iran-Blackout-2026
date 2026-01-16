package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_auth_authorizationSignUpRequired extends TLRPC$auth_Authorization {
    public static int constructor = 1148485274;
    public int flags;
    public TLRPC$TL_help_termsOfService terms_of_service;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        if ((int32 & 1) != 0) {
            this.terms_of_service = TLRPC$TL_help_termsOfService.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        if ((this.flags & 1) != 0) {
            this.terms_of_service.serializeToStream(stream);
        }
    }
}
