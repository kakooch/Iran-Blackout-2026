package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$InputPhoto extends TLObject {
    public long access_hash;
    public byte[] file_reference;
    public long id;

    public static TLRPC$InputPhoto TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$InputPhoto tLRPC$TL_inputPhotoEmpty;
        if (constructor == 483901197) {
            tLRPC$TL_inputPhotoEmpty = new TLRPC$TL_inputPhotoEmpty();
        } else {
            tLRPC$TL_inputPhotoEmpty = constructor != 1001634122 ? null : new TLRPC$TL_inputPhoto();
        }
        if (tLRPC$TL_inputPhotoEmpty == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in InputPhoto", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_inputPhotoEmpty != null) {
            tLRPC$TL_inputPhotoEmpty.readParams(stream, exception);
        }
        return tLRPC$TL_inputPhotoEmpty;
    }
}
