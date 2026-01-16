package ir.nasim;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C15196jA2;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.AvatarImage;
import java.io.File;

/* renamed from: ir.nasim.lA2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C16378lA2 extends RecyclerView.C {
    public static final a A = new a(null);
    public static final int B = 8;
    private final C15196jA2.a u;
    private final LinearLayout v;
    private final TextView w;
    private final ImageView x;
    private final ImageView y;
    private final TextView z;

    /* renamed from: ir.nasim.lA2$a */
    public static final class a {
        private a() {
        }

        public final C16378lA2 a(ViewGroup viewGroup, C15196jA2.a aVar) {
            AbstractC13042fc3.i(viewGroup, "parent");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC12208eD5.item_friend_share_crowdfunding, viewGroup, false);
            AbstractC13042fc3.f(viewInflate);
            return new C16378lA2(viewInflate, aVar, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C16378lA2(View view, C15196jA2.a aVar, ED1 ed1) {
        this(view, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(C16969mA2 c16969mA2, C16378lA2 c16378lA2, View view) {
        AbstractC13042fc3.i(c16969mA2, "$friend");
        AbstractC13042fc3.i(c16378lA2, "this$0");
        c16969mA2.c(!c16969mA2.b());
        C15196jA2.a aVar = c16378lA2.u;
        if (aVar != null) {
            aVar.s5(c16969mA2);
        }
        if (c16969mA2.b()) {
            c16378lA2.y.setVisibility(0);
        } else {
            c16378lA2.y.setVisibility(4);
        }
    }

    private final AvatarImage H0(Avatar avatar) {
        return C22078ud6.a(80.0f) >= 100 ? avatar.getLargeImage() : avatar.getSmallImage();
    }

    public final void E0(final C16969mA2 c16969mA2) {
        String string;
        AbstractC13042fc3.i(c16969mA2, "friend");
        if (c16969mA2.b()) {
            this.y.setVisibility(0);
        } else {
            this.y.setVisibility(4);
        }
        C21231tK7 c21231tK7 = (C21231tK7) AbstractC5969Lp4.g().n(c16969mA2.a());
        if (c21231tK7 == null) {
            C19406qI3.b("FriendShareViewHolder", "In bind friend, userVM is null, so return!");
            return;
        }
        Object objB = c21231tK7.r().b();
        AbstractC13042fc3.h(objB, "get(...)");
        this.w.setText(((CharSequence) objB).length() == 0 ? (String) c21231tK7.r().b() : String.valueOf(((String) c21231tK7.r().b()).charAt(0)));
        this.z.setText((CharSequence) c21231tK7.r().b());
        String[] strArr = {this.a.getContext().getString(TA5.placeholder_0), this.a.getContext().getString(TA5.placeholder_1), this.a.getContext().getString(TA5.placeholder_2), this.a.getContext().getString(TA5.placeholder_3), this.a.getContext().getString(TA5.placeholder_4), this.a.getContext().getString(TA5.placeholder_5), this.a.getContext().getString(TA5.placeholder_6)};
        try {
            if (c21231tK7.o() == 0) {
                string = this.a.getContext().getString(TA5.placeholder_empty);
                AbstractC13042fc3.f(string);
            } else {
                string = strArr[Math.abs(c21231tK7.o()) % 7];
                AbstractC13042fc3.f(string);
            }
            this.v.getBackground().setColorFilter(Color.parseColor(string), PorterDuff.Mode.SRC_ATOP);
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
        this.z.setTypeface(C6011Lu2.k());
        this.w.setTypeface(C6011Lu2.k());
        this.a.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.kA2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C16378lA2.F0(c16969mA2, this, view);
            }
        });
        Avatar avatar = (Avatar) c21231tK7.h().b();
        if ((avatar != null ? avatar.getSmallImage() : null) == null) {
            QI2.a.a(this.x);
            return;
        }
        Object objB2 = c21231tK7.h().b();
        AbstractC13042fc3.h(objB2, "get(...)");
        AvatarImage avatarImageH0 = H0((Avatar) objB2);
        FileReference fileReference = avatarImageH0 != null ? avatarImageH0.getFileReference() : null;
        if (fileReference != null) {
            AbstractC5969Lp4.d().q(fileReference, true, new b());
        }
    }

    private C16378lA2(View view, C15196jA2.a aVar) {
        super(view);
        this.u = aVar;
        View viewFindViewById = view.findViewById(BC5.placeHolderLayout);
        AbstractC13042fc3.h(viewFindViewById, "findViewById(...)");
        this.v = (LinearLayout) viewFindViewById;
        View viewFindViewById2 = view.findViewById(BC5.placeHolderTxt);
        AbstractC13042fc3.h(viewFindViewById2, "findViewById(...)");
        this.w = (TextView) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(BC5.avatarImg);
        AbstractC13042fc3.h(viewFindViewById3, "findViewById(...)");
        this.x = (ImageView) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(BC5.selectedBadgeImg);
        AbstractC13042fc3.h(viewFindViewById4, "findViewById(...)");
        this.y = (ImageView) viewFindViewById4;
        View viewFindViewById5 = view.findViewById(BC5.nameTxt);
        AbstractC13042fc3.h(viewFindViewById5, "findViewById(...)");
        this.z = (TextView) viewFindViewById5;
    }

    /* renamed from: ir.nasim.lA2$b */
    public static final class b implements InterfaceC8091Um2 {
        b() {
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            Uri uriFromFile = Uri.fromFile(new File(interfaceC3346Am2.getDescriptor()));
            AbstractC13042fc3.f(uriFromFile);
            QI2.l(uriFromFile, C16378lA2.this.x);
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void e() {
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
        }
    }
}
