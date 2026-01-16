package com.pedro.encoder.input.gl.render.filters;

import android.content.Context;
import android.opengl.GLES20;
import com.pedro.encoder.input.gl.render.BaseRenderOffScreen;
import com.pedro.encoder.input.gl.render.RenderHandler;
import com.pedro.encoder.utils.gl.GlUtil;

/* loaded from: classes3.dex */
public abstract class BaseFilterRender extends BaseRenderOffScreen {
    private int height;
    protected int previousTexId;
    private RenderHandler renderHandler = new RenderHandler();
    private int width;

    protected abstract void drawFilter();

    protected abstract void initGlFilter(Context context);

    public void initGl(int i, int i2, Context context, int i3, int i4) {
        this.width = i;
        this.height = i2;
        GlUtil.checkGlError("initGl start");
        initGlFilter(context);
        GlUtil.checkGlError("initGl end");
    }

    public void initFBOLink() {
        initFBO(this.width, this.height, this.renderHandler.getFboId(), this.renderHandler.getRboId(), this.renderHandler.getTexId());
    }

    public void draw() {
        GlUtil.checkGlError("drawFilter start");
        GLES20.glBindFramebuffer(36160, this.renderHandler.getFboId()[0]);
        GLES20.glViewport(0, 0, this.width, this.height);
        drawFilter();
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindFramebuffer(36160, 0);
        GlUtil.checkGlError("drawFilter end");
    }

    public void setPreviousTexId(int i) {
        this.previousTexId = i;
    }

    @Override // com.pedro.encoder.input.gl.render.BaseRenderOffScreen
    public int getTexId() {
        return this.renderHandler.getTexId()[0];
    }

    public int getPreviousTexId() {
        return this.previousTexId;
    }

    public RenderHandler getRenderHandler() {
        return this.renderHandler;
    }

    public void setRenderHandler(RenderHandler renderHandler) {
        this.renderHandler = renderHandler;
    }
}
