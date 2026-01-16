package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$InputSecureFile extends TLObject {
    public static TLRPC$InputSecureFile TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$InputSecureFile tLRPC$TL_inputSecureFileUploaded;
        if (constructor == 859091184) {
            tLRPC$TL_inputSecureFileUploaded = new TLRPC$TL_inputSecureFileUploaded();
        } else {
            tLRPC$TL_inputSecureFileUploaded = constructor != 1399317950 ? null : new TLRPC$TL_inputSecureFile();
        }
        if (tLRPC$TL_inputSecureFileUploaded == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in InputSecureFile", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_inputSecureFileUploaded != null) {
            tLRPC$TL_inputSecureFileUploaded.readParams(stream, exception);
        }
        return tLRPC$TL_inputSecureFileUploaded;
    }
}
