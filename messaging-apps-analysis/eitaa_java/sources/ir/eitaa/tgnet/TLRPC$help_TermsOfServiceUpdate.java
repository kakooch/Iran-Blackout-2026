package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$help_TermsOfServiceUpdate extends TLObject {
    public static TLRPC$help_TermsOfServiceUpdate TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$help_TermsOfServiceUpdate tLRPC$TL_help_termsOfServiceUpdateEmpty;
        if (constructor != -483352705) {
            tLRPC$TL_help_termsOfServiceUpdateEmpty = constructor != 686618977 ? null : new TLRPC$TL_help_termsOfServiceUpdate();
        } else {
            tLRPC$TL_help_termsOfServiceUpdateEmpty = new TLRPC$TL_help_termsOfServiceUpdateEmpty();
        }
        if (tLRPC$TL_help_termsOfServiceUpdateEmpty == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in help_TermsOfServiceUpdate", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_help_termsOfServiceUpdateEmpty != null) {
            tLRPC$TL_help_termsOfServiceUpdateEmpty.readParams(stream, exception);
        }
        return tLRPC$TL_help_termsOfServiceUpdateEmpty;
    }
}
