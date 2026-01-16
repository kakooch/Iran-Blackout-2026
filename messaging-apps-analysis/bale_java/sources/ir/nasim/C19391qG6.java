package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C9475a16;

/* renamed from: ir.nasim.qG6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C19391qG6 {
    private final InterfaceC19699qn4 a = AbstractC20899sn4.b(false, 1, null);
    private final InterfaceC9102Ym4 b = AbstractC13472gH6.d(null, null, 2, null);

    /* renamed from: ir.nasim.qG6$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        /* synthetic */ Object e;
        int g;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return C19391qG6.this.d(null, this);
        }
    }

    /* renamed from: ir.nasim.qG6$b */
    private static final class b implements InterfaceC15254jG6 {
        private final InterfaceC23054wG6 a;
        private final HE0 b;

        public b(InterfaceC23054wG6 interfaceC23054wG6, HE0 he0) {
            this.a = interfaceC23054wG6;
            this.b = he0;
        }

        @Override // ir.nasim.InterfaceC15254jG6
        public InterfaceC23054wG6 a() {
            return this.a;
        }

        @Override // ir.nasim.InterfaceC15254jG6
        public void b() {
            if (this.b.b()) {
                HE0 he0 = this.b;
                C9475a16.a aVar = C9475a16.b;
                he0.resumeWith(C9475a16.b(EnumC21868uG6.ActionPerformed));
            }
        }

        @Override // ir.nasim.InterfaceC15254jG6
        public void dismiss() {
            if (this.b.b()) {
                HE0 he0 = this.b;
                C9475a16.a aVar = C9475a16.b;
                he0.resumeWith(C9475a16.b(EnumC21868uG6.Dismissed));
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(a(), bVar.a()) && AbstractC13042fc3.d(this.b, bVar.b);
        }

        public int hashCode() {
            return (a().hashCode() * 31) + this.b.hashCode();
        }
    }

    /* renamed from: ir.nasim.qG6$c */
    private static final class c implements InterfaceC23054wG6 {
        private final String a;
        private final String b;
        private final boolean c;
        private final EnumC17618nG6 d;

        public c(String str, String str2, boolean z, EnumC17618nG6 enumC17618nG6) {
            this.a = str;
            this.b = str2;
            this.c = z;
            this.d = enumC17618nG6;
        }

        @Override // ir.nasim.InterfaceC23054wG6
        public String a() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC23054wG6
        public String b() {
            return this.a;
        }

        @Override // ir.nasim.InterfaceC23054wG6
        public boolean c() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            return AbstractC13042fc3.d(b(), cVar.b()) && AbstractC13042fc3.d(a(), cVar.a()) && c() == cVar.c() && f() == cVar.f();
        }

        @Override // ir.nasim.InterfaceC23054wG6
        public EnumC17618nG6 f() {
            return this.d;
        }

        public int hashCode() {
            int iHashCode = b().hashCode() * 31;
            String strA = a();
            return ((((iHashCode + (strA != null ? strA.hashCode() : 0)) * 31) + Boolean.hashCode(c())) * 31) + f().hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(InterfaceC15254jG6 interfaceC15254jG6) {
        this.b.setValue(interfaceC15254jG6);
    }

    public static /* synthetic */ Object f(C19391qG6 c19391qG6, String str, String str2, boolean z, EnumC17618nG6 enumC17618nG6, InterfaceC20295rm1 interfaceC20295rm1, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            enumC17618nG6 = str3 == null ? EnumC17618nG6.Short : EnumC17618nG6.Indefinite;
        }
        return c19391qG6.e(str, str3, z2, enumC17618nG6, interfaceC20295rm1);
    }

    public final InterfaceC15254jG6 b() {
        return (InterfaceC15254jG6) this.b.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(ir.nasim.InterfaceC23054wG6 r9, ir.nasim.InterfaceC20295rm1 r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof ir.nasim.C19391qG6.a
            if (r0 == 0) goto L13
            r0 = r10
            ir.nasim.qG6$a r0 = (ir.nasim.C19391qG6.a) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.g = r1
            goto L18
        L13:
            ir.nasim.qG6$a r0 = new ir.nasim.qG6$a
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.e
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.g
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L5b
            if (r2 == r4) goto L49
            if (r2 != r3) goto L41
            java.lang.Object r9 = r0.d
            ir.nasim.qG6$a r9 = (ir.nasim.C19391qG6.a) r9
            java.lang.Object r9 = r0.c
            ir.nasim.qn4 r9 = (ir.nasim.InterfaceC19699qn4) r9
            java.lang.Object r1 = r0.b
            ir.nasim.wG6 r1 = (ir.nasim.InterfaceC23054wG6) r1
            java.lang.Object r0 = r0.a
            ir.nasim.qG6 r0 = (ir.nasim.C19391qG6) r0
            ir.nasim.AbstractC10685c16.b(r10)     // Catch: java.lang.Throwable -> L3e
            goto La9
        L3e:
            r10 = move-exception
            goto Lb2
        L41:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L49:
            java.lang.Object r9 = r0.c
            ir.nasim.qn4 r9 = (ir.nasim.InterfaceC19699qn4) r9
            java.lang.Object r2 = r0.b
            ir.nasim.wG6 r2 = (ir.nasim.InterfaceC23054wG6) r2
            java.lang.Object r6 = r0.a
            ir.nasim.qG6 r6 = (ir.nasim.C19391qG6) r6
            ir.nasim.AbstractC10685c16.b(r10)
            r10 = r9
            r9 = r2
            goto L70
        L5b:
            ir.nasim.AbstractC10685c16.b(r10)
            ir.nasim.qn4 r10 = r8.a
            r0.a = r8
            r0.b = r9
            r0.c = r10
            r0.g = r4
            java.lang.Object r2 = r10.a(r5, r0)
            if (r2 != r1) goto L6f
            return r1
        L6f:
            r6 = r8
        L70:
            r0.a = r6     // Catch: java.lang.Throwable -> L9c
            r0.b = r9     // Catch: java.lang.Throwable -> L9c
            r0.c = r10     // Catch: java.lang.Throwable -> L9c
            r0.d = r0     // Catch: java.lang.Throwable -> L9c
            r0.g = r3     // Catch: java.lang.Throwable -> L9c
            ir.nasim.IE0 r2 = new ir.nasim.IE0     // Catch: java.lang.Throwable -> L9c
            ir.nasim.rm1 r3 = ir.nasim.AbstractC13660gc3.c(r0)     // Catch: java.lang.Throwable -> L9c
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L9c
            r2.w()     // Catch: java.lang.Throwable -> L9c
            ir.nasim.qG6$b r3 = new ir.nasim.qG6$b     // Catch: java.lang.Throwable -> L9c
            r3.<init>(r9, r2)     // Catch: java.lang.Throwable -> L9c
            a(r6, r3)     // Catch: java.lang.Throwable -> L9c
            java.lang.Object r9 = r2.t()     // Catch: java.lang.Throwable -> L9c
            java.lang.Object r2 = ir.nasim.AbstractC13660gc3.e()     // Catch: java.lang.Throwable -> L9c
            if (r9 != r2) goto La2
            ir.nasim.WA1.c(r0)     // Catch: java.lang.Throwable -> L9c
            goto La2
        L9c:
            r9 = move-exception
            r0 = r6
            r7 = r10
            r10 = r9
            r9 = r7
            goto Lb2
        La2:
            if (r9 != r1) goto La5
            return r1
        La5:
            r0 = r6
            r7 = r10
            r10 = r9
            r9 = r7
        La9:
            r0.c(r5)     // Catch: java.lang.Throwable -> Lb0
            r9.e(r5)
            return r10
        Lb0:
            r10 = move-exception
            goto Lb6
        Lb2:
            r0.c(r5)     // Catch: java.lang.Throwable -> Lb0
            throw r10     // Catch: java.lang.Throwable -> Lb0
        Lb6:
            r9.e(r5)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19391qG6.d(ir.nasim.wG6, ir.nasim.rm1):java.lang.Object");
    }

    public final Object e(String str, String str2, boolean z, EnumC17618nG6 enumC17618nG6, InterfaceC20295rm1 interfaceC20295rm1) {
        return d(new c(str, str2, z, enumC17618nG6), interfaceC20295rm1);
    }
}
