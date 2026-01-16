package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$InputPhoto extends TLObject {
    public long access_hash;
    public String avatar_id;
    public byte[] file_reference;
    public long id;
    public long main_id;
    public long thumb_id;

    public static TLRPC$InputPhoto TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$InputPhoto tLRPC$TL_inputPhoto;
        if (i == 483901197) {
            tLRPC$TL_inputPhoto = new TLRPC$InputPhoto() { // from class: org.rbmain.tgnet.TLRPC$TL_inputPhotoEmpty
                public static int constructor = 483901197;

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                }
            };
        } else {
            tLRPC$TL_inputPhoto = i != 1001634122 ? null : new TLRPC$TL_inputPhoto();
        }
        if (tLRPC$TL_inputPhoto == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in InputPhoto", Integer.valueOf(i)));
        }
        if (tLRPC$TL_inputPhoto != null) {
            tLRPC$TL_inputPhoto.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_inputPhoto;
    }
}
