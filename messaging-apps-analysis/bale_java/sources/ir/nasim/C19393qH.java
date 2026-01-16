package ir.nasim;

import android.content.SharedPreferences;

/* renamed from: ir.nasim.qH, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19393qH {
    public static final C19393qH a = new C19393qH();
    private static final SharedPreferences b;
    public static final int c;

    static {
        SharedPreferences sharedPreferences = C5721Ko.a.d().getSharedPreferences("arbaeen.ini", 0);
        AbstractC13042fc3.h(sharedPreferences, "getSharedPreferences(...)");
        b = sharedPreferences;
        c = 8;
    }

    private C19393qH() {
    }

    public final boolean a() {
        return b.getBoolean("first_status_sent", false);
    }

    public final String b() {
        return b.getString("last_viewer_list", null);
    }

    public final String c() {
        try {
            return b.getString("recent_list", null);
        } catch (Exception unused) {
            return null;
        }
    }

    public final boolean d() {
        return b.getBoolean("shown_last_viewer_tooltip", false);
    }

    public final void e() {
        b.edit().remove("last_viewer_list").apply();
    }

    public final void f() {
        b.edit().remove("recent_list").apply();
    }

    public final void g() {
        b.edit().putBoolean("first_status_sent", true).apply();
    }

    public final void h(String str) {
        AbstractC13042fc3.i(str, "recentList");
        SharedPreferences.Editor editorEdit = b.edit();
        editorEdit.putString("last_viewer_list", str);
        editorEdit.apply();
    }

    public final void i(String str) {
        AbstractC13042fc3.i(str, "recentList");
        SharedPreferences.Editor editorEdit = b.edit();
        editorEdit.putString("recent_list", str);
        editorEdit.apply();
    }

    public final void j() {
        b.edit().putBoolean("shown_last_viewer_tooltip", true).apply();
    }
}
