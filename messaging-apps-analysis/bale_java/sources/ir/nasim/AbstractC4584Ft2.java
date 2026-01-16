package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.res.Resources;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC4584Ft2;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC22053ub1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Ft2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC4584Ft2 {

    /* renamed from: ir.nasim.Ft2$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List c;
        final /* synthetic */ InterfaceC9102Ym4 d;
        final /* synthetic */ InterfaceC9102Ym4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(List list, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = list;
            this.d = interfaceC9102Ym4;
            this.e = interfaceC9102Ym42;
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
            List list = this.c;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : list) {
                if (((C8870Xr2) obj2).e()) {
                    arrayList.add(obj2);
                } else {
                    arrayList2.add(obj2);
                }
            }
            XV4 xv4 = new XV4(arrayList, arrayList2);
            List list2 = (List) xv4.a();
            List list3 = (List) xv4.b();
            if (!AbstractC13042fc3.d(list2, AbstractC4584Ft2.o(this.d))) {
                AbstractC4584Ft2.p(this.d, list2);
            }
            if (!AbstractC13042fc3.d(list3, AbstractC4584Ft2.q(this.e))) {
                AbstractC4584Ft2.r(this.e, list3);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ft2$b */
    static final class b implements PointerInputEventHandler {
        final /* synthetic */ defpackage.t a;

        b(defpackage.t tVar) {
            this.a = tVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 e(defpackage.t tVar, ZG4 zg4) {
            AbstractC13042fc3.i(tVar, "$dragDropState");
            tVar.f(zg4.t());
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(defpackage.t tVar) {
            AbstractC13042fc3.i(tVar, "$dragDropState");
            tVar.e();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 g(defpackage.t tVar) {
            AbstractC13042fc3.i(tVar, "$dragDropState");
            tVar.e();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(defpackage.t tVar, C6616Og5 c6616Og5, ZG4 zg4) {
            AbstractC13042fc3.i(tVar, "$dragDropState");
            AbstractC13042fc3.i(c6616Og5, "change");
            c6616Og5.a();
            tVar.d(zg4.t());
            return C19938rB7.a;
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
            final defpackage.t tVar = this.a;
            UA2 ua2 = new UA2() { // from class: ir.nasim.Gt2
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return AbstractC4584Ft2.b.e(tVar, (ZG4) obj);
                }
            };
            final defpackage.t tVar2 = this.a;
            SA2 sa2 = new SA2() { // from class: ir.nasim.Ht2
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return AbstractC4584Ft2.b.f(tVar2);
                }
            };
            final defpackage.t tVar3 = this.a;
            SA2 sa22 = new SA2() { // from class: ir.nasim.It2
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return AbstractC4584Ft2.b.g(tVar3);
                }
            };
            final defpackage.t tVar4 = this.a;
            Object objG = EZ1.g(interfaceC9049Yg5, ua2, sa2, sa22, new InterfaceC14603iB2() { // from class: ir.nasim.Jt2
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC4584Ft2.b.h(tVar4, (C6616Og5) obj, (ZG4) obj2);
                }
            }, interfaceC20295rm1);
            return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ft2$c */
    static final class c implements InterfaceC15796kB2 {
        final /* synthetic */ InterfaceC9102Ym4 a;

        c(InterfaceC9102Ym4 interfaceC9102Ym4) {
            this.a = interfaceC9102Ym4;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC4584Ft2.w(UY6.c(FD5.your_folders, interfaceC22053ub1, 0), UY6.d(AbstractC4584Ft2.o(this.a).size() == 1 ? FD5.count_folder : FD5.count_folders, new Object[]{Integer.valueOf(AbstractC4584Ft2.o(this.a).size())}, interfaceC22053ub1, 0), interfaceC22053ub1, 0, 0);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ft2$d */
    static final class d implements InterfaceC15796kB2 {
        final /* synthetic */ InterfaceC13228fs2 a;
        final /* synthetic */ InterfaceC9102Ym4 b;

        d(InterfaceC13228fs2 interfaceC13228fs2, InterfaceC9102Ym4 interfaceC9102Ym4) {
            this.a = interfaceC13228fs2;
            this.b = interfaceC9102Ym4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(InterfaceC13228fs2 interfaceC13228fs2, InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(interfaceC13228fs2, "$folderListAction");
            AbstractC13042fc3.i(interfaceC9102Ym4, "$activeFolders$delegate");
            interfaceC13228fs2.getOnCreateNewFolderClick().invoke(Integer.valueOf(AbstractC4584Ft2.o(interfaceC9102Ym4).size()));
            return C19938rB7.a;
        }

        public final void b(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            String strC = UY6.c(FD5.add_folder, interfaceC22053ub1, 0);
            int i2 = AbstractC16390lB5.add_to_folder;
            G10 g10 = G10.a;
            int i3 = G10.b;
            C11984ds7 c11984ds7 = new C11984ds7(g10.a(interfaceC22053ub1, i3).r(), g10.a(interfaceC22053ub1, i3).I(), g10.a(interfaceC22053ub1, i3).z(), g10.a(interfaceC22053ub1, i3).I(), null);
            interfaceC22053ub1.W(1852209773);
            boolean zD = interfaceC22053ub1.D(this.a);
            final InterfaceC13228fs2 interfaceC13228fs2 = this.a;
            final InterfaceC9102Ym4 interfaceC9102Ym4 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Kt2
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC4584Ft2.d.c(interfaceC13228fs2, interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC16797ls7.i(strC, i2, null, null, null, null, c11984ds7, (SA2) objB, null, false, interfaceC22053ub1, C11984ds7.f << 18, 828);
            MY2.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null), C17784nZ1.q(1)), null, 0L, interfaceC22053ub1, 6, 6);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ft2$e */
    static final class e implements UA2 {
        final /* synthetic */ InterfaceC9102Ym4 a;

        e(InterfaceC9102Ym4 interfaceC9102Ym4) {
            this.a = interfaceC9102Ym4;
        }

        public final void a(InterfaceC11379cu3 interfaceC11379cu3) {
            AbstractC13042fc3.i(interfaceC11379cu3, "coordinates");
            AbstractC4584Ft2.m(this.a, interfaceC11379cu3.p0(ZG4.b.c()));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC11379cu3) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ft2$f */
    public static final class f implements InterfaceC14603iB2 {
        final /* synthetic */ UA2 a;

        public f(UA2 ua2) {
            this.a = ua2;
        }

        public final Object a(int i, Object obj) {
            Object objInvoke;
            UA2 ua2 = this.a;
            return (ua2 == null || (objInvoke = ua2.invoke(obj)) == null) ? Integer.valueOf(i) : objInvoke;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((Number) obj).intValue(), obj2);
        }
    }

    /* renamed from: ir.nasim.Ft2$g */
    public static final class g extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC14603iB2 e;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(InterfaceC14603iB2 interfaceC14603iB2, List list) {
            super(1);
            this.e = interfaceC14603iB2;
            this.f = list;
        }

        public final Object a(int i) {
            return this.e.invoke(Integer.valueOf(i), this.f.get(i));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    /* renamed from: ir.nasim.Ft2$h */
    public static final class h extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ List e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(List list) {
            super(1);
            this.e = list;
        }

        public final Object a(int i) {
            this.e.get(i);
            return new defpackage.v(i);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    /* renamed from: ir.nasim.Ft2$i */
    public static final class i extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
        final /* synthetic */ List e;
        final /* synthetic */ defpackage.t f;
        final /* synthetic */ InterfaceC13228fs2 g;

        /* renamed from: ir.nasim.Ft2$i$a */
        public static final class a implements UA2 {
            final /* synthetic */ defpackage.t a;

            public a(defpackage.t tVar) {
                this.a = tVar;
            }

            public final void a(androidx.compose.ui.graphics.c cVar) {
                AbstractC13042fc3.i(cVar, "$this$graphicsLayer");
                cVar.e(this.a.a());
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((androidx.compose.ui.graphics.c) obj);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(List list, defpackage.t tVar, InterfaceC13228fs2 interfaceC13228fs2) {
            super(4);
            this.e = list;
            this.f = tVar;
            this.g = interfaceC13228fs2;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            int i3;
            androidx.compose.ui.e eVarA;
            androidx.compose.ui.e eVarD;
            if ((i2 & 6) == 0) {
                i3 = (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2) | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
            }
            boolean z = false;
            if (!interfaceC22053ub1.o((i3 & 147) != 146, i3 & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1091073711, i3, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
            }
            Object obj = this.e.get(i);
            interfaceC22053ub1.W(1917688087);
            Integer numB = this.f.b();
            if (numB != null && i == numB.intValue()) {
                z = true;
            }
            interfaceC22053ub1.W(-2016346676);
            if (z) {
                androidx.compose.ui.e eVarA2 = Ac8.a(androidx.compose.ui.e.a, 1.0f);
                interfaceC22053ub1.W(-2016343748);
                boolean zD = interfaceC22053ub1.D(this.f);
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new a(this.f);
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                eVarA = androidx.compose.ui.graphics.b.a(eVarA2, (UA2) objB);
            } else {
                eVarA = androidx.compose.ui.e.a;
            }
            interfaceC22053ub1.Q();
            C8870Xr2 c8870Xr2 = (C8870Xr2) obj;
            interfaceC22053ub1.W(1584689137);
            interfaceC22053ub1.W(1852234607);
            Object objB2 = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB2 == aVar.a()) {
                objB2 = AbstractC13472gH6.d(ZG4.d(ZG4.b.c()), null, 2, null);
                interfaceC22053ub1.s(objB2);
            }
            InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB2;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(1852238737);
            Object objB3 = interfaceC22053ub1.B();
            if (objB3 == aVar.a()) {
                objB3 = new e(interfaceC9102Ym4);
                interfaceC22053ub1.s(objB3);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarA3 = androidx.compose.ui.layout.c.a(eVarA, (UA2) objB3);
            if (z) {
                interfaceC22053ub1.W(1584973747);
                eVarD = androidx.compose.foundation.b.d(androidx.compose.ui.e.a, G10.a.a(interfaceC22053ub1, G10.b).y(), null, 2, null);
                interfaceC22053ub1.Q();
            } else {
                interfaceC22053ub1.W(1585083084);
                eVarD = androidx.compose.foundation.b.d(androidx.compose.ui.e.a, G10.a.a(interfaceC22053ub1, G10.b).r(), null, 2, null);
                interfaceC22053ub1.Q();
            }
            AbstractC22224us2.q(c8870Xr2, eVarA3.i(eVarD), this.g, interfaceC22053ub1, 0, 0);
            interfaceC22053ub1.Q();
            interfaceC22053ub1.Q();
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ft2$j */
    public static final class j extends AbstractC8614Ws3 implements UA2 {
        public static final j e = new j();

        public j() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(Object obj) {
            return null;
        }
    }

    /* renamed from: ir.nasim.Ft2$k */
    public static final class k extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(UA2 ua2, List list) {
            super(1);
            this.e = ua2;
            this.f = list;
        }

        public final Object a(int i) {
            return this.e.invoke(this.f.get(i));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    /* renamed from: ir.nasim.Ft2$l */
    public static final class l extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(UA2 ua2, List list) {
            super(1);
            this.e = ua2;
            this.f = list;
        }

        public final Object a(int i) {
            return this.e.invoke(this.f.get(i));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    /* renamed from: ir.nasim.Ft2$m */
    public static final class m extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
        final /* synthetic */ List e;
        final /* synthetic */ InterfaceC13228fs2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(List list, InterfaceC13228fs2 interfaceC13228fs2) {
            super(4);
            this.e = list;
            this.f = interfaceC13228fs2;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            int i3;
            if ((i2 & 6) == 0) {
                i3 = (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2) | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
            }
            if (!interfaceC22053ub1.o((i3 & 147) != 146, i3 & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-632812321, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
            }
            C8870Xr2 c8870Xr2 = (C8870Xr2) this.e.get(i);
            interfaceC22053ub1.W(1583071402);
            AbstractC22224us2.q(c8870Xr2, null, this.f, interfaceC22053ub1, 0, 2);
            interfaceC22053ub1.Q();
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ft2$n */
    static final class n implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;

        /* renamed from: ir.nasim.Ft2$n$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ SA2 a;

            a(SA2 sa2) {
                this.a = sa2;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC21639ts7.i(UY6.c(FD5.settings_folders, interfaceC22053ub1, 0), FV0.b(AbstractC22050ua8.c(androidx.compose.ui.e.a, AbstractC21393ta8.g(C17979ns7.a.e(interfaceC22053ub1, C17979ns7.g), AbstractC23236wa8.a.f()))), this.a, null, null, null, null, interfaceC22053ub1, 0, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        n(SA2 sa2) {
            this.a = sa2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.a), AbstractC19242q11.e(305198380, true, new a(this.a), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ft2$o */
    static final class o implements InterfaceC14603iB2 {
        final /* synthetic */ C19391qG6 a;

        o(C19391qG6 c19391qG6) {
            this.a = c19391qG6;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC18209oG6.b(this.a, null, O51.a.a(), interfaceC22053ub1, 390, 2);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ft2$p */
    static final class p implements InterfaceC15796kB2 {
        final /* synthetic */ InterfaceC9664aL6 a;
        final /* synthetic */ C6236Mt2 b;
        final /* synthetic */ InterfaceC13228fs2 c;
        final /* synthetic */ C19391qG6 d;
        final /* synthetic */ InterfaceC9664aL6 e;

        /* renamed from: ir.nasim.Ft2$p$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC9664aL6 c;
            final /* synthetic */ C19391qG6 d;
            final /* synthetic */ Resources e;
            final /* synthetic */ C6236Mt2 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC9664aL6 interfaceC9664aL6, C19391qG6 c19391qG6, Resources resources, C6236Mt2 c6236Mt2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC9664aL6;
                this.d = c19391qG6;
                this.e = resources;
                this.f = c6236Mt2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 y(C6236Mt2 c6236Mt2) {
                c6236Mt2.g1();
                return C19938rB7.a;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, this.e, this.f, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    WF6 wf6T = AbstractC4584Ft2.t(this.c);
                    if (wf6T != null) {
                        C19391qG6 c19391qG6 = this.d;
                        Resources resources = this.e;
                        final C6236Mt2 c6236Mt2 = this.f;
                        AbstractC13042fc3.f(resources);
                        SA2 sa2 = new SA2() { // from class: ir.nasim.Lt2
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return AbstractC4584Ft2.p.a.y(c6236Mt2);
                            }
                        };
                        this.b = 1;
                        if (AbstractC4584Ft2.H(c19391qG6, wf6T, resources, sa2, this) == objE) {
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

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        p(InterfaceC9664aL6 interfaceC9664aL6, C6236Mt2 c6236Mt2, InterfaceC13228fs2 interfaceC13228fs2, C19391qG6 c19391qG6, InterfaceC9664aL6 interfaceC9664aL62) {
            this.a = interfaceC9664aL6;
            this.b = c6236Mt2;
            this.c = interfaceC13228fs2;
            this.d = c19391qG6;
            this.e = interfaceC9664aL62;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r3v6 ??, still in use, count: 1, list:
              (r3v6 ?? I:java.lang.Object) from 0x0074: INVOKE (r16v0 ?? I:ir.nasim.ub1), (r3v6 ?? I:java.lang.Object) INTERFACE call: ir.nasim.ub1.s(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:117)
            	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
            	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
            	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
            	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
            	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
            	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
            */
        public final void a(
        /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r3v6 ??, still in use, count: 1, list:
              (r3v6 ?? I:java.lang.Object) from 0x0074: INVOKE (r16v0 ?? I:ir.nasim.ub1), (r3v6 ?? I:java.lang.Object) INTERFACE call: ir.nasim.ub1.s(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:117)
            	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
            	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
            	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
            	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
            	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
            */
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r15v0 ??
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:405)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            */

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ft2$q */
    static final class q extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int c;

        q(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC4584Ft2.H(null, null, null, null, this);
        }
    }

    public static final /* synthetic */ WF6 D(InterfaceC9664aL6 interfaceC9664aL6) {
        return t(interfaceC9664aL6);
    }

    public static final /* synthetic */ List E(InterfaceC9664aL6 interfaceC9664aL6) {
        return u(interfaceC9664aL6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object H(ir.nasim.C19391qG6 r9, ir.nasim.WF6 r10, android.content.res.Resources r11, ir.nasim.SA2 r12, ir.nasim.InterfaceC20295rm1 r13) throws android.content.res.Resources.NotFoundException {
        /*
            boolean r0 = r13 instanceof ir.nasim.AbstractC4584Ft2.q
            if (r0 == 0) goto L14
            r0 = r13
            ir.nasim.Ft2$q r0 = (ir.nasim.AbstractC4584Ft2.q) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.c = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            ir.nasim.Ft2$q r0 = new ir.nasim.Ft2$q
            r0.<init>(r13)
            goto L12
        L1a:
            java.lang.Object r13 = r6.b
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.c
            r2 = 1
            if (r1 == 0) goto L38
            if (r1 != r2) goto L30
            java.lang.Object r9 = r6.a
            r12 = r9
            ir.nasim.SA2 r12 = (ir.nasim.SA2) r12
            ir.nasim.AbstractC10685c16.b(r13)
            goto L52
        L30:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L38:
            ir.nasim.AbstractC10685c16.b(r13)
            java.lang.String r10 = ir.nasim.AbstractC10829cG6.a(r10, r11)
            r6.a = r12
            r6.c = r2
            r3 = 0
            r4 = 0
            r5 = 0
            r7 = 14
            r8 = 0
            r1 = r9
            r2 = r10
            java.lang.Object r9 = ir.nasim.C19391qG6.f(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r9 != r0) goto L52
            return r0
        L52:
            r12.invoke()
            ir.nasim.rB7 r9 = ir.nasim.C19938rB7.a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC4584Ft2.H(ir.nasim.qG6, ir.nasim.WF6, android.content.res.Resources, ir.nasim.SA2, ir.nasim.rm1):java.lang.Object");
    }

    public static final void h(androidx.compose.ui.e eVar, final List list, final InterfaceC13228fs2 interfaceC13228fs2, InterfaceC22053ub1 interfaceC22053ub1, final int i2, final int i3) {
        androidx.compose.ui.e eVar2;
        int i4;
        final androidx.compose.ui.e eVar3;
        AbstractC13042fc3.i(list, "folderList");
        AbstractC13042fc3.i(interfaceC13228fs2, "folderListAction");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(2019896118);
        int i5 = i3 & 1;
        if (i5 != 0) {
            i4 = i2 | 6;
            eVar2 = eVar;
        } else if ((i2 & 6) == 0) {
            eVar2 = eVar;
            i4 = (interfaceC22053ub1J.V(eVar2) ? 4 : 2) | i2;
        } else {
            eVar2 = eVar;
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            i4 |= interfaceC22053ub1J.D(list) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i2 & 384) == 0) {
            i4 |= (i2 & 512) == 0 ? interfaceC22053ub1J.V(interfaceC13228fs2) : interfaceC22053ub1J.D(interfaceC13228fs2) ? 256 : 128;
        }
        int i6 = i4;
        if ((i6 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            eVar3 = eVar2;
        } else {
            eVar3 = i5 != 0 ? androidx.compose.ui.e.a : eVar2;
            interfaceC22053ub1J.W(109126595);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC13472gH6.d(AbstractC10360bX0.m(), null, 2, null);
                interfaceC22053ub1J.s(objB);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(109129315);
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == aVar.a()) {
                objB2 = AbstractC13472gH6.d(AbstractC10360bX0.m(), null, 2, null);
                interfaceC22053ub1J.s(objB2);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym42 = (InterfaceC9102Ym4) objB2;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(109132392);
            boolean zD = interfaceC22053ub1J.D(list);
            Object objB3 = interfaceC22053ub1J.B();
            if (zD || objB3 == aVar.a()) {
                objB3 = new a(list, interfaceC9102Ym4, interfaceC9102Ym42, null);
                interfaceC22053ub1J.s(objB3);
            }
            interfaceC22053ub1J.Q();
            AbstractC10721c52.e(list, (InterfaceC14603iB2) objB3, interfaceC22053ub1J, (i6 >> 3) & 14);
            C19206px3 c19206px3B = AbstractC19797qx3.b(0, 0, interfaceC22053ub1J, 0, 3);
            int size = o(interfaceC9102Ym4).size();
            interfaceC22053ub1J.W(109146637);
            Object objB4 = interfaceC22053ub1J.B();
            if (objB4 == aVar.a()) {
                objB4 = new InterfaceC14603iB2() { // from class: ir.nasim.zt2
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj, Object obj2) {
                        return AbstractC4584Ft2.i(interfaceC9102Ym4, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                    }
                };
                interfaceC22053ub1J.s(objB4);
            }
            InterfaceC14603iB2 interfaceC14603iB2 = (InterfaceC14603iB2) objB4;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(109152561);
            int i7 = i6 & 896;
            boolean z = i7 == 256 || ((i6 & 512) != 0 && interfaceC22053ub1J.D(interfaceC13228fs2));
            Object objB5 = interfaceC22053ub1J.B();
            if (z || objB5 == aVar.a()) {
                objB5 = new SA2() { // from class: ir.nasim.At2
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC4584Ft2.j(interfaceC13228fs2, interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1J.s(objB5);
            }
            interfaceC22053ub1J.Q();
            boolean z2 = true;
            final defpackage.t tVarA = defpackage.u.a(c19206px3B, interfaceC14603iB2, (SA2) objB5, size, interfaceC22053ub1J, 48);
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(eVar3, 0.0f, 1, null);
            interfaceC22053ub1J.W(109162096);
            boolean zD2 = interfaceC22053ub1J.D(tVarA);
            Object objB6 = interfaceC22053ub1J.B();
            if (zD2 || objB6 == aVar.a()) {
                objB6 = new b(tVarA);
                interfaceC22053ub1J.s(objB6);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarC = AbstractC21071t37.c(eVarF, tVarA, (PointerInputEventHandler) objB6);
            C24254yJ.m mVarH = C24254yJ.a.h();
            interfaceC22053ub1J.W(109182363);
            if (i7 != 256 && ((i6 & 512) == 0 || !interfaceC22053ub1J.D(interfaceC13228fs2))) {
                z2 = false;
            }
            boolean zD3 = interfaceC22053ub1J.D(tVarA) | z2;
            Object objB7 = interfaceC22053ub1J.B();
            if (zD3 || objB7 == aVar.a()) {
                objB7 = new UA2() { // from class: ir.nasim.Bt2
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC4584Ft2.k(tVarA, interfaceC9102Ym42, interfaceC13228fs2, interfaceC9102Ym4, (InterfaceC15069ix3) obj);
                    }
                };
                interfaceC22053ub1J.s(objB7);
            }
            interfaceC22053ub1J.Q();
            AbstractC12623ev3.b(eVarC, c19206px3B, null, false, mVarH, null, null, false, null, (UA2) objB7, interfaceC22053ub1J, 24576, 492);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Ct2
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC4584Ft2.n(eVar3, list, interfaceC13228fs2, i2, i3, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(InterfaceC9102Ym4 interfaceC9102Ym4, int i2, int i3) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$activeFolders$delegate");
        List listP1 = AbstractC15401jX0.p1(o(interfaceC9102Ym4));
        listP1.add(i3, listP1.remove(i2));
        p(interfaceC9102Ym4, listP1);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(InterfaceC13228fs2 interfaceC13228fs2, InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC13228fs2, "$folderListAction");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$activeFolders$delegate");
        UA2 ua2D = interfaceC13228fs2.d();
        List listO = o(interfaceC9102Ym4);
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listO, 10));
        Iterator it = listO.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((C8870Xr2) it.next()).c()));
        }
        ua2D.invoke(AbstractC15401jX0.m1(arrayList));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(defpackage.t tVar, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC13228fs2 interfaceC13228fs2, InterfaceC9102Ym4 interfaceC9102Ym42, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(tVar, "$dragDropState");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$inActiveFolders$delegate");
        AbstractC13042fc3.i(interfaceC13228fs2, "$folderListAction");
        AbstractC13042fc3.i(interfaceC9102Ym42, "$activeFolders$delegate");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
        if (!q(interfaceC9102Ym4).isEmpty()) {
            InterfaceC15069ix3.d(interfaceC15069ix3, null, null, O51.a.b(), 3, null);
        }
        List listQ = q(interfaceC9102Ym4);
        interfaceC15069ix3.a(listQ.size(), new k(new UA2() { // from class: ir.nasim.Et2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return AbstractC4584Ft2.l((C8870Xr2) obj);
            }
        }, listQ), new l(j.e, listQ), AbstractC19242q11.c(-632812321, true, new m(listQ, interfaceC13228fs2)));
        if (!o(interfaceC9102Ym42).isEmpty()) {
            InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(-1777388241, true, new c(interfaceC9102Ym42)), 3, null);
        }
        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(-1791306175, true, new d(interfaceC13228fs2, interfaceC9102Ym42)), 3, null);
        List listO = o(interfaceC9102Ym42);
        interfaceC15069ix3.a(listO.size(), new g(new f(null), listO), new h(listO), AbstractC19242q11.c(-1091073711, true, new i(listO, tVar, interfaceC13228fs2)));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object l(C8870Xr2 c8870Xr2) {
        AbstractC13042fc3.i(c8870Xr2, "folder");
        return Integer.valueOf(c8870Xr2.c() + AbstractC17026mG5.a.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(InterfaceC9102Ym4 interfaceC9102Ym4, long j2) {
        interfaceC9102Ym4.setValue(ZG4.d(j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(androidx.compose.ui.e eVar, List list, InterfaceC13228fs2 interfaceC13228fs2, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(list, "$folderList");
        AbstractC13042fc3.i(interfaceC13228fs2, "$folderListAction");
        h(eVar, list, interfaceC13228fs2, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List o(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (List) interfaceC9102Ym4.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(InterfaceC9102Ym4 interfaceC9102Ym4, List list) {
        interfaceC9102Ym4.setValue(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List q(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (List) interfaceC9102Ym4.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(InterfaceC9102Ym4 interfaceC9102Ym4, List list) {
        interfaceC9102Ym4.setValue(list);
    }

    public static final void s(final SA2 sa2, final InterfaceC13228fs2 interfaceC13228fs2, final C6236Mt2 c6236Mt2, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(sa2, "onBackPress");
        AbstractC13042fc3.i(interfaceC13228fs2, "folderListAction");
        AbstractC13042fc3.i(c6236Mt2, "viewModel");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1219658152);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= (i2 & 64) == 0 ? interfaceC22053ub1J.V(interfaceC13228fs2) : interfaceC22053ub1J.D(interfaceC13228fs2) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(c6236Mt2) ? 256 : 128;
        }
        if ((i3 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            interfaceC22053ub1J.W(15019868);
            Object objB = interfaceC22053ub1J.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new C19391qG6();
                interfaceC22053ub1J.s(objB);
            }
            C19391qG6 c19391qG6 = (C19391qG6) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC11029cc6.a(androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), AbstractC19242q11.e(1934610540, true, new n(sa2), interfaceC22053ub1J, 54), null, AbstractC19242q11.e(-2015528594, true, new o(c19391qG6), interfaceC22053ub1J, 54), null, 0, G10.a.a(interfaceC22053ub1J, G10.b).r(), 0L, null, AbstractC19242q11.e(-1167862089, true, new p(AbstractC5976Lq2.c(c6236Mt2.a1(), null, null, null, interfaceC22053ub1J, 0, 7), c6236Mt2, interfaceC13228fs2, c19391qG6, AbstractC5976Lq2.c(c6236Mt2.Y0(), null, null, null, interfaceC22053ub1J, 0, 7)), interfaceC22053ub12, 54), interfaceC22053ub12, 805309494, 436);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.yt2
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC4584Ft2.v(sa2, interfaceC13228fs2, c6236Mt2, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WF6 t(InterfaceC9664aL6 interfaceC9664aL6) {
        return (WF6) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List u(InterfaceC9664aL6 interfaceC9664aL6) {
        return (List) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v(SA2 sa2, InterfaceC13228fs2 interfaceC13228fs2, C6236Mt2 c6236Mt2, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(sa2, "$onBackPress");
        AbstractC13042fc3.i(interfaceC13228fs2, "$folderListAction");
        AbstractC13042fc3.i(c6236Mt2, "$viewModel");
        s(sa2, interfaceC13228fs2, c6236Mt2, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void w(java.lang.String r33, java.lang.String r34, ir.nasim.InterfaceC22053ub1 r35, final int r36, final int r37) {
        /*
            Method dump skipped, instructions count: 398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC4584Ft2.w(java.lang.String, java.lang.String, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x(String str, String str2, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        w(str, str2, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }
}
