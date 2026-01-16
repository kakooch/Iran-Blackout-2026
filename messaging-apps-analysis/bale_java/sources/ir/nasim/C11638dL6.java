package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: ir.nasim.dL6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C11638dL6 extends W1 implements InterfaceC9336Zm4, LE0, LB2 {
    private static final AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(C11638dL6.class, Object.class, "_state");
    private volatile Object _state;
    private int e;

    /* renamed from: ir.nasim.dL6$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        /* synthetic */ Object f;
        int h;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= RecyclerView.UNDEFINED_DURATION;
            return C11638dL6.this.b(null, this);
        }
    }

    public C11638dL6(Object obj) {
        this._state = obj;
    }

    private final boolean s(Object obj, Object obj2) {
        int i;
        Y1[] y1ArrP;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj != null && !AbstractC13042fc3.d(obj3, obj)) {
                return false;
            }
            if (AbstractC13042fc3.d(obj3, obj2)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, obj2);
            int i2 = this.e;
            if ((i2 & 1) != 0) {
                this.e = i2 + 2;
                return true;
            }
            int i3 = i2 + 1;
            this.e = i3;
            Y1[] y1ArrP2 = p();
            C19938rB7 c19938rB7 = C19938rB7.a;
            while (true) {
                C12890fL6[] c12890fL6Arr = (C12890fL6[]) y1ArrP2;
                if (c12890fL6Arr != null) {
                    for (C12890fL6 c12890fL6 : c12890fL6Arr) {
                        if (c12890fL6 != null) {
                            c12890fL6.g();
                        }
                    }
                }
                synchronized (this) {
                    i = this.e;
                    if (i == i3) {
                        this.e = i3 + 1;
                        return true;
                    }
                    y1ArrP = p();
                    C19938rB7 c19938rB72 = C19938rB7.a;
                }
                y1ArrP2 = y1ArrP;
                i3 = i;
            }
        }
    }

    @Override // ir.nasim.InterfaceC8327Vm4, ir.nasim.InterfaceC4806Gq2
    public Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        setValue(obj);
        return C19938rB7.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:40:0x00b8, B:42:0x00be], limit reached: 57 */
    /* JADX WARN: Path cross not found for [B:42:0x00be, B:40:0x00b8], limit reached: 57 */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b3 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:14:0x003e, B:36:0x00ab, B:38:0x00b3, B:40:0x00b8, B:50:0x00d9, B:52:0x00df, B:42:0x00be, B:46:0x00c5, B:21:0x0060, B:24:0x0073, B:35:0x009c), top: B:57:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b8 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:14:0x003e, B:36:0x00ab, B:38:0x00b3, B:40:0x00b8, B:50:0x00d9, B:52:0x00df, B:42:0x00be, B:46:0x00c5, B:21:0x0060, B:24:0x0073, B:35:0x009c), top: B:57:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00df A[Catch: all -> 0x0043, TRY_LEAVE, TryCatch #0 {all -> 0x0043, blocks: (B:14:0x003e, B:36:0x00ab, B:38:0x00b3, B:40:0x00b8, B:50:0x00d9, B:52:0x00df, B:42:0x00be, B:46:0x00c5, B:21:0x0060, B:24:0x0073, B:35:0x009c), top: B:57:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v2, types: [ir.nasim.Y1] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v1, types: [ir.nasim.W1] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00dd -> B:36:0x00ab). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x00ef -> B:36:0x00ab). Please report as a decompilation issue!!! */
    @Override // ir.nasim.InterfaceC10040ay6, ir.nasim.InterfaceC4557Fq2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(ir.nasim.InterfaceC4806Gq2 r11, ir.nasim.InterfaceC20295rm1 r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C11638dL6.b(ir.nasim.Gq2, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC8327Vm4
    public boolean c(Object obj) {
        setValue(obj);
        return true;
    }

    @Override // ir.nasim.InterfaceC10040ay6
    public List e() {
        return AbstractC9766aX0.e(getValue());
    }

    @Override // ir.nasim.InterfaceC9336Zm4
    public boolean f(Object obj, Object obj2) {
        if (obj == null) {
            obj = AbstractC12225eF4.a;
        }
        if (obj2 == null) {
            obj2 = AbstractC12225eF4.a;
        }
        return s(obj, obj2);
    }

    @Override // ir.nasim.LB2
    public InterfaceC4557Fq2 g(InterfaceC11938do1 interfaceC11938do1, int i, EnumC6162Ml0 enumC6162Ml0) {
        return AbstractC12281eL6.d(this, interfaceC11938do1, i, enumC6162Ml0);
    }

    @Override // ir.nasim.InterfaceC9336Zm4, ir.nasim.InterfaceC10258bL6
    public Object getValue() {
        C14539i47 c14539i47 = AbstractC12225eF4.a;
        Object obj = f.get(this);
        if (obj == c14539i47) {
            return null;
        }
        return obj;
    }

    @Override // ir.nasim.InterfaceC8327Vm4
    public void k() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.W1
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public C12890fL6 l() {
        return new C12890fL6();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.W1
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public C12890fL6[] m(int i) {
        return new C12890fL6[i];
    }

    @Override // ir.nasim.InterfaceC9336Zm4
    public void setValue(Object obj) {
        if (obj == null) {
            obj = AbstractC12225eF4.a;
        }
        s(null, obj);
    }
}
