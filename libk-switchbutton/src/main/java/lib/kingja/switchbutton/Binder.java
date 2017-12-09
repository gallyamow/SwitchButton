package lib.kingja.switchbutton;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;

/**
 * Adding support of Android Data Binding
 */
public class Binder {
    @BindingAdapter(value = {"app:selectedTab", "app:selectedTabAttrChanged"}, requireAll = false)
    public static void setSelectedTab(SwitchMultiButton view, int selectedTab, final InverseBindingListener listener) {
        if (view.getSelectedTab() != selectedTab) {
            view.setSelectedTab(selectedTab);

            if (listener != null) {
                view.setOnSwitchListener(new SwitchMultiButton.OnSwitchListener() {
                    @Override
                    public void onSwitch(int position, String tabText) {
                        listener.onChange();
                    }
                });
            }
        }
    }

    @InverseBindingAdapter(attribute = "app:selectedTab", event = "app:selectedTabAttrChanged")
    public static int getSelectedTab(SwitchMultiButton view) {
        return view.getSelectedTab();
    }
}
