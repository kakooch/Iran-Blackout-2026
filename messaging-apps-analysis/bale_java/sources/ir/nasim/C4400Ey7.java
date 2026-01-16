package ir.nasim;

/* renamed from: ir.nasim.Ey7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C4400Ey7 extends AbstractC4166Dy7 {
    private final KQ7 a;
    private final AbstractC4099Dr3 b;

    public C4400Ey7(KQ7 kq7, AbstractC4099Dr3 abstractC4099Dr3) {
        if (kq7 == null) {
            d(0);
        }
        if (abstractC4099Dr3 == null) {
            d(1);
        }
        this.a = kq7;
        this.b = abstractC4099Dr3;
    }

    private static /* synthetic */ void d(int i) {
        String str = (i == 4 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 5) ? 2 : 3];
        switch (i) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "type";
                break;
            case 4:
            case 5:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
                break;
            case 6:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "projection";
                break;
        }
        if (i == 4) {
            objArr[1] = "getProjectionKind";
        } else if (i != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
        } else {
            objArr[1] = "getType";
        }
        if (i == 3) {
            objArr[2] = "replaceType";
        } else if (i != 4 && i != 5) {
            if (i != 6) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "refine";
            }
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // ir.nasim.InterfaceC3932Cy7
    public InterfaceC3932Cy7 a(AbstractC5284Ir3 abstractC5284Ir3) {
        if (abstractC5284Ir3 == null) {
            d(6);
        }
        return new C4400Ey7(this.a, abstractC5284Ir3.g(this.b));
    }

    @Override // ir.nasim.InterfaceC3932Cy7
    public boolean b() {
        return false;
    }

    @Override // ir.nasim.InterfaceC3932Cy7
    public KQ7 c() {
        KQ7 kq7 = this.a;
        if (kq7 == null) {
            d(4);
        }
        return kq7;
    }

    @Override // ir.nasim.InterfaceC3932Cy7
    public AbstractC4099Dr3 getType() {
        AbstractC4099Dr3 abstractC4099Dr3 = this.b;
        if (abstractC4099Dr3 == null) {
            d(5);
        }
        return abstractC4099Dr3;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C4400Ey7(AbstractC4099Dr3 abstractC4099Dr3) {
        this(KQ7.INVARIANT, abstractC4099Dr3);
        if (abstractC4099Dr3 == null) {
            d(2);
        }
    }
}
