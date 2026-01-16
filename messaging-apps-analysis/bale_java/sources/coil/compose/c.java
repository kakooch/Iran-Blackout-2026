package coil.compose;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC24975zX0;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC13157fl1;
import ir.nasim.InterfaceC5452Jk0;
import ir.nasim.RZ6;

/* loaded from: classes2.dex */
final class c implements RZ6, InterfaceC5452Jk0 {
    private final InterfaceC5452Jk0 a;
    private final AsyncImagePainter b;
    private final String c;
    private final InterfaceC12529em d;
    private final InterfaceC13157fl1 e;
    private final float f;
    private final AbstractC24975zX0 g;
    private final boolean h;

    public c(InterfaceC5452Jk0 interfaceC5452Jk0, AsyncImagePainter asyncImagePainter, String str, InterfaceC12529em interfaceC12529em, InterfaceC13157fl1 interfaceC13157fl1, float f, AbstractC24975zX0 abstractC24975zX0, boolean z) {
        this.a = interfaceC5452Jk0;
        this.b = asyncImagePainter;
        this.c = str;
        this.d = interfaceC12529em;
        this.e = interfaceC13157fl1;
        this.f = f;
        this.g = abstractC24975zX0;
        this.h = z;
    }

    @Override // ir.nasim.RZ6
    public float a() {
        return this.f;
    }

    @Override // ir.nasim.RZ6
    public AbstractC24975zX0 b() {
        return this.g;
    }

    @Override // ir.nasim.RZ6
    public InterfaceC13157fl1 c() {
        return this.e;
    }

    @Override // ir.nasim.InterfaceC5452Jk0
    public androidx.compose.ui.e e(androidx.compose.ui.e eVar) {
        return this.a.e(eVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return AbstractC13042fc3.d(this.a, cVar.a) && AbstractC13042fc3.d(this.b, cVar.b) && AbstractC13042fc3.d(this.c, cVar.c) && AbstractC13042fc3.d(this.d, cVar.d) && AbstractC13042fc3.d(this.e, cVar.e) && Float.compare(this.f, cVar.f) == 0 && AbstractC13042fc3.d(this.g, cVar.g) && this.h == cVar.h;
    }

    @Override // ir.nasim.RZ6
    public InterfaceC12529em f() {
        return this.d;
    }

    @Override // ir.nasim.RZ6
    public AsyncImagePainter g() {
        return this.b;
    }

    @Override // ir.nasim.RZ6
    public String getContentDescription() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC5452Jk0
    public androidx.compose.ui.e h(androidx.compose.ui.e eVar, InterfaceC12529em interfaceC12529em) {
        return this.a.h(eVar, interfaceC12529em);
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String str = this.c;
        int iHashCode2 = (((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + Float.hashCode(this.f)) * 31;
        AbstractC24975zX0 abstractC24975zX0 = this.g;
        return ((iHashCode2 + (abstractC24975zX0 != null ? abstractC24975zX0.hashCode() : 0)) * 31) + Boolean.hashCode(this.h);
    }

    @Override // ir.nasim.RZ6
    public boolean o() {
        return this.h;
    }

    public String toString() {
        return "RealSubcomposeAsyncImageScope(parentScope=" + this.a + ", painter=" + this.b + ", contentDescription=" + this.c + ", alignment=" + this.d + ", contentScale=" + this.e + ", alpha=" + this.f + ", colorFilter=" + this.g + ", clipToBounds=" + this.h + ')';
    }
}
