package ir.nasim;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes3.dex */
public final class V20 {
    public static final a a = new a(null);
    private static volatile V20 b;
    private static SharedPreferences c;

    public static final class a {
        private a() {
        }

        public final V20 a(Context context) {
            AbstractC13042fc3.i(context, "context");
            V20 v20 = V20.b;
            if (v20 == null) {
                synchronized (this) {
                    v20 = V20.b;
                    if (v20 == null) {
                        v20 = new V20(null);
                        V20.b = v20;
                        SharedPreferences sharedPreferences = context.getSharedPreferences("com.skydoves.balloon", 0);
                        AbstractC13042fc3.h(sharedPreferences, "getSharedPreferences(...)");
                        V20.c = sharedPreferences;
                    }
                }
            }
            return v20;
        }

        public final String b(String str) {
            AbstractC13042fc3.i(str, "name");
            return "SHOWED_UP" + str;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private V20() {
    }

    private final int d(String str) {
        SharedPreferences sharedPreferences = c;
        if (sharedPreferences == null) {
            AbstractC13042fc3.y("sharedPreferenceManager");
            sharedPreferences = null;
        }
        return sharedPreferences.getInt(a.b(str), 0);
    }

    private final void e(String str, int i) {
        SharedPreferences sharedPreferences = c;
        if (sharedPreferences == null) {
            AbstractC13042fc3.y("sharedPreferenceManager");
            sharedPreferences = null;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        AbstractC13042fc3.h(editorEdit, "editor");
        editorEdit.putInt(a.b(str), i);
        editorEdit.apply();
    }

    public final void f(String str) {
        AbstractC13042fc3.i(str, "name");
        e(str, d(str) + 1);
    }

    public final boolean g(String str, int i) {
        AbstractC13042fc3.i(str, "name");
        return d(str) < i;
    }

    public /* synthetic */ V20(ED1 ed1) {
        this();
    }
}
