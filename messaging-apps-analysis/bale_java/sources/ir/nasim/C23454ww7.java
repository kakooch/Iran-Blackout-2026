package ir.nasim;

import android.gov.nist.core.Separators;
import android.text.Layout;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: ir.nasim.ww7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C23454ww7 extends WC6 {
    private static final Pattern p = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern q = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern r = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    static final Pattern s = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
    static final Pattern t = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final Pattern u = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");
    private static final Pattern v = Pattern.compile("^(\\d+) (\\d+)$");
    private static final b w = new b(30.0f, 1, 1);
    private static final a x = new a(32, 15);
    private final XmlPullParserFactory o;

    /* renamed from: ir.nasim.ww7$a */
    private static final class a {
        final int a;
        final int b;

        a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    /* renamed from: ir.nasim.ww7$b */
    private static final class b {
        final float a;
        final int b;
        final int c;

        b(float f, int i, int i2) {
            this.a = f;
            this.b = i;
            this.c = i2;
        }
    }

    /* renamed from: ir.nasim.ww7$c */
    private static final class c {
        final int a;
        final int b;

        c(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    public C23454ww7() throws XmlPullParserException {
        super("TtmlDecoder");
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.o = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    private static C3441Aw7 B(C3441Aw7 c3441Aw7) {
        return c3441Aw7 == null ? new C3441Aw7() : c3441Aw7;
    }

    private static boolean C(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("image") || str.equals("data") || str.equals("information");
    }

    private static Layout.Alignment D(String str) {
        String strE = AbstractC14083hK.e(str);
        strE.hashCode();
        switch (strE) {
            case "center":
                return Layout.Alignment.ALIGN_CENTER;
            case "end":
            case "right":
                return Layout.Alignment.ALIGN_OPPOSITE;
            case "left":
            case "start":
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                return null;
        }
    }

    private static a E(XmlPullParser xmlPullParser, a aVar) throws SubtitleDecoderException, NumberFormatException {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return aVar;
        }
        Matcher matcher = v.matcher(attributeValue);
        if (!matcher.matches()) {
            AbstractC18815pI3.k("TtmlDecoder", "Ignoring malformed cell resolution: " + attributeValue);
            return aVar;
        }
        try {
            int i = Integer.parseInt((String) AbstractC20011rK.e(matcher.group(1)));
            int i2 = Integer.parseInt((String) AbstractC20011rK.e(matcher.group(2)));
            if (i != 0 && i2 != 0) {
                return new a(i, i2);
            }
            throw new SubtitleDecoderException("Invalid cell resolution " + i + Separators.SP + i2);
        } catch (NumberFormatException unused) {
            AbstractC18815pI3.k("TtmlDecoder", "Ignoring malformed cell resolution: " + attributeValue);
            return aVar;
        }
    }

    private static void F(String str, C3441Aw7 c3441Aw7) throws SubtitleDecoderException {
        Matcher matcher;
        String str2;
        String[] strArrR0 = AbstractC9683aN7.R0(str, "\\s+");
        if (strArrR0.length == 1) {
            matcher = r.matcher(str);
        } else {
            if (strArrR0.length != 2) {
                throw new SubtitleDecoderException("Invalid number of entries for fontSize: " + strArrR0.length + Separators.DOT);
            }
            matcher = r.matcher(strArrR0[1]);
            AbstractC18815pI3.k("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if (!matcher.matches()) {
            throw new SubtitleDecoderException("Invalid expression for fontSize: '" + str + "'.");
        }
        str2 = (String) AbstractC20011rK.e(matcher.group(3));
        str2.hashCode();
        switch (str2) {
            case "%":
                c3441Aw7.z(3);
                break;
            case "em":
                c3441Aw7.z(2);
                break;
            case "px":
                c3441Aw7.z(1);
                break;
            default:
                throw new SubtitleDecoderException("Invalid unit for fontSize: '" + str2 + "'.");
        }
        c3441Aw7.y(Float.parseFloat((String) AbstractC20011rK.e(matcher.group(1))));
    }

    private static b G(XmlPullParser xmlPullParser) throws SubtitleDecoderException, NumberFormatException {
        float f;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int i = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            if (AbstractC9683aN7.R0(attributeValue2, Separators.SP).length != 2) {
                throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
            f = Integer.parseInt(r2[0]) / Integer.parseInt(r2[1]);
        } else {
            f = 1.0f;
        }
        b bVar = w;
        int i2 = bVar.b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i2 = Integer.parseInt(attributeValue3);
        }
        int i3 = bVar.c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i3 = Integer.parseInt(attributeValue4);
        }
        return new b(i * f, i2, i3);
    }

    private static Map H(XmlPullParser xmlPullParser, Map map, a aVar, c cVar, Map map2, Map map3) throws XmlPullParserException, IOException, NumberFormatException {
        do {
            xmlPullParser.next();
            if (AbstractC19002pc8.e(xmlPullParser, "style")) {
                String strA = AbstractC19002pc8.a(xmlPullParser, "style");
                C3441Aw7 c3441Aw7M = M(xmlPullParser, new C3441Aw7());
                if (strA != null) {
                    for (String str : N(strA)) {
                        c3441Aw7M.a((C3441Aw7) map.get(str));
                    }
                }
                String strG = c3441Aw7M.g();
                if (strG != null) {
                    map.put(strG, c3441Aw7M);
                }
            } else if (AbstractC19002pc8.e(xmlPullParser, "region")) {
                C24634yw7 c24634yw7K = K(xmlPullParser, aVar, cVar);
                if (c24634yw7K != null) {
                    map2.put(c24634yw7K.a, c24634yw7K);
                }
            } else if (AbstractC19002pc8.e(xmlPullParser, "metadata")) {
                I(xmlPullParser, map3);
            }
        } while (!AbstractC19002pc8.c(xmlPullParser, "head"));
        return map;
    }

    private static void I(XmlPullParser xmlPullParser, Map map) throws XmlPullParserException, IOException {
        String strA;
        do {
            xmlPullParser.next();
            if (AbstractC19002pc8.e(xmlPullParser, "image") && (strA = AbstractC19002pc8.a(xmlPullParser, "id")) != null) {
                map.put(strA, xmlPullParser.nextText());
            }
        } while (!AbstractC19002pc8.c(xmlPullParser, "metadata"));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static ir.nasim.C24044xw7 J(org.xmlpull.v1.XmlPullParser r20, ir.nasim.C24044xw7 r21, java.util.Map r22, ir.nasim.C23454ww7.b r23) throws com.google.android.exoplayer2.text.SubtitleDecoderException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23454ww7.J(org.xmlpull.v1.XmlPullParser, ir.nasim.xw7, java.util.Map, ir.nasim.ww7$b):ir.nasim.xw7");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static ir.nasim.C24634yw7 K(org.xmlpull.v1.XmlPullParser r17, ir.nasim.C23454ww7.a r18, ir.nasim.C23454ww7.c r19) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23454ww7.K(org.xmlpull.v1.XmlPullParser, ir.nasim.ww7$a, ir.nasim.ww7$c):ir.nasim.yw7");
    }

    private static float L(String str) {
        Matcher matcher = s.matcher(str);
        if (!matcher.matches()) {
            AbstractC18815pI3.k("TtmlDecoder", "Invalid value for shear: " + str);
            return Float.MAX_VALUE;
        }
        try {
            return Math.min(100.0f, Math.max(-100.0f, Float.parseFloat((String) AbstractC20011rK.e(matcher.group(1)))));
        } catch (NumberFormatException e) {
            AbstractC18815pI3.l("TtmlDecoder", "Failed to parse shear: " + str, e);
            return Float.MAX_VALUE;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static ir.nasim.C3441Aw7 M(org.xmlpull.v1.XmlPullParser r12, ir.nasim.C3441Aw7 r13) {
        /*
            Method dump skipped, instructions count: 928
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23454ww7.M(org.xmlpull.v1.XmlPullParser, ir.nasim.Aw7):ir.nasim.Aw7");
    }

    private static String[] N(String str) {
        String strTrim = str.trim();
        return strTrim.isEmpty() ? new String[0] : AbstractC9683aN7.R0(strTrim, "\\s+");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static long O(java.lang.String r13, ir.nasim.C23454ww7.b r14) throws com.google.android.exoplayer2.text.SubtitleDecoderException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23454ww7.O(java.lang.String, ir.nasim.ww7$b):long");
    }

    private static c P(XmlPullParser xmlPullParser) {
        String strA = AbstractC19002pc8.a(xmlPullParser, "extent");
        if (strA == null) {
            return null;
        }
        Matcher matcher = u.matcher(strA);
        if (!matcher.matches()) {
            AbstractC18815pI3.k("TtmlDecoder", "Ignoring non-pixel tts extent: " + strA);
            return null;
        }
        try {
            return new c(Integer.parseInt((String) AbstractC20011rK.e(matcher.group(1))), Integer.parseInt((String) AbstractC20011rK.e(matcher.group(2))));
        } catch (NumberFormatException unused) {
            AbstractC18815pI3.k("TtmlDecoder", "Ignoring malformed tts extent: " + strA);
            return null;
        }
    }

    @Override // ir.nasim.WC6
    protected InterfaceC24081y07 A(byte[] bArr, int i, boolean z) throws XmlPullParserException, SubtitleDecoderException, NumberFormatException, IOException {
        b bVar;
        try {
            XmlPullParser xmlPullParserNewPullParser = this.o.newPullParser();
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            map2.put("", new C24634yw7(""));
            c cVarP = null;
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            b bVarG = w;
            a aVarE = x;
            int i2 = 0;
            C3680Bw7 c3680Bw7 = null;
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.getEventType()) {
                C24044xw7 c24044xw7 = (C24044xw7) arrayDeque.peek();
                if (i2 == 0) {
                    String name = xmlPullParserNewPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            bVarG = G(xmlPullParserNewPullParser);
                            aVarE = E(xmlPullParserNewPullParser, x);
                            cVarP = P(xmlPullParserNewPullParser);
                        }
                        c cVar = cVarP;
                        b bVar2 = bVarG;
                        a aVar = aVarE;
                        if (C(name)) {
                            if ("head".equals(name)) {
                                bVar = bVar2;
                                H(xmlPullParserNewPullParser, map, aVar, cVar, map2, map3);
                            } else {
                                bVar = bVar2;
                                try {
                                    C24044xw7 c24044xw7J = J(xmlPullParserNewPullParser, c24044xw7, map2, bVar);
                                    arrayDeque.push(c24044xw7J);
                                    if (c24044xw7 != null) {
                                        c24044xw7.a(c24044xw7J);
                                    }
                                } catch (SubtitleDecoderException e) {
                                    AbstractC18815pI3.l("TtmlDecoder", "Suppressing parser error", e);
                                    i2++;
                                }
                            }
                            bVarG = bVar;
                        } else {
                            AbstractC18815pI3.f("TtmlDecoder", "Ignoring unsupported tag: " + xmlPullParserNewPullParser.getName());
                            i2++;
                            bVarG = bVar2;
                        }
                        cVarP = cVar;
                        aVarE = aVar;
                    } else if (eventType == 4) {
                        ((C24044xw7) AbstractC20011rK.e(c24044xw7)).a(C24044xw7.d(xmlPullParserNewPullParser.getText()));
                    } else if (eventType == 3) {
                        if (xmlPullParserNewPullParser.getName().equals("tt")) {
                            c3680Bw7 = new C3680Bw7((C24044xw7) AbstractC20011rK.e((C24044xw7) arrayDeque.peek()), map, map2, map3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i2++;
                } else if (eventType == 3) {
                    i2--;
                }
                xmlPullParserNewPullParser.next();
            }
            if (c3680Bw7 != null) {
                return c3680Bw7;
            }
            throw new SubtitleDecoderException("No TTML subtitles found");
        } catch (IOException e2) {
            throw new IllegalStateException("Unexpected error when reading input.", e2);
        } catch (XmlPullParserException e3) {
            throw new SubtitleDecoderException("Unable to decode source", e3);
        }
    }
}
