package ir.nasim;

import java.io.IOException;
import java.io.StringWriter;

/* renamed from: ir.nasim.vk3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC22735vk3 {
    public boolean A() {
        return this instanceof C8542Wk3;
    }

    public boolean B() {
        return this instanceof C9906al3;
    }

    public boolean f() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double h() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int i() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public C13149fk3 j() {
        if (w()) {
            return (C13149fk3) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public C8542Wk3 o() {
        if (A()) {
            return (C8542Wk3) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public C9906al3 r() {
        if (B()) {
            return (C9906al3) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public long t() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            C22155ul3 c22155ul3 = new C22155ul3(stringWriter);
            c22155ul3.D(true);
            AbstractC19553qY6.b(this, c22155ul3);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public String v() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean w() {
        return this instanceof C13149fk3;
    }

    public boolean x() {
        return this instanceof C8074Uk3;
    }
}
