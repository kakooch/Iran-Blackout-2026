package ir.nasim;

import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;

/* renamed from: ir.nasim.nF4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C17607nF4 extends C16425lF4 {
    public C17607nF4(InputConnection inputConnection, UA2 ua2) {
        super(inputConnection, ua2);
    }

    @Override // ir.nasim.AbstractC15834kF4, android.view.inputmethod.InputConnection
    public final boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
        InputConnection inputConnectionC = c();
        if (inputConnectionC != null) {
            return inputConnectionC.commitContent(inputContentInfo, i, bundle);
        }
        return false;
    }
}
