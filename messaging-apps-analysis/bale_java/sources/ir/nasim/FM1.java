package ir.nasim;

import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes5.dex */
public abstract class FM1 {

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ Collection d;
        final /* synthetic */ BM1 e;

        /* renamed from: ir.nasim.FM1$a$a, reason: collision with other inner class name */
        static final class C0366a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ BM1 c;
            final /* synthetic */ DialogEntity d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0366a(BM1 bm1, DialogEntity dialogEntity, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = bm1;
                this.d = dialogEntity;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0366a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    BM1 bm1 = this.c;
                    DialogEntity dialogEntity = this.d;
                    this.b = 1;
                    obj = bm1.b(dialogEntity, this);
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
                return ((C0366a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Collection collection, BM1 bm1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = collection;
            this.e = bm1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.d, this.e, interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                Collection collection = this.d;
                BM1 bm1 = this.e;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(collection, 10));
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    arrayList.add(AbstractC10533bm0.b(interfaceC20315ro1, null, null, new C0366a(bm1, (DialogEntity) it.next(), null), 3, null));
                }
                this.b = 1;
                obj = DV.a(arrayList, this);
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
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final Object a(BM1 bm1, Collection collection, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC20906so1.e(new a(collection, bm1, null), interfaceC20295rm1);
    }
}
