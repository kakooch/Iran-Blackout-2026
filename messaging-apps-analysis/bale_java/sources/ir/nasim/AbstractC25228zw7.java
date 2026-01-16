package ir.nasim;

import android.gov.nist.core.Separators;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import java.util.ArrayDeque;
import java.util.Map;

/* renamed from: ir.nasim.zw7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC25228zw7 {
    public static void a(Spannable spannable, int i, int i2, C3441Aw7 c3441Aw7, C24044xw7 c24044xw7, Map map, int i3) {
        C24044xw7 c24044xw7E;
        C3441Aw7 c3441Aw7F;
        int i4;
        if (c3441Aw7.l() != -1) {
            spannable.setSpan(new StyleSpan(c3441Aw7.l()), i, i2, 33);
        }
        if (c3441Aw7.s()) {
            spannable.setSpan(new StrikethroughSpan(), i, i2, 33);
        }
        if (c3441Aw7.t()) {
            spannable.setSpan(new UnderlineSpan(), i, i2, 33);
        }
        if (c3441Aw7.q()) {
            AbstractC14072hI6.a(spannable, new ForegroundColorSpan(c3441Aw7.c()), i, i2, 33);
        }
        if (c3441Aw7.p()) {
            AbstractC14072hI6.a(spannable, new BackgroundColorSpan(c3441Aw7.b()), i, i2, 33);
        }
        if (c3441Aw7.d() != null) {
            AbstractC14072hI6.a(spannable, new TypefaceSpan(c3441Aw7.d()), i, i2, 33);
        }
        if (c3441Aw7.o() != null) {
            C5936Ll7 c5936Ll7 = (C5936Ll7) AbstractC20011rK.e(c3441Aw7.o());
            int i5 = c5936Ll7.a;
            if (i5 == -1) {
                i5 = (i3 == 2 || i3 == 1) ? 3 : 1;
                i4 = 1;
            } else {
                i4 = c5936Ll7.b;
            }
            int i6 = c5936Ll7.c;
            if (i6 == -2) {
                i6 = 1;
            }
            AbstractC14072hI6.a(spannable, new C6169Ml7(i5, i4, i6), i, i2, 33);
        }
        int iJ = c3441Aw7.j();
        if (iJ == 2) {
            C24044xw7 c24044xw7D = d(c24044xw7, map);
            if (c24044xw7D != null && (c24044xw7E = e(c24044xw7D, map)) != null) {
                if (c24044xw7E.g() != 1 || c24044xw7E.f(0).b == null) {
                    AbstractC18815pI3.f("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                } else {
                    String str = (String) AbstractC9683aN7.j(c24044xw7E.f(0).b);
                    C3441Aw7 c3441Aw7F2 = f(c24044xw7E.f, c24044xw7E.l(), map);
                    int i7 = c3441Aw7F2 != null ? c3441Aw7F2.i() : -1;
                    if (i7 == -1 && (c3441Aw7F = f(c24044xw7D.f, c24044xw7D.l(), map)) != null) {
                        i7 = c3441Aw7F.i();
                    }
                    spannable.setSpan(new C13379g76(str, i7), i, i2, 33);
                }
            }
        } else if (iJ == 3 || iJ == 4) {
            spannable.setSpan(new MH1(), i, i2, 33);
        }
        if (c3441Aw7.n()) {
            AbstractC14072hI6.a(spannable, new QY2(), i, i2, 33);
        }
        int iF = c3441Aw7.f();
        if (iF == 1) {
            AbstractC14072hI6.a(spannable, new AbsoluteSizeSpan((int) c3441Aw7.e(), true), i, i2, 33);
        } else if (iF == 2) {
            AbstractC14072hI6.a(spannable, new RelativeSizeSpan(c3441Aw7.e()), i, i2, 33);
        } else {
            if (iF != 3) {
                return;
            }
            AbstractC14072hI6.a(spannable, new RelativeSizeSpan(c3441Aw7.e() / 100.0f), i, i2, 33);
        }
    }

    static String b(String str) {
        return str.replaceAll(Separators.NEWLINE, Separators.RETURN).replaceAll(" *\n *", Separators.RETURN).replaceAll(Separators.RETURN, Separators.SP).replaceAll("[ \t\\x0B\f\r]+", Separators.SP);
    }

    static void c(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length < 0 || spannableStringBuilder.charAt(length) == '\n') {
            return;
        }
        spannableStringBuilder.append('\n');
    }

    private static C24044xw7 d(C24044xw7 c24044xw7, Map map) {
        while (c24044xw7 != null) {
            C3441Aw7 c3441Aw7F = f(c24044xw7.f, c24044xw7.l(), map);
            if (c3441Aw7F != null && c3441Aw7F.j() == 1) {
                return c24044xw7;
            }
            c24044xw7 = c24044xw7.j;
        }
        return null;
    }

    private static C24044xw7 e(C24044xw7 c24044xw7, Map map) {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(c24044xw7);
        while (!arrayDeque.isEmpty()) {
            C24044xw7 c24044xw72 = (C24044xw7) arrayDeque.pop();
            C3441Aw7 c3441Aw7F = f(c24044xw72.f, c24044xw72.l(), map);
            if (c3441Aw7F != null && c3441Aw7F.j() == 3) {
                return c24044xw72;
            }
            for (int iG = c24044xw72.g() - 1; iG >= 0; iG--) {
                arrayDeque.push(c24044xw72.f(iG));
            }
        }
        return null;
    }

    public static C3441Aw7 f(C3441Aw7 c3441Aw7, String[] strArr, Map map) {
        int i = 0;
        if (c3441Aw7 == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return (C3441Aw7) map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                C3441Aw7 c3441Aw72 = new C3441Aw7();
                int length = strArr.length;
                while (i < length) {
                    c3441Aw72.a((C3441Aw7) map.get(strArr[i]));
                    i++;
                }
                return c3441Aw72;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                return c3441Aw7.a((C3441Aw7) map.get(strArr[0]));
            }
            if (strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i < length2) {
                    c3441Aw7.a((C3441Aw7) map.get(strArr[i]));
                    i++;
                }
            }
        }
        return c3441Aw7;
    }
}
