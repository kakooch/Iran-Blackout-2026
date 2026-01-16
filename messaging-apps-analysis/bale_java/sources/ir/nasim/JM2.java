package ir.nasim;

import androidx.fragment.app.Fragment;

/* loaded from: classes4.dex */
public interface JM2 {
    static /* synthetic */ C22042ua0 e(JM2 jm2, int i, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getGroupProfileFragment");
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        return jm2.a(i, z);
    }

    C22042ua0 a(int i, boolean z);

    Fragment b(int i, ZN2 zn2);
}
