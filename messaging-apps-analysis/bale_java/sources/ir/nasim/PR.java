package ir.nasim;

import android.gov.nist.core.Separators;
import android.util.Base64;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import java.util.Date;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public final class PR implements NR {
    private final C20074rR a;
    private final MR b;

    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return PR.this.e(null, this);
        }
    }

    static final class b extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return PR.this.h(0, null, this);
        }
    }

    static final class c extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return PR.this.g(this);
        }
    }

    static final class d extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        boolean d;
        /* synthetic */ Object e;
        int g;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return PR.this.d(null, null, false, this);
        }
    }

    static final class e extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return PR.this.k(0, this);
        }
    }

    static final class f extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return PR.this.b(this);
        }
    }

    static final class g extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return PR.this.c(null, this);
        }
    }

    static final class h extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return PR.this.j(null, this);
        }
    }

    static final class i extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return PR.this.f(this);
        }
    }

    static final class j extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return PR.this.i(this);
        }
    }

    static final class k extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        /* synthetic */ Object e;
        int g;

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return PR.this.a(null, null, this);
        }
    }

    public PR(C20074rR c20074rR, MR mr) {
        AbstractC13042fc3.i(c20074rR, "localDataSource");
        AbstractC13042fc3.i(mr, "remoteDataSource");
        this.a = c20074rR;
        this.b = mr;
    }

    private final boolean m(String str) {
        List listN0 = AbstractC20762sZ6.N0(str, new String[]{Separators.DOT}, false, 0, 6, null);
        if (listN0.size() != 3) {
            Log.e("AuthenticatorToken", "invalid number of token parts");
            return true;
        }
        byte[] bArrDecode = Base64.decode((String) listN0.get(1), 10);
        AbstractC13042fc3.h(bArrDecode, "decode(...)");
        long jOptLong = new JSONObject(new String(bArrDecode, C12275eL0.b)).optLong("exp", -1L);
        if (jOptLong != -1) {
            return new Date(jOptLong * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT).before(new Date());
        }
        Log.e("AuthenticatorToken", "invalid expiration time");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(String str) {
        AbstractC13042fc3.i(str, "it");
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.NR
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(java.lang.String r7, ir.nasim.SR r8, ir.nasim.InterfaceC20295rm1 r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof ir.nasim.PR.k
            if (r0 == 0) goto L13
            r0 = r9
            ir.nasim.PR$k r0 = (ir.nasim.PR.k) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.g = r1
            goto L18
        L13:
            ir.nasim.PR$k r0 = new ir.nasim.PR$k
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.e
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.g
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L61
            if (r2 == r5) goto L50
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r7 = r0.a
            ir.nasim.QR$a r7 = (ir.nasim.QR.a) r7
            ir.nasim.AbstractC10685c16.b(r9)
            goto La9
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3c:
            java.lang.Object r7 = r0.d
            ir.nasim.QR r7 = (ir.nasim.QR) r7
            java.lang.Object r8 = r0.c
            ir.nasim.SR r8 = (ir.nasim.SR) r8
            java.lang.Object r2 = r0.b
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r4 = r0.a
            ir.nasim.PR r4 = (ir.nasim.PR) r4
            ir.nasim.AbstractC10685c16.b(r9)
            goto L92
        L50:
            java.lang.Object r7 = r0.c
            r8 = r7
            ir.nasim.SR r8 = (ir.nasim.SR) r8
            java.lang.Object r7 = r0.b
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r2 = r0.a
            ir.nasim.PR r2 = (ir.nasim.PR) r2
            ir.nasim.AbstractC10685c16.b(r9)
            goto L76
        L61:
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.MR r9 = r6.b
            r0.a = r6
            r0.b = r7
            r0.c = r8
            r0.g = r5
            java.lang.Object r9 = r9.i(r7, r0)
            if (r9 != r1) goto L75
            return r1
        L75:
            r2 = r6
        L76:
            ir.nasim.QR r9 = (ir.nasim.QR) r9
            boolean r5 = r9 instanceof ir.nasim.QR.c
            if (r5 == 0) goto Lb6
            ir.nasim.rR r5 = r2.a
            r0.a = r2
            r0.b = r7
            r0.c = r8
            r0.d = r9
            r0.g = r4
            java.lang.Object r4 = r5.f(r7, r0)
            if (r4 != r1) goto L8f
            return r1
        L8f:
            r4 = r2
            r2 = r7
            r7 = r9
        L92:
            if (r8 == 0) goto Lb5
            ir.nasim.QR$a r7 = ir.nasim.QR.a
            r0.a = r7
            r9 = 0
            r0.b = r9
            r0.c = r9
            r0.d = r9
            r0.g = r3
            r9 = 0
            java.lang.Object r9 = r4.d(r2, r8, r9, r0)
            if (r9 != r1) goto La9
            return r1
        La9:
            ir.nasim.QR r9 = (ir.nasim.QR) r9
            ir.nasim.OR r8 = new ir.nasim.OR
            r8.<init>()
            ir.nasim.QR r7 = r7.a(r9, r8)
            return r7
        Lb5:
            r9 = r7
        Lb6:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.PR.a(java.lang.String, ir.nasim.SR, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.NR
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.PR.f
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.PR$f r0 = (ir.nasim.PR.f) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.PR$f r0 = new ir.nasim.PR$f
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r5)
            goto L3f
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.MR r5 = r4.b
            r0.c = r3
            java.lang.Object r5 = r5.g(r0)
            if (r5 != r1) goto L3f
            return r1
        L3f:
            ir.nasim.QR r5 = (ir.nasim.QR) r5
            boolean r0 = r5 instanceof ir.nasim.QR.b
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.PR.b(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.NR
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(ir.nasim.SR r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof ir.nasim.PR.g
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.PR$g r0 = (ir.nasim.PR.g) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.PR$g r0 = new ir.nasim.PR$g
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L41
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            ir.nasim.AbstractC10685c16.b(r8)
            goto L6e
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            java.lang.Object r7 = r0.b
            ir.nasim.SR r7 = (ir.nasim.SR) r7
            java.lang.Object r2 = r0.a
            ir.nasim.PR r2 = (ir.nasim.PR) r2
            ir.nasim.AbstractC10685c16.b(r8)
            goto L54
        L41:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.rR r8 = r6.a
            r0.a = r6
            r0.b = r7
            r0.e = r4
            java.lang.Object r8 = r8.e(r7, r0)
            if (r8 != r1) goto L53
            return r1
        L53:
            r2 = r6
        L54:
            java.lang.String r8 = (java.lang.String) r8
            if (r8 != 0) goto L59
            return r5
        L59:
            boolean r4 = r2.m(r8)
            if (r4 == 0) goto L6f
            ir.nasim.rR r8 = r2.a
            r0.a = r5
            r0.b = r5
            r0.e = r3
            java.lang.Object r7 = r8.b(r7, r0)
            if (r7 != r1) goto L6e
            return r1
        L6e:
            return r5
        L6f:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.PR.c(ir.nasim.SR, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.NR
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(java.lang.String r11, ir.nasim.SR r12, boolean r13, ir.nasim.InterfaceC20295rm1 r14) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.PR.d(java.lang.String, ir.nasim.SR, boolean, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.NR
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(ir.nasim.SR r9, ir.nasim.InterfaceC20295rm1 r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof ir.nasim.PR.a
            if (r0 == 0) goto L13
            r0 = r10
            ir.nasim.PR$a r0 = (ir.nasim.PR.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.PR$a r0 = new ir.nasim.PR$a
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L54
            if (r2 == r5) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r9 = r0.a
            ir.nasim.QR r9 = (ir.nasim.QR) r9
            ir.nasim.AbstractC10685c16.b(r10)
            goto Laf
        L34:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3c:
            java.lang.Object r9 = r0.a
            ir.nasim.PR r9 = (ir.nasim.PR) r9
            ir.nasim.AbstractC10685c16.b(r10)
            goto L7e
        L44:
            java.lang.Object r9 = r0.b
            ir.nasim.SR r9 = (ir.nasim.SR) r9
            java.lang.Object r2 = r0.a
            ir.nasim.PR r2 = (ir.nasim.PR) r2
            ir.nasim.AbstractC10685c16.b(r10)
            r7 = r10
            r10 = r9
            r9 = r2
            r2 = r7
            goto L69
        L54:
            ir.nasim.AbstractC10685c16.b(r10)
            ir.nasim.rR r10 = r8.a
            r0.a = r8
            r0.b = r9
            r0.e = r5
            java.lang.Object r10 = r10.d(r0)
            if (r10 != r1) goto L66
            return r1
        L66:
            r2 = r10
            r10 = r9
            r9 = r8
        L69:
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L6f
            java.lang.String r2 = ""
        L6f:
            r0.a = r9
            r6 = 0
            r0.b = r6
            r0.e = r4
            r4 = 0
            java.lang.Object r10 = r9.d(r2, r10, r4, r0)
            if (r10 != r1) goto L7e
            return r1
        L7e:
            ir.nasim.QR r10 = (ir.nasim.QR) r10
            boolean r2 = r10 instanceof ir.nasim.QR.c
            if (r2 == 0) goto L8e
            ir.nasim.QR$c r9 = new ir.nasim.QR$c
            java.lang.Boolean r10 = ir.nasim.AbstractC6392Nk0.a(r5)
            r9.<init>(r10)
            goto Lbb
        L8e:
            boolean r2 = r10 instanceof ir.nasim.QR.b
            if (r2 == 0) goto Lbc
            r2 = r10
            ir.nasim.QR$b r2 = (ir.nasim.QR.b) r2
            ir.nasim.pR r2 = r2.b()
            ir.nasim.pR$b r4 = ir.nasim.InterfaceC18892pR.b.a
            boolean r2 = ir.nasim.AbstractC13042fc3.d(r2, r4)
            if (r2 != 0) goto Lb0
            ir.nasim.rR r9 = r9.a
            r0.a = r10
            r0.e = r3
            java.lang.Object r9 = r9.c(r0)
            if (r9 != r1) goto Lae
            return r1
        Lae:
            r9 = r10
        Laf:
            r10 = r9
        Lb0:
            ir.nasim.QR$b r9 = new ir.nasim.QR$b
            ir.nasim.QR$b r10 = (ir.nasim.QR.b) r10
            ir.nasim.pR r10 = r10.b()
            r9.<init>(r10)
        Lbb:
            return r9
        Lbc:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
            r9.<init>()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.PR.e(ir.nasim.SR, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.NR
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.PR.i
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.PR$i r0 = (ir.nasim.PR.i) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.PR$i r0 = new ir.nasim.PR$i
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r5)
            goto L3f
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.rR r5 = r4.a
            r0.c = r3
            java.lang.Object r5 = r5.d(r0)
            if (r5 != r1) goto L3f
            return r1
        L3f:
            if (r5 == 0) goto L42
            goto L43
        L42:
            r3 = 0
        L43:
            java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.PR.f(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.NR
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object g(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.PR.c
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.PR$c r0 = (ir.nasim.PR.c) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.PR$c r0 = new ir.nasim.PR$c
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r0 = r0.a
            ir.nasim.QR r0 = (ir.nasim.QR) r0
            ir.nasim.AbstractC10685c16.b(r6)
            goto L74
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L38:
            java.lang.Object r2 = r0.a
            ir.nasim.PR r2 = (ir.nasim.PR) r2
            ir.nasim.AbstractC10685c16.b(r6)
            goto L51
        L40:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.MR r6 = r5.b
            r0.a = r5
            r0.d = r4
            java.lang.Object r6 = r6.d(r0)
            if (r6 != r1) goto L50
            return r1
        L50:
            r2 = r5
        L51:
            ir.nasim.QR r6 = (ir.nasim.QR) r6
            boolean r4 = r6 instanceof ir.nasim.QR.c
            if (r4 == 0) goto L75
            r4 = r6
            ir.nasim.QR$c r4 = (ir.nasim.QR.c) r4
            java.lang.Object r4 = r4.b()
            ir.nasim.qS0 r4 = (ir.nasim.C19493qS0) r4
            boolean r4 = r4.a()
            if (r4 != 0) goto L75
            ir.nasim.rR r2 = r2.a
            r0.a = r6
            r0.d = r3
            java.lang.Object r0 = r2.a(r0)
            if (r0 != r1) goto L73
            return r1
        L73:
            r0 = r6
        L74:
            r6 = r0
        L75:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.PR.g(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.NR
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object h(int r6, ir.nasim.SR r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof ir.nasim.PR.b
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.PR$b r0 = (ir.nasim.PR.b) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.PR$b r0 = new ir.nasim.PR$b
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L45
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r6 = r0.a
            ir.nasim.QR r6 = (ir.nasim.QR) r6
            ir.nasim.AbstractC10685c16.b(r8)
            goto L71
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            java.lang.Object r6 = r0.b
            r7 = r6
            ir.nasim.SR r7 = (ir.nasim.SR) r7
            java.lang.Object r6 = r0.a
            ir.nasim.PR r6 = (ir.nasim.PR) r6
            ir.nasim.AbstractC10685c16.b(r8)
            goto L5c
        L45:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.MR r8 = r5.b
            ir.nasim.hG5 r2 = r7.j()
            r0.a = r5
            r0.b = r7
            r0.e = r4
            java.lang.Object r8 = r8.c(r6, r2, r0)
            if (r8 != r1) goto L5b
            return r1
        L5b:
            r6 = r5
        L5c:
            ir.nasim.QR r8 = (ir.nasim.QR) r8
            boolean r2 = r8 instanceof ir.nasim.QR.c
            if (r2 == 0) goto L73
            r0.a = r8
            r2 = 0
            r0.b = r2
            r0.e = r3
            java.lang.Object r6 = r6.e(r7, r0)
            if (r6 != r1) goto L70
            return r1
        L70:
            r6 = r8
        L71:
            r8 = r6
            goto L79
        L73:
            boolean r6 = r8 instanceof ir.nasim.QR.b
            if (r6 == 0) goto L7a
            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
        L79:
            return r8
        L7a:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.PR.h(int, ir.nasim.SR, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.NR
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object i(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.PR.j
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.PR$j r0 = (ir.nasim.PR.j) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.PR$j r0 = new ir.nasim.PR$j
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r5)
            goto L3f
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.MR r5 = r4.b
            r0.c = r3
            java.lang.Object r5 = r5.h(r0)
            if (r5 != r1) goto L3f
            return r1
        L3f:
            ir.nasim.QR r5 = (ir.nasim.QR) r5
            boolean r0 = r5 instanceof ir.nasim.QR.b
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.PR.i(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.NR
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object j(ir.nasim.SR r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ir.nasim.PR.h
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.PR$h r0 = (ir.nasim.PR.h) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.PR$h r0 = new ir.nasim.PR$h
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r6)
            goto L3d
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            ir.nasim.AbstractC10685c16.b(r6)
            r0.c = r3
            java.lang.Object r6 = r4.c(r5, r0)
            if (r6 != r1) goto L3d
            return r1
        L3d:
            if (r6 == 0) goto L40
            goto L41
        L40:
            r3 = 0
        L41:
            java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.PR.j(ir.nasim.SR, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.NR
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object k(int r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.PR.e
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.PR$e r0 = (ir.nasim.PR.e) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.PR$e r0 = new ir.nasim.PR$e
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r6 = r0.a
            ir.nasim.QR r6 = (ir.nasim.QR) r6
            ir.nasim.AbstractC10685c16.b(r7)
            goto L65
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            java.lang.Object r6 = r0.a
            ir.nasim.PR r6 = (ir.nasim.PR) r6
            ir.nasim.AbstractC10685c16.b(r7)
            goto L51
        L40:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.MR r7 = r5.b
            r0.a = r5
            r0.d = r4
            java.lang.Object r7 = r7.f(r6, r0)
            if (r7 != r1) goto L50
            return r1
        L50:
            r6 = r5
        L51:
            ir.nasim.QR r7 = (ir.nasim.QR) r7
            boolean r2 = r7 instanceof ir.nasim.QR.c
            if (r2 == 0) goto L67
            ir.nasim.rR r6 = r6.a
            r0.a = r7
            r0.d = r3
            java.lang.Object r6 = r6.a(r0)
            if (r6 != r1) goto L64
            return r1
        L64:
            r6 = r7
        L65:
            r7 = r6
            goto L6b
        L67:
            boolean r6 = r7 instanceof ir.nasim.QR.b
            if (r6 == 0) goto L6c
        L6b:
            return r7
        L6c:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.PR.k(int, ir.nasim.rm1):java.lang.Object");
    }
}
