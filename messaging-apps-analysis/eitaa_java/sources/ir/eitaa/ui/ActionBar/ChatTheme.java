package ir.eitaa.ui.ActionBar;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.ChatThemeController;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLoader;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.tgnet.ResultCallback;
import ir.eitaa.tgnet.TLRPC$TL_chatTheme;
import ir.eitaa.tgnet.TLRPC$TL_theme;
import ir.eitaa.tgnet.TLRPC$TL_themeSettings;
import ir.eitaa.tgnet.TLRPC$WallPaper;
import ir.eitaa.ui.ActionBar.Theme;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class ChatTheme {
    private final TLRPC$TL_chatTheme chatThemeObject;
    private HashMap<String, Integer> darkCurrentColors;
    private String darkWallpaperLink;
    public final boolean isDefault;
    private HashMap<String, Integer> lightCurrentColors;
    private String lightWallpaperLink;

    public ChatTheme(TLRPC$TL_chatTheme chatThemeObject, boolean isDefault) {
        this.chatThemeObject = chatThemeObject;
        this.isDefault = isDefault;
    }

    public void initColors() {
        getCurrentColors(0, false);
        getCurrentColors(0, true);
    }

    public String getEmoticon() {
        return this.chatThemeObject.emoticon;
    }

    public TLRPC$TL_theme getTlTheme(boolean isDark) {
        return (TLRPC$TL_theme) (isDark ? this.chatThemeObject.dark_theme : this.chatThemeObject.theme);
    }

    public TLRPC$WallPaper getWallpaper(boolean isDark) {
        return getTlTheme(isDark).settings.wallpaper;
    }

    public String getWallpaperLink(boolean isDark) {
        return isDark ? this.darkWallpaperLink : this.lightWallpaperLink;
    }

    public HashMap<String, Integer> getCurrentColors(int currentAccount, boolean isDark) {
        HashMap<String, Integer> map = isDark ? this.darkCurrentColors : this.lightCurrentColors;
        if (map != null) {
            return map;
        }
        TLRPC$TL_theme tlTheme = getTlTheme(isDark);
        Theme.ThemeInfo themeInfo = new Theme.ThemeInfo(Theme.getTheme(Theme.getBaseThemeKey(tlTheme.settings)));
        Theme.ThemeAccent themeAccentCreateNewAccent = themeInfo.createNewAccent(tlTheme, currentAccount, true);
        themeInfo.setCurrentAccentId(themeAccentCreateNewAccent.id);
        HashMap<String, Integer> map2 = new HashMap<>();
        String[] strArr = new String[1];
        if (themeInfo.pathToFile != null) {
            map2.putAll(Theme.getThemeFileValues(new File(themeInfo.pathToFile), null, strArr));
        } else {
            String str = themeInfo.assetName;
            if (str != null) {
                map2.putAll(Theme.getThemeFileValues(null, str, strArr));
            }
        }
        if (isDark) {
            this.darkWallpaperLink = strArr[0];
        } else {
            this.lightWallpaperLink = strArr[0];
        }
        HashMap<String, Integer> map3 = new HashMap<>(map2);
        themeAccentCreateNewAccent.fillAccentColors(map2, map3);
        if (!isDark) {
            map3.put("chat_messageTextOut", -14606047);
        }
        for (Map.Entry<String, String> entry : Theme.getFallbackKeys().entrySet()) {
            String key = entry.getKey();
            if (!map3.containsKey(key)) {
                map3.put(key, map3.get(entry.getValue()));
            }
        }
        for (Map.Entry<String, Integer> entry2 : Theme.getDefaultColors().entrySet()) {
            if (!map3.containsKey(entry2.getKey())) {
                map3.put(entry2.getKey(), entry2.getValue());
            }
        }
        if (isDark) {
            this.darkCurrentColors = map3;
        } else {
            this.lightCurrentColors = map3;
        }
        return map3;
    }

    public void loadWallpaper(boolean isDark, final ResultCallback<Pair<Long, Bitmap>> callback) {
        String str;
        TLRPC$WallPaper wallpaper = getWallpaper(isDark);
        if (wallpaper == null && callback != null) {
            callback.onComplete(null);
            return;
        }
        final long j = getTlTheme(isDark).id;
        Bitmap wallpaperBitmap = ChatThemeController.getWallpaperBitmap(j);
        if (wallpaperBitmap != null && callback != null) {
            callback.onComplete(new Pair<>(Long.valueOf(j), wallpaperBitmap));
            return;
        }
        ImageLocation forDocument = ImageLocation.getForDocument(wallpaper.document);
        ImageReceiver imageReceiver = new ImageReceiver();
        if (SharedConfig.getDevicePerformanceClass() == 0) {
            Point point = AndroidUtilities.displaySize;
            int iMin = Math.min(point.x, point.y);
            Point point2 = AndroidUtilities.displaySize;
            str = ((int) (iMin / AndroidUtilities.density)) + "_" + ((int) (Math.max(point2.x, point2.y) / AndroidUtilities.density)) + "_f";
        } else {
            str = ((int) (1080.0f / AndroidUtilities.density)) + "_" + ((int) (1920.0f / AndroidUtilities.density)) + "_f";
        }
        imageReceiver.setImage(forDocument, str, null, ".jpg", wallpaper, 1);
        imageReceiver.setDelegate(new ImageReceiver.ImageReceiverDelegate() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$ChatTheme$KOYo3_ylnCVbvHbVrTdW343QRfE
            @Override // ir.eitaa.messenger.ImageReceiver.ImageReceiverDelegate
            public final void didSetImage(ImageReceiver imageReceiver2, boolean z, boolean z2, boolean z3) {
                ChatTheme.lambda$loadWallpaper$0(callback, j, imageReceiver2, z, z2, z3);
            }

            @Override // ir.eitaa.messenger.ImageReceiver.ImageReceiverDelegate
            public /* synthetic */ void onAnimationReady(ImageReceiver imageReceiver2) {
                ImageReceiver.ImageReceiverDelegate.CC.$default$onAnimationReady(this, imageReceiver2);
            }
        });
        ImageLoader.getInstance().loadImageForImageReceiver(imageReceiver);
    }

    static /* synthetic */ void lambda$loadWallpaper$0(ResultCallback resultCallback, long j, ImageReceiver imageReceiver, boolean z, boolean z2, boolean z3) {
        ImageReceiver.BitmapHolder bitmapSafe = imageReceiver.getBitmapSafe();
        if (!z || bitmapSafe == null) {
            return;
        }
        Bitmap bitmap = bitmapSafe.bitmap;
        if (bitmap == null) {
            Drawable drawable = bitmapSafe.drawable;
            if (drawable instanceof BitmapDrawable) {
                bitmap = ((BitmapDrawable) drawable).getBitmap();
            }
        }
        if (resultCallback != null) {
            resultCallback.onComplete(new Pair(Long.valueOf(j), bitmap));
        }
    }

    public void loadWallpaperThumb(boolean isDark, final ResultCallback<Pair<Long, Bitmap>> callback) {
        TLRPC$WallPaper wallpaper = getWallpaper(isDark);
        if (wallpaper == null) {
            if (callback != null) {
                callback.onComplete(null);
                return;
            }
            return;
        }
        final long j = getTlTheme(isDark).id;
        Bitmap wallpaperThumbBitmap = ChatThemeController.getWallpaperThumbBitmap(j);
        final File wallpaperThumbFile = getWallpaperThumbFile(j);
        if (wallpaperThumbBitmap == null && wallpaperThumbFile.exists() && wallpaperThumbFile.length() > 0) {
            try {
                wallpaperThumbBitmap = BitmapFactory.decodeFile(wallpaperThumbFile.getAbsolutePath());
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        if (wallpaperThumbBitmap != null) {
            if (callback != null) {
                callback.onComplete(new Pair<>(Long.valueOf(j), wallpaperThumbBitmap));
            }
        } else {
            ImageLocation forDocument = ImageLocation.getForDocument(FileLoader.getClosestPhotoSizeWithSize(wallpaper.document.thumbs, R.styleable.AppCompatTheme_windowNoTitle), wallpaper.document);
            ImageReceiver imageReceiver = new ImageReceiver();
            imageReceiver.setImage(forDocument, "120_80", null, null, null, 1);
            imageReceiver.setDelegate(new ImageReceiver.ImageReceiverDelegate() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$ChatTheme$k0BzhgchsteREqWa2sIb68WJy0k
                @Override // ir.eitaa.messenger.ImageReceiver.ImageReceiverDelegate
                public final void didSetImage(ImageReceiver imageReceiver2, boolean z, boolean z2, boolean z3) {
                    ChatTheme.lambda$loadWallpaperThumb$2(callback, j, wallpaperThumbFile, imageReceiver2, z, z2, z3);
                }

                @Override // ir.eitaa.messenger.ImageReceiver.ImageReceiverDelegate
                public /* synthetic */ void onAnimationReady(ImageReceiver imageReceiver2) {
                    ImageReceiver.ImageReceiverDelegate.CC.$default$onAnimationReady(this, imageReceiver2);
                }
            });
            ImageLoader.getInstance().loadImageForImageReceiver(imageReceiver);
        }
    }

    static /* synthetic */ void lambda$loadWallpaperThumb$2(ResultCallback resultCallback, long j, final File file, ImageReceiver imageReceiver, boolean z, boolean z2, boolean z3) {
        ImageReceiver.BitmapHolder bitmapSafe = imageReceiver.getBitmapSafe();
        if (!z || bitmapSafe == null) {
            return;
        }
        final Bitmap bitmap = bitmapSafe.bitmap;
        if (bitmap == null) {
            Drawable drawable = bitmapSafe.drawable;
            if (drawable instanceof BitmapDrawable) {
                bitmap = ((BitmapDrawable) drawable).getBitmap();
            }
        }
        if (bitmap != null) {
            if (resultCallback != null) {
                resultCallback.onComplete(new Pair(Long.valueOf(j), bitmap));
            }
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$ChatTheme$S3eLZP9gjWRRJ5iEeCOrLZwdhJo
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    ChatTheme.lambda$loadWallpaperThumb$1(file, bitmap);
                }
            });
        } else if (resultCallback != null) {
            resultCallback.onComplete(null);
        }
    }

    static /* synthetic */ void lambda$loadWallpaperThumb$1(File file, Bitmap bitmap) throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 87, fileOutputStream);
                fileOutputStream.close();
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void preloadWallpaper() {
        loadWallpaperThumb(false, null);
        loadWallpaperThumb(true, null);
        loadWallpaper(false, null);
        loadWallpaper(true, null);
    }

    private File getWallpaperThumbFile(long themeId) {
        return new File(ApplicationLoader.getFilesDirFixed(), "wallpaper_thumb_" + themeId + ".png");
    }

    public static Theme.ThemeInfo getDefaultThemeInfo(boolean isDark) {
        String string;
        Theme.ThemeInfo currentNightTheme = isDark ? Theme.getCurrentNightTheme() : Theme.getCurrentTheme();
        if (isDark != currentNightTheme.isDark()) {
            SharedPreferences mainSettings = MessagesController.getMainSettings(UserConfig.selectedAccount);
            if (isDark) {
                string = mainSettings.getString("dark_theme", "Dark Blue");
            } else {
                string = mainSettings.getString("day_theme", "Blue");
            }
            currentNightTheme = Theme.getTheme(string);
            if (currentNightTheme == null) {
                currentNightTheme = Theme.getTheme(isDark ? "Dark Blue" : "Blue");
            }
        }
        return new Theme.ThemeInfo(currentNightTheme);
    }

    public static ChatTheme getDefault() {
        Theme.ThemeInfo defaultThemeInfo = getDefaultThemeInfo(true);
        fillTlTheme(defaultThemeInfo);
        Theme.ThemeInfo defaultThemeInfo2 = getDefaultThemeInfo(false);
        fillTlTheme(defaultThemeInfo2);
        TLRPC$TL_chatTheme tLRPC$TL_chatTheme = new TLRPC$TL_chatTheme();
        tLRPC$TL_chatTheme.emoticon = "❌";
        tLRPC$TL_chatTheme.dark_theme = defaultThemeInfo.info;
        tLRPC$TL_chatTheme.theme = defaultThemeInfo2.info;
        ChatTheme chatTheme = new ChatTheme(tLRPC$TL_chatTheme, true);
        chatTheme.darkCurrentColors = getCurrentColors(defaultThemeInfo);
        chatTheme.lightCurrentColors = getCurrentColors(defaultThemeInfo2);
        return chatTheme;
    }

    private static void fillTlTheme(Theme.ThemeInfo themeInfo) {
        if (themeInfo.info == null) {
            themeInfo.info = new TLRPC$TL_theme();
        }
        TLRPC$TL_theme tLRPC$TL_theme = themeInfo.info;
        if (tLRPC$TL_theme.settings == null) {
            tLRPC$TL_theme.settings = new TLRPC$TL_themeSettings();
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        Theme.ThemeAccent accent = themeInfo.getAccent(false);
        if (accent != null) {
            int i = accent.myMessagesAccentColor;
            if (i != 0) {
                arrayList.add(Integer.valueOf(i));
            }
            int i2 = accent.myMessagesGradientAccentColor1;
            if (i2 != 0) {
                arrayList.add(Integer.valueOf(i2));
            }
            int i3 = accent.myMessagesGradientAccentColor2;
            if (i3 != 0) {
                arrayList.add(Integer.valueOf(i3));
            }
            int i4 = accent.myMessagesGradientAccentColor3;
            if (i4 != 0) {
                arrayList.add(Integer.valueOf(i4));
            }
        }
        themeInfo.info.settings.message_colors = arrayList;
    }

    private static HashMap<String, Integer> getCurrentColors(Theme.ThemeInfo themeInfo) {
        HashMap<String, Integer> map = new HashMap<>();
        if (themeInfo.pathToFile != null) {
            map.putAll(Theme.getThemeFileValues(new File(themeInfo.pathToFile), null, null));
        } else {
            String str = themeInfo.assetName;
            if (str != null) {
                map.putAll(Theme.getThemeFileValues(null, str, null));
            }
        }
        HashMap<String, Integer> map2 = new HashMap<>(map);
        Theme.ThemeAccent accent = themeInfo.getAccent(false);
        if (accent != null) {
            accent.fillAccentColors(map, map2);
        }
        return map2;
    }
}
