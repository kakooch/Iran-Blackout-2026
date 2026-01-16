package androidx.compose.foundation;

import android.view.KeyEvent;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20271rj7;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.B26;
import ir.nasim.C19938rB7;
import ir.nasim.ED1;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC17521n63;
import ir.nasim.InterfaceC18507om4;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC6194Mo5;
import ir.nasim.InterfaceC9049Yg5;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.ZG4;

/* loaded from: classes.dex */
public class f extends androidx.compose.foundation.a {

    static final class a extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ long d;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC6194Mo5 interfaceC6194Mo5 = (InterfaceC6194Mo5) this.c;
                long j = this.d;
                if (f.this.O2()) {
                    f fVar = f.this;
                    this.b = 1;
                    if (fVar.Q2(interfaceC6194Mo5, j, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        public final Object n(InterfaceC6194Mo5 interfaceC6194Mo5, long j, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = f.this.new a(interfaceC20295rm1);
            aVar.c = interfaceC6194Mo5;
            aVar.d = j;
            return aVar.invokeSuspend(C19938rB7.a);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return n((InterfaceC6194Mo5) obj, ((ZG4) obj2).t(), (InterfaceC20295rm1) obj3);
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        b() {
            super(1);
        }

        public final void a(long j) {
            if (f.this.O2()) {
                f.this.P2().invoke();
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((ZG4) obj).t());
            return C19938rB7.a;
        }
    }

    public /* synthetic */ f(InterfaceC18507om4 interfaceC18507om4, InterfaceC17521n63 interfaceC17521n63, boolean z, String str, B26 b26, SA2 sa2, ED1 ed1) {
        this(interfaceC18507om4, interfaceC17521n63, z, str, b26, sa2);
    }

    static /* synthetic */ Object Z2(f fVar, InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objI = AbstractC20271rj7.i(interfaceC9049Yg5, fVar.new a(null), fVar.new b(), interfaceC20295rm1);
        return objI == AbstractC14862ic3.e() ? objI : C19938rB7.a;
    }

    @Override // androidx.compose.foundation.a
    public Object J2(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
        return Z2(this, interfaceC9049Yg5, interfaceC20295rm1);
    }

    @Override // androidx.compose.foundation.a
    protected final boolean T2(KeyEvent keyEvent) {
        return false;
    }

    @Override // androidx.compose.foundation.a
    protected final boolean U2(KeyEvent keyEvent) {
        P2().invoke();
        return true;
    }

    public final void a3(InterfaceC18507om4 interfaceC18507om4, InterfaceC17521n63 interfaceC17521n63, boolean z, String str, B26 b26, SA2 sa2) {
        Y2(interfaceC18507om4, interfaceC17521n63, z, str, b26, sa2);
    }

    private f(InterfaceC18507om4 interfaceC18507om4, InterfaceC17521n63 interfaceC17521n63, boolean z, String str, B26 b26, SA2 sa2) {
        super(interfaceC18507om4, interfaceC17521n63, z, str, b26, sa2, null);
    }
}
