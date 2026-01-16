package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.w40, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C22934w40 extends RecyclerView.C {
    public static final a v = new a(null);
    private final UA2 u;

    /* renamed from: ir.nasim.w40$a */
    public static final class a {
        private a() {
        }

        public final C22934w40 a(ViewGroup viewGroup, UA2 ua2) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(ua2, "onSuggestClickListener");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC12208eD5.item_card_copied_suggest, viewGroup, false);
            AbstractC13042fc3.f(viewInflate);
            return new C22934w40(viewInflate, ua2, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C22934w40(View view, UA2 ua2, ED1 ed1) {
        this(view, ua2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(C22934w40 c22934w40, C21748u40 c21748u40, View view) {
        AbstractC13042fc3.i(c22934w40, "this$0");
        AbstractC13042fc3.i(c21748u40, "$card");
        c22934w40.u.invoke(c21748u40.a());
    }

    public final void D0(final C21748u40 c21748u40) {
        Drawable drawableF;
        AbstractC13042fc3.i(c21748u40, ParameterNames.CARD);
        TextView textView = (TextView) this.a.findViewById(BC5.cardNumberCopiedTxt);
        TextView textView2 = (TextView) this.a.findViewById(BC5.nameTxt);
        ImageView imageView = (ImageView) this.a.findViewById(BC5.bankLogo);
        textView.setTypeface(C6011Lu2.k());
        C20481s50 c20481s50 = C20481s50.a;
        Integer numD = c20481s50.d(c21748u40.a());
        if (numD != null) {
            drawableF = AbstractC4043Dl1.f(this.a.getContext(), numD.intValue());
        } else {
            drawableF = null;
        }
        imageView.setImageDrawable(drawableF);
        textView2.setTypeface(C6011Lu2.k());
        textView.setText(XY6.e(c20481s50.f(c21748u40.a())));
        this.a.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.v40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C22934w40.E0(this.a, c21748u40, view);
            }
        });
    }

    private C22934w40(View view, UA2 ua2) {
        super(view);
        this.u = ua2;
    }
}
