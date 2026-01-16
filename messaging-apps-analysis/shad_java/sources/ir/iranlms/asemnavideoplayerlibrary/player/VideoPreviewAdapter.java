package ir.iranlms.asemnavideoplayerlibrary.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.iranlms.asemnavideoplayerlibrary.player.models.ThumbnailItem;
import ir.medu.shad.R;
import ir.resaneh1.iptv.logger.MyLog;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class VideoPreviewAdapter extends RecyclerView.Adapter<ViewHolder> {
    Context mActivity;
    private RecyclerView parentRecycler;
    ArrayList<ThumbnailItem> thumbnailItems;

    public VideoPreviewAdapter(Context context, ArrayList<ThumbnailItem> arrayList) {
        this.thumbnailItems = arrayList;
        this.mActivity = context;
        loadThumbnailsImage();
    }

    void loadThumbnailsImage() {
        Iterator<ThumbnailItem> it = this.thumbnailItems.iterator();
        while (it.hasNext()) {
            final ThumbnailItem next = it.next();
            try {
                Glide.with(this.mActivity).asBitmap().load(next.imageUrl).into((RequestBuilder<Bitmap>) new SimpleTarget<Bitmap>(this) { // from class: ir.iranlms.asemnavideoplayerlibrary.player.VideoPreviewAdapter.1
                    @Override // com.bumptech.glide.request.target.Target
                    public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                        onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                    }

                    public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                        next.bitmap = bitmap;
                    }
                });
            } catch (Exception unused) {
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.parentRecycler = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_video_preview_card, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        try {
            viewHolder.imageView.setImageDrawable(setReleventImage(i + 1));
        } catch (Exception e) {
            MyLog.e("preee", e.getMessage() + BuildConfig.FLAVOR);
        }
        viewHolder.textView.setText((i + 1) + BuildConfig.FLAVOR);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        Iterator<ThumbnailItem> it = this.thumbnailItems.iterator();
        int i = 0;
        while (it.hasNext()) {
            ThumbnailItem next = it.next();
            i += next.countX * next.countY;
        }
        return i;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imageView;
        private TextView textView;

        public ViewHolder(View view) {
            super(view);
            this.imageView = (ImageView) view.findViewById(R.id.city_image);
            this.textView = (TextView) view.findViewById(R.id.city_name);
            view.findViewById(R.id.container).setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPreviewAdapter.this.parentRecycler.smoothScrollToPosition(getAdapterPosition());
        }
    }

    private Drawable setReleventImage(int i) {
        ThumbnailItem thumbnailItem;
        int i2 = 0;
        while (true) {
            if (i2 >= this.thumbnailItems.size()) {
                thumbnailItem = null;
                break;
            }
            if (i > this.thumbnailItems.get(i2).getCount()) {
                i -= this.thumbnailItems.get(i2).getCount();
                i2++;
            } else {
                thumbnailItem = this.thumbnailItems.get(i2);
                MyLog.e("thumbnail:", "I:" + i2);
                break;
            }
        }
        return findImage(thumbnailItem.bitmap, i, thumbnailItem.countX, thumbnailItem.countY);
    }

    public int calculateX(int i, int i2, int i3, int i4, int i5) {
        int i6 = i - 1;
        return (i6 - ((i6 / i2) * i2)) * i4;
    }

    public int calculateY(int i, int i2, int i3, int i4, int i5) {
        return ((i - 1) / i2) * i5;
    }

    private Drawable findImage(Bitmap bitmap, int i, int i2, int i3) {
        int width = bitmap.getWidth() / i2;
        int height = bitmap.getHeight() / i3;
        Matrix matrix = new Matrix();
        int iCalculateX = calculateX(i, i2, i3, width, height);
        int iCalculateY = calculateY(i, i2, i3, width, height);
        MyLog.e("x , y", iCalculateX + " " + iCalculateY);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, iCalculateX, iCalculateY, width, height, matrix, true);
        double width2 = (double) bitmapCreateBitmap.getWidth();
        Double.isNaN(width2);
        double height2 = (double) bitmapCreateBitmap.getHeight();
        Double.isNaN(height2);
        return new BitmapDrawable(Bitmap.createScaledBitmap(bitmapCreateBitmap, (int) (width2 * 3.5d), (int) (height2 * 3.5d), true));
    }
}
