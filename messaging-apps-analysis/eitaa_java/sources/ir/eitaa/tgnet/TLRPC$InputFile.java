package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$InputFile extends TLObject {
    public long id;
    public String md5_checksum;
    public String name;
    public int parts;

    public static TLRPC$InputFile TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$InputFile tLRPC$TL_inputFile;
        if (constructor != -181407105) {
            tLRPC$TL_inputFile = constructor != -95482955 ? null : new TLRPC$TL_inputFileBig();
        } else {
            tLRPC$TL_inputFile = new TLRPC$TL_inputFile();
        }
        if (tLRPC$TL_inputFile == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in InputFile", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_inputFile != null) {
            tLRPC$TL_inputFile.readParams(stream, exception);
        }
        return tLRPC$TL_inputFile;
    }
}
