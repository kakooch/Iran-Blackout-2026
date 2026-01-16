package ir.nasim.tgwidgets.editor.ui.ActionBar;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Base64;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.StateSet;
import ir.nasim.AbstractC14047hG;
import ir.nasim.AbstractC18470oi7;
import ir.nasim.AbstractC19363qD5;
import ir.nasim.AbstractC22000uV3;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.AbstractC5261Io7;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8662Wx6;
import ir.nasim.AbstractC8814Xl0;
import ir.nasim.AbstractC9075Yj4;
import ir.nasim.C10743c74;
import ir.nasim.C13010fZ0;
import ir.nasim.C17561nA3;
import ir.nasim.C18707p67;
import ir.nasim.C22477vI7;
import ir.nasim.C23394wq6;
import ir.nasim.C4278El2;
import ir.nasim.C6857Pg7;
import ir.nasim.IA5;
import ir.nasim.JQ5;
import ir.nasim.QY0;
import ir.nasim.RunnableC23375wo7;
import ir.nasim.RunnableC23965xo7;
import ir.nasim.S97;
import ir.nasim.Z05;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.C;
import ir.nasim.tgwidgets.editor.messenger.E;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.tgnet.ConnectionsManager;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.RLottieDrawable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public abstract class m {
    public static ArrayList A = null;
    public static Drawable A0 = null;
    public static TextPaint A1 = null;
    public static Drawable A2 = null;
    public static final int A4;
    public static final int A5;
    public static final int A6;
    public static final int A7;
    public static final int A8;
    public static final int A9;
    public static final int Aa;
    public static final int Ab;
    public static final int Ac;
    public static final int Ad;
    public static final int Ae;
    public static final int Af;
    public static final int Ag;
    public static final int Ah;
    private static final ArrayList B;
    public static Drawable B0 = null;
    public static TextPaint[] B1 = null;
    public static Drawable B2 = null;
    public static final int B4;
    public static final int B5;
    public static final int B6;
    public static final int B7;
    public static final int B8;
    public static final int B9;
    public static final int Ba;
    public static final int Bb;
    public static final int Bc;
    public static final int Bd;
    public static final int Be;
    public static final int Bf;
    public static final int Bg;
    public static final int Bh;
    private static final HashMap C;
    public static Drawable C0 = null;
    public static TextPaint C1 = null;
    public static Drawable C2 = null;
    public static final int C4;
    public static final int C5;
    public static final int C6;
    public static final int C7;
    public static final int C8;
    public static final int C9;
    public static final int Ca;
    public static final int Cb;
    public static final int Cc;
    public static final int Cd;
    public static final int Ce;
    public static final int Cf;
    public static final int Cg;
    public static final int Ch;
    private static k D = null;
    public static Drawable D0 = null;
    public static TextPaint D1 = null;
    public static Drawable D2 = null;
    public static Drawable D3 = null;
    public static final int D4;
    public static final int D5;
    public static final int D6;
    public static final int D7;
    public static final int D8;
    public static final int D9;
    public static final int Da;
    public static final int Db;
    public static final int Dc;
    public static final int Dd;
    public static final int De;
    public static final int Df;
    public static final int Dg;
    public static final int Dh;
    private static k E = null;
    public static Drawable E0 = null;
    public static TextPaint E1 = null;
    public static Drawable E2 = null;
    public static Drawable E3 = null;
    public static final int E4;
    public static final int E5;
    public static final int E6;
    public static final int E7;
    public static final int E8;
    public static final int E9;
    public static final int Ea;
    public static final int Eb;
    public static final int Ec;
    public static final int Ed;
    public static final int Ee;
    public static final int Ef;
    public static final int Eg;
    public static final int Eh;
    private static k F = null;
    public static Drawable F0 = null;
    public static TextPaint F1 = null;
    public static Drawable F2 = null;
    public static Drawable F3 = null;
    public static final int F4;
    public static final int F5;
    public static final int F6;
    public static final int F7;
    public static final int F8;
    public static final int F9;
    public static final int Fa;
    public static final int Fb;
    public static final int Fc;
    public static final int Fd;
    public static final int Fe;
    public static final int Ff;
    public static final int Fg;
    public static final int Fh;
    private static final k G;
    public static Drawable G0 = null;
    public static TextPaint G1 = null;
    public static Drawable G2 = null;
    public static Drawable G3 = null;
    public static final int G4;
    public static final int G5;
    public static final int G6;
    public static final int G7;
    public static final int G8;
    public static final int G9;
    public static final int Ga;
    public static final int Gb;
    public static final int Gc;
    public static final int Gd;
    public static final int Ge;
    public static final int Gf;
    public static final int Gg;
    public static final int Gh;
    private static k H = null;
    public static Drawable H0 = null;
    public static TextPaint H1 = null;
    public static Drawable H2 = null;
    public static final int H4;
    public static final int H5;
    public static final int H6;
    public static final int H7;
    public static final int H8;
    public static final int H9;
    public static final int Ha;
    public static final int Hb;
    public static final int Hc;
    public static final int Hd;
    public static final int He;
    public static final int Hf;
    public static final int Hg;
    public static final int Hh;
    private static boolean I = false;
    public static Drawable I0 = null;
    public static TextPaint I1 = null;
    public static Drawable I2 = null;
    public static final int I4;
    public static final int I5;
    public static final int I6;
    public static final int I7;
    public static final int I8;
    public static final int I9;
    public static final int Ia;
    public static final int Ib;
    public static final int Ic;
    public static final int Id;
    public static final int Ie;
    public static final int If;
    public static final int Ig;
    public static final int Ih;
    private static boolean J = false;
    public static Drawable J0 = null;
    public static TextPaint J1 = null;
    public static Drawable J2 = null;
    public static final int J4;
    public static final int J5;
    public static final int J6;
    public static final int J7;
    public static final int J8;
    public static final int J9;
    public static final int Ja;
    public static final int Jb;
    public static final int Jc;
    public static final int Jd;
    public static final int Je;
    public static final int Jf;
    public static final int Jg;
    public static final int Jh;
    private static int K = 0;
    public static Drawable K0 = null;
    public static TextPaint K1 = null;
    public static Drawable K2 = null;
    public static final int K4;
    public static final int K5;
    public static final int K6;
    public static final int K7;
    public static final int K8;
    public static final int K9;
    public static final int Ka;
    public static final int Kb;
    public static final int Kc;
    public static final int Kd;
    public static final int Ke;
    public static final int Kf;
    public static final int Kg;
    public static final int Kh;
    private static int L = 0;
    public static Drawable L0 = null;
    public static TextPaint L1 = null;
    public static Drawable L2 = null;
    public static Drawable L3 = null;
    public static final int L4;
    public static final int L5;
    public static final int L6;
    public static final int L7;
    public static final int L8;
    public static final int L9;
    public static final int La;
    public static final int Lb;
    public static final int Lc;
    public static final int Ld;
    public static final int Le;
    public static final int Lf;
    public static final int Lg;
    public static final int Lh;
    private static long M = 0;
    public static Drawable M0 = null;
    public static TextPaint M1 = null;
    public static Drawable M2 = null;
    public static Drawable M3 = null;
    public static final int M4;
    public static final int M5;
    public static final int M6;
    public static final int M7;
    public static final int M8;
    public static final int M9;
    public static final int Ma;
    public static final int Mb;
    public static final int Mc;
    public static final int Md;
    public static final int Me;
    public static final int Mf;
    public static final int Mg;
    private static final HashMap Mh;
    private static int N = 0;
    public static Drawable N0 = null;
    public static TextPaint N1 = null;
    public static Drawable N2 = null;
    public static Drawable N3 = null;
    public static final int N4;
    public static final int N5;
    public static final int N6;
    public static final int N7;
    public static final int N8;
    public static final int N9;
    public static final int Na;
    public static final int Nb;
    public static final int Nc;
    public static final int Nd;
    public static final int Ne;
    public static final int Nf;
    public static final int Ng;
    private static final HashMap Nh;
    public static BitmapShader O = null;
    public static Drawable O0 = null;
    public static TextPaint O1 = null;
    public static Drawable O2 = null;
    public static Drawable O3 = null;
    public static final int O4;
    public static final int O5;
    public static final int O6;
    public static final int O7;
    public static final int O8;
    public static final int O9;
    public static final int Oa;
    public static final int Ob;
    public static final int Oc;
    public static final int Od;
    public static final int Oe;
    public static final int Of;
    public static final int Og;
    private static final HashMap Oh;
    private static int P = 0;
    public static RLottieDrawable P0 = null;
    public static TextPaint P1 = null;
    public static Drawable P2 = null;
    public static final int P4;
    public static final int P5;
    public static final int P6;
    public static final int P7;
    public static final int P8;
    public static final int P9;
    public static final int Pa;
    public static final int Pb;
    public static final int Pc;
    public static final int Pd;
    public static final int Pe;
    public static final int Pf;
    public static final int Pg;
    private static final HashMap Ph;
    private static Drawable Q = null;
    public static RLottieDrawable Q0 = null;
    public static TextPaint Q1 = null;
    public static Drawable Q2 = null;
    public static final int Q4;
    public static final int Q5;
    public static final int Q6;
    public static final int Q7;
    public static final int Q8;
    public static final int Q9;
    public static final int Qa;
    public static final int Qb;
    public static final int Qc;
    public static final int Qd;
    public static final int Qe;
    public static final int Qf;
    public static final int Qg;
    private static final int[] Qh;
    private static Drawable R = null;
    public static RLottieDrawable R0 = null;
    public static TextPaint R1 = null;
    public static Drawable R2 = null;
    public static int R3 = 0;
    public static final int R4;
    public static final int R5;
    public static final int R6;
    public static final int R7;
    public static final int R8;
    public static final int R9;
    public static final int Ra;
    public static final int Rb;
    public static final int Rc;
    public static final int Rd;
    public static final int Re;
    public static final int Rf;
    public static final int Rg;
    private static final SparseIntArray Rh;
    private static int S = 0;
    public static RLottieDrawable S0 = null;
    public static TextPaint S1 = null;
    public static Drawable S2 = null;
    public static final int S3;
    public static final int S4;
    public static final int S5;
    public static final int S6;
    public static final int S7;
    public static final int S8;
    public static final int S9;
    public static final int Sa;
    public static final int Sb;
    public static final int Sc;
    public static final int Sd;
    public static final int Se;
    public static final int Sf;
    public static final int Sg;
    private static final HashSet Sh;
    private static String T = null;
    public static RLottieDrawable T0 = null;
    public static TextPaint T1 = null;
    public static Drawable T2 = null;
    public static final int T3;
    public static final int T4;
    public static final int T5;
    public static final int T6;
    public static final int T7;
    public static final int T8;
    public static final int T9;
    public static final int Ta;
    public static final int Tb;
    public static final int Tc;
    public static final int Td;
    public static final int Te;
    public static final int Tf;
    public static final int Tg;
    private static SparseIntArray Th = null;
    private static boolean U = false;
    public static RLottieDrawable U0 = null;
    public static TextPaint U1 = null;
    public static Drawable U2 = null;
    public static final int U3;
    public static final int U4;
    public static final int U5;
    public static final int U6;
    public static final int U7;
    public static final int U8;
    public static final int U9;
    public static final int Ua;
    public static final int Ub;
    public static final int Uc;
    public static final int Ud;
    public static final int Ue;
    public static final int Uf;
    public static final int Ug;
    private static SparseIntArray Uh = null;
    public static Paint V = null;
    public static boolean V0 = false;
    public static TextPaint V1 = null;
    public static Drawable V2 = null;
    public static final int V3;
    public static final int V4;
    public static final int V5;
    public static final int V6;
    public static final int V7;
    public static final int V8;
    public static final int V9;
    public static final int Va;
    public static final int Vb;
    public static final int Vc;
    public static final int Vd;
    public static final int Ve;
    public static final int Vf;
    public static final int Vg;
    private static SparseIntArray Vh = null;
    public static Paint W = null;
    private static int W0 = 0;
    public static TextPaint W1 = null;
    public static Drawable W2 = null;
    public static final int W3;
    public static final int W4;
    public static final int W5;
    public static int[] W6 = null;
    public static final int W7;
    public static final int W8;
    public static final int W9;
    public static final int Wa;
    public static final int Wb;
    public static final int Wc;
    public static final int Wd;
    public static final int We;
    public static final int Wf;
    public static final int Wg;
    private static boolean Wh = false;
    public static Paint X = null;
    private static int X0 = 0;
    public static TextPaint X1 = null;
    public static Drawable X2 = null;
    public static final int X3;
    public static final int X4;
    public static final int X5;
    public static int[] X6 = null;
    public static final int X7;
    public static final int X8;
    public static final int X9;
    public static final int Xa;
    public static final int Xb;
    public static final int Xc;
    public static final int Xd;
    public static final int Xe;
    public static final int Xf;
    public static final int Xg;
    private static final ThreadLocal Xh;
    public static Paint Y = null;
    private static long Y0 = 0;
    public static TextPaint Y1 = null;
    public static Drawable Y2 = null;
    public static final int Y3;
    public static final int Y4;
    public static final int Y5;
    public static int[] Y6 = null;
    public static final int Y7;
    public static final int Y8;
    public static final int Y9;
    public static final int Ya;
    public static final int Yb;
    public static final int Yc;
    public static final int Yd;
    public static final int Ye;
    public static final int Yf;
    public static final int Yg;
    private static final ThreadLocal Yh;
    public static Paint Z = null;
    private static boolean Z0 = false;
    public static TextPaint Z1 = null;
    public static Drawable Z2 = null;
    public static final int Z3;
    public static final int Z4;
    public static final int Z5;
    public static final int Z6;
    public static final int Z7;
    public static final int Z8;
    public static final int Z9;
    public static final int Za;
    public static final int Zb;
    public static final int Zc;
    public static final int Zd;
    public static final int Ze;
    public static final int Zf;
    public static final int Zg;
    private static final ThreadLocal Zh;
    public static Paint a0 = null;
    public static TextPaint a1 = null;
    public static TextPaint a2 = null;
    public static Drawable a3 = null;
    public static final int a4;
    public static final int a5;
    public static final int a6;
    public static final int a7;
    public static final int a8;
    public static final int a9;
    public static final int aa;
    public static final int ab;
    public static final int ac;
    public static final int ad;
    public static final int ae;
    public static final int af;
    public static final int ag;
    public static final int ah;

    /* renamed from: ai, reason: collision with root package name */
    private static final ThreadLocal f83ai;
    public static Runnable b = null;
    public static Paint b0 = null;
    public static Drawable b1 = null;
    public static TextPaint b2 = null;
    public static Drawable b3 = null;
    public static final int b4;
    public static final int b5;
    public static final int b6;
    public static final int b7;
    public static final int b8;
    public static final int b9;
    public static final int ba;
    public static final int bb;
    public static final int bc;
    public static final int bd;
    public static final int be;
    public static final int bf;
    public static final int bg;
    public static final int bh;
    private static final ThreadLocal bi;
    private static SensorManager c = null;
    public static Drawable c1 = null;
    public static TextPaint c2 = null;
    public static Drawable c3 = null;
    public static final int c4;
    public static final int c5;
    public static final int c6;
    public static final int c7;
    public static final int c8;
    public static final int c9;
    public static final int ca;
    public static final int cb;
    public static final int cc;
    public static final int cd;
    public static final int ce;
    public static final int cf;
    public static final int cg;
    public static final int ch;
    private static Method ci = null;
    private static Sensor d = null;
    public static Drawable d0 = null;
    public static Paint d1 = null;
    public static TextPaint d2 = null;
    public static Drawable d3 = null;
    public static final int d4;
    public static final int d5;
    public static final int d6;
    public static final int d7;
    public static final int d8;
    public static final int d9;
    public static final int da;
    public static final int db;
    public static final int dc;
    public static final int dd;
    public static final int de;
    public static final int df;
    public static final int dg;
    public static final int dh;
    private static final SensorEventListener di;
    private static boolean e = false;
    public static Paint e0 = null;
    public static Paint e1 = null;
    public static TextPaint e2 = null;
    public static Drawable e3 = null;
    public static final int e4;
    public static final int e5;
    public static final int e6;
    public static final int e7;
    public static final int e8;
    public static final int e9;
    public static final int ea;
    public static final int eb;
    public static final int ec;
    public static final int ed;
    public static final int ee;
    public static final int ef;
    public static final int eg;
    public static final int eh;
    public static Paint ei = null;
    private static float f = 1.0f;
    public static Paint f0;
    public static Paint f1;
    public static Drawable f2;
    public static Drawable f3;
    public static final int f4;
    public static final int f5;
    public static final int f6;
    public static final int f7;
    public static final int f8;
    public static final int f9;
    public static final int fa;
    public static final int fb;
    public static final int fc;
    public static final int fd;
    public static final int fe;
    public static final int ff;
    public static final int fg;
    public static final int fh;
    public static Paint fi;
    private static long g;
    public static Paint g0;
    public static Paint g1;
    public static Drawable g2;
    public static Drawable g3;
    public static final int g4;
    public static final int g5;
    public static final int g6;
    public static final int g7;
    public static final int g8;
    public static final int g9;
    public static final int ga;
    public static final int gb;
    public static final int gc;
    public static final int gd;
    public static final int ge;
    public static final int gf;
    public static final int gg;
    public static final int gh;
    private static boolean h;
    public static Paint h0;
    public static Paint h1;
    public static Drawable h2;
    public static Drawable h3;
    public static final int h4;
    public static final int h5;
    public static final int h6;
    public static final int h7;
    public static final int h8;
    public static final int h9;
    public static final int ha;
    public static final int hb;
    public static final int hc;
    public static final int hd;
    public static final int he;
    public static final int hf;
    public static final int hg;
    public static final int hh;
    private static boolean i;
    public static Paint i0;
    public static Paint i1;
    public static Drawable i2;
    public static Drawable i3;
    public static final int i4;
    public static final int i5;
    public static final int i6;
    public static final int i7;
    public static final int i8;
    public static final int i9;
    public static final int ia;
    public static final int ib;
    public static final int ic;
    public static final int id;
    public static final int ie;

    /* renamed from: if, reason: not valid java name */
    public static final int f39if;
    public static final int ig;
    public static final int ih;
    public static Paint j0;
    public static Paint j1;
    public static f j2;
    public static Drawable j3;
    public static final int j4;
    public static final int j5;
    public static final int j6;
    public static final int j7;
    public static final int j8;
    public static final int j9;

    /* renamed from: ja, reason: collision with root package name */
    public static final int f84ja;
    public static final int jb;
    public static final int jc;
    public static final int jd;
    public static final int je;
    public static final int jf;
    public static final int jg;
    public static final int jh;
    public static Paint k0;
    public static Paint k1;
    public static f k2;
    public static Drawable k3;
    public static final int k4;
    public static final int k5;
    public static final int k6;
    public static final int k7;
    public static final int k8;
    public static final int k9;
    public static final int ka;
    public static final int kb;
    public static final int kc;
    public static final int kd;
    public static final int ke;
    public static final int kf;
    public static final int kg;
    public static final int kh;
    public static Paint l0;
    public static Paint l1;
    public static f l2;
    public static Drawable l3;
    public static final int l4;
    public static final int l5;
    public static final int l6;
    public static final int l7;
    public static final int l8;
    public static final int l9;
    public static final int la;
    public static final int lb;
    public static final int lc;
    public static final int ld;
    public static final int le;
    public static final int lf;
    public static final int lg;
    public static final int lh;
    public static int m;
    public static TextPaint[] m0;
    public static Paint m1;
    public static f m2;
    public static Drawable m3;
    public static final int m4;
    public static final int m5;
    public static final int m6;
    public static final int m7;
    public static final int m8;
    public static final int m9;
    public static final int ma;
    public static final int mb;
    public static final int mc;
    public static final int md;

    /* renamed from: me, reason: collision with root package name */
    public static final int f85me;
    public static final int mf;
    public static final int mg;
    public static final int[] mh;
    public static boolean n;
    public static TextPaint[] n0;
    public static Paint n1;
    public static f n2;
    public static Drawable n3;
    public static final int n4;
    public static final int n5;
    public static final int n6;
    public static final int n7;
    public static final int n8;
    public static final int n9;
    public static final int na;
    public static final int nb;
    public static final int nc;
    public static final int nd;
    public static final int ne;
    public static final int nf;
    public static final int ng;
    public static final int nh;
    public static float o;
    public static TextPaint o0;
    public static Paint o1;
    public static f o2;
    public static Drawable o3;
    public static final int o4;
    public static final int o5;
    public static final int o6;
    public static final int o7;
    public static final int o8;
    public static final int o9;
    public static final int oa;
    public static final int ob;
    public static final int oc;
    public static final int od;
    public static final int oe;
    public static final int of;
    public static final int og;
    public static final int oh;
    public static int p;
    public static TextPaint p0;
    public static Paint p1;
    public static f p2;
    public static Drawable p3;
    public static final int p4;
    public static final int p5;
    public static final int p6;
    public static final int p7;
    public static final int p8;
    public static final int p9;
    public static final int pa;
    public static final int pb;
    public static final int pc;
    public static final int pd;
    public static final int pe;
    public static final int pf;
    public static final int pg;
    public static final int ph;
    public static int q;
    public static TextPaint[] q0;
    public static Paint q1;
    public static f q2;
    public static Drawable q3;
    public static final int q4;
    public static final int q5;
    public static final int q6;
    public static final int q7;
    public static final int q8;
    public static final int q9;
    public static final int qa;
    public static final int qb;
    public static final int qc;
    public static final int qd;
    public static final int qe;
    public static final int qf;
    public static final int qg;
    public static final int qh;
    public static int r;
    public static TextPaint r0;
    public static Paint r1;
    public static PorterDuffColorFilter r2;
    public static Drawable r3;
    public static final int r4;
    public static final int r5;
    public static final int r6;
    public static final int r7;
    public static final int r8;
    public static final int r9;
    public static final int ra;
    public static final int rb;
    public static final int rc;
    public static final int rd;
    public static final int re;
    public static final int rf;
    public static final int rg;
    public static final int rh;
    public static int s;
    public static TextPaint[] s0;
    public static Paint s1;
    public static Z05 s2;
    public static Drawable s3;
    public static final int s4;
    public static final int s5;
    public static final int s6;
    public static final int s7;
    public static final int s8;
    public static final int s9;
    public static final int sa;
    public static final int sb;
    public static final int sc;
    public static final int sd;
    public static final int se;
    public static final int sf;
    public static final int sg;
    public static final int sh;
    public static int t;
    public static TextPaint t0;
    public static Paint t1;
    public static Drawable t2;
    public static Drawable t3;
    public static final int t4;
    public static final int t5;
    public static final int t6;
    public static final int t7;
    public static final int t8;
    public static final int t9;
    public static final int ta;
    public static final int tb;
    public static final int tc;
    public static final int td;
    public static final int te;
    public static final int tf;
    public static final int tg;
    public static final int th;
    public static String u;
    public static TextPaint u0;
    public static Paint u1;
    public static Drawable u2;
    public static Drawable u3;
    public static final int u4;
    public static final int u5;
    public static final int u6;
    public static final int u7;
    public static final int u8;
    public static final int u9;
    public static final int ua;
    public static final int ub;
    public static final int uc;
    public static final int ud;
    public static final int ue;
    public static final int uf;
    public static final int ug;
    public static final int uh;
    public static double v;
    public static TextPaint v0;
    public static TextPaint v1;
    public static Drawable v2;
    public static final int v4;
    public static final int v5;
    public static final int v6;
    public static final int v7;
    public static final int v8;
    public static final int v9;
    public static final int va;
    public static final int vb;
    public static final int vc;
    public static final int vd;
    public static final int ve;
    public static final int vf;
    public static final int vg;
    public static final int vh;
    public static double w;
    public static TextPaint w0;
    public static TextPaint w1;
    public static Drawable w2;
    public static final int w4;
    public static final int w5;
    public static final int w6;
    public static final int w7;
    public static final int w8;
    public static final int w9;
    public static final int wa;
    public static final int wb;
    public static final int wc;
    public static final int wd;
    public static final int we;
    public static final int wf;
    public static final int wg;
    public static final int wh;
    public static TextPaint x0;
    public static TextPaint x1;
    public static Drawable x2;
    public static final int x4;
    public static final int x5;
    public static final int x6;
    public static final int x7;
    public static final int x8;
    public static final int x9;
    public static final int xa;
    public static final int xb;
    public static final int xc;
    public static final int xd;
    public static final int xe;
    public static final int xf;
    public static final int xg;
    public static final int xh;
    public static TextPaint y0;
    public static TextPaint y1;
    public static Drawable y2;
    public static final int y4;
    public static final int y5;
    public static final int y6;
    public static final int y7;
    public static final int y8;
    public static final int y9;
    public static final int ya;
    public static final int yb;
    public static final int yc;
    public static final int yd;
    public static final int ye;
    public static final int yf;
    public static final int yg;
    public static final int yh;
    public static Drawable z0;
    public static TextPaint z1;
    public static Drawable z2;
    public static final int z4;
    public static final int z5;
    public static final int z6;
    public static final int z7;
    public static final int z8;
    public static final int z9;
    public static final int za;
    public static final int zb;
    public static final int zc;
    public static final int zd;
    public static final int ze;
    public static final int zf;
    public static final int zg;
    public static final int zh;
    private static final Object a = new Object();
    private static final Runnable j = new a();
    private static final Runnable k = new b();
    public static int l = 99;
    private static final Paint x = new Paint(1);
    private static final int[] y = new int[1];
    private static final long[] z = new long[1];
    public static Drawable[] c0 = new Drawable[14];
    public static Drawable[] v3 = new Drawable[2];
    public static Drawable[] w3 = new Drawable[2];
    public static Drawable[] x3 = new Drawable[2];
    public static Drawable[] y3 = new Drawable[2];
    public static Drawable[] z3 = new Drawable[2];
    public static Drawable[] A3 = new Drawable[2];
    public static Drawable[] B3 = new Drawable[2];
    public static Drawable[] C3 = new Drawable[2];
    public static RLottieDrawable[] H3 = new RLottieDrawable[6];
    public static Drawable[] I3 = new Drawable[2];
    public static Drawable[] J3 = new Drawable[2];
    public static Drawable[][] K3 = (Drawable[][]) Array.newInstance((Class<?>) Drawable.class, 5, 2);
    public static Path[] P3 = new Path[2];
    public static Path[] Q3 = new Path[3];

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.h = false;
            m.v(false);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.i = false;
            m.v(true);
        }
    }

    class c extends Drawable {
        RectF a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        c(int i, int i2) {
            this.b = i;
            this.c = i2;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            int iF;
            Rect bounds = getBounds();
            int i = this.b;
            if (i != 7) {
                if (i == 1 || i == 6) {
                    iF = this.c;
                    if (iF <= 0) {
                        iF = AbstractC21455b.F(20.0f);
                    }
                } else {
                    iF = i == 3 ? Math.max(bounds.width(), bounds.height()) / 2 : (int) Math.ceil(Math.sqrt(((bounds.left - bounds.centerX()) * (bounds.left - bounds.centerX())) + ((bounds.top - bounds.centerY()) * (bounds.top - bounds.centerY()))));
                }
                canvas.drawCircle(bounds.centerX(), bounds.centerY(), iF, m.x);
                return;
            }
            if (this.a == null) {
                this.a = new RectF();
            }
            this.a.set(bounds);
            int iF2 = this.c;
            if (iF2 <= 0) {
                iF2 = AbstractC21455b.F(6.0f);
            }
            float f = iF2;
            canvas.drawRoundRect(this.a, f, f, m.x);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    class d implements SensorEventListener {
        d() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
        }
    }

    public static class e {
        private static final int a = m.N4;
        private static float[] b;

        private static float[] a(float... fArr) {
            return fArr.length == 0 ? new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f} : fArr.length == 1 ? new float[]{AbstractC21455b.F(fArr[0]), AbstractC21455b.F(fArr[0]), AbstractC21455b.F(fArr[0]), AbstractC21455b.F(fArr[0]), AbstractC21455b.F(fArr[0]), AbstractC21455b.F(fArr[0]), AbstractC21455b.F(fArr[0]), AbstractC21455b.F(fArr[0])} : fArr.length == 2 ? new float[]{AbstractC21455b.F(fArr[0]), AbstractC21455b.F(fArr[0]), AbstractC21455b.F(fArr[0]), AbstractC21455b.F(fArr[0]), AbstractC21455b.F(fArr[1]), AbstractC21455b.F(fArr[1]), AbstractC21455b.F(fArr[1]), AbstractC21455b.F(fArr[1])} : fArr.length == 3 ? new float[]{AbstractC21455b.F(fArr[0]), AbstractC21455b.F(fArr[0]), AbstractC21455b.F(fArr[1]), AbstractC21455b.F(fArr[1]), AbstractC21455b.F(fArr[2]), AbstractC21455b.F(fArr[2]), AbstractC21455b.F(fArr[2]), AbstractC21455b.F(fArr[2])} : fArr.length < 8 ? new float[]{AbstractC21455b.F(fArr[0]), AbstractC21455b.F(fArr[0]), AbstractC21455b.F(fArr[1]), AbstractC21455b.F(fArr[1]), AbstractC21455b.F(fArr[2]), AbstractC21455b.F(fArr[2]), AbstractC21455b.F(fArr[3]), AbstractC21455b.F(fArr[3])} : new float[]{AbstractC21455b.F(fArr[0]), AbstractC21455b.F(fArr[1]), AbstractC21455b.F(fArr[2]), AbstractC21455b.F(fArr[3]), AbstractC21455b.F(fArr[4]), AbstractC21455b.F(fArr[5]), AbstractC21455b.F(fArr[6]), AbstractC21455b.F(fArr[7])};
        }

        public static int b(int i) {
            if (b == null) {
                b = new float[3];
            }
            Color.colorToHSV(i, b);
            float[] fArr = b;
            float f = fArr[1];
            if (f > 0.01f) {
                fArr[1] = Math.min(1.0f, Math.max(0.0f, f + (m.D0() ? 0.25f : -0.25f)));
                float[] fArr2 = b;
                fArr2[2] = Math.min(1.0f, Math.max(0.0f, fArr2[2] + (m.D0() ? 0.05f : -0.05f)));
            } else {
                fArr[2] = Math.min(1.0f, Math.max(0.0f, fArr[2] + (m.D0() ? 0.1f : -0.1f)));
            }
            return Color.HSVToColor(127, b);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Drawable c(int i, int i2, float... fArr) {
            ColorDrawable colorDrawable = null;
            if (i != 0) {
                if (f(fArr)) {
                    ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(a(fArr), null, null));
                    shapeDrawable.getPaint().setColor(i);
                    colorDrawable = shapeDrawable;
                } else {
                    colorDrawable = new ColorDrawable(i);
                }
            }
            return d(colorDrawable, i2, fArr);
        }

        private static Drawable d(Drawable drawable, int i, float... fArr) {
            ShapeDrawable shapeDrawable;
            if (f(fArr)) {
                shapeDrawable = new ShapeDrawable(new RoundRectShape(a(fArr), null, null));
                shapeDrawable.getPaint().setColor(-1);
            } else {
                shapeDrawable = new ShapeDrawable(new RectShape());
                shapeDrawable.getPaint().setColor(-1);
            }
            return new RippleDrawable(new ColorStateList(new int[][]{StateSet.WILD_CARD}, new int[]{i}), drawable, shapeDrawable);
        }

        public static Drawable e(int i, float... fArr) {
            return c(i, b(i), fArr);
        }

        private static boolean f(float... fArr) {
            for (int i = 0; i < Math.min(8, fArr.length); i++) {
                if (fArr[i] > 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public static Drawable g(int i) {
            return h(i, 0.0f);
        }

        public static Drawable h(int i, float... fArr) {
            return c(0, b(i), fArr);
        }

        public static Drawable i(int i, float... fArr) {
            return h(m.i0(i), fArr);
        }
    }

    public static class f extends Drawable {
        public static AbstractC9075Yj4[] F = new AbstractC9075Yj4[3];
        public boolean A;
        public boolean B;
        private Bitmap C;
        private int D;
        private float E;
        private Shader a;
        private int b;
        private final Paint c;
        private final Paint d;
        private final RectF e;
        private final Matrix f;
        private final int g;
        public boolean h;
        private final Path i;
        private final Rect j;
        private final h k;
        private final boolean l;
        private int m;
        private boolean n;
        private boolean o;
        private boolean p;
        private final int[] q;
        private final Bitmap[] r;
        private final Drawable[] s;
        private final int[] t;
        private final int[][] u;
        private final Drawable[][] v;
        private final int[][] w;
        private int x;
        private boolean y;
        public f z;

        public f(int i, boolean z, boolean z2) {
            this(i, z, z2, null);
        }

        private int b(float f) {
            return this.g == 2 ? (int) Math.ceil(f * 3.0f) : AbstractC21455b.F(f);
        }

        private static ByteBuffer e(int i, int i2, int i3, int i4) {
            ByteBuffer byteBufferOrder = ByteBuffer.allocate(84).order(ByteOrder.nativeOrder());
            byteBufferOrder.put((byte) 1);
            byteBufferOrder.put((byte) 2);
            byteBufferOrder.put((byte) 2);
            byteBufferOrder.put((byte) 9);
            byteBufferOrder.putInt(0);
            byteBufferOrder.putInt(0);
            byteBufferOrder.putInt(0);
            byteBufferOrder.putInt(0);
            byteBufferOrder.putInt(0);
            byteBufferOrder.putInt(0);
            byteBufferOrder.putInt(0);
            byteBufferOrder.putInt(i);
            byteBufferOrder.putInt(i2);
            byteBufferOrder.putInt(i3);
            byteBufferOrder.putInt(i4);
            byteBufferOrder.putInt(1);
            byteBufferOrder.putInt(1);
            byteBufferOrder.putInt(1);
            byteBufferOrder.putInt(1);
            byteBufferOrder.putInt(1);
            byteBufferOrder.putInt(1);
            byteBufferOrder.putInt(1);
            byteBufferOrder.putInt(1);
            byteBufferOrder.putInt(1);
            return byteBufferOrder;
        }

        public void a() {
            Bitmap bitmap;
            if (this.a instanceof BitmapShader) {
                if (!this.A || (bitmap = this.C) == null) {
                    AbstractC9075Yj4 abstractC9075Yj4 = F[this.g == 2 ? (char) 1 : (char) 0];
                    throw null;
                }
                char c = this.g == 2 ? (char) 1 : (char) 0;
                bitmap.getWidth();
                AbstractC9075Yj4 abstractC9075Yj42 = F[c];
                throw null;
            }
        }

        public void c(Canvas canvas, Paint paint) {
            int iB;
            int i;
            Drawable drawableD;
            Rect bounds = getBounds();
            if (paint == null && this.a == null && this.D == 0 && this.E <= 0.0f && (drawableD = d()) != null) {
                drawableD.setBounds(bounds);
                drawableD.draw(canvas);
                return;
            }
            int iB2 = b(2.0f);
            int iB3 = this.D;
            if (iB3 != 0) {
                iB = iB3;
            } else if (this.E > 0.0f) {
                iB3 = AbstractC21455b.U0(b(AbstractC8662Wx6.t0), Math.min(bounds.width(), bounds.height()) / 2, this.E);
                iB = AbstractC21455b.U0(b(Math.min(6, AbstractC8662Wx6.t0)), Math.min(bounds.width(), bounds.height()) / 2, this.E);
            } else if (this.g == 2) {
                iB3 = b(6.0f);
                iB = b(6.0f);
            } else {
                iB3 = b(AbstractC8662Wx6.t0);
                iB = b(Math.min(6, AbstractC8662Wx6.t0));
            }
            int iB4 = b(6.0f);
            Paint paint2 = paint == null ? this.c : paint;
            if (paint == null && this.a != null) {
                this.f.reset();
                a();
                this.f.postTranslate(0.0f, -this.m);
                this.a.setLocalMatrix(this.f);
            }
            int iMax = Math.max(bounds.top, 0);
            boolean z = this.g != 1 ? (this.m + bounds.bottom) - iB3 < this.b : (this.m + bounds.bottom) - (iB4 * 2) < this.b;
            boolean z2 = this.m + (iB3 * 2) >= 0;
            Path path = this.i;
            path.rewind();
            int iHeight = (bounds.height() - iB2) >> 1;
            if (iB3 > iHeight) {
                iB3 = iHeight;
            }
            if (this.l) {
                if (this.y || this.g == 2 || paint != null || z) {
                    int i2 = this.p ? iB : iB3;
                    if (this.g == 1) {
                        path.moveTo((bounds.right - b(8.0f)) - i2, bounds.bottom - iB2);
                    } else {
                        path.moveTo(bounds.right - b(2.6f), bounds.bottom - iB2);
                    }
                    path.lineTo(bounds.left + iB2 + i2, bounds.bottom - iB2);
                    RectF rectF = this.e;
                    int i3 = bounds.left;
                    i = iB;
                    int i4 = bounds.bottom;
                    int i5 = i2 * 2;
                    rectF.set(i3 + iB2, (i4 - iB2) - i5, i3 + iB2 + i5, i4 - iB2);
                    path.arcTo(this.e, 90.0f, 90.0f, false);
                } else {
                    path.moveTo(bounds.right - b(8.0f), (iMax - this.m) + this.b);
                    path.lineTo(bounds.left + iB2, (iMax - this.m) + this.b);
                    i = iB;
                }
                if (this.y || this.g == 2 || paint != null || z2) {
                    path.lineTo(bounds.left + iB2, bounds.top + iB2 + iB3);
                    RectF rectF2 = this.e;
                    int i6 = bounds.left;
                    int i7 = bounds.top;
                    int i8 = iB3 * 2;
                    rectF2.set(i6 + iB2, i7 + iB2, i6 + iB2 + i8, i7 + iB2 + i8);
                    path.arcTo(this.e, 180.0f, 90.0f, false);
                    int i9 = this.n ? i : iB3;
                    if (this.g == 1) {
                        path.lineTo((bounds.right - iB2) - i9, bounds.top + iB2);
                        RectF rectF3 = this.e;
                        int i10 = bounds.right;
                        int i11 = i9 * 2;
                        int i12 = bounds.top;
                        rectF3.set((i10 - iB2) - i11, i12 + iB2, i10 - iB2, i12 + iB2 + i11);
                    } else {
                        path.lineTo((bounds.right - b(8.0f)) - i9, bounds.top + iB2);
                        int i13 = i9 * 2;
                        this.e.set((bounds.right - b(8.0f)) - i13, bounds.top + iB2, bounds.right - b(8.0f), bounds.top + iB2 + i13);
                    }
                    path.arcTo(this.e, 270.0f, 90.0f, false);
                } else {
                    path.lineTo(bounds.left + iB2, (iMax - this.m) - b(2.0f));
                    if (this.g == 1) {
                        path.lineTo(bounds.right - iB2, (iMax - this.m) - b(2.0f));
                    } else {
                        path.lineTo(bounds.right - b(8.0f), (iMax - this.m) - b(2.0f));
                    }
                }
                int i14 = this.g;
                if (i14 == 1) {
                    if (paint != null || z) {
                        int i15 = this.o ? i : iB3;
                        path.lineTo(bounds.right - iB2, (bounds.bottom - iB2) - i15);
                        RectF rectF4 = this.e;
                        int i16 = bounds.right;
                        int i17 = i15 * 2;
                        int i18 = bounds.bottom;
                        rectF4.set((i16 - iB2) - i17, (i18 - iB2) - i17, i16 - iB2, i18 - iB2);
                        path.arcTo(this.e, 0.0f, 90.0f, false);
                    } else {
                        path.lineTo(bounds.right - iB2, (iMax - this.m) + this.b);
                    }
                } else if (this.y || i14 == 2 || paint != null || z) {
                    path.lineTo(bounds.right - b(8.0f), ((bounds.bottom - iB2) - iB4) - b(3.0f));
                    int i19 = iB4 * 2;
                    this.e.set(bounds.right - b(8.0f), ((bounds.bottom - iB2) - i19) - b(9.0f), (bounds.right - b(7.0f)) + i19, (bounds.bottom - iB2) - b(1.0f));
                    path.arcTo(this.e, 180.0f, -83.0f, false);
                } else {
                    path.lineTo(bounds.right - b(8.0f), (iMax - this.m) + this.b);
                }
            } else {
                int i20 = iB;
                if (this.y || this.g == 2 || paint != null || z) {
                    int i21 = this.p ? i20 : iB3;
                    if (this.g == 1) {
                        path.moveTo(bounds.left + b(8.0f) + i21, bounds.bottom - iB2);
                    } else {
                        path.moveTo(bounds.left + b(2.6f), bounds.bottom - iB2);
                    }
                    path.lineTo((bounds.right - iB2) - i21, bounds.bottom - iB2);
                    RectF rectF5 = this.e;
                    int i22 = bounds.right;
                    int i23 = i21 * 2;
                    int i24 = bounds.bottom;
                    rectF5.set((i22 - iB2) - i23, (i24 - iB2) - i23, i22 - iB2, i24 - iB2);
                    path.arcTo(this.e, 90.0f, -90.0f, false);
                } else {
                    path.moveTo(bounds.left + b(8.0f), (iMax - this.m) + this.b);
                    path.lineTo(bounds.right - iB2, (iMax - this.m) + this.b);
                }
                if (this.y || this.g == 2 || paint != null || z2) {
                    path.lineTo(bounds.right - iB2, bounds.top + iB2 + iB3);
                    RectF rectF6 = this.e;
                    int i25 = bounds.right;
                    int i26 = iB3 * 2;
                    int i27 = bounds.top;
                    rectF6.set((i25 - iB2) - i26, i27 + iB2, i25 - iB2, i27 + iB2 + i26);
                    path.arcTo(this.e, 0.0f, -90.0f, false);
                    int i28 = this.n ? i20 : iB3;
                    if (this.g == 1) {
                        path.lineTo(bounds.left + iB2 + i28, bounds.top + iB2);
                        RectF rectF7 = this.e;
                        int i29 = bounds.left;
                        int i30 = bounds.top;
                        int i31 = i28 * 2;
                        rectF7.set(i29 + iB2, i30 + iB2, i29 + iB2 + i31, i30 + iB2 + i31);
                    } else {
                        path.lineTo(bounds.left + b(8.0f) + i28, bounds.top + iB2);
                        int i32 = i28 * 2;
                        this.e.set(bounds.left + b(8.0f), bounds.top + iB2, bounds.left + b(8.0f) + i32, bounds.top + iB2 + i32);
                    }
                    path.arcTo(this.e, 270.0f, -90.0f, false);
                } else {
                    path.lineTo(bounds.right - iB2, (iMax - this.m) - b(2.0f));
                    if (this.g == 1) {
                        path.lineTo(bounds.left + iB2, (iMax - this.m) - b(2.0f));
                    } else {
                        path.lineTo(bounds.left + b(8.0f), (iMax - this.m) - b(2.0f));
                    }
                }
                int i33 = this.g;
                if (i33 == 1) {
                    if (paint != null || z) {
                        int i34 = this.o ? i20 : iB3;
                        path.lineTo(bounds.left + iB2, (bounds.bottom - iB2) - i34);
                        RectF rectF8 = this.e;
                        int i35 = bounds.left;
                        int i36 = bounds.bottom;
                        int i37 = i34 * 2;
                        rectF8.set(i35 + iB2, (i36 - iB2) - i37, i35 + iB2 + i37, i36 - iB2);
                        path.arcTo(this.e, 180.0f, -90.0f, false);
                    } else {
                        path.lineTo(bounds.left + iB2, (iMax - this.m) + this.b);
                    }
                } else if (this.y || i33 == 2 || paint != null || z) {
                    path.lineTo(bounds.left + b(8.0f), ((bounds.bottom - iB2) - iB4) - b(3.0f));
                    int i38 = iB4 * 2;
                    this.e.set((bounds.left + b(7.0f)) - i38, ((bounds.bottom - iB2) - i38) - b(9.0f), bounds.left + b(8.0f), (bounds.bottom - iB2) - b(1.0f));
                    path.arcTo(this.e, 0.0f, 83.0f, false);
                } else {
                    path.lineTo(bounds.left + b(8.0f), (iMax - this.m) + this.b);
                }
            }
            path.close();
            canvas.drawPath(path, paint2);
            if (this.a != null && this.h && paint == null) {
                this.d.setColor(QY0.k(f(m.Fa), (int) ((Color.alpha(r2) * this.x) / 255.0f)));
                canvas.drawPath(path, this.d);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:71:0x017f  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x018d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public android.graphics.drawable.Drawable d() {
            /*
                Method dump skipped, instructions count: 451
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.ActionBar.m.f.d():android.graphics.drawable.Drawable");
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            f fVar = this.z;
            if (fVar == null) {
                c(canvas, null);
                return;
            }
            fVar.draw(canvas);
            setAlpha(0);
            c(canvas, null);
            setAlpha(255);
        }

        protected int f(int i) {
            if (this.g == 2) {
                return m.i0(i);
            }
            h hVar = this.k;
            return hVar != null ? hVar.getColor(i) : m.i0(i);
        }

        protected void finalize() throws Throwable {
            super.finalize();
            for (Bitmap bitmap : this.r) {
                if (bitmap != null) {
                    bitmap.recycle();
                }
            }
            Arrays.fill(this.r, (Object) null);
            Arrays.fill(this.s, (Object) null);
            Arrays.fill(this.q, -1);
        }

        public Shader g() {
            return this.a;
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -2;
        }

        public Matrix h() {
            return this.f;
        }

        public int i() {
            return this.m;
        }

        public boolean j() {
            return this.a != null && m.Wh;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            if (this.x != i || this.c.getAlpha() != i) {
                this.x = i;
                this.c.setAlpha(i);
                if (this.l) {
                    this.d.setAlpha((int) (Color.alpha(f(m.Fa)) * (i / 255.0f)));
                }
            }
            if (this.a == null) {
                Drawable drawableD = d();
                if (drawableD.getAlpha() != i) {
                    drawableD.setAlpha(i);
                }
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void setBounds(int i, int i2, int i3, int i4) {
            super.setBounds(i, i2, i3, i4);
            f fVar = this.z;
            if (fVar != null) {
                fVar.setBounds(i, i2, i3, i4);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(int i, PorterDuff.Mode mode) {
        }

        public f(int i, boolean z, boolean z2, h hVar) {
            this.c = new Paint(1);
            this.e = new RectF();
            this.f = new Matrix();
            this.j = new Rect();
            this.q = new int[]{-1, -1, -1, -1};
            this.r = new Bitmap[4];
            this.s = new Drawable[4];
            this.t = new int[]{-1, -1, -1, -1};
            this.u = new int[][]{new int[]{-1, -1, -1, -1}, new int[]{-1, -1, -1, -1}, new int[]{-1, -1, -1, -1}, new int[]{-1, -1, -1, -1}};
            this.v = (Drawable[][]) Array.newInstance((Class<?>) Drawable.class, 4, 4);
            this.w = new int[][]{new int[]{-1, -1, -1, -1}, new int[]{-1, -1, -1, -1}, new int[]{-1, -1, -1, -1}, new int[]{-1, -1, -1, -1}};
            this.k = hVar;
            this.l = z;
            this.g = i;
            this.h = z2;
            this.i = new Path();
            this.d = new Paint(1);
            this.x = 255;
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    public interface h {
        int getColor(int i);
    }

    public static class j {
        public int a;
        public k b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public boolean i;
        public long j;
        public long k;
        public long l;
        public long m;
        public float p;
        public boolean q;
        public C6857Pg7 r;
        public int s;
        public g t;
        public boolean u;
        public int n = 45;
        public String o = "";
        private final float[] v = new float[3];

        j() {
        }
    }

    public static class k implements E.d {
        public SparseArray B;
        public ArrayList D;
        public LongSparseArray G;
        private String J;
        private String Y;
        public g Z;
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public boolean f;
        public boolean g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int m;
        public int n;
        public C6857Pg7 o;
        private int q;
        private int r;
        private int s;
        public boolean t;
        public boolean u;
        public int w;
        public int x;
        public int y;
        public int z;
        public int l = 45;
        public boolean p = true;
        public boolean v = true;
        public int A = -1;
        public int H = 100;
        private int z0 = -1;

        k() {
        }

        private void A(SharedPreferences sharedPreferences, j jVar, String str) {
            try {
                String string = sharedPreferences.getString(str, null);
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(string);
                g gVar = new g();
                gVar.a = jSONObject.getString("wall");
                gVar.b = jSONObject.getString("owall");
                gVar.d = jSONObject.getInt("pColor");
                gVar.e = jSONObject.getInt("pGrColor");
                gVar.f = jSONObject.optInt("pGrColor2");
                gVar.g = jSONObject.optInt("pGrColor3");
                gVar.h = jSONObject.getInt("pGrAngle");
                gVar.c = jSONObject.getString("wallSlug");
                gVar.i = jSONObject.getBoolean("wBlur");
                gVar.j = jSONObject.getBoolean("wMotion");
                gVar.k = (float) jSONObject.getDouble("pIntensity");
                gVar.l = this;
                gVar.m = jVar;
                if (jVar != null) {
                    jVar.t = gVar;
                } else {
                    this.Z = gVar;
                }
                if (jSONObject.has("wallId") && jSONObject.getLong("wallId") == 1000001) {
                    gVar.c = "d";
                }
            } catch (Throwable th) {
                AbstractC6403Nl2.d(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void B(SharedPreferences sharedPreferences) {
            ArrayList arrayList = this.D;
            if (arrayList == null || arrayList.isEmpty()) {
                A(sharedPreferences, null, this.a + "_owp");
                return;
            }
            int size = this.D.size();
            for (int i = 0; i < size; i++) {
                j jVar = (j) this.D.get(i);
                A(sharedPreferences, jVar, this.a + "_" + jVar.a + "_owp");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C() throws JSONException, IOException {
            this.p = true;
            this.u = false;
            m.Y0(true);
            if (this == m.D && m.H == null) {
                E.j().s(E.V2, this, Boolean.valueOf(this == m.E), null, -1, m.Rh);
            }
        }

        private void D() {
            E.k(this.n).u(this, E.M1);
            E.k(this.n).u(this, E.N1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void E(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int[] iArr6, int[] iArr7, int[] iArr8, String[] strArr, int[] iArr9, int[] iArr10) {
            this.x = iArr.length;
            this.D = new ArrayList();
            this.B = new SparseArray();
            this.G = new LongSparseArray();
            for (int i = 0; i < iArr.length; i++) {
                j jVar = new j();
                jVar.a = iArr8 != null ? iArr8[i] : i;
                if (m.F0(jVar)) {
                    jVar.u = true;
                }
                jVar.c = iArr[i];
                jVar.b = this;
                if (iArr2 != null) {
                    jVar.e = iArr2[i];
                }
                if (iArr3 != null) {
                    jVar.f = iArr3[i];
                }
                if (iArr4 != null) {
                    int i2 = iArr4[i];
                    jVar.j = i2;
                    if (this.t && jVar.a == m.l) {
                        jVar.j = 4294967296L;
                    } else {
                        jVar.j = i2;
                    }
                }
                if (iArr5 != null) {
                    if (this.t && jVar.a == m.l) {
                        jVar.k = 4294967296L;
                    } else {
                        jVar.k = iArr5[i];
                    }
                }
                if (iArr6 != null) {
                    if (this.t && jVar.a == m.l) {
                        jVar.l = 4294967296L;
                    } else {
                        jVar.l = iArr6[i];
                    }
                }
                if (iArr7 != null) {
                    if (this.t && jVar.a == m.l) {
                        jVar.m = 4294967296L;
                    } else {
                        jVar.m = iArr7[i];
                    }
                }
                if (strArr != null) {
                    jVar.p = iArr10[i] / 100.0f;
                    jVar.n = iArr9[i];
                    jVar.o = strArr[i];
                }
                if ((m.F0(jVar) && this.a.equals("Dark Blue")) || this.a.equals("Night")) {
                    jVar.e = -10128392;
                    jVar.f = -9026357;
                    jVar.g = -7845452;
                    jVar.h = -5811800;
                    if (this.a.equals("Night")) {
                        jVar.p = -0.57f;
                        jVar.j = -9666650L;
                        jVar.k = -13749173L;
                        jVar.l = -8883033L;
                        jVar.m = -13421992L;
                    }
                }
                this.B.put(jVar.a, jVar);
                this.D.add(jVar);
            }
            this.y = ((j) this.B.get(0)).c;
        }

        static k n(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            try {
                k kVar = new k();
                kVar.a = jSONObject.getString("name");
                kVar.b = jSONObject.getString("path");
                if (jSONObject.has("account")) {
                    kVar.n = jSONObject.getInt("account");
                }
                if (jSONObject.has(ParameterNames.INFO)) {
                    try {
                        C23394wq6 c23394wq6 = new C23394wq6(Utilities.g(jSONObject.getString(ParameterNames.INFO)));
                        kVar.o = AbstractC18470oi7.d(c23394wq6, c23394wq6.e(true), true);
                    } catch (Throwable th) {
                        AbstractC6403Nl2.d(th);
                    }
                }
                if (jSONObject.has("loaded")) {
                    kVar.p = jSONObject.getBoolean("loaded");
                }
                return kVar;
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
                return null;
            }
        }

        static k o(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String[] strArrSplit = str.split("\\|");
            if (strArrSplit.length != 2) {
                return null;
            }
            k kVar = new k();
            kVar.a = strArrSplit[0];
            kVar.b = strArrSplit[1];
            return kVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean v() {
            if (!this.t) {
                return false;
            }
            int i = this.z;
            int i2 = m.l;
            if (i == i2) {
                return true;
            }
            j jVar = (j) this.B.get(i2);
            j jVar2 = (j) this.B.get(this.z);
            return (jVar2 == null || jVar == null || jVar.c != jVar2.c) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean w() {
            if (!this.t) {
                return false;
            }
            int i = this.z;
            int i2 = m.l;
            if (i == i2) {
                return true;
            }
            j jVar = (j) this.B.get(i2);
            j jVar2 = (j) this.B.get(this.z);
            return jVar != null && jVar2 != null && jVar.d == jVar2.d && jVar.e == jVar2.e && jVar.f == jVar2.f && jVar.g == jVar2.g && jVar.h == jVar2.h && jVar.i == jVar2.i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean x() {
            if (!this.t) {
                return false;
            }
            int i = this.z;
            int i2 = m.l;
            if (i == i2) {
                return true;
            }
            j jVar = (j) this.B.get(i2);
            j jVar2 = (j) this.B.get(this.z);
            return jVar != null && jVar2 != null && jVar.e == jVar2.e && jVar.f == jVar2.f && jVar.g == jVar2.g && jVar.h == jVar2.h && jVar.i == jVar2.i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void z(File file) {
            m(file, this.Y);
            AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.Ho7
                @Override // java.lang.Runnable
                public final void run() throws JSONException, IOException {
                    this.a.C();
                }
            });
        }

        public void F(int i) {
            this.z = i;
            j jVarQ = q(false);
            if (jVarQ != null) {
                this.Z = jVarQ.t;
            }
        }

        public void G(g gVar) {
            if (this.Z == gVar) {
                return;
            }
            j jVarQ = q(false);
            g gVar2 = this.Z;
            if (gVar2 != null) {
                gVar2.c();
            }
            if (gVar != null) {
                gVar.m = jVarQ;
                gVar.l = this;
                gVar.e();
            }
            this.Z = gVar;
            if (jVarQ != null) {
                jVarQ.t = gVar;
            }
        }

        public boolean m(File file, String str) {
            return false;
        }

        public String p(j jVar, boolean z) {
            StringBuilder sb;
            StringBuilder sb2;
            if (jVar == null) {
                jVar = q(false);
            }
            if (jVar == null) {
                StringBuilder sb3 = new StringBuilder();
                if (z) {
                    sb = new StringBuilder();
                    sb.append(this.a);
                    sb.append("_wp_o");
                } else {
                    sb = new StringBuilder();
                    sb.append(this.a);
                    sb.append("_wp");
                }
                sb3.append(sb.toString());
                sb3.append(Utilities.b.nextInt());
                sb3.append(".jpg");
                return sb3.toString();
            }
            StringBuilder sb4 = new StringBuilder();
            if (z) {
                sb2 = new StringBuilder();
                sb2.append(this.a);
                sb2.append("_");
                sb2.append(jVar.a);
                sb2.append("_wp_o");
            } else {
                sb2 = new StringBuilder();
                sb2.append(this.a);
                sb2.append("_");
                sb2.append(jVar.a);
                sb2.append("_wp");
            }
            sb4.append(sb2.toString());
            sb4.append(Utilities.b.nextInt());
            sb4.append(".jpg");
            return sb4.toString();
        }

        public j q(boolean z) {
            j jVar;
            if (this.D == null || (jVar = (j) this.B.get(this.z)) == null) {
                return null;
            }
            if (!z) {
                return jVar;
            }
            int i = this.H + 1;
            this.H = i;
            j jVar2 = new j();
            jVar2.c = jVar.c;
            jVar2.d = jVar.d;
            jVar2.e = jVar.e;
            jVar2.f = jVar.f;
            jVar2.g = jVar.g;
            jVar2.h = jVar.h;
            jVar2.i = jVar.i;
            jVar2.j = jVar.j;
            jVar2.k = jVar.k;
            jVar2.l = jVar.l;
            jVar2.m = jVar.m;
            jVar2.n = jVar.n;
            jVar2.o = jVar.o;
            jVar2.p = jVar.p;
            jVar2.q = jVar.q;
            jVar2.b = this;
            g gVar = this.Z;
            if (gVar != null) {
                jVar2.t = new g(gVar, this, jVar2);
            }
            this.A = this.z;
            jVar2.a = i;
            this.z = i;
            this.Z = jVar2.t;
            this.B.put(i, jVar2);
            this.D.add(0, jVar2);
            m.h1(this);
            return jVar2;
        }

        public String r() {
            if (this.o == null) {
                return this.a;
            }
            return "remote" + this.o.f;
        }

        JSONObject s() throws JSONException {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", this.a);
                jSONObject.put("path", this.b);
                jSONObject.put("account", this.n);
                C6857Pg7 c6857Pg7 = this.o;
                if (c6857Pg7 != null) {
                    C23394wq6 c23394wq6 = new C23394wq6(c6857Pg7.a());
                    this.o.c(c23394wq6);
                    jSONObject.put(ParameterNames.INFO, Utilities.b(c23394wq6.q()));
                }
                jSONObject.put("loaded", this.p);
                return jSONObject;
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
                return null;
            }
        }

        @Override // ir.nasim.tgwidgets.editor.messenger.E.d
        public void t(int i, int i2, Object... objArr) throws JSONException, IOException {
            int i3 = E.M1;
            if (i == i3 || i == E.N1) {
                String str = (String) objArr[0];
                C6857Pg7 c6857Pg7 = this.o;
                if (c6857Pg7 == null || c6857Pg7.j == null) {
                    return;
                }
                if (str.equals(this.J)) {
                    this.J = null;
                    final File file = (File) objArr[1];
                    Utilities.e.i(new Runnable() { // from class: ir.nasim.Fo7
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.z(file);
                        }
                    });
                    return;
                }
                if (str.equals(C4278El2.u(this.o.j))) {
                    D();
                    if (i == i3) {
                        File file2 = new File(this.b);
                        C6857Pg7 c6857Pg72 = this.o;
                        final k kVarE0 = m.e0(file2, c6857Pg72.i, c6857Pg72);
                        if (kVarE0 == null || kVarE0.c == null || new File(kVarE0.c).exists()) {
                            C();
                            return;
                        }
                        this.h = kVarE0.h;
                        this.i = kVarE0.i;
                        this.j = kVarE0.j;
                        this.k = kVarE0.k;
                        this.l = kVarE0.l;
                        this.f = kVarE0.f;
                        this.m = kVarE0.m;
                        this.Y = kVarE0.c;
                        C18707p67 c18707p67 = new C18707p67();
                        S97 s97 = new S97();
                        s97.b = kVarE0.e;
                        c18707p67.b = s97;
                        ConnectionsManager.k(kVarE0.n).m(c18707p67, new JQ5() { // from class: ir.nasim.Go7
                        });
                    }
                }
            }
        }

        public boolean u() {
            int i = this.z0;
            if (i != -1) {
                return i == 1;
            }
            if ("Dark Blue".equals(this.a) || "Night".equals(this.a)) {
                this.z0 = 1;
            } else if ("Blue".equals(this.a) || "Arctic Blue".equals(this.a) || "Day".equals(this.a)) {
                this.z0 = 0;
            }
            if (this.z0 == -1) {
                m.I(m.z0(new File(this.b), null, new String[1]), this);
            }
            return this.z0 == 1;
        }

        public boolean y() {
            return this.b == null && !u();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:131:0x23fc A[Catch: all -> 0x234b, TryCatch #2 {all -> 0x234b, blocks: (B:91:0x232f, B:93:0x2344, B:96:0x234e, B:98:0x2360, B:101:0x2370, B:105:0x237d, B:109:0x2393, B:113:0x23a5, B:116:0x23b6, B:119:0x23bf, B:121:0x23d3, B:126:0x23e1, B:128:0x23e8, B:129:0x23f8, B:131:0x23fc, B:132:0x2400, B:134:0x240b, B:135:0x2412, B:111:0x239b, B:107:0x2387), top: B:230:0x232f, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x240b A[Catch: all -> 0x234b, TryCatch #2 {all -> 0x234b, blocks: (B:91:0x232f, B:93:0x2344, B:96:0x234e, B:98:0x2360, B:101:0x2370, B:105:0x237d, B:109:0x2393, B:113:0x23a5, B:116:0x23b6, B:119:0x23bf, B:121:0x23d3, B:126:0x23e1, B:128:0x23e8, B:129:0x23f8, B:131:0x23fc, B:132:0x2400, B:134:0x240b, B:135:0x2412, B:111:0x239b, B:107:0x2387), top: B:230:0x232f, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x2553 A[Catch: Exception -> 0x2230, TryCatch #0 {Exception -> 0x2230, blocks: (B:45:0x220f, B:47:0x2225, B:60:0x2265, B:62:0x2273, B:70:0x229a, B:72:0x229e, B:74:0x22a6, B:75:0x22b8, B:76:0x22c2, B:78:0x22c8, B:80:0x22d2, B:82:0x22d6, B:84:0x2304, B:86:0x2308, B:159:0x254d, B:161:0x2553, B:162:0x255c, B:164:0x2560, B:166:0x2568, B:168:0x256c, B:170:0x2570, B:171:0x2572, B:173:0x257c, B:145:0x2442, B:148:0x2461, B:150:0x246b, B:152:0x2477, B:154:0x2483, B:157:0x2532, B:155:0x248d, B:156:0x2490, B:143:0x2439, B:144:0x2441, B:178:0x2593, B:179:0x2599, B:183:0x25a3, B:185:0x25f8, B:187:0x2606, B:189:0x2610, B:191:0x261e, B:190:0x2617, B:186:0x25ff, B:63:0x227f, B:65:0x2287, B:67:0x2290, B:69:0x2298, B:50:0x2233, B:52:0x223b, B:54:0x2243, B:56:0x224b, B:58:0x2253, B:88:0x2319, B:137:0x2428, B:138:0x242d), top: B:227:0x220f, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x256c A[Catch: Exception -> 0x2230, TryCatch #0 {Exception -> 0x2230, blocks: (B:45:0x220f, B:47:0x2225, B:60:0x2265, B:62:0x2273, B:70:0x229a, B:72:0x229e, B:74:0x22a6, B:75:0x22b8, B:76:0x22c2, B:78:0x22c8, B:80:0x22d2, B:82:0x22d6, B:84:0x2304, B:86:0x2308, B:159:0x254d, B:161:0x2553, B:162:0x255c, B:164:0x2560, B:166:0x2568, B:168:0x256c, B:170:0x2570, B:171:0x2572, B:173:0x257c, B:145:0x2442, B:148:0x2461, B:150:0x246b, B:152:0x2477, B:154:0x2483, B:157:0x2532, B:155:0x248d, B:156:0x2490, B:143:0x2439, B:144:0x2441, B:178:0x2593, B:179:0x2599, B:183:0x25a3, B:185:0x25f8, B:187:0x2606, B:189:0x2610, B:191:0x261e, B:190:0x2617, B:186:0x25ff, B:63:0x227f, B:65:0x2287, B:67:0x2290, B:69:0x2298, B:50:0x2233, B:52:0x223b, B:54:0x2243, B:56:0x224b, B:58:0x2253, B:88:0x2319, B:137:0x2428, B:138:0x242d), top: B:227:0x220f, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x256f  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x257c A[Catch: Exception -> 0x2230, TryCatch #0 {Exception -> 0x2230, blocks: (B:45:0x220f, B:47:0x2225, B:60:0x2265, B:62:0x2273, B:70:0x229a, B:72:0x229e, B:74:0x22a6, B:75:0x22b8, B:76:0x22c2, B:78:0x22c8, B:80:0x22d2, B:82:0x22d6, B:84:0x2304, B:86:0x2308, B:159:0x254d, B:161:0x2553, B:162:0x255c, B:164:0x2560, B:166:0x2568, B:168:0x256c, B:170:0x2570, B:171:0x2572, B:173:0x257c, B:145:0x2442, B:148:0x2461, B:150:0x246b, B:152:0x2477, B:154:0x2483, B:157:0x2532, B:155:0x248d, B:156:0x2490, B:143:0x2439, B:144:0x2441, B:178:0x2593, B:179:0x2599, B:183:0x25a3, B:185:0x25f8, B:187:0x2606, B:189:0x2610, B:191:0x261e, B:190:0x2617, B:186:0x25ff, B:63:0x227f, B:65:0x2287, B:67:0x2290, B:69:0x2298, B:50:0x2233, B:52:0x223b, B:54:0x2243, B:56:0x224b, B:58:0x2253, B:88:0x2319, B:137:0x2428, B:138:0x242d), top: B:227:0x220f, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:243:0x2589 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v56 */
    /* JADX WARN: Type inference failed for: r2v57, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v68 */
    static {
        /*
            Method dump skipped, instructions count: 11710
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.ActionBar.m.<clinit>():void");
    }

    private static void A(k kVar, boolean z10, boolean z11, boolean z12) {
        String[] strArrSplit;
        if (kVar == null) {
            return;
        }
        try {
            if (kVar.b == null && kVar.d == null) {
                if (!z12 && z10) {
                    SharedPreferences.Editor editorEdit = C.m().edit();
                    editorEdit.remove("theme");
                    editorEdit.commit();
                }
                Th.clear();
                S = 0;
                T = null;
                Q = null;
                R = null;
            } else {
                if (!z12 && z10) {
                    SharedPreferences.Editor editorEdit2 = C.m().edit();
                    editorEdit2.putString("theme", kVar.r());
                    editorEdit2.apply();
                }
                String[] strArr = new String[1];
                String str = kVar.d;
                if (str != null) {
                    Th = z0(null, str, null);
                } else {
                    Th = z0(new File(kVar.b), null, strArr);
                }
                S = Th.get(S3, -1);
                if (TextUtils.isEmpty(strArr[0])) {
                    try {
                        if (kVar.c != null) {
                            new File(kVar.c).delete();
                        }
                    } catch (Exception unused) {
                    }
                    kVar.c = null;
                    T = null;
                } else {
                    T = strArr[0];
                    String absolutePath = new File(AbstractC14047hG.b(), Utilities.a(T) + ".wp").getAbsolutePath();
                    try {
                        String str2 = kVar.c;
                        if (str2 != null && !str2.equals(absolutePath)) {
                            new File(kVar.c).delete();
                        }
                    } catch (Exception unused2) {
                    }
                    kVar.c = absolutePath;
                    try {
                        Uri uri = Uri.parse(T);
                        kVar.e = uri.getQueryParameter("slug");
                        String queryParameter = uri.getQueryParameter("mode");
                        if (queryParameter != null && (strArrSplit = queryParameter.toLowerCase().split(Separators.SP)) != null && strArrSplit.length > 0) {
                            for (int i10 = 0; i10 < strArrSplit.length; i10++) {
                                if ("blur".equals(strArrSplit[i10])) {
                                    kVar.f = true;
                                } else if ("motion".equals(strArrSplit[i10])) {
                                    kVar.g = true;
                                }
                            }
                        }
                        Utilities.h(uri.getQueryParameter("intensity")).intValue();
                        kVar.l = 45;
                        try {
                            String queryParameter2 = uri.getQueryParameter("bg_color");
                            if (!TextUtils.isEmpty(queryParameter2)) {
                                kVar.h = Integer.parseInt(queryParameter2.substring(0, 6), 16) | (-16777216);
                                if (queryParameter2.length() >= 13 && AbstractC21455b.I0(queryParameter2.charAt(6))) {
                                    kVar.i = Integer.parseInt(queryParameter2.substring(7, 13), 16) | (-16777216);
                                }
                                if (queryParameter2.length() >= 20 && AbstractC21455b.I0(queryParameter2.charAt(13))) {
                                    kVar.j = Integer.parseInt(queryParameter2.substring(14, 20), 16) | (-16777216);
                                }
                                if (queryParameter2.length() == 27 && AbstractC21455b.I0(queryParameter2.charAt(20))) {
                                    kVar.k = Integer.parseInt(queryParameter2.substring(21), 16) | (-16777216);
                                }
                            }
                        } catch (Exception unused3) {
                        }
                        try {
                            String queryParameter3 = uri.getQueryParameter("rotation");
                            if (!TextUtils.isEmpty(queryParameter3)) {
                                kVar.l = Utilities.h(queryParameter3).intValue();
                            }
                        } catch (Exception unused4) {
                        }
                    } catch (Throwable th2) {
                        AbstractC6403Nl2.d(th2);
                    }
                }
            }
            if (!z12 && H == null) {
                F = kVar;
                if (E0()) {
                    L = 2000;
                    M = SystemClock.elapsedRealtime();
                    AbstractC21455b.n1(new RunnableC23965xo7(), 2100L);
                }
            }
            D = kVar;
            T0();
        } catch (Exception e10) {
            AbstractC6403Nl2.d(e10);
        }
    }

    public static void A0(final File file, final String str, final String[] strArr, final Utilities.b bVar) {
        Utilities.g.i(new Runnable() { // from class: ir.nasim.Do7
            @Override // java.lang.Runnable
            public final void run() {
                ir.nasim.tgwidgets.editor.ui.ActionBar.m.M0(bVar, file, str, strArr);
            }
        });
    }

    public static void B(k kVar, boolean z10, Runnable runnable) {
        C(kVar, true, true, z10, runnable);
    }

    public static Drawable B0(Context context, int i10, int i11) {
        if (context == null) {
            return null;
        }
        Drawable drawableMutate = context.getResources().getDrawable(i10).mutate();
        drawableMutate.setColorFilter(new PorterDuffColorFilter(i11, PorterDuff.Mode.MULTIPLY));
        return drawableMutate;
    }

    private static void C(final k kVar, final boolean z10, boolean z11, final boolean z12, final Runnable runnable) {
        if (kVar == null) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        try {
        } catch (Exception e10) {
            AbstractC6403Nl2.d(e10);
        }
        if (kVar.b == null && kVar.d == null) {
            if (!z12 && z10) {
                SharedPreferences.Editor editorEdit = C.m().edit();
                editorEdit.remove("theme");
                editorEdit.apply();
            }
            Th.clear();
            S = 0;
            T = null;
            Q = null;
            R = null;
            if (!z12 && H == null) {
                F = kVar;
                if (E0()) {
                    L = 2000;
                    M = SystemClock.elapsedRealtime();
                    AbstractC21455b.n1(new RunnableC23965xo7(), 2100L);
                }
            }
            D = kVar;
            T0();
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        if (!z12 && z10) {
            SharedPreferences.Editor editorEdit2 = C.m().edit();
            editorEdit2.putString("theme", kVar.r());
            editorEdit2.apply();
        }
        final String[] strArr = new String[1];
        final Runnable runnable2 = new Runnable() { // from class: ir.nasim.Ao7
            @Override // java.lang.Runnable
            public final void run() {
                ir.nasim.tgwidgets.editor.ui.ActionBar.m.J0(strArr, kVar, z12, z10, runnable);
            }
        };
        String str = kVar.d;
        if (str != null) {
            A0(null, str, null, new Utilities.b() { // from class: ir.nasim.Bo7
                @Override // ir.nasim.tgwidgets.editor.messenger.Utilities.b
                public final void a(Object obj) {
                    ir.nasim.tgwidgets.editor.ui.ActionBar.m.K0(runnable2, (SparseIntArray) obj);
                }
            });
        } else {
            A0(new File(kVar.b), null, strArr, new Utilities.b() { // from class: ir.nasim.Co7
                @Override // ir.nasim.tgwidgets.editor.messenger.Utilities.b
                public final void a(Object obj) {
                    ir.nasim.tgwidgets.editor.ui.ActionBar.m.L0(runnable2, (SparseIntArray) obj);
                }
            });
        }
    }

    public static boolean C0() {
        return Vh != null;
    }

    public static int D(int i10, int i11) {
        float fAlpha = Color.alpha(i11) / 255.0f;
        float fAlpha2 = Color.alpha(i10) / 255.0f;
        float f10 = 1.0f - fAlpha;
        float f11 = (fAlpha2 * f10) + fAlpha;
        if (f11 == 0.0f) {
            return 0;
        }
        return Color.argb((int) (255.0f * f11), (int) (((Color.red(i11) * fAlpha) + ((Color.red(i10) * fAlpha2) * f10)) / f11), (int) (((Color.green(i11) * fAlpha) + ((Color.green(i10) * fAlpha2) * f10)) / f11), (int) (((Color.blue(i11) * fAlpha) + ((Color.blue(i10) * fAlpha2) * f10)) / f11));
    }

    public static boolean D0() {
        return D.u();
    }

    public static boolean E() {
        return Z0;
    }

    public static boolean E0() {
        return D == E;
    }

    public static void F() {
        if (m != 2) {
            if (i) {
                i = false;
                AbstractC21455b.t(k);
            }
            if (h) {
                h = false;
                AbstractC21455b.t(j);
            }
            if (e) {
                f = 1.0f;
                c.unregisterListener(di, d);
                e = false;
                if (AbstractC8814Xl0.b) {
                    AbstractC6403Nl2.a("light sensor unregistered");
                }
            }
        }
    }

    public static boolean F0(j jVar) {
        k kVar = jVar.b;
        if (kVar == null) {
            return false;
        }
        if (kVar.r().equals("Blue") && jVar.a == 99) {
            return true;
        }
        if (jVar.b.r().equals("Day") && jVar.a == 9) {
            return true;
        }
        return (jVar.b.r().equals("Night") || jVar.b.r().equals("Dark Blue")) && jVar.a == 0;
    }

    public static void G() {
        H(false);
    }

    private static boolean G0(int i10) {
        return i10 >= o9 && i10 < ya;
    }

    public static void H(boolean z10) {
        if (H != null) {
            return;
        }
        if (!z10 && L > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j10 = jElapsedRealtime - M;
            M = jElapsedRealtime;
            int i10 = (int) (L - j10);
            L = i10;
            if (i10 > 0) {
                return;
            }
        }
        if (z10) {
            if (i) {
                i = false;
                AbstractC21455b.t(k);
            }
            if (h) {
                h = false;
                AbstractC21455b.t(j);
            }
        }
        F();
        int iR0 = R0();
        if (iR0 != 0) {
            v(iR0 == 2);
        }
        if (z10) {
            g = 0L;
        }
    }

    private static boolean H0(int i10) {
        return i10 >= g9 && i10 < n9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void I(SparseIntArray sparseIntArray, k kVar) {
        if (kVar == null || sparseIntArray == null || kVar.z0 != -1) {
            return;
        }
        int i10 = N4;
        if (QY0.d(QY0.c(q0(sparseIntArray, i10), q0(sparseIntArray, i10), 0.5f)) < 0.5d) {
            kVar.z0 = 1;
        } else {
            kVar.z0 = 0;
        }
    }

    public static boolean I0() {
        return U;
    }

    public static void J(Context context, boolean z10) {
        TextPaint textPaint;
        O();
        if (!z10 && j2 == null) {
            Resources resources = context.getResources();
            f2 = resources.getDrawable(AbstractC23598xB5.video_muted);
            j2 = new f(0, false, false);
            k2 = new f(0, false, true);
            l2 = new f(0, true, false);
            m2 = new f(0, true, true);
            n2 = new f(1, false, false);
            o2 = new f(1, false, true);
            p2 = new f(1, true, false);
            q2 = new f(1, true, true);
            Z05 z05 = new Z05(0.293f, -26.0f, -28.0f, 1.0f);
            s2 = z05;
            z05.a("M 34.141 16.042 C 37.384 17.921 40.886 20.001 44.211 21.965 C 46.139 23.104 49.285 24.729 49.586 25.917 C 50.289 28.687 48.484 30 46.274 30 L 6 30.021 C 3.79 30.021 2.075 30.023 2 26.021 L 2.009 3.417 C 2.009 0.417 5.326 -0.58 7.068 0.417 C 10.545 2.406 25.024 10.761 34.141 16.042 Z", 166.0f);
            s2.a("M 37.843 17.769 C 41.143 19.508 44.131 21.164 47.429 23.117 C 48.542 23.775 49.623 24.561 49.761 25.993 C 50.074 28.708 48.557 30 46.347 30 L 6 30.012 C 3.79 30.012 2 28.222 2 26.012 L 2.009 4.609 C 2.009 1.626 5.276 0.664 7.074 1.541 C 10.608 3.309 28.488 12.842 37.843 17.769 Z", 200.0f);
            s2.a("M 40.644 18.756 C 43.986 20.389 49.867 23.108 49.884 25.534 C 49.897 27.154 49.88 24.441 49.894 26.059 C 49.911 28.733 48.6 30 46.39 30 L 6 30.013 C 3.79 30.013 2 28.223 2 26.013 L 2.008 5.52 C 2.008 2.55 5.237 1.614 7.079 2.401 C 10.656 4 31.106 14.097 40.644 18.756 Z", 217.0f);
            s2.a("M 43.782 19.218 C 47.117 20.675 50.075 21.538 50.041 24.796 C 50.022 26.606 50.038 24.309 50.039 26.104 C 50.038 28.736 48.663 30 46.453 30 L 6 29.986 C 3.79 29.986 2 28.196 2 25.986 L 2.008 6.491 C 2.008 3.535 5.196 2.627 7.085 3.316 C 10.708 4.731 33.992 14.944 43.782 19.218 Z", 234.0f);
            s2.a("M 47.421 16.941 C 50.544 18.191 50.783 19.91 50.769 22.706 C 50.761 24.484 50.76 23.953 50.79 26.073 C 50.814 27.835 49.334 30 47.124 30 L 5 30.01 C 2.79 30.01 1 28.22 1 26.01 L 1.001 10.823 C 1.001 8.218 3.532 6.895 5.572 7.26 C 7.493 8.01 47.421 16.941 47.421 16.941 Z", 267.0f);
            s2.a("M 47.641 17.125 C 50.641 18.207 51.09 19.935 51.078 22.653 C 51.07 24.191 51.062 21.23 51.088 23.063 C 51.109 24.886 49.587 27 47.377 27 L 5 27.009 C 2.79 27.009 1 25.219 1 23.009 L 0.983 11.459 C 0.983 8.908 3.414 7.522 5.476 7.838 C 7.138 8.486 47.641 17.125 47.641 17.125 Z", 300.0f);
            s2.a("M 48 7 C 50.21 7 52 8.79 52 11 C 52 19 52 19 52 19 C 52 21.21 50.21 23 48 23 L 4 23 C 1.79 23 0 21.21 0 19 L 0 11 C 0 8.79 1.79 7 4 7 C 48 7 48 7 48 7 Z", 383.0f);
            t2 = resources.getDrawable(AbstractC23598xB5.msg_check_s).mutate();
            u2 = resources.getDrawable(AbstractC23598xB5.msg_check_s).mutate();
            v2 = resources.getDrawable(AbstractC23598xB5.msg_check_s).mutate();
            w2 = resources.getDrawable(AbstractC23598xB5.msg_check_s).mutate();
            z2 = resources.getDrawable(AbstractC23598xB5.msg_check_s).mutate();
            B2 = resources.getDrawable(AbstractC23598xB5.msg_check_s).mutate();
            x2 = resources.getDrawable(AbstractC23598xB5.msg_halfcheck).mutate();
            y2 = resources.getDrawable(AbstractC23598xB5.msg_halfcheck).mutate();
            A2 = resources.getDrawable(AbstractC23598xB5.msg_halfcheck_s).mutate();
            C2 = resources.getDrawable(AbstractC23598xB5.msg_halfcheck_s).mutate();
            F2 = resources.getDrawable(AbstractC23598xB5.ic_lock_header).mutate();
            G2 = resources.getDrawable(AbstractC23598xB5.msg_views).mutate();
            H2 = resources.getDrawable(AbstractC23598xB5.msg_views).mutate();
            I2 = resources.getDrawable(AbstractC23598xB5.msg_views).mutate();
            J2 = resources.getDrawable(AbstractC23598xB5.msg_views).mutate();
            K2 = resources.getDrawable(AbstractC23598xB5.msg_reply_small).mutate();
            L2 = resources.getDrawable(AbstractC23598xB5.msg_reply_small).mutate();
            M2 = resources.getDrawable(AbstractC23598xB5.msg_reply_small).mutate();
            N2 = resources.getDrawable(AbstractC23598xB5.msg_reply_small).mutate();
            O2 = resources.getDrawable(AbstractC23598xB5.msg_pin_mini).mutate();
            P2 = resources.getDrawable(AbstractC23598xB5.msg_pin_mini).mutate();
            Q2 = resources.getDrawable(AbstractC23598xB5.msg_pin_mini).mutate();
            R2 = resources.getDrawable(AbstractC23598xB5.msg_pin_mini).mutate();
            T2 = resources.getDrawable(AbstractC23598xB5.msg_pin_mini).mutate();
            S2 = resources.getDrawable(AbstractC23598xB5.msg_pin_mini).mutate();
            U2 = resources.getDrawable(AbstractC23598xB5.msg_views).mutate();
            V2 = resources.getDrawable(AbstractC23598xB5.msg_reply_small).mutate();
            D2 = resources.getDrawable(AbstractC23598xB5.msg_views).mutate();
            E2 = resources.getDrawable(AbstractC23598xB5.msg_reply_small).mutate();
            W2 = resources.getDrawable(AbstractC23598xB5.msg_actions).mutate();
            X2 = resources.getDrawable(AbstractC23598xB5.msg_actions).mutate();
            Y2 = resources.getDrawable(AbstractC23598xB5.msg_actions).mutate();
            Z2 = resources.getDrawable(AbstractC23598xB5.msg_actions).mutate();
            a3 = resources.getDrawable(AbstractC23598xB5.video_actions);
            b3 = resources.getDrawable(AbstractC23598xB5.msg_instant).mutate();
            c3 = resources.getDrawable(AbstractC23598xB5.msg_instant).mutate();
            d3 = resources.getDrawable(AbstractC23598xB5.msg_warning);
            e3 = resources.getDrawable(AbstractC23598xB5.list_mute).mutate();
            f3 = resources.getDrawable(AbstractC23598xB5.ic_lock_header);
            v3[0] = resources.getDrawable(AbstractC23598xB5.chat_calls_voice).mutate();
            w3[0] = resources.getDrawable(AbstractC23598xB5.chat_calls_voice).mutate();
            x3[0] = resources.getDrawable(AbstractC23598xB5.chat_calls_voice).mutate();
            y3[0] = resources.getDrawable(AbstractC23598xB5.chat_calls_voice).mutate();
            v3[1] = resources.getDrawable(AbstractC23598xB5.chat_calls_video).mutate();
            w3[1] = resources.getDrawable(AbstractC23598xB5.chat_calls_video).mutate();
            x3[1] = resources.getDrawable(AbstractC23598xB5.chat_calls_video).mutate();
            y3[1] = resources.getDrawable(AbstractC23598xB5.chat_calls_video).mutate();
            D3 = resources.getDrawable(AbstractC23598xB5.chat_calls_outgoing).mutate();
            E3 = resources.getDrawable(AbstractC23598xB5.chat_calls_incoming).mutate();
            F3 = resources.getDrawable(AbstractC23598xB5.chat_calls_incoming).mutate();
            for (int i10 = 0; i10 < 2; i10++) {
                z3[i10] = resources.getDrawable(AbstractC23598xB5.poll_right).mutate();
                A3[i10] = resources.getDrawable(AbstractC23598xB5.poll_wrong).mutate();
                B3[i10] = resources.getDrawable(AbstractC23598xB5.msg_emoji_objects).mutate();
                C3[i10] = resources.getDrawable(AbstractC23598xB5.msg_psa).mutate();
            }
            L3 = resources.getDrawable(AbstractC23598xB5.ic_call_made_green_18dp).mutate();
            M3 = resources.getDrawable(AbstractC23598xB5.ic_call_made_green_18dp).mutate();
            N3 = resources.getDrawable(AbstractC23598xB5.ic_call_received_green_18dp).mutate();
            O3 = resources.getDrawable(AbstractC23598xB5.ic_call_received_green_18dp).mutate();
            g3 = resources.getDrawable(AbstractC23598xB5.bot_file);
            h3 = resources.getDrawable(AbstractC23598xB5.bot_music);
            i3 = resources.getDrawable(AbstractC23598xB5.bot_location);
            m3 = resources.getDrawable(AbstractC23598xB5.bot_link);
            n3 = resources.getDrawable(AbstractC23598xB5.bot_lines);
            o3 = resources.getDrawable(AbstractC23598xB5.bot_webview);
            p3 = resources.getDrawable(AbstractC23598xB5.bot_invite);
            q3 = resources.getDrawable(AbstractC23598xB5.msg_msgbubble);
            r3 = resources.getDrawable(AbstractC23598xB5.msg_msgbubble2);
            s3 = resources.getDrawable(AbstractC23598xB5.msg_arrowright);
            t3 = resources.getDrawable(AbstractC23598xB5.gradient_left);
            u3 = resources.getDrawable(AbstractC23598xB5.gradient_right);
            H3[0] = new RLottieDrawable(AbstractC19363qD5.attach_gallery, "attach_gallery", AbstractC21455b.F(26.0f), AbstractC21455b.F(26.0f));
            H3[1] = new RLottieDrawable(AbstractC19363qD5.attach_music, "attach_music", AbstractC21455b.F(26.0f), AbstractC21455b.F(26.0f));
            H3[2] = new RLottieDrawable(AbstractC19363qD5.attach_file, "attach_file", AbstractC21455b.F(26.0f), AbstractC21455b.F(26.0f));
            H3[3] = new RLottieDrawable(AbstractC19363qD5.attach_contact, "attach_contact", AbstractC21455b.F(26.0f), AbstractC21455b.F(26.0f));
            H3[4] = new RLottieDrawable(AbstractC19363qD5.attach_location, "attach_location", AbstractC21455b.F(26.0f), AbstractC21455b.F(26.0f));
            H3[5] = new RLottieDrawable(AbstractC19363qD5.attach_poll, "attach_poll", AbstractC21455b.F(26.0f), AbstractC21455b.F(26.0f));
            G3 = resources.getDrawable(AbstractC23598xB5.nophotos3);
            j3 = resources.getDrawable(AbstractC23598xB5.share_arrow).mutate();
            k3 = resources.getDrawable(AbstractC23598xB5.fast_reply);
            l3 = resources.getDrawable(AbstractC23598xB5.message_arrow);
            int iF = AbstractC21455b.F(2.0f);
            RectF rectF = new RectF();
            P3[0] = new Path();
            P3[0].moveTo(AbstractC21455b.F(7.0f), AbstractC21455b.F(3.0f));
            P3[0].lineTo(AbstractC21455b.F(14.0f), AbstractC21455b.F(3.0f));
            P3[0].lineTo(AbstractC21455b.F(21.0f), AbstractC21455b.F(10.0f));
            P3[0].lineTo(AbstractC21455b.F(21.0f), AbstractC21455b.F(20.0f));
            int i11 = iF * 2;
            rectF.set(AbstractC21455b.F(21.0f) - i11, AbstractC21455b.F(19.0f) - iF, AbstractC21455b.F(21.0f), AbstractC21455b.F(19.0f) + iF);
            P3[0].arcTo(rectF, 0.0f, 90.0f, false);
            P3[0].lineTo(AbstractC21455b.F(6.0f), AbstractC21455b.F(21.0f));
            rectF.set(AbstractC21455b.F(5.0f), AbstractC21455b.F(19.0f) - iF, AbstractC21455b.F(5.0f) + i11, AbstractC21455b.F(19.0f) + iF);
            P3[0].arcTo(rectF, 90.0f, 90.0f, false);
            P3[0].lineTo(AbstractC21455b.F(5.0f), AbstractC21455b.F(4.0f));
            rectF.set(AbstractC21455b.F(5.0f), AbstractC21455b.F(3.0f), AbstractC21455b.F(5.0f) + i11, AbstractC21455b.F(3.0f) + i11);
            P3[0].arcTo(rectF, 180.0f, 90.0f, false);
            P3[0].close();
            P3[1] = new Path();
            P3[1].moveTo(AbstractC21455b.F(14.0f), AbstractC21455b.F(5.0f));
            P3[1].lineTo(AbstractC21455b.F(19.0f), AbstractC21455b.F(10.0f));
            P3[1].lineTo(AbstractC21455b.F(14.0f), AbstractC21455b.F(10.0f));
            P3[1].close();
            K3[0][0] = L(AbstractC21455b.F(44.0f), AbstractC23598xB5.msg_round_play_m);
            K3[0][1] = L(AbstractC21455b.F(44.0f), AbstractC23598xB5.msg_round_play_m);
            K3[1][0] = L(AbstractC21455b.F(44.0f), AbstractC23598xB5.msg_round_pause_m);
            K3[1][1] = L(AbstractC21455b.F(44.0f), AbstractC23598xB5.msg_round_pause_m);
            K3[2][0] = L(AbstractC21455b.F(44.0f), AbstractC23598xB5.msg_round_load_m);
            K3[2][1] = L(AbstractC21455b.F(44.0f), AbstractC23598xB5.msg_round_load_m);
            K3[3][0] = L(AbstractC21455b.F(44.0f), AbstractC23598xB5.msg_round_file_s);
            K3[3][1] = L(AbstractC21455b.F(44.0f), AbstractC23598xB5.msg_round_file_s);
            K3[4][0] = L(AbstractC21455b.F(44.0f), AbstractC23598xB5.msg_round_cancel_m);
            K3[4][1] = L(AbstractC21455b.F(44.0f), AbstractC23598xB5.msg_round_cancel_m);
            J3[0] = L(AbstractC21455b.F(44.0f), AbstractC23598xB5.msg_contact);
            J3[1] = L(AbstractC21455b.F(44.0f), AbstractC23598xB5.msg_contact);
            I3[0] = resources.getDrawable(AbstractC23598xB5.msg_location).mutate();
            I3[1] = resources.getDrawable(AbstractC23598xB5.msg_location).mutate();
            g2 = context.getResources().getDrawable(AbstractC23598xB5.compose_panel_shadow).mutate();
            h2 = context.getResources().getDrawable(AbstractC23598xB5.sheet_shadow_round).mutate();
            try {
                int iF2 = AbstractC21455b.k + AbstractC21455b.F(6.0f);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iF2, iF2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                Paint paint = new Paint(1);
                paint.setColor(0);
                paint.setStyle(Paint.Style.FILL);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                Paint paint2 = new Paint(1);
                paint2.setShadowLayer(AbstractC21455b.F(4.0f), 0.0f, 0.0f, 1593835520);
                int i12 = 0;
                while (i12 < 2) {
                    canvas.drawCircle(iF2 / 2, iF2 / 2, (AbstractC21455b.k / 2) - AbstractC21455b.F(1.0f), i12 == 0 ? paint2 : paint);
                    i12++;
                }
                try {
                    canvas.setBitmap(null);
                } catch (Exception unused) {
                }
                i2 = new BitmapDrawable(bitmapCreateBitmap);
            } catch (Throwable unused2) {
            }
            Mh.clear();
            Nh.clear();
            Drawable drawable = n3;
            int i13 = Na;
            r("drawableBotInline", drawable, i13);
            r("drawableBotWebView", o3, i13);
            r("drawableBotLink", m3, i13);
            r("drawable_botInvite", p3, i13);
            r("drawableGoIcon", l3, i13);
            r("drawableCommentSticker", r3, i13);
            r("drawableMsgError", d3, jb);
            r("drawableMsgIn", j2, -1);
            r("drawableMsgInSelected", k2, -1);
            r("drawableMsgInMedia", n2, -1);
            r("drawableMsgInMediaSelected", o2, -1);
            r("drawableMsgInInstant", b3, gb);
            r("drawableMsgOut", l2, -1);
            r("drawableMsgOutSelected", m2, -1);
            r("drawableMsgOutMedia", p2, -1);
            r("drawableMsgOutMediaSelected", q2, -1);
            Drawable drawable2 = x3[0];
            int i14 = C9;
            r("drawableMsgOutCallAudio", drawable2, i14);
            Drawable drawable3 = y3[0];
            int i15 = D9;
            r("drawableMsgOutCallAudioSelected", drawable3, i15);
            r("drawableMsgOutCallVideo", x3[1], i14);
            r("drawableMsgOutCallVideo", y3[1], i15);
            r("drawableMsgOutCheck", t2, q9);
            r("drawableMsgOutCheckSelected", u2, r9);
            Drawable drawable4 = v2;
            int i16 = s9;
            r("drawableMsgOutCheckRead", drawable4, i16);
            Drawable drawable5 = w2;
            int i17 = t9;
            r("drawableMsgOutCheckReadSelected", drawable5, i17);
            r("drawableMsgOutHalfCheck", x2, i16);
            r("drawableMsgOutHalfCheckSelected", y2, i17);
            r("drawableMsgOutInstant", c3, i14);
            r("drawableMsgOutMenu", Y2, A9);
            r("drawableMsgOutMenuSelected", Z2, B9);
            Drawable drawable6 = Q2;
            int i18 = y9;
            r("drawableMsgOutPinned", drawable6, i18);
            Drawable drawable7 = R2;
            int i19 = z9;
            r("drawableMsgOutPinnedSelected", drawable7, i19);
            r("drawableMsgOutReplies", M2, i18);
            r("drawableMsgOutReplies", N2, i19);
            r("drawableMsgOutViews", I2, i18);
            r("drawableMsgOutViewsSelected", J2, i19);
            Drawable drawable8 = B2;
            int i20 = La;
            r("drawableMsgStickerCheck", drawable8, i20);
            r("drawableMsgStickerHalfCheck", C2, i20);
            r("drawableMsgStickerPinned", S2, i20);
            r("drawableMsgStickerReplies", E2, i20);
            r("drawableMsgStickerViews", D2, i20);
            r("drawableReplyIcon", k3, i13);
            r("drawableShareIcon", j3, i13);
            r("drawableMuteIcon", e3, Ra);
            r("drawableLockIcon", f3, Sa);
            r("drawable_chat_pollHintDrawableOut", B3[1], E9);
            r("drawable_chat_pollHintDrawableIn", B3[0], nb);
            t(z10, false);
        }
        if (!z10 && (textPaint = F1) != null) {
            textPaint.setTextSize(AbstractC21455b.F(12.0f));
            G1.setTextSize(AbstractC21455b.F(11.0f));
            I1.setTextSize(AbstractC21455b.F(15.0f));
            J1.setTextSize(AbstractC21455b.F(15.0f));
            K1.setTextSize(AbstractC21455b.F(13.0f));
            P1.setTextSize(AbstractC21455b.F(12.0f));
            H1.setTextSize(AbstractC21455b.F(12.0f));
            Q1.setTextSize(AbstractC21455b.F(16.0f));
            R1.setTextSize(AbstractC21455b.F(15.0f));
            S1.setTextSize(AbstractC21455b.F(15.0f));
            T1.setTextSize(AbstractC21455b.F(15.0f));
            U1.setTextSize(AbstractC21455b.F(13.0f));
            L1.setTextSize(AbstractC21455b.F(12.0f));
            X1.setTextSize(AbstractC21455b.F(r0));
            Z1.setTextSize(AbstractC21455b.F(r0));
            a2.setTextSize(AbstractC21455b.F(r0));
            float f10 = (((AbstractC8662Wx6.r0 * 2) + 10) / 3.0f) - 1.0f;
            b2.setTextSize(AbstractC21455b.F(f10));
            Y1.setTextSize(AbstractC21455b.F(r0));
            W1.setTextSize(AbstractC21455b.F(f10));
            String str = AbstractC8662Wx6.b;
            V1.setTextSize(AbstractC21455b.F(12.0f));
            M1.setTextSize(AbstractC21455b.F(13.0f));
            N1.setTextSize(AbstractC21455b.F(13.0f));
            O1.setTextSize(AbstractC21455b.F(13.0f));
            h1.setStrokeWidth(AbstractC21455b.F(1.0f));
            i1.setStrokeWidth(AbstractC21455b.F(1.1f));
            w1.setTextSize(AbstractC21455b.F(Math.max(16, AbstractC8662Wx6.r0) - 2));
            x1.setTextSize(AbstractC21455b.F(Math.max(16, AbstractC8662Wx6.r0) - 2));
            y1.setTextSize(AbstractC21455b.F(Math.max(16, AbstractC8662Wx6.r0)));
            d2.setTextSize(AbstractC21455b.F(15.0f));
            e2.setTextSize(AbstractC21455b.F(13.0f));
            t1.setStrokeWidth(AbstractC21455b.F(3.0f));
            u1.setStrokeWidth(AbstractC21455b.F(2.0f));
            c2.setTextSize(AbstractC21455b.F(14.0f));
            c2.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        }
        X0(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void J0(String[] strArr, k kVar, boolean z10, boolean z11, Runnable runnable) {
        String[] strArrSplit;
        try {
            S = Th.get(S3, -1);
            if (TextUtils.isEmpty(strArr[0])) {
                try {
                    if (kVar.c != null) {
                        new File(kVar.c).delete();
                    }
                } catch (Exception unused) {
                }
                kVar.c = null;
                T = null;
            } else {
                T = strArr[0];
                String absolutePath = new File(AbstractC14047hG.b(), Utilities.a(T) + ".wp").getAbsolutePath();
                try {
                    String str = kVar.c;
                    if (str != null && !str.equals(absolutePath)) {
                        new File(kVar.c).delete();
                    }
                } catch (Exception unused2) {
                }
                kVar.c = absolutePath;
                try {
                    Uri uri = Uri.parse(T);
                    kVar.e = uri.getQueryParameter("slug");
                    String queryParameter = uri.getQueryParameter("mode");
                    if (queryParameter != null && (strArrSplit = queryParameter.toLowerCase().split(Separators.SP)) != null && strArrSplit.length > 0) {
                        for (int i10 = 0; i10 < strArrSplit.length; i10++) {
                            if ("blur".equals(strArrSplit[i10])) {
                                kVar.f = true;
                            } else if ("motion".equals(strArrSplit[i10])) {
                                kVar.g = true;
                            }
                        }
                    }
                    Utilities.h(uri.getQueryParameter("intensity")).intValue();
                    kVar.l = 45;
                    try {
                        String queryParameter2 = uri.getQueryParameter("bg_color");
                        if (!TextUtils.isEmpty(queryParameter2)) {
                            kVar.h = Integer.parseInt(queryParameter2.substring(0, 6), 16) | (-16777216);
                            if (queryParameter2.length() >= 13 && AbstractC21455b.I0(queryParameter2.charAt(6))) {
                                kVar.i = Integer.parseInt(queryParameter2.substring(7, 13), 16) | (-16777216);
                            }
                            if (queryParameter2.length() >= 20 && AbstractC21455b.I0(queryParameter2.charAt(13))) {
                                kVar.j = Integer.parseInt(queryParameter2.substring(14, 20), 16) | (-16777216);
                            }
                            if (queryParameter2.length() == 27 && AbstractC21455b.I0(queryParameter2.charAt(20))) {
                                kVar.k = Integer.parseInt(queryParameter2.substring(21), 16) | (-16777216);
                            }
                        }
                    } catch (Exception unused3) {
                    }
                    try {
                        String queryParameter3 = uri.getQueryParameter("rotation");
                        if (!TextUtils.isEmpty(queryParameter3)) {
                            kVar.l = Utilities.h(queryParameter3).intValue();
                        }
                    } catch (Exception unused4) {
                    }
                } catch (Throwable th2) {
                    AbstractC6403Nl2.d(th2);
                }
            }
            if (!z10 && H == null) {
                F = kVar;
                if (E0()) {
                    L = 2000;
                    M = SystemClock.elapsedRealtime();
                    AbstractC21455b.n1(new RunnableC23965xo7(), 2100L);
                }
            }
            D = kVar;
            T0();
        } catch (Exception e10) {
            AbstractC6403Nl2.d(e10);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public static ShapeDrawable K(int i10, int i11) {
        OvalShape ovalShape = new OvalShape();
        float f10 = i10;
        ovalShape.resize(f10, f10);
        ShapeDrawable shapeDrawable = new ShapeDrawable(ovalShape);
        shapeDrawable.setIntrinsicWidth(i10);
        shapeDrawable.setIntrinsicHeight(i10);
        shapeDrawable.getPaint().setColor(i11);
        return shapeDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void K0(Runnable runnable, SparseIntArray sparseIntArray) {
        Th = sparseIntArray;
        runnable.run();
    }

    public static C13010fZ0 L(int i10, int i11) {
        return M(i10, i11, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void L0(Runnable runnable, SparseIntArray sparseIntArray) {
        Th = sparseIntArray;
        runnable.run();
    }

    public static C13010fZ0 M(int i10, int i11, int i12) {
        return N(i10, i11 != 0 ? AbstractC14047hG.a.getResources().getDrawable(i11).mutate() : null, i12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void M0(Utilities.b bVar, File file, String str, String[] strArr) {
        bVar.a(z0(file, str, strArr));
    }

    public static C13010fZ0 N(int i10, Drawable drawable, int i11) {
        OvalShape ovalShape = new OvalShape();
        float f10 = i10;
        ovalShape.resize(f10, f10);
        ShapeDrawable shapeDrawable = new ShapeDrawable(ovalShape);
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(-1);
        if (i11 == 1) {
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(AbstractC21455b.F(2.0f));
        } else if (i11 == 2) {
            paint.setAlpha(0);
        }
        C13010fZ0 c13010fZ0 = new C13010fZ0(shapeDrawable, drawable);
        c13010fZ0.c(i10, i10);
        return c13010fZ0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v0, types: [boolean] */
    public static /* synthetic */ int N0(j jVar, j jVar2) {
        if (F0(jVar)) {
            return -1;
        }
        if (F0(jVar2)) {
            return 1;
        }
        ?? r02 = jVar.u;
        ?? r32 = jVar2.u;
        if (r02 != r32) {
            return r02 > r32 ? -1 : 1;
        }
        if (r02 != 0) {
            int i10 = jVar.a;
            int i11 = jVar2.a;
            if (i10 > i11) {
                return 1;
            }
            return i10 < i11 ? -1 : 0;
        }
        int i12 = jVar.a;
        int i13 = jVar2.a;
        if (i12 > i13) {
            return -1;
        }
        return i12 < i13 ? 1 : 0;
    }

    public static void O() {
        Q();
        if (F1 == null) {
            F1 = new TextPaint(1);
            TextPaint textPaint = new TextPaint(1);
            G1 = textPaint;
            textPaint.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            TextPaint textPaint2 = new TextPaint(1);
            I1 = textPaint2;
            textPaint2.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            d1 = new Paint(1);
            TextPaint textPaint3 = new TextPaint(1);
            J1 = textPaint3;
            textPaint3.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            K1 = new TextPaint(1);
            Paint paint = new Paint();
            e1 = paint;
            paint.setPathEffect(C17561nA3.b());
            Paint paint2 = new Paint();
            f1 = paint2;
            paint2.setPathEffect(C17561nA3.b());
            Paint paint3 = new Paint();
            g1 = paint3;
            paint3.setPathEffect(C17561nA3.b());
            Paint paint4 = new Paint(1);
            t1 = paint4;
            Paint.Cap cap = Paint.Cap.ROUND;
            paint4.setStrokeCap(cap);
            Paint paint5 = t1;
            Paint.Style style = Paint.Style.STROKE;
            paint5.setStyle(style);
            t1.setColor(-1610612737);
            Paint paint6 = new Paint(1);
            u1 = paint6;
            paint6.setStrokeCap(cap);
            u1.setStyle(style);
            P1 = new TextPaint(1);
            TextPaint textPaint4 = new TextPaint(1);
            H1 = textPaint4;
            textPaint4.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            TextPaint textPaint5 = new TextPaint(1);
            Q1 = textPaint5;
            textPaint5.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            R1 = new TextPaint(1);
            TextPaint textPaint6 = new TextPaint(1);
            S1 = textPaint6;
            textPaint6.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            TextPaint textPaint7 = new TextPaint(1);
            T1 = textPaint7;
            textPaint7.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            U1 = new TextPaint(1);
            L1 = new TextPaint(1);
            TextPaint textPaint8 = new TextPaint(1);
            M1 = textPaint8;
            textPaint8.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            N1 = new TextPaint(1);
            V1 = new TextPaint(1);
            W1 = new TextPaint(1);
            TextPaint textPaint9 = new TextPaint(1);
            X1 = textPaint9;
            textPaint9.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            Y1 = new TextPaint(1);
            TextPaint textPaint10 = new TextPaint(1);
            Z1 = textPaint10;
            textPaint10.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            a2 = new TextPaint(1);
            TextPaint textPaint11 = new TextPaint(1);
            b2 = textPaint11;
            textPaint11.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            c2 = new TextPaint(1);
            TextPaint textPaint12 = new TextPaint(1);
            O1 = textPaint12;
            textPaint12.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            Paint paint7 = new Paint(1);
            h1 = paint7;
            paint7.setStyle(style);
            h1.setStrokeCap(cap);
            Paint paint8 = new Paint(1);
            i1 = paint8;
            paint8.setStyle(style);
            i1.setStrokeCap(cap);
            j1 = new Paint(1);
            k1 = new Paint(1);
            Paint paint9 = new Paint(1);
            l1 = paint9;
            paint9.setStyle(style);
            l1.setStrokeCap(cap);
            w1 = new TextPaint(1);
            x1 = new TextPaint(1);
            w1.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            TextPaint textPaint13 = new TextPaint(1);
            y1 = textPaint13;
            textPaint13.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            Paint paint10 = new Paint(1);
            q1 = paint10;
            paint10.setColor(704643072);
            r1 = new Paint(1);
            TextPaint textPaint14 = new TextPaint(1);
            d2 = textPaint14;
            textPaint14.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            e2 = new TextPaint(1);
            s1 = new Paint();
            m1 = new Paint(1);
            n1 = new Paint(1);
            o1 = new Paint(1);
            p1 = new Paint(1);
            s("paintChatMessageBackgroundSelected", m1, kb);
            s("paintChatActionBackground", n1, Oa);
            s("paintChatActionBackgroundSelected", o1, Pa);
            TextPaint textPaint15 = w1;
            int i10 = La;
            s("paintChatActionText", textPaint15, i10);
            s("paintChatActionText2", x1, i10);
            s("paintChatBotButton", S1, qb);
            s("paintChatComposeBackground", s1, tc);
            s("paintChatTimeBackground", r1, Za);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int O0(k kVar, k kVar2) {
        if (kVar.b == null && kVar.d == null) {
            return -1;
        }
        if (kVar2.b == null && kVar2.d == null) {
            return 1;
        }
        return kVar.a.compareTo(kVar2.a);
    }

    public static void P(Context context) {
        if (u0 == null) {
            TextPaint textPaint = new TextPaint(1);
            u0 = textPaint;
            textPaint.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            h0 = new Paint(1);
            l0 = new Paint(1);
            e0 = new Paint(1);
        }
        u0.setTextSize(AbstractC21455b.F(13.0f));
    }

    public static void P0(boolean z10) {
    }

    public static void Q() {
        synchronized (a) {
            try {
                if (v1 == null) {
                    v1 = new TextPaint(1);
                    A1 = new TextPaint(1);
                    B1 = new TextPaint[6];
                    C1 = new TextPaint(1);
                    D1 = new TextPaint(1);
                    E1 = new TextPaint(1);
                    TextPaint textPaint = new TextPaint(1);
                    z1 = textPaint;
                    textPaint.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
                    TextPaint textPaint2 = new TextPaint(1);
                    X1 = textPaint2;
                    textPaint2.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
                    TextPaint textPaint3 = new TextPaint(1);
                    Z1 = textPaint3;
                    textPaint3.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
                    a2 = new TextPaint(1);
                    TextPaint textPaint4 = new TextPaint(1);
                    b2 = textPaint4;
                    textPaint4.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
                    Y1 = new TextPaint(1);
                    W1 = new TextPaint(1);
                    V1 = new TextPaint(1);
                }
                float[] fArr = {0.68f, 0.46f, 0.34f, 0.28f, 0.22f, 0.19f};
                int i10 = 0;
                while (true) {
                    TextPaint[] textPaintArr = B1;
                    if (i10 < textPaintArr.length) {
                        textPaintArr[i10] = new TextPaint(1);
                        B1[i10].setTextSize(AbstractC21455b.F(fArr[i10] * 120.0f));
                        i10++;
                    } else {
                        C1.setTextSize(AbstractC21455b.F(46.0f));
                        D1.setTextSize(AbstractC21455b.F(38.0f));
                        E1.setTextSize(AbstractC21455b.F(30.0f));
                        v1.setTextSize(AbstractC21455b.F(AbstractC8662Wx6.r0));
                        A1.setTextSize(AbstractC21455b.F(14.0f));
                        z1.setTextSize(AbstractC21455b.F(15.0f));
                        X1.setTextSize(AbstractC21455b.F(r0));
                        Z1.setTextSize(AbstractC21455b.F(r0));
                        a2.setTextSize(AbstractC21455b.F(r0));
                        float f10 = (((AbstractC8662Wx6.r0 * 2) + 10) / 3.0f) - 1.0f;
                        b2.setTextSize(AbstractC21455b.F(f10));
                        Y1.setTextSize(AbstractC21455b.F(r0));
                        W1.setTextSize(AbstractC21455b.F(f10));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static int Q0(int i10, float f10) {
        return QY0.k(i10, AbstractC22000uV3.b((int) (Color.alpha(i10) * f10), 0, 255));
    }

    public static void R(Context context) {
        if (V == null) {
            Paint paint = new Paint();
            V = paint;
            paint.setStrokeWidth(1.0f);
            Paint paint2 = new Paint();
            W = paint2;
            paint2.setStrokeWidth(1.0f);
            b0 = new Paint(1);
            Paint paint3 = new Paint(1);
            Z = paint3;
            paint3.setStyle(Paint.Style.STROKE);
            Z.setStrokeWidth(AbstractC21455b.F(2.0f));
            Z.setStrokeCap(Paint.Cap.ROUND);
            Paint paint4 = new Paint(1);
            Y = paint4;
            paint4.setColor(0);
            Y.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            a0 = new Paint(1);
            Paint paint5 = new Paint();
            X = paint5;
            paint5.setPathEffect(C17561nA3.b());
            Resources resources = context.getResources();
            c0[0] = resources.getDrawable(AbstractC23598xB5.chats_saved);
            c0[1] = resources.getDrawable(AbstractC23598xB5.ghost);
            c0[2] = resources.getDrawable(AbstractC23598xB5.msg_folders_private);
            c0[3] = resources.getDrawable(AbstractC23598xB5.msg_folders_requests);
            c0[4] = resources.getDrawable(AbstractC23598xB5.msg_folders_groups);
            c0[5] = resources.getDrawable(AbstractC23598xB5.msg_folders_channels);
            c0[6] = resources.getDrawable(AbstractC23598xB5.msg_folders_bots);
            c0[7] = resources.getDrawable(AbstractC23598xB5.msg_folders_muted);
            c0[8] = resources.getDrawable(AbstractC23598xB5.msg_folders_read);
            c0[9] = resources.getDrawable(AbstractC23598xB5.msg_folders_archive);
            c0[10] = resources.getDrawable(AbstractC23598xB5.msg_folders_private);
            c0[11] = resources.getDrawable(AbstractC23598xB5.chats_replies);
            c0[12] = resources.getDrawable(AbstractC23598xB5.other_chats);
            c0[13] = resources.getDrawable(AbstractC23598xB5.msg_stories_closefriends);
            RLottieDrawable rLottieDrawable = P0;
            if (rLottieDrawable != null) {
                rLottieDrawable.setCallback(null);
                P0.T(false);
            }
            RLottieDrawable rLottieDrawable2 = Q0;
            if (rLottieDrawable2 != null) {
                rLottieDrawable2.T(false);
            }
            RLottieDrawable rLottieDrawable3 = R0;
            if (rLottieDrawable3 != null) {
                rLottieDrawable3.T(false);
            }
            RLottieDrawable rLottieDrawable4 = S0;
            if (rLottieDrawable4 != null) {
                rLottieDrawable4.T(false);
            }
            RLottieDrawable rLottieDrawable5 = T0;
            if (rLottieDrawable5 != null) {
                rLottieDrawable5.T(false);
            }
            RLottieDrawable rLottieDrawable6 = U0;
            if (rLottieDrawable6 != null) {
                rLottieDrawable6.T(false);
            }
            P0 = new RLottieDrawable(AbstractC19363qD5.chats_archiveavatar, "chats_archiveavatar", AbstractC21455b.F(36.0f), AbstractC21455b.F(36.0f), false, (int[]) null);
            Q0 = new RLottieDrawable(AbstractC19363qD5.chats_archive, "chats_archive", AbstractC21455b.F(36.0f), AbstractC21455b.F(36.0f), false, (int[]) null);
            R0 = new RLottieDrawable(AbstractC19363qD5.chats_unarchive, "chats_unarchive", AbstractC21455b.F(AbstractC21455b.F(36.0f)), AbstractC21455b.F(36.0f), false, (int[]) null);
            S0 = new RLottieDrawable(AbstractC19363qD5.chats_hide, "chats_hide", AbstractC21455b.F(36.0f), AbstractC21455b.F(36.0f), false, (int[]) null);
            T0 = new RLottieDrawable(AbstractC19363qD5.chats_unhide, "chats_unhide", AbstractC21455b.F(36.0f), AbstractC21455b.F(36.0f), false, (int[]) null);
            U0 = new RLottieDrawable(AbstractC19363qD5.chat_audio_record_delete, "chats_psahide", AbstractC21455b.F(30.0f), AbstractC21455b.F(30.0f), false, (int[]) null);
            u();
        }
    }

    private static int R0() {
        return 0;
    }

    public static void S(Context context) {
        R(context);
        P(context);
        if (m0 == null) {
            Resources resources = context.getResources();
            m0 = new TextPaint[2];
            n0 = new TextPaint[2];
            q0 = new TextPaint[2];
            s0 = new TextPaint[2];
            for (int i10 = 0; i10 < 2; i10++) {
                m0[i10] = new TextPaint(1);
                m0[i10].setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
                n0[i10] = new TextPaint(1);
                n0[i10].setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
                q0[i10] = new TextPaint(1);
                s0[i10] = new TextPaint(1);
            }
            TextPaint textPaint = new TextPaint(1);
            o0 = textPaint;
            textPaint.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            TextPaint textPaint2 = new TextPaint(1);
            p0 = textPaint2;
            textPaint2.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            TextPaint textPaint3 = new TextPaint(1);
            r0 = textPaint3;
            textPaint3.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            t0 = new TextPaint(1);
            TextPaint textPaint4 = new TextPaint(1);
            v0 = textPaint4;
            textPaint4.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            TextPaint textPaint5 = new TextPaint(1);
            w0 = textPaint5;
            textPaint5.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            x0 = new TextPaint(1);
            y0 = new TextPaint(1);
            f0 = new Paint();
            g0 = new Paint(1);
            j0 = new Paint(1);
            i0 = new Paint(1);
            k0 = new Paint(1);
            E0 = resources.getDrawable(AbstractC23598xB5.list_secret);
            F0 = resources.getDrawable(AbstractC23598xB5.msg_mini_lock2);
            z0 = resources.getDrawable(AbstractC23598xB5.list_check).mutate();
            A0 = resources.getDrawable(AbstractC23598xB5.list_check).mutate();
            B0 = resources.getDrawable(AbstractC23598xB5.list_halfcheck);
            C0 = resources.getDrawable(AbstractC23598xB5.list_warning_sign);
            D0 = resources.getDrawable(AbstractC23598xB5.list_reorder).mutate();
            G0 = resources.getDrawable(AbstractC23598xB5.list_mute).mutate();
            H0 = resources.getDrawable(AbstractC23598xB5.list_unmute).mutate();
            I0 = resources.getDrawable(AbstractC23598xB5.verified_area).mutate();
            J0 = resources.getDrawable(AbstractC23598xB5.verified_check).mutate();
            L0 = resources.getDrawable(AbstractC23598xB5.mentionchatslist);
            M0 = resources.getDrawable(AbstractC23598xB5.reactionchatslist);
            K0 = resources.getDrawable(AbstractC23598xB5.list_pin);
            O0 = resources.getDrawable(AbstractC23598xB5.msg_mini_forumarrow);
            d0 = resources.getDrawable(AbstractC23598xB5.preview_arrow);
            RectF rectF = new RectF();
            Q3[0] = new Path();
            Q3[2] = new Path();
            float F10 = AbstractC21455b.F(12.0f);
            float F11 = AbstractC21455b.F(12.0f);
            rectF.set(F10 - AbstractC21455b.F(5.0f), F11 - AbstractC21455b.F(5.0f), AbstractC21455b.F(5.0f) + F10, AbstractC21455b.F(5.0f) + F11);
            Q3[2].arcTo(rectF, -160.0f, -110.0f, true);
            Q3[2].arcTo(rectF, 20.0f, -110.0f, true);
            Q3[0].moveTo(F10, AbstractC21455b.F(8.0f) + F11);
            Q3[0].lineTo(F10, AbstractC21455b.F(2.0f) + F11);
            Q3[0].lineTo(AbstractC21455b.F(3.0f) + F10, AbstractC21455b.F(5.0f) + F11);
            Q3[0].close();
            Q3[0].moveTo(F10, F11 - AbstractC21455b.F(8.0f));
            Q3[0].lineTo(F10, F11 - AbstractC21455b.F(2.0f));
            Q3[0].lineTo(F10 - AbstractC21455b.F(3.0f), F11 - AbstractC21455b.F(5.0f));
            Q3[0].close();
            w();
        }
        r0.setTextSize(AbstractC21455b.F(14.0f));
        t0.setTextSize(AbstractC21455b.F(13.0f));
        v0.setTextSize(AbstractC21455b.F(13.0f));
        w0.setTextSize(AbstractC21455b.F(11.0f));
        x0.setTextSize(AbstractC21455b.F(15.0f));
        y0.setTextSize(AbstractC21455b.F(15.0f));
        o0.setTextSize(AbstractC21455b.F(16.0f));
        p0.setTextSize(AbstractC21455b.F(16.0f));
    }

    public static void S0() {
        int i10 = 0;
        while (true) {
            RLottieDrawable[] rLottieDrawableArr = H3;
            if (i10 >= rLottieDrawableArr.length) {
                return;
            }
            RLottieDrawable rLottieDrawable = rLottieDrawableArr[i10];
            if (rLottieDrawable != null) {
                rLottieDrawable.w();
                if (i10 == 0) {
                    RLottieDrawable rLottieDrawable2 = H3[i10];
                    int i11 = P8;
                    rLottieDrawable2.n0("Color_Mount.**", p0(i11));
                    H3[i10].n0("Color_PhotoShadow.**", p0(i11));
                    RLottieDrawable rLottieDrawable3 = H3[i10];
                    int i12 = O8;
                    rLottieDrawable3.n0("White_Photo.**", p0(i12));
                    H3[i10].n0("White_BackPhoto.**", p0(i12));
                } else if (i10 == 1) {
                    RLottieDrawable rLottieDrawable4 = H3[i10];
                    int i13 = O8;
                    rLottieDrawable4.n0("White_Play1.**", p0(i13));
                    H3[i10].n0("White_Play2.**", p0(i13));
                } else if (i10 == 2) {
                    H3[i10].n0("Color_Corner.**", p0(T8));
                    H3[i10].n0("White_List.**", p0(O8));
                } else if (i10 == 3) {
                    RLottieDrawable rLottieDrawable5 = H3[i10];
                    int i14 = O8;
                    rLottieDrawable5.n0("White_User1.**", p0(i14));
                    H3[i10].n0("White_User2.**", p0(i14));
                } else if (i10 == 4) {
                    H3[i10].n0("Color_Oval.**", p0(X8));
                    H3[i10].n0("White_Pin.**", p0(O8));
                } else if (i10 == 5) {
                    RLottieDrawable rLottieDrawable6 = H3[i10];
                    int i15 = O8;
                    rLottieDrawable6.n0("White_Column 1.**", p0(i15));
                    H3[i10].n0("White_Column 2.**", p0(i15));
                    H3[i10].n0("White_Column 3.**", p0(i15));
                }
                H3[i10].B();
            }
            i10++;
        }
    }

    public static void T(Context context) {
        if (b1 == null) {
            a1 = new TextPaint(1);
            Resources resources = context.getResources();
            b1 = resources.getDrawable(AbstractC23598xB5.verified_area).mutate();
            c1 = resources.getDrawable(AbstractC23598xB5.verified_check).mutate();
            x();
        }
        a1.setTextSize(AbstractC21455b.F(16.0f));
    }

    public static void T0() {
        U0(false, false);
    }

    public static Drawable U(int i10, int i11, int i12) {
        x.setColor(-1);
        return new RippleDrawable(new ColorStateList(new int[][]{StateSet.WILD_CARD}, new int[]{i10}), null, new i(i11, i12));
    }

    public static void U0(boolean z10, boolean z11) {
    }

    public static Drawable V(int i10, int i11, int i12, int i13, int i14) {
        x.setColor(-1);
        return new RippleDrawable(new ColorStateList(new int[][]{StateSet.WILD_CARD}, new int[]{i10}), null, new i(i11, i12, i13, i14));
    }

    public static void V0(Context context) {
        d0();
        if (j2 != null) {
            j2 = null;
            J(context, false);
        }
        if (m0 != null) {
            m0 = null;
            S(context);
        }
        if (b1 != null) {
            b1 = null;
            T(context);
        }
    }

    public static Drawable W(int i10, int i11) {
        float f10 = i10;
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{f10, f10, f10, f10, f10, f10, f10, f10}, null, null));
        shapeDrawable.getPaint().setColor(i11);
        return shapeDrawable;
    }

    public static void W0(boolean z10) {
        K = 0;
        Q = null;
        R = null;
        P0(z10);
    }

    public static Drawable X(int i10, int i11, int i12) {
        float f10 = i10;
        float f11 = i11;
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{f10, f10, f10, f10, f11, f11, f11, f11}, null, null));
        shapeDrawable.getPaint().setColor(i12);
        return shapeDrawable;
    }

    private static void X0(Context context) {
        int[] iArr = Qh;
        iArr[F4] = context.getResources().getColor(IA5.colorPrimary_dark);
        iArr[G4] = context.getResources().getColor(IA5.colorPrimaryHover_dark);
        iArr[t4] = context.getResources().getColor(IA5.colorPrimary_light);
    }

    public static Drawable Y(int i10) {
        return a0(i10, 1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Y0(boolean z10) throws JSONException, IOException {
        Z0(z10, false);
    }

    public static Drawable Z(int i10, int i11) {
        return a0(i10, i11, -1);
    }

    private static void Z0(boolean z10, boolean z11) throws JSONException, IOException {
        ArrayList arrayList;
        int i10 = 0;
        SharedPreferences.Editor editorEdit = AbstractC14047hG.a.getSharedPreferences("themeconfig", 0).edit();
        if (z10) {
            JSONArray jSONArray = new JSONArray();
            int i11 = 0;
            while (true) {
                ArrayList arrayList2 = B;
                if (i11 >= arrayList2.size()) {
                    break;
                }
                JSONObject jSONObjectS = ((k) arrayList2.get(i11)).s();
                if (jSONObjectS != null) {
                    jSONArray.put(jSONObjectS);
                }
                i11++;
            }
            editorEdit.putString("themes2", jSONArray.toString());
        }
        editorEdit.putLong("2remoteThemesHash" + ((Object) ""), z[0]);
        editorEdit.putInt("lastLoadingThemesTime" + ((Object) ""), y[0]);
        editorEdit.commit();
        if (z10) {
            while (i10 < 5) {
                k kVar = (k) C.get(i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? "Night" : "Day" : "Arctic Blue" : "Dark Blue" : "Blue");
                if (kVar != null && (arrayList = kVar.D) != null && !arrayList.isEmpty()) {
                    b1(kVar, true, false, false, false, z11);
                }
                i10++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.drawable.Drawable a0(int r7, int r8, int r9) {
        /*
            r0 = -1
            r1 = 5
            r2 = 1
            r3 = 0
            if (r8 == r2) goto L23
            if (r8 != r1) goto L9
            goto L23
        L9:
            if (r8 == r2) goto L25
            r4 = 3
            if (r8 == r4) goto L25
            r4 = 4
            if (r8 == r4) goto L25
            if (r8 == r1) goto L25
            r4 = 6
            if (r8 == r4) goto L25
            r4 = 7
            if (r8 != r4) goto L1a
            goto L25
        L1a:
            r4 = 2
            if (r8 != r4) goto L23
            android.graphics.drawable.ColorDrawable r4 = new android.graphics.drawable.ColorDrawable
            r4.<init>(r0)
            goto L2f
        L23:
            r4 = r3
            goto L2f
        L25:
            android.graphics.Paint r4 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.x
            r4.setColor(r0)
            ir.nasim.tgwidgets.editor.ui.ActionBar.m$c r4 = new ir.nasim.tgwidgets.editor.ui.ActionBar.m$c
            r4.<init>(r8, r9)
        L2f:
            android.content.res.ColorStateList r5 = new android.content.res.ColorStateList
            int[] r6 = android.util.StateSet.WILD_CARD
            int[][] r6 = new int[][]{r6}
            int[] r7 = new int[]{r7}
            r5.<init>(r6, r7)
            android.graphics.drawable.RippleDrawable r7 = new android.graphics.drawable.RippleDrawable
            r7.<init>(r5, r3, r4)
            if (r8 != r2) goto L51
            if (r9 > 0) goto L4d
            r8 = 1101004800(0x41a00000, float:20.0)
            int r9 = ir.nasim.tgwidgets.editor.messenger.AbstractC21455b.F(r8)
        L4d:
            r7.setRadius(r9)
            goto L56
        L51:
            if (r8 != r1) goto L56
            r7.setRadius(r0)
        L56:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.ActionBar.m.a0(int, int, int):android.graphics.drawable.Drawable");
    }

    public static void a1(k kVar, boolean z10, boolean z11, boolean z12, boolean z13) throws IOException {
        b1(kVar, z10, z11, z12, z13, false);
    }

    public static Drawable b0(int i10, int i11, int i12) {
        OvalShape ovalShape = new OvalShape();
        float f10 = i10;
        ovalShape.resize(f10, f10);
        ShapeDrawable shapeDrawable = new ShapeDrawable(ovalShape);
        shapeDrawable.getPaint().setColor(i11);
        ShapeDrawable shapeDrawable2 = new ShapeDrawable(ovalShape);
        shapeDrawable2.getPaint().setColor(-1);
        return new RippleDrawable(new ColorStateList(new int[][]{StateSet.WILD_CARD}, new int[]{i12}), shapeDrawable, shapeDrawable2);
    }

    public static void b1(k kVar, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) throws IOException {
        if (z10) {
            SharedPreferences.Editor editorEdit = AbstractC14047hG.a.getSharedPreferences("themeconfig", 0).edit();
            if (!z12) {
                int size = kVar.D.size();
                int iMax = Math.max(0, size - kVar.x);
                C23394wq6 c23394wq6 = new C23394wq6(((iMax * 16) + 2) * 4);
                c23394wq6.m(9);
                c23394wq6.m(iMax);
                for (int i10 = 0; i10 < size; i10++) {
                    j jVar = (j) kVar.D.get(i10);
                    int i11 = jVar.a;
                    if (i11 >= 100) {
                        c23394wq6.m(i11);
                        c23394wq6.m(jVar.c);
                        c23394wq6.m(jVar.d);
                        c23394wq6.m(jVar.e);
                        c23394wq6.m(jVar.f);
                        c23394wq6.m(jVar.g);
                        c23394wq6.m(jVar.h);
                        c23394wq6.i(jVar.i);
                        c23394wq6.n(jVar.j);
                        c23394wq6.n(jVar.k);
                        c23394wq6.n(jVar.l);
                        c23394wq6.n(jVar.m);
                        c23394wq6.m(jVar.n);
                        c23394wq6.n(0L);
                        c23394wq6.l(jVar.p);
                        c23394wq6.i(jVar.q);
                        c23394wq6.o(jVar.o);
                        c23394wq6.i(jVar.r != null);
                        if (jVar.r != null) {
                            c23394wq6.m(jVar.s);
                            jVar.r.c(c23394wq6);
                        }
                    }
                }
                editorEdit.putString("accents_" + kVar.d, Base64.encodeToString(c23394wq6.q(), 3));
                if (!z14) {
                    E.j().s(E.S2, new Object[0]);
                }
            }
            editorEdit.putInt("accent_current_" + kVar.d, kVar.z);
            editorEdit.commit();
        } else {
            if (kVar.A != -1) {
                if (z11) {
                    j jVar2 = (j) kVar.B.get(kVar.z);
                    kVar.B.remove(jVar2.a);
                    kVar.D.remove(jVar2);
                    C6857Pg7 c6857Pg7 = jVar2.r;
                    if (c6857Pg7 != null) {
                        kVar.G.remove(c6857Pg7.f);
                    }
                }
                kVar.z = kVar.A;
                j jVarQ = kVar.q(false);
                if (jVarQ != null) {
                    kVar.Z = jVarQ.t;
                } else {
                    kVar.Z = null;
                }
            }
            if (D == kVar) {
                T0();
            }
        }
        kVar.A = -1;
    }

    public static Drawable c0(int i10, int i11, int i12, int i13) {
        float f10 = i10;
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{f10, f10, f10, f10, f10, f10, f10, f10}, null, null));
        shapeDrawable.getPaint().setColor(i11);
        ShapeDrawable shapeDrawable2 = new ShapeDrawable(new RoundRectShape(new float[]{f10, f10, f10, f10, f10, f10, f10, f10}, null, null));
        shapeDrawable2.getPaint().setColor(i13);
        return new RippleDrawable(new ColorStateList(new int[][]{StateSet.WILD_CARD}, new int[]{i12}), shapeDrawable, shapeDrawable2);
    }

    public static void c1(Drawable drawable, int i10, boolean z10) {
        if (drawable instanceof C13010fZ0) {
            Drawable drawableB = z10 ? ((C13010fZ0) drawable).b() : ((C13010fZ0) drawable).a();
            if (drawableB instanceof ColorDrawable) {
                ((ColorDrawable) drawableB).setColor(i10);
            } else {
                drawableB.setColorFilter(new PorterDuffColorFilter(i10, PorterDuff.Mode.MULTIPLY));
            }
        }
    }

    public static void d0() {
    }

    public static void d1(Drawable drawable, int i10) {
        if (drawable == null) {
            return;
        }
        drawable.setColorFilter(new PorterDuffColorFilter(i10, PorterDuff.Mode.MULTIPLY));
    }

    public static k e0(File file, String str, C6857Pg7 c6857Pg7) {
        String[] strArrSplit;
        try {
            k kVar = new k();
            kVar.a = str;
            kVar.o = c6857Pg7;
            kVar.b = file.getAbsolutePath();
            kVar.n = C22477vI7.f;
            String[] strArr = new String[1];
            I(z0(new File(kVar.b), null, strArr), kVar);
            if (TextUtils.isEmpty(strArr[0])) {
                T = null;
            } else {
                String str2 = strArr[0];
                kVar.c = new File(AbstractC14047hG.b(), Utilities.a(str2) + ".wp").getAbsolutePath();
                try {
                    Uri uri = Uri.parse(str2);
                    kVar.e = uri.getQueryParameter("slug");
                    String queryParameter = uri.getQueryParameter("mode");
                    if (queryParameter != null && (strArrSplit = queryParameter.toLowerCase().split(Separators.SP)) != null && strArrSplit.length > 0) {
                        for (int i10 = 0; i10 < strArrSplit.length; i10++) {
                            if ("blur".equals(strArrSplit[i10])) {
                                kVar.f = true;
                            } else if ("motion".equals(strArrSplit[i10])) {
                                kVar.g = true;
                            }
                        }
                    }
                    String queryParameter2 = uri.getQueryParameter("intensity");
                    if (!TextUtils.isEmpty(queryParameter2)) {
                        try {
                            String queryParameter3 = uri.getQueryParameter("bg_color");
                            if (!TextUtils.isEmpty(queryParameter3)) {
                                kVar.h = Integer.parseInt(queryParameter3.substring(0, 6), 16) | (-16777216);
                                if (queryParameter3.length() >= 13 && AbstractC21455b.I0(queryParameter3.charAt(6))) {
                                    kVar.i = Integer.parseInt(queryParameter3.substring(7, 13), 16) | (-16777216);
                                }
                                if (queryParameter3.length() >= 20 && AbstractC21455b.I0(queryParameter3.charAt(13))) {
                                    kVar.j = Integer.parseInt(queryParameter3.substring(14, 20), 16) | (-16777216);
                                }
                                if (queryParameter3.length() == 27 && AbstractC21455b.I0(queryParameter3.charAt(20))) {
                                    kVar.k = Integer.parseInt(queryParameter3.substring(21), 16) | (-16777216);
                                }
                            }
                        } catch (Exception unused) {
                        }
                        try {
                            String queryParameter4 = uri.getQueryParameter("rotation");
                            if (!TextUtils.isEmpty(queryParameter4)) {
                                kVar.l = Utilities.h(queryParameter4).intValue();
                            }
                        } catch (Exception unused2) {
                        }
                        if (!TextUtils.isEmpty(queryParameter2)) {
                            kVar.m = Utilities.h(queryParameter2).intValue();
                        }
                        if (kVar.m == 0) {
                            kVar.m = 50;
                        }
                    }
                } catch (Throwable th2) {
                    AbstractC6403Nl2.d(th2);
                }
            }
            return kVar;
        } catch (Exception e10) {
            AbstractC6403Nl2.d(e10);
            return null;
        }
    }

    public static void e1(Drawable drawable, int i10) {
        d1(drawable, i0(i10));
    }

    public static File f0(String str) throws IOException {
        long jAvailable;
        File file = new File(AbstractC14047hG.b(), str);
        try {
            InputStream inputStreamOpen = AbstractC14047hG.a.getAssets().open(str);
            jAvailable = inputStreamOpen.available();
            inputStreamOpen.close();
        } catch (Exception e10) {
            AbstractC6403Nl2.d(e10);
            jAvailable = 0;
        }
        if (!file.exists() || (jAvailable != 0 && file.length() != jAvailable)) {
            try {
                InputStream inputStreamOpen2 = AbstractC14047hG.a.getAssets().open(str);
                try {
                    AbstractC21455b.C(inputStreamOpen2, file);
                    if (inputStreamOpen2 != null) {
                        inputStreamOpen2.close();
                    }
                } finally {
                }
            } catch (Exception e11) {
                AbstractC6403Nl2.d(e11);
            }
        }
        return file;
    }

    public static void f1(Drawable drawable, int i10, int i11) {
        if (drawable instanceof RippleDrawable) {
            RippleDrawable rippleDrawable = (RippleDrawable) drawable;
            int numberOfLayers = rippleDrawable.getNumberOfLayers();
            for (int i12 = 0; i12 < numberOfLayers; i12++) {
                Drawable drawable2 = rippleDrawable.getDrawable(i12);
                if (drawable2 instanceof i) {
                    ((i) drawable2).a(i10, i11);
                    return;
                }
            }
        }
    }

    public static Drawable g0() throws InterruptedException {
        Drawable drawableH0 = h0();
        if (drawableH0 != null || b == null) {
            return drawableH0;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Utilities.g.i(new RunnableC23375wo7(countDownLatch));
        try {
            countDownLatch.await();
        } catch (Exception e10) {
            AbstractC6403Nl2.d(e10);
        }
        return h0();
    }

    public static void g1(Drawable drawable, int i10, boolean z10) {
        Drawable drawableY0;
        if (drawable instanceof StateListDrawable) {
            try {
                if (z10) {
                    Drawable drawableY02 = y0(drawable, 0);
                    if (drawableY02 instanceof ShapeDrawable) {
                        ((ShapeDrawable) drawableY02).getPaint().setColor(i10);
                    } else {
                        drawableY02.setColorFilter(new PorterDuffColorFilter(i10, PorterDuff.Mode.MULTIPLY));
                    }
                    drawableY0 = y0(drawable, 1);
                } else {
                    drawableY0 = y0(drawable, 2);
                }
                if (drawableY0 instanceof ShapeDrawable) {
                    ((ShapeDrawable) drawableY0).getPaint().setColor(i10);
                    return;
                } else {
                    drawableY0.setColorFilter(new PorterDuffColorFilter(i10, PorterDuff.Mode.MULTIPLY));
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        if (drawable instanceof RippleDrawable) {
            RippleDrawable rippleDrawable = (RippleDrawable) drawable;
            if (z10) {
                rippleDrawable.setColor(new ColorStateList(new int[][]{StateSet.WILD_CARD}, new int[]{i10}));
                return;
            }
            if (rippleDrawable.getNumberOfLayers() > 0) {
                Drawable drawable2 = rippleDrawable.getDrawable(0);
                if (drawable2 instanceof ShapeDrawable) {
                    ((ShapeDrawable) drawable2).getPaint().setColor(i10);
                } else {
                    drawable2.setColorFilter(new PorterDuffColorFilter(i10, PorterDuff.Mode.MULTIPLY));
                }
            }
        }
    }

    public static Drawable h0() {
        Drawable drawable = R;
        return drawable != null ? drawable : Q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h1(k kVar) {
        Collections.sort(kVar.D, new Comparator() { // from class: ir.nasim.zo7
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ir.nasim.tgwidgets.editor.ui.ActionBar.m.N0((m.j) obj, (m.j) obj2);
            }
        });
    }

    public static int i0(int i10) {
        return k0(i10, null, false);
    }

    private static void i1() {
        Collections.sort(A, new Comparator() { // from class: ir.nasim.yo7
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ir.nasim.tgwidgets.editor.ui.ActionBar.m.O0((m.k) obj, (m.k) obj2);
            }
        });
    }

    public static int j0(int i10, h hVar) {
        return hVar != null ? hVar.getColor(i10) : i0(i10);
    }

    public static int k0(int i10, boolean[] zArr, boolean z10) {
        int iIndexOfKey;
        SparseIntArray sparseIntArray;
        int iIndexOfKey2;
        if (!z10 && (sparseIntArray = Vh) != null && (iIndexOfKey2 = sparseIntArray.indexOfKey(i10)) >= 0) {
            return Vh.valueAt(iIndexOfKey2);
        }
        if (O != null && (La == i10 || Ma == i10 || Na == i10 || wb == i10 || yb == i10 || Cb == i10)) {
            return -1;
        }
        if (D == G) {
            if (H0(i10) ? D.x() : G0(i10) ? D.w() : (oc == i10 || pc == i10 || qc == i10 || rc == i10) ? false : D.v()) {
                return i10 == Oa ? N : i10 == Pa ? P : o0(i10);
            }
        }
        int iIndexOfKey3 = Uh.indexOfKey(i10);
        if (iIndexOfKey3 >= 0) {
            int iValueAt = Uh.valueAt(iIndexOfKey3);
            return (N4 == i10 || J5 == i10 || Z6 == i10 || t7 == i10) ? iValueAt | (-16777216) : iValueAt;
        }
        int i11 = Rh.get(i10, -1);
        if (i11 != -1 && (iIndexOfKey = Uh.indexOfKey(i11)) >= 0) {
            return Uh.valueAt(iIndexOfKey);
        }
        if (zArr != null) {
            zArr[0] = true;
        }
        return i10 == Oa ? N : i10 == Pa ? P : o0(i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.drawable.Drawable l0() {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            long r2 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y0
            long r0 = r0 - r2
            r2 = 60000(0xea60, double:2.9644E-319)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L7a
            long r0 = java.lang.System.currentTimeMillis()
            ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y0 = r0
            java.util.Calendar r0 = java.util.Calendar.getInstance()
            long r1 = java.lang.System.currentTimeMillis()
            r0.setTimeInMillis(r1)
            r1 = 2
            int r1 = r0.get(r1)
            r2 = 5
            int r2 = r0.get(r2)
            r3 = 12
            r0.get(r3)
            r3 = 11
            int r0 = r0.get(r3)
            r4 = 1
            if (r1 != 0) goto L3f
            if (r2 != r4) goto L3f
            r5 = 23
            if (r0 > r5) goto L3f
            r0 = r4
            goto L40
        L3f:
            r0 = 0
        L40:
            ir.nasim.tgwidgets.editor.ui.ActionBar.m.Z0 = r0
            android.graphics.drawable.Drawable r0 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.N0
            if (r0 != 0) goto L7a
            if (r1 != r3) goto L56
            boolean r0 = ir.nasim.AbstractC8814Xl0.c
            r3 = 31
            if (r0 == 0) goto L51
            r0 = 29
            goto L52
        L51:
            r0 = r3
        L52:
            if (r2 < r0) goto L56
            if (r2 <= r3) goto L5a
        L56:
            if (r1 != 0) goto L7a
            if (r2 != r4) goto L7a
        L5a:
            android.content.Context r0 = ir.nasim.AbstractC14047hG.a
            android.content.res.Resources r0 = r0.getResources()
            int r1 = ir.nasim.AbstractC23598xB5.newyear
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)
            ir.nasim.tgwidgets.editor.ui.ActionBar.m.N0 = r0
            r0 = 1077936128(0x40400000, float:3.0)
            int r0 = ir.nasim.tgwidgets.editor.messenger.AbstractC21455b.F(r0)
            int r0 = -r0
            ir.nasim.tgwidgets.editor.ui.ActionBar.m.W0 = r0
            r0 = -1059061760(0xffffffffc0e00000, float:-7.0)
            int r0 = ir.nasim.tgwidgets.editor.messenger.AbstractC21455b.F(r0)
            int r0 = -r0
            ir.nasim.tgwidgets.editor.ui.ActionBar.m.X0 = r0
        L7a:
            android.graphics.drawable.Drawable r0 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.N0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.ActionBar.m.l0():android.graphics.drawable.Drawable");
    }

    public static int m0() {
        return W0;
    }

    public static int n0() {
        return X0;
    }

    public static int o0(int i10) {
        int i11 = Qh[i10];
        return i11 == 0 ? (H0(i10) || i10 == j8 || i10 == t8 || i10 == k8 || i10 == qc || i10 == rc) ? 0 : -65536 : i11;
    }

    public static int p0(int i10) {
        return k0(i10, null, true);
    }

    public static int q0(SparseIntArray sparseIntArray, int i10) {
        int iIndexOfKey = sparseIntArray.indexOfKey(i10);
        return iIndexOfKey >= 0 ? sparseIntArray.valueAt(iIndexOfKey) : Qh[i10];
    }

    private static void r(String str, Drawable drawable, int i10) {
        Mh.put(str, drawable);
        Nh.put(str, Integer.valueOf(i10));
    }

    public static Drawable r0(int i10) {
        return s0(AbstractC21455b.F(3.0f), i10);
    }

    private static void s(String str, Paint paint, int i10) {
        Oh.put(str, paint);
        Ph.put(str, Integer.valueOf(i10));
    }

    public static Drawable s0(int i10, int i11) {
        return new RippleDrawable(new ColorStateList(new int[][]{StateSet.WILD_CARD}, new int[]{(i11 & 16777215) | 419430400}), null, W(i10, -1));
    }

    public static void t(boolean z10, boolean z11) {
        if (v1 == null || j2 == null || z10) {
            return;
        }
        M1.setColor(i0(mb));
        L1.setColor(i0(lb));
        S1.setColor(i0(qb));
        e1.setColor(i0(mc));
        f1.setColor(i0(sa));
        d1.setColor(i0(ob));
        g1.setColor(i0(nc));
        j1.setColor(i0(ib));
        Paint paint = k1;
        int i10 = b9;
        paint.setColor(i0(i10));
        l1.setColor(i0(i10));
        TextPaint textPaint = w1;
        int i11 = La;
        textPaint.setColor(i0(i11));
        x1.setColor(i0(i11));
        w1.linkColor = i0(Ma);
        y1.setColor(i0(i11));
        d2.setColor(i0(p5));
        s1.setColor(i0(tc));
        r1.setColor(i0(Za));
        e1(f2, Lb);
        f fVar = j2;
        int i12 = d9;
        e1(fVar, i12);
        f fVar2 = k2;
        int i13 = Ga;
        e1(fVar2, i13);
        e1(n2, i12);
        e1(o2, i13);
        e1(t2, q9);
        e1(u2, r9);
        Drawable drawable = v2;
        int i14 = s9;
        e1(drawable, i14);
        Drawable drawable2 = w2;
        int i15 = t9;
        e1(drawable2, i15);
        e1(x2, i14);
        e1(y2, i15);
        Drawable drawable3 = z2;
        int i16 = Va;
        e1(drawable3, i16);
        e1(A2, i16);
        e1(B2, i11);
        e1(C2, i11);
        e1(D2, i11);
        e1(E2, i11);
        e1(F2, i11);
        Drawable drawable4 = j3;
        int i17 = Na;
        e1(drawable4, i17);
        e1(k3, i17);
        e1(l3, i17);
        e1(n3, i17);
        e1(o3, i17);
        e1(p3, i17);
        e1(m3, i17);
        Drawable drawable5 = G2;
        int i18 = ab;
        e1(drawable5, i18);
        Drawable drawable6 = H2;
        int i19 = bb;
        e1(drawable6, i19);
        Drawable drawable7 = I2;
        int i20 = y9;
        e1(drawable7, i20);
        Drawable drawable8 = J2;
        int i21 = z9;
        e1(drawable8, i21);
        e1(K2, i18);
        e1(L2, i19);
        e1(M2, i20);
        e1(N2, i21);
        e1(O2, i18);
        e1(P2, i19);
        e1(Q2, i20);
        e1(R2, i21);
        Drawable drawable9 = T2;
        int i22 = cb;
        e1(drawable9, i22);
        e1(S2, i11);
        e1(U2, i22);
        e1(V2, i22);
        e1(W2, db);
        e1(X2, eb);
        e1(Y2, A9);
        e1(Z2, B9);
        e1(a3, fb);
        e1(c3, C9);
        Drawable drawable10 = b3;
        int i23 = gb;
        e1(drawable10, i23);
        e1(d3, jb);
        e1(e3, Ra);
        e1(f3, Sa);
        Drawable drawable11 = g3;
        int i24 = hd;
        e1(drawable11, i24);
        e1(h3, i24);
        e1(i3, i24);
        e1(q3, i23);
        e1(r3, i17);
        e1(s3, i23);
        Drawable drawable12 = t3;
        int i25 = cd;
        e1(drawable12, i25);
        e1(u3, i25);
        for (int i26 = 0; i26 < 2; i26++) {
            e1(v3[i26], gb);
            e1(w3[i26], hb);
            e1(x3[i26], C9);
            e1(y3[i26], D9);
        }
        e1(D3, p9);
        Drawable drawable13 = E3;
        int i27 = Z5;
        e1(drawable13, i27);
        e1(F3, c9);
        e1(L3, i27);
        Drawable drawable14 = M3;
        int i28 = rg;
        e1(drawable14, i28);
        e1(N3, i27);
        e1(O3, i28);
        for (int i29 = 0; i29 < 5; i29++) {
            c1(K3[i29][0], i0(Jc), false);
            c1(K3[i29][0], i0(Xa), true);
            c1(K3[i29][1], i0(Kc), false);
            c1(K3[i29][1], i0(Ya), true);
        }
        c1(J3[0], i0(Sc), false);
        c1(J3[0], i0(Tc), true);
        c1(J3[1], i0(wa), false);
        c1(J3[1], i0(xa), true);
        d1(I3[0], i0(Rc));
        d1(I3[1], i0(va));
        d1(B3[0], i0(nb));
        d1(B3[1], i0(E9));
        d1(C3[0], i0(ab));
        d1(C3[1], i0(y9));
        e1(g2, uc);
        e1(h2, tc);
        int iI0 = i0(fa) == -1 ? i0(h9) : -1;
        d1(z3[1], iI0);
        d1(A3[1], iI0);
        d1(G3, i0(J8));
        S0();
    }

    public static Drawable t0(int i10, int i11) {
        if (i11 < 0) {
            return Z(i10, 2);
        }
        return new RippleDrawable(new ColorStateList(new int[][]{StateSet.WILD_CARD}, new int[]{i10}), new ColorDrawable(i0(i11)), new ColorDrawable(-1));
    }

    public static void u() {
        Paint paint = V;
        if (paint == null) {
            return;
        }
        paint.setColor(i0(M5));
        X.setColor(i0(t5));
        int i10 = 0;
        while (true) {
            Drawable[] drawableArr = c0;
            if (i10 >= drawableArr.length) {
                P0.w();
                RLottieDrawable rLottieDrawable = P0;
                int i11 = u6;
                rLottieDrawable.n0("Arrow1.**", p0(i11));
                P0.n0("Arrow2.**", p0(i11));
                RLottieDrawable rLottieDrawable2 = P0;
                int i12 = r6;
                rLottieDrawable2.n0("Box2.**", p0(i12));
                P0.n0("Box1.**", p0(i12));
                P0.B();
                V0 = false;
                P0.b0(true);
                S0.w();
                RLottieDrawable rLottieDrawable3 = S0;
                int i13 = L7;
                rLottieDrawable3.n0("Arrow.**", p0(i13));
                S0.n0("Line.**", p0(i13));
                S0.B();
                T0.w();
                T0.n0("Arrow.**", p0(i13));
                T0.n0("Line.**", p0(i13));
                T0.B();
                U0.w();
                RLottieDrawable rLottieDrawable4 = U0;
                int i14 = J7;
                rLottieDrawable4.n0("Line 1.**", p0(i14));
                U0.n0("Line 2.**", p0(i14));
                U0.n0("Line 3.**", p0(i14));
                U0.n0("Cup Red.**", p0(i13));
                U0.n0("Box.**", p0(i13));
                U0.B();
                Q0.w();
                Q0.n0("Arrow.**", p0(i14));
                Q0.n0("Box2.**", p0(i13));
                Q0.n0("Box1.**", p0(i13));
                Q0.B();
                R0.w();
                R0.n0("Arrow1.**", p0(i13));
                R0.n0("Arrow2.**", p0(K7));
                R0.n0("Box2.**", p0(i13));
                R0.n0("Box1.**", p0(i13));
                R0.B();
                r2 = new PorterDuffColorFilter(i0(p5), PorterDuff.Mode.SRC_IN);
                return;
            }
            e1(drawableArr[i10], r6);
            i10++;
        }
    }

    public static Drawable u0(int i10, boolean z10) {
        return z10 ? t0(i10, N4) : Z(i10, 2);
    }

    public static void v(boolean z10) {
        if (H != null) {
            return;
        }
        if (z10) {
            k kVar = D;
            k kVar2 = E;
            if (kVar != kVar2) {
                if (kVar == null || !(kVar2 == null || kVar.u() == E.u())) {
                    J = true;
                    g = SystemClock.elapsedRealtime();
                    I = true;
                    E.j().s(E.V2, E, Boolean.TRUE, null, -1);
                    I = false;
                    return;
                }
                return;
            }
            return;
        }
        k kVar3 = D;
        k kVar4 = F;
        if (kVar3 != kVar4) {
            if (kVar3 == null || !(kVar4 == null || kVar3.y() == F.y())) {
                J = false;
                g = SystemClock.elapsedRealtime();
                I = true;
                E.j().s(E.V2, F, Boolean.TRUE, null, -1);
                I = false;
            }
        }
    }

    public static Drawable v0(boolean z10) {
        return u0(i0(S4), z10);
    }

    public static void w() {
        if (m0 == null) {
            return;
        }
        for (int i10 = 0; i10 < 2; i10++) {
            m0[i10].setColor(i0(E7));
            n0[i10].setColor(i0(G7));
            TextPaint textPaint = q0[i10];
            int iI0 = i0(N7);
            textPaint.linkColor = iI0;
            textPaint.setColor(iI0);
            s0[i10].setColor(i0(W7));
        }
        o0.setColor(i0(E7));
        p0.setColor(i0(G7));
        TextPaint textPaint2 = r0;
        int iI02 = i0(T7);
        textPaint2.linkColor = iI02;
        textPaint2.setColor(iI02);
        f0.setColor(i0(Z7));
        g0.setColor(i0(Y7));
        t0.setColor(i0(X7));
        u0.setColor(i0(D7));
        TextPaint textPaint3 = v0;
        int i11 = M7;
        textPaint3.setColor(i0(i11));
        w0.setColor(i0(i11));
        h0.setColor(i0(B7));
        l0.setColor(i0(M4));
        j0.setColor(i0(C7));
        k0.setColor(i0(W7));
        i0.setColor(i0(d8));
        x0.setColor(i0(Y4));
        y0.setColor(i0(j5));
        e1(E0, H7);
        Drawable drawable = F0;
        int i12 = I7;
        e1(drawable, i12);
        e1(z0, a8);
        Drawable drawable2 = A0;
        int i13 = b8;
        e1(drawable2, i13);
        e1(B0, i13);
        e1(C0, e8);
        e1(K0, i12);
        e1(D0, i12);
        Drawable drawable3 = G0;
        int i14 = h8;
        e1(drawable3, i14);
        e1(H0, i14);
        Drawable drawable4 = L0;
        int i15 = i8;
        e1(drawable4, i15);
        e1(O0, N7);
        e1(M0, i15);
        e1(I0, f8);
        e1(J0, g8);
        e1(N0, h7);
    }

    public static Drawable w0(boolean z10, h hVar) {
        return u0(j0(S4, hVar), z10);
    }

    public static void x() {
        if (b1 == null) {
            return;
        }
        a1.setColor(i0(p5));
        a1.linkColor = i0(s5);
        e1(b1, qf);
        e1(c1, rf);
    }

    public static int x0() {
        int iIndexOfKey = Uh.indexOfKey(Oa);
        return iIndexOfKey >= 0 ? Uh.valueAt(iIndexOfKey) : N;
    }

    public static void y(k kVar, boolean z10) {
        z(kVar, true, z10);
    }

    private static Drawable y0(Drawable drawable, int i10) {
        if (Build.VERSION.SDK_INT >= 29 && (drawable instanceof StateListDrawable)) {
            return ((StateListDrawable) drawable).getStateDrawable(i10);
        }
        if (ci == null) {
            try {
                ci = StateListDrawable.class.getDeclaredMethod("getStateDrawable", Integer.TYPE);
            } catch (Throwable unused) {
            }
        }
        Method method = ci;
        if (method == null) {
            return null;
        }
        try {
            return (Drawable) method.invoke(drawable, Integer.valueOf(i10));
        } catch (Exception unused2) {
            return null;
        }
    }

    public static void z(k kVar, boolean z10, boolean z11) {
        A(kVar, z10, true, z11);
    }

    public static SparseIntArray z0(File file, String str, String[] strArr) throws IOException {
        int iIntValue;
        SparseIntArray sparseIntArray = new SparseIntArray();
        FileInputStream fileInputStream = null;
        try {
            try {
                byte[] bArr = new byte[1024];
                FileInputStream fileInputStream2 = new FileInputStream(str != null ? f0(str) : file);
                int i10 = -1;
                int i11 = -1;
                int i12 = 0;
                boolean z10 = false;
                while (true) {
                    try {
                        int i13 = fileInputStream2.read(bArr);
                        if (i13 == i10) {
                            break;
                        }
                        int i14 = 0;
                        int i15 = 0;
                        int i16 = i12;
                        while (true) {
                            if (i14 >= i13) {
                                break;
                            }
                            if (bArr[i14] == 10) {
                                int i17 = i14 - i15;
                                int i18 = i17 + 1;
                                String str2 = new String(bArr, i15, i17);
                                if (str2.startsWith("WLS=")) {
                                    if (strArr != null && strArr.length > 0) {
                                        strArr[0] = str2.substring(4);
                                    }
                                } else {
                                    if (str2.startsWith("WPS")) {
                                        i11 = i16 + i18;
                                        z10 = true;
                                        break;
                                    }
                                    int iIndexOf = str2.indexOf(61);
                                    if (iIndexOf != i10) {
                                        String strSubstring = str2.substring(0, iIndexOf);
                                        String strSubstring2 = str2.substring(iIndexOf + 1);
                                        if (strSubstring2.length() <= 0 || strSubstring2.charAt(0) != '#') {
                                            iIntValue = Utilities.h(strSubstring2).intValue();
                                        } else {
                                            try {
                                                iIntValue = Color.parseColor(strSubstring2);
                                            } catch (Exception unused) {
                                                iIntValue = Utilities.h(strSubstring2).intValue();
                                            }
                                        }
                                        int iD = AbstractC5261Io7.d(strSubstring);
                                        if (iD >= 0) {
                                            sparseIntArray.put(iD, iIntValue);
                                        }
                                    }
                                }
                                i15 += i18;
                                i16 += i18;
                            }
                            i14++;
                            i10 = -1;
                        }
                        if (i12 == i16) {
                            break;
                        }
                        fileInputStream2.getChannel().position(i16);
                        if (z10) {
                            break;
                        }
                        i12 = i16;
                        i10 = -1;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        try {
                            AbstractC6403Nl2.d(th);
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return sparseIntArray;
                        } finally {
                        }
                    }
                }
                sparseIntArray.put(S3, i11);
                fileInputStream2.close();
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e10) {
            AbstractC6403Nl2.d(e10);
        }
        return sparseIntArray;
    }

    public static class g {
        public String a;
        public String b;
        public String c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public boolean i;
        public boolean j;
        public float k;
        public k l;
        public j m;

        public g() {
            this.a = "";
            this.b = "";
            this.c = "";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            AbstractC14047hG.a.getSharedPreferences("themeconfig", 0).edit().remove(d()).commit();
            new File(AbstractC14047hG.b(), this.a).delete();
            new File(AbstractC14047hG.b(), this.b).delete();
        }

        private String d() {
            if (this.m == null) {
                return this.l.a + "_owp";
            }
            return this.l.a + "_" + this.m.a + "_owp";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e() {
            try {
                String strD = d();
                SharedPreferences.Editor editorEdit = AbstractC14047hG.a.getSharedPreferences("themeconfig", 0).edit();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("wall", this.a);
                jSONObject.put("owall", this.b);
                jSONObject.put("pColor", this.d);
                jSONObject.put("pGrColor", this.e);
                jSONObject.put("pGrColor2", this.f);
                jSONObject.put("pGrColor3", this.g);
                jSONObject.put("pGrAngle", this.h);
                String str = this.c;
                if (str == null) {
                    str = "";
                }
                jSONObject.put("wallSlug", str);
                jSONObject.put("wBlur", this.i);
                jSONObject.put("wMotion", this.j);
                jSONObject.put("pIntensity", this.k);
                editorEdit.putString(strD, jSONObject.toString());
                editorEdit.commit();
            } catch (Throwable th) {
                AbstractC6403Nl2.d(th);
            }
        }

        public g(g gVar, k kVar, j jVar) {
            this.a = "";
            this.b = "";
            this.c = "";
            this.c = gVar.c;
            this.d = gVar.d;
            this.e = gVar.e;
            this.f = gVar.f;
            this.g = gVar.g;
            this.h = gVar.h;
            this.i = gVar.i;
            this.j = gVar.j;
            this.k = gVar.k;
            this.l = kVar;
            this.m = jVar;
            if (!TextUtils.isEmpty(gVar.a)) {
                try {
                    File file = new File(AbstractC14047hG.b(), gVar.a);
                    File fileB = AbstractC14047hG.b();
                    String strP = this.l.p(this.m, false);
                    this.a = strP;
                    AbstractC21455b.B(file, new File(fileB, strP));
                } catch (Exception e) {
                    this.a = "";
                    AbstractC6403Nl2.d(e);
                }
            } else {
                this.a = "";
            }
            if (!TextUtils.isEmpty(gVar.b)) {
                if (!gVar.b.equals(gVar.a)) {
                    try {
                        File file2 = new File(AbstractC14047hG.b(), gVar.b);
                        File fileB2 = AbstractC14047hG.b();
                        String strP2 = this.l.p(this.m, true);
                        this.b = strP2;
                        AbstractC21455b.B(file2, new File(fileB2, strP2));
                        return;
                    } catch (Exception e2) {
                        this.b = "";
                        AbstractC6403Nl2.d(e2);
                        return;
                    }
                }
                this.b = this.a;
                return;
            }
            this.b = "";
        }
    }

    public static class i extends Drawable {
        private final float[] b;
        private final Path a = new Path();
        boolean c = true;

        public i(float f, float f2) {
            this.b = new float[]{F, F, F, F, F, F, F, F};
            float F = AbstractC21455b.F(f);
            float F2 = AbstractC21455b.F(f2);
        }

        public void a(float f, float f2) {
            float[] fArr = this.b;
            float F = AbstractC21455b.F(f);
            fArr[3] = F;
            fArr[2] = F;
            fArr[1] = F;
            fArr[0] = F;
            float[] fArr2 = this.b;
            float F2 = AbstractC21455b.F(f2);
            fArr2[7] = F2;
            fArr2[6] = F2;
            fArr2[5] = F2;
            fArr2[4] = F2;
            this.c = true;
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.c) {
                this.c = false;
                this.a.reset();
                RectF rectF = AbstractC21455b.x;
                rectF.set(getBounds());
                this.a.addRoundRect(rectF, this.b, Path.Direction.CW);
            }
            canvas.drawPath(this.a, m.x);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable
        protected void onBoundsChange(Rect rect) {
            this.c = true;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }

        public i(float f, float f2, float f3, float f4) {
            this.b = new float[]{F, F, F, F, F, F, F, F};
            float F = AbstractC21455b.F(f);
            float F2 = AbstractC21455b.F(f2);
            float F3 = AbstractC21455b.F(f3);
            float F4 = AbstractC21455b.F(f4);
        }
    }

    public static void j1(C10743c74 c10743c74) {
    }
}
