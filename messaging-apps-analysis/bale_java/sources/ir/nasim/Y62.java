package ir.nasim;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.X62;
import ir.nasim.features.smiles.widget.ImageViewEmoji;

/* loaded from: classes6.dex */
public abstract class Y62 extends RecyclerView.C {
    private int u;

    public static final class a extends Y62 {
        private final ImageViewEmoji v;
        private final UA2 w;

        /* renamed from: ir.nasim.Y62$a$a, reason: collision with other inner class name */
        /* synthetic */ class C0782a extends EB2 implements UA2 {
            C0782a(Object obj) {
                super(1, obj, UA2.class, "invoke", "invoke(Ljava/lang/Object;)Ljava/lang/Object;", 0);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                y((String) obj);
                return C19938rB7.a;
            }

            public final void y(String str) {
                AbstractC13042fc3.i(str, "p0");
                ((UA2) this.receiver).invoke(str);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ImageViewEmoji imageViewEmoji, UA2 ua2) {
            super(imageViewEmoji, null);
            AbstractC13042fc3.i(imageViewEmoji, "viewEmoji");
            AbstractC13042fc3.i(ua2, "listener");
            this.v = imageViewEmoji;
            this.w = ua2;
        }

        @Override // ir.nasim.Y62
        /* renamed from: F0, reason: merged with bridge method [inline-methods] */
        public void C0(X62.a aVar) {
            AbstractC13042fc3.i(aVar, "item");
            E0(aVar.c());
            String strB = aVar.b();
            R62 r62 = R62.a;
            String str = (String) r62.z().get(aVar.b());
            if (str != null) {
                strB = r62.m(strB, str);
            }
            this.v.setImageDrawable(r62.y(strB), aVar.d());
            this.v.setTag(aVar.b());
            this.v.setContentDescription(strB);
            if (!aVar.d()) {
                this.v.setShowBadge(T52.a.d().contains(r62.D(aVar.b(), null)));
            }
            this.v.setListener(new C0782a(this.w));
        }
    }

    public static final class b extends Y62 {
        private final TextView v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(TextView textView) {
            super(textView, null);
            AbstractC13042fc3.i(textView, "textView");
            this.v = textView;
        }

        @Override // ir.nasim.Y62
        /* renamed from: F0, reason: merged with bridge method [inline-methods] */
        public void C0(X62.b bVar) {
            AbstractC13042fc3.i(bVar, "item");
            E0(bVar.b());
            TextView textView = this.v;
            textView.setTextColor(AbstractC4043Dl1.c(textView.getContext(), TA5.color8));
            this.v.setTextSize(1, 12.0f);
            this.v.setTypeface(C6011Lu2.k());
            this.v.setPadding(AbstractC8943Xx1.c(12), AbstractC8943Xx1.c(8), AbstractC8943Xx1.c(12), 0);
            this.v.setText(bVar.c());
        }
    }

    public /* synthetic */ Y62(View view, ED1 ed1) {
        this(view);
    }

    public abstract void C0(X62 x62);

    public final int D0() {
        return this.u;
    }

    protected final void E0(int i) {
        this.u = i;
    }

    private Y62(View view) {
        super(view);
        this.u = -1;
    }
}
