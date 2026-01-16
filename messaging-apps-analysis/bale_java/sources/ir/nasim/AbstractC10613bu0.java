package ir.nasim;

import android.text.Spannable;

/* renamed from: ir.nasim.bu0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC10613bu0 {

    /* renamed from: ir.nasim.bu0$a */
    public static final class a extends AbstractC10613bu0 {
        private final Spannable a;
        private final Spannable b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Spannable spannable, Spannable spannable2) {
            super(null);
            AbstractC13042fc3.i(spannable, "title");
            this.a = spannable;
            this.b = spannable2;
        }

        @Override // ir.nasim.AbstractC10613bu0
        public Spannable a() {
            return this.b;
        }

        @Override // ir.nasim.AbstractC10613bu0
        public Spannable b() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.bu0$b */
    public static final class b extends AbstractC10613bu0 {
        private final Spannable a;
        private final Spannable b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Spannable spannable, Spannable spannable2) {
            super(null);
            AbstractC13042fc3.i(spannable, "title");
            this.a = spannable;
            this.b = spannable2;
        }

        @Override // ir.nasim.AbstractC10613bu0
        public Spannable a() {
            return this.b;
        }

        @Override // ir.nasim.AbstractC10613bu0
        public Spannable b() {
            return this.a;
        }
    }

    private AbstractC10613bu0() {
    }

    public abstract Spannable a();

    public abstract Spannable b();

    public /* synthetic */ AbstractC10613bu0(ED1 ed1) {
        this();
    }
}
