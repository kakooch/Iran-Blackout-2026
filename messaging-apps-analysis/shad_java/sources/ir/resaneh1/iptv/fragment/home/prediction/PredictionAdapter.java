package ir.resaneh1.iptv.fragment.home.prediction;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.KeyCycleOscillator$1$$ExternalSyntheticBackport0;
import androidx.recyclerview.widget.RecyclerView;
import ir.resaneh1.iptv.model.HomePageModels;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes3.dex */
public class PredictionAdapter extends RecyclerListView.SelectionAdapter {
    public Context context;
    private final BaseFragment parentFragment;
    public List<HomePageModels.PredictionSectionItem> predictions = new ArrayList();

    @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
    public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
        return false;
    }

    public PredictionAdapter(Context context, BaseFragment baseFragment) {
        this.context = context;
        this.parentFragment = baseFragment;
    }

    public void setPredictions(List<HomePageModels.PredictionSectionItem> list) {
        if (list == null) {
            this.predictions.clear();
            notifyDataSetChanged();
        } else {
            if (this.predictions.equals(list)) {
                return;
            }
            sortByPriority(list);
            this.predictions.clear();
            this.predictions.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$sortByPriority$0(HomePageModels.PredictionSectionItem predictionSectionItem, HomePageModels.PredictionSectionItem predictionSectionItem2) {
        return KeyCycleOscillator$1$$ExternalSyntheticBackport0.m(predictionSectionItem.priority, predictionSectionItem2.priority);
    }

    private void sortByPriority(List<HomePageModels.PredictionSectionItem> list) {
        Collections.sort(list, new Comparator() { // from class: ir.resaneh1.iptv.fragment.home.prediction.PredictionAdapter$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return PredictionAdapter.lambda$sortByPriority$0((HomePageModels.PredictionSectionItem) obj, (HomePageModels.PredictionSectionItem) obj2);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        PredictionItemCell predictionItemCell = new PredictionItemCell(this.context, this.parentFragment);
        setLayoutParams(predictionItemCell);
        return new ViewHolder(predictionItemCell);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        View view = viewHolder.itemView;
        if (view instanceof PredictionItemCell) {
            ((PredictionItemCell) view).setData(this.predictions.get(i));
        }
    }

    private void setLayoutParams(View view) {
        view.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(view.getLayoutParams());
        marginLayoutParams.setMargins(0, 20, 0, 20);
        view.setLayoutParams(marginLayoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.predictions.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
        }
    }
}
