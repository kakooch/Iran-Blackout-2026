package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.C18680p40;
import ir.nasim.features.attach.model.BankAttachment;

/* renamed from: ir.nasim.r40, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19862r40 extends AbstractC16640ld0 {
    public static final a w = new a(null);
    public static final int x = 8;
    private final C18680p40.a v;

    /* renamed from: ir.nasim.r40$a */
    public static final class a {
        private a() {
        }

        public final C19862r40 a(ViewGroup viewGroup, C18680p40.a aVar) {
            AbstractC13042fc3.i(viewGroup, "parent");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC12208eD5.bottom_sheet_chat_attach_item_transfer, viewGroup, false);
            AbstractC13042fc3.f(viewInflate);
            return new C19862r40(viewInflate, aVar, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C19862r40(View view, C18680p40.a aVar, ED1 ed1) {
        this(view, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(C19862r40 c19862r40, BankAttachment bankAttachment, View view) {
        AbstractC13042fc3.i(c19862r40, "this$0");
        AbstractC13042fc3.i(bankAttachment, "$attachment");
        C18680p40.a aVar = c19862r40.v;
        if (aVar != null) {
            aVar.c(bankAttachment);
        }
    }

    private final void H0(BankAttachment bankAttachment, ImageView imageView) {
        Drawable drawableF;
        Integer src = bankAttachment.getSrc();
        if (src != null) {
            drawableF = AbstractC4043Dl1.f(C0(), src.intValue());
            if (AbstractC13042fc3.d(bankAttachment.getTag(), "GOLD_GIFT_POCKET")) {
                double d = 34;
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) ((AbstractC3742Cd6.c() * d) + 0.5d), (int) ((d * AbstractC3742Cd6.c()) + 0.5d), Bitmap.Config.ARGB_8888);
                AbstractC13042fc3.h(bitmapCreateBitmap, "createBitmap(...)");
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                if (drawableF != null) {
                    drawableF.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                }
                if (drawableF != null) {
                    drawableF.draw(canvas);
                }
                drawableF = new BitmapDrawable(C0().getResources(), bitmapCreateBitmap);
            }
        } else {
            drawableF = null;
        }
        imageView.setImageDrawable(drawableF);
    }

    public final void E0(final BankAttachment bankAttachment) {
        AbstractC13042fc3.i(bankAttachment, "attachment");
        View viewFindViewById = this.a.findViewById(BC5.transfer_drawable_background);
        AbstractC13042fc3.h(viewFindViewById, "findViewById(...)");
        View viewFindViewById2 = this.a.findViewById(BC5.transfer_drawable);
        AbstractC13042fc3.h(viewFindViewById2, "findViewById(...)");
        ImageView imageView = (ImageView) viewFindViewById2;
        View viewFindViewById3 = this.a.findViewById(BC5.transfer_title);
        AbstractC13042fc3.h(viewFindViewById3, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById3;
        View viewFindViewById4 = this.a.findViewById(BC5.transfer_border);
        AbstractC13042fc3.h(viewFindViewById4, "findViewById(...)");
        ImageView imageView2 = (ImageView) viewFindViewById4;
        View viewFindViewById5 = this.a.findViewById(BC5.transfer_badge);
        AbstractC13042fc3.h(viewFindViewById5, "findViewById(...)");
        ImageView imageView3 = (ImageView) viewFindViewById5;
        this.a.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.q40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C19862r40.F0(this.a, bankAttachment, view);
            }
        });
        ((ConstraintLayout) viewFindViewById).getBackground().setColorFilter(Color.parseColor(bankAttachment.getBackgroundTint()), PorterDuff.Mode.SRC_ATOP);
        H0(bankAttachment, imageView);
        imageView.setColorFilter(Color.parseColor(bankAttachment.getTint()));
        textView.setText(bankAttachment.getTitle());
        textView.setTextColor(Color.parseColor(bankAttachment.getTitleColor()));
        textView.setTypeface(C6011Lu2.i());
        bankAttachment.getBorder();
        if (bankAttachment.getBorder() != null) {
            imageView2.setColorFilter(Color.parseColor(bankAttachment.getBorder()));
            imageView2.setVisibility(0);
        } else {
            imageView2.setVisibility(8);
        }
        if (bankAttachment.getBadgeEnabled()) {
            imageView3.setVisibility(0);
        } else {
            imageView3.setVisibility(4);
        }
    }

    private C19862r40(View view, C18680p40.a aVar) {
        super(view);
        this.v = aVar;
    }
}
