package com.google.android.exoplayer2.text.webvtt;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.webvtt.WebvttCue;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class WebvttCueParser {
    public static final Pattern CUE_HEADER_PATTERN = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
    private static final Pattern CUE_SETTING_PATTERN = Pattern.compile("(\\S+?):(\\S+)");
    private final StringBuilder textBuilder = new StringBuilder();

    public boolean parseCue(ParsableByteArray webvttData, WebvttCue.Builder builder, List<WebvttCssStyle> styles) {
        String line = webvttData.readLine();
        if (line == null) {
            return false;
        }
        Pattern pattern = CUE_HEADER_PATTERN;
        Matcher matcher = pattern.matcher(line);
        if (matcher.matches()) {
            return parseCue(null, matcher, webvttData, builder, this.textBuilder, styles);
        }
        String line2 = webvttData.readLine();
        if (line2 == null) {
            return false;
        }
        Matcher matcher2 = pattern.matcher(line2);
        if (matcher2.matches()) {
            return parseCue(line.trim(), matcher2, webvttData, builder, this.textBuilder, styles);
        }
        return false;
    }

    static void parseCueSettingsList(String cueSettingsList, WebvttCue.Builder builder) {
        Matcher matcher = CUE_SETTING_PATTERN.matcher(cueSettingsList);
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            String strGroup2 = matcher.group(2);
            try {
                if ("line".equals(strGroup)) {
                    parseLineAttribute(strGroup2, builder);
                } else if ("align".equals(strGroup)) {
                    builder.setTextAlignment(parseTextAlignment(strGroup2));
                } else if ("position".equals(strGroup)) {
                    parsePositionAttribute(strGroup2, builder);
                } else if ("size".equals(strGroup)) {
                    builder.setWidth(WebvttParserUtil.parsePercentage(strGroup2));
                } else {
                    Log.w("WebvttCueParser", "Unknown cue setting " + strGroup + ":" + strGroup2);
                }
            } catch (NumberFormatException unused) {
                Log.w("WebvttCueParser", "Skipping bad cue setting: " + matcher.group());
            }
        }
    }

    static void parseCueText(String id, String markup, WebvttCue.Builder builder, List<WebvttCssStyle> styles) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < markup.length()) {
            char cCharAt = markup.charAt(i);
            if (cCharAt == '&') {
                i++;
                int iIndexOf = markup.indexOf(59, i);
                int iIndexOf2 = markup.indexOf(32, i);
                if (iIndexOf == -1) {
                    iIndexOf = iIndexOf2;
                } else if (iIndexOf2 != -1) {
                    iIndexOf = Math.min(iIndexOf, iIndexOf2);
                }
                if (iIndexOf != -1) {
                    applyEntity(markup.substring(i, iIndexOf), spannableStringBuilder);
                    if (iIndexOf == iIndexOf2) {
                        spannableStringBuilder.append((CharSequence) " ");
                    }
                    i = iIndexOf + 1;
                } else {
                    spannableStringBuilder.append(cCharAt);
                }
            } else if (cCharAt == '<') {
                int iFindEndOfTag = i + 1;
                if (iFindEndOfTag < markup.length()) {
                    boolean z = markup.charAt(iFindEndOfTag) == '/';
                    iFindEndOfTag = findEndOfTag(markup, iFindEndOfTag);
                    int i2 = iFindEndOfTag - 2;
                    boolean z2 = markup.charAt(i2) == '/';
                    int i3 = i + (z ? 2 : 1);
                    if (!z2) {
                        i2 = iFindEndOfTag - 1;
                    }
                    String strSubstring = markup.substring(i3, i2);
                    if (!strSubstring.trim().isEmpty()) {
                        String tagName = getTagName(strSubstring);
                        if (isSupportedTag(tagName)) {
                            if (z) {
                                while (!arrayDeque.isEmpty()) {
                                    StartTag startTag = (StartTag) arrayDeque.pop();
                                    applySpansForTag(id, startTag, spannableStringBuilder, styles, arrayList);
                                    if (startTag.name.equals(tagName)) {
                                        break;
                                    }
                                }
                            } else if (!z2) {
                                arrayDeque.push(StartTag.buildStartTag(strSubstring, spannableStringBuilder.length()));
                            }
                        }
                    }
                }
                i = iFindEndOfTag;
            } else {
                spannableStringBuilder.append(cCharAt);
                i++;
            }
        }
        while (!arrayDeque.isEmpty()) {
            applySpansForTag(id, (StartTag) arrayDeque.pop(), spannableStringBuilder, styles, arrayList);
        }
        applySpansForTag(id, StartTag.buildWholeCueVirtualTag(), spannableStringBuilder, styles, arrayList);
        builder.setText(spannableStringBuilder);
    }

    private static boolean parseCue(String id, Matcher cueHeaderMatcher, ParsableByteArray webvttData, WebvttCue.Builder builder, StringBuilder textBuilder, List<WebvttCssStyle> styles) {
        try {
            builder.setStartTime(WebvttParserUtil.parseTimestampUs(cueHeaderMatcher.group(1))).setEndTime(WebvttParserUtil.parseTimestampUs(cueHeaderMatcher.group(2)));
            parseCueSettingsList(cueHeaderMatcher.group(3), builder);
            textBuilder.setLength(0);
            String line = webvttData.readLine();
            while (!TextUtils.isEmpty(line)) {
                if (textBuilder.length() > 0) {
                    textBuilder.append("\n");
                }
                textBuilder.append(line.trim());
                line = webvttData.readLine();
            }
            parseCueText(id, textBuilder.toString(), builder, styles);
            return true;
        } catch (NumberFormatException unused) {
            Log.w("WebvttCueParser", "Skipping cue with bad header: " + cueHeaderMatcher.group());
            return false;
        }
    }

    private static void parseLineAttribute(String s, WebvttCue.Builder builder) throws NumberFormatException {
        int iIndexOf = s.indexOf(44);
        if (iIndexOf != -1) {
            builder.setLineAnchor(parsePositionAnchor(s.substring(iIndexOf + 1)));
            s = s.substring(0, iIndexOf);
        }
        if (s.endsWith("%")) {
            builder.setLine(WebvttParserUtil.parsePercentage(s)).setLineType(0);
            return;
        }
        int i = Integer.parseInt(s);
        if (i < 0) {
            i--;
        }
        builder.setLine(i).setLineType(1);
    }

    private static void parsePositionAttribute(String s, WebvttCue.Builder builder) {
        int iIndexOf = s.indexOf(44);
        if (iIndexOf != -1) {
            builder.setPositionAnchor(parsePositionAnchor(s.substring(iIndexOf + 1)));
            s = s.substring(0, iIndexOf);
        }
        builder.setPosition(WebvttParserUtil.parsePercentage(s));
    }

    private static int parsePositionAnchor(String s) {
        s.hashCode();
        switch (s) {
            case "center":
            case "middle":
                return 1;
            case "end":
                return 2;
            case "start":
                return 0;
            default:
                Log.w("WebvttCueParser", "Invalid anchor value: " + s);
                return Integer.MIN_VALUE;
        }
    }

    private static int parseTextAlignment(String s) {
        s.hashCode();
        switch (s) {
            case "center":
            case "middle":
                return 2;
            case "end":
                return 3;
            case "left":
                return 4;
            case "right":
                return 5;
            case "start":
                return 1;
            default:
                Log.w("WebvttCueParser", "Invalid alignment value: " + s);
                return 2;
        }
    }

    private static int findEndOfTag(String markup, int startPos) {
        int iIndexOf = markup.indexOf(62, startPos);
        return iIndexOf == -1 ? markup.length() : iIndexOf + 1;
    }

    private static void applyEntity(String entity, SpannableStringBuilder spannedText) {
        entity.hashCode();
        switch (entity) {
            case "gt":
                spannedText.append('>');
                break;
            case "lt":
                spannedText.append('<');
                break;
            case "amp":
                spannedText.append('&');
                break;
            case "nbsp":
                spannedText.append(' ');
                break;
            default:
                Log.w("WebvttCueParser", "ignoring unsupported entity: '&" + entity + ";'");
                break;
        }
    }

    private static boolean isSupportedTag(String tagName) {
        tagName.hashCode();
        switch (tagName) {
            case "b":
            case "c":
            case "i":
            case "u":
            case "v":
            case "lang":
                return true;
            default:
                return false;
        }
    }

    private static void applySpansForTag(String cueId, StartTag startTag, SpannableStringBuilder text, List<WebvttCssStyle> styles, List<StyleMatch> scratchStyleMatches) {
        int i;
        int length;
        i = startTag.position;
        length = text.length();
        String str = startTag.name;
        str.hashCode();
        switch (str) {
            case "":
            case "c":
            case "v":
            case "lang":
                break;
            case "b":
                text.setSpan(new StyleSpan(1), i, length, 33);
                break;
            case "i":
                text.setSpan(new StyleSpan(2), i, length, 33);
                break;
            case "u":
                text.setSpan(new UnderlineSpan(), i, length, 33);
                break;
            default:
                return;
        }
        scratchStyleMatches.clear();
        getApplicableStyles(styles, cueId, startTag, scratchStyleMatches);
        int size = scratchStyleMatches.size();
        for (int i2 = 0; i2 < size; i2++) {
            applyStyleToText(text, scratchStyleMatches.get(i2).style, i, length);
        }
    }

    private static void applyStyleToText(SpannableStringBuilder spannedText, WebvttCssStyle style, int start, int end) {
        if (style == null) {
            return;
        }
        if (style.getStyle() != -1) {
            spannedText.setSpan(new StyleSpan(style.getStyle()), start, end, 33);
        }
        if (style.isLinethrough()) {
            spannedText.setSpan(new StrikethroughSpan(), start, end, 33);
        }
        if (style.isUnderline()) {
            spannedText.setSpan(new UnderlineSpan(), start, end, 33);
        }
        if (style.hasFontColor()) {
            spannedText.setSpan(new ForegroundColorSpan(style.getFontColor()), start, end, 33);
        }
        if (style.hasBackgroundColor()) {
            spannedText.setSpan(new BackgroundColorSpan(style.getBackgroundColor()), start, end, 33);
        }
        if (style.getFontFamily() != null) {
            spannedText.setSpan(new TypefaceSpan(style.getFontFamily()), start, end, 33);
        }
        Layout.Alignment textAlign = style.getTextAlign();
        if (textAlign != null) {
            spannedText.setSpan(new AlignmentSpan.Standard(textAlign), start, end, 33);
        }
        int fontSizeUnit = style.getFontSizeUnit();
        if (fontSizeUnit == 1) {
            spannedText.setSpan(new AbsoluteSizeSpan((int) style.getFontSize(), true), start, end, 33);
        } else if (fontSizeUnit == 2) {
            spannedText.setSpan(new RelativeSizeSpan(style.getFontSize()), start, end, 33);
        } else {
            if (fontSizeUnit != 3) {
                return;
            }
            spannedText.setSpan(new RelativeSizeSpan(style.getFontSize() / 100.0f), start, end, 33);
        }
    }

    private static String getTagName(String tagExpression) {
        String strTrim = tagExpression.trim();
        Assertions.checkArgument(!strTrim.isEmpty());
        return Util.splitAtFirst(strTrim, "[ \\.]")[0];
    }

    private static void getApplicableStyles(List<WebvttCssStyle> declaredStyles, String id, StartTag tag, List<StyleMatch> output) {
        int size = declaredStyles.size();
        for (int i = 0; i < size; i++) {
            WebvttCssStyle webvttCssStyle = declaredStyles.get(i);
            int specificityScore = webvttCssStyle.getSpecificityScore(id, tag.name, tag.classes, tag.voice);
            if (specificityScore > 0) {
                output.add(new StyleMatch(specificityScore, webvttCssStyle));
            }
        }
        Collections.sort(output);
    }

    private static final class StyleMatch implements Comparable<StyleMatch> {
        public final int score;
        public final WebvttCssStyle style;

        public StyleMatch(int score, WebvttCssStyle style) {
            this.score = score;
            this.style = style;
        }

        @Override // java.lang.Comparable
        public int compareTo(StyleMatch another) {
            return this.score - another.score;
        }
    }

    private static final class StartTag {
        private static final String[] NO_CLASSES = new String[0];
        public final String[] classes;
        public final String name;
        public final int position;
        public final String voice;

        private StartTag(String name, int position, String voice, String[] classes) {
            this.position = position;
            this.name = name;
            this.voice = voice;
            this.classes = classes;
        }

        public static StartTag buildStartTag(String fullTagExpression, int position) {
            String str;
            String[] strArr;
            String strTrim = fullTagExpression.trim();
            Assertions.checkArgument(!strTrim.isEmpty());
            int iIndexOf = strTrim.indexOf(" ");
            if (iIndexOf == -1) {
                str = "";
            } else {
                String strTrim2 = strTrim.substring(iIndexOf).trim();
                strTrim = strTrim.substring(0, iIndexOf);
                str = strTrim2;
            }
            String[] strArrSplit = Util.split(strTrim, "\\.");
            String str2 = strArrSplit[0];
            if (strArrSplit.length > 1) {
                strArr = (String[]) Util.nullSafeArrayCopyOfRange(strArrSplit, 1, strArrSplit.length);
            } else {
                strArr = NO_CLASSES;
            }
            return new StartTag(str2, position, str, strArr);
        }

        public static StartTag buildWholeCueVirtualTag() {
            return new StartTag("", 0, "", new String[0]);
        }
    }
}
