package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_inputGeoPointEmpty extends TLRPC$InputGeoPoint {
    public static int constructor = -457104426;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
