package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeerType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public final class SF3 {
    private final UG7 a;
    private final AbstractC13778go1 b;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List c;
        final /* synthetic */ SF3 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(List list, SF3 sf3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = list;
            this.d = sf3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objD;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                List list = this.c;
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : list) {
                    C5886Lg2 c5886Lg2 = (C5886Lg2) obj2;
                    if (c5886Lg2.f().getExPeerType() == ExPeerType.GROUP || c5886Lg2.f().getExPeerType() == ExPeerType.CHANNEL) {
                        arrayList.add(obj2);
                    }
                }
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new C25238zy(((C5886Lg2) it.next()).f().getPeerId(), 0L));
                }
                C6517Nv5 c6517Nv5W = this.d.a.W(arrayList2);
                AbstractC13042fc3.h(c6517Nv5W, "forceLoadRequiredGroupPeers(...)");
                this.b = 1;
                objD = AbstractC6756Ov5.d(c6517Nv5W, null, this, 1, null);
                if (objD == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objD = ((C9475a16) obj).l();
            }
            if (C9475a16.g(objD)) {
                return null;
            }
            return objD;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ ArrayList c;
        final /* synthetic */ SF3 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ArrayList arrayList, SF3 sf3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = arrayList;
            this.d = sf3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objD;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                ArrayList arrayList = this.c;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : arrayList) {
                    C22114uh2 c22114uh2 = (C22114uh2) obj2;
                    if (c22114uh2.e() == ExPeerType.GROUP || c22114uh2.e() == ExPeerType.CHANNEL) {
                        arrayList2.add(obj2);
                    }
                }
                ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(arrayList2, 10));
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList3.add(new C25238zy(((C22114uh2) it.next()).l(), 0L));
                }
                C6517Nv5 c6517Nv5W = this.d.a.W(arrayList3);
                AbstractC13042fc3.h(c6517Nv5W, "forceLoadRequiredGroupPeers(...)");
                this.b = 1;
                objD = AbstractC6756Ov5.d(c6517Nv5W, null, this, 1, null);
                if (objD == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objD = ((C9475a16) obj).l();
            }
            if (C9475a16.g(objD)) {
                return null;
            }
            return objD;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public SF3(UG7 ug7, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(ug7, "updates");
        AbstractC13042fc3.i(abstractC13778go1, "dispatcher");
        this.a = ug7;
        this.b = abstractC13778go1;
    }

    public final Object b(ArrayList arrayList, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new b(arrayList, this, null), interfaceC20295rm1);
    }

    public final Object c(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new a(list, this, null), interfaceC20295rm1);
    }
}
