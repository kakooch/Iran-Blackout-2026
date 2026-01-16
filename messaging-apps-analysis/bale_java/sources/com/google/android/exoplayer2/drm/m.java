package com.google.android.exoplayer2.drm;

import ir.nasim.C15493jg5;
import ir.nasim.InterfaceC7698Sv1;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes2.dex */
public interface m {

    public static final class a {
        private final byte[] a;
        private final String b;
        private final int c;

        public a(byte[] bArr, String str, int i) {
            this.a = bArr;
            this.b = str;
            this.c = i;
        }

        public byte[] a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }
    }

    public interface b {
        void a(m mVar, byte[] bArr, int i, int i2, byte[] bArr2);
    }

    public interface c {
        m a(UUID uuid);
    }

    public static final class d {
        private final byte[] a;
        private final String b;

        public d(byte[] bArr, String str) {
            this.a = bArr;
            this.b = str;
        }

        public byte[] a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }
    }

    Map a(byte[] bArr);

    d b();

    byte[] c();

    void d(byte[] bArr, byte[] bArr2);

    void e(b bVar);

    void f(byte[] bArr);

    int g();

    InterfaceC7698Sv1 i(byte[] bArr);

    boolean j(byte[] bArr, String str);

    void k(byte[] bArr);

    byte[] l(byte[] bArr, byte[] bArr2);

    a m(byte[] bArr, List list, int i, HashMap map);

    void release();

    default void h(byte[] bArr, C15493jg5 c15493jg5) {
    }
}
