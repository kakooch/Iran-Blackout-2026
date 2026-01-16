package ir.nasim;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import ir.nasim.C9475a16;
import ir.nasim.InterfaceC17445my6;
import ir.nasim.TY1;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.features.conversation.messages.content.CircleProgressBar;
import livekit.org.webrtc.MediaStreamTrack;

/* loaded from: classes7.dex */
public final class CP extends AbstractC5350Iy6 {
    public static final a D0 = new a(null);
    public static final int E0 = 8;
    private final C11458d25 A0;
    private UA2 B0;
    private AbstractC17683nO C0;
    private final C16263ky6 Y;
    private final InterfaceC10258bL6 Z;
    private final UA2 z0;

    public static final class a {

        /* renamed from: ir.nasim.CP$a$a, reason: collision with other inner class name */
        static final class C0309a implements UA2 {
            final /* synthetic */ InterfaceC20295rm1 a;
            final /* synthetic */ String b;
            final /* synthetic */ boolean c;
            final /* synthetic */ J44 d;
            final /* synthetic */ T74 e;

            C0309a(InterfaceC20295rm1 interfaceC20295rm1, String str, boolean z, J44 j44, T74 t74) {
                this.a = interfaceC20295rm1;
                this.b = str;
                this.c = z;
                this.d = j44;
                this.e = t74;
            }

            public final void a(QN qn) {
                InterfaceC20295rm1 interfaceC20295rm1 = this.a;
                C9475a16.a aVar = C9475a16.b;
                interfaceC20295rm1.resumeWith(C9475a16.b(RN.b(this.b, this.c, this.d, this.e, qn)));
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((QN) obj);
                return C19938rB7.a;
            }
        }

        private a() {
        }

