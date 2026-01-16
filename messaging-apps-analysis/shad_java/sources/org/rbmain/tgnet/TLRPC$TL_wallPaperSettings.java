package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_wallPaperSettings extends TLRPC$WallPaperSettings {
    public static int constructor = 84438264;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.blur = (int32 & 2) != 0;
        this.motion = (int32 & 4) != 0;
        if ((int32 & 1) != 0) {
            this.background_color = abstractSerializedData.readInt32(z);
        }
        if ((this.flags & 16) != 0) {
            this.second_background_color = abstractSerializedData.readInt32(z);
        }
        if ((this.flags & 8) != 0) {
            this.intensity = abstractSerializedData.readInt32(z);
        }
        if ((this.flags & 16) != 0) {
            this.rotation = abstractSerializedData.readInt32(z);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.blur ? this.flags | 2 : this.flags & (-3);
        this.flags = i;
        int i2 = this.motion ? i | 4 : i & (-5);
        this.flags = i2;
        abstractSerializedData.writeInt32(i2);
        if ((this.flags & 1) != 0) {
            abstractSerializedData.writeInt32(this.background_color);
        }
        if ((this.flags & 16) != 0) {
            abstractSerializedData.writeInt32(this.second_background_color);
        }
        if ((this.flags & 8) != 0) {
            abstractSerializedData.writeInt32(this.intensity);
        }
        if ((this.flags & 16) != 0) {
            abstractSerializedData.writeInt32(this.rotation);
        }
    }
}
