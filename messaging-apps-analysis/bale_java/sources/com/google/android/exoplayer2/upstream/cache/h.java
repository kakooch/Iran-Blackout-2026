package com.google.android.exoplayer2.upstream.cache;

import android.database.SQLException;
import android.os.ConditionVariable;
import com.google.android.exoplayer2.upstream.cache.Cache;
import ir.nasim.AbstractC18533op0;
import ir.nasim.AbstractC18815pI3;
import ir.nasim.AbstractC20011rK;
import ir.nasim.C9315Zk1;
import ir.nasim.InterfaceC13995hA1;
import ir.nasim.InterfaceC8806Xk1;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: classes2.dex */
public final class h implements Cache {
    private static final HashSet l = new HashSet();
    private final File a;
    private final b b;
    private final f c;
    private final d d;
    private final HashMap e;
    private final Random f;
    private final boolean g;
    private long h;
    private long i;
    private boolean j;
    private Cache.CacheException k;

    class a extends Thread {
        final /* synthetic */ ConditionVariable a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, ConditionVariable conditionVariable) {
            super(str);
            this.a = conditionVariable;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            synchronized (h.this) {
                this.a.open();
                h.this.v();
                h.this.b.f();
            }
        }
    }

    public h(File file, b bVar, InterfaceC13995hA1 interfaceC13995hA1) {
        this(file, bVar, interfaceC13995hA1, null, false, false);
    }

    private void A(AbstractC18533op0 abstractC18533op0) {
        ArrayList arrayList = (ArrayList) this.e.get(abstractC18533op0.a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.a) arrayList.get(size)).c(this, abstractC18533op0);
            }
        }
        this.b.c(this, abstractC18533op0);
    }

    private void B(i iVar, AbstractC18533op0 abstractC18533op0) {
        ArrayList arrayList = (ArrayList) this.e.get(iVar.a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.a) arrayList.get(size)).a(this, iVar, abstractC18533op0);
            }
        }
        this.b.a(this, iVar, abstractC18533op0);
    }

    private static long C(String str) {
        return Long.parseLong(str.substring(0, str.indexOf(46)), 16);
    }

    private void D(AbstractC18533op0 abstractC18533op0) {
        e eVarG = this.c.g(abstractC18533op0.a);
        if (eVarG == null || !eVarG.k(abstractC18533op0)) {
            return;
        }
        this.i -= abstractC18533op0.c;
        if (this.d != null) {
            String name = abstractC18533op0.e.getName();
            try {
                this.d.f(name);
            } catch (IOException unused) {
                AbstractC18815pI3.k("SimpleCache", "Failed to remove file index entry for: " + name);
            }
        }
        this.c.q(eVarG.b);
        A(abstractC18533op0);
    }

    private void E() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.c.h().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((e) it.next()).f().iterator();
            while (it2.hasNext()) {
                AbstractC18533op0 abstractC18533op0 = (AbstractC18533op0) it2.next();
                if (abstractC18533op0.e.length() != abstractC18533op0.c) {
                    arrayList.add(abstractC18533op0);
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            D((AbstractC18533op0) arrayList.get(i));
        }
    }

    private i F(String str, i iVar) throws SQLException {
        boolean z;
        if (!this.g) {
            return iVar;
        }
        String name = ((File) AbstractC20011rK.e(iVar.e)).getName();
        long j = iVar.c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        d dVar = this.d;
        if (dVar != null) {
            try {
                dVar.h(name, j, jCurrentTimeMillis);
            } catch (IOException unused) {
                AbstractC18815pI3.k("SimpleCache", "Failed to update index with new touch timestamp.");
            }
            z = false;
        } else {
            z = true;
        }
        i iVarL = this.c.g(str).l(iVar, jCurrentTimeMillis, z);
        B(iVar, iVarL);
        return iVarL;
    }

    private void q(i iVar) {
        this.c.n(iVar.a).a(iVar);
        this.i += iVar.c;
        z(iVar);
    }

    private static void s(File file) throws Cache.CacheException {
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        String str = "Failed to create cache directory: " + file;
        AbstractC18815pI3.c("SimpleCache", str);
        throw new Cache.CacheException(str);
    }

    private static long t(File file) throws IOException {
        long jNextLong = new SecureRandom().nextLong();
        long jAbs = jNextLong == Long.MIN_VALUE ? 0L : Math.abs(jNextLong);
        File file2 = new File(file, Long.toString(jAbs, 16) + ".uid");
        if (file2.createNewFile()) {
            return jAbs;
        }
        throw new IOException("Failed to create UID file: " + file2);
    }

    private i u(String str, long j, long j2) {
        i iVarE;
        e eVarG = this.c.g(str);
        if (eVarG == null) {
            return i.q(str, j, j2);
        }
        while (true) {
            iVarE = eVarG.e(j, j2);
            if (!iVarE.d || iVarE.e.length() == iVarE.c) {
                break;
            }
            E();
        }
        return iVarE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (!this.a.exists()) {
            try {
                s(this.a);
            } catch (Cache.CacheException e) {
                this.k = e;
                return;
            }
        }
        File[] fileArrListFiles = this.a.listFiles();
        if (fileArrListFiles == null) {
            String str = "Failed to list cache directory files: " + this.a;
            AbstractC18815pI3.c("SimpleCache", str);
            this.k = new Cache.CacheException(str);
            return;
        }
        long jX = x(fileArrListFiles);
        this.h = jX;
        if (jX == -1) {
            try {
                this.h = t(this.a);
            } catch (IOException e2) {
                String str2 = "Failed to create cache UID: " + this.a;
                AbstractC18815pI3.d("SimpleCache", str2, e2);
                this.k = new Cache.CacheException(str2, e2);
                return;
            }
        }
        try {
            this.c.o(this.h);
            d dVar = this.d;
            if (dVar != null) {
                dVar.e(this.h);
                Map mapB = this.d.b();
                w(this.a, true, fileArrListFiles, mapB);
                this.d.g(mapB.keySet());
            } else {
                w(this.a, true, fileArrListFiles, null);
            }
            this.c.s();
            try {
                this.c.t();
            } catch (IOException e3) {
                AbstractC18815pI3.d("SimpleCache", "Storing index file failed", e3);
            }
        } catch (IOException e4) {
            String str3 = "Failed to initialize cache indices: " + this.a;
            AbstractC18815pI3.d("SimpleCache", str3, e4);
            this.k = new Cache.CacheException(str3, e4);
        }
    }

    private void w(File file, boolean z, File[] fileArr, Map map) {
        long j;
        long j2;
        if (fileArr == null || fileArr.length == 0) {
            if (z) {
                return;
            }
            file.delete();
            return;
        }
        for (File file2 : fileArr) {
            String name = file2.getName();
            if (z && name.indexOf(46) == -1) {
                w(file2, false, file2.listFiles(), map);
            } else if (!z || (!f.p(name) && !name.endsWith(".uid"))) {
                c cVar = map != null ? (c) map.remove(name) : null;
                if (cVar != null) {
                    j2 = cVar.a;
                    j = cVar.b;
                } else {
                    j = -9223372036854775807L;
                    j2 = -1;
                }
                i iVarO = i.o(file2, j2, j, this.c);
                if (iVarO != null) {
                    q(iVarO);
                } else {
                    file2.delete();
                }
            }
        }
    }

    private static long x(File[] fileArr) {
        int length = fileArr.length;
        for (int i = 0; i < length; i++) {
            File file = fileArr[i];
            String name = file.getName();
            if (name.endsWith(".uid")) {
                try {
                    return C(name);
                } catch (NumberFormatException unused) {
                    AbstractC18815pI3.c("SimpleCache", "Malformed UID file: " + file);
                    file.delete();
                }
            }
        }
        return -1L;
    }

    private static synchronized boolean y(File file) {
        return l.add(file.getAbsoluteFile());
    }

    private void z(i iVar) {
        ArrayList arrayList = (ArrayList) this.e.get(iVar.a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.a) arrayList.get(size)).b(this, iVar);
            }
        }
        this.b.b(this, iVar);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized File a(String str, long j, long j2) {
        e eVarG;
        File file;
        try {
            AbstractC20011rK.g(!this.j);
            r();
            eVarG = this.c.g(str);
            AbstractC20011rK.e(eVarG);
            AbstractC20011rK.g(eVarG.h(j, j2));
            if (!this.a.exists()) {
                s(this.a);
                E();
            }
            this.b.e(this, str, j, j2);
            file = new File(this.a, Integer.toString(this.f.nextInt(10)));
            if (!file.exists()) {
                s(file);
            }
        } catch (Throwable th) {
            throw th;
        }
        return i.s(file, eVarG.a, j, System.currentTimeMillis());
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized InterfaceC8806Xk1 b(String str) {
        AbstractC20011rK.g(!this.j);
        return this.c.j(str);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long c(String str, long j, long j2) {
        long j3;
        long j4 = j2 == -1 ? Long.MAX_VALUE : j + j2;
        long j5 = j4 < 0 ? Long.MAX_VALUE : j4;
        long j6 = j;
        j3 = 0;
        while (j6 < j5) {
            long jE = e(str, j6, j5 - j6);
            if (jE > 0) {
                j3 += jE;
            } else {
                jE = -jE;
            }
            j6 += jE;
        }
        return j3;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized AbstractC18533op0 d(String str, long j, long j2) {
        AbstractC20011rK.g(!this.j);
        r();
        i iVarU = u(str, j, j2);
        if (iVarU.d) {
            return F(str, iVarU);
        }
        if (this.c.n(str).j(j, iVarU.c)) {
            return iVarU;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long e(String str, long j, long j2) {
        e eVarG;
        AbstractC20011rK.g(!this.j);
        if (j2 == -1) {
            j2 = Long.MAX_VALUE;
        }
        eVarG = this.c.g(str);
        return eVarG != null ? eVarG.c(j, j2) : -j2;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized Set f() {
        AbstractC20011rK.g(!this.j);
        return new HashSet(this.c.l());
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void g(String str, C9315Zk1 c9315Zk1) {
        AbstractC20011rK.g(!this.j);
        r();
        this.c.e(str, c9315Zk1);
        try {
            this.c.t();
        } catch (IOException e) {
            throw new Cache.CacheException(e);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void h(AbstractC18533op0 abstractC18533op0) {
        AbstractC20011rK.g(!this.j);
        e eVar = (e) AbstractC20011rK.e(this.c.g(abstractC18533op0.a));
        eVar.m(abstractC18533op0.b);
        this.c.q(eVar.b);
        notifyAll();
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized AbstractC18533op0 i(String str, long j, long j2) {
        AbstractC18533op0 abstractC18533op0D;
        AbstractC20011rK.g(!this.j);
        r();
        while (true) {
            abstractC18533op0D = d(str, j, j2);
            if (abstractC18533op0D == null) {
                wait();
            }
        }
        return abstractC18533op0D;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void j(File file, long j) {
        AbstractC20011rK.g(!this.j);
        if (file.exists()) {
            if (j == 0) {
                file.delete();
                return;
            }
            i iVar = (i) AbstractC20011rK.e(i.p(file, j, this.c));
            e eVar = (e) AbstractC20011rK.e(this.c.g(iVar.a));
            AbstractC20011rK.g(eVar.h(iVar.b, iVar.c));
            long jA = InterfaceC8806Xk1.a(eVar.d());
            if (jA != -1) {
                AbstractC20011rK.g(iVar.b + iVar.c <= jA);
            }
            if (this.d == null) {
                q(iVar);
                this.c.t();
                notifyAll();
                return;
            }
            try {
                this.d.h(file.getName(), iVar.c, iVar.f);
                q(iVar);
                try {
                    this.c.t();
                    notifyAll();
                    return;
                } catch (IOException e) {
                    throw new Cache.CacheException(e);
                }
            } catch (IOException e2) {
                throw new Cache.CacheException(e2);
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void k(String str) {
        AbstractC20011rK.g(!this.j);
        Iterator it = m(str).iterator();
        while (it.hasNext()) {
            D((AbstractC18533op0) it.next());
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized NavigableSet l(String str, Cache.a aVar) {
        try {
            AbstractC20011rK.g(!this.j);
            AbstractC20011rK.e(str);
            AbstractC20011rK.e(aVar);
            ArrayList arrayList = (ArrayList) this.e.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.e.put(str, arrayList);
            }
            arrayList.add(aVar);
        } catch (Throwable th) {
            throw th;
        }
        return m(str);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized NavigableSet m(String str) {
        e eVarG;
        try {
            AbstractC20011rK.g(!this.j);
            eVarG = this.c.g(str);
        } catch (Throwable th) {
            throw th;
        }
        return (eVarG == null || eVarG.g()) ? new TreeSet() : new TreeSet((Collection) eVarG.f());
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void n(String str, Cache.a aVar) {
        if (this.j) {
            return;
        }
        ArrayList arrayList = (ArrayList) this.e.get(str);
        if (arrayList != null) {
            arrayList.remove(aVar);
            if (arrayList.isEmpty()) {
                this.e.remove(str);
            }
        }
    }

    public synchronized void r() {
        Cache.CacheException cacheException = this.k;
        if (cacheException != null) {
            throw cacheException;
        }
    }

    public h(File file, b bVar, InterfaceC13995hA1 interfaceC13995hA1, byte[] bArr, boolean z, boolean z2) {
        this(file, bVar, new f(interfaceC13995hA1, file, bArr, z, z2), (interfaceC13995hA1 == null || z2) ? null : new d(interfaceC13995hA1));
    }

    h(File file, b bVar, f fVar, d dVar) {
        if (y(file)) {
            this.a = file;
            this.b = bVar;
            this.c = fVar;
            this.d = dVar;
            this.e = new HashMap();
            this.f = new Random();
            this.g = bVar.d();
            this.h = -1L;
            ConditionVariable conditionVariable = new ConditionVariable();
            new a("ExoPlayer:SimpleCacheInit", conditionVariable).start();
            conditionVariable.block();
            return;
        }
        throw new IllegalStateException("Another SimpleCache instance uses the folder: " + file);
    }
}
