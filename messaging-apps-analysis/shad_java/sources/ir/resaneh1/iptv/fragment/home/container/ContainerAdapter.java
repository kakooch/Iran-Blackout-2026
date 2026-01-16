package ir.resaneh1.iptv.fragment.home.container;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.resaneh1.iptv.model.HomePageModels;
import j$.util.Comparator$CC;
import j$.util.function.ToIntFunction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class ContainerAdapter extends RecyclerView.Adapter<ViewHolder> {
    public List<HomePageModels.ContainerSectionItem> containers = new ArrayList();
    public Context context;

    public ContainerAdapter(Context context) {
        this.context = context;
    }

    public void setContainers(List<HomePageModels.ContainerSectionItem> list) {
        if (list == null) {
            this.containers.clear();
            notifyDataSetChanged();
        } else {
            if (this.containers.equals(list)) {
                return;
            }
            sortByPriority(list);
            this.containers.clear();
            this.containers.addAll(list);
            notifyDataSetChanged();
        }
    }

    private void sortByPriority(List<HomePageModels.ContainerSectionItem> list) {
        Collections.sort(list, Comparator$CC.comparingInt(new ToIntFunction() { // from class: ir.resaneh1.iptv.fragment.home.container.ContainerAdapter$$ExternalSyntheticLambda0
            @Override // j$.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return ((HomePageModels.ContainerSectionItem) obj).priority;
            }
        }));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ContainerItemCell containerItemCell = new ContainerItemCell(this.context);
        setLayoutParams(containerItemCell);
        return new ViewHolder(containerItemCell);
    }

    private void setLayoutParams(View view) {
        view.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(view.getLayoutParams());
        marginLayoutParams.setMargins(0, 10, 0, 10);
        view.setLayoutParams(marginLayoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.containerItemCell.setData(this.containers.get(i), Boolean.valueOf(i == this.containers.size() - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.containers.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        protected ContainerItemCell containerItemCell;

        public ViewHolder(View view) {
            super(view);
            this.containerItemCell = (ContainerItemCell) view;
        }
    }
}
