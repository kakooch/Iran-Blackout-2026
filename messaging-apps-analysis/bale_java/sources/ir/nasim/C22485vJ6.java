package ir.nasim;

import android.gov.nist.core.Separators;
import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C14451hw1;
import ir.nasim.C23671xJ6;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: ir.nasim.vJ6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C22485vJ6 extends WC6 {
    private static final Pattern t = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    private final boolean o;
    private final C23081wJ6 p;
    private Map q;
    private float r;
    private float s;

    public C22485vJ6(List list) {
        super("SsaDecoder");
        this.r = -3.4028235E38f;
        this.s = -3.4028235E38f;
        if (list == null || list.isEmpty()) {
            this.o = false;
            this.p = null;
            return;
        }
        this.o = true;
        String strB = AbstractC9683aN7.B((byte[]) list.get(0));
        AbstractC20011rK.a(strB.startsWith("Format:"));
        this.p = (C23081wJ6) AbstractC20011rK.e(C23081wJ6.a(strB));
        G(new EW4((byte[]) list.get(1)));
    }

    private static int B(long j, List list, List list2) {
        int i;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                i = 0;
                break;
            }
            if (((Long) list.get(size)).longValue() == j) {
                return size;
            }
            if (((Long) list.get(size)).longValue() < j) {
                i = size + 1;
                break;
            }
            size--;
        }
        list.add(i, Long.valueOf(j));
        list2.add(i, i == 0 ? new ArrayList() : new ArrayList((Collection) list2.get(i - 1)));
        return i;
    }

    private static float C(int i) {
        if (i == 0) {
            return 0.05f;
        }
        if (i != 1) {
            return i != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    private static C14451hw1 D(String str, C23671xJ6 c23671xJ6, C23671xJ6.b bVar, float f, float f2) {
        SpannableString spannableString = new SpannableString(str);
        C14451hw1.b bVarO = new C14451hw1.b().o(spannableString);
        if (c23671xJ6 != null) {
            if (c23671xJ6.c != null) {
                spannableString.setSpan(new ForegroundColorSpan(c23671xJ6.c.intValue()), 0, spannableString.length(), 33);
            }
            if (c23671xJ6.j == 3 && c23671xJ6.d != null) {
                spannableString.setSpan(new BackgroundColorSpan(c23671xJ6.d.intValue()), 0, spannableString.length(), 33);
            }
            float f3 = c23671xJ6.e;
            if (f3 != -3.4028235E38f && f2 != -3.4028235E38f) {
                bVarO.q(f3 / f2, 1);
            }
            boolean z = c23671xJ6.f;
            if (z && c23671xJ6.g) {
                spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
            } else if (z) {
                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
            } else if (c23671xJ6.g) {
                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
            }
            if (c23671xJ6.h) {
                spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
            }
            if (c23671xJ6.i) {
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            }
        }
        int i = bVar.a;
        if (i == -1) {
            i = c23671xJ6 != null ? c23671xJ6.b : -1;
        }
        bVarO.p(M(i)).l(L(i)).i(K(i));
        PointF pointF = bVar.b;
        if (pointF == null || f2 == -3.4028235E38f || f == -3.4028235E38f) {
            bVarO.k(C(bVarO.d()));
            bVarO.h(C(bVarO.c()), 0);
        } else {
            bVarO.k(pointF.x / f);
            bVarO.h(bVar.b.y / f2, 0);
        }
        return bVarO.a();
    }

    private void E(String str, C23081wJ6 c23081wJ6, List list, List list2) {
        int i;
        AbstractC20011rK.a(str.startsWith("Dialogue:"));
        String[] strArrSplit = str.substring(9).split(",", c23081wJ6.e);
        if (strArrSplit.length != c23081wJ6.e) {
            AbstractC18815pI3.k("SsaDecoder", "Skipping dialogue line with fewer columns than format: " + str);
            return;
        }
        long J = J(strArrSplit[c23081wJ6.a]);
        if (J == -9223372036854775807L) {
            AbstractC18815pI3.k("SsaDecoder", "Skipping invalid timing: " + str);
            return;
        }
        long J2 = J(strArrSplit[c23081wJ6.b]);
        if (J2 == -9223372036854775807L) {
            AbstractC18815pI3.k("SsaDecoder", "Skipping invalid timing: " + str);
            return;
        }
        Map map = this.q;
        C23671xJ6 c23671xJ6 = (map == null || (i = c23081wJ6.c) == -1) ? null : (C23671xJ6) map.get(strArrSplit[i].trim());
        String str2 = strArrSplit[c23081wJ6.d];
        C14451hw1 c14451hw1D = D(C23671xJ6.b.d(str2).replace("\\N", Separators.RETURN).replace("\\n", Separators.RETURN).replace("\\h", " "), c23671xJ6, C23671xJ6.b.b(str2), this.r, this.s);
        int iB = B(J2, list2, list);
        for (int iB2 = B(J, list2, list); iB2 < iB; iB2++) {
            ((List) list.get(iB2)).add(c14451hw1D);
        }
    }

    private void F(EW4 ew4, List list, List list2) {
        C23081wJ6 c23081wJ6A = this.o ? this.p : null;
        while (true) {
            String strQ = ew4.q();
            if (strQ == null) {
                return;
            }
            if (strQ.startsWith("Format:")) {
                c23081wJ6A = C23081wJ6.a(strQ);
            } else if (strQ.startsWith("Dialogue:")) {
                if (c23081wJ6A == null) {
                    AbstractC18815pI3.k("SsaDecoder", "Skipping dialogue line before complete format: " + strQ);
                } else {
                    E(strQ, c23081wJ6A, list, list2);
                }
            }
        }
    }

    private void G(EW4 ew4) {
        while (true) {
            String strQ = ew4.q();
            if (strQ == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(strQ)) {
                H(ew4);
            } else if ("[V4+ Styles]".equalsIgnoreCase(strQ)) {
                this.q = I(ew4);
            } else if ("[V4 Styles]".equalsIgnoreCase(strQ)) {
                AbstractC18815pI3.f("SsaDecoder", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(strQ)) {
                return;
            }
        }
    }

    private void H(EW4 ew4) {
        while (true) {
            String strQ = ew4.q();
            if (strQ == null) {
                return;
            }
            if (ew4.a() != 0 && ew4.h() == 91) {
                return;
            }
            String[] strArrSplit = strQ.split(":");
            if (strArrSplit.length == 2) {
                String strE = AbstractC14083hK.e(strArrSplit[0].trim());
                strE.hashCode();
                if (strE.equals("playresx")) {
                    this.r = Float.parseFloat(strArrSplit[1].trim());
                } else if (strE.equals("playresy")) {
                    try {
                        this.s = Float.parseFloat(strArrSplit[1].trim());
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
    }

    private static Map I(EW4 ew4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        C23671xJ6.a aVarA = null;
        while (true) {
            String strQ = ew4.q();
            if (strQ == null || (ew4.a() != 0 && ew4.h() == 91)) {
                break;
            }
            if (strQ.startsWith("Format:")) {
                aVarA = C23671xJ6.a.a(strQ);
            } else if (strQ.startsWith("Style:")) {
                if (aVarA == null) {
                    AbstractC18815pI3.k("SsaDecoder", "Skipping 'Style:' line before 'Format:' line: " + strQ);
                } else {
                    C23671xJ6 c23671xJ6B = C23671xJ6.b(strQ, aVarA);
                    if (c23671xJ6B != null) {
                        linkedHashMap.put(c23671xJ6B.a, c23671xJ6B);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    private static long J(String str) {
        Matcher matcher = t.matcher(str.trim());
        if (matcher.matches()) {
            return (Long.parseLong((String) AbstractC9683aN7.j(matcher.group(1))) * 3600000000L) + (Long.parseLong((String) AbstractC9683aN7.j(matcher.group(2))) * 60000000) + (Long.parseLong((String) AbstractC9683aN7.j(matcher.group(3))) * 1000000) + (Long.parseLong((String) AbstractC9683aN7.j(matcher.group(4))) * 10000);
        }
        return -9223372036854775807L;
    }

    private static int K(int i) {
        switch (i) {
            case -1:
                break;
            case 0:
            default:
                AbstractC18815pI3.k("SsaDecoder", "Unknown alignment: " + i);
                break;
            case 1:
            case 2:
            case 3:
                break;
            case 4:
            case 5:
            case 6:
                break;
            case 7:
            case 8:
            case 9:
                break;
        }
        return RecyclerView.UNDEFINED_DURATION;
    }

    private static int L(int i) {
        switch (i) {
            case -1:
                break;
            case 0:
            default:
                AbstractC18815pI3.k("SsaDecoder", "Unknown alignment: " + i);
                break;
            case 1:
            case 4:
            case 7:
                break;
            case 2:
            case 5:
            case 8:
                break;
            case 3:
            case 6:
            case 9:
                break;
        }
        return RecyclerView.UNDEFINED_DURATION;
    }

    private static Layout.Alignment M(int i) {
        switch (i) {
            case -1:
                return null;
            case 0:
            default:
                AbstractC18815pI3.k("SsaDecoder", "Unknown alignment: " + i);
                return null;
            case 1:
            case 4:
            case 7:
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
            case 5:
            case 8:
                return Layout.Alignment.ALIGN_CENTER;
            case 3:
            case 6:
            case 9:
                return Layout.Alignment.ALIGN_OPPOSITE;
        }
    }

    @Override // ir.nasim.WC6
    protected InterfaceC24081y07 A(byte[] bArr, int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        EW4 ew4 = new EW4(bArr, i);
        if (!this.o) {
            G(ew4);
        }
        F(ew4, arrayList, arrayList2);
        return new C24261yJ6(arrayList, arrayList2);
    }
}
