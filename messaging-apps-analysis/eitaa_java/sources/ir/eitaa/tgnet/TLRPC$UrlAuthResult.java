package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$UrlAuthResult extends TLObject {
    public static TLRPC$UrlAuthResult TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$UrlAuthResult tLRPC$TL_urlAuthResultAccepted;
        if (constructor == -1886646706) {
            tLRPC$TL_urlAuthResultAccepted = new TLRPC$TL_urlAuthResultAccepted();
        } else if (constructor != -1831650802) {
            tLRPC$TL_urlAuthResultAccepted = constructor != -1445536993 ? null : new TLRPC$UrlAuthResult() { // from class: ir.eitaa.tgnet.TLRPC$TL_urlAuthResultDefault
                public static int constructor = -1445536993;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                }
            };
        } else {
            tLRPC$TL_urlAuthResultAccepted = new TLRPC$TL_urlAuthResultRequest();
        }
        if (tLRPC$TL_urlAuthResultAccepted == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in UrlAuthResult", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_urlAuthResultAccepted != null) {
            tLRPC$TL_urlAuthResultAccepted.readParams(stream, exception);
        }
        return tLRPC$TL_urlAuthResultAccepted;
    }
}
