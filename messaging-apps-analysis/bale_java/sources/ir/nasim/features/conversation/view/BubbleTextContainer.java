package ir.nasim.features.conversation.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* loaded from: classes5.dex */
public class BubbleTextContainer extends FrameLayout {
    private Rect a;
    private final int b;

    public BubbleTextContainer(Context context) {
        super(context);
        this.a = new Rect();
        this.b = 50;
        setClipToPadding(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0267  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r25, int r26) {
        /*
            Method dump skipped, instructions count: 847
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.conversation.view.BubbleTextContainer.onMeasure(int, int):void");
    }

    public BubbleTextContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Rect();
        this.b = 50;
        setClipToPadding(false);
    }

    public BubbleTextContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new Rect();
        this.b = 50;
        setClipToPadding(false);
    }
}
