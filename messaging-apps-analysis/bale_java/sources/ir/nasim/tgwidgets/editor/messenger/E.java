package ir.nasim.tgwidgets.editor.messenger;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import ir.nasim.AbstractC14047hG;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8814Xl0;
import ir.nasim.RunnableC12207eD4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes7.dex */
public class E {
    public static final int A;
    public static final int A0;
    public static final int A1;
    public static final int A2;
    public static final int A3;
    public static final int B;
    public static final int B0;
    public static final int B1;
    public static final int B2;
    public static final int B3;
    public static final int C;
    public static final int C0;
    public static final int C1;
    public static final int C2;
    public static final int C3;
    public static final int D;
    public static final int D0;
    public static final int D1;
    public static final int D2;
    public static final int D3;
    public static final int E;
    public static final int E0;
    public static final int E1;
    public static final int E2;
    public static final int E3;
    public static final int F;
    public static final int F0;
    public static final int F1;
    public static final int F2;
    public static final int F3;
    public static final int G;
    public static final int G0;
    public static final int G1;
    public static final int G2;
    public static final int G3;
    public static final int H;
    public static final int H0;
    public static final int H1;
    public static final int H2;
    public static final int H3;
    public static final int I;
    public static final int I0;
    public static final int I1;
    public static final int I2;
    public static final int I3;
    public static final int J;
    public static final int J0;
    public static final int J1;
    public static final int J2;
    public static final int J3;
    public static final int K;
    public static final int K0;
    public static final int K1;
    public static final int K2;
    public static final int K3;
    public static final int L;
    public static final int L0;
    public static final int L1;
    public static final int L2;
    public static final int L3;
    public static final int M;
    public static final int M0;
    public static final int M1;
    public static final int M2;
    public static final int M3;
    public static final int N;
    public static final int N0;
    public static final int N1;
    public static final int N2;
    public static final int N3;
    public static final int O;
    public static final int O0;
    public static final int O1;
    public static final int O2;
    public static final int O3;
    public static final int P;
    public static final int P0;
    public static final int P1;
    public static final int P2;
    public static int P3 = 0;
    public static final int Q;
    public static final int Q0;
    public static final int Q1;
    public static final int Q2;
    public static int Q3 = 0;
    public static final int R;
    public static final int R0;
    public static final int R1;
    public static final int R2;
    public static int R3 = 0;
    public static final int S;
    public static final int S0;
    public static final int S1;
    public static final int S2;
    public static int S3 = 0;
    public static final int T;
    public static final int T0;
    public static final int T1;
    public static final int T2;
    public static int T3 = 0;
    public static final int U;
    public static final int U0;
    public static final int U1;
    public static final int U2;
    public static int U3 = 0;
    public static final int V;
    public static final int V0;
    public static final int V1;
    public static final int V2;
    public static int V3 = 0;
    public static final int W;
    public static final int W0;
    public static final int W1;
    public static final int W2;
    public static int W3 = 0;
    public static final int X;
    public static final int X0;
    public static final int X1;
    public static final int X2;
    public static int X3 = 0;
    public static final int Y;
    public static final int Y0;
    public static final int Y1;
    public static final int Y2;
    public static final int Y3;
    public static final int Z;
    public static final int Z0;
    public static final int Z1;
    public static final int Z2;
    public static final int Z3;
    public static final int a0;
    public static final int a1;
    public static final int a2;
    public static final int a3;
    public static final int a4;
    public static final int b0;
    public static final int b1;
    public static final int b2;
    public static final int b3;
    public static boolean b4 = false;
    public static final int c0;
    public static final int c1;
    public static final int c2;
    public static final int c3;
    private static volatile E[] c4 = null;
    public static final int d0;
    public static final int d1;
    public static final int d2;
    public static final int d3;
    private static volatile E d4 = null;
    public static final int e0;
    public static final int e1;
    public static final int e2;
    public static final int e3;
    public static final int f0;
    public static final int f1;
    public static final int f2;
    public static final int f3;
    public static final int g0;
    public static final int g1;
    public static final int g2;
    public static final int g3;
    public static final int h0;
    public static final int h1;
    public static final int h2;
    public static final int h3;
    public static final int i0;
    public static final int i1;
    public static final int i2;
    public static final int i3;
    public static final int j0;
    public static final int j1;
    public static final int j2;
    public static final int j3;
    public static final int k0;
    public static final int k1;
    public static final int k2;
    public static final int k3;
    public static final int l0;
    public static final int l1;
    public static final int l2;
    public static final int l3;
    public static final int m0;
    public static final int m1;
    public static final int m2;
    public static final int m3;
    public static final int n0;
    public static final int n1;
    public static final int n2;
    public static final int n3;
    public static final int o0;
    public static final int o1;
    public static final int o2;
    public static final int o3;
    public static final int p0;
    public static final int p1;
    public static final int p2;
    public static final int p3;
    public static final int q0;
    public static final int q1;
    public static final int q2;
    public static final int q3;
    private static int r = 0;
    public static final int r0;
    public static final int r1;
    public static final int r2;
    public static final int r3;
    public static final int s = 1;
    public static final int s0;
    public static final int s1;
    public static final int s2;
    public static final int s3;
    public static final int t;
    public static final int t0;
    public static final int t1;
    public static final int t2;
    public static final int t3;
    public static final int u;
    public static final int u0;
    public static final int u1;
    public static final int u2;
    public static final int u3;
    public static final int v;
    public static final int v0;
    public static final int v1;
    public static final int v2;
    public static final int v3;
    public static final int w;
    public static final int w0;
    public static final int w1;
    public static final int w2;
    public static final int w3;
    public static final int x;
    public static final int x0;
    public static final int x1;
    public static final int x2;
    public static final int x3;
    public static final int y;
    public static final int y0;
    public static final int y1;
    public static final int y2;
    public static final int y3;
    public static final int z;
    public static final int z0;
    public static final int z1;
    public static final int z2;
    public static final int z3;
    private Runnable i;
    private int k;
    private int o;
    private int p;
    private SparseArray a = new SparseArray();
    private SparseArray b = new SparseArray();
    private SparseArray c = new SparseArray();
    private ArrayList d = new ArrayList(10);
    private ArrayList e = new ArrayList(10);
    private ArrayList f = new ArrayList(10);
    private ArrayList g = new ArrayList(10);
    private ArrayList h = new ArrayList(10);
    private int j = 0;
    private int l = 1;
    HashSet m = new HashSet();
    private final SparseArray n = new SparseArray();
    SparseArray q = new SparseArray();

