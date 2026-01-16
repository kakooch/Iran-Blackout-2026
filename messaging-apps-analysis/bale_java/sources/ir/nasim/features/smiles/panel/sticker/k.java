package ir.nasim.features.smiles.panel.sticker;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC4310Eo7;
import ir.nasim.AbstractC8943Xx1;
import ir.nasim.C23698xM6;
import ir.nasim.C6011Lu2;
import ir.nasim.ED1;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC3346Am2;
import ir.nasim.InterfaceC8091Um2;
import ir.nasim.JF5;
import ir.nasim.RF6;
import ir.nasim.TA5;
import ir.nasim.features.smiles.panel.sticker.d;
import ir.nasim.features.smiles.panel.sticker.k;
import ir.nasim.features.smiles.widget.StickerView;

/* loaded from: classes6.dex */
public abstract class k extends RecyclerView.C {
    private int u;

    public static final class a extends k {
        private final TextView v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TextView textView) {
            super(textView, null);
            AbstractC13042fc3.i(textView, "textView");
            this.v = textView;
        }

        @Override // ir.nasim.features.smiles.panel.sticker.k
        /* renamed from: F0, reason: merged with bridge method [inline-methods] */
        public void C0(d.a aVar) {
            String strB;
            AbstractC13042fc3.i(aVar, "item");
            E0(aVar.a());
            this.v.setTextDirection(JF5.g() ? 4 : 3);
            if (aVar.c() == null && aVar.b() == null) {
                this.v.setLayoutParams(new FrameLayout.LayoutParams(-1, AbstractC8943Xx1.c(32)));
                return;
            }
            if (aVar.c() != null) {
                strB = this.v.getContext().getString(aVar.c().intValue());
                AbstractC13042fc3.f(strB);
            } else {
                strB = aVar.b();
                if (strB == null) {
                    strB = "";
                }
            }
            this.v.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            TextView textView = this.v;
            textView.setTextColor(AbstractC4043Dl1.c(textView.getContext(), TA5.color8));
            this.v.setTextSize(1, 12.0f);
            this.v.setTypeface(C6011Lu2.k());
            this.v.setPadding(AbstractC8943Xx1.c(12), AbstractC8943Xx1.c(8), AbstractC8943Xx1.c(12), 0);
            this.v.setText(strB);
        }

        @Override // ir.nasim.features.smiles.panel.sticker.k
        public void a() {
            this.v.setText("");
        }
    }

    public static final class b extends k {
        private C23698xM6 A;
        private final StickerView v;
        private final InterfaceC14603iB2 w;
        private final InterfaceC14603iB2 x;
        private boolean y;
        private String z;

        public static final class a implements InterfaceC8091Um2 {
            final /* synthetic */ d.b b;

            a(d.b bVar) {
                this.b = bVar;
            }

            @Override // ir.nasim.InterfaceC8091Um2
            public void c(float f) {
            }

            @Override // ir.nasim.InterfaceC8091Um2
            public void d(InterfaceC3346Am2 interfaceC3346Am2) {
                AbstractC13042fc3.i(interfaceC3346Am2, "reference");
                b.this.w.invoke(Integer.valueOf(this.b.b().y()), interfaceC3346Am2.getDescriptor());
            }

            @Override // ir.nasim.InterfaceC8091Um2
            public void e() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(StickerView stickerView, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22) {
            super(stickerView, null);
            AbstractC13042fc3.i(stickerView, "stickerView");
            AbstractC13042fc3.i(interfaceC14603iB2, "onCacheSticker");
            AbstractC13042fc3.i(interfaceC14603iB22, "onEmojiSelectedListener");
            this.v = stickerView;
            this.w = interfaceC14603iB2;
            this.x = interfaceC14603iB22;
            stickerView.setLayoutParams(new FrameLayout.LayoutParams(RF6.h(), RF6.h()));
            stickerView.setPadding(AbstractC8943Xx1.c(8), AbstractC8943Xx1.c(8), AbstractC8943Xx1.c(8), AbstractC8943Xx1.c(8));
            stickerView.setBackground(AbstractC4310Eo7.h(5.0f));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void L0(b bVar, d.b bVar2, View view) {
            AbstractC13042fc3.i(bVar, "this$0");
            AbstractC13042fc3.i(bVar2, "$item");
            bVar.x.invoke(bVar2.b(), Boolean.valueOf(bVar2.c()));
        }

        @Override // ir.nasim.features.smiles.panel.sticker.k
        /* renamed from: J0, reason: merged with bridge method [inline-methods] */
        public void C0(final d.b bVar) {
            AbstractC13042fc3.i(bVar, "item");
            E0(bVar.a());
            this.A = bVar.b();
            this.y = bVar.c();
            String str = this.z;
            if (str != null) {
                StickerView stickerView = this.v;
                AbstractC13042fc3.f(str);
                stickerView.h(str);
            } else {
                this.v.a(bVar.b().z(), new a(bVar));
            }
            this.v.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.DN6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    k.b.L0(this.a, bVar, view);
                }
            });
        }

        public final C23698xM6 M0() {
            return this.A;
        }

        public final boolean N0() {
            return this.y;
        }

        public final void O0(String str) {
            this.z = str;
        }

        @Override // ir.nasim.features.smiles.panel.sticker.k
        public void a() {
            this.v.m();
        }
    }

    public /* synthetic */ k(View view, ED1 ed1) {
        this(view);
    }

    public abstract void C0(d dVar);

    public final int D0() {
        return this.u;
    }

    protected final void E0(int i) {
        this.u = i;
    }

    public abstract void a();

    private k(View view) {
        super(view);
        this.u = -1;
    }
}
