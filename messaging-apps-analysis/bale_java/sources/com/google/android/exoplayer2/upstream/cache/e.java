package com.google.android.exoplayer2.upstream.cache;

import ir.nasim.AbstractC18533op0;
import ir.nasim.AbstractC18815pI3;
import ir.nasim.AbstractC20011rK;
import ir.nasim.C9315Zk1;
import ir.nasim.FD1;
import java.io.File;
import java.util.ArrayList;
import java.util.TreeSet;

/* loaded from: classes2.dex */
final class e {
    public final int a;
    public final String b;
    private final TreeSet c;
    private final ArrayList d;
    private FD1 e;

    private static final class a {
        public final long a;
        public final long b;

        public a(long j, long j2) {
            this.a = j;
            this.b = j2;
        }

        public boolean a(long j, long j2) {
            long j3 = this.b;
            if (j3 == -1) {
                return j >= this.a;
            }
            if (j2 == -1) {
                return false;
            }
            long j4 = this.a;
            return j4 <= j && j + j2 <= j4 + j3;
        }

        public boolean b(long j, long j2) {
            long j3 = this.a;
            if (j3 > j) {
                return j2 == -1 || j + j2 > j3;
            }
            long j4 = this.b;
            return j4 == -1 || j3 + j4 > j;
        }
    }

    public e(int i, String str) {
        this(i, str, FD1.c);
    }

    public void a(i iVar) {
        this.c.add(iVar);
    }

    public boolean b(C9315Zk1 c9315Zk1) {
        this.e = this.e.g(c9315Zk1);
        return !r2.equals(r0);
    }

    public long c(long j, long j2) {
        AbstractC20011rK.a(j >= 0);
        AbstractC20011rK.a(j2 >= 0);
        i iVarE = e(j, j2);
        if (iVarE.h()) {
            return -Math.min(iVarE.i() ? Long.MAX_VALUE : iVarE.c, j2);
        }
        long j3 = j + j2;
        long j4 = j3 >= 0 ? j3 : Long.MAX_VALUE;
        long jMax = iVarE.b + iVarE.c;
        if (jMax < j4) {
            for (i iVar : this.c.tailSet(iVarE, false)) {
                long j5 = iVar.b;
                if (j5 > jMax) {
                    break;
                }
                jMax = Math.max(jMax, j5 + iVar.c);
                if (jMax >= j4) {
                    break;
                }
            }
        }
        return Math.min(jMax - j, j2);
    }

    public FD1 d() {
        return this.e;
    }

    public i e(long j, long j2) {
        i iVarR = i.r(this.b, j);
        i iVar = (i) this.c.floor(iVarR);
        if (iVar != null && iVar.b + iVar.c > j) {
            return iVar;
        }
        i iVar2 = (i) this.c.ceiling(iVarR);
        if (iVar2 != null) {
            long j3 = iVar2.b - j;
            j2 = j2 == -1 ? j3 : Math.min(j3, j2);
        }
        return i.q(this.b, j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return this.a == eVar.a && this.b.equals(eVar.b) && this.c.equals(eVar.c) && this.e.equals(eVar.e);
    }

    public TreeSet f() {
        return this.c;
    }

    public boolean g() {
        return this.c.isEmpty();
    }

    public boolean h(long j, long j2) {
        for (int i = 0; i < this.d.size(); i++) {
            if (((a) this.d.get(i)).a(j, j2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.a * 31) + this.b.hashCode()) * 31) + this.e.hashCode();
    }

    public boolean i() {
        return this.d.isEmpty();
    }

    public boolean j(long j, long j2) {
        for (int i = 0; i < this.d.size(); i++) {
            if (((a) this.d.get(i)).b(j, j2)) {
                return false;
            }
        }
        this.d.add(new a(j, j2));
        return true;
    }

    public boolean k(AbstractC18533op0 abstractC18533op0) {
        if (!this.c.remove(abstractC18533op0)) {
            return false;
        }
        File file = abstractC18533op0.e;
        if (file == null) {
            return true;
        }
        file.delete();
        return true;
    }

    public i l(i iVar, long j, boolean z) {
        AbstractC20011rK.g(this.c.remove(iVar));
        File file = (File) AbstractC20011rK.e(iVar.e);
        if (z) {
            File fileS = i.s((File) AbstractC20011rK.e(file.getParentFile()), this.a, iVar.b, j);
            if (file.renameTo(fileS)) {
                file = fileS;
            } else {
                AbstractC18815pI3.k("CachedContent", "Failed to rename " + file + " to " + fileS);
            }
        }
        i iVarJ = iVar.j(file, j);
        this.c.add(iVarJ);
        return iVarJ;
    }

    public void m(long j) {
        for (int i = 0; i < this.d.size(); i++) {
            if (((a) this.d.get(i)).a == j) {
                this.d.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public e(int i, String str, FD1 fd1) {
        this.a = i;
        this.b = str;
        this.e = fd1;
        this.c = new TreeSet();
        this.d = new ArrayList();
    }
}
