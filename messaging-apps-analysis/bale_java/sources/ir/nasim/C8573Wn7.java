package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Wn7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C8573Wn7 extends AbstractC9008Yc0 {
    private final C8339Vn7 b;
    private final InterfaceC4557Fq2 c;

    /* renamed from: ir.nasim.Wn7$a */
    public static final class a implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.Wn7$a$a, reason: collision with other inner class name */
        public static final class C0736a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.Wn7$a$a$a, reason: collision with other inner class name */
            public static final class C0737a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0737a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return C0736a.this.a(null, this);
                }
            }

            public C0736a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = interfaceC4806Gq2;
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
                    boolean r0 = r7 instanceof ir.nasim.C8573Wn7.a.C0736a.C0737a
                    if (r0 == 0) goto L13
                    r0 = r7
                    ir.nasim.Wn7$a$a$a r0 = (ir.nasim.C8573Wn7.a.C0736a.C0737a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Wn7$a$a$a r0 = new ir.nasim.Wn7$a$a$a
                    r0.<init>(r7)
                L18:
                    java.lang.Object r7 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r7)
                    goto L48
                L29:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L31:
                    ir.nasim.AbstractC10685c16.b(r7)
                    ir.nasim.Gq2 r7 = r5.a
                    byte[] r6 = (byte[]) r6
                    java.lang.String r2 = new java.lang.String
                    java.nio.charset.Charset r4 = ir.nasim.C12275eL0.b
                    r2.<init>(r6, r4)
                    r0.b = r3
                    java.lang.Object r6 = r7.a(r2, r0)
                    if (r6 != r1) goto L48
                    return r1
                L48:
                    ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8573Wn7.a.C0736a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new C0736a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8573Wn7(C8339Vn7 c8339Vn7, InterfaceC17639nJ0 interfaceC17639nJ0) {
        super(interfaceC17639nJ0);
        AbstractC13042fc3.i(c8339Vn7, ParameterNames.INFO);
        AbstractC13042fc3.i(interfaceC17639nJ0, "source");
        this.b = c8339Vn7;
        this.c = new a(AbstractC6459Nq2.f0(interfaceC17639nJ0));
    }
}
