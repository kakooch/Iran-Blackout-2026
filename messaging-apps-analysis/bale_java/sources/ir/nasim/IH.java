package ir.nasim;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes5.dex */
public final class IH extends VW7 {
    private static final a d = new a(null);
    public static final int e = 8;
    private C20298rm4 b = new C20298rm4();
    private C20298rm4 c = new C20298rm4();

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ IH d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, IH ih, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = ih;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            ArrayList arrayList = new ArrayList();
            KS2 ks2 = new KS2();
            try {
                String strC = C19393qH.a.c();
                if (strC != null) {
                    try {
                        String[] strArr = (String[]) ks2.k(strC, String[].class);
                        arrayList = new ArrayList(AbstractC10360bX0.p(Arrays.copyOf(strArr, strArr.length)));
                    } catch (Exception e) {
                        C19406qI3.d("ArbaeenViewStatusViewModel", e);
                    }
                }
            } catch (Exception unused) {
                C19393qH.a.f();
            }
            if (arrayList.contains(this.c)) {
                arrayList.remove(this.c);
                arrayList.add(0, this.c);
            } else {
                arrayList.add(0, this.c);
            }
            if (arrayList.size() > 500) {
                arrayList.remove(arrayList.size() - 1);
            }
            String strT = ks2.t(arrayList);
            C19393qH c19393qH = C19393qH.a;
            AbstractC13042fc3.f(strT);
            c19393qH.i(strT);
            new ArrayList().add(arrayList);
            this.d.c1();
            this.d.b1();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ IH d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, IH ih, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = ih;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            ArrayList arrayList = new ArrayList();
            KS2 ks2 = new KS2();
            try {
                String strC = C19393qH.a.c();
                if (strC != null) {
                    try {
                        String[] strArr = (String[]) ks2.k(strC, String[].class);
                        arrayList = new ArrayList(AbstractC10360bX0.p(Arrays.copyOf(strArr, strArr.length)));
                    } catch (Exception e) {
                        C19406qI3.d("ArbaeenViewStatusViewModel", e);
                    }
                }
            } catch (Exception unused) {
                C19393qH.a.f();
            }
            if (arrayList.contains(this.c)) {
                arrayList.remove(arrayList.indexOf(this.c));
            }
            String strT = ks2.t(arrayList);
            C19393qH c19393qH = C19393qH.a;
            AbstractC13042fc3.f(strT);
            c19393qH.i(strT);
            new ArrayList().add(arrayList);
            this.d.c1();
            this.d.b1();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return IH.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            String[] strArrY0 = IH.this.Y0();
            IH ih = IH.this;
            ArrayList arrayList = new ArrayList();
            if (strArrY0 != null) {
                if (!(strArrY0.length == 0)) {
                    arrayList.addAll(ih.U0(strArrY0));
                }
            }
            ih.W0().n(arrayList);
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
            return IH.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            String[] strArrY0 = IH.this.Y0();
            IH ih = IH.this;
            ArrayList arrayList = new ArrayList();
            if (strArrY0 != null) {
                if (!(strArrY0.length == 0)) {
                    if (strArrY0.length > 4) {
                        String str = strArrY0[0];
                        arrayList.add(new C12847fH(str, ih.V0(str)));
                        String str2 = strArrY0[1];
                        arrayList.add(new C12847fH(str2, ih.V0(str2)));
                        String str3 = strArrY0[2];
                        arrayList.add(new C12847fH(str3, ih.V0(str3)));
                        String str4 = strArrY0[3];
                        arrayList.add(new C12847fH(str4, ih.V0(str4)));
                        arrayList.add(new C13465gH());
                    } else {
                        arrayList.addAll(ih.U0(strArrY0));
                    }
                }
            }
            ih.X0().n(arrayList);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
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
        String strC = C19393qH.a.c();
        if (strC == null) {
            return null;
        }
        try {
            return (String[]) new KS2().k(strC, String[].class);
        } catch (Exception e2) {
            C19406qI3.d("ArbaeenViewStatusViewModel", e2);
            return null;
        }
    }

    public final void T0(String str) {
        AbstractC13042fc3.i(str, "id");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new b(str, this, null), 2, null);
    }

    public final C20298rm4 W0() {
        return this.c;
    }

    public final C20298rm4 X0() {
        return this.b;
    }

    public final void Z0(String str) {
        AbstractC13042fc3.i(str, "id");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new c(str, this, null), 2, null);
    }

    public final void a1(String str) {
        AbstractC13042fc3.i(str, "type");
        HashMap map = new HashMap();
        map.put("event_type", str);
        C3343Am.i("arbaeen_ussd_click", map);
    }

    public final void b1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new d(null), 2, null);
    }

    public final void c1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new e(null), 2, null);
    }

    public final boolean d1(String str) {
        AbstractC13042fc3.i(str, "number");
        return new C20644sM5("^(\\+989|989|09|00989|9)[0-9]{9}$").g(new C20644sM5("[^\\d]").k(str, ""));
    }
}
