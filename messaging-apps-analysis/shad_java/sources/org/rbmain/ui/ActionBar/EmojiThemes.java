package org.rbmain.ui.ActionBar;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseIntArray;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.ChatThemeController;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.ImageLoader;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.Utilities;
import org.rbmain.tgnet.ResultCallback;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_theme;
import org.rbmain.tgnet.TLRPC$WallPaper;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes4.dex */
public class EmojiThemes {
    private static final int[] previewColorKeys = {Theme.key_chat_inBubble, Theme.key_chat_outBubble, Theme.key_featuredStickers_addButton, Theme.key_chat_wallpaper, Theme.key_chat_wallpaper_gradient_to1, Theme.key_chat_wallpaper_gradient_to2, Theme.key_chat_wallpaper_gradient_to3, Theme.key_chat_wallpaper_gradient_rotation};
    public String emoji;
    public ArrayList<ThemeItem> items = new ArrayList<>();
    public boolean showAsDefaultStub;

    public EmojiThemes() {
    }

    public EmojiThemes(TLRPC$TL_theme tLRPC$TL_theme, boolean z) {
        this.showAsDefaultStub = z;
        this.emoji = tLRPC$TL_theme.emoticon;
        if (z) {
            return;
        }
        ThemeItem themeItem = new ThemeItem();
        themeItem.tlTheme = tLRPC$TL_theme;
        themeItem.settingsIndex = 0;
        this.items.add(themeItem);
        ThemeItem themeItem2 = new ThemeItem();
        themeItem2.tlTheme = tLRPC$TL_theme;
        themeItem2.settingsIndex = 1;
        this.items.add(themeItem2);
    }

    public static EmojiThemes createChatThemesDefault() {
        EmojiThemes emojiThemes = new EmojiThemes();
        emojiThemes.emoji = "❌";
        emojiThemes.showAsDefaultStub = true;
        ThemeItem themeItem = new ThemeItem();
        themeItem.themeInfo = getDefaultThemeInfo(true);
        emojiThemes.items.add(themeItem);
        ThemeItem themeItem2 = new ThemeItem();
        themeItem2.themeInfo = getDefaultThemeInfo(false);
        emojiThemes.items.add(themeItem2);
        return emojiThemes;
    }

    public void initColors() {
        getPreviewColors(0, 0);
        getPreviewColors(0, 1);
    }

    public String getEmoticon() {
        return this.emoji;
    }

    public TLRPC$TL_theme getTlTheme(int i) {
        return this.items.get(i).tlTheme;
    }

    public TLRPC$WallPaper getWallpaper(int i) {
        if (this.items.get(i).settingsIndex < 0) {
            return null;
        }
        getTlTheme(i);
        return null;
    }

    public String getWallpaperLink(int i) {
        return this.items.get(i).wallpaperLink;
    }

    public int getSettingsIndex(int i) {
        return this.items.get(i).settingsIndex;
    }

