package ir.nasim;

import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.features.conversation.messages.content.CircleProgressBar;

/* renamed from: ir.nasim.Fd2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class ViewOnClickListenerC4440Fd2 extends AbstractC22092uf0 implements View.OnClickListener {
    private final TextView A;
    private String A0;
    private final CircleProgressBar B;
    private int B0;
    private String C0;
    private final ImageView D;
    private InterfaceC7857Tm2 D0;
    private C11603dH7 E0;
    private T74 F0;
    protected C18823pJ2 G;
    private AbstractC17683nO G0;
    private boolean H;
    private QN H0;
    private VL I0;
    private String J;
    private float Y;
    private boolean Z;
    private final C15319jO w;
    private final ImageView x;
    private final TextView y;
    private final TextView z;
    private String z0;

    /* renamed from: ir.nasim.Fd2$a */
    class a implements InterfaceC8807Xk2 {
        final /* synthetic */ FileReference a;

        a(FileReference fileReference) {
            this.a = fileReference;
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void c(float f) {
            AbstractC5969Lp4.d().s(this.a.getFileId());
            ViewOnClickListenerC4440Fd2.this.H = false;
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            ViewOnClickListenerC4440Fd2.this.H = false;
            ViewOnClickListenerC4440Fd2.this.J1(interfaceC3346Am2.getDescriptor());
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void e() {
            ViewOnClickListenerC4440Fd2.this.H = true;
            if (C5505Jq.F()) {
                AbstractC5969Lp4.d().F1(this.a);
            }
        }
    }

    /* renamed from: ir.nasim.Fd2$b */
    class b extends AbstractC17683nO {
        b() {
        }

        @Override // ir.nasim.AbstractC17683nO
        public void c(VL vl) {
            if (vl.d().equals(ViewOnClickListenerC4440Fd2.this.F0)) {
                ViewOnClickListenerC4440Fd2.this.I1();
            }
        }

        @Override // ir.nasim.AbstractC17683nO
        public void f(VL vl) {
            if (vl.d().equals(ViewOnClickListenerC4440Fd2.this.F0)) {
                ViewOnClickListenerC4440Fd2.this.F1();
            }
        }

        @Override // ir.nasim.AbstractC17683nO
        public void g(VL vl) {
            if (vl.d().equals(ViewOnClickListenerC4440Fd2.this.F0)) {
                ViewOnClickListenerC4440Fd2.this.H1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ir.nasim.Fd2$c */
    class c implements InterfaceC8091Um2 {
        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(QN qn) {
            ViewOnClickListenerC4440Fd2 viewOnClickListenerC4440Fd2 = ViewOnClickListenerC4440Fd2.this;
            viewOnClickListenerC4440Fd2.A0 = ((C8552Wl4) viewOnClickListenerC4440Fd2.I0).j();
            ViewOnClickListenerC4440Fd2 viewOnClickListenerC4440Fd22 = ViewOnClickListenerC4440Fd2.this;
            viewOnClickListenerC4440Fd22.z0 = ((C8552Wl4) viewOnClickListenerC4440Fd22.I0).h();
            ViewOnClickListenerC4440Fd2 viewOnClickListenerC4440Fd23 = ViewOnClickListenerC4440Fd2.this;
            viewOnClickListenerC4440Fd23.o1(viewOnClickListenerC4440Fd23.A0);
            ViewOnClickListenerC4440Fd2 viewOnClickListenerC4440Fd24 = ViewOnClickListenerC4440Fd2.this;
            viewOnClickListenerC4440Fd24.n1(viewOnClickListenerC4440Fd24.z0);
            ViewOnClickListenerC4440Fd2.this.z1();
            ViewOnClickListenerC4440Fd2.this.y1(qn);
            ViewOnClickListenerC4440Fd2.this.O1();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ C19938rB7 h(final QN qn) {
            if (qn == null) {
                return null;
            }
            ViewOnClickListenerC4440Fd2.this.H0 = qn;
            ViewOnClickListenerC4440Fd2 viewOnClickListenerC4440Fd2 = ViewOnClickListenerC4440Fd2.this;
            viewOnClickListenerC4440Fd2.I0 = RN.a((C8552Wl4) viewOnClickListenerC4440Fd2.I0, qn);
            AbstractC7426Rr.P(new Runnable() { // from class: ir.nasim.Hd2
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.f(qn);
                }
            });
            return null;
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
            ViewOnClickListenerC4440Fd2.this.D1();
            ViewOnClickListenerC4440Fd2.this.B1(f);
            ViewOnClickListenerC4440Fd2.this.B.setValue((int) (f * 100.0f));
            AbstractC14828iY7.l(ViewOnClickListenerC4440Fd2.this.B);
            ViewOnClickListenerC4440Fd2.this.H = false;
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            ViewOnClickListenerC4440Fd2.this.A1(interfaceC3346Am2.getDescriptor());
            AbstractC14828iY7.c(ViewOnClickListenerC4440Fd2.this.B);
            ViewOnClickListenerC4440Fd2.this.O1();
            if (ViewOnClickListenerC4440Fd2.this.Z) {
                C13519gN.a.K(ViewOnClickListenerC4440Fd2.this.C0, new UA2() { // from class: ir.nasim.Gd2
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return this.a.h((QN) obj);
                    }
                });
            }
            ViewOnClickListenerC4440Fd2.this.H = false;
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void e() {
            AbstractC14828iY7.c(ViewOnClickListenerC4440Fd2.this.B);
            ViewOnClickListenerC4440Fd2.this.l1();
            ViewOnClickListenerC4440Fd2.this.H = true;
            ViewOnClickListenerC4440Fd2.this.M1();
        }

        private c() {
        }
    }

    /* renamed from: ir.nasim.Fd2$d */
    private class d implements InterfaceC12246eH7 {
        @Override // ir.nasim.InterfaceC12246eH7
        public void b() {
            AbstractC14828iY7.c(ViewOnClickListenerC4440Fd2.this.B);
            ViewOnClickListenerC4440Fd2.this.F1();
        }

        @Override // ir.nasim.InterfaceC12246eH7
        public void f(float f, int i) {
            ViewOnClickListenerC4440Fd2.this.D1();
            ViewOnClickListenerC4440Fd2.this.B.setValue((int) (f * 100.0f));
            AbstractC14828iY7.l(ViewOnClickListenerC4440Fd2.this.B);
        }

        @Override // ir.nasim.InterfaceC12246eH7
        public void k() {
            ViewOnClickListenerC4440Fd2.this.E1(KB5.upload_voice);
        }

        private d() {
        }
    }

    public ViewOnClickListenerC4440Fd2(C15319jO c15319jO, View view) {
        super(view);
        this.z0 = "";
        this.A0 = "";
        this.w = c15319jO;
        this.x = (ImageView) view.findViewById(BC5.audio_icon);
        this.D = (ImageView) view.findViewById(BC5.cover);
        TextView textView = (TextView) view.findViewById(BC5.audio_title);
        this.y = textView;
        this.z = (TextView) view.findViewById(BC5.audio_info);
        TextView textView2 = (TextView) view.findViewById(BC5.audio_artist);
        this.A = textView2;
        CircleProgressBar circleProgressBar = (CircleProgressBar) view.findViewById(BC5.audio_progressView);
        this.B = circleProgressBar;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        circleProgressBar.setBgColor(c5495Jo7.h2());
        circleProgressBar.setColor(c5495Jo7.i2());
        circleProgressBar.setMaxValue(100);
        textView.setTypeface(C6011Lu2.k());
        textView2.setTypeface(C6011Lu2.k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B1(float f) {
        this.z.setText(AbstractC7426Rr.E(f * this.Y) + " / " + this.J);
    }

    private void C1() {
        this.D.setImageDrawable(new ColorDrawable(this.a.getContext().getResources().getColor(TA5.secondary)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D1() {
        E1(KB5.close_tab);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E1(int i) {
        this.x.setImageResource(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F1() {
        E1(KB5.player_play_audio);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H1() {
        E1(KB5.player_pause_audio);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I1() {
        F1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J1(String str) {
        if (this.F0 == null) {
            C19406qI3.b("ExoPlayListAudioHolder", "togglePlayAudio: currentMessageId is null!");
            return;
        }
        J44 j44 = new J44(this.G.i(), this.G.u(), this.G.r().longValue(), this.G.s(), EnumC23558x74.SENT, this.G.q());
        C23709xO c23709xO = C23709xO.a;
        if (this.I0 == null) {
            this.I0 = RN.b(str, false, j44, this.F0, this.H0);
        }
        if (c23709xO.x(this.I0)) {
            c23709xO.v(this.I0);
        } else {
            c23709xO.y(this.I0);
        }
    }

    private void L1() {
        String strA = C17959nq7.a.a(this.B0 / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
        if (JF5.g()) {
            strA = XY6.e(strA);
        }
        this.z.setText(strA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M1() {
        this.z.setText(this.J);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O1() {
        C23709xO c23709xO = C23709xO.a;
        T74 t74L = c23709xO.l();
        if (t74L == null || !t74L.equals(this.F0)) {
            I1();
        } else if (c23709xO.i()) {
            H1();
        } else {
            F1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l1() {
        if (this.x == null) {
            return;
        }
        if (C5505Jq.F()) {
            E1(KB5.player_download_audio);
        } else {
            E1(KB5.ic_lock_white_24dp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n1(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.A.setVisibility(0);
        this.A.setText(" , " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.y.setVisibility(0);
        this.y.setText(str);
    }

    private void s1(C18823pJ2 c18823pJ2) {
        T74 t74 = this.F0;
        if (t74 != null && t74.e() == r1() && this.F0.f() == c18823pJ2.i() && this.F0.d() == c18823pJ2.r().longValue()) {
            return;
        }
        this.F0 = new T74(r1(), c18823pJ2.i(), c18823pJ2.r().longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u1(View view) {
        C24967zW1 c24967zW1 = (C24967zW1) this.G.q();
        if (c24967zW1.z() instanceof C11920dm2) {
            FileReference fileReferenceB = ((C11920dm2) c24967zW1.z()).b();
            AbstractC5969Lp4.d().v1(fileReferenceB.getFileId(), fileReferenceB.getAccessHash(), new a(fileReferenceB));
        }
    }

    private void x1() {
        C23709xO c23709xO = C23709xO.a;
        b bVar = new b();
        this.G0 = bVar;
        c23709xO.u(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y1(QN qn) {
        if (qn.h() != null) {
            this.D.setImageBitmap(qn.h());
        } else {
            C1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z1() {
        int iB = (int) this.I0.b();
        this.B0 = iB;
        if (iB != 0) {
            L1();
        }
    }

    void A1(String str) {
        this.C0 = str;
        this.I0.e(str);
    }

    public void a() {
        this.G = null;
        InterfaceC7857Tm2 interfaceC7857Tm2 = this.D0;
        if (interfaceC7857Tm2 != null) {
            interfaceC7857Tm2.a(true);
            this.D0 = null;
            this.H0 = null;
        }
        C11603dH7 c11603dH7 = this.E0;
        if (c11603dH7 != null) {
            c11603dH7.b();
            this.E0 = null;
        }
        AbstractC17683nO abstractC17683nO = this.G0;
        if (abstractC17683nO != null) {
            C23709xO.a.z0(abstractC17683nO);
        }
        this.z0 = "";
        this.A0 = "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j1(C18823pJ2 c18823pJ2) {
        C18823pJ2 c18823pJ22;
        Object[] objArr;
        C18823pJ2 c18823pJ23 = this.G;
        if (c18823pJ23 == null || c18823pJ23.i() != c18823pJ2.i()) {
            c18823pJ22 = c18823pJ2;
            objArr = true;
        } else {
            c18823pJ22 = c18823pJ2;
            objArr = false;
        }
        this.G = c18823pJ22;
        s1(c18823pJ2);
        if (c18823pJ2.q() instanceof TM) {
            TM tm = (TM) c18823pJ2.q();
            this.J = p1(tm);
            this.Y = q1(tm);
            this.Z = tm.J();
            Object[] objArr2 = 0;
            this.I0 = RN.b(C18274oO.a.a(), false, new J44(this.G.i(), this.G.u(), this.G.r().longValue(), this.G.s(), EnumC23558x74.SENT, this.G.q()), this.F0, null);
            z1();
            this.z0 = ((C8552Wl4) this.I0).h();
            this.A0 = ((C8552Wl4) this.I0).j();
            if (objArr != false) {
                C1();
                InterfaceC7857Tm2 interfaceC7857Tm2 = this.D0;
                if (interfaceC7857Tm2 != null) {
                    interfaceC7857Tm2.a(true);
                    this.D0 = null;
                }
                C11603dH7 c11603dH7 = this.E0;
                if (c11603dH7 != null) {
                    c11603dH7.b();
                    this.E0 = null;
                }
                if (tm.z() instanceof C11920dm2) {
                    this.D0 = C5735Kp4.w().i().q(((C11920dm2) tm.z()).b(), AbstractC5969Lp4.d().n0(t1()), new c());
                } else {
                    if (!(tm.z() instanceof C4512Fl2)) {
                        throw new RuntimeException("Unknown file source type: " + tm.z());
                    }
                    this.E0 = C5735Kp4.w().i().r(c18823pJ2.i(), new d());
                    A1(((C4512Fl2) tm.z()).c);
                }
            }
        }
        o1(this.A0);
        n1(this.z0);
        if (this.H) {
            l1();
        }
        x1();
        this.x.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Ed2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.u1(view);
            }
        });
    }

    protected String p1(C24967zW1 c24967zW1) {
        return AbstractC7426Rr.E(c24967zW1.z().f() / 1024);
    }

    protected float q1(C24967zW1 c24967zW1) {
        return c24967zW1.z().f() / 1024;
    }

    public C11458d25 r1() {
        return this.w.J();
    }

    protected boolean t1() {
        return ((EnumC19739qr4) AbstractC5969Lp4.d().Y().v().E().h().b()) == EnumC19739qr4.MOBILE;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
