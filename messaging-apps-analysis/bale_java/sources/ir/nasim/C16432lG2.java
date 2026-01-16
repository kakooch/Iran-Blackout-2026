package ir.nasim;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.gov.nist.core.Separators;
import android.provider.ContactsContract;
import io.sentry.C3155n3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.lG2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C16432lG2 {
    private final Context a;
    private final AbstractC13778go1 b;

    /* renamed from: ir.nasim.lG2$a */
    public static final class a {
        private final long a;
        private final String b;
        private final String c;

        public a(long j, String str, String str2) {
            AbstractC13042fc3.i(str, "name");
            AbstractC13042fc3.i(str2, "phoneNumber");
            this.a = j;
            this.b = str;
            this.c = str2;
        }

        public final long a() {
            return this.a;
        }

        public final String b() {
            return this.b;
        }

        public final String c() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && AbstractC13042fc3.d(this.b, aVar.b) && AbstractC13042fc3.d(this.c, aVar.c);
        }

        public int hashCode() {
            return (((Long.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "PhoneBookContactItem(id=" + this.a + ", name=" + this.b + ", phoneNumber=" + this.c + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.lG2$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* renamed from: ir.nasim.lG2$b$a */
        public static final class a implements Comparator {
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AbstractC18050o01.d(((a) obj).b(), ((a) obj2).b());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C16432lG2.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws IOException {
            String string;
            String strM;
            String strM2;
            String strM3;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            ArrayList arrayList = new ArrayList();
            HashMap map = new HashMap();
            ContentResolver contentResolver = C16432lG2.this.a.getContentResolver();
            Cursor cursorQuery = contentResolver != null ? contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null) : null;
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                int columnIndex = cursorQuery.getColumnIndex("contact_id");
                int columnIndex2 = cursorQuery.getColumnIndex("data1");
                int columnIndex3 = cursorQuery.getColumnIndex("display_name");
                while (cursorQuery.moveToNext()) {
                    String string2 = cursorQuery.getString(columnIndex);
                    if (string2 != null && (string = cursorQuery.getString(columnIndex2)) != null) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < string.length(); i++) {
                            char cCharAt = string.charAt(i);
                            if (!AbstractC10868cL0.d(cCharAt)) {
                                sb.append(cCharAt);
                            }
                        }
                        String string3 = sb.toString();
                        AbstractC13042fc3.h(string3, "toString(...)");
                        if (string3 != null && (strM = AbstractC20153rZ6.M(string3, "+", "", false, 4, null)) != null && (strM2 = AbstractC20153rZ6.M(strM, Separators.LPAREN, "", false, 4, null)) != null && (strM3 = AbstractC20153rZ6.M(strM2, Separators.RPAREN, "", false, 4, null)) != null) {
                            String string4 = cursorQuery.getString(columnIndex3);
                            if (string4 == null) {
                                string4 = "";
                            }
                            if (strM3.length() >= 10) {
                                if (map.containsKey(AbstractC4616Fw7.a(string2, string4))) {
                                    ArrayList arrayList2 = (ArrayList) map.get(AbstractC4616Fw7.a(string2, string4));
                                    if (arrayList2 != null) {
                                        AbstractC6392Nk0.a(arrayList2.add(strM3));
                                    }
                                } else {
                                    map.put(AbstractC4616Fw7.a(string2, string4), AbstractC10360bX0.g(strM3));
                                }
                            }
                        }
                    }
                }
                cursorQuery.close();
            }
            for (Map.Entry entry : map.entrySet()) {
                XV4 xv4 = (XV4) entry.getKey();
                Iterator it = ((ArrayList) entry.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new a(Long.parseLong((String) xv4.e()), (String) xv4.f(), (String) it.next()));
                }
            }
            String str = this.d;
            C20644sM5 c20644sM5 = str != null ? new C20644sM5(C3155n3.DEFAULT_PROPAGATION_TARGETS + C20644sM5.b.c(str) + C3155n3.DEFAULT_PROPAGATION_TARGETS, EnumC23107wM5.c) : null;
            List listA1 = AbstractC15401jX0.a1(AbstractC15401jX0.j0(arrayList), new a());
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : listA1) {
                a aVar = (a) obj2;
                if (c20644sM5 == null || c20644sM5.g(aVar.b()) || c20644sM5.g(aVar.c())) {
                    arrayList3.add(obj2);
                }
            }
            return arrayList3;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C16432lG2(Context context, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(context, "applicationContext");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = context;
        this.b = abstractC13778go1;
    }

    public final Object b(String str, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new b(str, null), interfaceC20295rm1);
    }
}
