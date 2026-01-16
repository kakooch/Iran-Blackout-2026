package ir.nasim.chat;

import ai.bale.proto.MessagingStruct$DocumentMessage;
import ai.bale.proto.PeersStruct$ExPeer;
import ai.bale.proto.SearchOuterClass$ResponseSearchMessages;
import ai.bale.proto.SearchStruct$MessageSearchResult;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import android.webkit.MimeTypeMap;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.GlideException;
import com.google.gson.reflect.TypeToken;
import com.google.protobuf.BytesValue;
import com.google.protobuf.GeneratedMessageLite;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import ir.nasim.AbstractC10242bK;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC10976cX0;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC12281eL6;
import ir.nasim.AbstractC12542en2;
import ir.nasim.AbstractC12586er6;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC13554gQ7;
import ir.nasim.AbstractC13610gX0;
import ir.nasim.AbstractC13778go1;
import ir.nasim.AbstractC13790gp3;
import ir.nasim.AbstractC14251hc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC15208jB5;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC15729k44;
import ir.nasim.AbstractC17026mG5;
import ir.nasim.AbstractC17457n0;
import ir.nasim.AbstractC18050o01;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC19562qZ6;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC19981rG5;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC20084rS0;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC20906so1;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC23046wF7;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.AbstractC23145wQ7;
import ir.nasim.AbstractC23684xL1;
import ir.nasim.AbstractC24549yo1;
import ir.nasim.AbstractC3742Cd6;
import ir.nasim.AbstractC3860Cq7;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC4571Fr7;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.AbstractC6392Nk0;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.AbstractC6756Ov5;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.AbstractC9323Zl0;
import ir.nasim.AbstractC9395Zt0;
import ir.nasim.AbstractC9766aX0;
import ir.nasim.AbstractC9773aX7;
import ir.nasim.BI7;
import ir.nasim.BJ2;
import ir.nasim.C10054b01;
import ir.nasim.C10240bJ6;
import ir.nasim.C10299bQ2;
import ir.nasim.C10326bT2;
import ir.nasim.C10410bZ6;
import ir.nasim.C10844cI3;
import ir.nasim.C10872cL4;
import ir.nasim.C11458d25;
import ir.nasim.C11461d28;
import ir.nasim.C11637dL5;
import ir.nasim.C11907dl;
import ir.nasim.C12056dy;
import ir.nasim.C12280eL5;
import ir.nasim.C12366eV1;
import ir.nasim.C12798fB4;
import ir.nasim.C12872fJ6;
import ir.nasim.C12889fL5;
import ir.nasim.C12960fT4;
import ir.nasim.C13388g85;
import ir.nasim.C13437gD7;
import ir.nasim.C13518gM7;
import ir.nasim.C14225hZ6;
import ir.nasim.C14375ho5;
import ir.nasim.C14439hv;
import ir.nasim.C14505i18;
import ir.nasim.C14652iG2;
import ir.nasim.C14683iJ6;
import ir.nasim.C14697iL2;
import ir.nasim.C14733iO2;
import ir.nasim.C14970in2;
import ir.nasim.C16220ku1;
import ir.nasim.C16450lI2;
import ir.nasim.C16799lt;
import ir.nasim.C16885m18;
import ir.nasim.C16963m96;
import ir.nasim.C17050mJ2;
import ir.nasim.C17092mO;
import ir.nasim.C17448mz0;
import ir.nasim.C17483n25;
import ir.nasim.C17532n74;
import ir.nasim.C17626nH5;
import ir.nasim.C18039nz0;
import ir.nasim.C18074o25;
import ir.nasim.C18215oH3;
import ir.nasim.C18226oI5;
import ir.nasim.C18626oy5;
import ir.nasim.C18787pF2;
import ir.nasim.C18804pH1;
import ir.nasim.C18837pK7;
import ir.nasim.C18987pb3;
import ir.nasim.C19024pf0;
import ir.nasim.C19049ph5;
import ir.nasim.C19406qI3;
import ir.nasim.C19482qQ7;
import ir.nasim.C19493qS0;
import ir.nasim.C19711qo6;
import ir.nasim.C19751qs6;
import ir.nasim.C19938rB7;
import ir.nasim.C19951rD2;
import ir.nasim.C20021rL0;
import ir.nasim.C20610sI7;
import ir.nasim.C20800sd5;
import ir.nasim.C20919sp4;
import ir.nasim.C21159tC7;
import ir.nasim.C21167tD6;
import ir.nasim.C21191tG3;
import ir.nasim.C21231tK7;
import ir.nasim.C21376tZ0;
import ir.nasim.C22132uj0;
import ir.nasim.C22472vI2;
import ir.nasim.C22694vg2;
import ir.nasim.C23071wI5;
import ir.nasim.C23094wL1;
import ir.nasim.C23104wM2;
import ir.nasim.C23345wl7;
import ir.nasim.C23631xF2;
import ir.nasim.C23698xM6;
import ir.nasim.C24314yP5;
import ir.nasim.C24411ya3;
import ir.nasim.C24474yg6;
import ir.nasim.C24539yn1;
import ir.nasim.C24890zN5;
import ir.nasim.C24967zW1;
import ir.nasim.C25068zg6;
import ir.nasim.C25108zk6;
import ir.nasim.C25238zy;
import ir.nasim.C3343Am;
import ir.nasim.C3777Ch5;
import ir.nasim.C4382Ew7;
import ir.nasim.C4512Fl2;
import ir.nasim.C4627Fy0;
import ir.nasim.C4744Gj3;
import ir.nasim.C4892Gz7;
import ir.nasim.C5246In1;
import ir.nasim.C5495Jo7;
import ir.nasim.C5902Li0;
import ir.nasim.C6305Na3;
import ir.nasim.C6374Ni0;
import ir.nasim.C6409Nm;
import ir.nasim.C6517Nv5;
import ir.nasim.C6559Oa2;
import ir.nasim.C6634Oi0;
import ir.nasim.C6658Ok6;
import ir.nasim.C6833Pe1;
import ir.nasim.C6892Pk6;
import ir.nasim.C7234Qv5;
import ir.nasim.C7880To7;
import ir.nasim.C7906Tr6;
import ir.nasim.C8054Ui1;
import ir.nasim.C8386Vt0;
import ir.nasim.C8445Vz5;
import ir.nasim.C8512Wh0;
import ir.nasim.C8540Wk1;
import ir.nasim.C8920Xu5;
import ir.nasim.C8967Xz7;
import ir.nasim.C9475a16;
import ir.nasim.C9616aG3;
import ir.nasim.CI7;
import ir.nasim.DB3;
import ir.nasim.DD5;
import ir.nasim.DH5;
import ir.nasim.DV;
import ir.nasim.DX1;
import ir.nasim.E84;
import ir.nasim.EB2;
import ir.nasim.ED1;
import ir.nasim.EH5;
import ir.nasim.EM2;
import ir.nasim.EP5;
import ir.nasim.EnumC10088b35;
import ir.nasim.EnumC11636dL4;
import ir.nasim.EnumC16311l35;
import ir.nasim.EnumC16528lR;
import ir.nasim.EnumC16752lo2;
import ir.nasim.EnumC17253mf2;
import ir.nasim.EnumC20560sD2;
import ir.nasim.EnumC21012sz1;
import ir.nasim.EnumC21528th6;
import ir.nasim.EnumC23558x74;
import ir.nasim.EnumC24421yb3;
import ir.nasim.EnumC24659yz5;
import ir.nasim.EnumC3487Bb3;
import ir.nasim.EnumC3633Br5;
import ir.nasim.EnumC3721Cb3;
import ir.nasim.EnumC4196Ec1;
import ir.nasim.EnumC5360Iz7;
import ir.nasim.EnumC9477a18;
import ir.nasim.EnumC9567aB;
import ir.nasim.F17;
import ir.nasim.F84;
import ir.nasim.FD3;
import ir.nasim.FD7;
import ir.nasim.FF6;
import ir.nasim.FJ;
import ir.nasim.FM2;
import ir.nasim.FP5;
import ir.nasim.FS7;
import ir.nasim.FU;
import ir.nasim.G73;
import ir.nasim.GE4;
import ir.nasim.GS7;
import ir.nasim.HE0;
import ir.nasim.HG1;
import ir.nasim.HM2;
import ir.nasim.HM5;
import ir.nasim.HQ0;
import ir.nasim.I5;
import ir.nasim.IE0;
import ir.nasim.IF3;
import ir.nasim.IM5;
import ir.nasim.IN5;
import ir.nasim.IQ0;
import ir.nasim.IT5;
import ir.nasim.InterfaceC10210bG3;
import ir.nasim.InterfaceC10223bH7;
import ir.nasim.InterfaceC10258bL6;
import ir.nasim.InterfaceC10503bj0;
import ir.nasim.InterfaceC11621dJ7;
import ir.nasim.InterfaceC12532em2;
import ir.nasim.InterfaceC13136fj0;
import ir.nasim.InterfaceC13727gj0;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC14756iQ7;
import ir.nasim.InterfaceC15419jZ0;
import ir.nasim.InterfaceC16527lQ7;
import ir.nasim.InterfaceC16863lz6;
import ir.nasim.InterfaceC17527n7;
import ir.nasim.InterfaceC17569nB2;
import ir.nasim.InterfaceC18505om2;
import ir.nasim.InterfaceC19567qa2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC20642sM3;
import ir.nasim.InterfaceC20667sP1;
import ir.nasim.InterfaceC21103t7;
import ir.nasim.InterfaceC21549tj7;
import ir.nasim.InterfaceC21893uJ4;
import ir.nasim.InterfaceC22848vv0;
import ir.nasim.InterfaceC24449ye1;
import ir.nasim.InterfaceC3273Ae1;
import ir.nasim.InterfaceC3346Am2;
import ir.nasim.InterfaceC3544Bh6;
import ir.nasim.InterfaceC3570Bk5;
import ir.nasim.InterfaceC4335Er5;
import ir.nasim.InterfaceC4557Fq2;
import ir.nasim.InterfaceC4569Fr5;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.InterfaceC5520Jr5;
import ir.nasim.InterfaceC5943Lm5;
import ir.nasim.InterfaceC6334Nd5;
import ir.nasim.InterfaceC6990Pv5;
import ir.nasim.InterfaceC7486Rx5;
import ir.nasim.InterfaceC7857Tm2;
import ir.nasim.InterfaceC8091Um2;
import ir.nasim.InterfaceC8344Vo3;
import ir.nasim.InterfaceC8807Xk2;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.InterfaceC9336Zm4;
import ir.nasim.J08;
import ir.nasim.J44;
import ir.nasim.JF3;
import ir.nasim.JM6;
import ir.nasim.JQ0;
import ir.nasim.K35;
import ir.nasim.KB5;
import ir.nasim.KM2;
import ir.nasim.KS2;
import ir.nasim.KW3;
import ir.nasim.LC3;
import ir.nasim.LD3;
import ir.nasim.MT4;
import ir.nasim.NA3;
import ir.nasim.NR;
import ir.nasim.NT4;
import ir.nasim.OK7;
import ir.nasim.OP5;
import ir.nasim.P25;
import ir.nasim.PD3;
import ir.nasim.PG5;
import ir.nasim.Q64;
import ir.nasim.QF2;
import ir.nasim.QF6;
import ir.nasim.QG2;
import ir.nasim.QR;
import ir.nasim.R74;
import ir.nasim.RQ;
import ir.nasim.RW1;
import ir.nasim.RY1;
import ir.nasim.S08;
import ir.nasim.S74;
import ir.nasim.SA2;
import ir.nasim.SR;
import ir.nasim.SZ2;
import ir.nasim.UA2;
import ir.nasim.UG7;
import ir.nasim.V13;
import ir.nasim.V9;
import ir.nasim.VE4;
import ir.nasim.VO5;
import ir.nasim.VW7;
import ir.nasim.VoiceTranscript;
import ir.nasim.W25;
import ir.nasim.WA1;
import ir.nasim.WF2;
import ir.nasim.WF3;
import ir.nasim.WM3;
import ir.nasim.WO5;
import ir.nasim.WU;
import ir.nasim.X25;
import ir.nasim.XV4;
import ir.nasim.XY6;
import ir.nasim.YT4;
import ir.nasim.YV0;
import ir.nasim.Z06;
import ir.nasim.ZF3;
import ir.nasim.ZN2;
import ir.nasim.chat.ChatViewModel;
import ir.nasim.core.modules.banking.BankingModule;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.messaging.history.entity.CurrentlyHistoryIsLoading;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.AvatarImage;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.core.network.RpcException;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.attach.model.AttachmentData;
import ir.nasim.features.attach.model.ShareAttachment;
import ir.nasim.features.share.ShareData;
import ir.nasim.story.repository.StoryRepository;
import ir.nasim.utils.share.SharedContent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes4.dex */
public final class ChatViewModel extends VW7 {
    public static final C11152c R2 = new C11152c(null);
    public static final int S2 = 8;
    private final InterfaceC20642sM3 A;
    private final FP5 A0;
    private final ExPeerType A1;
    private final C21167tD6 A2;
    private final UG7 B;
    private final FD7 B0;
    private final C11458d25 B1;
    private final InterfaceC9173Yu3 B2;
    private final C17626nH5.a C0;
    private final Boolean C1;
    private boolean C2;
    private final C6559Oa2 D;
    private final C25108zk6.a D0;
    private final String D1;
    private final InterfaceC9336Zm4 D2;
    private final C20800sd5.a E0;
    private final InterfaceC9173Yu3 E1;
    private final InterfaceC10258bL6 E2;
    private final InterfaceC19567qa2 F0;
    private final InterfaceC9173Yu3 F1;
    private final InterfaceC9173Yu3 F2;
    private final int G;
    private final EP5 G0;
    private final InterfaceC9173Yu3 G1;
    private InterfaceC13730gj3 G2;
    private final BankingModule H;
    private final C18837pK7 H0;
    private final boolean H1;
    private final InterfaceC9173Yu3 H2;
    private final C23631xF2 I0;
    private final int I1;
    private final InterfaceC9173Yu3 I2;
    private final C11461d28 J;
    private final C4744Gj3 J0;
    private final InterfaceC9173Yu3 J1;
    private final InterfaceC5520Jr5 J2;
    private final C21376tZ0 K0;
    private final InterfaceC9173Yu3 K1;
    private final InterfaceC13136fj0 K2;
    private final C24474yg6 L0;
    private C14733iO2 L1;
    private final HM2 L2;
    private final C18804pH1 M0;
    private C21231tK7 M1;
    private final InterfaceC9336Zm4 M2;
    private final C19711qo6 N0;
    private C5246In1 N1;
    private final InterfaceC10258bL6 N2;
    private final NR O0;
    private final C20919sp4 O1;
    private InterfaceC13730gj3 O2;
    private final InterfaceC13727gj0 P0;
    private boolean P1;
    private final InterfaceC9173Yu3 P2;
    private final ZF3 Q0;
    private long Q1;
    private final HashSet Q2;
    private final InterfaceC20667sP1 R0;
    private long R1;
    private final InterfaceC6334Nd5 S0;
    private int S1;
    private final QF2 T0;
    private final InterfaceC12532em2 U0;
    private int U1;
    private final InterfaceC20315ro1 V0;
    private long V1;
    private final InterfaceC3570Bk5 W0;
    private long W1;
    private final C3777Ch5 X0;
    private long X1;
    private final C4892Gz7 Y;
    private final InterfaceC7486Rx5 Y0;
    private final InterfaceC9336Zm4 Y1;
    private final C14375ho5 Z;
    private final InterfaceC5943Lm5 Z0;
    private final InterfaceC9336Zm4 Z1;
    private FU a1;
    private final InterfaceC10258bL6 a2;
    private final AbstractC13778go1 b;
    private String b1;
    private final InterfaceC9336Zm4 b2;
    private final C23094wL1 c;
    private boolean c1;
    private final InterfaceC10258bL6 c2;
    private final SettingsModule d;
    private final InterfaceC9173Yu3 d1;
    private final EnumC16752lo2 d2;
    private final VE4 e;
    private final IF3 e1;
    private final InterfaceC9336Zm4 e2;
    private final C10299bQ2 f;
    private final InterfaceC9173Yu3 f1;
    private final InterfaceC10258bL6 f2;
    private final OK7 g;
    private final InterfaceC9336Zm4 g1;
    private final InterfaceC10258bL6 g2;
    private final C8054Ui1 h;
    private final InterfaceC10258bL6 h1;
    private final Map h2;
    private final C14970in2 i;
    private final InterfaceC9336Zm4 i1;
    private final InterfaceC9336Zm4 i2;
    private final KM2 j;
    private final InterfaceC10258bL6 j1;
    private final InterfaceC9336Zm4 j2;
    private final StoryRepository k;
    private final InterfaceC9336Zm4 k1;
    private final InterfaceC10258bL6 k2;
    private final InterfaceC11621dJ7 l;
    private final InterfaceC10258bL6 l1;
    private final InterfaceC9336Zm4 l2;
    private final F84 m;
    private final InterfaceC10258bL6 m1;
    private final InterfaceC10258bL6 m2;
    private final C16450lI2 n;
    private final InterfaceC9336Zm4 n1;
    private final InterfaceC10258bL6 n2;
    private final InterfaceC21103t7 o;
    private boolean o1;
    private final InterfaceC9336Zm4 o2;
    private final InterfaceC17527n7 p;
    private boolean p1;
    private boolean p2;
    private final V9 q;
    private final C21191tG3 q1;
    private long q2;
    private final IN5 r;
    private final InterfaceC9173Yu3 r1;
    private boolean r2;
    private final WF2 s;
    private final InterfaceC9173Yu3 s1;
    private boolean s2;
    private final C14652iG2 t;
    private List t1;
    private boolean t2;
    private final C24314yP5 u;
    private HQ0 u1;
    private C23071wI5 u2;
    private final E84 v;
    private C14683iJ6 v1;
    private boolean v2;
    private final C6409Nm w;
    private boolean w1;
    private final C10054b01 w2;
    private final InterfaceC3570Bk5 x;
    private final InterfaceC9336Zm4 x1;
    private long x2;
    private final C4627Fy0 y;
    private final InterfaceC4557Fq2 y1;
    private long y2;
    private final C16220ku1 z;
    private final InterfaceC3570Bk5 z0;
    private final C11458d25 z1;
    private final C21167tD6 z2;

    static final class A extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        A(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return ChatViewModel.this.i5(null, null, this);
        }
    }

    static final class A0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        final /* synthetic */ long f;
        final /* synthetic */ long g;
        final /* synthetic */ int h;
        final /* synthetic */ int i;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ ChatViewModel c;
            final /* synthetic */ J44 d;
            final /* synthetic */ C12280eL5 e;
            final /* synthetic */ C12280eL5 f;
            final /* synthetic */ int g;
            final /* synthetic */ int h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ChatViewModel chatViewModel, J44 j44, C12280eL5 c12280eL5, C12280eL5 c12280eL52, int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = chatViewModel;
                this.d = j44;
                this.e = c12280eL5;
                this.f = c12280eL52;
                this.g = i;
                this.h = i2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, this.e, this.f, this.g, this.h, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C14733iO2 c14733iO2W6 = this.c.w6();
                    if ((c14733iO2W6 != null ? c14733iO2W6.p() : null) == ExPeerType.GROUP) {
                        F84.l.b(this.d);
                        return this.d;
                    }
                    F84 f84 = this.c.m;
                    long j = this.e.a;
                    long j2 = this.f.a;
                    int i2 = this.g;
                    int i3 = this.h;
                    this.b = 1;
                    obj = f84.k(j, j2, i2, i3, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return obj;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        A0(long j, long j2, int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.f = j;
            this.g = j2;
            this.h = i;
            this.i = i2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new A0(this.f, this.g, this.h, this.i, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:48:0x012a  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0137  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r40) {
            /*
                Method dump skipped, instructions count: 576
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.A0.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((A0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class A1 implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ ChatViewModel b;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ ChatViewModel b;

            /* renamed from: ir.nasim.chat.ChatViewModel$A1$a$a, reason: collision with other inner class name */
            public static final class C0965a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0965a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, ChatViewModel chatViewModel) {
                this.a = interfaceC4806Gq2;
                this.b = chatViewModel;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof ir.nasim.chat.ChatViewModel.A1.a.C0965a
                    if (r0 == 0) goto L13
                    r0 = r7
                    ir.nasim.chat.ChatViewModel$A1$a$a r0 = (ir.nasim.chat.ChatViewModel.A1.a.C0965a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.chat.ChatViewModel$A1$a$a r0 = new ir.nasim.chat.ChatViewModel$A1$a$a
                    r0.<init>(r7)
                L18:
                    java.lang.Object r7 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r7)
                    goto L52
                L29:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L31:
                    ir.nasim.AbstractC10685c16.b(r7)
                    ir.nasim.Gq2 r7 = r5.a
                    r2 = r6
                    ir.nasim.uE7 r2 = (ir.nasim.C21851uE7) r2
                    int r2 = r2.b()
                    ir.nasim.chat.ChatViewModel r4 = r5.b
                    ir.nasim.d25 r4 = ir.nasim.chat.ChatViewModel.c3(r4)
                    int r4 = r4.getPeerId()
                    if (r2 != r4) goto L52
                    r0.b = r3
                    java.lang.Object r6 = r7.a(r6, r0)
                    if (r6 != r1) goto L52
                    return r1
                L52:
                    ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.A1.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public A1(InterfaceC4557Fq2 interfaceC4557Fq2, ChatViewModel chatViewModel) {
            this.a = interfaceC4557Fq2;
            this.b = chatViewModel;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    static final class B extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ SharedContent.MediaContent d;
        final /* synthetic */ Context e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        B(SharedContent.MediaContent mediaContent, Context context, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = mediaContent;
            this.e = context;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            B b = new B(this.d, this.e, interfaceC20295rm1);
            b.c = obj;
            return b;
        }

        /* JADX WARN: Removed duplicated region for block: B:63:0x016d  */
        /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instructions count: 462
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.B.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((B) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class B0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ ExPeerType c;
            final /* synthetic */ C11458d25 d;
            final /* synthetic */ ChatViewModel e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ExPeerType exPeerType, C11458d25 c11458d25, ChatViewModel chatViewModel, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = exPeerType;
                this.d = c11458d25;
                this.e = chatViewModel;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    if (this.c != null) {
                        C18987pb3.p1(C18987pb3.a, this.d, AbstractC6392Nk0.e(0L), AbstractC6392Nk0.e(0L), false, "", null, false, false, 192, null);
                        return C19938rB7.a;
                    }
                    C6517Nv5 c6517Nv5W = this.e.B.W(AbstractC10360bX0.s(new C25238zy(this.d.getPeerId(), 0L)));
                    AbstractC13042fc3.h(c6517Nv5W, "forceLoadRequiredGroupPeers(...)");
                    this.b = 1;
                    if (AbstractC6756Ov5.d(c6517Nv5W, null, this, 1, null) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    ((C9475a16) obj).l();
                }
                C18987pb3.p1(C18987pb3.a, this.d, AbstractC6392Nk0.e(0L), AbstractC6392Nk0.e(0L), false, "", null, false, false, 192, null);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        B0(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new B0(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C11458d25 c11458d25R = C11458d25.r(6180860182L);
                AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
                ExPeerType exPeerTypeA = X25.a(c11458d25R);
                WM3 wm3C = C12366eV1.c();
                a aVar = new a(exPeerTypeA, c11458d25R, ChatViewModel.this, null);
                this.b = 1;
                if (AbstractC9323Zl0.g(wm3C, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((B0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class B1 implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.chat.ChatViewModel$B1$a$a, reason: collision with other inner class name */
            public static final class C0966a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0966a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = interfaceC4806Gq2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof ir.nasim.chat.ChatViewModel.B1.a.C0966a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.chat.ChatViewModel$B1$a$a r0 = (ir.nasim.chat.ChatViewModel.B1.a.C0966a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.chat.ChatViewModel$B1$a$a r0 = new ir.nasim.chat.ChatViewModel$B1$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L43
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    boolean r2 = r5 instanceof ir.nasim.C21851uE7
                    if (r2 == 0) goto L43
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L43
                    return r1
                L43:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.B1.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public B1(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    static final class C extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new C(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            List listT0;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (ChatViewModel.this.H8()) {
                    return C19938rB7.a;
                }
                ChatViewModel chatViewModel = ChatViewModel.this;
                int i2 = this.d;
                this.b = 1;
                obj = chatViewModel.o9(i2, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            ChatViewModel chatViewModel2 = ChatViewModel.this;
            List list = (List) obj;
            InterfaceC9336Zm4 interfaceC9336Zm4 = chatViewModel2.l2;
            do {
                value = interfaceC9336Zm4.getValue();
                List list2 = list;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(new S74((J44) it.next()));
                }
                listT0 = AbstractC15401jX0.T0(arrayList);
                long jAbs = 0;
                long j = chatViewModel2.x.getLong("pin_locally_removed_Date" + chatViewModel2.z1.getPeerId(), 0L);
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    jAbs += Math.abs(((J44) it2.next()).h());
                }
                if (j >= jAbs) {
                    listT0 = null;
                }
                if (listT0 == null) {
                    listT0 = AbstractC10360bX0.m();
                }
            } while (!interfaceC9336Zm4.f(value, listT0));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class C0 extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        C0(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            Object objR9 = ChatViewModel.this.R9(0, null, this);
            return objR9 == AbstractC14862ic3.e() ? objR9 : C9475a16.a(objR9);
        }
    }

    public static final class C1 implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC18050o01.d(Long.valueOf(((S74) obj).a().h()), Long.valueOf(((S74) obj2).a().h()));
        }
    }

    static final class D extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;
        final /* synthetic */ long e;
        final /* synthetic */ long f;

        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ ChatViewModel a;

            a(ChatViewModel chatViewModel) {
                this.a = chatViewModel;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(NT4 nt4, InterfaceC20295rm1 interfaceC20295rm1) {
                this.a.o2.setValue(nt4);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        D(String str, long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
            this.e = j;
            this.f = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final YT4 y(ChatViewModel chatViewModel, String str, long j, long j2) {
            return new EH5(chatViewModel.C0.a(str, j, chatViewModel.z1, j2));
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new D(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                MT4 mt4 = new MT4(20, 0, false, 20, 0, 0, 50, null);
                final ChatViewModel chatViewModel = ChatViewModel.this;
                final String str = this.d;
                final long j = this.e;
                final long j2 = this.f;
                InterfaceC4557Fq2 interfaceC4557Fq2A = AbstractC9395Zt0.a(new C12960fT4(mt4, null, new SA2() { // from class: ir.nasim.chat.Y0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return ChatViewModel.D.y(chatViewModel, str, j, j2);
                    }
                }, 2, null).a(), AbstractC9773aX7.a(ChatViewModel.this));
                a aVar = new a(ChatViewModel.this);
                this.b = 1;
                if (interfaceC4557Fq2A.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((D) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class D0 extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        D0(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objS9 = ChatViewModel.this.S9(null, false, this);
            return objS9 == AbstractC14862ic3.e() ? objS9 : C9475a16.a(objS9);
        }
    }

    static final class D1 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ SA2 e;
        final /* synthetic */ UA2 f;
        final /* synthetic */ UA2 g;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ ChatViewModel c;
            final /* synthetic */ J44 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ChatViewModel chatViewModel, J44 j44, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = chatViewModel;
                this.d = j44;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    NR nr = this.c.O0;
                    SR sr = SR.d;
                    this.b = 1;
                    obj = nr.c(sr, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        return C19938rB7.a;
                    }
                    AbstractC10685c16.b(obj);
                }
                String str = (String) obj;
                if (str != null) {
                    ChatViewModel chatViewModel = this.c;
                    J44 j44 = this.d;
                    if (true ^ AbstractC20762sZ6.n0(str)) {
                        InterfaceC13727gj0 interfaceC13727gj0 = chatViewModel.P0;
                        int iU = j44.U();
                        long jI = j44.i();
                        long jH = j44.h();
                        this.b = 2;
                        if (interfaceC13727gj0.c(str, iU, jI, jH, this) == objE) {
                            return objE;
                        }
                    }
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public /* synthetic */ class b {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[RQ.values().length];
                try {
                    iArr[RQ.a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RQ.b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[RQ.c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        D1(SA2 sa2, UA2 ua2, UA2 ua22, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = sa2;
            this.f = ua2;
            this.g = ua22;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(ChatViewModel chatViewModel, boolean z, J44 j44) {
            if (z) {
                AbstractC10533bm0.d(AbstractC9773aX7.a(chatViewModel), null, null, new a(chatViewModel, j44, null), 3, null);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            D1 d1 = ChatViewModel.this.new D1(this.e, this.f, this.g, interfaceC20295rm1);
            d1.c = obj;
            return d1;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objG;
            Object value;
            JQ0 jq0;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                NR nr = ChatViewModel.this.O0;
                this.c = interfaceC20315ro1;
                this.b = 1;
                objG = nr.g(this);
                if (objG == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objG = obj;
            }
            C19493qS0 c19493qS0 = (C19493qS0) ((QR) objG).a();
            if (c19493qS0 == null) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = ChatViewModel.this.g1;
                do {
                    value = interfaceC9336Zm4.getValue();
                    jq0 = (JQ0) value;
                } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : AbstractC4616Fw7.a(null, AbstractC6392Nk0.d(DD5.error_unknown)), (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
                return C19938rB7.a;
            }
            int i2 = b.a[AbstractC20084rS0.a(c19493qS0).ordinal()];
            if (i2 == 1) {
                this.e.invoke();
            } else if (i2 == 2) {
                this.f.invoke(AbstractC6392Nk0.a(true));
            } else {
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                this.f.invoke(AbstractC6392Nk0.a(false));
            }
            UA2 ua2 = this.g;
            final ChatViewModel chatViewModel = ChatViewModel.this;
            ua2.invoke(new InterfaceC14603iB2() { // from class: ir.nasim.chat.h1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj2, Object obj3) {
                    return ChatViewModel.D1.y(chatViewModel, ((Boolean) obj2).booleanValue(), (J44) obj3);
                }
            });
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((D1) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class E extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ long e;

        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ ChatViewModel a;

            a(ChatViewModel chatViewModel) {
                this.a = chatViewModel;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(NT4 nt4, InterfaceC20295rm1 interfaceC20295rm1) {
                this.a.i2.setValue(nt4);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        E(long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final YT4 y(ChatViewModel chatViewModel, long j, long j2) {
            return new C6892Pk6(chatViewModel.D0.a(j, chatViewModel.z1, chatViewModel.m6(), j2));
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new E(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                MT4 mt4 = new MT4(20, 0, false, 20, 0, 0, 50, null);
                final ChatViewModel chatViewModel = ChatViewModel.this;
                final long j = this.d;
                final long j2 = this.e;
                InterfaceC4557Fq2 interfaceC4557Fq2A = AbstractC9395Zt0.a(new C12960fT4(mt4, null, new SA2() { // from class: ir.nasim.chat.Z0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return ChatViewModel.E.y(chatViewModel, j, j2);
                    }
                }, 2, null).a(), AbstractC9773aX7.a(ChatViewModel.this));
                a aVar = new a(ChatViewModel.this);
                this.b = 1;
                if (interfaceC4557Fq2A.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((E) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class E0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        E0(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            E0 e0 = ChatViewModel.this.new E0(interfaceC20295rm1);
            e0.c = obj;
            return e0;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            FD3 fd3 = (FD3) ((Map) this.c).get(AbstractC6392Nk0.e(ChatViewModel.this.z1.u()));
            if (fd3 == null || !fd3.f()) {
                return null;
            }
            return fd3;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Map map, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((E0) create(map, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class E1 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ SA2 e;
        final /* synthetic */ UA2 f;
        final /* synthetic */ SA2 g;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[RQ.values().length];
                try {
                    iArr[RQ.a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RQ.b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[RQ.c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        E1(SA2 sa2, UA2 ua2, SA2 sa22, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = sa2;
            this.f = ua2;
            this.g = sa22;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            E1 e1 = ChatViewModel.this.new E1(this.e, this.f, this.g, interfaceC20295rm1);
            e1.c = obj;
            return e1;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objG;
            Object value;
            JQ0 jq0;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                NR nr = ChatViewModel.this.O0;
                this.c = interfaceC20315ro1;
                this.b = 1;
                objG = nr.g(this);
                if (objG == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objG = obj;
            }
            C19493qS0 c19493qS0 = (C19493qS0) ((QR) objG).a();
            if (c19493qS0 == null) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = ChatViewModel.this.g1;
                do {
                    value = interfaceC9336Zm4.getValue();
                    jq0 = (JQ0) value;
                } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : AbstractC4616Fw7.a(null, AbstractC6392Nk0.d(DD5.error_unknown)), (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
                return C19938rB7.a;
            }
            int i2 = a.a[AbstractC20084rS0.a(c19493qS0).ordinal()];
            if (i2 == 1) {
                this.e.invoke();
            } else if (i2 == 2) {
                this.f.invoke(AbstractC6392Nk0.a(true));
            } else {
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                this.f.invoke(AbstractC6392Nk0.a(false));
            }
            this.g.invoke();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((E1) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class F extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C14683iJ6 c;
        final /* synthetic */ ChatViewModel d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        F(C14683iJ6 c14683iJ6, ChatViewModel chatViewModel, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c14683iJ6;
            this.d = chatViewModel;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new F(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Long lE;
            Long lE2;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C12872fJ6 c12872fJ6 = new C12872fJ6(new C8540Wk1(new C18215oH3(this.c, this.d.z1.getPeerId())));
            if (this.d.kc()) {
                Long lM = this.d.m.m(this.d.z1);
                lE2 = null;
                lE = lM != null ? AbstractC6392Nk0.e(lM.longValue() - 1) : null;
                Long lM2 = this.d.m.m(this.d.z1);
                if (lM2 != null) {
                    lE2 = AbstractC6392Nk0.e(lM2.longValue() - 1);
                }
            } else {
                Long lM3 = this.d.m.m(this.d.z1);
                lE = AbstractC6392Nk0.e(lM3 != null ? lM3.longValue() + 1 : System.currentTimeMillis());
                Long lM4 = this.d.m.m(this.d.z1);
                lE2 = lM4 != null ? AbstractC6392Nk0.e(lM4.longValue() + 1) : AbstractC6392Nk0.e(System.currentTimeMillis());
            }
            Long l = lE2;
            if (lE == null) {
                return C19938rB7.a;
            }
            if (l == null) {
                return C19938rB7.a;
            }
            this.d.m.i(this.d.z1, new J44(AbstractC19981rG5.a(), lE.longValue(), l.longValue(), this.d.z1.getPeerId(), EnumC23558x74.SENT, c12872fJ6, null, 0, null, null, 0L, null, null, false, null, null, false, null, null, 524224, null));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((F) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class F0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        F0(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            F0 f0 = ChatViewModel.this.new F0(interfaceC20295rm1);
            f0.c = obj;
            return f0;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            FD3 fd3;
            C22694vg2 c22694vg2V;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            byte[] bArrC = null;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                FD3 fd32 = (FD3) this.c;
                if (fd32 == null) {
                    return null;
                }
                ZF3 zf3 = ChatViewModel.this.Q0;
                C11458d25 c11458d25D = fd32.d();
                long jB = fd32.b();
                this.c = fd32;
                this.b = 1;
                objB = zf3.b(c11458d25D, jB, this);
                if (objB == objE) {
                    return objE;
                }
                fd3 = fd32;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                fd3 = (FD3) this.c;
                AbstractC10685c16.b(obj);
                objB = obj;
            }
            J44 j44 = (J44) objB;
            if (j44 == null) {
                return null;
            }
            C11458d25 c11458d25D2 = fd3.d();
            long jA = fd3.a();
            long jC = fd3.c();
            long jB2 = fd3.b();
            String strValueOf = String.valueOf(fd3.e());
            C23345wl7 c23345wl7L = j44.F().l();
            String strV = c23345wl7L != null ? c23345wl7L.v() : null;
            C24967zW1 c24967zW1H = j44.H();
            if (c24967zW1H != null && (c22694vg2V = c24967zW1H.v()) != null) {
                bArrC = c22694vg2V.c();
            }
            return new PD3(c11458d25D2, jA, strV, jC, jB2, strValueOf, bArrC);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(FD3 fd3, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((F0) create(fd3, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class F1 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        private /* synthetic */ Object d;
        final /* synthetic */ C8967Xz7 e;
        final /* synthetic */ ChatViewModel f;
        final /* synthetic */ long g;
        final /* synthetic */ long h;
        final /* synthetic */ SA2 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        F1(C8967Xz7 c8967Xz7, ChatViewModel chatViewModel, long j, long j2, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = c8967Xz7;
            this.f = chatViewModel;
            this.g = j;
            this.h = j2;
            this.i = sa2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            F1 f1 = new F1(this.e, this.f, this.g, this.h, this.i, interfaceC20295rm1);
            f1.d = obj;
            return f1;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            J08 j08;
            Object objD;
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.d;
                AbstractC17457n0 abstractC17457n0F = this.e.j().F();
                j08 = abstractC17457n0F instanceof J08 ? (J08) abstractC17457n0F : null;
                if (j08 == null) {
                    this.i.invoke();
                    return C19938rB7.a;
                }
                this.f.Kc(J44.D(this.e.j(), 0L, 0L, 0L, 0, null, J08.l.a(j08, VoiceTranscript.c(j08.J(), EnumC9477a18.c, null, false, 6, null)), null, 0, null, null, 0L, null, null, false, null, false, null, null, 262111, null));
                C6517Nv5 c6517Nv5O2 = this.f.v.O2(this.f.z1, this.f.m6(), AbstractC6392Nk0.e(this.e.j().i()), AbstractC6392Nk0.e(this.e.j().h()), AbstractC6392Nk0.e(this.g), AbstractC6392Nk0.e(this.h), j08);
                AbstractC13042fc3.h(c6517Nv5O2, "voiceToTextMessage(...)");
                this.d = interfaceC20315ro1;
                this.b = j08;
                this.c = 1;
                objD = AbstractC6756Ov5.d(c6517Nv5O2, null, this, 1, null);
                if (objD == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                J08 j082 = (J08) this.b;
                AbstractC10685c16.b(obj);
                objD = ((C9475a16) obj).l();
                j08 = j082;
            }
            if (C9475a16.j(objD)) {
                Pair pair = (Pair) objD;
                if (((Boolean) pair.second).booleanValue()) {
                    return C19938rB7.a;
                }
                MessagingStruct$DocumentMessage messagingStruct$DocumentMessage = (MessagingStruct$DocumentMessage) pair.first;
                if (messagingStruct$DocumentMessage == null) {
                    return C19938rB7.a;
                }
                objB = C9475a16.b(messagingStruct$DocumentMessage);
            } else {
                objB = C9475a16.b(objD);
            }
            ChatViewModel chatViewModel = this.f;
            C8967Xz7 c8967Xz7 = this.e;
            SA2 sa2 = this.i;
            Throwable thE = C9475a16.e(objB);
            if (thE == null) {
                C19406qI3.a("ChatViewModel", "request voiceToTextMessage is already has transcript and should not wait for update", new Object[0]);
                this.d = null;
                this.b = null;
                this.c = 2;
                if (chatViewModel.o8((MessagingStruct$DocumentMessage) objB, j08, c8967Xz7, sa2, this) == objE) {
                    return objE;
                }
            } else {
                C19406qI3.a("ChatViewModel", "fail to request voiceToTextMessage for : " + thE.getMessage(), new Object[0]);
                chatViewModel.Kc(J44.D(c8967Xz7.j(), 0L, 0L, 0L, 0, null, J08.l.a(j08, VoiceTranscript.c(j08.J(), EnumC9477a18.b, null, false, 4, null)), null, 0, null, null, 0L, null, null, false, null, false, null, null, 262111, null));
                chatViewModel.p8(thE);
                sa2.invoke();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((F1) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class G extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11458d25 c;
        final /* synthetic */ ChatViewModel d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        G(C11458d25 c11458d25, ChatViewModel chatViewModel, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c11458d25;
            this.d = chatViewModel;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new G(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (this.c.z()) {
                    C18804pH1 c18804pH1 = this.d.M0;
                    int peerId = this.c.getPeerId();
                    this.b = 1;
                    if (c18804pH1.c(peerId, this) == objE) {
                        return objE;
                    }
                } else {
                    C6517Nv5 c6517Nv5R0 = this.d.v.r0(this.c);
                    AbstractC13042fc3.h(c6517Nv5R0, "deleteChat(...)");
                    this.b = 2;
                    if (AbstractC6756Ov5.d(c6517Nv5R0, null, this, 1, null) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ((C9475a16) obj).l();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((G) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class G0 implements InterfaceC5520Jr5 {
        private final SA2 a;
        private final UA2 b;
        private final SA2 c;
        private final SA2 d;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            int c;
            final /* synthetic */ ChatViewModel d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ChatViewModel chatViewModel, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = chatViewModel;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                ChatViewModel chatViewModel;
                Object objL;
                Object value;
                JQ0 jq0;
                Object objE = AbstractC14862ic3.e();
                int i = this.c;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    ChatViewModel chatViewModel2 = this.d;
                    C21231tK7 c21231tK7 = chatViewModel2.M1;
                    if (c21231tK7 == null) {
                        C19406qI3.k("NewChatPrivacyBar", "Adding user to contacts FAILED {UserVm.id} is null", new Object[0]);
                        C9475a16.a aVar = C9475a16.b;
                        C9475a16.b(AbstractC10685c16.a(new IllegalArgumentException("UserVm.id is Null")));
                        return C19938rB7.a;
                    }
                    int iO = c21231tK7.o();
                    this.b = chatViewModel2;
                    this.c = 1;
                    Object objO4 = chatViewModel2.o4(iO, this);
                    if (objO4 == objE) {
                        return objE;
                    }
                    chatViewModel = chatViewModel2;
                    objL = objO4;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    chatViewModel = (ChatViewModel) this.b;
                    AbstractC10685c16.b(obj);
                    objL = ((C9475a16) obj).l();
                }
                if (C9475a16.j(objL)) {
                    int iIntValue = ((Number) objL).intValue();
                    InterfaceC9336Zm4 interfaceC9336Zm4 = chatViewModel.g1;
                    do {
                        value = interfaceC9336Zm4.getValue();
                        jq0 = (JQ0) value;
                    } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : AbstractC6392Nk0.d(iIntValue), (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
                }
                Throwable thE = C9475a16.e(objL);
                if (thE != null) {
                    C19406qI3.c("NewChatPrivacyBar", "Adding user to contacts", thE);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ ChatViewModel c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(ChatViewModel chatViewModel, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = chatViewModel;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object value;
                JQ0 jq0;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.c.g1;
                do {
                    value = interfaceC9336Zm4.getValue();
                    jq0 = (JQ0) value;
                } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : InterfaceC4569Fr5.b.a, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        G0(final ChatViewModel chatViewModel) {
            this.a = new SA2() { // from class: ir.nasim.dS0
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return ChatViewModel.G0.i(chatViewModel);
                }
            };
            this.b = new UA2() { // from class: ir.nasim.eS0
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return ChatViewModel.G0.j(chatViewModel, (String) obj);
                }
            };
            this.c = new SA2() { // from class: ir.nasim.fS0
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return ChatViewModel.G0.k(chatViewModel);
                }
            };
            this.d = new SA2() { // from class: ir.nasim.gS0
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return ChatViewModel.G0.l(chatViewModel);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(ChatViewModel chatViewModel) {
            AbstractC13042fc3.i(chatViewModel, "this$0");
            AbstractC10533bm0.d(AbstractC9773aX7.a(chatViewModel), null, null, new a(chatViewModel, null), 3, null);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 j(ChatViewModel chatViewModel, String str) {
            Object value;
            JQ0 jq0;
            AbstractC13042fc3.i(chatViewModel, "this$0");
            AbstractC13042fc3.i(str, "username");
            InterfaceC9336Zm4 interfaceC9336Zm4 = chatViewModel.g1;
            do {
                value = interfaceC9336Zm4.getValue();
                jq0 = (JQ0) value;
            } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : new InterfaceC4569Fr5.a(str, false, 2, null), (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 k(ChatViewModel chatViewModel) {
            AbstractC13042fc3.i(chatViewModel, "this$0");
            AbstractC10533bm0.d(AbstractC9773aX7.a(chatViewModel), null, null, new b(chatViewModel, null), 3, null);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 l(ChatViewModel chatViewModel) {
            AbstractC13042fc3.i(chatViewModel, "this$0");
            chatViewModel.s5();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC5520Jr5
        public SA2 a() {
            return this.d;
        }

        @Override // ir.nasim.InterfaceC5520Jr5
        public UA2 b() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC5520Jr5
        public SA2 c() {
            return this.a;
        }

        @Override // ir.nasim.InterfaceC5520Jr5
        public SA2 d() {
            return this.c;
        }
    }

    static final class H extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        H(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new H(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            ChatViewModel chatViewModel;
            Object objL;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = ChatViewModel.this.i1;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, InterfaceC4335Er5.d.a));
                ChatViewModel chatViewModel2 = ChatViewModel.this;
                FP5 fp5 = chatViewModel2.A0;
                ExPeer exPeer = new ExPeer(ChatViewModel.this.m6(), ChatViewModel.this.z1.getPeerId());
                this.b = chatViewModel2;
                this.c = 1;
                Object objA = fp5.a(exPeer, this);
                if (objA == objE) {
                    return objE;
                }
                chatViewModel = chatViewModel2;
                objL = objA;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                chatViewModel = (ChatViewModel) this.b;
                AbstractC10685c16.b(obj);
                objL = ((C9475a16) obj).l();
            }
            chatViewModel.r8(objL, "Dismissed privacy bar", "Dismissed privacy bar has been failed");
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((H) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class H0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC18505om2 c;
        final /* synthetic */ ChatViewModel d;
        final /* synthetic */ SA2 e;

        public static final class a implements InterfaceC8807Xk2 {
            final /* synthetic */ ChatViewModel a;
            final /* synthetic */ SA2 b;

            a(ChatViewModel chatViewModel, SA2 sa2) {
                this.a = chatViewModel;
                this.b = sa2;
            }

            @Override // ir.nasim.InterfaceC8807Xk2
            public void c(float f) {
                Object value;
                JQ0 jq0;
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.a.g1;
                do {
                    value = interfaceC9336Zm4.getValue();
                    jq0 = (JQ0) value;
                } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : AbstractC4616Fw7.a(null, Integer.valueOf(DD5.story_image_is_not_downloaded)), (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
            }

            @Override // ir.nasim.InterfaceC8807Xk2
            public void d(InterfaceC3346Am2 interfaceC3346Am2) {
                AbstractC13042fc3.i(interfaceC3346Am2, "reference");
                this.b.invoke();
            }

            @Override // ir.nasim.InterfaceC8807Xk2
            public void g(DX1 dx1) {
                Object value;
                JQ0 jq0;
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.a.g1;
                do {
                    value = interfaceC9336Zm4.getValue();
                    jq0 = (JQ0) value;
                } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : AbstractC4616Fw7.a(null, Integer.valueOf(DD5.story_image_is_not_downloaded)), (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        H0(InterfaceC18505om2 interfaceC18505om2, ChatViewModel chatViewModel, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC18505om2;
            this.d = chatViewModel;
            this.e = sa2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new H0(this.c, this.d, this.e, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x005d  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r13.b
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                ir.nasim.AbstractC10685c16.b(r14)
                goto L62
            Lf:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L17:
                ir.nasim.AbstractC10685c16.b(r14)
                ir.nasim.om2 r14 = r13.c
                if (r14 == 0) goto L5d
                boolean r1 = r14 instanceof ir.nasim.C11920dm2
                if (r1 == 0) goto L25
                ir.nasim.dm2 r14 = (ir.nasim.C11920dm2) r14
                goto L26
            L25:
                r14 = 0
            L26:
                if (r14 == 0) goto L5d
                ir.nasim.chat.ChatViewModel r14 = r13.d
                ir.nasim.QF2 r3 = ir.nasim.chat.ChatViewModel.I2(r14)
                ir.nasim.om2 r14 = r13.c
                ir.nasim.dm2 r14 = (ir.nasim.C11920dm2) r14
                ir.nasim.core.modules.file.entity.FileReference r14 = r14.b()
                long r4 = r14.getFileId()
                ir.nasim.om2 r14 = r13.c
                ir.nasim.dm2 r14 = (ir.nasim.C11920dm2) r14
                ir.nasim.core.modules.file.entity.FileReference r14 = r14.b()
                long r6 = r14.getAccessHash()
                ir.nasim.chat.ChatViewModel$H0$a r8 = new ir.nasim.chat.ChatViewModel$H0$a
                ir.nasim.chat.ChatViewModel r14 = r13.d
                ir.nasim.SA2 r1 = r13.e
                r8.<init>(r14, r1)
                r13.b = r2
                r9 = 0
                r11 = 8
                r12 = 0
                r10 = r13
                java.lang.Object r14 = ir.nasim.QF2.p(r3, r4, r6, r8, r9, r10, r11, r12)
                if (r14 != r0) goto L62
                return r0
            L5d:
                ir.nasim.SA2 r14 = r13.e
                r14.invoke()
            L62:
                ir.nasim.rB7 r14 = ir.nasim.C19938rB7.a
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.H0.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((H0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class I extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        int f;
        final /* synthetic */ List g;
        final /* synthetic */ ChatViewModel h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        I(List list, ChatViewModel chatViewModel, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.g = list;
            this.h = chatViewModel;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new I(this.g, this.h, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0071  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0069 -> B:15:0x006a). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r6.f
                r2 = 1
                if (r1 == 0) goto L27
                if (r1 != r2) goto L1f
                java.lang.Object r1 = r6.e
                java.util.Collection r1 = (java.util.Collection) r1
                java.lang.Object r3 = r6.d
                java.util.Iterator r3 = (java.util.Iterator) r3
                java.lang.Object r4 = r6.c
                java.util.Collection r4 = (java.util.Collection) r4
                java.lang.Object r5 = r6.b
                ir.nasim.chat.ChatViewModel r5 = (ir.nasim.chat.ChatViewModel) r5
                ir.nasim.AbstractC10685c16.b(r7)
                goto L6a
            L1f:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L27:
                ir.nasim.AbstractC10685c16.b(r7)
                java.util.List r7 = r6.g
                ir.nasim.AbstractC13042fc3.f(r7)
                java.lang.Iterable r7 = (java.lang.Iterable) r7
                ir.nasim.chat.ChatViewModel r1 = r6.h
                java.util.ArrayList r3 = new java.util.ArrayList
                r4 = 10
                int r4 = ir.nasim.ZW0.x(r7, r4)
                r3.<init>(r4)
                java.util.Iterator r7 = r7.iterator()
                r5 = r1
                r1 = r3
                r3 = r7
            L45:
                boolean r7 = r3.hasNext()
                if (r7 == 0) goto L71
                java.lang.Object r7 = r3.next()
                ir.nasim.nI7 r7 = (ir.nasim.C17637nI7) r7
                ir.nasim.pK7 r4 = ir.nasim.chat.ChatViewModel.u3(r5)
                ir.nasim.AbstractC13042fc3.f(r7)
                r6.b = r5
                r6.c = r1
                r6.d = r3
                r6.e = r1
                r6.f = r2
                java.lang.Object r7 = r4.a(r7, r6)
                if (r7 != r0) goto L69
                return r0
            L69:
                r4 = r1
            L6a:
                ir.nasim.BI7 r7 = (ir.nasim.BI7) r7
                r1.add(r7)
                r1 = r4
                goto L45
            L71:
                java.util.List r1 = (java.util.List) r1
                ir.nasim.chat.ChatViewModel r7 = r6.h
                ir.nasim.Zm4 r7 = ir.nasim.chat.ChatViewModel.B3(r7)
            L79:
                java.lang.Object r0 = r7.getValue()
                r2 = r0
                java.util.List r2 = (java.util.List) r2
                boolean r0 = r7.f(r0, r1)
                if (r0 == 0) goto L79
                ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.I.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((I) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class I0 extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        I0(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objFa = ChatViewModel.this.fa(0, this);
            return objFa == AbstractC14862ic3.e() ? objFa : C9475a16.a(objFa);
        }
    }

    static final class J extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        J(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new J(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE;
            Object objE2 = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                V9 v9 = ChatViewModel.this.q;
                this.b = 1;
                objE = v9.e(this);
                if (objE == objE2) {
                    return objE2;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objE = ((C9475a16) obj).l();
            }
            ChatViewModel chatViewModel = ChatViewModel.this;
            if (C9475a16.j(objE)) {
                chatViewModel.x.g("AVATAR_REACTION_ENABLE", true);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((J) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class J0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ long e;
        final /* synthetic */ String f;
        final /* synthetic */ List g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        J0(long j, long j2, String str, List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = j2;
            this.f = str;
            this.g = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new J0(this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                IN5 in5 = ChatViewModel.this.r;
                C11458d25 c11458d25 = ChatViewModel.this.z1;
                long j = this.d;
                long j2 = this.e;
                String str = this.f;
                List list = this.g;
                boolean zH8 = ChatViewModel.this.H8();
                this.b = 1;
                if (in5.d(c11458d25, j, j2, str, list, zH8, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ((C9475a16) obj).l();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((J0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class K implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.chat.ChatViewModel$K$a$a, reason: collision with other inner class name */
            public static final class C0967a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0967a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = interfaceC4806Gq2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof ir.nasim.chat.ChatViewModel.K.a.C0967a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.chat.ChatViewModel$K$a$a r0 = (ir.nasim.chat.ChatViewModel.K.a.C0967a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.chat.ChatViewModel$K$a$a r0 = new ir.nasim.chat.ChatViewModel$K$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L43
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    boolean r2 = r5 instanceof ir.nasim.RY1.a
                    if (r2 == 0) goto L43
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L43
                    return r1
                L43:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.K.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public K(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    static final class K0 extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        K0(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            Object objIa = ChatViewModel.this.ia(0, null, this);
            return objIa == AbstractC14862ic3.e() ? objIa : C9475a16.a(objIa);
        }
    }

    static final class L extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        L(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return ChatViewModel.this.B5(null, this);
        }
    }

    static final class L0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;
        final /* synthetic */ OP5 e;
        final /* synthetic */ List f;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ ChatViewModel d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ChatViewModel chatViewModel, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = chatViewModel;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((C9475a16) obj).l(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object value;
                JQ0 jq0;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                int i = C9475a16.j(((C9475a16) this.c).l()) ? DD5.report_sent_success : DD5.report_sent_failure;
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.g1;
                do {
                    value = interfaceC9336Zm4.getValue();
                    jq0 = (JQ0) value;
                } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : AbstractC4616Fw7.a(null, AbstractC6392Nk0.d(i)), (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
                return C19938rB7.a;
            }

            public final Object n(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(C9475a16.a(obj), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        L0(String str, OP5 op5, List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
            this.e = op5;
            this.f = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new L0(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C24314yP5 c24314yP5 = ChatViewModel.this.u;
                ExPeer exPeer = new ExPeer(ChatViewModel.this.m6(), ChatViewModel.this.z1.getPeerId());
                String str = this.d;
                OP5 op5 = this.e;
                List<J44> list = this.f;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                for (J44 j44 : list) {
                    arrayList.add(new Q64(j44.h(), j44.i()));
                }
                InterfaceC4557Fq2 interfaceC4557Fq2A = c24314yP5.a(exPeer, str, op5, arrayList);
                a aVar = new a(ChatViewModel.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2A, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((L0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class M extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        M(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new M(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (ChatViewModel.this.z1.C()) {
                    InterfaceC11621dJ7 interfaceC11621dJ7 = ChatViewModel.this.l;
                    long peerId = ChatViewModel.this.z1.getPeerId();
                    this.b = 1;
                    if (interfaceC11621dJ7.s(peerId, true, this) == objE) {
                        return objE;
                    }
                } else {
                    KM2 km2 = ChatViewModel.this.j;
                    int peerId2 = ChatViewModel.this.z1.getPeerId();
                    this.b = 2;
                    if (km2.c(peerId2, true, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ((C9475a16) obj).l();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((M) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class M0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        M0(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new M0(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            JQ0 jq0;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            ChatViewModel.this.G0.b(new ExPeer(ChatViewModel.this.m6(), ChatViewModel.this.z1.getPeerId()), "", OP5.e, P25.d);
            InterfaceC9336Zm4 interfaceC9336Zm4 = ChatViewModel.this.g1;
            do {
                value = interfaceC9336Zm4.getValue();
                jq0 = (JQ0) value;
            } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : InterfaceC4569Fr5.f.a, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((M0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class N extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        N(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return ChatViewModel.this.D5(null, this);
        }
    }

    static final class N0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        N0(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new N0(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            JQ0 jq0;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC9336Zm4 interfaceC9336Zm4 = ChatViewModel.this.g1;
            do {
                value = interfaceC9336Zm4.getValue();
                jq0 = (JQ0) value;
            } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((N0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class O extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        O(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return ChatViewModel.this.E5(null, null, this);
        }
    }

    static final class O0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ long e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        O0(long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = j2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new O0(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objG;
            Object value;
            JQ0 jq0;
            Object value2;
            JQ0 jq02;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C3777Ch5 c3777Ch5 = ChatViewModel.this.X0;
                long j = this.d;
                this.b = 1;
                objG = c3777Ch5.g(j, this);
                if (objG == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objG = obj;
            }
            C16885m18 c16885m18 = (C16885m18) objG;
            if (c16885m18 != null) {
                ChatViewModel.this.G5(c16885m18, this.e);
                InterfaceC9336Zm4 interfaceC9336Zm4 = ChatViewModel.this.g1;
                long j2 = this.e;
                do {
                    value2 = interfaceC9336Zm4.getValue();
                    jq02 = (JQ0) value2;
                } while (!interfaceC9336Zm4.f(value2, jq02.a((262142 & 1) != 0 ? jq02.a : null, (262142 & 2) != 0 ? jq02.b : null, (262142 & 4) != 0 ? jq02.c : null, (262142 & 8) != 0 ? jq02.d : null, (262142 & 16) != 0 ? jq02.e : false, (262142 & 32) != 0 ? jq02.f : null, (262142 & 64) != 0 ? jq02.g : null, (262142 & 128) != 0 ? jq02.h : null, (262142 & 256) != 0 ? jq02.i : null, (262142 & 512) != 0 ? jq02.j : null, (262142 & 1024) != 0 ? jq02.k : null, (262142 & 2048) != 0 ? jq02.l : null, (262142 & 4096) != 0 ? jq02.m : null, (262142 & 8192) != 0 ? jq02.n : null, (262142 & 16384) != 0 ? jq02.o : null, (262142 & 32768) != 0 ? jq02.p : null, (262142 & 65536) != 0 ? jq02.q : new XV4(c16885m18, AbstractC6392Nk0.e(j2)), (262142 & 131072) != 0 ? jq02.r : null)));
            } else {
                InterfaceC9336Zm4 interfaceC9336Zm42 = ChatViewModel.this.g1;
                do {
                    value = interfaceC9336Zm42.getValue();
                    jq0 = (JQ0) value;
                } while (!interfaceC9336Zm42.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : AbstractC4616Fw7.a(null, AbstractC6392Nk0.d(DD5.error_unknown)), (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((O0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class P extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ C12889fL5 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        P(long j, C12889fL5 c12889fL5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = c12889fL5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new P(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC11621dJ7 interfaceC11621dJ7 = ChatViewModel.this.l;
                long j = this.d;
                this.b = 1;
                if (InterfaceC11621dJ7.q(interfaceC11621dJ7, j, false, this, 2, null) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ((C9475a16) obj).l();
            }
            C21231tK7 c21231tK7 = (C21231tK7) ChatViewModel.this.g.o0().n(this.d);
            if (c21231tK7 == null) {
                C19406qI3.j("NewChatPrivacyBar", "findInviterIdAndShowPrivacyBar, Inviter user is null!", new Object[0]);
            } else {
                this.e.a = c21231tK7.r().b();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((P) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class P0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ long e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        P0(long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = j2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new P0(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20642sM3 interfaceC20642sM3 = ChatViewModel.this.A;
                long j = this.d;
                long j2 = this.e;
                int peerId = ChatViewModel.this.z1.getPeerId();
                EnumC16311l35 enumC16311l35 = EnumC16311l35.PeerType_GROUP;
                this.b = 1;
                if (interfaceC20642sM3.b(j, j2, 0L, peerId, enumC16311l35, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((P0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class Q extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ C16885m18 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        Q(long j, C16885m18 c16885m18, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = c16885m18;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new Q(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            DB3 db3F0 = ChatViewModel.this.H8() ? ChatViewModel.this.v.F0() : ChatViewModel.this.v.H0(ChatViewModel.this.z1);
            if (db3F0 == null) {
                return C19938rB7.a;
            }
            J44 j44 = (J44) db3F0.a(this.d);
            AbstractC17457n0 abstractC17457n0F = j44 != null ? j44.F() : null;
            C19049ph5 c19049ph5 = abstractC17457n0F instanceof C19049ph5 ? (C19049ph5) abstractC17457n0F : null;
            if (c19049ph5 == null) {
                return C19938rB7.a;
            }
            C19049ph5.a aVar = C19049ph5.i;
            boolean zY = c19049ph5.y();
            long jU = c19049ph5.u();
            String strV = c19049ph5.v();
            List listP1 = AbstractC15401jX0.p1(c19049ph5.t());
            EnumC9567aB enumC9567aBW = c19049ph5.w();
            if (enumC9567aBW == null) {
                enumC9567aBW = EnumC9567aB.UNSUPPORTED_VALUE;
            }
            db3F0.d(j44.u(aVar.a(zY, jU, strV, listP1, enumC9567aBW, this.e), true));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((Q) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class Q0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ long e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        Q0(long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = j2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new Q0(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20642sM3 interfaceC20642sM3 = ChatViewModel.this.A;
                long j = this.d;
                long j2 = this.e;
                int peerId = ChatViewModel.this.z1.getPeerId();
                EnumC16311l35 enumC16311l35 = EnumC16311l35.PeerType_GROUP;
                this.b = 1;
                obj = interfaceC20642sM3.b(j, j2, 0L, peerId, enumC16311l35, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            Z06 z06 = (Z06) obj;
            if (z06 instanceof Z06.a) {
                if (AbstractC13042fc3.d(((Z06.a) z06).a().getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String(), "NOT_MEMBER")) {
                    ChatViewModel.this.Ca();
                }
            } else {
                if (!(z06 instanceof Z06.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                ChatViewModel.this.Ba();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((Q0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class R extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ long e;
        final /* synthetic */ Context f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        R(long j, long j2, Context context, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = j2;
            this.f = context;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new R(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C17626nH5 c17626nH5A = ChatViewModel.this.C0.a(null, this.d, ChatViewModel.this.z1, this.e);
                this.b = 1;
                obj = c17626nH5A.f(1, 3, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            ChatViewModel chatViewModel = ChatViewModel.this;
            Context context = this.f;
            List list = (List) obj;
            C13518gM7 c13518gM7J7 = chatViewModel.J7();
            List list2 = list;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(AbstractC6392Nk0.d(((DH5) it.next()).e()));
            }
            c13518gM7J7.g(AbstractC15401jX0.f1(arrayList, 3));
            chatViewModel.u5(context, chatViewModel.J7(), list);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((R) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class R0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        final /* synthetic */ List e;
        final /* synthetic */ ChatViewModel f;
        final /* synthetic */ C11458d25 g;
        final /* synthetic */ C11458d25 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        R0(List list, ChatViewModel chatViewModel, C11458d25 c11458d25, C11458d25 c11458d252, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = list;
            this.f = chatViewModel;
            this.g = c11458d25;
            this.h = c11458d252;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final JQ0 y(JQ0 jq0) {
            return jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : AbstractC4616Fw7.a(null, Integer.valueOf(DD5.saved_message_success_message)), (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new R0(this.e, this.f, this.g, this.h, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035 A[Catch: Exception -> 0x0019, TRY_LEAVE, TryCatch #0 {Exception -> 0x0019, blocks: (B:6:0x0015, B:23:0x004e, B:16:0x002f, B:18:0x0035, B:19:0x003c, B:22:0x004b, B:15:0x0028), top: B:28:0x0009, inners: #1 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0048 -> B:23:0x004e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x004b -> B:23:0x004e). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r7.d
                java.lang.String r2 = "ChatViewModel"
                r3 = 1
                if (r1 == 0) goto L25
                if (r1 != r3) goto L1d
                java.lang.Object r1 = r7.c
                ir.nasim.J44 r1 = (ir.nasim.J44) r1
                java.lang.Object r4 = r7.b
                java.util.Iterator r4 = (java.util.Iterator) r4
                ir.nasim.AbstractC10685c16.b(r8)     // Catch: java.lang.Exception -> L19 java.lang.InterruptedException -> L1b
                goto L4e
            L19:
                r8 = move-exception
                goto L5c
            L1b:
                r8 = move-exception
                goto L4b
            L1d:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L25:
                ir.nasim.AbstractC10685c16.b(r8)
                java.util.List r8 = r7.e     // Catch: java.lang.Exception -> L19
                java.util.Iterator r8 = r8.iterator()     // Catch: java.lang.Exception -> L19
                r4 = r8
            L2f:
                boolean r8 = r4.hasNext()     // Catch: java.lang.Exception -> L19
                if (r8 == 0) goto L5f
                java.lang.Object r8 = r4.next()     // Catch: java.lang.Exception -> L19
                r1 = r8
                ir.nasim.J44 r1 = (ir.nasim.J44) r1     // Catch: java.lang.Exception -> L19
                r7.b = r4     // Catch: java.lang.Exception -> L19 java.lang.InterruptedException -> L1b
                r7.c = r1     // Catch: java.lang.Exception -> L19 java.lang.InterruptedException -> L1b
                r7.d = r3     // Catch: java.lang.Exception -> L19 java.lang.InterruptedException -> L1b
                r5 = 300(0x12c, double:1.48E-321)
                java.lang.Object r8 = ir.nasim.HG1.b(r5, r7)     // Catch: java.lang.Exception -> L19 java.lang.InterruptedException -> L1b
                if (r8 != r0) goto L4e
                return r0
            L4b:
                ir.nasim.C19406qI3.d(r2, r8)     // Catch: java.lang.Exception -> L19
            L4e:
                ir.nasim.chat.ChatViewModel r8 = r7.f     // Catch: java.lang.Exception -> L19
                ir.nasim.E84 r8 = ir.nasim.chat.ChatViewModel.Y2(r8)     // Catch: java.lang.Exception -> L19
                ir.nasim.d25 r5 = r7.g     // Catch: java.lang.Exception -> L19
                ir.nasim.d25 r6 = r7.h     // Catch: java.lang.Exception -> L19
                r8.x0(r5, r6, r1)     // Catch: java.lang.Exception -> L19
                goto L2f
            L5c:
                ir.nasim.C19406qI3.d(r2, r8)
            L5f:
                ir.nasim.chat.ChatViewModel r8 = r7.f
                ir.nasim.chat.d1 r0 = new ir.nasim.chat.d1
                r0.<init>()
                r8.Nc(r0)
                ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.R0.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((R0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class S extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ long e;
        final /* synthetic */ Context f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        S(long j, long j2, Context context, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = j2;
            this.f = context;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new S(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objF;
            Object value;
            List listP1;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C25108zk6 c25108zk6A = ChatViewModel.this.D0.a(this.d, ChatViewModel.this.z1, ChatViewModel.this.m6(), this.e);
                this.b = 1;
                objF = c25108zk6A.f(1, 3, this);
                if (objF == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objF = obj;
            }
            ChatViewModel chatViewModel = ChatViewModel.this;
            long j = this.d;
            long j2 = this.e;
            Context context = this.f;
            XV4 xv4 = (XV4) objF;
            Map map = chatViewModel.h2;
            XV4 xv4A = AbstractC4616Fw7.a(AbstractC6392Nk0.e(j), AbstractC6392Nk0.e(j2));
            Object objA = map.get(xv4A);
            if (objA == null) {
                int iIntValue = ((Number) xv4.f()).intValue();
                ArrayList arrayList = new ArrayList(iIntValue);
                for (int i2 = 0; i2 < iIntValue; i2++) {
                    arrayList.add(null);
                }
                objA = AbstractC12281eL6.a(arrayList);
                map.put(xv4A, objA);
            }
            InterfaceC9336Zm4 interfaceC9336Zm4 = (InterfaceC9336Zm4) objA;
            do {
                value = interfaceC9336Zm4.getValue();
                List list = (List) value;
                listP1 = AbstractC15401jX0.p1(list);
                if (((Number) xv4.f()).intValue() > list.size()) {
                    int iIntValue2 = ((Number) xv4.f()).intValue() - list.size();
                    ArrayList arrayList2 = new ArrayList(iIntValue2);
                    for (int i3 = 0; i3 < iIntValue2; i3++) {
                        arrayList2.add(null);
                    }
                    listP1.addAll(arrayList2);
                }
            } while (!interfaceC9336Zm4.f(value, listP1));
            C13518gM7 c13518gM7J7 = chatViewModel.J7();
            Iterable iterable = (Iterable) xv4.e();
            ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(iterable, 10));
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList3.add(AbstractC6392Nk0.d(((C6658Ok6) it.next()).c()));
            }
            c13518gM7J7.g(AbstractC15401jX0.f1(arrayList3, 3));
            chatViewModel.Ma(context, chatViewModel.J7(), AbstractC15401jX0.f1((Iterable) xv4.e(), 3), j, j2);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((S) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class S0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ BytesValue d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        S0(BytesValue bytesValue, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = bytesValue;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new S0(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objL;
            SearchOuterClass$ResponseSearchMessages searchOuterClass$ResponseSearchMessages;
            Object value;
            C25068zg6 c25068zg6;
            List listI;
            List<? extends InterfaceC3544Bh6> listM;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C24474yg6 c24474yg6 = ChatViewModel.this.L0;
                BytesValue bytesValue = this.d;
                this.b = 1;
                Object objE2 = c24474yg6.e(bytesValue, this);
                if (objE2 == objE) {
                    return objE;
                }
                objL = objE2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objL = ((C9475a16) obj).l();
            }
            C9475a16 c9475a16A = C9475a16.a(objL);
            if (!C9475a16.j(c9475a16A.l())) {
                c9475a16A = null;
            }
            if (c9475a16A != null) {
                Object objL2 = c9475a16A.l();
                if (C9475a16.g(objL2)) {
                    objL2 = null;
                }
                searchOuterClass$ResponseSearchMessages = (SearchOuterClass$ResponseSearchMessages) objL2;
            } else {
                searchOuterClass$ResponseSearchMessages = null;
            }
            InterfaceC9336Zm4 interfaceC9336Zm4 = ChatViewModel.this.e2;
            do {
                value = interfaceC9336Zm4.getValue();
                c25068zg6 = (C25068zg6) value;
                listI = c25068zg6.i();
                if (searchOuterClass$ResponseSearchMessages == null || (listM = searchOuterClass$ResponseSearchMessages.getSearchResultsOrBuilderList()) == null) {
                    listM = AbstractC10360bX0.m();
                }
            } while (!interfaceC9336Zm4.f(value, c25068zg6.a((5885 & 1) != 0 ? c25068zg6.a : 0L, (5885 & 2) != 0 ? c25068zg6.b : EnumC21528th6.d, (5885 & 4) != 0 ? c25068zg6.c : null, (5885 & 8) != 0 ? c25068zg6.d : null, (5885 & 16) != 0 ? c25068zg6.e : null, (5885 & 32) != 0 ? c25068zg6.f : null, (5885 & 64) != 0 ? c25068zg6.g : null, (5885 & 128) != 0 ? c25068zg6.h : 0, (5885 & 256) != 0 ? c25068zg6.i : AbstractC15401jX0.R0(listI, listM), (5885 & 512) != 0 ? c25068zg6.j : 0, (5885 & 1024) != 0 ? c25068zg6.k : 0, (5885 & 2048) != 0 ? c25068zg6.l : searchOuterClass$ResponseSearchMessages != null ? searchOuterClass$ResponseSearchMessages.getLoadMoreState() : null, (5885 & 4096) != 0 ? c25068zg6.m : false)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((S0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class T extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        T(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return ChatViewModel.this.W5(null, this);
        }
    }

    static final class T0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ List e;
        final /* synthetic */ String f;
        final /* synthetic */ int g;
        final /* synthetic */ long h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        T0(List list, String str, int i, long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = list;
            this.f = str;
            this.g = i;
            this.h = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new T0(this.e, this.f, this.g, this.h, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0098 A[Catch: Exception -> 0x0106, LOOP:0: B:26:0x0092->B:28:0x0098, LOOP_END, TryCatch #0 {Exception -> 0x0106, blocks: (B:12:0x0027, B:15:0x0030, B:37:0x00e2, B:16:0x0038, B:25:0x007d, B:26:0x0092, B:28:0x0098, B:29:0x00a8, B:30:0x00b7, B:32:0x00bd, B:33:0x00cf, B:22:0x006c), top: B:45:0x000e }] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00bd A[Catch: Exception -> 0x0106, LOOP:1: B:30:0x00b7->B:32:0x00bd, LOOP_END, TryCatch #0 {Exception -> 0x0106, blocks: (B:12:0x0027, B:15:0x0030, B:37:0x00e2, B:16:0x0038, B:25:0x007d, B:26:0x0092, B:28:0x0098, B:29:0x00a8, B:30:0x00b7, B:32:0x00bd, B:33:0x00cf, B:22:0x006c), top: B:45:0x000e }] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00e0 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00e1  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0105 A[RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                Method dump skipped, instructions count: 305
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.T0.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((T0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class U extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ List d;
        final /* synthetic */ List e;
        final /* synthetic */ ChatViewModel f;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            int c;
            final /* synthetic */ List d;
            final /* synthetic */ ChatViewModel e;
            final /* synthetic */ long f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(List list, ChatViewModel chatViewModel, long j, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = list;
                this.e = chatViewModel;
                this.f = j;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.d, this.e, this.f, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                List list;
                Object objE = AbstractC14862ic3.e();
                int i = this.c;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    List list2 = this.d;
                    KM2 km2 = this.e.j;
                    long j = this.f;
                    this.b = list2;
                    this.c = 1;
                    Object objL = km2.l(j, this);
                    if (objL == objE) {
                        return objE;
                    }
                    list = list2;
                    obj = objL;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    list = (List) this.b;
                    AbstractC10685c16.b(obj);
                }
                return AbstractC6392Nk0.a(list.add(obj));
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        U(List list, List list2, ChatViewModel chatViewModel, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = list;
            this.e = list2;
            this.f = chatViewModel;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            U u = new U(this.d, this.e, this.f, interfaceC20295rm1);
            u.c = obj;
            return u;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                List list = this.d;
                if (list != null) {
                    List list2 = list;
                    List list3 = this.e;
                    ChatViewModel chatViewModel = this.f;
                    ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(AbstractC10533bm0.b(interfaceC20315ro1, null, null, new a(list3, chatViewModel, ((Number) it.next()).longValue(), null), 3, null));
                    }
                    this.b = 1;
                    obj = DV.a(arrayList, this);
                    if (obj == objE) {
                        return objE;
                    }
                }
                return C19938rB7.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((U) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class U0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        U0(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new U0(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            JQ0 jq0;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            ChatViewModel.this.x.putInt("COUNT_DISPLAY_TOOLTIP_JOIN_CHANNEL", ChatViewModel.this.x.getInt("COUNT_DISPLAY_TOOLTIP_JOIN_CHANNEL", 0) + 1);
            ChatViewModel.this.x.putLong("LAST_TIME_DISPLAY_TOOLTIP_JOIN_CHANNEL", System.currentTimeMillis());
            InterfaceC9336Zm4 interfaceC9336Zm4 = ChatViewModel.this.g1;
            do {
                value = interfaceC9336Zm4.getValue();
                jq0 = (JQ0) value;
            } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((U0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class V extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        V(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return ChatViewModel.this.j6(null, this);
        }
    }

    static final class V0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        long c;
        long d;
        int e;
        private /* synthetic */ Object f;
        final /* synthetic */ Context g;
        final /* synthetic */ C13518gM7 h;
        final /* synthetic */ List i;
        final /* synthetic */ ChatViewModel j;
        final /* synthetic */ long k;
        final /* synthetic */ long l;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            Object c;
            Object d;
            Object e;
            int f;
            final /* synthetic */ FU g;
            final /* synthetic */ C20610sI7 h;
            final /* synthetic */ List i;
            final /* synthetic */ Context j;

            /* renamed from: ir.nasim.chat.ChatViewModel$V0$a$a, reason: collision with other inner class name */
            static final class C0968a implements SA2 {
                final /* synthetic */ List a;
                final /* synthetic */ C20610sI7 b;
                final /* synthetic */ HE0 c;
                final /* synthetic */ Context d;

                C0968a(List list, C20610sI7 c20610sI7, HE0 he0, Context context) {
                    this.a = list;
                    this.b = c20610sI7;
                    this.c = he0;
                    this.d = context;
                }

                public final void a() {
                    Object fileReference;
                    AvatarImage imageDefaultSize;
                    List list = this.a;
                    C20610sI7 c20610sI7 = this.b;
                    Iterator it = list.iterator();
                    while (true) {
                        fileReference = null;
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        Avatar avatarA = ((C6658Ok6) next).a();
                        if (avatarA != null && (imageDefaultSize = avatarA.getImageDefaultSize()) != null) {
                            fileReference = imageDefaultSize.getFileReference();
                        }
                        if (AbstractC13042fc3.d(fileReference, c20610sI7.b())) {
                            fileReference = next;
                            break;
                        }
                    }
                    C6658Ok6 c6658Ok6 = (C6658Ok6) fileReference;
                    if (c6658Ok6 != null) {
                        AbstractC24549yo1.c(this.c, new WU(c6658Ok6.b(), c6658Ok6.c(), 12.0f, this.d, c6658Ok6.d(), true));
                    }
                }

                @Override // ir.nasim.SA2
                public /* bridge */ /* synthetic */ Object invoke() {
                    a();
                    return C19938rB7.a;
                }
            }

            static final class b implements UA2 {
                final /* synthetic */ HE0 a;

                b(HE0 he0) {
                    this.a = he0;
                }

                public final void a(Drawable drawable) {
                    AbstractC13042fc3.i(drawable, "resource");
                    AbstractC24549yo1.c(this.a, drawable);
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((Drawable) obj);
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(FU fu, C20610sI7 c20610sI7, List list, Context context, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.g = fu;
                this.h = c20610sI7;
                this.i = list;
                this.j = context;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.g, this.h, this.i, this.j, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.f;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    FU fu = this.g;
                    C20610sI7 c20610sI7 = this.h;
                    List list = this.i;
                    Context context = this.j;
                    this.b = fu;
                    this.c = c20610sI7;
                    this.d = list;
                    this.e = context;
                    this.f = 1;
                    IE0 ie0 = new IE0(AbstractC14251hc3.c(this), 1);
                    ie0.w();
                    fu.e(c20610sI7, (int) ((24 * AbstractC3742Cd6.c()) + 0.5d), new C0968a(list, c20610sI7, ie0, context), new b(ie0));
                    obj = ie0.t();
                    if (obj == AbstractC14862ic3.e()) {
                        WA1.c(this);
                    }
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return obj;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        V0(Context context, C13518gM7 c13518gM7, List list, ChatViewModel chatViewModel, long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.g = context;
            this.h = c13518gM7;
            this.i = list;
            this.j = chatViewModel;
            this.k = j;
            this.l = j2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            V0 v0 = new V0(this.g, this.h, this.i, this.j, this.k, this.l, interfaceC20295rm1);
            v0.f = obj;
            return v0;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            long j;
            Object objA;
            long j2;
            ChatViewModel chatViewModel;
            Object value;
            List listM1;
            Object objE = AbstractC14862ic3.e();
            int i = this.e;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.f;
                C18226oI5.a aVar = C18226oI5.c;
                Context context = this.g;
                C13518gM7 c13518gM7 = this.h;
                List list = this.i;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(AbstractC6392Nk0.d(((C6658Ok6) it.next()).c()));
                }
                List listT0 = AbstractC15401jX0.T0(aVar.a(context, c13518gM7, AbstractC15401jX0.r1(arrayList)).values());
                ChatViewModel chatViewModel2 = this.j;
                Context context2 = this.g;
                long j3 = this.k;
                long j4 = this.l;
                List list2 = this.i;
                if (chatViewModel2.a1 == null) {
                    chatViewModel2.a1 = new FU(context2);
                }
                FU fu = chatViewModel2.a1;
                if (fu != null) {
                    List list3 = listT0;
                    ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list3, 10));
                    Iterator it2 = list3.iterator();
                    while (it2.hasNext()) {
                        ArrayList arrayList3 = arrayList2;
                        arrayList3.add(AbstractC10533bm0.b(interfaceC20315ro1, null, null, new a(fu, (C20610sI7) it2.next(), list2, context2, null), 3, null));
                        arrayList2 = arrayList3;
                        context2 = context2;
                        list2 = list2;
                        fu = fu;
                        j4 = j4;
                        j3 = j3;
                    }
                    long j5 = j3;
                    this.f = chatViewModel2;
                    this.b = fu;
                    this.c = j5;
                    j = j4;
                    this.d = j;
                    this.e = 1;
                    objA = DV.a(arrayList2, this);
                    if (objA == objE) {
                        return objE;
                    }
                    j2 = j5;
                    chatViewModel = chatViewModel2;
                }
                return C19938rB7.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j6 = this.d;
            j2 = this.c;
            chatViewModel = (ChatViewModel) this.f;
            AbstractC10685c16.b(obj);
            j = j6;
            objA = obj;
            List list4 = (List) objA;
            InterfaceC9336Zm4 interfaceC9336Zm4 = (InterfaceC9336Zm4) chatViewModel.h2.get(AbstractC4616Fw7.a(AbstractC6392Nk0.e(j2), AbstractC6392Nk0.e(j)));
            if (interfaceC9336Zm4 != null) {
                do {
                    value = interfaceC9336Zm4.getValue();
                    listM1 = (List) value;
                    if (AbstractC15401jX0.n0(listM1).size() != list4.size()) {
                        List listP1 = AbstractC15401jX0.p1(listM1);
                        int i2 = 0;
                        for (Object obj2 : list4) {
                            int i3 = i2 + 1;
                            if (i2 < 0) {
                                AbstractC10360bX0.w();
                            }
                            listP1.set(i2, (Drawable) obj2);
                            i2 = i3;
                        }
                        listM1 = AbstractC15401jX0.m1(listP1);
                    }
                } while (!interfaceC9336Zm4.f(value, listM1));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((V0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class W extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        W(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objQ6 = ChatViewModel.this.q6(null, this);
            return objQ6 == AbstractC14862ic3.e() ? objQ6 : C9475a16.a(objQ6);
        }
    }

    static final class W0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        final /* synthetic */ J44 e;
        final /* synthetic */ ChatViewModel f;
        final /* synthetic */ String g;
        final /* synthetic */ Context h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        W0(J44 j44, ChatViewModel chatViewModel, String str, Context context, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = j44;
            this.f = chatViewModel;
            this.g = str;
            this.h = context;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new W0(this.e, this.f, this.g, this.h, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            J44 j44F5;
            Object objY;
            ChatViewModel chatViewModel;
            Context context;
            Object value;
            JQ0 jq0;
            Object objE = AbstractC14862ic3.e();
            int i = this.d;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (this.e.F() instanceof C11907dl) {
                    j44F5 = this.f.F5(this.e);
                    if (j44F5 == null) {
                        return C19938rB7.a;
                    }
                } else {
                    j44F5 = this.e;
                }
                String strA = C14225hZ6.a(this.g);
                if (strA != null) {
                    ChatViewModel chatViewModel2 = this.f;
                    Context context2 = this.h;
                    F84 f84 = chatViewModel2.m;
                    C11458d25 c11458d25 = chatViewModel2.z1;
                    this.b = chatViewModel2;
                    this.c = context2;
                    this.d = 1;
                    objY = f84.y(c11458d25, strA, j44F5, this);
                    if (objY == objE) {
                        return objE;
                    }
                    chatViewModel = chatViewModel2;
                    context = context2;
                }
                return C19938rB7.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            context = (Context) this.c;
            chatViewModel = (ChatViewModel) this.b;
            AbstractC10685c16.b(obj);
            objY = ((C9475a16) obj).l();
            Throwable thE = C9475a16.e(objY);
            if (thE != null) {
                String strL6 = chatViewModel.l6(thE, context);
                InterfaceC9336Zm4 interfaceC9336Zm4 = chatViewModel.g1;
                do {
                    value = interfaceC9336Zm4.getValue();
                    jq0 = (JQ0) value;
                } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : AbstractC4616Fw7.a(strL6, null), (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((W0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class X extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        X(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objR6 = ChatViewModel.this.r6(0, this);
            return objR6 == AbstractC14862ic3.e() ? objR6 : C9475a16.a(objR6);
        }
    }

    public static final class X0 extends HashMap {
        X0(ChatViewModel chatViewModel, ExPeerType exPeerType) {
            put("peer_id", Integer.valueOf(chatViewModel.z1.getPeerId()));
            put("peer_type", exPeerType.toString());
        }

        public /* bridge */ boolean b(String str) {
            return super.containsKey(str);
        }

        public /* bridge */ Object c(String str) {
            return super.get(str);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof String) {
                return b((String) obj);
            }
            return false;
        }

        public /* bridge */ Set d() {
            return super.entrySet();
        }

        public /* bridge */ Set e() {
            return super.keySet();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set entrySet() {
            return d();
        }

        public /* bridge */ Object f(String str, Object obj) {
            return super.getOrDefault(str, obj);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Object get(Object obj) {
            if (obj instanceof String) {
                return c((String) obj);
            }
            return null;
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj instanceof String) ? obj2 : f((String) obj, obj2);
        }

        public /* bridge */ int k() {
            return super.size();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set keySet() {
            return e();
        }

        public /* bridge */ Collection l() {
            return super.values();
        }

        public /* bridge */ Object n(String str) {
            return super.remove(str);
        }

        public /* bridge */ boolean p(String str, Object obj) {
            return super.remove(str, obj);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Object remove(Object obj) {
            if (obj instanceof String) {
                return n((String) obj);
            }
            return null;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return k();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection values() {
            return l();
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if ((obj instanceof String) && obj2 != null) {
                return p((String) obj, obj2);
            }
            return false;
        }
    }

    public static final class Y implements IT5 {
        final /* synthetic */ InterfaceC20295rm1 a;

        Y(InterfaceC20295rm1 interfaceC20295rm1) {
            this.a = interfaceC20295rm1;
        }

        @Override // ir.nasim.IT5
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean b(Bitmap bitmap, Object obj, InterfaceC21549tj7 interfaceC21549tj7, EnumC21012sz1 enumC21012sz1, boolean z) {
            AbstractC13042fc3.i(bitmap, "resource");
            AbstractC13042fc3.i(obj, CommonUrlParts.MODEL);
            AbstractC13042fc3.i(interfaceC21549tj7, "target");
            AbstractC13042fc3.i(enumC21012sz1, "dataSource");
            this.a.resumeWith(C9475a16.b(bitmap));
            return true;
        }

        @Override // ir.nasim.IT5
        public boolean d(GlideException glideException, Object obj, InterfaceC21549tj7 interfaceC21549tj7, boolean z) {
            AbstractC13042fc3.i(interfaceC21549tj7, "target");
            this.a.resumeWith(C9475a16.b(null));
            return true;
        }
    }

    static final class Y0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC9336Zm4 c;
        final /* synthetic */ InterfaceC7857Tm2 d;
        final /* synthetic */ ChatViewModel e;
        final /* synthetic */ C11458d25 f;
        final /* synthetic */ Context g;
        final /* synthetic */ C24890zN5 h;
        final /* synthetic */ int i;
        final /* synthetic */ String j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        Y0(InterfaceC9336Zm4 interfaceC9336Zm4, InterfaceC7857Tm2 interfaceC7857Tm2, ChatViewModel chatViewModel, C11458d25 c11458d25, Context context, C24890zN5 c24890zN5, int i, String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC9336Zm4;
            this.d = interfaceC7857Tm2;
            this.e = chatViewModel;
            this.f = c11458d25;
            this.g = context;
            this.h = c24890zN5;
            this.i = i;
            this.j = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new Y0(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(1000L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            if (!((Boolean) this.c.getValue()).booleanValue()) {
                this.d.a(true);
                this.e.bb(this.f, this.g, this.h, this.i, this.j);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((Y0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class Z extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        Z(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            Object objH6 = ChatViewModel.this.H6(null, this);
            return objH6 == AbstractC14862ic3.e() ? objH6 : C9475a16.a(objH6);
        }
    }

    public static final class Z0 implements InterfaceC8091Um2 {
        final /* synthetic */ InterfaceC9336Zm4 a;
        final /* synthetic */ ChatViewModel b;
        final /* synthetic */ Context c;
        final /* synthetic */ String d;
        final /* synthetic */ C11458d25 e;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ Context c;
            final /* synthetic */ InterfaceC3346Am2 d;
            final /* synthetic */ String e;
            final /* synthetic */ ChatViewModel f;
            final /* synthetic */ C11458d25 g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Context context, InterfaceC3346Am2 interfaceC3346Am2, String str, ChatViewModel chatViewModel, C11458d25 c11458d25, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = context;
                this.d = interfaceC3346Am2;
                this.e = str;
                this.f = chatViewModel;
                this.g = c11458d25;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, this.e, this.f, this.g, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    RW1 rw1 = RW1.a;
                    Context context = this.c;
                    String descriptor = this.d.getDescriptor();
                    String str = this.e;
                    this.b = 1;
                    obj = RW1.w(rw1, context, descriptor, str, false, null, this, 16, null);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                this.f.v.t2(this.g, 0L, 0L, (C24967zW1) obj, this.f.i6());
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        Z0(InterfaceC9336Zm4 interfaceC9336Zm4, ChatViewModel chatViewModel, Context context, String str, C11458d25 c11458d25) {
            this.a = interfaceC9336Zm4;
            this.b = chatViewModel;
            this.c = context;
            this.d = str;
            this.e = c11458d25;
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            this.a.setValue(Boolean.TRUE);
            AbstractC10533bm0.d(AbstractC9773aX7.a(this.b), C12366eV1.b(), null, new a(this.c, interfaceC3346Am2, this.d, this.b, this.e, null), 2, null);
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void e() {
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$a, reason: case insensitive filesystem */
    static final class C11146a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        C11146a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            C11146a c11146a = ChatViewModel.this.new C11146a(interfaceC20295rm1);
            c11146a.c = obj;
            return c11146a;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            List list = (List) this.c;
            InterfaceC9336Zm4 interfaceC9336Zm4 = ChatViewModel.this.l2;
            List listN0 = AbstractC15401jX0.n0(list);
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listN0, 10));
            Iterator it = listN0.iterator();
            while (it.hasNext()) {
                arrayList.add(new S74((J44) it.next()));
            }
            interfaceC9336Zm4.setValue(arrayList);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11146a) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$a0, reason: case insensitive filesystem */
    static final class C11147a0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11147a0(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            C11147a0 c11147a0 = ChatViewModel.this.new C11147a0(this.e, interfaceC20295rm1);
            c11147a0.c = obj;
            return c11147a0;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC20315ro1 interfaceC20315ro1;
            Object objL;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro12 = (InterfaceC20315ro1) this.c;
                F84 f84 = ChatViewModel.this.m;
                String str = this.e;
                this.c = interfaceC20315ro12;
                this.b = 1;
                Object objN = f84.n(str, this);
                if (objN == objE) {
                    return objE;
                }
                interfaceC20315ro1 = interfaceC20315ro12;
                objL = objN;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                AbstractC10685c16.b(obj);
                objL = ((C9475a16) obj).l();
            }
            ChatViewModel chatViewModel = ChatViewModel.this;
            String str2 = this.e;
            if (C9475a16.j(objL)) {
                NA3 na3 = (NA3) objL;
                if (chatViewModel.O2 != null && AbstractC20906so1.g(interfaceC20315ro1)) {
                    na3.p(str2);
                    chatViewModel.Tb(na3);
                }
            }
            ChatViewModel chatViewModel2 = ChatViewModel.this;
            String str3 = this.e;
            if (C9475a16.e(objL) != null && chatViewModel2.O2 != null && AbstractC20906so1.g(interfaceC20315ro1)) {
                NA3 na32 = NA3.e;
                na32.p(str3);
                chatViewModel2.Tb(na32);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11147a0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$a1, reason: case insensitive filesystem */
    static final class C11148a1 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ QG2 c;
        final /* synthetic */ ChatViewModel d;
        final /* synthetic */ long e;
        final /* synthetic */ long f;
        final /* synthetic */ Context g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11148a1(QG2 qg2, ChatViewModel chatViewModel, long j, long j2, Context context, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = qg2;
            this.d = chatViewModel;
            this.e = j;
            this.f = j2;
            this.g = context;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new C11148a1(this.c, this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            String mimeTypeFromExtension;
            byte[] bArrI;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                String strA = this.c.a();
                if (strA == null) {
                    this.d.v.w2(this.d.z1, this.c, new ArrayList(), AbstractC6392Nk0.e(this.e), AbstractC6392Nk0.e(this.f), this.d.i6());
                    return C19938rB7.a;
                }
                if (this.c.e() == null && (mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(AbstractC12542en2.q(new File(strA)))) != null) {
                    QG2 qg2 = this.c;
                    C19406qI3.a("GifsRepository", "mime type is set manually", new Object[0]);
                    qg2.i(mimeTypeFromExtension);
                }
                if (this.c.f() == null) {
                    C19406qI3.a("GifsRepository", "thumbnail is set manually", new Object[0]);
                    ChatViewModel chatViewModel = this.d;
                    Context context = this.g;
                    this.b = 1;
                    obj = chatViewModel.s6(context, strA, this);
                    if (obj == objE) {
                        return objE;
                    }
                }
                this.d.v.w2(this.d.z1, this.c, new ArrayList(), AbstractC6392Nk0.e(this.e), AbstractC6392Nk0.e(this.f), this.d.i6());
                return C19938rB7.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            Bitmap bitmap = (Bitmap) obj;
            if (bitmap == null || (bArrI = V13.i(V13.o(bitmap, 90, 90))) == null) {
                bArrI = new byte[0];
            }
            this.c.j(bArrI);
            this.d.v.w2(this.d.z1, this.c, new ArrayList(), AbstractC6392Nk0.e(this.e), AbstractC6392Nk0.e(this.f), this.d.i6());
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11148a1) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$b, reason: case insensitive filesystem */
    static final class C11149b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        C11149b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new C11149b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            int i = ChatViewModel.this.x.getInt("selected_smiles_tab_key", 0);
            InterfaceC9336Zm4 interfaceC9336Zm4 = ChatViewModel.this.D2;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, FF6.b((FF6) value, QF6.values()[i], false, 2, null)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11149b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$b0, reason: case insensitive filesystem */
    static final class C11150b0 extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        C11150b0(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return ChatViewModel.this.N6(null, this);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$b1, reason: case insensitive filesystem */
    public static final class C11151b1 extends HashMap {
        C11151b1(ExPeerType exPeerType, ChatViewModel chatViewModel) {
            put("peer_type", exPeerType.name());
            put("peer_id", String.valueOf(chatViewModel.z1.getPeerId()));
        }

        public /* bridge */ boolean b(String str) {
            return super.containsKey(str);
        }

        public /* bridge */ boolean c(String str) {
            return super.containsValue(str);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof String) {
                return b((String) obj);
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof String) {
                return c((String) obj);
            }
            return false;
        }

        public /* bridge */ String d(String str) {
            return (String) super.get(str);
        }

        public /* bridge */ Set e() {
            return super.entrySet();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set entrySet() {
            return e();
        }

        public /* bridge */ Set f() {
            return super.keySet();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            if (obj instanceof String) {
                return d((String) obj);
            }
            return null;
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj instanceof String) ? obj2 : k((String) obj, (String) obj2);
        }

        public /* bridge */ String k(String str, String str2) {
            return (String) super.getOrDefault(str, str2);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set keySet() {
            return f();
        }

        public /* bridge */ int l() {
            return super.size();
        }

        public /* bridge */ Collection n() {
            return super.values();
        }

        public /* bridge */ String p(String str) {
            return (String) super.remove(str);
        }

        public /* bridge */ boolean q(String str, String str2) {
            return super.remove(str, str2);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object obj) {
            if (obj instanceof String) {
                return p((String) obj);
            }
            return null;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return l();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection values() {
            return n();
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if ((obj instanceof String) && (obj2 instanceof String)) {
                return q((String) obj, (String) obj2);
            }
            return false;
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$c, reason: case insensitive filesystem */
    public static final class C11152c {
        private C11152c() {
        }

        public /* synthetic */ C11152c(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$c0, reason: case insensitive filesystem */
    static final class C11153c0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        C11153c0(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            C11153c0 c11153c0 = new C11153c0(interfaceC20295rm1);
            c11153c0.c = obj;
            return c11153c0;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            RY1 ry1 = (RY1) this.c;
            return AbstractC6392Nk0.a((ry1 instanceof RY1.a) || (ry1 instanceof RY1.c));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(RY1 ry1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11153c0) create(ry1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$c1, reason: case insensitive filesystem */
    static final class C11154c1 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List c;
        final /* synthetic */ List d;
        final /* synthetic */ List e;
        final /* synthetic */ ChatViewModel f;
        final /* synthetic */ C11458d25 g;
        final /* synthetic */ long h;
        final /* synthetic */ long i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11154c1(List list, List list2, List list3, ChatViewModel chatViewModel, C11458d25 c11458d25, long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = list;
            this.d = list2;
            this.e = list3;
            this.f = chatViewModel;
            this.g = c11458d25;
            this.h = j;
            this.i = j2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new C11154c1(this.c, this.d, this.e, this.f, this.g, this.h, this.i, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            KW3 aVar;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            ArrayList arrayList = new ArrayList();
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                String str = (String) this.c.get(i);
                if (str != null) {
                    if (((Boolean) this.d.get(i)).booleanValue()) {
                        List list = this.e;
                        aVar = new KW3.b(str, list != null ? (String) list.get(i) : null, false, false, null, 16, null);
                    } else {
                        List list2 = this.e;
                        aVar = new KW3.a(str, list2 != null ? (String) list2.get(i) : null, false);
                    }
                    arrayList.add(aVar);
                }
            }
            F84 f84 = this.f.m;
            C11458d25 c11458d25 = this.g;
            long j = this.h;
            long j2 = this.i;
            C7880To7 c7880To7I6 = this.f.i6();
            KW3[] kw3Arr = (KW3[]) arrayList.toArray(new KW3[0]);
            f84.v(c11458d25, j, j2, c7880To7I6, (KW3[]) Arrays.copyOf(kw3Arr, kw3Arr.length));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11154c1) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$d, reason: case insensitive filesystem */
    public /* synthetic */ class C11155d {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;
        public static final /* synthetic */ int[] d;
        public static final /* synthetic */ int[] e;
        public static final /* synthetic */ int[] f;
        public static final /* synthetic */ int[] g;

        static {
            int[] iArr = new int[ExPeerType.values().length];
            try {
                iArr[ExPeerType.CHANNEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExPeerType.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ExPeerType.PRIVATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ExPeerType.BOT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ExPeerType.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ExPeerType.THREAD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            a = iArr;
            int[] iArr2 = new int[W25.values().length];
            try {
                iArr2[W25.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[W25.a.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[W25.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            b = iArr2;
            int[] iArr3 = new int[EnumC3633Br5.values().length];
            try {
                iArr3[EnumC3633Br5.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[EnumC3633Br5.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[EnumC3633Br5.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            c = iArr3;
            int[] iArr4 = new int[ZN2.values().length];
            try {
                iArr4[ZN2.GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr4[ZN2.CHANNEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            d = iArr4;
            int[] iArr5 = new int[EnumC20560sD2.values().length];
            try {
                iArr5[EnumC20560sD2.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr5[EnumC20560sD2.a.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr5[EnumC20560sD2.b.ordinal()] = 3;
            } catch (NoSuchFieldError unused17) {
            }
            e = iArr5;
            int[] iArr6 = new int[EnumC17253mf2.values().length];
            try {
                iArr6[EnumC17253mf2.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr6[EnumC17253mf2.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused19) {
            }
            f = iArr6;
            int[] iArr7 = new int[EnumC16752lo2.values().length];
            try {
                iArr7[EnumC16752lo2.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr7[EnumC16752lo2.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr7[EnumC16752lo2.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused22) {
            }
            g = iArr7;
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$d0, reason: case insensitive filesystem */
    static final class C11156d0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;

        C11156d0(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new C11156d0(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0099  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r8.d
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L29
                if (r1 == r3) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r0 = r8.c
                ir.nasim.chat.ChatViewModel r0 = (ir.nasim.chat.ChatViewModel) r0
                ir.nasim.AbstractC10685c16.b(r9)
                goto L95
            L17:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1f:
                ir.nasim.AbstractC10685c16.b(r9)
                ir.nasim.a16 r9 = (ir.nasim.C9475a16) r9
                java.lang.Object r9 = r9.l()
                goto L45
            L29:
                ir.nasim.AbstractC10685c16.b(r9)
                ir.nasim.chat.ChatViewModel r9 = ir.nasim.chat.ChatViewModel.this
                ir.nasim.Lm5 r9 = ir.nasim.chat.ChatViewModel.g3(r9)
                ir.nasim.chat.ChatViewModel r1 = ir.nasim.chat.ChatViewModel.this
                ir.nasim.d25 r1 = ir.nasim.chat.ChatViewModel.c3(r1)
                int r1 = r1.getPeerId()
                r8.d = r3
                java.lang.Object r9 = r9.k(r1, r3, r8)
                if (r9 != r0) goto L45
                return r0
            L45:
                ir.nasim.chat.ChatViewModel r1 = ir.nasim.chat.ChatViewModel.this
                boolean r3 = ir.nasim.C9475a16.j(r9)
                if (r3 == 0) goto Laa
                r3 = r9
                ai.bale.proto.PremiumOuterClass$ResponseIsPremium r3 = (ai.bale.proto.PremiumOuterClass$ResponseIsPremium) r3
                ai.bale.proto.PremiumStruct$UserPremiumStatus r4 = r3.getUserStatus()
                boolean r4 = r4.getIsPremium()
                if (r4 == 0) goto Laa
                ir.nasim.Lm5 r4 = ir.nasim.chat.ChatViewModel.g3(r1)
                ai.bale.proto.PremiumStruct$UserPremiumStatus r5 = r3.getUserStatus()
                ai.bale.proto.PremiumStruct$UserPremiumDetail r5 = r5.getDetail()
                ai.bale.proto.PremiumStruct$Badge r5 = r5.getBadge()
                long r5 = r5.getBadgeId()
                ai.bale.proto.PremiumStruct$UserPremiumStatus r3 = r3.getUserStatus()
                ai.bale.proto.PremiumStruct$UserPremiumDetail r3 = r3.getDetail()
                ai.bale.proto.PremiumStruct$Badge r3 = r3.getBadge()
                java.lang.String r3 = r3.getMediaUrl()
                java.lang.String r7 = "getMediaUrl(...)"
                ir.nasim.AbstractC13042fc3.h(r3, r7)
                ir.nasim.Fq2 r3 = r4.l(r5, r3)
                r8.b = r9
                r8.c = r1
                r8.d = r2
                java.lang.Object r9 = ir.nasim.AbstractC6459Nq2.I(r3, r8)
                if (r9 != r0) goto L94
                return r0
            L94:
                r0 = r1
            L95:
                java.lang.String r9 = (java.lang.String) r9
                if (r9 == 0) goto Laa
                ir.nasim.Zm4 r0 = ir.nasim.chat.ChatViewModel.A3(r0)
            L9d:
                java.lang.Object r1 = r0.getValue()
                r2 = r1
                java.lang.String r2 = (java.lang.String) r2
                boolean r1 = r0.f(r1, r9)
                if (r1 == 0) goto L9d
            Laa:
                ir.nasim.rB7 r9 = ir.nasim.C19938rB7.a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.C11156d0.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11156d0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$d1, reason: case insensitive filesystem */
    static final class C11157d1 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;
        final /* synthetic */ int e;
        final /* synthetic */ ExPeerType f;
        final /* synthetic */ Boolean g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11157d1(String str, int i, ExPeerType exPeerType, Boolean bool, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
            this.e = i;
            this.f = exPeerType;
            this.g = bool;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new C11157d1(this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC13727gj0 interfaceC13727gj0 = ChatViewModel.this.P0;
                String str = this.d;
                int i2 = this.e;
                ExPeerType exPeerType = this.f;
                long j = ChatViewModel.this.W1;
                long j2 = ChatViewModel.this.X1;
                Boolean bool = this.g;
                this.b = 1;
                if (interfaceC13727gj0.b(str, i2, exPeerType, j, j2, bool, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11157d1) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$e, reason: case insensitive filesystem */
    static final class C11158e extends AbstractC22163um1 {
        Object a;
        int b;
        /* synthetic */ Object c;
        int e;

        C11158e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            Object objO4 = ChatViewModel.this.o4(0, this);
            return objO4 == AbstractC14862ic3.e() ? objO4 : C9475a16.a(objO4);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$e0, reason: case insensitive filesystem */
    static final class C11159e0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.chat.ChatViewModel$e0$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ ChatViewModel c;

            /* renamed from: ir.nasim.chat.ChatViewModel$e0$a$a, reason: collision with other inner class name */
            static final class C0969a implements InterfaceC4806Gq2 {
                final /* synthetic */ ChatViewModel a;

                C0969a(ChatViewModel chatViewModel) {
                    this.a = chatViewModel;
                }

                @Override // ir.nasim.InterfaceC4806Gq2
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object a(IM5 im5, InterfaceC20295rm1 interfaceC20295rm1) {
                    this.a.k1.setValue(im5);
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ChatViewModel chatViewModel, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = chatViewModel;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    this.c.k1.setValue(IM5.b.a);
                    StoryRepository storyRepository = this.c.k;
                    GeneratedMessageLite generatedMessageLiteA = PeersStruct$ExPeer.newBuilder().B(this.c.z1.getPeerId()).C(EnumC10088b35.ExPeerType_CHANNEL).a();
                    AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                    this.b = 1;
                    obj = storyRepository.U((PeersStruct$ExPeer) generatedMessageLiteA, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        return C19938rB7.a;
                    }
                    AbstractC10685c16.b(obj);
                }
                C0969a c0969a = new C0969a(this.c);
                this.b = 2;
                if (((InterfaceC4557Fq2) obj).b(c0969a, this) == objE) {
                    return objE;
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        C11159e0(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new C11159e0(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                long jE2 = ChatViewModel.this.d.e2();
                a aVar = new a(ChatViewModel.this, null);
                this.b = 1;
                if (AbstractC3860Cq7.c(jE2, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11159e0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$e1, reason: case insensitive filesystem */
    static final class C11160e1 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11160e1(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new C11160e1(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            ChatViewModel.this.v.I2(ChatViewModel.this.z1, this.d, AbstractC6392Nk0.e(0L));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11160e1) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$f, reason: case insensitive filesystem */
    public static final class C11161f implements InterfaceC15419jZ0 {
        final /* synthetic */ HE0 a;

        C11161f(HE0 he0) {
            this.a = he0;
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public /* bridge */ /* synthetic */ void a(Object obj) {
            b(((Boolean) obj).booleanValue());
        }

        public void b(boolean z) {
            if (z) {
                HE0 he0 = this.a;
                C9475a16.a aVar = C9475a16.b;
                AbstractC24549yo1.c(he0, C9475a16.a(C9475a16.b(Integer.valueOf(DD5.contact_added))));
            }
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            AbstractC13042fc3.i(exc, "e");
            HE0 he0 = this.a;
            C9475a16.a aVar = C9475a16.b;
            AbstractC24549yo1.c(he0, C9475a16.a(C9475a16.b(AbstractC10685c16.a(exc))));
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$f0, reason: case insensitive filesystem */
    public static final class C11162f0 implements HM2 {
        private final SA2 a;
        private final UA2 b;
        private final UA2 c;
        private final SA2 d;

        C11162f0(final ChatViewModel chatViewModel) {
            this.a = new SA2() { // from class: ir.nasim.ZR0
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return ChatViewModel.C11162f0.i(chatViewModel);
                }
            };
            this.b = new UA2() { // from class: ir.nasim.aS0
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return ChatViewModel.C11162f0.l(chatViewModel, (ZN2) obj);
                }
            };
            this.c = new UA2() { // from class: ir.nasim.bS0
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return ChatViewModel.C11162f0.k(chatViewModel, (ZN2) obj);
                }
            };
            this.d = new SA2() { // from class: ir.nasim.cS0
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return ChatViewModel.C11162f0.j(chatViewModel);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(ChatViewModel chatViewModel) {
            AbstractC13042fc3.i(chatViewModel, "this$0");
            chatViewModel.s5();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 j(ChatViewModel chatViewModel) {
            AbstractC13042fc3.i(chatViewModel, "this$0");
            chatViewModel.s5();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 k(ChatViewModel chatViewModel, ZN2 zn2) {
            Object value;
            JQ0 jq0;
            AbstractC13042fc3.i(chatViewModel, "this$0");
            AbstractC13042fc3.i(zn2, "groupType");
            InterfaceC9336Zm4 interfaceC9336Zm4 = chatViewModel.g1;
            do {
                value = interfaceC9336Zm4.getValue();
                jq0 = (JQ0) value;
            } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : new InterfaceC4569Fr5.d(zn2), (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 l(ChatViewModel chatViewModel, ZN2 zn2) {
            Object value;
            JQ0 jq0;
            AbstractC13042fc3.i(chatViewModel, "this$0");
            AbstractC13042fc3.i(zn2, "groupType");
            InterfaceC9336Zm4 interfaceC9336Zm4 = chatViewModel.g1;
            do {
                value = interfaceC9336Zm4.getValue();
                jq0 = (JQ0) value;
            } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : new InterfaceC4569Fr5.c(zn2), (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.HM2
        public SA2 a() {
            return this.d;
        }

        @Override // ir.nasim.HM2
        public UA2 b() {
            return this.b;
        }

        @Override // ir.nasim.HM2
        public SA2 c() {
            return this.a;
        }

        @Override // ir.nasim.HM2
        public UA2 d() {
            return this.c;
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$f1, reason: case insensitive filesystem */
    static final class C11163f1 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        C11163f1(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new C11163f1(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objA;
            Object value;
            JQ0 jq0;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C19711qo6 c19711qo6 = ChatViewModel.this.N0;
                C11458d25 c11458d25 = ChatViewModel.this.z1;
                long j = ChatViewModel.this.G;
                C7880To7 c7880To7I6 = ChatViewModel.this.i6();
                this.b = 1;
                objA = c19711qo6.a(c11458d25, j, c7880To7I6, this);
                if (objA == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objA = ((C9475a16) obj).l();
            }
            ChatViewModel chatViewModel = ChatViewModel.this;
            if (C9475a16.e(objA) != null) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = chatViewModel.g1;
                do {
                    value = interfaceC9336Zm4.getValue();
                    jq0 = (JQ0) value;
                } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : AbstractC4616Fw7.a(null, AbstractC6392Nk0.d(DD5.error_unknown)), (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11163f1) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$g, reason: case insensitive filesystem */
    static final class C11164g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        final /* synthetic */ J44 e;
        final /* synthetic */ ChatViewModel f;
        final /* synthetic */ Context g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11164g(J44 j44, ChatViewModel chatViewModel, Context context, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = j44;
            this.f = chatViewModel;
            this.g = context;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new C11164g(this.e, this.f, this.g, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:41:0x00d1 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00d6  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00e5  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00eb  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00fd  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0119  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x012e A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0137  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0186  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r34) {
            /*
                Method dump skipped, instructions count: 482
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.C11164g.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11164g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$g0, reason: case insensitive filesystem */
    static final class C11165g0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ UA2 d;

        /* renamed from: ir.nasim.chat.ChatViewModel$g0$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ ChatViewModel d;
            final /* synthetic */ UA2 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ChatViewModel chatViewModel, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = chatViewModel;
                this.e = ua2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean y(Q64 q64, S74 s74) {
                return s74.a().i() == q64.i() && s74.a().h() == q64.h();
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object value;
                List listP1;
                Object value2;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                final Q64 q64 = (Q64) this.c;
                if (q64.i() >= 0 || q64.h() >= 0 || q64.r() >= 0) {
                    InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.l2;
                    do {
                        value = interfaceC9336Zm4.getValue();
                        listP1 = AbstractC15401jX0.p1((List) value);
                        AbstractC13610gX0.K(listP1, new UA2() { // from class: ir.nasim.chat.a1
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj2) {
                                return Boolean.valueOf(ChatViewModel.C11165g0.a.y(q64, (S74) obj2));
                            }
                        });
                    } while (!interfaceC9336Zm4.f(value, listP1));
                } else {
                    InterfaceC9336Zm4 interfaceC9336Zm42 = this.d.l2;
                    do {
                        value2 = interfaceC9336Zm42.getValue();
                    } while (!interfaceC9336Zm42.f(value2, AbstractC10360bX0.m()));
                }
                this.e.invoke(q64);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Q64 q64, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(q64, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11165g0(UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = ua2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new C11165g0(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            C19482qQ7 c19482qQ7B;
            InterfaceC4557Fq2 interfaceC4557Fq2A;
            InterfaceC4557Fq2 interfaceC4557Fq2F;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C14733iO2 c14733iO2W6 = ChatViewModel.this.w6();
                if (c14733iO2W6 != null && (c19482qQ7B = c14733iO2W6.B()) != null && (interfaceC4557Fq2A = AbstractC23145wQ7.a(c19482qQ7B)) != null && (interfaceC4557Fq2F = AbstractC6459Nq2.F(interfaceC4557Fq2A)) != null) {
                    a aVar = new a(ChatViewModel.this, this.d, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2F, aVar, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11165g0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class g1 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11458d25 d;
        final /* synthetic */ ExPeerType e;
        final /* synthetic */ J44 f;
        final /* synthetic */ G73.e g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g1(C11458d25 c11458d25, ExPeerType exPeerType, J44 j44, G73.e eVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c11458d25;
            this.e = exPeerType;
            this.f = j44;
            this.g = eVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final JQ0 D(C14439hv c14439hv, JQ0 jq0) {
            return jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : c14439hv, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final JQ0 z(JQ0 jq0) {
            return jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new g1(this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            String strB;
            Object objA;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC13727gj0 interfaceC13727gj0 = ChatViewModel.this.P0;
                C11458d25 c11458d25 = this.d;
                ExPeerType exPeerType = this.e;
                long jI = this.f.i();
                long jH = this.f.h();
                CI7 ci7Y = this.f.Y();
                if (ci7Y == null || (strB = ci7Y.b()) == null) {
                    strB = "";
                }
                String str = strB;
                String strD = this.g.d();
                this.b = 1;
                objA = interfaceC13727gj0.a(c11458d25, exPeerType, jI, jH, str, strD, this);
                if (objA == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objA = ((C9475a16) obj).l();
            }
            ChatViewModel chatViewModel = ChatViewModel.this;
            G73.e eVar = this.g;
            if (C9475a16.j(objA)) {
                final C14439hv c14439hv = (C14439hv) objA;
                chatViewModel.Nc(new UA2() { // from class: ir.nasim.chat.e1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj2) {
                        return ChatViewModel.g1.z((JQ0) obj2);
                    }
                });
                chatViewModel.Nc(new UA2() { // from class: ir.nasim.chat.f1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj2) {
                        return ChatViewModel.g1.D(c14439hv, (JQ0) obj2);
                    }
                });
                G73.d dVarA = eVar.a();
                if (dVarA != null) {
                    dVarA.b();
                }
            }
            G73.e eVar2 = this.g;
            Throwable thE = C9475a16.e(objA);
            if (thE != null) {
                G73.d dVarA2 = eVar2.a();
                if (dVarA2 != null) {
                    dVarA2.b();
                }
                C19406qI3.a("ChatViewModel", "sendRequestData, failed due to: " + thE, new Object[0]);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g1) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$h, reason: case insensitive filesystem */
    static final class C11166h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ long e;
        final /* synthetic */ String f;
        final /* synthetic */ List g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11166h(long j, long j2, String str, List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = j2;
            this.f = str;
            this.g = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new C11166h(this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                V9 v9 = ChatViewModel.this.q;
                C11458d25 c11458d25 = ChatViewModel.this.z1;
                long j = this.d;
                long j2 = this.e;
                String str = this.f;
                List list = this.g;
                boolean zH8 = ChatViewModel.this.H8();
                this.b = 1;
                if (v9.f(c11458d25, j, j2, str, list, zH8, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ((C9475a16) obj).l();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11166h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$h0, reason: case insensitive filesystem */
    static final class C11167h0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ UA2 d;

        /* renamed from: ir.nasim.chat.ChatViewModel$h0$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ ChatViewModel d;
            final /* synthetic */ UA2 e;

            /* renamed from: ir.nasim.chat.ChatViewModel$h0$a$a, reason: collision with other inner class name */
            public static final class C0970a implements Comparator {
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return AbstractC18050o01.d(Long.valueOf(((S74) obj).a().h()), Long.valueOf(((S74) obj2).a().h()));
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ChatViewModel chatViewModel, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = chatViewModel;
                this.e = ua2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object value;
                ArrayList arrayList;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                J44 j44 = (J44) this.c;
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.l2;
                do {
                    value = interfaceC9336Zm4.getValue();
                    List listP1 = AbstractC15401jX0.p1((List) value);
                    if (!listP1.contains(new S74(j44))) {
                        listP1.add(new S74(j44));
                    }
                    HashSet hashSet = new HashSet();
                    arrayList = new ArrayList();
                    for (Object obj2 : listP1) {
                        S74 s74 = (S74) obj2;
                        if (hashSet.add(AbstractC4616Fw7.a(AbstractC6392Nk0.e(s74.a().h()), AbstractC6392Nk0.e(s74.a().i())))) {
                            arrayList.add(obj2);
                        }
                    }
                } while (!interfaceC9336Zm4.f(value, AbstractC15401jX0.a1(arrayList, new C0970a())));
                this.e.invoke(j44);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(J44 j44, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(j44, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11167h0(UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = ua2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new C11167h0(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            C19482qQ7 c19482qQ7A;
            InterfaceC4557Fq2 interfaceC4557Fq2A;
            InterfaceC4557Fq2 interfaceC4557Fq2F;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C14733iO2 c14733iO2W6 = ChatViewModel.this.w6();
                if (c14733iO2W6 != null && (c19482qQ7A = c14733iO2W6.A()) != null && (interfaceC4557Fq2A = AbstractC23145wQ7.a(c19482qQ7A)) != null && (interfaceC4557Fq2F = AbstractC6459Nq2.F(interfaceC4557Fq2A)) != null) {
                    a aVar = new a(ChatViewModel.this, this.d, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2F, aVar, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11167h0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class h1 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ Context e;
        final /* synthetic */ SharedContent.MediaContent f;
        final /* synthetic */ long g;
        final /* synthetic */ long h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h1(Context context, SharedContent.MediaContent mediaContent, long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = context;
            this.f = mediaContent;
            this.g = j;
            this.h = j2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            h1 h1Var = ChatViewModel.this.new h1(this.e, this.f, this.g, this.h, interfaceC20295rm1);
            h1Var.c = obj;
            return h1Var;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                ChatViewModel chatViewModel = ChatViewModel.this;
                Context applicationContext = this.e.getApplicationContext();
                AbstractC13042fc3.h(applicationContext, "getApplicationContext(...)");
                SharedContent.MediaContent mediaContent = this.f;
                this.c = interfaceC20315ro1;
                this.b = 1;
                obj = chatViewModel.i5(applicationContext, mediaContent, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C24967zW1 c24967zW1 = (C24967zW1) obj;
            if (c24967zW1 == null) {
                C19406qI3.b("ChatViewModel", "Failed to send shared content!!");
                return C19938rB7.a;
            }
            ChatViewModel.this.v.t2(ChatViewModel.this.z1, this.g, this.h, c24967zW1, ChatViewModel.this.i6());
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h1) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$i, reason: case insensitive filesystem */
    public static final class C11168i implements InterfaceC15419jZ0 {
        final /* synthetic */ C4382Ew7 a;
        final /* synthetic */ ProgressDialog b;
        final /* synthetic */ C6833Pe1 c;
        final /* synthetic */ ChatViewModel d;
        final /* synthetic */ long e;

        C11168i(C4382Ew7 c4382Ew7, ProgressDialog progressDialog, C6833Pe1 c6833Pe1, ChatViewModel chatViewModel, long j) {
            this.a = c4382Ew7;
            this.b = progressDialog;
            this.c = c6833Pe1;
            this.d = chatViewModel;
            this.e = j;
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Boolean bool) {
            Object value;
            JQ0 jq0;
            Object objA = this.a.a();
            AbstractC13042fc3.h(objA, "getT1(...)");
            ((C21231tK7) AbstractC10242bK.b0((Object[]) objA)).z().i(bool);
            this.b.dismiss();
            C6833Pe1 c6833Pe1 = this.c;
            Object objA2 = this.a.a();
            AbstractC13042fc3.h(objA2, "getT1(...)");
            int iO = ((C21231tK7) AbstractC10242bK.b0((Object[]) objA2)).o();
            boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
            Object objA3 = this.a.a();
            AbstractC13042fc3.h(objA3, "getT1(...)");
            C6833Pe1 c6833Pe1C = c6833Pe1.C(iO, zBooleanValue, (Avatar) ((C21231tK7) AbstractC10242bK.b0((Object[]) objA3)).h().b());
            J44 j44 = (J44) this.d.v.H0(this.d.z1).a(this.e);
            AbstractC13042fc3.f(c6833Pe1C);
            this.d.v.H0(this.d.z1).d(j44.u(c6833Pe1C, true));
            if (AbstractC13042fc3.d(bool, Boolean.TRUE)) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.g1;
                do {
                    value = interfaceC9336Zm4.getValue();
                    jq0 = (JQ0) value;
                } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : AbstractC4616Fw7.a(null, Integer.valueOf(DD5.contact_added)), (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
            }
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            Object value;
            JQ0 jq0;
            Log.i("addUserToMyContacts", "ERROR: " + (exc != null ? exc.getMessage() : null));
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.g1;
            do {
                value = interfaceC9336Zm4.getValue();
                jq0 = (JQ0) value;
            } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : AbstractC4616Fw7.a(null, Integer.valueOf(DD5.security_toast_unable_to_load)), (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
            this.b.dismiss();
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$i0, reason: case insensitive filesystem */
    static final class C11169i0 extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        /* synthetic */ Object e;
        int g;

        C11169i0(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return ChatViewModel.this.o8(null, null, null, null, this);
        }
    }

    static final class i1 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        int g;
        final /* synthetic */ long i;
        final /* synthetic */ long j;
        final /* synthetic */ Context k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i1(long j, long j2, Context context, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.i = j;
            this.j = j2;
            this.k = context;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new i1(this.i, this.j, this.k, interfaceC20295rm1);
        }

        /* JADX WARN: Code restructure failed: missing block: B:47:0x00b6, code lost:
        
            if (r13 == null) goto L23;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00bc  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00e0  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00e3  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00e5  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00e9  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0126  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x012b  */
        /* JADX WARN: Type inference failed for: r9v21, types: [java.util.Collection] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00e5 -> B:23:0x00b6). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00e9 -> B:15:0x0061). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x011d -> B:39:0x0120). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r23) {
            /*
                Method dump skipped, instructions count: 335
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.i1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i1) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$j, reason: case insensitive filesystem */
    static final class C11170j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ List e;
        final /* synthetic */ long f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11170j(long j, List list, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = list;
            this.f = j2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new C11170j(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objH;
            Object value;
            JQ0 jq0;
            Object value2;
            JQ0 jq02;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C3777Ch5 c3777Ch5 = ChatViewModel.this.X0;
                long j = this.d;
                List list = this.e;
                this.b = 1;
                objH = c3777Ch5.h(j, list, this);
                if (objH == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objH = obj;
            }
            C16885m18 c16885m18 = (C16885m18) objH;
            if (c16885m18 != null) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = ChatViewModel.this.g1;
                long j2 = this.f;
                do {
                    value2 = interfaceC9336Zm4.getValue();
                    jq02 = (JQ0) value2;
                } while (!interfaceC9336Zm4.f(value2, jq02.a((262142 & 1) != 0 ? jq02.a : null, (262142 & 2) != 0 ? jq02.b : null, (262142 & 4) != 0 ? jq02.c : null, (262142 & 8) != 0 ? jq02.d : null, (262142 & 16) != 0 ? jq02.e : false, (262142 & 32) != 0 ? jq02.f : null, (262142 & 64) != 0 ? jq02.g : null, (262142 & 128) != 0 ? jq02.h : null, (262142 & 256) != 0 ? jq02.i : null, (262142 & 512) != 0 ? jq02.j : null, (262142 & 1024) != 0 ? jq02.k : null, (262142 & 2048) != 0 ? jq02.l : null, (262142 & 4096) != 0 ? jq02.m : null, (262142 & 8192) != 0 ? jq02.n : null, (262142 & 16384) != 0 ? jq02.o : null, (262142 & 32768) != 0 ? jq02.p : null, (262142 & 65536) != 0 ? jq02.q : new XV4(c16885m18, AbstractC6392Nk0.e(j2)), (262142 & 131072) != 0 ? jq02.r : null)));
            } else {
                InterfaceC9336Zm4 interfaceC9336Zm42 = ChatViewModel.this.g1;
                do {
                    value = interfaceC9336Zm42.getValue();
                    jq0 = (JQ0) value;
                } while (!interfaceC9336Zm42.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : AbstractC4616Fw7.a(null, AbstractC6392Nk0.d(DD5.error_unknown)), (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11170j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$j0, reason: case insensitive filesystem */
    static final class C11171j0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        C11171j0(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new C11171j0(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            ChatViewModel chatViewModel;
            ChatViewModel chatViewModel2;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (ChatViewModel.this.z1.C()) {
                    ChatViewModel chatViewModel3 = ChatViewModel.this;
                    InterfaceC11621dJ7 interfaceC11621dJ7 = chatViewModel3.l;
                    long peerId = ChatViewModel.this.z1.getPeerId();
                    this.b = chatViewModel3;
                    this.c = 1;
                    Object objM = interfaceC11621dJ7.m(peerId, this);
                    if (objM == objE) {
                        return objE;
                    }
                    chatViewModel2 = chatViewModel3;
                    obj = objM;
                    chatViewModel2.M1 = (C21231tK7) obj;
                } else if (ChatViewModel.this.z1.z()) {
                    ChatViewModel chatViewModel4 = ChatViewModel.this;
                    KM2 km2 = chatViewModel4.j;
                    long peerId2 = ChatViewModel.this.z1.getPeerId();
                    this.b = chatViewModel4;
                    this.c = 2;
                    Object objM2 = km2.m(peerId2, this);
                    if (objM2 == objE) {
                        return objE;
                    }
                    chatViewModel = chatViewModel4;
                    obj = objM2;
                    chatViewModel.Rb((C14733iO2) obj);
                }
            } else if (i == 1) {
                chatViewModel2 = (ChatViewModel) this.b;
                AbstractC10685c16.b(obj);
                chatViewModel2.M1 = (C21231tK7) obj;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                chatViewModel = (ChatViewModel) this.b;
                AbstractC10685c16.b(obj);
                chatViewModel.Rb((C14733iO2) obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11171j0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class j1 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C10240bJ6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j1(C10240bJ6 c10240bJ6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c10240bJ6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new j1(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC17527n7 interfaceC17527n7 = ChatViewModel.this.p;
                String strB = this.d.b();
                ExPeer exPeer = new ExPeer(ChatViewModel.this.m6(), ChatViewModel.this.z1.getPeerId());
                this.b = 1;
                if (interfaceC17527n7.l(strB, exPeer, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            ChatViewModel.this.p.f(this.d.b(), this.d.g(), this.d.h(), this.d.a(), this.d.e(), ChatViewModel.this.m6());
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j1) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$k, reason: case insensitive filesystem */
    static final class C11172k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ EnumC3633Br5 c;
        final /* synthetic */ ChatViewModel d;
        final /* synthetic */ HashSet e;
        final /* synthetic */ C14733iO2 f;

        /* renamed from: ir.nasim.chat.ChatViewModel$k$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC3633Br5.values().length];
                try {
                    iArr[EnumC3633Br5.c.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC3633Br5.b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[EnumC3633Br5.d.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11172k(EnumC3633Br5 enumC3633Br5, ChatViewModel chatViewModel, HashSet hashSet, C14733iO2 c14733iO2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = enumC3633Br5;
            this.d = chatViewModel;
            this.e = hashSet;
            this.f = c14733iO2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new C11172k(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object value2;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                EnumC3633Br5 enumC3633Br5 = this.c;
                int i2 = enumC3633Br5 == null ? -1 : a.a[enumC3633Br5.ordinal()];
                if (i2 != -1) {
                    if (i2 == 1) {
                        ChatViewModel chatViewModel = this.d;
                        HashSet hashSet = this.e;
                        AbstractC13042fc3.f(hashSet);
                        ZN2 zn2Q = this.f.q();
                        AbstractC13042fc3.h(zn2Q, "getGroupType(...)");
                        this.b = 1;
                        if (chatViewModel.E5(hashSet, zn2Q, this) == objE) {
                            return objE;
                        }
                    } else if (i2 == 2) {
                        InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.i1;
                        do {
                            value = interfaceC9336Zm4.getValue();
                        } while (!interfaceC9336Zm4.f(value, InterfaceC4335Er5.d.a));
                    } else {
                        if (i2 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        InterfaceC9336Zm4 interfaceC9336Zm42 = this.d.i1;
                        do {
                            value2 = interfaceC9336Zm42.getValue();
                        } while (!interfaceC9336Zm42.f(value2, InterfaceC4335Er5.f.a));
                        C19406qI3.j("NewChatPrivacyBar", "Receive " + this.c + " value for privacyBar mode", new Object[0]);
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11172k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$k0, reason: case insensitive filesystem */
    static final class C11173k0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;
        final /* synthetic */ boolean e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11173k0(int i, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new C11173k0(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC21103t7 interfaceC21103t7 = ChatViewModel.this.o;
                int i2 = this.d;
                boolean z = this.e;
                this.b = 1;
                obj = interfaceC21103t7.g(i2, z, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C14683iJ6 c14683iJ6 = (C14683iJ6) obj;
            if (!ChatViewModel.this.M8() && c14683iJ6 != null) {
                ChatViewModel.this.v1 = c14683iJ6;
                ChatViewModel.this.n5(c14683iJ6);
                ChatViewModel.this.Sb(true);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11173k0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class k1 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;
        final /* synthetic */ C25238zy g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k1(C25238zy c25238zy, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.g = c25238zy;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new k1(this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            C14683iJ6 c14683iJ6;
            ChatViewModel chatViewModel;
            C25238zy c25238zy;
            Object objE = AbstractC14862ic3.e();
            int i = this.e;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C14683iJ6 c14683iJ62 = ChatViewModel.this.v1;
                if (c14683iJ62 != null) {
                    ChatViewModel chatViewModel2 = ChatViewModel.this;
                    C25238zy c25238zy2 = this.g;
                    InterfaceC17527n7 interfaceC17527n7 = chatViewModel2.p;
                    String strB = c14683iJ62.b();
                    this.b = chatViewModel2;
                    this.c = c25238zy2;
                    this.d = c14683iJ62;
                    this.e = 1;
                    if (interfaceC17527n7.k(strB, c25238zy2, this) == objE) {
                        return objE;
                    }
                    c14683iJ6 = c14683iJ62;
                    chatViewModel = chatViewModel2;
                    c25238zy = c25238zy2;
                }
                return C19938rB7.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c14683iJ6 = (C14683iJ6) this.d;
            c25238zy = (C25238zy) this.c;
            chatViewModel = (ChatViewModel) this.b;
            AbstractC10685c16.b(obj);
            chatViewModel.p.c(c14683iJ6.b(), c14683iJ6.f(), c14683iJ6.g(), c14683iJ6.a(), c25238zy.q());
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k1) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$l, reason: case insensitive filesystem */
    static final class C11174l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        C11174l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new C11174l(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                ChatViewModel chatViewModel = ChatViewModel.this;
                this.b = 1;
                if (chatViewModel.H4(this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ((C9475a16) obj).l();
            }
            ChatViewModel.this.la();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11174l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$l0, reason: case insensitive filesystem */
    static final class C11175l0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        C11175l0(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new C11175l0(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objG;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                V9 v9 = ChatViewModel.this.q;
                this.b = 1;
                objG = v9.g(this);
                if (objG == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objG = ((C9475a16) obj).l();
            }
            ChatViewModel chatViewModel = ChatViewModel.this;
            if (C9475a16.j(objG)) {
                chatViewModel.x.g("AVATAR_REACTION_ENABLE", ((Boolean) objG).booleanValue());
            }
            if (C9475a16.e(objG) != null) {
                C19406qI3.b("ChatViewModel", "GetShowReactionFlag Fail");
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11175l0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class l1 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ long e;
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l1(long j, long j2, int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = j2;
            this.f = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new l1(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            ChatViewModel.this.v.L2(ChatViewModel.this.z1, ChatViewModel.this.m6(), this.d, this.e, this.f);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((l1) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$m, reason: case insensitive filesystem */
    static final class C11176m extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        C11176m(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objG4 = ChatViewModel.this.G4(0, this);
            return objG4 == AbstractC14862ic3.e() ? objG4 : C9475a16.a(objG4);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$m0, reason: case insensitive filesystem */
    static final class C11177m0 extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        C11177m0(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objX8 = ChatViewModel.this.X8(0, null, null, this);
            return objX8 == AbstractC14862ic3.e() ? objX8 : C9475a16.a(objX8);
        }
    }

    static final class m1 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m1(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new m1(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            JQ0 jq0;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC10503bj0 interfaceC10503bj0E = ((JQ0) ChatViewModel.this.C7().getValue()).e();
            InterfaceC10503bj0.a aVar = interfaceC10503bj0E instanceof InterfaceC10503bj0.a ? (InterfaceC10503bj0.a) interfaceC10503bj0E : null;
            if (aVar == null) {
                return C19938rB7.a;
            }
            InterfaceC9336Zm4 interfaceC9336Zm4 = ChatViewModel.this.g1;
            boolean z = this.d;
            do {
                value = interfaceC9336Zm4.getValue();
                jq0 = (JQ0) value;
            } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : InterfaceC10503bj0.a.b(aVar, null, z, 1, null), (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((m1) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$n, reason: case insensitive filesystem */
    static final class C11178n extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        C11178n(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            Object objH4 = ChatViewModel.this.H4(this);
            return objH4 == AbstractC14862ic3.e() ? objH4 : C9475a16.a(objH4);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$n0, reason: case insensitive filesystem */
    static final class C11179n0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11179n0(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new C11179n0(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objL;
            Object value;
            JQ0 jq0;
            Object value2;
            JQ0 jq02;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C4744Gj3 c4744Gj3 = ChatViewModel.this.J0;
                String str = this.d;
                this.b = 1;
                Object objA = c4744Gj3.a(str, this);
                if (objA == objE) {
                    return objE;
                }
                objL = objA;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objL = ((C9475a16) obj).l();
            }
            ChatViewModel chatViewModel = ChatViewModel.this;
            Throwable thE = C9475a16.e(objL);
            if (thE != null) {
                if (thE instanceof IllegalStateException) {
                    InterfaceC9336Zm4 interfaceC9336Zm4 = chatViewModel.g1;
                    do {
                        value2 = interfaceC9336Zm4.getValue();
                        jq02 = (JQ0) value2;
                    } while (!interfaceC9336Zm4.f(value2, jq02.a((262142 & 1) != 0 ? jq02.a : AbstractC4616Fw7.a(null, AbstractC6392Nk0.d(DD5.toast_can_not_join_multiple_calls)), (262142 & 2) != 0 ? jq02.b : null, (262142 & 4) != 0 ? jq02.c : null, (262142 & 8) != 0 ? jq02.d : null, (262142 & 16) != 0 ? jq02.e : false, (262142 & 32) != 0 ? jq02.f : null, (262142 & 64) != 0 ? jq02.g : null, (262142 & 128) != 0 ? jq02.h : null, (262142 & 256) != 0 ? jq02.i : null, (262142 & 512) != 0 ? jq02.j : null, (262142 & 1024) != 0 ? jq02.k : null, (262142 & 2048) != 0 ? jq02.l : null, (262142 & 4096) != 0 ? jq02.m : null, (262142 & 8192) != 0 ? jq02.n : null, (262142 & 16384) != 0 ? jq02.o : null, (262142 & 32768) != 0 ? jq02.p : null, (262142 & 65536) != 0 ? jq02.q : null, (262142 & 131072) != 0 ? jq02.r : null)));
                } else {
                    InterfaceC9336Zm4 interfaceC9336Zm42 = chatViewModel.g1;
                    do {
                        value = interfaceC9336Zm42.getValue();
                        jq0 = (JQ0) value;
                    } while (!interfaceC9336Zm42.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : AbstractC4616Fw7.a(null, AbstractC6392Nk0.d(DD5.toast_invalid_call_link)), (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11179n0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class n1 extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        n1(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return ChatViewModel.this.Ib(null, this);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$o, reason: case insensitive filesystem */
    public static final class C11180o implements InterfaceC13136fj0 {
        private final SA2 a;
        private final UA2 b;
        private final SA2 c;

        C11180o(final ChatViewModel chatViewModel) {
            this.a = new SA2() { // from class: ir.nasim.WR0
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return ChatViewModel.C11180o.i(chatViewModel);
                }
            };
            this.b = new UA2() { // from class: ir.nasim.XR0
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return ChatViewModel.C11180o.g(chatViewModel, (String) obj);
                }
            };
            this.c = new SA2() { // from class: ir.nasim.YR0
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return ChatViewModel.C11180o.h(chatViewModel);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 g(ChatViewModel chatViewModel, String str) {
            Object value;
            JQ0 jq0;
            AbstractC13042fc3.i(chatViewModel, "this$0");
            AbstractC13042fc3.i(str, "username");
            InterfaceC9336Zm4 interfaceC9336Zm4 = chatViewModel.g1;
            do {
                value = interfaceC9336Zm4.getValue();
                jq0 = (JQ0) value;
            } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : new InterfaceC4569Fr5.a(str, true), (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(ChatViewModel chatViewModel) {
            AbstractC13042fc3.i(chatViewModel, "this$0");
            chatViewModel.s5();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(ChatViewModel chatViewModel) {
            AbstractC13042fc3.i(chatViewModel, "this$0");
            chatViewModel.s5();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC13136fj0
        public SA2 a() {
            return this.c;
        }

        @Override // ir.nasim.InterfaceC13136fj0
        public UA2 b() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC13136fj0
        public SA2 c() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$o0, reason: case insensitive filesystem */
    static final class C11181o0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ UA2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11181o0(UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = ua2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void D(C11637dL5 c11637dL5, List list) {
            List listR;
            AbstractC13042fc3.f(list);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                J44 j44 = (J44) it.next();
                if (j44.F() instanceof C11907dl) {
                    int i = c11637dL5.a;
                    AbstractC17457n0 abstractC17457n0F = j44.F();
                    C11907dl c11907dl = abstractC17457n0F instanceof C11907dl ? (C11907dl) abstractC17457n0F : null;
                    c11637dL5.a = i + ((c11907dl == null || (listR = c11907dl.r()) == null) ? 0 : listR.size());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void z(ChatViewModel chatViewModel, UA2 ua2, final C11637dL5 c11637dL5, C14505i18 c14505i18) {
            Object value;
            List listK = chatViewModel.v.H0(chatViewModel.z1).k();
            AbstractC13042fc3.h(listK, "getAllValue(...)");
            J44 j44 = (J44) AbstractC15401jX0.t0(listK, chatViewModel.d.a2() - 1);
            DB3 db3H0 = chatViewModel.v.H0(chatViewModel.z1);
            if (j44 != null) {
                db3H0.x(null, j44.h(), EnumC24659yz5.b, 10, true).m0(new InterfaceC24449ye1() { // from class: ir.nasim.chat.c1
                    @Override // ir.nasim.InterfaceC24449ye1
                    public final void apply(Object obj) {
                        ChatViewModel.C11181o0.D(c11637dL5, (List) obj);
                    }
                });
                ua2.invoke(j44);
                InterfaceC9336Zm4 interfaceC9336Zm4 = chatViewModel.Y1;
                do {
                    value = interfaceC9336Zm4.getValue();
                    ((Number) value).intValue();
                } while (!interfaceC9336Zm4.f(value, Integer.valueOf(chatViewModel.d.a2() + c11637dL5.a)));
            }
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new C11181o0(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            final C11637dL5 c11637dL5 = new C11637dL5();
            C6517Nv5 c6517Nv5J1 = ChatViewModel.this.v.J1(ChatViewModel.this.z1, false);
            final ChatViewModel chatViewModel = ChatViewModel.this;
            final UA2 ua2 = this.d;
            c6517Nv5J1.m0(new InterfaceC24449ye1() { // from class: ir.nasim.chat.b1
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj2) {
                    ChatViewModel.C11181o0.z(chatViewModel, ua2, c11637dL5, (C14505i18) obj2);
                }
            });
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11181o0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class o1 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        int f;

        o1(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new o1(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            ChatViewModel chatViewModel;
            String str;
            C21231tK7 c21231tK7;
            String str2;
            Object objL;
            Object value;
            JQ0 jq0;
            Object value2;
            JQ0 jq02;
            Object objE = AbstractC14862ic3.e();
            int i = this.f;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C21231tK7 c21231tK72 = ChatViewModel.this.M1;
                if (c21231tK72 != null) {
                    chatViewModel = ChatViewModel.this;
                    String str3 = "PREF_KEY_BOT_WEB_APP_MENU_TITLE" + chatViewModel.z1.getPeerId();
                    String string = chatViewModel.x.getString(str3, "");
                    AbstractC13042fc3.f(string);
                    if (!AbstractC20762sZ6.n0(string)) {
                        InterfaceC9336Zm4 interfaceC9336Zm4 = chatViewModel.g1;
                        do {
                            value = interfaceC9336Zm4.getValue();
                            jq0 = (JQ0) value;
                        } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : new InterfaceC10503bj0.c(string, null), (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
                    } else {
                        chatViewModel.Eb(c21231tK72);
                    }
                    C14652iG2 c14652iG2 = chatViewModel.t;
                    int peerId = chatViewModel.z1.getPeerId();
                    this.b = chatViewModel;
                    this.c = c21231tK72;
                    this.d = str3;
                    this.e = string;
                    this.f = 1;
                    Object objA = c14652iG2.a(peerId, this);
                    if (objA == objE) {
                        return objE;
                    }
                    str = string;
                    c21231tK7 = c21231tK72;
                    str2 = str3;
                    objL = objA;
                }
                return C19938rB7.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) this.e;
            str2 = (String) this.d;
            c21231tK7 = (C21231tK7) this.c;
            chatViewModel = (ChatViewModel) this.b;
            AbstractC10685c16.b(obj);
            objL = ((C9475a16) obj).l();
            AbstractC15729k44.a aVar = AbstractC15729k44.a.a;
            if (C9475a16.g(objL)) {
                objL = aVar;
            }
            AbstractC15729k44 abstractC15729k44 = (AbstractC15729k44) objL;
            if (abstractC15729k44 instanceof AbstractC15729k44.a) {
                AbstractC13042fc3.f(str);
                if (AbstractC20762sZ6.n0(str)) {
                    chatViewModel.Eb(c21231tK7);
                }
            } else {
                if (!(abstractC15729k44 instanceof AbstractC15729k44.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                AbstractC15729k44.b bVar = (AbstractC15729k44.b) abstractC15729k44;
                chatViewModel.x.putString(str2, bVar.a());
                InterfaceC10503bj0.c cVar = new InterfaceC10503bj0.c(bVar.a(), bVar.b());
                InterfaceC9336Zm4 interfaceC9336Zm42 = chatViewModel.g1;
                do {
                    value2 = interfaceC9336Zm42.getValue();
                    jq02 = (JQ0) value2;
                } while (!interfaceC9336Zm42.f(value2, jq02.a((262142 & 1) != 0 ? jq02.a : null, (262142 & 2) != 0 ? jq02.b : null, (262142 & 4) != 0 ? jq02.c : null, (262142 & 8) != 0 ? jq02.d : null, (262142 & 16) != 0 ? jq02.e : false, (262142 & 32) != 0 ? jq02.f : null, (262142 & 64) != 0 ? jq02.g : null, (262142 & 128) != 0 ? jq02.h : null, (262142 & 256) != 0 ? jq02.i : null, (262142 & 512) != 0 ? jq02.j : null, (262142 & 1024) != 0 ? jq02.k : cVar, (262142 & 2048) != 0 ? jq02.l : null, (262142 & 4096) != 0 ? jq02.m : null, (262142 & 8192) != 0 ? jq02.n : null, (262142 & 16384) != 0 ? jq02.o : null, (262142 & 32768) != 0 ? jq02.p : null, (262142 & 65536) != 0 ? jq02.q : null, (262142 & 131072) != 0 ? jq02.r : null)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((o1) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$p, reason: case insensitive filesystem */
    public static final class C11182p implements InterfaceC8807Xk2 {
        final /* synthetic */ InterfaceC24449ye1 a;

        C11182p(InterfaceC24449ye1 interfaceC24449ye1) {
            this.a = interfaceC24449ye1;
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void c(float f) {
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            this.a.apply(interfaceC3346Am2);
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void e() {
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$p0, reason: case insensitive filesystem */
    static final class C11183p0 extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        C11183p0(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return ChatViewModel.this.n9(this);
        }
    }

    static final class p1 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        p1(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new p1(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20667sP1 interfaceC20667sP1 = ChatViewModel.this.R0;
                List listE = AbstractC9766aX0.e(new ExPeer(ChatViewModel.this.m6(), ChatViewModel.this.z1.getPeerId()));
                this.b = 1;
                if (interfaceC20667sP1.u(listE, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((p1) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$q, reason: case insensitive filesystem */
    public static final class C11184q implements InterfaceC10223bH7 {
        final /* synthetic */ J44 a;
        final /* synthetic */ ChatViewModel b;

        C11184q(J44 j44, ChatViewModel chatViewModel) {
            this.a = j44;
            this.b = chatViewModel;
        }

        @Override // ir.nasim.InterfaceC10223bH7
        public void g(boolean z) {
            if (z) {
                return;
            }
            C19406qI3.j("ChatViewModel", "Pending message(" + this.a.i() + ") without an active upload detected.", new Object[0]);
            this.b.v.n2(this.b.z1, this.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$q0, reason: case insensitive filesystem */
    static final class C11185q0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ UA2 d;
        final /* synthetic */ ChatViewModel e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11185q0(UA2 ua2, ChatViewModel chatViewModel, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = ua2;
            this.e = chatViewModel;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new C11185q0(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            UA2 ua2;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                UA2 ua22 = this.d;
                NR nr = this.e.O0;
                SR sr = SR.b;
                this.b = ua22;
                this.c = 1;
                Object objJ = nr.j(sr, this);
                if (objJ == objE) {
                    return objE;
                }
                ua2 = ua22;
                obj = objJ;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua2 = (UA2) this.b;
                AbstractC10685c16.b(obj);
            }
            ua2.invoke(AbstractC6392Nk0.a(!((Boolean) obj).booleanValue()));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11185q0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class q1 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ long e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q1(long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = j2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new q1(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20642sM3 interfaceC20642sM3 = ChatViewModel.this.A;
                long j = this.d;
                long j2 = this.e;
                int peerId = ChatViewModel.this.z1.getPeerId();
                EnumC16311l35 enumC16311l35 = EnumC16311l35.PeerType_GROUP;
                this.b = 1;
                if (interfaceC20642sM3.a(j, j2, 0L, peerId, enumC16311l35, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((q1) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$r, reason: case insensitive filesystem */
    static final class C11186r extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ ShareData c;
        final /* synthetic */ ChatViewModel d;
        final /* synthetic */ Context e;
        final /* synthetic */ String[] f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11186r(ShareData shareData, ChatViewModel chatViewModel, Context context, String[] strArr, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = shareData;
            this.d = chatViewModel;
            this.e = context;
            this.f = strArr;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new C11186r(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws IOException {
            Object value;
            Uri uri;
            Object value2;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            List<String> sendUriMultiple = this.c.getSendUriMultiple();
            if (sendUriMultiple != null) {
                Context context = this.e;
                String[] strArr = this.f;
                ChatViewModel chatViewModel = this.d;
                for (String str : sendUriMultiple) {
                    if (str != null && (uri = Uri.parse(str)) != null) {
                        Cursor cursorQuery = context.getContentResolver().query(uri, strArr, null, null, null);
                        try {
                            Cursor cursor = cursorQuery;
                            if (cursor != null && cursor.moveToFirst() && !AbstractC13042fc3.d(cursor.getString(cursor.getColumnIndex(strArr[0])), "image/gif")) {
                                InterfaceC9336Zm4 interfaceC9336Zm4 = chatViewModel.x1;
                                do {
                                    value2 = interfaceC9336Zm4.getValue();
                                } while (!interfaceC9336Zm4.f(value2, new K35.a(AbstractC12217eE5.your_single_group_send_media_permission_denied)));
                                C19938rB7 c19938rB7 = C19938rB7.a;
                                YV0.a(cursorQuery, null);
                                return c19938rB7;
                            }
                            C19938rB7 c19938rB72 = C19938rB7.a;
                            YV0.a(cursorQuery, null);
                        } finally {
                        }
                    }
                }
            }
            InterfaceC9336Zm4 interfaceC9336Zm42 = this.d.x1;
            ShareData shareData = this.c;
            do {
                value = interfaceC9336Zm42.getValue();
            } while (!interfaceC9336Zm42.f(value, new K35.b(shareData)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11186r) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$r0, reason: case insensitive filesystem */
    static final class C11187r0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        C11187r0(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new C11187r0(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            JQ0 jq0;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC10503bj0 interfaceC10503bj0E = ((JQ0) ChatViewModel.this.C7().getValue()).e();
            InterfaceC10503bj0.a aVar = interfaceC10503bj0E instanceof InterfaceC10503bj0.a ? (InterfaceC10503bj0.a) interfaceC10503bj0E : null;
            if (aVar == null) {
                return C19938rB7.a;
            }
            InterfaceC9336Zm4 interfaceC9336Zm4 = ChatViewModel.this.g1;
            do {
                value = interfaceC9336Zm4.getValue();
                jq0 = (JQ0) value;
            } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : InterfaceC10503bj0.a.b(aVar, null, !aVar.d(), 1, null), (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11187r0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class r1 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ long e;
        final /* synthetic */ Context f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r1(long j, long j2, Context context, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = j2;
            this.f = context;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new r1(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20642sM3 interfaceC20642sM3 = ChatViewModel.this.A;
                long j = this.d;
                long j2 = this.e;
                int peerId = ChatViewModel.this.z1.getPeerId();
                EnumC16311l35 enumC16311l35 = EnumC16311l35.PeerType_GROUP;
                this.b = 1;
                obj = interfaceC20642sM3.a(j, j2, 0L, peerId, enumC16311l35, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            Z06 z06 = (Z06) obj;
            if (z06 instanceof Z06.a) {
                String str = ((Z06.a) z06).a().getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String();
                int iHashCode = str.hashCode();
                if (iHashCode != 1428934658) {
                    if (iHashCode != 1848044966) {
                        if (iHashCode == 1872749348) {
                            str.equals("TOO_OLD_MESSAGE");
                        }
                    } else if (str.equals("NOT_MEMBER")) {
                        ChatViewModel.this.ec();
                    }
                } else if (str.equals("DAILY_POST_UPVOTES_LIMIT_EXCEED")) {
                    ChatViewModel.this.V9(this.f);
                }
            } else {
                if (!(z06 instanceof Z06.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                ChatViewModel.this.dc(this.f);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((r1) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$s, reason: case insensitive filesystem */
    static final class C11188s extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ ShareData c;
        final /* synthetic */ ChatViewModel d;
        final /* synthetic */ Context e;
        final /* synthetic */ String[] f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11188s(ShareData shareData, ChatViewModel chatViewModel, Context context, String[] strArr, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = shareData;
            this.d = chatViewModel;
            this.e = context;
            this.f = strArr;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new C11188s(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws IOException {
            Object value;
            Uri uri;
            Object value2;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            List<String> sendUriMultiple = this.c.getSendUriMultiple();
            if (sendUriMultiple != null) {
                Context context = this.e;
                String[] strArr = this.f;
                ChatViewModel chatViewModel = this.d;
                for (String str : sendUriMultiple) {
                    if (str != null && (uri = Uri.parse(str)) != null) {
                        Cursor cursorQuery = context.getContentResolver().query(uri, strArr, null, null, null);
                        try {
                            Cursor cursor = cursorQuery;
                            if (cursor != null && cursor.moveToFirst() && AbstractC13042fc3.d(cursor.getString(cursor.getColumnIndex(strArr[0])), "image/gif")) {
                                InterfaceC9336Zm4 interfaceC9336Zm4 = chatViewModel.x1;
                                do {
                                    value2 = interfaceC9336Zm4.getValue();
                                } while (!interfaceC9336Zm4.f(value2, new K35.a(AbstractC12217eE5.your_single_group_send_sticker_permission_denied)));
                                C19938rB7 c19938rB7 = C19938rB7.a;
                                YV0.a(cursorQuery, null);
                                return c19938rB7;
                            }
                            C19938rB7 c19938rB72 = C19938rB7.a;
                            YV0.a(cursorQuery, null);
                        } finally {
                        }
                    }
                }
            }
            InterfaceC9336Zm4 interfaceC9336Zm42 = this.d.x1;
            ShareData shareData = this.c;
            do {
                value = interfaceC9336Zm42.getValue();
            } while (!interfaceC9336Zm42.f(value, new K35.b(shareData)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11188s) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$s0, reason: case insensitive filesystem */
    static final class C11189s0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.chat.ChatViewModel$s0$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ ChatViewModel d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ChatViewModel chatViewModel, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = chatViewModel;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object value;
                JQ0 jq0;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                C17448mz0 c17448mz0 = (C17448mz0) this.c;
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.g1;
                do {
                    value = interfaceC9336Zm4.getValue();
                    jq0 = (JQ0) value;
                } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : c17448mz0.e() != C17448mz0.a.o, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C17448mz0 c17448mz0, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c17448mz0, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        C11189s0(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new C11189s0(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C4627Fy0 unused = ChatViewModel.this.y;
                InterfaceC10258bL6 interfaceC10258bL6D = C18039nz0.a.d();
                a aVar = new a(ChatViewModel.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6D, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11189s0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* synthetic */ class s1 extends EB2 implements SA2 {
        s1(Object obj) {
            super(0, obj, ChatViewModel.class, "showSuccessSuggestMagazineSnackBarFirst", "showSuccessSuggestMagazineSnackBarFirst()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((ChatViewModel) this.receiver).qc();
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$t, reason: case insensitive filesystem */
    static final class C11190t extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        C11190t(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new C11190t(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            JQ0 jq0;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = ChatViewModel.this.x.getLong("LAST_TIME_DISPLAY_TOOLTIP_JOIN_CHANNEL", 0L);
            if (ChatViewModel.this.x.getInt("COUNT_DISPLAY_TOOLTIP_JOIN_CHANNEL", 0) < 3 && jCurrentTimeMillis - j > 86400000) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = ChatViewModel.this.g1;
                do {
                    value = interfaceC9336Zm4.getValue();
                    jq0 = (JQ0) value;
                } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : AbstractC6392Nk0.d(DD5.tooltip_title_join_channel), (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11190t) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$t0, reason: case insensitive filesystem */
    static final class C11191t0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.chat.ChatViewModel$t0$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ ChatViewModel c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ChatViewModel chatViewModel, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = chatViewModel;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                AbstractC18350oW3.a(obj);
                return n(null, (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object value;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.c.i1;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, InterfaceC4335Er5.d.a));
                return C19938rB7.a;
            }

            public final Object n(AbstractC23046wF7 abstractC23046wF7, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(abstractC23046wF7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.chat.ChatViewModel$t0$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;
            final /* synthetic */ ChatViewModel b;

            /* renamed from: ir.nasim.chat.ChatViewModel$t0$b$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;
                final /* synthetic */ ChatViewModel b;

                /* renamed from: ir.nasim.chat.ChatViewModel$t0$b$a$a, reason: collision with other inner class name */
                public static final class C0971a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0971a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2, ChatViewModel chatViewModel) {
                    this.a = interfaceC4806Gq2;
                    this.b = chatViewModel;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.chat.ChatViewModel.C11191t0.b.a.C0971a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.chat.ChatViewModel$t0$b$a$a r0 = (ir.nasim.chat.ChatViewModel.C11191t0.b.a.C0971a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.chat.ChatViewModel$t0$b$a$a r0 = new ir.nasim.chat.ChatViewModel$t0$b$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        ir.nasim.AbstractC13660gc3.e()
                        int r0 = r0.b
                        if (r0 == 0) goto L32
                        r5 = 1
                        if (r0 != r5) goto L2a
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    L2a:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L32:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.AbstractC18350oW3.a(r5)
                        r5 = 0
                        throw r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.C11191t0.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2, ChatViewModel chatViewModel) {
                this.a = interfaceC4557Fq2;
                this.b = chatViewModel;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.chat.ChatViewModel$t0$c */
        public static final class c implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.chat.ChatViewModel$t0$c$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.chat.ChatViewModel$t0$c$a$a, reason: collision with other inner class name */
                public static final class C0972a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0972a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r4, ir.nasim.InterfaceC20295rm1 r5) {
                    /*
                        r3 = this;
                        boolean r4 = r5 instanceof ir.nasim.chat.ChatViewModel.C11191t0.c.a.C0972a
                        if (r4 == 0) goto L13
                        r4 = r5
                        ir.nasim.chat.ChatViewModel$t0$c$a$a r4 = (ir.nasim.chat.ChatViewModel.C11191t0.c.a.C0972a) r4
                        int r0 = r4.b
                        r1 = -2147483648(0xffffffff80000000, float:-0.0)
                        r2 = r0 & r1
                        if (r2 == 0) goto L13
                        int r0 = r0 - r1
                        r4.b = r0
                        goto L18
                    L13:
                        ir.nasim.chat.ChatViewModel$t0$c$a$a r4 = new ir.nasim.chat.ChatViewModel$t0$c$a$a
                        r4.<init>(r5)
                    L18:
                        java.lang.Object r5 = r4.a
                        ir.nasim.AbstractC13660gc3.e()
                        int r4 = r4.b
                        if (r4 == 0) goto L30
                        r0 = 1
                        if (r4 != r0) goto L28
                        ir.nasim.AbstractC10685c16.b(r5)
                        goto L33
                    L28:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L30:
                        ir.nasim.AbstractC10685c16.b(r5)
                    L33:
                        ir.nasim.rB7 r4 = ir.nasim.C19938rB7.a
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.C11191t0.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public c(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        C11191t0(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new C11191t0(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                b bVar = new b(new c(ChatViewModel.this.B0.c()), ChatViewModel.this);
                a aVar = new a(ChatViewModel.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(bVar, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11191t0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class t1 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        t1(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new t1(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            JQ0 jq0;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = ChatViewModel.this.g1;
                do {
                    value = interfaceC9336Zm4.getValue();
                    jq0 = (JQ0) value;
                } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
                InterfaceC13727gj0 interfaceC13727gj0 = ChatViewModel.this.P0;
                int peerId = ChatViewModel.this.z1.getPeerId();
                this.b = 1;
                if (InterfaceC13727gj0.e(interfaceC13727gj0, peerId, null, null, this, 6, null) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ((C9475a16) obj).l();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((t1) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$u, reason: case insensitive filesystem */
    static final class C11192u extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        C11192u(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new C11192u(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            ChatViewModel.this.R0.z(ChatViewModel.this.z1, null, "");
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11192u) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$u0, reason: case insensitive filesystem */
    static final class C11193u0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.chat.ChatViewModel$u0$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ ChatViewModel c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ChatViewModel chatViewModel, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = chatViewModel;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object value;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.c.i1;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, InterfaceC4335Er5.d.a));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C13437gD7 c13437gD7, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c13437gD7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.chat.ChatViewModel$u0$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;
            final /* synthetic */ ChatViewModel b;

            /* renamed from: ir.nasim.chat.ChatViewModel$u0$b$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;
                final /* synthetic */ ChatViewModel b;

                /* renamed from: ir.nasim.chat.ChatViewModel$u0$b$a$a, reason: collision with other inner class name */
                public static final class C0973a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0973a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2, ChatViewModel chatViewModel) {
                    this.a = interfaceC4806Gq2;
                    this.b = chatViewModel;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof ir.nasim.chat.ChatViewModel.C11193u0.b.a.C0973a
                        if (r0 == 0) goto L13
                        r0 = r7
                        ir.nasim.chat.ChatViewModel$u0$b$a$a r0 = (ir.nasim.chat.ChatViewModel.C11193u0.b.a.C0973a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.chat.ChatViewModel$u0$b$a$a r0 = new ir.nasim.chat.ChatViewModel$u0$b$a$a
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r7)
                        goto L5a
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        ir.nasim.AbstractC10685c16.b(r7)
                        ir.nasim.Gq2 r7 = r5.a
                        r2 = r6
                        ir.nasim.gD7 r2 = (ir.nasim.C13437gD7) r2
                        java.util.List r2 = r2.b()
                        ir.nasim.chat.ChatViewModel r4 = r5.b
                        ir.nasim.d25 r4 = ir.nasim.chat.ChatViewModel.c3(r4)
                        int r4 = r4.getPeerId()
                        java.lang.Integer r4 = ir.nasim.AbstractC6392Nk0.d(r4)
                        boolean r2 = r2.contains(r4)
                        if (r2 == 0) goto L5a
                        r0.b = r3
                        java.lang.Object r6 = r7.a(r6, r0)
                        if (r6 != r1) goto L5a
                        return r1
                    L5a:
                        ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.C11193u0.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2, ChatViewModel chatViewModel) {
                this.a = interfaceC4557Fq2;
                this.b = chatViewModel;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.chat.ChatViewModel$u0$c */
        public static final class c implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.chat.ChatViewModel$u0$c$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.chat.ChatViewModel$u0$c$a$a, reason: collision with other inner class name */
                public static final class C0974a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0974a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.chat.ChatViewModel.C11193u0.c.a.C0974a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.chat.ChatViewModel$u0$c$a$a r0 = (ir.nasim.chat.ChatViewModel.C11193u0.c.a.C0974a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.chat.ChatViewModel$u0$c$a$a r0 = new ir.nasim.chat.ChatViewModel$u0$c$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L43
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        boolean r2 = r5 instanceof ir.nasim.C13437gD7
                        if (r2 == 0) goto L43
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L43
                        return r1
                    L43:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.C11193u0.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public c(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        C11193u0(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new C11193u0(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                b bVar = new b(new c(ChatViewModel.this.B0.c()), ChatViewModel.this);
                a aVar = new a(ChatViewModel.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(bVar, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11193u0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class u1 implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ ChatViewModel b;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ ChatViewModel b;

            /* renamed from: ir.nasim.chat.ChatViewModel$u1$a$a, reason: collision with other inner class name */
            public static final class C0975a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;
                Object c;
                Object e;
                int f;

                public C0975a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, ChatViewModel chatViewModel) {
                this.a = interfaceC4806Gq2;
                this.b = chatViewModel;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:52:0x0116 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
            /* JADX WARN: Type inference failed for: r7v0 */
            /* JADX WARN: Type inference failed for: r7v1 */
            /* JADX WARN: Type inference failed for: r7v10 */
            /* JADX WARN: Type inference failed for: r7v11 */
            /* JADX WARN: Type inference failed for: r7v7 */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r19, ir.nasim.InterfaceC20295rm1 r20) {
                /*
                    Method dump skipped, instructions count: 282
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.u1.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public u1(InterfaceC4557Fq2 interfaceC4557Fq2, ChatViewModel chatViewModel) {
            this.a = interfaceC4557Fq2;
            this.b = chatViewModel;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$v, reason: case insensitive filesystem */
    static final class C11194v extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.chat.ChatViewModel$v$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ ChatViewModel a;

            a(ChatViewModel chatViewModel) {
                this.a = chatViewModel;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(String str, InterfaceC20295rm1 interfaceC20295rm1) {
                Object value;
                JQ0 jq0;
                if (str == null || AbstractC20762sZ6.n0(str)) {
                    return C19938rB7.a;
                }
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.a.g1;
                do {
                    value = interfaceC9336Zm4.getValue();
                    jq0 = (JQ0) value;
                } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : new C6634Oi0(str, null, 2, null), (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
                return C19938rB7.a;
            }
        }

        C11194v(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new C11194v(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            C10410bZ6 c10410bZ6G;
            InterfaceC4557Fq2 interfaceC4557Fq2A;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C21231tK7 c21231tK7 = ChatViewModel.this.M1;
                if (c21231tK7 != null && (c10410bZ6G = c21231tK7.g()) != null && (interfaceC4557Fq2A = AbstractC23145wQ7.a(c10410bZ6G)) != null) {
                    a aVar = new a(ChatViewModel.this);
                    this.b = 1;
                    if (interfaceC4557Fq2A.b(aVar, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11194v) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$v0, reason: case insensitive filesystem */
    static final class C11195v0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.chat.ChatViewModel$v0$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ ChatViewModel a;

            /* renamed from: ir.nasim.chat.ChatViewModel$v0$a$a, reason: collision with other inner class name */
            static final class C0976a extends AbstractC22163um1 {
                Object a;
                /* synthetic */ Object b;
                int d;

                C0976a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.b = obj;
                    this.d |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            a(ChatViewModel chatViewModel) {
                this.a = chatViewModel;
            }

            /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(ir.nasim.C24069xz5 r28, ir.nasim.InterfaceC20295rm1 r29) {
                /*
                    Method dump skipped, instructions count: 408
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.C11195v0.a.a(ir.nasim.xz5, ir.nasim.rm1):java.lang.Object");
            }
        }

        /* renamed from: ir.nasim.chat.ChatViewModel$v0$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;
            final /* synthetic */ ChatViewModel b;

            /* renamed from: ir.nasim.chat.ChatViewModel$v0$b$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;
                final /* synthetic */ ChatViewModel b;

                /* renamed from: ir.nasim.chat.ChatViewModel$v0$b$a$a, reason: collision with other inner class name */
                public static final class C0977a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0977a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2, ChatViewModel chatViewModel) {
                    this.a = interfaceC4806Gq2;
                    this.b = chatViewModel;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof ir.nasim.chat.ChatViewModel.C11195v0.b.a.C0977a
                        if (r0 == 0) goto L13
                        r0 = r7
                        ir.nasim.chat.ChatViewModel$v0$b$a$a r0 = (ir.nasim.chat.ChatViewModel.C11195v0.b.a.C0977a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.chat.ChatViewModel$v0$b$a$a r0 = new ir.nasim.chat.ChatViewModel$v0$b$a$a
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r7)
                        goto L66
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        ir.nasim.AbstractC10685c16.b(r7)
                        ir.nasim.Gq2 r7 = r5.a
                        r2 = r6
                        ir.nasim.zg6 r2 = (ir.nasim.C25068zg6) r2
                        java.lang.String r4 = r2.f()
                        if (r4 == 0) goto L45
                        boolean r4 = ir.nasim.AbstractC14836iZ6.n0(r4)
                        if (r4 == 0) goto L5d
                    L45:
                        ir.nasim.chat.ChatViewModel r4 = r5.b
                        ir.nasim.d25 r4 = ir.nasim.chat.ChatViewModel.c3(r4)
                        boolean r4 = r4.z()
                        if (r4 == 0) goto L57
                        java.lang.Integer r4 = r2.n()
                        if (r4 != 0) goto L5d
                    L57:
                        java.lang.Long r2 = r2.m()
                        if (r2 == 0) goto L66
                    L5d:
                        r0.b = r3
                        java.lang.Object r6 = r7.a(r6, r0)
                        if (r6 != r1) goto L66
                        return r1
                    L66:
                        ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.C11195v0.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2, ChatViewModel chatViewModel) {
                this.a = interfaceC4557Fq2;
                this.b = chatViewModel;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.chat.ChatViewModel$v0$c */
        public static final class c implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.chat.ChatViewModel$v0$c$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.chat.ChatViewModel$v0$c$a$a, reason: collision with other inner class name */
                public static final class C0978a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0978a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r8, ir.nasim.InterfaceC20295rm1 r9) {
                    /*
                        r7 = this;
                        boolean r0 = r9 instanceof ir.nasim.chat.ChatViewModel.C11195v0.c.a.C0978a
                        if (r0 == 0) goto L13
                        r0 = r9
                        ir.nasim.chat.ChatViewModel$v0$c$a$a r0 = (ir.nasim.chat.ChatViewModel.C11195v0.c.a.C0978a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.chat.ChatViewModel$v0$c$a$a r0 = new ir.nasim.chat.ChatViewModel$v0$c$a$a
                        r0.<init>(r9)
                    L18:
                        java.lang.Object r9 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r9)
                        goto L5a
                    L29:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r9)
                        throw r8
                    L31:
                        ir.nasim.AbstractC10685c16.b(r9)
                        ir.nasim.Gq2 r9 = r7.a
                        ir.nasim.zg6 r8 = (ir.nasim.C25068zg6) r8
                        ir.nasim.xz5 r2 = new ir.nasim.xz5
                        long r4 = r8.c()
                        java.lang.Long r4 = ir.nasim.AbstractC6392Nk0.e(r4)
                        java.lang.String r5 = r8.f()
                        java.lang.Integer r6 = r8.n()
                        java.lang.Long r8 = r8.m()
                        r2.<init>(r4, r5, r6, r8)
                        r0.b = r3
                        java.lang.Object r8 = r9.a(r2, r0)
                        if (r8 != r1) goto L5a
                        return r1
                    L5a:
                        ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.C11195v0.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public c(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        C11195v0(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new C11195v0(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.v(new c(new b(ChatViewModel.this.e2, ChatViewModel.this)));
                a aVar = new a(ChatViewModel.this);
                this.b = 1;
                if (interfaceC4557Fq2V.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11195v0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class v1 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ long e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        v1(long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = j2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new v1(this.d, this.e, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0063  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r25) {
            /*
                r24 = this;
                r0 = r24
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.b
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L24
                if (r2 == r4) goto L1e
                if (r2 != r3) goto L16
                ir.nasim.AbstractC10685c16.b(r25)
                r2 = r25
                goto L59
            L16:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L1e:
                ir.nasim.AbstractC10685c16.b(r25)
                r2 = r25
                goto L38
            L24:
                ir.nasim.AbstractC10685c16.b(r25)
                ir.nasim.chat.ChatViewModel r2 = ir.nasim.chat.ChatViewModel.this
                ir.nasim.Ch5 r2 = ir.nasim.chat.ChatViewModel.d3(r2)
                long r5 = r0.d
                r0.b = r4
                java.lang.Object r2 = r2.c(r5, r0)
                if (r2 != r1) goto L38
                return r1
            L38:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                boolean r2 = r2.booleanValue()
                if (r2 == 0) goto L6b
                ir.nasim.chat.ChatViewModel r2 = ir.nasim.chat.ChatViewModel.this
                ir.nasim.Ch5 r2 = ir.nasim.chat.ChatViewModel.d3(r2)
                long r4 = r0.d
                java.lang.Long r4 = ir.nasim.AbstractC6392Nk0.e(r4)
                java.util.List r4 = ir.nasim.ZW0.e(r4)
                r0.b = r3
                java.lang.Object r2 = r2.f(r4, r0)
                if (r2 != r1) goto L59
                return r1
            L59:
                java.util.List r2 = (java.util.List) r2
                java.lang.Object r1 = ir.nasim.ZW0.s0(r2)
                ir.nasim.m18 r1 = (ir.nasim.C16885m18) r1
                if (r1 == 0) goto La8
                ir.nasim.chat.ChatViewModel r2 = ir.nasim.chat.ChatViewModel.this
                long r3 = r0.e
                r2.G5(r1, r3)
                goto La8
            L6b:
                ir.nasim.chat.ChatViewModel r1 = ir.nasim.chat.ChatViewModel.this
                ir.nasim.Zm4 r1 = ir.nasim.chat.ChatViewModel.N3(r1)
            L71:
                java.lang.Object r2 = r1.getValue()
                r3 = r2
                ir.nasim.JQ0 r3 = (ir.nasim.JQ0) r3
                int r4 = ir.nasim.DD5.error_unknown
                java.lang.Integer r4 = ir.nasim.AbstractC6392Nk0.d(r4)
                r5 = 0
                ir.nasim.XV4 r4 = ir.nasim.AbstractC4616Fw7.a(r5, r4)
                r22 = 262142(0x3fffe, float:3.67339E-40)
                r23 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r15 = 0
                r16 = 0
                r17 = 0
                r18 = 0
                r19 = 0
                r20 = 0
                r21 = 0
                ir.nasim.JQ0 r3 = ir.nasim.JQ0.b(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
                boolean r2 = r1.f(r2, r3)
                if (r2 == 0) goto L71
            La8:
                ir.nasim.rB7 r1 = ir.nasim.C19938rB7.a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.v1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((v1) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$w, reason: case insensitive filesystem */
    static final class C11196w extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.chat.ChatViewModel$w$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return ((C5902Li0) this.c).b();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C5902Li0 c5902Li0, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c5902Li0, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.chat.ChatViewModel$w$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ ChatViewModel d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(ChatViewModel chatViewModel, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = chatViewModel;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, interfaceC20295rm1);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C6374Ni0 c6374Ni0 = (C6374Ni0) this.c;
                    if (c6374Ni0 != null && !c6374Ni0.c()) {
                        InterfaceC13730gj3 interfaceC13730gj3 = this.d.G2;
                        if (interfaceC13730gj3 != null) {
                            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
                        }
                        ChatViewModel chatViewModel = this.d;
                        this.b = 1;
                        if (chatViewModel.Ib(c6374Ni0, this) == objE) {
                            return objE;
                        }
                    } else if (C8386Vt0.J4()) {
                        this.d.Z4();
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C6374Ni0 c6374Ni0, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(c6374Ni0, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        C11196w(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new C11196w(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            C19482qQ7 c19482qQ7J;
            InterfaceC4557Fq2 interfaceC4557Fq2A;
            InterfaceC4557Fq2 interfaceC4557Fq2X;
            InterfaceC4557Fq2 interfaceC4557Fq2V;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C21231tK7 c21231tK7 = ChatViewModel.this.M1;
                if (c21231tK7 != null && (c19482qQ7J = c21231tK7.j()) != null && (interfaceC4557Fq2A = AbstractC23145wQ7.a(c19482qQ7J)) != null && (interfaceC4557Fq2X = AbstractC6459Nq2.X(interfaceC4557Fq2A, new a(null))) != null && (interfaceC4557Fq2V = AbstractC6459Nq2.v(interfaceC4557Fq2X)) != null) {
                    b bVar = new b(ChatViewModel.this, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2V, bVar, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11196w) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$w0, reason: case insensitive filesystem */
    static final class C11197w0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        C11197w0(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new C11197w0(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            ChatViewModel.this.x.putInt("selected_smiles_tab_key", ((FF6) ChatViewModel.this.D2.getValue()).c().ordinal());
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11197w0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class w1 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        boolean d;
        int e;
        final /* synthetic */ int g;
        final /* synthetic */ String h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        w1(int i, String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.g = i;
            this.h = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new w1(this.g, this.h, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x00c8  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00d8  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x010b  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r29) {
            /*
                Method dump skipped, instructions count: 332
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.w1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((w1) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$x, reason: case insensitive filesystem */
    static final class C11198x extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.chat.ChatViewModel$x$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ ChatViewModel d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ChatViewModel chatViewModel, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = chatViewModel;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                C21159tC7 c21159tC7 = (C21159tC7) this.c;
                C22132uj0 c22132uj0 = new C22132uj0(c21159tC7.c(), c21159tC7.b());
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.g1;
                while (true) {
                    Object value = interfaceC9336Zm4.getValue();
                    JQ0 jq0 = (JQ0) value;
                    C22132uj0 c22132uj02 = c22132uj0;
                    if (interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : c22132uj02, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null))) {
                        return C19938rB7.a;
                    }
                    c22132uj0 = c22132uj02;
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C21159tC7 c21159tC7, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c21159tC7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.chat.ChatViewModel$x$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;
            final /* synthetic */ ChatViewModel b;

            /* renamed from: ir.nasim.chat.ChatViewModel$x$b$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;
                final /* synthetic */ ChatViewModel b;

                /* renamed from: ir.nasim.chat.ChatViewModel$x$b$a$a, reason: collision with other inner class name */
                public static final class C0979a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0979a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2, ChatViewModel chatViewModel) {
                    this.a = interfaceC4806Gq2;
                    this.b = chatViewModel;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof ir.nasim.chat.ChatViewModel.C11198x.b.a.C0979a
                        if (r0 == 0) goto L13
                        r0 = r7
                        ir.nasim.chat.ChatViewModel$x$b$a$a r0 = (ir.nasim.chat.ChatViewModel.C11198x.b.a.C0979a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.chat.ChatViewModel$x$b$a$a r0 = new ir.nasim.chat.ChatViewModel$x$b$a$a
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r7)
                        goto L52
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        ir.nasim.AbstractC10685c16.b(r7)
                        ir.nasim.Gq2 r7 = r5.a
                        r2 = r6
                        ir.nasim.tC7 r2 = (ir.nasim.C21159tC7) r2
                        int r2 = r2.a()
                        ir.nasim.chat.ChatViewModel r4 = r5.b
                        ir.nasim.d25 r4 = ir.nasim.chat.ChatViewModel.c3(r4)
                        int r4 = r4.getPeerId()
                        if (r2 != r4) goto L52
                        r0.b = r3
                        java.lang.Object r6 = r7.a(r6, r0)
                        if (r6 != r1) goto L52
                        return r1
                    L52:
                        ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.C11198x.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2, ChatViewModel chatViewModel) {
                this.a = interfaceC4557Fq2;
                this.b = chatViewModel;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.chat.ChatViewModel$x$c */
        public static final class c implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.chat.ChatViewModel$x$c$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.chat.ChatViewModel$x$c$a$a, reason: collision with other inner class name */
                public static final class C0980a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0980a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.chat.ChatViewModel.C11198x.c.a.C0980a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.chat.ChatViewModel$x$c$a$a r0 = (ir.nasim.chat.ChatViewModel.C11198x.c.a.C0980a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.chat.ChatViewModel$x$c$a$a r0 = new ir.nasim.chat.ChatViewModel$x$c$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L43
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        boolean r2 = r5 instanceof ir.nasim.C21159tC7
                        if (r2 == 0) goto L43
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L43
                        return r1
                    L43:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.C11198x.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public c(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        C11198x(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new C11198x(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                b bVar = new b(new c(ChatViewModel.this.B0.c()), ChatViewModel.this);
                a aVar = new a(ChatViewModel.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(bVar, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11198x) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$x0, reason: case insensitive filesystem */
    static final class C11199x0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        C11199x0(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new C11199x0(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                F84 f84 = ChatViewModel.this.m;
                this.b = 1;
                if (f84.q(this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11199x0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class x1 extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        x1(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objWc = ChatViewModel.this.wc(null, false, this);
            return objWc == AbstractC14862ic3.e() ? objWc : C9475a16.a(objWc);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$y, reason: case insensitive filesystem */
    static final class C11200y extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.chat.ChatViewModel$y$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ ChatViewModel a;

            a(ChatViewModel chatViewModel) {
                this.a = chatViewModel;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(C19951rD2 c19951rD2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object value;
                JQ0 jq0;
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.a.g1;
                do {
                    value = interfaceC9336Zm4.getValue();
                    jq0 = (JQ0) value;
                } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : c19951rD2, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
                return C19938rB7.a;
            }
        }

        C11200y(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new C11200y(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2A = ChatViewModel.this.s.a(ChatViewModel.this.d6());
                a aVar = new a(ChatViewModel.this);
                this.b = 1;
                if (interfaceC4557Fq2A.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11200y) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$y0, reason: case insensitive filesystem */
    static final class C11201y0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        C11201y0(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new C11201y0(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            ChatViewModel.this.v.s0(ChatViewModel.this.z1);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11201y0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class y1 extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        y1(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objXc = ChatViewModel.this.xc(0, this);
            return objXc == AbstractC14862ic3.e() ? objXc : C9475a16.a(objXc);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$z, reason: case insensitive filesystem */
    static final class C11202z extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.chat.ChatViewModel$z$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ ChatViewModel d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ChatViewModel chatViewModel, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = chatViewModel;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((C9475a16) obj).l(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    Object objL = ((C9475a16) this.c).l();
                    if (C9475a16.g(objL)) {
                        objL = null;
                    }
                    List listD = (List) objL;
                    if (listD == null) {
                        listD = PG5.a.d();
                    }
                    List listD2 = PG5.a.d();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : listD2) {
                        if (listD.contains((String) obj2)) {
                            arrayList.add(obj2);
                        }
                    }
                    InterfaceC9336Zm4 interfaceC9336Zm4K7 = this.d.K7();
                    this.b = 1;
                    if (interfaceC9336Zm4K7.a(arrayList, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            public final Object n(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(C9475a16.a(obj), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        C11202z(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ChatViewModel.this.new C11202z(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2E = ChatViewModel.this.j.e(ChatViewModel.this.z1);
                a aVar = new a(ChatViewModel.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2E, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11202z) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.chat.ChatViewModel$z0, reason: case insensitive filesystem */
    static final class C11203z0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ C8967Xz7 d;
        final /* synthetic */ ChatViewModel e;
        final /* synthetic */ EnumC9477a18 f;
        final /* synthetic */ String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11203z0(C8967Xz7 c8967Xz7, ChatViewModel chatViewModel, EnumC9477a18 enumC9477a18, String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c8967Xz7;
            this.e = chatViewModel;
            this.f = enumC9477a18;
            this.g = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            C11203z0 c11203z0 = new C11203z0(this.d, this.e, this.f, this.g, interfaceC20295rm1);
            c11203z0.c = obj;
            return c11203z0;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            AbstractC17457n0 abstractC17457n0F = this.d.j().F();
            J08 j08 = abstractC17457n0F instanceof J08 ? (J08) abstractC17457n0F : null;
            if (j08 == null) {
                return C19938rB7.a;
            }
            ChatViewModel chatViewModel = this.e;
            J44 j44J = this.d.j();
            J08.a aVar = J08.l;
            VoiceTranscript voiceTranscriptJ = j08.J();
            EnumC9477a18 enumC9477a18 = this.f;
            String voiceTranscript = this.g;
            if (voiceTranscript == null) {
                voiceTranscript = j08.J().getVoiceTranscript();
            }
            chatViewModel.Kc(J44.D(j44J, 0L, 0L, 0L, 0, null, aVar.a(j08, VoiceTranscript.c(voiceTranscriptJ, enumC9477a18, voiceTranscript, false, 4, null)), null, 0, null, null, 0L, null, null, false, null, false, null, null, 262111, null));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11203z0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class z1 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ J44 e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ UA2 g;
        final /* synthetic */ UA2 h;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ ChatViewModel c;
            final /* synthetic */ J44 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ChatViewModel chatViewModel, J44 j44, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = chatViewModel;
                this.d = j44;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    ChatViewModel chatViewModel = this.c;
                    J44 j44 = this.d;
                    this.b = 1;
                    if (chatViewModel.D5(j44, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public /* synthetic */ class b {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[RQ.values().length];
                try {
                    iArr[RQ.a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RQ.b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[RQ.c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        z1(J44 j44, SA2 sa2, UA2 ua2, UA2 ua22, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = j44;
            this.f = sa2;
            this.g = ua2;
            this.h = ua22;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(ChatViewModel chatViewModel, J44 j44, boolean z) {
            if (z) {
                AbstractC10533bm0.d(AbstractC9773aX7.a(chatViewModel), null, null, new a(chatViewModel, j44, null), 3, null);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            z1 z1Var = ChatViewModel.this.new z1(this.e, this.f, this.g, this.h, interfaceC20295rm1);
            z1Var.c = obj;
            return z1Var;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0081  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00c2  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r26) {
            /*
                Method dump skipped, instructions count: 261
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.z1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((z1) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public ChatViewModel(final androidx.lifecycle.y yVar, AbstractC13778go1 abstractC13778go1, C23094wL1 c23094wL1, SettingsModule settingsModule, VE4 ve4, C10299bQ2 c10299bQ2, OK7 ok7, C8054Ui1 c8054Ui1, C14970in2 c14970in2, KM2 km2, StoryRepository storyRepository, InterfaceC11621dJ7 interfaceC11621dJ7, F84 f84, C16450lI2 c16450lI2, InterfaceC21103t7 interfaceC21103t7, InterfaceC17527n7 interfaceC17527n7, V9 v9, IN5 in5, WF2 wf2, C21191tG3.b bVar, final WF3.b bVar2, C14652iG2 c14652iG2, C24314yP5 c24314yP5, E84 e84, C6409Nm c6409Nm, InterfaceC3570Bk5 interfaceC3570Bk5, C4627Fy0 c4627Fy0, C16220ku1 c16220ku1, InterfaceC20642sM3 interfaceC20642sM3, UG7 ug7, C6559Oa2 c6559Oa2, int i, BankingModule bankingModule, C11461d28 c11461d28, C4892Gz7 c4892Gz7, C14375ho5 c14375ho5, InterfaceC3570Bk5 interfaceC3570Bk52, FP5 fp5, FD7 fd7, C17626nH5.a aVar, C25108zk6.a aVar2, C20800sd5.a aVar3, InterfaceC19567qa2 interfaceC19567qa2, EP5 ep5, C18837pK7 c18837pK7, JF3 jf3, final InterfaceC10210bG3 interfaceC10210bG3, C23631xF2 c23631xF2, C4744Gj3 c4744Gj3, C21376tZ0 c21376tZ0, C24474yg6 c24474yg6, C18804pH1 c18804pH1, C19711qo6 c19711qo6, NR nr, InterfaceC13727gj0 interfaceC13727gj0, LD3 ld3, ZF3 zf3, InterfaceC20667sP1 interfaceC20667sP1, InterfaceC6334Nd5 interfaceC6334Nd5, C18787pF2 c18787pF2, QF2 qf2, InterfaceC12532em2 interfaceC12532em2, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC3570Bk5 interfaceC3570Bk53, C3777Ch5 c3777Ch5, InterfaceC7486Rx5 interfaceC7486Rx5, InterfaceC5943Lm5 interfaceC5943Lm5) {
        AbstractC13042fc3.i(yVar, "savedStateHandle");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(c23094wL1, "dialogAdStateManager");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(ve4, "notificationsModule");
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        AbstractC13042fc3.i(ok7, "usersModule");
        AbstractC13042fc3.i(c8054Ui1, "contactsModule");
        AbstractC13042fc3.i(c14970in2, "filesModule");
        AbstractC13042fc3.i(km2, "groupsRepository");
        AbstractC13042fc3.i(storyRepository, "storyRepository");
        AbstractC13042fc3.i(interfaceC11621dJ7, "usersRepository");
        AbstractC13042fc3.i(f84, "messagesRepository");
        AbstractC13042fc3.i(c16450lI2, "gifsRepository");
        AbstractC13042fc3.i(interfaceC21103t7, "adRepository");
        AbstractC13042fc3.i(interfaceC17527n7, "adEventRepository");
        AbstractC13042fc3.i(v9, "addReactionUseCase");
        AbstractC13042fc3.i(in5, "removeReactionUseCase");
        AbstractC13042fc3.i(wf2, "getGalleryResultUseCase");
        AbstractC13042fc3.i(bVar, "loadViewsUseCaseFactory");
        AbstractC13042fc3.i(bVar2, "loadLiveStreamDataUseCaseFactory");
        AbstractC13042fc3.i(c14652iG2, "getMainWebAppUseCase");
        AbstractC13042fc3.i(c24314yP5, "reportMessagesUseCase");
        AbstractC13042fc3.i(e84, "messagesModule");
        AbstractC13042fc3.i(c6409Nm, "analyticsRepository");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferencesStorage");
        AbstractC13042fc3.i(c4627Fy0, "callRepository");
        AbstractC13042fc3.i(c16220ku1, "createVideoFileFromExoCacheUseCase");
        AbstractC13042fc3.i(interfaceC20642sM3, "magazineRepository");
        AbstractC13042fc3.i(ug7, "updatesModule");
        AbstractC13042fc3.i(c6559Oa2, "eventBus");
        AbstractC13042fc3.i(bankingModule, "bankingModule");
        AbstractC13042fc3.i(c11461d28, "walletModule");
        AbstractC13042fc3.i(c4892Gz7, "typingModule");
        AbstractC13042fc3.i(c14375ho5, "presenceModule");
        AbstractC13042fc3.i(interfaceC3570Bk52, "preferences");
        AbstractC13042fc3.i(fp5, "reportRepository");
        AbstractC13042fc3.i(fd7, "updateGateway");
        AbstractC13042fc3.i(aVar, "reactionListDataLoaderFactory");
        AbstractC13042fc3.i(aVar2, "seenListDataLoaderFactory");
        AbstractC13042fc3.i(aVar3, "pinMessageDataLoaderFactory");
        AbstractC13042fc3.i(interfaceC19567qa2, "serajAnalytics");
        AbstractC13042fc3.i(ep5, "reportPeerUseCase");
        AbstractC13042fc3.i(c18837pK7, "userInviteMapper");
        AbstractC13042fc3.i(jf3, "loadAndApplyRepliesInfo");
        AbstractC13042fc3.i(interfaceC10210bG3, "loadPollResultUseCase");
        AbstractC13042fc3.i(c23631xF2, "getCallLinkDetailsUseCase");
        AbstractC13042fc3.i(c4744Gj3, "joinCallFromLinkUseCase");
        AbstractC13042fc3.i(c21376tZ0, "commentDataStore");
        AbstractC13042fc3.i(c24474yg6, "searchMessageRepository");
        AbstractC13042fc3.i(c18804pH1, "deleteAndLeaveGroupUseCase");
        AbstractC13042fc3.i(c19711qo6, "sendContactUseCase");
        AbstractC13042fc3.i(nr, "authenticatorRepository");
        AbstractC13042fc3.i(interfaceC13727gj0, "botRepository");
        AbstractC13042fc3.i(ld3, "liveStreamRepository");
        AbstractC13042fc3.i(zf3, "loadPinnedLiveUseCase");
        AbstractC13042fc3.i(interfaceC20667sP1, "dialogRepository");
        AbstractC13042fc3.i(interfaceC6334Nd5, "pinMessagesRepository");
        AbstractC13042fc3.i(c18787pF2, "getAudioBarStateUseCase");
        AbstractC13042fc3.i(qf2, "getDownloadedFileStateUsecase");
        AbstractC13042fc3.i(interfaceC12532em2, "fileRepository");
        AbstractC13042fc3.i(interfaceC20315ro1, "applicationScope");
        AbstractC13042fc3.i(interfaceC3570Bk53, "androidProperties");
        AbstractC13042fc3.i(c3777Ch5, "pollRepository");
        AbstractC13042fc3.i(interfaceC7486Rx5, "messageToUserAvatarMapperProvider");
        AbstractC13042fc3.i(interfaceC5943Lm5, "premiumRepository");
        this.b = abstractC13778go1;
        this.c = c23094wL1;
        this.d = settingsModule;
        this.e = ve4;
        this.f = c10299bQ2;
        this.g = ok7;
        this.h = c8054Ui1;
        this.i = c14970in2;
        this.j = km2;
        this.k = storyRepository;
        this.l = interfaceC11621dJ7;
        this.m = f84;
        this.n = c16450lI2;
        this.o = interfaceC21103t7;
        this.p = interfaceC17527n7;
        this.q = v9;
        this.r = in5;
        this.s = wf2;
        this.t = c14652iG2;
        this.u = c24314yP5;
        this.v = e84;
        this.w = c6409Nm;
        this.x = interfaceC3570Bk5;
        this.y = c4627Fy0;
        this.z = c16220ku1;
        this.A = interfaceC20642sM3;
        this.B = ug7;
        this.D = c6559Oa2;
        this.G = i;
        this.H = bankingModule;
        this.J = c11461d28;
        this.Y = c4892Gz7;
        this.Z = c14375ho5;
        this.z0 = interfaceC3570Bk52;
        this.A0 = fp5;
        this.B0 = fd7;
        this.C0 = aVar;
        this.D0 = aVar2;
        this.E0 = aVar3;
        this.F0 = interfaceC19567qa2;
        this.G0 = ep5;
        this.H0 = c18837pK7;
        this.I0 = c23631xF2;
        this.J0 = c4744Gj3;
        this.K0 = c21376tZ0;
        this.L0 = c24474yg6;
        this.M0 = c18804pH1;
        this.N0 = c19711qo6;
        this.O0 = nr;
        this.P0 = interfaceC13727gj0;
        this.Q0 = zf3;
        this.R0 = interfaceC20667sP1;
        this.S0 = interfaceC6334Nd5;
        this.T0 = qf2;
        this.U0 = interfaceC12532em2;
        this.V0 = interfaceC20315ro1;
        this.W0 = interfaceC3570Bk53;
        this.X0 = c3777Ch5;
        this.Y0 = interfaceC7486Rx5;
        this.Z0 = interfaceC5943Lm5;
        this.b1 = "";
        this.d1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.VQ0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return ChatViewModel.q9(this.a, interfaceC10210bG3);
            }
        });
        this.e1 = jf3.a(AbstractC9773aX7.a(this));
        this.f1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.UR0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return ChatViewModel.R4(this.a);
            }
        });
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new JQ0(null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null));
        this.g1 = interfaceC9336Zm4A;
        this.h1 = AbstractC6459Nq2.c(interfaceC9336Zm4A);
        InterfaceC9336Zm4 interfaceC9336Zm4A2 = AbstractC12281eL6.a(InterfaceC4335Er5.d.a);
        this.i1 = interfaceC9336Zm4A2;
        this.j1 = AbstractC6459Nq2.c(interfaceC9336Zm4A2);
        InterfaceC9336Zm4 interfaceC9336Zm4A3 = AbstractC12281eL6.a(IM5.b.a);
        this.k1 = interfaceC9336Zm4A3;
        this.l1 = interfaceC9336Zm4A3;
        InterfaceC4557Fq2 interfaceC4557Fq2G = c18787pF2.g();
        InterfaceC20315ro1 interfaceC20315ro1A = AbstractC9773aX7.a(this);
        InterfaceC16863lz6.a aVar4 = InterfaceC16863lz6.a;
        this.m1 = AbstractC6459Nq2.o0(interfaceC4557Fq2G, interfaceC20315ro1A, aVar4.c(), new C17092mO(null, null, 3, null));
        this.n1 = AbstractC12281eL6.a(null);
        this.q1 = bVar.a(AbstractC9773aX7.a(this));
        this.r1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.VR0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return ChatViewModel.m9(bVar2, this);
            }
        });
        this.s1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.LQ0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return ChatViewModel.fc(yVar);
            }
        });
        this.t1 = (List) yVar.c("EXTRA_SHARED_CONTENTS");
        this.u1 = HQ0.b;
        InterfaceC9336Zm4 interfaceC9336Zm4A4 = AbstractC12281eL6.a(null);
        this.x1 = interfaceC9336Zm4A4;
        this.y1 = AbstractC6459Nq2.F(interfaceC9336Zm4A4);
        Long l = (Long) yVar.c("ARGUMENT_KEY_PEER_ID");
        C11458d25 c11458d25R = C11458d25.r(l != null ? l.longValue() : 0L);
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        this.z1 = c11458d25R;
        Object objC = yVar.c("ARGUMENT_KEY_EX_PEER_TYPE");
        AbstractC13042fc3.f(objC);
        ExPeerType exPeerTypeFromValue = ExPeerType.fromValue(((Number) objC).intValue());
        AbstractC13042fc3.h(exPeerTypeFromValue, "fromValue(...)");
        this.A1 = exPeerTypeFromValue;
        Long l2 = (Long) yVar.c("ARGUMENT_KEY_INTENDED_PEER_ID");
        this.B1 = l2 != null ? C11458d25.r(l2.longValue()) : null;
        this.C1 = (Boolean) yVar.c("ARGUMENT_KEY_JOIN_VIA_LINK");
        this.D1 = "Chat(" + c11458d25R.s().name() + ", " + c11458d25R.getPeerId() + ")_ViewModel(" + this + Separators.RPAREN;
        this.E1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.MQ0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return ChatViewModel.y8(yVar);
            }
        });
        this.F1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.NQ0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return ChatViewModel.z8(yVar);
            }
        });
        this.G1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.OQ0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return ChatViewModel.I4(yVar);
            }
        });
        Boolean bool = (Boolean) yVar.c("ADD_MEMBER_BUTTON");
        this.H1 = bool != null ? bool.booleanValue() : false;
        this.I1 = AbstractC17026mG5.a.g(Integer.MAX_VALUE);
        this.J1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.PQ0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Long.valueOf(ChatViewModel.u4(this.a));
            }
        });
        this.K1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.QQ0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return ChatViewModel.v4(this.a);
            }
        });
        this.O1 = new C20919sp4();
        this.Q1 = Long.MAX_VALUE;
        this.R1 = -1L;
        this.U1 = -1;
        this.V1 = -1L;
        this.W1 = -1L;
        this.X1 = -1L;
        this.Y1 = AbstractC12281eL6.a(0);
        InterfaceC9336Zm4 interfaceC9336Zm4A5 = AbstractC12281eL6.a(AbstractC10360bX0.m());
        this.Z1 = interfaceC9336Zm4A5;
        this.a2 = AbstractC6459Nq2.c(interfaceC9336Zm4A5);
        InterfaceC9336Zm4 interfaceC9336Zm4A6 = AbstractC12281eL6.a(0L);
        this.b2 = interfaceC9336Zm4A6;
        this.c2 = AbstractC6459Nq2.c(interfaceC9336Zm4A6);
        EnumC16752lo2 enumC16752lo2 = exPeerTypeFromValue == ExPeerType.GROUP ? EnumC16752lo2.b : EnumC16752lo2.a;
        this.d2 = enumC16752lo2;
        InterfaceC9336Zm4 interfaceC9336Zm4A7 = AbstractC12281eL6.a(new C25068zg6(0L, null, null, enumC16752lo2, null, null, null, 0, null, 0, 0, null, false, 8183, null));
        this.e2 = interfaceC9336Zm4A7;
        this.f2 = AbstractC6459Nq2.c(interfaceC9336Zm4A7);
        this.g2 = AbstractC6459Nq2.o0(new u1(interfaceC9336Zm4A7, this), AbstractC9773aX7.a(this), InterfaceC16863lz6.a.b(aVar4, 0L, 0L, 3, null), null);
        z9();
        this.h2 = new LinkedHashMap();
        this.i2 = AbstractC12281eL6.a(NT4.e.a());
        ArrayList arrayList = new ArrayList(3);
        for (int i2 = 0; i2 < 3; i2++) {
            arrayList.add(null);
        }
        InterfaceC9336Zm4 interfaceC9336Zm4A8 = AbstractC12281eL6.a(arrayList);
        this.j2 = interfaceC9336Zm4A8;
        this.k2 = AbstractC6459Nq2.c(interfaceC9336Zm4A8);
        InterfaceC9336Zm4 interfaceC9336Zm4A9 = AbstractC12281eL6.a(AbstractC10360bX0.m());
        this.l2 = interfaceC9336Zm4A9;
        this.m2 = AbstractC6459Nq2.c(interfaceC9336Zm4A9);
        if (this.z1.C() && C8386Vt0.r9()) {
            AbstractC6459Nq2.W(AbstractC6459Nq2.V(AbstractC6459Nq2.b0(this.S0.e(this.z1, this.A1.getValue()), new C11146a(null)), C12366eV1.c()), AbstractC9773aX7.a(this));
        }
        this.n2 = AbstractC6459Nq2.o0(AbstractC6459Nq2.X(AbstractC6459Nq2.v(AbstractC6459Nq2.X(ld3.m(), new E0(null))), new F0(null)), AbstractC9773aX7.a(this), InterfaceC16863lz6.a.c(), null);
        this.o2 = AbstractC12281eL6.a(NT4.e.a());
        this.q2 = -1L;
        this.w2 = new C10054b01(new Runnable() { // from class: ir.nasim.RQ0
            @Override // java.lang.Runnable
            public final void run() {
                ChatViewModel.aa(this.a);
            }
        });
        this.z2 = new C21167tD6();
        this.A2 = new C21167tD6();
        this.B2 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.gR0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return ChatViewModel.f2();
            }
        });
        InterfaceC9336Zm4 interfaceC9336Zm4A10 = AbstractC12281eL6.a(new FF6(QF6.b, false));
        this.D2 = interfaceC9336Zm4A10;
        this.E2 = AbstractC6459Nq2.c(interfaceC9336Zm4A10);
        this.F2 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.rR0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return ChatViewModel.Jc(this.a);
            }
        });
        D8();
        w8().s(new UA2() { // from class: ir.nasim.CR0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ChatViewModel.h2(this.a, (Throwable) obj);
            }
        });
        f5();
        W4();
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.b, null, new C11149b(null), 2, null);
        w9();
        e5();
        x9();
        this.H2 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.NR0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return ChatViewModel.zc(this.a);
            }
        });
        this.I2 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.SR0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return ChatViewModel.Bc(this.a);
            }
        });
        this.J2 = new G0(this);
        this.K2 = new C11180o(this);
        this.L2 = new C11162f0(this);
        InterfaceC9336Zm4 interfaceC9336Zm4A11 = AbstractC12281eL6.a(null);
        this.M2 = interfaceC9336Zm4A11;
        this.N2 = interfaceC9336Zm4A11;
        this.P2 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.TR0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return ChatViewModel.Qc(this.a);
            }
        });
        this.Q2 = new HashSet();
    }

    private final void A4() {
        C19406qI3.a("NewChatPrivacyBar", "Start observing privacy bar mode for GROUP", new Object[0]);
        final C14733iO2 c14733iO2 = this.L1;
        if (c14733iO2 == null || this.O1.y(c14733iO2.D(), c14733iO2.t(), new InterfaceC16527lQ7() { // from class: ir.nasim.FR0
            @Override // ir.nasim.InterfaceC16527lQ7
            public final void a(Object obj, AbstractC13554gQ7 abstractC13554gQ7, Object obj2, AbstractC13554gQ7 abstractC13554gQ72) {
                ChatViewModel.B4(c14733iO2, this, (EnumC3633Br5) obj, abstractC13554gQ7, (HashSet) obj2, abstractC13554gQ72);
            }
        }) == null) {
            C19406qI3.j("NewChatPrivacyBar", "GroupVM is null, can't observe privacy bar mode", new Object[0]);
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long Ac(List list) {
        AbstractC13042fc3.f(list);
        Iterator it = list.iterator();
        long jH = 0;
        while (it.hasNext()) {
            jH += ((Q64) it.next()).h();
        }
        return jH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B4(C14733iO2 c14733iO2, ChatViewModel chatViewModel, EnumC3633Br5 enumC3633Br5, AbstractC13554gQ7 abstractC13554gQ7, HashSet hashSet, AbstractC13554gQ7 abstractC13554gQ72) {
        AbstractC13042fc3.i(c14733iO2, "$vm");
        AbstractC13042fc3.i(chatViewModel, "this$0");
        C19406qI3.a("NewChatPrivacyBar", c14733iO2.q().name() + "_CHAT has been opened with that privacyBarMode is " + enumC3633Br5, new Object[0]);
        AbstractC10533bm0.d(AbstractC9773aX7.a(chatViewModel), null, null, new C11172k(enumC3633Br5, chatViewModel, hashSet, c14733iO2, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00aa A[PHI: r15
      0x00aa: PHI (r15v10 java.lang.Object) = (r15v9 java.lang.Object), (r15v1 java.lang.Object) binds: [B:30:0x00a7, B:13:0x002b] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object B5(ir.nasim.core.modules.file.entity.FileReference r14, ir.nasim.InterfaceC20295rm1 r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof ir.nasim.chat.ChatViewModel.L
            if (r0 == 0) goto L13
            r0 = r15
            ir.nasim.chat.ChatViewModel$L r0 = (ir.nasim.chat.ChatViewModel.L) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.chat.ChatViewModel$L r0 = new ir.nasim.chat.ChatViewModel$L
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.c
            java.lang.Object r10 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r0.e
            r11 = 3
            r12 = 2
            r2 = 1
            if (r1 == 0) goto L51
            if (r1 == r2) goto L44
            if (r1 == r12) goto L38
            if (r1 != r11) goto L30
            ir.nasim.AbstractC10685c16.b(r15)
            goto Laa
        L30:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L38:
            java.lang.Object r14 = r0.b
            ir.nasim.core.modules.file.entity.FileReference r14 = (ir.nasim.core.modules.file.entity.FileReference) r14
            java.lang.Object r1 = r0.a
            ir.nasim.chat.ChatViewModel r1 = (ir.nasim.chat.ChatViewModel) r1
            ir.nasim.AbstractC10685c16.b(r15)
            goto L90
        L44:
            java.lang.Object r14 = r0.b
            ir.nasim.core.modules.file.entity.FileReference r14 = (ir.nasim.core.modules.file.entity.FileReference) r14
            java.lang.Object r1 = r0.a
            ir.nasim.chat.ChatViewModel r1 = (ir.nasim.chat.ChatViewModel) r1
            ir.nasim.AbstractC10685c16.b(r15)
            r8 = r1
            goto L73
        L51:
            ir.nasim.AbstractC10685c16.b(r15)
            long r3 = r14.getFileId()
            long r5 = r14.getAccessHash()
            ir.nasim.em2 r1 = r13.U0
            r0.a = r13
            r0.b = r14
            r0.e = r2
            r15 = 0
            r8 = 4
            r9 = 0
            r2 = r3
            r4 = r5
            r6 = r15
            r7 = r0
            java.lang.Object r15 = ir.nasim.InterfaceC12532em2.b(r1, r2, r4, r6, r7, r8, r9)
            if (r15 != r10) goto L72
            return r10
        L72:
            r8 = r13
        L73:
            ir.nasim.RY1 r15 = (ir.nasim.RY1) r15
            boolean r1 = r15 instanceof ir.nasim.RY1.a
            if (r1 == 0) goto L7a
            return r15
        L7a:
            ir.nasim.em2 r1 = r8.U0
            r0.a = r8
            r0.b = r14
            r0.e = r12
            r3 = 0
            r4 = 0
            r6 = 4
            r7 = 0
            r2 = r14
            r5 = r0
            java.lang.Object r15 = ir.nasim.InterfaceC12532em2.a(r1, r2, r3, r4, r5, r6, r7)
            if (r15 != r10) goto L8f
            return r10
        L8f:
            r1 = r8
        L90:
            ir.nasim.em2 r15 = r1.U0
            r1 = 0
            ir.nasim.Fq2 r14 = r15.g(r14, r1)
            ir.nasim.chat.ChatViewModel$K r15 = new ir.nasim.chat.ChatViewModel$K
            r15.<init>(r14)
            r14 = 0
            r0.a = r14
            r0.b = r14
            r0.e = r11
            java.lang.Object r15 = ir.nasim.AbstractC6459Nq2.I(r15, r0)
            if (r15 != r10) goto Laa
            return r10
        Laa:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.B5(ir.nasim.core.modules.file.entity.FileReference, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ba() {
        Object value;
        JQ0 jq0;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g1;
        do {
            value = interfaceC9336Zm4.getValue();
            jq0 = (JQ0) value;
        } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : AbstractC4616Fw7.a(null, Integer.valueOf(DD5.snack_bar_magazine_revoke_vote)), (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC10258bL6 Bc(ChatViewModel chatViewModel) {
        C19482qQ7 c19482qQ7M;
        InterfaceC4557Fq2 interfaceC4557Fq2A;
        InterfaceC4557Fq2 interfaceC4557Fq2F;
        InterfaceC4557Fq2 interfaceC4557Fq2X;
        ExPeerType exPeerType;
        AbstractC13042fc3.i(chatViewModel, "this$0");
        C5246In1 c5246In1 = chatViewModel.N1;
        if (c5246In1 == null || (c19482qQ7M = c5246In1.m()) == null) {
            return null;
        }
        if (!C8386Vt0.W5() || (((exPeerType = chatViewModel.A1) != ExPeerType.GROUP && exPeerType != ExPeerType.PRIVATE) || chatViewModel.z1.getPeerId() == chatViewModel.G)) {
            c19482qQ7M = null;
        }
        if (c19482qQ7M == null || (interfaceC4557Fq2A = AbstractC23145wQ7.a(c19482qQ7M)) == null || (interfaceC4557Fq2F = AbstractC6459Nq2.F(interfaceC4557Fq2A)) == null || (interfaceC4557Fq2X = AbstractC6459Nq2.x(interfaceC4557Fq2F, new UA2() { // from class: ir.nasim.yR0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return Long.valueOf(ChatViewModel.Cc((List) obj));
            }
        })) == null) {
            return null;
        }
        return AbstractC6459Nq2.o0(interfaceC4557Fq2X, AbstractC9773aX7.a(chatViewModel), InterfaceC16863lz6.a.d(), AbstractC10360bX0.m());
    }

    private final void C4() {
        C19406qI3.a("NewChatPrivacyBar", "Start observing privacy bar mode for PRIVATE", new Object[0]);
        C21231tK7 c21231tK7 = this.M1;
        if (c21231tK7 == null || this.O1.y(c21231tK7.w(), c21231tK7.r(), new InterfaceC16527lQ7() { // from class: ir.nasim.HR0
            @Override // ir.nasim.InterfaceC16527lQ7
            public final void a(Object obj, AbstractC13554gQ7 abstractC13554gQ7, Object obj2, AbstractC13554gQ7 abstractC13554gQ72) {
                ChatViewModel.E4(this.a, (EnumC3633Br5) obj, abstractC13554gQ7, (String) obj2, abstractC13554gQ72);
            }
        }) == null) {
            C19406qI3.j("NewChatPrivacyBar", "UserVM is null, can't observe privacy bar mode", new Object[0]);
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ca() {
        Object value;
        JQ0 jq0;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g1;
        do {
            value = interfaceC9336Zm4.getValue();
            jq0 = (JQ0) value;
        } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : AbstractC4616Fw7.a(null, Integer.valueOf(DD5.snack_bar_not_join_magazine_revoke_vote)), (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long Cc(List list) {
        AbstractC13042fc3.i(list, "messageIds");
        Iterator it = list.iterator();
        long jH = 0;
        while (it.hasNext()) {
            jH += ((Q64) it.next()).h();
        }
        return jH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object D5(ir.nasim.J44 r31, ir.nasim.InterfaceC20295rm1 r32) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.D5(ir.nasim.J44, ir.nasim.rm1):java.lang.Object");
    }

    private final int D6(long j, long j2, C19024pf0 c19024pf0) {
        int iR = c19024pf0.r();
        for (int i = 0; i < iR; i++) {
            J44 j44 = (J44) c19024pf0.o(i);
            if (j44.i() == j && j44.W() == j2) {
                return i;
            }
        }
        return -1;
    }

    private final void D8() {
        if (J8()) {
            return;
        }
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C11175l0(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E4(ChatViewModel chatViewModel, EnumC3633Br5 enumC3633Br5, AbstractC13554gQ7 abstractC13554gQ7, String str, AbstractC13554gQ7 abstractC13554gQ72) {
        Object value;
        Object value2;
        Object value3;
        AbstractC13042fc3.i(chatViewModel, "this$0");
        C19406qI3.a("NewChatPrivacyBar", "PRIVATE_CHAT has been opened with that privacyBarMode is " + enumC3633Br5, new Object[0]);
        int i = enumC3633Br5 == null ? -1 : C11155d.c[enumC3633Br5.ordinal()];
        if (i != -1) {
            if (i == 1) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = chatViewModel.i1;
                do {
                    value = interfaceC9336Zm4.getValue();
                    AbstractC13042fc3.f(str);
                } while (!interfaceC9336Zm4.f(value, new InterfaceC4335Er5.e(str)));
                return;
            }
            if (i == 2) {
                InterfaceC9336Zm4 interfaceC9336Zm42 = chatViewModel.i1;
                do {
                    value2 = interfaceC9336Zm42.getValue();
                } while (!interfaceC9336Zm42.f(value2, InterfaceC4335Er5.d.a));
                return;
            }
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            InterfaceC9336Zm4 interfaceC9336Zm43 = chatViewModel.i1;
            do {
                value3 = interfaceC9336Zm43.getValue();
            } while (!interfaceC9336Zm43.f(value3, InterfaceC4335Er5.f.a));
            C19406qI3.j("NewChatPrivacyBar", "Receive " + enumC3633Br5 + " value for privacyBar mode", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object E5(java.util.Collection r12, ir.nasim.ZN2 r13, ir.nasim.InterfaceC20295rm1 r14) {
        /*
            Method dump skipped, instructions count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.E5(java.util.Collection, ir.nasim.ZN2, ir.nasim.rm1):java.lang.Object");
    }

    private final int E6(long j, C19024pf0 c19024pf0) {
        int iR = c19024pf0.r();
        for (int i = 0; i < iR; i++) {
            if (((J44) c19024pf0.o(i)).W() == j) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Eb(C21231tK7 c21231tK7) {
        FJ fj = (FJ) c21231tK7.i().b();
        if (fj != null) {
            if (!(!fj.isEmpty())) {
                fj = null;
            }
            if (fj != null) {
                Gb(this, fj);
            }
        }
        this.O1.r(c21231tK7.i(), new InterfaceC14756iQ7() { // from class: ir.nasim.GR0
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                ChatViewModel.Fb(this.a, (FJ) obj, abstractC13554gQ7);
            }
        });
    }

    public static /* synthetic */ void Ec(ChatViewModel chatViewModel, int i, TreeSet treeSet, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = true;
        }
        chatViewModel.Dc(i, treeSet, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fb(ChatViewModel chatViewModel, FJ fj, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(chatViewModel, "this$0");
        if (fj != null) {
            if (!(!fj.isEmpty())) {
                fj = null;
            }
            if (fj != null) {
                Gb(chatViewModel, fj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JQ0 Fc(JQ0 jq0) {
        AbstractC13042fc3.i(jq0, "it");
        return jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : new AbstractC4571Fr7.d(false, false, 2, null), (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null);
    }

    private static final void Gb(ChatViewModel chatViewModel, List list) {
        InterfaceC10503bj0.a aVar = new InterfaceC10503bj0.a(list, false, 2, null);
        InterfaceC9336Zm4 interfaceC9336Zm4 = chatViewModel.g1;
        while (true) {
            Object value = interfaceC9336Zm4.getValue();
            JQ0 jq0 = (JQ0) value;
            InterfaceC9336Zm4 interfaceC9336Zm42 = interfaceC9336Zm4;
            InterfaceC10503bj0.a aVar2 = aVar;
            if (interfaceC9336Zm42.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : aVar, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null))) {
                return;
            }
            interfaceC9336Zm4 = interfaceC9336Zm42;
            aVar = aVar2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JQ0 Gc(JQ0 jq0) {
        AbstractC13042fc3.i(jq0, "it");
        return jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : AbstractC4571Fr7.b.a, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object H4(ir.nasim.InterfaceC20295rm1 r29) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.H4(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean H8() {
        return (this.x2 == 0 || this.y2 == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JQ0 Hc(boolean z, I5 i5, JQ0 jq0) {
        AbstractC13042fc3.i(i5, "$menuItems");
        AbstractC13042fc3.i(jq0, "it");
        return z ? jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : new AbstractC4571Fr7.e(i5), (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null) : jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : new AbstractC4571Fr7.a(i5), (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String I4(androidx.lifecycle.y yVar) {
        AbstractC13042fc3.i(yVar, "$savedStateHandle");
        return (String) yVar.c("BOT_THAT_ADDED_NAME");
    }

    private final boolean I8(J44[] j44Arr) {
        if (j44Arr.length != 1) {
            return false;
        }
        J44 j44 = j44Arr[0];
        AbstractC17457n0 abstractC17457n0F = j44.F();
        if (!this.d.I(j44.h()) || j44.U() != this.G) {
            return false;
        }
        C8445Vz5 c8445Vz5Q = j44.Q();
        return ((c8445Vz5Q != null && c8445Vz5Q.E()) || (abstractC17457n0F instanceof C11907dl) || (abstractC17457n0F instanceof C16799lt) || (abstractC17457n0F instanceof JM6) || (abstractC17457n0F instanceof ir.nasim.core.modules.messaging.entity.content.a) || (abstractC17457n0F instanceof C22472vI2) || (abstractC17457n0F instanceof BJ2) || (abstractC17457n0F instanceof C18626oy5) || (abstractC17457n0F instanceof C6833Pe1) || (abstractC17457n0F instanceof C10844cI3) || (abstractC17457n0F instanceof AbstractC12586er6)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Ib(ir.nasim.C6374Ni0 r32, ir.nasim.InterfaceC20295rm1 r33) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.Ib(ir.nasim.Ni0, ir.nasim.rm1):java.lang.Object");
    }

    private final void Ic(int i, Drawable drawable) {
        Object value;
        List listP1;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.j2;
        do {
            value = interfaceC9336Zm4.getValue();
            listP1 = AbstractC15401jX0.p1((List) value);
            listP1.set(i, drawable);
        } while (!interfaceC9336Zm4.f(value, AbstractC15401jX0.m1(listP1)));
    }

    private final void Ja(BytesValue bytesValue) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new S0(bytesValue, null), 3, null);
    }

    private final void Jb() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new o1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC10258bL6 Jc(ChatViewModel chatViewModel) {
        AbstractC13042fc3.i(chatViewModel, "this$0");
        return AbstractC6459Nq2.o0(new A1(new B1(chatViewModel.B0.c()), chatViewModel), AbstractC9773aX7.a(chatViewModel), InterfaceC16863lz6.a.c(), null);
    }

    private final WF3 K6() {
        return (WF3) this.r1.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC9336Zm4 K7() {
        return (InterfaceC9336Zm4) this.B2.getValue();
    }

    private final C9616aG3 L6() {
        return (C9616aG3) this.d1.getValue();
    }

    private final void Lc(J44 j44) {
        Object value;
        ArrayList arrayList;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.l2;
        do {
            value = interfaceC9336Zm4.getValue();
            List listP1 = AbstractC15401jX0.p1((List) value);
            listP1.add(new S74(j44));
            HashSet hashSet = new HashSet();
            arrayList = new ArrayList();
            for (Object obj : listP1) {
                S74 s74 = (S74) obj;
                if (hashSet.add(AbstractC4616Fw7.a(Long.valueOf(s74.a().h()), Long.valueOf(s74.a().i())))) {
                    arrayList.add(obj);
                }
            }
        } while (!interfaceC9336Zm4.f(value, AbstractC15401jX0.a1(arrayList, new C1())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M7(final ChatViewModel chatViewModel, final C19024pf0 c19024pf0, final C7234Qv5 c7234Qv5) {
        AbstractC13042fc3.i(chatViewModel, "this$0");
        AbstractC13042fc3.i(c19024pf0, "$displayList");
        AbstractC13042fc3.i(c7234Qv5, "resolver");
        chatViewModel.f9(chatViewModel.z1, c19024pf0).m0(new InterfaceC24449ye1() { // from class: ir.nasim.wR0
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ChatViewModel.N7(c7234Qv5, chatViewModel, (C14505i18) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.xR0
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ChatViewModel.O7(this.a, c7234Qv5, c19024pf0, (Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 Ma(Context context, C13518gM7 c13518gM7, List list, long j, long j2) {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new V0(context, c13518gM7, list, this, j, j2, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object N6(ir.nasim.core.modules.file.entity.FileReference r12, ir.nasim.InterfaceC20295rm1 r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof ir.nasim.chat.ChatViewModel.C11150b0
            if (r0 == 0) goto L13
            r0 = r13
            ir.nasim.chat.ChatViewModel$b0 r0 = (ir.nasim.chat.ChatViewModel.C11150b0) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.chat.ChatViewModel$b0 r0 = new ir.nasim.chat.ChatViewModel$b0
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.c
            java.lang.Object r8 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r0.e
            r2 = 1
            r9 = 2
            r10 = 0
            if (r1 == 0) goto L41
            if (r1 == r2) goto L35
            if (r1 != r9) goto L2d
            ir.nasim.AbstractC10685c16.b(r13)
            goto L76
        L2d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L35:
            java.lang.Object r12 = r0.b
            ir.nasim.core.modules.file.entity.FileReference r12 = (ir.nasim.core.modules.file.entity.FileReference) r12
            java.lang.Object r1 = r0.a
            ir.nasim.chat.ChatViewModel r1 = (ir.nasim.chat.ChatViewModel) r1
            ir.nasim.AbstractC10685c16.b(r13)
            goto L5d
        L41:
            ir.nasim.AbstractC10685c16.b(r13)
            if (r12 != 0) goto L47
            return r10
        L47:
            ir.nasim.em2 r1 = r11.U0
            r0.a = r11
            r0.b = r12
            r0.e = r2
            r3 = 0
            r4 = 0
            r6 = 6
            r7 = 0
            r2 = r12
            r5 = r0
            java.lang.Object r13 = ir.nasim.InterfaceC12532em2.a(r1, r2, r3, r4, r5, r6, r7)
            if (r13 != r8) goto L5c
            return r8
        L5c:
            r1 = r11
        L5d:
            ir.nasim.em2 r13 = r1.U0
            r1 = 0
            ir.nasim.Fq2 r12 = ir.nasim.InterfaceC12532em2.i(r13, r12, r1, r9, r10)
            ir.nasim.chat.ChatViewModel$c0 r13 = new ir.nasim.chat.ChatViewModel$c0
            r13.<init>(r10)
            r0.a = r10
            r0.b = r10
            r0.e = r9
            java.lang.Object r13 = ir.nasim.AbstractC6459Nq2.J(r12, r13, r0)
            if (r13 != r8) goto L76
            return r8
        L76:
            ir.nasim.RY1 r13 = (ir.nasim.RY1) r13
            boolean r12 = r13 instanceof ir.nasim.RY1.a
            if (r12 == 0) goto L7f
            ir.nasim.RY1$a r13 = (ir.nasim.RY1.a) r13
            goto L80
        L7f:
            r13 = r10
        L80:
            if (r13 == 0) goto L8c
            ir.nasim.Am2 r12 = r13.a()
            if (r12 == 0) goto L8c
            java.lang.String r10 = r12.getDescriptor()
        L8c:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.N6(ir.nasim.core.modules.file.entity.FileReference, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N7(C7234Qv5 c7234Qv5, ChatViewModel chatViewModel, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c7234Qv5, "$resolver");
        AbstractC13042fc3.i(chatViewModel, "this$0");
        c7234Qv5.b(new C10872cL4(EnumC11636dL4.LAST_MESSAGE, 0L, chatViewModel.Q1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O7(ChatViewModel chatViewModel, C7234Qv5 c7234Qv5, C19024pf0 c19024pf0, Exception exc) {
        AbstractC13042fc3.i(chatViewModel, "this$0");
        AbstractC13042fc3.i(c7234Qv5, "$resolver");
        AbstractC13042fc3.i(c19024pf0, "$displayList");
        AbstractC13042fc3.i(exc, "exception");
        if (exc instanceof CurrentlyHistoryIsLoading) {
            chatViewModel.c8(c7234Qv5, c19024pf0);
        } else {
            c7234Qv5.a(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(ChatViewModel chatViewModel, C10872cL4 c10872cL4) {
        AbstractC13042fc3.i(chatViewModel, "this$0");
        chatViewModel.Ob(true);
    }

    private final void Oa(long j) {
        this.w.d("authentication_bots", AbstractC20051rO3.n(AbstractC4616Fw7.a("peer_id", Integer.valueOf(this.z1.getPeerId())), AbstractC4616Fw7.a("peer_type", Integer.valueOf(ExPeerType.BOT.getValue())), AbstractC4616Fw7.a(DialogEntity.COLUMN_RID, Long.valueOf(j)), AbstractC4616Fw7.a("random_id", Integer.valueOf(this.I1)), AbstractC4616Fw7.a("source_type", Integer.valueOf(EnumC16528lR.c.j()))));
    }

    private final void P4(boolean z) {
        boolean z2 = !this.r2 && this.s2;
        if (this.t2 != z2) {
            this.t2 = z2;
            this.v.i0(this.z1, z2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(ChatViewModel chatViewModel, C10872cL4 c10872cL4) {
        AbstractC13042fc3.i(chatViewModel, "this$0");
        AbstractC13042fc3.i(c10872cL4, "cmd");
        chatViewModel.q2 = c10872cL4.c();
        chatViewModel.Ob(true);
    }

    public static /* synthetic */ C6517Nv5 Q7(ChatViewModel chatViewModel, C19024pf0 c19024pf0, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return chatViewModel.P7(c19024pf0, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C13518gM7 Qc(ChatViewModel chatViewModel) {
        AbstractC13042fc3.i(chatViewModel, "this$0");
        return new C13518gM7(chatViewModel.g.p0(), chatViewModel.L1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IQ0 R4(ChatViewModel chatViewModel) {
        AbstractC13042fc3.i(chatViewModel, "this$0");
        switch (C11155d.a[chatViewModel.A1.ordinal()]) {
            case 1:
                return new IQ0.a.C0416a(chatViewModel.L1);
            case 2:
                return new IQ0.a.b(chatViewModel.L1);
            case 3:
                return new IQ0.b.C0417b(chatViewModel.M1);
            case 4:
                return new IQ0.b.a(chatViewModel.M1);
            case 5:
                return new IQ0.b.C0417b(chatViewModel.M1);
            case 6:
                return new IQ0.b.C0417b(chatViewModel.M1);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R7(ChatViewModel chatViewModel, boolean z, final C19024pf0 c19024pf0, final C7234Qv5 c7234Qv5) {
        AbstractC13042fc3.i(chatViewModel, "this$0");
        AbstractC13042fc3.i(c19024pf0, "$displayList");
        AbstractC13042fc3.i(c7234Qv5, "resolver");
        chatViewModel.v.H1(chatViewModel.z1, z).H(new InterfaceC17569nB2() { // from class: ir.nasim.BR0
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return ChatViewModel.S7(c19024pf0, (C14505i18) obj);
            }
        }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.DR0
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ChatViewModel.T7(c7234Qv5, (C14505i18) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ra(long j, long j2, List list) {
        C12889fL5 c12889fL5 = new C12889fL5();
        c12889fL5.a = new ArrayList();
        int i = 0;
        while (i < list.size()) {
            int i2 = i + 1;
            C24967zW1 c24967zW1 = (C24967zW1) list.get(i);
            if ((c24967zW1 instanceof C13388g85) || (c24967zW1 instanceof GS7)) {
                ((List) c12889fL5.a).add(c24967zW1);
            } else {
                Sa(c12889fL5, this, j, j2);
                this.v.t2(this.z1, j, j2, c24967zW1, i6());
            }
            i = i2;
        }
        Sa(c12889fL5, this, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 S7(C19024pf0 c19024pf0, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c19024pf0, "$displayList");
        return c19024pf0.X();
    }

    private static final void Sa(C12889fL5 c12889fL5, ChatViewModel chatViewModel, long j, long j2) {
        if (!((Collection) c12889fL5.a).isEmpty()) {
            int i = 0;
            if (((List) c12889fL5.a).size() == 1) {
                chatViewModel.v.t2(chatViewModel.z1, j, j2, (C24967zW1) ((List) c12889fL5.a).get(0), chatViewModel.i6());
            } else {
                while (true) {
                    int i2 = i + 10;
                    chatViewModel.v.m2(Long.valueOf(AbstractC19981rG5.a()), chatViewModel.z1, Long.valueOf(j), Long.valueOf(j2), ((List) c12889fL5.a).subList(i, AbstractC23053wG5.i(i2, ((List) c12889fL5.a).size())));
                    if (((List) c12889fL5.a).size() <= i2) {
                        break;
                    } else {
                        i = i2;
                    }
                }
            }
            c12889fL5.a = new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T7(C7234Qv5 c7234Qv5, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c7234Qv5, "$resolver");
        c7234Qv5.b(new C10872cL4(EnumC11636dL4.FIRST_MESSAGE, 0L, 0L));
    }

    private final void T9(List list, C20610sI7 c20610sI7, int i, Context context) {
        Object next;
        AvatarImage imageDefaultSize;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Avatar avatarA = ((DH5) next).a();
            if (AbstractC13042fc3.d((avatarA == null || (imageDefaultSize = avatarA.getImageDefaultSize()) == null) ? null : imageDefaultSize.getFileReference(), c20610sI7.b())) {
                break;
            }
        }
        DH5 dh5 = (DH5) next;
        Ic(i, new WU(dh5 != null ? dh5.b() : null, dh5 != null ? dh5.e() : AbstractC19981rG5.b(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT), 12.0f, context, dh5 != null ? dh5.f() : false, true));
    }

    private final long U6() {
        C19482qQ7 c19482qQ7H;
        Long l;
        C5246In1 c5246In1 = this.N1;
        return (c5246In1 == null || (c19482qQ7H = c5246In1.h()) == null || (l = (Long) c19482qQ7H.b()) == null) ? this.R1 : l.longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ub(J44 j44, boolean z) {
        C17532n74 c17532n74;
        DB3 db3H0 = this.v.H0(this.z1);
        C17532n74 c17532n74T = j44.T();
        if (c17532n74T == null || (c17532n74 = c17532n74T.q((504 & 1) != 0 ? c17532n74T.a : 0, (504 & 2) != 0 ? c17532n74T.b : null, (504 & 4) != 0 ? c17532n74T.c : null, (504 & 8) != 0 ? c17532n74T.d : null, (504 & 16) != 0 ? c17532n74T.e : null, (504 & 32) != 0 ? c17532n74T.f : null, (504 & 64) != 0 ? c17532n74T.g : true, (504 & 128) != 0 ? c17532n74T.h : 0L, (504 & 256) != 0 ? c17532n74T.i : 0)) == null) {
            c17532n74 = new C17532n74(0, null, null, null, null, null, z, 0L, 0, 447, null);
        }
        db3H0.d(J44.D(j44, 0L, 0L, 0L, 0, null, null, null, 0, null, null, 0L, null, null, false, null, false, c17532n74, null, 196607, null));
    }

    private final int V6() {
        C19482qQ7 c19482qQ7N;
        Integer num;
        C5246In1 c5246In1 = this.N1;
        return (c5246In1 == null || (c19482qQ7N = c5246In1.n()) == null || (num = (Integer) c19482qQ7N.b()) == null) ? this.S1 : num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V7(final ChatViewModel chatViewModel, final C19024pf0 c19024pf0, final C7234Qv5 c7234Qv5) {
        AbstractC13042fc3.i(chatViewModel, "this$0");
        AbstractC13042fc3.i(c19024pf0, "$displayList");
        AbstractC13042fc3.i(c7234Qv5, "resolver");
        chatViewModel.h9(chatViewModel.V1, c19024pf0).H(new InterfaceC17569nB2() { // from class: ir.nasim.qR0
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return ChatViewModel.W7(c19024pf0, chatViewModel, (C14505i18) obj);
            }
        }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.sR0
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ChatViewModel.X7(c7234Qv5, chatViewModel, (C14505i18) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.tR0
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ChatViewModel.Y7(c7234Qv5, (Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V9(Context context) {
        Object value;
        JQ0 jq0;
        Object value2;
        JQ0 jq02;
        if (this.d.M3()) {
            String string = context.getString(DD5.snack_bar_reach_limit_suggest_magazine, XY6.v(String.valueOf(this.A.c())));
            AbstractC13042fc3.h(string, "getString(...)");
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.g1;
            do {
                value = interfaceC9336Zm4.getValue();
                jq0 = (JQ0) value;
            } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : AbstractC4616Fw7.a(string, null), (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
            return;
        }
        String string2 = context.getString(DD5.dialog_desc_limit_suggest_magazine, XY6.v(String.valueOf(this.A.c())));
        AbstractC13042fc3.h(string2, "getString(...)");
        InterfaceC9336Zm4 interfaceC9336Zm42 = this.g1;
        do {
            value2 = interfaceC9336Zm42.getValue();
            jq02 = (JQ0) value2;
        } while (!interfaceC9336Zm42.f(value2, jq02.a((262142 & 1) != 0 ? jq02.a : null, (262142 & 2) != 0 ? jq02.b : null, (262142 & 4) != 0 ? jq02.c : null, (262142 & 8) != 0 ? jq02.d : null, (262142 & 16) != 0 ? jq02.e : false, (262142 & 32) != 0 ? jq02.f : null, (262142 & 64) != 0 ? jq02.g : new C20021rL0(AbstractC15208jB5.magazine_profile, DD5.dialog_title_suggest_magazine, null, string2, null, 20, null), (262142 & 128) != 0 ? jq02.h : null, (262142 & 256) != 0 ? jq02.i : null, (262142 & 512) != 0 ? jq02.j : null, (262142 & 1024) != 0 ? jq02.k : null, (262142 & 2048) != 0 ? jq02.l : null, (262142 & 4096) != 0 ? jq02.m : null, (262142 & 8192) != 0 ? jq02.n : null, (262142 & 16384) != 0 ? jq02.o : null, (262142 & 32768) != 0 ? jq02.p : null, (262142 & 65536) != 0 ? jq02.q : null, (262142 & 131072) != 0 ? jq02.r : null)));
        this.d.s7(true);
    }

    private final void W4() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new C11190t(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 W7(C19024pf0 c19024pf0, ChatViewModel chatViewModel, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c19024pf0, "$displayList");
        AbstractC13042fc3.i(chatViewModel, "this$0");
        return c19024pf0.Z(chatViewModel.V1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X7(C7234Qv5 c7234Qv5, ChatViewModel chatViewModel, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c7234Qv5, "$resolver");
        AbstractC13042fc3.i(chatViewModel, "this$0");
        c7234Qv5.b(new C10872cL4(EnumC11636dL4.LAST_READ_MESSAGE, 0L, chatViewModel.V1));
    }

    private final void X9() {
        if (this.u2 != null) {
            this.u2 = null;
            this.v.e2(this.z1, this.V1, ((Number) this.Y1.getValue()).intValue());
        }
        this.v2 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y7(C7234Qv5 c7234Qv5, Exception exc) {
        AbstractC13042fc3.i(c7234Qv5, "$resolver");
        AbstractC13042fc3.i(exc, "e");
        c7234Qv5.a(exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z4() {
        InterfaceC13730gj3 interfaceC13730gj3 = this.G2;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.G2 = AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C11194v(null), 3, null);
    }

    private final C6634Oi0.a Z6(C6374Ni0.a aVar) {
        if (aVar instanceof C6374Ni0.a.b) {
            C6374Ni0.a.d dVarD = ((C6374Ni0.a.b) aVar).d();
            if (dVarD != null) {
                return new C6634Oi0.a.c(dVarD.a());
            }
            return null;
        }
        if (aVar instanceof C6374Ni0.a.c) {
            C6374Ni0.a.d dVarD2 = ((C6374Ni0.a.c) aVar).d();
            if (dVarD2 != null) {
                return new C6634Oi0.a.c(dVarD2.a());
            }
            return null;
        }
        if (aVar instanceof C6374Ni0.a.e) {
            return new C6634Oi0.a.d(this.d.E0());
        }
        if (aVar == null) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void a5() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C11196w(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a9(ChatViewModel chatViewModel, Integer num, Exception exc) {
        AbstractC13042fc3.i(chatViewModel, "this$0");
        chatViewModel.o1 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(ChatViewModel chatViewModel) {
        AbstractC13042fc3.i(chatViewModel, "this$0");
        chatViewModel.X9();
    }

    private final void ab(C11458d25 c11458d25, Context context, C24890zN5 c24890zN5, int i, String str) {
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(Boolean.FALSE);
        Z0 z0 = new Z0(interfaceC9336Zm4A, this, context, str, c11458d25);
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new Y0(interfaceC9336Zm4A, this.i.D(new FileReference(new C12056dy(c24890zN5.b(), c24890zN5.a(), 1), "fall.jpg", "", c24890zN5.c()), true, z0, (56 & 8) != 0 ? false : false, (56 & 16) != 0, (56 & 32) != 0 ? false : false), this, c11458d25, context, c24890zN5, i, str, null), 2, null);
    }

    private final void b5() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C11198x(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bb(C11458d25 c11458d25, Context context, C24890zN5 c24890zN5, int i, String str) {
        Bitmap bitmap;
        Drawable drawableF = i % 2 == 0 ? AbstractC4043Dl1.f(context, KB5.faal_red_thumbnail) : AbstractC4043Dl1.f(context, KB5.faal_green_thumbnail);
        BitmapDrawable bitmapDrawable = drawableF instanceof BitmapDrawable ? (BitmapDrawable) drawableF : null;
        if (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) {
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 10, byteArrayOutputStream);
        this.v.F2(c11458d25, str, Long.valueOf(c24890zN5.b()), Long.valueOf(c24890zN5.a()), c24890zN5.c(), 200, 300, new C22694vg2(300, 200, byteArrayOutputStream.toByteArray()), null);
    }

    private final void c8(final C7234Qv5 c7234Qv5, final C19024pf0 c19024pf0) {
        AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.ER0
            @Override // java.lang.Runnable
            public final void run() {
                ChatViewModel.d8(this.a, c19024pf0, c7234Qv5);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d8(final ChatViewModel chatViewModel, final C19024pf0 c19024pf0, final C7234Qv5 c7234Qv5) {
        AbstractC13042fc3.i(chatViewModel, "this$0");
        AbstractC13042fc3.i(c19024pf0, "$displayList");
        AbstractC13042fc3.i(c7234Qv5, "$resolver");
        chatViewModel.f9(chatViewModel.z1, c19024pf0).m0(new InterfaceC24449ye1() { // from class: ir.nasim.JR0
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ChatViewModel.e8(c7234Qv5, chatViewModel, (C14505i18) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.KR0
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ChatViewModel.f8(this.a, c19024pf0, c7234Qv5, (Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dc(Context context) {
        Object value;
        JQ0 jq0;
        if (this.d.N3()) {
            pc();
            return;
        }
        String string = context.getString(DD5.dialog_desc_first_suggest_magazine, XY6.v(String.valueOf(this.A.c())));
        AbstractC13042fc3.h(string, "getString(...)");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g1;
        do {
            value = interfaceC9336Zm4.getValue();
            jq0 = (JQ0) value;
        } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : new C20021rL0(AbstractC15208jB5.up_vote_modal_light, DD5.dialog_title_suggest_magazine, null, string, new s1(this), 4, null), (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
        this.d.t7(true);
    }

    private final void e5() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new C11200y(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e8(C7234Qv5 c7234Qv5, ChatViewModel chatViewModel, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c7234Qv5, "$resolver");
        AbstractC13042fc3.i(chatViewModel, "this$0");
        c7234Qv5.b(new C10872cL4(EnumC11636dL4.LAST_MESSAGE, 0L, chatViewModel.Q1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e9(ChatViewModel chatViewModel, C14505i18 c14505i18, Exception exc) {
        AbstractC13042fc3.i(chatViewModel, "this$0");
        chatViewModel.z2.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ec() {
        Object value;
        JQ0 jq0;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g1;
        do {
            value = interfaceC9336Zm4.getValue();
            jq0 = (JQ0) value;
        } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : AbstractC4616Fw7.a(null, Integer.valueOf(DD5.snack_bar_not_join_magazine_vote)), (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC9336Zm4 f2() {
        return AbstractC12281eL6.a(PG5.a.d());
    }

    private final void f5() {
        if (this.z1.z()) {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C11202z(null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f8(final ChatViewModel chatViewModel, final C19024pf0 c19024pf0, final C7234Qv5 c7234Qv5, Exception exc) {
        AbstractC13042fc3.i(chatViewModel, "this$0");
        AbstractC13042fc3.i(c19024pf0, "$displayList");
        AbstractC13042fc3.i(c7234Qv5, "$resolver");
        AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.LR0
            @Override // java.lang.Runnable
            public final void run() {
                ChatViewModel.g8(this.a, c19024pf0, c7234Qv5);
            }
        }, 1300L);
    }

    private final C6517Nv5 f9(C11458d25 c11458d25, final C19024pf0 c19024pf0) {
        C6517Nv5 c6517Nv5H = this.v.J1(c11458d25, H8()).H(new InterfaceC17569nB2() { // from class: ir.nasim.uR0
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return ChatViewModel.g9(c19024pf0, (C14505i18) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShareData fc(androidx.lifecycle.y yVar) {
        AbstractC13042fc3.i(yVar, "$savedStateHandle");
        return (ShareData) yVar.c("EXTRA_SHARE_DATA");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g2(ShareAttachment shareAttachment) {
        AbstractC13042fc3.i(shareAttachment, "it");
        return AbstractC13042fc3.d(shareAttachment.getTag(), "POLL");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g8(final ChatViewModel chatViewModel, final C19024pf0 c19024pf0, final C7234Qv5 c7234Qv5) {
        AbstractC13042fc3.i(chatViewModel, "this$0");
        AbstractC13042fc3.i(c19024pf0, "$displayList");
        AbstractC13042fc3.i(c7234Qv5, "$resolver");
        chatViewModel.f9(chatViewModel.z1, c19024pf0).m0(new InterfaceC24449ye1() { // from class: ir.nasim.MR0
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ChatViewModel.h8(c7234Qv5, chatViewModel, (C14505i18) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.OR0
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ChatViewModel.i8(this.a, c19024pf0, c7234Qv5, (Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 g9(C19024pf0 c19024pf0, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c19024pf0, "$displayList");
        return c19024pf0.Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h2(ChatViewModel chatViewModel, Throwable th) {
        AbstractC13042fc3.i(chatViewModel, "this$0");
        chatViewModel.y9();
        C21231tK7 c21231tK7 = chatViewModel.M1;
        if (c21231tK7 != null && c21231tK7.y()) {
            chatViewModel.Jb();
            if (C8386Vt0.L4()) {
                chatViewModel.a5();
            } else {
                chatViewModel.Z4();
            }
            if (C8386Vt0.a.P4()) {
                chatViewModel.b5();
            }
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h8(C7234Qv5 c7234Qv5, ChatViewModel chatViewModel, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c7234Qv5, "$resolver");
        AbstractC13042fc3.i(chatViewModel, "this$0");
        c7234Qv5.b(new C10872cL4(EnumC11636dL4.LAST_MESSAGE, 0L, chatViewModel.Q1));
    }

    private final C6517Nv5 h9(long j, C19024pf0 c19024pf0) {
        if (E6(j, c19024pf0) >= 0) {
            C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.f(c6517Nv5L0);
            return c6517Nv5L0;
        }
        C6517Nv5 c6517Nv5I1 = this.v.I1(this.z1, j, H8());
        AbstractC13042fc3.f(c6517Nv5I1);
        return c6517Nv5I1;
    }

    public static /* synthetic */ void hb(ChatViewModel chatViewModel, String str, int i, ExPeerType exPeerType, Boolean bool, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            bool = null;
        }
        chatViewModel.gb(str, i, exPeerType, bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i5(android.content.Context r6, ir.nasim.utils.share.SharedContent.MediaContent r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof ir.nasim.chat.ChatViewModel.A
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.chat.ChatViewModel$A r0 = (ir.nasim.chat.ChatViewModel.A) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.chat.ChatViewModel$A r0 = new ir.nasim.chat.ChatViewModel$A
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L37
            if (r2 != r4) goto L2f
            java.lang.Object r6 = r0.a
            r7 = r6
            ir.nasim.utils.share.SharedContent$MediaContent r7 = (ir.nasim.utils.share.SharedContent.MediaContent) r7
            ir.nasim.AbstractC10685c16.b(r8)
            goto L4c
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.go1 r8 = r5.b
            ir.nasim.chat.ChatViewModel$B r2 = new ir.nasim.chat.ChatViewModel$B
            r2.<init>(r7, r6, r3)
            r0.a = r7
            r0.d = r4
            java.lang.Object r8 = ir.nasim.AbstractC9323Zl0.g(r8, r2, r0)
            if (r8 != r1) goto L4c
            return r1
        L4c:
            r6 = r8
            ir.nasim.zW1 r6 = (ir.nasim.C24967zW1) r6
            if (r6 != 0) goto L52
            goto L5a
        L52:
            java.lang.Class r6 = r6.getClass()
            java.lang.String r3 = r6.getSimpleName()
        L5a:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r7)
            java.lang.String r7 = " mapped to "
            r6.append(r7)
            r6.append(r3)
            java.lang.String r6 = r6.toString()
            r7 = 0
            java.lang.Object[] r7 = new java.lang.Object[r7]
            java.lang.String r0 = "ChatViewModel"
            ir.nasim.C19406qI3.a(r0, r6, r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.i5(android.content.Context, ir.nasim.utils.share.SharedContent$MediaContent, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i8(final ChatViewModel chatViewModel, final C19024pf0 c19024pf0, final C7234Qv5 c7234Qv5, Exception exc) {
        AbstractC13042fc3.i(chatViewModel, "this$0");
        AbstractC13042fc3.i(c19024pf0, "$displayList");
        AbstractC13042fc3.i(c7234Qv5, "$resolver");
        AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.PR0
            @Override // java.lang.Runnable
            public final void run() {
                ChatViewModel.j8(this.a, c19024pf0, c7234Qv5);
            }
        }, 1700L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j6(ir.nasim.C6374Ni0.a r14, ir.nasim.InterfaceC20295rm1 r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof ir.nasim.chat.ChatViewModel.V
            if (r0 == 0) goto L13
            r0 = r15
            ir.nasim.chat.ChatViewModel$V r0 = (ir.nasim.chat.ChatViewModel.V) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.chat.ChatViewModel$V r0 = new ir.nasim.chat.ChatViewModel$V
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r14 = r0.a
            ir.nasim.Ni0$a r14 = (ir.nasim.C6374Ni0.a) r14
            ir.nasim.AbstractC10685c16.b(r15)
            goto L76
        L2e:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L36:
            ir.nasim.AbstractC10685c16.b(r15)
            if (r14 != 0) goto L3c
            return r4
        L3c:
            boolean r15 = r14 instanceof ir.nasim.C6374Ni0.a.e
            if (r15 == 0) goto L4c
            ir.nasim.Oi0$a$d r14 = new ir.nasim.Oi0$a$d
            ir.nasim.core.modules.settings.SettingsModule r15 = r13.d
            java.lang.String r15 = r15.E0()
            r14.<init>(r15)
            return r14
        L4c:
            ir.nasim.core.modules.file.entity.FileReference r15 = new ir.nasim.core.modules.file.entity.FileReference
            ir.nasim.Ni0$a$a r2 = r14.a()
            long r6 = r2.b()
            ir.nasim.Ni0$a$a r2 = r14.a()
            long r8 = r2.a()
            java.lang.String r10 = r14.b()
            r11 = 0
            int r12 = r14.c()
            r5 = r15
            r5.<init>(r6, r8, r10, r11, r12)
            r0.a = r14
            r0.d = r3
            java.lang.Object r15 = r13.N6(r15, r0)
            if (r15 != r1) goto L76
            return r1
        L76:
            java.lang.String r15 = (java.lang.String) r15
            if (r15 != 0) goto L7b
            return r4
        L7b:
            boolean r0 = r14 instanceof ir.nasim.C6374Ni0.a.b
            if (r0 == 0) goto L85
            ir.nasim.Oi0$a$a r4 = new ir.nasim.Oi0$a$a
            r4.<init>(r15)
            goto L8e
        L85:
            boolean r14 = r14 instanceof ir.nasim.C6374Ni0.a.c
            if (r14 == 0) goto L8e
            ir.nasim.Oi0$a$b r4 = new ir.nasim.Oi0$a$b
            r4.<init>(r15)
        L8e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.j6(ir.nasim.Ni0$a, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j8(final ChatViewModel chatViewModel, C19024pf0 c19024pf0, final C7234Qv5 c7234Qv5) {
        AbstractC13042fc3.i(chatViewModel, "this$0");
        AbstractC13042fc3.i(c19024pf0, "$displayList");
        AbstractC13042fc3.i(c7234Qv5, "$resolver");
        chatViewModel.f9(chatViewModel.z1, c19024pf0).m0(new InterfaceC24449ye1() { // from class: ir.nasim.QR0
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ChatViewModel.k8(c7234Qv5, chatViewModel, (C14505i18) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.RR0
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ChatViewModel.l8(c7234Qv5, (Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 j9(C19024pf0 c19024pf0, C10872cL4 c10872cL4) {
        AbstractC13042fc3.i(c19024pf0, "$displayList");
        return c19024pf0.Z(c10872cL4.c());
    }

    public static /* synthetic */ void k5(ChatViewModel chatViewModel, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        chatViewModel.j5(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k8(C7234Qv5 c7234Qv5, ChatViewModel chatViewModel, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c7234Qv5, "$resolver");
        AbstractC13042fc3.i(chatViewModel, "this$0");
        c7234Qv5.b(new C10872cL4(EnumC11636dL4.LAST_MESSAGE, 0L, chatViewModel.Q1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 k9(ChatViewModel chatViewModel, C19024pf0 c19024pf0, C10872cL4 c10872cL4) {
        AbstractC13042fc3.i(chatViewModel, "this$0");
        AbstractC13042fc3.i(c19024pf0, "$displayList");
        int iD6 = chatViewModel.D6(c10872cL4.b(), c10872cL4.c(), c19024pf0);
        return iD6 < 0 ? C6517Nv5.F(new Resources.NotFoundException("index")) : C6517Nv5.l0(Integer.valueOf(iD6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean kc() {
        return this.z1.C() && AbstractC20762sZ6.M0(this.d.h4(), new char[]{','}, false, 0, 6, null).contains(String.valueOf(this.z1.getPeerId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String l6(Throwable th, Context context) {
        if (!(th instanceof RpcException)) {
            return th.getMessage();
        }
        RpcException rpcException = (RpcException) th;
        return AbstractC13042fc3.d(rpcException.getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String(), "NOT_IN_TIME_WINDOW") ? context.getString(DD5.edit_message_error_slowpoke) : AbstractC13042fc3.d(rpcException.getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String(), "DENIAL_MESSAGE") ? context.getString(DD5.edit_message_error_not_yours) : AbstractC13042fc3.d(rpcException.getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String(), "TIMEOUT") ? context.getString(DD5.edit_message_error_time_out) : AbstractC13042fc3.d(rpcException.getIr.nasim.database.dailogLists.DialogEntity.COLUMN_MESSAGE java.lang.String(), "Not Exists") ? context.getString(DD5.toast_not_exist) : rpcException.getIr.nasim.database.dailogLists.DialogEntity.COLUMN_MESSAGE java.lang.String();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l8(C7234Qv5 c7234Qv5, Exception exc) {
        AbstractC13042fc3.i(c7234Qv5, "$resolver");
        AbstractC13042fc3.i(exc, "e");
        c7234Qv5.a(exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lb(ProgressDialog progressDialog, C4382Ew7 c4382Ew7) {
        AbstractC13042fc3.i(progressDialog, "$progressBar");
        Object objA = c4382Ew7.a();
        AbstractC13042fc3.h(objA, "getT1(...)");
        if (!(((Object[]) objA).length == 0)) {
            C18987pb3 c18987pb3 = C18987pb3.a;
            W25 w25 = W25.a;
            Object objA2 = c4382Ew7.a();
            AbstractC13042fc3.h(objA2, "getT1(...)");
            C18987pb3.x1(c18987pb3, new C11458d25(w25, ((C21231tK7) AbstractC10242bK.b0((Object[]) objA2)).o()), null, null, false, null, null, false, null, null, false, null, 2046, null);
            progressDialog.dismiss();
        }
    }

    private final void m8(UA2 ua2, UA2 ua22) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C11165g0(ua2, null), 3, null);
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C11167h0(ua22, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WF3 m9(WF3.b bVar, ChatViewModel chatViewModel) {
        AbstractC13042fc3.i(bVar, "$loadLiveStreamDataUseCaseFactory");
        AbstractC13042fc3.i(chatViewModel, "this$0");
        return bVar.a(AbstractC9773aX7.a(chatViewModel));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n5(C14683iJ6 c14683iJ6) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new F(c14683iJ6, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o8(ai.bale.proto.MessagingStruct$DocumentMessage r39, ir.nasim.J08 r40, ir.nasim.C8967Xz7 r41, ir.nasim.SA2 r42, ir.nasim.InterfaceC20295rm1 r43) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.o8(ai.bale.proto.MessagingStruct$DocumentMessage, ir.nasim.J08, ir.nasim.Xz7, ir.nasim.SA2, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object o9(int i, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.E0.a(this.z1.getPeerId()).c(i, 50, interfaceC20295rm1);
    }

    public static /* synthetic */ void oc(ChatViewModel chatViewModel, String str, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        chatViewModel.nc(str, num, num2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p8(Throwable th) {
        int i;
        if (th instanceof RpcException) {
            String str = ((RpcException) th).getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String();
            i = AbstractC13042fc3.d(str, "ErrLimitReached") ? DD5.error_voice_to_text_limit : AbstractC13042fc3.d(str, "ErrInvalidArgument") ? DD5.error_voice_to_text_format : DD5.error_unknown;
        } else {
            i = DD5.error_unknown;
        }
        oc(this, null, Integer.valueOf(i), Integer.valueOf(AbstractC15208jB5.icon_danger_circle), 1, null);
    }

    private final void pc() {
        Object value;
        JQ0 jq0;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g1;
        do {
            value = interfaceC9336Zm4.getValue();
            jq0 = (JQ0) value;
        } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : AbstractC4616Fw7.a(null, Integer.valueOf(DD5.snack_bar_magazine_vote)), (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C9616aG3 q9(ChatViewModel chatViewModel, InterfaceC10210bG3 interfaceC10210bG3) {
        DB3 db3H0;
        C6305Na3 c6305Na3U;
        AbstractC13042fc3.i(chatViewModel, "this$0");
        AbstractC13042fc3.i(interfaceC10210bG3, "$loadPollResultUseCase");
        C14733iO2 c14733iO2 = chatViewModel.L1;
        long j = 5000;
        if (c14733iO2 != null && (c6305Na3U = c14733iO2.u()) != null && ((Number) c6305Na3U.b()).intValue() >= 50) {
            Object objB = c6305Na3U.b();
            AbstractC13042fc3.h(objB, "get(...)");
            int iIntValue = ((Number) objB).intValue();
            j = (51 > iIntValue || iIntValue >= 1000) ? 15000L : 10000L;
        }
        InterfaceC20315ro1 interfaceC20315ro1A = AbstractC9773aX7.a(chatViewModel);
        if (!chatViewModel.H8() || (db3H0 = chatViewModel.v.F0()) == null) {
            db3H0 = chatViewModel.v.H0(chatViewModel.z1);
        }
        AbstractC13042fc3.f(db3H0);
        return interfaceC10210bG3.a(interfaceC20315ro1A, db3H0, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qc() {
        Object value;
        JQ0 jq0;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g1;
        do {
            value = interfaceC9336Zm4.getValue();
            jq0 = (JQ0) value;
        } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : AbstractC4616Fw7.a(null, Integer.valueOf(DD5.snack_bar_magazine_vote_first)), (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r8(Object obj, String str, String str2) {
        Object value;
        if (C9475a16.j(obj)) {
            C19406qI3.a("NewChatPrivacyBar", str, new Object[0]);
        } else {
            C19406qI3.c("NewChatPrivacyBar", str2, C9475a16.e(obj));
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.i1;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, InterfaceC4335Er5.d.a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s4(ChatViewModel chatViewModel, ProgressDialog progressDialog, C6833Pe1 c6833Pe1, long j, C4382Ew7 c4382Ew7) {
        AbstractC13042fc3.i(chatViewModel, "this$0");
        AbstractC13042fc3.i(progressDialog, "$progressDialog");
        AbstractC13042fc3.i(c6833Pe1, "$content");
        Object objA = c4382Ew7.a();
        AbstractC13042fc3.h(objA, "getT1(...)");
        if (!(((Object[]) objA).length == 0)) {
            C8054Ui1 c8054Ui1 = chatViewModel.h;
            Object objA2 = c4382Ew7.a();
            AbstractC13042fc3.h(objA2, "getT1(...)");
            c8054Ui1.U(((C21231tK7) AbstractC10242bK.b0((Object[]) objA2)).o()).a(new C11168i(c4382Ew7, progressDialog, c6833Pe1, chatViewModel, j));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object s6(Context context, String str, InterfaceC20295rm1 interfaceC20295rm1) {
        if (str == null) {
            return null;
        }
        C16963m96 c16963m96 = new C16963m96(AbstractC14251hc3.c(interfaceC20295rm1));
        com.bumptech.glide.b.t(context).d().Z0(str).S0(new Y(c16963m96)).f1();
        Object objA = c16963m96.a();
        if (objA == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objA;
    }

    private final ShareData s7() {
        return (ShareData) this.s1.getValue();
    }

    private final void s8(final J44 j44) {
        C5246In1 c5246In1;
        if (this.P1 || (c5246In1 = this.N1) == null) {
            return;
        }
        this.O1.r(c5246In1.g(), new InterfaceC14756iQ7() { // from class: ir.nasim.YQ0
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                ChatViewModel.t8(this.a, ((Long) obj).longValue(), abstractC13554gQ7);
            }
        });
        this.O1.r(c5246In1.o(), new InterfaceC14756iQ7() { // from class: ir.nasim.ZQ0
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                ChatViewModel.u8(j44, this, ((Integer) obj).intValue(), abstractC13554gQ7);
            }
        });
        int iV6 = V6();
        this.S1 = iV6;
        this.Y1.setValue(Integer.valueOf(iV6));
        long jU6 = U6();
        this.R1 = jU6;
        this.V1 = jU6;
        this.U1 = this.S1;
        this.A2.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t8(ChatViewModel chatViewModel, long j, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(chatViewModel, "this$0");
        chatViewModel.Q1 = j;
    }

    private final SearchStruct$MessageSearchResult t9(int i) {
        Object value;
        C25068zg6 c25068zg6;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.e2;
        do {
            value = interfaceC9336Zm4.getValue();
            c25068zg6 = (C25068zg6) value;
        } while (!interfaceC9336Zm4.f(value, c25068zg6.a((5885 & 1) != 0 ? c25068zg6.a : 0L, (5885 & 2) != 0 ? c25068zg6.b : null, (5885 & 4) != 0 ? c25068zg6.c : null, (5885 & 8) != 0 ? c25068zg6.d : null, (5885 & 16) != 0 ? c25068zg6.e : null, (5885 & 32) != 0 ? c25068zg6.f : null, (5885 & 64) != 0 ? c25068zg6.g : null, (5885 & 128) != 0 ? c25068zg6.h : 0, (5885 & 256) != 0 ? c25068zg6.i : null, (5885 & 512) != 0 ? c25068zg6.j : i, (5885 & 1024) != 0 ? c25068zg6.k : c25068zg6.d(), (5885 & 2048) != 0 ? c25068zg6.l : null, (5885 & 4096) != 0 ? c25068zg6.m : false)));
        InterfaceC3544Bh6 interfaceC3544Bh6 = (InterfaceC3544Bh6) AbstractC15401jX0.t0(((C25068zg6) this.e2.getValue()).i(), i);
        if (interfaceC3544Bh6 != null) {
            return interfaceC3544Bh6.getResult();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JQ0 ta(JQ0 jq0) {
        AbstractC13042fc3.i(jq0, "it");
        return jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long u4(ChatViewModel chatViewModel) {
        AbstractC13042fc3.i(chatViewModel, "this$0");
        return chatViewModel.d.g0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u5(final Context context, C13518gM7 c13518gM7, final List list) {
        C18226oI5.a aVar = C18226oI5.c;
        List listF1 = AbstractC15401jX0.f1(list, 3);
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listF1, 10));
        Iterator it = listF1.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((DH5) it.next()).e()));
        }
        List listT0 = AbstractC15401jX0.T0(aVar.a(context, c13518gM7, AbstractC15401jX0.r1(arrayList)).values());
        if (this.a1 == null) {
            this.a1 = new FU(context);
        }
        FU fu = this.a1;
        if (fu != null) {
            final int i = 0;
            for (Object obj : listT0) {
                int i2 = i + 1;
                if (i < 0) {
                    AbstractC10360bX0.w();
                }
                final C20610sI7 c20610sI7 = (C20610sI7) obj;
                final int i3 = i;
                fu.e(c20610sI7, (int) ((24 * AbstractC3742Cd6.c()) + 0.5d), new SA2() { // from class: ir.nasim.jR0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return ChatViewModel.v5(this.a, list, c20610sI7, i3, context);
                    }
                }, new UA2() { // from class: ir.nasim.kR0
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj2) {
                        return ChatViewModel.w5(this.a, i, (Drawable) obj2);
                    }
                });
                i = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u8(J44 j44, ChatViewModel chatViewModel, int i, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(chatViewModel, "this$0");
        if (j44 == null || j44.h() < chatViewModel.Q1) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = chatViewModel.Y1;
            interfaceC9336Zm4.setValue(Integer.valueOf(((Number) interfaceC9336Zm4.getValue()).intValue() + i));
            chatViewModel.A2.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String v4(ChatViewModel chatViewModel) {
        AbstractC13042fc3.i(chatViewModel, "this$0");
        return chatViewModel.d.i0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v5(ChatViewModel chatViewModel, List list, C20610sI7 c20610sI7, int i, Context context) {
        AbstractC13042fc3.i(chatViewModel, "this$0");
        AbstractC13042fc3.i(list, "$reactionListModels");
        AbstractC13042fc3.i(c20610sI7, "$userAvatar");
        AbstractC13042fc3.i(context, "$context");
        chatViewModel.T9(list, c20610sI7, i, context);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w5(ChatViewModel chatViewModel, int i, Drawable drawable) {
        AbstractC13042fc3.i(chatViewModel, "this$0");
        AbstractC13042fc3.i(drawable, "resource");
        chatViewModel.Ic(i, drawable);
        return C19938rB7.a;
    }

    private final InterfaceC13730gj3 w8() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new C11171j0(null), 2, null);
    }

    private final void w9() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new C11189s0(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x7(ChatViewModel chatViewModel, long j, final C7234Qv5 c7234Qv5) {
        AbstractC13042fc3.i(chatViewModel, "this$0");
        AbstractC13042fc3.i(c7234Qv5, "resolver");
        chatViewModel.v.V1(chatViewModel.z1, j, false).m0(new InterfaceC24449ye1() { // from class: ir.nasim.zR0
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ChatViewModel.y7(c7234Qv5, (C10872cL4) obj);
            }
        });
    }

    private final void x9() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C11191t0(null), 3, null);
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C11193u0(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JQ0 xa(JQ0 jq0) {
        AbstractC13042fc3.i(jq0, "it");
        return jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null);
    }

    private final void y4() {
        C21231tK7 c21231tK7 = this.M1;
        if (c21231tK7 != null) {
            this.O1.y(c21231tK7.w(), c21231tK7.r(), new InterfaceC16527lQ7() { // from class: ir.nasim.IR0
                @Override // ir.nasim.InterfaceC16527lQ7
                public final void a(Object obj, AbstractC13554gQ7 abstractC13554gQ7, Object obj2, AbstractC13554gQ7 abstractC13554gQ72) {
                    ChatViewModel.z4(this.a, (EnumC3633Br5) obj, abstractC13554gQ7, (String) obj2, abstractC13554gQ72);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y5(final ChatViewModel chatViewModel, C14505i18 c14505i18) {
        AbstractC13042fc3.i(chatViewModel, "this$0");
        InterfaceC8344Vo3 interfaceC8344Vo3P0 = chatViewModel.g.p0();
        List listC6 = chatViewModel.C6();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listC6, 10));
        Iterator it = listC6.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((Number) it.next()).intValue()));
        }
        interfaceC8344Vo3P0.g(arrayList).m0(new InterfaceC24449ye1() { // from class: ir.nasim.AR0
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ChatViewModel.z5(this.a, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y7(C7234Qv5 c7234Qv5, C10872cL4 c10872cL4) {
        AbstractC13042fc3.i(c7234Qv5, "$resolver");
        c7234Qv5.b(c10872cL4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String y8(androidx.lifecycle.y yVar) {
        AbstractC13042fc3.i(yVar, "$savedStateHandle");
        return (String) yVar.c("INVITE_LINK");
    }

    private final void y9() {
        boolean z = this.A1 == ExPeerType.BOT;
        boolean z2 = this.z1.getPeerId() == this.G;
        if (z2) {
            C19406qI3.a("NewChatPrivacyBar", "Observing PrivacyBar was ignored! isSavedMessage= " + z2, new Object[0]);
            return;
        }
        if (z) {
            y4();
            return;
        }
        int i = C11155d.b[this.z1.s().ordinal()];
        if (i == 1) {
            A4();
        } else {
            if (i != 2 && i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            C4();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z4(ChatViewModel chatViewModel, EnumC3633Br5 enumC3633Br5, AbstractC13554gQ7 abstractC13554gQ7, String str, AbstractC13554gQ7 abstractC13554gQ72) {
        Object value;
        Object value2;
        Object value3;
        AbstractC13042fc3.i(chatViewModel, "this$0");
        int i = enumC3633Br5 == null ? -1 : C11155d.c[enumC3633Br5.ordinal()];
        if (i != -1) {
            if (i == 1) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = chatViewModel.i1;
                do {
                    value = interfaceC9336Zm4.getValue();
                    AbstractC13042fc3.f(str);
                } while (!interfaceC9336Zm4.f(value, new InterfaceC4335Er5.a(str)));
                return;
            }
            if (i == 2) {
                InterfaceC9336Zm4 interfaceC9336Zm42 = chatViewModel.i1;
                do {
                    value2 = interfaceC9336Zm42.getValue();
                } while (!interfaceC9336Zm42.f(value2, InterfaceC4335Er5.d.a));
                return;
            }
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            InterfaceC9336Zm4 interfaceC9336Zm43 = chatViewModel.i1;
            do {
                value3 = interfaceC9336Zm43.getValue();
            } while (!interfaceC9336Zm43.f(value3, InterfaceC4335Er5.f.a));
            C19406qI3.k("NewChatPrivacyBar", "Receive " + enumC3633Br5 + " value for privacyBar mode", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z5(ChatViewModel chatViewModel, List list) {
        AbstractC13042fc3.i(chatViewModel, "this$0");
        AbstractC10533bm0.d(AbstractC9773aX7.a(chatViewModel), null, null, new I(list, chatViewModel, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List z8(androidx.lifecycle.y yVar) {
        List listD1;
        AbstractC13042fc3.i(yVar, "$savedStateHandle");
        int[] iArr = (int[]) yVar.c("INVITE_PEERS");
        return (iArr == null || (listD1 = AbstractC10242bK.d1(iArr)) == null) ? AbstractC10242bK.d1(new int[0]) : listD1;
    }

    private final void z9() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C11195v0(null), 3, null);
    }

    public static /* synthetic */ void zb(ChatViewModel chatViewModel, int i, int i2, String str, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 16) != 0) {
            i4 = F17.b.j();
        }
        chatViewModel.yb(i, i2, str, i3, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC10258bL6 zc(ChatViewModel chatViewModel) {
        C19482qQ7 c19482qQ7L;
        InterfaceC4557Fq2 interfaceC4557Fq2A;
        InterfaceC4557Fq2 interfaceC4557Fq2X;
        InterfaceC4557Fq2 interfaceC4557Fq2F;
        AbstractC13042fc3.i(chatViewModel, "this$0");
        C5246In1 c5246In1 = chatViewModel.N1;
        if (c5246In1 == null || (c19482qQ7L = c5246In1.l()) == null) {
            return null;
        }
        if (!C8386Vt0.U5() || chatViewModel.A1 != ExPeerType.GROUP) {
            c19482qQ7L = null;
        }
        if (c19482qQ7L == null || (interfaceC4557Fq2A = AbstractC23145wQ7.a(c19482qQ7L)) == null || (interfaceC4557Fq2X = AbstractC6459Nq2.x(interfaceC4557Fq2A, new UA2() { // from class: ir.nasim.vR0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return Long.valueOf(ChatViewModel.Ac((List) obj));
            }
        })) == null || (interfaceC4557Fq2F = AbstractC6459Nq2.F(interfaceC4557Fq2X)) == null) {
            return null;
        }
        return AbstractC6459Nq2.o0(interfaceC4557Fq2F, AbstractC9773aX7.a(chatViewModel), InterfaceC16863lz6.a.d(), AbstractC10360bX0.m());
    }

    public final InterfaceC13730gj3 A5() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new J(null), 3, null);
    }

    public final String A6() {
        return (String) this.E1.getValue();
    }

    public final String A7() {
        return this.d.s4();
    }

    public final void A8(String str) {
        AbstractC13042fc3.i(str, ParameterNames.TEXT);
        Iterable iterable = (Iterable) this.Z1.getValue();
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            if (((BI7) obj).h()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new C11458d25(W25.a, ((BI7) it.next()).d()));
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            this.v.A2((C11458d25) it2.next(), str, null, true, i6());
        }
    }

    public final void A9(C11458d25 c11458d25) {
        this.v.P1(c11458d25);
    }

    public final void Aa(long j, long j2) {
        C8512Wh0 c8512Wh0F;
        C14733iO2 c14733iO2 = this.L1;
        if (!((c14733iO2 == null || (c8512Wh0F = c14733iO2.F()) == null) ? false : AbstractC13042fc3.d(c8512Wh0F.b(), Boolean.FALSE))) {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new Q0(j, j2, null), 2, null);
        } else {
            Ca();
            AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new P0(j, j2, null), 2, null);
        }
    }

    public final void Ab(C11458d25 c11458d25, String str, ArrayList arrayList, boolean z, C7880To7 c7880To7) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(str, ParameterNames.TEXT);
        this.v.A2(c11458d25, str, arrayList, z, c7880To7);
    }

    public final InterfaceC10258bL6 B6() {
        return this.a2;
    }

    public final int B7() {
        return this.U1;
    }

    public final boolean B8() {
        return this.d.f5(this.z1.getPeerId());
    }

    public final void B9(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        this.D.f(new C17483n25(c11458d25));
    }

    public final void Bb(long j, Long l, boolean z) {
        this.F0.a("video_compress", new FS7(this.z1, j, l, this.A1, z).a());
    }

    public final void C5() {
        AbstractC10533bm0.d(this.V0, this.b, null, new M(null), 2, null);
    }

    public final List C6() {
        return (List) this.F1.getValue();
    }

    public final InterfaceC10258bL6 C7() {
        return this.h1;
    }

    public final boolean C8(J44 j44) {
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        j44.F();
        return j44.g0();
    }

    public final void C9(C11458d25 c11458d25, ExPeerType exPeerType) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        this.D.f(new C18074o25(c11458d25, exPeerType));
        C19406qI3.a("PushHandler", "onPushReceived from onConversationOpened", new Object[0]);
        this.e.I(GE4.a(c11458d25));
    }

    public final void Cb(S08 s08) {
        AbstractC13042fc3.i(s08, "voiceRecorderEvents");
        this.F0.a(s08.b(), s08.a());
    }

    public final C21167tD6 D7() {
        return this.A2;
    }

    public final void D9() {
        Map mapT = this.d.T();
        if (mapT.get("tooltip_interacted_channels") != null) {
            List list = (List) mapT.get("tooltip_interacted_channels");
            if (list != null) {
                list.add(Integer.valueOf(this.z1.getPeerId()));
            }
        } else {
            mapT.put("tooltip_interacted_channels", AbstractC10360bX0.s(Integer.valueOf(this.z1.getPeerId())));
        }
        this.d.a6(mapT);
    }

    public final void Da(C11458d25 c11458d25, String str) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_DRAFT);
        this.v.l2(c11458d25, str);
    }

    public final InterfaceC13730gj3 Db(long j, long j2, int i) {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new l1(j, j2, i, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:148:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x01fe A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0132 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Dc(int r23, java.util.TreeSet r24, boolean r25, final boolean r26) {
        /*
            Method dump skipped, instructions count: 641
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.Dc(int, java.util.TreeSet, boolean, boolean):void");
    }

    public final InterfaceC10258bL6 E7() {
        return (InterfaceC10258bL6) this.H2.getValue();
    }

    public final boolean E8() {
        return this.z1.u() == 42;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E9() {
        /*
            r10 = this;
            ir.nasim.core.modules.profile.entity.ExPeerType r0 = r10.A1
            ir.nasim.core.modules.profile.entity.ExPeerType r1 = ir.nasim.core.modules.profile.entity.ExPeerType.CHANNEL
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L22
            ir.nasim.iO2 r0 = r10.L1
            if (r0 == 0) goto L1d
            ir.nasim.Wh0 r0 = r0.n()
            if (r0 == 0) goto L1d
            java.lang.Object r0 = r0.b()
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r0 = ir.nasim.AbstractC13042fc3.d(r0, r1)
            goto L1e
        L1d:
            r0 = r3
        L1e:
            if (r0 == 0) goto L22
            r0 = r2
            goto L23
        L22:
            r0 = r3
        L23:
            if (r0 == 0) goto L30
            ir.nasim.tZ0 r0 = r10.K0
            ir.nasim.d25 r1 = r10.z1
            int r1 = r1.getPeerId()
            r0.d(r1)
        L30:
            ir.nasim.ro1 r4 = r10.V0
            ir.nasim.chat.ChatViewModel$x0 r7 = new ir.nasim.chat.ChatViewModel$x0
            r0 = 0
            r7.<init>(r0)
            r8 = 3
            r9 = 0
            r5 = 0
            r6 = 0
            ir.nasim.AbstractC9323Zl0.d(r4, r5, r6, r7, r8, r9)
            r10.P1 = r2
            ir.nasim.sp4 r1 = r10.O1
            r1.d0()
            ir.nasim.E84 r1 = r10.v
            ir.nasim.d25 r2 = r10.z1
            r1.v0(r2)
            ir.nasim.F84 r4 = r10.m
            ir.nasim.iO2 r1 = r10.L1
            if (r1 == 0) goto L61
            ir.nasim.qQ7 r1 = r1.o()
            if (r1 == 0) goto L61
            java.lang.Object r1 = r1.b()
            java.lang.Integer r1 = (java.lang.Integer) r1
            r5 = r1
            goto L62
        L61:
            r5 = r0
        L62:
            long r6 = r10.x2
            long r8 = r10.y2
            r4.x(r5, r6, r8)
            ir.nasim.d25 r1 = r10.z1
            boolean r1 = r1.z()
            if (r1 == 0) goto L99
            boolean r1 = r10.o1
            if (r1 != 0) goto L99
            ir.nasim.iO2 r1 = r10.L1
            if (r1 == 0) goto L89
            ir.nasim.Wh0 r1 = r1.F()
            if (r1 == 0) goto L89
            java.lang.Object r1 = r1.b()
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            boolean r3 = ir.nasim.AbstractC13042fc3.d(r1, r2)
        L89:
            if (r3 == 0) goto L99
            ir.nasim.mJ2 r4 = ir.nasim.C17050mJ2.a
            ir.nasim.chat.ChatViewModel$y0 r7 = new ir.nasim.chat.ChatViewModel$y0
            r7.<init>(r0)
            r8 = 3
            r9 = 0
            r5 = 0
            r6 = 0
            ir.nasim.AbstractC9323Zl0.d(r4, r5, r6, r7, r8, r9)
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.E9():void");
    }

    public final void Ea(C11458d25 c11458d25, J44 j44, int i) {
        if (j44 == null || H8()) {
            return;
        }
        this.v.g0(c11458d25, j44.i(), j44.W(), i, H8());
    }

    public final InterfaceC13730gj3 F4() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C11174l(null), 3, null);
    }

    public final J44 F5(J44 j44) {
        AbstractC13042fc3.i(j44, "album");
        AbstractC17457n0 abstractC17457n0F = j44.F();
        AbstractC13042fc3.g(abstractC17457n0F, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.AlbumContent");
        List listR = ((C11907dl) abstractC17457n0F).r();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (Object obj : listR) {
            int i4 = i2 + 1;
            if (i2 < 0) {
                AbstractC10360bX0.w();
            }
            C23345wl7 c23345wl7L = ((J44) obj).F().l();
            String strV = c23345wl7L != null ? c23345wl7L.v() : null;
            if (strV != null && strV.length() != 0) {
                i3++;
                if (i3 > 1) {
                    return null;
                }
                i = i2;
            }
            i2 = i4;
        }
        return (J44) listR.get(i);
    }

    public final int F6() {
        return this.d.K2();
    }

    public final InterfaceC10258bL6 F7() {
        return (InterfaceC10258bL6) this.I2.getValue();
    }

    public final boolean F8() {
        return this.d.p1();
    }

    public final void F9() {
        this.h.p0();
    }

    public final void Fa(J44 j44, int i) {
        J44 j442;
        C19482qQ7 c19482qQ7O;
        Integer num;
        if (j44 == null) {
            return;
        }
        C14733iO2 c14733iO2 = this.L1;
        int iIntValue = (c14733iO2 == null || (c19482qQ7O = c14733iO2.o()) == null || (num = (Integer) c19482qQ7O.b()) == null) ? 0 : num.intValue();
        boolean zS9 = s9(j44);
        DB3 db3H0 = this.v.H0(C11458d25.y(iIntValue));
        J44 j443 = (J44) db3H0.a(this.m.o().c());
        if (j443 != null) {
            C17532n74 c17532n74T = j443.T();
            if (c17532n74T == null) {
                c17532n74T = new C17532n74(0, null, null, null, null, null, false, 0L, 0, 511, null);
            }
            C17532n74 c17532n74 = c17532n74T;
            C7880To7 c7880To7 = !zS9 ? new C7880To7(j44.i(), j44.h(), null, 4, null) : c17532n74.z();
            int iC = !zS9 ? i : c17532n74.C();
            long jH = c17532n74.w().h();
            DB3 db3F0 = this.v.F0();
            db3H0.d(J44.D(j443, 0L, 0L, 0L, 0, null, null, null, 0, null, null, 0L, null, null, false, null, false, c17532n74.q((504 & 1) != 0 ? c17532n74.a : 0, (504 & 2) != 0 ? c17532n74.b : null, (504 & 4) != 0 ? c17532n74.c : null, (504 & 8) != 0 ? c17532n74.d : c7880To7, (504 & 16) != 0 ? c17532n74.e : null, (504 & 32) != 0 ? c17532n74.f : null, (504 & 64) != 0 ? c17532n74.g : false, (504 & 128) != 0 ? c17532n74.h : Math.max(jH, (db3F0 == null || (j442 = (J44) db3F0.r()) == null) ? 0L : j442.h()), (504 & 256) != 0 ? c17532n74.i : iC), null, 196607, null));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object G4(int r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ir.nasim.chat.ChatViewModel.C11176m
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.chat.ChatViewModel$m r0 = (ir.nasim.chat.ChatViewModel.C11176m) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.chat.ChatViewModel$m r0 = new ir.nasim.chat.ChatViewModel$m
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
            java.lang.Object r5 = r6.l()
            goto L4a
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.OK7 r6 = r4.g
            ir.nasim.Nv5 r5 = r6.U(r5)
            r0.c = r3
            r6 = 0
            java.lang.Object r5 = ir.nasim.AbstractC6756Ov5.d(r5, r6, r0, r3, r6)
            if (r5 != r1) goto L4a
            return r1
        L4a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.G4(int, ir.nasim.rm1):java.lang.Object");
    }

    public final void G5(C16885m18 c16885m18, long j) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.a(), null, new Q(j, c16885m18, null), 2, null);
    }

    public final long G6() {
        return this.Q1;
    }

    public final InterfaceC10258bL6 G7() {
        return (InterfaceC10258bL6) this.F2.getValue();
    }

    public final boolean G8() {
        return this.z1.u() == 41 && C8386Vt0.a.v5();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void G9(ir.nasim.C22149uk7 r26, long r27, long r29) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.G9(ir.nasim.uk7, long, long):void");
    }

    public final void Ga(List list, C11458d25 c11458d25) {
        AbstractC13042fc3.i(list, "messages");
        AbstractC13042fc3.i(c11458d25, "fromPeer");
        if (list.isEmpty()) {
            return;
        }
        C11458d25 c11458d25E = C11458d25.E(this.G);
        AbstractC13042fc3.h(c11458d25E, "user(...)");
        AbstractC10533bm0.d(C17050mJ2.a, this.b, null, new R0(list, this, c11458d25E, c11458d25, null), 2, null);
    }

    public final void H5() {
        Object value;
        JQ0 jq0;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g1;
        do {
            value = interfaceC9336Zm4.getValue();
            jq0 = (JQ0) value;
        } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object H6(java.lang.String r26, ir.nasim.InterfaceC20295rm1 r27) {
        /*
            r25 = this;
            r0 = r25
            r1 = r27
            boolean r2 = r1 instanceof ir.nasim.chat.ChatViewModel.Z
            if (r2 == 0) goto L17
            r2 = r1
            ir.nasim.chat.ChatViewModel$Z r2 = (ir.nasim.chat.ChatViewModel.Z) r2
            int r3 = r2.d
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.d = r3
            goto L1c
        L17:
            ir.nasim.chat.ChatViewModel$Z r2 = new ir.nasim.chat.ChatViewModel$Z
            r2.<init>(r1)
        L1c:
            java.lang.Object r1 = r2.b
            java.lang.Object r3 = ir.nasim.AbstractC13660gc3.e()
            int r4 = r2.d
            r5 = 1
            if (r4 == 0) goto L3f
            if (r4 != r5) goto L37
            java.lang.Object r2 = r2.a
            ir.nasim.chat.ChatViewModel r2 = (ir.nasim.chat.ChatViewModel) r2
            ir.nasim.AbstractC10685c16.b(r1)
            ir.nasim.a16 r1 = (ir.nasim.C9475a16) r1
            java.lang.Object r1 = r1.l()
            goto L52
        L37:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L3f:
            ir.nasim.AbstractC10685c16.b(r1)
            ir.nasim.xF2 r1 = r0.I0
            r2.a = r0
            r2.d = r5
            r4 = r26
            java.lang.Object r1 = r1.b(r4, r2)
            if (r1 != r3) goto L51
            return r3
        L51:
            r2 = r0
        L52:
            java.lang.Throwable r3 = ir.nasim.C9475a16.e(r1)
            if (r3 == 0) goto L92
            ir.nasim.Zm4 r2 = r2.g1
        L5a:
            java.lang.Object r3 = r2.getValue()
            r4 = r3
            ir.nasim.JQ0 r4 = (ir.nasim.JQ0) r4
            int r5 = ir.nasim.DD5.toast_invalid_call_link
            java.lang.Integer r5 = ir.nasim.AbstractC6392Nk0.d(r5)
            r6 = 0
            ir.nasim.XV4 r5 = ir.nasim.AbstractC4616Fw7.a(r6, r5)
            r23 = 262142(0x3fffe, float:3.67339E-40)
            r24 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            ir.nasim.JQ0 r4 = ir.nasim.JQ0.b(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            boolean r3 = r2.f(r3, r4)
            if (r3 == 0) goto L5a
        L92:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.H6(java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    public final C19482qQ7 H7(int i) {
        C19482qQ7 c19482qQ7A = this.Y.B(i).a();
        AbstractC13042fc3.h(c19482qQ7A, "getActive(...)");
        return c19482qQ7A;
    }

    public final InterfaceC13730gj3 H9(C8967Xz7 c8967Xz7, EnumC9477a18 enumC9477a18, String str) {
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(enumC9477a18, "voiceTranscriptState");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C11203z0(c8967Xz7, this, enumC9477a18, str, null), 3, null);
    }

    public final void Ha() {
        if (!this.s2) {
            this.s2 = true;
        }
        P4(H8());
    }

    public final void Hb(boolean z) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new m1(z, null), 3, null);
    }

    public final String I5(int i) {
        C24411ya3 c24411ya3 = (C24411ya3) this.d.S().get("low_member_range");
        return (c24411ya3 == null || !c24411ya3.B(i)) ? this.d.Z() : this.d.Y();
    }

    public final void I6(String str) {
        AbstractC13042fc3.i(str, "link");
        this.O2 = AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C11147a0(str, null), 3, null);
    }

    public final C21231tK7 I7(long j) {
        return (C21231tK7) this.g.o0().n(j);
    }

    public final void I9(Context context) {
        AbstractC13042fc3.i(context, "context");
        try {
            C9475a16.a aVar = C9475a16.b;
            AbstractC7426Rr.a.A(context, Uri.parse(this.d.O4()));
            C9475a16.b(C19938rB7.a);
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            C9475a16.b(AbstractC10685c16.a(th));
        }
    }

    public final void Ia(Long l) {
        Object value;
        C25068zg6 c25068zg6;
        this.b1 = "calendar";
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.e2;
        do {
            value = interfaceC9336Zm4.getValue();
            c25068zg6 = (C25068zg6) value;
        } while (!interfaceC9336Zm4.f(value, c25068zg6.a((5885 & 1) != 0 ? c25068zg6.a : 0L, (5885 & 2) != 0 ? c25068zg6.b : null, (5885 & 4) != 0 ? c25068zg6.c : EnumC16752lo2.b, (5885 & 8) != 0 ? c25068zg6.d : null, (5885 & 16) != 0 ? c25068zg6.e : null, (5885 & 32) != 0 ? c25068zg6.f : l, (5885 & 64) != 0 ? c25068zg6.g : null, (5885 & 128) != 0 ? c25068zg6.h : 0, (5885 & 256) != 0 ? c25068zg6.i : null, (5885 & 512) != 0 ? c25068zg6.j : 0, (5885 & 1024) != 0 ? c25068zg6.k : 0, (5885 & 2048) != 0 ? c25068zg6.l : null, (5885 & 4096) != 0 ? c25068zg6.m : false)));
    }

    public final C6517Nv5 J4(C11458d25 c11458d25, long j, long j2) {
        AbstractC13042fc3.i(c11458d25, "peer");
        this.p2 = true;
        C6517Nv5 c6517Nv5W1 = this.v.W1(c11458d25, Long.valueOf(j), Long.valueOf(j2), F84.l.a(), this.m.o());
        AbstractC13042fc3.h(c6517Nv5W1, "openCommentHistory(...)");
        return c6517Nv5W1;
    }

    public final int J5() {
        return this.d.c0();
    }

    public final List J6() {
        List listN0 = AbstractC20762sZ6.N0(this.d.R2(), new String[]{","}, false, 0, 6, null);
        ArrayList arrayList = new ArrayList();
        Iterator it = listN0.iterator();
        while (it.hasNext()) {
            Long lQ = AbstractC19562qZ6.q((String) it.next());
            if (lQ != null) {
                arrayList.add(lQ);
            }
        }
        return arrayList;
    }

    public final C13518gM7 J7() {
        return (C13518gM7) this.P2.getValue();
    }

    public final boolean J8() {
        return this.x.h("AVATAR_REACTION_ENABLE", false);
    }

    public final void J9(long j, long j2, int i, int i2) {
        if (!this.v.p0() || this.c1) {
            return;
        }
        AbstractC10533bm0.d(C17050mJ2.a, C12366eV1.c(), null, new A0(j, j2, i, i2, null), 2, null);
    }

    public final boolean K4(int i, ExPeerType exPeerType, Boolean bool) {
        return exPeerType == ExPeerType.GROUP && C8386Vt0.a.S6() && this.d.q2() >= i && i != 0 && AbstractC13042fc3.d(bool, Boolean.TRUE);
    }

    public final long K5() {
        return ((Number) this.J1.getValue()).longValue();
    }

    public final boolean K8() {
        return this.z0.h("PREFERENCES_KEY_FULL_SCREEN_INTENT_DIALOG_SHOWN", false);
    }

    public final C6517Nv5 K9(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        C6517Nv5 c6517Nv5D2 = this.v.d2(c11458d25, H8());
        AbstractC13042fc3.h(c6517Nv5D2, "openHistory(...)");
        return c6517Nv5D2;
    }

    public final InterfaceC13730gj3 Ka(long j, String str, List list, int i) {
        AbstractC13042fc3.i(str, "question");
        AbstractC13042fc3.i(list, "answers");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new T0(list, str, i, j, null), 2, null);
    }

    public final void Kb(HQ0 hq0) {
        AbstractC13042fc3.i(hq0, "<set-?>");
        this.u1 = hq0;
    }

    public final void Kc(J44 j44) {
        AbstractC13042fc3.i(j44, "newMessage");
        this.v.H0(this.z1).d(j44);
    }

    @Override // ir.nasim.VW7
    protected void L0() {
        E9();
        FU fu = this.a1;
        if (fu != null) {
            fu.d();
        }
        this.a1 = null;
        AbstractC10533bm0.d(C17050mJ2.a, this.b, null, new C11197w0(null), 2, null);
        super.L0();
    }

    public final void L4() {
        InterfaceC13730gj3 interfaceC13730gj3 = this.O2;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
    }

    public final String L5() {
        return (String) this.K1.getValue();
    }

    public final C6517Nv5 L7(final C19024pf0 c19024pf0) {
        AbstractC13042fc3.i(c19024pf0, "displayList");
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.bR0
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                ChatViewModel.M7(this.a, c19024pf0, c7234Qv5);
            }
        });
    }

    public final boolean L8() {
        return this.d.s2();
    }

    public final C6517Nv5 L9(C11458d25 c11458d25, long j, long j2, int i) {
        AbstractC13042fc3.i(c11458d25, "peer");
        C6517Nv5 c6517Nv5Z1 = this.v.Z1(c11458d25, j, j2, i);
        AbstractC13042fc3.h(c6517Nv5Z1, "openHistory(...)");
        return c6517Nv5Z1;
    }

    public final void La() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new U0(null), 2, null);
    }

    public final void Lb(long j) {
        this.y2 = j;
    }

    public final void M4(C11458d25 c11458d25, boolean z) {
        AbstractC13042fc3.i(c11458d25, "peer");
        this.d.P(c11458d25, z);
    }

    public final AttachmentData M5() {
        String strO3 = C5495Jo7.a.J2() ? C8386Vt0.a.O6() ? this.d.o3() : this.d.w0() : C8386Vt0.a.O6() ? this.d.n3() : this.d.v0();
        Object objL = new KS2().l(this.d.x0(), new TypeToken<List<? extends String>>() { // from class: ir.nasim.chat.ChatViewModel$attachmentData$badgeListType$1
        }.d());
        AbstractC13042fc3.h(objL, "fromJson(...)");
        List list = (List) objL;
        AttachmentData attachmentData = (AttachmentData) new KS2().k(strO3, AttachmentData.class);
        int iA3 = this.d.A3();
        for (ShareAttachment shareAttachment : attachmentData.getShareAttachments()) {
            if (list.contains(shareAttachment.getTag())) {
                shareAttachment.setShowBadge(Boolean.valueOf(iA3 > -1));
            }
        }
        if (!C8386Vt0.f9() || H8() || !AbstractC10360bX0.p(ExPeerType.GROUP, ExPeerType.CHANNEL).contains(this.A1)) {
            AbstractC13610gX0.K(attachmentData.getShareAttachments(), new UA2() { // from class: ir.nasim.hR0
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(ChatViewModel.g2((ShareAttachment) obj));
                }
            });
        }
        AbstractC13042fc3.f(attachmentData);
        return attachmentData;
    }

    public final long M6() {
        return (long) this.d.h3();
    }

    public final boolean M8() {
        return this.C2;
    }

    public final void M9(long j, long j2, boolean z, InterfaceC21893uJ4 interfaceC21893uJ4) {
        if (this.q2 != j2 || z) {
            this.v.a2(this.z1, j, j2, interfaceC21893uJ4, H8()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.cR0
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    ChatViewModel.P9(this.a, (C10872cL4) obj);
                }
            });
        }
    }

    public final void Mb(long j) {
        this.x2 = j;
    }

    public final void Mc(boolean z) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.e2;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, new C25068zg6(0L, z ? EnumC21528th6.b : EnumC21528th6.a, null, this.d2, null, null, null, 0, null, 0, 0, null, false, 8181, null)));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void N4(boolean r26) {
        /*
            r25 = this;
            r0 = r25
            ir.nasim.Zm4 r1 = r0.g1
        L4:
            java.lang.Object r2 = r1.getValue()
            r24 = r2
            ir.nasim.JQ0 r24 = (ir.nasim.JQ0) r24
            ir.nasim.WO5 r3 = r24.n()
            if (r3 == 0) goto L4d
            if (r26 == 0) goto L20
            ir.nasim.WO5$b r4 = new ir.nasim.WO5$b
            java.util.List r3 = r3.a()
            r4.<init>(r3)
        L1d:
            r16 = r4
            goto L2a
        L20:
            ir.nasim.WO5$a r4 = new ir.nasim.WO5$a
            java.util.List r3 = r3.a()
            r4.<init>(r3)
            goto L1d
        L2a:
            r22 = 258047(0x3efff, float:3.61601E-40)
            r23 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r3 = r24
            ir.nasim.JQ0 r3 = ir.nasim.JQ0.b(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            if (r3 != 0) goto L4f
        L4d:
            r3 = r24
        L4f:
            boolean r2 = r1.f(r2, r3)
            if (r2 == 0) goto L4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.N4(boolean):void");
    }

    public final InterfaceC10258bL6 N5() {
        return this.m1;
    }

    public final boolean N8() {
        return this.z1.u() == 1108996041 && C8386Vt0.a.m7();
    }

    public final void N9(boolean z, InterfaceC21893uJ4 interfaceC21893uJ4) {
        if (!this.p2 || z) {
            this.v.c2(this.z1, interfaceC21893uJ4, H8()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.iR0
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    ChatViewModel.O9(this.a, (C10872cL4) obj);
                }
            });
        }
    }

    public final void Na(int i) {
        Object next;
        Object value;
        Iterator it = ((Iterable) this.Z1.getValue()).iterator();
        while (true) {
            if (it.hasNext()) {
                next = it.next();
                if (((BI7) next).d() == i) {
                    break;
                }
            } else {
                next = null;
                break;
            }
        }
        BI7 bi7 = (BI7) next;
        if (bi7 != null) {
            boolean zH = bi7.h();
            List<BI7> listP1 = AbstractC15401jX0.p1((Collection) this.Z1.getValue());
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listP1, 10));
            for (BI7 bi7B : listP1) {
                if (bi7B.d() == i) {
                    bi7B = BI7.b(bi7B, 0, null, null, !zH, null, false, 55, null);
                }
                arrayList.add(bi7B);
            }
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.Z1;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, arrayList));
        }
    }

    public final InterfaceC13730gj3 Nb() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new p1(null), 3, null);
    }

    public final void Nc(UA2 ua2) {
        Object value;
        AbstractC13042fc3.i(ua2, "update");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g1;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, (JQ0) ua2.invoke((JQ0) value)));
    }

    public final void O4(boolean z) {
        this.r2 = z;
        P4(H8());
    }

    public final InterfaceC10258bL6 O5() {
        return AbstractC6459Nq2.c(K7());
    }

    public final E84 O6() {
        return this.v;
    }

    public final Boolean O8() {
        return this.C1;
    }

    public final void Ob(boolean z) {
        this.p2 = z;
    }

    public final void Oc(SA2 sa2, UA2 ua2, UA2 ua22) {
        AbstractC13042fc3.i(sa2, "navigateToCreatePass");
        AbstractC13042fc3.i(ua2, "navigateToValidatePass");
        AbstractC13042fc3.i(ua22, "registerNavigateResult");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new D1(sa2, ua2, ua22, null), 3, null);
    }

    public final void P5(Context context, long j, long j2) {
        Object value;
        ArrayList arrayList;
        AbstractC13042fc3.i(context, "context");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.j2;
        do {
            value = interfaceC9336Zm4.getValue();
            arrayList = new ArrayList(3);
            for (int i = 0; i < 3; i++) {
                arrayList.add(null);
            }
        } while (!interfaceC9336Zm4.f(value, arrayList));
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new R(j, j2, context, null), 3, null);
    }

    public final InterfaceC4557Fq2 P6() {
        return this.A.f();
    }

    public final C6517Nv5 P7(final C19024pf0 c19024pf0, final boolean z) {
        AbstractC13042fc3.i(c19024pf0, "displayList");
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.dR0
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                ChatViewModel.R7(this.a, z, c19024pf0, c7234Qv5);
            }
        });
    }

    public final boolean P8() {
        C6305Na3 c6305Na3U;
        Integer num;
        C14733iO2 c14733iO2 = this.L1;
        return ((c14733iO2 == null || (c6305Na3U = c14733iO2.u()) == null || (num = (Integer) c6305Na3U.b()) == null) ? Integer.MAX_VALUE : num.intValue()) <= this.d.g3();
    }

    public final void Pa(InterfaceC22848vv0 interfaceC22848vv0, long j) {
        AbstractC13042fc3.i(interfaceC22848vv0, "eventType");
        this.w.d("call_link_click", AbstractC20051rO3.p(AbstractC4616Fw7.a("action_type", Integer.valueOf(interfaceC22848vv0.a())), AbstractC4616Fw7.a("call_id", Long.valueOf(j))));
    }

    public final void Pb(long j) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.b2;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Number) value).longValue();
        } while (!interfaceC9336Zm4.f(value, Long.valueOf(j)));
    }

    public final void Pc(SA2 sa2, UA2 ua2, SA2 sa22) {
        AbstractC13042fc3.i(sa2, "navigateToCreatePass");
        AbstractC13042fc3.i(ua2, "navigateToValidatePass");
        AbstractC13042fc3.i(sa22, "registerNavigateResult");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new E1(sa2, ua2, sa22, null), 3, null);
    }

    public final InterfaceC13730gj3 Q5(Context context, long j, long j2) {
        AbstractC13042fc3.i(context, "context");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new S(j, j2, context, null), 3, null);
    }

    public final String Q6() {
        return (String) this.J.B().b();
    }

    public final boolean Q8(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        return this.d.H5(c11458d25);
    }

    public final void Q9() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new B0(null), 2, null);
    }

    public final void Qa(String str, List list, List list2, byte[] bArr, Long l, Long l2) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(list, "phones");
        AbstractC13042fc3.i(list2, "emails");
        this.v.r2(this.z1, str, new ArrayList(list), new ArrayList(list2), bArr != null ? Base64.encodeToString(bArr, 0) : null, l, l2, i6());
    }

    public final void Qb(boolean z) {
        this.z0.g("PREFERENCES_KEY_FULL_SCREEN_INTENT_DIALOG_SHOWN", z);
    }

    public final InterfaceC10258bL6 R5() {
        return this.k2;
    }

    public final long R6() {
        return this.V1;
    }

    public final boolean R8() {
        return this.z1.u() == 270066638;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object R9(int r10, ir.nasim.J44 r11, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof ir.nasim.chat.ChatViewModel.C0
            if (r0 == 0) goto L14
            r0 = r12
            ir.nasim.chat.ChatViewModel$C0 r0 = (ir.nasim.chat.ChatViewModel.C0) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.e = r1
        L12:
            r8 = r0
            goto L1a
        L14:
            ir.nasim.chat.ChatViewModel$C0 r0 = new ir.nasim.chat.ChatViewModel$C0
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r12 = r8.c
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r8.e
            r2 = 1
            if (r1 == 0) goto L42
            if (r1 != r2) goto L3a
            java.lang.Object r10 = r8.b
            r11 = r10
            ir.nasim.J44 r11 = (ir.nasim.J44) r11
            java.lang.Object r10 = r8.a
            ir.nasim.chat.ChatViewModel r10 = (ir.nasim.chat.ChatViewModel) r10
            ir.nasim.AbstractC10685c16.b(r12)
            ir.nasim.a16 r12 = (ir.nasim.C9475a16) r12
            java.lang.Object r12 = r12.l()
            goto L62
        L3a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L42:
            ir.nasim.AbstractC10685c16.b(r12)
            ir.nasim.Nd5 r1 = r9.S0
            int r3 = ir.nasim.AbstractC5969Lp4.f()
            long r4 = r11.h()
            long r6 = r11.i()
            r8.a = r9
            r8.b = r11
            r8.e = r2
            r2 = r10
            java.lang.Object r12 = r1.a(r2, r3, r4, r6, r8)
            if (r12 != r0) goto L61
            return r0
        L61:
            r10 = r9
        L62:
            boolean r0 = ir.nasim.C9475a16.j(r12)
            if (r0 == 0) goto L6e
            r0 = r12
            ir.nasim.i18 r0 = (ir.nasim.C14505i18) r0
            r10.Lc(r11)
        L6e:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.R9(int, ir.nasim.J44, ir.nasim.rm1):java.lang.Object");
    }

    public final void Rb(C14733iO2 c14733iO2) {
        this.L1 = c14733iO2;
    }

    public final InterfaceC13730gj3 Rc(long j, long j2, C8967Xz7 c8967Xz7, SA2 sa2) {
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(sa2, "onError");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.b, null, new F1(c8967Xz7, this, j, j2, sa2, null), 2, null);
    }

    public final InterfaceC10258bL6 S5() {
        return AbstractC6459Nq2.c(this.n1);
    }

    public final InterfaceC10258bL6 S6() {
        return AbstractC6459Nq2.c(this.Y1);
    }

    public final boolean S8() {
        C19482qQ7 c19482qQ7O;
        Integer num;
        C14733iO2 c14733iO2 = this.L1;
        if (c14733iO2 == null || (c19482qQ7O = c14733iO2.o()) == null || (num = (Integer) c19482qQ7O.b()) == null) {
            return false;
        }
        int iIntValue = num.intValue();
        return (H8() && iIntValue == 0) || ((C14697iL2) this.f.X1().d((long) iIntValue)).q0() == ZN2.GROUP;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object S9(ir.nasim.J44 r9, boolean r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof ir.nasim.chat.ChatViewModel.D0
            if (r0 == 0) goto L14
            r0 = r11
            ir.nasim.chat.ChatViewModel$D0 r0 = (ir.nasim.chat.ChatViewModel.D0) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.c = r1
        L12:
            r7 = r0
            goto L1a
        L14:
            ir.nasim.chat.ChatViewModel$D0 r0 = new ir.nasim.chat.ChatViewModel$D0
            r0.<init>(r11)
            goto L12
        L1a:
            java.lang.Object r11 = r7.a
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r7.c
            r2 = 1
            if (r1 == 0) goto L39
            if (r1 != r2) goto L31
            ir.nasim.AbstractC10685c16.b(r11)
            ir.nasim.a16 r11 = (ir.nasim.C9475a16) r11
            java.lang.Object r9 = r11.l()
            goto L61
        L31:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L39:
            ir.nasim.AbstractC10685c16.b(r11)
            ir.nasim.Nd5 r1 = r8.S0
            long r3 = r9.i()
            java.lang.Long r11 = ir.nasim.AbstractC6392Nk0.e(r3)
            long r3 = r9.h()
            java.lang.Long r3 = ir.nasim.AbstractC6392Nk0.e(r3)
            ir.nasim.d25 r4 = r8.z1
            ir.nasim.core.modules.profile.entity.ExPeerType r9 = r8.A1
            int r5 = r9.getValue()
            r7.c = r2
            r2 = r11
            r6 = r10
            java.lang.Object r9 = r1.h(r2, r3, r4, r5, r6, r7)
            if (r9 != r0) goto L61
            return r0
        L61:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.S9(ir.nasim.J44, boolean, ir.nasim.rm1):java.lang.Object");
    }

    public final void Sb(boolean z) {
        this.C2 = z;
    }

    public final void T4(long j, long j2, InterfaceC24449ye1 interfaceC24449ye1) {
        AbstractC13042fc3.i(interfaceC24449ye1, "consumer");
        C14970in2.W(this.i, j, j2, new C11182p(interfaceC24449ye1), false, 8, null);
    }

    public final String T5() {
        return this.d.J0();
    }

    public final SearchStruct$MessageSearchResult T6() {
        C25068zg6 c25068zg6 = (C25068zg6) this.e2.getValue();
        HashMap map = new HashMap();
        map.put("peer_id", Integer.valueOf(this.z1.getPeerId()));
        String lowerCase = this.z1.s().toString().toLowerCase(Locale.ROOT);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        map.put("peer_type", lowerCase);
        String strF = c25068zg6.f();
        map.put(ParameterNames.TEXT, Boolean.valueOf(!(strF == null || strF.length() == 0)));
        map.put("calendar", Boolean.valueOf(c25068zg6.m() != null));
        map.put("user", Boolean.valueOf(c25068zg6.n() != null));
        qb("message_search_result_click", map);
        if (c25068zg6.d() > 0) {
            return t9(c25068zg6.d() - 1);
        }
        return null;
    }

    public final boolean T8() {
        return AbstractC20762sZ6.X(this.d.Q3(), String.valueOf(this.z1.getPeerId()), false, 2, null) && C8386Vt0.ha();
    }

    public final InterfaceC13730gj3 Ta(Context context, String str, J44 j44) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(str, "editedText");
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new W0(j44, this, str, context, null), 3, null);
    }

    public final void Tb(NA3 na3) {
        Object value;
        JQ0 jq0;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g1;
        do {
            value = interfaceC9336Zm4.getValue();
            jq0 = (JQ0) value;
        } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : na3, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
    }

    public final void U4(J44 j44) {
        List listE;
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        if (j44.L() != EnumC23558x74.PENDING) {
            return;
        }
        AbstractC17457n0 abstractC17457n0F = j44.F();
        C11907dl c11907dl = abstractC17457n0F instanceof C11907dl ? (C11907dl) abstractC17457n0F : null;
        if (c11907dl == null || (listE = c11907dl.r()) == null) {
            listE = AbstractC9766aX0.e(j44);
        }
        List list = listE;
        if ((list instanceof Collection) && list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C24967zW1 c24967zW1H = ((J44) it.next()).H();
            if ((c24967zW1H != null ? c24967zW1H.z() : null) instanceof C4512Fl2) {
                if (this.Q2.add(Long.valueOf(j44.i()))) {
                    Iterator it2 = listE.iterator();
                    while (it2.hasNext()) {
                        this.i.a0(((J44) it2.next()).i(), new C11184q(j44, this));
                    }
                    return;
                }
                return;
            }
        }
    }

    public final InterfaceC13136fj0 U5() {
        return this.K2;
    }

    public final C6517Nv5 U7(final C19024pf0 c19024pf0) {
        AbstractC13042fc3.i(c19024pf0, "displayList");
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.lR0
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                ChatViewModel.V7(this.a, c19024pf0, c7234Qv5);
            }
        });
    }

    public final boolean U8(J44 j44) {
        return this.A1 == ExPeerType.BOT && this.z1.getPeerId() == 270066638 && j44 != null && (j44.F() instanceof C7906Tr6);
    }

    public final boolean U9(int i) {
        return i != this.G && this.d.G3(this.z1.u()) && this.A1 == ExPeerType.CHANNEL && this.d.H3() <= AbstractC23053wG5.t(new C24411ya3(0, 100), AbstractC17026mG5.a);
    }

    public final void Ua(ExPeerType exPeerType) {
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        C3343Am.i("GoTo_bottom", new X0(this, exPeerType));
    }

    public final void V4(Context context, EM2 em2, EM2 em22) {
        Object value;
        Object value2;
        Object value3;
        Object value4;
        Object value5;
        Object value6;
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(em2, "isSendGifEnabled");
        AbstractC13042fc3.i(em22, "isSendMediaEnabled");
        ShareData shareDataS7 = s7();
        if (shareDataS7 != null) {
            String[] strArr = {"mime_type"};
            EM2 em23 = EM2.a;
            if (em22 != em23 && em2 != em23) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.x1;
                do {
                    value6 = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value6, new K35.a(AbstractC12217eE5.send_media_permission_denied)));
                return;
            }
            if (em22 != em23) {
                if (shareDataS7.getSendUriString() == null) {
                    if (shareDataS7.getSendUriMultiple() != null) {
                        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new C11186r(shareDataS7, this, context, strArr, null), 2, null);
                        return;
                    }
                    return;
                } else {
                    if (AbstractC13042fc3.d(shareDataS7.getSendMimeType(), "image/gif")) {
                        InterfaceC9336Zm4 interfaceC9336Zm42 = this.x1;
                        do {
                            value4 = interfaceC9336Zm42.getValue();
                        } while (!interfaceC9336Zm42.f(value4, new K35.b(shareDataS7)));
                        return;
                    }
                    InterfaceC9336Zm4 interfaceC9336Zm43 = this.x1;
                    do {
                        value5 = interfaceC9336Zm43.getValue();
                    } while (!interfaceC9336Zm43.f(value5, new K35.a(AbstractC12217eE5.send_media_permission_denied)));
                    return;
                }
            }
            if (em2 == em23) {
                InterfaceC9336Zm4 interfaceC9336Zm44 = this.x1;
                do {
                    value = interfaceC9336Zm44.getValue();
                } while (!interfaceC9336Zm44.f(value, new K35.b(shareDataS7)));
                return;
            }
            if (shareDataS7.getSendUriString() == null) {
                if (shareDataS7.getSendUriMultiple() != null) {
                    AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new C11188s(shareDataS7, this, context, strArr, null), 2, null);
                }
            } else {
                if (AbstractC13042fc3.d(shareDataS7.getSendMimeType(), "image/gif")) {
                    InterfaceC9336Zm4 interfaceC9336Zm45 = this.x1;
                    do {
                        value3 = interfaceC9336Zm45.getValue();
                    } while (!interfaceC9336Zm45.f(value3, new K35.a(AbstractC12217eE5.no_stickers_permissoin_for_member)));
                    return;
                }
                InterfaceC9336Zm4 interfaceC9336Zm46 = this.x1;
                do {
                    value2 = interfaceC9336Zm46.getValue();
                } while (!interfaceC9336Zm46.f(value2, new K35.b(shareDataS7)));
            }
        }
    }

    public final String V5() {
        return (String) this.G1.getValue();
    }

    public final boolean V8(J44 j44) {
        return this.A1 == ExPeerType.PRIVATE && j44 != null && (j44.F() instanceof C19751qs6);
    }

    public final void Va(String str, EnumC24421yb3 enumC24421yb3, EnumC3487Bb3 enumC3487Bb3) {
        AbstractC13042fc3.i(str, "inlineButtonText");
        AbstractC13042fc3.i(enumC24421yb3, "actionType");
        AbstractC13042fc3.i(enumC3487Bb3, "eventType");
        this.w.d("Services_Interactive_Bots", AbstractC20051rO3.n(AbstractC4616Fw7.a("peer_id", Integer.valueOf(this.z1.getPeerId())), AbstractC4616Fw7.a("peer_type", Integer.valueOf(ExPeerType.BOT.getValue())), AbstractC4616Fw7.a("pressed_button", str), AbstractC4616Fw7.a("event_type", Integer.valueOf(enumC3487Bb3.j())), AbstractC4616Fw7.a("action_type", Integer.valueOf(enumC24421yb3.j())), AbstractC4616Fw7.a("random_id", Integer.valueOf(this.I1))));
    }

    public final void Vb(String str) {
        Object value;
        C25068zg6 c25068zg6;
        AbstractC13042fc3.i(str, "query");
        this.b1 = ParameterNames.TEXT;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.e2;
        do {
            value = interfaceC9336Zm4.getValue();
            c25068zg6 = (C25068zg6) value;
        } while (!interfaceC9336Zm4.f(value, c25068zg6.a((5885 & 1) != 0 ? c25068zg6.a : 0L, (5885 & 2) != 0 ? c25068zg6.b : null, (5885 & 4) != 0 ? c25068zg6.c : null, (5885 & 8) != 0 ? c25068zg6.d : null, (5885 & 16) != 0 ? c25068zg6.e : str, (5885 & 32) != 0 ? c25068zg6.f : null, (5885 & 64) != 0 ? c25068zg6.g : null, (5885 & 128) != 0 ? c25068zg6.h : 0, (5885 & 256) != 0 ? c25068zg6.i : null, (5885 & 512) != 0 ? c25068zg6.j : 0, (5885 & 1024) != 0 ? c25068zg6.k : 0, (5885 & 2048) != 0 ? c25068zg6.l : null, (5885 & 4096) != 0 ? c25068zg6.m : false)));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object W5(ir.nasim.C11920dm2 r11, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof ir.nasim.chat.ChatViewModel.T
            if (r0 == 0) goto L14
            r0 = r12
            ir.nasim.chat.ChatViewModel$T r0 = (ir.nasim.chat.ChatViewModel.T) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.c = r1
        L12:
            r9 = r0
            goto L1a
        L14:
            ir.nasim.chat.ChatViewModel$T r0 = new ir.nasim.chat.ChatViewModel$T
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r12 = r9.a
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r9.c
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            ir.nasim.AbstractC10685c16.b(r12)
            goto L66
        L2b:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L33:
            ir.nasim.AbstractC10685c16.b(r12)
            ir.nasim.ku1 r1 = r10.z
            ir.nasim.core.modules.file.entity.FileReference r12 = r11.b()
            long r3 = r12.getFileId()
            ir.nasim.core.modules.file.entity.FileReference r12 = r11.b()
            long r5 = r12.getAccessHash()
            ir.nasim.core.modules.file.entity.FileReference r12 = r11.b()
            int r12 = r12.getFileSize()
            long r7 = (long) r12
            ir.nasim.core.modules.file.entity.FileReference r11 = r11.b()
            java.lang.String r11 = r11.getFileName()
            r9.c = r2
            r2 = r3
            r4 = r5
            r6 = r7
            r8 = r11
            java.lang.Object r12 = r1.k(r2, r4, r6, r8, r9)
            if (r12 != r0) goto L66
            return r0
        L66:
            java.io.File r12 = (java.io.File) r12
            if (r12 == 0) goto L6f
            java.lang.String r11 = r12.getAbsolutePath()
            goto L70
        L6f:
            r11 = 0
        L70:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.W5(ir.nasim.dm2, ir.nasim.rm1):java.lang.Object");
    }

    public final InterfaceC10258bL6 W6() {
        return this.m2;
    }

    public final boolean W8() {
        return this.w1;
    }

    public final void W9() {
        C5246In1 c5246In1 = this.N1;
        if (c5246In1 == null) {
            return;
        }
        Long l = (Long) c5246In1.g().b();
        this.Y1.setValue(0);
        this.V1 = l.longValue();
        this.A2.r();
        Z9(true);
    }

    public final void Wa(String str, EnumC24421yb3 enumC24421yb3, EnumC3721Cb3 enumC3721Cb3) {
        AbstractC13042fc3.i(str, "keyboardButtonText");
        AbstractC13042fc3.i(enumC24421yb3, "actionType");
        AbstractC13042fc3.i(enumC3721Cb3, "eventType");
        this.w.d("Services_Interactive_Bots", AbstractC20051rO3.n(AbstractC4616Fw7.a("peer_id", Integer.valueOf(this.z1.getPeerId())), AbstractC4616Fw7.a("peer_type", Integer.valueOf(ExPeerType.BOT.getValue())), AbstractC4616Fw7.a("pressed_button", str), AbstractC4616Fw7.a("event_type", Integer.valueOf(enumC3721Cb3.j())), AbstractC4616Fw7.a("action_type", Integer.valueOf(enumC24421yb3.j())), AbstractC4616Fw7.a("random_id", Integer.valueOf(this.I1))));
    }

    public final void Wb(boolean z) {
        this.d.r7(this.z1.getPeerId(), z);
    }

    public final void X4() {
        this.v.l0();
    }

    public final boolean X5() {
        C14733iO2 c14733iO2;
        C14733iO2 c14733iO22;
        List list;
        C24411ya3 c24411ya3;
        C6305Na3 c6305Na3U;
        C19482qQ7 c19482qQ7S;
        C23104wM2 c23104wM2;
        if (this.A1 == ExPeerType.CHANNEL && C8386Vt0.Z3() && ((((c14733iO2 = this.L1) != null && (c19482qQ7S = c14733iO2.s()) != null && (c23104wM2 = (C23104wM2) c19482qQ7S.b()) != null && c23104wM2.j()) || ((c14733iO22 = this.L1) != null && c14733iO22.x() == this.G)) && (list = (List) this.d.T().get("tooltip_interacted_channels")) != null && (!list.contains(Integer.valueOf(this.z1.getPeerId()))) && (c24411ya3 = (C24411ya3) this.d.S().get("total_range")) != null)) {
            C14733iO2 c14733iO23 = this.L1;
            Integer num = (c14733iO23 == null || (c6305Na3U = c14733iO23.u()) == null) ? null : (Integer) c6305Na3U.b();
            if (num != null && c24411ya3.B(num.intValue())) {
                return true;
            }
        }
        return false;
    }

    public final InterfaceC10258bL6 X6() {
        return this.n2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object X8(int r5, java.lang.String r6, ir.nasim.SA2 r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof ir.nasim.chat.ChatViewModel.C11177m0
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.chat.ChatViewModel$m0 r0 = (ir.nasim.chat.ChatViewModel.C11177m0) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.chat.ChatViewModel$m0 r0 = new ir.nasim.chat.ChatViewModel$m0
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r5 = r8.l()
            goto L49
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.OK7 r8 = r4.g
            ir.nasim.Nv5 r5 = r8.q0(r5, r6)
            r0.c = r3
            java.lang.Object r5 = ir.nasim.AbstractC6756Ov5.c(r5, r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.X8(int, java.lang.String, ir.nasim.SA2, ir.nasim.rm1):java.lang.Object");
    }

    public final void Xa(String str, EnumC24421yb3 enumC24421yb3) {
        AbstractC13042fc3.i(str, "pressedButtonText");
        AbstractC13042fc3.i(enumC24421yb3, "actionType");
        this.w.d("Services_Interactive_Bots", AbstractC20051rO3.n(AbstractC4616Fw7.a("peer_id", Integer.valueOf(this.z1.getPeerId())), AbstractC4616Fw7.a("peer_type", Integer.valueOf(ExPeerType.BOT.getValue())), AbstractC4616Fw7.a("pressed_button", str), AbstractC4616Fw7.a("action_type", Integer.valueOf(enumC24421yb3.j())), AbstractC4616Fw7.a("random_id", Integer.valueOf(this.I1))));
    }

    public final void Xb(Integer num) {
        Object value;
        C25068zg6 c25068zg6;
        this.b1 = "user";
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.e2;
        do {
            value = interfaceC9336Zm4.getValue();
            c25068zg6 = (C25068zg6) value;
        } while (!interfaceC9336Zm4.f(value, c25068zg6.a((5885 & 1) != 0 ? c25068zg6.a : 0L, (5885 & 2) != 0 ? c25068zg6.b : null, (5885 & 4) != 0 ? c25068zg6.c : null, (5885 & 8) != 0 ? c25068zg6.d : EnumC16752lo2.b, (5885 & 16) != 0 ? c25068zg6.e : null, (5885 & 32) != 0 ? c25068zg6.f : null, (5885 & 64) != 0 ? c25068zg6.g : num, (5885 & 128) != 0 ? c25068zg6.h : 0, (5885 & 256) != 0 ? c25068zg6.i : null, (5885 & 512) != 0 ? c25068zg6.j : 0, (5885 & 1024) != 0 ? c25068zg6.k : 0, (5885 & 2048) != 0 ? c25068zg6.l : null, (5885 & 4096) != 0 ? c25068zg6.m : false)));
    }

    public final InterfaceC13730gj3 Y4() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.b, null, new C11192u(null), 2, null);
    }

    public final String Y5() {
        return "https://" + this.d.n1() + Separators.SLASH;
    }

    public final InterfaceC10258bL6 Y6() {
        return this.N2;
    }

    public final InterfaceC13730gj3 Y8(String str) {
        AbstractC13042fc3.i(str, "callLink");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C11179n0(str, null), 3, null);
    }

    public final void Y9(J44 j44) {
        C5246In1 c5246In1;
        Object value;
        List listR;
        AbstractC13042fc3.i(j44, "item");
        if (H8() || (c5246In1 = this.N1) == null || j44.U() == this.G) {
            return;
        }
        Long l = (Long) c5246In1.g().b();
        if (j44.h() <= ((Long) c5246In1.h().b()).longValue() || j44.h() <= this.V1) {
            return;
        }
        this.V1 = j44.h();
        boolean z = l != null && j44.h() == l.longValue();
        if (((Number) this.Y1.getValue()).intValue() > 0) {
            if (j44.F() instanceof C11907dl) {
                AbstractC17457n0 abstractC17457n0F = j44.F();
                C11907dl c11907dl = abstractC17457n0F instanceof C11907dl ? (C11907dl) abstractC17457n0F : null;
                int size = (c11907dl == null || (listR = c11907dl.r()) == null) ? 0 : listR.size();
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.Y1;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, Integer.valueOf(Math.max(0, ((Number) value).intValue() - size))));
            } else {
                this.Y1.setValue(Integer.valueOf(((Number) r7.getValue()).intValue() - 1));
            }
            this.A2.r();
        }
        Z9(z);
    }

    public final void Ya(J44 j44) {
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        AbstractC17457n0 abstractC17457n0F = j44.F();
        C12872fJ6 c12872fJ6 = abstractC17457n0F instanceof C12872fJ6 ? (C12872fJ6) abstractC17457n0F : null;
        if (c12872fJ6 != null) {
            HashMap map = new HashMap();
            map.put("ad_item_id", c12872fJ6.t());
            map.put("ad_item_state", ConstantDeviceInfo.APP_PLATFORM);
            map.put("peer_id", Integer.valueOf(c12872fJ6.w()));
            map.put("action_type", 2);
            map.put("tag_1", Integer.valueOf(c12872fJ6.x()));
            map.put("tag_2", Integer.valueOf(c12872fJ6.y()));
            C3343Am.i("ad_sponsored_action", map);
        }
    }

    public final void Yb(int i) {
        if (C8386Vt0.f9()) {
            this.d.m7(i);
        }
    }

    public final String Z5() {
        return this.d.q1();
    }

    public final C6517Nv5 Z7(int i, String str) {
        AbstractC13042fc3.i(str, "serviceKey");
        return this.H.f2(i, str);
    }

    public final C6517Nv5 Z8(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        if (AbstractC13042fc3.d(c11458d25, this.z1)) {
            this.o1 = true;
        }
        C6517Nv5 c6517Nv5Z = this.f.q2(c11458d25).z(new InterfaceC3273Ae1() { // from class: ir.nasim.XQ0
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                ChatViewModel.a9(this.a, (Integer) obj, (Exception) obj2);
            }
        });
        AbstractC13042fc3.h(c6517Nv5Z, "after(...)");
        return c6517Nv5Z;
    }

    public final void Z9(boolean z) {
        if (z) {
            this.u2 = null;
            this.v.e2(this.z1, this.V1, ((Number) this.Y1.getValue()).intValue());
            return;
        }
        this.u2 = new C23071wI5();
        if (this.v2) {
            return;
        }
        this.v2 = true;
        this.w2.d(5000L);
    }

    public final void Za(C11458d25 c11458d25, Context context, String str) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(str, "caption");
        XV4 xv4B = C10326bT2.a.b();
        if (xv4B != null) {
            ab(c11458d25, context, (C24890zN5) xv4B.e(), ((Number) xv4B.f()).intValue(), str);
        }
    }

    public final void Zb(boolean z) {
        EnumC16752lo2 enumC16752lo2;
        if (z) {
            enumC16752lo2 = C11155d.g[((C25068zg6) this.e2.getValue()).g().ordinal()] == 1 ? EnumC16752lo2.a : EnumC16752lo2.c;
        } else {
            int i = C11155d.g[((C25068zg6) this.e2.getValue()).g().ordinal()];
            if (i == 1) {
                enumC16752lo2 = EnumC16752lo2.a;
            } else {
                if (i != 2 && i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                enumC16752lo2 = EnumC16752lo2.b;
            }
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.e2;
        while (true) {
            Object value = interfaceC9336Zm4.getValue();
            C25068zg6 c25068zg6 = (C25068zg6) value;
            InterfaceC9336Zm4 interfaceC9336Zm42 = interfaceC9336Zm4;
            if (interfaceC9336Zm42.f(value, c25068zg6.a((5885 & 1) != 0 ? c25068zg6.a : 0L, (5885 & 2) != 0 ? c25068zg6.b : null, (5885 & 4) != 0 ? c25068zg6.c : null, (5885 & 8) != 0 ? c25068zg6.d : enumC16752lo2, (5885 & 16) != 0 ? c25068zg6.e : null, (5885 & 32) != 0 ? c25068zg6.f : null, (5885 & 64) != 0 ? c25068zg6.g : null, (5885 & 128) != 0 ? c25068zg6.h : 0, (5885 & 256) != 0 ? c25068zg6.i : null, (5885 & 512) != 0 ? c25068zg6.j : 0, (5885 & 1024) != 0 ? c25068zg6.k : 0, (5885 & 2048) != 0 ? c25068zg6.l : null, (5885 & 4096) != 0 ? c25068zg6.m : z))) {
                return;
            } else {
                interfaceC9336Zm4 = interfaceC9336Zm42;
            }
        }
    }

    public final C20919sp4 a6() {
        return this.O1;
    }

    public final InterfaceC13730gj3 a7() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C11156d0(null), 3, null);
    }

    public final void a8(AbstractC23684xL1 abstractC23684xL1) {
        AbstractC13042fc3.i(abstractC23684xL1, "action");
        this.c.t(abstractC23684xL1);
    }

    public final void ac(FF6 ff6) {
        Object value;
        AbstractC13042fc3.i(ff6, "smilesPanelState");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.D2;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, ff6));
    }

    public final C14733iO2 b6() {
        if (this.z1.z()) {
            return x6(this.z1.getPeerId());
        }
        return null;
    }

    public final Object b7(long j, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.Z.F(j, interfaceC20295rm1);
    }

    public final void b8(long j, long j2, C19951rD2 c19951rD2) {
        AbstractC13042fc3.i(c19951rD2, "result");
        int i = C11155d.e[((H8() && c19951rD2.b() == EnumC20560sD2.b) ? EnumC20560sD2.c : c19951rD2.b()).ordinal()];
        if (i == 1 || i == 2) {
            F84 f84 = this.m;
            C11458d25 c11458d25 = this.z1;
            C7880To7 c7880To7I6 = i6();
            KW3[] kw3Arr = (KW3[]) c19951rD2.a().toArray(new KW3[0]);
            f84.u(c11458d25, j, j2, c7880To7I6, (KW3[]) Arrays.copyOf(kw3Arr, kw3Arr.length));
            return;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        F84 f842 = this.m;
        C11458d25 c11458d252 = this.z1;
        C7880To7 c7880To7I62 = i6();
        KW3[] kw3Arr2 = (KW3[]) c19951rD2.a().toArray(new KW3[0]);
        f842.v(c11458d252, j, j2, c7880To7I62, (KW3[]) Arrays.copyOf(kw3Arr2, kw3Arr2.length));
    }

    public final boolean b9() {
        return this.d.P2(this.z1.u()) && this.A1 == ExPeerType.CHANNEL;
    }

    public final void ba(long j, long j2) {
        this.v.f2(this.z1, new Q64(j, j2), this.A1);
    }

    public final void bc(boolean z) {
        this.w1 = z;
    }

    public final IQ0 c6() {
        return (IQ0) this.f1.getValue();
    }

    public final long c7() {
        return this.R1;
    }

    public final String c9(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        String strG1 = this.v.G1(Long.valueOf(c11458d25.u()));
        AbstractC13042fc3.h(strG1, "loadDraft(...)");
        return strG1;
    }

    public final void ca(long j, long j2) {
        this.v.g2(this.z1, new Q64(j, j2), this.A1);
    }

    public final void cb(Context context, QG2 qg2, long j, long j2) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(qg2, "gif");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.b, null, new C11148a1(qg2, this, j, j2, context, null), 2, null);
    }

    public final void cc(long j, long j2, Context context) {
        C8512Wh0 c8512Wh0F;
        AbstractC13042fc3.i(context, "context");
        C14733iO2 c14733iO2 = this.L1;
        if (!((c14733iO2 == null || (c8512Wh0F = c14733iO2.F()) == null) ? false : AbstractC13042fc3.d(c8512Wh0F.b(), Boolean.FALSE))) {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new r1(j, j2, context, null), 2, null);
        } else {
            ec();
            AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new q1(j, j2, null), 2, null);
        }
    }

    public final String d6() {
        return this.D1;
    }

    public final int d7() {
        return this.S1;
    }

    public final void d9(C19024pf0 c19024pf0) {
        AbstractC13042fc3.i(c19024pf0, "displayList");
        f9(this.z1, c19024pf0).z(new InterfaceC3273Ae1() { // from class: ir.nasim.pR0
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                ChatViewModel.e9(this.a, (C14505i18) obj, (Exception) obj2);
            }
        });
    }

    public final InterfaceC13730gj3 da(InterfaceC18505om2 interfaceC18505om2, SA2 sa2) {
        AbstractC13042fc3.i(sa2, "onReady");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new H0(interfaceC18505om2, this, sa2, null), 3, null);
    }

    public final void db(ExPeerType exPeerType) {
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        C3343Am.i("click_on_gift_button", new C11151b1(exPeerType, this));
    }

    public final C21231tK7 e6() {
        if (this.z1.C()) {
            return I7(this.z1.getPeerId());
        }
        return null;
    }

    public final SearchStruct$MessageSearchResult e7() {
        C25068zg6 c25068zg6 = (C25068zg6) this.e2.getValue();
        HashMap map = new HashMap();
        map.put("peer_id", Integer.valueOf(this.z1.getPeerId()));
        String lowerCase = this.z1.s().toString().toLowerCase(Locale.ROOT);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        map.put("peer_type", lowerCase);
        String strF = c25068zg6.f();
        map.put(ParameterNames.TEXT, Boolean.valueOf(!(strF == null || strF.length() == 0)));
        map.put("calendar", Boolean.valueOf(c25068zg6.m() != null));
        map.put("user", Boolean.valueOf(c25068zg6.n() != null));
        qb("message_search_result_click", map);
        int iD = c25068zg6.d() + 1;
        if (iD >= c25068zg6.j() && c25068zg6.k() == null) {
            return null;
        }
        if (iD < c25068zg6.i().size() || c25068zg6.k() == null) {
            return t9(iD);
        }
        Ja(c25068zg6.k());
        return null;
    }

    public final void ea(C11458d25 c11458d25) {
        this.v.j2(c11458d25);
    }

    public final void eb(EnumC17253mf2 enumC17253mf2, int i) {
        AbstractC13042fc3.i(enumC17253mf2, "hafezFaalEventStatus");
        HashMap map = new HashMap();
        map.put("origin", 2);
        int i2 = C11155d.f[enumC17253mf2.ordinal()];
        boolean z = true;
        if (i2 != 1) {
            if (i2 != 2) {
                return;
            } else {
                z = false;
            }
        }
        map.put("request_status", Boolean.valueOf(z));
        map.put("peer_id", Integer.valueOf(i));
        this.w.d("yalda", map);
    }

    public final long f6() {
        return this.y2;
    }

    public final InterfaceC10258bL6 f7() {
        return this.j1;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object fa(int r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ir.nasim.chat.ChatViewModel.I0
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.chat.ChatViewModel$I0 r0 = (ir.nasim.chat.ChatViewModel.I0) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.chat.ChatViewModel$I0 r0 = new ir.nasim.chat.ChatViewModel$I0
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
            java.lang.Object r5 = r6.l()
            goto L45
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.Nd5 r6 = r4.S0
            r0.c = r3
            java.lang.Object r5 = r6.c(r5, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.fa(int, ir.nasim.rm1):java.lang.Object");
    }

    public final InterfaceC13730gj3 fb(C11458d25 c11458d25, long j, long j2, List list, List list2, List list3) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(list, "paths");
        AbstractC13042fc3.i(list3, "mediaTypes");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new C11154c1(list, list3, list2, this, c11458d25, j, j2, null), 2, null);
    }

    public final boolean g5(long j) {
        return this.A.d(j);
    }

    public final long g6() {
        return this.x2;
    }

    public final InterfaceC5520Jr5 g7() {
        return this.J2;
    }

    public final void ga(int i, List list) {
        Object value;
        AbstractC13042fc3.i(list, "messages");
        InterfaceC3570Bk5 interfaceC3570Bk5 = this.x;
        String str = "pin_locally_removed_Date" + i;
        Iterator it = list.iterator();
        long jAbs = 0;
        while (it.hasNext()) {
            jAbs += Math.abs(((S74) it.next()).a().h());
        }
        interfaceC3570Bk5.putLong(str, jAbs);
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.l2;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, AbstractC10360bX0.m()));
    }

    public final void gb(String str, int i, ExPeerType exPeerType, Boolean bool) {
        AbstractC13042fc3.i(str, "requestId");
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C11157d1(str, i, exPeerType, bool, null), 3, null);
    }

    public final boolean gc(long j) {
        if (((Number) this.Y1.getValue()).intValue() > 0) {
            long j2 = this.V1;
            if (j2 < this.Q1 && j < j2) {
                return true;
            }
        }
        return false;
    }

    public final R74 h5() {
        if (this.z1.z() && this.A1 == ExPeerType.GROUP) {
            return (R74) this.Y0.get();
        }
        return null;
    }

    public final List h6(List list) {
        ArrayList arrayList = new ArrayList();
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new U(list, arrayList, this, null), 3, null);
        return arrayList;
    }

    public final InterfaceC9336Zm4 h7() {
        return this.o2;
    }

    public final void ha(List list, String str, long j, long j2) {
        AbstractC13042fc3.i(list, "reactions");
        AbstractC13042fc3.i(str, "emojiCode");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.a(), null, new J0(j, j2, str, list, null), 2, null);
    }

    public final boolean hc() {
        return this.d.B5(EnumC4196Ec1.x) && this.A1 == ExPeerType.PRIVATE && !H8();
    }

    public final C7880To7 i6() {
        if (this.x2 == 0 || this.y2 == 0) {
            return null;
        }
        return new C7880To7(this.x2, this.y2, this.u1);
    }

    public final HM5 i7() {
        if (!this.p1) {
            this.p1 = true;
            AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C11159e0(null), 3, null);
        }
        return new HM5((IM5) this.k1.getValue(), this.z1);
    }

    public final C6517Nv5 i9(long j, long j2, final C19024pf0 c19024pf0) {
        AbstractC13042fc3.i(c19024pf0, "displayList");
        int iD6 = D6(j, j2, c19024pf0);
        if (iD6 >= 0) {
            C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(Integer.valueOf(iD6));
            AbstractC13042fc3.f(c6517Nv5L0);
            return c6517Nv5L0;
        }
        C6517Nv5 c6517Nv5H = this.v.b2(this.z1, j, j2, H8()).A(new InterfaceC17569nB2() { // from class: ir.nasim.eR0
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return ChatViewModel.j9(c19024pf0, (C10872cL4) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.fR0
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return ChatViewModel.k9(this.a, c19024pf0, (C10872cL4) obj);
            }
        });
        AbstractC13042fc3.f(c6517Nv5H);
        return c6517Nv5H;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object ia(int r9, ir.nasim.J44 r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof ir.nasim.chat.ChatViewModel.K0
            if (r0 == 0) goto L14
            r0 = r11
            ir.nasim.chat.ChatViewModel$K0 r0 = (ir.nasim.chat.ChatViewModel.K0) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.e = r1
        L12:
            r7 = r0
            goto L1a
        L14:
            ir.nasim.chat.ChatViewModel$K0 r0 = new ir.nasim.chat.ChatViewModel$K0
            r0.<init>(r11)
            goto L12
        L1a:
            java.lang.Object r11 = r7.c
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r7.e
            r2 = 1
            if (r1 == 0) goto L42
            if (r1 != r2) goto L3a
            java.lang.Object r9 = r7.b
            r10 = r9
            ir.nasim.J44 r10 = (ir.nasim.J44) r10
            java.lang.Object r9 = r7.a
            ir.nasim.chat.ChatViewModel r9 = (ir.nasim.chat.ChatViewModel) r9
            ir.nasim.AbstractC10685c16.b(r11)
            ir.nasim.a16 r11 = (ir.nasim.C9475a16) r11
            java.lang.Object r11 = r11.l()
            goto L5e
        L3a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L42:
            ir.nasim.AbstractC10685c16.b(r11)
            ir.nasim.Nd5 r1 = r8.S0
            long r3 = r10.h()
            long r5 = r10.i()
            r7.a = r8
            r7.b = r10
            r7.e = r2
            r2 = r9
            java.lang.Object r11 = r1.i(r2, r3, r5, r7)
            if (r11 != r0) goto L5d
            return r0
        L5d:
            r9 = r8
        L5e:
            boolean r0 = ir.nasim.C9475a16.j(r11)
            if (r0 == 0) goto L84
            r0 = r11
            ir.nasim.i18 r0 = (ir.nasim.C14505i18) r0
            ir.nasim.Zm4 r9 = r9.l2
        L69:
            java.lang.Object r0 = r9.getValue()
            r1 = r0
            java.util.List r1 = (java.util.List) r1
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.List r1 = ir.nasim.ZW0.p1(r1)
            ir.nasim.S74 r2 = new ir.nasim.S74
            r2.<init>(r10)
            r1.remove(r2)
            boolean r0 = r9.f(r0, r1)
            if (r0 == 0) goto L69
        L84:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.ia(int, ir.nasim.J44, ir.nasim.rm1):java.lang.Object");
    }

    public final void ib(double d, double d2, String str, String str2, Long l, Long l2) {
        this.v.z2(this.z1, Double.valueOf(d), Double.valueOf(d2), str, str2, l, l2, i6());
    }

    public final boolean ic() {
        C21231tK7 c21231tK7;
        if (this.d.B5(EnumC4196Ec1.v) && !H8()) {
            ExPeerType exPeerType = this.A1;
            if ((exPeerType == ExPeerType.GROUP || exPeerType == ExPeerType.CHANNEL) && FM2.a.d(FM2.a, this.L1, false, 2, null)) {
                return true;
            }
            if (this.A1 == ExPeerType.PRIVATE && (c21231tK7 = this.M1) != null && !c21231tK7.y()) {
                return true;
            }
        }
        return false;
    }

    public final void j5(int i) {
        if (this.z1.z()) {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C(i, null), 3, null);
        }
    }

    public final InterfaceC10258bL6 j7() {
        return this.l1;
    }

    public final void ja(List list) {
        AbstractC13042fc3.i(list, "messages");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            J44 j44 = (J44) it.next();
            if (j44.L() == EnumC23558x74.PENDING) {
                this.i.S(j44.i());
            }
        }
    }

    public final void jb(String str) {
        AbstractC13042fc3.i(str, "itemText");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C11160e1(str, null), 3, null);
    }

    public final boolean jc() {
        C21231tK7 c21231tK7;
        if (!H8() && this.d.B5(EnumC4196Ec1.B)) {
            ExPeerType exPeerType = this.A1;
            if ((exPeerType == ExPeerType.GROUP || exPeerType == ExPeerType.CHANNEL) && FM2.a.d(FM2.a, this.L1, false, 2, null)) {
                return true;
            }
            if (this.A1 == ExPeerType.PRIVATE && (c21231tK7 = this.M1) != null && !c21231tK7.y()) {
                return true;
            }
        }
        return false;
    }

    public final C21167tD6 k6() {
        return this.z2;
    }

    public final InterfaceC10258bL6 k7() {
        return this.g2;
    }

    public final InterfaceC13730gj3 ka(String str, OP5 op5, List list) {
        AbstractC13042fc3.i(str, "description");
        AbstractC13042fc3.i(op5, "reportType");
        AbstractC13042fc3.i(list, "messages");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.b, null, new L0(str, op5, list, null), 2, null);
    }

    public final void kb(String str, Context context) {
        AbstractC13042fc3.i(str, "query");
        if (context == null) {
            C19406qI3.j("ChatViewModel", "Return from sendMessageToContact, because context is null!", new Object[0]);
        } else {
            final ProgressDialog progressDialogE = C8920Xu5.e(context, true);
            this.h.h0(str).m0(new InterfaceC24449ye1() { // from class: ir.nasim.mR0
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    ChatViewModel.lb(progressDialogE, (C4382Ew7) obj);
                }
            });
        }
    }

    public final InterfaceC13730gj3 l5(String str, long j, long j2) {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new D(str, j, j2, null), 3, null);
    }

    public final InterfaceC10258bL6 l7() {
        return this.f2;
    }

    public final InterfaceC13730gj3 l9(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "onLoaded");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C11181o0(ua2, null), 3, null);
    }

    public final void la() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new M0(null), 3, null);
    }

    public final boolean lc() {
        return this.d.S7();
    }

    public final InterfaceC13730gj3 m5(long j, long j2) {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new E(j, j2, null), 3, null);
    }

    public final ExPeerType m6() {
        return this.A1;
    }

    public final InterfaceC9336Zm4 m7() {
        return this.i2;
    }

    public final void ma(J44 j44) {
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        if (C8386Vt0.w7()) {
            AbstractC17457n0 abstractC17457n0F = j44.F();
            LC3 lc3 = abstractC17457n0F instanceof LC3 ? (LC3) abstractC17457n0F : null;
            if (lc3 != null) {
                K6().e(this.z1, j44, lc3.t());
            }
        }
    }

    public final void mb(C11458d25 c11458d25, String str, ArrayList arrayList, boolean z, Long l, Long l2, C7880To7 c7880To7) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(str, ParameterNames.TEXT);
        this.v.B2(c11458d25, str, arrayList, z, l, l2, c7880To7);
    }

    public final void mc() {
        Object value;
        JQ0 jq0;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g1;
        do {
            value = interfaceC9336Zm4.getValue();
            jq0 = (JQ0) value;
        } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : AbstractC4616Fw7.a(null, Integer.valueOf(DD5.toast_call_link_not_supported)), (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
    }

    public final InterfaceC10258bL6 n6() {
        return this.c2;
    }

    public final int n7() {
        return this.d.O3();
    }

    public final void n8(UA2 ua2, UA2 ua22) {
        AbstractC13042fc3.i(ua2, "onRemoved");
        AbstractC13042fc3.i(ua22, "onAdded");
        if (this.z1.z()) {
            m8(ua2, ua22);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n9(ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof ir.nasim.chat.ChatViewModel.C11183p0
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.chat.ChatViewModel$p0 r0 = (ir.nasim.chat.ChatViewModel.C11183p0) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.chat.ChatViewModel$p0 r0 = new ir.nasim.chat.ChatViewModel$p0
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r8 = r8.l()
            goto L59
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L38:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.OK7 r8 = r7.g
            ir.nasim.VL3 r8 = r8.o0()
            ir.nasim.d25 r2 = r7.z1
            long r5 = r2.u()
            ir.nasim.Nv5 r8 = r8.k(r5)
            java.lang.String r2 = "get(...)"
            ir.nasim.AbstractC13042fc3.h(r8, r2)
            r0.c = r3
            java.lang.Object r8 = ir.nasim.AbstractC6756Ov5.d(r8, r4, r0, r3, r4)
            if (r8 != r1) goto L59
            return r1
        L59:
            boolean r0 = ir.nasim.C9475a16.g(r8)
            if (r0 == 0) goto L60
            r8 = r4
        L60:
            ir.nasim.tK7 r8 = (ir.nasim.C21231tK7) r8
            if (r8 == 0) goto L71
            ir.nasim.bZ6 r8 = r8.r()
            if (r8 == 0) goto L71
            java.lang.Object r8 = r8.b()
            r4 = r8
            java.lang.String r4 = (java.lang.String) r4
        L71:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.n9(ir.nasim.rm1):java.lang.Object");
    }

    public final void na(J44 j44) {
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        this.q1.s(this.z1, j44, true);
    }

    public final void nb() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C11163f1(null), 3, null);
    }

    public final void nc(String str, Integer num, Integer num2) {
        Object value;
        JQ0 jq0;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g1;
        do {
            value = interfaceC9336Zm4.getValue();
            jq0 = (JQ0) value;
        } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : AbstractC4616Fw7.a(str, num), (262142 & 2) != 0 ? jq0.b : num2, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o4(int r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ir.nasim.chat.ChatViewModel.C11158e
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.chat.ChatViewModel$e r0 = (ir.nasim.chat.ChatViewModel.C11158e) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.chat.ChatViewModel$e r0 = new ir.nasim.chat.ChatViewModel$e
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.a
            ir.nasim.chat.ChatViewModel r5 = (ir.nasim.chat.ChatViewModel) r5
            ir.nasim.AbstractC10685c16.b(r6)
            goto L6a
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            ir.nasim.AbstractC10685c16.b(r6)
            r0.a = r4
            r0.b = r5
            r0.e = r3
            ir.nasim.IE0 r6 = new ir.nasim.IE0
            ir.nasim.rm1 r2 = ir.nasim.AbstractC13660gc3.c(r0)
            r6.<init>(r2, r3)
            r6.w()
            ir.nasim.Ui1 r2 = C2(r4)
            ir.nasim.iZ0 r5 = r2.U(r5)
            ir.nasim.chat.ChatViewModel$f r2 = new ir.nasim.chat.ChatViewModel$f
            r2.<init>(r6)
            r5.a(r2)
            java.lang.Object r6 = r6.t()
            java.lang.Object r5 = ir.nasim.AbstractC13660gc3.e()
            if (r6 != r5) goto L67
            ir.nasim.WA1.c(r0)
        L67:
            if (r6 != r1) goto L6a
            return r1
        L6a:
            ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
            java.lang.Object r5 = r6.l()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.o4(int, ir.nasim.rm1):java.lang.Object");
    }

    public final InterfaceC13730gj3 o5(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new G(c11458d25, this, null), 3, null);
    }

    public final int o6() {
        return this.d.a2();
    }

    public final int o7() {
        return this.d.P3();
    }

    public final void oa() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new N0(null), 3, null);
    }

    public final void ob(G73.e eVar, J44 j44, ExPeerType exPeerType, C11458d25 c11458d25) {
        AbstractC13042fc3.i(eVar, "inlineButton");
        AbstractC13042fc3.i(j44, "currentMessage");
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new g1(c11458d25, exPeerType, j44, eVar, null), 3, null);
    }

    public final void p4(Context context, J44 j44) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.b, null, new C11164g(j44, this, context, null), 2, null);
    }

    public final void p5(List list, List list2, boolean z) {
        AbstractC13042fc3.i(list, "rids");
        AbstractC13042fc3.i(list2, "dates");
        this.v.u0(this.z1, list, list2, z);
    }

    public final String p6() {
        return this.d.b2();
    }

    public final int p7() {
        return this.I1;
    }

    public final void p9(ArrayList arrayList) {
        AbstractC13042fc3.i(arrayList, "range");
        L6().e(arrayList);
    }

    public final void pa() {
        Object value;
        JQ0 jq0;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g1;
        do {
            value = interfaceC9336Zm4.getValue();
            jq0 = (JQ0) value;
        } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
    }

    public final void pb(String str, Map map) {
        AbstractC13042fc3.i(str, "eventName");
        AbstractC13042fc3.i(map, "params");
        this.F0.a(str, map);
    }

    public final void q4(List list, String str, long j, long j2) {
        AbstractC13042fc3.i(list, "reactions");
        AbstractC13042fc3.i(str, "emojiCode");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.a(), null, new C11166h(j, j2, str, list, null), 2, null);
    }

    public final void q5() {
        this.x.g("MAGAZINE_EVENT_BAR_CLOSED_KEY", true);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q6(ir.nasim.C11458d25 r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ir.nasim.chat.ChatViewModel.W
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.chat.ChatViewModel$W r0 = (ir.nasim.chat.ChatViewModel.W) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.chat.ChatViewModel$W r0 = new ir.nasim.chat.ChatViewModel$W
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
            java.lang.Object r5 = r6.l()
            goto L4a
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.bQ2 r6 = r4.f
            ir.nasim.Nv5 r5 = r6.T1(r5)
            r0.c = r3
            r6 = 0
            java.lang.Object r5 = ir.nasim.AbstractC6756Ov5.d(r5, r6, r0, r3, r6)
            if (r5 != r1) goto L4a
            return r1
        L4a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.q6(ir.nasim.d25, ir.nasim.rm1):java.lang.Object");
    }

    public final SettingsModule q7() {
        return this.d;
    }

    public final boolean q8() {
        return this.d.u2();
    }

    public final void qa() {
        Object value;
        JQ0 jq0;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g1;
        do {
            value = interfaceC9336Zm4.getValue();
            jq0 = (JQ0) value;
        } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : null, (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
    }

    public final void qb(String str, Map map) {
        AbstractC13042fc3.i(str, "eventName");
        AbstractC13042fc3.i(map, "params");
        C3343Am.i(str, map);
    }

    public final void r4(String str, Context context, final long j, final C6833Pe1 c6833Pe1) {
        AbstractC13042fc3.i(str, "phone");
        AbstractC13042fc3.i(c6833Pe1, "content");
        if (context == null) {
            C19406qI3.j("ChatViewModel", "Return from addUserToMyContacts, because context is null!", new Object[0]);
        } else {
            final ProgressDialog progressDialogE = C8920Xu5.e(context, true);
            this.h.h0(str).m0(new InterfaceC24449ye1() { // from class: ir.nasim.KQ0
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    ChatViewModel.s4(this.a, progressDialogE, c6833Pe1, j, (C4382Ew7) obj);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r6(int r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ir.nasim.chat.ChatViewModel.X
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.chat.ChatViewModel$X r0 = (ir.nasim.chat.ChatViewModel.X) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.chat.ChatViewModel$X r0 = new ir.nasim.chat.ChatViewModel$X
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
            java.lang.Object r5 = r6.l()
            goto L4a
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.OK7 r6 = r4.g
            ir.nasim.Nv5 r5 = r6.j0(r5)
            r0.c = r3
            r6 = 0
            java.lang.Object r5 = ir.nasim.AbstractC6756Ov5.d(r5, r6, r0, r3, r6)
            if (r5 != r1) goto L4a
            return r1
        L4a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.r6(int, ir.nasim.rm1):java.lang.Object");
    }

    public final int r7() {
        return this.d.A3();
    }

    public final void r9(ArrayList arrayList) {
        AbstractC13042fc3.i(arrayList, "range");
        IF3 if3 = this.e1;
        int peerId = this.z1.getPeerId();
        long jU = this.z1.u();
        C14733iO2 c14733iO2 = this.L1;
        if3.d(arrayList, peerId, jU, (c14733iO2 != null ? c14733iO2.q() : null) == ZN2.CHANNEL);
    }

    public final void ra() {
        Object value;
        JQ0 jq0;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g1;
        do {
            value = interfaceC9336Zm4.getValue();
            jq0 = (JQ0) value;
        } while (!interfaceC9336Zm4.f(value, jq0.a((262142 & 1) != 0 ? jq0.a : null, (262142 & 2) != 0 ? jq0.b : null, (262142 & 4) != 0 ? jq0.c : null, (262142 & 8) != 0 ? jq0.d : null, (262142 & 16) != 0 ? jq0.e : false, (262142 & 32) != 0 ? jq0.f : null, (262142 & 64) != 0 ? jq0.g : null, (262142 & 128) != 0 ? jq0.h : null, (262142 & 256) != 0 ? jq0.i : null, (262142 & 512) != 0 ? jq0.j : null, (262142 & 1024) != 0 ? jq0.k : null, (262142 & 2048) != 0 ? jq0.l : null, (262142 & 4096) != 0 ? jq0.m : new WO5.a(AbstractC9766aX0.e(new VO5(AbstractC9766aX0.e(AbstractC13790gp3.f.a)))), (262142 & 8192) != 0 ? jq0.n : null, (262142 & 16384) != 0 ? jq0.o : null, (262142 & 32768) != 0 ? jq0.p : null, (262142 & 65536) != 0 ? jq0.q : null, (262142 & 131072) != 0 ? jq0.r : null)));
    }

    public final InterfaceC13730gj3 rb(Context context, SharedContent.MediaContent mediaContent, long j, long j2) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(mediaContent, "sharedContent");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new h1(context, mediaContent, j, j2, null), 3, null);
    }

    public final void rc() {
        AbstractC10533bm0.d(this.V0, null, null, new t1(null), 3, null);
    }

    public final InterfaceC13730gj3 s5() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new H(null), 3, null);
    }

    public final boolean s9(J44 j44) {
        J44 j44A;
        return j44 == null || j44.i() == C24539yn1.P.b().i() || ((j44A = F84.l.a()) != null && j44.i() == j44A.i());
    }

    public final void sa() {
        Nc(new UA2() { // from class: ir.nasim.oR0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ChatViewModel.ta((JQ0) obj);
            }
        });
    }

    public final void sc() {
        this.Y.D(this.z1, EnumC5360Iz7.c);
    }

    public final InterfaceC13730gj3 t4(long j, List list, long j2) {
        AbstractC13042fc3.i(list, "optionIds");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new C11170j(j, list, j2, null), 2, null);
    }

    public final void t5() {
        this.w2.b();
    }

    public final HM2 t6() {
        return this.L2;
    }

    public final InterfaceC4557Fq2 t7() {
        return this.y1;
    }

    public final InterfaceC13730gj3 tb(Context context, long j, long j2) {
        AbstractC13042fc3.i(context, "context");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12798fB4.b, null, new i1(j, j2, context, null), 2, null);
    }

    public final void tc(long j, long j2) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.b, null, new v1(j, j2, null), 2, null);
    }

    public final ZN2 u6() {
        return this.A1 == ExPeerType.CHANNEL ? ZN2.CHANNEL : ZN2.GROUP;
    }

    public final boolean u7() {
        return this.H1;
    }

    public final void u9(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "callback");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C11185q0(ua2, this, null), 3, null);
    }

    public final void ua() {
        this.W0.g("toggle_suggestion_channels", true);
    }

    public final void uc(int i, String str) {
        AbstractC13042fc3.i(str, "comment");
        AbstractC10533bm0.d(this.V0, null, null, new w1(i, str, null), 3, null);
    }

    public final C19482qQ7 v6(int i) {
        return this.Y.A(i).a();
    }

    public final InterfaceC10258bL6 v7() {
        return this.E2;
    }

    public final C5246In1 v8(C5246In1 c5246In1, J44 j44, SA2 sa2) {
        SZ2 sz2;
        AbstractC13042fc3.i(c5246In1, "value");
        AbstractC13042fc3.i(sa2, "messagesAdapterProvider");
        this.N1 = c5246In1;
        if (H8()) {
            return this.N1;
        }
        C5246In1 c5246In12 = this.N1;
        if (c5246In12 != null && (sz2 = (SZ2) sa2.invoke()) != null) {
            sz2.m(c5246In12);
        }
        s8(j44);
        return this.N1;
    }

    public final void v9() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C11187r0(null), 3, null);
    }

    public final void va() {
        this.U1 = ((Number) this.Y1.getValue()).intValue();
    }

    public final void vb(C10240bJ6 c10240bJ6) {
        AbstractC13042fc3.i(c10240bJ6, DialogEntity.COLUMN_MESSAGE);
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new j1(c10240bJ6, null), 3, null);
    }

    public final boolean vc() {
        boolean z = !this.W0.h("toggle_suggestion_channels", false);
        this.W0.g("toggle_suggestion_channels", z);
        return z;
    }

    public final void w4() {
        this.d.X6(true);
    }

    public final C14733iO2 w6() {
        return this.L1;
    }

    public final C6517Nv5 w7(final long j) {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.WQ0
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                ChatViewModel.x7(this.a, j, c7234Qv5);
            }
        });
    }

    public final void wa() {
        Nc(new UA2() { // from class: ir.nasim.nR0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ChatViewModel.xa((JQ0) obj);
            }
        });
    }

    public final void wb(C25238zy c25238zy) {
        AbstractC13042fc3.i(c25238zy, "apiGroupOutPeer");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new k1(c25238zy, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object wc(java.util.List r5, boolean r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ir.nasim.chat.ChatViewModel.x1
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.chat.ChatViewModel$x1 r0 = (ir.nasim.chat.ChatViewModel.x1) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.chat.ChatViewModel$x1 r0 = new ir.nasim.chat.ChatViewModel$x1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r5 = r7.l()
            goto L47
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.Nd5 r7 = r4.S0
            ir.nasim.d25 r2 = r4.z1
            r0.c = r3
            java.lang.Object r5 = r7.b(r5, r2, r6, r0)
            if (r5 != r1) goto L47
            return r1
        L47:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.wc(java.util.List, boolean, ir.nasim.rm1):java.lang.Object");
    }

    public final InterfaceC10258bL6 x4(long j, long j2) {
        Map map = this.h2;
        XV4 xv4A = AbstractC4616Fw7.a(Long.valueOf(j), Long.valueOf(j2));
        Object objA = map.get(xv4A);
        if (objA == null) {
            objA = AbstractC12281eL6.a(AbstractC10360bX0.m());
            map.put(xv4A, objA);
        }
        return AbstractC6459Nq2.c((InterfaceC9336Zm4) objA);
    }

    public final void x5() {
        this.g.w0(AbstractC15401jX0.m1(C6()), false).m0(new InterfaceC24449ye1() { // from class: ir.nasim.aR0
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ChatViewModel.y5(this.a, (C14505i18) obj);
            }
        });
    }

    public final C14733iO2 x6(long j) {
        return (C14733iO2) this.f.Y1().n(j);
    }

    public final void x8(int i, boolean z) {
        if (this.C2) {
            return;
        }
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C11173k0(i, z, null), 3, null);
    }

    public final void xb(C11458d25 c11458d25, C23698xM6 c23698xM6, Long l, Long l2, C7880To7 c7880To7) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(c23698xM6, "sticker");
        this.v.G2(c11458d25, c23698xM6, l, l2, c7880To7);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object xc(int r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ir.nasim.chat.ChatViewModel.y1
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.chat.ChatViewModel$y1 r0 = (ir.nasim.chat.ChatViewModel.y1) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.chat.ChatViewModel$y1 r0 = new ir.nasim.chat.ChatViewModel$y1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
            java.lang.Object r5 = r6.l()
            goto L4a
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.OK7 r6 = r4.g
            ir.nasim.Nv5 r5 = r6.C0(r5)
            r0.c = r3
            r6 = 0
            java.lang.Object r5 = ir.nasim.AbstractC6756Ov5.d(r5, r6, r0, r3, r6)
            if (r5 != r1) goto L4a
            return r1
        L4a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.ChatViewModel.xc(int, ir.nasim.rm1):java.lang.Object");
    }

    public final C11458d25 y6() {
        return this.B1;
    }

    public final void ya() {
        this.S1 = 0;
    }

    public final void yb(int i, int i2, String str, int i3, int i4, int i5) {
        AbstractC13042fc3.i(str, "peerType");
        pb("recommended_channels", AbstractC20051rO3.n(AbstractC4616Fw7.a("random_id", Integer.valueOf(i)), AbstractC4616Fw7.a("peer_id", Integer.valueOf(i2)), AbstractC4616Fw7.a("peer_type", str), AbstractC4616Fw7.a("source_id", Integer.valueOf(i3)), AbstractC4616Fw7.a("origin", Integer.valueOf(i4)), AbstractC4616Fw7.a("action_type", Integer.valueOf(i5))));
    }

    public final void yc(J44 j44, SA2 sa2, UA2 ua2, UA2 ua22) {
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(sa2, "navigateToCreatePass");
        AbstractC13042fc3.i(ua2, "navigateToValidatePass");
        AbstractC13042fc3.i(ua22, "registerNavigateResult");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new z1(j44, sa2, ua2, ua22, null), 3, null);
    }

    public final String z6() {
        return this.d.A2();
    }

    public final boolean z7() {
        return this.W0.h("toggle_suggestion_channels", false);
    }

    public final InterfaceC13730gj3 za(long j, long j2) {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.b, null, new O0(j, j2, null), 2, null);
    }
}
