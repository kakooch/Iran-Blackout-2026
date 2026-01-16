package ir.resaneh1.iptv.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spannable;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.util.HashSet;
import java.util.Set;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.ImageReceiver;

/* loaded from: classes3.dex */
public class StoryTextAttributeObject {
    public BackGroundType backGroundType;
    public int color;
    public Layout layout;
    private Paint paint;
    public Spannable spannableString;
    public TextAlignmentEnum textAlignmentType;
    public TextColorTypeEnum textColorType;
    public TextFontEnum textFont;
    public int textSizeInDp;
    int[] colors1 = {-36797, -42909, -49023};
    int[] colors3 = {-36797, -278483, -141259};
    int[] colors4 = {-11827540, -12221781, -12552029};
    float[] positions1 = {0.0f, 0.5f, 1.0f};
    int[] colors2 = {-3790808, -689152, -10929, -11751600, -14575885, -6543440};
    float[] positions2 = {0.0f, 0.2f, 0.4f, 0.6f, 0.8f, 1.0f};
    float backGroundRadius = AndroidUtilities.dp(8.0f);
    private int paddingPx = AndroidUtilities.dp(8.0f);

    public enum BackGroundType {
        none,
        rounded,
        roundFrost,
        emphasis
    }

    public enum TextAlignmentEnum {
        center,
        right,
        left
    }

    public enum TextColorTypeEnum {
        rainbow,
        twoColorPink,
        twoColorOrange,
        simple,
        twoColorBlue,
        simpleAlpha
    }

    public enum TextFontEnum {
        classic,
        modern,
        neon,
        typewriter,
        strong
    }

    public int getShadowDx() {
        return 0;
    }

    public int getShadowDy() {
        return 0;
    }

