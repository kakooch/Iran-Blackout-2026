package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C9475a16;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: ir.nasim.by6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C10656by6 extends W1 implements InterfaceC8327Vm4, LE0, LB2 {
    private final int e;
    private final int f;
    private final EnumC6162Ml0 g;
    private Object[] h;
    private long i;
    private long j;
    private int k;
    private int l;

    /* renamed from: ir.nasim.by6$a */
    private static final class a implements NV1 {
        public final C10656by6 a;
        public long b;
        public final Object c;
        public final InterfaceC20295rm1 d;

        public a(C10656by6 c10656by6, long j, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            this.a = c10656by6;
            this.b = j;
            this.c = obj;
            this.d = interfaceC20295rm1;
        }

        @Override // ir.nasim.NV1
        public void dispose() {
            this.a.B(this);
        }
    }

    /* renamed from: ir.nasim.by6$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC6162Ml0.values().length];
            try {
                iArr[EnumC6162Ml0.SUSPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC6162Ml0.DROP_LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC6162Ml0.DROP_OLDEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.by6$c */
    static final class c extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        /* synthetic */ Object e;
        int g;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return C10656by6.D(C10656by6.this, null, this);
        }
    }

    public C10656by6(int i, int i2, EnumC6162Ml0 enumC6162Ml0) {
        this.e = i;
        this.f = i2;
        this.g = enumC6162Ml0;
    }

    private final Object A(C12063dy6 c12063dy6, InterfaceC20295rm1 interfaceC20295rm1) {
        IE0 ie0 = new IE0(AbstractC14251hc3.c(interfaceC20295rm1), 1);
        ie0.w();
        synchronized (this) {
            try {
                if (W(c12063dy6) < 0) {
                    c12063dy6.b = ie0;
                } else {
                    C9475a16.a aVar = C9475a16.b;
                    ie0.resumeWith(C9475a16.b(C19938rB7.a));
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        Object objT = ie0.t();
        if (objT == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objT == AbstractC14862ic3.e() ? objT : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(a aVar) {
        synchronized (this) {
            if (aVar.b < N()) {
                return;
            }
            Object[] objArr = this.h;
            AbstractC13042fc3.f(objArr);
            if (AbstractC11420cy6.f(objArr, aVar.b) != aVar) {
                return;
            }
            AbstractC11420cy6.g(objArr, aVar.b, AbstractC11420cy6.a);
            C();
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
    }

    private final void C() {
        if (this.f != 0 || this.l > 1) {
            Object[] objArr = this.h;
            AbstractC13042fc3.f(objArr);
            while (this.l > 0 && AbstractC11420cy6.f(objArr, (N() + S()) - 1) == AbstractC11420cy6.a) {
                this.l--;
                AbstractC11420cy6.g(objArr, N() + S(), null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object D(ir.nasim.C10656by6 r8, ir.nasim.InterfaceC4806Gq2 r9, ir.nasim.InterfaceC20295rm1 r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10656by6.D(ir.nasim.by6, ir.nasim.Gq2, ir.nasim.rm1):java.lang.Object");
    }

    private final void E(long j) {
        Y1[] y1Arr;
        if (((W1) this).b != 0 && (y1Arr = ((W1) this).a) != null) {
            for (Y1 y1 : y1Arr) {
                if (y1 != null) {
                    C12063dy6 c12063dy6 = (C12063dy6) y1;
                    long j2 = c12063dy6.a;
                    if (j2 >= 0 && j2 < j) {
                        c12063dy6.a = j;
                    }
                }
            }
        }
        this.j = j;
    }

    private final void H() {
        Object[] objArr = this.h;
        AbstractC13042fc3.f(objArr);
        AbstractC11420cy6.g(objArr, N(), null);
        this.k--;
        long jN = N() + 1;
        if (this.i < jN) {
            this.i = jN;
        }
        if (this.j < jN) {
            E(jN);
        }
    }

    static /* synthetic */ Object I(C10656by6 c10656by6, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        if (c10656by6.c(obj)) {
            return C19938rB7.a;
        }
        Object objJ = c10656by6.J(obj, interfaceC20295rm1);
        return objJ == AbstractC14862ic3.e() ? objJ : C19938rB7.a;
    }

    private final Object J(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        InterfaceC20295rm1[] interfaceC20295rm1ArrL;
        a aVar;
        IE0 ie0 = new IE0(AbstractC14251hc3.c(interfaceC20295rm1), 1);
        ie0.w();
        InterfaceC20295rm1[] interfaceC20295rm1ArrL2 = X1.a;
        synchronized (this) {
            try {
                if (U(obj)) {
                    C9475a16.a aVar2 = C9475a16.b;
                    ie0.resumeWith(C9475a16.b(C19938rB7.a));
                    interfaceC20295rm1ArrL = L(interfaceC20295rm1ArrL2);
                    aVar = null;
                } else {
                    a aVar3 = new a(this, S() + N(), obj, ie0);
                    K(aVar3);
                    this.l++;
                    if (this.f == 0) {
                        interfaceC20295rm1ArrL2 = L(interfaceC20295rm1ArrL2);
                    }
                    interfaceC20295rm1ArrL = interfaceC20295rm1ArrL2;
                    aVar = aVar3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (aVar != null) {
            KE0.a(ie0, aVar);
        }
        for (InterfaceC20295rm1 interfaceC20295rm12 : interfaceC20295rm1ArrL) {
            if (interfaceC20295rm12 != null) {
                C9475a16.a aVar4 = C9475a16.b;
                interfaceC20295rm12.resumeWith(C9475a16.b(C19938rB7.a));
            }
        }
        Object objT = ie0.t();
        if (objT == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objT == AbstractC14862ic3.e() ? objT : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(Object obj) {
        int iS = S();
        Object[] objArrT = this.h;
        if (objArrT == null) {
            objArrT = T(null, 0, 2);
        } else if (iS >= objArrT.length) {
            objArrT = T(objArrT, iS, objArrT.length * 2);
        }
        AbstractC11420cy6.g(objArrT, N() + iS, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.Object, java.lang.Object[]] */
    public final InterfaceC20295rm1[] L(InterfaceC20295rm1[] interfaceC20295rm1Arr) {
        Y1[] y1Arr;
        C12063dy6 c12063dy6;
        InterfaceC20295rm1 interfaceC20295rm1;
        int length = interfaceC20295rm1Arr.length;
        if (((W1) this).b != 0 && (y1Arr = ((W1) this).a) != null) {
            int length2 = y1Arr.length;
            int i = 0;
            interfaceC20295rm1Arr = interfaceC20295rm1Arr;
            while (i < length2) {
                Y1 y1 = y1Arr[i];
                if (y1 != null && (interfaceC20295rm1 = (c12063dy6 = (C12063dy6) y1).b) != null && W(c12063dy6) >= 0) {
                    int length3 = interfaceC20295rm1Arr.length;
                    interfaceC20295rm1Arr = interfaceC20295rm1Arr;
                    if (length >= length3) {
                        ?? CopyOf = Arrays.copyOf(interfaceC20295rm1Arr, Math.max(2, interfaceC20295rm1Arr.length * 2));
                        AbstractC13042fc3.h(CopyOf, "copyOf(this, newSize)");
                        interfaceC20295rm1Arr = CopyOf;
                    }
                    interfaceC20295rm1Arr[length] = interfaceC20295rm1;
                    c12063dy6.b = null;
                    length++;
                }
                i++;
                interfaceC20295rm1Arr = interfaceC20295rm1Arr;
            }
        }
        return interfaceC20295rm1Arr;
    }

    private final long M() {
        return N() + this.k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long N() {
        return Math.min(this.j, this.i);
    }

    private final Object P(long j) {
        Object[] objArr = this.h;
        AbstractC13042fc3.f(objArr);
        Object objF = AbstractC11420cy6.f(objArr, j);
        return objF instanceof a ? ((a) objF).c : objF;
    }

    private final long Q() {
        return N() + this.k + this.l;
    }

    private final int R() {
        return (int) ((N() + this.k) - this.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int S() {
        return this.k + this.l;
    }

    private final Object[] T(Object[] objArr, int i, int i2) {
        if (i2 <= 0) {
            throw new IllegalStateException("Buffer size overflow".toString());
        }
        Object[] objArr2 = new Object[i2];
        this.h = objArr2;
        if (objArr == null) {
            return objArr2;
        }
        long jN = N();
        for (int i3 = 0; i3 < i; i3++) {
            long j = i3 + jN;
            AbstractC11420cy6.g(objArr2, j, AbstractC11420cy6.f(objArr, j));
        }
        return objArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean U(Object obj) {
        if (o() == 0) {
            return V(obj);
        }
        if (this.k >= this.f && this.j <= this.i) {
            int i = b.a[this.g.ordinal()];
            if (i == 1) {
                return false;
            }
            if (i == 2) {
                return true;
            }
        }
        K(obj);
        int i2 = this.k + 1;
        this.k = i2;
        if (i2 > this.f) {
            H();
        }
        if (R() > this.e) {
            Y(this.i + 1, this.j, M(), Q());
        }
        return true;
    }

    private final boolean V(Object obj) {
        if (this.e == 0) {
            return true;
        }
        K(obj);
        int i = this.k + 1;
        this.k = i;
        if (i > this.e) {
            H();
        }
        this.j = N() + this.k;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long W(C12063dy6 c12063dy6) {
        long j = c12063dy6.a;
        if (j < M()) {
            return j;
        }
        if (this.f <= 0 && j <= N() && this.l != 0) {
            return j;
        }
        return -1L;
    }

    private final Object X(C12063dy6 c12063dy6) {
        Object obj;
        InterfaceC20295rm1[] interfaceC20295rm1ArrZ = X1.a;
        synchronized (this) {
            try {
                long jW = W(c12063dy6);
                if (jW < 0) {
                    obj = AbstractC11420cy6.a;
                } else {
                    long j = c12063dy6.a;
                    Object objP = P(jW);
                    c12063dy6.a = jW + 1;
                    interfaceC20295rm1ArrZ = Z(j);
                    obj = objP;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (InterfaceC20295rm1 interfaceC20295rm1 : interfaceC20295rm1ArrZ) {
            if (interfaceC20295rm1 != null) {
                C9475a16.a aVar = C9475a16.b;
                interfaceC20295rm1.resumeWith(C9475a16.b(C19938rB7.a));
            }
        }
        return obj;
    }

    private final void Y(long j, long j2, long j3, long j4) {
        long jMin = Math.min(j2, j);
        for (long jN = N(); jN < jMin; jN++) {
            Object[] objArr = this.h;
            AbstractC13042fc3.f(objArr);
            AbstractC11420cy6.g(objArr, jN, null);
        }
        this.i = j;
        this.j = j2;
        this.k = (int) (j3 - jMin);
        this.l = (int) (j4 - j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.W1
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public C12063dy6 l() {
        return new C12063dy6();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.W1
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public C12063dy6[] m(int i) {
        return new C12063dy6[i];
    }

    protected final Object O() {
        Object[] objArr = this.h;
        AbstractC13042fc3.f(objArr);
        return AbstractC11420cy6.f(objArr, (this.i + R()) - 1);
    }

    public final InterfaceC20295rm1[] Z(long j) {
        long j2;
        long j3;
        long j4;
        Y1[] y1Arr;
        if (j > this.j) {
            return X1.a;
        }
        long jN = N();
        long j5 = this.k + jN;
        if (this.f == 0 && this.l > 0) {
            j5++;
        }
        if (((W1) this).b != 0 && (y1Arr = ((W1) this).a) != null) {
            for (Y1 y1 : y1Arr) {
                if (y1 != null) {
                    long j6 = ((C12063dy6) y1).a;
                    if (j6 >= 0 && j6 < j5) {
                        j5 = j6;
                    }
                }
            }
        }
        if (j5 <= this.j) {
            return X1.a;
        }
        long jM = M();
        int iMin = o() > 0 ? Math.min(this.l, this.f - ((int) (jM - j5))) : this.l;
        InterfaceC20295rm1[] interfaceC20295rm1Arr = X1.a;
        long j7 = this.l + jM;
        if (iMin > 0) {
            interfaceC20295rm1Arr = new InterfaceC20295rm1[iMin];
            Object[] objArr = this.h;
            AbstractC13042fc3.f(objArr);
            long j8 = jM;
            int i = 0;
            while (true) {
                if (jM >= j7) {
                    j2 = j5;
                    j3 = j7;
                    break;
                }
                Object objF = AbstractC11420cy6.f(objArr, jM);
                j2 = j5;
                C14539i47 c14539i47 = AbstractC11420cy6.a;
                if (objF != c14539i47) {
                    AbstractC13042fc3.g(objF, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    a aVar = (a) objF;
                    int i2 = i + 1;
                    j3 = j7;
                    interfaceC20295rm1Arr[i] = aVar.d;
                    AbstractC11420cy6.g(objArr, jM, c14539i47);
                    AbstractC11420cy6.g(objArr, j8, aVar.c);
                    j4 = 1;
                    j8++;
                    if (i2 >= iMin) {
                        break;
                    }
                    i = i2;
                } else {
                    j3 = j7;
                    j4 = 1;
                }
                jM += j4;
                j5 = j2;
                j7 = j3;
            }
            jM = j8;
        } else {
            j2 = j5;
            j3 = j7;
        }
        int i3 = (int) (jM - jN);
        long j9 = o() == 0 ? jM : j2;
        long jMax = Math.max(this.i, jM - Math.min(this.e, i3));
        if (this.f == 0 && jMax < j3) {
            Object[] objArr2 = this.h;
            AbstractC13042fc3.f(objArr2);
            if (AbstractC13042fc3.d(AbstractC11420cy6.f(objArr2, jMax), AbstractC11420cy6.a)) {
                jM++;
                jMax++;
            }
        }
        Y(jMax, j9, jM, j3);
        C();
        return (interfaceC20295rm1Arr.length == 0) ^ true ? L(interfaceC20295rm1Arr) : interfaceC20295rm1Arr;
    }

    @Override // ir.nasim.InterfaceC8327Vm4, ir.nasim.InterfaceC4806Gq2
    public Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        return I(this, obj, interfaceC20295rm1);
    }

    public final long a0() {
        long j = this.i;
        if (j < this.j) {
            this.j = j;
        }
        return j;
    }

    @Override // ir.nasim.InterfaceC10040ay6, ir.nasim.InterfaceC4557Fq2
    public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
        return D(this, interfaceC4806Gq2, interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC8327Vm4
    public boolean c(Object obj) {
        int i;
        boolean z;
        InterfaceC20295rm1[] interfaceC20295rm1ArrL = X1.a;
        synchronized (this) {
            if (U(obj)) {
                interfaceC20295rm1ArrL = L(interfaceC20295rm1ArrL);
                z = true;
            } else {
                z = false;
            }
        }
        for (InterfaceC20295rm1 interfaceC20295rm1 : interfaceC20295rm1ArrL) {
            if (interfaceC20295rm1 != null) {
                C9475a16.a aVar = C9475a16.b;
                interfaceC20295rm1.resumeWith(C9475a16.b(C19938rB7.a));
            }
        }
        return z;
    }

    @Override // ir.nasim.InterfaceC10040ay6
    public List e() {
        synchronized (this) {
            int iR = R();
            if (iR == 0) {
                return AbstractC10360bX0.m();
            }
            ArrayList arrayList = new ArrayList(iR);
            Object[] objArr = this.h;
            AbstractC13042fc3.f(objArr);
            for (int i = 0; i < iR; i++) {
                arrayList.add(AbstractC11420cy6.f(objArr, this.i + i));
            }
            return arrayList;
        }
    }

    @Override // ir.nasim.LB2
    public InterfaceC4557Fq2 g(InterfaceC11938do1 interfaceC11938do1, int i, EnumC6162Ml0 enumC6162Ml0) {
        return AbstractC11420cy6.e(this, interfaceC11938do1, i, enumC6162Ml0);
    }

    @Override // ir.nasim.InterfaceC8327Vm4
    public void k() {
        synchronized (this) {
            Y(M(), this.j, M(), Q());
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
    }
}
