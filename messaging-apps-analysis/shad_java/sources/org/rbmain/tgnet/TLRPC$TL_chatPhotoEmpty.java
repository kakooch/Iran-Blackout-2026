package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_chatPhotoEmpty extends TLRPC$ChatPhoto {
    public static int constructor = 935395612;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
