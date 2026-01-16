package ir.nasim;

import ir.nasim.AbstractC21430te5;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.on7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C18520on7 implements InterfaceC10970cW3 {
    private final SA2 a;
    private final SA2 b;

    /* renamed from: ir.nasim.on7$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ List e;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(List list, List list2) {
            super(1);
            this.e = list;
            this.f = list2;
        }

        public final void a(AbstractC21430te5.a aVar) {
            List list = this.e;
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    XV4 xv4 = (XV4) list.get(i);
                    AbstractC21430te5.a.j(aVar, (AbstractC21430te5) xv4.a(), ((C22045ua3) xv4.b()).r(), 0.0f, 2, null);
                }
            }
            List list2 = this.f;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    XV4 xv42 = (XV4) list2.get(i2);
                    AbstractC21430te5 abstractC21430te5 = (AbstractC21430te5) xv42.a();
                    SA2 sa2 = (SA2) xv42.b();
                    AbstractC21430te5.a.j(aVar, abstractC21430te5, sa2 != null ? ((C22045ua3) sa2.invoke()).r() : C22045ua3.b.b(), 0.0f, 2, null);
                }
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    public C18520on7(SA2 sa2, SA2 sa22) {
        this.a = sa2;
        this.b = sa22;
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, List list, long j) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList(list.size());
        List list2 = list;
        int size = list2.size();
        for (int i = 0; i < size; i++) {
            Object obj = list.get(i);
            if (!(((ZV3) obj).h() instanceof C5252In7)) {
                arrayList2.add(obj);
            }
        }
        List list3 = (List) this.b.invoke();
        if (list3 != null) {
            ArrayList arrayList3 = new ArrayList(list3.size());
            int size2 = list3.size();
            for (int i2 = 0; i2 < size2; i2++) {
                CK5 ck5 = (CK5) list3.get(i2);
                XV4 xv4 = ck5 != null ? new XV4(((ZV3) arrayList2.get(i2)).l0(AbstractC19606qe1.b(0, (int) Math.floor(ck5.j() - ck5.i()), 0, (int) Math.floor(ck5.e() - ck5.l()), 5, null)), C22045ua3.c(C22045ua3.f((Math.round(ck5.l()) & 4294967295L) | (Math.round(ck5.i()) << 32)))) : null;
                if (xv4 != null) {
                    arrayList3.add(xv4);
                }
            }
            arrayList = arrayList3;
        } else {
            arrayList = null;
        }
        ArrayList arrayList4 = new ArrayList(list.size());
        int size3 = list2.size();
        for (int i3 = 0; i3 < size3; i3++) {
            Object obj2 = list.get(i3);
            if (((ZV3) obj2).h() instanceof C5252In7) {
                arrayList4.add(obj2);
            }
        }
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, C17833ne1.l(j), C17833ne1.k(j), null, new a(arrayList, AbstractC22072ud0.k(arrayList4, this.a)), 4, null);
    }
}
