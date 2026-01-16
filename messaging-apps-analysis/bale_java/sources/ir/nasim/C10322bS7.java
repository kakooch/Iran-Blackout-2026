package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.C13871gx5;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.bS7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C10322bS7 {
    public static final a f = new a(null);
    private final b a;
    private final C13871gx5.d b;
    private final EnumC15858kI1 c;
    private final Integer d;
    private final String e;

    /* renamed from: ir.nasim.bS7$a */
    public static final class a {

        /* renamed from: ir.nasim.bS7$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0908a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[C13871gx5.c.values().length];
                iArr[C13871gx5.c.WARNING.ordinal()] = 1;
                iArr[C13871gx5.c.ERROR.ordinal()] = 2;
                iArr[C13871gx5.c.HIDDEN.ordinal()] = 3;
                a = iArr;
            }
        }

        private a() {
        }

        public final C10322bS7 a(int i, InterfaceC6692Oo4 interfaceC6692Oo4, C10938cS7 c10938cS7) {
            EnumC15858kI1 enumC15858kI1;
            AbstractC13042fc3.i(interfaceC6692Oo4, "nameResolver");
            AbstractC13042fc3.i(c10938cS7, "table");
            C13871gx5 c13871gx5B = c10938cS7.b(i);
            if (c13871gx5B == null) {
                return null;
            }
            b bVarA = b.d.a(c13871gx5B.N() ? Integer.valueOf(c13871gx5B.G()) : null, c13871gx5B.O() ? Integer.valueOf(c13871gx5B.H()) : null);
            C13871gx5.c cVarE = c13871gx5B.E();
            AbstractC13042fc3.f(cVarE);
            int i2 = C0908a.a[cVarE.ordinal()];
            if (i2 == 1) {
                enumC15858kI1 = EnumC15858kI1.a;
            } else if (i2 == 2) {
                enumC15858kI1 = EnumC15858kI1.b;
            } else {
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                enumC15858kI1 = EnumC15858kI1.c;
            }
            EnumC15858kI1 enumC15858kI12 = enumC15858kI1;
            Integer numValueOf = c13871gx5B.K() ? Integer.valueOf(c13871gx5B.D()) : null;
            String string = c13871gx5B.M() ? interfaceC6692Oo4.getString(c13871gx5B.F()) : null;
            C13871gx5.d dVarJ = c13871gx5B.J();
            AbstractC13042fc3.h(dVarJ, "info.versionKind");
            return new C10322bS7(bVarA, dVarJ, enumC15858kI12, numValueOf, string);
        }

        public final List b(kotlin.reflect.jvm.internal.impl.protobuf.l lVar, InterfaceC6692Oo4 interfaceC6692Oo4, C10938cS7 c10938cS7) {
            List<Integer> listH0;
            AbstractC13042fc3.i(lVar, "proto");
            AbstractC13042fc3.i(interfaceC6692Oo4, "nameResolver");
            AbstractC13042fc3.i(c10938cS7, "table");
            if (lVar instanceof C6526Nw5) {
                listH0 = ((C6526Nw5) lVar).M0();
            } else if (lVar instanceof C6765Ow5) {
                listH0 = ((C6765Ow5) lVar).R();
            } else if (lVar instanceof C7950Tw5) {
                listH0 = ((C7950Tw5) lVar).n0();
            } else if (lVar instanceof C9193Yw5) {
                listH0 = ((C9193Yw5) lVar).k0();
            } else {
                if (!(lVar instanceof C11410cx5)) {
                    throw new IllegalStateException(AbstractC13042fc3.q("Unexpected declaration: ", lVar.getClass()));
                }
                listH0 = ((C11410cx5) lVar).h0();
            }
            AbstractC13042fc3.h(listH0, "ids");
            ArrayList arrayList = new ArrayList();
            for (Integer num : listH0) {
                AbstractC13042fc3.h(num, "id");
                C10322bS7 c10322bS7A = a(num.intValue(), interfaceC6692Oo4, c10938cS7);
                if (c10322bS7A != null) {
                    arrayList.add(c10322bS7A);
                }
            }
            return arrayList;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.bS7$b */
    public static final class b {
        public static final a d = new a(null);
        public static final b e = new b(256, 256, 256);
        private final int a;
        private final int b;
        private final int c;

        /* renamed from: ir.nasim.bS7$b$a */
        public static final class a {
            private a() {
            }

            public final b a(Integer num, Integer num2) {
                return num2 != null ? new b(num2.intValue() & 255, (num2.intValue() >> 8) & 255, (num2.intValue() >> 16) & 255) : num != null ? new b(num.intValue() & 7, (num.intValue() >> 3) & 15, (num.intValue() >> 7) & 127) : b.e;
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        public b(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        public final String a() {
            StringBuilder sb;
            int i;
            if (this.c == 0) {
                sb = new StringBuilder();
                sb.append(this.a);
                sb.append('.');
                i = this.b;
            } else {
                sb = new StringBuilder();
                sb.append(this.a);
                sb.append('.');
                sb.append(this.b);
                sb.append('.');
                i = this.c;
            }
            sb.append(i);
            return sb.toString();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.b == bVar.b && this.c == bVar.c;
        }

        public int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.c;
        }

        public String toString() {
            return a();
        }

        public /* synthetic */ b(int i, int i2, int i3, int i4, ED1 ed1) {
            this(i, i2, (i4 & 4) != 0 ? 0 : i3);
        }
    }

    public C10322bS7(b bVar, C13871gx5.d dVar, EnumC15858kI1 enumC15858kI1, Integer num, String str) {
        AbstractC13042fc3.i(bVar, ParameterNames.VERSION);
        AbstractC13042fc3.i(dVar, "kind");
        AbstractC13042fc3.i(enumC15858kI1, "level");
        this.a = bVar;
        this.b = dVar;
        this.c = enumC15858kI1;
        this.d = num;
        this.e = str;
    }

    public final C13871gx5.d a() {
        return this.b;
    }

    public final b b() {
        return this.a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("since ");
        sb.append(this.a);
        sb.append(' ');
        sb.append(this.c);
        Integer num = this.d;
        sb.append(num != null ? AbstractC13042fc3.q(" error ", num) : "");
        String str = this.e;
        sb.append(str != null ? AbstractC13042fc3.q(": ", str) : "");
        return sb.toString();
    }
}
