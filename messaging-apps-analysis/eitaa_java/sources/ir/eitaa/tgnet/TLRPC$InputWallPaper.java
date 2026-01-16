package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$InputWallPaper extends TLObject {
    public static TLRPC$InputWallPaper TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$InputWallPaper tLRPC$TL_inputWallPaperNoFile;
        if (constructor == -1770371538) {
            tLRPC$TL_inputWallPaperNoFile = new TLRPC$TL_inputWallPaperNoFile();
        } else if (constructor == -433014407) {
            tLRPC$TL_inputWallPaperNoFile = new TLRPC$TL_inputWallPaper();
        } else {
            tLRPC$TL_inputWallPaperNoFile = constructor != 1913199744 ? null : new TLRPC$TL_inputWallPaperSlug();
        }
        if (tLRPC$TL_inputWallPaperNoFile == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in InputWallPaper", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_inputWallPaperNoFile != null) {
            tLRPC$TL_inputWallPaperNoFile.readParams(stream, exception);
        }
        return tLRPC$TL_inputWallPaperNoFile;
    }
}
