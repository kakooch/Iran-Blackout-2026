package ir.nasim.features.conversation.view;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.BC5;
import ir.nasim.C5495Jo7;
import ir.nasim.EnumC9127Yp2;
import ir.nasim.KB5;

/* loaded from: classes5.dex */
public class BaleFloatButtonContainer extends CardView {
    View.OnClickListener j;
    Context k;

    public BaleFloatButtonContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = context;
    }

    private ColorStateList getColorStateList() {
        return new ColorStateList(new int[][]{new int[]{R.attr.state_enabled}, new int[]{R.attr.state_pressed}}, new int[]{0, C5495Jo7.a.l0()});
    }

    public void f(EnumC9127Yp2 enumC9127Yp2, View.OnClickListener onClickListener) {
        this.j = onClickListener;
        setOnClickListener(onClickListener);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.k);
        if (enumC9127Yp2 == EnumC9127Yp2.a) {
            layoutInflaterFrom.inflate(AbstractC12208eD5.float_button_hafez, this);
        } else if (enumC9127Yp2 == EnumC9127Yp2.b) {
            layoutInflaterFrom.inflate(AbstractC12208eD5.float_button_gift, this);
        } else if (enumC9127Yp2 == EnumC9127Yp2.c) {
            layoutInflaterFrom.inflate(AbstractC12208eD5.float_button_hedie, this);
            ((ImageView) findViewById(BC5.iv_hedie)).setImageDrawable(AbstractC4043Dl1.f(this.k, KB5.ic_hedie));
        } else if (enumC9127Yp2 == EnumC9127Yp2.d) {
            layoutInflaterFrom.inflate(AbstractC12208eD5.float_button_hedie, this);
            ((ImageView) findViewById(BC5.iv_hedie)).setImageDrawable(AbstractC4043Dl1.f(this.k, KB5.ic_hedie_with_out_text));
        }
        setBackgroundTintList(getColorStateList());
    }
}
