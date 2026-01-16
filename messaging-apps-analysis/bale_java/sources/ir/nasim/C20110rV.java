package ir.nasim;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.AvatarImage;

/* renamed from: ir.nasim.rV, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C20110rV extends RecyclerView.C {
    private final ImageView u;
    private InterfaceC7857Tm2 v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C20110rV(View view) {
        super(view);
        AbstractC13042fc3.i(view, "itemView");
        this.u = (ImageView) view.findViewById(BC5.photo_view_avatar);
    }

    private final void D0(Avatar avatar) {
        C14970in2 c14970in2D = AbstractC5969Lp4.d().o2().D();
        AvatarImage smallImage = avatar.getSmallImage();
        AbstractC13042fc3.f(smallImage);
        FileReference fileReference = smallImage.getFileReference();
        AbstractC13042fc3.h(fileReference, "getFileReference(...)");
        this.v = c14970in2D.D(fileReference, true, new a(), (56 & 8) != 0 ? false : false, (56 & 16) != 0 ? true : true, (56 & 32) != 0 ? false : false);
    }

    private final void F0() {
        this.u.setAlpha(1.0f);
    }

    private final void H0() {
        this.u.setAlpha(0.35f);
    }

    public final void E0(Avatar avatar) {
        if (avatar == null || avatar.getSmallImage() == null) {
            this.u.setImageBitmap(null);
        } else {
            D0(avatar);
        }
        if (this.a.isSelected()) {
            F0();
        } else {
            H0();
        }
        this.u.requestLayout();
    }

    public final void a() {
        InterfaceC7857Tm2 interfaceC7857Tm2 = this.v;
        if (interfaceC7857Tm2 != null) {
            interfaceC7857Tm2.b();
            this.v = null;
        }
    }

    /* renamed from: ir.nasim.rV$a */
    public static final class a implements InterfaceC8091Um2 {
        a() {
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            QI2.v(C20110rV.this.u, interfaceC3346Am2.getDescriptor(), null, 2, null);
            AbstractC14828iY7.l(C20110rV.this.u);
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void e() {
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
        }
    }
}
