package ir.nasim.contact.data;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC10976cX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC13778go1;
import ir.nasim.AbstractC14251hc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC17773nY;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC24549yo1;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC6392Nk0;
import ir.nasim.AbstractC6756Ov5;
import ir.nasim.AbstractC9323Zl0;
import ir.nasim.AbstractC9766aX0;
import ir.nasim.C19938rB7;
import ir.nasim.C3512Be1;
import ir.nasim.C6517Nv5;
import ir.nasim.C8054Ui1;
import ir.nasim.C9045Yg1;
import ir.nasim.C9475a16;
import ir.nasim.DB3;
import ir.nasim.EnumC4715Gg1;
import ir.nasim.HE0;
import ir.nasim.IE0;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC6118Mg1;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.KB5;
import ir.nasim.OK7;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.WA1;
import ir.nasim.WK;
import ir.nasim.contact.data.ContactItem;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.database.entity.ContactEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public final class a implements d {
    private final C9045Yg1 b;
    private final InterfaceC6118Mg1 c;
    private final OK7 d;
    private final AbstractC13778go1 e;
    private final String f;
    private final boolean g;
    private final String h;
    private final EnumC4715Gg1 i;
    private final InterfaceC9173Yu3 j;
    private final InterfaceC9173Yu3 k;
    private final ContactItem.BaleContactItem l;

    /* renamed from: ir.nasim.contact.data.a$a, reason: collision with other inner class name */
    public interface InterfaceC0987a {
        a a(String str, boolean z, String str2, EnumC4715Gg1 enumC4715Gg1);
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;
        private /* synthetic */ Object f;
        final /* synthetic */ int h;
        final /* synthetic */ int i;

        /* renamed from: ir.nasim.contact.data.a$b$a, reason: collision with other inner class name */
        static final class C0988a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ a c;
            final /* synthetic */ List d;
            final /* synthetic */ HE0 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0988a(a aVar, List list, HE0 he0, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = aVar;
                this.d = list;
                this.e = he0;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0988a(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objD;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    OK7 ok7 = this.c.d;
                    List list = this.d;
                    ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(AbstractC6392Nk0.d(((ContactEntity) it.next()).getId()));
                    }
                    C6517Nv5 c6517Nv5W0 = ok7.w0(arrayList, false);
                    this.b = 1;
                    objD = AbstractC6756Ov5.d(c6517Nv5W0, null, this, 1, null);
                    if (objD == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    objD = ((C9475a16) obj).l();
                }
                HE0 he0 = this.e;
                List list2 = this.d;
                if (C9475a16.j(objD)) {
                    List<ContactEntity> list3 = list2;
                    ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list3, 10));
                    for (ContactEntity contactEntity : list3) {
                        int id = contactEntity.getId();
                        String name = contactEntity.getName();
                        Avatar avatarA = AbstractC17773nY.a(contactEntity);
                        arrayList2.add(new ContactItem.BaleContactItem(id, name, avatarA != null ? new ContactItem.BaleContactItem.b.a(avatarA) : null, contactEntity.isBot()));
                    }
                    AbstractC24549yo1.c(he0, arrayList2);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0988a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.h = i;
            this.i = i2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = a.this.new b(this.h, this.i, interfaceC20295rm1);
            bVar.f = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC20315ro1 interfaceC20315ro1;
            Object objE = AbstractC14862ic3.e();
            int i = this.e;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                interfaceC20315ro1 = (InterfaceC20315ro1) this.f;
                InterfaceC6118Mg1 interfaceC6118Mg1 = a.this.c;
                String str = a.this.f;
                EnumC4715Gg1 enumC4715Gg1 = a.this.i;
                int i2 = this.h;
                int i3 = this.i;
                this.f = interfaceC20315ro1;
                this.e = 1;
                obj = interfaceC6118Mg1.a(str, enumC4715Gg1, i2, i3, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return (List) obj;
                }
                interfaceC20315ro1 = (InterfaceC20315ro1) this.f;
                AbstractC10685c16.b(obj);
            }
            InterfaceC20315ro1 interfaceC20315ro12 = interfaceC20315ro1;
            a aVar = a.this;
            List list = (List) obj;
            this.f = interfaceC20315ro12;
            this.b = aVar;
            this.c = list;
            this.d = this;
            this.e = 2;
            IE0 ie0 = new IE0(AbstractC14251hc3.c(this), 1);
            ie0.w();
            AbstractC10533bm0.d(interfaceC20315ro12, null, null, new C0988a(aVar, list, ie0, null), 3, null);
            obj = ie0.t();
            if (obj == AbstractC14862ic3.e()) {
                WA1.c(this);
            }
            if (obj == objE) {
                return objE;
            }
            return (List) obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class c extends AbstractC22163um1 {
        Object a;
        int b;
        /* synthetic */ Object c;
        int e;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return a.this.a(0, 0, this);
        }
    }

    public a(final C8054Ui1 c8054Ui1, C9045Yg1 c9045Yg1, InterfaceC6118Mg1 interfaceC6118Mg1, OK7 ok7, AbstractC13778go1 abstractC13778go1, String str, boolean z, String str2, EnumC4715Gg1 enumC4715Gg1) {
        AbstractC13042fc3.i(c8054Ui1, "contactsModule");
        AbstractC13042fc3.i(c9045Yg1, "mapper");
        AbstractC13042fc3.i(interfaceC6118Mg1, "contactRepository");
        AbstractC13042fc3.i(ok7, "usersModule");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(str2, "savedMessagesName");
        AbstractC13042fc3.i(enumC4715Gg1, "sortType");
        this.b = c9045Yg1;
        this.c = interfaceC6118Mg1;
        this.d = ok7;
        this.e = abstractC13778go1;
        this.f = str;
        this.g = z;
        this.h = str2;
        this.i = enumC4715Gg1;
        this.j = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.hY
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return ir.nasim.contact.data.a.q(c8054Ui1);
            }
        });
        this.k = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.jY
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Integer.valueOf(ir.nasim.contact.data.a.r());
            }
        });
        this.l = m();
    }

    private final Object i(int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.e, new b(i, i2, null), interfaceC20295rm1);
    }

    private final WK j() {
        return (WK) this.j.getValue();
    }

    private final int k() {
        return ((Number) this.k.getValue()).intValue();
    }

    private final List l() {
        List listE;
        ContactItem.BaleContactItem baleContactItem = this.l;
        ContactItem.BaleContactItem baleContactItemB = baleContactItem != null ? ContactItem.BaleContactItem.b(baleContactItem, 0, this.h, new ContactItem.BaleContactItem.b.C0986b(KB5.ic_saved_message), false, 9, null) : null;
        return (baleContactItemB == null || (listE = AbstractC9766aX0.e(baleContactItemB)) == null) ? AbstractC10360bX0.m() : listE;
    }

    private final List n(int i, List list) {
        String str = this.f;
        if (str == null || AbstractC20762sZ6.n0(str)) {
            return list;
        }
        List listS = s(list, new UA2() { // from class: ir.nasim.lY
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ir.nasim.contact.data.a.o(this.a, (ContactItem.BaleContactItem) obj));
            }
        });
        return (i == 0 && p(this.f)) ? AbstractC15401jX0.R0(l(), listS) : listS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o(a aVar, ContactItem.BaleContactItem baleContactItem) {
        AbstractC13042fc3.i(aVar, "this$0");
        AbstractC13042fc3.i(baleContactItem, "it");
        return baleContactItem.getId() == aVar.k();
    }

    private final boolean p(String str) {
        String name;
        ContactItem.BaleContactItem baleContactItem = this.l;
        return ((baleContactItem == null || (name = baleContactItem.getName()) == null) ? false : AbstractC20762sZ6.V(name, str, true)) || AbstractC20762sZ6.V(this.h, str, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WK q(C8054Ui1 c8054Ui1) {
        AbstractC13042fc3.i(c8054Ui1, "$contactsModule");
        DB3 db3M0 = c8054Ui1.m0();
        AbstractC13042fc3.g(db3M0, "null cannot be cast to non-null type ir.nasim.core.runtime.storage.AsyncListEngine<ir.nasim.core.modules.contacts.entity.Contact>");
        return (WK) db3M0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int r() {
        return AbstractC5969Lp4.f();
    }

    private final List s(List list, UA2 ua2) {
        Iterator it = list.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (((Boolean) ua2.invoke(it.next())).booleanValue()) {
                break;
            }
            i++;
        }
        if (i == -1) {
            return list;
        }
        List listP1 = AbstractC15401jX0.p1(list);
        listP1.remove(i);
        return listP1;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.contact.data.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(int r5, int r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ir.nasim.contact.data.a.c
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.contact.data.a$c r0 = (ir.nasim.contact.data.a.c) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.contact.data.a$c r0 = new ir.nasim.contact.data.a$c
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            int r5 = r0.b
            java.lang.Object r6 = r0.a
            ir.nasim.contact.data.a r6 = (ir.nasim.contact.data.a) r6
            ir.nasim.AbstractC10685c16.b(r7)
            goto L48
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r7)
            r0.a = r4
            r0.b = r5
            r0.e = r3
            java.lang.Object r7 = r4.i(r5, r6, r0)
            if (r7 != r1) goto L47
            return r1
        L47:
            r6 = r4
        L48:
            java.util.List r7 = (java.util.List) r7
            boolean r0 = r6.g
            if (r0 == 0) goto L52
            java.util.List r7 = r6.n(r5, r7)
        L52:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.contact.data.a.a(int, int, ir.nasim.rm1):java.lang.Object");
    }

    public final ContactItem.BaleContactItem m() {
        C3512Be1 c3512Be1 = (C3512Be1) j().a(k());
        if (c3512Be1 == null) {
            return null;
        }
        return this.b.a(c3512Be1);
    }
}
