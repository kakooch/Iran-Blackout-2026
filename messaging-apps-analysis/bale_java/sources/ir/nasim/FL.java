package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public final class FL {
    private final Object a = a.b(null);
    private final C17660nL3 b = new C17660nL3(16);
    private final C7386Rm4 c = AbstractC22068uc6.b();
    private final C47 d = new C47();

    public static final class b {
        private final InterfaceC8154Ut2 a;
        private final Object b;

        public b(InterfaceC8154Ut2 interfaceC8154Ut2, Object obj) {
            this.a = interfaceC8154Ut2;
            this.b = obj;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && AbstractC13042fc3.d(this.b, bVar.b);
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            Object obj = this.b;
            return iHashCode + (obj == null ? 0 : obj.hashCode());
        }

        public String toString() {
            return "Key(font=" + this.a + ", loaderKey=" + this.b + ')';
        }
    }

    static final class c extends AbstractC22163um1 {
        Object a;
        Object b;
        boolean c;
        /* synthetic */ Object d;
        int f;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return FL.this.g(null, null, false, null, this);
        }
    }

    public static /* synthetic */ void f(FL fl, InterfaceC8154Ut2 interfaceC8154Ut2, InterfaceC9848af5 interfaceC9848af5, Object obj, boolean z, int i, Object obj2) {
        if ((i & 8) != 0) {
            z = false;
        }
        fl.e(interfaceC8154Ut2, interfaceC9848af5, obj, z);
    }

    public final a d(InterfaceC8154Ut2 interfaceC8154Ut2, InterfaceC9848af5 interfaceC9848af5) {
        a aVar;
        b bVar = new b(interfaceC8154Ut2, interfaceC9848af5.b());
        synchronized (this.d) {
            aVar = (a) this.b.d(bVar);
            if (aVar == null) {
                aVar = (a) this.c.e(bVar);
            }
        }
        return aVar;
    }

    public final void e(InterfaceC8154Ut2 interfaceC8154Ut2, InterfaceC9848af5 interfaceC9848af5, Object obj, boolean z) {
        b bVar = new b(interfaceC8154Ut2, interfaceC9848af5.b());
        synchronized (this.d) {
            try {
                if (obj == null) {
                    this.c.x(bVar, a.a(this.a));
                    C19938rB7 c19938rB7 = C19938rB7.a;
                } else if (z) {
                    this.c.x(bVar, a.a(a.b(obj)));
                    C19938rB7 c19938rB72 = C19938rB7.a;
                } else {
                    this.b.f(bVar, a.a(a.b(obj)));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(ir.nasim.InterfaceC8154Ut2 r6, ir.nasim.InterfaceC9848af5 r7, boolean r8, ir.nasim.UA2 r9, ir.nasim.InterfaceC20295rm1 r10) {
        /*
            r5 = this;
            boolean r0 = r10 instanceof ir.nasim.FL.c
            if (r0 == 0) goto L13
            r0 = r10
            ir.nasim.FL$c r0 = (ir.nasim.FL.c) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.FL$c r0 = new ir.nasim.FL$c
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.f
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            boolean r8 = r0.c
            java.lang.Object r6 = r0.b
            ir.nasim.FL$b r6 = (ir.nasim.FL.b) r6
            java.lang.Object r7 = r0.a
            ir.nasim.FL r7 = (ir.nasim.FL) r7
            ir.nasim.AbstractC10685c16.b(r10)
            goto L7d
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            ir.nasim.AbstractC10685c16.b(r10)
            ir.nasim.FL$b r10 = new ir.nasim.FL$b
            java.lang.Object r7 = r7.b()
            r10.<init>(r6, r7)
            ir.nasim.C47 r6 = r5.d
            monitor-enter(r6)
            ir.nasim.nL3 r7 = r5.b     // Catch: java.lang.Throwable -> L5d
            java.lang.Object r7 = r7.d(r10)     // Catch: java.lang.Throwable -> L5d
            ir.nasim.FL$a r7 = (ir.nasim.FL.a) r7     // Catch: java.lang.Throwable -> L5d
            if (r7 != 0) goto L5f
            ir.nasim.Rm4 r7 = r5.c     // Catch: java.lang.Throwable -> L5d
            java.lang.Object r7 = r7.e(r10)     // Catch: java.lang.Throwable -> L5d
            ir.nasim.FL$a r7 = (ir.nasim.FL.a) r7     // Catch: java.lang.Throwable -> L5d
            goto L5f
        L5d:
            r7 = move-exception
            goto Lb3
        L5f:
            if (r7 == 0) goto L67
            java.lang.Object r7 = r7.g()     // Catch: java.lang.Throwable -> L5d
            monitor-exit(r6)
            return r7
        L67:
            ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a     // Catch: java.lang.Throwable -> L5d
            monitor-exit(r6)
            r0.a = r5
            r0.b = r10
            r0.c = r8
            r0.f = r3
            java.lang.Object r6 = r9.invoke(r0)
            if (r6 != r1) goto L79
            return r1
        L79:
            r7 = r5
            r4 = r10
            r10 = r6
            r6 = r4
        L7d:
            ir.nasim.C47 r9 = r7.d
            monitor-enter(r9)
            if (r10 != 0) goto L90
            ir.nasim.Rm4 r8 = r7.c     // Catch: java.lang.Throwable -> L8e
            java.lang.Object r7 = r7.a     // Catch: java.lang.Throwable -> L8e
            ir.nasim.FL$a r7 = ir.nasim.FL.a.a(r7)     // Catch: java.lang.Throwable -> L8e
            r8.x(r6, r7)     // Catch: java.lang.Throwable -> L8e
            goto Lad
        L8e:
            r6 = move-exception
            goto Lb1
        L90:
            if (r8 == 0) goto La0
            ir.nasim.Rm4 r7 = r7.c     // Catch: java.lang.Throwable -> L8e
            java.lang.Object r8 = ir.nasim.FL.a.b(r10)     // Catch: java.lang.Throwable -> L8e
            ir.nasim.FL$a r8 = ir.nasim.FL.a.a(r8)     // Catch: java.lang.Throwable -> L8e
            r7.x(r6, r8)     // Catch: java.lang.Throwable -> L8e
            goto Lad
        La0:
            ir.nasim.nL3 r7 = r7.b     // Catch: java.lang.Throwable -> L8e
            java.lang.Object r8 = ir.nasim.FL.a.b(r10)     // Catch: java.lang.Throwable -> L8e
            ir.nasim.FL$a r8 = ir.nasim.FL.a.a(r8)     // Catch: java.lang.Throwable -> L8e
            r7.f(r6, r8)     // Catch: java.lang.Throwable -> L8e
        Lad:
            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a     // Catch: java.lang.Throwable -> L8e
            monitor-exit(r9)
            return r10
        Lb1:
            monitor-exit(r9)
            throw r6
        Lb3:
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.FL.g(ir.nasim.Ut2, ir.nasim.af5, boolean, ir.nasim.UA2, ir.nasim.rm1):java.lang.Object");
    }

    public static final class a {
        private final Object a;

        private /* synthetic */ a(Object obj) {
            this.a = obj;
        }

        public static final /* synthetic */ a a(Object obj) {
            return new a(obj);
        }

        public static boolean c(Object obj, Object obj2) {
            return (obj2 instanceof a) && AbstractC13042fc3.d(obj, ((a) obj2).g());
        }

        public static int d(Object obj) {
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public static final boolean e(Object obj) {
            return obj == null;
        }

        public static String f(Object obj) {
            return "AsyncTypefaceResult(result=" + obj + ')';
        }

        public boolean equals(Object obj) {
            return c(this.a, obj);
        }

        public final /* synthetic */ Object g() {
            return this.a;
        }

        public int hashCode() {
            return d(this.a);
        }

        public String toString() {
            return f(this.a);
        }

        public static Object b(Object obj) {
            return obj;
        }
    }
}
