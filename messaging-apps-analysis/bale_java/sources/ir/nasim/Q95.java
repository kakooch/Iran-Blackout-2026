package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.cardview.widget.CardView;
import ir.nasim.InterfaceC17445my6;
import ir.nasim.TY1;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.sharedmedia.ui.SquareImageView;

/* loaded from: classes7.dex */
public final class Q95 extends AbstractC5350Iy6 {
    private static final a C0 = new a(null);
    public static final int D0 = 8;
    private final UA2 A0;
    private UA2 B0;
    private final C22881vy6 Y;
    private final InterfaceC10258bL6 Z;
    private final UA2 z0;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ FileReference d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(FileReference fileReference, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = fileReference;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return Q95.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                QF2 qf2C0 = Q95.this.T0().C0();
                long fileId = this.d.getFileId();
                long accessHash = this.d.getAccessHash();
                InterfaceC8807Xk2 interfaceC8807Xk2P0 = Q95.this.P0();
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
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC17445my6 d;
        final /* synthetic */ InterfaceC3346Am2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC17445my6 interfaceC17445my6, InterfaceC3346Am2 interfaceC3346Am2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC17445my6;
            this.e = interfaceC3346Am2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return Q95.this.new c(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            Q95.this.Y.d.setVisibility(8);
            Q95.this.Y.f.setVisibility(8);
            if (((Boolean) Q95.this.Z.getValue()).booleanValue()) {
                Q95.this.Y.b.setChecked(this.d.a());
                Q95.this.Y.b.setVisibility(0);
            } else {
                Q95.this.Y.b.setVisibility(8);
            }
            this.d.e(new TY1.a(this.e));
            InterfaceC3346Am2 interfaceC3346Am2 = this.e;
            String descriptor = interfaceC3346Am2 != null ? interfaceC3346Am2.getDescriptor() : null;
            if (descriptor != null && descriptor.length() != 0) {
                InterfaceC3346Am2 interfaceC3346Am22 = this.e;
                AbstractC13042fc3.f(interfaceC3346Am22);
                String descriptor2 = interfaceC3346Am22.getDescriptor();
                SquareImageView squareImageView = Q95.this.Y.e;
                AbstractC13042fc3.h(squareImageView, "imgMainPic");
                QI2.p(descriptor2, squareImageView, null, 4, null);
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
        final /* synthetic */ InterfaceC17445my6 c;
        final /* synthetic */ float d;
        final /* synthetic */ Q95 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(InterfaceC17445my6 interfaceC17445my6, float f, Q95 q95, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC17445my6;
            this.d = f;
            this.e = q95;
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
            ((InterfaceC17445my6.d) this.c).e(new TY1.b((int) (this.d * ((InterfaceC17445my6.d) this.c).f())));
            this.e.Y.d.setVisibility(8);
            if (((Boolean) this.e.Z.getValue()).booleanValue()) {
                this.e.Y.f.setVisibility(8);
                this.e.Y.b.setVisibility(0);
                this.e.Y.b.setChecked(((InterfaceC17445my6.d) this.c).a());
            } else {
                this.e.Y.d.setVisibility(0);
                this.e.Y.f.setVisibility(0);
                this.e.Y.b.setVisibility(8);
            }
            this.e.Y.c.setImageResource(AbstractC22412vB5.close_tab);
            TextView textView = this.e.Y.f;
            Context context = this.e.Y.getRoot().getContext();
            AbstractC13042fc3.h(context, "getContext(...)");
            textView.setText(C20877sl2.a(context, AbstractC20723sV3.d(((InterfaceC17445my6.d) this.c).f() * this.d)));
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
        final /* synthetic */ InterfaceC17445my6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(InterfaceC17445my6 interfaceC17445my6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC17445my6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return Q95.this.new e(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            Q95 q95 = Q95.this;
            String string = q95.Y.getRoot().getContext().getString(RD5.not_downloaded_description);
            AbstractC13042fc3.h(string, "getString(...)");
            Context context = Q95.this.Y.getRoot().getContext();
            AbstractC13042fc3.h(context, "getContext(...)");
            q95.q1(string, C20877sl2.a(context, ((InterfaceC17445my6.d) this.d).f()));
            Q95.this.Y.b.setChecked(((InterfaceC17445my6.d) this.d).a());
            if (((Boolean) Q95.this.Z.getValue()).booleanValue()) {
                Q95.this.Y.d.setVisibility(8);
                Q95.this.Y.f.setVisibility(8);
                Q95.this.Y.b.setVisibility(0);
            } else {
                Q95.this.Y.d.setVisibility(0);
                Q95.this.Y.f.setVisibility(0);
                Q95.this.Y.b.setVisibility(8);
            }
            ((InterfaceC17445my6.d) this.d).e(TY1.c.a);
            if (((InterfaceC17445my6.d) this.d).g() != null) {
                Q95 q952 = Q95.this;
                InterfaceC17445my6 interfaceC17445my6 = this.d;
                QI2 qi2 = QI2.a;
                SquareImageView squareImageView = q952.Y.e;
                AbstractC13042fc3.h(squareImageView, "imgMainPic");
                qi2.q(squareImageView, ((InterfaceC17445my6.d) interfaceC17445my6).g(), 2, 1);
            }
            Q95.this.Y.c.setImageResource(AbstractC22412vB5.ba_music_download);
            TextView textView = Q95.this.Y.f;
            Context context2 = Q95.this.Y.getRoot().getContext();
            AbstractC13042fc3.h(context2, "getContext(...)");
            textView.setText(C20877sl2.a(context2, ((InterfaceC17445my6.d) this.d).f()));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Q95(C22881vy6 c22881vy6, InterfaceC10258bL6 interfaceC10258bL6, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua2, InterfaceC20315ro1 interfaceC20315ro1, UA2 ua22) {
        AbstractC13042fc3.i(c22881vy6, "binding");
        AbstractC13042fc3.i(interfaceC10258bL6, "isSelectedMode");
        AbstractC13042fc3.i(interfaceC14603iB2, "onLongClickListener");
        AbstractC13042fc3.i(ua2, "openMediaCallback");
        AbstractC13042fc3.i(interfaceC20315ro1, "observableCoroutineScope");
        AbstractC13042fc3.i(ua22, "onItemSelectChange");
        CardView root = c22881vy6.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        CardView root2 = c22881vy6.getRoot();
        AbstractC13042fc3.h(root2, "getRoot(...)");
        AppCompatCheckBox appCompatCheckBox = c22881vy6.b;
        AbstractC13042fc3.h(appCompatCheckBox, "chbSelected");
        super(interfaceC10258bL6, ua22, interfaceC14603iB2, interfaceC20315ro1, root, root2, appCompatCheckBox);
        this.Y = c22881vy6;
        this.Z = interfaceC10258bL6;
        this.z0 = ua2;
        this.A0 = ua22;
        this.B0 = new UA2() { // from class: ir.nasim.L95
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return Q95.p1(this.a, (InterfaceC17445my6) obj);
            }
        };
        super.V0();
        c22881vy6.f.setTypeface(C6011Lu2.k());
        c22881vy6.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.N95
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Q95.j1(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(Q95 q95, View view) {
        AbstractC13042fc3.i(q95, "this$0");
        InterfaceC17445my6.d dVar = (InterfaceC17445my6.d) q95.A0.invoke(Integer.valueOf(q95.I()));
        if (dVar != null) {
            q95.Q0().invoke(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p1(Q95 q95, InterfaceC17445my6 interfaceC17445my6) {
        AbstractC13042fc3.i(q95, "this$0");
        AbstractC13042fc3.i(interfaceC17445my6, "item");
        TY1 ty1D = interfaceC17445my6.d();
        if (ty1D instanceof TY1.b) {
            InterfaceC17445my6.a.b(interfaceC17445my6);
        } else if (ty1D instanceof TY1.a) {
            q95.z0.invoke(interfaceC17445my6.getContent());
        } else if (ty1D instanceof TY1.c) {
            InterfaceC17445my6.a.e(interfaceC17445my6);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q1(String str, String str2) {
        this.Y.getRoot().setContentDescription("");
        this.Y.getRoot().setContentDescription(this.Y.getRoot().getContext().getString(RD5.media_picture) + Separators.SP + str + Separators.SP + str2);
    }

    @Override // ir.nasim.AbstractC5350Iy6
    public void N0(boolean z) {
        FileReference fileReferenceB;
        super.N0(z);
        if (z) {
            this.Y.d.setVisibility(8);
            this.Y.f.setVisibility(8);
            return;
        }
        InterfaceC17445my6 interfaceC17445my6S0 = S0();
        if (interfaceC17445my6S0 == null || (fileReferenceB = interfaceC17445my6S0.b()) == null) {
            return;
        }
        AbstractC10533bm0.d(U0(), null, null, new b(fileReferenceB, null), 3, null);
    }

    @Override // ir.nasim.AbstractC5350Iy6
    public UA2 Q0() {
        return this.B0;
    }

    @Override // ir.nasim.AbstractC5350Iy6
    public void c1(InterfaceC17445my6 interfaceC17445my6, InterfaceC3346Am2 interfaceC3346Am2) {
        AbstractC13042fc3.i(interfaceC17445my6, "item");
        interfaceC17445my6.e(new TY1.a(interfaceC3346Am2));
        q1("", "");
        AbstractC10533bm0.d(O0(), null, null, new c(interfaceC17445my6, interfaceC3346Am2, null), 3, null);
    }

    @Override // ir.nasim.AbstractC5350Iy6
    public void d1(InterfaceC17445my6 interfaceC17445my6, float f) {
        AbstractC13042fc3.i(interfaceC17445my6, "item");
        InterfaceC17445my6.d dVar = (InterfaceC17445my6.d) interfaceC17445my6;
        dVar.e(new TY1.b((int) (dVar.f() * f)));
        String string = this.Y.getRoot().getContext().getString(RD5.downloading_description);
        AbstractC13042fc3.h(string, "getString(...)");
        Context context = this.Y.getRoot().getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        q1(string, C20877sl2.a(context, dVar.f()));
        AbstractC10533bm0.d(O0(), null, null, new d(interfaceC17445my6, f, this, null), 3, null);
    }

    @Override // ir.nasim.AbstractC5350Iy6
    public void e1(InterfaceC17445my6 interfaceC17445my6) {
        AbstractC13042fc3.i(interfaceC17445my6, "item");
        ((InterfaceC17445my6.d) interfaceC17445my6).e(TY1.c.a);
        AbstractC10533bm0.d(O0(), null, null, new e(interfaceC17445my6, null), 3, null);
    }
}
