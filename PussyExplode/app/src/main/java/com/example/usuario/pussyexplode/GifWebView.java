package com.example.usuario.pussyexplode;

import android.content.Context;
import android.webkit.WebView;

/**
 * Created by Usuario on 23/06/2016.
 */
public class GifWebView extends WebView {

    public GifWebView(Context context, String path) {
        super(context);

        loadUrl(path);
    }
}
