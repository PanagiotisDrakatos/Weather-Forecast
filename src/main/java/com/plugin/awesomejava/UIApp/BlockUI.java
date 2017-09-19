package com.plugin.awesomejava.UIApp;

import com.plugin.awesomejava.Forecast.FeedEntry;
import com.plugin.awesomejava.Location.GetCurrentRegion;
import java.util.concurrent.atomic.AtomicBoolean;

public class BlockUI {

    private final AtomicBoolean visibilityVar;
    private FeedEntry entry;

    public BlockUI() {
        this.visibilityVar = new AtomicBoolean();
    }

    public void SetVisibilityVar(boolean flag) {
        visibilityVar.set(flag);
    }

    public AtomicBoolean getVisibilityVar() {
        return visibilityVar;
    }

    public FeedEntry IsStart() {
        GetCurrentRegion region = new GetCurrentRegion();
        this.entry = region.GetLocationServices();

        if (this.entry == null) {
            visibilityVar.set(false);
            return this.entry;
        }

        visibilityVar.set(true);
        return this.entry;
    }

}
