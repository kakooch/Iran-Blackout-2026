package ir.nasim;

import android.view.Choreographer;
import android.view.inputmethod.EditorInfo;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C14383hp3;
import ir.nasim.C22785vp3;
import ir.nasim.S33;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.Vm7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC8330Vm7 {
    public static final Executor d(final Choreographer choreographer) {
        return new Executor() { // from class: ir.nasim.Tm7
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                AbstractC8330Vm7.e(choreographer, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Choreographer choreographer, final Runnable runnable) {
        choreographer.postFrameCallback(new Choreographer.FrameCallback() { // from class: ir.nasim.Um7
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                AbstractC8330Vm7.f(runnable, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Runnable runnable, long j) {
        runnable.run();
    }

    private static final boolean g(int i, int i2) {
        return (i & i2) == i2;
    }

    public static final void h(EditorInfo editorInfo, T33 t33, C23945xm7 c23945xm7) {
        int iE = t33.e();
        S33.a aVar = S33.b;
        int i = 6;
        if (S33.m(iE, aVar.a())) {
            if (!t33.h()) {
                i = 0;
            }
        } else if (S33.m(iE, aVar.e())) {
            i = 1;
        } else if (S33.m(iE, aVar.c())) {
            i = 2;
        } else if (S33.m(iE, aVar.d())) {
            i = 5;
        } else if (S33.m(iE, aVar.f())) {
            i = 7;
        } else if (S33.m(iE, aVar.g())) {
            i = 3;
        } else if (S33.m(iE, aVar.h())) {
            i = 4;
        } else if (!S33.m(iE, aVar.b())) {
            throw new IllegalStateException("invalid ImeAction".toString());
        }
        editorInfo.imeOptions = i;
        t33.g();
        int iF = t33.f();
        C22785vp3.a aVar2 = C22785vp3.b;
        if (C22785vp3.n(iF, aVar2.h())) {
            editorInfo.inputType = 1;
        } else if (C22785vp3.n(iF, aVar2.a())) {
            editorInfo.inputType = 1;
            editorInfo.imeOptions |= RecyclerView.UNDEFINED_DURATION;
        } else if (C22785vp3.n(iF, aVar2.d())) {
            editorInfo.inputType = 2;
        } else if (C22785vp3.n(iF, aVar2.g())) {
            editorInfo.inputType = 3;
        } else if (C22785vp3.n(iF, aVar2.j())) {
            editorInfo.inputType = 17;
        } else if (C22785vp3.n(iF, aVar2.c())) {
            editorInfo.inputType = 33;
        } else if (C22785vp3.n(iF, aVar2.f())) {
            editorInfo.inputType = 129;
        } else if (C22785vp3.n(iF, aVar2.e())) {
            editorInfo.inputType = 18;
        } else {
            if (!C22785vp3.n(iF, aVar2.b())) {
                throw new IllegalStateException("Invalid Keyboard Type".toString());
            }
            editorInfo.inputType = 8194;
        }
        if (!t33.h() && g(editorInfo.inputType, 1)) {
            editorInfo.inputType |= 131072;
            if (S33.m(t33.e(), aVar.a())) {
                editorInfo.imeOptions |= 1073741824;
            }
        }
        if (g(editorInfo.inputType, 1)) {
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
        editorInfo.initialSelStart = C4301En7.n(c23945xm7.g());
        editorInfo.initialSelEnd = C4301En7.i(c23945xm7.g());
        AbstractC9511a52.f(editorInfo, c23945xm7.h());
        editorInfo.imeOptions |= 33554432;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(EditorInfo editorInfo) {
        if (androidx.emoji2.text.e.k()) {
            androidx.emoji2.text.e.c().x(editorInfo);
        }
    }
}
