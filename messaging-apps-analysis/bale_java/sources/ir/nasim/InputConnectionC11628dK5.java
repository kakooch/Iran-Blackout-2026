package ir.nasim;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.dK5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class InputConnectionC11628dK5 implements InputConnection {
    private final InterfaceC16369l93 a;
    private final boolean b;
    private int c;
    private C23945xm7 d;
    private int e;
    private boolean f;
    private final List g = new ArrayList();
    private boolean h = true;

    public InputConnectionC11628dK5(C23945xm7 c23945xm7, InterfaceC16369l93 interfaceC16369l93, boolean z) {
        this.a = interfaceC16369l93;
        this.b = z;
        this.d = c23945xm7;
    }

    private final void b(InterfaceC18081o32 interfaceC18081o32) {
        c();
        try {
            this.g.add(interfaceC18081o32);
        } finally {
            d();
        }
    }

    private final boolean c() {
        this.c++;
        return true;
    }

    private final boolean d() {
        int i = this.c - 1;
        this.c = i;
        if (i == 0 && (!this.g.isEmpty())) {
            this.a.d(AbstractC15401jX0.p1(this.g));
            this.g.clear();
        }
        return this.c > 0;
    }

    private final void e(int i) {
        sendKeyEvent(new KeyEvent(0, i));
        sendKeyEvent(new KeyEvent(1, i));
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        boolean z = this.h;
        return z ? c() : z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int i) {
        boolean z = this.h;
        if (z) {
            return false;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public void closeConnection() {
        this.g.clear();
        this.c = 0;
        this.h = false;
        this.a.e(this);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCompletion(CompletionInfo completionInfo) {
        boolean z = this.h;
        if (z) {
            return false;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
        boolean z = this.h;
        if (z) {
            return false;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        boolean z = this.h;
        return z ? this.b : z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i) {
        boolean z = this.h;
        if (z) {
            b(new UZ0(String.valueOf(charSequence), i));
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i, int i2) {
        boolean z = this.h;
        if (!z) {
            return z;
        }
        b(new KH1(i, i2));
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        boolean z = this.h;
        if (!z) {
            return z;
        }
        b(new LH1(i, i2));
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        return d();
    }

    public final void f(C23945xm7 c23945xm7) {
        this.d = c23945xm7;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        boolean z = this.h;
        if (!z) {
            return z;
        }
        b(new C4539Fo2());
        return true;
    }

    public final void g(C23945xm7 c23945xm7, InterfaceC19324q93 interfaceC19324q93) {
        if (this.h) {
            f(c23945xm7);
            if (this.f) {
                interfaceC19324q93.a(this.e, AbstractC24757z93.a(c23945xm7));
            }
            C4301En7 c4301En7F = c23945xm7.f();
            int iL = c4301En7F != null ? C4301En7.l(c4301En7F.r()) : -1;
            C4301En7 c4301En7F2 = c23945xm7.f();
            interfaceC19324q93.c(C4301En7.l(c23945xm7.g()), C4301En7.k(c23945xm7.g()), iL, c4301En7F2 != null ? C4301En7.k(c4301En7F2.r()) : -1);
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public int getCursorCapsMode(int i) {
        return TextUtils.getCapsMode(this.d.h(), C4301En7.l(this.d.g()), i);
    }

    @Override // android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i) {
        boolean z = (i & 1) != 0;
        this.f = z;
        if (z) {
            this.e = extractedTextRequest != null ? extractedTextRequest.token : 0;
        }
        return AbstractC24757z93.a(this.d);
    }

    @Override // android.view.inputmethod.InputConnection
    public Handler getHandler() {
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getSelectedText(int i) {
        if (C4301En7.h(this.d.g())) {
            return null;
        }
        return AbstractC24535ym7.a(this.d).toString();
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextAfterCursor(int i, int i2) {
        return AbstractC24535ym7.b(this.d, i).toString();
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextBeforeCursor(int i, int i2) {
        return AbstractC24535ym7.c(this.d, i).toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int i) {
        boolean z = this.h;
        if (z) {
            z = false;
            switch (i) {
                case android.R.id.selectAll:
                    b(new C24024xu6(0, this.d.h().length()));
                    break;
                case android.R.id.cut:
                    e(277);
                    break;
                case android.R.id.copy:
                    e(278);
                    break;
                case android.R.id.paste:
                    e(279);
                    break;
            }
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performEditorAction(int i) {
        int iA;
        boolean z = this.h;
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
    public boolean performPrivateCommand(String str, Bundle bundle) {
        boolean z = this.h;
        if (z) {
            return true;
        }
        return z;
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
        boolean z5 = this.h;
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
        boolean z = this.h;
        if (!z) {
            return z;
        }
        this.a.a(keyEvent);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int i, int i2) {
        boolean z = this.h;
        if (z) {
            b(new C14436hu6(i, i2));
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i) {
        boolean z = this.h;
        if (z) {
            b(new C15043iu6(String.valueOf(charSequence), i));
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setSelection(int i, int i2) {
        boolean z = this.h;
        if (!z) {
            return z;
        }
        b(new C24024xu6(i, i2));
        return true;
    }
}