        public final Object a(C18823pJ2 c18823pJ2, String str, boolean z, C11458d25 c11458d25, InterfaceC20295rm1 interfaceC20295rm1) {
            if (str == null) {
                return null;
            }
            C16963m96 c16963m96 = new C16963m96(AbstractC14251hc3.c(interfaceC20295rm1));
            long jI = c18823pJ2.i();
            Long lR = c18823pJ2.r();
            AbstractC13042fc3.h(lR, "getDate(...)");
            T74 t74 = new T74(c11458d25, jI, lR.longValue());
            long jI2 = c18823pJ2.i();
            long jU = c18823pJ2.u();
            Long lR2 = c18823pJ2.r();
            AbstractC13042fc3.h(lR2, "getDate(...)");
            long jLongValue = lR2.longValue();
            int iS = c18823pJ2.s();
            EnumC23558x74 enumC23558x74 = EnumC23558x74.SENT;
            AbstractC17457n0 abstractC17457n0Q = c18823pJ2.q();
            AbstractC13042fc3.h(abstractC17457n0Q, "getContent(...)");
            C13519gN.a.K(str, new C0309a(c16963m96, str, z, new J44(jI2, jU, jLongValue, iS, enumC23558x74, abstractC17457n0Q, null, 0, null, null, 0L, null, null, false, null, null, false, null, null, 524224, null), t74));
            Object objA = c16963m96.a();
            if (objA == AbstractC14862ic3.e()) {
                WA1.c(interfaceC20295rm1);
            }
            return objA;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b extends AbstractC17683nO {
        b() {
        }

        @Override // ir.nasim.AbstractC17683nO
        public void a(VL vl) {
            if (CP.this.q1(vl)) {
                CP.this.Y.i.setImageResource(AbstractC22412vB5.new_stop);
            }
        }

        @Override // ir.nasim.AbstractC17683nO
        public void c(VL vl) {
            AbstractC13042fc3.i(vl, MediaStreamTrack.AUDIO_TRACK_KIND);
            if (CP.this.q1(vl)) {
                CP.this.Y.i.setImageResource(AbstractC22412vB5.ic_play);
            }
        }

        @Override // ir.nasim.AbstractC17683nO
        public void e() {
            CP.this.s1();
        }

        @Override // ir.nasim.AbstractC17683nO
        public void f(VL vl) {
            AbstractC13042fc3.i(vl, MediaStreamTrack.AUDIO_TRACK_KIND);
            if (CP.this.q1(vl)) {
                CP.this.Y.i.setImageResource(AbstractC22412vB5.ic_play);
            }
        }

        @Override // ir.nasim.AbstractC17683nO
        public void g(VL vl) {
            AbstractC13042fc3.i(vl, MediaStreamTrack.AUDIO_TRACK_KIND);
            if (CP.this.q1(vl)) {
                CP.this.Y.i.setImageResource(AbstractC22412vB5.new_stop);
            }
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC17445my6 c;
        final /* synthetic */ CP d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC17445my6 interfaceC17445my6, CP cp, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC17445my6;
            this.d = cp;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                a aVar = CP.D0;
                C18823pJ2 content = this.c.getContent();
                TY1 ty1D = this.c.d();
                AbstractC13042fc3.g(ty1D, "null cannot be cast to non-null type ir.nasim.sharedmedia.ui.state.DownloadState.Downloaded");
                InterfaceC3346Am2 interfaceC3346Am2A = ((TY1.a) ty1D).a();
                String descriptor = interfaceC3346Am2A != null ? interfaceC3346Am2A.getDescriptor() : null;
                C11458d25 c11458d25 = this.d.A0;
                this.b = 1;
                obj = aVar.a(content, descriptor, false, c11458d25, this);
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
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ FileReference d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(FileReference fileReference, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = fileReference;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return CP.this.new d(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                QF2 qf2C0 = CP.this.T0().C0();
                long fileId = this.d.getFileId();
                long accessHash = this.d.getAccessHash();
                InterfaceC8807Xk2 interfaceC8807Xk2P0 = CP.this.P0();
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
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC3346Am2 c;
        final /* synthetic */ CP d;
        final /* synthetic */ InterfaceC17445my6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(InterfaceC3346Am2 interfaceC3346Am2, CP cp, InterfaceC17445my6 interfaceC17445my6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC3346Am2;
            this.d = cp;
            this.e = interfaceC17445my6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new e(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC3346Am2 interfaceC3346Am2 = this.c;
                String descriptor = interfaceC3346Am2 != null ? interfaceC3346Am2.getDescriptor() : null;
                if (descriptor != null && descriptor.length() != 0) {
                    this.d.Y.d.setChecked(this.e.a());
                    if (((Boolean) this.d.Z.getValue()).booleanValue()) {
                        this.d.Y.d.setVisibility(0);
                    } else {
                        this.d.Y.d.setVisibility(8);
                    }
                    C23709xO c23709xO = C23709xO.a;
                    if (c23709xO.i() && this.d.q1(c23709xO.M())) {
                        AbstractC17683nO abstractC17683nO = this.d.C0;
                        if (abstractC17683nO != null) {
                            VL vlM = c23709xO.M();
                            AbstractC13042fc3.f(vlM);
                            abstractC17683nO.g(vlM);
                        }
                    } else {
                        this.d.Y.i.setImageResource(AbstractC22412vB5.ic_play);
                    }
                    this.d.Y.c.setVisibility(8);
                    if (this.e.getContent().q() instanceof TM) {
                        C13519gN c13519gN = C13519gN.a;
                        InterfaceC3346Am2 interfaceC3346Am22 = this.c;
                        AbstractC13042fc3.f(interfaceC3346Am22);
                        String descriptor2 = interfaceC3346Am22.getDescriptor();
                        this.b = 1;
                        obj = c13519gN.J(descriptor2, this);
                        if (obj == objE) {
                            return objE;
                        }
                    }
                }
                return C19938rB7.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            QN qn = (QN) obj;
            if ((qn != null ? qn.h() : null) != null) {
                this.d.Y.h.setImageBitmap(qn.h());
            } else {
                this.d.Y.h.setImageResource(FA5.primary_light);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC17445my6 d;
        final /* synthetic */ float e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(InterfaceC17445my6 interfaceC17445my6, float f, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC17445my6;
            this.e = f;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return CP.this.new f(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            CP.this.Y.h.setImageResource(FA5.primary_light);
            CP.this.Y.d.setChecked(this.d.a());
            if (((Boolean) CP.this.Z.getValue()).booleanValue()) {
                CP.this.Y.d.setVisibility(0);
            } else {
                CP.this.Y.d.setVisibility(8);
            }
            CP.this.Y.c.setVisibility(0);
            CP.this.Y.c.setValue((int) (this.e * 100));
            CP.this.Y.i.setImageResource(AbstractC22412vB5.close_tab);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC17445my6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(InterfaceC17445my6 interfaceC17445my6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC17445my6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return CP.this.new g(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            CP.this.Y.h.setImageResource(FA5.primary_light);
            CP.this.Y.d.setChecked(this.d.a());
            if (((Boolean) CP.this.Z.getValue()).booleanValue()) {
                CP.this.Y.d.setVisibility(0);
            } else {
                CP.this.Y.d.setVisibility(8);
            }
            CP.this.Y.c.setVisibility(8);
            CP.this.Y.i.setImageResource(AbstractC22412vB5.ba_music_download);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CP(C16263ky6 c16263ky6, InterfaceC10258bL6 interfaceC10258bL6, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua2, InterfaceC20315ro1 interfaceC20315ro1, C11458d25 c11458d25) {
        AbstractC13042fc3.i(c16263ky6, "binding");
        AbstractC13042fc3.i(interfaceC10258bL6, "isSelectedMode");
        AbstractC13042fc3.i(interfaceC14603iB2, "onLongClickListener");
        AbstractC13042fc3.i(ua2, "onItemSelectChange");
        AbstractC13042fc3.i(interfaceC20315ro1, "observableCoroutineScope");
        AbstractC13042fc3.i(c11458d25, "peer");
        LinearLayout linearLayoutB = c16263ky6.getRoot();
        AbstractC13042fc3.h(linearLayoutB, "getRoot(...)");
        LinearLayout linearLayout = c16263ky6.f;
        AbstractC13042fc3.h(linearLayout, "contentContainer");
        AppCompatCheckBox appCompatCheckBox = c16263ky6.d;
        AbstractC13042fc3.h(appCompatCheckBox, "chbSelected");
        super(interfaceC10258bL6, ua2, interfaceC14603iB2, interfaceC20315ro1, linearLayoutB, linearLayout, appCompatCheckBox);
        this.Y = c16263ky6;
        this.Z = interfaceC10258bL6;
        this.z0 = ua2;
        this.A0 = c11458d25;
        this.B0 = new UA2() { // from class: ir.nasim.AP
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return CP.r1(this.a, (InterfaceC17445my6) obj);
            }
        };
        super.V0();
        CircleProgressBar circleProgressBar = c16263ky6.c;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        circleProgressBar.setBgColor(c5495Jo7.h2());
        c16263ky6.c.setColor(c5495Jo7.i2());
        c16263ky6.c.setMaxValue(100);
        AppCompatImageView appCompatImageView = c16263ky6.i;
        Context context = c16263ky6.getRoot().getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        appCompatImageView.setColorFilter(C5495Jo7.F0(context, TA5.color3_2));
        c16263ky6.g.setTypeface(C6011Lu2.k());
        c16263ky6.k.setTypeface(C6011Lu2.k());
        c16263ky6.b.setTypeface(C6011Lu2.k());
        c16263ky6.j.setTypeface(C6011Lu2.k());
        c16263ky6.e.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.BP
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CP.j1(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(CP cp, View view) {
        AbstractC13042fc3.i(cp, "this$0");
        InterfaceC17445my6 interfaceC17445my6S0 = cp.S0();
        if (interfaceC17445my6S0 != null) {
            cp.Q0().invoke(interfaceC17445my6S0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r1(CP cp, InterfaceC17445my6 interfaceC17445my6) {
        AbstractC13042fc3.i(cp, "this$0");
        AbstractC13042fc3.i(interfaceC17445my6, "item");
        TY1 ty1D = interfaceC17445my6.d();
        if (ty1D instanceof TY1.b) {
            InterfaceC17445my6.a.b(interfaceC17445my6);
        } else if (ty1D instanceof TY1.a) {
            C23709xO c23709xO = C23709xO.a;
            if (c23709xO.i() && cp.q1(c23709xO.M())) {
                c23709xO.h();
            } else {
                AbstractC10533bm0.d(cp.O0(), null, null, new c(interfaceC17445my6, cp, null), 3, null);
            }
        } else if (ty1D instanceof TY1.c) {
            InterfaceC17445my6.a.e(interfaceC17445my6);
        }
        return C19938rB7.a;
    }

    @Override // ir.nasim.AbstractC5350Iy6
    public void M0(InterfaceC17445my6 interfaceC17445my6, long j) {
        StringBuilder sb;
        super.M0(interfaceC17445my6, j);
        if (interfaceC17445my6 != null) {
            b bVar = new b();
            this.C0 = bVar;
            C23709xO.a.u(bVar);
            if (j == -1) {
                this.Y.m.setVisibility(8);
                this.Y.l.setVisibility(0);
                C16263ky6 c16263ky6 = this.Y;
                TextView textView = c16263ky6.l;
                Context context = c16263ky6.getRoot().getContext();
                AbstractC13042fc3.h(context, "getContext(...)");
                textView.setText(C14593iA1.p(context, ((InterfaceC17445my6.a) interfaceC17445my6).h(), false, true, 4, null));
            } else {
                InterfaceC17445my6.a aVar = (InterfaceC17445my6.a) interfaceC17445my6;
                if (C14593iA1.K(aVar.h(), j)) {
                    this.Y.m.setVisibility(8);
                    this.Y.l.setVisibility(8);
                } else {
                    this.Y.m.setVisibility(0);
                    this.Y.l.setVisibility(0);
                    C16263ky6 c16263ky62 = this.Y;
                    TextView textView2 = c16263ky62.l;
                    Context context2 = c16263ky62.getRoot().getContext();
                    AbstractC13042fc3.h(context2, "getContext(...)");
                    textView2.setText(C14593iA1.p(context2, aVar.h(), false, true, 4, null));
                }
            }
            InterfaceC17445my6.a aVar2 = (InterfaceC17445my6.a) interfaceC17445my6;
            this.Y.j.setText(aVar2.i());
            C16263ky6 c16263ky63 = this.Y;
            TextView textView3 = c16263ky63.k;
            Context context3 = c16263ky63.getRoot().getContext();
            AbstractC13042fc3.h(context3, "getContext(...)");
            textView3.setText(C20877sl2.a(context3, aVar2.f()));
            String strG = aVar2.g();
            if (strG == null || strG.length() == 0) {
                this.Y.b.setText("");
            } else {
                TextView textView4 = this.Y.b;
                if (JF5.g()) {
                    String strG2 = aVar2.g();
                    sb = new StringBuilder();
                    sb.append(",");
                    sb.append(strG2);
                } else {
                    String strG3 = aVar2.g();
                    sb = new StringBuilder();
                    sb.append(strG3);
                    sb.append(",");
                }
                textView4.setText(sb.toString());
            }
            Context context4 = this.Y.getRoot().getContext();
            AbstractC13042fc3.h(context4, "getContext(...)");
            String strP = C14593iA1.p(context4, aVar2.h(), true, false, 8, null);
            this.Y.g.setText("| " + strP);
        }
    }

    @Override // ir.nasim.AbstractC5350Iy6
    public UA2 Q0() {
        return this.B0;
    }

    @Override // ir.nasim.AbstractC5350Iy6
    public void c1(InterfaceC17445my6 interfaceC17445my6, InterfaceC3346Am2 interfaceC3346Am2) {
        AbstractC13042fc3.i(interfaceC17445my6, "item");
        interfaceC17445my6.e(new TY1.a(interfaceC3346Am2));
        AbstractC10533bm0.d(O0(), null, null, new e(interfaceC3346Am2, this, interfaceC17445my6, null), 3, null);
    }

    @Override // ir.nasim.AbstractC5350Iy6
    public void d1(InterfaceC17445my6 interfaceC17445my6, float f2) {
        AbstractC13042fc3.i(interfaceC17445my6, "item");
        interfaceC17445my6.e(new TY1.b((int) (interfaceC17445my6.f() * f2)));
        AbstractC10533bm0.d(O0(), null, null, new f(interfaceC17445my6, f2, null), 3, null);
    }

    @Override // ir.nasim.AbstractC5350Iy6
    public void e1(InterfaceC17445my6 interfaceC17445my6) {
        AbstractC13042fc3.i(interfaceC17445my6, "item");
        interfaceC17445my6.e(TY1.c.a);
        AbstractC10533bm0.d(O0(), null, null, new g(interfaceC17445my6, null), 3, null);
    }

    @Override // ir.nasim.AbstractC5350Iy6
    public void f1() {
        super.f1();
        AbstractC17683nO abstractC17683nO = this.C0;
        if (abstractC17683nO != null) {
            C23709xO.a.z0(abstractC17683nO);
        }
    }

    public final boolean q1(VL vl) {
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
        return (interfaceC17445my6S02.getContent().i() != vl.d().f() || (vlM = C23709xO.a.M()) == null || (t74D = vlM.d()) == null || (c11458d25E = t74D.e()) == null || this.A0.getPeerId() != c11458d25E.getPeerId()) ? false : true;
    }

    public final void s1() {
        FileReference fileReferenceB;
        InterfaceC17445my6 interfaceC17445my6S0 = S0();
        if (interfaceC17445my6S0 == null || (fileReferenceB = interfaceC17445my6S0.b()) == null) {
            return;
        }
        AbstractC10533bm0.d(U0(), null, null, new d(fileReferenceB, null), 3, null);
    }
}
