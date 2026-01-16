package ir.nasim;

/* renamed from: ir.nasim.yy7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC24652yy7 implements InterfaceC6907Pm3 {
    public static final a a = new a(null);

    /* renamed from: ir.nasim.yy7$a */
    public static final class a {

        /* renamed from: ir.nasim.yy7$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C1801a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC8326Vm3.values().length];
                try {
                    iArr[EnumC8326Vm3.a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC8326Vm3.b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[EnumC8326Vm3.c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        private a() {
        }

        public final String a(InterfaceC6907Pm3 interfaceC6907Pm3) {
            AbstractC13042fc3.i(interfaceC6907Pm3, "typeParameter");
            StringBuilder sb = new StringBuilder();
            int i = C1801a.a[interfaceC6907Pm3.m().ordinal()];
            if (i == 2) {
                sb.append("in ");
            } else if (i == 3) {
                sb.append("out ");
            }
            sb.append(interfaceC6907Pm3.getName());
            String string = sb.toString();
            AbstractC13042fc3.h(string, "toString(...)");
            return string;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }
}
