package androidx.compose.ui.draganddrop;

import android.view.DragEvent;
import android.view.View;
import androidx.compose.ui.e;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.BZ1;
import ir.nasim.C23810xZ1;
import ir.nasim.C24994zZ1;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC24400yZ1;
import ir.nasim.PJ;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class AndroidDragAndDropManager implements View.OnDragListener, InterfaceC24400yZ1 {
    private final InterfaceC15796kB2 a;
    private final C24994zZ1 b = new C24994zZ1(null, null, 3, null);
    private final PJ c = new PJ(0, 1, null);
    private final e d = new AbstractC25066zg4() { // from class: androidx.compose.ui.draganddrop.AndroidDragAndDropManager$modifier$1
        public boolean equals(Object other) {
            return other == this;
        }

        public int hashCode() {
            return this.b.b.hashCode();
        }

        @Override // ir.nasim.AbstractC25066zg4
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public C24994zZ1 f() {
            return this.b.b;
        }

        @Override // ir.nasim.AbstractC25066zg4
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void k(C24994zZ1 node) {
        }
    };

    public AndroidDragAndDropManager(InterfaceC15796kB2 interfaceC15796kB2) {
        this.a = interfaceC15796kB2;
    }

    @Override // ir.nasim.InterfaceC24400yZ1
    public boolean a(BZ1 bz1) {
        return this.c.contains(bz1);
    }

    @Override // ir.nasim.InterfaceC24400yZ1
    public void b(BZ1 bz1) {
        this.c.add(bz1);
    }

    public e d() {
        return this.d;
    }

    @Override // android.view.View.OnDragListener
    public boolean onDrag(View view, DragEvent dragEvent) {
        C23810xZ1 c23810xZ1 = new C23810xZ1(dragEvent);
        switch (dragEvent.getAction()) {
            case 1:
                boolean zV2 = this.b.v2(c23810xZ1);
                Iterator<E> it = this.c.iterator();
                while (it.hasNext()) {
                    ((BZ1) it.next()).N(c23810xZ1);
                }
                break;
            case 2:
                this.b.a0(c23810xZ1);
                break;
            case 4:
                this.b.q0(c23810xZ1);
                this.c.clear();
                break;
            case 5:
                this.b.e0(c23810xZ1);
                break;
            case 6:
                this.b.v0(c23810xZ1);
                break;
        }
        return false;
    }
}
