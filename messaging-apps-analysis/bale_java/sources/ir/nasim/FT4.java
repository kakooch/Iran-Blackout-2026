package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.KotlinNothingValueException;

/* loaded from: classes5.dex */
public final class FT4 {
    private final InterfaceC9336Zm4 a;
    private final InterfaceC9336Zm4 b;
    private final InterfaceC4557Fq2 c;
    private final Set d;
    private final Set e;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.FT4$a$a, reason: collision with other inner class name */
        static final class C0369a implements InterfaceC4806Gq2 {
            final /* synthetic */ FT4 a;

            /* renamed from: ir.nasim.FT4$a$a$a, reason: collision with other inner class name */
            static final class C0370a extends AbstractC22163um1 {
                Object a;
                Object b;
                /* synthetic */ Object c;
                int e;

                C0370a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.c = obj;
                    this.e |= RecyclerView.UNDEFINED_DURATION;
                    return C0369a.this.a(null, this);
                }
            }

            C0369a(FT4 ft4) {
                this.a = ft4;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.util.Set r5, ir.nasim.InterfaceC20295rm1 r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof ir.nasim.FT4.a.C0369a.C0370a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.FT4$a$a$a r0 = (ir.nasim.FT4.a.C0369a.C0370a) r0
                    int r1 = r0.e
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.e = r1
                    goto L18
                L13:
                    ir.nasim.FT4$a$a$a r0 = new ir.nasim.FT4$a$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.c
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.e
                    r3 = 1
                    if (r2 == 0) goto L39
                    if (r2 != r3) goto L31
                    java.lang.Object r5 = r0.b
                    java.util.Set r5 = (java.util.Set) r5
                    java.lang.Object r0 = r0.a
                    ir.nasim.FT4$a$a r0 = (ir.nasim.FT4.a.C0369a) r0
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L5e
                L31:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L39:
                    ir.nasim.AbstractC10685c16.b(r6)
                    java.lang.Iterable r5 = (java.lang.Iterable) r5
                    ir.nasim.FT4 r6 = r4.a
                    java.util.Set r6 = r6.c()
                    java.lang.Iterable r6 = (java.lang.Iterable) r6
                    java.util.Set r5 = ir.nasim.ZW0.b1(r5, r6)
                    ir.nasim.FT4 r6 = r4.a
                    ir.nasim.Zm4 r6 = ir.nasim.FT4.b(r6)
                    r0.a = r4
                    r0.b = r5
                    r0.e = r3
                    java.lang.Object r6 = r6.a(r5, r0)
                    if (r6 != r1) goto L5d
                    return r1
                L5d:
                    r0 = r4
                L5e:
                    ir.nasim.FT4 r6 = r0.a
                    java.util.Set r6 = ir.nasim.FT4.a(r6)
                    java.util.Collection r5 = (java.util.Collection) r5
                    r6.addAll(r5)
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.FT4.a.C0369a.a(java.util.Set, ir.nasim.rm1):java.lang.Object");
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return FT4.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4E = FT4.this.e();
                C0369a c0369a = new C0369a(FT4.this);
                this.b = 1;
                if (interfaceC9336Zm4E.b(c0369a, this) == objE) {
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
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public FT4(InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        this.a = AbstractC12281eL6.a(new LinkedHashSet());
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new LinkedHashSet());
        this.b = interfaceC9336Zm4A;
        this.c = interfaceC9336Zm4A;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.d = linkedHashSet;
        this.e = linkedHashSet;
        AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(null), 3, null);
    }

    public final Set c() {
        return this.e;
    }

    public final InterfaceC4557Fq2 d() {
        return this.c;
    }

    public final InterfaceC9336Zm4 e() {
        return this.a;
    }
}
