package ir.nasim;

import ai.bale.proto.MessagingStruct$ServiceEx;
import ai.bale.proto.PeersStruct$Peer;
import android.content.Context;
import android.gov.nist.core.Separators;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C9475a16;
import ir.nasim.RP1;
import ir.nasim.UO1;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.database.dailogLists.DialogDatabase;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.database.dailogLists.DialogFolderAssociationEntity;
import ir.nasim.database.dailogLists.DialogLastMessage;
import ir.nasim.database.dailogLists.DialogPeerUnreadStateEntity;
import ir.nasim.database.dailogLists.MessageIdentifier;
import ir.nasim.database.dailogLists.MessageState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.tP1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21270tP1 implements InterfaceC20667sP1 {
    private final C19467qP1 a;
    private final HM1 b;
    private final ir.nasim.database.dailogLists.c c;
    private final BM1 d;
    private final C24011xt3 e;
    private final InterfaceC3570Bk5 f;
    private final E84 g;
    private final InterfaceC16512lP1 h;
    private final AbstractC13778go1 i;
    private final Context j;
    private final InterfaceC20315ro1 k;
    private final TP1 l;
    private final InterfaceC8898Xu3 m;
    private final int n;
    private final DialogDatabase o;
    private boolean p;

    /* renamed from: ir.nasim.tP1$A */
    static final class A extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ C11458d25 e;
        final /* synthetic */ String f;
        final /* synthetic */ Long g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        A(C11458d25 c11458d25, String str, Long l, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = c11458d25;
            this.f = str;
            this.g = l;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21270tP1.this.new A(this.e, this.f, this.g, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0083 A[RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r11.c
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2a
                if (r1 == r4) goto L26
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                ir.nasim.AbstractC10685c16.b(r12)
                goto L84
            L16:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L1e:
                java.lang.Object r1 = r11.b
                ir.nasim.database.dailogLists.DialogEntity r1 = (ir.nasim.database.dailogLists.DialogEntity) r1
                ir.nasim.AbstractC10685c16.b(r12)
                goto L59
            L26:
                ir.nasim.AbstractC10685c16.b(r12)
                goto L3a
            L2a:
                ir.nasim.AbstractC10685c16.b(r12)
                ir.nasim.tP1 r12 = ir.nasim.C21270tP1.this
                ir.nasim.d25 r1 = r11.e
                r11.c = r4
                java.lang.Object r12 = r12.H(r1, r11)
                if (r12 != r0) goto L3a
                return r0
            L3a:
                r1 = r12
                ir.nasim.database.dailogLists.DialogEntity r1 = (ir.nasim.database.dailogLists.DialogEntity) r1
                ir.nasim.tP1 r12 = ir.nasim.C21270tP1.this
                ir.nasim.HM1 r4 = ir.nasim.C21270tP1.V(r12)
                ir.nasim.d25 r12 = r11.e
                long r5 = r12.u()
                java.lang.String r7 = r11.f
                java.lang.Long r8 = r11.g
                r11.b = r1
                r11.c = r3
                r9 = r11
                java.lang.Object r12 = r4.t(r5, r7, r8, r9)
                if (r12 != r0) goto L59
                return r0
            L59:
                ir.nasim.tP1 r12 = ir.nasim.C21270tP1.this
                ir.nasim.TP1 r12 = ir.nasim.C21270tP1.Y(r12)
                ir.nasim.RP1$d r9 = new ir.nasim.RP1$d
                ir.nasim.d25 r3 = r11.e
                long r4 = r3.u()
                java.lang.String r6 = r11.f
                java.lang.Long r7 = r11.g
                r10 = 0
                if (r1 == 0) goto L74
                ir.nasim.database.dailogLists.DialogLastMessage r1 = r1.getMessage()
                r8 = r1
                goto L75
            L74:
                r8 = r10
            L75:
                r3 = r9
                r3.<init>(r4, r6, r7, r8)
                r11.b = r10
                r11.c = r2
                java.lang.Object r12 = r12.e(r9, r11)
                if (r12 != r0) goto L84
                return r0
            L84:
                ir.nasim.rB7 r12 = ir.nasim.C19938rB7.a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21270tP1.A.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((A) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tP1$B */
    static final class B extends AbstractC19859r37 implements InterfaceC14603iB2 {
        long b;
        int c;
        final /* synthetic */ C17637nI7 d;
        final /* synthetic */ C21270tP1 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        B(C17637nI7 c17637nI7, C21270tP1 c21270tP1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c17637nI7;
            this.e = c21270tP1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new B(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            long j;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                long jU = this.d.u0().u();
                HM1 hm1 = this.e.b;
                String name = this.d.getName();
                AbstractC13042fc3.h(name, "getName(...)");
                boolean zR0 = this.d.r0();
                boolean zC = this.d.T().c();
                boolean zJ0 = this.e.j0(this.d.e0());
                this.b = jU;
                this.c = 1;
                if (hm1.r(jU, name, zJ0, zC, zR0, this) == objE) {
                    return objE;
                }
                j = jU;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                long j2 = this.b;
                AbstractC10685c16.b(obj);
                j = j2;
            }
            TP1 tp1 = this.e.l;
            String name2 = this.d.getName();
            AbstractC13042fc3.h(name2, "getName(...)");
            Avatar avatarS = this.d.S();
            RP1.m mVar = new RP1.m(j, name2, avatarS != null ? avatarS.toByteArray() : null, this.d.r0(), this.d.e0());
            this.c = 2;
            if (tp1.e(mVar, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((B) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tP1$C */
    static final class C extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        int f;
        final /* synthetic */ List g;
        final /* synthetic */ C21270tP1 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C(List list, C21270tP1 c21270tP1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.g = list;
            this.h = c21270tP1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new C(this.g, this.h, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0045  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x006d  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0085  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x008c  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0097  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x009e  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00ab  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00b0  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00e7 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0061 -> B:6:0x0022). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r36) {
            /*
                Method dump skipped, instructions count: 232
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21270tP1.C.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tP1$D */
    static final class D extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        D(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21270tP1.this.new D(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC16512lP1 interfaceC16512lP1 = C21270tP1.this.h;
                this.b = 1;
                obj = interfaceC16512lP1.b(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                AbstractC10685c16.b(obj);
            }
            Iterable<DialogPeerUnreadStateEntity> iterable = (Iterable) obj;
            C21270tP1 c21270tP1 = C21270tP1.this;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(iterable, 10));
            for (DialogPeerUnreadStateEntity dialogPeerUnreadStateEntity : iterable) {
                SettingsModule settingsModule = (SettingsModule) c21270tP1.m.get();
                C11458d25 c11458d25R = C11458d25.r(dialogPeerUnreadStateEntity.getPeerUid());
                AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
                arrayList.add(DialogPeerUnreadStateEntity.copy$default(dialogPeerUnreadStateEntity, 0L, settingsModule.H5(c11458d25R), 1, null));
            }
            InterfaceC16512lP1 interfaceC16512lP12 = C21270tP1.this.h;
            this.b = 2;
            if (interfaceC16512lP12.l(arrayList, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((D) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tP1$E */
    static final class E extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        E(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21270tP1.this.new E(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                TP1 tp1 = C21270tP1.this.l;
                RP1.c cVar = new RP1.c(this.d);
                this.b = 1;
                if (tp1.e(cVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                AbstractC10685c16.b(obj);
            }
            HM1 hm1 = C21270tP1.this.b;
            List list = this.d;
            this.b = 2;
            if (hm1.o(list, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((E) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tP1$F */
    static final class F extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ C21271a e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        F(C21271a c21271a, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = c21271a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21270tP1.this.new F(this.e, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x006d A[RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r6.c
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L29
                if (r1 == r4) goto L21
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                ir.nasim.AbstractC10685c16.b(r7)
                goto L6e
            L15:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1d:
                ir.nasim.AbstractC10685c16.b(r7)
                goto L53
            L21:
                java.lang.Object r1 = r6.b
                ir.nasim.HM1 r1 = (ir.nasim.HM1) r1
                ir.nasim.AbstractC10685c16.b(r7)
                goto L45
            L29:
                ir.nasim.AbstractC10685c16.b(r7)
                ir.nasim.tP1 r7 = ir.nasim.C21270tP1.this
                ir.nasim.HM1 r1 = ir.nasim.C21270tP1.V(r7)
                ir.nasim.tP1 r7 = ir.nasim.C21270tP1.this
                ir.nasim.tP1$a r5 = r6.e
                java.util.List r5 = r5.a()
                r6.b = r1
                r6.c = r4
                java.lang.Object r7 = ir.nasim.C21270tP1.i0(r7, r5, r6)
                if (r7 != r0) goto L45
                return r0
            L45:
                java.util.List r7 = (java.util.List) r7
                r4 = 0
                r6.b = r4
                r6.c = r3
                java.lang.Object r7 = r1.q(r7, r6)
                if (r7 != r0) goto L53
                return r0
            L53:
                ir.nasim.tP1 r7 = ir.nasim.C21270tP1.this
                ir.nasim.database.dailogLists.c r7 = ir.nasim.C21270tP1.W(r7)
                ir.nasim.tP1$a r1 = r6.e
                java.util.Set r1 = r1.b()
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.List r1 = ir.nasim.ZW0.m1(r1)
                r6.c = r2
                java.lang.Object r7 = r7.a(r1, r6)
                if (r7 != r0) goto L6e
                return r0
            L6e:
                ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21270tP1.F.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((F) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tP1$G */
    static final class G extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        G(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objG = C21270tP1.this.g(null, this);
            return objG == AbstractC14862ic3.e() ? objG : C9475a16.a(objG);
        }
    }

    /* renamed from: ir.nasim.tP1$H */
    static final class H extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List c;
        final /* synthetic */ C21270tP1 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        H(List list, C21270tP1 c21270tP1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = list;
            this.d = c21270tP1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new H(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objP;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (this.c.isEmpty()) {
                    C9475a16.a aVar = C9475a16.b;
                    return C9475a16.a(C9475a16.b(C19938rB7.a));
                }
                C19467qP1 c19467qP1 = this.d.a;
                List list = this.c;
                this.b = 1;
                objP = c19467qP1.p(list, this);
                if (objP == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objP = ((C9475a16) obj).l();
            }
            C21270tP1 c21270tP1 = this.d;
            List list2 = this.c;
            if (C9475a16.j(objP)) {
                List<ExPeer> list3 = list2;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list3, 10));
                for (ExPeer exPeer : list3) {
                    arrayList.add(new C11458d25(exPeer.getExPeerType().getPeerType(), exPeer.getPeerId()));
                }
                c21270tP1.h(arrayList);
            }
            return C9475a16.a(objP);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((H) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tP1$I */
    static final class I extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;
        final /* synthetic */ List f;
        final /* synthetic */ C21270tP1 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        I(List list, C21270tP1 c21270tP1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.f = list;
            this.g = c21270tP1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new I(this.f, this.g, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x00a5  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r9.e
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L39
                if (r1 == r3) goto L29
                if (r1 != r2) goto L21
                java.lang.Object r0 = r9.c
                ir.nasim.d25 r0 = (ir.nasim.C11458d25) r0
                java.lang.Object r1 = r9.b
                ir.nasim.tP1 r1 = (ir.nasim.C21270tP1) r1
                ir.nasim.AbstractC10685c16.b(r10)
                ir.nasim.a16 r10 = (ir.nasim.C9475a16) r10
                java.lang.Object r10 = r10.l()
                goto L9f
            L21:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L29:
                java.lang.Object r1 = r9.d
                ir.nasim.d25 r1 = (ir.nasim.C11458d25) r1
                java.lang.Object r4 = r9.c
                java.util.List r4 = (java.util.List) r4
                java.lang.Object r5 = r9.b
                ir.nasim.tP1 r5 = (ir.nasim.C21270tP1) r5
                ir.nasim.AbstractC10685c16.b(r10)
                goto L75
            L39:
                ir.nasim.AbstractC10685c16.b(r10)
                java.util.List r10 = r9.f
                java.lang.Object r10 = ir.nasim.ZW0.s0(r10)
                ir.nasim.core.modules.profile.entity.ExPeer r10 = (ir.nasim.core.modules.profile.entity.ExPeer) r10
                if (r10 == 0) goto Lae
                ir.nasim.tP1 r1 = r9.g
                java.util.List r4 = r9.f
                ir.nasim.d25 r5 = new ir.nasim.d25
                ir.nasim.core.modules.profile.entity.ExPeerType r6 = r10.getExPeerType()
                ir.nasim.W25 r6 = r6.getPeerType()
                int r10 = r10.getPeerId()
                r5.<init>(r6, r10)
                ir.nasim.HM1 r10 = ir.nasim.C21270tP1.V(r1)
                long r6 = r5.u()
                r9.b = r1
                r9.c = r4
                r9.d = r5
                r9.e = r3
                java.lang.Object r10 = r10.j(r6, r9)
                if (r10 != r0) goto L72
                return r0
            L72:
                r8 = r5
                r5 = r1
                r1 = r8
            L75:
                ir.nasim.database.dailogLists.DialogEntity r10 = (ir.nasim.database.dailogLists.DialogEntity) r10
                if (r10 == 0) goto L86
                java.lang.Boolean r10 = r10.getMarkAsUnread()
                java.lang.Boolean r3 = ir.nasim.AbstractC6392Nk0.a(r3)
                boolean r10 = ir.nasim.AbstractC13042fc3.d(r10, r3)
                goto L87
            L86:
                r10 = 0
            L87:
                if (r10 == 0) goto Lae
                ir.nasim.qP1 r10 = ir.nasim.C21270tP1.d0(r5)
                r9.b = r5
                r9.c = r1
                r3 = 0
                r9.d = r3
                r9.e = r2
                java.lang.Object r10 = r10.p(r4, r9)
                if (r10 != r0) goto L9d
                return r0
            L9d:
                r0 = r1
                r1 = r5
            L9f:
                boolean r2 = ir.nasim.C9475a16.j(r10)
                if (r2 == 0) goto Lae
                ir.nasim.rB7 r10 = (ir.nasim.C19938rB7) r10
                java.util.List r10 = ir.nasim.ZW0.e(r0)
                r1.h(r10)
            Lae:
                ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21270tP1.I.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((I) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tP1$J */
    static final class J extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        long d;
        int e;
        final /* synthetic */ List g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        J(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.g = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21270tP1.this.new J(this.g, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x00be  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00f1 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00f2  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00ef -> B:12:0x002f). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                Method dump skipped, instructions count: 306
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21270tP1.J.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((J) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tP1$K */
    static final class K extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        K(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objF = C21270tP1.this.f(null, this);
            return objF == AbstractC14862ic3.e() ? objF : C9475a16.a(objF);
        }
    }

    /* renamed from: ir.nasim.tP1$L */
    static final class L extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List c;
        final /* synthetic */ C21270tP1 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        L(List list, C21270tP1 c21270tP1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = list;
            this.d = c21270tP1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new L(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objQ;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (this.c.isEmpty()) {
                    C9475a16.a aVar = C9475a16.b;
                    return C9475a16.a(C9475a16.b(C19938rB7.a));
                }
                C19467qP1 c19467qP1 = this.d.a;
                List list = this.c;
                this.b = 1;
                objQ = c19467qP1.q(list, this);
                if (objQ == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objQ = ((C9475a16) obj).l();
            }
            C21270tP1 c21270tP1 = this.d;
            List list2 = this.c;
            if (C9475a16.j(objQ)) {
                List<ExPeer> list3 = list2;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list3, 10));
                for (ExPeer exPeer : list3) {
                    arrayList.add(new C11458d25(exPeer.getExPeerType().getPeerType(), exPeer.getPeerId()));
                }
                c21270tP1.G(arrayList);
            }
            return C9475a16.a(objQ);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((L) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tP1$M */
    static final class M extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        M(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.f = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21270tP1.this.new M(this.f, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x00ab  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00e5 A[LOOP:1: B:30:0x00df->B:32:0x00e5, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0114 A[RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                Method dump skipped, instructions count: 280
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21270tP1.M.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((M) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tP1$N */
    static final class N extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        int f;
        final /* synthetic */ List g;
        final /* synthetic */ C21270tP1 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        N(List list, C21270tP1 c21270tP1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.g = list;
            this.h = c21270tP1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new N(this.g, this.h, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x006b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0063 -> B:15:0x0064). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r6.f
                r2 = 1
                if (r1 == 0) goto L27
                if (r1 != r2) goto L1f
                java.lang.Object r1 = r6.e
                java.util.Collection r1 = (java.util.Collection) r1
                java.lang.Object r3 = r6.d
                java.util.Iterator r3 = (java.util.Iterator) r3
                java.lang.Object r4 = r6.c
                java.util.Collection r4 = (java.util.Collection) r4
                java.lang.Object r5 = r6.b
                ir.nasim.tP1 r5 = (ir.nasim.C21270tP1) r5
                ir.nasim.AbstractC10685c16.b(r7)
                goto L64
            L1f:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L27:
                ir.nasim.AbstractC10685c16.b(r7)
                java.util.List r7 = r6.g
                java.lang.Iterable r7 = (java.lang.Iterable) r7
                ir.nasim.tP1 r1 = r6.h
                java.util.ArrayList r3 = new java.util.ArrayList
                r4 = 10
                int r4 = ir.nasim.ZW0.x(r7, r4)
                r3.<init>(r4)
                java.util.Iterator r7 = r7.iterator()
                r5 = r1
                r1 = r3
                r3 = r7
            L42:
                boolean r7 = r3.hasNext()
                if (r7 == 0) goto L6b
                java.lang.Object r7 = r3.next()
                ai.bale.proto.MessagingStruct$Dialog r7 = (ai.bale.proto.MessagingStruct$Dialog) r7
                ir.nasim.BM1 r4 = ir.nasim.C21270tP1.U(r5)
                r6.b = r5
                r6.c = r1
                r6.d = r3
                r6.e = r1
                r6.f = r2
                java.lang.Object r7 = r4.e(r7, r6)
                if (r7 != r0) goto L63
                return r0
            L63:
                r4 = r1
            L64:
                ir.nasim.oN1 r7 = (ir.nasim.C18267oN1) r7
                r1.add(r7)
                r1 = r4
                goto L42
            L6b:
                java.util.List r1 = (java.util.List) r1
                ir.nasim.tP1 r7 = r6.h
                ir.nasim.E84 r7 = ir.nasim.C21270tP1.c0(r7)
                ir.nasim.l66 r7 = r7.T0()
                r7.s(r1)
                ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21270tP1.N.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((N) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tP1$O */
    static final class O extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List c;
        final /* synthetic */ C21270tP1 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        O(List list, C21270tP1 c21270tP1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = list;
            this.d = c21270tP1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new O(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                List list = this.c;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new DialogPeerUnreadStateEntity(new C11458d25((ExPeer) it.next()).u(), false));
                }
                InterfaceC16512lP1 interfaceC16512lP1 = this.d.h;
                Set setR1 = AbstractC15401jX0.r1(arrayList);
                this.b = 1;
                if (interfaceC16512lP1.k(setR1, this) == objE) {
                    return objE;
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
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((O) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tP1$P */
    static final class P extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Set d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        P(Set set, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = set;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21270tP1.this.new P(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC16512lP1 interfaceC16512lP1 = C21270tP1.this.h;
                Set set = this.d;
                this.b = 1;
                if (interfaceC16512lP1.k(set, this) == objE) {
                    return objE;
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
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((P) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tP1$Q */
    static final class Q extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int c;
        final /* synthetic */ C21270tP1 d;
        final /* synthetic */ C11458d25 e;
        final /* synthetic */ boolean f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        Q(int i, C21270tP1 c21270tP1, C11458d25 c11458d25, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = i;
            this.d = c21270tP1;
            this.e = c11458d25;
            this.f = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new Q(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (this.c > 0) {
                    InterfaceC16512lP1 interfaceC16512lP1 = this.d.h;
                    DialogPeerUnreadStateEntity dialogPeerUnreadStateEntity = new DialogPeerUnreadStateEntity(this.e.u(), !this.f);
                    this.b = 1;
                    if (interfaceC16512lP1.d(dialogPeerUnreadStateEntity, this) == objE) {
                        return objE;
                    }
                } else {
                    InterfaceC16512lP1 interfaceC16512lP12 = this.d.h;
                    long jU = this.e.u();
                    this.b = 2;
                    if (interfaceC16512lP12.g(jU, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((Q) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tP1$a, reason: case insensitive filesystem */
    public static final class C21271a {
        private final List a;
        private final Set b;

        public C21271a(List list, Set set) {
            AbstractC13042fc3.i(list, "dialogEntities");
            AbstractC13042fc3.i(set, "folderAssociations");
            this.a = list;
            this.b = set;
        }

        public final List a() {
            return this.a;
        }

        public final Set b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C21271a)) {
                return false;
            }
            C21271a c21271a = (C21271a) obj;
            return AbstractC13042fc3.d(this.a, c21271a.a) && AbstractC13042fc3.d(this.b, c21271a.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "DialogsWithRelations(dialogEntities=" + this.a + ", folderAssociations=" + this.b + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.tP1$b, reason: case insensitive filesystem */
    public /* synthetic */ class C21272b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC16311l35.values().length];
            try {
                iArr[EnumC16311l35.PeerType_GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC16311l35.PeerType_ENCRYPTEDPRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC16311l35.UNRECOGNIZED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC16311l35.PeerType_UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumC16311l35.PeerType_PRIVATE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.tP1$c, reason: case insensitive filesystem */
    static final class C21273c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        long b;
        Object c;
        Object d;
        int e;
        final /* synthetic */ C11458d25 f;
        final /* synthetic */ C21270tP1 g;
        final /* synthetic */ long h;
        final /* synthetic */ long i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C21273c(C11458d25 c11458d25, C21270tP1 c21270tP1, long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.f = c11458d25;
            this.g = c21270tP1;
            this.h = j;
            this.i = j2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new C21273c(this.f, this.g, this.h, this.i, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:43:0x010c  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0122 A[RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                Method dump skipped, instructions count: 294
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21270tP1.C21273c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C21273c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tP1$d, reason: case insensitive filesystem */
    static final class C21274d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C21274d(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21270tP1.this.new C21274d(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C21270tP1 c21270tP1 = C21270tP1.this;
                List list = this.d;
                this.b = 1;
                if (c21270tP1.l0(list, null, this) == objE) {
                    return objE;
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
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C21274d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tP1$e, reason: case insensitive filesystem */
    static final class C21275e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C21275e(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21270tP1.this.new C21275e(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                HM1 hm1 = C21270tP1.this.b;
                long j = this.d;
                this.b = 1;
                if (hm1.e(j, this) == objE) {
                    return objE;
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
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C21275e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tP1$f, reason: case insensitive filesystem */
    static final class C21276f extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        /* synthetic */ Object g;
        int i;

        C21276f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= RecyclerView.UNDEFINED_DURATION;
            return C21270tP1.this.k0(null, null, this);
        }
    }

    /* renamed from: ir.nasim.tP1$g, reason: case insensitive filesystem */
    static final class C21277g extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        C21277g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C21270tP1.this.l0(null, null, this);
        }
    }

    /* renamed from: ir.nasim.tP1$h, reason: case insensitive filesystem */
    static final class C21278h extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        int e;
        /* synthetic */ Object f;
        int h;

        C21278h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= RecyclerView.UNDEFINED_DURATION;
            return C21270tP1.this.m0(null, null, null, 0, this);
        }
    }

    /* renamed from: ir.nasim.tP1$i, reason: case insensitive filesystem */
    static final class C21279i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C21279i(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21270tP1.this.new C21279i(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                HM1 hm1 = C21270tP1.this.b;
                long j = this.d;
                this.b = 1;
                obj = hm1.j(j, this);
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
            return ((C21279i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tP1$j, reason: case insensitive filesystem */
    static final class C21280j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11458d25 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C21280j(C11458d25 c11458d25, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c11458d25;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21270tP1.this.new C21280j(this.d, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r6.b
                r2 = 2
                r3 = 1
                r4 = 0
                if (r1 == 0) goto L25
                if (r1 == r3) goto L1b
                if (r1 != r2) goto L13
                ir.nasim.AbstractC10685c16.b(r7)
                goto L60
            L13:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1b:
                ir.nasim.AbstractC10685c16.b(r7)
                ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
                java.lang.Object r7 = r7.l()
                goto L3d
            L25:
                ir.nasim.AbstractC10685c16.b(r7)
                ir.nasim.tP1 r7 = ir.nasim.C21270tP1.this
                ir.nasim.qP1 r7 = ir.nasim.C21270tP1.d0(r7)
                ir.nasim.d25 r1 = r6.d
                java.util.List r1 = ir.nasim.ZW0.e(r1)
                r6.b = r3
                java.lang.Object r7 = r7.j(r1, r6)
                if (r7 != r0) goto L3d
                return r0
            L3d:
                java.lang.Throwable r1 = ir.nasim.C9475a16.e(r7)
                if (r1 == 0) goto L4a
                ir.nasim.UO1$e r3 = ir.nasim.UO1.e.a
                java.lang.String r5 = "Loading Peer dialog has been failed"
                r3.c(r5, r1)
            L4a:
                boolean r1 = ir.nasim.C9475a16.g(r7)
                if (r1 == 0) goto L51
                r7 = r4
            L51:
                java.util.List r7 = (java.util.List) r7
                if (r7 == 0) goto L6b
                ir.nasim.tP1 r1 = ir.nasim.C21270tP1.this
                r6.b = r2
                java.lang.Object r7 = ir.nasim.C21270tP1.Q(r1, r7, r4, r6)
                if (r7 != r0) goto L60
                return r0
            L60:
                java.util.List r7 = (java.util.List) r7
                if (r7 == 0) goto L6b
                java.lang.Object r7 = ir.nasim.ZW0.s0(r7)
                r4 = r7
                ir.nasim.database.dailogLists.DialogEntity r4 = (ir.nasim.database.dailogLists.DialogEntity) r4
            L6b:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21270tP1.C21280j.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C21280j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tP1$k, reason: case insensitive filesystem */
    static final class C21281k extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        C21281k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            Object objO0 = C21270tP1.this.o0(null, this);
            return objO0 == AbstractC14862ic3.e() ? objO0 : C9475a16.a(objO0);
        }
    }

    /* renamed from: ir.nasim.tP1$l, reason: case insensitive filesystem */
    static final class C21282l extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        C21282l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objD = C21270tP1.this.D(0, this);
            return objD == AbstractC14862ic3.e() ? objD : C9475a16.a(objD);
        }
    }

    /* renamed from: ir.nasim.tP1$m, reason: case insensitive filesystem */
    static final class C21283m extends AbstractC22163um1 {
        Object a;
        int b;
        int c;
        /* synthetic */ Object d;
        int f;

        C21283m(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            Object objW0 = C21270tP1.this.w0(0L, 0, 0, this);
            return objW0 == AbstractC14862ic3.e() ? objW0 : C9475a16.a(objW0);
        }
    }

    /* renamed from: ir.nasim.tP1$n, reason: case insensitive filesystem */
    static final class C21284n extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        C21284n(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C21270tP1.this.H(null, this);
        }
    }

    /* renamed from: ir.nasim.tP1$o, reason: case insensitive filesystem */
    static final class C21285o extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        C21285o(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            Object objO = C21270tP1.this.o(null, this);
            return objO == AbstractC14862ic3.e() ? objO : C9475a16.a(objO);
        }
    }

    /* renamed from: ir.nasim.tP1$p, reason: case insensitive filesystem */
    static final class C21286p extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        C21286p(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objY = C21270tP1.this.y(0L, 0, 0, this);
            return objY == AbstractC14862ic3.e() ? objY : C9475a16.a(objY);
        }
    }

    /* renamed from: ir.nasim.tP1$q, reason: case insensitive filesystem */
    static final class C21287q extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C21287q(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21270tP1.this.new C21287q(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                TP1 tp1 = C21270tP1.this.l;
                RP1.b bVar = new RP1.b(this.d);
                this.b = 1;
                if (tp1.e(bVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                AbstractC10685c16.b(obj);
            }
            HM1 hm1 = C21270tP1.this.b;
            List list = this.d;
            this.b = 2;
            if (hm1.n(list, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C21287q) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tP1$r */
    static final class r extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11458d25 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(C11458d25 c11458d25, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c11458d25;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21270tP1.this.new r(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                String string = C21270tP1.this.j.getString(FD5.dialog_chat_history_cleared);
                AbstractC13042fc3.h(string, "getString(...)");
                RP1.h hVar = new RP1.h(this.d.u(), 0L, new DialogLastMessage.Text(string, (List) null, (EnumC22968w74) null, (String) null, false, 0, (MessageState) null, (Set) null, (MessagingStruct$ServiceEx.b) null, 510, (ED1) null), null, null, this.d.getPeerId(), 24, null);
                TP1 tp1 = C21270tP1.this.l;
                this.b = 1;
                if (tp1.e(hVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                AbstractC10685c16.b(obj);
            }
            HM1 hm1 = C21270tP1.this.b;
            long jU = this.d.u();
            String string2 = C21270tP1.this.j.getString(FD5.dialog_chat_history_cleared);
            AbstractC13042fc3.h(string2, "getString(...)");
            DialogLastMessage.Text text = new DialogLastMessage.Text(string2, (List) null, (EnumC22968w74) null, (String) null, false, 0, (MessageState) null, (Set) null, (MessagingStruct$ServiceEx.b) null, 510, (ED1) null);
            this.b = 2;
            if (hm1.u(jU, 0L, text, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((r) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tP1$s */
    static final class s extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;

        /* renamed from: ir.nasim.tP1$s$a */
        static final class a extends AbstractC19859r37 implements UA2 {
            int b;
            final /* synthetic */ C21270tP1 c;
            final /* synthetic */ long d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C21270tP1 c21270tP1, long j, InterfaceC20295rm1 interfaceC20295rm1) {
                super(1, interfaceC20295rm1);
                this.c = c21270tP1;
                this.d = j;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            /* JADX WARN: Removed duplicated region for block: B:20:0x0062 A[RETURN] */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                /*
                    r7 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r7.b
                    r2 = 3
                    r3 = 2
                    r4 = 1
                    if (r1 == 0) goto L25
                    if (r1 == r4) goto L21
                    if (r1 == r3) goto L1d
                    if (r1 != r2) goto L15
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L63
                L15:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r0)
                    throw r8
                L1d:
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L4a
                L21:
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L39
                L25:
                    ir.nasim.AbstractC10685c16.b(r8)
                    ir.nasim.tP1 r8 = r7.c
                    ir.nasim.HM1 r8 = ir.nasim.C21270tP1.V(r8)
                    long r5 = r7.d
                    r7.b = r4
                    java.lang.Object r8 = r8.g(r5, r7)
                    if (r8 != r0) goto L39
                    return r0
                L39:
                    ir.nasim.tP1 r8 = r7.c
                    ir.nasim.database.dailogLists.c r8 = ir.nasim.C21270tP1.W(r8)
                    long r4 = r7.d
                    r7.b = r3
                    java.lang.Object r8 = r8.c(r4, r7)
                    if (r8 != r0) goto L4a
                    return r0
                L4a:
                    ir.nasim.tP1 r8 = r7.c
                    ir.nasim.lP1 r8 = ir.nasim.C21270tP1.X(r8)
                    long r3 = r7.d
                    java.lang.Long r1 = ir.nasim.AbstractC6392Nk0.e(r3)
                    java.util.List r1 = ir.nasim.ZW0.e(r1)
                    r7.b = r2
                    java.lang.Object r8 = r8.h(r1, r7)
                    if (r8 != r0) goto L63
                    return r0
                L63:
                    ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21270tP1.s.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.UA2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        s(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21270tP1.this.new s(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                DialogDatabase dialogDatabase = C21270tP1.this.o;
                a aVar = new a(C21270tP1.this, this.d, null);
                this.b = 1;
                if (androidx.room.f.d(dialogDatabase, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                AbstractC10685c16.b(obj);
            }
            TP1 tp1 = C21270tP1.this.l;
            RP1.a aVar2 = new RP1.a(this.d);
            this.b = 2;
            if (tp1.e(aVar2, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((s) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tP1$t */
    static final class t extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11458d25 d;
        final /* synthetic */ int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        t(C11458d25 c11458d25, int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c11458d25;
            this.e = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21270tP1.this.new t(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                TP1 tp1 = C21270tP1.this.l;
                RP1.l lVar = new RP1.l(this.d.u(), this.e);
                this.b = 1;
                if (tp1.e(lVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                AbstractC10685c16.b(obj);
            }
            HM1 hm1 = C21270tP1.this.b;
            long jU = this.d.u();
            int i2 = this.e;
            this.b = 2;
            if (hm1.v(jU, i2, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((t) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tP1$u */
    static final class u extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C14697iL2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        u(C14697iL2 c14697iL2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c14697iL2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21270tP1.this.new u(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                HM1 hm1 = C21270tP1.this.b;
                long jU = this.d.I0().u();
                String strG0 = this.d.G0();
                AbstractC13042fc3.h(strG0, "getTitle(...)");
                boolean zJ0 = C21270tP1.this.j0(this.d.x0());
                this.b = 1;
                if (HM1.s(hm1, jU, strG0, zJ0, false, false, this, 16, null) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                AbstractC10685c16.b(obj);
            }
            TP1 tp1 = C21270tP1.this.l;
            long jU2 = this.d.I0().u();
            String strG02 = this.d.G0();
            AbstractC13042fc3.h(strG02, "getTitle(...)");
            Avatar avatarH0 = this.d.h0();
            RP1.e eVar = new RP1.e(jU2, strG02, avatarH0 != null ? avatarH0.toByteArray() : null, this.d.x0());
            this.b = 2;
            if (tp1.e(eVar, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((u) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tP1$v */
    static final class v extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        private /* synthetic */ Object d;
        final /* synthetic */ C11458d25 f;
        final /* synthetic */ long g;
        final /* synthetic */ AbstractC17457n0 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        v(C11458d25 c11458d25, long j, AbstractC17457n0 abstractC17457n0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.f = c11458d25;
            this.g = j;
            this.h = abstractC17457n0;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            v vVar = C21270tP1.this.new v(this.f, this.g, this.h, interfaceC20295rm1);
            vVar.d = obj;
            return vVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:44:0x0126 A[RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r35) {
            /*
                Method dump skipped, instructions count: 301
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21270tP1.v.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((v) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tP1$w */
    static final class w extends AbstractC19859r37 implements InterfaceC14603iB2 {
        long b;
        long c;
        int d;
        private /* synthetic */ Object e;
        final /* synthetic */ C11458d25 f;
        final /* synthetic */ J44 g;
        final /* synthetic */ C21270tP1 h;
        final /* synthetic */ boolean i;
        final /* synthetic */ int j;
        final /* synthetic */ List k;
        final /* synthetic */ ExPeerType l;
        final /* synthetic */ long m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        w(C11458d25 c11458d25, J44 j44, C21270tP1 c21270tP1, boolean z, int i, List list, ExPeerType exPeerType, long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.f = c11458d25;
            this.g = j44;
            this.h = c21270tP1;
            this.i = z;
            this.j = i;
            this.k = list;
            this.l = exPeerType;
            this.m = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            w wVar = new w(this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, interfaceC20295rm1);
            wVar.e = obj;
            return wVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x00a4  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00c9  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0114 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0115  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0124  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x014c  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0155  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x01b9 A[LOOP:0: B:44:0x01b3->B:46:0x01b9, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0215 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0227 A[RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r39) {
            /*
                Method dump skipped, instructions count: 574
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21270tP1.w.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((w) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tP1$x */
    static final class x extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        long f;
        int g;
        final /* synthetic */ C11458d25 i;
        final /* synthetic */ long j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        x(C11458d25 c11458d25, long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.i = c11458d25;
            this.j = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21270tP1.this.new x(this.i, this.j, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x00e9  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00ec  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r38) {
            /*
                Method dump skipped, instructions count: 288
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21270tP1.x.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((x) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tP1$y */
    static final class y extends AbstractC19859r37 implements InterfaceC14603iB2 {
        long b;
        Object c;
        Object d;
        int e;
        final /* synthetic */ C11458d25 f;
        final /* synthetic */ C21270tP1 g;
        final /* synthetic */ long h;
        final /* synthetic */ long i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        y(C11458d25 c11458d25, C21270tP1 c21270tP1, long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.f = c11458d25;
            this.g = c21270tP1;
            this.h = j;
            this.i = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean y(long j, long j2, MessageIdentifier messageIdentifier) {
            return messageIdentifier.getRid() == j && messageIdentifier.getDate() == j2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new y(this.f, this.g, this.h, this.i, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x00c9 A[RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r12.e
                r2 = 3
                r3 = 2
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L34
                if (r1 == r5) goto L2e
                if (r1 == r3) goto L1f
                if (r1 != r2) goto L17
                ir.nasim.AbstractC10685c16.b(r13)
                goto Lca
            L17:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L1f:
                long r5 = r12.b
                java.lang.Object r1 = r12.d
                java.util.List r1 = (java.util.List) r1
                java.lang.Object r3 = r12.c
                ir.nasim.database.dailogLists.DialogEntity r3 = (ir.nasim.database.dailogLists.DialogEntity) r3
                ir.nasim.AbstractC10685c16.b(r13)
                goto La4
            L2e:
                long r6 = r12.b
                ir.nasim.AbstractC10685c16.b(r13)
                goto L4e
            L34:
                ir.nasim.AbstractC10685c16.b(r13)
                ir.nasim.d25 r13 = r12.f
                long r6 = r13.u()
                ir.nasim.tP1 r13 = r12.g
                ir.nasim.HM1 r13 = ir.nasim.C21270tP1.V(r13)
                r12.b = r6
                r12.e = r5
                java.lang.Object r13 = r13.j(r6, r12)
                if (r13 != r0) goto L4e
                return r0
            L4e:
                ir.nasim.database.dailogLists.DialogEntity r13 = (ir.nasim.database.dailogLists.DialogEntity) r13
                if (r13 == 0) goto Lca
                java.util.List r1 = r13.getUnreadMentions()
                if (r1 != 0) goto L5c
                java.util.List r1 = ir.nasim.ZW0.m()
            L5c:
                java.util.Collection r1 = (java.util.Collection) r1
                boolean r1 = r1.isEmpty()
                r1 = r1 ^ r5
                if (r1 == 0) goto Lca
                java.util.List r1 = r13.getUnreadMentions()
                if (r1 == 0) goto L86
                java.util.Collection r1 = (java.util.Collection) r1
                java.util.List r1 = ir.nasim.ZW0.p1(r1)
                if (r1 == 0) goto L86
                long r8 = r12.h
                long r10 = r12.i
                ir.nasim.uP1 r5 = new ir.nasim.uP1
                r5.<init>()
                ir.nasim.ZW0.K(r1, r5)
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.List r1 = ir.nasim.ZW0.m1(r1)
                goto L87
            L86:
                r1 = r4
            L87:
                if (r1 != 0) goto L8d
                java.util.List r1 = ir.nasim.ZW0.m()
            L8d:
                ir.nasim.tP1 r5 = r12.g
                ir.nasim.HM1 r5 = ir.nasim.C21270tP1.V(r5)
                r12.c = r13
                r12.d = r1
                r12.b = r6
                r12.e = r3
                java.lang.Object r3 = r5.w(r6, r1, r12)
                if (r3 != r0) goto La2
                return r0
            La2:
                r3 = r13
                r5 = r6
            La4:
                ir.nasim.tP1 r13 = r12.g
                java.lang.String r3 = r3.getExPeerType()
                ir.nasim.core.modules.profile.entity.ExPeerType r3 = ir.nasim.core.modules.profile.entity.ExPeerType.valueOf(r3)
                boolean r13 = ir.nasim.C21270tP1.g0(r13, r1, r3)
                ir.nasim.tP1 r1 = r12.g
                ir.nasim.TP1 r1 = ir.nasim.C21270tP1.Y(r1)
                ir.nasim.RP1$g r3 = new ir.nasim.RP1$g
                r3.<init>(r5, r13)
                r12.c = r4
                r12.d = r4
                r12.e = r2
                java.lang.Object r13 = r1.e(r3, r12)
                if (r13 != r0) goto Lca
                return r0
            Lca:
                ir.nasim.rB7 r13 = ir.nasim.C19938rB7.a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21270tP1.y.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((y) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tP1$z */
    static final class z extends AbstractC19859r37 implements InterfaceC14603iB2 {
        long b;
        Object c;
        int d;
        final /* synthetic */ C11458d25 e;
        final /* synthetic */ C21270tP1 f;
        final /* synthetic */ long g;
        final /* synthetic */ long h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        z(C11458d25 c11458d25, C21270tP1 c21270tP1, long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = c11458d25;
            this.f = c21270tP1;
            this.g = j;
            this.h = j2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new z(this.e, this.f, this.g, this.h, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:62:0x0118 A[RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                Method dump skipped, instructions count: 287
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21270tP1.z.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((z) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C21270tP1(C19467qP1 c19467qP1, HM1 hm1, ir.nasim.database.dailogLists.c cVar, BM1 bm1, C24011xt3 c24011xt3, InterfaceC3570Bk5 interfaceC3570Bk5, E84 e84, InterfaceC16512lP1 interfaceC16512lP1, AbstractC13778go1 abstractC13778go1, Context context, InterfaceC20315ro1 interfaceC20315ro1, TP1 tp1, InterfaceC8898Xu3 interfaceC8898Xu3, int i, DialogDatabase dialogDatabase) {
        AbstractC13042fc3.i(c19467qP1, "remoteDataSource");
        AbstractC13042fc3.i(hm1, "dialogDao");
        AbstractC13042fc3.i(cVar, "dialogFolderDao");
        AbstractC13042fc3.i(bm1, "dialogDTOConverter");
        AbstractC13042fc3.i(c24011xt3, "lastMessageMapper");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferences");
        AbstractC13042fc3.i(e84, "messagesModule");
        AbstractC13042fc3.i(interfaceC16512lP1, "dialogPeerUnreadStateDao");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(interfaceC20315ro1, "applicationScope");
        AbstractC13042fc3.i(tp1, "dialogUpdateProvider");
        AbstractC13042fc3.i(interfaceC8898Xu3, "settingsModule");
        AbstractC13042fc3.i(dialogDatabase, "db");
        this.a = c19467qP1;
        this.b = hm1;
        this.c = cVar;
        this.d = bm1;
        this.e = c24011xt3;
        this.f = interfaceC3570Bk5;
        this.g = e84;
        this.h = interfaceC16512lP1;
        this.i = abstractC13778go1;
        this.j = context;
        this.k = interfaceC20315ro1;
        this.l = tp1;
        this.m = interfaceC8898Xu3;
        this.n = i;
        this.o = dialogDatabase;
    }

    private final Object A0(int i, int i2, List list, InterfaceC20295rm1 interfaceC20295rm1) {
        DialogEntity dialogEntity = (DialogEntity) AbstractC15401jX0.F0(list);
        long jMax = Math.max(dialogEntity != null ? dialogEntity.getSortDate() : 0L, 0L);
        boolean z2 = list.size() < i2;
        UO1.d.a.b(i, "SetLastLoaded Date to, folderId: " + i + ", lastLoadedDate: " + jMax + ", endOfPaginationReached=" + z2 + Separators.SP, "Repository");
        Object objV = this.c.V(i, jMax, z2, interfaceC20295rm1);
        return objV == AbstractC14862ic3.e() ? objV : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j0(E25 e25) {
        return e25 == E25.VERIFIED || e25 == E25.LEGAL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00ab -> B:21:0x00ae). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k0(java.util.List r11, java.lang.Integer r12, ir.nasim.InterfaceC20295rm1 r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof ir.nasim.C21270tP1.C21276f
            if (r0 == 0) goto L13
            r0 = r13
            ir.nasim.tP1$f r0 = (ir.nasim.C21270tP1.C21276f) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.i = r1
            goto L18
        L13:
            ir.nasim.tP1$f r0 = new ir.nasim.tP1$f
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.g
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.i
            r3 = 1
            if (r2 == 0) goto L4a
            if (r2 != r3) goto L42
            java.lang.Object r11 = r0.f
            java.util.List r11 = (java.util.List) r11
            java.lang.Object r12 = r0.e
            java.util.Iterator r12 = (java.util.Iterator) r12
            java.lang.Object r2 = r0.d
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r4 = r0.c
            java.util.Set r4 = (java.util.Set) r4
            java.lang.Object r5 = r0.b
            java.lang.Integer r5 = (java.lang.Integer) r5
            java.lang.Object r6 = r0.a
            ir.nasim.tP1 r6 = (ir.nasim.C21270tP1) r6
            ir.nasim.AbstractC10685c16.b(r13)
            goto Lae
        L42:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L4a:
            ir.nasim.AbstractC10685c16.b(r13)
            r10.z0(r11)
            java.util.LinkedHashSet r13 = new java.util.LinkedHashSet
            r13.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.Iterator r11 = r11.iterator()
            r6 = r10
            r4 = r13
            r13 = r12
            r12 = r11
            r11 = r2
        L65:
            boolean r2 = r12.hasNext()
            if (r2 == 0) goto Lb4
            java.lang.Object r2 = r12.next()
            ai.bale.proto.MessagingStruct$Dialog r2 = (ai.bale.proto.MessagingStruct$Dialog) r2
            ai.bale.proto.PeersStruct$Peer r5 = r2.getPeer()
            java.lang.String r7 = "getPeer(...)"
            ir.nasim.AbstractC13042fc3.h(r5, r7)
            long r7 = r6.t0(r5)
            ai.bale.proto.PeersStruct$ExInfo r5 = r2.getExInfo()
            ir.nasim.b35 r5 = r5.getExPeerType()
            java.lang.String r9 = "getExPeerType(...)"
            ir.nasim.AbstractC13042fc3.h(r5, r9)
            java.util.Set r5 = r6.p0(r7, r5, r13)
            java.util.Collection r5 = (java.util.Collection) r5
            r4.addAll(r5)
            ir.nasim.BM1 r5 = r6.d
            r0.a = r6
            r0.b = r13
            r0.c = r4
            r0.d = r11
            r0.e = r12
            r0.f = r11
            r0.i = r3
            java.lang.Object r2 = r5.f(r2, r0)
            if (r2 != r1) goto Lab
            return r1
        Lab:
            r5 = r13
            r13 = r2
            r2 = r11
        Lae:
            r11.add(r13)
            r11 = r2
            r13 = r5
            goto L65
        Lb4:
            ir.nasim.tP1$a r12 = new ir.nasim.tP1$a
            r12.<init>(r11, r4)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21270tP1.k0(java.util.List, java.lang.Integer, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l0(java.util.List r6, java.lang.Integer r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof ir.nasim.C21270tP1.C21277g
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.tP1$g r0 = (ir.nasim.C21270tP1.C21277g) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.tP1$g r0 = new ir.nasim.tP1$g
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r6 = r0.a
            ir.nasim.AbstractC10685c16.b(r8)
            goto L5c
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            java.lang.Object r6 = r0.a
            ir.nasim.tP1 r6 = (ir.nasim.C21270tP1) r6
            ir.nasim.AbstractC10685c16.b(r8)
            goto L4d
        L3e:
            ir.nasim.AbstractC10685c16.b(r8)
            r0.a = r5
            r0.d = r4
            java.lang.Object r8 = r5.k0(r6, r7, r0)
            if (r8 != r1) goto L4c
            return r1
        L4c:
            r6 = r5
        L4d:
            r7 = r8
            ir.nasim.tP1$a r7 = (ir.nasim.C21270tP1.C21271a) r7
            r0.a = r8
            r0.d = r3
            java.lang.Object r6 = r6.y0(r7, r0)
            if (r6 != r1) goto L5b
            return r1
        L5b:
            r6 = r8
        L5c:
            ir.nasim.tP1$a r6 = (ir.nasim.C21270tP1.C21271a) r6
            java.util.List r6 = r6.a()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21270tP1.l0(java.util.List, java.lang.Integer, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m0(ir.nasim.C11458d25 r37, ir.nasim.core.modules.profile.entity.ExPeerType r38, ir.nasim.J44 r39, int r40, ir.nasim.InterfaceC20295rm1 r41) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21270tP1.m0(ir.nasim.d25, ir.nasim.core.modules.profile.entity.ExPeerType, ir.nasim.J44, int, ir.nasim.rm1):java.lang.Object");
    }

    private final Object n0(C11458d25 c11458d25, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.i, new C21280j(c11458d25, null), interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o0(java.util.List r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof ir.nasim.C21270tP1.C21281k
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.tP1$k r0 = (ir.nasim.C21270tP1.C21281k) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.tP1$k r0 = new ir.nasim.tP1$k
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            ir.nasim.AbstractC10685c16.b(r8)
            goto L74
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            java.lang.Object r7 = r0.a
            ir.nasim.tP1 r7 = (ir.nasim.C21270tP1) r7
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r8 = r8.l()
            goto L53
        L42:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.qP1 r8 = r6.a
            r0.a = r6
            r0.d = r4
            java.lang.Object r8 = r8.j(r7, r0)
            if (r8 != r1) goto L52
            return r1
        L52:
            r7 = r6
        L53:
            java.lang.Throwable r2 = ir.nasim.C9475a16.e(r8)
            if (r2 == 0) goto L60
            ir.nasim.UO1$e r4 = ir.nasim.UO1.e.a
            java.lang.String r5 = "Loading Peer dialog has been failed"
            r4.c(r5, r2)
        L60:
            boolean r2 = ir.nasim.C9475a16.j(r8)
            if (r2 == 0) goto L76
            java.util.List r8 = (java.util.List) r8
            r2 = 0
            r0.a = r2
            r0.d = r3
            java.lang.Object r8 = r7.l0(r8, r2, r0)
            if (r8 != r1) goto L74
            return r1
        L74:
            java.util.List r8 = (java.util.List) r8
        L76:
            java.lang.Object r7 = ir.nasim.C9475a16.b(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21270tP1.o0(java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    private final Set p0(long j, EnumC10088b35 enumC10088b35, Integer num) {
        Set setB = AbstractC4363Eu6.b();
        if (num != null) {
            setB.add(new DialogFolderAssociationEntity(j, num.intValue(), null, 4, null));
        }
        int iQ0 = q0(enumC10088b35);
        if (num == null || num.intValue() != iQ0) {
            setB.add(new DialogFolderAssociationEntity(j, q0(enumC10088b35), null, 4, null));
        }
        EnumC7296Rc4 enumC7296Rc4 = EnumC7296Rc4.ReservedFolderID_ALL;
        int number = enumC7296Rc4.getNumber();
        if (num == null || num.intValue() != number) {
            setB.add(new DialogFolderAssociationEntity(j, enumC7296Rc4.getNumber(), null, 4, null));
        }
        return AbstractC4363Eu6.a(setB);
    }

    private final int q0(EnumC10088b35 enumC10088b35) {
        Object objB;
        try {
            C9475a16.a aVar = C9475a16.b;
            objB = C9475a16.b(Integer.valueOf(enumC10088b35.getNumber()));
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        Integer numValueOf = Integer.valueOf(EnumC7296Rc4.ReservedFolderID_ALL.getNumber());
        if (C9475a16.g(objB)) {
            objB = numValueOf;
        }
        return ((Number) objB).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MessageState r0(ExPeerType exPeerType, long j, long j2) {
        return exPeerType == ExPeerType.CHANNEL ? MessageState.Unknown : j2 >= j ? MessageState.Read : MessageState.Sent;
    }

    private final long t0(PeersStruct$Peer peersStruct$Peer) {
        W25 w25;
        EnumC16311l35 type = peersStruct$Peer.getType();
        int i = type == null ? -1 : C21272b.a[type.ordinal()];
        if (i == -1) {
            w25 = W25.a;
        } else if (i == 1) {
            w25 = W25.b;
        } else if (i != 2) {
            if (i != 3 && i != 4 && i != 5) {
                throw new NoWhenBranchMatchedException();
            }
            w25 = W25.a;
        } else {
            w25 = W25.c;
        }
        return C11458d25.w(peersStruct$Peer.getId(), w25);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String u0(List list, ExPeerType exPeerType, boolean z2) {
        List list2 = list;
        return (list2 == null || list2.isEmpty() || !((exPeerType == ExPeerType.GROUP || exPeerType == ExPeerType.PRIVATE) && !z2 && C8386Vt0.W5())) ? "" : "❤️";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean v0(List list, ExPeerType exPeerType) {
        List list2 = list;
        return list2 != null && !list2.isEmpty() && exPeerType == ExPeerType.GROUP && C8386Vt0.U5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object w0(long r15, int r17, int r18, ir.nasim.InterfaceC20295rm1 r19) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21270tP1.w0(long, int, int, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object x0(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.i, new C(list, this, null), interfaceC20295rm1);
    }

    private final Object y0(C21271a c21271a, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.i, new F(c21271a, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    private final InterfaceC13730gj3 z0(List list) {
        return AbstractC10533bm0.d(this.k, this.i, null, new N(list, this, null), 2, null);
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public Object A(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.i, new C21287q(list, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public void B(C17637nI7 c17637nI7) {
        AbstractC13042fc3.i(c17637nI7, "user");
        AbstractC9913am0.b(null, new B(c17637nI7, this, null), 1, null);
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public void C(C11458d25 c11458d25, J44 j44, boolean z2, ExPeerType exPeerType, List list, int i, long j) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(list, "mentionIds");
        AbstractC9913am0.b(null, new w(c11458d25, j44, this, z2, i, list, exPeerType, j, null), 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // ir.nasim.InterfaceC20667sP1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object D(int r8, ir.nasim.InterfaceC20295rm1 r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ir.nasim.C21270tP1.C21282l
            if (r0 == 0) goto L14
            r0 = r9
            ir.nasim.tP1$l r0 = (ir.nasim.C21270tP1.C21282l) r0
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
            ir.nasim.tP1$l r0 = new ir.nasim.tP1$l
            r0.<init>(r9)
            goto L12
        L1a:
            java.lang.Object r9 = r6.a
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.c
            r2 = 1
            if (r1 == 0) goto L39
            if (r1 != r2) goto L31
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.a16 r9 = (ir.nasim.C9475a16) r9
            java.lang.Object r8 = r9.l()
            goto L66
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.UO1$e r9 = ir.nasim.UO1.e.a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Init dialogs for folder "
            r1.append(r3)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            r3 = 2
            r4 = 0
            ir.nasim.UO1.e.b(r9, r1, r4, r3, r4)
            r6.c = r2
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r4 = 90
            r1 = r7
            r5 = r8
            java.lang.Object r8 = r1.w0(r2, r4, r5, r6)
            if (r8 != r0) goto L66
            return r0
        L66:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21270tP1.D(int, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public void E(List list) {
        AbstractC13042fc3.i(list, "unreadExPeers");
        AbstractC9323Zl0.e(this.i, new O(list, this, null));
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public InterfaceC4557Fq2 F() {
        return this.h.j();
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public void G(List list) {
        AbstractC13042fc3.i(list, "peers");
        AbstractC10533bm0.d(this.k, this.i, null, new M(list, null), 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC20667sP1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object H(ir.nasim.C11458d25 r8, ir.nasim.InterfaceC20295rm1 r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ir.nasim.C21270tP1.C21284n
            if (r0 == 0) goto L13
            r0 = r9
            ir.nasim.tP1$n r0 = (ir.nasim.C21270tP1.C21284n) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.tP1$n r0 = new ir.nasim.tP1$n
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            ir.nasim.AbstractC10685c16.b(r9)
            goto L69
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L34:
            java.lang.Object r8 = r0.b
            ir.nasim.d25 r8 = (ir.nasim.C11458d25) r8
            java.lang.Object r2 = r0.a
            ir.nasim.tP1 r2 = (ir.nasim.C21270tP1) r2
            ir.nasim.AbstractC10685c16.b(r9)
            goto L57
        L40:
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.HM1 r9 = r7.b
            long r5 = r8.u()
            r0.a = r7
            r0.b = r8
            r0.e = r4
            java.lang.Object r9 = r9.j(r5, r0)
            if (r9 != r1) goto L56
            return r1
        L56:
            r2 = r7
        L57:
            ir.nasim.database.dailogLists.DialogEntity r9 = (ir.nasim.database.dailogLists.DialogEntity) r9
            if (r9 != 0) goto L69
            r9 = 0
            r0.a = r9
            r0.b = r9
            r0.e = r3
            java.lang.Object r9 = r2.n0(r8, r0)
            if (r9 != r1) goto L69
            return r1
        L69:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21270tP1.H(ir.nasim.d25, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public Object I(int i, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objF = this.a.f(i, interfaceC20295rm1);
        return objF == AbstractC14862ic3.e() ? objF : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public void J(C11458d25 c11458d25, long j, long j2) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC9913am0.b(null, new C21273c(c11458d25, this, j, j2, null), 1, null);
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public void K(C11458d25 c11458d25, long j) {
        AbstractC13042fc3.i(c11458d25, "peer");
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public void L(List list) {
        AbstractC13042fc3.i(list, "dialogList");
        AbstractC10533bm0.d(this.k, this.i, null, new C21274d(list, null), 2, null);
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public void M(long j, boolean z2) {
        this.l.h(new RP1.i(AbstractC4363Eu6.c(Long.valueOf(j)), z2));
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public void N(C11458d25 c11458d25, long j, AbstractC17457n0 abstractC17457n0) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(abstractC17457n0, "content");
        AbstractC9913am0.b(null, new v(c11458d25, j, abstractC17457n0, null), 1, null);
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public void a(C14697iL2 c14697iL2) {
        AbstractC13042fc3.i(c14697iL2, "group");
        AbstractC9913am0.b(null, new u(c14697iL2, null), 1, null);
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public Object b(InterfaceC20295rm1 interfaceC20295rm1) {
        return this.h.b(interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public void c(Set set) {
        AbstractC13042fc3.i(set, "unreadPeers");
        AbstractC9323Zl0.e(this.i, new P(set, null));
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public void d(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC9913am0.b(null, new r(c11458d25, null), 1, null);
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public Object e(int i, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.c.v(i, interfaceC20295rm1);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC20667sP1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(java.util.List r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.C21270tP1.K
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.tP1$K r0 = (ir.nasim.C21270tP1.K) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.tP1$K r0 = new ir.nasim.tP1$K
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r7)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.go1 r7 = r5.i
            ir.nasim.tP1$L r2 = new ir.nasim.tP1$L
            r4 = 0
            r2.<init>(r6, r5, r4)
            r0.c = r3
            java.lang.Object r7 = ir.nasim.AbstractC9323Zl0.g(r7, r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r6 = r7.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21270tP1.f(java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC20667sP1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object g(java.util.List r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.C21270tP1.G
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.tP1$G r0 = (ir.nasim.C21270tP1.G) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.tP1$G r0 = new ir.nasim.tP1$G
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r7)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.go1 r7 = r5.i
            ir.nasim.tP1$H r2 = new ir.nasim.tP1$H
            r4 = 0
            r2.<init>(r6, r5, r4)
            r0.c = r3
            java.lang.Object r7 = ir.nasim.AbstractC9323Zl0.g(r7, r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r6 = r7.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21270tP1.g(java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public void h(List list) {
        AbstractC13042fc3.i(list, "peers");
        AbstractC9913am0.b(null, new J(list, null), 1, null);
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public void i(C11458d25 c11458d25, long j) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC9913am0.b(null, new x(c11458d25, j, null), 1, null);
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public void j(C11458d25 c11458d25, long j, long j2) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC9913am0.b(null, new y(c11458d25, this, j, j2, null), 1, null);
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public void k(long j) {
        AbstractC9913am0.b(null, new C21275e(j, null), 1, null);
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public void l() {
        AbstractC9323Zl0.e(this.i, new D(null));
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public Object m(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.i, new E(list, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public void n(long j) {
        AbstractC9913am0.b(null, new s(j, null), 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC20667sP1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object o(java.util.List r9, ir.nasim.InterfaceC20295rm1 r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof ir.nasim.C21270tP1.C21285o
            if (r0 == 0) goto L13
            r0 = r10
            ir.nasim.tP1$o r0 = (ir.nasim.C21270tP1.C21285o) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.tP1$o r0 = new ir.nasim.tP1$o
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 10
            r4 = 1
            r5 = 2
            if (r2 == 0) goto L45
            if (r2 == r4) goto L3d
            if (r2 != r5) goto L35
            ir.nasim.AbstractC10685c16.b(r10)
            ir.nasim.a16 r10 = (ir.nasim.C9475a16) r10
            java.lang.Object r9 = r10.l()
            goto Lc8
        L35:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3d:
            java.lang.Object r9 = r0.a
            ir.nasim.tP1 r9 = (ir.nasim.C21270tP1) r9
            ir.nasim.AbstractC10685c16.b(r10)
            goto L7d
        L45:
            ir.nasim.AbstractC10685c16.b(r10)
            ir.nasim.HM1 r10 = r8.b
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.ArrayList r2 = new java.util.ArrayList
            int r6 = ir.nasim.ZW0.x(r9, r3)
            r2.<init>(r6)
            java.util.Iterator r9 = r9.iterator()
        L59:
            boolean r6 = r9.hasNext()
            if (r6 == 0) goto L71
            java.lang.Object r6 = r9.next()
            ir.nasim.d25 r6 = (ir.nasim.C11458d25) r6
            long r6 = r6.u()
            java.lang.Long r6 = ir.nasim.AbstractC6392Nk0.e(r6)
            r2.add(r6)
            goto L59
        L71:
            r0.a = r8
            r0.d = r4
            java.lang.Object r10 = r10.h(r2, r0)
            if (r10 != r1) goto L7c
            return r1
        L7c:
            r9 = r8
        L7d:
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = ir.nasim.ZW0.x(r10, r3)
            r2.<init>(r3)
            java.util.Iterator r10 = r10.iterator()
        L8c:
            boolean r3 = r10.hasNext()
            if (r3 == 0) goto La4
            java.lang.Object r3 = r10.next()
            java.lang.Number r3 = (java.lang.Number) r3
            long r3 = r3.longValue()
            ir.nasim.d25 r3 = ir.nasim.C11458d25.r(r3)
            r2.add(r3)
            goto L8c
        La4:
            boolean r10 = r2.isEmpty()
            r3 = 0
            if (r10 == 0) goto Lbd
            ir.nasim.UO1$e r9 = ir.nasim.UO1.e.a
            java.lang.String r10 = "loadMissingDialogsFromRemote > No missing peers detected → skipping remote fetch."
            ir.nasim.UO1.e.b(r9, r10, r3, r5, r3)
            ir.nasim.a16$a r9 = ir.nasim.C9475a16.b
            java.util.List r9 = ir.nasim.ZW0.m()
            java.lang.Object r9 = ir.nasim.C9475a16.b(r9)
            return r9
        Lbd:
            r0.a = r3
            r0.d = r5
            java.lang.Object r9 = r9.o0(r2, r0)
            if (r9 != r1) goto Lc8
            return r1
        Lc8:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21270tP1.o(java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public void p(C11458d25 c11458d25, int i) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC9913am0.b(null, new t(c11458d25, i, null), 1, null);
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public boolean q() {
        return this.p;
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public Object r(long j, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.i, new C21279i(j, null), interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public Object s(int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.c.t(i, i2, C8386Vt0.I3(), interfaceC20295rm1);
    }

    public final int s0() {
        return this.n;
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public void t(C11458d25 c11458d25, long j, long j2) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC9913am0.b(null, new z(c11458d25, this, j, j2, null), 1, null);
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public Object u(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        AbstractC10533bm0.d(this.k, this.i, null, new I(list, this, null), 2, null);
        return C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public Object v(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objF = this.b.f(interfaceC20295rm1);
        return objF == AbstractC14862ic3.e() ? objF : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public void w(boolean z2) {
        this.p = z2;
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public void x(C11458d25 c11458d25, int i, boolean z2) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC9323Zl0.e(this.i, new Q(i, this, c11458d25, z2, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // ir.nasim.InterfaceC20667sP1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object y(long r7, int r9, int r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r6 = this;
            boolean r10 = r11 instanceof ir.nasim.C21270tP1.C21286p
            if (r10 == 0) goto L14
            r10 = r11
            ir.nasim.tP1$p r10 = (ir.nasim.C21270tP1.C21286p) r10
            int r0 = r10.c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L14
            int r0 = r0 - r1
            r10.c = r0
        L12:
            r5 = r10
            goto L1a
        L14:
            ir.nasim.tP1$p r10 = new ir.nasim.tP1$p
            r10.<init>(r11)
            goto L12
        L1a:
            java.lang.Object r10 = r5.a
            java.lang.Object r11 = ir.nasim.AbstractC13660gc3.e()
            int r0 = r5.c
            r1 = 1
            if (r0 == 0) goto L39
            if (r0 != r1) goto L31
            ir.nasim.AbstractC10685c16.b(r10)
            ir.nasim.a16 r10 = (ir.nasim.C9475a16) r10
            java.lang.Object r7 = r10.l()
            goto L6a
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            ir.nasim.AbstractC10685c16.b(r10)
            ir.nasim.UO1$e r10 = ir.nasim.UO1.e.a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Load more: folder "
            r0.append(r2)
            r0.append(r9)
            java.lang.String r2 = ", minDate="
            r0.append(r2)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            r2 = 2
            r3 = 0
            ir.nasim.UO1.e.b(r10, r0, r3, r2, r3)
            r5.c = r1
            r3 = 30
            r0 = r6
            r1 = r7
            r4 = r9
            java.lang.Object r7 = r0.w0(r1, r3, r4, r5)
            if (r7 != r11) goto L6a
            return r11
        L6a:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21270tP1.y(long, int, int, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC20667sP1
    public void z(C11458d25 c11458d25, Long l, String str) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_DRAFT);
        AbstractC9913am0.b(null, new A(c11458d25, str, l, null), 1, null);
    }
}
