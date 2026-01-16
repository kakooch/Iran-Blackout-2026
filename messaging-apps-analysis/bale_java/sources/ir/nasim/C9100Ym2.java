package ir.nasim;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import ir.nasim.InterfaceC17445my6;
import ir.nasim.TY1;

/* renamed from: ir.nasim.Ym2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C9100Ym2 extends AbstractC5350Iy6 {
    private final UA2 A0;
    private final UA2 B0;
    private UA2 C0;
    private final C20418ry6 Y;
    private final InterfaceC10258bL6 Z;
    private final InterfaceC14603iB2 z0;

    /* renamed from: ir.nasim.Ym2$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC3346Am2 c;
        final /* synthetic */ C9100Ym2 d;
        final /* synthetic */ InterfaceC17445my6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC3346Am2 interfaceC3346Am2, C9100Ym2 c9100Ym2, InterfaceC17445my6 interfaceC17445my6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC3346Am2;
            this.d = c9100Ym2;
            this.e = interfaceC17445my6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, this.e, interfaceC20295rm1);
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
                this.d.Y.e.setVisibility(8);
                this.d.Y.b.setChecked(this.e.a());
                if (((Boolean) this.d.Z.getValue()).booleanValue()) {
                    this.d.Y.b.setVisibility(0);
                } else {
                    this.d.Y.b.setVisibility(8);
                }
                TextView textView = this.d.Y.j;
                Context context = this.d.Y.getRoot().getContext();
                AbstractC13042fc3.h(context, "getContext(...)");
                textView.setText(C20877sl2.a(context, this.e.f()));
                if (this.e.getContent().q() instanceof C13388g85) {
                    InterfaceC3346Am2 interfaceC3346Am22 = this.c;
                    AbstractC13042fc3.f(interfaceC3346Am22);
                    String descriptor2 = interfaceC3346Am22.getDescriptor();
                    AbstractC13042fc3.f(descriptor2);
                    AppCompatImageView appCompatImageView = this.d.Y.h;
                    AbstractC13042fc3.h(appCompatImageView, "imgLogo");
                    QI2.p(descriptor2, appCompatImageView, null, 4, null);
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

    /* renamed from: ir.nasim.Ym2$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC17445my6 d;
        final /* synthetic */ float e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC17445my6 interfaceC17445my6, float f, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC17445my6;
            this.e = f;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C9100Ym2.this.new b(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C9100Ym2.this.Y.b.setChecked(this.d.a());
            if (((Boolean) C9100Ym2.this.Z.getValue()).booleanValue()) {
                C9100Ym2.this.Y.b.setVisibility(0);
            } else {
                C9100Ym2.this.Y.b.setVisibility(8);
            }
            C9100Ym2.this.Y.e.setVisibility(0);
            C9100Ym2.this.Y.g.setImageResource(AbstractC22412vB5.new_stop);
            TextView textView = C9100Ym2.this.Y.j;
            Context context = C9100Ym2.this.Y.getRoot().getContext();
            AbstractC13042fc3.h(context, "getContext(...)");
            textView.setText(C20877sl2.a(context, AbstractC20723sV3.d(this.d.f() * this.e)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ym2$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC17445my6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC17445my6 interfaceC17445my6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC17445my6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C9100Ym2.this.new c(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C9100Ym2.this.Y.b.setChecked(this.d.a());
            if (((Boolean) C9100Ym2.this.Z.getValue()).booleanValue()) {
                C9100Ym2.this.Y.b.setVisibility(0);
            } else {
                C9100Ym2.this.Y.b.setVisibility(8);
            }
            C9100Ym2.this.Y.g.setImageResource(AbstractC22412vB5.new_download);
            C9100Ym2.this.Y.e.setVisibility(0);
            TextView textView = C9100Ym2.this.Y.j;
            Context context = C9100Ym2.this.Y.getRoot().getContext();
            AbstractC13042fc3.h(context, "getContext(...)");
            textView.setText(C20877sl2.a(context, this.d.f()));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C9100Ym2(C20418ry6 c20418ry6, InterfaceC10258bL6 interfaceC10258bL6, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua2, UA2 ua22, InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(c20418ry6, "binding");
        AbstractC13042fc3.i(interfaceC10258bL6, "isSelectedMode");
        AbstractC13042fc3.i(interfaceC14603iB2, "onLongClickListener");
        AbstractC13042fc3.i(ua2, "openFile");
        AbstractC13042fc3.i(ua22, "onItemSelectChange");
        AbstractC13042fc3.i(interfaceC20315ro1, "observableCoroutineScope");
        LinearLayout root = c20418ry6.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        LinearLayout linearLayout = c20418ry6.c;
        AbstractC13042fc3.h(linearLayout, "contentContainer");
        AppCompatCheckBox appCompatCheckBox = c20418ry6.b;
        AbstractC13042fc3.h(appCompatCheckBox, "chbSelected");
        super(interfaceC10258bL6, ua22, interfaceC14603iB2, interfaceC20315ro1, root, linearLayout, appCompatCheckBox);
        this.Y = c20418ry6;
        this.Z = interfaceC10258bL6;
        this.z0 = interfaceC14603iB2;
        this.A0 = ua2;
        this.B0 = ua22;
        this.C0 = new UA2() { // from class: ir.nasim.Wm2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C9100Ym2.p1(this.a, (InterfaceC17445my6) obj);
            }
        };
        super.V0();
        c20418ry6.g.setColorFilter(C5495Jo7.a.u2());
        c20418ry6.d.setTypeface(C6011Lu2.k());
        c20418ry6.j.setTypeface(C6011Lu2.k());
        c20418ry6.f.setTypeface(C6011Lu2.k());
        c20418ry6.i.setTypeface(C6011Lu2.k());
        c20418ry6.g.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Xm2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C9100Ym2.j1(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(C9100Ym2 c9100Ym2, View view) {
        AbstractC13042fc3.i(c9100Ym2, "this$0");
        InterfaceC17445my6 interfaceC17445my6S0 = c9100Ym2.S0();
        if (interfaceC17445my6S0 != null) {
            c9100Ym2.Q0().invoke(interfaceC17445my6S0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p1(C9100Ym2 c9100Ym2, InterfaceC17445my6 interfaceC17445my6) {
        AbstractC13042fc3.i(c9100Ym2, "this$0");
        AbstractC13042fc3.i(interfaceC17445my6, "item");
        TY1 ty1D = interfaceC17445my6.d();
        if (ty1D instanceof TY1.b) {
            InterfaceC17445my6.a.b(interfaceC17445my6);
        } else if (ty1D instanceof TY1.a) {
            c9100Ym2.A0.invoke(interfaceC17445my6);
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
            if (j == -1) {
                this.Y.l.setVisibility(8);
                this.Y.k.setVisibility(0);
                C20418ry6 c20418ry6 = this.Y;
                TextView textView = c20418ry6.k;
                Context context = c20418ry6.getRoot().getContext();
                AbstractC13042fc3.h(context, "getContext(...)");
                textView.setText(C14593iA1.p(context, ((InterfaceC17445my6.c) interfaceC17445my6).h(), false, true, 4, null));
            } else {
                InterfaceC17445my6.c cVar = (InterfaceC17445my6.c) interfaceC17445my6;
                if (C14593iA1.K(cVar.h(), j)) {
                    this.Y.l.setVisibility(8);
                    this.Y.k.setVisibility(8);
                } else {
                    this.Y.l.setVisibility(0);
                    this.Y.k.setVisibility(0);
                    C20418ry6 c20418ry62 = this.Y;
                    TextView textView2 = c20418ry62.k;
                    Context context2 = c20418ry62.getRoot().getContext();
                    AbstractC13042fc3.h(context2, "getContext(...)");
                    textView2.setText(C14593iA1.p(context2, cVar.h(), false, true, 4, null));
                }
            }
            TextView textView3 = this.Y.f;
            if (JF5.g()) {
                String strG = ((InterfaceC17445my6.c) interfaceC17445my6).g();
                sb = new StringBuilder();
                sb.append(strG);
                sb.append(",");
            } else {
                String strG2 = ((InterfaceC17445my6.c) interfaceC17445my6).g();
                sb = new StringBuilder();
                sb.append(",");
                sb.append(strG2);
            }
            textView3.setText(sb.toString());
            InterfaceC17445my6.c cVar2 = (InterfaceC17445my6.c) interfaceC17445my6;
            this.Y.i.setText(cVar2.i());
            Context context3 = this.Y.getRoot().getContext();
            AbstractC13042fc3.h(context3, "getContext(...)");
            String strP = C14593iA1.p(context3, cVar2.h(), true, false, 8, null);
            this.Y.h.setImageResource(o1(cVar2.g()));
            this.Y.d.setText("| " + strP);
        }
    }

    @Override // ir.nasim.AbstractC5350Iy6
    public UA2 Q0() {
        return this.C0;
    }

    @Override // ir.nasim.AbstractC5350Iy6
    public void c1(InterfaceC17445my6 interfaceC17445my6, InterfaceC3346Am2 interfaceC3346Am2) {
        AbstractC13042fc3.i(interfaceC17445my6, "item");
        interfaceC17445my6.e(new TY1.a(interfaceC3346Am2));
        AbstractC10533bm0.d(O0(), null, null, new a(interfaceC3346Am2, this, interfaceC17445my6, null), 3, null);
    }

    @Override // ir.nasim.AbstractC5350Iy6
    public void d1(InterfaceC17445my6 interfaceC17445my6, float f) {
        AbstractC13042fc3.i(interfaceC17445my6, "item");
        interfaceC17445my6.e(new TY1.b((int) (interfaceC17445my6.f() * f)));
        AbstractC10533bm0.d(O0(), null, null, new b(interfaceC17445my6, f, null), 3, null);
    }

    @Override // ir.nasim.AbstractC5350Iy6
    public void e1(InterfaceC17445my6 interfaceC17445my6) {
        AbstractC13042fc3.i(interfaceC17445my6, "item");
        interfaceC17445my6.e(TY1.c.a);
        AbstractC10533bm0.d(O0(), null, null, new c(interfaceC17445my6, null), 3, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0033, code lost:
    
        if (r2.equals("jpeg") == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:
    
        if (r2.equals("docx") == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0047, code lost:
    
        if (r2.equals("xls") == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0071, code lost:
    
        if (r2.equals("psd") == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007b, code lost:
    
        if (r2.equals("ppt") == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a5, code lost:
    
        if (r2.equals("pdd") == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00cd, code lost:
    
        if (r2.equals("jpg") == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d9, code lost:
    
        if (r2.equals("doc") == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001f, code lost:
    
        if (r2.equals("xlsx") == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00fd, code lost:
    
        if (r2.equals("ait") == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0112, code lost:
    
        if (r2.equals("ai") == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0119, code lost:
    
        return ir.nasim.AbstractC22412vB5.icon_illustrator;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:?, code lost:
    
        return ir.nasim.AbstractC22412vB5.icon_exel;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:?, code lost:
    
        return ir.nasim.AbstractC22412vB5.icon_powerpoint;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:?, code lost:
    
        return ir.nasim.AbstractC22412vB5.icon_photoshop;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:?, code lost:
    
        return ir.nasim.AbstractC22412vB5.icon_jpeg;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:?, code lost:
    
        return ir.nasim.AbstractC22412vB5.icon_word;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0029, code lost:
    
        if (r2.equals("pptx") == false) goto L81;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int o1(java.lang.String r2) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9100Ym2.o1(java.lang.String):int");
    }
}
