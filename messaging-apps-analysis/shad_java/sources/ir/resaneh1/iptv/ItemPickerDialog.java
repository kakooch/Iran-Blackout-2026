package ir.resaneh1.iptv;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.ItemListRequest;
import ir.resaneh1.iptv.model.GetListOutput;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class ItemPickerDialog extends Dialog {
    private ArrayList<? extends PresenterItem> defaultSelectedItems;
    TextView doneTextView;
    public boolean hasSearch;
    private ItemPickerListAdapter itemPickerListAdapter;
    ListInput listInput;
    private final Activity mActivity;
    OnArrayItemsSelectedListener onArrayItemsSelectedListener;
    View.OnClickListener onClickListener;
    OnItemSelectedListener onItemSelectedListener;
    OnStringSelectedListener onStringSelectedListener;
    PickType pickTpye;
    private RecyclerView recyclerView;
    EditText searchEditText;
    String title;

    enum PickType {
        baseItemSingle,
        baseItemMultiple,
        enumSingle
    }

    public ItemPickerDialog(Activity activity, ListInput listInput, String str, boolean z, OnItemSelectedListener onItemSelectedListener, boolean z2) {
        super(activity);
        PickType pickType = PickType.baseItemSingle;
        this.pickTpye = pickType;
        this.hasSearch = true;
        this.onClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.ItemPickerDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.textViewDone) {
                    ItemPickerDialog itemPickerDialog = ItemPickerDialog.this;
                    if (itemPickerDialog.pickTpye == PickType.baseItemMultiple) {
                        if (itemPickerDialog.itemPickerListAdapter != null) {
                            ItemPickerDialog itemPickerDialog2 = ItemPickerDialog.this;
                            itemPickerDialog2.onArrayItemsSelectedListener.onArrayItemSelected(itemPickerDialog2.itemPickerListAdapter.getSelectedItems());
                        } else {
                            ItemPickerDialog.this.onArrayItemsSelectedListener.onArrayItemSelected(new ArrayList<>());
                        }
                    }
                }
            }
        };
        this.mActivity = activity;
        this.onItemSelectedListener = onItemSelectedListener;
        this.listInput = listInput;
        this.title = str;
        this.pickTpye = pickType;
        this.hasSearch = z2;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setContentView(R.layout.dialog_searchable_picker);
        getWindow().setLayout(-1, -2);
        TextView textView = (TextView) findViewById(R.id.textViewDone);
        this.doneTextView = textView;
        if (this.pickTpye == PickType.baseItemMultiple) {
            textView.setOnClickListener(this.onClickListener);
        } else {
            textView.setVisibility(8);
        }
        ((TextView) findViewById(R.id.textViewTitle)).setText(this.title);
        this.recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        EditText editText = (EditText) findViewById(R.id.editTextSearch);
        this.searchEditText = editText;
        if (this.pickTpye == PickType.enumSingle || !this.hasSearch) {
            editText.setVisibility(8);
        }
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        ListInput listInput = this.listInput;
        if (listInput.itemType != ListInput.ItemType.array) {
            if (listInput != null) {
                loadItems();
            }
        } else if (listInput.arrayList != null) {
            findViewById(R.id.progressBar).setVisibility(4);
            setItemList(this.listInput.arrayList);
        }
    }

    void loadItems() {
        new ArrayList();
        if (this.pickTpye != PickType.baseItemSingle || this.listInput == null) {
            return;
        }
        findViewById(R.id.progressBar).setVisibility(0);
        findViewById(R.id.notFoundLayout).setVisibility(4);
        new ItemListRequest().load(this.mActivity, this.listInput, new ItemListRequest.Listener() { // from class: ir.resaneh1.iptv.ItemPickerDialog.1
            @Override // ir.resaneh1.iptv.helper.ItemListRequest.Listener
            public void onResponse(ArrayList<? extends PresenterItem> arrayList, GetListOutput getListOutput) {
                ItemPickerDialog.this.setItemList(arrayList);
                ItemPickerDialog.this.findViewById(R.id.progressBar).setVisibility(4);
            }

            @Override // ir.resaneh1.iptv.helper.ItemListRequest.Listener
            public void onFailure(Throwable th) {
                ItemPickerDialog.this.findViewById(R.id.progressBar).setVisibility(4);
                ItemPickerDialog.this.findViewById(R.id.notFoundLayout).setVisibility(0);
            }
        });
    }

    void setItemList(ArrayList<? extends PresenterItem> arrayList) {
        PickType pickType = this.pickTpye;
        if (pickType == PickType.baseItemSingle) {
            this.itemPickerListAdapter = new ItemPickerListAdapter(this.mActivity, arrayList, this.onItemSelectedListener);
        } else if (pickType == PickType.enumSingle) {
            this.itemPickerListAdapter = new ItemPickerListAdapter(this.mActivity, arrayList, this.onStringSelectedListener);
        } else if (pickType == PickType.baseItemMultiple) {
            Iterator<? extends PresenterItem> it = arrayList.iterator();
            while (true) {
                int i = 0;
                if (!it.hasNext()) {
                    break;
                }
                PresenterItem next = it.next();
                while (true) {
                    if (i >= this.defaultSelectedItems.size()) {
                        break;
                    }
                    if (this.defaultSelectedItems.get(i).presenterId.equals(next.presenterId)) {
                        it.remove();
                        break;
                    }
                    i++;
                }
            }
            Iterator<? extends PresenterItem> it2 = this.defaultSelectedItems.iterator();
            while (it2.hasNext()) {
                PresenterItem next2 = it2.next();
                next2.presenterIsSelected = true;
                arrayList.add(0, next2);
            }
            this.itemPickerListAdapter = new ItemPickerListAdapter(this.mActivity, arrayList, this.onArrayItemsSelectedListener);
        }
        this.recyclerView.setAdapter(this.itemPickerListAdapter);
        this.searchEditText.addTextChangedListener(new TextWatcher() { // from class: ir.resaneh1.iptv.ItemPickerDialog.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                ItemPickerDialog.this.itemPickerListAdapter.getFilter().filter(((Object) charSequence) + BuildConfig.FLAVOR);
                ItemPickerDialog.this.itemPickerListAdapter.notifyDataSetChanged();
            }
        });
    }
}
