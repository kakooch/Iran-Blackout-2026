package com.pedro.encoder.input.gl.render;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.pedro.encoder.input.gl.render.filters.BaseFilterRender;
import com.pedro.encoder.input.gl.render.filters.NoFilterRender;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class ManagerRender {
    public static int numFilters = 1;
    private List<BaseFilterRender> baseFilterRender = new ArrayList(numFilters);
    private CameraRender cameraRender = new CameraRender();
    private Context context;
    private int height;
    private int previewHeight;
    private int previewWidth;
    private ScreenRender screenRender;
    private int width;

    public ManagerRender() {
        for (int i = 0; i < numFilters; i++) {
            this.baseFilterRender.add(new NoFilterRender());
        }
        this.screenRender = new ScreenRender();
    }

    public void initGl(Context context, int i, int i2, int i3, int i4) {
        this.context = context;
        this.width = i;
        this.height = i2;
        this.previewWidth = i3;
        this.previewHeight = i4;
        this.cameraRender.initGl(i, i2, context, i3, i4);
        int i5 = 0;
        while (i5 < numFilters) {
            this.baseFilterRender.get(i5).setPreviousTexId(i5 == 0 ? this.cameraRender.getTexId() : this.baseFilterRender.get(i5 - 1).getTexId());
            this.baseFilterRender.get(i5).initGl(this.width, this.height, context, i3, i4);
            this.baseFilterRender.get(i5).initFBOLink();
            i5++;
        }
        this.screenRender.setStreamSize(i, i2);
        this.screenRender.setTexId(this.baseFilterRender.get(numFilters - 1).getTexId());
        this.screenRender.initGl(context);
    }

    public void drawOffScreen() {
        this.cameraRender.draw();
        Iterator<BaseFilterRender> it = this.baseFilterRender.iterator();
        while (it.hasNext()) {
            it.next().draw();
        }
    }

    public void drawScreen(int i, int i2, boolean z, int i3, int i4, boolean z2) {
        this.screenRender.draw(i, i2, z, i3, i4, z2);
    }

    public void release() {
        this.cameraRender.release();
        for (int i = 0; i < this.baseFilterRender.size(); i++) {
            this.baseFilterRender.get(i).release();
            this.baseFilterRender.set(i, new NoFilterRender());
        }
        this.screenRender.release();
    }

    public void enableAA(boolean z) {
        this.screenRender.setAAEnabled(z);
    }

    public void updateFrame() {
        this.cameraRender.updateTexImage();
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.cameraRender.getSurfaceTexture();
    }

    public void setFilter(int i, BaseFilterRender baseFilterRender) {
        int previousTexId = this.baseFilterRender.get(i).getPreviousTexId();
        RenderHandler renderHandler = this.baseFilterRender.get(i).getRenderHandler();
        this.baseFilterRender.get(i).release();
        this.baseFilterRender.set(i, baseFilterRender);
        this.baseFilterRender.get(i).setPreviousTexId(previousTexId);
        this.baseFilterRender.get(i).initGl(this.width, this.height, this.context, this.previewWidth, this.previewHeight);
        this.baseFilterRender.get(i).setRenderHandler(renderHandler);
    }

    public void setCameraRotation(int i) {
        this.cameraRender.setRotation(i);
    }

    public void setCameraFlip(boolean z, boolean z2) {
        this.cameraRender.setFlip(z, z2);
    }
}