    class a implements View.OnAttachStateChangeListener {
        final /* synthetic */ d a;

        a(d dVar) {
            this.a = dVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            E.j().e(this.a, E.K2);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            E.j().u(this.a, E.K2);
        }
    }

    private static class b {
        int[] a;
        final long b;

        private b() {
            this.b = SystemClock.elapsedRealtime();
        }
    }

    private static class c {
        private int a;
        private Object[] b;

        private c(int i, Object[] objArr) {
            this.a = i;
            this.b = objArr;
        }
    }

    public interface d {
        void t(int i, int i2, Object... objArr);
    }

    private class e extends ArrayList {
        HashSet a;

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(Object obj) {
            if (this.a.add(obj)) {
                return super.add(obj);
            }
            return false;
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean addAll(Collection collection) {
            Iterator it = collection.iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (add(it.next())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.a.clear();
            super.clear();
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return this.a.contains(obj);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public Object remove(int i) {
            Object objRemove = super.remove(i);
            if (objRemove != null) {
                this.a.remove(objRemove);
            }
            return objRemove;
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        private e() {
            this.a = new HashSet();
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public void add(int i, Object obj) {
            if (this.a.add(obj)) {
                super.add(i, obj);
            }
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public boolean addAll(int i, Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean remove(Object obj) {
            if (this.a.remove(obj)) {
                return super.remove(obj);
            }
            return false;
        }
    }

    static {
        int i = 1 + 1;
        t = i;
        u = i + 1;
        v = i + 2;
        w = i + 3;
        x = i + 4;
        y = i + 5;
        z = i + 6;
        A = i + 7;
        B = i + 8;
        C = i + 9;
        D = i + 10;
        E = i + 11;
        F = i + 12;
        G = i + 13;
        H = i + 14;
        I = i + 15;
        J = i + 16;
        K = i + 17;
        L = i + 18;
        M = i + 19;
        N = i + 20;
        O = i + 21;
        P = i + 22;
        Q = i + 23;
        R = i + 24;
        S = i + 25;
        T = i + 26;
        U = i + 27;
        V = i + 28;
        W = i + 29;
        X = i + 30;
        Y = i + 31;
        Z = i + 32;
        a0 = i + 33;
        b0 = i + 34;
        c0 = i + 35;
        d0 = i + 36;
        e0 = i + 37;
        f0 = i + 38;
        g0 = i + 39;
        h0 = i + 40;
        i0 = i + 41;
        j0 = i + 42;
        k0 = i + 43;
        l0 = i + 44;
        m0 = i + 45;
        n0 = i + 46;
        o0 = i + 47;
        p0 = i + 48;
        q0 = i + 49;
        r0 = i + 50;
        s0 = i + 51;
        t0 = i + 52;
        u0 = i + 53;
        v0 = i + 54;
        w0 = i + 55;
        x0 = i + 56;
        y0 = i + 57;
        z0 = i + 58;
        A0 = i + 59;
        B0 = i + 60;
        C0 = i + 61;
        D0 = i + 62;
        E0 = i + 63;
        F0 = i + 64;
        G0 = i + 65;
        H0 = i + 66;
        I0 = i + 67;
        J0 = i + 68;
        K0 = i + 69;
        L0 = i + 70;
        M0 = i + 71;
        N0 = i + 72;
        O0 = i + 73;
        P0 = i + 74;
        Q0 = i + 75;
        R0 = i + 76;
        S0 = i + 77;
        T0 = i + 78;
        U0 = i + 79;
        V0 = i + 80;
        W0 = i + 81;
        X0 = i + 82;
        Y0 = i + 83;
        Z0 = i + 84;
        a1 = i + 85;
        b1 = i + 86;
        c1 = i + 87;
        d1 = i + 88;
        e1 = i + 89;
        f1 = i + 90;
        g1 = i + 91;
        h1 = i + 92;
        i1 = i + 93;
        j1 = i + 94;
        k1 = i + 95;
        l1 = i + 96;
        m1 = i + 97;
        n1 = i + 98;
        o1 = i + 99;
        p1 = i + 100;
        q1 = i + 101;
        r1 = i + 102;
        s1 = i + 103;
        t1 = i + 104;
        int i4 = i + Type.L64;
        u1 = i + 105;
        v1 = i4;
        int i5 = i + Type.EUI48;
        w1 = i + 107;
        x1 = i5;
        y1 = i + 109;
        int i6 = i + WKSRecord.Service.SUNRPC;
        z1 = i + 110;
        int i7 = i + SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER;
        A1 = i6;
        B1 = i7;
        C1 = i + 113;
        D1 = i + 114;
        E1 = i + 115;
        int i8 = i + WKSRecord.Service.UUCP_PATH;
        F1 = i + 116;
        int i9 = i + SetRpcStruct$ComposedRpc.LOAD_HISTORY_FIELD_NUMBER;
        G1 = i8;
        H1 = i9;
        int i10 = i + SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER;
        I1 = i + 119;
        int i11 = i + WKSRecord.Service.ERPC;
        J1 = i10;
        K1 = i11;
        L1 = i + 122;
        M1 = i + 123;
        N1 = i + 124;
        O1 = i + 125;
        P1 = i + 126;
        Q1 = i + 127;
        R1 = i + 128;
        S1 = i + 129;
        T1 = i + 130;
        int i12 = i + WKSRecord.Service.CISCO_SYS;
        U1 = i + 131;
        int i13 = i + WKSRecord.Service.STATSRV;
        V1 = i12;
        W1 = i13;
        X1 = i + 134;
        Y1 = i + 135;
        Z1 = i + 136;
        int i14 = i + WKSRecord.Service.NETBIOS_DGM;
        a2 = i + 137;
        int i15 = i + WKSRecord.Service.NETBIOS_SSN;
        b2 = i14;
        int i16 = i + WKSRecord.Service.EMFIS_DATA;
        c2 = i15;
        int i17 = i + WKSRecord.Service.EMFIS_CNTL;
        d2 = i16;
        int i18 = i + WKSRecord.Service.BL_IDM;
        e2 = i17;
        int i19 = i + SetRpcStruct$ComposedRpc.GET_NASIM_FILE_UPLOAD_URL_FIELD_NUMBER;
        f2 = i18;
        int i20 = i + SetRpcStruct$ComposedRpc.EDIT_MY_TIME_ZONE_FIELD_NUMBER;
        g2 = i19;
        int i21 = i + SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER;
        h2 = i20;
        int i22 = i + SetRpcStruct$ComposedRpc.RESPONSE_GET_USER_CONTEXT_FIELD_NUMBER;
        i2 = i21;
        j2 = i22;
        k2 = i + 147;
        l2 = i + 148;
        m2 = i + 149;
        n2 = i + 150;
        o2 = i + 151;
        int i23 = i + SetRpcStruct$ComposedRpc.GET_GROUP_STATE_FIELD_NUMBER;
        p2 = i + 152;
        q2 = i23;
        r2 = i + 154;
        s2 = i + 155;
        int i24 = i + SetRpcStruct$ComposedRpc.RESPONSE_GET_NASIM_FILE_UPLOAD_URL_FIELD_NUMBER;
        t2 = i + 156;
        u2 = i24;
        v2 = i + 158;
        w2 = i + 159;
        int i25 = i + SetUpdatesStruct$ComposedUpdates.OWN_STICKERS_CHANGED_FIELD_NUMBER;
        x2 = i + 160;
        int i26 = i + SetUpdatesStruct$ComposedUpdates.MESSAGE_CONTENT_CHANGED_FIELD_NUMBER;
        y2 = i25;
        int i27 = i + SetUpdatesStruct$ComposedUpdates.MESSAGE_DATE_CHANGED_FIELD_NUMBER;
        z2 = i26;
        int i28 = i + SetUpdatesStruct$ComposedUpdates.STICKER_COLLECTIONS_CHANGED_FIELD_NUMBER;
        A2 = i27;
        B2 = i28;
        C2 = i + 165;
        D2 = i + 166;
        E2 = i + 167;
        int i29 = i + SetUpdatesStruct$ComposedUpdates.MESSAGE_QUOTED_CHANGED_FIELD_NUMBER;
        F2 = i + 168;
        G2 = i29;
        H2 = i + 170;
        I2 = i + 171;
        J2 = i + 172;
        K2 = i + 173;
        L2 = i + 174;
        M2 = i + 175;
        int i30 = i + SetRpcStruct$ComposedRpc.GET_GROUP_INVITE_URL_FIELD_NUMBER;
        N2 = i + 176;
        int i31 = i + SetRpcStruct$ComposedRpc.RESPONSE_INVITE_URL_FIELD_NUMBER;
        O2 = i30;
        int i32 = i + SetRpcStruct$ComposedRpc.REVOKE_INVITE_URL_FIELD_NUMBER;
        P2 = i31;
        int i33 = i + SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER;
        Q2 = i32;
        int i34 = i + SetRpcStruct$ComposedRpc.RESPONSE_JOIN_GROUP_FIELD_NUMBER;
        R2 = i33;
        S2 = i34;
        T2 = i + 182;
        U2 = i + 183;
        V2 = i + 184;
        W2 = i + 185;
        int i35 = i + SetRpcStruct$ComposedRpc.GET_GROUP_DIFFERENCE_FIELD_NUMBER;
        X2 = i + 186;
        Y2 = i35;
        int i36 = i + SetRpcStruct$ComposedRpc.VALIDATE_CODE_FIELD_NUMBER;
        Z2 = i + 188;
        int i37 = i + SetRpcStruct$ComposedRpc.SIGN_UP_FIELD_NUMBER;
        a3 = i36;
        int i38 = i + SetRpcStruct$ComposedRpc.START_PHONE_AUTH_FIELD_NUMBER;
        b3 = i37;
        c3 = i38;
        int i39 = i + SetRpcStruct$ComposedRpc.RESPONSE_START_PHONE_AUTH_FIELD_NUMBER;
        d3 = i + 192;
        e3 = i39;
        f3 = i + 194;
        g3 = i + 195;
        h3 = i + 196;
        i3 = i + 197;
        j3 = i + 198;
        k3 = i + 199;
        l3 = i + 200;
        m3 = i + 201;
        n3 = i + 202;
        int i40 = i + SetRpcStruct$ComposedRpc.RESPONSE_GET_GROUP_DIFFERENCE_FIELD_NUMBER;
        o3 = i + 203;
        int i41 = i + SetRpcStruct$ComposedRpc.EDIT_NICK_NAME_FIELD_NUMBER;
        p3 = i40;
        int i42 = i + SetRpcStruct$ComposedRpc.CHECK_NICK_NAME_FIELD_NUMBER;
        q3 = i41;
        r3 = i42;
        s3 = i + 207;
        t3 = i + 208;
        u3 = i + 209;
        v3 = i + 210;
        w3 = i + 211;
        x3 = i + 212;
        int i43 = i + SetUpdatesStruct$ComposedUpdates.GROUP_ABOUT_CHANGED_OBSOLETE_FIELD_NUMBER;
        y3 = i + 213;
        z3 = i43;
        A3 = i + 215;
        B3 = i + 216;
        C3 = i + 217;
        D3 = i + 218;
        int i44 = i + SetRpcStruct$ComposedRpc.MESSAGE_REMOVE_REACTION_FIELD_NUMBER;
        E3 = i + 219;
        F3 = i44;
        G3 = i + 221;
        H3 = i + 222;
        I3 = i + 223;
        J3 = i + 224;
        K3 = i + 225;
        int i45 = i + SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER;
        L3 = i + 226;
        int i46 = i + SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_REMOVED_FIELD_NUMBER;
        M3 = i45;
        int i47 = i + SetRpcStruct$ComposedRpc.NOTIFY_ABOUT_DEVICE_INFO_FIELD_NUMBER;
        N3 = i46;
        int i48 = i + SetRpcStruct$ComposedRpc.CREATE_GROUP_FIELD_NUMBER;
        O3 = i47;
        P3 = i48;
        Q3 = i + 231;
        int i49 = i + SetRpcStruct$ComposedRpc.SEARCH_PEER_FIELD_NUMBER;
        R3 = i + 232;
        int i50 = i + SetRpcStruct$ComposedRpc.RESPONSE_SEARCH_PEER_FIELD_NUMBER;
        S3 = i49;
        int i51 = i + SetRpcStruct$ComposedRpc.RESPONSE_DIALOGS_ORDER_FIELD_NUMBER;
        T3 = i50;
        U3 = i51;
        V3 = i + 236;
        int i52 = i + SetRpcStruct$ComposedRpc.LOAD_OWN_STICKERS_FIELD_NUMBER;
        W3 = i + 237;
        int i53 = i + SetRpcStruct$ComposedRpc.RESPONSE_LOAD_OWN_STICKERS_FIELD_NUMBER;
        X3 = i52;
        int i54 = i + SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER;
        Y3 = i53;
        Z3 = i54;
        r = i + 242;
        a4 = i + 241;
        c4 = new E[1];
    }

    public E(int i) {
        this.o = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        ArrayList arrayList = null;
        this.i = null;
        if (this.n.size() == 0) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jMin = Long.MAX_VALUE;
        for (int i = 0; i < this.n.size(); i++) {
            long j = ((b) this.n.valueAt(i)).b;
            if (jElapsedRealtime - j > 1000) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(Integer.valueOf(this.n.keyAt(i)));
            } else {
                jMin = Math.min(j, jMin);
            }
        }
        if (arrayList != null) {
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                q(((Integer) arrayList.get(i4)).intValue());
            }
        }
        if (jMin != Long.MAX_VALUE) {
            AbstractC21455b.n1(new Runnable() { // from class: ir.nasim.fD4
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.m();
                }
            }, Math.max(17L, 5017 - (jElapsedRealtime - jMin)));
        }
    }

    private ArrayList g(int i) {
        return (i == O2 || i == d1 || i == e1) ? new e() : new ArrayList();
    }

    public static E j() {
        E e4 = d4;
        if (e4 == null) {
            synchronized (E.class) {
                try {
                    e4 = d4;
                    if (e4 == null) {
                        e4 = new E(-1);
                        d4 = e4;
                    }
                } finally {
                }
            }
        }
        return e4;
    }

    public static E k(int i) {
        E e4 = c4[i];
        if (e4 == null) {
            synchronized (E.class) {
                try {
                    e4 = c4[i];
                    if (e4 == null) {
                        E[] eArr = c4;
                        E e5 = new E(i);
                        eArr[i] = e5;
                        e4 = e5;
                    }
                } finally {
                }
            }
        }
        return e4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        this.i = new RunnableC12207eD4(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(View view, int i, int i4, Object[] objArr) {
        if (i == K2 && view != null && view.isAttachedToWindow()) {
            view.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(int i, Object[] objArr, int i4) {
        t(i, false, objArr);
        this.q.remove(i4);
    }

    public static void p(final View view) {
        if (view == null) {
            return;
        }
        view.addOnAttachStateChangeListener(new a(new d() { // from class: ir.nasim.dD4
            @Override // ir.nasim.tgwidgets.editor.messenger.E.d
            public final void t(int i, int i4, Object[] objArr) {
                ir.nasim.tgwidgets.editor.messenger.E.n(view, i, i4, objArr);
            }
        }));
    }

    private void r(final int i, final Object[] objArr) {
        final int iHashCode = (Arrays.hashCode(objArr) << 16) + i;
        if (this.q.indexOfKey(iHashCode) >= 0) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: ir.nasim.cD4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.o(i, objArr, iHashCode);
            }
        };
        this.q.put(iHashCode, runnable);
        AbstractC21455b.n1(runnable, 250L);
    }

    private boolean y(int i, Object[] objArr) {
        return i == t;
    }

    public void e(d dVar, int i) {
        if (AbstractC8814Xl0.a && Thread.currentThread() != AbstractC14047hG.b.getLooper().getThread()) {
            throw new RuntimeException("addObserver allowed only from MAIN thread");
        }
        if (this.j != 0) {
            ArrayList arrayList = (ArrayList) this.c.get(i);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.c.put(i, arrayList);
            }
            arrayList.add(dVar);
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.a.get(i);
        if (arrayList2 == null) {
            SparseArray sparseArray = this.a;
            ArrayList arrayListG = g(i);
            sparseArray.put(i, arrayListG);
            arrayList2 = arrayListG;
        }
        if (arrayList2.contains(dVar)) {
            return;
        }
        arrayList2.add(dVar);
        if (!AbstractC8814Xl0.a || b4 || arrayList2.size() <= 1000) {
            return;
        }
        b4 = true;
        AbstractC6403Nl2.e(new RuntimeException("Total observers more than 1000, need check for memory leak. " + i), true);
    }

    public void h(Runnable runnable) {
        if (l()) {
            this.e.add(runnable);
        } else {
            runnable.run();
        }
    }

    public int i() {
        return this.p;
    }

    public boolean l() {
        return this.k > 0;
    }

    public void q(int i) {
        b bVar = (b) this.n.get(i);
        this.n.delete(i);
        if (bVar != null) {
            this.k--;
            if (!this.m.isEmpty()) {
                this.m.remove(Integer.valueOf(i));
                if (this.m.isEmpty()) {
                    j().s(e1, 512);
                }
            }
            if (this.k == 0) {
                v();
            }
        }
        if (this.i == null || this.n.size() != 0) {
            return;
        }
        AbstractC21455b.t(this.i);
        this.i = null;
    }

    public void s(int i, Object... objArr) {
        boolean z4 = i == e1 || i == d1 || i == O2 || i == v || i == L2;
        ArrayList arrayList = null;
        if (!z4 && this.n.size() > 0) {
            int size = this.n.size();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            int i4 = 0;
            for (int i5 = 0; i5 < this.n.size(); i5++) {
                b bVar = (b) this.n.valueAt(i5);
                if (jElapsedRealtime - bVar.b > 5017) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(Integer.valueOf(this.n.keyAt(i5)));
                }
                int[] iArr = bVar.a;
                if (iArr == null) {
                    break;
                }
                int i6 = 0;
                while (true) {
                    if (i6 >= iArr.length) {
                        break;
                    }
                    if (iArr[i6] == i) {
                        i4++;
                        break;
                    }
                    i6++;
                }
            }
            z4 = size == i4;
        }
        if (i == e1) {
            this.p = (~((Integer) objArr[0]).intValue()) & this.p;
        } else if (i == d1) {
            this.p = ((Integer) objArr[0]).intValue() | this.p;
        }
        if (y(i, objArr) && AbstractC8814Xl0.a) {
            r(i, objArr);
        } else {
            t(i, z4, objArr);
        }
        if (arrayList != null) {
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                q(((Integer) arrayList.get(i7)).intValue());
            }
        }
    }

    public void t(int i, boolean z4, Object... objArr) {
        if (AbstractC8814Xl0.a && Thread.currentThread() != AbstractC14047hG.b.getLooper().getThread()) {
            throw new RuntimeException("postNotificationName allowed only from MAIN thread");
        }
        if (!z4 && l()) {
            this.d.add(new c(i, objArr));
            return;
        }
        if (!this.h.isEmpty() && this.h.size() > 0) {
            AbstractC18350oW3.a(this.h.get(0));
            throw null;
        }
        this.j++;
        ArrayList arrayList = (ArrayList) this.a.get(i);
        if (arrayList != null && !arrayList.isEmpty()) {
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                ((d) arrayList.get(i4)).t(i, this.o, objArr);
            }
        }
        int i5 = this.j - 1;
        this.j = i5;
        if (i5 == 0) {
            if (this.b.size() != 0) {
                for (int i6 = 0; i6 < this.b.size(); i6++) {
                    int iKeyAt = this.b.keyAt(i6);
                    ArrayList arrayList2 = (ArrayList) this.b.get(iKeyAt);
                    for (int i7 = 0; i7 < arrayList2.size(); i7++) {
                        u((d) arrayList2.get(i7), iKeyAt);
                    }
                }
                this.b.clear();
            }
            if (this.c.size() != 0) {
                for (int i8 = 0; i8 < this.c.size(); i8++) {
                    int iKeyAt2 = this.c.keyAt(i8);
                    ArrayList arrayList3 = (ArrayList) this.c.get(iKeyAt2);
                    for (int i9 = 0; i9 < arrayList3.size(); i9++) {
                        e((d) arrayList3.get(i9), iKeyAt2);
                    }
                }
                this.c.clear();
            }
        }
    }

    public void u(d dVar, int i) {
        if (AbstractC8814Xl0.a && Thread.currentThread() != AbstractC14047hG.b.getLooper().getThread()) {
            throw new RuntimeException("removeObserver allowed only from MAIN thread");
        }
        if (this.j == 0) {
            ArrayList arrayList = (ArrayList) this.a.get(i);
            if (arrayList != null) {
                arrayList.remove(dVar);
                return;
            }
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.b.get(i);
        if (arrayList2 == null) {
            arrayList2 = new ArrayList();
            this.b.put(i, arrayList2);
        }
        arrayList2.add(dVar);
    }

    public void v() {
        if (!this.d.isEmpty()) {
            this.g.clear();
            this.g.addAll(this.d);
            this.d.clear();
            for (int i = 0; i < this.g.size(); i++) {
                c cVar = (c) this.g.get(i);
                t(cVar.a, true, cVar.b);
            }
            this.g.clear();
        }
        if (this.e.isEmpty()) {
            return;
        }
        this.f.clear();
        this.f.addAll(this.e);
        this.e.clear();
        for (int i4 = 0; i4 < this.f.size(); i4++) {
            AbstractC21455b.m1((Runnable) this.f.get(i4));
        }
        this.f.clear();
    }

    public int w(int i, int[] iArr) {
        return x(i, iArr, true);
    }

    public int x(int i, int[] iArr, boolean z4) {
        q(i);
        if (this.m.isEmpty() && z4) {
            j().s(d1, 512);
        }
        this.k++;
        int i4 = this.l + 1;
        this.l = i4;
        if (z4) {
            this.m.add(Integer.valueOf(i4));
        }
        b bVar = new b();
        bVar.a = iArr;
        this.n.put(this.l, bVar);
        if (this.i == null) {
            RunnableC12207eD4 runnableC12207eD4 = new RunnableC12207eD4(this);
            this.i = runnableC12207eD4;
            AbstractC21455b.n1(runnableC12207eD4, 5017L);
        }
        return this.l;
    }
}
