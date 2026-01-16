package ir.nasim;

import com.google.firebase.components.DependencyException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
final class T06 extends I0 {
    private final Set a;
    private final Set b;
    private final Set c;
    private final Set d;
    private final Set e;
    private final Set f;
    private final S01 g;

    private static class a implements InterfaceC17444my5 {
        private final Set a;
        private final InterfaceC17444my5 b;

        public a(Set set, InterfaceC17444my5 interfaceC17444my5) {
            this.a = set;
            this.b = interfaceC17444my5;
        }
    }

    T06(I01 i01, S01 s01) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (C10226bI1 c10226bI1 : i01.e()) {
            if (c10226bI1.d()) {
                if (c10226bI1.f()) {
                    hashSet4.add(c10226bI1.b());
                } else {
                    hashSet.add(c10226bI1.b());
                }
            } else if (c10226bI1.c()) {
                hashSet3.add(c10226bI1.b());
            } else if (c10226bI1.f()) {
                hashSet5.add(c10226bI1.b());
            } else {
                hashSet2.add(c10226bI1.b());
            }
        }
        if (!i01.i().isEmpty()) {
            hashSet.add(InterfaceC17444my5.class);
        }
        this.a = Collections.unmodifiableSet(hashSet);
        this.b = Collections.unmodifiableSet(hashSet2);
        this.c = Collections.unmodifiableSet(hashSet3);
        this.d = Collections.unmodifiableSet(hashSet4);
        this.e = Collections.unmodifiableSet(hashSet5);
        this.f = i01.i();
        this.g = s01;
    }

    @Override // ir.nasim.I0, ir.nasim.S01
    public Object a(Class cls) {
        if (!this.a.contains(cls)) {
            throw new DependencyException(String.format("Attempting to request an undeclared dependency %s.", cls));
        }
        Object objA = this.g.a(cls);
        return !cls.equals(InterfaceC17444my5.class) ? objA : new a(this.f, (InterfaceC17444my5) objA);
    }

    @Override // ir.nasim.S01
    public InterfaceC7959Tx5 b(Class cls) {
        if (this.e.contains(cls)) {
            return this.g.b(cls);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", cls));
    }

    @Override // ir.nasim.I0, ir.nasim.S01
    public Set c(Class cls) {
        if (this.d.contains(cls)) {
            return this.g.c(cls);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Set<%s>.", cls));
    }

    @Override // ir.nasim.S01
    public InterfaceC7959Tx5 d(Class cls) {
        if (this.b.contains(cls)) {
            return this.g.d(cls);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<%s>.", cls));
    }
}
