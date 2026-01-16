package ir.nasim;

import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.ComposeAnimationType;
import java.util.Set;

/* renamed from: ir.nasim.Js, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5523Js implements ComposeAnimation, InterfaceC23445wv7 {
    public static final a e = new a(null);
    public static final int f = 8;
    private static boolean g;
    private final C21669tv7 a;
    private final Set b;
    private final String c;
    private final ComposeAnimationType d;

    /* renamed from: ir.nasim.Js$a */
    public static final class a {
        private a() {
        }

        public final boolean a() {
            return C5523Js.g;
        }

        public final C5523Js b(C21669tv7 c21669tv7) {
            Object objH;
            Set setC;
            ED1 ed1 = null;
            if (!a() || (objH = c21669tv7.h()) == null) {
                return null;
            }
            Object[] enumConstants = objH.getClass().getEnumConstants();
            if (enumConstants == null || (setC = AbstractC10242bK.s1(enumConstants)) == null) {
                setC = AbstractC4363Eu6.c(objH);
            }
            String strJ = c21669tv7.j();
            if (strJ == null) {
                strJ = AbstractC10882cM5.b(objH.getClass()).p();
            }
            return new C5523Js(c21669tv7, setC, strJ, ed1);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        ComposeAnimationType[] composeAnimationTypeArrValues = ComposeAnimationType.values();
        int length = composeAnimationTypeArrValues.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (AbstractC13042fc3.d(composeAnimationTypeArrValues[i].name(), "ANIMATED_CONTENT")) {
                z = true;
                break;
            }
            i++;
        }
        g = z;
    }

    public /* synthetic */ C5523Js(C21669tv7 c21669tv7, Set set, String str, ED1 ed1) {
        this(c21669tv7, set, str);
    }

    @Override // ir.nasim.InterfaceC23445wv7
    public C21669tv7 a() {
        return this.a;
    }

    private C5523Js(C21669tv7 c21669tv7, Set set, String str) {
        this.a = c21669tv7;
        this.b = set;
        this.c = str;
        this.d = ComposeAnimationType.ANIMATED_CONTENT;
    }
}
