package ir.nasim;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ir.nasim.C19274q43;

/* renamed from: ir.nasim.t43, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C21077t43 extends AbstractC16640ld0 {
    public static final a x = new a(null);
    public static final int y = 8;
    private final InterfaceC9764aW7 v;
    private final C19274q43.a w;

    /* renamed from: ir.nasim.t43$a */
    public static final class a {
        private a() {
        }

        public final C21077t43 a(ViewGroup viewGroup, C19274q43.a aVar) {
            AbstractC13042fc3.i(viewGroup, "parent");
            C20818sf3 c20818sf3C = C20818sf3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c20818sf3C, "inflate(...)");
            return new C21077t43(c20818sf3C, aVar, null);
        }

        public final C21077t43 b(ViewGroup viewGroup, C19274q43.a aVar) {
            AbstractC13042fc3.i(viewGroup, "parent");
            C21438tf3 c21438tf3C = C21438tf3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c21438tf3C, "inflate(...)");
            return new C21077t43(c21438tf3C, aVar, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C21077t43(InterfaceC9764aW7 interfaceC9764aW7, C19274q43.a aVar, ED1 ed1) {
        this(interfaceC9764aW7, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(C21077t43 c21077t43, C18683p43 c18683p43, View view) {
        AbstractC13042fc3.i(c21077t43, "this$0");
        AbstractC13042fc3.i(c18683p43, "$item");
        C19274q43.a aVar = c21077t43.w;
        if (aVar != null) {
            aVar.y0(c18683p43);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(C21077t43 c21077t43, C18683p43 c18683p43, View view) {
        AbstractC13042fc3.i(c21077t43, "this$0");
        AbstractC13042fc3.i(c18683p43, "$item");
        C19274q43.a aVar = c21077t43.w;
        if (aVar != null) {
            aVar.y0(c18683p43);
        }
    }

    public final void F0(final C18683p43 c18683p43) {
        AbstractC13042fc3.i(c18683p43, "item");
        InterfaceC9764aW7 interfaceC9764aW7 = this.v;
        AbstractC13042fc3.g(interfaceC9764aW7, "null cannot be cast to non-null type ir.nasim.databinding.ItemImportedPhotoRectangleBinding");
        C20818sf3 c20818sf3 = (C20818sf3) interfaceC9764aW7;
        c20818sf3.b.setImageURI(Uri.parse(c18683p43.b()));
        c20818sf3.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.r43
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C21077t43.H0(this.a, c18683p43, view);
            }
        });
    }

    public final void J0(final C18683p43 c18683p43) {
        AbstractC13042fc3.i(c18683p43, "item");
        InterfaceC9764aW7 interfaceC9764aW7 = this.v;
        AbstractC13042fc3.g(interfaceC9764aW7, "null cannot be cast to non-null type ir.nasim.databinding.ItemImportedPhotoSquareBinding");
        C21438tf3 c21438tf3 = (C21438tf3) interfaceC9764aW7;
        c21438tf3.b.setImageURI(Uri.parse(c18683p43.b()));
        c21438tf3.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.s43
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C21077t43.L0(this.a, c18683p43, view);
            }
        });
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private C21077t43(InterfaceC9764aW7 interfaceC9764aW7, C19274q43.a aVar) {
        View root = interfaceC9764aW7.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        super(root);
        this.v = interfaceC9764aW7;
        this.w = aVar;
    }
}
