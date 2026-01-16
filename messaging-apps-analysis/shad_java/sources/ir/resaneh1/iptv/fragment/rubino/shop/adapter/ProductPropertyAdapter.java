package ir.resaneh1.iptv.fragment.rubino.shop.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListView;
import java.util.HashMap;
import org.rbmain.messenger.LocaleController;

/* loaded from: classes3.dex */
public class ProductPropertyAdapter extends RecyclerListView.SelectionAdapter {
    public Context context;
    public String[] mKeys;
    public HashMap<String, String> productPropertiesList = new HashMap<>();
    private final String TAG = ProductPropertyAdapter.class.getName();

    @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.SelectionAdapter
    public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
        return false;
    }

    public ProductPropertyAdapter(Context context) {
        this.context = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Log.i(this.TAG, "onCreateViewHolder: ");
        return new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.item_shop_product_property, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Log.i(this.TAG, "onBindViewHolder: ");
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        String[] strArr = this.mKeys;
        if (strArr == null) {
            throw new IllegalStateException("key set is not initialized");
        }
        String str = strArr[i];
        String str2 = this.productPropertiesList.get(str);
        if (str == null || str2 == null) {
            return;
        }
        viewHolder2.infoTextView.setText(str);
        viewHolder2.titleTextView.setText(str2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.mKeys != null) {
            return this.productPropertiesList.size();
        }
        return 0;
    }

    public void setData(HashMap<String, String> map) {
        this.productPropertiesList.clear();
        if (map == null) {
            return;
        }
        this.productPropertiesList.putAll(map);
        this.mKeys = (String[]) map.keySet().toArray(new String[0]);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerListView.Holder {
        protected TextView infoTextView;
        protected TextView titleTextView;

        public ViewHolder(View view) {
            super(view);
            TextView textView = (TextView) view.findViewById(R.id.product_property_title_text_view);
            this.titleTextView = textView;
            textView.setText(LocaleController.getString(R.string.product_details));
            this.infoTextView = (TextView) view.findViewById(R.id.product_property_info_text_view);
        }
    }
}
