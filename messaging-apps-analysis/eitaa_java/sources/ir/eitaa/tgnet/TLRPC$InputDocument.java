package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$InputDocument extends TLObject {
    public long access_hash;
    public byte[] file_reference;
    public long id;

    public static TLRPC$InputDocument TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$InputDocument tLRPC$TL_inputDocument;
        if (constructor != 448771445) {
            tLRPC$TL_inputDocument = constructor != 1928391342 ? null : new TLRPC$TL_inputDocumentEmpty();
        } else {
            tLRPC$TL_inputDocument = new TLRPC$TL_inputDocument();
        }
        if (tLRPC$TL_inputDocument == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in InputDocument", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_inputDocument != null) {
            tLRPC$TL_inputDocument.readParams(stream, exception);
        }
        return tLRPC$TL_inputDocument;
    }
}
