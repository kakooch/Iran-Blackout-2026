package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Nz, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC6547Nz {

    /* renamed from: ir.nasim.Nz$a */
    static final class a extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.b |= RecyclerView.UNDEFINED_DURATION;
            Object objA = AbstractC6547Nz.a(null, null, 0L, this);
            return objA == AbstractC14862ic3.e() ? objA : C9475a16.a(objA);
        }
    }

    /* renamed from: ir.nasim.Nz$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        Object b;
        long c;
        int d;
        int e;
        int f;
        int g;
        /* synthetic */ Object h;
        int i;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.h = obj;
            this.i |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC6547Nz.c(null, null, 0L, 0, 0, 0, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(ir.nasim.C22871vx5 r9, ir.nasim.C6287Mz r10, long r11, ir.nasim.InterfaceC20295rm1 r13) {
        /*
            boolean r0 = r13 instanceof ir.nasim.AbstractC6547Nz.a
            if (r0 == 0) goto L14
            r0 = r13
            ir.nasim.Nz$a r0 = (ir.nasim.AbstractC6547Nz.a) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.b = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            ir.nasim.Nz$a r0 = new ir.nasim.Nz$a
            r0.<init>(r13)
            goto L12
        L1a:
            java.lang.Object r13 = r6.a
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.b
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            ir.nasim.AbstractC10685c16.b(r13)
            goto L45
        L2b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L33:
            ir.nasim.AbstractC10685c16.b(r13)
            r6.b = r2
            r5 = 0
            r7 = 4
            r8 = 0
            r1 = r10
            r2 = r9
            r3 = r11
            java.lang.Object r13 = ir.nasim.InterfaceC16847ly.c(r1, r2, r3, r5, r6, r7, r8)
            if (r13 != r0) goto L45
            return r0
        L45:
            ir.nasim.Z06 r13 = (ir.nasim.Z06) r13
            boolean r9 = r13 instanceof ir.nasim.Z06.b
            if (r9 == 0) goto L58
            ir.nasim.a16$a r9 = ir.nasim.C9475a16.b
            ir.nasim.Z06$b r13 = (ir.nasim.Z06.b) r13
            com.google.protobuf.P r9 = r13.a()
            java.lang.Object r9 = ir.nasim.C9475a16.b(r9)
            goto L6c
        L58:
            boolean r9 = r13 instanceof ir.nasim.Z06.a
            if (r9 == 0) goto L6d
            ir.nasim.a16$a r9 = ir.nasim.C9475a16.b
            ir.nasim.Z06$a r13 = (ir.nasim.Z06.a) r13
            ir.nasim.core.network.RpcException r9 = r13.a()
            java.lang.Object r9 = ir.nasim.AbstractC10685c16.a(r9)
            java.lang.Object r9 = ir.nasim.C9475a16.b(r9)
        L6c:
            return r9
        L6d:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
            r9.<init>()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC6547Nz.a(ir.nasim.vx5, ir.nasim.Mz, long, ir.nasim.rm1):java.lang.Object");
    }

    public static /* synthetic */ Object b(C22871vx5 c22871vx5, C6287Mz c6287Mz, long j, InterfaceC20295rm1 interfaceC20295rm1, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 16500;
        }
        return a(c22871vx5, c6287Mz, j, interfaceC20295rm1);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x011b -> B:36:0x011d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(ir.nasim.C6287Mz r20, ir.nasim.C22871vx5 r21, long r22, int r24, int r25, int r26, ir.nasim.InterfaceC20295rm1 r27) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC6547Nz.c(ir.nasim.Mz, ir.nasim.vx5, long, int, int, int, ir.nasim.rm1):java.lang.Object");
    }
}
