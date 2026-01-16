package ir.nasim;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import ir.nasim.C20323rp;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: ir.nasim.j82, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class SharedPreferencesC15176j82 implements SharedPreferences {
    final SharedPreferences a;
    final CopyOnWriteArrayList b = new CopyOnWriteArrayList();
    final String c;
    final String d;
    final InterfaceC3780Ci e;
    final GJ1 f;

    /* renamed from: ir.nasim.j82$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            a = iArr;
            try {
                iArr[c.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.INT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[c.LONG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[c.FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[c.STRING_SET.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: ir.nasim.j82$b */
    private static final class b implements SharedPreferences.Editor {
        private final SharedPreferencesC15176j82 a;
        private final SharedPreferences.Editor b;
        private final AtomicBoolean d = new AtomicBoolean(false);
        private final List c = new CopyOnWriteArrayList();

        b(SharedPreferencesC15176j82 sharedPreferencesC15176j82, SharedPreferences.Editor editor) {
            this.a = sharedPreferencesC15176j82;
            this.b = editor;
        }

        private void a() {
            if (this.d.getAndSet(false)) {
                for (String str : this.a.getAll().keySet()) {
                    if (!this.c.contains(str) && !this.a.g(str)) {
                        this.b.remove(this.a.d(str));
                    }
                }
            }
        }

        private void b() {
            Iterator it = this.a.b.iterator();
            while (it.hasNext()) {
                SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = (SharedPreferences.OnSharedPreferenceChangeListener) it.next();
                Iterator it2 = this.c.iterator();
                while (it2.hasNext()) {
                    onSharedPreferenceChangeListener.onSharedPreferenceChanged(this.a, (String) it2.next());
                }
            }
        }

        private void c(String str, byte[] bArr) {
            if (this.a.g(str)) {
                throw new SecurityException(str + " is a reserved key for the encryption keyset.");
            }
            this.c.add(str);
            if (str == null) {
                str = "__NULL__";
            }
            try {
                Pair pairE = this.a.e(str, bArr);
                this.b.putString((String) pairE.first, (String) pairE.second);
            } catch (GeneralSecurityException e) {
                throw new SecurityException("Could not encrypt data: " + e.getMessage(), e);
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            a();
            this.b.apply();
            b();
            this.c.clear();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.d.set(true);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            a();
            try {
                return this.b.commit();
            } finally {
                b();
                this.c.clear();
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(5);
            byteBufferAllocate.putInt(c.BOOLEAN.p());
            byteBufferAllocate.put(z ? (byte) 1 : (byte) 0);
            c(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
            byteBufferAllocate.putInt(c.FLOAT.p());
            byteBufferAllocate.putFloat(f);
            c(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
            byteBufferAllocate.putInt(c.INT.p());
            byteBufferAllocate.putInt(i);
            c(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(12);
            byteBufferAllocate.putInt(c.LONG.p());
            byteBufferAllocate.putLong(j);
            c(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            if (str2 == null) {
                str2 = "__NULL__";
            }
            byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
            int length = bytes.length;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length + 8);
            byteBufferAllocate.putInt(c.STRING.p());
            byteBufferAllocate.putInt(length);
            byteBufferAllocate.put(bytes);
            c(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set set) {
            if (set == null) {
                set = new PJ();
                set.add("__NULL__");
            }
            ArrayList<byte[]> arrayList = new ArrayList(set.size());
            int size = set.size() * 4;
            Iterator it = set.iterator();
            while (it.hasNext()) {
                byte[] bytes = ((String) it.next()).getBytes(StandardCharsets.UTF_8);
                arrayList.add(bytes);
                size += bytes.length;
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(size + 4);
            byteBufferAllocate.putInt(c.STRING_SET.p());
            for (byte[] bArr : arrayList) {
                byteBufferAllocate.putInt(bArr.length);
                byteBufferAllocate.put(bArr);
            }
            c(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            if (!this.a.g(str)) {
                this.b.remove(this.a.d(str));
                this.c.add(str);
                return this;
            }
            throw new SecurityException(str + " is a reserved key for the encryption keyset.");
        }
    }

    /* renamed from: ir.nasim.j82$c */
    private enum c {
        STRING(0),
        STRING_SET(1),
        INT(2),
        LONG(3),
        FLOAT(4),
        BOOLEAN(5);

        private final int a;

        c(int i) {
            this.a = i;
        }

        public static c j(int i) {
            if (i == 0) {
                return STRING;
            }
            if (i == 1) {
                return STRING_SET;
            }
            if (i == 2) {
                return INT;
            }
            if (i == 3) {
                return LONG;
            }
            if (i == 4) {
                return FLOAT;
            }
            if (i != 5) {
                return null;
            }
            return BOOLEAN;
        }

        public int p() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.j82$d */
    public enum d {
        AES256_SIV("AES256_SIV");

        private final String a;

        d(String str) {
            this.a = str;
        }

        C6925Po3 j() {
            return AbstractC7169Qo3.a(this.a);
        }
    }

    /* renamed from: ir.nasim.j82$e */
    public enum e {
        AES256_GCM("AES256_GCM");

        private final String a;

        e(String str) {
            this.a = str;
        }

        C6925Po3 j() {
            return AbstractC7169Qo3.a(this.a);
        }
    }

    SharedPreferencesC15176j82(String str, String str2, SharedPreferences sharedPreferences, InterfaceC3780Ci interfaceC3780Ci, GJ1 gj1) {
        this.c = str;
        this.a = sharedPreferences;
        this.d = str2;
        this.e = interfaceC3780Ci;
        this.f = gj1;
    }

    public static SharedPreferences a(Context context, String str, IU3 iu3, d dVar, e eVar) {
        return b(str, iu3.a(), context, dVar, eVar);
    }

    public static SharedPreferences b(String str, String str2, Context context, d dVar, e eVar) {
        HJ1.a();
        AbstractC4014Di.b();
        Context applicationContext = context.getApplicationContext();
        C5266Ip3 c5266Ip3E = new C20323rp.b().l(dVar.j()).n(applicationContext, "__androidx_security_crypto_encrypted_prefs_key_keyset__", str).m("android-keystore://" + str2).f().e();
        C5266Ip3 c5266Ip3E2 = new C20323rp.b().l(eVar.j()).n(applicationContext, "__androidx_security_crypto_encrypted_prefs_value_keyset__", str).m("android-keystore://" + str2).f().e();
        return new SharedPreferencesC15176j82(str, str2, applicationContext.getSharedPreferences(str, 0), (InterfaceC3780Ci) c5266Ip3E2.l(InterfaceC3780Ci.class), (GJ1) c5266Ip3E.l(GJ1.class));
    }

    private Object f(String str) {
        if (g(str)) {
            throw new SecurityException(str + " is a reserved key for the encryption keyset.");
        }
        if (str == null) {
            str = "__NULL__";
        }
        try {
            String strD = d(str);
            String string = this.a.getString(strD, null);
            if (string == null) {
                return null;
            }
            byte[] bArrA = AbstractC12757f90.a(string, 0);
            InterfaceC3780Ci interfaceC3780Ci = this.e;
            Charset charset = StandardCharsets.UTF_8;
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(interfaceC3780Ci.b(bArrA, strD.getBytes(charset)));
            byteBufferWrap.position(0);
            int i = byteBufferWrap.getInt();
            c cVarJ = c.j(i);
            if (cVarJ == null) {
                throw new SecurityException("Unknown type ID for encrypted pref value: " + i);
            }
            switch (a.a[cVarJ.ordinal()]) {
                case 1:
                    int i2 = byteBufferWrap.getInt();
                    ByteBuffer byteBufferSlice = byteBufferWrap.slice();
                    byteBufferWrap.limit(i2);
                    String string2 = charset.decode(byteBufferSlice).toString();
                    if (string2.equals("__NULL__")) {
                        return null;
                    }
                    return string2;
                case 2:
                    return Integer.valueOf(byteBufferWrap.getInt());
                case 3:
                    return Long.valueOf(byteBufferWrap.getLong());
                case 4:
                    return Float.valueOf(byteBufferWrap.getFloat());
                case 5:
                    return Boolean.valueOf(byteBufferWrap.get() != 0);
                case 6:
                    PJ pj = new PJ();
                    while (byteBufferWrap.hasRemaining()) {
                        int i3 = byteBufferWrap.getInt();
                        ByteBuffer byteBufferSlice2 = byteBufferWrap.slice();
                        byteBufferSlice2.limit(i3);
                        byteBufferWrap.position(byteBufferWrap.position() + i3);
                        pj.add(StandardCharsets.UTF_8.decode(byteBufferSlice2).toString());
                    }
                    if (pj.size() == 1 && "__NULL__".equals(pj.B(0))) {
                        return null;
                    }
                    return pj;
                default:
                    throw new SecurityException("Unhandled type for encrypted pref value: " + cVarJ);
            }
        } catch (GeneralSecurityException e2) {
            throw new SecurityException("Could not decrypt value. " + e2.getMessage(), e2);
        }
    }

    String c(String str) {
        try {
            String str2 = new String(this.f.b(AbstractC12757f90.a(str, 0), this.c.getBytes()), StandardCharsets.UTF_8);
            if (str2.equals("__NULL__")) {
                return null;
            }
            return str2;
        } catch (GeneralSecurityException e2) {
            throw new SecurityException("Could not decrypt key. " + e2.getMessage(), e2);
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        if (!g(str)) {
            return this.a.contains(d(str));
        }
        throw new SecurityException(str + " is a reserved key for the encryption keyset.");
    }

    String d(String str) {
        if (str == null) {
            str = "__NULL__";
        }
        try {
            return AbstractC12757f90.d(this.f.a(str.getBytes(StandardCharsets.UTF_8), this.c.getBytes()));
        } catch (GeneralSecurityException e2) {
            throw new SecurityException("Could not encrypt key. " + e2.getMessage(), e2);
        }
    }

    Pair e(String str, byte[] bArr) {
        String strD = d(str);
        return new Pair(strD, AbstractC12757f90.d(this.e.a(bArr, strD.getBytes(StandardCharsets.UTF_8))));
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return new b(this, this.a.edit());
    }

    boolean g(String str) {
        return "__androidx_security_crypto_encrypted_prefs_key_keyset__".equals(str) || "__androidx_security_crypto_encrypted_prefs_value_keyset__".equals(str);
    }

    @Override // android.content.SharedPreferences
    public Map getAll() {
        HashMap map = new HashMap();
        for (Map.Entry<String, ?> entry : this.a.getAll().entrySet()) {
            if (!g(entry.getKey())) {
                String strC = c(entry.getKey());
                map.put(strC, f(strC));
            }
        }
        return map;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        Object objF = f(str);
        return objF instanceof Boolean ? ((Boolean) objF).booleanValue() : z;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        Object objF = f(str);
        return objF instanceof Float ? ((Float) objF).floatValue() : f;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        Object objF = f(str);
        return objF instanceof Integer ? ((Integer) objF).intValue() : i;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        Object objF = f(str);
        return objF instanceof Long ? ((Long) objF).longValue() : j;
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        Object objF = f(str);
        return objF instanceof String ? (String) objF : str2;
    }

    @Override // android.content.SharedPreferences
    public Set getStringSet(String str, Set set) {
        Object objF = f(str);
        Set pj = objF instanceof Set ? (Set) objF : new PJ();
        return pj.size() > 0 ? pj : set;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.b.add(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.b.remove(onSharedPreferenceChangeListener);
    }
}
