package ir.resaneh1.iptv.fragment.rubino.shop;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;

/* loaded from: classes3.dex */
public class AddImageCell extends FrameLayout {
    int sizeInDp;

    public AddImageCell(Context context) {
        super(context);
        this.sizeInDp = 140;
        FrameLayout frameLayout = new FrameLayout(context);
        int i = this.sizeInDp;
        addView(frameLayout, LayoutHelper.createFrame(i, i, 17, 4.0f, 4.0f, 4.0f, 4.0f));
        frameLayout.setBackground(context.getResources().getDrawable(R.drawable.shop_ractangle_grey_dotted));
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.plus);
        imageView.setColorFilter(new PorterDuffColorFilter(context.getResources().getColor(R.color.grey_400), PorterDuff.Mode.MULTIPLY));
        frameLayout.addView(imageView, LayoutHelper.createFrame(16, 16, 17));
    }
}
