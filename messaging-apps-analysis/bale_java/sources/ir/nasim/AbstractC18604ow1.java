package ir.nasim;

import ir.nasim.InterfaceC18013nw1;
import ir.nasim.SY1;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.ow1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC18604ow1 {
    public static final SY1 a(InterfaceC18013nw1 interfaceC18013nw1) {
        AbstractC13042fc3.i(interfaceC18013nw1, "<this>");
        if (interfaceC18013nw1 instanceof InterfaceC18013nw1.a) {
            return new SY1.a(((InterfaceC18013nw1.a) interfaceC18013nw1).a());
        }
        if (interfaceC18013nw1 instanceof InterfaceC18013nw1.b) {
            return new SY1.c(null);
        }
        throw new NoWhenBranchMatchedException();
    }
}
