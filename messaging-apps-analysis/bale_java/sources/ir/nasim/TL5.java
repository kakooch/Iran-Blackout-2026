package ir.nasim;

import java.lang.annotation.Annotation;
import java.util.List;

/* loaded from: classes8.dex */
public final class TL5 extends IL5 implements InterfaceC9065Yi3 {
    private final RL5 a;
    private final Annotation[] b;
    private final String c;
    private final boolean d;

    public TL5(RL5 rl5, Annotation[] annotationArr, String str, boolean z) {
        AbstractC13042fc3.i(rl5, "type");
        AbstractC13042fc3.i(annotationArr, "reflectAnnotations");
        this.a = rl5;
        this.b = annotationArr;
        this.c = str;
        this.d = z;
    }

    @Override // ir.nasim.InterfaceC5194Ih3
    public boolean E() {
        return false;
    }

    @Override // ir.nasim.InterfaceC5194Ih3
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public C22502vL5 z(C9424Zw2 c9424Zw2) {
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        return AbstractC24872zL5.a(this.b, c9424Zw2);
    }

    @Override // ir.nasim.InterfaceC5194Ih3
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public List getAnnotations() {
        return AbstractC24872zL5.b(this.b);
    }

    @Override // ir.nasim.InterfaceC9065Yi3
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public RL5 getType() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC9065Yi3
    public boolean c() {
        return this.d;
    }

    @Override // ir.nasim.InterfaceC9065Yi3
    public C6432No4 getName() {
        String str = this.c;
        if (str == null) {
            return null;
        }
        return C6432No4.o(str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TL5.class.getName());
        sb.append(": ");
        sb.append(c() ? "vararg " : "");
        sb.append(getName());
        sb.append(": ");
        sb.append(getType());
        return sb.toString();
    }
}
