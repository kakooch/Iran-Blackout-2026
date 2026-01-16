package ir.nasim;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* renamed from: ir.nasim.eH, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12238eH extends VW7 {
    private C20298rm4 b = new C20298rm4();
    private C20298rm4 c = new C20298rm4();

    /* renamed from: ir.nasim.eH$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ String d;
        final /* synthetic */ C12238eH e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, C12238eH c12238eH, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
            this.e = c12238eH;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.d, this.e, interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            String name;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            ArrayList arrayList = new ArrayList();
            KS2 ks2 = new KS2();
            try {
                String strB = C19393qH.a.b();
                if (strB != null) {
                    try {
                        String[] strArr = (String[]) ks2.k(strB, String[].class);
                        arrayList = new ArrayList(AbstractC10360bX0.p(Arrays.copyOf(strArr, strArr.length)));
                    } catch (Exception e) {
                        if (interfaceC20315ro1.getClass().isAnonymousClass()) {
                            name = interfaceC20315ro1.getClass().getName();
                            if (name.length() <= 23) {
                                AbstractC13042fc3.f(name);
                            } else {
                                AbstractC13042fc3.f(name);
                                name = name.substring(name.length() - 23, name.length());
                                AbstractC13042fc3.h(name, "substring(...)");
                            }
                        } else {
                            name = interfaceC20315ro1.getClass().getSimpleName();
                            if (name.length() <= 23) {
                                AbstractC13042fc3.f(name);
                            } else {
                                AbstractC13042fc3.f(name);
                                name = name.substring(0, 23);
                                AbstractC13042fc3.h(name, "substring(...)");
                            }
                        }
                        C19406qI3.d(name, e);
                    }
                }
            } catch (Exception unused) {
                C19393qH.a.e();
            }
            if (arrayList.contains(this.d)) {
                arrayList.remove(this.d);
                arrayList.add(0, this.d);
            } else {
                arrayList.add(0, this.d);
            }
            if (arrayList.size() > 500) {
                arrayList.remove(arrayList.size() - 1);
            }
            String strT = ks2.t(arrayList);
            C19393qH c19393qH = C19393qH.a;
            AbstractC13042fc3.f(strT);
            c19393qH.h(strT);
            new ArrayList().add(arrayList);
            this.e.c1();
            this.e.b1();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.eH$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ String d;
        final /* synthetic */ C12238eH e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, C12238eH c12238eH, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
            this.e = c12238eH;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.d, this.e, interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            String name;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            ArrayList arrayList = new ArrayList();
            KS2 ks2 = new KS2();
            try {
                String strB = C19393qH.a.b();
                if (strB != null) {
                    try {
                        String[] strArr = (String[]) ks2.k(strB, String[].class);
                        arrayList = new ArrayList(AbstractC10360bX0.p(Arrays.copyOf(strArr, strArr.length)));
                    } catch (Exception e) {
                        if (interfaceC20315ro1.getClass().isAnonymousClass()) {
                            name = interfaceC20315ro1.getClass().getName();
                            if (name.length() <= 23) {
                                AbstractC13042fc3.f(name);
                            } else {
                                AbstractC13042fc3.f(name);
                                name = name.substring(name.length() - 23, name.length());
                                AbstractC13042fc3.h(name, "substring(...)");
                            }
                        } else {
                            name = interfaceC20315ro1.getClass().getSimpleName();
                            if (name.length() <= 23) {
                                AbstractC13042fc3.f(name);
                            } else {
                                AbstractC13042fc3.f(name);
                                name = name.substring(0, 23);
                                AbstractC13042fc3.h(name, "substring(...)");
                            }
                        }
                        C19406qI3.d(name, e);
                    }
                }
            } catch (Exception unused) {
                C19393qH.a.e();
            }
            if (arrayList.contains(this.d)) {
                arrayList.remove(arrayList.indexOf(this.d));
            }
            String strT = ks2.t(arrayList);
            C19393qH c19393qH = C19393qH.a;
            AbstractC13042fc3.f(strT);
            c19393qH.h(strT);
            new ArrayList().add(arrayList);
            this.e.c1();
            this.e.b1();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.eH$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12238eH.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            String[] strArrY0 = C12238eH.this.Y0();
            C12238eH c12238eH = C12238eH.this;
            ArrayList arrayList = new ArrayList();
            if (strArrY0 != null) {
                if (!(strArrY0.length == 0)) {
                    arrayList.addAll(c12238eH.U0(strArrY0));
                }
            }
            c12238eH.W0().n(arrayList);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.eH$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12238eH.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            String[] strArrY0 = C12238eH.this.Y0();
            C12238eH c12238eH = C12238eH.this;
            ArrayList arrayList = new ArrayList();
            if (strArrY0 != null) {
                if (!(strArrY0.length == 0)) {
                    if (strArrY0.length > 4) {
                        String str = strArrY0[0];
                        arrayList.add(new C12847fH(str, c12238eH.V0(str)));
                        String str2 = strArrY0[1];
                        arrayList.add(new C12847fH(str2, c12238eH.V0(str2)));
                        String str3 = strArrY0[2];
                        arrayList.add(new C12847fH(str3, c12238eH.V0(str3)));
                        String str4 = strArrY0[3];
                        arrayList.add(new C12847fH(str4, c12238eH.V0(str4)));
                        arrayList.add(new C13465gH());
                    } else {
                        arrayList.addAll(c12238eH.U0(strArrY0));
                    }
                }
            }
            c12238eH.X0().n(arrayList);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList U0(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(new C12847fH(str, V0(str)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String V0(String str) {
        C5721Ko c5721Ko = C5721Ko.a;
        if (AbstractC4043Dl1.a(c5721Ko.d(), "android.permission.READ_CONTACTS") == 0) {
            ContentResolver contentResolver = c5721Ko.d().getContentResolver();
            Uri uriWithAppendedPath = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(AbstractC20153rZ6.O(str, "0", "", false, 4, null)));
            AbstractC13042fc3.h(uriWithAppendedPath, "withAppendedPath(...)");
            Cursor cursorQuery = contentResolver.query(uriWithAppendedPath, new String[]{"display_name"}, null, null, null);
            if (cursorQuery == null) {
                cursorQuery = null;
            }
            if (cursorQuery != null) {
                if (cursorQuery.moveToFirst() && cursorQuery.getColumnIndex("display_name") >= 0) {
                    str = cursorQuery.getString(cursorQuery.getColumnIndex("display_name"));
                }
                if (!cursorQuery.isClosed()) {
                    cursorQuery.close();
                }
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String[] Y0() {
        String name;
        String strB = C19393qH.a.b();
        if (strB == null) {
            return null;
        }
        try {
            return (String[]) new KS2().k(strB, String[].class);
        } catch (Exception e) {
            if (C12238eH.class.isAnonymousClass()) {
                name = C12238eH.class.getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = C12238eH.class.getSimpleName();
                int length2 = name.length();
                AbstractC13042fc3.f(name);
                if (length2 > 23) {
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.d(name, e);
            return null;
        }
    }

    public final void T0(String str) {
        AbstractC13042fc3.i(str, "id");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new a(str, this, null), 2, null);
    }

    public final C20298rm4 W0() {
        return this.c;
    }

    public final C20298rm4 X0() {
        return this.b;
    }

    public final void Z0(String str) {
        AbstractC13042fc3.i(str, "id");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new b(str, this, null), 2, null);
    }

    public final void a1(String str) {
        AbstractC13042fc3.i(str, "type");
        HashMap map = new HashMap();
        map.put("event_type", str);
        C3343Am.i("arbaeen_ussd_click", map);
    }

    public final void b1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new c(null), 2, null);
    }

    public final void c1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new d(null), 2, null);
    }

    public final boolean d1(String str) {
        AbstractC13042fc3.i(str, "number");
        return new C20644sM5("^(\\+989|989|09|00989|9)[0-9]{9}$").g(new C20644sM5("[^\\d]").k(str, ""));
    }
}
