package ir.nasim;

import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.R62;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.C21457d;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.ui.Components.AnimatedEmojiSpan;
import ir.nasim.tgwidgets.editor.ui.Components.URLSpanNoUnderlineBold;
import java.io.File;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: ir.nasim.c74, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C10743c74 {
    public static Pattern Z;
    public static Pattern a0;
    public static Pattern b0;
    public AbstractC12724f57 A;
    public ArrayList B;
    public ArrayList C;
    public ir.nasim.tgwidgets.editor.messenger.H D;
    public int E;
    public boolean F;
    public boolean G;
    public StringBuilder H;
    public boolean I;
    public ArrayList J;
    public CharSequence K;
    public ArrayList L;
    public BitmapDrawable M;
    public int N;
    private boolean O;
    public int P;
    public int Q;
    private int R;
    private boolean S;
    public Object T;
    public Object U;
    private boolean V;
    public boolean W;
    private boolean X;
    public Boolean Y;
    public long a;
    public long b;
    public boolean c;
    public Boolean d;
    public L57 e;
    public AbstractC18106o57 f;
    public Long g;
    public String h;
    public CharSequence i;
    public CharSequence j;
    public CharSequence k;
    public C10743c74 l;
    public int m;
    public boolean n;
    private int o;
    public long p;
    public int q;
    public String r;
    public float s;
    public float t;
    public int u;
    public float v;
    public int w;
    public int x;
    public double y;
    public AbstractC12724f57 z;

    public C10743c74(int i, L57 l57, String str, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4) {
        this.m = AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
        this.t = -1.0f;
        this.V = false;
        this.W = false;
        this.N = i;
        this.i = str;
        this.e = l57;
        this.c = z3;
    }

    private static void A1(ArrayList arrayList, List list) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            AbstractC11500d67 abstractC11500d67 = (AbstractC11500d67) arrayList.get(i);
            if (abstractC11500d67 != null) {
                int size2 = list.size();
                int i2 = 0;
                while (true) {
                    if (i2 < size2) {
                        AbstractC11500d67 abstractC11500d672 = (AbstractC11500d67) list.get(i2);
                        if (!(abstractC11500d672 instanceof C7788Te7) && !(abstractC11500d672 instanceof C6600Oe7) && abstractC11500d672 != null && abstractC11500d672.b.equals(abstractC11500d67.b)) {
                            abstractC11500d67.c = abstractC11500d672.c;
                            break;
                        }
                        i2++;
                    }
                }
            }
        }
    }

    public static boolean B0(L57 l57) {
        return W(l57) instanceof C20792sc7;
    }

    private AbstractC15742k57 D(AbstractMap abstractMap, C21892uJ3 c21892uJ3, long j) {
        AbstractC15742k57 abstractC15742k57 = abstractMap != null ? (AbstractC15742k57) abstractMap.get(Long.valueOf(j)) : c21892uJ3 != null ? (AbstractC15742k57) c21892uJ3.f(j) : null;
        return abstractC15742k57 == null ? ir.nasim.tgwidgets.editor.messenger.C.n(this.N).i(Long.valueOf(j)) : abstractC15742k57;
    }

    public static boolean D0(L57 l57) {
        return E0(l57, true);
    }

    public static boolean E0(L57 l57, boolean z) {
        return l57 == null || W(l57) == null || (W(l57) instanceof C19001pc7) || (z && (W(l57) instanceof C5153Ic7));
    }

    public static long G(L57 l57) {
        Z57 z57;
        if (l57.Q == 0 && (z57 = l57.d) != null) {
            long j = z57.c;
            if (j != 0) {
                l57.Q = -j;
            } else {
                long j2 = z57.d;
                if (j2 != 0) {
                    l57.Q = -j2;
                } else if (l57.c == null || N0(l57)) {
                    l57.Q = l57.d.b;
                } else {
                    l57.Q = l57.c.b;
                }
            }
        }
        return l57.Q;
    }

    public static boolean H0(AbstractC18106o57 abstractC18106o57) {
        if (abstractC18106o57 != null) {
            for (int i = 0; i < abstractC18106o57.p.size(); i++) {
                if (((AbstractC18697p57) abstractC18106o57.p.get(i)) instanceof C77) {
                    return !r2.o;
                }
            }
            if (!TextUtils.isEmpty(abstractC18106o57.i)) {
                String lowerCase = abstractC18106o57.i.toLowerCase();
                if (lowerCase.equals("audio/flac") || lowerCase.equals("audio/ogg") || lowerCase.equals("audio/opus") || lowerCase.equals("audio/x-opus+ogg") || (lowerCase.equals("application/octet-stream") && C4278El2.C(abstractC18106o57).endsWith(".opus"))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean I0(L57 l57) {
        return W(l57) instanceof C5153Ic7 ? H0(W(l57).B.r) : W(l57) != null && H0(W(l57).s);
    }

    public static AbstractC18106o57 J(L57 l57) {
        if (W(l57) instanceof C5153Ic7) {
            return W(l57).B.r;
        }
        if (W(l57) instanceof C19592qc7) {
            return W(l57).v.i;
        }
        if (W(l57) != null) {
            return W(l57).s;
        }
        return null;
    }

    public static AbstractC22719vi7 K(AbstractC18106o57 abstractC18106o57) {
        if (abstractC18106o57 == null || abstractC18106o57.l.isEmpty()) {
            return null;
        }
        return (AbstractC22719vi7) abstractC18106o57.l.get(0);
    }

    public static boolean K0(AbstractC18106o57 abstractC18106o57) {
        if (abstractC18106o57 != null && "video/mp4".equals(abstractC18106o57.i)) {
            boolean z = false;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < abstractC18106o57.p.size(); i3++) {
                AbstractC18697p57 abstractC18697p57 = (AbstractC18697p57) abstractC18106o57.p.get(i3);
                if (abstractC18697p57 instanceof B77) {
                    z = true;
                } else if (abstractC18697p57 instanceof N77) {
                    i = abstractC18697p57.j;
                    i2 = abstractC18697p57.k;
                }
            }
            if (z && i <= 1280 && i2 <= 1280) {
                return true;
            }
        }
        return false;
    }

    private AbstractC18106o57 L(AbstractC25089zi7 abstractC25089zi7, long j) {
        if (abstractC25089zi7 != null && abstractC25089zi7.s != null) {
            AbstractC18106o57 abstractC18106o57 = abstractC25089zi7.r;
            if (abstractC18106o57 != null && abstractC18106o57.c == j) {
                return abstractC18106o57;
            }
            for (int i = 0; i < abstractC25089zi7.s.h.size(); i++) {
                AbstractC18106o57 abstractC18106o572 = (AbstractC18106o57) abstractC25089zi7.s.h.get(i);
                if (abstractC18106o572.c == j) {
                    return abstractC18106o572;
                }
            }
        }
        return null;
    }

    public static boolean L0(C12154e78 c12154e78) {
        if (c12154e78 != null && "video/mp4".equals(c12154e78.f)) {
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < c12154e78.d.size(); i3++) {
                AbstractC18697p57 abstractC18697p57 = (AbstractC18697p57) c12154e78.d.get(i3);
                if (!(abstractC18697p57 instanceof B77) && (abstractC18697p57 instanceof N77)) {
                    i = abstractC18697p57.j;
                    i2 = abstractC18697p57.k;
                }
            }
            if (i <= 1280 && i2 <= 1280) {
                return true;
            }
        }
        return false;
    }

    public static boolean N0(L57 l57) {
        return l57.l;
    }

    public static String O(L57 l57) {
        AbstractC11500d67 abstractC11500d67Y;
        if (W(l57) instanceof C16046kc7) {
            return C4278El2.u(J(l57));
        }
        if (!(W(l57) instanceof C23255wc7)) {
            return (!(W(l57) instanceof C5153Ic7) || W(l57).B == null) ? "" : C4278El2.u(W(l57).B.r);
        }
        ArrayList arrayList = W(l57).f.h;
        return (arrayList.size() <= 0 || (abstractC11500d67Y = C4278El2.y(arrayList, AbstractC21455b.g0())) == null) ? "" : C4278El2.u(abstractC11500d67Y);
    }

    public static long Q(L57 l57) {
        return a0(l57.c);
    }

    public static boolean Q0(L57 l57) {
        M57 m57;
        AbstractC10736c67 abstractC10736c67;
        return W(l57) instanceof C5153Ic7 ? (W(l57).B.k instanceof C6345Ne7) && !(W(l57).B.r instanceof A77) : (l57 == null || (m57 = l57.f) == null || (abstractC10736c67 = m57.i) == null) ? W(l57) instanceof C23255wc7 : abstractC10736c67 instanceof C6345Ne7;
    }

    public static boolean S0(AbstractC18106o57 abstractC18106o57) {
        if (abstractC18106o57 != null && "video/mp4".equals(abstractC18106o57.i)) {
            boolean z = false;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < abstractC18106o57.p.size(); i3++) {
                AbstractC18697p57 abstractC18697p57 = (AbstractC18697p57) abstractC18106o57.p.get(i3);
                if (abstractC18697p57 instanceof N77) {
                    i = abstractC18697p57.j;
                    i2 = abstractC18697p57.k;
                    z = abstractC18697p57.g;
                }
            }
            if (z && i <= 1280 && i2 <= 1280) {
                return true;
            }
        }
        return false;
    }

    public static boolean T0(L57 l57) {
        return W(l57) instanceof C5153Ic7 ? S0(W(l57).B.r) : W(l57) != null && S0(W(l57).s);
    }

    public static F57 U(AbstractC18106o57 abstractC18106o57) {
        if (abstractC18106o57 == null) {
            return null;
        }
        int size = abstractC18106o57.p.size();
        for (int i = 0; i < size; i++) {
            AbstractC18697p57 abstractC18697p57 = (AbstractC18697p57) abstractC18106o57.p.get(i);
            if ((abstractC18697p57 instanceof J77) || (abstractC18697p57 instanceof F77)) {
                F57 f57 = abstractC18697p57.c;
                if (f57 instanceof K97) {
                    return null;
                }
                return f57;
            }
        }
        return null;
    }

    public static Q57 V(C10743c74 c10743c74) {
        L57 l57;
        if (c10743c74 == null || (l57 = c10743c74.e) == null) {
            return null;
        }
        return W(l57);
    }

    public static Q57 W(L57 l57) {
        Q57 q57 = l57.h;
        if (q57 == null) {
            return q57;
        }
        O57 o57 = q57.I;
        return o57 instanceof C7997Ub7 ? ((C7997Ub7) o57).b : q57;
    }

    private C10743c74 Y(AbstractC25089zi7 abstractC25089zi7, W57 w57) {
        C18981pa7 c18981pa7;
        if (w57 instanceof C9840ae7) {
            AbstractC10736c67 abstractC10736c67B0 = b0(abstractC25089zi7, ((C9840ae7) w57).f);
            if (abstractC10736c67B0 == abstractC25089zi7.k) {
                return this;
            }
            c18981pa7 = new C18981pa7();
            C23255wc7 c23255wc7 = new C23255wc7();
            c18981pa7.h = c23255wc7;
            c23255wc7.f = abstractC10736c67B0;
        } else if (w57 instanceof C17248me7) {
            C17248me7 c17248me7 = (C17248me7) w57;
            if (L(abstractC25089zi7, c17248me7.h) == abstractC25089zi7.r) {
                return this;
            }
            C18981pa7 c18981pa72 = new C18981pa7();
            C16046kc7 c16046kc7 = new C16046kc7();
            c18981pa72.h = c16046kc7;
            c16046kc7.s = L(abstractC25089zi7, c17248me7.h);
            c18981pa7 = c18981pa72;
        } else {
            c18981pa7 = null;
        }
        c18981pa7.g = "";
        c18981pa7.V = T();
        c18981pa7.b = Utilities.b.nextInt();
        L57 l57 = this.e;
        c18981pa7.e = l57.e;
        c18981pa7.d = l57.d;
        c18981pa7.l = l57.l;
        c18981pa7.c = l57.c;
        return new C10743c74(this.N, c18981pa7, false, true);
    }

    public static boolean Z0(AbstractC18106o57 abstractC18106o57) {
        if (abstractC18106o57 != null) {
            for (int i = 0; i < abstractC18106o57.p.size(); i++) {
                if (((AbstractC18697p57) abstractC18106o57.p.get(i)) instanceof J77) {
                    return "image/webp".equals(abstractC18106o57.i) || "video/webm".equals(abstractC18106o57.i);
                }
            }
        }
        return false;
    }

    public static long a0(Z57 z57) {
        long j;
        if (z57 == null) {
            return 0L;
        }
        if (z57 instanceof C4220Ee7) {
            j = z57.c;
        } else {
            if (!(z57 instanceof C3752Ce7)) {
                return z57.b;
            }
            j = z57.d;
        }
        return -j;
    }

    /* JADX WARN: Removed duplicated region for block: B:134:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x03ca A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0238 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean b(java.lang.CharSequence r17, java.util.ArrayList r18, boolean r19, boolean r20, boolean r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 980
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10743c74.b(java.lang.CharSequence, java.util.ArrayList, boolean, boolean, boolean, boolean):boolean");
    }

    private AbstractC10736c67 b0(AbstractC25089zi7 abstractC25089zi7, long j) {
        if (abstractC25089zi7 != null && abstractC25089zi7.s != null) {
            AbstractC10736c67 abstractC10736c67 = abstractC25089zi7.k;
            if (abstractC10736c67 != null && abstractC10736c67.d == j) {
                return abstractC10736c67;
            }
            for (int i = 0; i < abstractC25089zi7.s.g.size(); i++) {
                AbstractC10736c67 abstractC10736c672 = (AbstractC10736c67) abstractC25089zi7.s.g.get(i);
                if (abstractC10736c672.d == j) {
                    return abstractC10736c672;
                }
            }
        }
        return null;
    }

    public static boolean b1(AbstractC18106o57 abstractC18106o57) {
        if (abstractC18106o57 == null) {
            return false;
        }
        int size = abstractC18106o57.p.size();
        for (int i = 0; i < size; i++) {
            AbstractC18697p57 abstractC18697p57 = (AbstractC18697p57) abstractC18106o57.p.get(i);
            if (abstractC18697p57 instanceof F77) {
                F57 f57 = abstractC18697p57.c;
                if ((f57 instanceof L97) && f57.b == 1269403972611866647L) {
                    return true;
                }
                return ((F77) abstractC18697p57).t;
            }
        }
        return false;
    }

    private boolean c(CharSequence charSequence, boolean z) {
        return d(charSequence, false, z);
    }

    private AbstractC19652qi7 d0(AbstractMap abstractMap, C21892uJ3 c21892uJ3, long j) {
        AbstractC19652qi7 abstractC19652qi7 = abstractMap != null ? (AbstractC19652qi7) abstractMap.get(Long.valueOf(j)) : c21892uJ3 != null ? (AbstractC19652qi7) c21892uJ3.f(j) : null;
        return abstractC19652qi7 == null ? ir.nasim.tgwidgets.editor.messenger.C.n(this.N).s(Long.valueOf(j)) : abstractC19652qi7;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0215  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void e(boolean r16, java.lang.CharSequence r17, boolean r18, int r19, int r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 564
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10743c74.e(boolean, java.lang.CharSequence, boolean, int, int, boolean):void");
    }

    public static boolean e1(AbstractC18106o57 abstractC18106o57) {
        if (abstractC18106o57 == null) {
            return false;
        }
        boolean z = false;
        int i = 0;
        int i2 = 0;
        boolean z2 = false;
        for (int i3 = 0; i3 < abstractC18106o57.p.size(); i3++) {
            AbstractC18697p57 abstractC18697p57 = (AbstractC18697p57) abstractC18106o57.p.get(i3);
            if (abstractC18697p57 instanceof N77) {
                if (abstractC18697p57.g) {
                    return false;
                }
                i = abstractC18697p57.j;
                i2 = abstractC18697p57.k;
                z2 = true;
            } else if (abstractC18697p57 instanceof B77) {
                z = true;
            }
        }
        if (z && (i > 1280 || i2 > 1280)) {
            z = false;
        }
        if (AbstractC8662Wx6.c0 && !z2 && "video/x-matroska".equals(abstractC18106o57.i)) {
            z2 = true;
        }
        return z2 && !z;
    }

    private boolean f() {
        Z57 z57;
        if (!AbstractC8662Wx6.p0) {
            return false;
        }
        L57 l57 = this.e;
        if (l57 == null || (z57 = l57.d) == null || (z57.d == 0 && z57.c == 0)) {
            return true;
        }
        ir.nasim.tgwidgets.editor.messenger.C cN = ir.nasim.tgwidgets.editor.messenger.C.n(this.N);
        Z57 z572 = this.e.d;
        long j = z572.d;
        if (j == 0) {
            j = z572.c;
        }
        AbstractC15742k57 abstractC15742k57I = cN.i(Long.valueOf(j));
        return (abstractC15742k57I != null && abstractC15742k57I.F) || !AbstractC13547gQ0.d(abstractC15742k57I, 8) || AbstractC13547gQ0.c(abstractC15742k57I);
    }

    public static boolean f1(L57 l57) {
        if (W(l57) == null || !g1(W(l57).s)) {
            return W(l57) instanceof C5153Ic7 ? e1(W(l57).B.r) : W(l57) != null && e1(W(l57).s);
        }
        return false;
    }

    public static boolean g() {
        return AbstractC8662Wx6.h() == 2;
    }

    public static boolean g1(AbstractC18106o57 abstractC18106o57) {
        return abstractC18106o57 != null && h1(abstractC18106o57);
    }

    public static boolean h(int i, boolean z, L57 l57, AbstractC15742k57 abstractC15742k57) {
        U67 u67;
        Z57 z57;
        if (l57 == null) {
            return false;
        }
        if (AbstractC13547gQ0.g(abstractC15742k57) && (l57.f instanceof C5135Ia7)) {
            return false;
        }
        if (l57.b < 0) {
            return true;
        }
        if (abstractC15742k57 == null && (z57 = l57.d) != null && z57.d != 0) {
            abstractC15742k57 = ir.nasim.tgwidgets.editor.messenger.C.n(i).i(Long.valueOf(l57.d.d));
        }
        if (!AbstractC13547gQ0.e(abstractC15742k57)) {
            return z || N0(l57) || !AbstractC13547gQ0.e(abstractC15742k57);
        }
        if (z && !abstractC15742k57.q) {
            if (!abstractC15742k57.g) {
                U67 u672 = abstractC15742k57.L;
                if (u672 == null) {
                    return false;
                }
                if (!u672.f && !l57.l) {
                    return false;
                }
            }
            return true;
        }
        boolean z2 = l57.l;
        if (z2 && (l57 instanceof C8006Uc7)) {
            return l57.b != 1 && AbstractC13547gQ0.a(abstractC15742k57, 13);
        }
        if (!z) {
            if (l57.b == 1) {
                return false;
            }
            if (!abstractC15742k57.g && (((u67 = abstractC15742k57.L) == null || (!u67.f && (!z2 || (!abstractC15742k57.q && !u67.d)))) && (!abstractC15742k57.q || !z2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean h1(AbstractC18106o57 abstractC18106o57) {
        if (abstractC18106o57 != null) {
            for (int i = 0; i < abstractC18106o57.p.size(); i++) {
                AbstractC18697p57 abstractC18697p57 = (AbstractC18697p57) abstractC18106o57.p.get(i);
                if ((abstractC18697p57 instanceof J77) || (abstractC18697p57 instanceof F77)) {
                    return "video/webm".equals(abstractC18106o57.i);
                }
            }
        }
        return false;
    }

    public static boolean j1(AbstractC18106o57 abstractC18106o57) {
        if (abstractC18106o57 != null) {
            for (int i = 0; i < abstractC18106o57.p.size(); i++) {
                AbstractC18697p57 abstractC18697p57 = (AbstractC18697p57) abstractC18106o57.p.get(i);
                if (abstractC18697p57 instanceof C77) {
                    return abstractC18697p57.o;
                }
            }
        }
        return false;
    }

    public static boolean k1(L57 l57) {
        return W(l57) instanceof C5153Ic7 ? j1(W(l57).B.r) : W(l57) != null && j1(W(l57).s);
    }

    public static boolean l(AbstractC18106o57 abstractC18106o57) {
        String str;
        if (abstractC18106o57 != null && (str = abstractC18106o57.i) != null) {
            String lowerCase = str.toLowerCase();
            if ((r0(abstractC18106o57) && (lowerCase.equals("image/png") || lowerCase.equals("image/jpg") || lowerCase.equals("image/jpeg"))) || (Build.VERSION.SDK_INT >= 26 && lowerCase.equals("image/heic"))) {
                for (int i = 0; i < abstractC18106o57.p.size(); i++) {
                    AbstractC18697p57 abstractC18697p57 = (AbstractC18697p57) abstractC18106o57.p.get(i);
                    if (abstractC18697p57 instanceof I77) {
                        I77 i77 = (I77) abstractC18697p57;
                        return i77.j < 6000 && i77.k < 6000;
                    }
                }
            } else if (AbstractC8814Xl0.c) {
                String strC = C4278El2.C(abstractC18106o57);
                if ((strC.startsWith("tg_secret_sticker") && strC.endsWith("json")) || strC.endsWith(".svg")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean l0(AbstractC18106o57 abstractC18106o57) {
        return abstractC18106o57 != null && abstractC18106o57.i.equals("video/webm");
    }

    public static boolean m0(AbstractC18106o57 abstractC18106o57, boolean z) {
        if (abstractC18106o57 != null && (("application/x-tgsticker".equals(abstractC18106o57.i) && !abstractC18106o57.k.isEmpty()) || "application/x-tgsdice".equals(abstractC18106o57.i))) {
            if (z) {
                return true;
            }
            int size = abstractC18106o57.p.size();
            for (int i = 0; i < size; i++) {
                AbstractC18697p57 abstractC18697p57 = (AbstractC18697p57) abstractC18106o57.p.get(i);
                if (abstractC18697p57 instanceof J77) {
                    return abstractC18697p57.c instanceof N97;
                }
                if (abstractC18697p57 instanceof F77) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean m1(AbstractC18106o57 abstractC18106o57) {
        return abstractC18106o57 != null && "video/webm".equals(abstractC18106o57.i);
    }

    private void n(Integer num) {
        TextPaint textPaint;
        if (num == null || num.intValue() < 1) {
            CharSequence charSequence = this.i;
            AnimatedEmojiSpan[] animatedEmojiSpanArr = (AnimatedEmojiSpan[]) ((Spannable) charSequence).getSpans(0, charSequence.length(), AnimatedEmojiSpan.class);
            if (animatedEmojiSpanArr == null || animatedEmojiSpanArr.length <= 0) {
                this.R = 0;
                return;
            }
            this.R = animatedEmojiSpanArr.length;
            for (int i = 0; i < animatedEmojiSpanArr.length; i++) {
                animatedEmojiSpanArr[i].k(ir.nasim.tgwidgets.editor.ui.ActionBar.m.v1.getFontMetricsInt(), (int) (ir.nasim.tgwidgets.editor.ui.ActionBar.m.v1.getTextSize() + AbstractC21455b.F(4.0f)), -1);
                animatedEmojiSpanArr[i].e = false;
            }
            return;
        }
        CharSequence charSequence2 = this.i;
        R62.c[] cVarArr = (R62.c[]) ((Spannable) charSequence2).getSpans(0, charSequence2.length(), R62.c.class);
        CharSequence charSequence3 = this.i;
        AnimatedEmojiSpan[] animatedEmojiSpanArr2 = (AnimatedEmojiSpan[]) ((Spannable) charSequence3).getSpans(0, charSequence3.length(), AnimatedEmojiSpan.class);
        this.P = Math.max(num.intValue(), (cVarArr == null ? 0 : cVarArr.length) + (animatedEmojiSpanArr2 == null ? 0 : animatedEmojiSpanArr2.length));
        this.R = animatedEmojiSpanArr2 == null ? 0 : animatedEmojiSpanArr2.length;
        this.Q = 0;
        if (animatedEmojiSpanArr2 != null) {
            for (AnimatedEmojiSpan animatedEmojiSpan : animatedEmojiSpanArr2) {
                if (!animatedEmojiSpan.d) {
                    this.Q++;
                }
            }
        }
        int i2 = this.P;
        boolean z = (i2 - (cVarArr == null ? 0 : cVarArr.length)) - (animatedEmojiSpanArr2 == null ? 0 : animatedEmojiSpanArr2.length) > 0;
        this.O = z;
        if (i2 == 0 || z) {
            if (animatedEmojiSpanArr2 == null || animatedEmojiSpanArr2.length <= 0) {
                return;
            }
            for (int i3 = 0; i3 < animatedEmojiSpanArr2.length; i3++) {
                animatedEmojiSpanArr2[i3].k(ir.nasim.tgwidgets.editor.ui.ActionBar.m.v1.getFontMetricsInt(), (int) (ir.nasim.tgwidgets.editor.ui.ActionBar.m.v1.getTextSize() + AbstractC21455b.F(4.0f)), -1);
                animatedEmojiSpanArr2[i3].e = false;
            }
            return;
        }
        int i4 = this.Q;
        boolean z2 = i2 == i4;
        int i5 = 2;
        switch (Math.max(i2, i4)) {
            case 0:
            case 1:
            case 2:
                TextPaint[] textPaintArr = ir.nasim.tgwidgets.editor.ui.ActionBar.m.B1;
                textPaint = z2 ? textPaintArr[0] : textPaintArr[2];
                i5 = 1;
                break;
            case 3:
                TextPaint[] textPaintArr2 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.B1;
                textPaint = z2 ? textPaintArr2[1] : textPaintArr2[3];
                i5 = 1;
                break;
            case 4:
                TextPaint[] textPaintArr3 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.B1;
                textPaint = z2 ? textPaintArr3[2] : textPaintArr3[4];
                i5 = 1;
                break;
            case 5:
                TextPaint[] textPaintArr4 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.B1;
                if (z2) {
                    textPaint = textPaintArr4[3];
                    break;
                } else {
                    textPaint = textPaintArr4[5];
                    break;
                }
            case 6:
                TextPaint[] textPaintArr5 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.B1;
                if (z2) {
                    textPaint = textPaintArr5[4];
                    break;
                } else {
                    textPaint = textPaintArr5[5];
                    break;
                }
            default:
                int i6 = this.P > 9 ? 0 : -1;
                textPaint = ir.nasim.tgwidgets.editor.ui.ActionBar.m.B1[5];
                i5 = i6;
                break;
        }
        int textSize = (int) (textPaint.getTextSize() + AbstractC21455b.F(4.0f));
        if (cVarArr != null && cVarArr.length > 0) {
            for (R62.c cVar : cVarArr) {
                cVar.b(textPaint.getFontMetricsInt(), textSize);
            }
        }
        if (animatedEmojiSpanArr2 == null || animatedEmojiSpanArr2.length <= 0) {
            return;
        }
        for (int i7 = 0; i7 < animatedEmojiSpanArr2.length; i7++) {
            animatedEmojiSpanArr2[i7].k(textPaint.getFontMetricsInt(), textSize, i5);
            animatedEmojiSpanArr2[i7].e = true;
        }
    }

    private void o(int[] iArr) {
        n(iArr == null ? null : Integer.valueOf(iArr[0]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int p1(N57 n57, N57 n572) {
        int i = n57.b;
        int i2 = n572.b;
        if (i > i2) {
            return 1;
        }
        return i < i2 ? -1 : 0;
    }

    public static boolean q0(AbstractC18106o57 abstractC18106o57) {
        if (abstractC18106o57 != null) {
            for (int i = 0; i < abstractC18106o57.p.size(); i++) {
                if (((AbstractC18697p57) abstractC18106o57.p.get(i)) instanceof H77) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean r(java.lang.CharSequence r14) {
        /*
            r0 = 0
            if (r14 == 0) goto L8e
            int r1 = r14.length()
            r2 = 2
            if (r1 < r2) goto L8e
            int r1 = r14.length()
            r3 = 20480(0x5000, float:2.8699E-41)
            if (r1 <= r3) goto L14
            goto L8e
        L14:
            int r1 = r14.length()
            r3 = r0
            r4 = r3
            r5 = r4
            r6 = r5
            r7 = r6
        L1d:
            if (r3 >= r1) goto L8e
            char r8 = r14.charAt(r3)
            r9 = 48
            r10 = 32
            r11 = 1
            if (r8 < r9) goto L37
            r9 = 57
            if (r8 > r9) goto L37
            int r4 = r4 + 1
            r5 = 6
            if (r4 < r5) goto L34
            return r11
        L34:
            r5 = r0
            r6 = r5
            goto L3c
        L37:
            if (r8 == r10) goto L3b
            if (r4 > 0) goto L3c
        L3b:
            r4 = r0
        L3c:
            r9 = 64
            r12 = 47
            if (r8 == r9) goto L4c
            r9 = 35
            if (r8 == r9) goto L4c
            if (r8 == r12) goto L4c
            r9 = 36
            if (r8 != r9) goto L4e
        L4c:
            if (r3 == 0) goto L8d
        L4e:
            if (r3 == 0) goto L61
            int r9 = r3 + (-1)
            char r13 = r14.charAt(r9)
            if (r13 == r10) goto L8d
            char r9 = r14.charAt(r9)
            r13 = 10
            if (r9 != r13) goto L61
            goto L8d
        L61:
            r9 = 58
            if (r8 != r9) goto L6b
            if (r5 != 0) goto L69
            r5 = r11
            goto L89
        L69:
            r5 = r0
            goto L89
        L6b:
            if (r8 != r12) goto L75
            if (r5 != r2) goto L70
            return r11
        L70:
            if (r5 != r11) goto L69
            int r5 = r5 + 1
            goto L89
        L75:
            r9 = 46
            if (r8 != r9) goto L82
            if (r6 != 0) goto L80
            if (r7 == r10) goto L80
            int r6 = r6 + 1
            goto L89
        L80:
            r6 = r0
            goto L89
        L82:
            if (r8 == r10) goto L80
            if (r7 != r9) goto L80
            if (r6 != r11) goto L80
            return r11
        L89:
            int r3 = r3 + 1
            r7 = r8
            goto L1d
        L8d:
            return r11
        L8e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10743c74.r(java.lang.CharSequence):boolean");
    }

    public static boolean r0(AbstractC18106o57 abstractC18106o57) {
        if (abstractC18106o57 != null && !abstractC18106o57.k.isEmpty()) {
            int size = abstractC18106o57.k.size();
            for (int i = 0; i < size; i++) {
                AbstractC11500d67 abstractC11500d67 = (AbstractC11500d67) abstractC18106o57.k.get(i);
                if (abstractC11500d67 != null && !(abstractC11500d67 instanceof C7788Te7) && (!(abstractC11500d67.c instanceof C19318q87) || abstractC11500d67.g != null)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void t() {
        I();
    }

    public static Spannable t1(CharSequence charSequence, ArrayList arrayList, Paint.FontMetricsInt fontMetricsInt, boolean z) {
        Spannable spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence);
        if (arrayList == null) {
            return spannableString;
        }
        R62.c[] cVarArr = (R62.c[]) spannableString.getSpans(0, spannableString.length(), R62.c.class);
        for (int i = 0; i < arrayList.size(); i++) {
            N57 n57 = (N57) arrayList.get(i);
            if (n57 instanceof C4427Fb7) {
                C4427Fb7 c4427Fb7 = (C4427Fb7) n57;
                for (int i2 = 0; i2 < cVarArr.length; i2++) {
                    R62.c cVar = cVarArr[i2];
                    if (cVar != null) {
                        int spanStart = spannableString.getSpanStart(cVar);
                        int spanEnd = spannableString.getSpanEnd(cVar);
                        int i3 = c4427Fb7.b;
                        if (AbstractC21455b.u0(i3, c4427Fb7.c + i3, spanStart, spanEnd)) {
                            spannableString.removeSpan(cVar);
                            cVarArr[i2] = null;
                        }
                    }
                }
                if (n57.b + n57.c <= spannableString.length()) {
                    int i4 = n57.b;
                    AnimatedEmojiSpan[] animatedEmojiSpanArr = (AnimatedEmojiSpan[]) spannableString.getSpans(i4, n57.c + i4, AnimatedEmojiSpan.class);
                    if (animatedEmojiSpanArr != null && animatedEmojiSpanArr.length > 0) {
                        for (AnimatedEmojiSpan animatedEmojiSpan : animatedEmojiSpanArr) {
                            spannableString.removeSpan(animatedEmojiSpan);
                        }
                    }
                    AnimatedEmojiSpan animatedEmojiSpan2 = c4427Fb7.g != null ? new AnimatedEmojiSpan(c4427Fb7.g, fontMetricsInt) : new AnimatedEmojiSpan(c4427Fb7.f, fontMetricsInt);
                    animatedEmojiSpan2.f = z;
                    int i5 = n57.b;
                    spannableString.setSpan(animatedEmojiSpan2, i5, n57.c + i5, 33);
                }
            }
        }
        return spannableString;
    }

    public static boolean u0(AbstractC18106o57 abstractC18106o57) {
        return v0(abstractC18106o57, false);
    }

    public static boolean v0(AbstractC18106o57 abstractC18106o57, boolean z) {
        String str;
        return (abstractC18106o57 == null || (str = abstractC18106o57.i) == null || ((!str.equals("image/gif") || z) && !K0(abstractC18106o57))) ? false : true;
    }

    public static CharSequence v1(CharSequence charSequence, String str, AbstractC12724f57 abstractC12724f57) {
        String str2;
        String strReplace;
        int iIndexOf = TextUtils.indexOf(charSequence, str);
        if (iIndexOf < 0) {
            return charSequence;
        }
        AbstractC12724f57 abstractC12724f572 = null;
        if (abstractC12724f57 instanceof AbstractC19652qi7) {
            AbstractC19652qi7 abstractC19652qi7 = (AbstractC19652qi7) abstractC12724f57;
            strReplace = LI7.e(abstractC19652qi7).replace('\n', ' ');
            str2 = "" + abstractC19652qi7.b;
        } else if (abstractC12724f57 instanceof AbstractC15742k57) {
            AbstractC15742k57 abstractC15742k57 = (AbstractC15742k57) abstractC12724f57;
            strReplace = abstractC15742k57.c.replace('\n', ' ');
            str2 = "" + (-abstractC15742k57.b);
        } else if (abstractC12724f57 instanceof C21795u87) {
            strReplace = ((C21795u87) abstractC12724f57).f.replace('\n', ' ');
            str2 = "game";
        } else if (abstractC12724f57 instanceof AbstractC21091t57) {
            strReplace = "ForumUtilities";
            abstractC12724f572 = abstractC12724f57;
            str2 = "topic";
        } else {
            str2 = "0";
            strReplace = "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(TextUtils.replace(charSequence, new String[]{str}, new CharSequence[]{strReplace}));
        URLSpanNoUnderlineBold uRLSpanNoUnderlineBold = new URLSpanNoUnderlineBold("" + str2);
        uRLSpanNoUnderlineBold.a(abstractC12724f572);
        spannableStringBuilder.setSpan(uRLSpanNoUnderlineBold, iIndexOf, strReplace.length() + iIndexOf, 33);
        return spannableStringBuilder;
    }

    public static String w(AbstractC18106o57 abstractC18106o57, String str) {
        return x(abstractC18106o57, str, null);
    }

    public static boolean w0(C12154e78 c12154e78) {
        return c12154e78 != null && (c12154e78.f.equals("image/gif") || L0(c12154e78));
    }

    public static String x(AbstractC18106o57 abstractC18106o57, String str, Integer num) {
        return "";
    }

    public static boolean x0(L57 l57) {
        if (W(l57) instanceof C5153Ic7) {
            return u0(W(l57).B.r);
        }
        if (W(l57) != null) {
            return v0(W(l57).s, (l57.E > 0L ? 1 : (l57.E == 0L ? 0 : -1)) != 0);
        }
        return false;
    }

    public static boolean z0(L57 l57) {
        return W(l57) instanceof C22069uc7;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x069f  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0727  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0793  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x087c A[PHI: r8
      0x087c: PHI (r8v41 ir.nasim.k57) = (r8v39 ir.nasim.k57), (r8v44 ir.nasim.k57) binds: [B:322:0x0892, B:316:0x0873] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:344:0x0908  */
    /* JADX WARN: Removed duplicated region for block: B:431:0x0b7f  */
    /* JADX WARN: Removed duplicated region for block: B:646:0x10d4  */
    /* JADX WARN: Removed duplicated region for block: B:761:0x13de  */
    /* JADX WARN: Removed duplicated region for block: B:781:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void z1(java.util.AbstractMap r23, java.util.AbstractMap r24, ir.nasim.C21892uJ3 r25, ir.nasim.C21892uJ3 r26) {
        /*
            Method dump skipped, instructions count: 5089
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10743c74.z1(java.util.AbstractMap, java.util.AbstractMap, ir.nasim.uJ3, ir.nasim.uJ3):void");
    }

    public void A(AbstractC19652qi7 abstractC19652qi7) {
        String strI;
        if (abstractC19652qi7 == null) {
            abstractC19652qi7 = ir.nasim.tgwidgets.editor.messenger.C.n(this.N).s(Long.valueOf(F()));
        }
        String strA = abstractC19652qi7 != null ? LI7.a(abstractC19652qi7) : "";
        try {
            FH3 fh3W = FH3.w();
            M57 m57 = this.e.f;
            strI = fh3W.i(m57.w, m57.u);
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
            strI = "<error>";
        }
        C10743c74 c10743c74 = this.l;
        if (c10743c74 == null || !(V(c10743c74) instanceof C22069uc7)) {
            if (this.e.f.s) {
                this.i = FH3.q(TD5.tgwidget_PaymentSuccessfullyPaidNoItemRecurrent, strI, strA);
                return;
            } else {
                this.i = FH3.r("PaymentSuccessfullyPaidNoItem", TD5.tgwidget_PaymentSuccessfullyPaidNoItem, strI, strA);
                return;
            }
        }
        if (this.e.f.s) {
            this.i = FH3.q(TD5.tgwidget_PaymentSuccessfullyPaidRecurrent, strI, strA, V(this.l).n);
        } else {
            this.i = FH3.r("PaymentSuccessfullyPaid", TD5.tgwidget_PaymentSuccessfullyPaid, strI, strA, V(this.l).n);
        }
    }

    public boolean A0() {
        return B0(this.e);
    }

    public boolean B1() {
        return C1(false);
    }

    public void C(boolean z) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayList arrayList7;
        if (h0()) {
            C8231Vb7 c8231Vb7 = (C8231Vb7) this.e.h.I;
            if (z) {
                A1(this.B, Collections.singletonList(c8231Vb7.e));
            } else {
                this.B = new ArrayList(Collections.singletonList(c8231Vb7.e));
            }
            this.z = this.e;
            if (this.M == null) {
                u();
                return;
            }
            return;
        }
        L57 l57 = this.e;
        if (l57 instanceof C8006Uc7) {
            M57 m57 = l57.f;
            if (m57 instanceof C4184Ea7) {
                AbstractC10736c67 abstractC10736c67 = m57.i;
                if (z) {
                    ArrayList arrayList8 = this.B;
                    if (arrayList8 != null && !arrayList8.isEmpty()) {
                        for (int i = 0; i < this.B.size(); i++) {
                            AbstractC11500d67 abstractC11500d67 = (AbstractC11500d67) this.B.get(i);
                            int i2 = 0;
                            while (true) {
                                if (i2 < abstractC10736c67.h.size()) {
                                    AbstractC11500d67 abstractC11500d672 = (AbstractC11500d67) abstractC10736c67.h.get(i2);
                                    if (!(abstractC11500d672 instanceof C7788Te7) && abstractC11500d672.b.equals(abstractC11500d67.b)) {
                                        abstractC11500d67.c = abstractC11500d672.c;
                                        break;
                                    }
                                    i2++;
                                }
                            }
                        }
                    }
                } else {
                    this.B = new ArrayList(abstractC10736c67.h);
                }
                if (abstractC10736c67.j != 0 && (arrayList7 = this.B) != null) {
                    int size = arrayList7.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        AbstractC20488s57 abstractC20488s57 = ((AbstractC11500d67) this.B.get(i3)).c;
                        if (abstractC20488s57 != null) {
                            abstractC20488s57.b = abstractC10736c67.j;
                            abstractC20488s57.f = abstractC10736c67.f;
                        }
                    }
                }
                this.z = this.e.f.i;
                return;
            }
            return;
        }
        if (this.f != null || this.g != null) {
            if (TextUtils.isEmpty(this.h) && r0(this.f)) {
                if (!z || (arrayList = this.B) == null) {
                    ArrayList arrayList9 = new ArrayList();
                    this.B = arrayList9;
                    arrayList9.addAll(this.f.k);
                } else if (!arrayList.isEmpty()) {
                    A1(this.B, this.f.k);
                }
                this.z = this.f;
                return;
            }
            return;
        }
        if (W(l57) == null || (W(this.e) instanceof C19001pc7)) {
            return;
        }
        if (W(this.e) instanceof C23255wc7) {
            AbstractC10736c67 abstractC10736c672 = W(this.e).f;
            if (z && ((arrayList6 = this.B) == null || arrayList6.size() == abstractC10736c672.h.size())) {
                ArrayList arrayList10 = this.B;
                if (arrayList10 != null && !arrayList10.isEmpty()) {
                    for (int i4 = 0; i4 < this.B.size(); i4++) {
                        AbstractC11500d67 abstractC11500d673 = (AbstractC11500d67) this.B.get(i4);
                        if (abstractC11500d673 != null) {
                            int i5 = 0;
                            while (true) {
                                if (i5 >= abstractC10736c672.h.size()) {
                                    break;
                                }
                                AbstractC11500d67 abstractC11500d674 = (AbstractC11500d67) abstractC10736c672.h.get(i5);
                                if (abstractC11500d674 != null && !(abstractC11500d674 instanceof C7788Te7)) {
                                    if (abstractC11500d674.b.equals(abstractC11500d673.b)) {
                                        abstractC11500d673.c = abstractC11500d674.c;
                                        break;
                                    }
                                    if ("s".equals(abstractC11500d673.b) && (abstractC11500d674 instanceof C8758Xe7)) {
                                        this.B.set(i4, abstractC11500d674);
                                        break;
                                    }
                                }
                                i5++;
                            }
                        }
                    }
                }
            } else {
                this.B = new ArrayList(abstractC10736c672.h);
            }
            this.z = W(this.e).f;
            return;
        }
        if (W(this.e) instanceof C16046kc7) {
            AbstractC18106o57 abstractC18106o57I = I();
            if (r0(abstractC18106o57I)) {
                if (!z || (arrayList5 = this.B) == null) {
                    ArrayList arrayList11 = new ArrayList();
                    this.B = arrayList11;
                    arrayList11.addAll(abstractC18106o57I.k);
                } else if (!arrayList5.isEmpty()) {
                    A1(this.B, abstractC18106o57I.k);
                }
                this.z = abstractC18106o57I;
                return;
            }
            return;
        }
        if (!(W(this.e) instanceof C19592qc7)) {
            if (W(this.e) instanceof C5153Ic7) {
                AbstractC10736c67 abstractC10736c673 = W(this.e).B.k;
                AbstractC18106o57 abstractC18106o57 = W(this.e).B.r;
                if (abstractC10736c673 != null) {
                    if (!z || (arrayList2 = this.B) == null) {
                        this.B = new ArrayList(abstractC10736c673.h);
                    } else if (!arrayList2.isEmpty()) {
                        A1(this.B, abstractC10736c673.h);
                    }
                    this.z = abstractC10736c673;
                    return;
                }
                if (abstractC18106o57 == null || !r0(abstractC18106o57)) {
                    return;
                }
                if (z) {
                    ArrayList arrayList12 = this.B;
                    if (arrayList12 != null && !arrayList12.isEmpty()) {
                        A1(this.B, abstractC18106o57.k);
                    }
                } else {
                    ArrayList arrayList13 = new ArrayList();
                    this.B = arrayList13;
                    arrayList13.addAll(abstractC18106o57.k);
                }
                this.z = abstractC18106o57;
                return;
            }
            return;
        }
        AbstractC18106o57 abstractC18106o572 = W(this.e).v.i;
        if (abstractC18106o572 != null && r0(abstractC18106o572)) {
            if (z) {
                ArrayList arrayList14 = this.B;
                if (arrayList14 != null && !arrayList14.isEmpty()) {
                    A1(this.B, abstractC18106o572.k);
                }
            } else {
                ArrayList arrayList15 = new ArrayList();
                this.B = arrayList15;
                arrayList15.addAll(abstractC18106o572.k);
            }
            this.z = abstractC18106o572;
        }
        AbstractC10736c67 abstractC10736c674 = W(this.e).v.h;
        if (abstractC10736c674 != null) {
            if (!z || (arrayList4 = this.C) == null) {
                this.C = new ArrayList(abstractC10736c674.h);
            } else if (!arrayList4.isEmpty()) {
                A1(this.C, abstractC10736c674.h);
            }
            this.A = abstractC10736c674;
        }
        if (this.B != null || (arrayList3 = this.C) == null) {
            return;
        }
        this.B = arrayList3;
        this.C = null;
        this.z = this.A;
        this.A = null;
    }

    public boolean C0() {
        return D0(this.e);
    }

    public boolean C1(boolean z) {
        return false;
    }

    public long E() {
        Z57 z57 = this.e.d;
        if (z57 instanceof C4220Ee7) {
            return z57.c;
        }
        if (z57 instanceof C3752Ce7) {
            return z57.d;
        }
        return 0L;
    }

    public long F() {
        return G(this.e);
    }

    public boolean F0(boolean z) {
        return E0(this.e, z);
    }

    public boolean G0() {
        return (!I0(this.e) || c1() || R0()) ? false : true;
    }

    public String H() {
        if (!o0()) {
            return null;
        }
        C14866ic7 c14866ic7 = (C14866ic7) W(this.e);
        return TextUtils.isEmpty(c14866ic7.O) ? "🎲" : c14866ic7.O.replace("️", "");
    }

    public AbstractC18106o57 I() {
        AbstractC18106o57 abstractC18106o57 = this.f;
        return abstractC18106o57 != null ? abstractC18106o57 : J(this.e);
    }

    public boolean J0() {
        return W(this.e) != null && K0(I());
    }

    public double M() {
        AbstractC18116o67 abstractC18116o67;
        Q57 q57;
        double d = this.y;
        if (d > 0.0d) {
            return d;
        }
        AbstractC18106o57 abstractC18106o57I = I();
        if (abstractC18106o57I == null && this.m == 23 && (abstractC18116o67 = W(this.e).L) != null && (q57 = abstractC18116o67.p) != null) {
            abstractC18106o57I = q57.s;
        }
        if (abstractC18106o57I == null) {
            return 0.0d;
        }
        int i = this.x;
        if (i > 0) {
            return i;
        }
        for (int i2 = 0; i2 < abstractC18106o57I.p.size(); i2++) {
            AbstractC18697p57 abstractC18697p57 = (AbstractC18697p57) abstractC18106o57I.p.get(i2);
            if (abstractC18697p57 instanceof C77) {
                double d2 = abstractC18697p57.d;
                this.y = d2;
                return d2;
            }
            if (abstractC18697p57 instanceof N77) {
                double d3 = abstractC18697p57.d;
                this.y = d3;
                return d3;
            }
        }
        return this.x;
    }

    public boolean M0() {
        return this.e.l;
    }

    public String N() {
        return O(this.e);
    }

    public boolean O0() {
        Z57 z57;
        Z57 z572;
        Boolean bool = this.Y;
        if (bool != null) {
            return bool.booleanValue();
        }
        Z57 z573 = this.e.d;
        AbstractC15742k57 abstractC15742k57D = null;
        if (z573 != null) {
            long j = z573.d;
            if (j != 0) {
                abstractC15742k57D = D(null, null, j);
            }
        }
        L57 l57 = this.e;
        if (l57.l) {
            Z57 z574 = l57.c;
            if ((z574 instanceof C4937He7) || ((z574 instanceof C3752Ce7) && (!AbstractC13547gQ0.e(abstractC15742k57D) || abstractC15742k57D.q))) {
                L57 l572 = this.e;
                if (!l572.v) {
                    if (l572.A == null) {
                        this.Y = Boolean.TRUE;
                        return true;
                    }
                    long jH = C22477vI7.j(this.N).h();
                    if (F() != jH) {
                        Z57 z575 = this.e.A.i;
                        z = z575 == null || z575.b == jH;
                        this.Y = Boolean.valueOf(z);
                        return z;
                    }
                    P57 p57 = this.e.A;
                    Z57 z576 = p57.d;
                    if (((z576 instanceof C4937He7) && z576.b == jH && ((z572 = p57.i) == null || z572.b == jH)) || ((z57 = p57.i) != null && z57.b == jH && (z576 == null || z576.b == jH))) {
                        z = true;
                    }
                    this.Y = Boolean.valueOf(z);
                    return z;
                }
            }
        }
        this.Y = Boolean.FALSE;
        return false;
    }

    public long P() {
        return Q(this.e);
    }

    public boolean P0() {
        return Q0(this.e);
    }

    public long R() {
        long j = this.a;
        return j != 0 ? j : S();
    }

    public boolean R0() {
        if (this.o == 0) {
            this.o = (this.m == 5 || T0(this.e)) ? 1 : 2;
        }
        return this.o == 1;
    }

    public long S() {
        long j = this.b;
        return j != 0 ? j : this.e.E;
    }

    public int T() {
        return this.e.b;
    }

    public boolean U0() {
        int i;
        L57 l57 = this.e;
        if (l57 instanceof C20802sd7) {
            return (((W(l57) instanceof C23255wc7) || t0()) && (i = this.e.R) > 0 && i <= 60) || i1() || R0() || c1();
        }
        if (l57 instanceof C18981pa7) {
            return (W(l57) == null || W(this.e).F == 0 || (!(W(this.e) instanceof C23255wc7) && !(W(this.e) instanceof C16046kc7))) ? false : true;
        }
        return false;
    }

    public boolean V0() {
        L57 l57 = this.e;
        return l57.K == 1 && l57.b < 0;
    }

    public boolean W0() {
        L57 l57 = this.e;
        return l57.K == 0 || l57.b > 0;
    }

    public int X() {
        if (c1()) {
            return 2;
        }
        if (i1()) {
            return 1;
        }
        if (W(this.e) instanceof C16046kc7) {
            return 3;
        }
        return W(this.e) instanceof C23255wc7 ? 0 : 4;
    }

    public boolean X0() {
        return false;
    }

    public boolean Y0() {
        int i = this.m;
        return i != 1000 ? i == 13 : Z0(I()) || g1(I());
    }

    public String Z() {
        AbstractC18106o57 abstractC18106o57I = I();
        if (abstractC18106o57I != null) {
            return abstractC18106o57I.i;
        }
        if (!(W(this.e) instanceof C22069uc7)) {
            return W(this.e) instanceof C23255wc7 ? "image/jpeg" : (!(W(this.e) instanceof C5153Ic7) || W(this.e).B.k == null) ? "" : "image/jpeg";
        }
        AbstractC24495yi7 abstractC24495yi7 = ((C22069uc7) W(this.e)).N;
        return abstractC24495yi7 != null ? abstractC24495yi7.e : "";
    }

    public boolean a1() {
        if (this.c) {
            return true;
        }
        Boolean bool = this.d;
        if (bool != null) {
            return bool.booleanValue();
        }
        Z57 z57 = this.e.d;
        if (z57 != null) {
            long j = z57.d;
            if (j != 0) {
                AbstractC15742k57 abstractC15742k57D = D(null, null, j);
                if (abstractC15742k57D == null) {
                    return false;
                }
                boolean z = abstractC15742k57D.q;
                this.d = Boolean.valueOf(z);
                return z;
            }
        }
        this.d = Boolean.FALSE;
        return false;
    }

    public String c0() {
        AbstractC18106o57 abstractC18106o57I = I();
        if (abstractC18106o57I == null) {
            return null;
        }
        Iterator it = abstractC18106o57I.p.iterator();
        while (it.hasNext()) {
            AbstractC18697p57 abstractC18697p57 = (AbstractC18697p57) it.next();
            if (abstractC18697p57 instanceof J77) {
                return abstractC18697p57.b;
            }
        }
        return null;
    }

    public boolean c1() {
        return f1(this.e);
    }

    public boolean d(CharSequence charSequence, boolean z, boolean z2) {
        ArrayList arrayList;
        if (charSequence == null) {
            return false;
        }
        if (this.I) {
            ArrayList arrayList2 = new ArrayList();
            C5144Ib7 c5144Ib7 = new C5144Ib7();
            c5144Ib7.b = 0;
            c5144Ib7.c = charSequence.length();
            arrayList2.add(c5144Ib7);
            return b(charSequence, arrayList2, O0(), true, z, z2);
        }
        if (this.W) {
            this.e.getClass();
            arrayList = null;
        } else {
            arrayList = this.e.n;
        }
        return b(charSequence, arrayList, O0(), true, z, z2);
    }

    public boolean d1() {
        AbstractC10736c67 abstractC10736c67;
        M57 m57 = this.e.f;
        return (m57 == null || (abstractC10736c67 = m57.i) == null || abstractC10736c67.i.isEmpty()) ? false : true;
    }

    public ArrayList e0(ArrayList arrayList, ArrayList arrayList2) {
        AbstractC25089zi7 abstractC25089zi7;
        V57 v57;
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        if (W(this.e) == null || W(this.e).B == null || (v57 = (abstractC25089zi7 = W(this.e).B).s) == null) {
            return arrayList;
        }
        if (arrayList2 == null) {
            arrayList2 = v57.f;
        }
        for (int i = 0; i < arrayList2.size(); i++) {
            W57 w57 = (W57) arrayList2.get(i);
            if (w57 instanceof C13066fe7) {
                C13066fe7 c13066fe7 = (C13066fe7) w57;
                for (int i2 = 0; i2 < c13066fe7.e.size(); i2++) {
                    arrayList.add(Y(abstractC25089zi7, (W57) c13066fe7.e.get(i2)));
                }
            } else if (w57 instanceof C5162Id7) {
                C5162Id7 c5162Id7 = (C5162Id7) w57;
                for (int i3 = 0; i3 < c5162Id7.e.size(); i3++) {
                    arrayList.add(Y(abstractC25089zi7, (W57) c5162Id7.e.get(i3)));
                }
            }
        }
        return arrayList;
    }

    public boolean f0() {
        if (W(this.e) instanceof C23255wc7) {
            return W(this.e).f != null && W(this.e).f.c;
        }
        if (W(this.e) instanceof C16046kc7) {
            return q0(W(this.e).s);
        }
        return false;
    }

    public boolean g0() {
        Q57 q57 = this.e.h;
        return (q57 == null || q57.I == null) ? false : true;
    }

    public boolean h0() {
        Q57 q57 = this.e.h;
        return q57 != null && (q57.I instanceof C8231Vb7);
    }

    public boolean i() {
        if (U0()) {
            return false;
        }
        if (W(this.e) instanceof C23255wc7) {
            return true;
        }
        return (!(W(this.e) instanceof C16046kc7) || i1() || Y0() || k0() || R0()) ? false : true;
    }

    public boolean i0() {
        Q57 q57 = this.e.h;
        return q57 != null && (q57.I instanceof C7997Ub7);
    }

    public boolean i1() {
        return k1(this.e);
    }

    public boolean j() {
        return ((this.e instanceof C20802sd7) || r1() || A0() || this.m == 16 || X0() || this.e.I) ? false : true;
    }

    public boolean j0() {
        ArrayList arrayList;
        return R() != 0 && (!((arrayList = this.B) == null || arrayList.isEmpty()) || G0() || p0());
    }

    public boolean k() {
        return l(I());
    }

    public boolean k0() {
        int i = this.m;
        if (i != 1000) {
            return i == 15;
        }
        boolean zC = ZO1.c(F());
        if (zC && this.e.W != 1) {
            return false;
        }
        if (this.g == null || this.f != null) {
            return m0(I(), (this.f == null && zC && !M0()) ? false : true);
        }
        return true;
    }

    public boolean l1() {
        return (W(this.e) instanceof C5153Ic7) && W(this.e).B != null && "telegram_background".equals(W(this.e).B.g);
    }

    public boolean m() {
        AbstractC18106o57 abstractC18106o57I = I();
        if (abstractC18106o57I != null && !(abstractC18106o57I instanceof R77)) {
            if (AbstractC8662Wx6.b0) {
                return true;
            }
            for (int i = 0; i < abstractC18106o57I.p.size(); i++) {
                AbstractC18697p57 abstractC18697p57 = (AbstractC18697p57) abstractC18106o57I.p.get(i);
                if (abstractC18697p57 instanceof N77) {
                    return abstractC18697p57.h;
                }
            }
            if (AbstractC8662Wx6.c0 && "video/x-matroska".equals(abstractC18106o57I.i)) {
                return true;
            }
        }
        return false;
    }

    public boolean n0() {
        int i = this.m;
        return i == 13 || i == 15 || i == 19;
    }

    public boolean n1() {
        return W(this.e) instanceof C5153Ic7;
    }

    public boolean o0() {
        return W(this.e) instanceof C14866ic7;
    }

    public boolean o1() {
        return (W(this.e) instanceof C5153Ic7) && W(this.e).B != null && !TextUtils.isEmpty(W(this.e).B.l) && "YouTube".equals(W(this.e).B.h);
    }

    public void p() {
        q(true);
    }

    public boolean p0() {
        return (I() == null || c1() || G0() || i1() || n0()) ? false : true;
    }

    public void q(boolean z) {
        int i;
        AbstractC10736c67 abstractC10736c67;
        this.F = false;
        this.G = false;
        int i2 = this.m;
        if (i2 == 20) {
            C8231Vb7 c8231Vb7 = (C8231Vb7) this.e.h.I;
            if (c8231Vb7.e != null) {
                File fileM = C4278El2.H(this.N).M(c8231Vb7.e);
                if (!this.G) {
                    this.G = fileM.exists() || (c8231Vb7.e instanceof C8758Xe7);
                }
            }
        } else if (i2 == 1 && C4278El2.y(this.B, AbstractC21455b.g0()) != null) {
            File fileS = C4278El2.H(this.N).S(this.e, z);
            if (r1()) {
                this.G = new File(fileS.getAbsolutePath() + ".enc").exists();
            }
            if (!this.G) {
                this.G = fileS.exists();
            }
        }
        if ((!this.G && this.m == 8) || (i = this.m) == 3 || i == 9 || i == 2 || i == 14 || i == 5) {
            String str = this.e.M;
            if (str != null && str.length() > 0) {
                this.F = new File(this.e.M).exists();
            }
            if (!this.F) {
                File fileS2 = C4278El2.H(this.N).S(this.e, z);
                if (this.m == 3 && r1()) {
                    this.G = new File(fileS2.getAbsolutePath() + ".enc").exists();
                }
                if (!this.G) {
                    this.G = fileS2.exists();
                }
            }
        }
        if (this.G) {
            return;
        }
        AbstractC18106o57 abstractC18106o57I = I();
        if (abstractC18106o57I != null) {
            if (l1()) {
                this.G = C4278El2.H(this.N).P(abstractC18106o57I, null, true, z).exists();
                return;
            } else {
                this.G = C4278El2.H(this.N).P(abstractC18106o57I, null, false, z).exists();
                return;
            }
        }
        int i3 = this.m;
        if (i3 == 0) {
            AbstractC11500d67 abstractC11500d67Y = C4278El2.y(this.B, AbstractC21455b.g0());
            if (abstractC11500d67Y == null) {
                return;
            }
            this.G = C4278El2.H(this.N).P(abstractC11500d67Y, null, true, z).exists();
            return;
        }
        if (i3 != 11 || (abstractC10736c67 = this.e.f.i) == null || abstractC10736c67.i.isEmpty()) {
            return;
        }
        this.G = C4278El2.H(this.N).P((AbstractC12724f57) abstractC10736c67.i.get(0), null, true, z).exists();
    }

    public void q1() {
        C6327Nc7 c6327Nc7;
        CharSequence charSequenceS;
        if (this.I) {
            return;
        }
        this.E = 0;
        if (((this.e.p instanceof C3761Cf7) && !g0()) || ((c6327Nc7 = this.e.F) != null && !c6327Nc7.e.isEmpty())) {
            ir.nasim.tgwidgets.editor.ui.ActionBar.m.Q();
            StringBuilder sb = this.H;
            if (sb == null) {
                this.H = new StringBuilder();
            } else {
                sb.setLength(0);
            }
        }
        if (!(this.e.p instanceof C3761Cf7) || g0() || this.e.p.h == null) {
            return;
        }
        for (int i = 0; i < this.e.p.h.size(); i++) {
            C13644ga7 c13644ga7 = (C13644ga7) this.e.p.h.get(i);
            int size = c13644ga7.b.size();
            int iMax = 0;
            for (int i2 = 0; i2 < size; i2++) {
                K57 k57 = (K57) c13644ga7.b.get(i2);
                StringBuilder sb2 = this.H;
                sb2.append(i);
                sb2.append(i2);
                if (!(k57 instanceof Y97) || (W(this.e).d & 4) == 0) {
                    String str = k57.b;
                    if (str == null) {
                        str = "";
                    }
                    charSequenceS = R62.S(str, ir.nasim.tgwidgets.editor.ui.ActionBar.m.z1.getFontMetricsInt(), AbstractC21455b.F(15.0f), false);
                } else {
                    charSequenceS = FH3.E("PaymentReceipt", TD5.tgwidget_PaymentReceipt);
                }
                StaticLayout staticLayout = new StaticLayout(charSequenceS, ir.nasim.tgwidgets.editor.ui.ActionBar.m.z1, AbstractC21455b.F(2000.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                if (staticLayout.getLineCount() > 0) {
                    float lineWidth = staticLayout.getLineWidth(0);
                    float lineLeft = staticLayout.getLineLeft(0);
                    if (lineLeft < lineWidth) {
                        lineWidth -= lineLeft;
                    }
                    iMax = Math.max(iMax, ((int) Math.ceil(lineWidth)) + AbstractC21455b.F(4.0f));
                }
            }
            this.E = Math.max(this.E, ((iMax + AbstractC21455b.F(12.0f)) * size) + (AbstractC21455b.F(5.0f) * (size - 1)));
        }
    }

    public boolean r1() {
        if (h0()) {
            return true;
        }
        L57 l57 = this.e;
        if (l57 instanceof C20802sd7) {
            int iMax = Math.max(l57.R, W(l57).F);
            return iMax > 0 && ((((W(this.e) instanceof C23255wc7) || c1() || t0()) && iMax <= 60) || R0());
        }
        if (l57 instanceof C18981pa7) {
            return (W(l57) == null || W(this.e).F == 0 || (!(W(this.e) instanceof C23255wc7) && !(W(this.e) instanceof C16046kc7))) ? false : true;
        }
        return false;
    }

    public boolean s0() {
        L57 l57 = this.e;
        return (l57.c instanceof C4937He7) && !l57.v;
    }

    public Spannable s1(CharSequence charSequence, Paint.FontMetricsInt fontMetricsInt) {
        if (this.W) {
            this.e.getClass();
        }
        return t1(charSequence, this.e.n, fontMetricsInt, false);
    }

    public boolean t0() {
        return x0(this.e);
    }

    public void u() {
        if (this.B != null) {
            if (g() || h0()) {
                try {
                    int size = this.B.size();
                    for (int i = 0; i < size; i++) {
                        AbstractC11500d67 abstractC11500d67 = (AbstractC11500d67) this.B.get(i);
                        if (abstractC11500d67 instanceof C8758Xe7) {
                            this.M = new BitmapDrawable(AbstractC14047hG.a.getResources(), C21457d.j0(abstractC11500d67.g, "b"));
                            return;
                        }
                    }
                } catch (Throwable th) {
                    AbstractC6403Nl2.d(th);
                }
            }
        }
    }

    public boolean v(C10743c74 c10743c74) {
        return c10743c74 != null && T() == c10743c74.T() && F() == c10743c74.F();
    }

    public CharSequence w1(CharSequence charSequence, String str, ArrayList arrayList, AbstractMap abstractMap, C21892uJ3 c21892uJ3) {
        if (TextUtils.indexOf(charSequence, str) < 0) {
            return charSequence;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        for (int i = 0; i < arrayList.size(); i++) {
            AbstractC19652qi7 abstractC19652qi7S = abstractMap != null ? (AbstractC19652qi7) abstractMap.get(arrayList.get(i)) : c21892uJ3 != null ? (AbstractC19652qi7) c21892uJ3.f(((Long) arrayList.get(i)).longValue()) : null;
            if (abstractC19652qi7S == null) {
                abstractC19652qi7S = ir.nasim.tgwidgets.editor.messenger.C.n(this.N).s((Long) arrayList.get(i));
            }
            if (abstractC19652qi7S != null) {
                String strE = LI7.e(abstractC19652qi7S);
                int length = spannableStringBuilder.length();
                if (spannableStringBuilder.length() != 0) {
                    spannableStringBuilder.append((CharSequence) ", ");
                }
                spannableStringBuilder.append((CharSequence) strE);
                spannableStringBuilder.setSpan(new URLSpanNoUnderlineBold("" + abstractC19652qi7S.b), length, strE.length() + length, 33);
            }
        }
        return TextUtils.replace(charSequence, new String[]{str}, new CharSequence[]{spannableStringBuilder});
    }

    public void x1() {
        this.s = 0.0f;
        this.w = 0;
        this.v = 0.0f;
    }

    public void y() {
        if ((this.j == null || this.W != this.X) && !R0()) {
            L57 l57 = this.e;
            String str = l57.g;
            ArrayList arrayList = l57.n;
            if (g0()) {
                L57 l572 = this.e;
                String str2 = l572.h.j;
                l572.g = str2;
                str = str2;
            }
            boolean z = this.W;
            this.X = z;
            if (z) {
                this.e.getClass();
                throw null;
            }
            if (C0() || (W(this.e) instanceof C19592qc7) || TextUtils.isEmpty(str)) {
                return;
            }
            boolean z2 = false;
            CharSequence charSequenceS = R62.S(str, ir.nasim.tgwidgets.editor.ui.ActionBar.m.v1.getFontMetricsInt(), AbstractC21455b.F(20.0f), false);
            this.j = charSequenceS;
            this.j = s1(charSequenceS, ir.nasim.tgwidgets.editor.ui.ActionBar.m.v1.getFontMetricsInt());
            if (!(this.e.K != 0 ? false : !arrayList.isEmpty()) && (this.p != 0 || (W(this.e) instanceof C25029zc7) || (W(this.e) instanceof C23845xc7) || (W(this.e) instanceof C24435yc7) || (W(this.e) instanceof C18410oc7) || (W(this.e) instanceof C17228mc7) || (W(this.e) instanceof C17819nc7) || ((M0() && this.e.K != 0) || this.e.b < 0))) {
                z2 = true;
            }
            if (z2) {
                if (r(this.j)) {
                    try {
                        AbstractC21455b.l((Spannable) this.j, 5);
                    } catch (Exception e) {
                        AbstractC6403Nl2.d(e);
                    }
                }
                e(O0(), this.j, true, 0, 0, true);
            }
            c(this.j, z2);
            if (c1()) {
                e(O0(), this.j, true, 3, (int) M(), false);
            } else if (G0() || i1()) {
                e(O0(), this.j, true, 4, (int) M(), false);
            }
        }
    }

    public boolean y0() {
        return z0(this.e);
    }

    public void y1() {
        int i;
        int i2 = this.m;
        this.m = AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
        this.o = 0;
        L57 l57 = this.e;
        if ((l57 instanceof C18981pa7) || (l57 instanceof C8465Wb7)) {
            if (this.I) {
                this.m = 0;
            } else if (this.f == null && this.g == null) {
                if (F0(false) && !o0() && this.P >= 1 && !this.O) {
                    this.m = 19;
                } else if (C0()) {
                    this.m = 0;
                    if (TextUtils.isEmpty(this.i) && this.p == 0) {
                        this.i = FH3.E("EventLogOriginalCaptionEmpty", TD5.tgwidget_EventLogOriginalCaptionEmpty);
                    }
                } else if (h0()) {
                    this.m = 20;
                } else if (W(this.e).F != 0 && ((W(this.e).f instanceof C7083Qe7) || (I() instanceof Q77))) {
                    this.q = 1;
                    this.m = 10;
                } else if (W(this.e) instanceof C14866ic7) {
                    this.m = 15;
                    if (W(this.e).s == null) {
                        W(this.e).s = new A77();
                        W(this.e).s.e = new byte[0];
                        W(this.e).s.i = "application/x-tgsdice";
                        W(this.e).s.m = RecyclerView.UNDEFINED_DURATION;
                        W(this.e).s.c = -2147483648L;
                        I77 i77 = new I77();
                        i77.j = 512;
                        i77.k = 512;
                        W(this.e).s.p.add(i77);
                    }
                } else if (W(this.e) instanceof C23255wc7) {
                    this.m = 1;
                } else if ((W(this.e) instanceof C20199rc7) || (W(this.e) instanceof C4202Ec7) || (W(this.e) instanceof C20792sc7)) {
                    this.m = 4;
                } else if (R0()) {
                    this.m = 5;
                } else if (c1()) {
                    this.m = 3;
                } else if (i1()) {
                    this.m = 2;
                } else if (G0()) {
                    this.m = 14;
                } else if (W(this.e) instanceof C13046fc7) {
                    this.m = 12;
                } else if (W(this.e) instanceof C3261Ac7) {
                    this.m = 17;
                    this.J = new ArrayList();
                } else if (W(this.e) instanceof C3734Cc7) {
                    this.m = 0;
                } else if (W(this.e) instanceof C16046kc7) {
                    AbstractC18106o57 abstractC18106o57I = I();
                    if (abstractC18106o57I == null || abstractC18106o57I.i == null) {
                        this.m = 9;
                    } else if (v0(abstractC18106o57I, j0())) {
                        this.m = 8;
                    } else if (Y0()) {
                        this.m = 13;
                    } else if (k0()) {
                        this.m = 15;
                    } else {
                        this.m = 9;
                    }
                } else if ((W(this.e) instanceof C19592qc7) || (W(this.e) instanceof C22069uc7)) {
                    this.m = 0;
                } else if (W(this.e) instanceof C3500Bc7) {
                    int i3 = W(this.e).M ? 24 : 23;
                    this.m = i3;
                    if (i3 == 24) {
                        this.q = 1;
                    }
                }
            } else if (Y0()) {
                this.m = 13;
            } else {
                this.m = 15;
            }
        } else if (l57 instanceof C8006Uc7) {
            M57 m57 = l57.f;
            if (m57 instanceof C16627lb7) {
                this.q = 1;
                this.m = 0;
            } else if (m57 instanceof C14856ib7) {
                this.q = 1;
                this.m = 22;
                C14856ib7 c14856ib7 = (C14856ib7) m57;
                ArrayList arrayList = new ArrayList();
                this.B = arrayList;
                AbstractC18106o57 abstractC18106o57 = c14856ib7.E.j;
                if (abstractC18106o57 != null) {
                    arrayList.addAll(abstractC18106o57.k);
                    this.z = c14856ib7.E.j;
                }
            } else if (m57 instanceof C17218mb7) {
                this.q = 1;
                this.m = 21;
                ArrayList arrayList2 = new ArrayList();
                this.B = arrayList2;
                arrayList2.addAll(this.e.f.i.h);
                this.z = this.e.f.i;
            } else if (m57 instanceof C8722Xa7) {
                this.m = 0;
            } else if (m57 instanceof C7281Ra7) {
                this.q = 1;
                this.m = 18;
            } else if ((m57 instanceof C4184Ea7) || (m57 instanceof C20782sb7)) {
                this.q = 1;
                this.m = 11;
            } else if (m57 instanceof C23835xb7) {
                AbstractC16924m57 abstractC16924m57 = m57.d;
                if ((abstractC16924m57 instanceof C22971w77) || (abstractC16924m57 instanceof C23561x77)) {
                    this.q = 1;
                    this.m = 10;
                } else {
                    this.q = -1;
                    this.m = -1;
                }
            } else if (m57 instanceof C7988Ua7) {
                this.q = -1;
                this.m = -1;
            } else if (m57 instanceof C10430bb7) {
                this.m = 16;
            } else {
                this.q = 1;
                this.m = 10;
            }
        }
        if (i2 == 1000 || i2 == (i = this.m) || i == 19) {
            return;
        }
        z1(ir.nasim.tgwidgets.editor.messenger.C.n(this.N).v(), ir.nasim.tgwidgets.editor.messenger.C.n(this.N).j(), null, null);
        C(false);
    }

    public C10743c74(int i, L57 l57, boolean z, boolean z2) {
        this(i, l57, null, null, null, null, null, z, z2, 0L);
    }

    public C10743c74(int i, L57 l57, C10743c74 c10743c74, boolean z, boolean z2) {
        this(i, l57, c10743c74, null, null, null, null, z, z2, 0L);
    }

    public C10743c74(int i, L57 l57, C10743c74 c10743c74, AbstractMap abstractMap, AbstractMap abstractMap2, C21892uJ3 c21892uJ3, C21892uJ3 c21892uJ32, boolean z, boolean z2, long j) {
        TextPaint textPaint;
        this.m = AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
        this.t = -1.0f;
        this.V = false;
        this.W = false;
        ir.nasim.tgwidgets.editor.ui.ActionBar.m.Q();
        this.N = i;
        this.e = l57;
        this.l = c10743c74;
        this.p = j;
        L57 l572 = l57.U;
        if (l572 != null) {
            this.l = new C10743c74(i, l572, null, abstractMap, abstractMap2, c21892uJ3, c21892uJ32, false, z2, j);
        }
        Z57 z57 = l57.c;
        if (z57 instanceof C4937He7) {
            d0(abstractMap, c21892uJ3, z57.b);
        }
        z1(abstractMap, abstractMap2, c21892uJ3, c21892uJ32);
        y1();
        if (z) {
            C1(false);
        }
        q1();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(this.e.e * 1000);
        this.r = String.format("%d_%02d_%02d", Integer.valueOf(gregorianCalendar.get(1)), Integer.valueOf(gregorianCalendar.get(2)), Integer.valueOf(gregorianCalendar.get(6)));
        s();
        y();
        if (z) {
            if (W(this.e) instanceof C19592qc7) {
                textPaint = ir.nasim.tgwidgets.editor.ui.ActionBar.m.A1;
            } else {
                textPaint = ir.nasim.tgwidgets.editor.ui.ActionBar.m.v1;
            }
            int[] iArr = f() ? new int[1] : null;
            CharSequence charSequenceT = R62.T(this.i, textPaint.getFontMetricsInt(), AbstractC21455b.F(20.0f), false, iArr);
            this.i = charSequenceT;
            Spannable spannableS1 = s1(charSequenceT, textPaint.getFontMetricsInt());
            this.i = spannableS1;
            if (iArr != null && iArr[0] > 1) {
                u1(spannableS1, iArr);
            }
            o(iArr);
            y1();
            t();
        }
        this.S = z;
        C(false);
        if (z2) {
            p();
        }
    }

    public void s() {
    }

    public void z(AbstractC19652qi7 abstractC19652qi7) {
    }

    public void B(AbstractC19652qi7 abstractC19652qi7, AbstractC15742k57 abstractC15742k57) {
    }

    public void u1(CharSequence charSequence, int[] iArr) {
    }
}