    public StoryTextAttributeObject(BackGroundType backGroundType, TextFontEnum textFontEnum, TextAlignmentEnum textAlignmentEnum, int i, int i2, TextColorTypeEnum textColorTypeEnum) {
        this.textSizeInDp = i;
        this.backGroundType = backGroundType;
        this.textFont = textFontEnum;
        this.textAlignmentType = textAlignmentEnum;
        this.textColorType = textColorTypeEnum;
        this.color = i2;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public StoryTextAttributeObject m531clone() {
        return new StoryTextAttributeObject(this.backGroundType, this.textFont, this.textAlignmentType, this.textSizeInDp, this.color, this.textColorType);
    }

    public Typeface getTypeFace() {
        if (this.textFont == TextFontEnum.strong) {
            return AndroidUtilities.getTypeface("fonts/iranyekanwebbold.ttf");
        }
        return AndroidUtilities.getTypeface("fonts/storyfont.ttf");
    }

    public int getShadowColor() {
        if (this.textFont == TextFontEnum.neon) {
            return this.color;
        }
        return (this.backGroundType == BackGroundType.none && this.textColorType == TextColorTypeEnum.simple && this.color == -1) ? -16777216 : 0;
    }

    public int getShadowRadius() {
        if (this.textFont == TextFontEnum.neon) {
            return AndroidUtilities.dp(8.0f);
        }
        if (this.backGroundType == BackGroundType.none && this.textColorType == TextColorTypeEnum.simple && this.color == -1) {
            return AndroidUtilities.dp(4.0f);
        }
        return 0;
    }

    public int getTextColor() {
        TextFontEnum textFontEnum = this.textFont;
        TextFontEnum textFontEnum2 = TextFontEnum.neon;
        if (textFontEnum != textFontEnum2 && this.backGroundType == BackGroundType.none) {
            return this.color;
        }
        if (textFontEnum == textFontEnum2) {
            return -1;
        }
        if (textFontEnum == textFontEnum2 || this.backGroundType == BackGroundType.none) {
            return 0;
        }
        return (Color.red(this.color) + Color.green(this.color)) + Color.blue(this.color) > 510 ? -16777216 : -1;
    }

    public Drawable getHashtagBackground() throws Resources.NotFoundException {
        if (ApplicationLoader.applicationActivity.getResources() == null) {
            return null;
        }
        Drawable drawable = ApplicationLoader.applicationActivity.getResources().getDrawable(R.drawable.shape_story_text_background);
        BackGroundType backGroundType = this.backGroundType;
        if (backGroundType == BackGroundType.rounded) {
            drawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
            drawable.setAlpha(255);
            return drawable;
        }
        if (backGroundType == BackGroundType.roundFrost) {
            drawable.setColorFilter(ApplicationLoader.applicationActivity.getResources().getColor(R.color.grey_300), PorterDuff.Mode.SRC_ATOP);
            drawable.setAlpha(ImageReceiver.DEFAULT_CROSSFADE_DURATION);
        }
        return drawable;
    }

    public Drawable getBackground(Layout layout) {
        this.layout = layout;
        if (this.backGroundType != BackGroundType.none) {
            return createBackGroundDrawable(layout);
        }
        return null;
    }

    private Drawable createBackGroundDrawable(Layout layout) {
        if (layout == null) {
            return null;
        }
        Path pathFromLayout3 = getPathFromLayout3(layout);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(layout.getWidth(), layout.getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(bitmapCreateBitmap).drawPath(pathFromLayout3, getPaintByType());
        return new BitmapDrawable(bitmapCreateBitmap);
    }

    private Paint getPaintByType() {
        CornerPathEffect cornerPathEffect;
        if (this.paint == null) {
            this.paint = new Paint(1);
        }
        this.paint.setColor(this.color);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeWidth(AndroidUtilities.dp(0.0f));
        BackGroundType backGroundType = this.backGroundType;
        BackGroundType backGroundType2 = BackGroundType.roundFrost;
        if (backGroundType == backGroundType2) {
            this.paint.setAlpha(ImageReceiver.DEFAULT_CROSSFADE_DURATION);
        } else {
            this.paint.setAlpha(255);
        }
        BackGroundType backGroundType3 = this.backGroundType;
        if (backGroundType3 == BackGroundType.rounded || backGroundType3 == backGroundType2) {
            cornerPathEffect = new CornerPathEffect(this.backGroundRadius);
        } else {
            cornerPathEffect = new CornerPathEffect(0.0f);
        }
        this.paint.setPathEffect(cornerPathEffect);
        return this.paint;
    }

    private Path getPathFromLayout(Layout layout) {
        if (layout == null) {
            return null;
        }
        Path path = new Path();
        Float[] fArrCreateLefts = createLefts();
        Float[] fArrCreateRights = createRights();
        for (int i = 0; i < layout.getLineCount(); i++) {
            if (layout.getLineLeft(i) != layout.getLineRight(i)) {
                path.addRect(new RectF(fArrCreateLefts[i].floatValue(), layout.getLineTop(i), fArrCreateRights[i].floatValue(), layout.getLineBottom(i)), Path.Direction.CW);
            }
        }
        return path;
    }

    private Path getPathFromLayout2(Layout layout) {
        if (layout == null) {
            return null;
        }
        float strokeWidth = getPaintByType().getStrokeWidth();
        Path path = new Path();
        Float[] fArrCreateLefts = createLefts();
        Float[] fArrCreateRights = createRights();
        int i = 0;
        int i2 = 0;
        float fFloatValue = 0.0f;
        while (i < layout.getLineCount()) {
            while (i < layout.getLineCount() && layout.getLineLeft(i) == layout.getLineRight(i)) {
                i2 = i + 1;
                i = i2;
            }
            if (i < layout.getLineCount()) {
                if (i == i2) {
                    fFloatValue = (fArrCreateRights[i].floatValue() + fArrCreateLefts[i].floatValue()) / 2.0f;
                    path.moveTo(fFloatValue, layout.getLineTop(i) + strokeWidth);
                }
                path.lineTo(fArrCreateLefts[i].floatValue() + strokeWidth, layout.getLineTop(i) + strokeWidth);
                path.lineTo(fArrCreateLefts[i].floatValue() + strokeWidth, layout.getLineBottom(i) - strokeWidth);
                int i3 = i + 1;
                if (i3 == layout.getLineCount() || layout.getLineLeft(i3) == layout.getLineRight(i3)) {
                    for (int i4 = i; i4 >= i2; i4--) {
                        path.lineTo(fArrCreateRights[i4].floatValue() - strokeWidth, layout.getLineBottom(i4) - strokeWidth);
                        path.lineTo(fArrCreateRights[i4].floatValue() - strokeWidth, layout.getLineTop(i4) + strokeWidth);
                        if (i4 == i2) {
                            path.lineTo(fFloatValue, layout.getLineTop(i4) + strokeWidth);
                        }
                    }
                }
            }
            i++;
        }
        return path;
    }

    private Path getPathFromLayout3(Layout layout) {
        if (layout == null) {
            return null;
        }
        float strokeWidth = getPaintByType().getStrokeWidth();
        Path path = new Path();
        Float[] fArrCreateLefts = createLefts();
        Float[] fArrCreateRights = createRights();
        int i = 0;
        int i2 = 0;
        float fFloatValue = 0.0f;
        while (i < layout.getLineCount()) {
            while (i < layout.getLineCount() && (layout.getLineLeft(i) == layout.getLineRight(i) || layout.getLineWidth(i) == 0.0f)) {
                i2 = i + 1;
                i = i2;
            }
            if (i < layout.getLineCount()) {
                if (i == i2) {
                    fFloatValue = (fArrCreateRights[i].floatValue() + fArrCreateLefts[i].floatValue()) / 2.0f;
                    path.moveTo(fFloatValue, ((float) layout.getLineTop(i)) < strokeWidth ? layout.getLineTop(i) + strokeWidth : layout.getLineTop(i));
                }
                path.lineTo((fArrCreateLefts[i].floatValue() + strokeWidth) - ((float) this.paddingPx) > 0.0f ? (fArrCreateLefts[i].floatValue() + strokeWidth) - this.paddingPx : strokeWidth, ((float) layout.getLineTop(i)) < strokeWidth ? layout.getLineTop(i) + strokeWidth : layout.getLineTop(i));
                path.lineTo((fArrCreateLefts[i].floatValue() + strokeWidth) - ((float) this.paddingPx) > 0.0f ? (fArrCreateLefts[i].floatValue() + strokeWidth) - this.paddingPx : strokeWidth, ((float) (layout.getHeight() - layout.getLineBottom(i))) < strokeWidth ? layout.getLineBottom(i) - strokeWidth : layout.getLineBottom(i));
                int i3 = i + 1;
                if (i3 == layout.getLineCount() || layout.getLineLeft(i3) == layout.getLineRight(i3) || layout.getLineWidth(i3) == 0.0f) {
                    for (int i4 = i; i4 >= i2; i4--) {
                        path.lineTo((fArrCreateRights[i4].floatValue() - strokeWidth) + ((float) this.paddingPx) < ((float) layout.getWidth()) ? (fArrCreateRights[i4].floatValue() - strokeWidth) + this.paddingPx : layout.getWidth() - strokeWidth, ((float) (layout.getHeight() - layout.getLineBottom(i4))) < strokeWidth ? layout.getLineBottom(i4) - strokeWidth : layout.getLineBottom(i4));
                        path.lineTo((fArrCreateRights[i4].floatValue() - strokeWidth) + ((float) this.paddingPx) < ((float) layout.getWidth()) ? (fArrCreateRights[i4].floatValue() - strokeWidth) + this.paddingPx : layout.getWidth() - strokeWidth, ((float) layout.getLineTop(i4)) < strokeWidth ? layout.getLineTop(i4) + strokeWidth : layout.getLineTop(i4));
                        if (i4 == i2) {
                            path.lineTo(fFloatValue, ((float) layout.getLineTop(i4)) < strokeWidth ? layout.getLineTop(i4) + strokeWidth : layout.getLineTop(i4));
                        }
                    }
                }
            }
            i++;
        }
        return path;
    }

    public static int getGravity(StoryTextAttributeObject storyTextAttributeObject) {
        TextAlignmentEnum textAlignmentEnum = storyTextAttributeObject.textAlignmentType;
        if (textAlignmentEnum == TextAlignmentEnum.right) {
            return 21;
        }
        return textAlignmentEnum == TextAlignmentEnum.left ? 19 : 17;
    }

    public static int getBackgroundIconIdByType(StoryTextAttributeObject storyTextAttributeObject) {
        BackGroundType backGroundType = storyTextAttributeObject.backGroundType;
        if (backGroundType == BackGroundType.none) {
            TextFontEnum textFontEnum = storyTextAttributeObject.textFont;
            if (textFontEnum == TextFontEnum.classic) {
                return R.drawable.story_text_bg_off;
            }
            if (textFontEnum == TextFontEnum.typewriter || textFontEnum == TextFontEnum.strong) {
                return R.drawable.story_text_emphasis_outline;
            }
        }
        return backGroundType == BackGroundType.rounded ? R.drawable.story_text_bg_on : backGroundType == BackGroundType.roundFrost ? R.drawable.story_text_bg_frost : backGroundType == BackGroundType.emphasis ? R.drawable.story_text_emphasis_fill : R.drawable.transparent;
    }

    public static TextFontEnum getNextTextFont(StoryTextAttributeObject storyTextAttributeObject) {
        TextFontEnum textFontEnum = storyTextAttributeObject.textFont;
        TextFontEnum textFontEnum2 = TextFontEnum.classic;
        if (textFontEnum == textFontEnum2) {
            return TextFontEnum.modern;
        }
        if (textFontEnum == TextFontEnum.modern) {
            return TextFontEnum.neon;
        }
        if (textFontEnum == TextFontEnum.neon) {
            return TextFontEnum.typewriter;
        }
        if (textFontEnum == TextFontEnum.typewriter) {
            return TextFontEnum.strong;
        }
        TextFontEnum textFontEnum3 = TextFontEnum.strong;
        return textFontEnum2;
    }

    public static TextColorTypeEnum getNextHashtagTextColorType(StoryTextAttributeObject storyTextAttributeObject) {
        TextColorTypeEnum textColorTypeEnum = storyTextAttributeObject.textColorType;
        TextColorTypeEnum textColorTypeEnum2 = TextColorTypeEnum.simple;
        if (textColorTypeEnum == textColorTypeEnum2) {
            return TextColorTypeEnum.twoColorPink;
        }
        TextColorTypeEnum textColorTypeEnum3 = TextColorTypeEnum.twoColorPink;
        if (textColorTypeEnum == textColorTypeEnum3) {
            return TextColorTypeEnum.rainbow;
        }
        return textColorTypeEnum == TextColorTypeEnum.rainbow ? textColorTypeEnum2 : textColorTypeEnum3;
    }

    public static TextColorTypeEnum getNextMentionTextColorType(StoryTextAttributeObject storyTextAttributeObject) {
        TextColorTypeEnum textColorTypeEnum = storyTextAttributeObject.textColorType;
        TextColorTypeEnum textColorTypeEnum2 = TextColorTypeEnum.simple;
        if (textColorTypeEnum == textColorTypeEnum2) {
            return TextColorTypeEnum.twoColorOrange;
        }
        if (textColorTypeEnum == TextColorTypeEnum.twoColorOrange) {
            return TextColorTypeEnum.rainbow;
        }
        return textColorTypeEnum == TextColorTypeEnum.rainbow ? textColorTypeEnum2 : TextColorTypeEnum.twoColorPink;
    }

    public static TextColorTypeEnum getNextLinkTextColorType(StoryTextAttributeObject storyTextAttributeObject) {
        TextColorTypeEnum textColorTypeEnum = storyTextAttributeObject.textColorType;
        TextColorTypeEnum textColorTypeEnum2 = TextColorTypeEnum.simple;
        if (textColorTypeEnum == textColorTypeEnum2) {
            return TextColorTypeEnum.twoColorBlue;
        }
        TextColorTypeEnum textColorTypeEnum3 = TextColorTypeEnum.twoColorBlue;
        if (textColorTypeEnum == textColorTypeEnum3) {
            return TextColorTypeEnum.rainbow;
        }
        if (textColorTypeEnum == TextColorTypeEnum.rainbow) {
            return TextColorTypeEnum.simpleAlpha;
        }
        return textColorTypeEnum == TextColorTypeEnum.simpleAlpha ? textColorTypeEnum2 : textColorTypeEnum3;
    }

    public static BackGroundType getHashtagOrMentionBackGroundByColorType(StoryTextAttributeObject storyTextAttributeObject) {
        TextColorTypeEnum textColorTypeEnum = storyTextAttributeObject.textColorType;
        if (textColorTypeEnum == TextColorTypeEnum.simple) {
            return BackGroundType.roundFrost;
        }
        if (textColorTypeEnum == TextColorTypeEnum.twoColorPink) {
            return BackGroundType.rounded;
        }
        if (textColorTypeEnum == TextColorTypeEnum.rainbow) {
            return BackGroundType.rounded;
        }
        return BackGroundType.rounded;
    }

    public static BackGroundType getLinkBackGroundByColorType(StoryTextAttributeObject storyTextAttributeObject) {
        if (storyTextAttributeObject.textColorType == TextColorTypeEnum.simpleAlpha) {
            return BackGroundType.roundFrost;
        }
        return BackGroundType.rounded;
    }

    public static BackGroundType getNextBackGround(StoryTextAttributeObject storyTextAttributeObject) {
        TextFontEnum textFontEnum = storyTextAttributeObject.textFont;
        if (textFontEnum == TextFontEnum.classic) {
            BackGroundType backGroundType = storyTextAttributeObject.backGroundType;
            BackGroundType backGroundType2 = BackGroundType.none;
            if (backGroundType == backGroundType2) {
                return BackGroundType.rounded;
            }
            if (backGroundType == BackGroundType.rounded) {
                return BackGroundType.roundFrost;
            }
            if (backGroundType == BackGroundType.roundFrost) {
                return backGroundType2;
            }
        }
        if (textFontEnum == TextFontEnum.typewriter || textFontEnum == TextFontEnum.strong) {
            BackGroundType backGroundType3 = storyTextAttributeObject.backGroundType;
            BackGroundType backGroundType4 = BackGroundType.none;
            if (backGroundType3 == backGroundType4) {
                return BackGroundType.emphasis;
            }
            if (backGroundType3 == BackGroundType.emphasis) {
                return backGroundType4;
            }
        }
        return BackGroundType.none;
    }

    public static TextAlignmentEnum getNextAlignment(StoryTextAttributeObject storyTextAttributeObject) {
        TextFontEnum textFontEnum = storyTextAttributeObject.textFont;
        if (textFontEnum == TextFontEnum.classic || textFontEnum == TextFontEnum.typewriter) {
            TextAlignmentEnum textAlignmentEnum = storyTextAttributeObject.textAlignmentType;
            TextAlignmentEnum textAlignmentEnum2 = TextAlignmentEnum.center;
            if (textAlignmentEnum == textAlignmentEnum2) {
                return TextAlignmentEnum.right;
            }
            if (textAlignmentEnum == TextAlignmentEnum.right) {
                return TextAlignmentEnum.left;
            }
            if (textAlignmentEnum == TextAlignmentEnum.left) {
                return textAlignmentEnum2;
            }
        }
        return TextAlignmentEnum.center;
    }

    public static String getFontStringByType(StoryTextAttributeObject storyTextAttributeObject) {
        try {
            return storyTextAttributeObject.textFont + BuildConfig.FLAVOR;
        } catch (Exception unused) {
            return BuildConfig.FLAVOR;
        }
    }

    public static int getAlignmentIconIdByType(StoryTextAttributeObject storyTextAttributeObject) {
        TextAlignmentEnum textAlignmentEnum = storyTextAttributeObject.textAlignmentType;
        return textAlignmentEnum == TextAlignmentEnum.center ? R.drawable.story_text_align_center : textAlignmentEnum == TextAlignmentEnum.right ? R.drawable.story_text_align_right : textAlignmentEnum == TextAlignmentEnum.left ? R.drawable.story_text_align_left : R.drawable.transparent;
    }

    private Float[] createLefts() {
        Layout layout = this.layout;
        if (layout == null) {
            return null;
        }
        int lineCount = layout.getLineCount();
        Float[] fArr = new Float[lineCount];
        for (int i = 0; i < lineCount; i++) {
            fArr[i] = Float.valueOf(this.layout.getLineLeft(i));
        }
        HashSet hashSet = new HashSet();
        int i2 = 0;
        while (hashSet.size() < lineCount) {
            if (i2 == lineCount) {
                i2 = 0;
            }
            int iFindSmallestIndex = findSmallestIndex(fArr, hashSet);
            hashSet.add(Integer.valueOf(iFindSmallestIndex));
            float fFloatValue = fArr[iFindSmallestIndex].floatValue();
            if (iFindSmallestIndex > 0) {
                int i3 = iFindSmallestIndex - 1;
                float fFloatValue2 = fArr[i3].floatValue();
                float f = fFloatValue - fFloatValue2;
                if (f > 0.0f && f < this.backGroundRadius * 2.0f) {
                    fArr[iFindSmallestIndex] = Float.valueOf(fFloatValue2);
                    removeFromSet(i3, hashSet);
                    removeFromSet(iFindSmallestIndex + 1, hashSet);
                    removeFromSet(iFindSmallestIndex, hashSet);
                }
            }
            float fFloatValue3 = fArr[iFindSmallestIndex].floatValue();
            int i4 = iFindSmallestIndex + 1;
            if (i4 < lineCount) {
                float fFloatValue4 = fArr[i4].floatValue();
                float f2 = fFloatValue3 - fFloatValue4;
                if (f2 > 0.0f && f2 < this.backGroundRadius * 2.0f) {
                    fArr[iFindSmallestIndex] = Float.valueOf(fFloatValue4);
                    removeFromSet(iFindSmallestIndex - 1, hashSet);
                    removeFromSet(i4, hashSet);
                    removeFromSet(iFindSmallestIndex, hashSet);
                }
            }
            i2++;
        }
        return fArr;
    }

    private void removeFromSet(int i, Set<Integer> set) {
        if (set == null) {
            return;
        }
        for (Integer num : set) {
            if (num.intValue() == i) {
                try {
                    set.remove(num);
                    return;
                } catch (Exception unused) {
                }
            }
        }
    }

    private Float[] createRights() {
        Layout layout = this.layout;
        if (layout == null) {
            return null;
        }
        int lineCount = layout.getLineCount();
        Float[] fArr = new Float[lineCount];
        for (int i = 0; i < lineCount; i++) {
            fArr[i] = Float.valueOf(this.layout.getLineRight(i));
        }
        HashSet hashSet = new HashSet();
        int i2 = 0;
        while (hashSet.size() < lineCount) {
            if (i2 == lineCount) {
                i2 = 0;
            }
            int iFindMaxIndex = findMaxIndex(fArr, hashSet);
            hashSet.add(Integer.valueOf(iFindMaxIndex));
            float fFloatValue = fArr[iFindMaxIndex].floatValue();
            if (iFindMaxIndex > 0) {
                int i3 = iFindMaxIndex - 1;
                float fFloatValue2 = fArr[i3].floatValue();
                float f = fFloatValue2 - fFloatValue;
                if (f > 0.0f && f < this.backGroundRadius * 2.0f) {
                    fArr[iFindMaxIndex] = Float.valueOf(fFloatValue2);
                    removeFromSet(i3, hashSet);
                    removeFromSet(iFindMaxIndex + 1, hashSet);
                    removeFromSet(iFindMaxIndex, hashSet);
                }
            }
            float fFloatValue3 = fArr[iFindMaxIndex].floatValue();
            int i4 = iFindMaxIndex + 1;
            if (i4 < lineCount) {
                float fFloatValue4 = fArr[i4].floatValue();
                float f2 = fFloatValue4 - fFloatValue3;
                if (f2 > 0.0f && f2 < this.backGroundRadius * 2.0f) {
                    fArr[iFindMaxIndex] = Float.valueOf(fFloatValue4);
                    removeFromSet(iFindMaxIndex - 1, hashSet);
                    removeFromSet(i4, hashSet);
                    removeFromSet(iFindMaxIndex, hashSet);
                }
            }
            i2++;
        }
        return fArr;
    }

    private int findSmallestIndex(Float[] fArr, Set<Integer> set) {
        int i = 0;
        float fFloatValue = fArr[0].floatValue();
        while (i < fArr.length - 1 && set.contains(Integer.valueOf(i))) {
            i++;
            fFloatValue = fArr[i].floatValue();
        }
        for (int i2 = i + 1; i2 < fArr.length; i2++) {
            if (fArr[i2].floatValue() < fFloatValue && !set.contains(Integer.valueOf(i2))) {
                fFloatValue = fArr[i2].floatValue();
                i = i2;
            }
        }
        return i;
    }

    private int findMaxIndex(Float[] fArr, Set<Integer> set) {
        int i = 0;
        float fFloatValue = fArr[0].floatValue();
        while (i < fArr.length - 1 && set.contains(Integer.valueOf(i))) {
            i++;
            fFloatValue = fArr[i].floatValue();
        }
        for (int i2 = i + 1; i2 < fArr.length; i2++) {
            if (fArr[i2].floatValue() > fFloatValue && !set.contains(Integer.valueOf(i2))) {
                fFloatValue = fArr[i2].floatValue();
                i = i2;
            }
        }
        return i;
    }

    public Shader getTextPaintShader(TextColorTypeEnum textColorTypeEnum, float f, float f2, float f3, float f4) {
        if (textColorTypeEnum != TextColorTypeEnum.simple && textColorTypeEnum != TextColorTypeEnum.simpleAlpha) {
            if (textColorTypeEnum == TextColorTypeEnum.twoColorPink) {
                return new LinearGradient(f, f2, f3, f4, this.colors1, this.positions1, Shader.TileMode.CLAMP);
            }
            if (textColorTypeEnum == TextColorTypeEnum.twoColorOrange) {
                return new LinearGradient(f, f2, f3, f4, this.colors3, this.positions1, Shader.TileMode.CLAMP);
            }
            if (textColorTypeEnum == TextColorTypeEnum.twoColorBlue) {
                return new LinearGradient(f, f2, f3, f4, this.colors4, this.positions1, Shader.TileMode.CLAMP);
            }
            if (textColorTypeEnum == TextColorTypeEnum.rainbow) {
                return new LinearGradient(f, f2, f3, f4, this.colors2, this.positions2, Shader.TileMode.CLAMP);
            }
        }
        return null;
    }
}
