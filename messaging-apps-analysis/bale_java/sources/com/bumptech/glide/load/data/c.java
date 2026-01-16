package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.a;
import ir.nasim.LJ;
import ir.nasim.OK5;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class c implements com.bumptech.glide.load.data.a {
    private final OK5 a;

    public static final class a implements a.InterfaceC0146a {
        private final LJ a;

        public a(LJ lj) {
            this.a = lj;
        }

        @Override // com.bumptech.glide.load.data.a.InterfaceC0146a
        public Class a() {
            return InputStream.class;
        }

        @Override // com.bumptech.glide.load.data.a.InterfaceC0146a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.bumptech.glide.load.data.a b(InputStream inputStream) {
            return new c(inputStream, this.a);
        }
    }

    public c(InputStream inputStream, LJ lj) {
        OK5 ok5 = new OK5(inputStream, lj);
        this.a = ok5;
        ok5.mark(5242880);
    }

    public void a() {
        this.a.b();
    }

    @Override // com.bumptech.glide.load.data.a
    public void b() {
        this.a.c();
    }

    @Override // com.bumptech.glide.load.data.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public InputStream c() {
        this.a.reset();
        return this.a;
    }
}
