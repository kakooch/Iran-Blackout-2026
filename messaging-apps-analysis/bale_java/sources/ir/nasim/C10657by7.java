package ir.nasim;

/* renamed from: ir.nasim.by7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
class C10657by7 implements InterfaceC12064dy7 {
    C10657by7() {
    }

    private static /* synthetic */ void b(int i) {
        Object[] objArr = new Object[3];
        switch (i) {
            case 1:
            case 4:
                objArr[0] = "b";
                break;
            case 2:
            case 7:
                objArr[0] = "typeCheckingProcedure";
                break;
            case 3:
            default:
                objArr[0] = "a";
                break;
            case 5:
            case 10:
                objArr[0] = "subtype";
                break;
            case 6:
            case 11:
                objArr[0] = "supertype";
                break;
            case 8:
                objArr[0] = "type";
                break;
            case 9:
                objArr[0] = "typeProjection";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl";
        switch (i) {
            case 3:
            case 4:
                objArr[2] = "assertEqualTypeConstructors";
                break;
            case 5:
            case 6:
            case 7:
                objArr[2] = "assertSubtype";
                break;
            case 8:
            case 9:
                objArr[2] = "capture";
                break;
            case 10:
            case 11:
                objArr[2] = "noCorrespondingSupertype";
                break;
            default:
                objArr[2] = "assertEqualTypes";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // ir.nasim.InterfaceC12064dy7
    public boolean a(InterfaceC13882gy7 interfaceC13882gy7, InterfaceC13882gy7 interfaceC13882gy72) {
        if (interfaceC13882gy7 == null) {
            b(3);
        }
        if (interfaceC13882gy72 == null) {
            b(4);
        }
        return interfaceC13882gy7.equals(interfaceC13882gy72);
    }
}
