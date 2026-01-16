package ir.nasim;

import android.os.Handler;
import android.view.inputmethod.InputConnection;

/* renamed from: ir.nasim.lF4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C16425lF4 extends AbstractC15834kF4 {
    public C16425lF4(InputConnection inputConnection, UA2 ua2) {
        super(inputConnection, ua2);
    }

    @Override // ir.nasim.AbstractC15834kF4
    protected final void b(InputConnection inputConnection) {
        inputConnection.closeConnection();
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        InputConnection inputConnectionC = c();
        if (inputConnectionC != null) {
            return inputConnectionC.deleteSurroundingTextInCodePoints(i, i2);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final Handler getHandler() {
        InputConnection inputConnectionC = c();
        if (inputConnectionC != null) {
            return inputConnectionC.getHandler();
        }
        return null;
    }
}
