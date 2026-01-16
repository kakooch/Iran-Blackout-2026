package ir.nasim;

import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import java.util.Calendar;
import java.util.List;

/* renamed from: ir.nasim.Jo7, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C5495Jo7 {
    private static int A;
    private static int A0;
    private static int A1;
    private static int A2;
    private static int B;
    private static int B0;
    private static int B1;
    private static int B2;
    private static int C;
    private static int C0;
    private static int C1;
    private static int C2;
    private static int D;
    private static int D0;
    private static int D1;
    private static int D2;
    private static int E;
    private static int E0;
    private static int E1;
    private static int E2;
    private static int F;
    private static int F0;
    private static int F1;
    private static int F2;
    private static int G;
    private static int G0;
    private static int G1;
    private static int G2;
    private static int H;
    private static int H0;
    private static int H1;
    private static int H2;
    private static int I;
    private static int I0;
    private static int I1;
    private static int J;
    private static int J0;
    private static int J1;
    private static int K;
    private static int K0;
    private static int K1;
    private static int L;
    private static int L0;
    private static int L1;
    private static int M;
    private static int M0;
    private static int M1;
    private static int N;
    private static int N0;
    private static int N1;
    private static int O;
    private static int O0;
    private static int O1;
    private static int P;
    private static int P0;
    private static int P1;
    private static int Q;
    private static int Q0;
    private static int Q1;
    private static int R;
    private static int R0;
    private static int R1;
    private static int S;
    private static int S0;
    private static int S1;
    private static int T;
    private static int T0;
    private static int T1;
    private static int U;
    private static int U0;
    private static int U1;
    private static int V;
    private static int V0;
    private static int V1;
    private static int W;
    private static int W0;
    private static int W1;
    private static int X;
    private static int X0;
    private static int X1;
    private static int Y;
    private static int Y0;
    private static int Y1;
    private static int Z;
    private static int Z0;
    private static int Z1;
    private static int a0;
    private static int a1;
    private static int a2;
    private static int b0;
    private static int b1;
    private static int b2;
    private static int c;
    private static int c0;
    private static int c1;
    private static int c2;
    private static int d;
    private static int d0;
    private static int d1;
    private static int d2;
    private static int e;
    private static int e0;
    private static int e1;
    private static int e2;
    private static int f;
    private static int f0;
    private static int f1;
    private static int f2;
    private static int g;
    private static int g0;
    private static int g1;
    private static int g2;
    private static int h;
    private static int h0;
    private static int h1;
    private static int h2;
    private static int i;
    private static int i0;
    private static int i1;
    private static int i2;
    private static int j;
    private static int j0;
    private static int j1;
    private static int j2;
    private static int k;
    private static int k0;
    private static int k1;
    private static int k2;
    private static int l;
    private static int l0;
    private static int l1;
    private static int l2;
    private static int m;
    private static int m0;
    private static int m1;
    private static int m2;
    private static int n;
    private static int n0;
    private static int n1;
    private static int n2;
    private static int o;
    private static int o0;
    private static int o1;
    private static int o2;
    private static int p;
    private static int p0;
    private static int p1;
    private static int p2;
    private static int q;
    private static int q0;
    private static int q1;
    private static int q2;
    private static int r;
    private static int r0;
    private static int r1;
    private static int r2;
    private static int s;
    private static int s0;
    private static int s1;
    private static int s2;
    private static int t;
    private static int t0;
    private static int t1;
    private static int t2;
    private static int u;
    private static int u0;
    private static int u1;
    private static int u2;
    private static int v;
    private static int v0;
    private static int v1;
    private static int v2;
    private static int w;
    private static int w0;
    private static int w1;
    private static int w2;
    private static int x;
    private static int x0;
    private static int x1;
    private static int x2;
    private static int y;
    private static int y0;
    private static int y1;
    private static int y2;
    private static int z;
    private static int z0;
    private static int z1;
    private static int z2;
    public static final C5495Jo7 a = new C5495Jo7();
    private static int b = -1000;
    private static final List I2 = AbstractC10360bX0.p(new C24411ya3(7, 16), new C24411ya3(7, 17), new C24411ya3(6, 17), new C24411ya3(7, 18), new C24411ya3(6, 19), new C24411ya3(6, 19), new C24411ya3(6, 19), new C24411ya3(6, 19), new C24411ya3(6, 18), new C24411ya3(6, 17), new C24411ya3(6, 16), new C24411ya3(7, 16));
    public static final int J2 = 8;

    private C5495Jo7() {
    }

    public static final int F0(Context context, int i3) throws Resources.NotFoundException {
        AbstractC13042fc3.i(context, "context");
        String string = context.getResources().getString(i3);
        AbstractC13042fc3.h(string, "getString(...)");
        return Color.parseColor(string);
    }

    public static final void G2(Context context) {
        AbstractC13042fc3.i(context, "context");
        int i3 = C7183Qq.q(EnumC18608ow5.d).getInt("Theme_Pref", 1);
        b = i3;
        C5495Jo7 c5495Jo7 = a;
        int iZ0 = c5495Jo7.z0(i3);
        b = iZ0;
        c5495Jo7.L2(iZ0);
        c = F0(context, IA5.primary);
        d = F0(context, IA5.secondary);
        e = F0(context, IA5.secondary_2);
        f = F0(context, IA5.color3_2);
        g = F0(context, IA5.color4);
        h = F0(context, IA5.color6_2);
        i = F0(context, IA5.color6_3);
        j = F0(context, IA5.color7);
        k = F0(context, IA5.color8);
        l = F0(context, IA5.color9);
        m = F0(context, IA5.color12);
        n = F0(context, IA5.error);
        o = F0(context, IA5.a3);
        p = c5495Jo7.y0(F0(context, IA5.c1), 0);
        s = F0(context, IA5.appBarTitle);
        t = F0(context, IA5.appBarSubtitle);
        u = F0(context, IA5.appBarInputBackground);
        v = F0(context, IA5.appBarInputHint);
        w = F0(context, IA5.appBarInputText);
        x = F0(context, IA5.appBarInputIcon);
        y = F0(context, IA5.appBarInputIconDisable);
        z = F0(context, IA5.appBarButton);
        A = F0(context, IA5.popupBackground);
        B = F0(context, IA5.popupText);
        C = F0(context, IA5.background_1);
        D = F0(context, IA5.background_2);
        E = F0(context, IA5.background_3);
        F = F0(context, IA5.background_4);
        G = F0(context, IA5.background_5);
        H = F0(context, IA5.backgroundContentText);
        I = F0(context, IA5.backgroundContentIcon);
        q = F0(context, IA5.progressViewBgPlayList);
        r = F0(context, IA5.progressViewPlayList);
        J = F0(context, IA5.tabBarNavBarActiveObject);
        K = F0(context, IA5.tabBarNavBarActiveText);
        L = F0(context, IA5.tabBarNavBarNormalObject);
        M = F0(context, IA5.inputBackground);
        N = F0(context, IA5.inputBackgroundDisable);
        O = F0(context, IA5.inputBackgroundDisable2);
        P = F0(context, IA5.inputText);
        Q = F0(context, IA5.inputError);
        R = F0(context, IA5.inputHint);
        S = F0(context, IA5.n300);
        T = F0(context, IA5.inputIconActive);
        V = F0(context, IA5.buttonTextActive);
        U = F0(context, IA5.buttonBackground);
        W = F0(context, IA5.buttonBackgroundActive);
        X = F0(context, IA5.buttonContent);
        Y = F0(context, IA5.buttonContentActive);
        Z = F0(context, IA5.buttonContentDisable);
        a0 = F0(context, IA5.buttonBackgroundDisable);
        b0 = F0(context, IA5.buttonTextDisable);
        c0 = F0(context, IA5.shadow);
        d0 = F0(context, IA5.divider);
        e0 = F0(context, IA5.attachmentBackground);
        f0 = F0(context, IA5.attachmentFileBackground);
        g0 = F0(context, IA5.attachmentSwipe);
        h0 = F0(context, IA5.itemBackground);
        i0 = F0(context, IA5.itemBackgroundSecondary);
        j0 = F0(context, IA5.itemPinnedBackground);
        k0 = F0(context, IA5.itemTitle);
        l0 = F0(context, IA5.itemSubtitle);
        m0 = F0(context, IA5.itemDesc);
        n0 = F0(context, IA5.itemDescNew);
        o0 = F0(context, IA5.itemIcon);
        p0 = F0(context, IA5.itemIconActive);
        q0 = F0(context, IA5.itemDescActive);
        r0 = F0(context, IA5.itemDescActiveNew);
        s0 = F0(context, IA5.itemDescActiveSecondary);
        t0 = F0(context, IA5.itemDescAlert);
        u0 = F0(context, IA5.itemDescContent);
        v0 = F0(context, IA5.itemDivider);
        w0 = F0(context, IA5.itemDividerText);
        x0 = F0(context, IA5.itemButtonBackground);
        y0 = F0(context, IA5.itemButtonBackgroundRipple);
        z0 = F0(context, IA5.itemButtonIcon);
        A0 = F0(context, IA5.bankCardBackground);
        B0 = F0(context, IA5.privacyBarButtonTextAlert);
        C0 = F0(context, IA5.pinMessageTitle);
        D0 = F0(context, IA5.pinMessageSubtitle);
        E0 = F0(context, IA5.pinMessageIcon);
        F0 = F0(context, IA5.bubbleAdminState);
        G0 = F0(context, IA5.bubbleInDesc);
        H0 = F0(context, IA5.bubbleSelectedBackground);
        I0 = F0(context, IA5.bubbleTextActive);
        J0 = F0(context, IA5.bgDividerBubbles);
        K0 = F0(context, IA5.textDividerBubbles);
        L0 = F0(context, IA5.eventBarText);
        M0 = F0(context, IA5.eventBarIcon);
        N0 = F0(context, IA5.eventBarCallToAction);
        O0 = F0(context, IA5.marketBadgeBackground);
        P0 = F0(context, IA5.marketDisableItemBackground);
        Q0 = F0(context, IA5.marketDisableItemTitle);
        R0 = F0(context, IA5.pfm_tag_2);
        S0 = F0(context, IA5.pfm_tag_3);
        T0 = F0(context, IA5.pfm_tag_4);
        U0 = F0(context, IA5.pfm_tag_5);
        V0 = F0(context, IA5.pfm_tag_6);
        W0 = F0(context, IA5.pfm_tag_7);
        X0 = F0(context, IA5.pfm_tag_8);
        Y0 = F0(context, IA5.pfm_tag_9);
        Z0 = F0(context, IA5.pfm_tag_10);
        a1 = F0(context, IA5.pfm_tag_11);
        b1 = F0(context, IA5.pfm_tag_12);
        c1 = F0(context, IA5.pfm_tag_13);
        d1 = F0(context, IA5.pfm_tag_14);
        e1 = F0(context, IA5.pfm_tag_15);
        f1 = F0(context, IA5.pfm_tag_16);
        g1 = F0(context, IA5.pfm_tag_17);
        h1 = F0(context, IA5.pfm_tag_18);
        i1 = F0(context, IA5.pfm_tag_19);
        j1 = F0(context, IA5.pfm_tag_31);
        k1 = F0(context, IA5.pfm_tag_33);
        l1 = F0(context, IA5.pfm_tag_35);
        m1 = F0(context, IA5.pfm_tag_36);
        n1 = F0(context, IA5.pfm_withdraw_no_tag);
        o1 = F0(context, IA5.pfm_tag_20);
        p1 = F0(context, IA5.pfm_tag_21);
        q1 = F0(context, IA5.pfm_tag_22);
        r1 = F0(context, IA5.pfm_tag_23);
        s1 = F0(context, IA5.pfm_tag_24);
        t1 = F0(context, IA5.pfm_tag_25);
        u1 = F0(context, IA5.pfm_tag_26);
        v1 = F0(context, IA5.pfm_tag_27);
        w1 = F0(context, IA5.pfm_tag_28);
        x1 = F0(context, IA5.pfm_tag_29);
        y1 = F0(context, IA5.pfm_tag_30);
        z1 = F0(context, IA5.pfm_tag_32);
        A1 = F0(context, IA5.pfm_tag_34);
        B1 = F0(context, IA5.pfm_top_up_no_tag);
        D1 = F0(context, IA5.pfm_custom_tag_1);
        E1 = F0(context, IA5.pfm_custom_tag_2);
        F1 = F0(context, IA5.pfm_custom_tag_3);
        G1 = F0(context, IA5.pfm_custom_tag_4);
        H1 = F0(context, IA5.pfm_custom_tag_5);
        I1 = F0(context, IA5.webViewLoadingTitle);
        J1 = F0(context, IA5.webViewLoadingDescription);
        K1 = F0(context, IA5.webViewErrorTitle);
        L1 = F0(context, IA5.webViewErrorDescription);
        C1 = F0(context, IA5.c1);
        M1 = F0(context, IA5.c2);
        N1 = F0(context, IA5.c5);
        O1 = F0(context, IA5.c5_2);
        P1 = F0(context, IA5.c6);
        Q1 = F0(context, IA5.c7);
        R1 = F0(context, IA5.c8);
        S1 = F0(context, IA5.c9);
        T1 = F0(context, IA5.c10);
        U1 = F0(context, IA5.c11);
        V1 = F0(context, IA5.c12);
        W1 = F0(context, IA5.primary_light);
        X1 = F0(context, IA5.s1);
        Y1 = F0(context, IA5.s2);
        Z1 = F0(context, IA5.s3);
        a2 = F0(context, IA5.s4);
        b2 = F0(context, IA5.s5);
        c2 = F0(context, IA5.s6);
        d2 = F0(context, IA5.s7);
        e2 = F0(context, IA5.s9);
        f2 = F0(context, IA5.s10);
        g2 = F0(context, IA5.s11);
        h2 = F0(context, IA5.color_bg_0);
        i2 = F0(context, IA5.color_bg_1);
        j2 = F0(context, IA5.color_bg_2);
        k2 = F0(context, IA5.color_bg_3);
        l2 = F0(context, IA5.color_bg_4);
        m2 = F0(context, IA5.color_bg_5);
        n2 = F0(context, IA5.color_bg_6);
        o2 = F0(context, IA5.color_bg_7);
        p2 = F0(context, IA5.color_bg_8);
        q2 = F0(context, IA5.color_bg_9);
        r2 = F0(context, IA5.color_bg_10);
        s2 = F0(context, IA5.color_bg_11);
        t2 = F0(context, IA5.color_bg_12);
        u2 = F0(context, IA5.color_bg_13);
        v2 = F0(context, IA5.color_bg_14);
        w2 = F0(context, IA5.color_bg_15);
        x2 = F0(context, IA5.color_bg_16);
        y2 = F0(context, IA5.color_bg_21);
        z2 = F0(context, IA5.color_bg_22);
        A2 = F0(context, IA5.color_bg_23);
        B2 = F0(context, IA5.color_bg_24);
        C2 = F0(context, IA5.color_bg_25);
        D2 = F0(context, IA5.color_bg_26);
        E2 = F0(context, IA5.color_bg_27);
        F2 = F0(context, IA5.color_bg_28);
        G2 = F0(context, IA5.link_color);
        H2 = F0(context, IA5.colorPrimaryHover);
    }

    public static final int K2(int i3, Context context) {
        AbstractC13042fc3.i(context, "context");
        try {
            C5495Jo7 c5495Jo7 = a;
            int iZ0 = c5495Jo7.z0(i3);
            b = iZ0;
            c5495Jo7.L2(iZ0);
        } catch (Exception e3) {
            C19406qI3.b("ThemeColors", "setCorrectTheme: " + e3.getMessage());
        }
        return b;
    }

    private final void L2(int i3) {
        try {
            androidx.appcompat.app.b.N(i3);
        } catch (Exception e3) {
            C19406qI3.b("ThemeColors", "updateAppTheme: " + e3.getMessage());
        }
    }

    public static final int l1(Context context) {
        AbstractC13042fc3.i(context, "context");
        if (b == -1000) {
            G2(context);
        }
        return b;
    }

    public final int A() {
        return w2;
    }

    public final int A0() {
        return d0;
    }

    public final int A1() {
        return i1;
    }

    public final int A2() {
        return K0;
    }

    public final int B() {
        return x2;
    }

    public final int B0() {
        return n;
    }

    public final int B1() {
        return R0;
    }

    public final int B2() {
        return p;
    }

    public final int C() {
        return j2;
    }

    public final int C0() {
        return N0;
    }

    public final int C1() {
        return o1;
    }

    public final int C2() {
        return L1;
    }

    public final int D() {
        return y2;
    }

    public final int D0() {
        return M0;
    }

    public final int D1() {
        return p1;
    }

    public final int D2() {
        return K1;
    }

    public final int E() {
        return z2;
    }

    public final int E0() {
        return L0;
    }

    public final int E1() {
        return q1;
    }

    public final int E2() {
        return J1;
    }

    public final int F() {
        return A2;
    }

    public final int F1() {
        return r1;
    }

    public final int F2() {
        return I1;
    }

    public final int G() {
        return B2;
    }

    public final int G0() {
        return M;
    }

    public final int G1() {
        return s1;
    }

    public final int H() {
        return C2;
    }

    public final int H0() {
        return N;
    }

    public final int H1() {
        return t1;
    }

    public final boolean H2() {
        UiModeManager uiModeManager = (UiModeManager) AbstractC4043Dl1.l(C5721Ko.a.d(), UiModeManager.class);
        return uiModeManager != null && uiModeManager.getNightMode() == 2;
    }

    public final int I() {
        return D2;
    }

    public final int I0() {
        return O;
    }

    public final int I1() {
        return u1;
    }

    public final boolean I2() {
        Calendar calendar = Calendar.getInstance();
        int i3 = calendar.get(11);
        int i4 = calendar.get(2);
        List list = I2;
        C24411ya3 c24411ya3 = i4 < list.size() ? (C24411ya3) list.get(i4) : (C24411ya3) list.get(list.size() - 1);
        int iO = c24411ya3.o();
        boolean z3 = false;
        if (i3 <= c24411ya3.t() && iO <= i3) {
            z3 = true;
        }
        return !z3;
    }

    public final int J() {
        return E2;
    }

    public final int J0() {
        return Q;
    }

    public final int J1() {
        return v1;
    }

    public final boolean J2() {
        return b == 2;
    }

    public final int K() {
        return F2;
    }

    public final int K0() {
        return R;
    }

    public final int K1() {
        return w1;
    }

    public final int L() {
        return k2;
    }

    public final int L0() {
        return S;
    }

    public final int L1() {
        return x1;
    }

    public final int M() {
        return l2;
    }

    public final int M0() {
        return T;
    }

    public final int M1() {
        return S0;
    }

    public final int N() {
        return m2;
    }

    public final int N0() {
        return P;
    }

    public final int N1() {
        return y1;
    }

    public final int O() {
        return n2;
    }

    public final int O0() {
        return h0;
    }

    public final int O1() {
        return j1;
    }

    public final int P() {
        return o2;
    }

    public final int P0() {
        return i0;
    }

    public final int P1() {
        return z1;
    }

    public final int Q() {
        return p2;
    }

    public final int Q0() {
        return x0;
    }

    public final int Q1() {
        return k1;
    }

    public final int R() {
        return q2;
    }

    public final int R0() {
        return y0;
    }

    public final int R1() {
        return A1;
    }

    public final int S() {
        return J0;
    }

    public final int S0() {
        return z0;
    }

    public final int S1() {
        return l1;
    }

    public final int T() {
        return F0;
    }

    public final int T0() {
        return m0;
    }

    public final int T1() {
        return m1;
    }

    public final int U() {
        return G0;
    }

    public final int U0() {
        return q0;
    }

    public final int U1() {
        return T0;
    }

    public final int V() {
        return H0;
    }

    public final int V0() {
        return r0;
    }

    public final int V1() {
        return U0;
    }

    public final int W() {
        return I0;
    }

    public final int W0() {
        return s0;
    }

    public final int W1() {
        return V0;
    }

    public final int X() {
        return U;
    }

    public final int X0() {
        return t0;
    }

    public final int X1() {
        return W0;
    }

    public final int Y() {
        return W;
    }

    public final int Y0() {
        return u0;
    }

    public final int Y1() {
        return X0;
    }

    public final int Z() {
        return a0;
    }

    public final int Z0() {
        return n0;
    }

    public final int Z1() {
        return Y0;
    }

    public final int a() {
        return o;
    }

    public final int a0() {
        return X;
    }

    public final int a1() {
        return v0;
    }

    public final int a2() {
        return B1;
    }

    public final int b() {
        return z;
    }

    public final int b0() {
        return Y;
    }

    public final int b1() {
        return w0;
    }

    public final int b2() {
        return n1;
    }

    public final int c() {
        return u;
    }

    public final int c0() {
        return Z;
    }

    public final int c1() {
        return o0;
    }

    public final int c2() {
        return A;
    }

    public final int d() {
        return v;
    }

    public final int d0() {
        return V;
    }

    public final int d1() {
        return p0;
    }

    public final int d2() {
        return B;
    }

    public final int e() {
        return x;
    }

    public final int e0() {
        return b0;
    }

    public final int e1() {
        return j0;
    }

    public final int e2() {
        return c;
    }

    public final int f() {
        return y;
    }

    public final int f0() {
        return C1;
    }

    public final int f1() {
        return l0;
    }

    public final int f2() {
        return W1;
    }

    public final int g() {
        return w;
    }

    public final int g0() {
        return T1;
    }

    public final int g1() {
        return k0;
    }

    public final int g2() {
        return B0;
    }

    public final int h() {
        return t;
    }

    public final int h0() {
        return U1;
    }

    public final int h1() {
        return G2;
    }

    public final int h2() {
        return q;
    }

    public final int i() {
        return s;
    }

    public final int i0() {
        return M1;
    }

    public final int i1() {
        return O0;
    }

    public final int i2() {
        return r;
    }

    public final int j() {
        return e0;
    }

    public final int j0() {
        return N1;
    }

    public final int j1() {
        return P0;
    }

    public final int j2() {
        return X1;
    }

    public final int k() {
        return f0;
    }

    public final int k0() {
        return O1;
    }

    public final int k1() {
        return Q0;
    }

    public final int k2() {
        return f2;
    }

    public final int l() {
        return g0;
    }

    public final int l0() {
        return P1;
    }

    public final int l2() {
        return g2;
    }

    public final int m() {
        return H;
    }

    public final int m0() {
        return Q1;
    }

    public final int m1() {
        return D1;
    }

    public final int m2() {
        return Y1;
    }

    public final int n() {
        return C;
    }

    public final int n0() {
        return R1;
    }

    public final int n1() {
        return E1;
    }

    public final int n2() {
        return Z1;
    }

    public final int o() {
        return D;
    }

    public final int o0() {
        return S1;
    }

    public final int o1() {
        return F1;
    }

    public final int o2() {
        return a2;
    }

    public final int p() {
        return E;
    }

    public final int p0() {
        return m;
    }

    public final int p1() {
        return G1;
    }

    public final int p2() {
        return b2;
    }

    public final int q() {
        return F;
    }

    public final int q0() {
        return f;
    }

    public final int q1() {
        return H1;
    }

    public final int q2() {
        return c2;
    }

    public final int r() {
        return G;
    }

    public final int r0() {
        return g;
    }

    public final int r1() {
        return Z0;
    }

    public final int r2() {
        return d2;
    }

    public final int s() {
        return A0;
    }

    public final int s0() {
        return h;
    }

    public final int s1() {
        return a1;
    }

    public final int s2() {
        return e2;
    }

    public final int t() {
        return h2;
    }

    public final int t0() {
        return i;
    }

    public final int t1() {
        return b1;
    }

    public final int t2() {
        return d;
    }

    public final int u() {
        return i2;
    }

    public final int u0() {
        return j;
    }

    public final int u1() {
        return c1;
    }

    public final int u2() {
        return e;
    }

    public final int v() {
        return r2;
    }

    public final int v0() {
        return k;
    }

    public final int v1() {
        return d1;
    }

    public final int v2() {
        return c0;
    }

    public final int w() {
        return s2;
    }

    public final int w0() {
        return l;
    }

    public final int w1() {
        return e1;
    }

    public final String w2(int i3) {
        String str = String.format("#%06X", Integer.valueOf(i3 & 16777215));
        AbstractC13042fc3.h(str, "format(...)");
        return str;
    }

    public final int x() {
        return t2;
    }

    public final int x0() {
        return H2;
    }

    public final int x1() {
        return f1;
    }

    public final int x2() {
        return J;
    }

    public final int y() {
        return u2;
    }

    public final int y0(int i3, int i4) {
        return QY0.k(i3, (int) (i4 * 0.01f * 255));
    }

    public final int y1() {
        return g1;
    }

    public final int y2() {
        return K;
    }

    public final int z() {
        return v2;
    }

    public final int z0(int i3) {
        try {
            boolean zI2 = I2();
            boolean zH2 = H2();
            if (i3 != 0 || !zI2) {
                if (i3 != 0 || zI2) {
                    if (i3 != -1 || !zH2) {
                        if (i3 != -1 || zH2) {
                            return i3;
                        }
                    }
                }
                return 1;
            }
            return 2;
        } catch (Exception e3) {
            C19406qI3.b("ThemeColors", "getCorrectTheme: " + e3.getMessage());
            return i3;
        }
    }

    public final int z1() {
        return h1;
    }

    public final int z2() {
        return L;
    }
}
