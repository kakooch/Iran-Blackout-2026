package ir.nasim;

import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

/* renamed from: ir.nasim.u93, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C21801u93 {
    private final InterfaceC20227rf5 a;
    private final SA2 b;
    private final Object c = new Object();
    private C12544en4 d = new C12544en4(new E48[16], 0);
    private boolean e;

    /* renamed from: ir.nasim.u93$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        a() {
            super(1);
        }

        public final void a(InterfaceInputConnectionC15243jF4 interfaceInputConnectionC15243jF4) {
            interfaceInputConnectionC15243jF4.a();
            C12544en4 c12544en4 = C21801u93.this.d;
            Object[] objArr = c12544en4.a;
            int iO = c12544en4.o();
            int i = 0;
            while (true) {
                if (i >= iO) {
                    i = -1;
                    break;
                } else if (AbstractC13042fc3.d((E48) objArr[i], interfaceInputConnectionC15243jF4)) {
                    break;
                } else {
                    i++;
                }
            }
            if (i >= 0) {
                C21801u93.this.d.w(i);
            }
            if (C21801u93.this.d.o() == 0) {
                C21801u93.this.b.invoke();
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceInputConnectionC15243jF4) obj);
            return C19938rB7.a;
        }
    }

    public C21801u93(InterfaceC20227rf5 interfaceC20227rf5, SA2 sa2) {
        this.a = interfaceC20227rf5;
        this.b = sa2;
    }

    public final InputConnection c(EditorInfo editorInfo) {
        synchronized (this.c) {
            if (this.e) {
                return null;
            }
            InterfaceInputConnectionC15243jF4 interfaceInputConnectionC15243jF4A = AbstractC19971rF4.a(this.a.a(editorInfo), new a());
            this.d.d(new E48(interfaceInputConnectionC15243jF4A));
            return interfaceInputConnectionC15243jF4A;
        }
    }

    public final void d() {
        synchronized (this.c) {
            try {
                this.e = true;
                C12544en4 c12544en4 = this.d;
                Object[] objArr = c12544en4.a;
                int iO = c12544en4.o();
                for (int i = 0; i < iO; i++) {
                    InterfaceInputConnectionC15243jF4 interfaceInputConnectionC15243jF4 = (InterfaceInputConnectionC15243jF4) ((E48) objArr[i]).get();
                    if (interfaceInputConnectionC15243jF4 != null) {
                        interfaceInputConnectionC15243jF4.a();
                    }
                }
                this.d.k();
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean e() {
        return !this.e;
    }
}
