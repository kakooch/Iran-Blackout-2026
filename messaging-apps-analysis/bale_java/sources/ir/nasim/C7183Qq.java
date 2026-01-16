package ir.nasim;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.Qq, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C7183Qq implements InterfaceC3570Bk5 {
    private static final Object e = new Object();
    private static HashMap f = new HashMap();
    private static byte[] g = null;
    private final Context b;
    private final SharedPreferences c;
    private final String a = "AndroidProperties";
    private volatile boolean d = false;

    private C7183Qq(Context context, String str) {
        this.b = context;
        this.c = context.getSharedPreferences(str, 0);
    }

    private byte[] o() {
        boolean z;
        byte[] bArrC;
        byte[] bArrD;
        byte[] bArrB = b("_symmetric_encryption_key_");
        if (bArrB == null) {
            bArrB = AbstractC7464Rv1.k(32);
            if (!AbstractC6431No3.h("_asymmetric_encryption_key_") || (bArrD = AbstractC6431No3.d("_asymmetric_encryption_key_", bArrB)) == null) {
                z = false;
            } else {
                g("is_asymmetric_key_encrypted", true);
                z = true;
                bArrB = bArrD;
            }
            f("_symmetric_encryption_key_", bArrB);
        } else {
            z = false;
        }
        return ((z || h("is_asymmetric_key_encrypted", false)) && (bArrC = AbstractC6431No3.c("_asymmetric_encryption_key_", bArrB)) != null) ? bArrC : bArrB;
    }

    public static InterfaceC3570Bk5 p() {
        String strP = C13923h3.p();
        if (!f.containsKey(strP)) {
            synchronized (C7183Qq.class) {
                try {
                    if (!f.containsKey(strP)) {
                        f.put(strP, new C7183Qq(C5721Ko.b, strP));
                    }
                } finally {
                }
            }
        }
        return (InterfaceC3570Bk5) f.get(strP);
    }

    public static InterfaceC3570Bk5 q(EnumC18608ow5 enumC18608ow5) {
        if (!f.containsKey(enumC18608ow5.getValue())) {
            synchronized (C7183Qq.class) {
                try {
                    if (!f.containsKey(enumC18608ow5.getValue())) {
                        f.put(enumC18608ow5.getValue(), new C7183Qq(C5721Ko.b, enumC18608ow5.getValue()));
                    }
                } finally {
                }
            }
        }
        return (InterfaceC3570Bk5) f.get(enumC18608ow5.getValue());
    }

    public static InterfaceC3570Bk5 r(String str) {
        if (!f.containsKey(str)) {
            synchronized (C7183Qq.class) {
                try {
                    if (!f.containsKey(str)) {
                        f.put(str, new C7183Qq(C5721Ko.b, str));
                    }
                } finally {
                }
            }
        }
        return (InterfaceC3570Bk5) f.get(str);
    }

    public static InterfaceC3570Bk5 s() {
        HashMap map = f;
        EnumC18608ow5 enumC18608ow5 = EnumC18608ow5.o;
        if (!map.containsKey(enumC18608ow5.getValue())) {
            synchronized (C7183Qq.class) {
                try {
                    if (!f.containsKey(enumC18608ow5.getValue())) {
                        f.put(enumC18608ow5.getValue(), new C7183Qq(C5721Ko.b, enumC18608ow5.getValue()));
                    }
                } finally {
                }
            }
        }
        return (InterfaceC3570Bk5) f.get(enumC18608ow5.getValue());
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public byte[] a(String str) {
        k();
        byte[] bArrB = b(str);
        if (g == null) {
            g = o();
        }
        return AbstractC7464Rv1.b(g, bArrB);
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public synchronized byte[] b(String str) {
        String string = this.c.getString(str, null);
        if (string == null) {
            return null;
        }
        return Base64.decode(string, 0);
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public synchronized void c(String str, int i) {
        this.c.edit().putInt(str, i).commit();
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public synchronized void clear() {
        this.c.edit().clear().commit();
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public boolean contains(String str) {
        return this.c.contains(str);
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public void d(String str, boolean z) {
        this.c.edit().putBoolean(str, z).commit();
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public synchronized String e(String str) {
        return this.c.getString(str, null);
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public synchronized void f(String str, byte[] bArr) {
        try {
            if (bArr != null) {
                this.c.edit().putString(str, Base64.encodeToString(bArr, 0)).apply();
            } else {
                this.c.edit().remove(str).apply();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public synchronized void g(String str, boolean z) {
        this.c.edit().putBoolean(str, z).apply();
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public Map getAll() {
        return this.c.getAll();
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public synchronized int getInt(String str, int i) {
        return this.c.getInt(str, i);
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public synchronized long getLong(String str, long j) {
        return this.c.getLong(str, j);
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public synchronized String getString(String str, String str2) {
        return this.c.getString(str, str2);
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public synchronized boolean h(String str, boolean z) {
        return this.c.getBoolean(str, z);
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public void i(List list) {
        SharedPreferences.Editor editorEdit = this.c.edit();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            editorEdit.remove((String) it.next());
        }
        editorEdit.apply();
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public synchronized void j(String str, byte[] bArr) {
        try {
            if (bArr != null) {
                this.c.edit().putString(str, Base64.encodeToString(bArr, 0)).commit();
            } else {
                this.c.edit().remove(str).commit();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public void k() {
        if (this.d) {
            return;
        }
        synchronized (e) {
            if (!this.d) {
                try {
                    AbstractC6431No3.a(this.b, "_asymmetric_encryption_key_");
                } catch (Exception e2) {
                    C19406qI3.c("AndroidProperties", " keyStoreHelper create keys failed ", e2);
                }
                this.d = true;
            }
        }
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public synchronized Set l(String str) {
        return this.c.getStringSet(str, new HashSet());
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public synchronized void m(String str, String str2) {
        this.c.edit().putString(str, str2).commit();
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public void n(String str, byte[] bArr) {
        k();
        f(str, AbstractC7464Rv1.d(o(), bArr));
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public synchronized void putFloat(String str, float f2) {
        this.c.edit().putFloat(str, f2).apply();
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public synchronized void putInt(String str, int i) {
        this.c.edit().putInt(str, i).apply();
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public synchronized void putLong(String str, long j) {
        this.c.edit().putLong(str, j).apply();
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public synchronized void putString(String str, String str2) {
        this.c.edit().putString(str, str2).apply();
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public synchronized void putStringSet(String str, Set set) {
        this.c.edit().putStringSet(str, set).apply();
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public void remove(String str) {
        this.c.edit().remove(str).apply();
    }
}
