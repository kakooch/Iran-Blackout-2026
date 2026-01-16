package ir.nasim;

import ir.nasim.C9475a16;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: ir.nasim.yo1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC24549yo1 {

    /* renamed from: ir.nasim.yo1$a */
    static final class a implements UA2 {
        final /* synthetic */ HE0 a;
        final /* synthetic */ C12889fL5 b;
        final /* synthetic */ AtomicInteger c;

        a(HE0 he0, C12889fL5 c12889fL5, AtomicInteger atomicInteger) {
            this.a = he0;
            this.b = c12889fL5;
            this.c = atomicInteger;
        }

        public final void a(Throwable th) {
            if (th == null) {
                if (this.c.decrementAndGet() == 0) {
                    AbstractC24549yo1.c(this.a, C19938rB7.a);
                    return;
                }
                return;
            }
            if (this.a.b()) {
                HE0 he0 = this.a;
                C9475a16.a aVar = C9475a16.b;
                he0.resumeWith(C9475a16.b(AbstractC10685c16.a(th)));
            }
            List list = (List) this.b.a;
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((NV1) it.next()).dispose();
                }
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.yo1$b */
    static final class b implements UA2 {
        final /* synthetic */ C12889fL5 a;

        b(C12889fL5 c12889fL5) {
            this.a = c12889fL5;
        }

        public final void a(Throwable th) {
            Iterator it = ((Iterable) this.a.a).iterator();
            while (it.hasNext()) {
                ((NV1) it.next()).dispose();
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.yo1$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ UA2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = ua2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                UA2 ua2 = this.c;
                this.b = 1;
                obj = ua2.invoke(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final Object a(Collection collection, InterfaceC20295rm1 interfaceC20295rm1) {
        IE0 ie0 = new IE0(AbstractC14251hc3.c(interfaceC20295rm1), 1);
        ie0.w();
        AtomicInteger atomicInteger = new AtomicInteger(collection.size());
        C12889fL5 c12889fL5 = new C12889fL5();
        Collection<InterfaceC13730gj3> collection2 = collection;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(collection2, 10));
        for (InterfaceC13730gj3 interfaceC13730gj3 : collection2) {
            interfaceC13730gj3.start();
            arrayList.add(interfaceC13730gj3.s(new a(ie0, c12889fL5, atomicInteger)));
        }
        c12889fL5.a = arrayList;
        if (ie0.p()) {
            Iterator it = ((Iterable) c12889fL5.a).iterator();
            while (it.hasNext()) {
                ((NV1) it.next()).dispose();
            }
        } else {
            ie0.J(new b(c12889fL5));
        }
        Object objT = ie0.t();
        if (objT == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objT == AbstractC14862ic3.e() ? objT : C19938rB7.a;
    }

    public static final Object b(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "block");
        return AbstractC9913am0.b(null, new c(ua2, null), 1, null);
    }

    public static final void c(HE0 he0, Object obj) {
        AbstractC13042fc3.i(he0, "<this>");
        try {
            if (he0.b()) {
                he0.resumeWith(C9475a16.b(obj));
            }
        } catch (IllegalStateException unused) {
        }
    }
}
