package ir.nasim;

import android.gov.nist.core.Separators;
import android.graphics.Color;
import android.graphics.PointF;
import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: ir.nasim.xJ6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C23671xJ6 {
    public final String a;
    public final int b;
    public final Integer c;
    public final Integer d;
    public final float e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final int j;

    /* renamed from: ir.nasim.xJ6$a */
    static final class a {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;
        public final int j;
        public final int k;

        private a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.h = i8;
            this.i = i9;
            this.j = i10;
            this.k = i11;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0031  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static ir.nasim.C23671xJ6.a a(java.lang.String r17) {
            /*
                Method dump skipped, instructions count: 274
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23671xJ6.a.a(java.lang.String):ir.nasim.xJ6$a");
        }
    }

    /* renamed from: ir.nasim.xJ6$b */
    static final class b {
        private static final Pattern c = Pattern.compile("\\{([^}]*)\\}");
        private static final Pattern d = Pattern.compile(AbstractC9683aN7.A("\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
        private static final Pattern e = Pattern.compile(AbstractC9683aN7.A("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
        private static final Pattern f = Pattern.compile("\\\\an(\\d+)");
        public final int a;
        public final PointF b;

        private b(int i, PointF pointF) {
            this.a = i;
            this.b = pointF;
        }

        private static int a(String str) {
            Matcher matcher = f.matcher(str);
            if (matcher.find()) {
                return C23671xJ6.e((String) AbstractC20011rK.e(matcher.group(1)));
            }
            return -1;
        }

        public static b b(String str) {
            Matcher matcher = c.matcher(str);
            PointF pointF = null;
            int i = -1;
            while (matcher.find()) {
                String str2 = (String) AbstractC20011rK.e(matcher.group(1));
                try {
                    PointF pointFC = c(str2);
                    if (pointFC != null) {
                        pointF = pointFC;
                    }
                } catch (RuntimeException unused) {
                }
                try {
                    int iA = a(str2);
                    if (iA != -1) {
                        i = iA;
                    }
                } catch (RuntimeException unused2) {
                }
            }
            return new b(i, pointF);
        }

        private static PointF c(String str) {
            String strGroup;
            String strGroup2;
            Matcher matcher = d.matcher(str);
            Matcher matcher2 = e.matcher(str);
            boolean zFind = matcher.find();
            boolean zFind2 = matcher2.find();
            if (zFind) {
                if (zFind2) {
                    AbstractC18815pI3.f("SsaStyle.Overrides", "Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='" + str + Separators.QUOTE);
                }
                strGroup = matcher.group(1);
                strGroup2 = matcher.group(2);
            } else {
                if (!zFind2) {
                    return null;
                }
                strGroup = matcher2.group(1);
                strGroup2 = matcher2.group(2);
            }
            return new PointF(Float.parseFloat(((String) AbstractC20011rK.e(strGroup)).trim()), Float.parseFloat(((String) AbstractC20011rK.e(strGroup2)).trim()));
        }

        public static String d(String str) {
            return c.matcher(str).replaceAll("");
        }
    }

    private C23671xJ6(String str, int i, Integer num, Integer num2, float f, boolean z, boolean z2, boolean z3, boolean z4, int i2) {
        this.a = str;
        this.b = i;
        this.c = num;
        this.d = num2;
        this.e = f;
        this.f = z;
        this.g = z2;
        this.h = z3;
        this.i = z4;
        this.j = i2;
    }

    public static C23671xJ6 b(String str, a aVar) {
        AbstractC20011rK.a(str.startsWith("Style:"));
        String[] strArrSplit = TextUtils.split(str.substring(6), ",");
        int length = strArrSplit.length;
        int i = aVar.k;
        if (length != i) {
            AbstractC18815pI3.k("SsaStyle", AbstractC9683aN7.A("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", Integer.valueOf(i), Integer.valueOf(strArrSplit.length), str));
            return null;
        }
        try {
            String strTrim = strArrSplit[aVar.a].trim();
            int i2 = aVar.b;
            int iE = i2 != -1 ? e(strArrSplit[i2].trim()) : -1;
            int i3 = aVar.c;
            Integer numH = i3 != -1 ? h(strArrSplit[i3].trim()) : null;
            int i4 = aVar.d;
            Integer numH2 = i4 != -1 ? h(strArrSplit[i4].trim()) : null;
            int i5 = aVar.e;
            float fI = i5 != -1 ? i(strArrSplit[i5].trim()) : -3.4028235E38f;
            int i6 = aVar.f;
            boolean z = i6 != -1 && f(strArrSplit[i6].trim());
            int i7 = aVar.g;
            boolean z2 = i7 != -1 && f(strArrSplit[i7].trim());
            int i8 = aVar.h;
            boolean z3 = i8 != -1 && f(strArrSplit[i8].trim());
            int i9 = aVar.i;
            boolean z4 = i9 != -1 && f(strArrSplit[i9].trim());
            int i10 = aVar.j;
            return new C23671xJ6(strTrim, iE, numH, numH2, fI, z, z2, z3, z4, i10 != -1 ? g(strArrSplit[i10].trim()) : -1);
        } catch (RuntimeException e) {
            AbstractC18815pI3.l("SsaStyle", "Skipping malformed 'Style:' line: '" + str + Separators.QUOTE, e);
            return null;
        }
    }

    private static boolean c(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    private static boolean d(int i) {
        return i == 1 || i == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int e(String str) throws NumberFormatException {
        try {
            int i = Integer.parseInt(str.trim());
            if (c(i)) {
                return i;
            }
        } catch (NumberFormatException unused) {
        }
        AbstractC18815pI3.k("SsaStyle", "Ignoring unknown alignment: " + str);
        return -1;
    }

    private static boolean f(String str) throws NumberFormatException {
        try {
            int i = Integer.parseInt(str);
            return i == 1 || i == -1;
        } catch (NumberFormatException e) {
            AbstractC18815pI3.l("SsaStyle", "Failed to parse boolean value: '" + str + Separators.QUOTE, e);
            return false;
        }
    }

    private static int g(String str) throws NumberFormatException {
        try {
            int i = Integer.parseInt(str.trim());
            if (d(i)) {
                return i;
            }
        } catch (NumberFormatException unused) {
        }
        AbstractC18815pI3.k("SsaStyle", "Ignoring unknown BorderStyle: " + str);
        return -1;
    }

    public static Integer h(String str) {
        try {
            long j = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            AbstractC20011rK.a(j <= 4294967295L);
            return Integer.valueOf(Color.argb(AbstractC8236Vc3.d(((j >> 24) & 255) ^ 255), AbstractC8236Vc3.d(j & 255), AbstractC8236Vc3.d((j >> 8) & 255), AbstractC8236Vc3.d((j >> 16) & 255)));
        } catch (IllegalArgumentException e) {
            AbstractC18815pI3.l("SsaStyle", "Failed to parse color expression: '" + str + Separators.QUOTE, e);
            return null;
        }
    }

    private static float i(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            AbstractC18815pI3.l("SsaStyle", "Failed to parse font size: '" + str + Separators.QUOTE, e);
            return -3.4028235E38f;
        }
    }
}
