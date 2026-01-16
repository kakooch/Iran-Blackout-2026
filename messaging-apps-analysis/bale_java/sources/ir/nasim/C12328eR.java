package ir.nasim;

import android.content.Context;
import android.content.SharedPreferences;
import ir.nasim.IU3;
import ir.nasim.SharedPreferencesC15176j82;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.eR, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C12328eR {
    public static final a d = new a(null);
    private final Context a;
    private final IU3 b;
    private final SharedPreferences c;

    /* renamed from: ir.nasim.eR$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C12328eR(Context context) {
        AbstractC13042fc3.i(context, "context");
        this.a = context;
        IU3 iu3A = new IU3.b(context).b(IU3.c.AES256_GCM).a();
        AbstractC13042fc3.h(iu3A, "build(...)");
        this.b = iu3A;
        SharedPreferences sharedPreferencesA = SharedPreferencesC15176j82.a(context, "secret_shared_prefs", iu3A, SharedPreferencesC15176j82.d.AES256_SIV, SharedPreferencesC15176j82.e.AES256_GCM);
        AbstractC13042fc3.h(sharedPreferencesA, "create(...)");
        this.c = sharedPreferencesA;
    }

    public static /* synthetic */ String d(C12328eR c12328eR, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return c12328eR.c(str, str2);
    }

    public final void a(String str) {
        List listM;
        List listN0;
        AbstractC13042fc3.i(str, "item");
        String string = this.c.getString("Auth_Future_Token_List", "");
        if (string == null || (listN0 = AbstractC20762sZ6.N0(string, new String[]{","}, false, 0, 6, null)) == null) {
            listM = null;
        } else {
            listM = new ArrayList();
            for (Object obj : listN0) {
                if (!AbstractC20762sZ6.n0((String) obj)) {
                    listM.add(obj);
                }
            }
        }
        if (listM == null) {
            listM = AbstractC10360bX0.m();
        }
        List listP1 = AbstractC15401jX0.p1(listM);
        if (listP1.size() == 10) {
            listP1.remove(0);
        }
        listP1.add(str);
        this.c.edit().putString("Auth_Future_Token_List", AbstractC15401jX0.A0(listP1, ",", null, null, 0, null, null, 62, null)).apply();
    }

    public final List b() {
        ArrayList arrayList;
        List listN0;
        String string = this.c.getString("Auth_Future_Token_List", "");
        if (string == null || (listN0 = AbstractC20762sZ6.N0(string, new String[]{","}, false, 0, 6, null)) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (Object obj : listN0) {
                if (!AbstractC20762sZ6.n0((String) obj)) {
                    arrayList.add(obj);
                }
            }
        }
        return arrayList == null ? AbstractC10360bX0.m() : arrayList;
    }

    public final String c(String str, String str2) {
        AbstractC13042fc3.i(str, "key");
        return this.c.getString(str, str2);
    }

    public final void e(String str) {
        AbstractC13042fc3.i(str, "key");
        SharedPreferences.Editor editorEdit = this.c.edit();
        AbstractC13042fc3.h(editorEdit, "editor");
        editorEdit.remove(str);
        editorEdit.apply();
    }

    public final void f(String str, String str2) {
        AbstractC13042fc3.i(str, "key");
        AbstractC13042fc3.i(str2, "value");
        SharedPreferences.Editor editorEdit = this.c.edit();
        AbstractC13042fc3.h(editorEdit, "editor");
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }
}
