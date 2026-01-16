package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.KotlinNothingValueException;

/* loaded from: classes8.dex */
final class OK6 implements InterfaceC16863lz6 {

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC10258bL6 d;

        /* renamed from: ir.nasim.OK6$a$a, reason: collision with other inner class name */
        static final class C0550a implements InterfaceC4806Gq2 {
            final /* synthetic */ C9663aL5 a;
            final /* synthetic */ InterfaceC4806Gq2 b;

            /* renamed from: ir.nasim.OK6$a$a$a, reason: collision with other inner class name */
            static final class C0551a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int c;

                C0551a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.c |= RecyclerView.UNDEFINED_DURATION;
                    return C0550a.this.b(0, this);
                }
            }

            C0550a(C9663aL5 c9663aL5, InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = c9663aL5;
                this.b = interfaceC4806Gq2;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            public /* bridge */ /* synthetic */ Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return b(((Number) obj).intValue(), interfaceC20295rm1);
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object b(int r5, ir.nasim.InterfaceC20295rm1 r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof ir.nasim.OK6.a.C0550a.C0551a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.OK6$a$a$a r0 = (ir.nasim.OK6.a.C0550a.C0551a) r0
                    int r1 = r0.c
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.c = r1
                    goto L18
                L13:
                    ir.nasim.OK6$a$a$a r0 = new ir.nasim.OK6$a$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.c
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L4b
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    if (r5 <= 0) goto L4e
                    ir.nasim.aL5 r5 = r4.a
                    boolean r6 = r5.a
                    if (r6 != 0) goto L4e
                    r5.a = r3
                    ir.nasim.Gq2 r5 = r4.b
                    ir.nasim.iz6 r6 = ir.nasim.EnumC15090iz6.START
                    r0.c = r3
                    java.lang.Object r5 = r5.a(r6, r0)
                    if (r5 != r1) goto L4b
                    return r1
                L4b:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                L4e:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.OK6.a.C0550a.b(int, ir.nasim.rm1):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC10258bL6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.d, interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                C9663aL5 c9663aL5 = new C9663aL5();
                InterfaceC10258bL6 interfaceC10258bL6 = this.d;
                C0550a c0550a = new C0550a(c9663aL5, interfaceC4806Gq2);
                this.b = 1;
                if (interfaceC10258bL6.b(c0550a, this) == objE) {
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
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    @Override // ir.nasim.InterfaceC16863lz6
    public InterfaceC4557Fq2 a(InterfaceC10258bL6 interfaceC10258bL6) {
        return AbstractC6459Nq2.R(new a(interfaceC10258bL6, null));
    }

    public String toString() {
        return "SharingStarted.Lazily";
    }
}
