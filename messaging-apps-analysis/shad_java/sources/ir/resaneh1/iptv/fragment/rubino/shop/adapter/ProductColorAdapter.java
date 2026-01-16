package ir.resaneh1.iptv.fragment.rubino.shop.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.appp.common.utils.AndroidUtilities;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListView;
import ir.resaneh1.iptv.model.ShopModels;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ProductColorAdapter extends RecyclerListView.SelectionAdapter {
    public Context context;
    private final Drawable selectedDrawable;
    private final Drawable unselectedDrawable;
    public List<ShopModels.ColorObject> productColorList = new ArrayList();
    private int selectedNum = -1;

    @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.SelectionAdapter
    public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
        return true;
    }

    public ProductColorAdapter(Context context) {
        this.context = context;
        this.selectedDrawable = context.getResources().getDrawable(R.drawable.shop_bg_rectangle_blue_rounded_border);
        this.unselectedDrawable = context.getResources().getDrawable(R.drawable.bg_rectangle_gray_rounded_border);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.item_shop_product_color, viewGroup, false));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.adapter.ProductColorAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateViewHolder$0(view);
            }
        });
        return viewHolder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateViewHolder$0(View view) {
        setSelected(((Integer) view.getTag()).intValue());
    }

    public void setSelected(int i) {
        if (i < 0 || i >= getItemCount()) {
            return;
        }
        int i2 = this.selectedNum;
        this.selectedNum = i;
        notifyItemChanged(i2);
        notifyItemChanged(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int color;
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.itemView.setTag(Integer.valueOf(i));
        viewHolder2.colorNameTv.setText(this.productColorList.get(i).name);
        viewHolder2.colorFl.setBackground(new CircleDrawable(this.productColorList.get(i).color_code, this.context.getResources().getColor(R.color.grey_700_alpha_50), AndroidUtilities.dp(14.0f)));
        if (getItemViewType(i) == 1) {
            try {
                color = Color.parseColor(this.productColorList.get(i).color_code);
            } catch (Exception unused) {
                color = -1;
            }
            if (color == -1 || Color.red(color) + Color.green(color) + Color.blue(color) > 510) {
                viewHolder2.selectedIv.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
            } else {
                viewHolder2.selectedIv.clearColorFilter();
            }
            viewHolder2.mainFl.setBackground(this.selectedDrawable);
            viewHolder2.selectedIv.setVisibility(0);
            return;
        }
        viewHolder2.selectedIv.setVisibility(8);
        viewHolder2.mainFl.setBackground(this.unselectedDrawable);
    }

    public ShopModels.ColorObject getSelectedColor() {
        int i = this.selectedNum;
        if (i < 0 || i >= this.productColorList.size()) {
            return null;
        }
        return this.productColorList.get(this.selectedNum);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.productColorList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i == this.selectedNum ? 1 : 2;
    }

    public void setData(ArrayList<ShopModels.ColorObject> arrayList) {
        if (arrayList == null) {
            return;
        }
        this.productColorList.clear();
        this.productColorList.addAll(arrayList);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerListView.Holder {
        protected FrameLayout colorFl;
        protected TextView colorNameTv;
        protected LinearLayout mainFl;
        protected ImageView selectedIv;

        public ViewHolder(View view) {
            super(view);
            this.colorFl = (FrameLayout) view.findViewById(R.id.color_frame_layout);
            this.colorNameTv = (TextView) view.findViewById(R.id.color_name_text_view);
            this.selectedIv = (ImageView) view.findViewById(R.id.selected_image_view);
            this.mainFl = (LinearLayout) view.findViewById(R.id.item_shop_product_color_main_fl);
        }
    }

    public static class CircleDrawable extends Drawable {
        private Paint circlePaint = new Paint(1);
        private String fillColorCode;
        private float radius;
        private int strokeColor;

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        public CircleDrawable(String str, int i, float f) {
            this.fillColorCode = str;
            this.strokeColor = i;
            this.radius = f;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            int iCenterX = getBounds().centerX();
            int iCenterY = getBounds().centerY();
            this.circlePaint.setStyle(Paint.Style.FILL);
            this.circlePaint.setColor(Color.parseColor(this.fillColorCode));
            float f = iCenterX;
            float f2 = iCenterY;
            canvas.drawCircle(f, f2, this.radius, this.circlePaint);
            this.circlePaint.setStyle(Paint.Style.STROKE);
            this.circlePaint.setColor(this.strokeColor);
            this.circlePaint.setStrokeWidth(1.0f);
            canvas.drawCircle(f, f2, this.radius, this.circlePaint);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            this.circlePaint.setAlpha(i);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            this.circlePaint.setColorFilter(colorFilter);
        }
    }
}
