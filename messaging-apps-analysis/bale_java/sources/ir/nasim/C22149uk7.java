package ir.nasim;

import android.content.Context;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* renamed from: ir.nasim.uk7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C22149uk7 extends AbstractC17457n0 {
    private long c;
    private AbstractC17457n0 d;
    private String e;
    private V73 f;
    private UO5 g;
    private XO5 h;

    public C22149uk7(C11909dl1 c11909dl1) {
        super(c11909dl1);
        TC tc = (TC) c11909dl1.c();
        this.d = AbstractC17457n0.h(tc.u());
        this.c = tc.D();
        this.e = tc.C();
        this.f = new V73(c11909dl1);
        this.g = new UO5(c11909dl1);
        this.h = new XO5(c11909dl1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream z(W73 w73) {
        return w73.a().stream();
    }

    @Override // ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        return this.d.b(context, i, str, z);
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C22149uk7 c22149uk7 = (C22149uk7) obj;
        return this.c == c22149uk7.c && Objects.equals(this.d, c22149uk7.d) && Objects.equals(this.e, c22149uk7.e) && Objects.equals(this.f, c22149uk7.f) && Objects.equals(this.g, c22149uk7.g) && Objects.equals(this.h, c22149uk7.h);
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.c), this.d, this.e, this.f, this.g, this.h);
    }

    @Override // ir.nasim.AbstractC17457n0
    public String j(Context context) {
        String str = (String) this.f.r().stream().flatMap(new Function() { // from class: ir.nasim.sk7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return C22149uk7.z((W73) obj);
            }
        }).map(new Function() { // from class: ir.nasim.tk7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((U73) obj).f();
            }
        }).collect(Collectors.joining(", "));
        if (l().v() == null) {
            return "";
        }
        return l().v() + str;
    }

    @Override // ir.nasim.AbstractC17457n0
    public C23345wl7 l() {
        return t().l();
    }

    public V73 s() {
        return this.f;
    }

    public AbstractC17457n0 t() {
        return this.d;
    }

    public UO5 u() {
        return this.g;
    }

    public long v() {
        return this.c;
    }

    public boolean w() {
        List listR;
        V73 v73 = this.f;
        return (v73 == null || (listR = v73.r()) == null || listR.size() <= 0) ? false : true;
    }

    public boolean x() {
        UO5 uo5 = this.g;
        return (uo5 == null || uo5.s().isEmpty()) ? false : true;
    }

    public boolean y() {
        XO5 xo5 = this.h;
        return xo5 != null && xo5.r();
    }
}
