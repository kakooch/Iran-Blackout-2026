package ir.nasim;

import ir.nasim.tgwidgets.editor.messenger.Utilities;

/* renamed from: ir.nasim.z23, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C24687z23 {
    public int a;
    public byte[] b;
    public byte[] c;
    public byte[] d;
    public long e;
    public C18727p87 f;
    public String g;
    public AbstractC18106o57 h;
    public long i;
    public AbstractC11500d67 j;
    public AbstractC10736c67 k;
    public int l;
    public D57 m;
    public F57 n;
    public int o;
    public long p;
    public long q;
    public long r;
    public String s;
    public C12154e78 t;

    public static C24687z23 a(AbstractC15742k57 abstractC15742k57, int i) {
        AbstractC16333l57 abstractC16333l57;
        D57 c22395v97;
        if (abstractC15742k57 == null || (abstractC16333l57 = abstractC15742k57.m) == null) {
            return null;
        }
        if (i == 2) {
            if (abstractC16333l57.f == null) {
                return null;
            }
            C24687z23 c24687z23 = new C24687z23();
            C8758Xe7 c8758Xe7 = new C8758Xe7();
            c24687z23.j = c8758Xe7;
            c8758Xe7.b = "s";
            c8758Xe7.g = abstractC15742k57.m.f;
            return c24687z23;
        }
        AbstractC20488s57 abstractC20488s57 = i == 0 ? abstractC16333l57.e : abstractC16333l57.d;
        if (abstractC20488s57 == null) {
            return null;
        }
        if (!AbstractC13547gQ0.e(abstractC15742k57)) {
            c22395v97 = new C22395v97();
            c22395v97.f = abstractC15742k57.b;
        } else {
            if (abstractC15742k57.r == 0) {
                return null;
            }
            c22395v97 = new C19919r97();
            c22395v97.e = abstractC15742k57.b;
            c22395v97.g = abstractC15742k57.r;
        }
        D57 d57 = c22395v97;
        int i2 = abstractC15742k57.m.g;
        if (i2 == 0) {
            i2 = abstractC20488s57.b;
        }
        C24687z23 c24687z23H = h(abstractC20488s57, 0, null, null, d57, i, i2, null, null);
        c24687z23H.q = abstractC15742k57.m.h;
        return c24687z23H;
    }

    public static C24687z23 b(AbstractC18106o57 abstractC18106o57) {
        if (abstractC18106o57 == null) {
            return null;
        }
        C24687z23 c24687z23 = new C24687z23();
        c24687z23.h = abstractC18106o57;
        c24687z23.c = abstractC18106o57.n;
        c24687z23.d = abstractC18106o57.o;
        c24687z23.p = abstractC18106o57.j;
        return c24687z23;
    }

    public static C24687z23 c(AbstractC11500d67 abstractC11500d67, AbstractC18106o57 abstractC18106o57) {
        if ((abstractC11500d67 instanceof C8758Xe7) || (abstractC11500d67 instanceof C7317Re7)) {
            C24687z23 c24687z23 = new C24687z23();
            c24687z23.j = abstractC11500d67;
            return c24687z23;
        }
        if (abstractC11500d67 == null || abstractC18106o57 == null) {
            return null;
        }
        return h(abstractC11500d67.c, abstractC11500d67.f, null, abstractC18106o57, null, 1, abstractC18106o57.m, null, abstractC11500d67.b);
    }

    public static C24687z23 d(AbstractC22719vi7 abstractC22719vi7, AbstractC18106o57 abstractC18106o57) {
        if (abstractC22719vi7 == null || abstractC18106o57 == null) {
            return null;
        }
        C24687z23 c24687z23H = h(abstractC22719vi7.d, abstractC22719vi7.g, null, abstractC18106o57, null, 1, abstractC18106o57.m, null, abstractC22719vi7.c);
        if ("f".equals(abstractC22719vi7.c)) {
            c24687z23H.o = 1;
        } else {
            c24687z23H.o = 2;
        }
        return c24687z23H;
    }

    public static C24687z23 e(AbstractC11500d67 abstractC11500d67, L57 l57) {
        if (!(abstractC11500d67 instanceof C8758Xe7) && !(abstractC11500d67 instanceof C7317Re7)) {
            return null;
        }
        C24687z23 c24687z23 = new C24687z23();
        c24687z23.j = abstractC11500d67;
        return c24687z23;
    }

    public static C24687z23 f(AbstractC11500d67 abstractC11500d67, AbstractC12724f57 abstractC12724f57) {
        if (abstractC12724f57 instanceof AbstractC10736c67) {
            return i(abstractC11500d67, (AbstractC10736c67) abstractC12724f57);
        }
        if (abstractC12724f57 instanceof AbstractC18106o57) {
            return c(abstractC11500d67, (AbstractC18106o57) abstractC12724f57);
        }
        if (abstractC12724f57 instanceof L57) {
            return e(abstractC11500d67, (L57) abstractC12724f57);
        }
        return null;
    }

    public static C24687z23 g(String str) {
        if (str == null) {
            return null;
        }
        C24687z23 c24687z23 = new C24687z23();
        c24687z23.g = str;
        return c24687z23;
    }

    private static C24687z23 h(AbstractC20488s57 abstractC20488s57, int i, AbstractC10736c67 abstractC10736c67, AbstractC18106o57 abstractC18106o57, D57 d57, int i2, int i3, F57 f57, String str) {
        if (abstractC20488s57 == null) {
            return null;
        }
        if (abstractC10736c67 == null && d57 == null && f57 == null && abstractC18106o57 == null) {
            return null;
        }
        C24687z23 c24687z23 = new C24687z23();
        c24687z23.a = i3;
        c24687z23.k = abstractC10736c67;
        c24687z23.p = i;
        c24687z23.m = d57;
        c24687z23.l = i2;
        c24687z23.n = f57;
        if (abstractC20488s57 instanceof C18727p87) {
            c24687z23.f = (C18727p87) abstractC20488s57;
            if (abstractC10736c67 != null) {
                c24687z23.b = abstractC10736c67.f;
                c24687z23.e = abstractC10736c67.e;
                c24687z23.q = abstractC10736c67.d;
                c24687z23.s = str;
            } else if (abstractC18106o57 != null) {
                c24687z23.b = abstractC18106o57.e;
                c24687z23.e = abstractC18106o57.d;
                c24687z23.r = abstractC18106o57.c;
                c24687z23.s = str;
            }
        } else {
            C18727p87 c18727p87 = new C18727p87();
            c24687z23.f = c18727p87;
            c18727p87.d = abstractC20488s57.d;
            c18727p87.c = abstractC20488s57.c;
            c18727p87.e = abstractC20488s57.e;
            c24687z23.a = abstractC20488s57.b;
            c24687z23.b = abstractC20488s57.f;
            c24687z23.c = abstractC20488s57.g;
            c24687z23.d = abstractC20488s57.h;
            c24687z23.e = abstractC20488s57.e;
        }
        return c24687z23;
    }

    public static C24687z23 i(AbstractC11500d67 abstractC11500d67, AbstractC10736c67 abstractC10736c67) {
        if ((abstractC11500d67 instanceof C8758Xe7) || (abstractC11500d67 instanceof C7317Re7)) {
            C24687z23 c24687z23 = new C24687z23();
            c24687z23.j = abstractC11500d67;
            return c24687z23;
        }
        if (abstractC11500d67 == null || abstractC10736c67 == null) {
            return null;
        }
        int i = abstractC10736c67.j;
        if (i == 0) {
            i = abstractC11500d67.c.b;
        }
        return h(abstractC11500d67.c, abstractC11500d67.f, abstractC10736c67, null, null, 1, i, null, abstractC11500d67.b);
    }

    public static C24687z23 j(AbstractC19652qi7 abstractC19652qi7, int i) {
        AbstractC20852si7 abstractC20852si7;
        if (abstractC19652qi7 != null && abstractC19652qi7.f != 0 && (abstractC20852si7 = abstractC19652qi7.h) != null) {
            if (i != 4 && i != 3) {
                if (i == 2) {
                    if (abstractC20852si7.g == null) {
                        return null;
                    }
                    C24687z23 c24687z23 = new C24687z23();
                    C8758Xe7 c8758Xe7 = new C8758Xe7();
                    c24687z23.j = c8758Xe7;
                    c8758Xe7.b = "s";
                    c8758Xe7.g = abstractC19652qi7.h.g;
                    return c24687z23;
                }
                AbstractC20488s57 abstractC20488s57 = i == 0 ? abstractC20852si7.f : abstractC20852si7.e;
                if (abstractC20488s57 == null) {
                    return null;
                }
                C24761z97 c24761z97 = new C24761z97();
                c24761z97.d = abstractC19652qi7.b;
                c24761z97.g = abstractC19652qi7.f;
                int i2 = abstractC19652qi7.h.h;
                if (i2 == 0) {
                    i2 = abstractC20488s57.b;
                }
                C24687z23 c24687z23H = h(abstractC20488s57, 0, null, null, c24761z97, i, i2, null, null);
                c24687z23H.q = abstractC19652qi7.h.d;
                return c24687z23H;
            }
            int i3 = C22477vI7.f;
            if (abstractC20852si7.c) {
                ir.nasim.tgwidgets.editor.messenger.C.n(i3).u(abstractC19652qi7.b);
            }
        }
        return null;
    }

    public static C24687z23 k(AbstractC12724f57 abstractC12724f57, int i) {
        if (abstractC12724f57 instanceof AbstractC19652qi7) {
            return j((AbstractC19652qi7) abstractC12724f57, i);
        }
        if (abstractC12724f57 instanceof AbstractC15742k57) {
            return a((AbstractC15742k57) abstractC12724f57, i);
        }
        return null;
    }

    public static C24687z23 l(C12154e78 c12154e78) {
        if (c12154e78 == null) {
            return null;
        }
        C24687z23 c24687z23 = new C24687z23();
        c24687z23.t = c12154e78;
        c24687z23.p = c12154e78.e;
        return c24687z23;
    }

    public static String o(Object obj, Object obj2, Object obj3) {
        if (obj instanceof AbstractC25089zi7) {
            if (obj2 instanceof C24687z23) {
                C24687z23 c24687z23 = (C24687z23) obj2;
                Object obj4 = c24687z23.h;
                if (obj4 == null && (obj4 = c24687z23.j) == null) {
                    AbstractC10736c67 abstractC10736c67 = c24687z23.k;
                    if (abstractC10736c67 != null) {
                        obj2 = abstractC10736c67;
                    }
                } else {
                    obj2 = obj4;
                }
            }
            if (obj2 == null) {
                return "stripped" + AbstractC9325Zl2.h(obj) + "_" + obj3;
            }
            if (obj2 instanceof AbstractC18106o57) {
                return "stripped" + AbstractC9325Zl2.h(obj) + "_" + ((AbstractC18106o57) obj2).c;
            }
            if (obj2 instanceof AbstractC10736c67) {
                return "stripped" + AbstractC9325Zl2.h(obj) + "_" + ((AbstractC10736c67) obj2).d;
            }
            if (obj2 instanceof AbstractC11500d67) {
                AbstractC11500d67 abstractC11500d67 = (AbstractC11500d67) obj2;
                if (abstractC11500d67.c == null) {
                    return "stripped" + AbstractC9325Zl2.h(obj);
                }
                return "stripped" + AbstractC9325Zl2.h(obj) + "_" + abstractC11500d67.c.d + "_" + abstractC11500d67.c.c;
            }
            if (obj2 instanceof AbstractC20488s57) {
                AbstractC20488s57 abstractC20488s57 = (AbstractC20488s57) obj2;
                return "stripped" + AbstractC9325Zl2.h(obj) + "_" + abstractC20488s57.d + "_" + abstractC20488s57.c;
            }
        }
        return "stripped" + AbstractC9325Zl2.h(obj);
    }

    public String m(Object obj, Object obj2, boolean z) {
        String str;
        AbstractC11500d67 abstractC11500d67 = this.j;
        if ((abstractC11500d67 instanceof C8758Xe7) || (abstractC11500d67 instanceof C7317Re7)) {
            if (abstractC11500d67.g.length > 0) {
                return o(obj, obj2, abstractC11500d67);
            }
            return null;
        }
        if (this.f != null) {
            return this.f.c + "_" + this.f.d;
        }
        C12154e78 c12154e78 = this.t;
        if (c12154e78 != null) {
            return Utilities.a(c12154e78.b);
        }
        if (this.h == null && (str = this.g) != null) {
            return Utilities.a(str);
        }
        return null;
    }

    public long n() {
        int i;
        AbstractC11500d67 abstractC11500d67 = this.j;
        if (abstractC11500d67 != null) {
            i = abstractC11500d67.f;
        } else {
            AbstractC18106o57 abstractC18106o57 = this.h;
            if (abstractC18106o57 != null) {
                return abstractC18106o57.j;
            }
            C12154e78 c12154e78 = this.t;
            if (c12154e78 == null) {
                return this.p;
            }
            i = c12154e78.e;
        }
        return i;
    }

    public boolean p() {
        return this.c != null;
    }
}
