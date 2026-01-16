package ir.nasim;

/* loaded from: classes8.dex */
public abstract class DJ0 {
    public static final InterfaceC17639nJ0 a(int i, EnumC6162Ml0 enumC6162Ml0, UA2 ua2) {
        InterfaceC17639nJ0 c6401Nl0;
        if (i == -2) {
            c6401Nl0 = enumC6162Ml0 == EnumC6162Ml0.SUSPEND ? new C6401Nl0(InterfaceC17639nJ0.c0.a(), ua2) : new C13668gd1(1, enumC6162Ml0, ua2);
        } else {
            if (i == -1) {
                if (enumC6162Ml0 == EnumC6162Ml0.SUSPEND) {
                    return new C13668gd1(1, EnumC6162Ml0.DROP_OLDEST, ua2);
                }
                throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
            }
            if (i != 0) {
                return i != Integer.MAX_VALUE ? enumC6162Ml0 == EnumC6162Ml0.SUSPEND ? new C6401Nl0(i, ua2) : new C13668gd1(i, enumC6162Ml0, ua2) : new C6401Nl0(Integer.MAX_VALUE, ua2);
            }
            c6401Nl0 = enumC6162Ml0 == EnumC6162Ml0.SUSPEND ? new C6401Nl0(0, ua2) : new C13668gd1(1, enumC6162Ml0, ua2);
        }
        return c6401Nl0;
    }

    public static /* synthetic */ InterfaceC17639nJ0 b(int i, EnumC6162Ml0 enumC6162Ml0, UA2 ua2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            enumC6162Ml0 = EnumC6162Ml0.SUSPEND;
        }
        if ((i2 & 4) != 0) {
            ua2 = null;
        }
        return a(i, enumC6162Ml0, ua2);
    }
}
