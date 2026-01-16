package ir.nasim;

import ir.nasim.EY7;
import java.lang.reflect.Modifier;

/* loaded from: classes8.dex */
public interface OL5 extends InterfaceC21535ti3 {

    public static final class a {
        public static GY7 a(OL5 ol5) {
            AbstractC13042fc3.i(ol5, "this");
            int iJ = ol5.J();
            return Modifier.isPublic(iJ) ? EY7.h.c : Modifier.isPrivate(iJ) ? EY7.e.c : Modifier.isProtected(iJ) ? Modifier.isStatic(iJ) ? C11269cj3.c : C10506bj3.c : C9886aj3.c;
        }

        public static boolean b(OL5 ol5) {
            AbstractC13042fc3.i(ol5, "this");
            return Modifier.isAbstract(ol5.J());
        }

        public static boolean c(OL5 ol5) {
            AbstractC13042fc3.i(ol5, "this");
            return Modifier.isFinal(ol5.J());
        }

        public static boolean d(OL5 ol5) {
            AbstractC13042fc3.i(ol5, "this");
            return Modifier.isStatic(ol5.J());
        }
    }

    int J();
}
