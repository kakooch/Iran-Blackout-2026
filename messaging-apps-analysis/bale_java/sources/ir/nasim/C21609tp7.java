package ir.nasim;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;

/* renamed from: ir.nasim.tp7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C21609tp7 implements InterfaceC18740pA0 {
    public static final C21609tp7 a = new C21609tp7();

    private C21609tp7() {
    }

    @Override // ir.nasim.InterfaceC18740pA0
    public List a() {
        return AbstractC10360bX0.m();
    }

    @Override // ir.nasim.InterfaceC18740pA0
    public /* bridge */ /* synthetic */ Member b() {
        return (Member) c();
    }

    public Void c() {
        return null;
    }

    @Override // ir.nasim.InterfaceC18740pA0
    public Object call(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "args");
        throw new UnsupportedOperationException("call/callBy are not supported for this declaration.");
    }

    @Override // ir.nasim.InterfaceC18740pA0
    public Type getReturnType() {
        Class cls = Void.TYPE;
        AbstractC13042fc3.h(cls, "Void.TYPE");
        return cls;
    }
}
