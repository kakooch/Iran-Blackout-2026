package ir.nasim;

import java.io.InputStream;

/* loaded from: classes5.dex */
public final class GL3 extends DL3 {
    public GL3(InputStream inputStream) {
        super(new C8526Wi5(inputStream), null, "");
    }

    public CL3 h(String str) {
        CL3 cl3F;
        do {
            cl3F = f();
        } while (!cl3F.e().matches(str));
        return cl3F;
    }

    public String toString() {
        return "mp4[pos=" + d() + "]";
    }
}
