package ir.nasim;

import java.util.Collections;
import java.util.List;

/* renamed from: ir.nasim.sC6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public interface InterfaceC20555sC6 {
    public static final InterfaceC20555sC6 a = new a();

    /* renamed from: ir.nasim.sC6$a */
    static class a implements InterfaceC20555sC6 {
        a() {
        }

        private static /* synthetic */ void c(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                    objArr[0] = "owner";
                    break;
                case 2:
                    objArr[0] = "returnType";
                    break;
                case 3:
                    objArr[0] = "valueParameters";
                    break;
                case 4:
                    objArr[0] = "typeParameters";
                    break;
                case 5:
                    objArr[0] = "descriptor";
                    break;
                case 6:
                    objArr[0] = "signatureErrors";
                    break;
                default:
                    objArr[0] = "method";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1";
            if (i == 5 || i == 6) {
                objArr[2] = "reportSignatureErrors";
            } else {
                objArr[2] = "resolvePropagatedSignature";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // ir.nasim.InterfaceC20555sC6
        public void a(InterfaceC15194jA0 interfaceC15194jA0, List list) {
            if (interfaceC15194jA0 == null) {
                c(5);
            }
            if (list == null) {
                c(6);
            }
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override // ir.nasim.InterfaceC20555sC6
        public b b(InterfaceC20257ri3 interfaceC20257ri3, InterfaceC21331tU0 interfaceC21331tU0, AbstractC4099Dr3 abstractC4099Dr3, AbstractC4099Dr3 abstractC4099Dr32, List list, List list2) {
            if (interfaceC20257ri3 == null) {
                c(0);
            }
            if (interfaceC21331tU0 == null) {
                c(1);
            }
            if (abstractC4099Dr3 == null) {
                c(2);
            }
            if (list == null) {
                c(3);
            }
            if (list2 == null) {
                c(4);
            }
            return new b(abstractC4099Dr3, abstractC4099Dr32, list, list2, Collections.emptyList(), false);
        }
    }

    /* renamed from: ir.nasim.sC6$b */
    public static class b {
        private final AbstractC4099Dr3 a;
        private final AbstractC4099Dr3 b;
        private final List c;
        private final List d;
        private final List e;
        private final boolean f;

        public b(AbstractC4099Dr3 abstractC4099Dr3, AbstractC4099Dr3 abstractC4099Dr32, List list, List list2, List list3, boolean z) {
            if (abstractC4099Dr3 == null) {
                a(0);
            }
            if (list == null) {
                a(1);
            }
            if (list2 == null) {
                a(2);
            }
            if (list3 == null) {
                a(3);
            }
            this.a = abstractC4099Dr3;
            this.b = abstractC4099Dr32;
            this.c = list;
            this.d = list2;
            this.e = list3;
            this.f = z;
        }

        private static /* synthetic */ void a(int i) {
            String str = (i == 4 || i == 5 || i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 4 || i == 5 || i == 6 || i == 7) ? 2 : 3];
            switch (i) {
                case 1:
                    objArr[0] = "valueParameters";
                    break;
                case 2:
                    objArr[0] = "typeParameters";
                    break;
                case 3:
                    objArr[0] = "signatureErrors";
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
                    break;
                default:
                    objArr[0] = "returnType";
                    break;
            }
            if (i == 4) {
                objArr[1] = "getReturnType";
            } else if (i == 5) {
                objArr[1] = "getValueParameters";
            } else if (i == 6) {
                objArr[1] = "getTypeParameters";
            } else if (i != 7) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
            } else {
                objArr[1] = "getErrors";
            }
            if (i != 4 && i != 5 && i != 6 && i != 7) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i != 4 && i != 5 && i != 6 && i != 7) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        public List b() {
            List list = this.e;
            if (list == null) {
                a(7);
            }
            return list;
        }

        public AbstractC4099Dr3 c() {
            return this.b;
        }

        public AbstractC4099Dr3 d() {
            AbstractC4099Dr3 abstractC4099Dr3 = this.a;
            if (abstractC4099Dr3 == null) {
                a(4);
            }
            return abstractC4099Dr3;
        }

        public List e() {
            List list = this.d;
            if (list == null) {
                a(6);
            }
            return list;
        }

        public List f() {
            List list = this.c;
            if (list == null) {
                a(5);
            }
            return list;
        }

        public boolean g() {
            return this.f;
        }
    }

    void a(InterfaceC15194jA0 interfaceC15194jA0, List list);

    b b(InterfaceC20257ri3 interfaceC20257ri3, InterfaceC21331tU0 interfaceC21331tU0, AbstractC4099Dr3 abstractC4099Dr3, AbstractC4099Dr3 abstractC4099Dr32, List list, List list2);
}
