package org.rbmain.messenger;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ir.resaneh1.iptv.helper.FlavorHelper;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.rbmain.messenger.CompoundEmoji;
import org.rbmain.ui.Components.AnimatedEmojiSpan;

/* loaded from: classes4.dex */
public class Emoji {
    private static String[] DEFAULT_RECENT = null;
    private static final int MAX_RECENT_EMOJI_COUNT = 48;
    public static int bigImgSize;
    public static int drawImgSize;
    private static Bitmap[][] emojiBmp;
    public static HashMap<String, String> emojiColor;
    private static int[] emojiCounts;
    public static boolean emojiDrawingUseAlpha;
    public static float emojiDrawingYOffset;
    public static HashMap<String, Integer> emojiUseHistory;
    private static final HashSet<String> hiddenEmojiData;
    private static Set<String> hiddenEmojiNameSet;
    private static Set<String> hiddenEmojiNameSetShad;
    public static Runnable invalidateUiRunnable;
    private static boolean[][] loadingEmoji;
    public static Paint placeholderPaint;
    public static ArrayList<String> recentEmoji;
    private static boolean recentEmojiLoaded;
    private static HashMap<CharSequence, DrawableInfo> rects = new HashMap<>();
    private static boolean inited = false;

    public static abstract class EmojiDrawable extends Drawable {
        boolean fullSize = false;
        int placeholderColor = 268435456;

        public boolean isLoaded() {
            return false;
        }

        public void preload() {
        }
    }

