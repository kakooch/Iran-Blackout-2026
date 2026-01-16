package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$ThemeSettings extends TLObject {
    public int accent_color;
    public TLRPC$BaseTheme base_theme;
    public int flags;
    public ArrayList<Integer> message_colors = new ArrayList<>();
    public boolean message_colors_animated;
    public int outbox_accent_color;
    public TLRPC$WallPaper wallpaper;

    public static TLRPC$ThemeSettings TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$ThemeSettings tLRPC$TL_themeSettings;
        if (constructor == -1917524116) {
            tLRPC$TL_themeSettings = new TLRPC$ThemeSettings() { // from class: ir.eitaa.tgnet.TLRPC$TL_themeSettings_layer132
                public static int constructor = -1917524116;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    int int32 = stream2.readInt32(exception2);
                    this.flags = int32;
                    this.message_colors_animated = (int32 & 4) != 0;
                    this.base_theme = TLRPC$BaseTheme.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    this.accent_color = stream2.readInt32(exception2);
                    if ((this.flags & 1) != 0) {
                        int int322 = stream2.readInt32(exception2);
                        if (int322 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        } else {
                            int int323 = stream2.readInt32(exception2);
                            for (int i = 0; i < int323; i++) {
                                this.message_colors.add(Integer.valueOf(stream2.readInt32(exception2)));
                            }
                        }
                    }
                    if ((this.flags & 2) != 0) {
                        this.wallpaper = TLRPC$WallPaper.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    int i = this.message_colors_animated ? this.flags | 4 : this.flags & (-5);
                    this.flags = i;
                    stream2.writeInt32(i);
                    this.base_theme.serializeToStream(stream2);
                    stream2.writeInt32(this.accent_color);
                    if ((this.flags & 1) != 0) {
                        stream2.writeInt32(481674261);
                        int size = this.message_colors.size();
                        stream2.writeInt32(size);
                        for (int i2 = 0; i2 < size; i2++) {
                            stream2.writeInt32(this.message_colors.get(i2).intValue());
                        }
                    }
                    if ((this.flags & 2) != 0) {
                        this.wallpaper.serializeToStream(stream2);
                    }
                }
            };
        } else if (constructor != -1676371894) {
            tLRPC$TL_themeSettings = constructor != -94849324 ? null : new TLRPC$TL_themeSettings();
        } else {
            tLRPC$TL_themeSettings = new TLRPC$ThemeSettings() { // from class: ir.eitaa.tgnet.TLRPC$TL_themeSettings_layer131
                public static int constructor = -1676371894;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    int int32;
                    int int322;
                    this.flags = stream2.readInt32(exception2);
                    this.base_theme = TLRPC$BaseTheme.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    this.accent_color = stream2.readInt32(exception2);
                    if ((this.flags & 1) != 0 && (int322 = stream2.readInt32(exception2)) != 0) {
                        this.message_colors.add(Integer.valueOf(int322));
                    }
                    if ((this.flags & 1) != 0 && (int32 = stream2.readInt32(exception2)) != 0) {
                        this.message_colors.add(0, Integer.valueOf(int32));
                    }
                    if ((this.flags & 2) != 0) {
                        this.wallpaper = TLRPC$WallPaper.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeInt32(this.flags);
                    this.base_theme.serializeToStream(stream2);
                    stream2.writeInt32(this.accent_color);
                    if ((this.flags & 1) != 0) {
                        stream2.writeInt32(this.message_colors.size() > 1 ? this.message_colors.get(1).intValue() : 0);
                    }
                    if ((this.flags & 1) != 0) {
                        stream2.writeInt32(this.message_colors.size() > 0 ? this.message_colors.get(0).intValue() : 0);
                    }
                    if ((this.flags & 2) != 0) {
                        this.wallpaper.serializeToStream(stream2);
                    }
                }
            };
        }
        if (tLRPC$TL_themeSettings == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in ThemeSettings", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_themeSettings != null) {
            tLRPC$TL_themeSettings.readParams(stream, exception);
        }
        return tLRPC$TL_themeSettings;
    }
}
