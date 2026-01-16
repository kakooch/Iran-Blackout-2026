package ir.nasim;

import android.app.Activity;
import android.content.Intent;
import android.gov.nist.core.Separators;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ir.nasim.C21753u45;

/* renamed from: ir.nasim.ln, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC16739ln {
    public static final a a = new a(null);

    /* renamed from: ir.nasim.ln$a */
    public static final class a {
        private a() {
        }

        private final Bitmap a(SpannableStringBuilder spannableStringBuilder) {
            View viewB = b(spannableStringBuilder);
            viewB.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            viewB.layout(0, 0, viewB.getMeasuredWidth(), viewB.getMeasuredHeight());
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(viewB.getMeasuredWidth(), viewB.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            AbstractC13042fc3.h(bitmapCreateBitmap, "createBitmap(...)");
            viewB.draw(new Canvas(bitmapCreateBitmap));
            return bitmapCreateBitmap;
        }

        private final View b(SpannableStringBuilder spannableStringBuilder) {
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(C5721Ko.a.d());
            AbstractC13042fc3.h(layoutInflaterFrom, "from(...)");
            View viewInflate = layoutInflaterFrom.inflate(AbstractC12208eD5.receipt_photo_share, (ViewGroup) null);
            AbstractC13042fc3.h(viewInflate, "inflate(...)");
            g(spannableStringBuilder, viewInflate);
            f(viewInflate);
            d(viewInflate);
            e(viewInflate);
            View viewFindViewById = viewInflate.findViewById(BC5.relative_layout);
            AbstractC13042fc3.h(viewFindViewById, "findViewById(...)");
            return viewFindViewById;
        }

        private final String c(Activity activity, String str, SpannableStringBuilder spannableStringBuilder) {
            if (C5505Jq.F()) {
                return C4053Dm2.C(str, a(spannableStringBuilder));
            }
            C21753u45.O0(C21753u45.a, activity, 0, null, new C21753u45.d[]{C21753u45.d.j, C21753u45.d.m}, 4, null);
            return null;
        }

        private final void d(View view) {
            TextView textView = (TextView) view.findViewById(BC5.bale_name_text_view);
            if (textView != null) {
                textView.setText(AbstractC12217eE5.receipt_share_header_name);
                textView.setTextColor(Color.parseColor("#161C4E"));
                textView.setTypeface(C6011Lu2.i());
                textView.setTextSize(16.0f);
            }
        }

        private final void e(View view) {
            TextView textView = (TextView) view.findViewById(BC5.bale_download_guide);
            if (textView != null) {
                textView.setText(AbstractC12217eE5.receipt_share_footer_name);
                textView.setTextColor(Color.parseColor("#2E8EEE"));
                textView.setTypeface(C6011Lu2.i());
                textView.setTextSize(16.0f);
            }
        }

        private final void f(View view) {
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(BC5.fl_bubble);
            if (relativeLayout != null) {
                relativeLayout.setBackgroundResource(KB5.bubble_receipt_out);
            }
        }

        private final void g(SpannableStringBuilder spannableStringBuilder, View view) {
            TextView textView = (TextView) view.findViewById(BC5.tv_text);
            if (textView != null) {
                textView.setText(spannableStringBuilder);
                textView.setTextSize(AbstractC7426Rr.a.f(6.0f));
                textView.setTextColor(Color.parseColor("#161C4E"));
                textView.setTypeface(C6011Lu2.k());
                textView.setTextDirection(1);
            }
        }

        public final void h(Activity activity, SpannableStringBuilder spannableStringBuilder) {
            String strC;
            AbstractC13042fc3.i(spannableStringBuilder, "receiptContent");
            if (activity == null || (strC = AbstractC16739ln.a.c(activity, "bale_receipt.jpg", spannableStringBuilder)) == null) {
                return;
            }
            Intent intentG = C22055ub3.g(activity, "bale_receipt.jpg", strC + Separators.SLASH + "bale_receipt.jpg", null, 8, null);
            if (intentG != null) {
                activity.startActivity(intentG);
            }
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }
}
