package ir.nasim;

import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import android.view.inputmethod.PreviewableHandwritingGesture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;

/* renamed from: ir.nasim.cK5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class InputConnectionC10864cK5 implements InputConnection {
    private final InterfaceC16960m93 a;
    private final boolean b;
    private final C6542Ny3 c;
    private final C19101pm7 d;
    private final InterfaceC18354oW7 e;
    private int f;
    private C23945xm7 g;
    private int h;
    private boolean i;
    private final List j = new ArrayList();
    private boolean k = true;

    /* renamed from: ir.nasim.cK5$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        a() {
            super(1);
        }

        public final void a(InterfaceC18081o32 interfaceC18081o32) {
            InputConnectionC10864cK5.this.c(interfaceC18081o32);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC18081o32) obj);
            return C19938rB7.a;
        }
    }

    public InputConnectionC10864cK5(C23945xm7 c23945xm7, InterfaceC16960m93 interfaceC16960m93, boolean z, C6542Ny3 c6542Ny3, C19101pm7 c19101pm7, InterfaceC18354oW7 interfaceC18354oW7) {
        this.a = interfaceC16960m93;
        this.b = z;
        this.c = c6542Ny3;
        this.d = c19101pm7;
        this.e = interfaceC18354oW7;
        this.g = c23945xm7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(InterfaceC18081o32 interfaceC18081o32) {
        d();
        try {
            this.j.add(interfaceC18081o32);
        } finally {
            e();
        }
    }

    private final boolean d() {
        this.f++;
        return true;
    }

    private final boolean e() {
        int i = this.f - 1;
        this.f = i;
        if (i == 0 && (!this.j.isEmpty())) {
            this.a.d(AbstractC15401jX0.p1(this.j));
            this.j.clear();
        }
        return this.f > 0;
    }

    private final void f(int i) {
        sendKeyEvent(new KeyEvent(0, i));
        sendKeyEvent(new KeyEvent(1, i));
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        boolean z = this.k;
        return z ? d() : z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int i) {
        boolean z = this.k;
        if (z) {
            return false;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public void closeConnection() {
        this.j.clear();
        this.f = 0;
        this.k = false;
        this.a.e(this);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCompletion(CompletionInfo completionInfo) {
        boolean z = this.k;
        if (z) {
            return false;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
        boolean z = this.k;
        if (z) {
            return false;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        boolean z = this.k;
        return z ? this.b : z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i) {
        boolean z = this.k;
        if (z) {
            c(new UZ0(String.valueOf(charSequence), i));
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i, int i2) {
        boolean z = this.k;
        if (!z) {
            return z;
        }
        c(new KH1(i, i2));
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        boolean z = this.k;
        if (!z) {
            return z;
        }
        c(new LH1(i, i2));
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        return e();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        boolean z = this.k;
        if (!z) {
            return z;
        }
        c(new C4539Fo2());
        return true;
    }

    public final void g(C23945xm7 c23945xm7) {
        this.g = c23945xm7;
    }

    @Override // android.view.inputmethod.InputConnection
    public int getCursorCapsMode(int i) {
        return TextUtils.getCapsMode(this.g.h(), C4301En7.l(this.g.g()), i);
    }

    @Override // android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i) {
        boolean z = (i & 1) != 0;
        this.i = z;
        if (z) {
            this.h = extractedTextRequest != null ? extractedTextRequest.token : 0;
        }
        return AbstractC12271eK5.b(this.g);
    }

    @Override // android.view.inputmethod.InputConnection
    public Handler getHandler() {
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getSelectedText(int i) {
        if (C4301En7.h(this.g.g())) {
            return null;
        }
        return AbstractC24535ym7.a(this.g).toString();
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextAfterCursor(int i, int i2) {
        return AbstractC24535ym7.b(this.g, i).toString();
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextBeforeCursor(int i, int i2) {
        return AbstractC24535ym7.c(this.g, i).toString();
    }

    public final void h(C23945xm7 c23945xm7, InterfaceC19915r93 interfaceC19915r93) {
        if (this.k) {
            g(c23945xm7);
            if (this.i) {
                interfaceC19915r93.a(this.h, AbstractC12271eK5.b(c23945xm7));
            }
            C4301En7 c4301En7F = c23945xm7.f();
            int iL = c4301En7F != null ? C4301En7.l(c4301En7F.r()) : -1;
            C4301En7 c4301En7F2 = c23945xm7.f();
            interfaceC19915r93.c(C4301En7.l(c23945xm7.g()), C4301En7.k(c23945xm7.g()), iL, c4301En7F2 != null ? C4301En7.k(c4301En7F2.r()) : -1);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int i) {
        boolean z = this.k;
        if (z) {
            z = false;
            switch (i) {
                case android.R.id.selectAll:
                    c(new C24024xu6(0, this.g.h().length()));
                    break;
                case android.R.id.cut:
                    f(277);
                    break;
                case android.R.id.copy:
                    f(278);
                    break;
                case android.R.id.paste:
                    f(279);
                    break;
            }
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performEditorAction(int i) {
        int iA;
        boolean z = this.k;
        if (!z) {
            return z;
        }
        if (i != 0) {
            switch (i) {
                case 2:
                    iA = S33.b.c();
                    break;
                case 3:
                    iA = S33.b.g();
                    break;
                case 4:
                    iA = S33.b.h();
                    break;
                case 5:
                    iA = S33.b.d();
                    break;
                case 6:
                    iA = S33.b.b();
                    break;
                case 7:
                    iA = S33.b.f();
                    break;
                default:
                    Log.w("RecordingIC", "IME sends unsupported Editor Action: " + i);
                    iA = S33.b.a();
                    break;
            }
        } else {
            iA = S33.b.a();
        }
        this.a.c(iA);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public void performHandwritingGesture(HandwritingGesture handwritingGesture, Executor executor, IntConsumer intConsumer) {
        if (Build.VERSION.SDK_INT >= 34) {
            C22251uv.a.b(this.c, this.d, handwritingGesture, this.e, executor, intConsumer, new a());
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String str, Bundle bundle) {
        boolean z = this.k;
        if (z) {
            return true;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean previewHandwritingGesture(PreviewableHandwritingGesture previewableHandwritingGesture, CancellationSignal cancellationSignal) {
        if (Build.VERSION.SDK_INT >= 34) {
            return C22251uv.a.d(this.c, this.d, previewableHandwritingGesture, cancellationSignal);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean reportFullscreenMode(boolean z) {
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5 = this.k;
        if (!z5) {
            return z5;
        }
        boolean z6 = false;
        boolean z7 = (i & 1) != 0;
        boolean z8 = (i & 2) != 0;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            boolean z9 = (i & 16) != 0;
            boolean z10 = (i & 8) != 0;
            boolean z11 = (i & 4) != 0;
            if (i2 >= 34 && (i & 32) != 0) {
                z6 = true;
            }
            if (z9 || z10 || z11 || z6) {
                z2 = z6;
                z = z11;
                z4 = z10;
                z3 = z9;
            } else if (i2 >= 34) {
                z3 = true;
                z4 = true;
                z = true;
                z2 = true;
            } else {
                z2 = z6;
                z3 = true;
                z4 = true;
                z = true;
            }
        } else {
            z = false;
            z2 = false;
            z3 = true;
            z4 = true;
        }
        this.a.b(z7, z8, z3, z4, z, z2);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        boolean z = this.k;
        if (!z) {
            return z;
        }
        this.a.a(keyEvent);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int i, int i2) {
        boolean z = this.k;
        if (z) {
            c(new C14436hu6(i, i2));
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i) {
        boolean z = this.k;
        if (z) {
            c(new C15043iu6(String.valueOf(charSequence), i));
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setSelection(int i, int i2) {
        boolean z = this.k;
        if (!z) {
            return z;
        }
        c(new C24024xu6(i, i2));
        return true;
    }
}
