package ir.nasim;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public class T34 implements InterfaceC3570Bk5 {
    private HashMap a = new HashMap();

    @Override // ir.nasim.InterfaceC3570Bk5
    public byte[] a(String str) {
        return b(str);
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public byte[] b(String str) {
        if (this.a.containsKey(str)) {
            return (byte[]) this.a.get(str);
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public void c(String str, int i) {
        putInt(str, i);
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public void clear() {
        this.a.clear();
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public boolean contains(String str) {
        return this.a.containsKey(str);
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public void d(String str, boolean z) {
        g(str, z);
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public String e(String str) {
        if (this.a.containsKey(str)) {
            return (String) this.a.get(str);
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public void f(String str, byte[] bArr) {
        if (bArr != null) {
            this.a.put(str, bArr);
        } else {
            this.a.remove(str);
        }
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public void g(String str, boolean z) {
        this.a.put(str, Boolean.valueOf(z));
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public Map getAll() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public int getInt(String str, int i) {
        return this.a.containsKey(str) ? ((Integer) this.a.get(str)).intValue() : i;
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public long getLong(String str, long j) {
        return this.a.containsKey(str) ? ((Long) this.a.get(str)).longValue() : j;
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public String getString(String str, String str2) {
        return this.a.containsKey(str) ? (String) this.a.get(str) : str2;
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public boolean h(String str, boolean z) {
        return this.a.containsKey(str) ? ((Boolean) this.a.get(str)).booleanValue() : z;
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public void i(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            list.remove((String) it.next());
        }
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public void j(String str, byte[] bArr) {
        f(str, bArr);
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public void k() {
        throw new RuntimeException("initKeyStore not implemented in MemoryPreferencesStorage ");
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public synchronized Set l(String str) {
        return null;
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public void m(String str, String str2) {
        putString(str, str2);
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public void n(String str, byte[] bArr) {
        f(str, bArr);
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public void putFloat(String str, float f) {
        this.a.put(str, Float.valueOf(f));
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public void putInt(String str, int i) {
        this.a.put(str, Integer.valueOf(i));
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public void putLong(String str, long j) {
        this.a.put(str, Long.valueOf(j));
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public void putString(String str, String str2) {
        if (str2 != null) {
            this.a.put(str, str2);
        } else {
            this.a.remove(str);
        }
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public synchronized void putStringSet(String str, Set set) {
    }

    @Override // ir.nasim.InterfaceC3570Bk5
    public void remove(String str) {
        if (this.a.containsKey(str)) {
            this.a.remove(str);
        }
    }
}
