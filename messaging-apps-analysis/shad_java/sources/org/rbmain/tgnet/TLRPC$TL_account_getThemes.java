package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_account_getThemes extends TLObject {
    public static int constructor = 676939512;
    public String format;
    public long hash;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$account_Themes.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.format);
        abstractSerializedData.writeInt64(this.hash);
    }
}
