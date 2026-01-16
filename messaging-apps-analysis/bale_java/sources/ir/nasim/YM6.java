package ir.nasim;

import ai.bale.proto.ImagesOuterClass$ResponseLoadStickerCollection;
import android.gov.nist.core.Separators;
import ir.nasim.BN6;
import ir.nasim.Z06;
import ir.nasim.core.network.RpcException;
import ir.nasim.features.smiles.panel.sticker.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes6.dex */
public final class YM6 extends VW7 {
    private final BN6 b;
    private OM6 c;
    private final C20298rm4 d;
    private final C20298rm4 e;
    private final int f;
    private int g;

    public static final class a {
        private final String a;
        private final List b;
        private final boolean c;

        public a(String str, List list, boolean z) {
            AbstractC13042fc3.i(str, "stickerName");
            AbstractC13042fc3.i(list, "pack");
            this.a = str;
            this.b = list;
            this.c = z;
        }

        public final boolean a() {
            return this.c;
        }

        public final List b() {
            return this.b;
        }

        public final String c() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(this.b, aVar.b) && this.c == aVar.c;
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Boolean.hashCode(this.c);
        }

        public String toString() {
            return "PackDetail(stickerName=" + this.a + ", pack=" + this.b + ", owned=" + this.c + Separators.RPAREN;
        }
    }

    public static final class b {
        private final boolean a;
        private final int b;

        public b(boolean z, int i) {
            this.a = z;
            this.b = i;
        }

        public final int a() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.b == bVar.b;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.a) * 31) + Integer.hashCode(this.b);
        }

        public String toString() {
            return "PackStatus(isSuccess=" + this.a + ", message=" + this.b + Separators.RPAREN;
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return YM6.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Integer num;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                BN6 bn6 = YM6.this.b;
                OM6 om6 = YM6.this.c;
                if (om6 == null) {
                    AbstractC13042fc3.y("loadedStickerPack");
                    om6 = null;
                }
                this.b = 1;
                obj = bn6.l(om6, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            Z06 z06 = (Z06) obj;
            if (z06 instanceof Z06.a) {
                RpcException rpcExceptionA = ((Z06.a) z06).a();
                YM6.this.e.n(new b(false, (rpcExceptionA == null || (num = (Integer) AbstractC23461wx5.a().get(rpcExceptionA.getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String())) == null) ? AbstractC12217eE5.sticker_add_problem : num.intValue()));
            } else {
                if (!(z06 instanceof Z06.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                YM6.this.e.n(new b(true, AbstractC12217eE5.sticker_add_success));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        boolean b;
        int c;
        final /* synthetic */ int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return YM6.this.new d(this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            boolean z;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                YM6.this.g = this.e;
                boolean zT = YM6.this.b.t(this.e);
                BN6 bn6 = YM6.this.b;
                int i2 = this.e;
                this.b = zT;
                this.c = 1;
                Object objV = bn6.v(i2, 0L, this);
                if (objV == objE) {
                    return objE;
                }
                z = zT;
                obj = objV;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                z = this.b;
                AbstractC10685c16.b(obj);
            }
            Z06 z06 = (Z06) obj;
            if (z06 instanceof Z06.a) {
                YM6.this.e.n(new b(false, AbstractC12217eE5.sticker_load_problem));
                YM6 ym6 = YM6.this;
                ym6.g = ym6.f;
            } else {
                if (!(z06 instanceof Z06.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                ImagesOuterClass$ResponseLoadStickerCollection imagesOuterClass$ResponseLoadStickerCollection = (ImagesOuterClass$ResponseLoadStickerCollection) ((Z06.b) z06).a();
                GC gcA1 = C18732p92.a1(imagesOuterClass$ResponseLoadStickerCollection != null ? imagesOuterClass$ResponseLoadStickerCollection.getCollection() : null);
                if (gcA1 != null) {
                    YM6 ym62 = YM6.this;
                    OM6 om6 = new OM6(gcA1);
                    ym62.c = om6;
                    List listW = om6.w();
                    AbstractC13042fc3.h(listW, "getStickers(...)");
                    List<C23698xM6> list = listW;
                    ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                    for (C23698xM6 c23698xM6 : list) {
                        AbstractC13042fc3.f(c23698xM6);
                        Integer numU = c23698xM6.u();
                        arrayList.add(new d.b(c23698xM6, false, numU != null ? numU.intValue() : -1));
                    }
                    C20298rm4 c20298rm4 = ym62.d;
                    String name = gcA1.getName();
                    if (name == null) {
                        name = "";
                    }
                    c20298rm4.n(new a(name, arrayList, z));
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return YM6.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                BN6 bn6 = YM6.this.b;
                OM6 om6 = YM6.this.c;
                if (om6 == null) {
                    AbstractC13042fc3.y("loadedStickerPack");
                    om6 = null;
                }
                this.b = 1;
                obj = bn6.w(om6, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            Z06 z06 = (Z06) obj;
            if (z06 instanceof Z06.a) {
                YM6.this.e.n(new b(false, AbstractC12217eE5.sticker_remove_problem));
            } else {
                if (!(z06 instanceof Z06.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                YM6.this.e.n(new b(true, AbstractC12217eE5.sticker_remove_success));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public YM6() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final InterfaceC13730gj3 X0() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new c(null), 2, null);
    }

    private final InterfaceC13730gj3 b1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new e(null), 2, null);
    }

    public final InterfaceC13730gj3 Y0(int i) {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new d(i, null), 2, null);
    }

    public final androidx.lifecycle.r Z0() {
        return this.e;
    }

    public final androidx.lifecycle.r a1() {
        return this.d;
    }

    public final void c1() {
        if (this.g == this.f) {
            return;
        }
        a aVar = (a) this.d.f();
        if (aVar == null || !aVar.a()) {
            X0();
        } else {
            b1();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ YM6(BN6 bn6, int i, ED1 ed1) {
        if ((i & 1) != 0) {
            BN6.b bVar = BN6.e;
            C6287Mz c6287MzS = C5735Kp4.w().i().o2().s();
            AbstractC13042fc3.h(c6287MzS, "getApiModule(...)");
            InterfaceC3570Bk5 interfaceC3570Bk5C = C5735Kp4.w().i().o2().c();
            AbstractC13042fc3.h(interfaceC3570Bk5C, "<get-preferences>(...)");
            InterfaceC3570Bk5 interfaceC3570Bk5Q = C7183Qq.q(EnumC18608ow5.j);
            AbstractC13042fc3.h(interfaceC3570Bk5Q, "getInstance(...)");
            bn6 = bVar.a(c6287MzS, interfaceC3570Bk5C, interfaceC3570Bk5Q);
        }
        this(bn6);
    }

    public YM6(BN6 bn6) {
        AbstractC13042fc3.i(bn6, "stickersRepository");
        this.b = bn6;
        this.d = new C20298rm4();
        this.e = new C20298rm4();
        this.f = -1;
        this.g = -1;
    }
}
