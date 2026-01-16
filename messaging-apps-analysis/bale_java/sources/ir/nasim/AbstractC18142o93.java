package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.o93, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC18142o93 {
    private static final String a = HI3.f("InputMerger");

    public static AbstractC18142o93 a(String str) {
        try {
            return (AbstractC18142o93) Class.forName(str).newInstance();
        } catch (Exception e) {
            HI3.c().b(a, "Trouble instantiating + " + str, e);
            return null;
        }
    }

    public abstract androidx.work.b b(List list);
}
