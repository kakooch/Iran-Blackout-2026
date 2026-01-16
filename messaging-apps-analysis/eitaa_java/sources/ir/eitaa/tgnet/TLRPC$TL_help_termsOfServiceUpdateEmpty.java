package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_help_termsOfServiceUpdateEmpty extends TLRPC$help_TermsOfServiceUpdate {
    public static int constructor = -483352705;
    public int expires;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.expires = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.expires);
    }
}
