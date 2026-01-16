package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_updateTheme extends TLRPC$Update {
    public static int constructor = -2112423005;
    public TLRPC$Theme theme;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.theme = TLRPC$Theme.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.theme.serializeToStream(abstractSerializedData);
    }
}
