package ir.eitaa.messenger;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public class Emoji {
    private static final int MAX_RECENT_EMOJI_COUNT = 48;
    private static int bigImgSize;
    public static float emojiDrawingYOffset;
    private static Paint placeholderPaint;
    private static boolean recentEmojiLoaded;
    private static HashMap<CharSequence, DrawableInfo> rects = new HashMap<>();
    private static boolean inited = false;
    private static int[] emojiCounts = {1906, 199, 123, 332, 128, 222, 292, 259};
    private static Bitmap[][] emojiBmp = new Bitmap[8][];
    private static boolean[][] loadingEmoji = new boolean[8][];
    public static HashMap<String, Integer> emojiUseHistory = new HashMap<>();
    public static ArrayList<String> recentEmoji = new ArrayList<>();
    public static HashMap<String, String> emojiColor = new HashMap<>();
    private static Runnable invalidateUiRunnable = new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$Emoji$8o_OAgfxpzsDvs549RrEhWM6wwk
        @Override // java.lang.Runnable
        public final void run() {
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.emojiLoaded, new Object[0]);
        }
    };
    private static int drawImgSize = AndroidUtilities.dp(20.0f);

    static {
        bigImgSize = AndroidUtilities.dp(AndroidUtilities.isTablet() ? 40.0f : 34.0f);
        int i = 0;
        while (true) {
            Bitmap[][] bitmapArr = emojiBmp;
            if (i >= bitmapArr.length) {
                break;
            }
            int[] iArr = emojiCounts;
            bitmapArr[i] = new Bitmap[iArr[i]];
            loadingEmoji[i] = new boolean[iArr[i]];
            i++;
        }
        for (int i2 = 0; i2 < EmojiData.data.length; i2++) {
            int i3 = 0;
            while (true) {
                String[][] strArr = EmojiData.data;
                if (i3 < strArr[i2].length) {
                    rects.put(strArr[i2][i3], new DrawableInfo((byte) i2, (short) i3, i3));
                    i3++;
                }
            }
        }
        Paint paint = new Paint();
        placeholderPaint = paint;
        paint.setColor(0);
    }

    public static void preloadEmoji(CharSequence code) {
        DrawableInfo drawableInfo = getDrawableInfo(code);
        if (drawableInfo != null) {
            loadEmoji(drawableInfo.page, drawableInfo.page2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void loadEmoji(final byte page, final short page2) {
        if (emojiBmp[page][page2] == null) {
            boolean[][] zArr = loadingEmoji;
            if (zArr[page][page2]) {
                return;
            }
            zArr[page][page2] = true;
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$Emoji$tSZJxchfz2E1eq4-MYZuODtzwY8
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    Emoji.lambda$loadEmoji$1(page, page2);
                }
            });
        }
    }

    static /* synthetic */ void lambda$loadEmoji$1(byte b, short s) throws IOException {
        loadEmojiInternal(b, s);
        loadingEmoji[b][s] = false;
    }

    private static void loadEmojiInternal(final byte page, final short page2) throws IOException {
        try {
            int i = AndroidUtilities.density <= 1.0f ? 2 : 1;
            Bitmap bitmapDecodeStream = null;
            try {
                InputStream inputStreamOpen = ApplicationLoader.applicationContext.getAssets().open("emoji/" + String.format(Locale.US, "%d_%d.png", Byte.valueOf(page), Short.valueOf(page2)));
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = false;
                options.inSampleSize = i;
                bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen, null, options);
                inputStreamOpen.close();
            } catch (Throwable th) {
                FileLog.e(th);
            }
            emojiBmp[page][page2] = bitmapDecodeStream;
            AndroidUtilities.cancelRunOnUIThread(invalidateUiRunnable);
            AndroidUtilities.runOnUIThread(invalidateUiRunnable);
        } catch (Throwable th2) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("Error loading emoji", th2);
            }
        }
    }

    public static void invalidateAll(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                invalidateAll(viewGroup.getChildAt(i));
            }
            return;
        }
        if (view instanceof TextView) {
            view.invalidate();
        }
    }

    public static String fixEmoji(String emoji) {
        int length = emoji.length();
        int i = 0;
        while (i < length) {
            char cCharAt = emoji.charAt(i);
            if (cCharAt < 55356 || cCharAt > 55358) {
                if (cCharAt == 8419) {
                    return emoji;
                }
                if (cCharAt >= 8252 && cCharAt <= 12953 && EmojiData.emojiToFE0FMap.containsKey(Character.valueOf(cCharAt))) {
                    StringBuilder sb = new StringBuilder();
                    i++;
                    sb.append(emoji.substring(0, i));
                    sb.append("️");
                    sb.append(emoji.substring(i));
                    emoji = sb.toString();
                    length++;
                }
            } else if (cCharAt != 55356 || i >= length - 1) {
                i++;
            } else {
                int i2 = i + 1;
                char cCharAt2 = emoji.charAt(i2);
                if (cCharAt2 == 56879 || cCharAt2 == 56324 || cCharAt2 == 56858 || cCharAt2 == 56703) {
                    StringBuilder sb2 = new StringBuilder();
                    i += 2;
                    sb2.append(emoji.substring(0, i));
                    sb2.append("️");
                    sb2.append(emoji.substring(i));
                    emoji = sb2.toString();
                    length++;
                } else {
                    i = i2;
                }
            }
            i++;
        }
        return emoji;
    }

    public static EmojiDrawable getEmojiDrawable(CharSequence code) {
        DrawableInfo drawableInfo = getDrawableInfo(code);
        if (drawableInfo == null) {
            return null;
        }
        EmojiDrawable emojiDrawable = new EmojiDrawable(drawableInfo);
        int i = drawImgSize;
        emojiDrawable.setBounds(0, 0, i, i);
        return emojiDrawable;
    }

    private static DrawableInfo getDrawableInfo(CharSequence code) {
        CharSequence charSequence;
        DrawableInfo drawableInfo = rects.get(code);
        return (drawableInfo != null || (charSequence = EmojiData.emojiAliasMap.get(code)) == null) ? drawableInfo : rects.get(charSequence);
    }

    public static boolean isValidEmoji(CharSequence code) {
        CharSequence charSequence;
        if (TextUtils.isEmpty(code)) {
            return false;
        }
        DrawableInfo drawableInfo = rects.get(code);
        if (drawableInfo == null && (charSequence = EmojiData.emojiAliasMap.get(code)) != null) {
            drawableInfo = rects.get(charSequence);
        }
        return drawableInfo != null;
    }

    public static Drawable getEmojiBigDrawable(String code) {
        CharSequence charSequence;
        EmojiDrawable emojiDrawable = getEmojiDrawable(code);
        if (emojiDrawable == null && (charSequence = EmojiData.emojiAliasMap.get(code)) != null) {
            emojiDrawable = getEmojiDrawable(charSequence);
        }
        if (emojiDrawable == null) {
            return null;
        }
        int i = bigImgSize;
        emojiDrawable.setBounds(0, 0, i, i);
        emojiDrawable.fullSize = true;
        return emojiDrawable;
    }

    public static class EmojiDrawable extends Drawable {
        private static Paint paint = new Paint(2);
        private static Rect rect = new Rect();
        private boolean fullSize = false;
        private DrawableInfo info;

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -2;
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter cf) {
        }

        public EmojiDrawable(DrawableInfo i) {
            this.info = i;
        }

        public DrawableInfo getDrawableInfo() {
            return this.info;
        }

        public Rect getDrawRect() {
            Rect bounds = getBounds();
            int iCenterX = bounds.centerX();
            int iCenterY = bounds.centerY();
            rect.left = iCenterX - ((this.fullSize ? Emoji.bigImgSize : Emoji.drawImgSize) / 2);
            rect.right = iCenterX + ((this.fullSize ? Emoji.bigImgSize : Emoji.drawImgSize) / 2);
            rect.top = iCenterY - ((this.fullSize ? Emoji.bigImgSize : Emoji.drawImgSize) / 2);
            rect.bottom = iCenterY + ((this.fullSize ? Emoji.bigImgSize : Emoji.drawImgSize) / 2);
            return rect;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Rect bounds;
            if (!isLoaded()) {
                DrawableInfo drawableInfo = this.info;
                Emoji.loadEmoji(drawableInfo.page, drawableInfo.page2);
                canvas.drawRect(getBounds(), Emoji.placeholderPaint);
                return;
            }
            if (this.fullSize) {
                bounds = getDrawRect();
            } else {
                bounds = getBounds();
            }
            if (canvas.quickReject(bounds.left, bounds.top, bounds.right, bounds.bottom, Canvas.EdgeType.AA)) {
                return;
            }
            Bitmap[][] bitmapArr = Emoji.emojiBmp;
            DrawableInfo drawableInfo2 = this.info;
            canvas.drawBitmap(bitmapArr[drawableInfo2.page][drawableInfo2.page2], (Rect) null, bounds, paint);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int alpha) {
            paint.setAlpha(alpha);
        }

        public boolean isLoaded() {
            Bitmap[][] bitmapArr = Emoji.emojiBmp;
            DrawableInfo drawableInfo = this.info;
            return bitmapArr[drawableInfo.page][drawableInfo.page2] != null;
        }

        public void preload() {
            if (isLoaded()) {
                return;
            }
            DrawableInfo drawableInfo = this.info;
            Emoji.loadEmoji(drawableInfo.page, drawableInfo.page2);
        }
    }

    private static class DrawableInfo {
        public int emojiIndex;
        public byte page;
        public short page2;

        public DrawableInfo(byte p, short p2, int index) {
            this.page = p;
            this.page2 = p2;
            this.emojiIndex = index;
        }
    }

    private static boolean inArray(char c, char[] a) {
        for (char c2 : a) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    public static CharSequence replaceEmoji(CharSequence cs, Paint.FontMetricsInt fontMetrics, int size, boolean createNew) {
        return replaceEmoji(cs, fontMetrics, size, createNew, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0191 A[Catch: Exception -> 0x028c, TryCatch #0 {Exception -> 0x028c, blocks: (B:15:0x0040, B:34:0x007b, B:86:0x011f, B:88:0x0125, B:90:0x0130, B:94:0x013e, B:115:0x0191, B:117:0x0195, B:121:0x01a2, B:123:0x01a8, B:148:0x01ee, B:137:0x01d4, B:139:0x01d8, B:152:0x01f9, B:154:0x0200, B:156:0x0204, B:158:0x020f, B:162:0x021d, B:165:0x022d, B:167:0x0236, B:169:0x0244, B:171:0x025b, B:173:0x026b, B:177:0x0275, B:95:0x014b, B:97:0x0152, B:99:0x015c, B:103:0x016b, B:105:0x017c, B:109:0x0185, B:23:0x0056, B:25:0x0061, B:36:0x008a, B:44:0x009e, B:45:0x00a1, B:49:0x00ad, B:51:0x00b6, B:55:0x00c0, B:63:0x00d4, B:81:0x010d, B:74:0x00f5, B:79:0x0105), top: B:192:0x0040 }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01f7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0200 A[Catch: Exception -> 0x028c, TryCatch #0 {Exception -> 0x028c, blocks: (B:15:0x0040, B:34:0x007b, B:86:0x011f, B:88:0x0125, B:90:0x0130, B:94:0x013e, B:115:0x0191, B:117:0x0195, B:121:0x01a2, B:123:0x01a8, B:148:0x01ee, B:137:0x01d4, B:139:0x01d8, B:152:0x01f9, B:154:0x0200, B:156:0x0204, B:158:0x020f, B:162:0x021d, B:165:0x022d, B:167:0x0236, B:169:0x0244, B:171:0x025b, B:173:0x026b, B:177:0x0275, B:95:0x014b, B:97:0x0152, B:99:0x015c, B:103:0x016b, B:105:0x017c, B:109:0x0185, B:23:0x0056, B:25:0x0061, B:36:0x008a, B:44:0x009e, B:45:0x00a1, B:49:0x00ad, B:51:0x00b6, B:55:0x00c0, B:63:0x00d4, B:81:0x010d, B:74:0x00f5, B:79:0x0105), top: B:192:0x0040 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x011f A[Catch: Exception -> 0x028c, TryCatch #0 {Exception -> 0x028c, blocks: (B:15:0x0040, B:34:0x007b, B:86:0x011f, B:88:0x0125, B:90:0x0130, B:94:0x013e, B:115:0x0191, B:117:0x0195, B:121:0x01a2, B:123:0x01a8, B:148:0x01ee, B:137:0x01d4, B:139:0x01d8, B:152:0x01f9, B:154:0x0200, B:156:0x0204, B:158:0x020f, B:162:0x021d, B:165:0x022d, B:167:0x0236, B:169:0x0244, B:171:0x025b, B:173:0x026b, B:177:0x0275, B:95:0x014b, B:97:0x0152, B:99:0x015c, B:103:0x016b, B:105:0x017c, B:109:0x0185, B:23:0x0056, B:25:0x0061, B:36:0x008a, B:44:0x009e, B:45:0x00a1, B:49:0x00ad, B:51:0x00b6, B:55:0x00c0, B:63:0x00d4, B:81:0x010d, B:74:0x00f5, B:79:0x0105), top: B:192:0x0040 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.CharSequence replaceEmoji(java.lang.CharSequence r25, android.graphics.Paint.FontMetricsInt r26, int r27, boolean r28, int[] r29) {
        /*
            Method dump skipped, instructions count: 670
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.Emoji.replaceEmoji(java.lang.CharSequence, android.graphics.Paint$FontMetricsInt, int, boolean, int[]):java.lang.CharSequence");
    }

    public static class EmojiSpan extends ImageSpan {
        private Paint.FontMetricsInt fontMetrics;
        private int size;

        public EmojiSpan(EmojiDrawable d, int verticalAlignment, int s, Paint.FontMetricsInt original) {
            super(d, verticalAlignment);
            this.size = AndroidUtilities.dp(20.0f);
            this.fontMetrics = original;
            if (original != null) {
                int iAbs = Math.abs(original.descent) + Math.abs(this.fontMetrics.ascent);
                this.size = iAbs;
                if (iAbs == 0) {
                    this.size = AndroidUtilities.dp(20.0f);
                }
            }
        }

        public void replaceFontMetrics(Paint.FontMetricsInt newMetrics, int newSize) {
            this.fontMetrics = newMetrics;
            this.size = newSize;
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
            if (fm == null) {
                fm = new Paint.FontMetricsInt();
            }
            Paint.FontMetricsInt fontMetricsInt = this.fontMetrics;
            if (fontMetricsInt == null) {
                int size = super.getSize(paint, text, start, end, fm);
                int iDp = AndroidUtilities.dp(8.0f);
                int iDp2 = AndroidUtilities.dp(10.0f);
                int i = (-iDp2) - iDp;
                fm.top = i;
                int i2 = iDp2 - iDp;
                fm.bottom = i2;
                fm.ascent = i;
                fm.leading = 0;
                fm.descent = i2;
                return size;
            }
            fm.ascent = fontMetricsInt.ascent;
            fm.descent = fontMetricsInt.descent;
            fm.top = fontMetricsInt.top;
            fm.bottom = fontMetricsInt.bottom;
            if (getDrawable() != null) {
                Drawable drawable = getDrawable();
                int i3 = this.size;
                drawable.setBounds(0, 0, i3, i3);
            }
            return this.size;
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
            boolean z;
            boolean z2 = true;
            if (paint.getAlpha() != 255) {
                getDrawable().setAlpha(paint.getAlpha());
                z = true;
            } else {
                z = false;
            }
            if (Emoji.emojiDrawingYOffset != 0.0f) {
                canvas.save();
                canvas.translate(0.0f, Emoji.emojiDrawingYOffset);
            } else {
                z2 = false;
            }
            super.draw(canvas, text, start, end, x, top, y, bottom, paint);
            if (z2) {
                canvas.restore();
            }
            if (z) {
                getDrawable().setAlpha(255);
            }
        }
    }

    public static void addRecentEmoji(String code) {
        Integer num = emojiUseHistory.get(code);
        if (num == null) {
            num = 0;
        }
        if (num.intValue() == 0 && emojiUseHistory.size() >= 48) {
            emojiUseHistory.remove(recentEmoji.get(r1.size() - 1));
            recentEmoji.set(r1.size() - 1, code);
        }
        emojiUseHistory.put(code, Integer.valueOf(num.intValue() + 1));
    }

    public static void sortEmoji() {
        recentEmoji.clear();
        Iterator<Map.Entry<String, Integer>> it = emojiUseHistory.entrySet().iterator();
        while (it.hasNext()) {
            recentEmoji.add(it.next().getKey());
        }
        Collections.sort(recentEmoji, $$Lambda$Emoji$G66rJ80VA_oH1K8cWWJfnFGMuzA.INSTANCE);
        while (recentEmoji.size() > 48) {
            recentEmoji.remove(r0.size() - 1);
        }
    }

    static /* synthetic */ int lambda$sortEmoji$2(String str, String str2) {
        Integer num = emojiUseHistory.get(str);
        Integer num2 = emojiUseHistory.get(str2);
        if (num == null) {
            num = 0;
        }
        if (num2 == null) {
            num2 = 0;
        }
        if (num.intValue() > num2.intValue()) {
            return -1;
        }
        return num.intValue() < num2.intValue() ? 1 : 0;
    }

    public static void saveRecentEmoji() {
        SharedPreferences globalEmojiSettings = MessagesController.getGlobalEmojiSettings();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : emojiUseHistory.entrySet()) {
            if (sb.length() != 0) {
                sb.append(",");
            }
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        globalEmojiSettings.edit().putString("emojis2", sb.toString()).commit();
    }

    public static void clearRecentEmoji() {
        MessagesController.getGlobalEmojiSettings().edit().putBoolean("filled_default", true).commit();
        emojiUseHistory.clear();
        recentEmoji.clear();
        saveRecentEmoji();
    }

    public static void loadRecentEmoji() {
        if (recentEmojiLoaded) {
            return;
        }
        recentEmojiLoaded = true;
        SharedPreferences globalEmojiSettings = MessagesController.getGlobalEmojiSettings();
        try {
            emojiUseHistory.clear();
            int i = 4;
            if (globalEmojiSettings.contains("emojis")) {
                String string = globalEmojiSettings.getString("emojis", "");
                if (string != null && string.length() > 0) {
                    String[] strArrSplit = string.split(",");
                    int length = strArrSplit.length;
                    int i2 = 0;
                    while (i2 < length) {
                        String[] strArrSplit2 = strArrSplit[i2].split("=");
                        long jLongValue = Utilities.parseLong(strArrSplit2[0]).longValue();
                        StringBuilder sb = new StringBuilder();
                        int i3 = 0;
                        while (i3 < i) {
                            sb.insert(0, (char) jLongValue);
                            jLongValue >>= 16;
                            if (jLongValue == 0) {
                                break;
                            }
                            i3++;
                            i = 4;
                        }
                        if (sb.length() > 0) {
                            emojiUseHistory.put(sb.toString(), Utilities.parseInt(strArrSplit2[1]));
                        }
                        i2++;
                        i = 4;
                    }
                }
                globalEmojiSettings.edit().remove("emojis").commit();
                saveRecentEmoji();
            } else {
                String string2 = globalEmojiSettings.getString("emojis2", "");
                if (string2 != null && string2.length() > 0) {
                    for (String str : string2.split(",")) {
                        String[] strArrSplit3 = str.split("=");
                        emojiUseHistory.put(strArrSplit3[0], Utilities.parseInt(strArrSplit3[1]));
                    }
                }
            }
            if (emojiUseHistory.isEmpty() && !globalEmojiSettings.getBoolean("filled_default", false)) {
                String[] strArr = {"😂", "😘", "❤", "😍", "😊", "😁", "👍", "☺", "😔", "😄", "😭", "😒", "😳", "😜", "🙈", "😉", "😃", "😢", "😝", "😱", "😡", "😏", "😞", "😅", "😚", "🙊", "😌", "😀", "😋", "😆", "👌", "😐", "😕"};
                for (int i4 = 0; i4 < 33; i4++) {
                    emojiUseHistory.put(strArr[i4], Integer.valueOf(33 - i4));
                }
                globalEmojiSettings.edit().putBoolean("filled_default", true).commit();
                saveRecentEmoji();
            }
            sortEmoji();
        } catch (Exception e) {
            FileLog.e(e);
        }
        try {
            String string3 = globalEmojiSettings.getString("color", "");
            if (string3 == null || string3.length() <= 0) {
                return;
            }
            for (String str2 : string3.split(",")) {
                String[] strArrSplit4 = str2.split("=");
                emojiColor.put(strArrSplit4[0], strArrSplit4[1]);
            }
        } catch (Exception e2) {
            FileLog.e(e2);
        }
    }

    public static void saveEmojiColors() {
        SharedPreferences globalEmojiSettings = MessagesController.getGlobalEmojiSettings();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : emojiColor.entrySet()) {
            if (sb.length() != 0) {
                sb.append(",");
            }
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        globalEmojiSettings.edit().putString("color", sb.toString()).commit();
    }
}
