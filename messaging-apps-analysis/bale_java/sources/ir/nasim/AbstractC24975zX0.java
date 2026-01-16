package ir.nasim;

import android.graphics.ColorFilter;

/* renamed from: ir.nasim.zX0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC24975zX0 {
    public static final a b = new a(null);
    private final ColorFilter a;

    /* renamed from: ir.nasim.zX0$a */
    public static final class a {
        private a() {
        }

        public static /* synthetic */ AbstractC24975zX0 b(a aVar, long j, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = AbstractC7094Qg0.a.z();
            }
            return aVar.a(j, i);
        }

        public final AbstractC24975zX0 a(long j, int i) {
            return new C7328Rg0(j, i, (ED1) null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public AbstractC24975zX0(ColorFilter colorFilter) {
        this.a = colorFilter;
    }

    public final ColorFilter a() {
        return this.a;
    }
}
