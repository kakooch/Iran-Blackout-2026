package ir.nasim;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes8.dex */
public final class FU0 {
    private final String a;
    private List b;
    private final List c;
    private final Set d;
    private final List e;
    private final List f;
    private final List g;

    public FU0(String str) {
        AbstractC13042fc3.i(str, "serialName");
        this.a = str;
        this.b = AbstractC10360bX0.m();
        this.c = new ArrayList();
        this.d = new HashSet();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
    }

    public static /* synthetic */ void b(FU0 fu0, String str, SerialDescriptor serialDescriptor, List list, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            list = AbstractC10360bX0.m();
        }
        if ((i & 8) != 0) {
            z = false;
        }
        fu0.a(str, serialDescriptor, list, z);
    }

    public final void a(String str, SerialDescriptor serialDescriptor, List list, boolean z) {
        AbstractC13042fc3.i(str, "elementName");
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        AbstractC13042fc3.i(list, "annotations");
        if (this.d.add(str)) {
            this.c.add(str);
            this.e.add(serialDescriptor);
            this.f.add(list);
            this.g.add(Boolean.valueOf(z));
            return;
        }
        throw new IllegalArgumentException(("Element with name '" + str + "' is already registered in " + this.a).toString());
    }

    public final List c() {
        return this.b;
    }

    public final List d() {
        return this.f;
    }

    public final List e() {
        return this.e;
    }

    public final List f() {
        return this.c;
    }

    public final List g() {
        return this.g;
    }

    public final void h(List list) {
        AbstractC13042fc3.i(list, "<set-?>");
        this.b = list;
    }
}
