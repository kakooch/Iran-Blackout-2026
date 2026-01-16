package ir.nasim;

import ai.bale.proto.MessagingStruct$Dialog;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Xd5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8747Xd5 implements InterfaceC8481Wd5 {
    private final AbstractC13778go1 a;
    private final InterfaceC20667sP1 b;
    private final C10299bQ2 c;
    private final InterfaceC20315ro1 d;
    private final SettingsModule e;
    private final InterfaceC6828Pd5 f;

    /* renamed from: ir.nasim.Xd5$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ F92 a = G92.a(EnumC7296Rc4.values());
    }

    /* renamed from: ir.nasim.Xd5$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC7296Rc4.values().length];
            try {
                iArr[EnumC7296Rc4.ReservedFolderID_CHANNEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC7296Rc4.ReservedFolderID_PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC7296Rc4.ReservedFolderID_GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC7296Rc4.ReservedFolderID_BOT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumC7296Rc4.ReservedFolderID_ALL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EnumC7296Rc4.ReservedFolderID_UNREAD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[EnumC7296Rc4.UNRECOGNIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[EnumC7296Rc4.ReservedFolderID_ARCHIVED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.Xd5$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        Object c;
        int d;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.f = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C8747Xd5.this.new c(this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws Throwable {
            int iY3;
            C12889fL5 c12889fL5;
            Object objL;
            Object objE = AbstractC14862ic3.e();
            int i = this.d;
            try {
            } catch (Exception e) {
                C19406qI3.d("migratePinnedDialog", e);
            }
            if (i == 0) {
                AbstractC10685c16.b(obj);
                iY3 = C8747Xd5.this.e.y3();
                C12889fL5 c12889fL52 = new C12889fL5();
                c12889fL52.a = AbstractC10360bX0.m();
                InterfaceC6828Pd5 interfaceC6828Pd5 = C8747Xd5.this.f;
                int number = EnumC7296Rc4.ReservedFolderID_ALL.getNumber();
                this.c = c12889fL52;
                this.b = iY3;
                this.d = 1;
                Object objD = interfaceC6828Pd5.d(number, this);
                if (objD == objE) {
                    return objE;
                }
                c12889fL5 = c12889fL52;
                objL = objD;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                iY3 = this.b;
                c12889fL5 = (C12889fL5) this.c;
                AbstractC10685c16.b(obj);
                objL = ((C9475a16) obj).l();
            }
            List list = this.f;
            if (C9475a16.j(objL)) {
                List list2 = (List) objL;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(AbstractC6392Nk0.d(((MessagingStruct$Dialog) it.next()).getPeer().getId()));
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : list) {
                    if (!arrayList.contains(AbstractC6392Nk0.d(C11458d25.r(((Number) obj2).longValue()).getPeerId()))) {
                        arrayList2.add(obj2);
                    }
                }
                List listF1 = AbstractC15401jX0.f1(arrayList2, iY3 - arrayList.size());
                c12889fL5.a = AbstractC15401jX0.k0(arrayList2, iY3 - arrayList.size());
                C10431bb8.a.a(EnumC7296Rc4.ReservedFolderID_ALL.getNumber(), AbstractC15401jX0.n1(listF1));
            }
            Iterable iterable = (Iterable) c12889fL5.a;
            C8747Xd5 c8747Xd5 = C8747Xd5.this;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj3 : iterable) {
                C11458d25 c11458d25R = C11458d25.r(((Number) obj3).longValue());
                AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
                ExPeerType exPeerTypeM1 = c8747Xd5.c.M1(c11458d25R);
                Object arrayList3 = linkedHashMap.get(exPeerTypeM1);
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList();
                    linkedHashMap.put(exPeerTypeM1, arrayList3);
                }
                ((List) arrayList3).add(obj3);
            }
            C8747Xd5 c8747Xd52 = C8747Xd5.this;
            this.c = null;
            this.d = 2;
            if (c8747Xd52.i(linkedHashMap, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Xd5$d */
    static final class d extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        int e;
        int f;
        /* synthetic */ Object g;
        int i;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= RecyclerView.UNDEFINED_DURATION;
            return C8747Xd5.this.i(null, this);
        }
    }

    /* renamed from: ir.nasim.Xd5$e */
    static final class e extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objA = C8747Xd5.this.a(0, null, this);
            return objA == AbstractC14862ic3.e() ? objA : C9475a16.a(objA);
        }
    }

    /* renamed from: ir.nasim.Xd5$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;
        final /* synthetic */ List e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(int i, List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C8747Xd5.this.new f(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objA;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC6828Pd5 interfaceC6828Pd5 = C8747Xd5.this.f;
                int i2 = this.d;
                List list = this.e;
                this.b = 1;
                objA = interfaceC6828Pd5.a(i2, list, this);
                if (objA == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objA = ((C9475a16) obj).l();
            }
            return C9475a16.a(objA);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C8747Xd5(AbstractC13778go1 abstractC13778go1, InterfaceC20667sP1 interfaceC20667sP1, C10299bQ2 c10299bQ2, InterfaceC20315ro1 interfaceC20315ro1, SettingsModule settingsModule, InterfaceC6828Pd5 interfaceC6828Pd5) {
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC20667sP1, "dialogRepository");
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        AbstractC13042fc3.i(interfaceC20315ro1, "applicationScope");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(interfaceC6828Pd5, "pinRepository");
        this.a = abstractC13778go1;
        this.b = interfaceC20667sP1;
        this.c = c10299bQ2;
        this.d = interfaceC20315ro1;
        this.e = settingsModule;
        this.f = interfaceC6828Pd5;
    }

    private final void g(int i) {
        EnumC7296Rc4 enumC7296Rc4J = EnumC7296Rc4.j(i);
        switch (enumC7296Rc4J == null ? -1 : b.a[enumC7296Rc4J.ordinal()]) {
            case 1:
                this.e.L6(true);
                return;
            case 2:
                this.e.N6(true);
                return;
            case 3:
                this.e.M6(true);
                return;
            case 4:
                this.e.K6(true);
                return;
            case 5:
            case 6:
            case 7:
            case 8:
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final ExPeerType h(EnumC7296Rc4 enumC7296Rc4) {
        switch (b.a[enumC7296Rc4.ordinal()]) {
            case 1:
                return ExPeerType.CHANNEL;
            case 2:
                return ExPeerType.PRIVATE;
            case 3:
                return ExPeerType.GROUP;
            case 4:
                return ExPeerType.BOT;
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00d8 -> B:56:0x0189). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0167 -> B:56:0x0189). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0180 -> B:55:0x0183). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(java.util.Map r19, ir.nasim.InterfaceC20295rm1 r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 403
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8747Xd5.i(java.util.Map, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC8481Wd5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(int r7, java.util.List r8, ir.nasim.InterfaceC20295rm1 r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof ir.nasim.C8747Xd5.e
            if (r0 == 0) goto L13
            r0 = r9
            ir.nasim.Xd5$e r0 = (ir.nasim.C8747Xd5.e) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Xd5$e r0 = new ir.nasim.Xd5$e
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r9)
            goto L73
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L31:
            ir.nasim.AbstractC10685c16.b(r9)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r9 = new java.util.ArrayList
            r2 = 10
            int r2 = ir.nasim.ZW0.x(r8, r2)
            r9.<init>(r2)
            java.util.Iterator r8 = r8.iterator()
        L45:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L62
            java.lang.Object r2 = r8.next()
            ir.nasim.core.modules.profile.entity.ExPeer r2 = (ir.nasim.core.modules.profile.entity.ExPeer) r2
            ir.nasim.d25 r4 = new ir.nasim.d25
            r4.<init>(r2)
            long r4 = r4.u()
            java.lang.Long r2 = ir.nasim.AbstractC6392Nk0.e(r4)
            r9.add(r2)
            goto L45
        L62:
            ir.nasim.go1 r8 = r6.a
            ir.nasim.Xd5$f r2 = new ir.nasim.Xd5$f
            r4 = 0
            r2.<init>(r7, r9, r4)
            r0.c = r3
            java.lang.Object r9 = ir.nasim.AbstractC9323Zl0.g(r8, r2, r0)
            if (r9 != r1) goto L73
            return r1
        L73:
            ir.nasim.a16 r9 = (ir.nasim.C9475a16) r9
            java.lang.Object r7 = r9.l()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8747Xd5.a(int, java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC8481Wd5
    public void b(List list) {
        AbstractC13042fc3.i(list, "peerUids");
        AbstractC10533bm0.d(this.d, null, null, new c(list, null), 3, null);
    }
}
