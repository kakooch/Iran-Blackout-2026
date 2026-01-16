package com.google.android.exoplayer2.upstream.cache;

import ir.nasim.AbstractC18533op0;
import ir.nasim.C9315Zk1;
import ir.nasim.InterfaceC8806Xk1;
import java.io.File;
import java.io.IOException;
import java.util.NavigableSet;
import java.util.Set;

/* loaded from: classes2.dex */
public interface Cache {

    public static class CacheException extends IOException {
        public CacheException(String str) {
            super(str);
        }

        public CacheException(Throwable th) {
            super(th);
        }

        public CacheException(String str, Throwable th) {
            super(str, th);
        }
    }

    public interface a {
        void a(Cache cache, AbstractC18533op0 abstractC18533op0, AbstractC18533op0 abstractC18533op02);

        void b(Cache cache, AbstractC18533op0 abstractC18533op0);

        void c(Cache cache, AbstractC18533op0 abstractC18533op0);
    }

    File a(String str, long j, long j2);

    InterfaceC8806Xk1 b(String str);

    long c(String str, long j, long j2);

    AbstractC18533op0 d(String str, long j, long j2);

    long e(String str, long j, long j2);

    Set f();

    void g(String str, C9315Zk1 c9315Zk1);

    void h(AbstractC18533op0 abstractC18533op0);

    AbstractC18533op0 i(String str, long j, long j2);

    void j(File file, long j);

    void k(String str);

    NavigableSet l(String str, a aVar);

    NavigableSet m(String str);

    void n(String str, a aVar);
}
