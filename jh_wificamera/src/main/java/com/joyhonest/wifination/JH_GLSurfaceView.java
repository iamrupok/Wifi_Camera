package com.joyhonest.wifination;

import android.content.Context;

import android.opengl.GLSurfaceView;

import android.util.AttributeSet;


import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by aiven on 2017/12/29.
 *
 */

public class JH_GLSurfaceView extends GLSurfaceView {

    public JH_GLSurfaceView(Context context_) {
        super(context_);
        init(context_);
    }

    public JH_GLSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    private void init(final Context context) {
        setEGLContextClientVersion(2);
        setRenderer(new GLSurfaceView.Renderer() {
            @Override
            public void onSurfaceCreated(GL10 gl, EGLConfig config) {
                wifination.init();
                //如果是 Tuk
                // naDecordInit();
            }

            @Override
            public void onSurfaceChanged(GL10 gl, int width, int height) {
                wifination.changeLayout(width, height);
            }

            @Override
            public void onDrawFrame(GL10 gl) {
                {
                    wifination.drawFrame();
                }
            }
        });
    }

    public static native int naDecordInit();

    public static native int naDecordRelease();

    public static native int naDecordFrame(byte[] data, int nLenA);


}
