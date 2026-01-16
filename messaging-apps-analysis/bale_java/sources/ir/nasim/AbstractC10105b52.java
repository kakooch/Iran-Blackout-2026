package ir.nasim;

import android.view.inputmethod.EditorInfo;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C14383hp3;
import ir.nasim.C22785vp3;
import ir.nasim.S33;

/* renamed from: ir.nasim.b52, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC10105b52 {
    private static final boolean a(int i, int i2) {
        return (i & i2) == i2;
    }

    public static final void b(EditorInfo editorInfo, CharSequence charSequence, long j, T33 t33, String[] strArr) {
        int iE = t33.e();
        S33.a aVar = S33.b;
        int i = 3;
        int i2 = 6;
        if (S33.m(iE, aVar.a())) {
            if (!t33.h()) {
                i2 = 0;
            }
        } else if (S33.m(iE, aVar.e())) {
            i2 = 1;
        } else if (S33.m(iE, aVar.c())) {
            i2 = 2;
        } else if (S33.m(iE, aVar.d())) {
            i2 = 5;
        } else if (S33.m(iE, aVar.f())) {
            i2 = 7;
        } else if (S33.m(iE, aVar.g())) {
            i2 = 3;
        } else if (S33.m(iE, aVar.h())) {
            i2 = 4;
        } else if (!S33.m(iE, aVar.b())) {
            throw new IllegalStateException("invalid ImeAction".toString());
        }
        editorInfo.imeOptions = i2;
        t33.g();
        KH3.a.a(editorInfo, t33.d());
        int iF = t33.f();
        C22785vp3.a aVar2 = C22785vp3.b;
        if (C22785vp3.n(iF, aVar2.h())) {
            i = 1;
        } else if (C22785vp3.n(iF, aVar2.a())) {
            editorInfo.imeOptions |= RecyclerView.UNDEFINED_DURATION;
            i = 1;
        } else if (C22785vp3.n(iF, aVar2.d())) {
            i = 2;
        } else if (!C22785vp3.n(iF, aVar2.g())) {
            if (C22785vp3.n(iF, aVar2.j())) {
                i = 17;
            } else if (C22785vp3.n(iF, aVar2.c())) {
                i = 33;
            } else if (C22785vp3.n(iF, aVar2.f())) {
                i = 129;
            } else if (C22785vp3.n(iF, aVar2.e())) {
                i = 18;
            } else {
                if (!C22785vp3.n(iF, aVar2.b())) {
                    throw new IllegalStateException("Invalid Keyboard Type".toString());
                }
                i = 8194;
            }
        }
        editorInfo.inputType = i;
        if (!t33.h() && a(editorInfo.inputType, 1)) {
            editorInfo.inputType |= 131072;
            if (S33.m(t33.e(), aVar.a())) {
                editorInfo.imeOptions |= 1073741824;
            }
        }
        if (a(editorInfo.inputType, 1)) {
            int iC = t33.c();
            C14383hp3.a aVar3 = C14383hp3.b;
            if (C14383hp3.i(iC, aVar3.a())) {
                editorInfo.inputType |= 4096;
            } else if (C14383hp3.i(iC, aVar3.e())) {
                editorInfo.inputType |= 8192;
            } else if (C14383hp3.i(iC, aVar3.c())) {
                editorInfo.inputType |= 16384;
            }
            if (t33.b()) {
                editorInfo.inputType |= 32768;
            }
        }
        editorInfo.initialSelStart = C4301En7.n(j);
        editorInfo.initialSelEnd = C4301En7.i(j);
        AbstractC9511a52.f(editorInfo, charSequence);
        if (strArr != null) {
            AbstractC9511a52.d(editorInfo, strArr);
        }
        editorInfo.imeOptions |= 33554432;
        if (!NZ6.a() || C22785vp3.n(t33.f(), aVar2.f()) || C22785vp3.n(t33.f(), aVar2.e())) {
            AbstractC9511a52.g(editorInfo, false);
        } else {
            AbstractC9511a52.g(editorInfo, true);
            X42.a.a(editorInfo);
        }
    }

    public static /* synthetic */ void c(EditorInfo editorInfo, CharSequence charSequence, long j, T33 t33, String[] strArr, int i, Object obj) {
        if ((i & 8) != 0) {
            strArr = null;
        }
        b(editorInfo, charSequence, j, t33, strArr);
    }
}
