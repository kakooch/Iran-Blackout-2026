package ir.nasim;

/* renamed from: ir.nasim.cy6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC11420cy6 {
    public static final C14539i47 a = new C14539i47("NO_VALUE");

    public static final InterfaceC8327Vm4 a(int i, int i2, EnumC6162Ml0 enumC6162Ml0) {
        if (i < 0) {
            throw new IllegalArgumentException(("replay cannot be negative, but was " + i).toString());
        }
        if (i2 < 0) {
            throw new IllegalArgumentException(("extraBufferCapacity cannot be negative, but was " + i2).toString());
        }
        if (i > 0 || i2 > 0 || enumC6162Ml0 == EnumC6162Ml0.SUSPEND) {
            int i3 = i2 + i;
            if (i3 < 0) {
                i3 = Integer.MAX_VALUE;
            }
            return new C10656by6(i, i3, enumC6162Ml0);
        }
        throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + enumC6162Ml0).toString());
    }

    public static /* synthetic */ InterfaceC8327Vm4 b(int i, int i2, EnumC6162Ml0 enumC6162Ml0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            enumC6162Ml0 = EnumC6162Ml0.SUSPEND;
        }
        return a(i, i2, enumC6162Ml0);
    }

    public static final InterfaceC4557Fq2 e(InterfaceC10040ay6 interfaceC10040ay6, InterfaceC11938do1 interfaceC11938do1, int i, EnumC6162Ml0 enumC6162Ml0) {
        return ((i == 0 || i == -3) && enumC6162Ml0 == EnumC6162Ml0.SUSPEND) ? interfaceC10040ay6 : new C23665xJ0(interfaceC10040ay6, interfaceC11938do1, i, enumC6162Ml0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object f(Object[] objArr, long j) {
        return objArr[((int) j) & (objArr.length - 1)];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Object[] objArr, long j, Object obj) {
        objArr[((int) j) & (objArr.length - 1)] = obj;
    }
}