    public SparseIntArray getPreviewColors(int i, int i2) throws IOException {
        Theme.ThemeAccent themeAccentCreateNewAccent;
        SparseIntArray sparseIntArray;
        int iIndexOfKey;
        Theme.ThemeInfo theme;
        SparseIntArray sparseIntArray2 = this.items.get(i2).currentPreviewColors;
        if (sparseIntArray2 != null) {
            return sparseIntArray2;
        }
        Theme.ThemeInfo themeInfo = getThemeInfo(i2);
        if (themeInfo == null) {
            int settingsIndex = getSettingsIndex(i2);
            TLRPC$TL_theme tlTheme = getTlTheme(i2);
            if (tlTheme != null) {
                theme = Theme.getTheme(Theme.getBaseThemeKey(tlTheme.settings.get(settingsIndex)));
            } else {
                theme = Theme.getTheme("Blue");
            }
            Theme.ThemeInfo themeInfo2 = new Theme.ThemeInfo(theme);
            themeAccentCreateNewAccent = themeInfo2.createNewAccent(tlTheme, i, true, settingsIndex);
            themeInfo2.setCurrentAccentId(themeAccentCreateNewAccent.id);
            themeInfo = themeInfo2;
        } else {
            SparseArray<Theme.ThemeAccent> sparseArray = themeInfo.themeAccentsMap;
            themeAccentCreateNewAccent = sparseArray != null ? sparseArray.get(this.items.get(i2).accentId) : null;
        }
        String[] strArr = new String[1];
        if (themeInfo.pathToFile != null) {
            sparseIntArray = Theme.getThemeFileValues(new File(themeInfo.pathToFile), null, strArr);
        } else {
            String str = themeInfo.assetName;
            if (str != null) {
                sparseIntArray = Theme.getThemeFileValues(null, str, strArr);
            } else {
                sparseIntArray = new SparseIntArray();
            }
        }
        int i3 = 0;
        this.items.get(i2).wallpaperLink = strArr[0];
        if (themeAccentCreateNewAccent != null) {
            SparseIntArray sparseIntArrayClone = sparseIntArray.clone();
            themeAccentCreateNewAccent.fillAccentColors(sparseIntArray, sparseIntArrayClone);
            sparseIntArray = sparseIntArrayClone;
        }
        SparseIntArray fallbackKeys = Theme.getFallbackKeys();
        this.items.get(i2).currentPreviewColors = new SparseIntArray();
        while (true) {
            int[] iArr = previewColorKeys;
            if (i3 < iArr.length) {
                int i4 = iArr[i3];
                int iIndexOfKey2 = sparseIntArray.indexOfKey(i4);
                if (iIndexOfKey2 >= 0) {
                    this.items.get(i2).currentPreviewColors.put(i4, sparseIntArray.valueAt(iIndexOfKey2));
                } else {
                    int i5 = fallbackKeys.get(i4, -1);
                    if (i5 >= 0 && (iIndexOfKey = sparseIntArray.indexOfKey(i5)) >= 0) {
                        this.items.get(i2).currentPreviewColors.put(i4, sparseIntArray.valueAt(iIndexOfKey));
                    }
                }
                i3++;
            } else {
                return this.items.get(i2).currentPreviewColors;
            }
        }
    }

    public SparseIntArray createColors(int i, int i2) throws IOException {
        Theme.ThemeAccent themeAccentCreateNewAccent;
        SparseIntArray sparseIntArray;
        int iIndexOfKey;
        Theme.ThemeInfo themeInfo = getThemeInfo(i2);
        if (themeInfo == null) {
            int settingsIndex = getSettingsIndex(i2);
            TLRPC$TL_theme tlTheme = getTlTheme(i2);
            Theme.ThemeInfo themeInfo2 = new Theme.ThemeInfo(Theme.getTheme(Theme.getBaseThemeKey(tlTheme.settings.get(settingsIndex))));
            themeAccentCreateNewAccent = themeInfo2.createNewAccent(tlTheme, i, true, settingsIndex);
            themeInfo2.setCurrentAccentId(themeAccentCreateNewAccent.id);
            themeInfo = themeInfo2;
        } else {
            SparseArray<Theme.ThemeAccent> sparseArray = themeInfo.themeAccentsMap;
            themeAccentCreateNewAccent = sparseArray != null ? sparseArray.get(this.items.get(i2).accentId) : null;
        }
        String[] strArr = new String[1];
        if (themeInfo.pathToFile != null) {
            sparseIntArray = Theme.getThemeFileValues(new File(themeInfo.pathToFile), null, strArr);
        } else {
            String str = themeInfo.assetName;
            if (str != null) {
                sparseIntArray = Theme.getThemeFileValues(null, str, strArr);
            } else {
                sparseIntArray = new SparseIntArray();
            }
        }
        this.items.get(i2).wallpaperLink = strArr[0];
        if (themeAccentCreateNewAccent != null) {
            SparseIntArray sparseIntArrayClone = sparseIntArray.clone();
            themeAccentCreateNewAccent.fillAccentColors(sparseIntArray, sparseIntArrayClone);
            sparseIntArray = sparseIntArrayClone;
        }
        SparseIntArray fallbackKeys = Theme.getFallbackKeys();
        for (int i3 = 0; i3 < fallbackKeys.size(); i3++) {
            int iKeyAt = fallbackKeys.keyAt(i3);
            int iValueAt = fallbackKeys.valueAt(i3);
            if (sparseIntArray.indexOfKey(iKeyAt) < 0 && (iIndexOfKey = sparseIntArray.indexOfKey(iValueAt)) >= 0) {
                sparseIntArray.put(iKeyAt, sparseIntArray.valueAt(iIndexOfKey));
            }
        }
        int[] defaultColors = Theme.getDefaultColors();
        for (int i4 = 0; i4 < defaultColors.length; i4++) {
            if (sparseIntArray.indexOfKey(i4) < 0) {
                sparseIntArray.put(i4, defaultColors[i4]);
            }
        }
        return sparseIntArray;
    }

