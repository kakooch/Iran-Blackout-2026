package ir.nasim;

import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import java.util.Map;

/* renamed from: ir.nasim.oG1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC18204oG1 {

    /* renamed from: ir.nasim.oG1$a */
    public interface a {
        c a();
    }

    /* renamed from: ir.nasim.oG1$b */
    public interface b {
        c a();
    }

    /* renamed from: ir.nasim.oG1$c */
    public static final class c {
        private final Map a;
        private final XW7 b;

        c(Map map, XW7 xw7) {
            this.a = map;
            this.b = xw7;
        }

        private G.c c(G.c cVar) {
            return new CV2(this.a, (G.c) AbstractC4497Fj5.b(cVar), this.b);
        }

        G.c a(ComponentActivity componentActivity, G.c cVar) {
            return c(cVar);
        }

        G.c b(Fragment fragment, G.c cVar) {
            return c(cVar);
        }
    }

    public static G.c a(ComponentActivity componentActivity, G.c cVar) {
        return ((a) D92.a(componentActivity, a.class)).a().a(componentActivity, cVar);
    }

    public static G.c b(Fragment fragment, G.c cVar) {
        return ((b) D92.a(fragment, b.class)).a().b(fragment, cVar);
    }
}
