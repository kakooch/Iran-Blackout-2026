package ir.nasim;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C9475a16;

/* renamed from: ir.nasim.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC15683k {

    /* renamed from: ir.nasim.k$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int d;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC15683k.a(null, this);
        }
    }

    /* renamed from: ir.nasim.k$b */
    public static final class b implements DefaultLifecycleObserver {
        final /* synthetic */ HE0 a;

        b(HE0 he0) {
            this.a = he0;
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onStart(InterfaceC18633oz3 interfaceC18633oz3) {
            HE0 he0 = this.a;
            C9475a16.a aVar = C9475a16.b;
            he0.resumeWith(C9475a16.b(C19938rB7.a));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(androidx.lifecycle.j r6, ir.nasim.InterfaceC20295rm1 r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof ir.nasim.AbstractC15683k.a
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.k$a r0 = (ir.nasim.AbstractC15683k.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.k$a r0 = new ir.nasim.k$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r6 = r0.b
            ir.nasim.fL5 r6 = (ir.nasim.C12889fL5) r6
            java.lang.Object r0 = r0.a
            androidx.lifecycle.j r0 = (androidx.lifecycle.j) r0
            ir.nasim.AbstractC10685c16.b(r7)     // Catch: java.lang.Throwable -> L31
            goto L8c
        L31:
            r7 = move-exception
            goto L98
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            ir.nasim.AbstractC10685c16.b(r7)
            androidx.lifecycle.j$b r7 = r6.b()
            androidx.lifecycle.j$b r2 = androidx.lifecycle.j.b.STARTED
            boolean r7 = r7.j(r2)
            if (r7 == 0) goto L4d
            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
            return r6
        L4d:
            ir.nasim.fL5 r7 = new ir.nasim.fL5
            r7.<init>()
            r0.a = r6     // Catch: java.lang.Throwable -> L81
            r0.b = r7     // Catch: java.lang.Throwable -> L81
            r0.d = r3     // Catch: java.lang.Throwable -> L81
            ir.nasim.IE0 r2 = new ir.nasim.IE0     // Catch: java.lang.Throwable -> L81
            ir.nasim.rm1 r4 = ir.nasim.AbstractC13660gc3.c(r0)     // Catch: java.lang.Throwable -> L81
            r2.<init>(r4, r3)     // Catch: java.lang.Throwable -> L81
            r2.w()     // Catch: java.lang.Throwable -> L81
            ir.nasim.k$b r3 = new ir.nasim.k$b     // Catch: java.lang.Throwable -> L81
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L81
            r7.a = r3     // Catch: java.lang.Throwable -> L81
            ir.nasim.AbstractC13042fc3.f(r3)     // Catch: java.lang.Throwable -> L81
            ir.nasim.nz3 r3 = (ir.nasim.InterfaceC18042nz3) r3     // Catch: java.lang.Throwable -> L81
            r6.a(r3)     // Catch: java.lang.Throwable -> L81
            java.lang.Object r2 = r2.t()     // Catch: java.lang.Throwable -> L81
            java.lang.Object r3 = ir.nasim.AbstractC13660gc3.e()     // Catch: java.lang.Throwable -> L81
            if (r2 != r3) goto L87
            ir.nasim.WA1.c(r0)     // Catch: java.lang.Throwable -> L81
            goto L87
        L81:
            r0 = move-exception
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r5
            goto L98
        L87:
            if (r2 != r1) goto L8a
            return r1
        L8a:
            r0 = r6
            r6 = r7
        L8c:
            java.lang.Object r6 = r6.a
            ir.nasim.nz3 r6 = (ir.nasim.InterfaceC18042nz3) r6
            if (r6 == 0) goto L95
            r0.d(r6)
        L95:
            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
            return r6
        L98:
            java.lang.Object r6 = r6.a
            ir.nasim.nz3 r6 = (ir.nasim.InterfaceC18042nz3) r6
            if (r6 == 0) goto La1
            r0.d(r6)
        La1:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC15683k.a(androidx.lifecycle.j, ir.nasim.rm1):java.lang.Object");
    }
}