    public Theme.ThemeInfo getThemeInfo(int i) {
        return this.items.get(i).themeInfo;
    }

    public void loadWallpaper(int i, ResultCallback<Pair<Long, Bitmap>> resultCallback) {
        TLRPC$WallPaper wallpaper = getWallpaper(i);
        if (wallpaper != null) {
            loadWallpaperImage(getTlTheme(i).id, wallpaper, resultCallback);
        } else if (resultCallback != null) {
            resultCallback.onComplete(null);
        }
    }

    public static void loadWallpaperImage(final long j, final TLRPC$WallPaper tLRPC$WallPaper, final ResultCallback<Pair<Long, Bitmap>> resultCallback) {
        ChatThemeController.getWallpaperBitmap(j, new ResultCallback() { // from class: org.rbmain.ui.ActionBar.EmojiThemes$$ExternalSyntheticLambda3
            @Override // org.rbmain.tgnet.ResultCallback
            public final void onComplete(Object obj) {
                EmojiThemes.lambda$loadWallpaperImage$1(resultCallback, j, tLRPC$WallPaper, (Bitmap) obj);
            }

            @Override // org.rbmain.tgnet.ResultCallback
            public /* synthetic */ void onError(TLRPC$TL_error tLRPC$TL_error) {
                ResultCallback.CC.$default$onError(this, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadWallpaperImage$1(final ResultCallback resultCallback, final long j, TLRPC$WallPaper tLRPC$WallPaper, Bitmap bitmap) {
        if (bitmap != null && resultCallback != null) {
            resultCallback.onComplete(new Pair(Long.valueOf(j), bitmap));
            return;
        }
        ImageLocation forDocument = ImageLocation.getForDocument(tLRPC$WallPaper.document);
        ImageReceiver imageReceiver = new ImageReceiver();
        imageReceiver.setAllowLoadingOnAttachedOnly(false);
        Point point = AndroidUtilities.displaySize;
        int iMin = Math.min(point.x, point.y);
        Point point2 = AndroidUtilities.displaySize;
        imageReceiver.setImage(forDocument, ((int) (iMin / AndroidUtilities.density)) + "_" + ((int) (Math.max(point2.x, point2.y) / AndroidUtilities.density)) + "_f", null, ".jpg", tLRPC$WallPaper, 1);
        imageReceiver.setDelegate(new ImageReceiver.ImageReceiverDelegate() { // from class: org.rbmain.ui.ActionBar.EmojiThemes$$ExternalSyntheticLambda1
            @Override // org.rbmain.messenger.ImageReceiver.ImageReceiverDelegate
            public final void didSetImage(ImageReceiver imageReceiver2, boolean z, boolean z2, boolean z3) {
                EmojiThemes.lambda$loadWallpaperImage$0(resultCallback, j, imageReceiver2, z, z2, z3);
            }

            @Override // org.rbmain.messenger.ImageReceiver.ImageReceiverDelegate
            public /* synthetic */ void onAnimationReady(ImageReceiver imageReceiver2) {
                ImageReceiver.ImageReceiverDelegate.CC.$default$onAnimationReady(this, imageReceiver2);
            }
        });
        ImageLoader.getInstance().loadImageForImageReceiver(imageReceiver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadWallpaperImage$0(ResultCallback resultCallback, long j, ImageReceiver imageReceiver, boolean z, boolean z2, boolean z3) {
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
        ChatThemeController.saveWallpaperBitmap(bitmap, j);
    }

    public void loadWallpaperThumb(int i, final ResultCallback<Pair<Long, Bitmap>> resultCallback) {
        TLRPC$WallPaper wallpaper = getWallpaper(i);
        if (wallpaper == null) {
            if (resultCallback != null) {
                resultCallback.onComplete(null);
                return;
            }
            return;
        }
        final long j = getTlTheme(i).id;
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
            if (resultCallback != null) {
                resultCallback.onComplete(new Pair<>(Long.valueOf(j), wallpaperThumbBitmap));
                return;
            }
            return;
        }
        TLRPC$Document tLRPC$Document = wallpaper.document;
        if (tLRPC$Document == null) {
            if (resultCallback != null) {
                resultCallback.onComplete(new Pair<>(Long.valueOf(j), null));
            }
        } else {
            ImageLocation forDocument = ImageLocation.getForDocument(FileLoader.getClosestPhotoSizeWithSize(tLRPC$Document.thumbs, 140), wallpaper.document);
            ImageReceiver imageReceiver = new ImageReceiver();
            imageReceiver.setAllowLoadingOnAttachedOnly(false);
            imageReceiver.setImage(forDocument, "120_140", null, null, null, 1);
            imageReceiver.setDelegate(new ImageReceiver.ImageReceiverDelegate() { // from class: org.rbmain.ui.ActionBar.EmojiThemes$$ExternalSyntheticLambda2
                @Override // org.rbmain.messenger.ImageReceiver.ImageReceiverDelegate
                public final void didSetImage(ImageReceiver imageReceiver2, boolean z, boolean z2, boolean z3) {
                    EmojiThemes.lambda$loadWallpaperThumb$3(resultCallback, j, wallpaperThumbFile, imageReceiver2, z, z2, z3);
                }

                @Override // org.rbmain.messenger.ImageReceiver.ImageReceiverDelegate
                public /* synthetic */ void onAnimationReady(ImageReceiver imageReceiver2) {
                    ImageReceiver.ImageReceiverDelegate.CC.$default$onAnimationReady(this, imageReceiver2);
                }
            });
            ImageLoader.getInstance().loadImageForImageReceiver(imageReceiver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadWallpaperThumb$3(ResultCallback resultCallback, long j, final File file, ImageReceiver imageReceiver, boolean z, boolean z2, boolean z3) {
        ImageReceiver.BitmapHolder bitmapSafe = imageReceiver.getBitmapSafe();
        if (!z || bitmapSafe == null || bitmapSafe.bitmap.isRecycled()) {
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
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.ui.ActionBar.EmojiThemes$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    EmojiThemes.lambda$loadWallpaperThumb$2(file, bitmap);
                }
            });
        } else if (resultCallback != null) {
            resultCallback.onComplete(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadWallpaperThumb$2(File file, Bitmap bitmap) throws IOException {
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
        loadWallpaperThumb(0, null);
        loadWallpaperThumb(1, null);
        loadWallpaper(0, null);
        loadWallpaper(1, null);
    }

    private File getWallpaperThumbFile(long j) {
        return new File(ApplicationLoader.getFilesDirFixed(), "wallpaper_thumb_" + j + ".png");
    }

    public static Theme.ThemeInfo getDefaultThemeInfo(boolean z) {
        String string;
        Theme.ThemeInfo currentNightTheme = z ? Theme.getCurrentNightTheme() : Theme.getCurrentTheme();
        if (z != currentNightTheme.isDark()) {
            SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("themeconfig", 0);
            if (z) {
                string = sharedPreferences.getString("lastDarkTheme", "Dark Blue");
            } else {
                string = sharedPreferences.getString("lastDayTheme", "Blue");
            }
            currentNightTheme = Theme.getTheme(string);
            if (currentNightTheme == null) {
                currentNightTheme = Theme.getTheme(z ? "Dark Blue" : "Blue");
            }
        }
        return new Theme.ThemeInfo(currentNightTheme);
    }

    public static void saveCustomTheme(Theme.ThemeInfo themeInfo, int i) throws IOException {
        SparseArray<Theme.ThemeAccent> sparseArray;
        Theme.ThemeAccent themeAccent;
        if (themeInfo == null) {
            return;
        }
        if (i < 0 || (sparseArray = themeInfo.themeAccentsMap) == null || !((themeAccent = sparseArray.get(i)) == null || themeAccent.isDefault)) {
            if (themeInfo.getKey().equals("Blue") && i == 99) {
                return;
            }
            if (themeInfo.getKey().equals("Day") && i == 9) {
                return;
            }
            if (themeInfo.getKey().equals("Night") && i == 0) {
                return;
            }
            if (themeInfo.getKey().equals("Dark Blue") && i == 0) {
                return;
            }
            boolean zIsDark = themeInfo.isDark();
            ApplicationLoader.applicationContext.getSharedPreferences("themeconfig", 0).edit().putString(zIsDark ? "lastDarkCustomTheme" : "lastDayCustomTheme", themeInfo.getKey()).putInt(zIsDark ? "lastDarkCustomThemeAccentId" : "lastDayCustomThemeAccentId", i).apply();
        }
    }

    public static class ThemeItem {
        public int accentId = -1;
        public SparseIntArray currentPreviewColors;
        int settingsIndex;
        public Theme.ThemeInfo themeInfo;
        TLRPC$TL_theme tlTheme;
        private String wallpaperLink;
    }
}
