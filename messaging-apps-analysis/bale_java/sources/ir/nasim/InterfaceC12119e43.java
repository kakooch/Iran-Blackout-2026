package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.e43, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC12119e43 extends List, InterfaceC9502a43, InterfaceC17915nm3 {

    /* renamed from: ir.nasim.e43$a */
    private static final class a extends AbstractC11442d1 implements InterfaceC12119e43 {
        private final InterfaceC12119e43 a;
        private final int b;
        private final int c;
        private int d;

        public a(InterfaceC12119e43 interfaceC12119e43, int i, int i2) {
            this.a = interfaceC12119e43;
            this.b = i;
            this.c = i2;
            MB3.c(i, i2, interfaceC12119e43.size());
            this.d = i2 - i;
        }

        @Override // ir.nasim.AbstractC11442d1, java.util.List
        public Object get(int i) {
            MB3.a(i, this.d);
            return this.a.get(this.b + i);
        }

        @Override // ir.nasim.G0
        public int getSize() {
            return this.d;
        }

        @Override // ir.nasim.AbstractC11442d1, java.util.List
        public InterfaceC12119e43 subList(int i, int i2) {
            MB3.c(i, i2, this.d);
            InterfaceC12119e43 interfaceC12119e43 = this.a;
            int i3 = this.b;
            return new a(interfaceC12119e43, i + i3, i3 + i2);
        }
    }

    @Override // java.util.List
    default InterfaceC12119e43 subList(int i, int i2) {
        return new a(this, i, i2);
    }
}
