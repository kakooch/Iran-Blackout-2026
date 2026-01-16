package ir.nasim;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.nc1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C17813nc1 {
    private final List a = new ArrayList();

    void a(C16837lw7 c16837lw7) {
        this.a.add(c16837lw7);
    }

    public void b(Path path) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            AbstractC16500lN7.b(path, (C16837lw7) this.a.get(size));
        }
    }
}
