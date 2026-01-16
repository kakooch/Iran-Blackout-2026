package ir.eitaa.tgnet;

/* loaded from: classes.dex */
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

    public static TLRPC$WallPaperSettings TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$TL_wallPaperSettings tLRPC$TL_wallPaperSettings;
        if (constructor == -1590738760) {
            tLRPC$TL_wallPaperSettings = new TLRPC$TL_wallPaperSettings() { // from class: ir.eitaa.tgnet.TLRPC$TL_wallPaperSettings_layer106
                public static int constructor = -1590738760;

                @Override // ir.eitaa.tgnet.TLRPC$TL_wallPaperSettings, ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    int int32 = stream2.readInt32(exception2);
                    this.flags = int32;
                    this.blur = (int32 & 2) != 0;
                    this.motion = (int32 & 4) != 0;
                    if ((int32 & 1) != 0) {
                        this.background_color = stream2.readInt32(exception2);
                    }
                    if ((this.flags & 8) != 0) {
                        this.intensity = stream2.readInt32(exception2);
                    }
                }

                @Override // ir.eitaa.tgnet.TLRPC$TL_wallPaperSettings, ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    int i = this.blur ? this.flags | 2 : this.flags & (-3);
                    this.flags = i;
                    int i2 = this.motion ? i | 4 : i & (-5);
                    this.flags = i2;
                    stream2.writeInt32(i2);
                    if ((this.flags & 1) != 0) {
                        stream2.writeInt32(this.background_color);
                    }
                    if ((this.flags & 8) != 0) {
                        stream2.writeInt32(this.intensity);
                    }
                }
            };
        } else if (constructor == 84438264) {
            tLRPC$TL_wallPaperSettings = new TLRPC$TL_wallPaperSettings() { // from class: ir.eitaa.tgnet.TLRPC$TL_wallPaperSettings_layer128
                public static int constructor = 84438264;

                @Override // ir.eitaa.tgnet.TLRPC$TL_wallPaperSettings, ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    int int32 = stream2.readInt32(exception2);
                    this.flags = int32;
                    this.blur = (int32 & 2) != 0;
                    this.motion = (int32 & 4) != 0;
                    if ((int32 & 1) != 0) {
                        this.background_color = stream2.readInt32(exception2);
                    }
                    if ((this.flags & 16) != 0) {
                        this.second_background_color = stream2.readInt32(exception2);
                    }
                    if ((this.flags & 8) != 0) {
                        this.intensity = stream2.readInt32(exception2);
                    }
                    if ((this.flags & 16) != 0) {
                        this.rotation = stream2.readInt32(exception2);
                    }
                }

                @Override // ir.eitaa.tgnet.TLRPC$TL_wallPaperSettings, ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    int i = this.blur ? this.flags | 2 : this.flags & (-3);
                    this.flags = i;
                    int i2 = this.motion ? i | 4 : i & (-5);
                    this.flags = i2;
                    stream2.writeInt32(i2);
                    if ((this.flags & 1) != 0) {
                        stream2.writeInt32(this.background_color);
                    }
                    if ((this.flags & 16) != 0) {
                        stream2.writeInt32(this.second_background_color);
                    }
                    if ((this.flags & 8) != 0) {
                        stream2.writeInt32(this.intensity);
                    }
                    if ((this.flags & 16) != 0) {
                        stream2.writeInt32(this.rotation);
                    }
                }
            };
        } else {
            tLRPC$TL_wallPaperSettings = constructor != 499236004 ? null : new TLRPC$TL_wallPaperSettings();
        }
        if (tLRPC$TL_wallPaperSettings == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in WallPaperSettings", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_wallPaperSettings != null) {
            tLRPC$TL_wallPaperSettings.readParams(stream, exception);
        }
        return tLRPC$TL_wallPaperSettings;
    }
}
