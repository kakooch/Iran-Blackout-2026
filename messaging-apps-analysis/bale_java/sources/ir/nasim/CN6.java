package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class CN6 extends AbstractC17902nl0 {
    public static final a d = new a(null);
    public static final int e = 8;
    private static volatile CN6 f;
    private final InterfaceC3570Bk5 a;
    private final InterfaceC9336Zm4 b;
    private final InterfaceC10258bL6 c;

    public static final class a {
        private a() {
        }

        public final CN6 a(InterfaceC3570Bk5 interfaceC3570Bk5) {
            AbstractC13042fc3.i(interfaceC3570Bk5, "preferences");
            if (CN6.f == null) {
                synchronized (BN6.class) {
                    try {
                        if (CN6.f == null) {
                            CN6.f = new CN6(interfaceC3570Bk5);
                        }
                        C19938rB7 c19938rB7 = C19938rB7.a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            CN6 cn6 = CN6.f;
            AbstractC13042fc3.f(cn6);
            return cn6;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return CN6.this.y(null, this);
        }
    }

    public CN6(InterfaceC3570Bk5 interfaceC3570Bk5) {
        String name;
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferences");
        this.a = interfaceC3570Bk5;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new ArrayList());
        this.b = interfaceC9336Zm4A;
        this.c = AbstractC6459Nq2.c(interfaceC9336Zm4A);
        byte[] bArrB = interfaceC3570Bk5.b("stickers.data");
        if (bArrB != null) {
            try {
                load(bArrB);
            } catch (IOException e2) {
                if (CN6.class.isAnonymousClass()) {
                    name = CN6.class.getName();
                    int length = name.length();
                    AbstractC13042fc3.f(name);
                    if (length > 23) {
                        name = name.substring(name.length() - 23, name.length());
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                } else {
                    name = CN6.class.getSimpleName();
                    int length2 = name.length();
                    AbstractC13042fc3.f(name);
                    if (length2 > 23) {
                        name = name.substring(0, 23);
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                }
                C19406qI3.c(name, "load", e2);
            }
        }
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) throws IOException {
        Object value;
        ArrayList arrayList;
        AbstractC13042fc3.i(c19084pl0, "values");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.b;
        do {
            value = interfaceC9336Zm4.getValue();
            List listL = c19084pl0.l(1);
            AbstractC13042fc3.h(listL, "getRepeatedBytes(...)");
            List list = listL;
            arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new OM6((byte[]) it.next()));
            }
        } while (!interfaceC9336Zm4.f(value, arrayList));
    }

    public final void s(OM6 om6) {
        Object value;
        List listP1;
        AbstractC13042fc3.i(om6, "stickerPack");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.b;
        do {
            value = interfaceC9336Zm4.getValue();
            listP1 = AbstractC15401jX0.p1((List) value);
            listP1.add(om6);
        } while (!interfaceC9336Zm4.f(value, listP1));
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        AbstractC13042fc3.i(c19675ql0, "writer");
        c19675ql0.m(1, (List) this.b.getValue());
    }

    public final InterfaceC10258bL6 u() {
        return this.c;
    }

    public final void w(OM6 om6) {
        Object value;
        List listP1;
        AbstractC13042fc3.i(om6, "stickerPack");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.b;
        do {
            value = interfaceC9336Zm4.getValue();
            listP1 = AbstractC15401jX0.p1((List) value);
            listP1.remove(om6);
        } while (!interfaceC9336Zm4.f(value, listP1));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object y(java.util.List r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ir.nasim.CN6.b
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.CN6$b r0 = (ir.nasim.CN6.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.CN6$b r0 = new ir.nasim.CN6$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.a
            ir.nasim.CN6 r5 = (ir.nasim.CN6) r5
            ir.nasim.AbstractC10685c16.b(r6)
            goto L46
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.Zm4 r6 = r4.b
            r0.a = r4
            r0.d = r3
            java.lang.Object r5 = r6.a(r5, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            r5 = r4
        L46:
            ir.nasim.Bk5 r6 = r5.a
            java.lang.String r0 = "stickers.data"
            byte[] r5 = r5.toByteArray()
            r6.f(r0, r5)
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.CN6.y(java.util.List, ir.nasim.rm1):java.lang.Object");
    }
}
