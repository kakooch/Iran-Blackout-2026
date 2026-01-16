package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_help_termsOfServiceUpdate extends TLRPC$help_TermsOfServiceUpdate {
    public static int constructor = 686618977;
    public int expires;
    public TLRPC$TL_help_termsOfService terms_of_service;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.expires = stream.readInt32(exception);
        this.terms_of_service = TLRPC$TL_help_termsOfService.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.expires);
        this.terms_of_service.serializeToStream(stream);
    }
}
