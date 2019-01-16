package com.liskovsoft.smartyoutubetv.flavors.exoplayer.player.dialogs;

import android.content.Context;
import com.liskovsoft.exoplayeractivity.R;
import com.liskovsoft.smartyoutubetv.flavors.exoplayer.player.ExoPreferences;
import com.liskovsoft.smartyoutubetv.dialogs.GenericSelectorDialog.SingleDialogSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RestrictCodecDialogSource implements SingleDialogSource {
    private final ExoPreferences mPrefs;
    private final Context mContext;

    public RestrictCodecDialogSource(Context ctx) {
        mContext = ctx;
        mPrefs = ExoPreferences.instance(ctx);
    }

    @Override
    public List<DialogItem> getItems() {
        List<DialogItem> map = new ArrayList<>();
        map.add(new RestrictCodecDialogItem(mContext.getString(R.string.no_restrictions), "", mPrefs));
        map.add(new RestrictCodecDialogItem("4K     60fps    vp9", "2160|60|vp9", mPrefs));
        map.add(new RestrictCodecDialogItem("4K     30fps    vp9", "2160|30|vp9", mPrefs));
        map.add(new RestrictCodecDialogItem("FHD    60fps    avc", "1080|60|avc", mPrefs));
        map.add(new RestrictCodecDialogItem("FHD    60fps    vp9", "1080|60|vp9", mPrefs));
        map.add(new RestrictCodecDialogItem("FHD    30fps    avc", "1080|30|avc", mPrefs));
        map.add(new RestrictCodecDialogItem("FHD    30fps    vp9", "1080|30|vp9", mPrefs));
        map.add(new RestrictCodecDialogItem("FHD    60fps    avc+vp9", "1080|60|", mPrefs));
        map.add(new RestrictCodecDialogItem("FHD    30fps    avc+vp9", "1080|30|", mPrefs));
        return map;
    }

    @Override
    public String getTitle() {
        return mContext.getString(R.string.select_preferred_codec);
    }
}