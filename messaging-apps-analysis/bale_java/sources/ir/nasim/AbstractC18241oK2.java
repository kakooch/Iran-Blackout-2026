package ir.nasim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import ir.nasim.ViewOnTouchListenerC5933Ll4;

/* renamed from: ir.nasim.oK2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC18241oK2 {
    private final Context a;
    private final int b;
    private final ZX7 c;
    private final C19423qK2 d;
    private final View e;

    /* renamed from: ir.nasim.oK2$a */
    public static final class a implements ViewOnTouchListenerC5933Ll4.c {
        final /* synthetic */ C5218Ik0 a;
        final /* synthetic */ AbstractC18241oK2 b;
        final /* synthetic */ C24159y85 c;

        a(C5218Ik0 c5218Ik0, AbstractC18241oK2 abstractC18241oK2, C24159y85 c24159y85) {
            this.a = c5218Ik0;
            this.b = abstractC18241oK2;
            this.c = c24159y85;
        }

        @Override // ir.nasim.ViewOnTouchListenerC5933Ll4.c
        public void a() {
            this.a.b();
            this.b.i();
            this.c.o(this.b.d());
        }

        @Override // ir.nasim.ViewOnTouchListenerC5933Ll4.c
        public void b() {
            AbstractC18241oK2 abstractC18241oK2 = this.b;
            abstractC18241oK2.j(abstractC18241oK2.d());
        }
    }

    public AbstractC18241oK2(Context context, int i, ZX7 zx7, C19423qK2 c19423qK2) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(zx7, "viewType");
        this.a = context;
        this.b = i;
        this.c = zx7;
        this.d = c19423qK2;
        if (i == 0) {
            throw new UnsupportedOperationException("Layout id cannot be zero. Please define a layout");
        }
        View viewInflate = LayoutInflater.from(context).inflate(i, (ViewGroup) null);
        AbstractC13042fc3.h(viewInflate, "from(context).inflate(layoutId, null)");
        this.e = viewInflate;
        h(viewInflate);
        f(viewInflate);
    }

    private final void f(View view) {
        view.setTag(this.c);
        ImageView imageView = (ImageView) view.findViewById(AbstractC20554sC5.imgPhotoEditorClose);
        if (imageView == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.nK2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AbstractC18241oK2.g(this.a, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(AbstractC18241oK2 abstractC18241oK2, View view) {
        AbstractC13042fc3.i(abstractC18241oK2, "this$0");
        C19423qK2 c19423qK2C = abstractC18241oK2.c();
        if (c19423qK2C == null) {
            return;
        }
        c19423qK2C.c(abstractC18241oK2);
    }

    protected final ViewOnTouchListenerC5933Ll4.c b(ViewGroup viewGroup, C24159y85 c24159y85) {
        AbstractC13042fc3.i(viewGroup, "viewGroup");
        AbstractC13042fc3.i(c24159y85, "viewState");
        return new a(new C5218Ik0(viewGroup, c24159y85), this, c24159y85);
    }

    public final C19423qK2 c() {
        return this.d;
    }

    public final View d() {
        return this.e;
    }

    public final ZX7 e() {
        return this.c;
    }

    public abstract void h(View view);

    protected final void i() {
        View viewFindViewById = this.e.findViewById(AbstractC20554sC5.frmBorder);
        View viewFindViewById2 = this.e.findViewById(AbstractC20554sC5.imgPhotoEditorClose);
        if (viewFindViewById != null) {
            viewFindViewById.setBackgroundResource(BB5.rounded_border_tv);
            viewFindViewById.setTag(Boolean.TRUE);
        }
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(0);
        }
    }

    public abstract void j(View view);
}
