package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$WallPaperSettings extends TLObject {
    public int background_color;
    public boolean blur;
    public int flags;
    public int fourth_background_color;
    public int intensity;
    public boolean motion;
    public int rotation;
    public int second_background_color;
    public int third_background_color;

    public static TLRPC$WallPaperSettings TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$TL_wallPaperSettings tLRPC$TL_wallPaperSettings;
        if (i == -1590738760) {
            tLRPC$TL_wallPaperSettings = new TLRPC$TL_wallPaperSettings() { // from class: org.rbmain.tgnet.TLRPC$TL_wallPaperSettings_layer106
                public static int constructor = -1590738760;

                @Override // org.rbmain.tgnet.TLRPC$TL_wallPaperSettings, org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                    int int32 = abstractSerializedData2.readInt32(z2);
                    this.flags = int32;
                    this.blur = (int32 & 2) != 0;
                    this.motion = (int32 & 4) != 0;
                    if ((int32 & 1) != 0) {
                        this.background_color = abstractSerializedData2.readInt32(z2);
                    }
                    if ((this.flags & 8) != 0) {
                        this.intensity = abstractSerializedData2.readInt32(z2);
                    }
                }

                @Override // org.rbmain.tgnet.TLRPC$TL_wallPaperSettings, org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                    int i2 = this.blur ? this.flags | 2 : this.flags & (-3);
                    this.flags = i2;
                    int i3 = this.motion ? i2 | 4 : i2 & (-5);
                    this.flags = i3;
                    abstractSerializedData2.writeInt32(i3);
                    if ((this.flags & 1) != 0) {
                        abstractSerializedData2.writeInt32(this.background_color);
                    }
                    if ((this.flags & 8) != 0) {
                        abstractSerializedData2.writeInt32(this.intensity);
                    }
                }
            };
        } else {
            tLRPC$TL_wallPaperSettings = i != 84438264 ? null : new TLRPC$TL_wallPaperSettings();
        }
        if (tLRPC$TL_wallPaperSettings == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in WallPaperSettings", Integer.valueOf(i)));
        }
        if (tLRPC$TL_wallPaperSettings != null) {
            tLRPC$TL_wallPaperSettings.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_wallPaperSettings;
    }
}
