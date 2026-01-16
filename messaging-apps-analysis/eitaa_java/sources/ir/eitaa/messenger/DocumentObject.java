package ir.eitaa.messenger;

import android.graphics.Paint;
import android.graphics.Path;
import ir.eitaa.messenger.SvgHelper;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$DocumentAttribute;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$TL_document;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeImageSize;
import ir.eitaa.tgnet.TLRPC$TL_photoPathSize;
import ir.eitaa.tgnet.TLRPC$TL_wallPaper;
import ir.eitaa.tgnet.TLRPC$ThemeSettings;
import ir.eitaa.tgnet.TLRPC$WallPaper;
import ir.eitaa.ui.ActionBar.Theme;
import java.util.ArrayList;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class DocumentObject {

    public static class ThemeDocument extends TLRPC$TL_document {
        public Theme.ThemeAccent accent;
        public Theme.ThemeInfo baseTheme;
        public TLRPC$ThemeSettings themeSettings;
        public TLRPC$Document wallpaper;

        public ThemeDocument(TLRPC$ThemeSettings settings) {
            this.themeSettings = settings;
            Theme.ThemeInfo theme = Theme.getTheme(Theme.getBaseThemeKey(settings));
            this.baseTheme = theme;
            this.accent = theme.createNewAccent(settings);
            TLRPC$WallPaper tLRPC$WallPaper = this.themeSettings.wallpaper;
            if (tLRPC$WallPaper instanceof TLRPC$TL_wallPaper) {
                TLRPC$Document tLRPC$Document = ((TLRPC$TL_wallPaper) tLRPC$WallPaper).document;
                this.wallpaper = tLRPC$Document;
                this.id = tLRPC$Document.id;
                this.access_hash = tLRPC$Document.access_hash;
                this.file_reference = tLRPC$Document.file_reference;
                this.user_id = tLRPC$Document.user_id;
                this.date = tLRPC$Document.date;
                this.file_name = tLRPC$Document.file_name;
                this.mime_type = tLRPC$Document.mime_type;
                this.size = tLRPC$Document.size;
                this.thumbs = tLRPC$Document.thumbs;
                this.version = tLRPC$Document.version;
                this.dc_id = tLRPC$Document.dc_id;
                this.key = tLRPC$Document.key;
                this.iv = tLRPC$Document.iv;
                this.attributes = tLRPC$Document.attributes;
                return;
            }
            this.id = -2147483648L;
            this.dc_id = Integer.MIN_VALUE;
        }
    }

    public static SvgHelper.SvgDrawable getSvgThumb(ArrayList<TLRPC$PhotoSize> sizes, String colorKey, float alpha) {
        int size = sizes.size();
        TLRPC$TL_photoPathSize tLRPC$TL_photoPathSize = null;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            TLRPC$PhotoSize tLRPC$PhotoSize = sizes.get(i3);
            if (tLRPC$PhotoSize instanceof TLRPC$TL_photoPathSize) {
                tLRPC$TL_photoPathSize = (TLRPC$TL_photoPathSize) tLRPC$PhotoSize;
            } else {
                i = tLRPC$PhotoSize.w;
                i2 = tLRPC$PhotoSize.h;
            }
            if (tLRPC$TL_photoPathSize != null && i != 0 && i2 != 0) {
                SvgHelper.SvgDrawable drawableByPath = SvgHelper.getDrawableByPath(SvgHelper.decompress(tLRPC$TL_photoPathSize.bytes), i, i2);
                if (drawableByPath != null) {
                    drawableByPath.setupGradient(colorKey, alpha);
                }
                return drawableByPath;
            }
        }
        return null;
    }

    public static SvgHelper.SvgDrawable getSvgThumb(TLRPC$Document document, String colorKey, float alpha) {
        return getSvgThumb(document, colorKey, alpha, 1.0f);
    }

    public static SvgHelper.SvgDrawable getSvgRectThumb(String colorKey, float alpha) {
        Path path = new Path();
        path.addRect(0.0f, 0.0f, 512.0f, 512.0f, Path.Direction.CW);
        path.close();
        SvgHelper.SvgDrawable svgDrawable = new SvgHelper.SvgDrawable();
        svgDrawable.commands.add(path);
        svgDrawable.paints.put(path, new Paint(1));
        svgDrawable.width = Factory.DEVICE_USE_ANDROID_CAMCORDER;
        svgDrawable.height = Factory.DEVICE_USE_ANDROID_CAMCORDER;
        svgDrawable.setupGradient(colorKey, alpha);
        return svgDrawable;
    }

    public static SvgHelper.SvgDrawable getSvgThumb(TLRPC$Document document, String colorKey, float alpha, float zoom) {
        int i;
        int i2;
        SvgHelper.SvgDrawable drawableByPath = null;
        if (document == null) {
            return null;
        }
        int size = document.thumbs.size();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                break;
            }
            TLRPC$PhotoSize tLRPC$PhotoSize = document.thumbs.get(i4);
            if (tLRPC$PhotoSize instanceof TLRPC$TL_photoPathSize) {
                int size2 = document.attributes.size();
                while (true) {
                    i = Factory.DEVICE_USE_ANDROID_CAMCORDER;
                    if (i3 >= size2) {
                        i2 = Factory.DEVICE_USE_ANDROID_CAMCORDER;
                        break;
                    }
                    TLRPC$DocumentAttribute tLRPC$DocumentAttribute = document.attributes.get(i3);
                    if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeImageSize) {
                        int i5 = tLRPC$DocumentAttribute.w;
                        int i6 = tLRPC$DocumentAttribute.h;
                        i = i5;
                        i2 = i6;
                        break;
                    }
                    i3++;
                }
                if (i != 0 && i2 != 0 && (drawableByPath = SvgHelper.getDrawableByPath(SvgHelper.decompress(tLRPC$PhotoSize.bytes), (int) (i * zoom), (int) (i2 * zoom))) != null) {
                    drawableByPath.setupGradient(colorKey, alpha);
                }
            } else {
                i4++;
            }
        }
        return drawableByPath;
    }
}
