package ir.nasim;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public abstract class G90 implements com.google.android.exoplayer2.upstream.a {
    private final boolean a;
    private final ArrayList b = new ArrayList(1);
    private int c;
    private com.google.android.exoplayer2.upstream.b d;

    protected G90(boolean z) {
        this.a = z;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public final void i(InterfaceC25209zu7 interfaceC25209zu7) {
        AbstractC20011rK.e(interfaceC25209zu7);
        if (this.b.contains(interfaceC25209zu7)) {
            return;
        }
        this.b.add(interfaceC25209zu7);
        this.c++;
    }

    protected final void n(int i) {
        com.google.android.exoplayer2.upstream.b bVar = (com.google.android.exoplayer2.upstream.b) AbstractC9683aN7.j(this.d);
        for (int i2 = 0; i2 < this.c; i2++) {
            ((InterfaceC25209zu7) this.b.get(i2)).g(this, bVar, this.a, i);
        }
    }

    protected final void o() {
        com.google.android.exoplayer2.upstream.b bVar = (com.google.android.exoplayer2.upstream.b) AbstractC9683aN7.j(this.d);
        for (int i = 0; i < this.c; i++) {
            ((InterfaceC25209zu7) this.b.get(i)).b(this, bVar, this.a);
        }
        this.d = null;
    }

    protected final void p(com.google.android.exoplayer2.upstream.b bVar) {
        for (int i = 0; i < this.c; i++) {
            ((InterfaceC25209zu7) this.b.get(i)).i(this, bVar, this.a);
        }
    }

    protected final void q(com.google.android.exoplayer2.upstream.b bVar) {
        this.d = bVar;
        for (int i = 0; i < this.c; i++) {
            ((InterfaceC25209zu7) this.b.get(i)).h(this, bVar, this.a);
        }
    }
}
