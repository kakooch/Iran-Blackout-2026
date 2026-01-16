package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_userProfilePhotoEmpty extends TLRPC$UserProfilePhoto {
    public static int constructor = 1326562017;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
