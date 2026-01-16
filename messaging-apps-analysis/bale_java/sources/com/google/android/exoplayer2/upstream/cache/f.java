package com.google.android.exoplayer2.upstream.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.gov.nist.core.Separators;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.database.DatabaseIOException;
import ir.nasim.AbstractC12345eS7;
import ir.nasim.AbstractC14535i43;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C9315Zk1;
import ir.nasim.DB7;
import ir.nasim.FD1;
import ir.nasim.InterfaceC13995hA1;
import ir.nasim.InterfaceC8806Xk1;
import ir.nasim.OL;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
class f {
    private final HashMap a;
    private final SparseArray b;
    private final SparseBooleanArray c;
    private final SparseBooleanArray d;
    private c e;
    private c f;

    private static final class a implements c {
        private static final String[] e = {"id", "key", "metadata"};
        private final InterfaceC13995hA1 a;
        private final SparseArray b = new SparseArray();
        private String c;
        private String d;

        public a(InterfaceC13995hA1 interfaceC13995hA1) {
            this.a = interfaceC13995hA1;
        }

        private void h(SQLiteDatabase sQLiteDatabase, e eVar) throws IOException, SQLException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            f.u(eVar.d(), new DataOutputStream(byteArrayOutputStream));
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Integer.valueOf(eVar.a));
            contentValues.put("key", eVar.b);
            contentValues.put("metadata", byteArray);
            sQLiteDatabase.replaceOrThrow((String) AbstractC20011rK.e(this.d), null, contentValues);
        }

        private static void i(InterfaceC13995hA1 interfaceC13995hA1, String str) throws DatabaseIOException {
            try {
                String strM = m(str);
                SQLiteDatabase sQLiteDatabaseE = interfaceC13995hA1.E();
                sQLiteDatabaseE.beginTransactionNonExclusive();
                try {
                    AbstractC12345eS7.c(sQLiteDatabaseE, 1, str);
                    k(sQLiteDatabaseE, strM);
                    sQLiteDatabaseE.setTransactionSuccessful();
                } finally {
                    sQLiteDatabaseE.endTransaction();
                }
            } catch (SQLException e2) {
                throw new DatabaseIOException(e2);
            }
        }

        private void j(SQLiteDatabase sQLiteDatabase, int i) {
            sQLiteDatabase.delete((String) AbstractC20011rK.e(this.d), "id = ?", new String[]{Integer.toString(i)});
        }

        private static void k(SQLiteDatabase sQLiteDatabase, String str) throws SQLException {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        }

        private Cursor l() {
            return this.a.F().query((String) AbstractC20011rK.e(this.d), e, null, null, null, null, null);
        }

        private static String m(String str) {
            return "ExoPlayerCacheIndex" + str;
        }

        private void n(SQLiteDatabase sQLiteDatabase) throws SQLException, DatabaseIOException {
            AbstractC12345eS7.d(sQLiteDatabase, 1, (String) AbstractC20011rK.e(this.c), 1);
            k(sQLiteDatabase, (String) AbstractC20011rK.e(this.d));
            sQLiteDatabase.execSQL("CREATE TABLE " + this.d + Separators.SP + "(id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)");
        }

        @Override // com.google.android.exoplayer2.upstream.cache.f.c
        public void a(e eVar, boolean z) {
            if (z) {
                this.b.delete(eVar.a);
            } else {
                this.b.put(eVar.a, null);
            }
        }

        @Override // com.google.android.exoplayer2.upstream.cache.f.c
        public boolean b() {
            return AbstractC12345eS7.b(this.a.F(), 1, (String) AbstractC20011rK.e(this.c)) != -1;
        }

        @Override // com.google.android.exoplayer2.upstream.cache.f.c
        public void c(HashMap map) throws DatabaseIOException {
            if (this.b.size() == 0) {
                return;
            }
            try {
                SQLiteDatabase sQLiteDatabaseE = this.a.E();
                sQLiteDatabaseE.beginTransactionNonExclusive();
                for (int i = 0; i < this.b.size(); i++) {
                    try {
                        e eVar = (e) this.b.valueAt(i);
                        if (eVar == null) {
                            j(sQLiteDatabaseE, this.b.keyAt(i));
                        } else {
                            h(sQLiteDatabaseE, eVar);
                        }
                    } catch (Throwable th) {
                        sQLiteDatabaseE.endTransaction();
                        throw th;
                    }
                }
                sQLiteDatabaseE.setTransactionSuccessful();
                this.b.clear();
                sQLiteDatabaseE.endTransaction();
            } catch (SQLException e2) {
                throw new DatabaseIOException(e2);
            }
        }

        @Override // com.google.android.exoplayer2.upstream.cache.f.c
        public void d(long j) {
            String hexString = Long.toHexString(j);
            this.c = hexString;
            this.d = m(hexString);
        }

        @Override // com.google.android.exoplayer2.upstream.cache.f.c
        public void delete() throws DatabaseIOException {
            i(this.a, (String) AbstractC20011rK.e(this.c));
        }

        @Override // com.google.android.exoplayer2.upstream.cache.f.c
        public void e(HashMap map) throws DatabaseIOException {
            try {
                SQLiteDatabase sQLiteDatabaseE = this.a.E();
                sQLiteDatabaseE.beginTransactionNonExclusive();
                try {
                    n(sQLiteDatabaseE);
                    Iterator it = map.values().iterator();
                    while (it.hasNext()) {
                        h(sQLiteDatabaseE, (e) it.next());
                    }
                    sQLiteDatabaseE.setTransactionSuccessful();
                    this.b.clear();
                    sQLiteDatabaseE.endTransaction();
                } catch (Throwable th) {
                    sQLiteDatabaseE.endTransaction();
                    throw th;
                }
            } catch (SQLException e2) {
                throw new DatabaseIOException(e2);
            }
        }

        @Override // com.google.android.exoplayer2.upstream.cache.f.c
        public void f(e eVar) {
            this.b.put(eVar.a, eVar);
        }

        @Override // com.google.android.exoplayer2.upstream.cache.f.c
        public void g(HashMap map, SparseArray sparseArray) throws DatabaseIOException {
            AbstractC20011rK.g(this.b.size() == 0);
            try {
                if (AbstractC12345eS7.b(this.a.F(), 1, (String) AbstractC20011rK.e(this.c)) != 1) {
                    SQLiteDatabase sQLiteDatabaseE = this.a.E();
                    sQLiteDatabaseE.beginTransactionNonExclusive();
                    try {
                        n(sQLiteDatabaseE);
                        sQLiteDatabaseE.setTransactionSuccessful();
                        sQLiteDatabaseE.endTransaction();
                    } catch (Throwable th) {
                        sQLiteDatabaseE.endTransaction();
                        throw th;
                    }
                }
                Cursor cursorL = l();
                while (cursorL.moveToNext()) {
                    try {
                        e eVar = new e(cursorL.getInt(0), (String) AbstractC20011rK.e(cursorL.getString(1)), f.r(new DataInputStream(new ByteArrayInputStream(cursorL.getBlob(2)))));
                        map.put(eVar.b, eVar);
                        sparseArray.put(eVar.a, eVar.b);
                    } finally {
                    }
                }
                cursorL.close();
            } catch (SQLiteException e2) {
                map.clear();
                sparseArray.clear();
                throw new DatabaseIOException(e2);
            }
        }
    }

    private static class b implements c {
        private final boolean a;
        private final Cipher b;
        private final SecretKeySpec c;
        private final SecureRandom d;
        private final OL e;
        private boolean f;
        private g g;

        public b(File file, byte[] bArr, boolean z) {
            Cipher cipherI;
            SecretKeySpec secretKeySpec;
            AbstractC20011rK.g((bArr == null && z) ? false : true);
            if (bArr != null) {
                AbstractC20011rK.a(bArr.length == 16);
                try {
                    cipherI = f.i();
                    secretKeySpec = new SecretKeySpec(bArr, "AES");
                } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
                    throw new IllegalStateException(e);
                }
            } else {
                AbstractC20011rK.a(!z);
                cipherI = null;
                secretKeySpec = null;
            }
            this.a = z;
            this.b = cipherI;
            this.c = secretKeySpec;
            this.d = z ? new SecureRandom() : null;
            this.e = new OL(file);
        }

        private int h(e eVar, int i) {
            int i2;
            int iHashCode;
            int iHashCode2 = (eVar.a * 31) + eVar.b.hashCode();
            if (i < 2) {
                long jA = InterfaceC8806Xk1.a(eVar.d());
                i2 = iHashCode2 * 31;
                iHashCode = (int) (jA ^ (jA >>> 32));
            } else {
                i2 = iHashCode2 * 31;
                iHashCode = eVar.d().hashCode();
            }
            return i2 + iHashCode;
        }

        private e i(int i, DataInputStream dataInputStream) throws IOException {
            FD1 fd1R;
            int i2 = dataInputStream.readInt();
            String utf = dataInputStream.readUTF();
            if (i < 2) {
                long j = dataInputStream.readLong();
                C9315Zk1 c9315Zk1 = new C9315Zk1();
                C9315Zk1.g(c9315Zk1, j);
                fd1R = FD1.c.g(c9315Zk1);
            } else {
                fd1R = f.r(dataInputStream);
            }
            return new e(i2, utf, fd1R);
        }

        private boolean j(HashMap map, SparseArray sparseArray) throws Throwable {
            BufferedInputStream bufferedInputStream;
            DataInputStream dataInputStream;
            if (!this.e.c()) {
                return true;
            }
            DataInputStream dataInputStream2 = null;
            try {
                bufferedInputStream = new BufferedInputStream(this.e.d());
                dataInputStream = new DataInputStream(bufferedInputStream);
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                int i = dataInputStream.readInt();
                if (i >= 0 && i <= 2) {
                    if ((dataInputStream.readInt() & 1) != 0) {
                        if (this.b == null) {
                            AbstractC9683aN7.m(dataInputStream);
                            return false;
                        }
                        byte[] bArr = new byte[16];
                        dataInputStream.readFully(bArr);
                        try {
                            this.b.init(2, (Key) AbstractC9683aN7.j(this.c), new IvParameterSpec(bArr));
                            dataInputStream = new DataInputStream(new CipherInputStream(bufferedInputStream, this.b));
                        } catch (InvalidAlgorithmParameterException e) {
                            e = e;
                            throw new IllegalStateException(e);
                        } catch (InvalidKeyException e2) {
                            e = e2;
                            throw new IllegalStateException(e);
                        }
                    } else if (this.a) {
                        this.f = true;
                    }
                    int i2 = dataInputStream.readInt();
                    int iH = 0;
                    for (int i3 = 0; i3 < i2; i3++) {
                        e eVarI = i(i, dataInputStream);
                        map.put(eVarI.b, eVarI);
                        sparseArray.put(eVarI.a, eVarI.b);
                        iH += h(eVarI, i);
                    }
                    int i4 = dataInputStream.readInt();
                    boolean z = dataInputStream.read() == -1;
                    if (i4 == iH && z) {
                        AbstractC9683aN7.m(dataInputStream);
                        return true;
                    }
                    AbstractC9683aN7.m(dataInputStream);
                    return false;
                }
                AbstractC9683aN7.m(dataInputStream);
                return false;
            } catch (IOException unused2) {
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    AbstractC9683aN7.m(dataInputStream2);
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    AbstractC9683aN7.m(dataInputStream2);
                }
                throw th;
            }
        }

        private void k(e eVar, DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeInt(eVar.a);
            dataOutputStream.writeUTF(eVar.b);
            f.u(eVar.d(), dataOutputStream);
        }

        private void l(HashMap map) throws Throwable {
            g gVar;
            DataOutputStream dataOutputStream;
            Closeable closeable = null;
            try {
                OutputStream outputStreamF = this.e.f();
                g gVar2 = this.g;
                if (gVar2 == null) {
                    this.g = new g(outputStreamF);
                } else {
                    gVar2.a(outputStreamF);
                }
                gVar = this.g;
                dataOutputStream = new DataOutputStream(gVar);
            } catch (Throwable th) {
                th = th;
            }
            try {
                dataOutputStream.writeInt(2);
                int iH = 0;
                dataOutputStream.writeInt(this.a ? 1 : 0);
                if (this.a) {
                    byte[] bArr = new byte[16];
                    ((SecureRandom) AbstractC9683aN7.j(this.d)).nextBytes(bArr);
                    dataOutputStream.write(bArr);
                    try {
                        ((Cipher) AbstractC9683aN7.j(this.b)).init(1, (Key) AbstractC9683aN7.j(this.c), new IvParameterSpec(bArr));
                        dataOutputStream.flush();
                        dataOutputStream = new DataOutputStream(new CipherOutputStream(gVar, this.b));
                    } catch (InvalidAlgorithmParameterException e) {
                        e = e;
                        throw new IllegalStateException(e);
                    } catch (InvalidKeyException e2) {
                        e = e2;
                        throw new IllegalStateException(e);
                    }
                }
                dataOutputStream.writeInt(map.size());
                for (e eVar : map.values()) {
                    k(eVar, dataOutputStream);
                    iH += h(eVar, 2);
                }
                dataOutputStream.writeInt(iH);
                this.e.b(dataOutputStream);
                AbstractC9683aN7.m(null);
            } catch (Throwable th2) {
                th = th2;
                closeable = dataOutputStream;
                AbstractC9683aN7.m(closeable);
                throw th;
            }
        }

        @Override // com.google.android.exoplayer2.upstream.cache.f.c
        public void a(e eVar, boolean z) {
            this.f = true;
        }

        @Override // com.google.android.exoplayer2.upstream.cache.f.c
        public boolean b() {
            return this.e.c();
        }

        @Override // com.google.android.exoplayer2.upstream.cache.f.c
        public void c(HashMap map) throws Throwable {
            if (this.f) {
                e(map);
            }
        }

        @Override // com.google.android.exoplayer2.upstream.cache.f.c
        public void d(long j) {
        }

        @Override // com.google.android.exoplayer2.upstream.cache.f.c
        public void delete() {
            this.e.a();
        }

        @Override // com.google.android.exoplayer2.upstream.cache.f.c
        public void e(HashMap map) throws Throwable {
            l(map);
            this.f = false;
        }

        @Override // com.google.android.exoplayer2.upstream.cache.f.c
        public void f(e eVar) {
            this.f = true;
        }

        @Override // com.google.android.exoplayer2.upstream.cache.f.c
        public void g(HashMap map, SparseArray sparseArray) {
            AbstractC20011rK.g(!this.f);
            if (j(map, sparseArray)) {
                return;
            }
            map.clear();
            sparseArray.clear();
            this.e.a();
        }
    }

    private interface c {
        void a(e eVar, boolean z);

        boolean b();

        void c(HashMap map);

        void d(long j);

        void delete();

        void e(HashMap map);

        void f(e eVar);

        void g(HashMap map, SparseArray sparseArray);
    }

    public f(InterfaceC13995hA1 interfaceC13995hA1, File file, byte[] bArr, boolean z, boolean z2) {
        AbstractC20011rK.g((interfaceC13995hA1 == null && file == null) ? false : true);
        this.a = new HashMap();
        this.b = new SparseArray();
        this.c = new SparseBooleanArray();
        this.d = new SparseBooleanArray();
        a aVar = interfaceC13995hA1 != null ? new a(interfaceC13995hA1) : null;
        b bVar = file != null ? new b(new File(file, "cached_content_index.exi"), bArr, z) : null;
        if (aVar == null || (bVar != null && z2)) {
            this.e = (c) AbstractC9683aN7.j(bVar);
            this.f = aVar;
        } else {
            this.e = aVar;
            this.f = bVar;
        }
    }

    private e d(String str) {
        int iM = m(this.b);
        e eVar = new e(iM, str);
        this.a.put(str, eVar);
        this.b.put(iM, str);
        this.d.put(iM, true);
        this.e.f(eVar);
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Cipher i() {
        if (AbstractC9683aN7.a == 18) {
            try {
                return Cipher.getInstance("AES/CBC/PKCS5PADDING", "BC");
            } catch (Throwable unused) {
            }
        }
        return Cipher.getInstance("AES/CBC/PKCS5PADDING");
    }

    static int m(SparseArray sparseArray) {
        int size = sparseArray.size();
        int i = 0;
        int iKeyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (iKeyAt >= 0) {
            return iKeyAt;
        }
        while (i < size && i == sparseArray.keyAt(i)) {
            i++;
        }
        return i;
    }

    public static boolean p(String str) {
        return str.startsWith("cached_content_index.exi");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static FD1 r(DataInputStream dataInputStream) throws IOException {
        int i = dataInputStream.readInt();
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < i; i2++) {
            String utf = dataInputStream.readUTF();
            int i3 = dataInputStream.readInt();
            if (i3 < 0) {
                throw new IOException("Invalid value size: " + i3);
            }
            int iMin = Math.min(i3, 10485760);
            byte[] bArrCopyOf = AbstractC9683aN7.f;
            int i4 = 0;
            while (i4 != i3) {
                int i5 = i4 + iMin;
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, i5);
                dataInputStream.readFully(bArrCopyOf, i4, iMin);
                iMin = Math.min(i3 - i5, 10485760);
                i4 = i5;
            }
            map.put(utf, bArrCopyOf);
        }
        return new FD1(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void u(FD1 fd1, DataOutputStream dataOutputStream) throws IOException {
        Set<Map.Entry> setH = fd1.h();
        dataOutputStream.writeInt(setH.size());
        for (Map.Entry entry : setH) {
            dataOutputStream.writeUTF((String) entry.getKey());
            byte[] bArr = (byte[]) entry.getValue();
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
        }
    }

    public void e(String str, C9315Zk1 c9315Zk1) {
        e eVarN = n(str);
        if (eVarN.b(c9315Zk1)) {
            this.e.f(eVarN);
        }
    }

    public int f(String str) {
        return n(str).a;
    }

    public e g(String str) {
        return (e) this.a.get(str);
    }

    public Collection h() {
        return Collections.unmodifiableCollection(this.a.values());
    }

    public InterfaceC8806Xk1 j(String str) {
        e eVarG = g(str);
        return eVarG != null ? eVarG.d() : FD1.c;
    }

    public String k(int i) {
        return (String) this.b.get(i);
    }

    public Set l() {
        return this.a.keySet();
    }

    public e n(String str) {
        e eVar = (e) this.a.get(str);
        return eVar == null ? d(str) : eVar;
    }

    public void o(long j) {
        c cVar;
        this.e.d(j);
        c cVar2 = this.f;
        if (cVar2 != null) {
            cVar2.d(j);
        }
        if (this.e.b() || (cVar = this.f) == null || !cVar.b()) {
            this.e.g(this.a, this.b);
        } else {
            this.f.g(this.a, this.b);
            this.e.e(this.a);
        }
        c cVar3 = this.f;
        if (cVar3 != null) {
            cVar3.delete();
            this.f = null;
        }
    }

    public void q(String str) {
        e eVar = (e) this.a.get(str);
        if (eVar != null && eVar.g() && eVar.i()) {
            this.a.remove(str);
            int i = eVar.a;
            boolean z = this.d.get(i);
            this.e.a(eVar, z);
            if (z) {
                this.b.remove(i);
                this.d.delete(i);
            } else {
                this.b.put(i, null);
                this.c.put(i, true);
            }
        }
    }

    public void s() {
        DB7 it = AbstractC14535i43.P(this.a.keySet()).iterator();
        while (it.hasNext()) {
            q((String) it.next());
        }
    }

    public void t() {
        this.e.c(this.a);
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            this.b.remove(this.c.keyAt(i));
        }
        this.c.clear();
        this.d.clear();
    }
}
