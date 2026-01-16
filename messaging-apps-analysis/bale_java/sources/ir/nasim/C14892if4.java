package ir.nasim;

import android.app.NotificationManager;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import ir.nasim.C14892if4;
import ir.nasim.C5210Ij1;
import ir.nasim.database.entity.ContactEntity;
import ir.nasim.features.payment.data.model.BankCreditCard;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.xbill.DNS.Type;

/* renamed from: ir.nasim.if4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14892if4 extends AbstractC6360Ng4 {
    private final C9057Yh4 m;
    private final List n;

    /* renamed from: ir.nasim.if4$a */
    public static final class a extends AbstractC14282hf4 {
        a() {
            super(60);
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void apply(C14505i18 c14505i18) {
            C14892if4.this.g0().T().B();
        }
    }

    /* renamed from: ir.nasim.if4$b */
    public static final class b extends AbstractC14282hf4 {
        b() {
            super(43);
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void apply(C14505i18 c14505i18) throws SQLException {
            AbstractC13042fc3.i(c14505i18, "aVoid");
            SQLiteDatabase sQLiteDatabaseB = AbstractC13215fr.b.b();
            sQLiteDatabaseB.beginTransactionNonExclusive();
            sQLiteDatabaseB.execSQL("DROP TABLE IF EXISTS kv_book_import");
            sQLiteDatabaseB.execSQL("DROP TABLE IF EXISTS kv_chat_cursor");
            sQLiteDatabaseB.execSQL("DROP TABLE IF EXISTS kv_chat_group_cursor");
            sQLiteDatabaseB.execSQL("DROP TABLE IF EXISTS kv_presence");
            sQLiteDatabaseB.setTransactionSuccessful();
            sQLiteDatabaseB.endTransaction();
        }
    }

    /* renamed from: ir.nasim.if4$c */
    public static final class c extends AbstractC14282hf4 {
        c() {
            super(54);
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void apply(C14505i18 c14505i18) {
            String strB;
            String strB2;
            String str = BankCreditCard.STORAGE_PREFIX + BankCreditCard.c.a;
            String str2 = BankCreditCard.STORAGE_PREFIX + BankCreditCard.c.b;
            String strE = C7183Qq.p().e(str);
            String strE2 = C7183Qq.p().e(str2);
            if (strE != null && strE.length() != 0) {
                C16358l82 c16358l82 = C16358l82.a;
                if (C16358l82.c(c16358l82, strE, null, 2, null) == null && (strB2 = c16358l82.b(strE, "QmFua2luZ1NlY3JldEtleQ==")) != null) {
                    C7183Qq.p().putString(str, C16358l82.f(c16358l82, strB2, null, 2, null));
                }
            }
            if (strE2 == null || strE2.length() == 0) {
                return;
            }
            C16358l82 c16358l822 = C16358l82.a;
            if (C16358l82.c(c16358l822, strE2, null, 2, null) != null || (strB = c16358l822.b(strE2, "QmFua2luZ1NlY3JldEtleQ==")) == null) {
                return;
            }
            C7183Qq.p().putString(str2, C16358l82.f(c16358l822, strB, null, 2, null));
        }
    }

    /* renamed from: ir.nasim.if4$d */
    public static final class d extends AbstractC14282hf4 {
        d() {
            super(38);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(final C14892if4 c14892if4, final List list) {
            AbstractC13042fc3.i(c14892if4, "this$0");
            AbstractC13042fc3.i(list, ContactEntity.TABLE_NAME);
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((C3512Be1) it.next()).r()));
            }
            final HashMap map = new HashMap();
            c14892if4.g0().W().p0().g(arrayList).m0(new InterfaceC24449ye1() { // from class: ir.nasim.kf4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C14892if4.d.q(map, list, c14892if4, (List) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void q(Map map, List list, C14892if4 c14892if4, List list2) {
            AbstractC13042fc3.i(map, "$usersIsBot");
            AbstractC13042fc3.i(list, "$contacts");
            AbstractC13042fc3.i(c14892if4, "this$0");
            AbstractC13042fc3.i(list2, "users");
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                C17637nI7 c17637nI7 = (C17637nI7) it.next();
                map.put(Integer.valueOf(c17637nI7.n0()), Boolean.valueOf(c17637nI7.p0()));
            }
            ArrayList arrayList = new ArrayList();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                C3512Be1 c3512Be1 = (C3512Be1) it2.next();
                Boolean bool = (Boolean) map.get(Integer.valueOf(c3512Be1.r()));
                arrayList.add(new C3512Be1(c3512Be1.r(), c3512Be1.j(), c3512Be1.q(), c3512Be1.getName(), bool != null ? bool.booleanValue() : false));
            }
            c14892if4.g0().A().m0().s(arrayList);
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public void apply(C14505i18 c14505i18) {
            AbstractC13042fc3.i(c14505i18, "aVoid");
            C6517Nv5 c6517Nv5H = C14892if4.this.g0().A().m0().h();
            final C14892if4 c14892if4 = C14892if4.this;
            c6517Nv5H.m0(new InterfaceC24449ye1() { // from class: ir.nasim.jf4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C14892if4.d.p(c14892if4, (List) obj);
                }
            });
        }
    }

    /* renamed from: ir.nasim.if4$e */
    public static final class e extends AbstractC14282hf4 {
        e() {
            super(79);
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void apply(C14505i18 c14505i18) {
            AbstractC13042fc3.i(c14505i18, "aVoid");
            C14892if4.this.g0().G().T0().l();
        }
    }

    /* renamed from: ir.nasim.if4$f */
    public static final class f extends AbstractC14282hf4 {
        f() {
            super(40);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C10405bZ1 p() {
            return new C10405bZ1();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void q(OK ok, C14892if4 c14892if4, List list) {
            AbstractC13042fc3.i(ok, "$downloadedEngine");
            AbstractC13042fc3.i(c14892if4, "this$0");
            if (list != null) {
                c14892if4.g0().D().O().c(list);
            }
            ok.m();
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public void apply(C14505i18 c14505i18) {
            AbstractC13042fc3.i(c14505i18, "aVoid");
            final OK ok = new OK(KN6.e(C86.a, "downloads", new InterfaceC17311ml0() { // from class: ir.nasim.lf4
                @Override // ir.nasim.InterfaceC17311ml0
                public final Object a() {
                    return C14892if4.f.p();
                }
            }, null), "D_db");
            C6517Nv5 c6517Nv5H = ok.h();
            final C14892if4 c14892if4 = C14892if4.this;
            c6517Nv5H.m0(new InterfaceC24449ye1() { // from class: ir.nasim.mf4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C14892if4.f.q(ok, c14892if4, (List) obj);
                }
            });
        }
    }

    /* renamed from: ir.nasim.if4$g */
    public static final class g extends AbstractC14282hf4 {
        g() {
            super(41);
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void apply(C14505i18 c14505i18) {
            AbstractC13042fc3.i(c14505i18, "aVoid");
            C10431bb8.a.h();
        }
    }

    /* renamed from: ir.nasim.if4$h */
    public static final class h extends AbstractC14282hf4 {
        h() {
            super(35);
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void apply(C14505i18 c14505i18) {
            AbstractC13042fc3.i(c14505i18, "aVoid");
            C10431bb8.a.c();
        }
    }

    /* renamed from: ir.nasim.if4$i */
    public static final class i extends AbstractC14282hf4 {
        i() {
            super(39);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(C14892if4 c14892if4, List list) {
            AbstractC13042fc3.i(c14892if4, "this$0");
            AbstractC13042fc3.i(list, "conversationStates");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                C4778Gn1 c4778Gn1 = (C4778Gn1) it.next();
                J44 j44 = (J44) c14892if4.g0().G().H0(c4778Gn1.b0()).m();
                if (j44 != null && j44.O() == null) {
                    j44.l0(new C3460Az(-1L, -1L, 0L));
                    c14892if4.g0().G().H0(c4778Gn1.b0()).d(j44);
                }
            }
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void apply(C14505i18 c14505i18) {
            AbstractC13042fc3.i(c14505i18, "aVoid");
            C6517Nv5 c6517Nv5H = C14892if4.this.g0().G().I0().o().h();
            final C14892if4 c14892if4 = C14892if4.this;
            c6517Nv5H.m0(new InterfaceC24449ye1() { // from class: ir.nasim.nf4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C14892if4.i.o(c14892if4, (List) obj);
                }
            });
        }
    }

    /* renamed from: ir.nasim.if4$j */
    public static final class j extends AbstractC14282hf4 {
        j() {
            super(53);
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void apply(C14505i18 c14505i18) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
            EnumC18608ow5 enumC18608ow5 = EnumC18608ow5.g;
            String strE = C7183Qq.q(enumC18608ow5).e("ir.nasim.shaparak_public_key");
            if (strE == null || strE.length() == 0) {
                return;
            }
            C16358l82 c16358l82 = C16358l82.a;
            if (C16358l82.c(c16358l82, strE, null, 2, null) == null) {
                String strB = c16358l82.b(strE, "QmFua2luZ1NlY3JldEtleQ==");
                C7183Qq.q(enumC18608ow5).putString("ir.nasim.shaparak_public_key", strB != null ? C16358l82.f(c16358l82, strB, null, 2, null) : null);
            }
        }
    }

    /* renamed from: ir.nasim.if4$k */
    public static final class k extends AbstractC14282hf4 {
        k() {
            super(34);
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void apply(C14505i18 c14505i18) {
            AbstractC13042fc3.i(c14505i18, "aVoid");
            if (Build.VERSION.SDK_INT >= 26) {
                Object systemService = C5721Ko.a.d().getSystemService("notification");
                AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                NotificationManager notificationManager = (NotificationManager) systemService;
                if (notificationManager.getNotificationChannel("custom_notification") != null) {
                    notificationManager.deleteNotificationChannel("custom_notification");
                }
            }
        }
    }

    /* renamed from: ir.nasim.if4$l */
    public static final class l extends AbstractC14282hf4 {
        l() {
            super(58);
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void apply(C14505i18 c14505i18) {
            List listK = C14892if4.this.g0().A().m0().k();
            if (listK != null) {
                ((InterfaceC13191fo5) I22.a(C5721Ko.a.d(), InterfaceC13191fo5.class)).o().e(listK);
            }
            C14892if4.this.g0().A().l0().d(new C5210Ij1.e());
        }
    }

    /* renamed from: ir.nasim.if4$m */
    public static final class m extends AbstractC14282hf4 {
        m() {
            super(61);
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void apply(C14505i18 c14505i18) {
            C14892if4.this.W().g("contacts_loaded", false);
            C14892if4.this.g0().A().c0();
        }
    }

    /* renamed from: ir.nasim.if4$n */
    public static final class n extends AbstractC14282hf4 {
        n() {
            super(59);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void q(List list, final C14892if4 c14892if4, C14505i18 c14505i18) {
            AbstractC13042fc3.i(list, "$localSearch");
            AbstractC13042fc3.i(c14892if4, "this$0");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final C18823pJ2 c18823pJ2 = (C18823pJ2) it.next();
                if (c18823pJ2.c.z()) {
                    c14892if4.g0().E().X1().a(c18823pJ2.c.getPeerId()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.pf4
                        @Override // ir.nasim.InterfaceC24449ye1
                        public final void apply(Object obj) {
                            C14892if4.n.r(c14892if4, c18823pJ2, (C14697iL2) obj);
                        }
                    });
                } else if (c18823pJ2.c.C()) {
                    c14892if4.g0().W().p0().a(c18823pJ2.c.getPeerId()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.qf4
                        @Override // ir.nasim.InterfaceC24449ye1
                        public final void apply(Object obj) {
                            C14892if4.n.s(c14892if4, c18823pJ2, (C17637nI7) obj);
                        }
                    });
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void r(C14892if4 c14892if4, C18823pJ2 c18823pJ2, C14697iL2 c14697iL2) {
            AbstractC13042fc3.i(c14892if4, "this$0");
            if (c14697iL2.q0() == ZN2.GROUP) {
                c14892if4.g0().Q().G().d(c18823pJ2);
            } else {
                c14892if4.g0().Q().E().d(c18823pJ2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void s(C14892if4 c14892if4, C18823pJ2 c18823pJ2, C17637nI7 c17637nI7) {
            AbstractC13042fc3.i(c14892if4, "this$0");
            if (c17637nI7.r0()) {
                return;
            }
            if (c17637nI7.p0()) {
                c14892if4.g0().Q().D().d(c18823pJ2);
            } else {
                c14892if4.g0().Q().J().d(c18823pJ2);
            }
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public void apply(C14505i18 c14505i18) {
            final List listK = C14892if4.this.g0().Q().H().k();
            if (listK == null) {
                return;
            }
            UG7 ug7V = C14892if4.this.g0().V();
            List<C18823pJ2> list = listK;
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C18823pJ2 c18823pJ2 = (C18823pJ2) it.next();
                C18766pD c18766pD = c18823pJ2.c.C() ? new C18766pD(c18823pJ2.c.getPeerId(), 0L) : null;
                if (c18766pD != null) {
                    arrayList.add(c18766pD);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (C18823pJ2 c18823pJ22 : list) {
                C25238zy c25238zy = new C25238zy(c18823pJ22.c.getPeerId(), 0L);
                if (!c18823pJ22.c.z()) {
                    c25238zy = null;
                }
                if (c25238zy != null) {
                    arrayList2.add(c25238zy);
                }
            }
            C6517Nv5 c6517Nv5T0 = ug7V.t0(arrayList, arrayList2, false);
            final C14892if4 c14892if4 = C14892if4.this;
            c6517Nv5T0.m0(new InterfaceC24449ye1() { // from class: ir.nasim.of4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C14892if4.n.q(listK, c14892if4, (C14505i18) obj);
                }
            });
        }
    }

    /* renamed from: ir.nasim.if4$o */
    public static final class o extends AbstractC14282hf4 {
        o() {
            super(107);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(List list) {
            InterfaceC8481Wd5 interfaceC8481Wd5Z = ((InterfaceC19009pd5) I22.a(C5721Ko.a.d(), InterfaceC19009pd5.class)).Z();
            AbstractC13042fc3.f(list);
            interfaceC8481Wd5Z.b(list);
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void apply(C14505i18 c14505i18) {
            AbstractC13042fc3.i(c14505i18, "t");
            if (C14892if4.this.g0().S().I5()) {
                return;
            }
            C14892if4.this.g0().S().l7(true);
            C14892if4.this.g0().c().g("LOAD_PIN_DIALOG", true);
            C14892if4.this.g0().G().K0().k().m0(new InterfaceC24449ye1() { // from class: ir.nasim.rf4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C14892if4.o.o((List) obj);
                }
            });
        }
    }

    /* renamed from: ir.nasim.if4$p */
    public static final class p extends AbstractC14282hf4 {
        p() {
            super(96);
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void apply(C14505i18 c14505i18) {
            ((HS1) I22.a(C5721Ko.a.d(), HS1.class)).P0().a();
        }
    }

    /* renamed from: ir.nasim.if4$q */
    public static final class q extends AbstractC14282hf4 {
        q() {
            super(Type.EUI48);
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void apply(C14505i18 c14505i18) {
            ((HS1) I22.a(C5721Ko.a.d(), HS1.class)).P0().a();
        }
    }

    /* renamed from: ir.nasim.if4$r */
    public static final class r extends AbstractC14282hf4 {

        /* renamed from: ir.nasim.if4$r$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C6164Ml2 c6164Ml2 = C6164Ml2.a;
                    this.b = 1;
                    obj = c6164Ml2.o(this);
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

        r() {
            super(52);
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void apply(C14505i18 c14505i18) {
            AbstractC13042fc3.i(c14505i18, "aVoid");
            AbstractC9913am0.b(null, new a(null), 1, null);
        }
    }

    /* renamed from: ir.nasim.if4$s */
    public static final class s extends AbstractC14282hf4 {
        s() {
            super(92);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(final C14892if4 c14892if4, final List list) {
            AbstractC13042fc3.i(c14892if4, "this$0");
            c14892if4.g0().E().X1().h().m0(new InterfaceC24449ye1() { // from class: ir.nasim.tf4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C14892if4.s.q(list, c14892if4, (List) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void q(List list, C14892if4 c14892if4, List list2) {
            AbstractC13042fc3.i(c14892if4, "this$0");
            AbstractC13042fc3.f(list2);
            ArrayList arrayList = new ArrayList();
            for (Object obj : list2) {
                C14697iL2 c14697iL2 = (C14697iL2) obj;
                AbstractC13042fc3.f(list);
                List list3 = list;
                if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                    Iterator it = list3.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (((C4778Gn1) it.next()).b0().getPeerId() == c14697iL2.p0()) {
                            if (!c14697iL2.H0()) {
                                arrayList.add(obj);
                            }
                        }
                    }
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                c14892if4.g0().G().s0(((C14697iL2) it2.next()).I0());
            }
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public void apply(C14505i18 c14505i18) {
            AbstractC13042fc3.i(c14505i18, "aVoid");
            C6517Nv5 c6517Nv5H = C14892if4.this.g0().G().I0().o().h();
            final C14892if4 c14892if4 = C14892if4.this;
            c6517Nv5H.m0(new InterfaceC24449ye1() { // from class: ir.nasim.sf4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C14892if4.s.p(c14892if4, (List) obj);
                }
            });
        }
    }

    /* renamed from: ir.nasim.if4$t */
    public static final class t extends AbstractC14282hf4 {
        t() {
            super(48);
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void apply(C14505i18 c14505i18) {
            AbstractC13042fc3.i(c14505i18, "aVoid");
            if (Build.VERSION.SDK_INT >= 26) {
                Object systemService = C5721Ko.a.d().getSystemService("notification");
                AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                NotificationManager notificationManager = (NotificationManager) systemService;
                EnumC18608ow5 enumC18608ow5 = EnumC18608ow5.e;
                notificationManager.deleteNotificationChannel(C7183Qq.q(enumC18608ow5).e("KEY_GIFT_CHANNEL_ID"));
                C7183Qq.q(enumC18608ow5).remove("KEY_GIFT_CHANNEL_ID");
                notificationManager.deleteNotificationChannel(C7183Qq.q(enumC18608ow5).e("KEY_CHANNEL_ID"));
                C7183Qq.q(enumC18608ow5).remove("KEY_CHANNEL_ID");
                notificationManager.deleteNotificationChannel(C7183Qq.q(enumC18608ow5).e("KEY_SILENT_CHANNEL_ID"));
                C7183Qq.q(enumC18608ow5).remove("KEY_SILENT_CHANNEL_ID");
            }
        }
    }

    /* renamed from: ir.nasim.if4$u */
    public static final class u extends AbstractC14282hf4 {
        u() {
            super(55);
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void apply(C14505i18 c14505i18) {
            AbstractC13042fc3.i(c14505i18, "t");
            try {
                byte[] bArrB = C14892if4.this.W().b("sender_pending_v2");
                if (bArrB == null) {
                    return;
                }
                C20466s35 c20466s35Q = C20466s35.q(bArrB);
                Iterator it = c20466s35Q.r().iterator();
                AbstractC13042fc3.h(it, "iterator(...)");
                while (it.hasNext()) {
                    C19857r35 c19857r35 = (C19857r35) it.next();
                    C14892if4.this.g0().G().H0(c19857r35.C()).b(c19857r35.i());
                }
                c20466s35Q.r().clear();
                C14892if4.this.W().f("sender_pending_v2", c20466s35Q.toByteArray());
            } catch (Exception e) {
                C19406qI3.j("stashHandler", "Failed to apply(" + h() + ") because of " + e.getMessage(), new Object[0]);
            }
        }
    }

    /* renamed from: ir.nasim.if4$v */
    public static final class v extends AbstractC14282hf4 {
        v() {
            super(99);
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void apply(C14505i18 c14505i18) {
            ((HS1) I22.a(C5721Ko.a.d(), HS1.class)).q().l();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C14892if4(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.m = c9057Yh4;
        this.n = new ArrayList();
        i0();
        b0("sequences_synced");
    }

    private final AbstractC14282hf4 A0() {
        return new t();
    }

    private final u B0() {
        return new u();
    }

    private final AbstractC14282hf4 C0() {
        return new v();
    }

    private final AbstractC14282hf4 d0() {
        return new a();
    }

    private final C6517Nv5 e0(int i2) {
        C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(C14505i18.a);
        AbstractC12992fX0.A(this.n);
        for (AbstractC14282hf4 abstractC14282hf4 : this.n) {
            if (abstractC14282hf4.h() > i2) {
                C19406qI3.a("stashHandler", "migration " + abstractC14282hf4.h(), new Object[0]);
                c6517Nv5L0 = c6517Nv5L0.m0(abstractC14282hf4);
            }
        }
        AbstractC13042fc3.f(c6517Nv5L0);
        return c6517Nv5L0;
    }

    private final AbstractC14282hf4 f0() {
        return new b();
    }

    private final int h0() {
        Integer num;
        Iterator it = this.n.iterator();
        if (it.hasNext()) {
            Integer numValueOf = Integer.valueOf(((AbstractC14282hf4) it.next()).h());
            while (it.hasNext()) {
                Integer numValueOf2 = Integer.valueOf(((AbstractC14282hf4) it.next()).h());
                if (numValueOf.compareTo(numValueOf2) < 0) {
                    numValueOf = numValueOf2;
                }
            }
            num = numValueOf;
        } else {
            num = null;
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    private final void i0() {
        this.n.add(r0());
        this.n.add(o0());
        this.n.add(k0());
        this.n.add(p0());
        this.n.add(m0());
        this.n.add(n0());
        this.n.add(f0());
        this.n.add(A0());
        this.n.add(y0());
        this.n.add(q0());
        this.n.add(j0());
        this.n.add(B0());
        this.n.add(s0());
        this.n.add(u0());
        this.n.add(t0());
        this.n.add(d0());
        this.n.add(w0());
        if (C8386Vt0.u8()) {
            this.n.add(v0());
        }
        this.n.add(l0());
        this.n.add(z0());
        this.n.add(new C3440Aw6(this.m));
        this.n.add(C0());
        this.n.add(x0());
    }

    private final AbstractC14282hf4 j0() {
        return new c();
    }

    private final AbstractC14282hf4 k0() {
        return new d();
    }

    private final AbstractC14282hf4 l0() {
        return new e();
    }

    private final AbstractC14282hf4 m0() {
        return new f();
    }

    private final AbstractC14282hf4 n0() {
        return new g();
    }

    private final AbstractC14282hf4 o0() {
        return new h();
    }

    private final AbstractC14282hf4 p0() {
        return new i();
    }

    private final AbstractC14282hf4 q0() {
        return new j();
    }

    private final AbstractC14282hf4 r0() {
        return new k();
    }

    private final AbstractC14282hf4 s0() {
        return new l();
    }

    private final AbstractC14282hf4 t0() {
        return new m();
    }

    private final AbstractC14282hf4 u0() {
        return new n();
    }

    private final AbstractC14282hf4 v0() {
        return new o();
    }

    private final AbstractC14282hf4 w0() {
        return new p();
    }

    private final AbstractC14282hf4 x0() {
        return new q();
    }

    private final AbstractC14282hf4 y0() {
        return new r();
    }

    private final AbstractC14282hf4 z0() {
        return new s();
    }

    @Override // ir.nasim.AbstractC6360Ng4
    public void V() {
        e0(W().getInt("migration_version", h0()));
        W().putInt("migration_version", h0());
    }

    public final C9057Yh4 g0() {
        return this.m;
    }
}
