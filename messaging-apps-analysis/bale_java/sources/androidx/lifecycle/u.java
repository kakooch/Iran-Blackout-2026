package androidx.lifecycle;

import androidx.lifecycle.j;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC9323Zl0;
import ir.nasim.C12366eV1;
import ir.nasim.C19938rB7;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.L15;

/* loaded from: classes2.dex */
public abstract class u {

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ j d;
        final /* synthetic */ j.b e;
        final /* synthetic */ InterfaceC14603iB2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(j jVar, j.b bVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = jVar;
            this.e = bVar;
            this.f = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.d, this.e, this.f, interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws Throwable {
            k kVar;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kVar = (k) this.c;
                try {
                    AbstractC10685c16.b(obj);
                    kVar.b();
                    return obj;
                } catch (Throwable th) {
                    th = th;
                    kVar.b();
                    throw th;
                }
            }
            AbstractC10685c16.b(obj);
            InterfaceC13730gj3 interfaceC13730gj3 = (InterfaceC13730gj3) ((InterfaceC20315ro1) this.c).getCoroutineContext().a(InterfaceC13730gj3.n0);
            if (interfaceC13730gj3 == null) {
                throw new IllegalStateException("when[State] methods should have a parent job".toString());
            }
            L15 l15 = new L15();
            k kVar2 = new k(this.d, this.e, l15.c, interfaceC13730gj3);
            try {
                InterfaceC14603iB2 interfaceC14603iB2 = this.f;
                this.c = kVar2;
                this.b = 1;
                obj = AbstractC9323Zl0.g(l15, interfaceC14603iB2, this);
                if (obj == objE) {
                    return objE;
                }
                kVar = kVar2;
                kVar.b();
                return obj;
            } catch (Throwable th2) {
                th = th2;
                kVar = kVar2;
                kVar.b();
                throw th;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final Object a(j jVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        return d(jVar, j.b.CREATED, interfaceC14603iB2, interfaceC20295rm1);
    }

    public static final Object b(j jVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        return d(jVar, j.b.RESUMED, interfaceC14603iB2, interfaceC20295rm1);
    }

    public static final Object c(j jVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        return d(jVar, j.b.STARTED, interfaceC14603iB2, interfaceC20295rm1);
    }

    public static final Object d(j jVar, j.b bVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.c().F0(), new a(jVar, bVar, interfaceC14603iB2, null), interfaceC20295rm1);
    }
}
