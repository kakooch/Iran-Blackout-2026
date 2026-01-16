package ir.nasim;

import ir.nasim.YT4;
import ir.nasim.database.entity.ContactEntity;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.bj1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10504bj1 extends YT4 {
    private List b;

    /* renamed from: ir.nasim.bj1$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int c;
        final /* synthetic */ YT4.a d;
        final /* synthetic */ C10504bj1 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i, YT4.a aVar, C10504bj1 c10504bj1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = i;
            this.d = aVar;
            this.e = c10504bj1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            int i = this.c;
            Integer numD = i == 0 ? null : AbstractC6392Nk0.d(i - this.d.b());
            int iB = this.c + this.d.b();
            if (iB >= this.e.i().size()) {
                iB = this.e.i().size();
            }
            return new YT4.b.c(AbstractC15401jX0.Y0(this.e.i(), AbstractC23053wG5.y(this.c, iB)), numD, this.c != this.e.i().size() ? AbstractC6392Nk0.d(iB) : null);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C10504bj1(String str, List list) {
        AbstractC13042fc3.i(str, "search");
        AbstractC13042fc3.i(list, ContactEntity.TABLE_NAME);
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            String name = ((C3512Be1) obj).getName();
            AbstractC13042fc3.h(name, "getName(...)");
            if (AbstractC20762sZ6.V(name, str, true)) {
                arrayList.add(obj);
            }
        }
        this.b = arrayList;
    }

    @Override // ir.nasim.YT4
    public Object f(YT4.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
        Integer num = (Integer) aVar.a();
        return AbstractC9323Zl0.g(C12366eV1.b(), new a(num != null ? num.intValue() : 0, aVar, this, null), interfaceC20295rm1);
    }

    public final List i() {
        return this.b;
    }

    @Override // ir.nasim.YT4
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Integer d(ZT4 zt4) {
        AbstractC13042fc3.i(zt4, "state");
        return 0;
    }
}
