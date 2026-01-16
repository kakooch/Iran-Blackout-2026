package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_securePasswordKdfAlgoSHA512 extends TLRPC$SecurePasswordKdfAlgo {
    public static int constructor = -2042159726;
    public byte[] salt;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.salt = abstractSerializedData.readByteArray(z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeByteArray(this.salt);
    }
}
