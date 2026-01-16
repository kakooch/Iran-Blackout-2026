package ir.nasim;

import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.Lq, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5973Lq implements InterfaceC22687vf5, InterfaceC20315ro1 {
    private final View a;
    private final C7155Qm7 b;
    private final InterfaceC20315ro1 c;
    private final AtomicReference d = AbstractC10619bu6.a();

    /* renamed from: ir.nasim.Lq$a */
    static final class a extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return C5973Lq.this.a(null, this);
        }
    }

    /* renamed from: ir.nasim.Lq$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC20227rf5 e;
        final /* synthetic */ C5973Lq f;

        /* renamed from: ir.nasim.Lq$b$a */
        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ C5973Lq e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C5973Lq c5973Lq) {
                super(0);
                this.e = c5973Lq;
            }

            public final void a() {
                AbstractC20906so1.d(this.e.c, null, 1, null);
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC20227rf5 interfaceC20227rf5, C5973Lq c5973Lq) {
            super(1);
            this.e = interfaceC20227rf5;
            this.f = c5973Lq;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C21801u93 invoke(InterfaceC20315ro1 interfaceC20315ro1) {
            return new C21801u93(this.e, new a(this.f));
        }
    }

    /* renamed from: ir.nasim.Lq$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        /* synthetic */ Object d;

        /* renamed from: ir.nasim.Lq$c$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C21801u93 e;
            final /* synthetic */ C5973Lq f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C21801u93 c21801u93, C5973Lq c5973Lq) {
                super(1);
                this.e = c21801u93;
                this.f = c5973Lq;
            }

            public final void a(Throwable th) {
                this.e.d();
                this.f.b.f();
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((Throwable) obj);
                return C19938rB7.a;
            }
        }

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = C5973Lq.this.new c(interfaceC20295rm1);
            cVar.d = obj;
            return cVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C21801u93 c21801u93 = (C21801u93) this.d;
                C5973Lq c5973Lq = C5973Lq.this;
                this.d = c21801u93;
                this.b = c5973Lq;
                this.c = 1;
                IE0 ie0 = new IE0(AbstractC14251hc3.c(this), 1);
                ie0.w();
                c5973Lq.b.e();
                ie0.J(new a(c21801u93, c5973Lq));
                Object objT = ie0.t();
                if (objT == AbstractC14862ic3.e()) {
                    WA1.c(this);
                }
                if (objT == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C21801u93 c21801u93, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(c21801u93, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C5973Lq(View view, C7155Qm7 c7155Qm7, InterfaceC20315ro1 interfaceC20315ro1) {
        this.a = view;
        this.b = c7155Qm7;
        this.c = interfaceC20315ro1;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC22687vf5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(ir.nasim.InterfaceC20227rf5 r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.C5973Lq.a
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.Lq$a r0 = (ir.nasim.C5973Lq.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Lq$a r0 = new ir.nasim.Lq$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L2d:
            ir.nasim.AbstractC10685c16.b(r7)
            goto L4a
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            java.util.concurrent.atomic.AtomicReference r7 = r5.d
            ir.nasim.Lq$b r2 = new ir.nasim.Lq$b
            r2.<init>(r6, r5)
            ir.nasim.Lq$c r6 = new ir.nasim.Lq$c
            r4 = 0
            r6.<init>(r4)
            r0.c = r3
            java.lang.Object r6 = ir.nasim.AbstractC10619bu6.d(r7, r2, r6, r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C5973Lq.a(ir.nasim.rf5, ir.nasim.rm1):java.lang.Object");
    }

    public final InputConnection d(EditorInfo editorInfo) {
        C21801u93 c21801u93 = (C21801u93) AbstractC10619bu6.c(this.d);
        if (c21801u93 != null) {
            return c21801u93.c(editorInfo);
        }
        return null;
    }

    public final boolean e() {
        C21801u93 c21801u93 = (C21801u93) AbstractC10619bu6.c(this.d);
        return c21801u93 != null && c21801u93.e();
    }

    @Override // ir.nasim.InterfaceC20315ro1
    public InterfaceC11938do1 getCoroutineContext() {
        return this.c.getCoroutineContext();
    }

    @Override // ir.nasim.InterfaceC22687vf5
    public View getView() {
        return this.a;
    }
}
