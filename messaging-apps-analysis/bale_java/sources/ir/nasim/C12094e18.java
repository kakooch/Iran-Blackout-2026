package ir.nasim;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.CP;
import ir.nasim.InterfaceC17445my6;
import ir.nasim.TY1;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.features.conversation.messages.content.CircleProgressBar;
import livekit.org.webrtc.MediaStreamTrack;

/* renamed from: ir.nasim.e18, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C12094e18 extends AbstractC5350Iy6 {
    private UA2 A0;
    private AbstractC17683nO B0;
    private final C10049az6 Y;
    private final InterfaceC10258bL6 Z;
    private final C11458d25 z0;

    /* renamed from: ir.nasim.e18$a */
    public static final class a extends AbstractC17683nO {
        a() {
        }

        @Override // ir.nasim.AbstractC17683nO
        public void a(VL vl) {
            if (C12094e18.this.r1(vl)) {
                C12094e18.this.Y.h.setImageResource(AbstractC22412vB5.new_stop);
            }
        }

        @Override // ir.nasim.AbstractC17683nO
        public void c(VL vl) {
            AbstractC13042fc3.i(vl, MediaStreamTrack.AUDIO_TRACK_KIND);
            if (C12094e18.this.r1(vl)) {
                C12094e18.this.Y.h.setImageResource(AbstractC22412vB5.ic_play);
            }
        }

        @Override // ir.nasim.AbstractC17683nO
        public void e() {
            C12094e18.this.t1();
        }

        @Override // ir.nasim.AbstractC17683nO
        public void f(VL vl) {
            AbstractC13042fc3.i(vl, MediaStreamTrack.AUDIO_TRACK_KIND);
            if (C12094e18.this.r1(vl)) {
                C12094e18.this.Y.h.setImageResource(AbstractC22412vB5.ic_play);
            }
        }

        @Override // ir.nasim.AbstractC17683nO
        public void g(VL vl) {
            AbstractC13042fc3.i(vl, MediaStreamTrack.AUDIO_TRACK_KIND);
            if (C12094e18.this.r1(vl)) {
                C12094e18.this.Y.h.setImageResource(AbstractC22412vB5.new_stop);
            }
        }
    }

    /* renamed from: ir.nasim.e18$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC17445my6 c;
        final /* synthetic */ C12094e18 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC17445my6 interfaceC17445my6, C12094e18 c12094e18, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC17445my6;
            this.d = c12094e18;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                CP.a aVar = CP.D0;
                C18823pJ2 content = this.c.getContent();
                TY1 ty1D = this.c.d();
                AbstractC13042fc3.g(ty1D, "null cannot be cast to non-null type ir.nasim.sharedmedia.ui.state.DownloadState.Downloaded");
                InterfaceC3346Am2 interfaceC3346Am2A = ((TY1.a) ty1D).a();
                String descriptor = interfaceC3346Am2A != null ? interfaceC3346Am2A.getDescriptor() : null;
                C11458d25 c11458d25 = this.d.z0;
                this.b = 1;
                obj = aVar.a(content, descriptor, true, c11458d25, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            VL vl = (VL) obj;
            if (vl != null) {
                C23709xO.a.y(vl);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.e18$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ FileReference d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(FileReference fileReference, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = fileReference;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12094e18.this.new c(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                QF2 qf2C0 = C12094e18.this.T0().C0();
                long fileId = this.d.getFileId();
                long accessHash = this.d.getAccessHash();
                InterfaceC8807Xk2 interfaceC8807Xk2P0 = C12094e18.this.P0();
                this.b = 1;
                if (qf2C0.m(fileId, accessHash, interfaceC8807Xk2P0, (8 & 8) != 0 ? false : false, this) == objE) {
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
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.e18$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC3346Am2 c;
        final /* synthetic */ C12094e18 d;
        final /* synthetic */ InterfaceC17445my6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(InterfaceC3346Am2 interfaceC3346Am2, C12094e18 c12094e18, InterfaceC17445my6 interfaceC17445my6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC3346Am2;
            this.d = c12094e18;
            this.e = interfaceC17445my6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC3346Am2 interfaceC3346Am2 = this.c;
            String descriptor = interfaceC3346Am2 != null ? interfaceC3346Am2.getDescriptor() : null;
            if (descriptor != null && descriptor.length() != 0) {
                this.d.Y.c.setChecked(this.e.a());
                if (((Boolean) this.d.Z.getValue()).booleanValue()) {
                    this.d.Y.c.setVisibility(0);
                } else {
                    this.d.Y.c.setVisibility(8);
                }
                C23709xO c23709xO = C23709xO.a;
                if (c23709xO.i() && this.d.r1(c23709xO.M())) {
                    AbstractC17683nO abstractC17683nO = this.d.B0;
                    if (abstractC17683nO != null) {
                        VL vlM = c23709xO.M();
                        AbstractC13042fc3.f(vlM);
                        abstractC17683nO.g(vlM);
                    }
                } else {
                    this.d.Y.h.setImageResource(AbstractC22412vB5.ic_play);
                }
                this.d.Y.b.setVisibility(8);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.e18$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC17445my6 d;
        final /* synthetic */ float e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(InterfaceC17445my6 interfaceC17445my6, float f, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC17445my6;
            this.e = f;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12094e18.this.new e(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C12094e18.this.Y.c.setChecked(this.d.a());
            if (((Boolean) C12094e18.this.Z.getValue()).booleanValue()) {
                C12094e18.this.Y.c.setVisibility(0);
            } else {
                C12094e18.this.Y.c.setVisibility(8);
            }
            C12094e18.this.Y.b.setVisibility(0);
            C12094e18.this.Y.b.setValue((int) (this.e * 100));
            C12094e18.this.Y.h.setImageResource(AbstractC22412vB5.close_tab);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.e18$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC17445my6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(InterfaceC17445my6 interfaceC17445my6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC17445my6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12094e18.this.new f(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C12094e18.this.Y.c.setChecked(this.d.a());
            if (((Boolean) C12094e18.this.Z.getValue()).booleanValue()) {
                C12094e18.this.Y.c.setVisibility(0);
            } else {
                C12094e18.this.Y.c.setVisibility(8);
            }
            C12094e18.this.Y.b.setVisibility(8);
            C12094e18.this.Y.h.setImageResource(AbstractC22412vB5.ba_music_download);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C12094e18(C10049az6 c10049az6, InterfaceC10258bL6 interfaceC10258bL6, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua2, InterfaceC20315ro1 interfaceC20315ro1, C11458d25 c11458d25) {
        AbstractC13042fc3.i(c10049az6, "binding");
        AbstractC13042fc3.i(interfaceC10258bL6, "isSelectedMode");
        AbstractC13042fc3.i(interfaceC14603iB2, "onLongClickListener");
        AbstractC13042fc3.i(ua2, "onItemSelectChange");
        AbstractC13042fc3.i(interfaceC20315ro1, "observableCoroutineScope");
        AbstractC13042fc3.i(c11458d25, "peer");
        LinearLayout linearLayoutB = c10049az6.getRoot();
        AbstractC13042fc3.h(linearLayoutB, "getRoot(...)");
        LinearLayout linearLayout = c10049az6.e;
        AbstractC13042fc3.h(linearLayout, "contentContainer");
        AppCompatCheckBox appCompatCheckBox = c10049az6.c;
        AbstractC13042fc3.h(appCompatCheckBox, "chbSelected");
        super(interfaceC10258bL6, ua2, interfaceC14603iB2, interfaceC20315ro1, linearLayoutB, linearLayout, appCompatCheckBox);
        this.Y = c10049az6;
        this.Z = interfaceC10258bL6;
        this.z0 = c11458d25;
        this.A0 = new UA2() { // from class: ir.nasim.c18
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C12094e18.s1(this.a, (InterfaceC17445my6) obj);
            }
        };
        super.V0();
        CircleProgressBar circleProgressBar = c10049az6.b;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        circleProgressBar.setBgColor(c5495Jo7.h2());
        c10049az6.b.setColor(c5495Jo7.i2());
        c10049az6.b.setMaxValue(100);
        AppCompatImageView appCompatImageView = c10049az6.h;
        Context context = c10049az6.getRoot().getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        appCompatImageView.setColorFilter(C5495Jo7.F0(context, FA5.color3_2));
        c10049az6.f.setTypeface(C6011Lu2.k());
        c10049az6.g.setTypeface(C6011Lu2.k());
        c10049az6.i.setTypeface(C6011Lu2.k());
        c10049az6.d.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.d18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C12094e18.j1(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(C12094e18 c12094e18, View view) {
        AbstractC13042fc3.i(c12094e18, "this$0");
        InterfaceC17445my6 interfaceC17445my6S0 = c12094e18.S0();
        if (interfaceC17445my6S0 != null) {
            c12094e18.Q0().invoke(interfaceC17445my6S0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s1(C12094e18 c12094e18, InterfaceC17445my6 interfaceC17445my6) {
        AbstractC13042fc3.i(c12094e18, "this$0");
        AbstractC13042fc3.i(interfaceC17445my6, "item");
        TY1 ty1D = interfaceC17445my6.d();
        if (ty1D instanceof TY1.b) {
            InterfaceC17445my6.a.b(interfaceC17445my6);
        } else if (ty1D instanceof TY1.a) {
            C23709xO c23709xO = C23709xO.a;
            if (c23709xO.i() && c12094e18.r1(c23709xO.M())) {
                c23709xO.h();
            } else {
                AbstractC10533bm0.d(c12094e18.O0(), null, null, new b(interfaceC17445my6, c12094e18, null), 3, null);
            }
        } else if (ty1D instanceof TY1.c) {
            InterfaceC17445my6.a.e(interfaceC17445my6);
        }
        return C19938rB7.a;
    }

    private final String u1(long j) {
        return XY6.v(C17959nq7.a.a((int) (j / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT)));
    }

    @Override // ir.nasim.AbstractC5350Iy6
    public UA2 Q0() {
        return this.A0;
    }

    @Override // ir.nasim.AbstractC5350Iy6
    public void c1(InterfaceC17445my6 interfaceC17445my6, InterfaceC3346Am2 interfaceC3346Am2) {
        AbstractC13042fc3.i(interfaceC17445my6, "item");
        interfaceC17445my6.e(new TY1.a(interfaceC3346Am2));
        AbstractC10533bm0.d(O0(), null, null, new d(interfaceC3346Am2, this, interfaceC17445my6, null), 3, null);
    }

    @Override // ir.nasim.AbstractC5350Iy6
    public void d1(InterfaceC17445my6 interfaceC17445my6, float f2) {
        AbstractC13042fc3.i(interfaceC17445my6, "item");
        interfaceC17445my6.e(new TY1.b((int) (interfaceC17445my6.f() * f2)));
        AbstractC10533bm0.d(O0(), null, null, new e(interfaceC17445my6, f2, null), 3, null);
    }

    @Override // ir.nasim.AbstractC5350Iy6
    public void e1(InterfaceC17445my6 interfaceC17445my6) {
        AbstractC13042fc3.i(interfaceC17445my6, "item");
        interfaceC17445my6.e(TY1.c.a);
        AbstractC10533bm0.d(O0(), null, null, new f(interfaceC17445my6, null), 3, null);
    }

    @Override // ir.nasim.AbstractC5350Iy6
    public void f1() {
        super.f1();
        AbstractC17683nO abstractC17683nO = this.B0;
        if (abstractC17683nO != null) {
            C23709xO.a.z0(abstractC17683nO);
        }
    }

    public final void q1(InterfaceC17445my6.f fVar, long j) {
        super.M0(fVar, j);
        if (fVar != null) {
            a aVar = new a();
            this.B0 = aVar;
            C23709xO.a.u(aVar);
            if (j == -1) {
                this.Y.k.setVisibility(8);
                this.Y.j.setVisibility(0);
                C10049az6 c10049az6 = this.Y;
                TextView textView = c10049az6.j;
                Context context = c10049az6.getRoot().getContext();
                AbstractC13042fc3.h(context, "getContext(...)");
                textView.setText(C14593iA1.p(context, fVar.h(), false, true, 4, null));
            } else if (C14593iA1.K(fVar.h(), j)) {
                this.Y.k.setVisibility(8);
                this.Y.j.setVisibility(8);
            } else {
                this.Y.k.setVisibility(0);
                this.Y.j.setVisibility(0);
                C10049az6 c10049az62 = this.Y;
                TextView textView2 = c10049az62.j;
                Context context2 = c10049az62.getRoot().getContext();
                AbstractC13042fc3.h(context2, "getContext(...)");
                textView2.setText(C14593iA1.p(context2, fVar.h(), false, true, 4, null));
            }
            this.Y.i.setText(fVar.i());
            this.Y.g.setText(u1(fVar.g()));
            Context context3 = this.Y.getRoot().getContext();
            AbstractC13042fc3.h(context3, "getContext(...)");
            String strP = C14593iA1.p(context3, fVar.h(), true, false, 8, null);
            this.Y.f.setText("| " + strP);
        }
    }

    public final boolean r1(VL vl) {
        VL vlM;
        T74 t74D;
        C11458d25 c11458d25E;
        if (S0() == null || vl == null) {
            return false;
        }
        InterfaceC17445my6 interfaceC17445my6S0 = S0();
        AbstractC13042fc3.f(interfaceC17445my6S0);
        if (interfaceC17445my6S0.h() != vl.d().d()) {
            return false;
        }
        InterfaceC17445my6 interfaceC17445my6S02 = S0();
        AbstractC13042fc3.f(interfaceC17445my6S02);
        return (interfaceC17445my6S02.getContent().i() != vl.d().f() || (vlM = C23709xO.a.M()) == null || (t74D = vlM.d()) == null || (c11458d25E = t74D.e()) == null || this.z0.getPeerId() != c11458d25E.getPeerId()) ? false : true;
    }

    public final void t1() {
        FileReference fileReferenceB;
        InterfaceC17445my6 interfaceC17445my6S0 = S0();
        if (interfaceC17445my6S0 == null || (fileReferenceB = interfaceC17445my6S0.b()) == null) {
            return;
        }
        AbstractC10533bm0.d(U0(), null, null, new c(fileReferenceB, null), 3, null);
    }
}
