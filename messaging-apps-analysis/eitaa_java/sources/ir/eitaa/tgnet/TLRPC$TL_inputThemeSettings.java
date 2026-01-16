package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_inputThemeSettings extends TLObject {
    public static int constructor = -1881255857;
    public int accent_color;
    public TLRPC$BaseTheme base_theme;
    public int flags;
    public ArrayList<Integer> message_colors = new ArrayList<>();
    public boolean message_colors_animated;
    public int outbox_accent_color;
    public TLRPC$InputWallPaper wallpaper;
    public TLRPC$WallPaperSettings wallpaper_settings;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.message_colors_animated = (int32 & 4) != 0;
        this.base_theme = TLRPC$BaseTheme.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.accent_color = stream.readInt32(exception);
        if ((this.flags & 8) != 0) {
            this.outbox_accent_color = stream.readInt32(exception);
        }
        if ((this.flags & 1) != 0) {
            int int322 = stream.readInt32(exception);
            if (int322 != 481674261) {
                if (exception) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                }
                return;
            } else {
                int int323 = stream.readInt32(exception);
                for (int i = 0; i < int323; i++) {
                    this.message_colors.add(Integer.valueOf(stream.readInt32(exception)));
                }
            }
        }
        if ((this.flags & 2) != 0) {
            this.wallpaper = TLRPC$InputWallPaper.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 2) != 0) {
            this.wallpaper_settings = TLRPC$WallPaperSettings.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.message_colors_animated ? this.flags | 4 : this.flags & (-5);
        this.flags = i;
        stream.writeInt32(i);
        this.base_theme.serializeToStream(stream);
        stream.writeInt32(this.accent_color);
        if ((this.flags & 8) != 0) {
            stream.writeInt32(this.outbox_accent_color);
        }
        if ((this.flags & 1) != 0) {
            stream.writeInt32(481674261);
            int size = this.message_colors.size();
            stream.writeInt32(size);
            for (int i2 = 0; i2 < size; i2++) {
                stream.writeInt32(this.message_colors.get(i2).intValue());
            }
        }
        if ((this.flags & 2) != 0) {
            this.wallpaper.serializeToStream(stream);
        }
        if ((this.flags & 2) != 0) {
            this.wallpaper_settings.serializeToStream(stream);
        }
    }
}
