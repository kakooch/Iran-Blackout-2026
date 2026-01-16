package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.A6;
import ir.nasim.InterfaceC22053ub1;
import java.util.UUID;

/* loaded from: classes.dex */
public abstract class A6 {

    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C22953w6 e;
        final /* synthetic */ AbstractC24133y6 f;
        final /* synthetic */ String g;
        final /* synthetic */ AbstractC18108o6 h;
        final /* synthetic */ InterfaceC9664aL6 i;

        /* renamed from: ir.nasim.A6$a$a, reason: collision with other inner class name */
        public static final class C0254a implements KV1 {
            final /* synthetic */ C22953w6 a;

            public C0254a(C22953w6 c22953w6) {
                this.a = c22953w6;
            }

            @Override // ir.nasim.KV1
            public void dispose() {
                this.a.c();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C22953w6 c22953w6, AbstractC24133y6 abstractC24133y6, String str, AbstractC18108o6 abstractC18108o6, InterfaceC9664aL6 interfaceC9664aL6) {
            super(1);
            this.e = c22953w6;
            this.f = abstractC24133y6;
            this.g = str;
            this.h = abstractC18108o6;
            this.i = interfaceC9664aL6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(InterfaceC9664aL6 interfaceC9664aL6, Object obj) {
            ((UA2) interfaceC9664aL6.getValue()).invoke(obj);
        }

        @Override // ir.nasim.UA2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final KV1 invoke(LV1 lv1) {
            C22953w6 c22953w6 = this.e;
            AbstractC24133y6 abstractC24133y6 = this.f;
            String str = this.g;
            AbstractC18108o6 abstractC18108o6 = this.h;
            final InterfaceC9664aL6 interfaceC9664aL6 = this.i;
            c22953w6.b(abstractC24133y6.l(str, abstractC18108o6, new InterfaceC17517n6() { // from class: ir.nasim.z6
                @Override // ir.nasim.InterfaceC17517n6
                public final void a(Object obj) {
                    A6.a.c(interfaceC9664aL6, obj);
                }
            }));
            return new C0254a(this.e);
        }
    }

    static final class b extends AbstractC8614Ws3 implements SA2 {
        public static final b e = new b();

        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return UUID.randomUUID().toString();
        }
    }

    public static final C14725iN3 a(AbstractC18108o6 abstractC18108o6, UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.A(-1408504823);
        InterfaceC9664aL6 interfaceC9664aL6Q = AbstractC10222bH6.q(abstractC18108o6, interfaceC22053ub1, i & 14);
        InterfaceC9664aL6 interfaceC9664aL6Q2 = AbstractC10222bH6.q(ua2, interfaceC22053ub1, (i >> 3) & 14);
        String str = (String) AbstractC9681aN5.e(new Object[0], null, null, b.e, interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 6);
        B6 b6A = EG3.a.a(interfaceC22053ub1, 6);
        if (b6A == null) {
            throw new IllegalStateException("No ActivityResultRegistryOwner was provided via LocalActivityResultRegistryOwner".toString());
        }
        AbstractC24133y6 activityResultRegistry = b6A.getActivityResultRegistry();
        interfaceC22053ub1.A(-1672765924);
        Object objB = interfaceC22053ub1.B();
        InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
        if (objB == aVar.a()) {
            objB = new C22953w6();
            interfaceC22053ub1.s(objB);
        }
        C22953w6 c22953w6 = (C22953w6) objB;
        interfaceC22053ub1.U();
        interfaceC22053ub1.A(-1672765850);
        Object objB2 = interfaceC22053ub1.B();
        if (objB2 == aVar.a()) {
            objB2 = new C14725iN3(c22953w6, interfaceC9664aL6Q);
            interfaceC22053ub1.s(objB2);
        }
        C14725iN3 c14725iN3 = (C14725iN3) objB2;
        interfaceC22053ub1.U();
        interfaceC22053ub1.A(-1672765582);
        boolean zV = interfaceC22053ub1.V(c22953w6) | interfaceC22053ub1.V(activityResultRegistry) | interfaceC22053ub1.V(str) | interfaceC22053ub1.V(abstractC18108o6) | interfaceC22053ub1.V(interfaceC9664aL6Q2);
        Object objB3 = interfaceC22053ub1.B();
        if (zV || objB3 == aVar.a()) {
            Object aVar2 = new a(c22953w6, activityResultRegistry, str, abstractC18108o6, interfaceC9664aL6Q2);
            interfaceC22053ub1.s(aVar2);
            objB3 = aVar2;
        }
        interfaceC22053ub1.U();
        AbstractC10721c52.c(activityResultRegistry, str, abstractC18108o6, (UA2) objB3, interfaceC22053ub1, (i << 6) & 896);
        interfaceC22053ub1.U();
        return c14725iN3;
    }
}