    static {
        String[][] strArr = EmojiData.data;
        emojiCounts = new int[]{strArr[0].length, strArr[1].length, strArr[2].length, strArr[3].length, strArr[4].length, strArr[5].length, strArr[6].length, strArr[7].length};
        emojiBmp = new Bitmap[8][];
        loadingEmoji = new boolean[8][];
        emojiUseHistory = new HashMap<>();
        recentEmoji = new ArrayList<>();
        emojiColor = new HashMap<>();
        invalidateUiRunnable = new Runnable() { // from class: org.rbmain.messenger.Emoji$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Emoji.lambda$static$0();
            }
        };
        emojiDrawingUseAlpha = true;
        DEFAULT_RECENT = new String[]{"😂", "😘", "❤", "😍", "😊", "😁", "👍", "☺", "😔", "😄", "😭", "💋", "😒", "😳", "😜", "🙈", "😉", "😃", "😢", "😝", "😱", "😡", "😏", "😞", "😅", "😚", "🙊", "😌", "😀", "😋", "😆", "👌", "😐", "😕"};
        hiddenEmojiNameSet = new HashSet(Arrays.asList("7_117", "7_5"));
        hiddenEmojiNameSetShad = new HashSet(Arrays.asList("7_117", "7_5", "0_349", "0_1150", "0_1151", "0_1153", "0_1159", "0_1201", "0_1207", "0_1483", "0_1495", "0_1496", "0_1497", "0_1612", "0_1630", "0_1656", "0_1760", "0_1786", "0_1812", "0_1838", "0_1864", "0_1890", "0_1921", "0_1922", "0_1923", "0_1924", "0_1925", "0_1926", "0_1927", "0_1928", "0_1929", "0_1930", "0_1955", "0_1956", "3_37", "3_55", "3_58", "3_137", "3_143", "3_155", "3_227", "3_288", "4_70", "4_110", "6_24", "6_27", "6_29", "6_30", "6_31", "6_32", "6_34", "6_38", "6_40", "6_106", "6_134", "7_6"));
        hiddenEmojiData = new HashSet<>();
        drawImgSize = AndroidUtilities.dp(20.0f);
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
                String[][] strArr2 = EmojiData.data;
                if (i3 < strArr2[i2].length) {
                    rects.put(strArr2[i2][i3], new DrawableInfo((byte) i2, (short) i3, i3));
                    i3++;
                }
            }
        }
        Paint paint = new Paint();
        placeholderPaint = paint;
        paint.setColor(0);
        if (FlavorHelper.isShad()) {
            hiddenEmojiNameSet = hiddenEmojiNameSetShad;
        }
        Set<String> set = hiddenEmojiNameSet;
        if (set == null || set.size() <= 0) {
            return;
        }
        try {
            for (String str : hiddenEmojiNameSet) {
                int iIndexOf = str.indexOf("_");
                hiddenEmojiData.add(EmojiData.data[Integer.parseInt(str.substring(0, iIndexOf))][Integer.parseInt(str.substring(iIndexOf + 1))]);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0() {
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.emojiDidLoad, new Object[0]);
    }

    public static void preloadEmoji(CharSequence charSequence) {
        DrawableInfo drawableInfo = getDrawableInfo(charSequence);
        if (drawableInfo != null) {
            loadEmoji(drawableInfo.page, drawableInfo.page2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void loadEmoji(final byte b, final short s) {
        if (emojiBmp[b][s] == null) {
            boolean[][] zArr = loadingEmoji;
            if (zArr[b][s]) {
                return;
            }
            zArr[b][s] = true;
            if (FlavorHelper.isShad()) {
                hiddenEmojiNameSet = hiddenEmojiNameSetShad;
            }
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.Emoji$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    Emoji.lambda$loadEmoji$1(b, s);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadEmoji$1(byte b, short s) {
        Bitmap bitmapLoadBitmap;
        Locale locale = Locale.US;
        if (hiddenEmojiNameSet.contains(String.format(locale, "%d_%d", Byte.valueOf(b), Short.valueOf(s)))) {
            bitmapLoadBitmap = Bitmaps.createBitmap(66, 66, Bitmap.Config.ARGB_8888);
        } else {
            bitmapLoadBitmap = loadBitmap("emoji/" + String.format(locale, "%d_%d.png", Byte.valueOf(b), Short.valueOf(s)));
        }
        if (bitmapLoadBitmap != null) {
            emojiBmp[b][s] = bitmapLoadBitmap;
            AndroidUtilities.cancelRunOnUIThread(invalidateUiRunnable);
            AndroidUtilities.runOnUIThread(invalidateUiRunnable);
        }
        loadingEmoji[b][s] = false;
    }

    public static Bitmap loadBitmap(String str) {
        Bitmap bitmapDecodeStream;
        try {
            int i = AndroidUtilities.density <= 1.0f ? 2 : 1;
            try {
                InputStream inputStreamOpen = ApplicationLoader.applicationContext.getAssets().open(str);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = false;
                options.inSampleSize = i;
                bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen, null, options);
                try {
                    inputStreamOpen.close();
                } catch (Throwable th) {
                    th = th;
                    FileLog.e(th);
                    return bitmapDecodeStream;
                }
            } catch (Throwable th2) {
                th = th2;
                bitmapDecodeStream = null;
            }
            return bitmapDecodeStream;
        } catch (Throwable th3) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("Error loading emoji", th3);
            }
            return null;
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

    public static String fixEmoji(String str) {
        if (hiddenEmojiData.contains(str)) {
            return io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        }
        int length = str.length();
        int i = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt < 55356 || cCharAt > 55358) {
                if (cCharAt == 8419) {
                    return str;
                }
                if (cCharAt >= 8252 && cCharAt <= 12953 && EmojiData.emojiToFE0FMap.containsKey(Character.valueOf(cCharAt))) {
                    StringBuilder sb = new StringBuilder();
                    i++;
                    sb.append(str.substring(0, i));
                    sb.append("️");
                    sb.append(str.substring(i));
                    str = sb.toString();
                    length++;
                }
            } else if (cCharAt != 55356 || i >= length - 1) {
                i++;
            } else {
                int i2 = i + 1;
                char cCharAt2 = str.charAt(i2);
                if (cCharAt2 == 56879 || cCharAt2 == 56324 || cCharAt2 == 56858 || cCharAt2 == 56703) {
                    StringBuilder sb2 = new StringBuilder();
                    i += 2;
                    sb2.append(str.substring(0, i));
                    sb2.append("️");
                    sb2.append(str.substring(i));
                    str = sb2.toString();
                    length++;
                } else {
                    i = i2;
                }
            }
            i++;
        }
        return str;
    }

    public static EmojiDrawable getEmojiDrawable(CharSequence charSequence) {
        CompoundEmoji.CompoundEmojiDrawable compoundEmojiDrawable;
        DrawableInfo drawableInfo = getDrawableInfo(charSequence);
        if (drawableInfo != null) {
            SimpleEmojiDrawable simpleEmojiDrawable = new SimpleEmojiDrawable(drawableInfo);
            int i = drawImgSize;
            simpleEmojiDrawable.setBounds(0, 0, i, i);
            return simpleEmojiDrawable;
        }
        if (charSequence == null || (compoundEmojiDrawable = CompoundEmoji.getCompoundEmojiDrawable(charSequence.toString())) == null) {
            return null;
        }
        int i2 = drawImgSize;
        compoundEmojiDrawable.setBounds(0, 0, i2, i2);
        return compoundEmojiDrawable;
    }

    private static DrawableInfo getDrawableInfo(CharSequence charSequence) {
        CharSequence charSequence2;
        DrawableInfo drawableInfo = rects.get(charSequence);
        return (drawableInfo != null || (charSequence2 = EmojiData.emojiAliasMap.get(charSequence)) == null) ? drawableInfo : rects.get(charSequence2);
    }

    public static boolean isValidEmoji(CharSequence charSequence) {
        CharSequence charSequence2;
        if (TextUtils.isEmpty(charSequence)) {
            return false;
        }
        DrawableInfo drawableInfo = rects.get(charSequence);
        if (drawableInfo == null && (charSequence2 = EmojiData.emojiAliasMap.get(charSequence)) != null) {
            drawableInfo = rects.get(charSequence2);
        }
        return drawableInfo != null;
    }

    public static Drawable getEmojiBigDrawable(String str) {
        CharSequence charSequence;
        EmojiDrawable compoundEmojiDrawable = CompoundEmoji.getCompoundEmojiDrawable(str);
        if (compoundEmojiDrawable != null) {
            int i = drawImgSize;
            compoundEmojiDrawable.setBounds(0, 0, i, i);
        } else {
            compoundEmojiDrawable = null;
        }
        if (compoundEmojiDrawable == null) {
            compoundEmojiDrawable = getEmojiDrawable(str);
        }
        if (compoundEmojiDrawable == null && (charSequence = EmojiData.emojiAliasMap.get(str)) != null) {
            compoundEmojiDrawable = getEmojiDrawable(charSequence);
        }
        if (compoundEmojiDrawable == null) {
            return null;
        }
        int i2 = bigImgSize;
        compoundEmojiDrawable.setBounds(0, 0, i2, i2);
        compoundEmojiDrawable.fullSize = true;
        return compoundEmojiDrawable;
    }

    public static class SimpleEmojiDrawable extends EmojiDrawable {
        private static Paint paint = new Paint(2);
        private static Rect rect = new Rect();
        private DrawableInfo info;

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -2;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }

        public SimpleEmojiDrawable(DrawableInfo drawableInfo) {
            this.info = drawableInfo;
        }

        public DrawableInfo getDrawableInfo() {
            return this.info;
        }

        public Rect getDrawRect() {
            Rect bounds = getBounds();
            int iCenterX = bounds.centerX();
            int iCenterY = bounds.centerY();
            Rect rect2 = rect;
            boolean z = this.fullSize;
            rect2.left = iCenterX - ((z ? Emoji.bigImgSize : Emoji.drawImgSize) / 2);
            rect.right = iCenterX + ((z ? Emoji.bigImgSize : Emoji.drawImgSize) / 2);
            rect.top = iCenterY - ((z ? Emoji.bigImgSize : Emoji.drawImgSize) / 2);
            rect.bottom = iCenterY + ((z ? Emoji.bigImgSize : Emoji.drawImgSize) / 2);
            return rect;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Rect bounds;
            if (!isLoaded()) {
                DrawableInfo drawableInfo = this.info;
                Emoji.loadEmoji(drawableInfo.page, drawableInfo.page2);
                Emoji.placeholderPaint.setColor(this.placeholderColor);
                Rect bounds2 = getBounds();
                canvas.drawCircle(bounds2.centerX(), bounds2.centerY(), bounds2.width() * 0.4f, Emoji.placeholderPaint);
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

        @Override // org.rbmain.messenger.Emoji.EmojiDrawable
        public boolean isLoaded() {
            Bitmap[][] bitmapArr = Emoji.emojiBmp;
            DrawableInfo drawableInfo = this.info;
            return bitmapArr[drawableInfo.page][drawableInfo.page2] != null;
        }

        @Override // org.rbmain.messenger.Emoji.EmojiDrawable
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

        public DrawableInfo(byte b, short s, int i) {
            this.page = b;
            this.page2 = s;
            this.emojiIndex = i;
        }
    }

    public static class EmojiSpanRange {
        public CharSequence code;
        public int end;
        public int start;

        public EmojiSpanRange(int i, int i2, CharSequence charSequence) {
            this.start = i;
            this.end = i2;
            this.code = charSequence;
        }
    }

    public static boolean fullyConsistsOfEmojis(CharSequence charSequence) {
        int[] iArr = new int[1];
        parseEmojis(charSequence, iArr);
        return iArr[0] > 0;
    }

    public static ArrayList<EmojiSpanRange> parseEmojis(CharSequence charSequence) {
        return parseEmojis(charSequence, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0196 A[Catch: Exception -> 0x027a, TryCatch #0 {Exception -> 0x027a, blocks: (B:9:0x0029, B:30:0x006c, B:88:0x011f, B:90:0x0123, B:92:0x0130, B:96:0x013e, B:115:0x0196, B:117:0x019a, B:121:0x01a7, B:123:0x01ad, B:161:0x020a, B:139:0x01d9, B:141:0x01dd, B:152:0x01f5, B:154:0x01f9, B:165:0x0215, B:167:0x021c, B:169:0x0220, B:171:0x022b, B:175:0x0239, B:178:0x0249, B:180:0x0252, B:182:0x0255, B:183:0x0266, B:97:0x014b, B:99:0x0152, B:101:0x015c, B:105:0x016b, B:107:0x0185, B:109:0x018b, B:17:0x0041, B:19:0x004c, B:32:0x0078, B:44:0x009a, B:42:0x0090, B:49:0x00ac, B:57:0x00c0, B:77:0x0100, B:68:0x00e2, B:75:0x00f8), top: B:194:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList<org.rbmain.messenger.Emoji.EmojiSpanRange> parseEmojis(java.lang.CharSequence r25, int[] r26) {
        /*
            Method dump skipped, instructions count: 650
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.Emoji.parseEmojis(java.lang.CharSequence, int[]):java.util.ArrayList");
    }

    public static CharSequence replaceEmoji(CharSequence charSequence, Paint.FontMetricsInt fontMetricsInt, boolean z) {
        return replaceEmoji(charSequence, fontMetricsInt, AndroidUtilities.dp(16.0f), z, (int[]) null);
    }

    public static CharSequence replaceEmoji(CharSequence charSequence, Paint.FontMetricsInt fontMetricsInt, int i, boolean z) {
        return replaceEmoji(charSequence, fontMetricsInt, i, z, (int[]) null);
    }

    public static CharSequence replaceEmoji(CharSequence charSequence, Paint.FontMetricsInt fontMetricsInt, int i, boolean z, int[] iArr) {
        return replaceEmoji(charSequence, fontMetricsInt, z, iArr, 0);
    }

    public static CharSequence replaceEmoji(CharSequence charSequence, Paint.FontMetricsInt fontMetricsInt, boolean z, int[] iArr, int i) {
        Spannable spannableNewSpannable;
        int i2;
        EmojiSpanRange emojiSpanRange;
        boolean z2;
        if (SharedConfig.useSystemEmoji || charSequence == null || charSequence.length() == 0) {
            return charSequence;
        }
        if (!z && (charSequence instanceof Spannable)) {
            spannableNewSpannable = (Spannable) charSequence;
        } else {
            spannableNewSpannable = Spannable.Factory.getInstance().newSpannable(charSequence.toString());
        }
        ArrayList<EmojiSpanRange> emojis = parseEmojis(spannableNewSpannable, iArr);
        if (emojis.isEmpty()) {
            return charSequence;
        }
        AnimatedEmojiSpan[] animatedEmojiSpanArr = (AnimatedEmojiSpan[]) spannableNewSpannable.getSpans(0, spannableNewSpannable.length(), AnimatedEmojiSpan.class);
        int i3 = SharedConfig.getDevicePerformanceClass() >= 2 ? 100 : 50;
        while (i2 < emojis.size()) {
            try {
                emojiSpanRange = emojis.get(i2);
            } catch (Exception e) {
                FileLog.e(e);
            }
            if (animatedEmojiSpanArr != null) {
                int i4 = 0;
                while (true) {
                    if (i4 >= animatedEmojiSpanArr.length) {
                        z2 = false;
                        break;
                    }
                    AnimatedEmojiSpan animatedEmojiSpan = animatedEmojiSpanArr[i4];
                    if (animatedEmojiSpan != null && spannableNewSpannable.getSpanStart(animatedEmojiSpan) == emojiSpanRange.start && spannableNewSpannable.getSpanEnd(animatedEmojiSpan) == emojiSpanRange.end) {
                        z2 = true;
                        break;
                    }
                    i4++;
                }
                i2 = z2 ? i2 + 1 : 0;
            }
            EmojiDrawable emojiDrawable = getEmojiDrawable(emojiSpanRange.code);
            if (emojiDrawable != null) {
                EmojiSpan emojiSpan = new EmojiSpan(emojiDrawable, i, fontMetricsInt);
                CharSequence charSequence2 = emojiSpanRange.code;
                emojiSpan.emoji = charSequence2 == null ? null : charSequence2.toString();
                spannableNewSpannable.setSpan(emojiSpan, emojiSpanRange.start, emojiSpanRange.end, 33);
            }
            int i5 = Build.VERSION.SDK_INT;
            if ((i5 < 23 || i5 >= 29) && i2 + 1 >= i3) {
                break;
            }
        }
        return spannableNewSpannable;
    }

    public static class EmojiSpan extends ImageSpan {
        public boolean drawn;
        public String emoji;
        public Paint.FontMetricsInt fontMetrics;
        public float lastDrawX;
        public float lastDrawY;
        public int size;

        public EmojiSpan(Drawable drawable, int i, Paint.FontMetricsInt fontMetricsInt) {
            super(drawable, i);
            this.size = AndroidUtilities.dp(20.0f);
            this.fontMetrics = fontMetricsInt;
            if (fontMetricsInt != null) {
                int iAbs = Math.abs(fontMetricsInt.descent) + Math.abs(this.fontMetrics.ascent);
                this.size = iAbs;
                if (iAbs == 0) {
                    this.size = AndroidUtilities.dp(20.0f);
                }
            }
        }

        public void replaceFontMetrics(Paint.FontMetricsInt fontMetricsInt, int i) {
            this.fontMetrics = fontMetricsInt;
            this.size = i;
        }

        public void replaceFontMetrics(Paint.FontMetricsInt fontMetricsInt) {
            this.fontMetrics = fontMetricsInt;
            if (fontMetricsInt != null) {
                int iAbs = Math.abs(fontMetricsInt.descent) + Math.abs(this.fontMetrics.ascent);
                this.size = iAbs;
                if (iAbs == 0) {
                    this.size = AndroidUtilities.dp(20.0f);
                }
            }
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            if (fontMetricsInt == null) {
                fontMetricsInt = new Paint.FontMetricsInt();
            }
            Paint.FontMetricsInt fontMetricsInt2 = this.fontMetrics;
            if (fontMetricsInt2 == null) {
                int size = super.getSize(paint, charSequence, i, i2, fontMetricsInt);
                int iDp = AndroidUtilities.dp(8.0f);
                int iDp2 = AndroidUtilities.dp(10.0f);
                int i3 = (-iDp2) - iDp;
                fontMetricsInt.top = i3;
                int i4 = iDp2 - iDp;
                fontMetricsInt.bottom = i4;
                fontMetricsInt.ascent = i3;
                fontMetricsInt.leading = 0;
                fontMetricsInt.descent = i4;
                return size;
            }
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
            if (getDrawable() != null) {
                Drawable drawable = getDrawable();
                int i5 = this.size;
                drawable.setBounds(0, 0, i5, i5);
            }
            return this.size;
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            boolean z;
            this.lastDrawX = (this.size / 2.0f) + f;
            this.lastDrawY = i3 + ((i5 - i3) / 2.0f);
            boolean z2 = true;
            this.drawn = true;
            if (paint.getAlpha() == 255 || !Emoji.emojiDrawingUseAlpha) {
                z = false;
            } else {
                getDrawable().setAlpha(paint.getAlpha());
                z = true;
            }
            if (Emoji.emojiDrawingYOffset != 0.0f) {
                canvas.save();
                canvas.translate(0.0f, Emoji.emojiDrawingYOffset);
            } else {
                z2 = false;
            }
            super.draw(canvas, charSequence, i, i2, f, i3, i4, i5, paint);
            if (z2) {
                canvas.restore();
            }
            if (z) {
                getDrawable().setAlpha(255);
            }
        }

        @Override // android.text.style.ReplacementSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (getDrawable() instanceof EmojiDrawable) {
                ((EmojiDrawable) getDrawable()).placeholderColor = 285212671 & textPaint.getColor();
            }
            super.updateDrawState(textPaint);
        }
    }

    public static void addRecentEmoji(String str) {
        Integer num = emojiUseHistory.get(str);
        if (num == null) {
            num = 0;
        }
        if (num.intValue() == 0 && emojiUseHistory.size() >= 48) {
            emojiUseHistory.remove(recentEmoji.get(r1.size() - 1));
            recentEmoji.set(r1.size() - 1, str);
        }
        emojiUseHistory.put(str, Integer.valueOf(num.intValue() + 1));
    }

    public static void removeRecentEmoji(String str) {
        emojiUseHistory.remove(str);
        recentEmoji.remove(str);
        if (emojiUseHistory.isEmpty() || recentEmoji.isEmpty()) {
            addRecentEmoji(DEFAULT_RECENT[0]);
        }
    }

    public static void sortEmoji() {
        recentEmoji.clear();
        Iterator<Map.Entry<String, Integer>> it = emojiUseHistory.entrySet().iterator();
        while (it.hasNext()) {
            recentEmoji.add(it.next().getKey());
        }
        Collections.sort(recentEmoji, new Comparator() { // from class: org.rbmain.messenger.Emoji$$ExternalSyntheticLambda2
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Emoji.lambda$sortEmoji$2((String) obj, (String) obj2);
            }
        });
        while (recentEmoji.size() > 48) {
            recentEmoji.remove(r0.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$sortEmoji$2(String str, String str2) {
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
            if (globalEmojiSettings.contains("emojis")) {
                String string = globalEmojiSettings.getString("emojis", io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
                if (string != null && string.length() > 0) {
                    for (String str : string.split(",")) {
                        String[] strArrSplit = str.split("=");
                        long jLongValue = Utilities.parseLong(strArrSplit[0]).longValue();
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < 4; i++) {
                            sb.insert(0, (char) jLongValue);
                            jLongValue >>= 16;
                            if (jLongValue == 0) {
                                break;
                            }
                        }
                        if (sb.length() > 0) {
                            emojiUseHistory.put(sb.toString(), Utilities.parseInt(strArrSplit[1]));
                        }
                    }
                }
                globalEmojiSettings.edit().remove("emojis").commit();
                saveRecentEmoji();
            } else {
                String string2 = globalEmojiSettings.getString("emojis2", io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
                if (string2 != null && string2.length() > 0) {
                    for (String str2 : string2.split(",")) {
                        String[] strArrSplit2 = str2.split("=");
                        emojiUseHistory.put(strArrSplit2[0], Utilities.parseInt(strArrSplit2[1]));
                    }
                }
            }
            if (emojiUseHistory.isEmpty() && !globalEmojiSettings.getBoolean("filled_default", false)) {
                int i2 = 0;
                while (true) {
                    String[] strArr = DEFAULT_RECENT;
                    if (i2 >= strArr.length) {
                        break;
                    }
                    emojiUseHistory.put(strArr[i2], Integer.valueOf(strArr.length - i2));
                    i2++;
                }
                globalEmojiSettings.edit().putBoolean("filled_default", true).commit();
                saveRecentEmoji();
            }
            sortEmoji();
        } catch (Exception e) {
            FileLog.e(e);
        }
        try {
            String string3 = globalEmojiSettings.getString("color", io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
            if (string3 == null || string3.length() <= 0) {
                return;
            }
            for (String str3 : string3.split(",")) {
                String[] strArrSplit3 = str3.split("=");
                emojiColor.put(strArrSplit3[0], strArrSplit3[1]);
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
