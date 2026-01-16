package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* renamed from: ir.nasim.m07, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C16874m07 implements InterfaceC10040ay6 {
    private final InterfaceC10040ay6 a;
    private final InterfaceC14603iB2 b;

    /* renamed from: ir.nasim.m07$a */
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
            return C16874m07.this.b(null, this);
        }
    }

    public C16874m07(InterfaceC10040ay6 interfaceC10040ay6, InterfaceC14603iB2 interfaceC14603iB2) {
        this.a = interfaceC10040ay6;
        this.b = interfaceC14603iB2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC10040ay6, ir.nasim.InterfaceC4557Fq2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(ir.nasim.InterfaceC4806Gq2 r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.C16874m07.a
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.m07$a r0 = (ir.nasim.C16874m07.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.m07$a r0 = new ir.nasim.m07$a
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
            goto L46
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.ay6 r7 = r5.a
            ir.nasim.l07 r2 = new ir.nasim.l07
            ir.nasim.iB2 r4 = r5.b
            r2.<init>(r6, r4)
            r0.c = r3
            java.lang.Object r6 = r7.b(r2, r0)
            if (r6 != r1) goto L46
            return r1
        L46:
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16874m07.b(ir.nasim.Gq2, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC10040ay6
    public List e() {
        return this.a.e();
    }
}
