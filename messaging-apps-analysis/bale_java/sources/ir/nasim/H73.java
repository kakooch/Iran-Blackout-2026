package ir.nasim;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes8.dex */
public final class H73 implements InterfaceC18740pA0 {
    private final a a;
    private final InterfaceC18740pA0 b;
    private final boolean c;

    private static final class a {
        private final C24411ya3 a;
        private final Method[] b;
        private final Method c;

        public a(C24411ya3 c24411ya3, Method[] methodArr, Method method) {
            AbstractC13042fc3.i(c24411ya3, "argumentRange");
            AbstractC13042fc3.i(methodArr, "unbox");
            this.a = c24411ya3;
            this.b = methodArr;
            this.c = method;
        }

        public final C24411ya3 a() {
            return this.a;
        }

        public final Method[] b() {
            return this.b;
        }

        public final Method c() {
            return this.c;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public H73(ir.nasim.InterfaceC15194jA0 r8, ir.nasim.InterfaceC18740pA0 r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.H73.<init>(ir.nasim.jA0, ir.nasim.pA0, boolean):void");
    }

    @Override // ir.nasim.InterfaceC18740pA0
    public List a() {
        return this.b.a();
    }

    @Override // ir.nasim.InterfaceC18740pA0
    public Member b() {
        return this.b.b();
    }

    @Override // ir.nasim.InterfaceC18740pA0
    public Object call(Object[] objArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object objInvoke;
        AbstractC13042fc3.i(objArr, "args");
        a aVar = this.a;
        C24411ya3 c24411ya3A = aVar.a();
        Method[] methodArrB = aVar.b();
        Method methodC = aVar.c();
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        AbstractC13042fc3.h(objArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        if (objArrCopyOf == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }
        int iO = c24411ya3A.o();
        int iT = c24411ya3A.t();
        if (iO <= iT) {
            while (true) {
                Method method = methodArrB[iO];
                Object objD = objArr[iO];
                if (method != null) {
                    if (objD != null) {
                        objD = method.invoke(objD, null);
                    } else {
                        Class<?> returnType = method.getReturnType();
                        AbstractC13042fc3.h(returnType, "method.returnType");
                        objD = AbstractC14729iN7.d(returnType);
                    }
                }
                objArrCopyOf[iO] = objD;
                if (iO == iT) {
                    break;
                }
                iO++;
            }
        }
        Object objCall = this.b.call(objArrCopyOf);
        return (methodC == null || (objInvoke = methodC.invoke(null, objCall)) == null) ? objCall : objInvoke;
    }

    @Override // ir.nasim.InterfaceC18740pA0
    public Type getReturnType() {
        return this.b.getReturnType();
    }
}
