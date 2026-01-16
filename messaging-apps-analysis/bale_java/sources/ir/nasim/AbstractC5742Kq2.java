package ir.nasim;

import kotlinx.coroutines.flow.internal.AbortFlowException;

/* renamed from: ir.nasim.Kq2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC5742Kq2 {
    public static final void a(AbortFlowException abortFlowException, InterfaceC4806Gq2 interfaceC4806Gq2) {
        if (abortFlowException.owner != interfaceC4806Gq2) {
            throw abortFlowException;
        }
    }
}
