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
public final class KV7 extends AbstractC5350Iy6 {
    private static final a C0 = new a(null);
    public static final int D0 = 8;
    private final UA2 A0;
    private UA2 B0;
    private final C3931Cy6 Y;
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
            return KV7.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                QF2 qf2C0 = KV7.this.T0().C0();
                long fileId = this.d.getFileId();
                long accessHash = this.d.getAccessHash();
                InterfaceC8807Xk2 interfaceC8807Xk2P0 = KV7.this.P0();
                this.b = 1;
                if (qf2C0.m(fileId, accessHash, interfaceC8807Xk2P0, true, this) == objE) {
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
        final /* synthetic */ InterfaceC3346Am2 c;
        final /* synthetic */ KV7 d;
        final /* synthetic */ InterfaceC17445my6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC3346Am2 interfaceC3346Am2, KV7 kv7, InterfaceC17445my6 interfaceC17445my6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC3346Am2;
            this.d = kv7;
            this.e = interfaceC17445my6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, this.e, interfaceC20295rm1);
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
                this.d.Y.d.setVisibility(8);
                this.d.Y.h.setVisibility(8);
                this.d.Y.g.setText(((InterfaceC17445my6.e) this.e).g());
                this.d.Y.b.setChecked(((InterfaceC17445my6.e) this.e).a());
                if (((Boolean) this.d.Z.getValue()).booleanValue()) {
                    this.d.Y.b.setVisibility(0);
                    this.d.Y.i.setVisibility(8);
                } else {
                    this.d.Y.b.setVisibility(8);
                    this.d.Y.i.setVisibility(0);
                }
                ((InterfaceC17445my6.e) this.e).e(new TY1.a(this.c));
                InterfaceC3346Am2 interfaceC3346Am22 = this.c;
                AbstractC13042fc3.f(interfaceC3346Am22);
                String descriptor2 = interfaceC3346Am22.getDescriptor();
                SquareImageView squareImageView = this.d.Y.e;
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
        final /* synthetic */ InterfaceC17445my6 d;
        final /* synthetic */ float e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(InterfaceC17445my6 interfaceC17445my6, float f, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC17445my6;
            this.e = f;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return KV7.this.new d(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            KV7.this.Y.b.setChecked(((InterfaceC17445my6.e) this.d).a());
            ((InterfaceC17445my6.e) this.d).e(new TY1.b((int) (this.e * ((InterfaceC17445my6.e) this.d).f())));
            if (((Boolean) KV7.this.Z.getValue()).booleanValue()) {
                KV7.this.Y.d.setVisibility(8);
                KV7.this.Y.h.setVisibility(8);
                KV7.this.Y.b.setVisibility(0);
            } else {
                KV7.this.Y.d.setVisibility(0);
                KV7.this.Y.h.setVisibility(0);
                KV7.this.Y.b.setVisibility(8);
            }
            KV7.this.Y.i.setVisibility(8);
            KV7.this.Y.e.setImageBitmap(((InterfaceC17445my6.e) this.d).i());
            KV7.this.Y.c.setImageResource(AbstractC22412vB5.close_tab);
            TextView textView = KV7.this.Y.h;
            Context context = KV7.this.Y.getRoot().getContext();
            AbstractC13042fc3.h(context, "getContext(...)");
            textView.setText(C20877sl2.a(context, AbstractC20723sV3.d(((InterfaceC17445my6.e) this.d).f() * this.e)));
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
            return KV7.this.new e(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (((Boolean) KV7.this.Z.getValue()).booleanValue()) {
                KV7.this.Y.b.setVisibility(0);
                KV7.this.Y.d.setVisibility(8);
                KV7.this.Y.i.setVisibility(8);
                KV7.this.Y.h.setVisibility(8);
            } else {
                KV7.this.Y.d.setVisibility(0);
                KV7.this.Y.h.setVisibility(0);
                KV7.this.Y.i.setVisibility(8);
                KV7.this.Y.b.setVisibility(8);
            }
            KV7.this.Y.b.setChecked(((InterfaceC17445my6.e) this.d).a());
            ((InterfaceC17445my6.e) this.d).e(TY1.c.a);
            if (((InterfaceC17445my6.e) this.d).i() != null) {
                KV7 kv7 = KV7.this;
                InterfaceC17445my6 interfaceC17445my6 = this.d;
                QI2 qi2 = QI2.a;
                SquareImageView squareImageView = kv7.Y.e;
                AbstractC13042fc3.h(squareImageView, "imgMainPic");
                qi2.q(squareImageView, ((InterfaceC17445my6.e) interfaceC17445my6).i(), 2, 1);
            }
            KV7.this.Y.c.setImageResource(AbstractC22412vB5.ba_music_download);
            TextView textView = KV7.this.Y.h;
            Context context = KV7.this.Y.getRoot().getContext();
            AbstractC13042fc3.h(context, "getContext(...)");
            textView.setText(C20877sl2.a(context, ((InterfaceC17445my6.e) this.d).f()));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public KV7(C3931Cy6 c3931Cy6, InterfaceC10258bL6 interfaceC10258bL6, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua2, UA2 ua22, InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(c3931Cy6, "binding");
        AbstractC13042fc3.i(interfaceC10258bL6, "isSelectedMode");
        AbstractC13042fc3.i(interfaceC14603iB2, "onLongClickListener");
        AbstractC13042fc3.i(ua2, "openMediaCallback");
        AbstractC13042fc3.i(ua22, "onItemSelectChange");
        AbstractC13042fc3.i(interfaceC20315ro1, "observableCoroutineScope");
        CardView root = c3931Cy6.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        CardView root2 = c3931Cy6.getRoot();
        AbstractC13042fc3.h(root2, "getRoot(...)");
        AppCompatCheckBox appCompatCheckBox = c3931Cy6.b;
        AbstractC13042fc3.h(appCompatCheckBox, "chbSelected");
        super(interfaceC10258bL6, ua22, interfaceC14603iB2, interfaceC20315ro1, root, root2, appCompatCheckBox);
        this.Y = c3931Cy6;
        this.Z = interfaceC10258bL6;
        this.z0 = ua2;
        this.A0 = ua22;
        this.B0 = new UA2() { // from class: ir.nasim.IV7
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return KV7.o1(this.a, (InterfaceC17445my6) obj);
            }
        };
        super.V0();
        c3931Cy6.h.setTypeface(C6011Lu2.k());
        c3931Cy6.g.setTypeface(C6011Lu2.k());
        c3931Cy6.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.JV7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KV7.j1(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(KV7 kv7, View view) {
        AbstractC13042fc3.i(kv7, "this$0");
        InterfaceC17445my6.e eVar = (InterfaceC17445my6.e) kv7.A0.invoke(Integer.valueOf(kv7.I()));
        if (eVar != null) {
            kv7.Q0().invoke(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o1(KV7 kv7, InterfaceC17445my6 interfaceC17445my6) {
        AbstractC13042fc3.i(kv7, "this$0");
        AbstractC13042fc3.i(interfaceC17445my6, "item");
        TY1 ty1D = interfaceC17445my6.d();
        if (ty1D instanceof TY1.b) {
            InterfaceC17445my6.a.b(interfaceC17445my6);
        } else if (ty1D instanceof TY1.a) {
            kv7.z0.invoke(interfaceC17445my6.getContent());
        } else if (ty1D instanceof TY1.c) {
            InterfaceC17445my6.a.e(interfaceC17445my6);
        }
        return C19938rB7.a;
    }

    private final void p1(String str, String str2) {
        this.Y.getRoot().setContentDescription("");
        this.Y.getRoot().setContentDescription(this.Y.getRoot().getContext().getString(RD5.media_video) + Separators.SP + str + Separators.SP + str2);
    }

    @Override // ir.nasim.AbstractC5350Iy6
    public void N0(boolean z) {
        FileReference fileReferenceB;
        super.N0(z);
        if (z) {
            this.Y.d.setVisibility(8);
            this.Y.h.setVisibility(8);
            this.Y.i.setVisibility(8);
        } else {
            InterfaceC17445my6 interfaceC17445my6S0 = S0();
            if (interfaceC17445my6S0 == null || (fileReferenceB = interfaceC17445my6S0.b()) == null) {
                return;
            }
            AbstractC10533bm0.d(U0(), null, null, new b(fileReferenceB, null), 3, null);
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
        p1("", "");
        AbstractC10533bm0.d(O0(), null, null, new c(interfaceC3346Am2, this, interfaceC17445my6, null), 3, null);
    }

    @Override // ir.nasim.AbstractC5350Iy6
    public void d1(InterfaceC17445my6 interfaceC17445my6, float f) {
        AbstractC13042fc3.i(interfaceC17445my6, "item");
        InterfaceC17445my6.e eVar = (InterfaceC17445my6.e) interfaceC17445my6;
        eVar.e(new TY1.b((int) (eVar.f() * f)));
        String string = this.Y.getRoot().getContext().getString(RD5.downloading_description);
        AbstractC13042fc3.h(string, "getString(...)");
        Context context = this.Y.getRoot().getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        p1(string, C20877sl2.a(context, eVar.f()));
        AbstractC10533bm0.d(O0(), null, null, new d(interfaceC17445my6, f, null), 3, null);
    }

    @Override // ir.nasim.AbstractC5350Iy6
    public void e1(InterfaceC17445my6 interfaceC17445my6) {
        AbstractC13042fc3.i(interfaceC17445my6, "item");
        InterfaceC17445my6.e eVar = (InterfaceC17445my6.e) interfaceC17445my6;
        eVar.e(TY1.c.a);
        String string = this.Y.getRoot().getContext().getString(RD5.not_downloaded_description);
        AbstractC13042fc3.h(string, "getString(...)");
        Context context = this.Y.getRoot().getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        p1(string, C20877sl2.a(context, eVar.f()));
        AbstractC10533bm0.d(O0(), null, null, new e(interfaceC17445my6, null), 3, null);
    }
}
