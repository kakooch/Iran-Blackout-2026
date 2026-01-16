package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_documentAttributeVideo extends TLRPC$DocumentAttribute {
    public static int constructor = 250621158;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.round_message = (int32 & 1) != 0;
        this.supports_streaming = (int32 & 2) != 0;
        this.duration = abstractSerializedData.readInt32(z);
        this.w = abstractSerializedData.readInt32(z);
        this.h = abstractSerializedData.readInt32(z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.round_message ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.supports_streaming ? i | 2 : i & (-3);
        this.flags = i2;
        abstractSerializedData.writeInt32(i2);
        abstractSerializedData.writeInt32(this.duration);
        abstractSerializedData.writeInt32(this.w);
        abstractSerializedData.writeInt32(this.h);
    }
}
