package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.graphics.Bitmap;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.AbstractC6339Ne1;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.AvatarImage;

/* renamed from: ir.nasim.Ne1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC6339Ne1 {

    /* renamed from: ir.nasim.Ne1$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC20315ro1 c;
        final /* synthetic */ Avatar d;
        final /* synthetic */ InterfaceC9102Ym4 e;

        /* renamed from: ir.nasim.Ne1$a$a, reason: collision with other inner class name */
        static final class C0533a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ Avatar c;
            final /* synthetic */ InterfaceC9102Ym4 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0533a(Avatar avatar, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = avatar;
                this.d = interfaceC9102Ym4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 y(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC3346Am2 interfaceC3346Am2) {
                Bitmap bitmapA = C16754lo4.v.a(interfaceC3346Am2);
                AbstractC6339Ne1.f(interfaceC9102Ym4, bitmapA != null ? new XV4(bitmapA, Boolean.TRUE) : new XV4(AbstractC6339Ne1.e(interfaceC9102Ym4).e(), Boolean.TRUE));
                return C19938rB7.a;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0533a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AvatarImage imageDefaultSize;
                FileReference fileReference;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (!((Boolean) AbstractC6339Ne1.e(this.d).f()).booleanValue()) {
                    Avatar avatar = this.c;
                    if (((avatar == null || (imageDefaultSize = avatar.getImageDefaultSize()) == null || (fileReference = imageDefaultSize.getFileReference()) == null) ? null : AbstractC6392Nk0.e(fileReference.getFileId())) != null) {
                        Avatar avatar2 = this.c;
                        final InterfaceC9102Ym4 interfaceC9102Ym4 = this.d;
                        AbstractC6339Ne1.m(avatar2, new UA2() { // from class: ir.nasim.Me1
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj2) {
                                return AbstractC6339Ne1.a.C0533a.y(interfaceC9102Ym4, (InterfaceC3346Am2) obj2);
                            }
                        });
                    }
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0533a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC20315ro1 interfaceC20315ro1, Avatar avatar, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC20315ro1;
            this.d = avatar;
            this.e = interfaceC9102Ym4;
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
            AbstractC10533bm0.d(this.c, C12366eV1.a(), null, new C0533a(this.d, this.e, null), 2, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ne1$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ C3512Be1 a;

        /* renamed from: ir.nasim.Ne1$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ C3512Be1 d;
            final /* synthetic */ Context e;
            final /* synthetic */ InterfaceC9102Ym4 f;

            /* renamed from: ir.nasim.Ne1$b$a$a, reason: collision with other inner class name */
            static final class C0534a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C3512Be1 c;
                final /* synthetic */ Context d;
                final /* synthetic */ InterfaceC9102Ym4 e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0534a(C3512Be1 c3512Be1, Context context, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c3512Be1;
                    this.d = context;
                    this.e = interfaceC9102Ym4;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C0534a(this.c, this.d, this.e, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        C14375ho5 c14375ho5N = AbstractC5969Lp4.e().N();
                        long jR = this.c.r();
                        this.b = 1;
                        obj = c14375ho5N.E(jR, this);
                        if (obj == objE) {
                            return objE;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                    }
                    PI7 pi7 = (PI7) obj;
                    if (pi7 != null) {
                        b.d(this.e, C14593iA1.y(this.d, pi7, false, 4, null));
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C0534a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C3512Be1 c3512Be1, Context context, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c3512Be1;
                this.e = context;
                this.f = interfaceC9102Ym4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, this.f, interfaceC20295rm1);
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
                AbstractC10533bm0.d((InterfaceC20315ro1) this.c, null, null, new C0534a(this.d, this.e, this.f, null), 3, null);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        b(C3512Be1 c3512Be1) {
            this.a = c3512Be1;
        }

        private static final String c(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return (String) interfaceC9102Ym4.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(InterfaceC9102Ym4 interfaceC9102Ym4, String str) {
            interfaceC9102Ym4.setValue(str);
        }

        /* JADX WARN: Type inference failed for: r4v4 */
        /* JADX WARN: Type inference failed for: r4v5, types: [ir.nasim.em$c, ir.nasim.rm1, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v7 */
        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            ?? r4;
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            float f = 10;
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), WX0.a(IA5.color6_2, interfaceC22053ub1, 0), null, 2, null), C17784nZ1.q(f), C17784nZ1.q(12), 0.0f, C17784nZ1.q(11), 4, null);
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC12529em.c cVarI = aVar2.i();
            C3512Be1 c3512Be1 = this.a;
            C24254yJ c24254yJ = C24254yJ.a;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(c24254yJ.g(), cVarI, interfaceC22053ub1, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarM);
            InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar3.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            M66 m66 = M66.a;
            int iR = c3512Be1.r();
            String name = c3512Be1.getName();
            AbstractC13042fc3.h(name, "getName(...)");
            AbstractC6339Ne1.d(iR, name, c3512Be1.q(), interfaceC22053ub1, 0);
            androidx.compose.ui.e eVarM2 = androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(f), 0.0f, C17784nZ1.q(f), 0.0f, 10, null);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.h(), aVar2.k(), interfaceC22053ub1, 48);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarM2);
            SA2 sa2A2 = aVar3.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A2);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3A, aVar3.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            String name2 = c3512Be1.getName();
            AbstractC13042fc3.h(name2, "getName(...)");
            C15386jV3 c15386jV3 = C15386jV3.a;
            int i2 = C15386jV3.b;
            AbstractC9339Zm7.b(name2, androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.t.C(aVar, null, false, 3, null), 0.0f, 1, null), WX0.a(IA5.color9, interfaceC22053ub1, 0), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.f()), 0L, AbstractC23365wn7.a.b(), false, 1, 0, null, c15386jV3.c(interfaceC22053ub1, i2).n(), interfaceC22053ub1, 48, 3120, 54776);
            int iR2 = c3512Be1.r();
            interfaceC22053ub1.W(1298016218);
            boolean zE = interfaceC22053ub1.e(iR2);
            Object objB = interfaceC22053ub1.B();
            if (zE || objB == InterfaceC22053ub1.a.a()) {
                r4 = 0;
                objB = AbstractC13472gH6.d("", null, 2, null);
                interfaceC22053ub1.s(objB);
            } else {
                r4 = 0;
            }
            InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1.Q();
            Context context = (Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g());
            Boolean bool = Boolean.TRUE;
            interfaceC22053ub1.W(1298022263);
            boolean zD = interfaceC22053ub1.D(c3512Be1) | interfaceC22053ub1.V(interfaceC9102Ym4) | interfaceC22053ub1.D(context);
            Object objB2 = interfaceC22053ub1.B();
            if (zD || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new a(c3512Be1, context, interfaceC9102Ym4, r4);
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC10721c52.e(bool, (InterfaceC14603iB2) objB2, interfaceC22053ub1, 6);
            AbstractC9339Zm7.b(c(interfaceC9102Ym4), androidx.compose.foundation.layout.t.C(aVar, r4, false, 3, r4), WX0.a(IA5.color8, interfaceC22053ub1, 0), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c15386jV3.c(interfaceC22053ub1, i2).o(), interfaceC22053ub1, 48, 0, 65528);
            interfaceC22053ub1.u();
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void d(final int i, final String str, final Avatar avatar, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        AbstractC13042fc3.i(str, "name");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(454353011);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.e(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.V(str) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.V(avatar) ? 256 : 128;
        }
        if ((i3 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            interfaceC22053ub1J.W(999612479);
            boolean z = (i3 & 14) == 4;
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
                objB = AbstractC13472gH6.d(new XV4(C16670lg0.g(str, i, aVar.f(52.0f), aVar.f(52.0f)), Boolean.FALSE), null, 2, null);
                interfaceC22053ub1J.s(objB);
            }
            InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1J.Q();
            Object objB2 = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar2 = InterfaceC22053ub1.a;
            if (objB2 == aVar2.a()) {
                objB2 = AbstractC10721c52.k(C18712p72.a, interfaceC22053ub1J);
                interfaceC22053ub1J.s(objB2);
            }
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) objB2;
            C19938rB7 c19938rB7 = C19938rB7.a;
            interfaceC22053ub1J.W(999625874);
            boolean zD = interfaceC22053ub1J.D(interfaceC20315ro1) | interfaceC22053ub1J.V(interfaceC9102Ym4) | ((i3 & 896) == 256);
            Object objB3 = interfaceC22053ub1J.B();
            if (zD || objB3 == aVar2.a()) {
                objB3 = new a(interfaceC20315ro1, avatar, interfaceC9102Ym4, null);
                interfaceC22053ub1J.s(objB3);
            }
            interfaceC22053ub1J.Q();
            AbstractC10721c52.e(c19938rB7, (InterfaceC14603iB2) objB3, interfaceC22053ub1J, 6);
            AbstractC11456d23.b(new BitmapPainter(AbstractC19123pp.c((Bitmap) e(interfaceC9102Ym4).e()), 0L, 0L, 6, null), str, androidx.compose.foundation.layout.t.t(FV0.a(androidx.compose.ui.e.a, N46.g()), C17784nZ1.q(52)), null, null, 0.0f, null, interfaceC22053ub1J, i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Le1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC6339Ne1.g(i, str, avatar, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final XV4 e(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (XV4) interfaceC9102Ym4.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(InterfaceC9102Ym4 interfaceC9102Ym4, XV4 xv4) {
        interfaceC9102Ym4.setValue(xv4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(int i, String str, Avatar avatar, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(str, "$name");
        d(i, str, avatar, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    public static final void h(final C3512Be1 c3512Be1, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(c3512Be1, "contact");
        AbstractC13042fc3.i(ua2, "onClick");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1967390441);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(c3512Be1) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            androidx.compose.ui.e eVarC = androidx.compose.foundation.layout.t.C(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null), null, false, 3, null);
            interfaceC22053ub1J.W(-147767779);
            boolean zD = interfaceC22053ub1J.D(c3512Be1) | ((i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Je1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC6339Ne1.i(ua2, c3512Be1);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            F27.a(androidx.compose.foundation.e.f(eVarC, true, null, null, (SA2) objB, 6, null), null, 0L, 0L, 0.0f, 0.0f, null, AbstractC19242q11.e(-1657635022, true, new b(c3512Be1), interfaceC22053ub1J, 54), interfaceC22053ub1J, 12582912, 126);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Ke1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC6339Ne1.j(c3512Be1, ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(UA2 ua2, C3512Be1 c3512Be1) {
        AbstractC13042fc3.i(ua2, "$onClick");
        AbstractC13042fc3.i(c3512Be1, "$contact");
        ua2.invoke(c3512Be1);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(C3512Be1 c3512Be1, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c3512Be1, "$contact");
        AbstractC13042fc3.i(ua2, "$onClick");
        h(c3512Be1, ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void m(Avatar avatar, UA2 ua2) {
        AvatarImage imageDefaultSize;
        FileReference fileReference;
        AbstractC13042fc3.i(ua2, "onLoaded");
        if (avatar == null || (imageDefaultSize = avatar.getImageDefaultSize()) == null || (fileReference = imageDefaultSize.getFileReference()) == null) {
            return;
        }
        AbstractC5969Lp4.e().D().D(fileReference, true, new c(ua2), (56 & 8) != 0 ? false : false, (56 & 16) != 0, (56 & 32) != 0 ? false : false);
    }

    /* renamed from: ir.nasim.Ne1$c */
    public static final class c implements InterfaceC8091Um2 {
        final /* synthetic */ UA2 a;

        c(UA2 ua2) {
            this.a = ua2;
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            this.a.invoke(interfaceC3346Am2);
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void e() {
            this.a.invoke(null);
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
        }
    }
}
