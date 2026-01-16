package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class WG3 {
    private final DD3 a;
    private final InterfaceC14123hO3 b;
    private final InterfaceC14123hO3 c;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = WG3.this.new a(interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            List list = (List) this.c;
            InterfaceC14123hO3 interfaceC14123hO3 = WG3.this.c;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add((FD3) interfaceC14123hO3.a((HD3) it.next()));
            }
            return arrayList;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public WG3(DD3 dd3, InterfaceC14123hO3 interfaceC14123hO3, InterfaceC14123hO3 interfaceC14123hO32) {
        AbstractC13042fc3.i(dd3, "liveStreamDao");
        AbstractC13042fc3.i(interfaceC14123hO3, "liveStreamDataToLiveStreamEntityMapper");
        AbstractC13042fc3.i(interfaceC14123hO32, "liveStreamEntityToLiveStreamDataMapper");
        this.a = dd3;
        this.b = interfaceC14123hO3;
        this.c = interfaceC14123hO32;
    }

    public final Object b(Iterable iterable, InterfaceC20295rm1 interfaceC20295rm1) {
        DD3 dd3 = this.a;
        InterfaceC14123hO3 interfaceC14123hO3 = this.b;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(iterable, 10));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add((HD3) interfaceC14123hO3.a((FD3) it.next()));
        }
        Object objF = dd3.f(arrayList, interfaceC20295rm1);
        return objF == AbstractC14862ic3.e() ? objF : C19938rB7.a;
    }

    public final Object c(FD3 fd3, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objH = this.a.h((HD3) this.b.a(fd3), interfaceC20295rm1);
        return objH == AbstractC14862ic3.e() ? objH : C19938rB7.a;
    }

    public final InterfaceC4557Fq2 d() {
        return AbstractC6459Nq2.X(this.a.e(), new a(null));
    }

    public final Object e(long j, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objD = this.a.d(j, interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }

    public final Object f(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objB = this.a.b(interfaceC20295rm1);
        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
    }
}
