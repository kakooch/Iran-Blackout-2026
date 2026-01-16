package ir.nasim;

import ir.nasim.core.model.webapp.WebAppArguments;

/* loaded from: classes8.dex */
public final class I48 {
    public static final I48 a = new I48();

    private I48() {
    }

    public final WebAppArguments a(androidx.lifecycle.y yVar) {
        AbstractC13042fc3.i(yVar, "savedStateHandle");
        Object objC = yVar.c("arg_webapp");
        AbstractC13042fc3.f(objC);
        return (WebAppArguments) objC;
    }
}
