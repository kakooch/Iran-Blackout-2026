package ir.nasim;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.AvatarImage;
import java.io.File;

/* renamed from: ir.nasim.g74, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C13377g74 extends RecyclerView.C {
    public static final a B = new a(null);
    public static final int D = 8;
    private final String[] A;
    private LinearLayout u;
    private TextView v;
    private ImageView w;
    private TextView x;
    private TextView y;
    private TextView z;

    /* renamed from: ir.nasim.g74$a */
    public static final class a {
        private a() {
        }

        public final C13377g74 a(ViewGroup viewGroup) {
            AbstractC13042fc3.i(viewGroup, "parent");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC12208eD5.item_paid_crowdfunding, viewGroup, false);
            AbstractC13042fc3.f(viewInflate);
            return new C13377g74(viewInflate, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C13377g74(View view, ED1 ed1) {
        this(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(C13377g74 c13377g74, C21231tK7 c21231tK7) {
        AbstractC13042fc3.i(c13377g74, "this$0");
        Object objB = c21231tK7.r().b();
        AbstractC13042fc3.h(objB, "get(...)");
        if (((CharSequence) objB).length() > 0) {
            c13377g74.v.setText(String.valueOf(((String) c21231tK7.r().b()).charAt(0)));
            c13377g74.x.setText((CharSequence) c21231tK7.r().b());
        }
        if (c21231tK7.h().b() != null) {
            Object objB2 = c21231tK7.h().b();
            AbstractC13042fc3.h(objB2, "get(...)");
            AvatarImage avatarImageJ0 = c13377g74.J0((Avatar) objB2);
            FileReference fileReference = avatarImageJ0 != null ? avatarImageJ0.getFileReference() : null;
            if (fileReference != null) {
                AbstractC5969Lp4.d().q(fileReference, true, c13377g74.new b());
            }
        }
    }

    private final String F0(int i) {
        String string = this.a.getContext().getString(i);
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    private final AvatarImage J0(Avatar avatar) {
        return C22078ud6.a(80.0f) >= 100 ? avatar.getLargeImage() : avatar.getSmallImage();
    }

    private final void L0(int i) {
        String string;
        if (i == 0) {
            string = this.a.getContext().getString(TA5.placeholder_empty);
            AbstractC13042fc3.f(string);
        } else {
            string = this.A[Math.abs(i) % this.A.length];
        }
        this.u.getBackground().setColorFilter(Color.parseColor(string), PorterDuff.Mode.SRC_ATOP);
    }

    public final void D0(P15 p15) {
        AbstractC13042fc3.i(p15, "item");
        Integer numS = p15.s();
        AbstractC13042fc3.h(numS, "getPayerUserId(...)");
        L0(numS.intValue());
        this.v.setText((CharSequence) null);
        this.x.setText((CharSequence) null);
        C11335cq c11335cqD = AbstractC5969Lp4.d();
        Integer numS2 = p15.s();
        AbstractC13042fc3.h(numS2, "getPayerUserId(...)");
        c11335cqD.h0(numS2.intValue()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.f74
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C13377g74.E0(this.a, (C21231tK7) obj);
            }
        });
        String strE = XY6.e(GY6.g(String.valueOf(p15.q().longValue())));
        String string = this.a.getContext().getString(AbstractC12217eE5.crowdfunding_rial_param, strE);
        AbstractC13042fc3.h(string, "getString(...)");
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(C5495Jo7.a.o0()), strE.length(), string.length(), 18);
        spannableString.setSpan(new AbsoluteSizeSpan(AbstractC7426Rr.a.f(12.0f)), strE.length(), string.length(), 18);
        this.y.setText(spannableString);
        TextView textView = this.z;
        Context context = textView.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        Long lR = p15.r();
        AbstractC13042fc3.h(lR, "getDate(...)");
        textView.setText(C14593iA1.h(context, lR.longValue(), false, 4, null));
    }

    public final ImageView H0() {
        return this.w;
    }

    private C13377g74(View view) {
        super(view);
        View viewFindViewById = view.findViewById(BC5.placeholderLayout);
        AbstractC13042fc3.h(viewFindViewById, "findViewById(...)");
        this.u = (LinearLayout) viewFindViewById;
        View viewFindViewById2 = view.findViewById(BC5.placeHolderTextView);
        AbstractC13042fc3.h(viewFindViewById2, "findViewById(...)");
        this.v = (TextView) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(BC5.avatarImg);
        AbstractC13042fc3.h(viewFindViewById3, "findViewById(...)");
        this.w = (ImageView) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(BC5.nameTxt);
        AbstractC13042fc3.h(viewFindViewById4, "findViewById(...)");
        this.x = (TextView) viewFindViewById4;
        View viewFindViewById5 = view.findViewById(BC5.amountTxt);
        AbstractC13042fc3.h(viewFindViewById5, "findViewById(...)");
        this.y = (TextView) viewFindViewById5;
        View viewFindViewById6 = view.findViewById(BC5.dateTxt);
        AbstractC13042fc3.h(viewFindViewById6, "findViewById(...)");
        this.z = (TextView) viewFindViewById6;
        this.A = new String[]{F0(TA5.placeholder_0), F0(TA5.placeholder_1), F0(TA5.placeholder_2), F0(TA5.placeholder_3), F0(TA5.placeholder_4), F0(TA5.placeholder_5), F0(TA5.placeholder_6)};
    }

    /* renamed from: ir.nasim.g74$b */
    public static final class b implements InterfaceC8091Um2 {
        b() {
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            Uri uriFromFile = Uri.fromFile(new File(interfaceC3346Am2.getDescriptor()));
            AbstractC13042fc3.f(uriFromFile);
            QI2.l(uriFromFile, C13377g74.this.H0());
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void e() {
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
        }
    }
}
