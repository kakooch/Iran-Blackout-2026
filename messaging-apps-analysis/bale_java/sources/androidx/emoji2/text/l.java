package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import ir.nasim.AbstractC18580ot7;
import ir.nasim.AbstractC4980Hj5;
import ir.nasim.C3276Ae4;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class l {
    private final C3276Ae4 a;
    private final char[] b;
    private final a c = new a(1024);
    private final Typeface d;

    static class a {
        private final SparseArray a;
        private m b;

        private a() {
            this(1);
        }

        a a(int i) {
            SparseArray sparseArray = this.a;
            if (sparseArray == null) {
                return null;
            }
            return (a) sparseArray.get(i);
        }

        final m b() {
            return this.b;
        }

        void c(m mVar, int i, int i2) {
            a aVarA = a(mVar.b(i));
            if (aVarA == null) {
                aVarA = new a();
                this.a.put(mVar.b(i), aVarA);
            }
            if (i2 > i) {
                aVarA.c(mVar, i + 1, i2);
            } else {
                aVarA.b = mVar;
            }
        }

        a(int i) {
            this.a = new SparseArray(i);
        }
    }

    private l(Typeface typeface, C3276Ae4 c3276Ae4) {
        this.d = typeface;
        this.a = c3276Ae4;
        this.b = new char[c3276Ae4.k() * 2];
        a(c3276Ae4);
    }

    private void a(C3276Ae4 c3276Ae4) {
        int iK = c3276Ae4.k();
        for (int i = 0; i < iK; i++) {
            m mVar = new m(this, i);
            Character.toChars(mVar.f(), this.b, i * 2);
            h(mVar);
        }
    }

    public static l b(Typeface typeface, ByteBuffer byteBuffer) {
        try {
            AbstractC18580ot7.a("EmojiCompat.MetadataRepo.create");
            return new l(typeface, k.b(byteBuffer));
        } finally {
            AbstractC18580ot7.b();
        }
    }

    public char[] c() {
        return this.b;
    }

    public C3276Ae4 d() {
        return this.a;
    }

    int e() {
        return this.a.l();
    }

    a f() {
        return this.c;
    }

    Typeface g() {
        return this.d;
    }

    void h(m mVar) {
        AbstractC4980Hj5.h(mVar, "emoji metadata cannot be null");
        AbstractC4980Hj5.b(mVar.c() > 0, "invalid metadata codepoint length");
        this.c.c(mVar, 0, mVar.c() - 1);
    }
}
