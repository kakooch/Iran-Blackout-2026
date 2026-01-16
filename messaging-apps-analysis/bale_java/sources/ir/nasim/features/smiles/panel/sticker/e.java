package ir.nasim.features.smiles.panel.sticker;

import android.content.res.ColorStateList;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC4310Eo7;
import ir.nasim.AbstractC8943Xx1;
import ir.nasim.C23698xM6;
import ir.nasim.ED1;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC3346Am2;
import ir.nasim.InterfaceC8091Um2;
import ir.nasim.RF6;
import ir.nasim.TA5;
import ir.nasim.features.smiles.panel.sticker.e;
import ir.nasim.features.smiles.panel.sticker.l;
import ir.nasim.features.smiles.widget.StickerView;
import ir.nasim.features.smiles.widget.TabLayoutRecycler;

/* loaded from: classes6.dex */
public abstract class e extends RecyclerView.C implements TabLayoutRecycler.b {
    public static final a v = new a(null);
    public static final int w = 8;
    private static final int x;
    private static final int y;
    private int u;

    public static final class a {
        private a() {
        }

        public final int a() {
            return e.x;
        }

        public final int b() {
            return e.y;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b extends e {
        private final InterfaceC14603iB2 A;
        private final StickerTabVHParent z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(StickerTabVHParent stickerTabVHParent, InterfaceC14603iB2 interfaceC14603iB2) {
            super(stickerTabVHParent, null);
            AbstractC13042fc3.i(stickerTabVHParent, "parentView");
            AbstractC13042fc3.i(interfaceC14603iB2, "onTabSelected");
            this.z = stickerTabVHParent;
            this.A = interfaceC14603iB2;
            a aVar = e.v;
            stickerTabVHParent.a(new FrameLayout.LayoutParams(aVar.b(), aVar.b(), 16));
            int iB = (aVar.b() - RF6.a.f()) / 2;
            ImageView imageView = (ImageView) stickerTabVHParent.getChild();
            imageView.setPadding(iB, iB, iB, iB);
            imageView.setBackground(AbstractC4310Eo7.h(5.0f));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void L0(b bVar, l.b bVar2, int i, View view) {
            AbstractC13042fc3.i(bVar, "this$0");
            AbstractC13042fc3.i(bVar2, "$item");
            bVar.A.invoke(bVar2, Integer.valueOf(i));
        }

        @Override // ir.nasim.features.smiles.panel.sticker.e
        /* renamed from: J0, reason: merged with bridge method [inline-methods] */
        public void E0(final l.b bVar, final int i) {
            AbstractC13042fc3.i(bVar, "item");
            F0(bVar.a());
            ((ImageView) this.z.getChild()).setImageResource(bVar.b());
            this.z.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.uN6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.b.L0(this.a, bVar, i, view);
                }
            });
        }

        @Override // ir.nasim.features.smiles.panel.sticker.e
        public void a() {
            ((ImageView) this.z.getChild()).setImageBitmap(null);
        }

        @Override // ir.nasim.features.smiles.widget.TabLayoutRecycler.b
        public void c() {
            ImageView imageView = (ImageView) this.z.getChild();
            imageView.setImageTintList(ColorStateList.valueOf(AbstractC4043Dl1.c(imageView.getContext(), TA5.secondary_2)));
        }

        @Override // ir.nasim.features.smiles.widget.TabLayoutRecycler.b
        public void p() {
            ImageView imageView = (ImageView) this.z.getChild();
            imageView.setImageTintList(ColorStateList.valueOf(AbstractC4043Dl1.c(imageView.getContext(), TA5.color8)));
        }
    }

    public static final class c extends e {
        private final InterfaceC14603iB2 A;
        private final InterfaceC14603iB2 B;
        private String D;
        private C23698xM6 G;
        private final StickerTabVHParent z;

        public static final class a implements InterfaceC8091Um2 {
            final /* synthetic */ l.a b;

            a(l.a aVar) {
                this.b = aVar;
            }

            @Override // ir.nasim.InterfaceC8091Um2
            public void c(float f) {
            }

            @Override // ir.nasim.InterfaceC8091Um2
            public void d(InterfaceC3346Am2 interfaceC3346Am2) {
                AbstractC13042fc3.i(interfaceC3346Am2, "reference");
                c.this.A.invoke(Integer.valueOf(this.b.b().y()), interfaceC3346Am2.getDescriptor());
            }

            @Override // ir.nasim.InterfaceC8091Um2
            public void e() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(StickerTabVHParent stickerTabVHParent, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22) {
            super(stickerTabVHParent, null);
            AbstractC13042fc3.i(stickerTabVHParent, "parentView");
            AbstractC13042fc3.i(interfaceC14603iB2, "onCacheSticker");
            AbstractC13042fc3.i(interfaceC14603iB22, "onTabSelected");
            this.z = stickerTabVHParent;
            this.A = interfaceC14603iB2;
            this.B = interfaceC14603iB22;
            a aVar = e.v;
            stickerTabVHParent.a(new FrameLayout.LayoutParams(aVar.b(), aVar.b(), 16));
            StickerView stickerView = (StickerView) stickerTabVHParent.getChild();
            stickerView.setPadding(aVar.a(), aVar.a(), aVar.a(), aVar.a());
            stickerView.setBackground(AbstractC4310Eo7.h(5.0f));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void M0(c cVar, l.a aVar, View view) {
            AbstractC13042fc3.i(cVar, "this$0");
            AbstractC13042fc3.i(aVar, "$item");
            cVar.B.invoke(aVar, Integer.valueOf(cVar.K()));
        }

        @Override // ir.nasim.features.smiles.panel.sticker.e
        /* renamed from: L0, reason: merged with bridge method [inline-methods] */
        public void E0(final l.a aVar, int i) {
            AbstractC13042fc3.i(aVar, "item");
            F0(aVar.a());
            this.G = aVar.b();
            if (this.D != null) {
                StickerView stickerView = (StickerView) this.z.getChild();
                String str = this.D;
                AbstractC13042fc3.f(str);
                stickerView.h(str);
            } else {
                ((StickerView) this.z.getChild()).a(aVar.b().z(), new a(aVar));
            }
            ((StickerView) this.z.getChild()).setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.vN6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.c.M0(this.a, aVar, view);
                }
            });
        }

        public final void N0(String str) {
            this.D = str;
        }

        @Override // ir.nasim.features.smiles.panel.sticker.e
        public void a() {
            ((StickerView) this.z.getChild()).m();
        }

        @Override // ir.nasim.features.smiles.widget.TabLayoutRecycler.b
        public void c() {
        }

        @Override // ir.nasim.features.smiles.widget.TabLayoutRecycler.b
        public void p() {
        }
    }

    static {
        int iC = AbstractC8943Xx1.c(2);
        x = iC;
        y = RF6.a.j() + (iC * 2);
    }

    public /* synthetic */ e(StickerTabVHParent stickerTabVHParent, ED1 ed1) {
        this(stickerTabVHParent);
    }

    public abstract void E0(l lVar, int i);

    protected final void F0(int i) {
        this.u = i;
    }

    public abstract void a();

    private e(StickerTabVHParent stickerTabVHParent) {
        super(stickerTabVHParent);
        this.u = -1;
    }
}
