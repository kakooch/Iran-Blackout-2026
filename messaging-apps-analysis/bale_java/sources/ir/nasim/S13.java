package ir.nasim;

import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class S13 {
    private final List a = new ArrayList();

    public synchronized void a(ImageHeaderParser imageHeaderParser) {
        this.a.add(imageHeaderParser);
    }

    public synchronized List b() {
        return this.a;
    }
}
