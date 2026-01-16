package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_userProfilePhotoEmpty extends TLRPC$UserProfilePhoto {
    public static int constructor = 1326562017;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
